package com.itech.ups.app.business.website.forum.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.website.forum.application.service.ForumService;
import com.itech.ups.app.components.filesync.FileSynchronizer;
import com.itech.ups.app.forum.application.domain.Forum;
import com.itech.ups.app.forum.application.domain.ForumPosts;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author zhangyf
 * @date 2014-04-07 修改论坛版块
 */
@Controller
public class EditForum extends AbstractActionParent {

    @Autowired
    private ForumService forumService;

    @Autowired
    private FileSynchronizer fileSynce;

    @RequestMapping("/business/website/forum/edit/{id}")
    public String edit(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("parentId", "0");
        List<Forum> forumList = null;
        Forum forum = forumService.findForum(id);
        request.setAttribute("forum", forum);
        String flagShow = "";
        if (forum != null) {
            if (forum.getParentId().equals("0")) {
                Map<String, Object> subForumMap = new HashMap<String, Object>();
                subForumMap.put("parentId", id);
                List<Forum> subForum = forumService.findForums(subForumMap);
                if (subForum.size() > 0) {
                    forumList = null;
                } else {
                    forumList = forumService.findForums(map);
                }
                flagShow = "true";
            } else {
                Map<String, Object> postMap = new HashMap<String, Object>();
                postMap.put("forumId", id);
                List<ForumPosts> posts = forumService.findForumPosts(postMap);
                if (posts.size() > 0) {
                    flagShow = "false";
                    forumList = forumService.findForums(map);
                } else {
                    flagShow = "true";
                    forumList = forumService.findForums(map);
                }
            }
        }
        request.setAttribute("flagShow", flagShow);
        request.setAttribute("forumList", forumList);
        return "/business/website/forum/edit";
    }

    @RequestMapping("/business/website/forum/edit/save")
    public String save(HttpServletRequest request, Forum forum, @RequestParam(value = "logoFile", required = true) MultipartFile logoFile) throws IOException, Exception {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
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
        }
        forum.setCode(forum.getCode().trim());
        forum.setEditorId(currentManager.getManager().getId());
        forum.setEditorName(currentManager.getManager().getName());
        forum.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        forumService.editForum(forum);
        saveBusinessLog("论坛版块管理", "修改论坛版块信息", forum, request);
        return "redirect:/business/website/forum/list";
    }
}
