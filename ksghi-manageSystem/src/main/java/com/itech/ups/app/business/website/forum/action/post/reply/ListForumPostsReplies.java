package com.itech.ups.app.business.website.forum.action.post.reply;

import com.itech.core.components.pager.PagerInfo;
import com.itech.ups.app.business.website.forum.application.service.ForumService;
import com.itech.ups.app.forum.application.domain.ForumPosts;
import com.itech.ups.app.forum.application.domain.PostsReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyf
 * @date 2014-04-06 论坛贴子回复管理
 */
@Controller
public class ListForumPostsReplies {

    @Autowired
    private ForumService forumService;

    @RequestMapping("/business/website/forum/post/reply/list/{id}")
    public String list(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        PagerInfo pagerInfo = new PagerInfo(request, 10);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("forumPostsId", id);
        ForumPosts forumPosts = forumService.findForumPost(id);
        int totalCount = forumService.findPostsRepliesTotalCount(map);
        pagerInfo.setTotalCount(totalCount);
        List<PostsReply> replyList = forumService.findPagePostsReplies(map, pagerInfo.getStartNum(), pagerInfo.getEndNum());
        request.setAttribute("totalCount", pagerInfo.getTotalCount());
        request.setAttribute("pageSize", pagerInfo.getPageSize());
        request.setAttribute("startNum", pagerInfo.getStartNum());
        request.setAttribute("results", replyList);
        request.setAttribute("count", replyList.size());
        request.setAttribute("forumPosts", forumPosts);
        return "/business/website/forum/post/reply/list";
    }
}
