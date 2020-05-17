package com.itech.ups.app.business.website.problem.action;

import com.itech.ups.app.business.website.problem.application.service.ProblemService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyf
 * @date 2014-04-07 检查分类下是否有有效问题
 */
@Controller
public class CheckProblem extends AbstractActionParent {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("/business/website/problem/check/{id}")
    public void check(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable("id") String id) throws Exception {
        // 判断该分类下是否有有效的问题
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("problemCategoryId", id);
        List<Map<String, String>> problemsList = new ArrayList<Map<String, String>>();
        problemsList = problemService.findProblems(map);
        String delFlag = ""; // 0代表不能删除,1代表能删除
        if (problemsList.size() == 0) {
            // 判断是否有子分类,如果有,则不能删除
            Map<String, Object> catMap = new HashMap<String, Object>();
            catMap.put("parentId", id);
            List<Map<String, String>> categoryList = problemService.findProblemCategories(catMap);
            if (categoryList.size() != 0) { // 如果没有子分类,可以删除
                delFlag = "haveSubCategory";
            } else { // 不能删除
                delFlag = "ok";
            }
        } else {
            delFlag = "haveProblem";
        }
        response.getWriter().write(delFlag);
    }
}
