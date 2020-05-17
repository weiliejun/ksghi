package com.itech.ups.app.business.website.link.action;

import com.itech.ups.app.business.website.link.application.service.LinkService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/*
 * @version 1.0, 2014-10-9
 * @author  jxy
 *
 */
@Controller
public class ListLink extends AbstractActionParent {

    @Autowired
    private LinkService service;

    @RequestMapping("/business/website/link/list")
    public String list(Model model, HttpServletRequest request) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return service.findLinks(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) service.findLinkTotalCount(params);
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

        // 保存翻页信息,保存查询条件，回显参数
        Limit limit = (Limit) request.getAttribute("grid" + TableModelUtils.LIMIT_ATTR);
        params.put("page", String.valueOf(limit.getRowSelect().getPage()));
        params.put("rowStart", String.valueOf(limit.getRowSelect().getRowStart()));
        params.put("rowEnd", String.valueOf(limit.getRowSelect().getRowEnd()));
        // ////

        return "business/website/link/list";
    }
}
