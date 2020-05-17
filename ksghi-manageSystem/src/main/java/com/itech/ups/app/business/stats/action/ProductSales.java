package com.itech.ups.app.business.stats.action;

import com.itech.core.util.CodeHelper;
import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.core.util.ThousandsHelper;
import com.itech.ups.app.business.stats.action.common.Page;
import com.itech.ups.app.business.stats.application.service.StatsService;
import com.itech.ups.base.web.action.AbstractActionParent;
import com.itech.ups.base.web.taglibs.code.Code;
import com.itech.ups.base.web.taglibs.code.CodesFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

@Controller
public class ProductSales extends AbstractActionParent {
    @Autowired
    private StatsService statsService;

    private String[] pTitle = {"产品类型:CATEGORY:20:center", "产品ID:ID:30:center", "产品名称:NAME:40:left", "合同编号:BORROW_CONTRACT_NO:30:left", "产品规模:AMOUNT:30:right", "年化利率:ANNUAL_RATE:30:right", "产品期限:DENDLINE:30:right", "支付方式:REPAY_TYPE:30:left", "出借总额(元):TENDER_AMOUNT:20:right", "单笔最高(元):TRANST:20:right", "单笔最低(元):TRANSB:20:right", "出借笔数:TENDER_USERS:20:right", "起息日:REPAY_START_DATE:30:center", "产品到期日:REPAY_END_DATE:30:center", "产品状态:STATUS:20:center", "备注:P_REMARK:20:left"};

    @RequestMapping("/business/stats/productsales/list")
    public String productSales(HttpServletRequest request, Model model) {
        Code element = CodesFactory.getInstance().getCode("product.status");
        List<String> values = element.getValues();
        Map<String, String> productStatus = null;
        if (!values.isEmpty()) {
            productStatus = new HashMap<String, String>();
            for (Iterator<String> iterator = values.iterator(); iterator.hasNext(); ) {
                String key = iterator.next();
                String label = element.getItems().get(key);
                if (StringUtils.isNotBlank(key)) {
                    if (key.equals("tender") || key.equals("success") || key.equals("repaying") || key.equals("repayed") || key.equals("prepayed") || key.equals("running")) {
                        productStatus.put(label, key);
                    }
                }
            }
        }
        Map<String, Object> params = selectParamsEasyui(request);

        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        model.addAllAttributes((Map<String, Object>) request.getSession().getAttribute(request.getRequestURI()));

        model.addAttribute("productStatus", productStatus);
        return "/business/stats/productsales";
    }

