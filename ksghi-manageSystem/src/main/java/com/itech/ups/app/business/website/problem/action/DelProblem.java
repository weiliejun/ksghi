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

/**
 * @author zhangyf 删除问题
 */

@Controller
public class DelProblem extends AbstractActionParent {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("/business/website/problem/delete/{id}")
    public String delete(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Problem problem = problemService.findProblem(id);
        problem.setDataStatus("invalid");
        problem.setEditorId(currentManager.getManager().getId());
        problem.setEditorName(currentManager.getManager().getName());
        problem.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        problemService.editProblem(problem);
        saveBusinessLog("问题管理", "删除问题信息", problem, request);
        return "redirect:/business/website/problem/list";
    }
}
