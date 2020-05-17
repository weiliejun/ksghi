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
 * @author zhaoyl 会员出借回款统计
 */
@Controller
public class UserReceivedPayment extends AbstractActionParent {

    @Autowired
    private StatsService service;

    // 子sheet页标题
    private String[] cTitle = {"期次:PERIOD:5:center", "应回款日期:REPAY_PLAN_DATE:20:center", "应收本息合计:REPAY_AMOUNT:20:right", "实收本息合计:REPAY_AMOUNTY:20:right", "实际回款日期:REPAY_TIME:20:center", "备注:REMARK:50:left"};
    // 主sheet页标题
    private String[] pTitle = {"产品类型:CATEGORY:20:center", "产品名称:PNAME:40:left", "合同编号:BORROW_CONTRACT_NO:25:left", "交易ID:TENDERID:30:center", "出借人ID:USER_INFO_ID:30:center", "出借人名称:UNAME:30:left", "出借金额:TRANS_AMOUNT:20:right", "预期收益(%/年):ANNUAL_RATE:20:right", "计息起息日:REPAY_START_DATE:20:center", "计息终止日:REPAY_END_DATE:25:center", "收益分配方式:REPAY_TYPE:30:left", "应收利息:YSLX:20:right", "总期数:ZQS:20:right", "已回期数:YHQS:20:right", "未回期数:WHQS:20:right", "已回本息合计:YHBXHJ:20:right", "未回本息合计:WHBXHJ:20:right", "产品状态:STATUS:20:left", "备注:BZ:20:left"};

    @RequestMapping("/business/stats/usereceivedpayment/list")
    public String list(HttpServletRequest request, Model model) {
        Map<String, Object> params = selectParamsEasyui(request);

        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        model.addAllAttributes((Map<String, Object>) request.getSession().getAttribute(request.getRequestURI()));
        return "/business/stats/userreceivedpaymentList";
    }

    @RequestMapping(value = "/business/stats/usereceivedpayment/loadexcel")
    public void loadExcel(HttpServletRequest request, HttpServletResponse response, String status, String userName, String productName, String repayStartDate, String repayEndDate) {
        Map<String, Object> params = selectParamsEasyui(request);

        Map<String, Object> resultMap = resultList(request, params, "exportExcel");
        Page page = (Page) resultMap.get("page");
        List<Map<String, Object>> resList = (List<Map<String, Object>>) page.getList();
        Map<String, Object> totalMap = (Map<String, Object>) resultMap.get("totalMap");

        String excelName = "会员出借回款统计_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());// excel名称
        String sheetName = "会员出借回款统计";// 主sheet名称

        StringBuffer pDescription = (StringBuffer) resultMap.get("pDescription");

        ExpExcelFSHelper.expExcel(request, response, excelName, sheetName, pDescription.toString(), pTitle, resList, cTitle);
    }