    @RequestMapping("/business/stats/productsales/exportExcel")
    public String productSalesExportExcel(HttpServletRequest request, HttpServletResponse response, Model model, String name, String status, String startDate, String endDate) {
        Map<String, Object> params = selectParamsEasyui(request);

        Map<String, Object> resultMap = resultList(request, params, "exportExcel");
        Page page = (Page) resultMap.get("page");
        List<Map<String, Object>> resList = (List<Map<String, Object>>) page.getList();
        Map<String, Object> totalMap = (Map<String, Object>) resultMap.get("totalMap");

        StringBuffer sta_title = new StringBuffer();
        sta_title.append("共 ").append(totalMap.get("TOTAL_COUNT") == null ? "0" : totalMap.get("TOTAL_COUNT").toString()).append("个产品，总出借金额：");
        sta_title.append(ThousandsHelper.formateThousands(totalMap.get("SUM_TENDER_AMOUNT"), true));
        sta_title.append("元，总出借笔数：");
        sta_title.append(totalMap.get("SUM_TENDER_USERS") == null ? "0" : totalMap.get("SUM_TENDER_USERS").toString());
        sta_title.append("笔");

        String sheeTTitle = "产品销售统计";
        String fileName = "产品销售统计" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, sta_title.toString(), pTitle, resList, null);
        return null;
    }

    @RequestMapping(value = {"/business/stats/productsales/query"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> productSalesQuery(HttpServletRequest request, String name, String status, String startDate, String endDate) {
        Map<String, Object> params = selectParamsEasyui(request);

        Map<String, Object> resultMap = resultList(request, params, "query");
        Page page = (Page) resultMap.get("page");
        Map<String, Object> totalMap = (Map<String, Object>) resultMap.get("totalMap");

        String totalAmount = ThousandsHelper.formateThousands(totalMap.get("SUM_TENDER_AMOUNT") == null ? "0.00" : totalMap.get("SUM_TENDER_AMOUNT").toString(), true);
        totalMap.put("SUM_TENDER_AMOUNT", totalAmount);
        totalMap.put("SUM_TENDER_USERS", totalMap.get("SUM_TENDER_USERS") == null ? "0" : totalMap.get("SUM_TENDER_USERS").toString());

        Map<String, Object> model = new HashMap<String, Object>();
        model.putAll(params);
        model.put("total", page.getTotalRow());
        model.put("rows", page.getList());
        model.put("totalMap", totalMap);

        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        request.getSession().setAttribute(request.getContextPath() + "/business/stats/productsales/list", params);

        return model;

    }

    private Map<String, Object> resultList(HttpServletRequest request, Map<String, Object> params, String type) {

        List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
        Map<String, Object> totalMap = statsService.findProductSalesTotalCount(params);

        // ///这里要这么修改/------这里是对当前页的记录
        Page page = null;
        if (new Integer(params.get("size").toString()).intValue() > 0) {
            if (params.get("page") != null && !request.getParameter("page").equals("1") && !request.getParameter("page").equalsIgnoreCase(params.get("page").toString())) {
                page = new Page(params.get("page").toString(), params.get("rows").toString(), ((BigDecimal) totalMap.get("TOTAL_COUNT")).intValue());
            } else {
                page = new Page(request, ((BigDecimal) totalMap.get("TOTAL_COUNT")).intValue());
            }
        } else {
            page = new Page(request, ((BigDecimal) totalMap.get("TOTAL_COUNT")).intValue());
        }

        if (type.equals("query")) {
            resList = statsService.findPageProductSales(params, page.getRowStart(), page.getRowEnd());
        } else if (type.equals("exportExcel")) {
            resList = statsService.findPageProductSales(params, 0, ((BigDecimal) totalMap.get("TOTAL_COUNT")).intValue());
        }

        for (Map<String, Object> map : resList) {
            String amount = "0";
            if ((BigDecimal) map.get("AMOUNT") != null) {
                amount = ((BigDecimal) map.get("AMOUNT")).divide(new BigDecimal(10000), 2, BigDecimal.ROUND_HALF_UP).toString();
            }
            if (amount.indexOf(".") > 0) {
                amount = amount.replaceAll("0+?$", "");// 去掉多余的0
                amount = amount.replaceAll("[.]$", "");// 如最后一位是.则去掉
            }
            if (map.get("ANNUAL_RATE") != null) {
                map.put("ANNUAL_RATE", map.get("ANNUAL_RATE").toString() + "%");
            }
            map.put("AMOUNT", amount + "万元");
            map.put("TENDER_AMOUNT", ThousandsHelper.formateThousands(map.get("TENDER_AMOUNT"), true));
            map.put("TRANST", ThousandsHelper.formateThousands(map.get("TRANST"), true));
            map.put("TRANSB", ThousandsHelper.formateThousands(map.get("TRANSB"), true));
            if (type.equals("exportExcel")) {
                map.put("CATEGORY", CodeHelper.getValueByCode("product.category", map.get("CATEGORY") == null ? "" : map.get("CATEGORY").toString()));
                map.put("STATUS", CodeHelper.getValueByCode("product.status", map.get("STATUS") == null ? "" : map.get("STATUS").toString()));
                map.put("REPAY_TYPE", CodeHelper.getValueByCode("product.repayType", map.get("REPAY_TYPE") == null ? "" : map.get("REPAY_TYPE").toString()));
            }
        }

        page.setList(resList);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("page", page);
        resultMap.put("totalMap", totalMap);
        return resultMap;
    }

}
