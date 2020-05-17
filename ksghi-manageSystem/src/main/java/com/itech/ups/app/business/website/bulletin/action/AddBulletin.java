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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/*
 * @version 1.0, 2014-5-4
 * @author  wcl
 *
 */
@Controller
public class AddBulletin extends AbstractActionParent {

    @Autowired
    private BulletinService service;

    @RequestMapping("/business/website/bulletin/add")
    public String add(HttpServletRequest request, Model model) {
        return "business/website/bulletin/add";
    }

    @RequestMapping("/business/website/bulletin/add/save")
    public String save(HttpServletRequest request, Bulletin bulletin) throws Exception {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        if (bulletin.getPublishStatus().equals("issue")) {
            bulletin.setPublishTime(DateHelper.getYMDHMSFormatDate(new Date()));
            bulletin.setPublisherId(currentManager.getManager().getId());
            bulletin.setPublisherName(currentManager.getManager().getName());
        }

        bulletin.setViews(0L);
        bulletin.setCreatorId(currentManager.getManager().getId());
        bulletin.setCreatorName(currentManager.getManager().getName());
        bulletin.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        bulletin.setEditorId(currentManager.getManager().getId());
        bulletin.setEditorName(currentManager.getManager().getName());
        bulletin.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        bulletin.setTopMark("no");

        bulletin = service.addBulletin(bulletin);
        saveBusinessLog("网站公告", "新增网站公告信息", bulletin, request);

        return "redirect:/business/website/bulletin/list";
    }
}
