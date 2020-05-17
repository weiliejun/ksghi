package com.itech.ups.app.business.stats.action;

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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class UserIntegral extends AbstractActionParent {
    String[] heads = {"会员ID:USER_INFO_ID:30:center", "会员姓名:NAME:30:left", "发放日期 :CREATE_TIME:30:center", "发放类型:BUSI_TYPE:40:left", "发放积分:CHANGE_NUM:30:right", "备注:SOURCE_REMARK:20:left"};
    @Autowired
    private StatsService statsService;

    @RequestMapping(value = {"/business/stats/userintegral/exportExcel"})
    public String expUserRechargeList(HttpServletRequest request, HttpServletResponse response, Model model, String name, String dateRange) {
        final Map<String, Object> params = selectParams(request);
        Map<String, Object> totalMap = statsService.findUserIntegrasTotalCount(params);
        final int totalCount = ((BigDecimal) totalMap.get("TOTAL")).intValue();
        List<Map<String, Object>> result = statsService.findUserIntegras(params, 0, (int) totalCount);
        for (Map<String, Object> map : result) {
            map.put("BUSI_TYPE", CodeHelper.getValueByCode("user.integra.busiType", map.get("BUSI_TYPE").toString()));
            String remark = map.get("SOURCE_REMARK") == null ? "" : map.get("SOURCE_REMARK").toString();
        }
        int userCount = ((BigDecimal) totalMap.get("DIST_USER")).intValue();
        int integralCount = ((BigDecimal) totalMap.get("SUM_CHANGE_NUM")).intValue();
        StringBuffer sta_title = new StringBuffer();
        sta_title.append("共 ").append(totalCount).append(" 条记录，发放人数：").append(userCount).append("人，发放积分合计：");
        sta_title.append(integralCount);
        String sheeTTitle = "会员积分发放统计";
        String fileName = "会员积分发放统计" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, sta_title.toString(), heads, result, null);
        return null;
    }

    @RequestMapping("/business/stats/userintegral/list")
    public String userIntegralList(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);
        Map<String, Object> totalMap = statsService.findUserIntegrasTotalCount(params);
        final int totalCount = ((BigDecimal) totalMap.get("TOTAL")).intValue();
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return statsService.findUserIntegras(params, rowStart, rowEnd);
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
        int userCount = ((BigDecimal) totalMap.get("DIST_USER")).intValue();
        BigDecimal integralCount = (BigDecimal) totalMap.get("SUM_CHANGE_NUM");
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("userCount", userCount);
        model.addAttribute("integralCount", integralCount);
        return "/business/stats/userintegral";

    }
}
