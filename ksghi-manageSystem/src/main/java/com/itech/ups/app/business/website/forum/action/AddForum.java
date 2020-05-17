package com.itech.ups.app.business.website.forum.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.website.forum.application.service.ForumService;
import com.itech.ups.app.components.filesync.FileSynchronizer;
import com.itech.ups.app.forum.application.domain.Forum;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Controller
public class AddForum extends AbstractActionParent {

    @Autowired
    private ForumService forumService;

    @Autowired
    private FileSynchronizer fileSynce;

    @RequestMapping("/business/website/forum/add")
    public String add(HttpServletRequest request, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("parentId", "0");
        List<Forum> forumList = forumService.findForums(map);
        request.setAttribute("forumList", forumList);
        return "/business/website/forum/add";
    }

    @RequestMapping("/business/website/forum/save")
    public String save(HttpServletRequest request, Forum forum, @RequestParam(value = "logoFile", required = true) MultipartFile logoFile) throws Exception {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        forum.setCreatorId(currentManager.getManager().getId());
        forum.setCreatorName(currentManager.getManager().getName());
        forum.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        forum.setEditorId(currentManager.getManager().getId());
        forum.setEditorName(currentManager.getManager().getName());
        forum.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        forum.setDataStatus("valid");
        forum.setPostsNum(0);
        forum.setPostsReplyNum(0);
        forum.setCode(forum.getCode().trim());
        forum = forumService.saveForum(forum);
        if (logoFile != null && !logoFile.isEmpty()) {
            String realPath = request.getSession().getServletContext().getRealPath("/");
            String pictureName = logoFile.getOriginalFilename();
            String extension = StringHelper.unqualify(pictureName).toLowerCase();
            long random = new Random(100000000).nextLong();
            pictureName = DateHelper.getCurrentDate().getTime() + "_" + random + "." + extension;

            String rootPath = ApplicationConstant.APP_UPLOAD_FORUM_LOGO_FILE_PATH + "/" + forum.getId();
            File rootFile = new File(realPath + rootPath);
            if (!rootFile.exists()) {
                FileUtils.forceMkdir(rootFile);
            }
            String filePath = rootPath + "/" + pictureName;
            File file = new File(realPath + filePath);

            logoFile.transferTo(file);
            fileSynce.syncFile(file, rootPath, pictureName); // 上传到网站端
            forum.setLogo(filePath);
            forumService.editForum(forum);
        }
        saveBusinessLog("论坛版块管理", "新增论坛版块信息", forum, request);
        return "redirect:/business/website/forum/list";
    }
}
