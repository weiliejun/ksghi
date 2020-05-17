package com.itech.ups.app.system.manager.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.MD5Helper;
import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.app.system.manager.application.service.ManagerService;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 版本信息：v1.0 日期：2011-12-19 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class AddManager extends AbstractActionParent {
    @Autowired
    private ManagerService service;

    @RequestMapping("/system/manager/add")
    public String add(HttpServletRequest request, Model model) {

        return "system/manager/add";
    }

    @RequestMapping("/system/manager/add/save")
    public String save(HttpServletRequest request, Manager manager) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        manager.setCreatorId(currentManager.getManager().getId());
        manager.setCreatorName(currentManager.getManager().getName());
        manager.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        manager.setEditorId(currentManager.getManager().getId());
        manager.setEditorName(currentManager.getManager().getName());
        manager.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        manager.setDataStatus("valid");// invalid-删除 valid有效
        manager.setPassword((new MD5Helper()).getMD5ofStr(ApplicationConstant.APP_MANAGER_INIT_PASSWORD));
        service.addManager(manager);
        saveBusinessLog("管理员管理", "新增管理员", manager, request);
        return "redirect:/system/manager/list";
    }
}
