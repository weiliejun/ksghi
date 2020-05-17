package com.itech.ups.app.business.stats.action;

import com.itech.core.util.CodeHelper;
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
 * @author zhaoyl 产品还款统计
 */
@Controller
public class ProductRepayment extends AbstractActionParent {

    @Autowired
    private StatsService service;

    // 子sheet页标题
    private String[] cTitle = {"期次:PERIOD:5:center", "应还款日期:REPAY_PLAN_DATE:20:center", "应还本息:REPAY_AMOUNT:20:right", "已付本息:REPAY_AMOUNTY:20:right", "实际还款日期:REPAY_TIME:20:center", "备注:REMARK:50:left"};
    // 主sheet页标题
    private String[] pTitle = {"产品类型:CATEGORY:20:center", "产品ID:ID:30:center", "产品名称:NAME:40:left", "合同编号:BORROW_CONTRACT_NO:25:left", "借款人ID:BORROWER_USER_INFO_ID:30:center", "借款人名称:BORROWER_NAME:30:left", "贷款期限:TIME_LIMIT:20:right", "贷款起息日:REPAY_START_DATE:20:center", "贷款终止日:REPAY_END_DATE:20:center", "支付方式:REPAY_TYPE:25:left", "贷款总额:AMOUNT:20:right", "贷款利率(%/年):ANNUAL_RATE:20:right", "应付利息:LIXI:20:right", "总期数:ZQS:20:right", "已付期数:YFQS:20:right", "未付期数:WFQS:20:right", "已付本息合计:YFBXHJ:20:right", "未付本息合计:WFBXHJ:20:right", "产品状态:STATUS:20:left", "备注:BZ:20:left"};

    @RequestMapping("/business/stats/productpayment/list")
    public String list(HttpServletRequest request, Model model) {
        Map<String, Object> params = selectParamsEasyui(request);

        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        model.addAllAttributes((Map<String, Object>) request.getSession().getAttribute(request.getRequestURI()));

        return "/business/stats/productpaymentList";
    }

    @RequestMapping(value = "/business/stats/productpayment/loadexcel")
    public void loadExcel(HttpServletRequest request, HttpServletResponse response, String status, String productName, String repayStart, String repayEnd) {
        Map<String, Object> params = selectParamsEasyui(request);

        Map<String, Object> resultMap = resultList(request, params, "exportExcel");
        Page page = (Page) resultMap.get("page");
        List<Map<String, Object>> resList = (List<Map<String, Object>>) page.getList();

        String excelName = "产品还款统计_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());// excel名称
        String sheetName = "产品还款统计";// 主sheet名称

        StringBuffer pDescription = (StringBuffer) resultMap.get("pDescription");

        ExpExcelFSHelper.expExcel(request, response, excelName, sheetName, pDescription.toString(), pTitle, resList, cTitle);
    }

