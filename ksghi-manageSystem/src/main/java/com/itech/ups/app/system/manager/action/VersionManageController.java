package com.itech.ups.app.system.manager.action;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.components.filesync.FileSynchronizer;
import com.itech.ups.app.manager.application.domain.VersionManage;
import com.itech.ups.app.system.manager.application.service.VersionManageService;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.util.FileHelper;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Controller
public class VersionManageController extends AbstractActionParent {
    private final Logger logger = Logger.getLogger(VersionManageController.class);
    @Autowired
    private VersionManageService versionManageService;
    @Autowired
    private FileSynchronizer fileSynchronizer;
    @Value("${product.pictureServerURL}")
    private String pictureServerURL;

    @RequestMapping(value = {"/version/add"}, method = RequestMethod.POST, produces = "application/json")
    public String addVersion(HttpServletRequest request, @RequestParam(value = "file", required = true) MultipartFile file, @RequestParam(value = "type", required = true) String type, @RequestParam(value = "version", required = true) String version, @RequestParam(value = "status", required = true) String status, @RequestParam(value = "onlineTime", required = true) String onlineTime, @RequestParam(value = "offlineTime", required = false) String offlineTime, @RequestParam(value = "id", required = false) String id, @RequestParam(value = "remark", required = true) String remark, String forcedUpgrade) {

        try {

            VersionManage versionManage = new VersionManage();
            versionManage.setOnlineTime(onlineTime);
            versionManage.setOfflineTime(offlineTime);
            versionManage.setType(type);
            versionManage.setStatus(status);
            versionManage.setRemark(remark);
            versionManage.setVersion(version);
            versionManage.setForcedUpgrade(forcedUpgrade);
            if (file != null && !file.isEmpty()) {
                String realPath = request.getSession().getServletContext().getRealPath("/");
                String fileName = FileHelper.disposeFileName(file.getOriginalFilename());
                String rootPath = ApplicationConstant.APP_VERSION_PATH + "/" + version;
                File rootFile = new File(realPath + rootPath);
                if (!rootFile.exists()) {
                    FileUtils.forceMkdir(rootFile);
                }
                String filePath = rootPath + "/" + fileName;
                File realFilePath = new File(realPath + filePath);

                file.transferTo(realFilePath);
                fileSynchronizer.syncFile(realFilePath, rootPath, fileName); // 上传到网站端
                versionManage.setPath(filePath);
            }
            if (id != null && !id.equals("")) {
                versionManage.setId(id);
                versionManageService.updateVersionManage(versionManage);
            } else {
                versionManage.setName(type + "_wjk_app_" + version);
                versionManage.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
                versionManage = versionManageService.addVersionManage(versionManage);
            }

        } catch (Exception e) {
            logger.error("upload file error! ", e);
            ;
        }
        return "redirect:/version/query";
    }

    @RequestMapping(value = {"/version/delete"}, method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String delestVersion(@RequestParam("id") String id) {
        try {
            versionManageService.deleteVersionManageById(id);
            return "true";
        } catch (Exception e) {
            logger.error("/version/delete! id:" + id, e);
            return "false";
        }
    }

    @RequestMapping(value = {"/version/modify"}, method = RequestMethod.POST)
    public String modifyVersion(Model model, VersionManage versionManage) {

        versionManageService.updateVersionManage(versionManage);
        return "redirect:/version/query";
    }

    @RequestMapping(value = {"/version/query"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String queryVersionList(Model model, HttpServletRequest request) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return versionManageService.findVersionManage(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) versionManageService.getCount(params);
                }
            });

            model.addAttribute("results", items);
        } else {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    return new ArrayList<Object>();
                }

                public int getTotalRows(Limit limit) {
                    return (int) 0;
                }
            });

            model.addAttribute("results", items);
        }

        // 保存翻页信息,保存查询条件，回显参数
        savePageParams(request, params, model);
        // ////

        return "manage/version/list";
    }

    @RequestMapping(value = {"/version/stop"}, method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String stopVersion(@RequestParam("id") String id) {

        try {
            versionManageService.stopVersion(id);
            return "true";
        } catch (Exception e) {
            logger.error("/version/stop error! id:" + id, e);
            return "false";
        }

    }

    @RequestMapping(value = {"/version/toAdd"}, method = RequestMethod.GET)
    public String toAddVersion() {
        return "manage/version/add";
    }

    @RequestMapping(value = {"/version/toModify"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String toModifyVersion(Model model, @RequestParam("id") String id) {
        VersionManage versionManage = versionManageService.findVersionManageById(id);
        model.addAttribute("version", versionManage);
        model.addAttribute("pictureServerURL", pictureServerURL);
        return "manage/version/modify";
    }
}
