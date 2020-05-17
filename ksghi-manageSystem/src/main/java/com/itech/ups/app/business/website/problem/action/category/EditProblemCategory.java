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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyf
 * @date 2014-04-07 修改问答分类
 */
@Controller
public class EditProblemCategory extends AbstractActionParent {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("/business/website/problem/category/edit/{id}")
    public String edit(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        ProblemCategory problemCategory = problemService.findProblemCategory(id);
        request.setAttribute("problemCategory", problemCategory);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("parentId", "0");
        List<Map<String, String>> categoryList = problemService.findProblemCategories(map);
        request.setAttribute("categoryList", categoryList);
        return "/business/website/problem/category/edit";
    }

    @RequestMapping(value = {"/business/website/problem/category/edit/save"}, method = RequestMethod.POST)
    public void save(HttpServletRequest request, HttpServletResponse response, Model model, String categoryId, String name, String parentId, int sequnum, String description) throws IOException, Exception {
        ProblemCategory problemCategory = problemService.findProblemCategory(categoryId);
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("problemCategoryId", categoryId);
        List<Map<String, String>> problems = problemService.findProblems(map);
        String flag = "";
        if (!problemCategory.getParentId().equals(parentId)) {
            if (problems.size() > 0) {
                if (parentId.equals("0")) {
                    flag = "haveProblem";
                } else {
                    flag = "success";
                }
            } else {
                Map<String, Object> mapCategory = new HashMap<String, Object>();
                mapCategory.put("parentId", categoryId);
                List<Map<String, String>> subCategories = problemService.findProblemCategories(mapCategory);
                if (subCategories.size() > 0) {
                    flag = "haveSubCategories";
                } else {
                    flag = "success";
                }
            }
        } else {
            flag = "success";
        }
        if (flag.equals("success")) {
            problemCategory.setName(name);
            problemCategory.setParentId(parentId);
            problemCategory.setSequnum(sequnum);
            problemCategory.setDescription(description);
            problemCategory.setEditorId(currentManager.getManager().getId());
            problemCategory.setEditorName(currentManager.getManager().getName());
            problemCategory.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
            problemService.editProblemCategory(problemCategory);
            saveBusinessLog("问题分类管理", "修改问题分类信息", problemCategory, request);
        }
        response.getWriter().print(flag);
    }
}
