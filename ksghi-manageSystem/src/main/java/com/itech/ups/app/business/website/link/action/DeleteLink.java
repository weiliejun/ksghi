package com.itech.ups.app.business.website.link.action;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.website.link.application.service.LinkService;
import com.itech.ups.app.link.application.domain.Link;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/*
 * @version 1.0, 2014-10-10
 * @author  jxy
 *
 */
@Controller
public class DeleteLink extends AbstractActionParent {

    @Autowired
    private LinkService service;

    @RequestMapping("/business/website/link/delete/{id}")
    public String delete(HttpServletRequest request, @PathVariable("id") String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        Link link = service.findLink(id);
        link.setEditorId(currentManager.getManager().getId());
        link.setEditorName(currentManager.getManager().getName());
        link.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));

        service.deleteLink(link);
        saveBusinessLog("网站友情链接管理", "删除友情链接信息", link, request);
        return "redirect:/business/website/link/list";
    }
}
