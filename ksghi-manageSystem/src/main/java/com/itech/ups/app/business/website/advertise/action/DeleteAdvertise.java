package com.itech.ups.app.business.website.advertise.action;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.advertise.application.domain.Advertise;
import com.itech.ups.app.business.website.advertise.application.service.AdvertiseService;
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
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-5-5
 * @author  zhaoyl
 * ===========================================================================
 *
 */
@Controller
public class DeleteAdvertise extends AbstractActionParent {

    @Autowired
    private AdvertiseService service;

    @RequestMapping("business/website/advertise/copy/{id}")
    public String copy(HttpServletRequest request, @PathVariable("id") String id) {
        CurrentManager curentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Advertise advertise1 = service.findAdvertise(id);
        Advertise advertise2 = service.findAdvertise(id);

        advertise1.setCreatorId(curentManager.getManager().getId());
        advertise2.setCreatorId(curentManager.getManager().getId());

        advertise1.setEditorName(curentManager.getManager().getName());
        advertise2.setEditorName(curentManager.getManager().getName());

        advertise1.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        advertise2.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));

        advertise1.setSequnum(null);
        advertise2.setSequnum(null);
        String code = advertise1.getCode();
        String[] strs = code.split("[-]");
        if (strs[0].trim().equals("index")) {
            advertise1.setCode("mobile-" + strs[1]);
            advertise2.setCode("app-" + strs[1]);
            service.addAdvertise(advertise1);
            service.addAdvertise(advertise2);

        } else if (strs[0].trim().equals("mobile")) {
            advertise1.setCode("index-" + strs[1]);
            advertise2.setCode("app-" + strs[1]);
            service.addAdvertise(advertise1);
            service.addAdvertise(advertise2);

        } else if (strs[0].trim().equals("app")) {
            advertise1.setCode("mobile-" + strs[1]);
            advertise2.setCode("index-" + strs[1]);
            service.addAdvertise(advertise1);
            service.addAdvertise(advertise2);
        } else {
            service.addAdvertise(advertise1);
        }
        saveBusinessLog("网站广告位管理", "复制广告位信息", advertise1, request);
        saveBusinessLog("网站广告位管理", "复制广告位信息", advertise2, request);
        return "redirect:/business/website/advertise/list";

    }

    @RequestMapping("/business/website/advertise/delete/{id}")
    public String delete(HttpServletRequest request, @PathVariable("id") String id) {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        Advertise advertise = service.findAdvertise(id);
        advertise.setEditorId(currentManager.getManager().getId());
        advertise.setEditorName(currentManager.getManager().getName());
        advertise.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        service.deleteAdvertise(advertise);
        saveBusinessLog("网站广告位管理", "删除广告位信息", advertise, request);
        return "redirect:/business/website/advertise/list";
    }
}
