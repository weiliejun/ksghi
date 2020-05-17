package com.itech.ups.app.system.authority.action.role;

import com.itech.core.components.xtree.TreeNode;
import com.itech.core.util.DateHelper;
import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.app.authority.application.domain.Role;
import com.itech.ups.app.system.authority.action.function.FunctionTreeBuildHelper;
import com.itech.ups.app.system.authority.application.service.AuthorityService;
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
import java.util.List;

/**
 * 版本信息：v1.0 日期：2011-12-19 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class EditRole extends AbstractActionParent {
    @Autowired
    private AuthorityService service;

    private void copyEditPropertiesToExitRole(Role role, Role exitRole) {

        exitRole.setName(role.getName());
        exitRole.setStatus(role.getStatus());
        exitRole.setDescription(role.getDescription());
    }

    @RequestMapping("/system/authority/role/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model, HttpServletRequest request) {
        Role role = service.findRole(id);
        model.addAttribute(role);

        List<Function> results = service.findAllFunctions();
        List<Function> roleFunctions = service.findRoleFunctions(role);
        TreeNode functionTree = new TreeNode("root", "系统功能树");
        FunctionTreeBuildHelper.buildSubTree(functionTree, results);
        String treeText = FunctionTreeBuildHelper.convertTreeToCheckZtreeString(functionTree, true, roleFunctions);
        model.addAttribute("treeText", treeText);

        return "system/authority/role/edit";
    }

    @RequestMapping("/system/authority/role/edit/save")
    public String save(HttpServletRequest request, Role role, String functionCodes) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Role exitRole = service.findRole(role.getId());
        copyEditPropertiesToExitRole(role, exitRole);
        exitRole.setEditorId(currentManager.getManager().getId());
        exitRole.setEditorName(currentManager.getManager().getName());
        exitRole.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        service.editRole(exitRole, functionCodes);
        saveBusinessLog("系统角色管理", "修改系统角色", role, request);
        return "redirect:/system/authority/role/list";
    }
}
