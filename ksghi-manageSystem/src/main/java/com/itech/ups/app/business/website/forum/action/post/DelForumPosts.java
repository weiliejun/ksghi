package com.itech.ups.app.business.website.forum.action.post;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.website.forum.application.service.ForumService;
import com.itech.ups.app.forum.application.domain.Forum;
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
import java.util.Date;

/**
 * @author zhangyf
 * @date 2014-04-07 删除论坛广告位
 */
@Controller
public class DelForumPosts extends AbstractActionParent {

    @Autowired
    private ForumService forumService;

    @RequestMapping("/business/website/forum/post/delete/{id}")
    public String delete(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        ForumPosts forumPosts = forumService.findForumPost(id);
        forumPosts.setDataStatus("invalid");
        forumPosts.setEditorId(currentManager.getManager().getId());
        forumPosts.setEditorName(currentManager.getManager().getName());
        forumPosts.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));

        Forum forum = forumService.findForum(forumPosts.getForumId());
        Forum parentForum = null;
        if (forum != null) {
            forum.setPostsNum(forum.getPostsNum() - 1);
            parentForum = forumService.findForum(forum.getParentId());
            if (parentForum != null) {
                parentForum.setPostsNum(parentForum.getPostsNum() - 1);
                forumService.editForum(parentForum);
            }
            forumService.editForum(forum);
        }
        forumService.editForumPosts(forumPosts);
        saveBusinessLog("论坛贴子管理", "删除论坛贴子信息", forumPosts, request);
        return "redirect:/business/website/forum/post/list";
    }
}
