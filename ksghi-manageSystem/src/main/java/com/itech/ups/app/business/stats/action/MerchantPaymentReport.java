package com.itech.ups.app.business.stats.action;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoyl 商户返利统计
 */
@Controller
public class MerchantPaymentReport extends AbstractActionParent {

    @Autowired
    private StatsService service;
    private String[] interestPTitle = {"支付日期:REPAY_TIME:20:center", "支付状态:STATUS:10:center", "产品名称:PNAME:40:left", "出借人姓名:UNAME:25:left", "出借日期:TZRQ:20:center", "出借放款日期:TZFKRQ:20:center", "出借金额:TRANS_AMOUNT:20:right", "年化利率:ANNUAL_RATE:20:right", "计息天数（天）:JXTS:20:right", "利息金额:REPAY_AMOUNT:20:right", "备注:BZ:20:left"};

    /**
     * 募集期利息统计
     *
     * @param request
     * @param productName    产品名称
     * @param userName       出借人名称
     * @param repayStartTime 支付日期开始日期
     * @param repayEndTime   支付日期结束日期
     * @return
     */
    @RequestMapping("/business/stats/merchantpaymentreport/interest/list")
    public String list(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);

        final Map<String, Object> totalMap = service.findInterestReportTotalCount(params);
        totalMap.put("TOTAL_AMOUNT", totalMap.get("TOTAL_AMOUNT") == null ? 0 : ThousandsHelper.formateThousands(totalMap.get("TOTAL_AMOUNT"), true));
        totalMap.put("TOTAL_RAMOUNT", totalMap.get("TOTAL_RAMOUNT") == null ? 0 : ThousandsHelper.formateThousands(totalMap.get("TOTAL_RAMOUNT"), true));
        final int totalCount = Integer.parseInt(totalMap.get("TOTAL").toString());
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    List<Map<String, Object>> list = service.findInterestReport(params, rowStart, rowEnd);
                    if (list != null && list.size() > 0) {
                        long jxtsT = 0;
                        for (Map<String, Object> map2 : list) {
                            map2.put("STATUS", map2.get("STATUS").toString().equals("repayed") ? "已付款" : "待付款");
                            map2.put("TRANS_AMOUNT", ThousandsHelper.formateThousands(map2.get("TRANS_AMOUNT"), true));
                            map2.put("REPAY_AMOUNT", ThousandsHelper.formateThousands(map2.get("REPAY_AMOUNT"), true));
                        }
                    }
                    return list;
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

        model.addAttribute("totalMap", totalMap);
        return "/business/stats/merchantpayment/interestList";
    }

    /**
     * 募集期利息导出
     *
     * @param request
     * @param response
     * @param status
     * @param productName
     * @param repayStart
     * @param repayEnd
     */
    @RequestMapping(value = "business/stats/merchantpaymentreport/interest/loadexcel")
    public void loadExcel(HttpServletRequest request, HttpServletResponse response, String productName, String userName, String repayStartTime, String repayEndTime, String status, String repayStatus) {
        final Map<String, Object> param = selectParams(request);
        /*
         * param.put("productName", productName); param.put("userName",
         * userName); param.put("repayStartTime", repayStartTime);
         * param.put("repayEndTime", repayEndTime); param.put("status", status);
         * param.put("repayStatus", repayStatus);
         */
        Map<String, Object> totalMap = service.findInterestReportTotalCount(param);
        totalMap.put("TOTAL_AMOUNT", totalMap.get("TOTAL_AMOUNT") == null ? 0 : ThousandsHelper.formateThousands(totalMap.get("TOTAL_AMOUNT"), true));
        totalMap.put("TOTAL_RAMOUNT", totalMap.get("TOTAL_RAMOUNT") == null ? 0 : ThousandsHelper.formateThousands(totalMap.get("TOTAL_RAMOUNT"), true));
        String excelName = "募集期利息统计_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());// excel名称
        String sheetName = "募集期利息统计";// 主sheet名称
        StringBuffer pDescription = new StringBuffer();// 主sheet说明
        List<Map<String, Object>> resultList = service.findInterestReport(param, 0, Integer.parseInt(totalMap.get("TOTAL").toString()));
        if (resultList != null && resultList.size() > 0) {
            long jxtsT = 0;
            for (Map<String, Object> map : resultList) {
                map.put("STATUS", map.get("STATUS").toString().equals("repayed") ? "已付款" : "待付款");
                map.put("TRANS_AMOUNT", ThousandsHelper.formateThousands(map.get("TRANS_AMOUNT"), true));
                map.put("REPAY_AMOUNT", ThousandsHelper.formateThousands(map.get("REPAY_AMOUNT"), true));
            }
            pDescription.append("共");// 主sheet说明
            pDescription.append(totalMap.get("TOTAL").toString()).append("条记录，出借总额：").append(totalMap.get("TOTAL_AMOUNT").toString());
            pDescription.append("元，计息天数：").append(totalMap.get("JXTST")).append("天，利息总额：").append(totalMap.get("TOTAL_RAMOUNT").toString());
        }
        ExpExcelFSHelper.expExcel(request, response, excelName, sheetName, pDescription.toString(), interestPTitle, resultList, null);
    }
}
