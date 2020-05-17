package com.itech.ups.app.business.website.problem.action;

import com.itech.ups.app.business.website.problem.application.service.ProblemService;
import com.itech.ups.app.problem.application.domain.ProblemCategory;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author zhangyf
 * @date 2014-04-19 问题管理
 */
@Controller
public class ListProblems extends AbstractActionParent {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("/business/website/problem/list")
    public String list(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return problemService.findPageProblems(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) problemService.findProblemsTotalCount(params);
                }
            });

            model.addAttribute("results", items);
        } else {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    return new ArrayList<Object>();
                }

                public int getTotalRows(Limit limit) {
                    return (int) 0;
                }
            });

            model.addAttribute("results", items);
        }

        List<ProblemCategory> categoryList = new ArrayList<ProblemCategory>();
        categoryList = problemService.findProblemCategoriesSelect(new HashMap());

        // 保存翻页信息,保存查询条件，回显参数
        savePageParams(request, params, model);
        // ////
        model.addAttribute("categoryList", categoryList);
        return "/business/website/problem/list";
    }

}
