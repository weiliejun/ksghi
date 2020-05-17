package com.itech.ups.app.business.website.problem.action.category;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.website.problem.application.service.ProblemService;
import com.itech.ups.app.problem.application.domain.ProblemCategory;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AddProblemCategory extends AbstractActionParent {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("/business/website/problem/category/add")
    public String add(HttpServletRequest request, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("parentId", "0");
        List<Map<String, String>> categoryList = problemService.findProblemCategories(map);
        request.setAttribute("categoryList", categoryList);
        return "/business/website/problem/category/add";
    }

    @RequestMapping("/business/website/problem/category/save")
    public String save(HttpServletRequest request, ProblemCategory category) throws Exception {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        category.setCreatorId(currentManager.getManager().getId());
        category.setCreatorName(currentManager.getManager().getName());
        category.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        category.setEditorId(currentManager.getManager().getId());
        category.setEditorName(currentManager.getManager().getName());
        category.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        category.setDataStatus("valid");
        category = problemService.addProblemCategory(category);
        saveBusinessLog("问答版块管理", "新增问答版块信息", category, request);
        return "redirect:/business/website/problem/category/list";
    }
}