    @RequestMapping(value = "/business/stats/productpayment/query", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> query(HttpServletRequest request, String status, String productName, String repayStart, String repayEnd) {
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
        request.getSession().setAttribute(request.getContextPath() + "/business/stats/productpayment/list", params);

        return model;
    }

    private Map<String, Object> resultList(HttpServletRequest request, Map<String, Object> params, String type) {

        List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
        Map<String, Object> totalMap = service.findProductPaymentsTotalInfo(params);

        totalMap.put("AMOUNTT", totalMap.get("AMOUNTT") == null ? "0" : ThousandsHelper.formateThousands(totalMap.get("AMOUNTT").toString(), true));
        totalMap.put("LIXIT", totalMap.get("LIXIT") == null ? "0.00" : ThousandsHelper.formateThousands(totalMap.get("LIXIT").toString(), true));
        totalMap.put("YFBJHJT", totalMap.get("YFBJHJT") == null ? "0.00" : ThousandsHelper.formateThousands(totalMap.get("YFBJHJT").toString(), true));
        totalMap.put("YFBXHJT", totalMap.get("YFBXHJT") == null ? "0.00" : ThousandsHelper.formateThousands(totalMap.get("YFBXHJT").toString(), true));
        totalMap.put("WFBXHJT", totalMap.get("WFBXHJT") == null ? "0.00" : ThousandsHelper.formateThousands(totalMap.get("WFBXHJT").toString(), true));

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
            resList = service.findProductPayments(params, page.getRowStart(), page.getRowEnd());
        } else if (type.equals("exportExcel")) {
            resList = service.findProductPayments(params, 0, ((BigDecimal) totalMap.get("TOTAL")).intValue());
        }

        StringBuffer pDescription = new StringBuffer();// 主sheet说明
        if (resList != null && resList.size() > 0) {
            for (Map<String, Object> fmap : resList) {
                fmap.put("AMOUNT", fmap.get("AMOUNT") == null ? "" : ThousandsHelper.formateThousands(fmap.get("AMOUNT").toString(), true));
                fmap.put("LIXI", fmap.get("LIXI") == null ? "" : ThousandsHelper.formateThousands(fmap.get("LIXI").toString(), true));
                fmap.put("YFBJHJ", fmap.get("YFBJHJ") == null ? "" : ThousandsHelper.formateThousands(fmap.get("YFBJHJ").toString(), true));
                fmap.put("YFBXHJ", fmap.get("YFBXHJ") == null ? "" : ThousandsHelper.formateThousands(fmap.get("YFBXHJ").toString(), true));
                fmap.put("WFBXHJ", fmap.get("WFBXHJ") == null ? "" : ThousandsHelper.formateThousands(fmap.get("WFBXHJ").toString(), true));

                fmap.put("CATEGORY", CodeHelper.getValueByCode("product.category", fmap.get("CATEGORY") == null ? "" : fmap.get("CATEGORY").toString()));
                fmap.put("REPAY_TYPE", CodeHelper.getValueByCode("product.repayType", fmap.get("REPAY_TYPE") == null ? "" : fmap.get("REPAY_TYPE").toString()));
                fmap.put("STATUS", CodeHelper.getValueByCode("product.status", fmap.get("STATUS") == null ? "" : fmap.get("STATUS").toString()));
                fmap.put("TIME_LIMIT", fmap.get("TIME_LIMIT") == null ? "" : fmap.get("TIME_LIMIT").toString() + (fmap.get("TIME_LIMIT_UNIT") == null ? "" : fmap.get("TIME_LIMIT_UNIT").equals("month") ? "(月)" : "(天)"));

                if (type.equals("exportExcel")) {
                    String productId = fmap.get("ID").toString();
                    Map<String, Object> repayParams = new HashMap<String, Object>();
                    repayParams.put("productId", productId);
                    List<Map<String, Object>> repayList = service.findRepayments(repayParams);
                    fmap.put("childName", fmap.get("ID").toString());// 子sheet名字
                    fmap.put("childList", repayList);// 子sheet的list
                    StringBuffer cDescription = new StringBuffer("产品类型：");
                    cDescription.append(fmap.get("CATEGORY").toString()).append("，产品ID：").append(fmap.get("ID").toString()).append("，产品名称：").append(fmap.get("NAME").toString());
                    fmap.put("cDescription", cDescription.toString());// 子sheet的说明
                    fmap.put("linkCol", 2);
                    // fmap.put("linkDes", "");
                }
            }

            if (type.equals("exportExcel")) {
                pDescription.append("共");// 主sheet说明
                pDescription.append(totalMap.get("TOTAL").toString()).append("个产品，贷款总额:").append(totalMap.get("AMOUNTT").toString()).append("元，应付利息总额：").append(totalMap.get("LIXIT").toString()).append("元，已付本息合计：").append(totalMap.get("YFBXHJT").toString()).append("元，未付本息合计：").append(totalMap.get("WFBXHJT").toString()).append("元");

                // ExpExcelFSHelper.expExcel(request, response, excelName,
                // sheetName, pDescription.toString(), pTitle, resultList,
                // cTitle);
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
