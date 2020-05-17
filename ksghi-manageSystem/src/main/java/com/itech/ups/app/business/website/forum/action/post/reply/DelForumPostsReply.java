package com.itech.ups.app.business.website.forum.action.post.reply;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.website.forum.application.service.ForumService;
import com.itech.ups.app.forum.application.domain.Forum;
import com.itech.ups.app.forum.application.domain.ForumPosts;
import com.itech.ups.app.forum.application.domain.PostsReply;
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
 * @date 2014-04-07 删除论坛贴子回复
 */
@Controller
public class DelForumPostsReply extends AbstractActionParent {

    @Autowired
    private ForumService forumService;

    @RequestMapping("/business/website/forum/post/reply/delete/{id},{forumPostsId}")
    public String delete(HttpServletRequest request, Model model, @PathVariable("id") String id, @PathVariable("forumPostsId") String forumPostsId) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        PostsReply postsReply = forumService.findPostsReply(id);
        postsReply.setDataStatus("invalid");
        postsReply.setEditorId(currentManager.getManager().getId());
        postsReply.setEditorName(currentManager.getManager().getName());
        postsReply.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        forumService.editPostsReply(postsReply);
        // 将贴子回复数减1
        ForumPosts forumPosts = forumService.findForumPost(forumPostsId);
        String forumId = forumPosts.getForumId();
        int replyNum = forumPosts.getReplyNum();
        forumPosts.setReplyNum(replyNum - 1); // 将回复数减1
        forumService.editForumPosts(forumPosts);
        // 将版块回复数减1
        Forum forum = forumService.findForum(forumId);
        Forum parentForum = null;
        if (forum != null) {
            forum.setPostsReplyNum(forum.getPostsReplyNum() - 1);
            parentForum = forumService.findForum(forum.getParentId());
            if (parentForum != null) {
                parentForum.setPostsReplyNum(parentForum.getPostsReplyNum() - 1);
                forumService.editForum(parentForum);
            }
            forumService.editForum(forum);

        }
        saveBusinessLog("论坛贴子回复管理", "删除论坛贴子回复信息", postsReply, request);
        return "redirect:/business/website/forum/post/reply/list/" + forumPostsId;
    }
}
