package com.itech.ups.app.business.website.problem.action;

import com.itech.ups.app.business.website.problem.application.service.ProblemService;
import com.itech.ups.app.problem.application.domain.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CheckProblemCode {
    @Autowired
    private ProblemService problemService;

    @RequestMapping(value = {"/business/website/problem/checkcode"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, String> checkCode(HttpServletRequest request, HttpServletResponse response, @RequestParam("code") String code) {

        Problem problem = null;
        problem = problemService.findProblemByCode(code);
        Map<String, String> result = new HashMap<String, String>();
        if (problem != null) {
            result.put("flag", "true");
            result.put("exist", "该编码已存在");
        } else {
            result.put("flag", "false");
        }
        return result;
    }

}
