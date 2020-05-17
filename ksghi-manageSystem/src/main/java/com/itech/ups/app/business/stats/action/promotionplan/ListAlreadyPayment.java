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
public class ListAlreadyPayment extends AbstractActionParent {
    private String[] pTitle = {"支付时间:REPAYTIME:15:center", "用户姓名:USERNAME:15:center", "手机号:USERMOBILE:15:center", "用户类别:LABELNAME:15:center", "支付类型:AMOUNTTYPE:30:center", "已付金额:MONEY:20:center"};
    @Autowired
    private StatsService statsService;

    @SuppressWarnings("unchecked")
    @RequestMapping("/business/stats/promotionplan/alreadypaymentExportExcel")
    public String alreadyPaymentExportExcel(HttpServletRequest request, HttpServletResponse response, String labelName, String mobile, String startDate, String endDate, String userName, String amountType) {
        final Map<String, Object> params = selectParams(request);
        List<Map<String, Object>> resultTemp = statsService.findAlreadyPayments(params, 0, (int) statsService.findAlreadyPaymentTotalCount(params));
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> map : resultTemp) {
            Map<String, Object> temp = new HashMap<String, Object>();
            temp.put("REPAYTIME", map.get("REPAYTIME") == null ? "" : map.get("REPAYTIME"));
            temp.put("USERNAME", map.get("USERNAME") == null ? "" : map.get("USERNAME"));
            String userMobile = map.get("USERMOBILE") == null ? "" : map.get("USERMOBILE").toString();
            temp.put("USERMOBILE", userMobile.substring(0, 3) + "****" + userMobile.substring(userMobile.length() - 4, userMobile.length()));
            temp.put("AMOUNTTYPE", CodeHelper.getValueByCode("user.userLabel", map.get("LABELNAME").toString()));
            temp.put("LABELNAME", CodeHelper.getValueByCode("merchantPayment.repayAmountType", map.get("AMOUNTTYPE").toString()));
            temp.put("MONEY", map.get("MONEY") == null ? "" : map.get("MONEY"));
            result.add(temp);
        }
        String sheeTTitle = "推广计划个人奖励已付汇总";
        String fileName = "推广计划个人奖励已付汇总" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);

        return null;
    }

    @RequestMapping("/business/stats/promotionplan/alreadypaymentlist")
    public String list(HttpServletRequest request, Model model) {

        final Map<String, Object> params = selectParams(request);

        Map totalMap = statsService.findAlreadyPaymentTotalMap();
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return statsService.findAlreadyPayments(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) statsService.findAlreadyPaymentTotalCount(params);
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

        return "/business/stats/promotionplan/alreadypaymentlist";
    }
}
