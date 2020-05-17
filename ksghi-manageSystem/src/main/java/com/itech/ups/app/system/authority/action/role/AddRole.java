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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 版本信息：v1.0 日期：2011-12-19 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class AddRole extends AbstractActionParent {
    @Autowired
    private AuthorityService service;

    @RequestMapping("/system/authority/role/add")
    public String add(HttpServletRequest request, Model model) {
        List<Function> results = service.findAllFunctions();
        TreeNode functionTree = new TreeNode("root", "系统功能树");
        FunctionTreeBuildHelper.buildSubTree(functionTree, results);
        String treeText = FunctionTreeBuildHelper.convertTreeToZtreeString(functionTree, true);
        model.addAttribute("treeText", treeText);
        return "system/authority/role/add";
    }

    @RequestMapping("/system/authority/role/add/save")
    public String save(HttpServletRequest request, Role role, String functionCodes) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        role.setCreatorId(currentManager.getManager().getId());
        role.setCreatorName(currentManager.getManager().getName());
        role.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        role.setEditorId(currentManager.getManager().getId());
        role.setEditorName(currentManager.getManager().getName());
        role.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        role.setDataStatus("valid");
        service.addRole(role, functionCodes);
        saveBusinessLog("系统角色管理", "新增系统角色", role, request);
        return "redirect:/system/authority/role/list";
    }
}
