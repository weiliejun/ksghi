package com.itech.ups.app.business.stats.action;

import com.itech.core.util.*;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoyl 代偿还款统计
 */
@Controller
public class InsteadRepayment extends AbstractActionParent {

    @Autowired
    private StatsService service;

    private String[] pTitle = {"产品类型:CATEGORY:20:center", "产品ID:ID:30:center", "产品名称:NAME:40:left", "合同编号:BORROW_CONTRACT_NO:25:left", "借款人ID:BORROWER_USER_INFO_ID:30:left", "借款人名称:BORROWER_NAME:30:left", "贷款期限:TIME_LIMIT:20:right", "支付方式:REPAY_TYPE:25:left", "贷款总额:AMOUNT:20:right", "总期数:ZQS:20:right", "代偿期次:PERIOD:20:right", "代偿机构名称:REPAY_USER_NAME:50:left", "延期类型:REPAY_AMOUNT_TYPE:50:left", "应还款日期:REPAY_PLAN_DATE:50:left", "代偿日期:REPAY_TIME:30:center", "代偿金额:DCJE:20:right", "产品状态:STATUS:20:left"};

    @RequestMapping("/business/stats/insteadrepayment/list")
    public String list(HttpServletRequest request, Model model) {
        Map<String, Object> params = selectParamsEasyui(request);

        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        model.addAllAttributes((Map<String, Object>) request.getSession().getAttribute(request.getRequestURI()));
        return "/business/stats/insteadrepaymentList";
    }

    @RequestMapping(value = "/business/stats/insteadrepayment/loadexcel")
    public void loadExcel(HttpServletRequest request, HttpServletResponse response, String status, String productName, String repayStart, String repayEnd, String repayAmountType, String repaytype) {
        Map<String, Object> params = selectParamsEasyui(request);

        Map<String, Object> resultMap = resultList(request, params, "exportExcel", repaytype);
        Page page = (Page) resultMap.get("page");
        List<Map<String, Object>> resList = (List<Map<String, Object>>) page.getList();

        StringBuffer pDescription = (StringBuffer) resultMap.get("pDescription");

        String excelName = "代偿还款统计_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());// excel名称
        String sheetName = "代偿还款统计";// 主sheet名称

        ExpExcelFSHelper.expExcel(request, response, excelName, sheetName, pDescription.toString(), pTitle, resList, null);
    }

