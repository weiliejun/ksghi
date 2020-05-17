package com.itech.ups.app.business.website.problem.action.reply;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.website.problem.application.service.ProblemService;
import com.itech.ups.app.problem.application.domain.ProblemReply;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Controller
public class EditProblemReply extends AbstractActionParent {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("/business/website/problem/reply/edit/{id}")
    public String edit(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        ProblemReply reply = problemService.findProblemReply(id);
        request.setAttribute("reply", reply);
        return "/business/website/problem/reply/edit";
    }

    @RequestMapping("/business/website/problem/reply/edit/save")
    public String save(HttpServletRequest request, ProblemReply reply) throws IOException, Exception {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        reply.setOperatorId(currentManager.getManager().getId());
        reply.setOperatorName(currentManager.getManager().getName());
        reply.setOperateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        reply.setOperateStatus("true"); // 已处理
        problemService.editProblemReply(reply);
        saveBusinessLog("客户留言管理", "处理客户留言信息", reply, request);
        return "redirect:/business/website/problem/reply/list";
    }
}
