package com.itech.ups.app.business.website.link.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ImageHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.website.link.application.service.LinkService;
import com.itech.ups.app.components.filesync.FileSynchronizer;
import com.itech.ups.app.link.application.domain.Link;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Random;

/*
 * @version 1.0, 2014-10-9
 * @author  jxy
 *
 */
@Controller
public class AddLink extends AbstractActionParent {
    @Autowired
    private LinkService service;

    @Autowired
    private FileSynchronizer fileSynce;

    @RequestMapping("/business/website/link/add")
    public String add() {
        return "/business/website/link/add";
    }

    @RequestMapping("/business/website/link/add/save")
    public String save(HttpServletRequest request, Link link, @RequestParam(value = "pictureFile", required = true) MultipartFile pictureFile) throws Exception {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        link.setCreatorId(currentManager.getManager().getId());
        link.setCreatorName(currentManager.getManager().getName());
        link.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        link.setEditorId(currentManager.getManager().getId());
        link.setEditorName(currentManager.getManager().getName());
        link.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));

        link = service.addLink(link);
        saveBusinessLog("网站友情链接管理", "新增友情链接信息", link, request);

        if (pictureFile != null && !pictureFile.isEmpty()) {
            String realPath = request.getSession().getServletContext().getRealPath("/");// 项目真实路径

            String fileName = pictureFile.getOriginalFilename();
            String extension = StringHelper.unqualify(fileName).toLowerCase();

            int type = ImageHelper.IMAGE_UNKNOWN;
            if (extension.toLowerCase().equals("jpg") || extension.equals("jpeg")) {
                type = ImageHelper.IMAGE_JPEG;
            } else if (extension.toLowerCase().equals("png")) {
                type = ImageHelper.IMAGE_PNG;
            }
            if (type != ImageHelper.IMAGE_UNKNOWN) {
                long random = new Random(100000000).nextLong();
                fileName = DateHelper.getCurrentDate().getTime() + "_" + random + "." + extension;

                String rootPath = ApplicationConstant.APP_UPLOAD_LINK_LOGO_FILE_PATH + "/" + link.getId();// 根路径

                File rootFile = new File(realPath + rootPath);
                if (!rootFile.exists()) {
                    FileUtils.forceMkdir(rootFile);
                }
                String filePath = rootPath + "/" + fileName;
                File file = new File(realPath + filePath);

                pictureFile.transferTo(file);
                fileSynce.syncFile(file, rootPath, fileName);// 上传到网站
                link.setLogo(filePath);
                service.editLink(link);
                saveBusinessLog("网站友情链接管理", "新增友情链接LOGO", link, request);
            }

        }
        return "redirect:/business/website/link/list";
    }

}
