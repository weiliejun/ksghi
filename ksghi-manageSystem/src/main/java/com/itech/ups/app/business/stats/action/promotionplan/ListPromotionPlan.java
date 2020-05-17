package com.itech.ups.app.business.stats.action.promotionplan;

import com.itech.core.util.CodeHelper;
import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.ups.app.business.stats.application.service.StatsService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author jxy 2014-12-4
 */

@Controller
public class ListPromotionPlan extends AbstractActionParent {
    private String[] pTitle = {"用户姓名:USERNAME:15:center", "手机号:USERMOBILE:15:center", "推荐人类别:LABELNAME:15:center", "推荐奖励金额:RECOMMENDREPAYAMOUNT:30:center", "自投奖励金额:INTERIORINVESTAMOUNT:30:center", "被推荐奖励金额:RECOMMENDEDREPAYAMOUNT:30:center", "应付金额合计:SUMREPAY:20:center", "已付金额:SUMREPAYED:20:center"};
    @Autowired
    private StatsService statsService;

    @RequestMapping(value = {"/business/stats/promotionplan/list"})
    public String list(HttpServletRequest request, Model model, String labelName, String userName, String mobile, String status) {

        final Map<String, Object> params = selectParams(request);

        Map totalMap = statsService.findPromotionPlanTotalMap();
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return statsService.findPromotionPlans(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) statsService.findPromotionPlanTotalCount(params);
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
        savePageParams(request, params, model);
        // ////
        request.setAttribute("totalMap", totalMap);
        return "/business/stats/promotionplan/promotionplanlist";
    }

    @RequestMapping(value = {"/business/stats/promotionplan/exportExcel"})
    public String promotionPlanExportExcel(HttpServletRequest request, String labelName, String userName, String mobile, String status, HttpServletResponse response) {

        final Map<String, Object> params = selectParams(request);

        List<Map<String, Object>> resultTemp = (List<Map<String, Object>>) statsService.findPromotionPlans(params, 0, (int) statsService.findPromotionPlanTotalCount(params));
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> map : resultTemp) {
            Map<String, Object> temp = new HashMap<String, Object>();

            temp.put("USERNAME", map.get("USERNAME") == null ? "" : map.get("USERNAME"));
            String userMobile = map.get("USERMOBILE") == null ? "" : map.get("USERMOBILE").toString();
            temp.put("USERMOBILE", userMobile.substring(0, 3) + "****" + userMobile.substring(userMobile.length() - 4, userMobile.length()));
            temp.put("LABELNAME", CodeHelper.getValueByCode("user.userLabel", map.get("LABELNAME").toString()));
            temp.put("RECOMMENDREPAYAMOUNT", map.get("RECOMMENDREPAYAMOUNT") == null ? "" : map.get("RECOMMENDREPAYAMOUNT"));
            temp.put("INTERIORINVESTAMOUNT", map.get("INTERIORINVESTAMOUNT") == null ? "" : map.get("INTERIORINVESTAMOUNT"));
            temp.put("RECOMMENDEDREPAYAMOUNT", map.get("RECOMMENDEDREPAYAMOUNT") == null ? "" : map.get("RECOMMENDEDREPAYAMOUNT"));
            temp.put("SUMREPAY", map.get("SUMREPAY") == null ? "" : map.get("SUMREPAY"));
            temp.put("SUMREPAYED", map.get("SUMREPAYED") == null ? "" : map.get("SUMREPAYED"));
            result.add(temp);
        }
        String sheeTTitle = "推广计划个人奖励结算汇总";
        String fileName = "推广计划个人奖励结算汇总" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);
        return null;
    }
}
