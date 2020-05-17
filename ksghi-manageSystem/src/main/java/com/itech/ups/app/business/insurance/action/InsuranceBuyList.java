package com.itech.ups.app.business.insurance.action;

import com.itech.core.util.CodeHelper;
import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.insurance.application.service.InsuranceService;
import com.itech.ups.app.business.stats.action.common.Page;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author  daishuli  2015-09-08
 */
@Controller
public class InsuranceBuyList extends AbstractActionParent {

    @Autowired
    private InsuranceService insuranceService;

    // 新增图片服务器访问地址
    @Value("${product.pictureServerURL}")
    private String pictureServerURL;

    private String[] pTitle = {"合同编号:CONTRACT_CODE:20:center", "保险产品名称:INSURANCE_NAME:30:center", "保险公司:COMPANY_NAME:30:center", "保险类型:CATEGORY:30:center", "用户昵称:NIKE_NAME:30:center", "客户姓名:CUSTOMER_NAME:20:center", "投保人手机号:CUSTOMER_PHONE:20:center", "交费方式:PAY_WAY:20:center", "已交保费:PAID_PREMIUM:20:center", "投保日期:INSURANCE_DATE:20:center", "最近交费日期:RECENT_PAYMENT_DATE:20:center", "合同生效日期:RECENTLY_PAY_DATE:20:center", "合同失效日期:CONTRACT_EFFECTIVE_DATE:20:center", "保单状态:INSURANCE_STATUS:10:center", "保单状态说明:INSURANCE_REMARK:50:center"};

    @RequestMapping("/business/insurance/buy/view")
    public String exportExcel(HttpServletRequest request, HttpServletResponse response, Model model, String contractAttachments) {
        model.addAttribute("contractAttachmentsPath", pictureServerURL + contractAttachments);
        return "/business/insurance/buy/view";
    }

    @RequestMapping("/business/insurance/buy/exportexcel")
    public String exportExcel(HttpServletRequest request, HttpServletResponse response, Model model, String companyName, String insuranceName, String upperAndLowerFrame, String customerName, String customerPhone, String insuranceStatus) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("companyName", StringHelper.isNotEmpty(companyName) == true ? companyName : null);
        params.put("insuranceName", StringHelper.isNotEmpty(insuranceName) == true ? insuranceName : null);
        params.put("upperAndLowerFrame", StringHelper.isNotEmpty(upperAndLowerFrame) == true ? upperAndLowerFrame : null);
        params.put("customerName", StringHelper.isNotEmpty(customerName) == true ? customerName : null);
        params.put("customerPhone", StringHelper.isNotEmpty(customerPhone) == true ? customerPhone : null);
        params.put("insuranceStatus", StringHelper.isNotEmpty(insuranceStatus) == true ? insuranceStatus : null);

        Page page = new Page(request, insuranceService.findInsuranceSalesDetailsTotalCount(params).intValue());
        List<Map<String, Object>> resultList = insuranceService.findInsuranceSalesDetails(params, page.getRowStart(), page.getTotalRow());
        for (Map<String, Object> fmap : resultList) {
            fmap.put("COMPANY_NAME", CodeHelper.getValueByCode("insurance.companyName", fmap.get("COMPANY_NAME").toString()));
            fmap.put("INSURANCE_STATUS", CodeHelper.getValueByCode("insurance.insuranceStatus", fmap.get("INSURANCE_STATUS").toString()));
        }

        StringBuffer sta_title = new StringBuffer();
        sta_title.append("统计：共 ").append(page.getTotalRow()).append("条记录");
        String sheeTTitle = "保险产品购买明细";
        String fileName = "保险产品购买明细" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, sta_title.toString(), pTitle, resultList, null);
        return null;
    }

    @RequestMapping("/business/insurance/buy/list")
    public String list() {
        return "/business/insurance/buy/list";
    }

    @RequestMapping(value = "/business/insurance/buy/query", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> query(HttpServletRequest request, String companyName, String insuranceName, String upperAndLowerFrame, String customerName, String customerPhone, String insuranceStatus) {
        final Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> model = new HashMap<String, Object>();

        params.put("companyName", StringHelper.isNotEmpty(companyName) == true ? companyName : null);
        params.put("insuranceName", StringHelper.isNotEmpty(insuranceName) == true ? insuranceName : null);
        params.put("upperAndLowerFrame", StringHelper.isNotEmpty(upperAndLowerFrame) == true ? upperAndLowerFrame : null);
        params.put("customerName", StringHelper.isNotEmpty(customerName) == true ? customerName : null);
        params.put("customerPhone", StringHelper.isNotEmpty(customerPhone) == true ? customerPhone : null);
        params.put("insuranceStatus", StringHelper.isNotEmpty(insuranceStatus) == true ? insuranceStatus : null);

        Page page = new Page(request, insuranceService.findInsuranceSalesDetailsTotalCount(params).intValue());
        List<Map<String, Object>> resultList = insuranceService.findInsuranceSalesDetails(params, page.getRowStart(), page.getRowEnd());
        if (resultList != null && resultList.size() > 0) {
            for (Map<String, Object> fmap : resultList) {
                fmap.put("COMPANYNAME", CodeHelper.getValueByCode("insurance.companyName", fmap.get("COMPANY_NAME").toString()));
                fmap.put("INSURANCE_STATUS", CodeHelper.getValueByCode("insurance.insuranceStatus", fmap.get("INSURANCE_STATUS").toString()));
                fmap.put("OPERATION", "<a href='#' onclick=\"view(\'" + fmap.get("CONTRACT_ATTACHMENTS").toString() + "\')\";>合同范本</a>");
            }
        }

        Map<String, Object> customerAndInsuranceCount = insuranceService.findInsuranceSalesDetailForCustomerAndInsuranceTotalCount(params);
        if (customerAndInsuranceCount != null) {
            model.put("insuranceNum", customerAndInsuranceCount.get("INSURANCENUM"));
            model.put("customerNum", customerAndInsuranceCount.get("CUSTOMERNUM"));
        } else {
            model.put("insuranceNum", 0);
            model.put("customerNum", 0);
        }
        page.setList(resultList);
        model.put("total", page.getTotalRow());
        model.put("rows", page.getList());
        return model;
    }
}