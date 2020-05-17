package com.itech.ups.app.business.website.forum.action;

import com.itech.ups.app.business.website.forum.application.service.ForumService;
import com.itech.ups.app.forum.application.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CheckForumCode {

    @Autowired
    private ForumService forumService;

    @RequestMapping(value = {"/business/website/forum/checkcode"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, String> checkForumCode(HttpServletRequest request, HttpServletResponse response, @RequestParam("code") String code) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        String flag = "";
        Map<String, String> result = new HashMap<String, String>();
        List<Forum> forum = forumService.findForums(map);
        if (forum.size() > 0) {
            flag = "true";
        } else {
            flag = "false";
        }
        result.put("flag", flag);
        return result;
    }
}
