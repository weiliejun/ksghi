package com.itech.ups.app.business.website.bulletin.action;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.bulletin.application.domain.Bulletin;
import com.itech.ups.app.business.website.bulletin.application.service.BulletinService;
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

/*
 * @version 1.0, 2014-5-4
 * @author  wcl
 *
 */
@Controller
public class EditBulletin extends AbstractActionParent {

    @Autowired
    private BulletinService service;

    @RequestMapping("/business/website/bulletin/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {

        Bulletin bulletin = service.findBulletin(id);
        model.addAttribute("bulletin", bulletin);

        return "business/website/bulletin/edit";
    }

    @RequestMapping("/business/website/bulletin/edit/save")
    public String save(HttpServletRequest request, Bulletin bulletin) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        Bulletin bulletinTmp = service.findBulletin(bulletin.getId());

        if (bulletin.getPublishStatus().equals("issue") && !bulletinTmp.getPublishStatus().equals(bulletin.getPublishStatus())) {
            bulletin.setPublishTime(DateHelper.getYMDHMSFormatDate(new Date()));
            bulletin.setPublisherId(currentManager.getManager().getId());
            bulletin.setPublisherName(currentManager.getManager().getName());
        }
        bulletin.setTopMark(bulletinTmp.getTopMark());
        bulletin.setEditorId(currentManager.getManager().getId());
        bulletin.setEditorName(currentManager.getManager().getName());
        bulletin.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        service.editBulletin(bulletin);
        saveBusinessLog("网站公告管理", "修改网站公告信息", bulletin, request);

        return "redirect:/business/website/bulletin/list";
    }

}
