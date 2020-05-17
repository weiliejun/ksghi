package com.itech.ups.app.business.website.problem.action;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.website.problem.application.service.ProblemService;
import com.itech.ups.app.problem.application.domain.Problem;
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
public class AddProblem extends AbstractActionParent {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("/business/website/problem/add")
    public String add(HttpServletRequest request, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pname", "notNull");
        List<Map<String, String>> categoryList = problemService.findProblemCategories(map);
        for (int i = 0; i < categoryList.size(); i++) {
            Map<String, String> category = categoryList.get(i);
            String name = category.get("NAME");
            String pname = category.get("PNAME");
            category.put("NAME", name + "------" + pname);
        }
        request.setAttribute("categoryList", categoryList);
        return "/business/website/problem/add";
    }

    @RequestMapping("/business/website/problem/save")
    public String save(HttpServletRequest request, Problem problem) throws Exception {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        problem.setCreatorId(currentManager.getManager().getId());
        problem.setCreatorName(currentManager.getManager().getName());
        problem.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        problem.setEditorId(currentManager.getManager().getId());
        problem.setEditorName(currentManager.getManager().getName());
        problem.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        problem.setDataStatus("valid");
        problem.setCode(problem.getCode().trim());
        problem = problemService.addProblem(problem);
        saveBusinessLog("问题管理", "新增问题信息", problem, request);
        return "redirect:/business/website/problem/list";
    }

}