    @RequestMapping(value = "/business/stats/insteadrepayment/query", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> query(HttpServletRequest request, String status, String productName, String repayStart, String repayEnd, String repayAmountType, String repaytype) {
        Map<String, Object> params = selectParamsEasyui(request);
        Map<String, Object> model = new HashMap<String, Object>();

        Map<String, Object> resultMap = resultList(request, params, "query", repaytype);
        Page page = (Page) resultMap.get("page");
        Map<String, Object> stats = (Map<String, Object>) resultMap.get("stats");

        model.putAll(params);
        model.put("total", page.getTotalRow());
        model.put("rows", page.getList());
        model.put("stats", stats);

        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        request.getSession().setAttribute(request.getContextPath() + "/business/stats/insteadrepayment/list", params);

        return model;
    }

    private Map<String, Object> resultList(HttpServletRequest request, Map<String, Object> params, String type, String repaytype) {

        if (StringHelper.isNotBlank((String) params.get("repaytype"))) {
            if ("1".equals(repaytype)) {
                String daichanghuankuan = "daichanghuankuan";
                params.put("daichanghuankuan", daichanghuankuan);
                params.remove("zizhuhuankuan");
            } else if ("2".equals(repaytype)) {
                String zizhuhuankuan = "zizhuhuankuan";
                params.put("zizhuhuankuan", zizhuhuankuan);
                params.remove("daichanghuankuan");
            } else {
                params.put("0", "0");
            }
        } else {
            params.remove("daichanghuankuan");
            params.remove("zizhuhuankuan");
            params.remove("repaytype");
        }
        List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> totalMap = service.findInsteadRepaymentsTotalInfo(params);

        int total = 0;
        float DCJET = 0;
        Map<String, String> map = new HashMap<String, String>();
        if (totalMap != null && totalMap.size() > 0) {
            for (Map<String, Object> tmap : totalMap) {
                total += Integer.parseInt(tmap.get("TOTAL").toString());
                DCJET += Float.parseFloat(tmap.get("DCJET").toString());
                if (tmap.get("REPAYTYPE").equals("interest")) {
                    map.put("LXYQT", tmap.get("TOTAL").toString());
                } else if (tmap.get("REPAYTYPE").equals("principalAndInterest")) {
                    map.put("BXYQT", tmap.get("TOTAL").toString());
                }
            }
        } else {
            map.put("BXYQT", "0");
        }
        map.put("DCJET", ThousandsHelper.formateThousands(DCJET, true));
        map.put("YQHKT", total + "");

        // ///这里要这么修改/------这里是对当前页的记录
        Page page = null;
        if (new Integer(params.get("size").toString()).intValue() > 0) {
            if (params.get("page") != null && !request.getParameter("page").equals("1") && !request.getParameter("page").equalsIgnoreCase(params.get("page").toString())) {
                page = new Page(params.get("page").toString(), params.get("rows").toString(), total);
            } else {
                page = new Page(request, total);
            }
        } else {
            page = new Page(request, total);
        }

        if (type.equals("query")) {
            resList = service.findInsteadRepayments(params, page.getRowStart(), page.getRowEnd());
        } else if (type.equals("exportExcel")) {
            resList = service.findInsteadRepayments(params, 0, total);
        }

        StringBuffer pDescription = new StringBuffer();// 主sheet说明
        if (resList != null && resList.size() > 0) {
            for (Map<String, Object> fmap : resList) {
                fmap.put("AMOUNT", fmap.get("AMOUNT") == null ? "" : ThousandsHelper.formateThousands(fmap.get("AMOUNT").toString(), true));
                fmap.put("DCJE", fmap.get("DCJE") == null ? "" : ThousandsHelper.formateThousands(fmap.get("DCJE").toString(), true));
                fmap.put("CATEGORY", CodeHelper.getValueByCode("product.category", fmap.get("CATEGORY") == null ? "" : fmap.get("CATEGORY").toString()));
                fmap.put("REPAY_TYPE", CodeHelper.getValueByCode("product.repayType", fmap.get("REPAY_TYPE") == null ? "" : fmap.get("REPAY_TYPE").toString()));
                fmap.put("STATUS", CodeHelper.getValueByCode("product.status", fmap.get("STATUS") == null ? "" : fmap.get("STATUS").toString()));
                fmap.put("TIME_LIMIT", fmap.get("TIME_LIMIT") == null ? "" : fmap.get("TIME_LIMIT").toString() + (fmap.get("TIME_LIMIT_UNIT") == null ? "" : fmap.get("TIME_LIMIT_UNIT").equals("month") ? "(月)" : "(天)"));
                if (type.equals("exportExcel")) {
                    fmap.put("REPAY_AMOUNT_TYPE", (CodeHelper.getValueByCode("tender.repayment.repayAmountTypeName", fmap.get("REPAY_AMOUNT_TYPE") == null ? "" : fmap.get("REPAY_AMOUNT_TYPE").toString())).toString());

                }
            }
            if (type.equals("exportExcel")) {
                if (map.get("LXYQT") == null) {
                    map.put("LXYQT", "0");
                } else if (map.get("BXYQT") == null) {
                    map.put("BXYQT", "0");
                }
                pDescription.append("共");// 主sheet说明
                pDescription.append(total + "").append("条记录，代偿金额合计:").append(map.get("DCJET").toString()).append(",").append("延期还款共计").append(map.get("YQHKT")).append("次").append(",").append("利息延期").append(map.get("LXYQT")).append("次").append(",").append("产品到期本息延期").append(map.get("BXYQT")).append("次");
            }
        }

        page.setList(resList);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("page", page);
        resultMap.put("totalMap", totalMap);
        resultMap.put("stats", map);
        resultMap.put("pDescription", pDescription);
        return resultMap;
    }
}
