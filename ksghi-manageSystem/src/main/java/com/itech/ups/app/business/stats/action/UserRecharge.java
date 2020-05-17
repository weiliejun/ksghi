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
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class UserRecharge extends AbstractActionParent {

    String[] heads = {"会员ID:ID:30:center", "会员类型:ROLE_TYPE:20:left", "会员姓名/公司名称:NAME:40:left", "充值日期 :CREATE_TIME:30:center", "充值金额（元）:TRANS_AMOUNT:30:right", "充值方式:PAY_METHOD:20:left", "备注:OPEN_BANK_ID:20:left"};
    @Autowired
    private StatsService statsService;

    @RequestMapping(value = {"/business/stats/userecharge/exportExcel"}, method = RequestMethod.GET)
    public String expUserRechargeList(HttpServletRequest request, HttpServletResponse response, Model model, String name, String roleType, String dateRange, String payMethod) {
        final Map<String, Object> params = selectParams(request);

        Map<String, Object> countMap = statsService.findRechargesTotalCount(params);
        int totalCount = ((BigDecimal) countMap.get("TOTAL")).intValue();
        List<Map<String, Object>> result = statsService.findPageRecharges(params, 0, (int) totalCount);
        for (Map<String, Object> map : result) {
            map.put("ROLE_TYPE", CodeHelper.getValueByCode("roleType", map.get("ROLE_TYPE").toString()));
            map.put("PAY_METHOD", CodeHelper.getValueByCode("recharge.payMethod", map.get("PAY_METHOD").toString()));
            map.put("OPEN_BANK_ID", CodeHelper.getValueByCode("bankAcronym", map.get("OPEN_BANK_ID") == null ? "" : map.get("OPEN_BANK_ID").toString()));
            Object transAmount = map.get("TRANS_AMOUNT");
            map.put("TRANS_AMOUNT", ThousandsHelper.formateThousands(transAmount, true));
        }

        int rechargeUserCount = ((BigDecimal) countMap.get("DIST_USER_TOTAL")).intValue();
        BigDecimal sumTransAmount = (BigDecimal) countMap.get("SUM_TRANS_AMOUNT");
        BigDecimal avgTransAmount = null;
        if (rechargeUserCount != 0) {
            if (sumTransAmount != null) {
                avgTransAmount = sumTransAmount.divide(new BigDecimal(rechargeUserCount), 2, BigDecimal.ROUND_HALF_UP);
            }
        }
        StringBuffer sta_title = new StringBuffer();
        sta_title.append("共 ").append(totalCount).append(" 条记录，充值人数：").append(rechargeUserCount).append("人， 充值金额合计：");
        sta_title.append(ThousandsHelper.formateThousands(sumTransAmount, true));
        sta_title.append("元， 人均充值：");
        sta_title.append(ThousandsHelper.formateThousands(avgTransAmount, true));
        sta_title.append("元");
        String sheeTTitle = "会员充值统计";
        String fileName = "会员充值统计" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, sta_title.toString(), heads, result, null);
        return null;
    }

    @RequestMapping("/business/stats/userecharge/list")
    public String userRecharge(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);
        Map<String, Object> countMap = statsService.findRechargesTotalCount(params);
        final int totalCount = ((BigDecimal) countMap.get("TOTAL")).intValue();
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return statsService.findPageRecharges(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) totalCount;
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
        int rechargeUserCount = ((BigDecimal) countMap.get("DIST_USER_TOTAL")).intValue();
        BigDecimal sumTransAmount = (BigDecimal) countMap.get("SUM_TRANS_AMOUNT");
        BigDecimal avgTransAmount = null;
        if (rechargeUserCount != 0) {
            if (sumTransAmount != null) {
                avgTransAmount = sumTransAmount.divide(new BigDecimal(rechargeUserCount), 2, BigDecimal.ROUND_HALF_UP);
            }
        }
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("rechargeUserCount", rechargeUserCount);
        model.addAttribute("sumTransAmount", ThousandsHelper.formateThousands(sumTransAmount, true));
        model.addAttribute("avgTransAmount", ThousandsHelper.formateThousands(avgTransAmount, true));
        return "/business/stats/userecharge";
    }
}
