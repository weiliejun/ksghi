package com.itech.ups.app.system.authority.action.role;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.authority.application.domain.Role;
import com.itech.ups.app.system.authority.application.service.AuthorityService;
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
public class DeleteRole extends AbstractActionParent {
    @Autowired
    private AuthorityService service;

    @RequestMapping("/system/authority/role/delete/{id}")
    public String edit(HttpServletRequest request, @PathVariable("id") String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Role role = service.findRole(id);
        role.setEditorId(currentManager.getManager().getId());
        role.setEditorName(currentManager.getManager().getName());
        role.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        role.setDataStatus("invalid");
        service.editRole(role);
        saveBusinessLog("系统角色管理", "删除系统角色", role, request);
        return "redirect:/system/authority/role/list";
    }
}
