package com.itech.ups.app.system.authority.action.function;

import com.itech.core.components.xtree.TreeNode;
import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.app.system.authority.application.service.AuthorityService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 版本信息：v1.0 日期：2011-12-24 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class FunctionIndex extends AbstractActionParent {
    @Autowired
    private AuthorityService service;

    @RequestMapping("/system/authority/function/index")
    public String index(HttpServletRequest request, Model model) {
        List<Function> results = service.findAllFunctions();
        TreeNode functionTree = new TreeNode("root", "系统功能树");
        FunctionTreeBuildHelper.buildSubTree(functionTree, results);
        String treeText = FunctionTreeBuildHelper.convertTreeToZtreeString(functionTree, true);
        model.addAttribute("treeText", treeText);
        return "system/authority/function/index";
    }
}
