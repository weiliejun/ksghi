package com.itech.ups.app.business.website.forum.action.post.reply;

import com.itech.ups.app.business.website.forum.application.service.ForumService;
import com.itech.ups.app.forum.application.domain.PostsReply;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyf
 * @date 2014-04-07 检查贴子下是否有有效回复
 */
@Controller
public class CheckForumPostsReplies extends AbstractActionParent {

    @Autowired
    private ForumService forumService;

    @RequestMapping("/business/website/forum/post/reply/check/{id}")
    public void check(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable("id") String id) throws Exception {
        // 判断该贴子下是否有有效的回复
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("forumPostsId", id);
        map.put("status", "valid");
        List<PostsReply> repliesList = forumService.findPostsReplies(map);
        String count = String.valueOf(repliesList.size());
        response.getWriter().write(count);
    }
}
