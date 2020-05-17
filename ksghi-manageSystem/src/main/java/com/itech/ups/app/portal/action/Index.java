package com.itech.ups.app.portal.action;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.app.system.manager.application.service.ManagerService;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件名：Login.java 版本信息：v1.0 日期：2011-12-24 Copyright Mike
 * Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class Index extends AbstractActionParent {

    @Autowired
    private ManagerService service;

    @RequestMapping(value = {"/index/password/change/save"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> changePassword(HttpServletRequest request, @RequestParam("password") String password, @RequestParam("oldPassword") String oldPassword) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Map<String, String> domain = new HashMap<String, String>();
        Manager manager = service.findManager(currentManager.getManager().getId());
        if (manager.getPassword().equalsIgnoreCase(oldPassword)) {
            manager.setEditorId(currentManager.getManager().getId());
            manager.setEditorName(currentManager.getManager().getName());
            manager.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
            manager.setPassword(password);
            service.editManager(manager);
            domain.put("flag", "true");
        } else {
            domain.put("flag", "false");
            domain.put("message", "您输入的旧密码不正确，请核对！");
        }
        return domain;
    }

    @RequestMapping(value = {"/index/dashboard"}, method = RequestMethod.GET)
    public String dashboard(HttpServletRequest request, Model model) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        return "/portal/dashboard";
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        return "/portal/index";
    }

    @RequestMapping(value = {"/index/password/change"}, method = RequestMethod.GET)
    public String password(HttpServletRequest request, Model model) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        return "/portal/password";
    }
}
