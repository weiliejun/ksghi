package com.itech.ups.app.business.website.forum.action;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.website.forum.application.service.ForumService;
import com.itech.ups.app.forum.application.domain.Forum;
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

@Controller
public class DelForum extends AbstractActionParent {

    @Autowired
    private ForumService forumService;

    @RequestMapping("/business/website/forum/delete/{id}")
    public String delete(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Forum forum = forumService.findForum(id);
        forum.setDataStatus("invalid");
        forum.setEditorId(currentManager.getManager().getId());
        forum.setEditorName(currentManager.getManager().getName());
        forum.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        forumService.editForum(forum);
        saveBusinessLog("论坛版块管理", "删除论坛版块信息", forum, request);
        return "redirect:/business/website/forum/list";
    }
}
