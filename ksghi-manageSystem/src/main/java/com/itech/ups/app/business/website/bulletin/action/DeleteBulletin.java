package com.itech.ups.app.business.website.bulletin.action;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.bulletin.application.domain.Bulletin;
import com.itech.ups.app.business.website.bulletin.application.service.BulletinService;
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
 * @version 1.0, 2014-5-4
 * @author  wcl
 *
 */
@Controller
public class DeleteBulletin extends AbstractActionParent {

    @Autowired
    private BulletinService service;

    @RequestMapping("/business/website/bulletin/delete/{id}")
    public String delete(HttpServletRequest request, @PathVariable("id") String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        Bulletin bulletin = service.findBulletin(id);
        bulletin.setDataStatus("invalid");
        bulletin.setEditorId(currentManager.getManager().getId());
        bulletin.setEditorName(currentManager.getManager().getName());
        bulletin.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));

        service.editBulletin(bulletin);
        saveBusinessLog("网站公告管理", "删除网站公告信息", bulletin, request);

        return "redirect:/business/website/bulletin/list";
    }

}
