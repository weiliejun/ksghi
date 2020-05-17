package com.itech.ups.app.business.website.forum.action.post;

import com.itech.ups.app.business.website.forum.application.service.ForumService;
import com.itech.ups.app.forum.application.domain.Forum;
import com.itech.ups.app.forum.application.domain.ForumPosts;
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
 * @date 2014-04-07 检查版块下是否有有效贴子
 */
@Controller
public class CheckForumPosts extends AbstractActionParent {

    @Autowired
    private ForumService forumService;

    @RequestMapping("/business/website/forum/post/check/{id}")
    public void check(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable("id") String id) throws Exception {
        // 判断该版块下是否有有效的贴子
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("forumId", id);
        map.put("status", "valid");
        String flag = "";
        List<ForumPosts> forumPostsList = forumService.findForumPosts(map);
        if (forumPostsList.size() == 0) {
            // 判断改板块下是否有子版块，如果有则不能删除
            Map<String, Object> forumMap = new HashMap<String, Object>();
            forumMap.put("parentId", id);
            List<Forum> forumList = forumService.findForums(forumMap);
            if (forumList.size() > 0) {
                flag = "haveChildForum";// 当flag ="haveChildForum"时，该板块下有子版块
            } else {
                flag = "ok";
            }
        } else {
            flag = "havePosts";// flag ="havePosts"，该版块下有帖子
        }
        response.getWriter().write(flag);
    }
}
