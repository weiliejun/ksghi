package com.itech.ups.app.business.website.forum.action.post;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.website.forum.application.service.ForumService;
import com.itech.ups.app.forum.application.domain.ForumPosts;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @author zhangyf
 * @date 2014-04-11 编辑论坛贴子
 */
@Controller
public class EditForumPosts extends AbstractActionParent {

    @Autowired
    private ForumService forumService;

    @RequestMapping("/business/website/forum/post/edit/{id}")
    public String edit(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        ForumPosts forumPosts = forumService.findForumPost(id);
        request.setAttribute("forumPosts", forumPosts);
        return "/business/website/forum/post/edit";
    }

    @RequestMapping("/business/website/forum/post/edit/save")
    public String save(HttpServletRequest request, ForumPosts forumPosts) throws IOException, Exception {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        forumPosts.setEditorId(currentManager.getManager().getId());
        forumPosts.setEditorName(currentManager.getManager().getName());
        forumPosts.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        forumService.editForumPosts(forumPosts);
        saveBusinessLog("论坛贴子管理", "修改论坛贴子信息", forumPosts, request);
        return "redirect:/business/website/forum/post/list";
    }
}
