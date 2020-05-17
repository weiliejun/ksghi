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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EditProblem extends AbstractActionParent {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("/business/website/problem/edit/{id}")
    public String edit(HttpServletRequest request, Model model, @PathVariable("id") String id) {
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
        Problem problem = problemService.findProblem(id);
        request.setAttribute("problem", problem);
        return "/business/website/problem/edit";
    }

    @RequestMapping("/business/website/problem/edit/save")
    public String save(HttpServletRequest request, Problem problem) throws Exception {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        problem.setEditorId(currentManager.getManager().getId());
        problem.setEditorName(currentManager.getManager().getName());
        problem.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        problem.setCode(problem.getCode().trim());
        problemService.editProblem(problem);
        saveBusinessLog("问题管理", "修改问题信息", problem, request);
        return "redirect:/business/website/problem/list";
    }
}
