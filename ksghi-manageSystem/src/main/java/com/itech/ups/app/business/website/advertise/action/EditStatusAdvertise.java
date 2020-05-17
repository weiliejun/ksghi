package com.itech.ups.app.business.website.advertise.action;

import com.itech.ups.app.advertise.application.domain.Advertise;
import com.itech.ups.app.business.website.advertise.application.service.AdvertiseService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*
 * @version 1.0, 2014-9-30
 * @author jxy
 *
 */
//修改使用状态
@Controller
public class EditStatusAdvertise extends AbstractActionParent {

    @Autowired
    private AdvertiseService service;

    // 启用
    @RequestMapping("/business/website/advertise/enable/{id}")
    public String enableStatus(HttpServletRequest request, @PathVariable("id") String id) {

        Advertise advertise = service.findAdvertise(id);
        advertise.setStatus("enable");
        service.editAdvertise(advertise);
        saveBusinessLog("网站广告位管理", "启用广告位信息", advertise, request);

        return "redirect:/business/website/advertise/list";
    }

    // 停用
    @RequestMapping("/business/website/advertise/unable/{id}")
    public String unableStatus(HttpServletRequest request, @PathVariable("id") String id) {

        Advertise advertise = service.findAdvertise(id);
        advertise.setStatus("unable");
        service.editAdvertise(advertise);
        saveBusinessLog("网站广告位管理", "停用广告位信息", advertise, request);

        return "redirect:/business/website/advertise/list";
    }
}
