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
import java.util.*;

@Controller
public class ActivityLottery extends AbstractActionParent {

    private final String[] pTitle = {"用户昵称:NICK_NAME:20:center", "用户姓名:NAME:30:center", "用户手机号:MOBILE:30:center", "活动名称:ACTIVATENAME:30:center", "活动编号:ACTIVATECODE:30:center", "奖券编号:ACTIVITYLOTTERYCODE:35:center", "奖券类型:TYPE:30:center", "是否金额转赠:IS_DONATION:30:center", "奖券价值:LOTTERY_VALUE:35:center", "发放时间:GIVE_TIME:30:center", "奖券使用截止日期:LOTTERY_END_TIME:20:center", "发放条件:GIVE_CONDITION:30:center", "激活条件:USE_CONDITION:40:center", "是否已使用:STATUS:30:right", "备注:REMARK:40:center"};
    @Autowired
    private StatsService statsService;

    @RequestMapping(value = "/business/stats/activitylottery/list")
    public String activitylottery(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return statsService.findActivityLotterys(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) statsService.findActivityLotterysTotalCount(params);
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

        return "/business/stats/activitylottery";
    }

    /*
     * 导出excel 2015-03-26 苏冰雪
     */
    @RequestMapping("/business/stats/activitylottery/list/exportExcel")
    public String fundRecordsExportExcel(HttpServletRequest request, HttpServletResponse response, String activateName, String activateCode, String activityLotteryCode, String type, String name, String mobile, String status) {
        final Map<String, Object> params = selectParams(request);

        List<HashMap> result0 = (List<HashMap>) statsService.findActivityLotterys(params, 0, (int) statsService.findActivityLotterysTotalCount(params));

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> map : result0) {
            HashMap temp = new HashMap();

            temp.put("NICK_NAME", map.get("NICK_NAME").toString().substring(0, 1) + "***" + map.get("NICK_NAME").toString().substring(map.get("NICK_NAME").toString().length() - 1, map.get("NICK_NAME").toString().length()));
            temp.put("NAME", map.get("NAME") == null ? "" : map.get("NAME").toString());
            String mobile1 = map.get("MOBILE").toString();
            temp.put("MOBILE", mobile1.substring(0, 3) + "****" + mobile1.substring(mobile1.length() - 4, mobile1.length()));
            temp.put("ACTIVATENAME", map.get("ACTIVATENAME") == null ? "" : map.get("ACTIVATENAME").toString());
            temp.put("ACTIVATECODE", map.get("ACTIVATECODE") == null ? "" : map.get("ACTIVATECODE").toString());
            temp.put("ACTIVITYLOTTERYCODE", map.get("ACTIVITYLOTTERYCODE") == null ? "" : map.get("ACTIVITYLOTTERYCODE").toString());
            temp.put("TYPE", CodeHelper.getValueByCode("activityLotteryType", map.get("TYPE").toString()));
            temp.put("IS_DONATION", CodeHelper.getValueByCode("activitylotteryIsDonation", map.get("IS_DONATION").toString()));
            temp.put("LOTTERY_VALUE", map.get("LOTTERY_VALUE") == null ? "" : map.get("LOTTERY_VALUE").toString());
            temp.put("GIVE_TIME", map.get("GIVE_TIME") == null ? "" : map.get("GIVE_TIME").toString());
            temp.put("LOTTERY_END_TIME", map.get("LOTTERY_END_TIME") == null ? "" : map.get("LOTTERY_END_TIME").toString());
            temp.put("GIVE_CONDITION", CodeHelper.getValueByCode("giveCondition", map.get("GIVE_CONDITION").toString()));
            temp.put("USE_CONDITION", map.get("USE_CONDITION") == null ? "" : map.get("USE_CONDITION").toString());
            temp.put("STATUS", CodeHelper.getValueByCode("activityLotteryStatus", map.get("STATUS").toString()));
            temp.put("REMARK", map.get("REMARK") == null ? "" : map.get("REMARK").toString());
            result.add(temp);
        }

        String sheeTTitle = "奖券统计";
        String fileName = "奖券统计" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);
        return null;
    }
}
