package com.itech.ups.app.business.stats.action;

import com.itech.core.util.CodeHelper;
import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.core.util.ThousandsHelper;
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
import java.math.BigDecimal;
import java.util.*;

@Controller
public class ActivityRebate extends AbstractActionParent {

    String[] heads = {"支付日期:REPAY_TIME:30:center", "产品名称:PNAME:30:left", "出借人姓名:UNAME:20:center", "出借金额 :TRANS_AMOUNT:30:right", "出借性质:INVESTMENT_NATURE:20:center", "返利金额:REPAY_AMOUNT:20:right", "返利类型:REPAY_AMOUNT_TYPE:20:center", "备注:REMARK:40:left"};
    @Autowired
    private StatsService statsService;

    @RequestMapping("/business/stats/activityrebate/list")
    public String activityRebate(HttpServletRequest request, Model model) {

        final Map<String, Object> params = searchCondition(request);
        Map<String, Object> countMap = statsService.selectMerchantPaymentsTotalCount(params);
        final int totalCount = ((BigDecimal) countMap.get("TOTAL")).intValue();
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return statsService.findMerchantPayments(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return totalCount;
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
        int userTotal = ((BigDecimal) countMap.get("DIST_USER_TOTAL")).intValue();
        BigDecimal sumRebateAmount = (BigDecimal) countMap.get("TOTAL_AMOUNT");

        model.addAttribute("totalCount", totalCount);
        model.addAttribute("userTotal", userTotal);
        model.addAttribute("sumRebateAmount", ThousandsHelper.formateThousands(sumRebateAmount, true));
        return "/business/stats/merchantpayment/cashList";
    }

    @RequestMapping("/business/stats/activityrebate/exportExcel")
    public String expActivityRebate(HttpServletRequest request, HttpServletResponse response, Model model, String pname, String uname, String category, String dateRange, String repayAmountType) {
        final Map<String, Object> map = searchCondition(request);
        Map<String, Object> countMap = statsService.selectMerchantPaymentsTotalCount(map);
        final int totalCount = ((BigDecimal) countMap.get("TOTAL")).intValue();
        List<Map<String, Object>> result = statsService.findMerchantPayments(map, 0, totalCount);
        if (result != null && result.size() > 0) {
            for (Map<String, Object> parme : result) {
                parme.put("REPAY_AMOUNT_TYPE", CodeHelper.getValueByCode("merchantPayment.repayAmountType", parme.get("REPAY_AMOUNT_TYPE").toString()));
                parme.put("INVESTMENT_NATURE", parme.get("CATEGORY") == null ? "" : CodeHelper.getValueByCode("tenderCategory", parme.get("CATEGORY").toString()));
                parme.put("REPAY_TIME", parme.get("REPAY_TIME").toString().substring(0, 10));
            }

        }
        int userTotal = ((BigDecimal) countMap.get("DIST_USER_TOTAL")).intValue();
        BigDecimal sumRebateAmount = (BigDecimal) countMap.get("TOTAL_AMOUNT");
        StringBuffer sta_title = new StringBuffer();
        sta_title.append("共 ").append(totalCount).append(" 条记录，出借人数：").append(userTotal).append("人， 返利合计：");
        sta_title.append(ThousandsHelper.formateThousands(sumRebateAmount, true));
        sta_title.append("元。 ");
        String sheeTTitle = "活动返利统计";
        String fileName = "活动返利统计" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, sta_title.toString(), heads, result, null);
        return null;
    }

    private Map<String, Object> searchCondition(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 读取保存的查询条件并复制
        Map parameters = (Map) request.getSession().getAttribute(request.getRequestURI());// 保存的查询条件
        if (null != parameters) {
            params.putAll(parameters);
        }
        params.put("queryString", request.getQueryString());
        // /////////////

        int i = 0;
        if (request.getQueryString() == null && null != params.get("size")) {
            i = new Integer(params.get("size").toString()).intValue();
        }
        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            if (null != request.getParameter(paraName) && !"".equalsIgnoreCase(request.getParameter(paraName)) && !"null".equalsIgnoreCase(request.getParameter(paraName))) {
                i++;
            }
            params.put(paraName, request.getParameter(paraName));
        }
        params.put("size", i);

        return params;
    }

}
