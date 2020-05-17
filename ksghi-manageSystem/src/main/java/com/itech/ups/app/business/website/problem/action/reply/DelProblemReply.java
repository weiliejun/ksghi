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
import java.util.Date;

/**
 * @author zhangyf 删除用户反馈
 */

@Controller
public class DelProblemReply extends AbstractActionParent {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("/business/website/problem/reply/delete/{id}")
    public String delete(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        ProblemReply problemReply = problemService.findProblemReply(id);
        problemReply.setDataStatus("invalid");
        problemReply.setOperatorId(currentManager.getManager().getId());
        problemReply.setOperatorName(currentManager.getManager().getName());
        problemReply.setOperateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        problemService.editProblemReply(problemReply);
        saveBusinessLog("客户留言管理", "删除客户留言", problemReply, request);
        return "redirect:/business/website/problem/reply/list";
    }
}
