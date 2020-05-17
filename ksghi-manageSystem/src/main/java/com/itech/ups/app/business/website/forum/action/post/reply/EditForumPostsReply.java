package com.itech.ups.app.business.website.forum.action.post.reply;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.website.forum.application.service.ForumService;
import com.itech.ups.app.forum.application.domain.PostsReply;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author zhangyf
 * @date 2014-04-11 编辑论坛贴子回复
 */
@Controller
public class EditForumPostsReply extends AbstractActionParent {

    @Autowired
    private ForumService forumService;

    @RequestMapping("/business/website/forum/post/reply/edit/save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
        String id = request.getParameter("replyId");
        String forumPostsId = request.getParameter("replyPostId");
        String content = request.getParameter("content");
        String status = request.getParameter("status");
        PostsReply postsReply = new PostsReply();
        postsReply.setId(id);
        postsReply.setForumPostsId(forumPostsId);
        postsReply.setContent(content);
        postsReply.setStatus(status);
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        postsReply.setEditorId(currentManager.getManager().getId());
        postsReply.setEditorName(currentManager.getManager().getName());
        postsReply.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        try {
            forumService.editPostsReply(postsReply);
            saveBusinessLog("论坛贴子回复管理", "修改论坛贴子回复信息", postsReply, request);
            response.getWriter().write("success");
        } catch (Exception e) {
            response.getWriter().write("failure");
        }
    }
}
