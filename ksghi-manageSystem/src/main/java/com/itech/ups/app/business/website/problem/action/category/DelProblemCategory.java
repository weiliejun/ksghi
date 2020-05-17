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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author zhangyf 删除问题分类
 */

@Controller
public class DelProblemCategory extends AbstractActionParent {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("/business/website/problem/category/delete/{id}")
    public String delete(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        ProblemCategory problemCategory = problemService.findProblemCategory(id);
        problemCategory.setDataStatus("invalid");
        problemCategory.setEditorId(currentManager.getManager().getId());
        problemCategory.setEditorName(currentManager.getManager().getName());
        problemCategory.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        problemService.editProblemCategory(problemCategory);
        saveBusinessLog("问题分类管理", "删除问题分类信息", problemCategory, request);
        return "redirect:/business/website/problem/category/list";
    }
}
