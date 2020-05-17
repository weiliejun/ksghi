package com.itech.ups.app.business.stats.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.core.util.ThousandsHelper;
import com.itech.ups.app.business.stats.action.common.Page;
import com.itech.ups.app.business.stats.application.service.StatsService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoyl 会员出借收益统计
 */
@Controller
public class Userincome extends AbstractActionParent {

    @Autowired
    private StatsService service;

    private String[] pTitle = {"会员ID:USERID:30:center", "会员姓名:NAME:30:left", "注册日期:CREATE_TIME:30:center", "出借次数:TZCS:20:right", "出借总额:TZZE:20:right", "单笔最高出借额:DBZGTZE:20:right", "单笔最低出借额:DBZDTZE:20:right", "出借收益合计:TZSYHJ:20:right", "总出借收益率:ZTZSYL:20:right", "备注:BZ:20:left"};

    @RequestMapping("/business/stats/userincome/list")
    public String list(HttpServletRequest request, Model model) {
        Map<String, Object> params = selectParamsEasyui(request);

        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        model.addAllAttributes((Map<String, Object>) request.getSession().getAttribute(request.getRequestURI()));

        return "/business/stats/userincomeList";
    }

    @RequestMapping(value = "/business/stats/userincome/loadexcel")
    public void loadExcel(HttpServletRequest request, HttpServletResponse response, String userName, String createTimeStart, String createTimeEnd) {
        Map<String, Object> params = selectParamsEasyui(request);

        Map<String, Object> resultMap = resultList(request, params, "exportExcel");
        Page page = (Page) resultMap.get("page");
        List<Map<String, Object>> resList = (List<Map<String, Object>>) page.getList();
        Map<String, Object> totalMap = (Map<String, Object>) resultMap.get("totalMap");

        String excelName = "会员出借收益统计_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());// excel名称
        String sheetName = "会员出借收益统计";// 主sheet名称

        StringBuffer pDescription = (StringBuffer) resultMap.get("pDescription");

        ExpExcelFSHelper.expExcel(request, response, excelName, sheetName, pDescription.toString(), pTitle, resList, null);
    }

    @RequestMapping(value = "/business/stats/userincome/query", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> query(HttpServletRequest request, String userName, String createTimeStart, String createTimeEnd) {
        Map<String, Object> params = selectParamsEasyui(request);
        Map<String, Object> model = new HashMap<String, Object>();

        Map<String, Object> resultMap = resultList(request, params, "query");
        Page page = (Page) resultMap.get("page");
        Map<String, Object> totalMap = (Map<String, Object>) resultMap.get("totalMap");

        model.putAll(params);
        model.put("total", page.getTotalRow());
        model.put("rows", page.getList());
        model.put("stats", totalMap);

        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        request.getSession().setAttribute(request.getContextPath() + "/business/stats/userincome/list", params);

        return model;
    }

    private Map<String, Object> resultList(HttpServletRequest request, Map<String, Object> params, String type) {

        List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
        Map<String, Object> totalMap = service.findUserincomesTotalInfo(params);

        totalMap.put("TZZEHJ", totalMap.get("TZZEHJ") == null ? "0" : ThousandsHelper.formateThousands(totalMap.get("TZZEHJ").toString(), true));
        totalMap.put("TZSYHJ", totalMap.get("TZSYHJ") == null ? "0" : ThousandsHelper.formateThousands(totalMap.get("TZSYHJ").toString(), true));

        // ///这里要这么修改/------这里是对当前页的记录
        Page page = null;
        if (new Integer(params.get("size").toString()).intValue() > 0) {
            if (params.get("page") != null && !request.getParameter("page").equals("1") && !request.getParameter("page").equalsIgnoreCase(params.get("page").toString())) {
                page = new Page(params.get("page").toString(), params.get("rows").toString(), ((BigDecimal) totalMap.get("TOTAL")).intValue());
            } else {
                page = new Page(request, ((BigDecimal) totalMap.get("TOTAL")).intValue());
            }
        } else {
            page = new Page(request, ((BigDecimal) totalMap.get("TOTAL")).intValue());
        }

        if (type.equals("query")) {
            resList = service.findUserincomes(params, page.getRowStart(), page.getRowEnd());
        } else if (type.equals("exportExcel")) {
            resList = service.findUserincomes(params, 0, ((BigDecimal) totalMap.get("TOTAL")).intValue());
        }

        StringBuffer pDescription = new StringBuffer("出借人数：");// 主sheet说明
        if (resList != null && resList.size() > 0) {
            for (Map<String, Object> fmap : resList) {
                fmap.put("TZZE", fmap.get("TZZE") == null ? "" : ThousandsHelper.formateThousands(fmap.get("TZZE").toString(), true));
                fmap.put("DBZGTZE", fmap.get("DBZGTZE") == null ? "" : ThousandsHelper.formateThousands(fmap.get("DBZGTZE").toString(), true));
                fmap.put("DBZDTZE", fmap.get("DBZDTZE") == null ? "" : ThousandsHelper.formateThousands(fmap.get("DBZDTZE").toString(), true));
                fmap.put("TZSYHJ", fmap.get("TZSYHJ") == null ? "" : ThousandsHelper.formateThousands(fmap.get("TZSYHJ").toString(), true));
            }
            if (type.equals("exportExcel")) {
                pDescription.append("出借人数：");// 主sheet说明
                pDescription.append(totalMap.get("TOTAL").toString()).append("人，出借金额合计:").append(totalMap.get("TZZEHJ").toString()).append("元，出借收益合计：").append(totalMap.get("TZSYHJ")).append("元，总出借收益率：").append(totalMap.get("ZTZSYL"));
            }
        }

        page.setList(resList);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("page", page);
        resultMap.put("totalMap", totalMap);
        resultMap.put("pDescription", pDescription);
        return resultMap;
    }
}
