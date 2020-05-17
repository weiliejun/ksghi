package com.itech.ups.app.system.manager.action;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.authority.application.domain.Role;
import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.app.system.authority.application.service.AuthorityService;
import com.itech.ups.app.system.manager.application.service.ManagerService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 版本信息：v1.0 日期：2011-12-19 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class SetRoles extends AbstractActionParent {
    @Autowired
    private ManagerService service;

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/system/manager/setroles/{id}")
    public String edit(@PathVariable("id") String id, Model model, HttpServletRequest request) {
        Manager manager = service.findManager(id);
        List<Role> managerRoles = service.findManagerRoles(id);
        List<Role> allRoles = authorityService.findAllRoles();
        if (allRoles != null && allRoles.size() > 0 && managerRoles != null && managerRoles.size() > 0) {
            for (int i = 0; i < allRoles.size(); i++) {
                Role arole = (Role) allRoles.get(i);
                for (int j = 0; j < managerRoles.size(); j++) {
                    Role urole = (Role) managerRoles.get(j);
                    if (arole.getId().equals(urole.getId())) {
                        allRoles.set(i, null);
                        break;
                    }
                }
            }
        }
        model.addAttribute(manager);
        model.addAttribute("managerRoles", managerRoles);
        model.addAttribute("allRoles", allRoles);
        return "system/manager/setRoles";
    }

    @RequestMapping("/system/manager/setroles/save")
    public String save(HttpServletRequest request, String[] roles, String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("managerId", id);
        params.put("roles", roles);
        params.put("creatorId", currentManager.getManager().getId());
        params.put("creatorName", currentManager.getManager().getName());
        params.put("createTime", DateHelper.getYMDHMSFormatDate(new Date()));
        service.saveManagerRoles(params);
        saveBusinessLog("管理员管理", "设置管理员权限", params, request);
        return "redirect:/system/manager/list";
    }
}
