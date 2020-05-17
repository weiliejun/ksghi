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
public class UserWithdraw extends AbstractActionParent {
    String[] heads = {"会员ID:ID:30:center", "会员类型:ROLE_TYPE:30:left", "会员姓名/公司名称:NAME:40:left", "提现日期 :CREATE_TIME:30:center", "提现金额（元）:TRANS_AMOUNT:30:right", "备注:OPEN_BANK_ID:20:left"};
    @Autowired
    private StatsService statsService;

    @RequestMapping(value = {"/business/stats/userwithdraw/exportExcel"}, method = RequestMethod.GET)
    public String expUserRechargeList(HttpServletRequest request, HttpServletResponse response, Model model, String name, String roleType, String dateRange) {
        final Map<String, Object> params = selectParams(request);

        Map<String, Object> totalMap = statsService.findWithdrawsTotalCount(params);
        int totalCount = ((BigDecimal) totalMap.get("TOTAL")).intValue();

        List<Map<String, Object>> result = statsService.findPageWithdraws(params, 0, (int) totalCount);
        for (Map<String, Object> map : result) {
            map.put("ROLE_TYPE", CodeHelper.getValueByCode("roleType", map.get("ROLE_TYPE").toString()));
            Object transAmount = map.get("TRANS_AMOUNT");
            map.put("TRANS_AMOUNT", ThousandsHelper.formateThousands(transAmount, true));
        }

        int withdrawUserCount = ((BigDecimal) totalMap.get("DIST_USER_TOTAL")).intValue();
        BigDecimal sumTransAmount = (BigDecimal) totalMap.get("SUM_TRANS_AMOUNT");
        BigDecimal avgTransAmount = null;
        if (withdrawUserCount != 0) {
            if (sumTransAmount != null) {
                avgTransAmount = sumTransAmount.divide(new BigDecimal(withdrawUserCount), 2, BigDecimal.ROUND_HALF_UP);
            }
        }
        StringBuffer sta_title = new StringBuffer();
        sta_title.append("共 ").append(totalCount).append(" 条记录，提现人数：").append(withdrawUserCount).append("人， 充值金额合计：");
        sta_title.append(ThousandsHelper.formateThousands(sumTransAmount, true));
        sta_title.append("元， 人均提现：");
        sta_title.append(ThousandsHelper.formateThousands(avgTransAmount, true));
        sta_title.append("元");
        String sheeTTitle = "会员提现统计";
        String fileName = "会员提现统计" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, sta_title.toString(), heads, result, null);
        return null;
    }

    @RequestMapping("/business/stats/userwithdraw/list")
    public String userWithdraw(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);

        Map<String, Object> totalMap = statsService.findWithdrawsTotalCount(params);
        final int totalCount = ((BigDecimal) totalMap.get("TOTAL")).intValue();
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return statsService.findPageWithdraws(params, rowStart, rowEnd);
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
        int withdrawUserCount = ((BigDecimal) totalMap.get("DIST_USER_TOTAL")).intValue();
        BigDecimal sumTransAmount = (BigDecimal) totalMap.get("SUM_TRANS_AMOUNT");
        BigDecimal avgTransAmount = null;
        if (withdrawUserCount != 0) {
            if (sumTransAmount != null) {
                avgTransAmount = sumTransAmount.divide(new BigDecimal(withdrawUserCount), 2, BigDecimal.ROUND_HALF_UP);
            }
        }
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("withdrawUserCount", withdrawUserCount);
        model.addAttribute("sumTransAmount", ThousandsHelper.formateThousands(sumTransAmount, true));
        model.addAttribute("avgTransAmount", ThousandsHelper.formateThousands(avgTransAmount, true));
        return "/business/stats/userwithdraw";

    }
}
