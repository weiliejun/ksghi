package com.itech.ups.app.business.website.bulletin.action;

import com.itech.ups.app.bulletin.application.domain.Bulletin;
import com.itech.ups.app.business.website.bulletin.application.service.BulletinService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*
 * @version 1.0, 2014-9-26
 * @author jxy
 */
//置顶一个公告
@Controller
public class TopBulletin extends AbstractActionParent {

    @Autowired
    private BulletinService service;

    @RequestMapping("/business/website/bulletin/cancelTop/{id}")
    public String cancelTop(@PathVariable("id") String id, HttpServletRequest request) {

        Bulletin bulletin = service.findBulletin(id);
        bulletin.setTopMark("no");
        service.editBulletin(bulletin);
        saveBusinessLog("网站公告管理", "取消置顶网站公告信息", bulletin, request);

        return "redirect:/business/website/bulletin/list";
    }

    @RequestMapping("/business/website/bulletin/top/{id}")
    public String top(@PathVariable("id") String id, HttpServletRequest request) {

        Bulletin bulletin = service.findBulletin(id);
        bulletin.setTopMark("yes");
        service.editBulletin(bulletin);
        saveBusinessLog("网站公告管理", "置顶网站公告信息", bulletin, request);

        return "redirect:/business/website/bulletin/list";
    }
}
