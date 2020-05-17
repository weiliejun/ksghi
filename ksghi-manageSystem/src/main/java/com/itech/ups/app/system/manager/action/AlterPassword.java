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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 版本信息：v1.0 日期：2011-12-19 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class AlterPassword extends AbstractActionParent {
    @Autowired
    private ManagerService service;

    @RequestMapping("/system/manager/alterpassword/{id}")
    public String edit(HttpServletRequest request, @PathVariable("id") String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Manager manager = service.findManager(id);
        manager.setEditorId(currentManager.getManager().getId());
        manager.setEditorName(currentManager.getManager().getName());
        manager.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        manager.setPassword((new MD5Helper()).getMD5ofStr(ApplicationConstant.APP_MANAGER_INIT_PASSWORD));
        service.editManager(manager);
        saveBusinessLog("管理员管理", "重置管理员密码", manager, request);
        return "redirect:/system/manager/list";
    }
}