    @RequestMapping(value = "/business/stats/usereceivedpayment/query", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> query(HttpServletRequest request, String status, String userName, String productName, String repayStartDate, String repayEndDate) {
        Map<String, Object> params = selectParamsEasyui(request);
        Map<String, Object> model = new HashMap<String, Object>();
        // size>0输入查询条件才查询
        // if (new Integer(params.get("size").toString()).intValue() > 0) {
        Map<String, Object> resultMap = resultList(request, params, "query");
        Page page = (Page) resultMap.get("page");
        List<Map<String, Object>> resList = (List<Map<String, Object>>) page.getList();
        Map<String, Object> totalMap = (Map<String, Object>) resultMap.get("totalMap");

        model.putAll(params);
        model.put("total", page.getTotalRow());
        model.put("rows", page.getList());
        model.put("stats", totalMap);

        /*
         * }else{ Map<String, Object> totalMap = new HashMap<String, Object>();
         * List<Map<String, Object>> rows = new ArrayList<Map<String,
         * Object>>();
         *
         * totalMap.put("TZZE", "0.00"); totalMap.put("YSLXZE", "0.00");
         * totalMap.put("YSBXHJ", "0.00"); totalMap.put("DFBXHJ", "0.00");
         *
         * model.put("total", 0); model.put("rows", rows); model.put("stats",
         * totalMap); }
         */
        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        request.getSession().setAttribute(request.getContextPath() + "/business/stats/usereceivedpayment/list", params);
        return model;
    }

    private Map<String, Object> resultList(HttpServletRequest request, Map<String, Object> params, String type) {

        List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
        Map<String, Object> totalMap = service.findUserReceivedPaymentsTotalInfo(params);

        totalMap.put("TZZE", totalMap.get("TZZE") == null ? "0.00" : ThousandsHelper.formateThousands(totalMap.get("TZZE").toString(), true));
        totalMap.put("YSLXZE", totalMap.get("YSLXZE") == null ? "0.00" : ThousandsHelper.formateThousands(totalMap.get("YSLXZE").toString(), true));
        totalMap.put("YSBXHJ", totalMap.get("YSBXHJ") == null ? "0.00" : ThousandsHelper.formateThousands(totalMap.get("YSBXHJ").toString(), true));
        totalMap.put("DFBXHJ", totalMap.get("DFBXHJ") == null ? "0.00" : ThousandsHelper.formateThousands(totalMap.get("DFBXHJ").toString(), true));

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
            resList = service.findUserReceivedPayments(params, page.getRowStart(), page.getRowEnd());
        } else if (type.equals("exportExcel")) {
            resList = service.findUserReceivedPayments(params, 0, ((BigDecimal) totalMap.get("TOTAL")).intValue());
        }

        StringBuffer pDescription = new StringBuffer();// 主sheet说明
        if (resList != null && resList.size() > 0) {
            for (Map<String, Object> fmap : resList) {
                fmap.put("TRANS_AMOUNT", fmap.get("TRANS_AMOUNT") == null ? "" : ThousandsHelper.formateThousands(fmap.get("TRANS_AMOUNT").toString(), true));
                fmap.put("YSLX", fmap.get("YSLX") == null ? "" : ThousandsHelper.formateThousands(fmap.get("YSLX").toString(), true));
                fmap.put("YHBXHJ", fmap.get("YHBXHJ") == null ? "" : ThousandsHelper.formateThousands(fmap.get("YHBXHJ").toString(), true));
                fmap.put("WHBXHJ", fmap.get("WHBXHJ") == null ? "" : ThousandsHelper.formateThousands(fmap.get("WHBXHJ").toString(), true));

                fmap.put("CATEGORY", CodeHelper.getValueByCode("product.category", fmap.get("CATEGORY").toString()));
                fmap.put("REPAY_TYPE", CodeHelper.getValueByCode("product.repayType", fmap.get("REPAY_TYPE").toString()));
                fmap.put("STATUS", CodeHelper.getValueByCode("product.status", fmap.get("STATUS").toString()));

                if (type.equals("exportExcel")) {
                    String tenderId = fmap.get("TENDERID").toString();
                    Map<String, Object> repayParams = new HashMap<String, Object>();
                    repayParams.put("tenderId", tenderId);
                    List<Map<String, Object>> repayList = service.findRepayments(repayParams);
                    fmap.put("childName", fmap.get("TENDERID").toString());// 子sheet名字
                    fmap.put("childList", repayList);// 子sheet的list
                    StringBuffer cDescription = new StringBuffer("产品类型：");
                    cDescription.append(fmap.get("CATEGORY").toString()).append("，产品名称：").append(fmap.get("PNAME").toString()).append("，出借人姓名").append(fmap.get("UNAME").toString());
                    fmap.put("cDescription", cDescription.toString());// 子sheet的说明
                    fmap.put("linkCol", 4);
                    // fmap.put("linkDes", "");
                }
            }
            if (type.equals("exportExcel")) {
                pDescription.append("共");// 主sheet说明
                pDescription.append(totalMap.get("TOTAL").toString()).append("笔出借，出借总额:").append(totalMap.get("TZZE").toString()).append("元，应收利息总额：").append(totalMap.get("YSLXZE").toString()).append("元，已收本息合计：").append(totalMap.get("YSBXHJ").toString()).append("元，待付本息合计：").append(totalMap.get("DFBXHJ").toString()).append("元");
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
