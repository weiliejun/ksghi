package com.itech.ups.app.business.insurance.action;

import com.itech.core.util.CodeHelper;
import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.insurance.application.service.InsuranceService;
import com.itech.ups.app.business.stats.action.common.Page;
import com.itech.ups.app.insurance.application.domain.InsuranceBooking;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/*
 * @author  daishuli  2015-09-07
 */
@Controller
public class InsuranceBookingList extends AbstractActionParent {

    @Autowired
    private InsuranceService insuranceService;

    private String[] pTitle = {"预约编号:CODE:25:center", "预约时间 :CREATE_TIME:25:center", "用户昵称:NIKE_NAME:20:center", "客户姓名:CUSTOMER_NAME:20:center", "注册手机号 :MOBILE:20:center", "身份证号:ID_NO:20:center", "保险产品名称:PRODUCT_NAME:50:center", "保险公司:COMPANY_NAME:50:center", "保险类型:CATEGORY:20:center", "投保范围:INSURANCE_COVERAGE:20:center", "交费方式 :PAY_TYPE:20:center", "预约状态 :STATUS:30:center", "推荐人姓名:USER_NAME:20:center", "预约状态说明:STATUS_REMARK:20:center"};

    @RequestMapping("/business/insurance/order/editStatus/{id}")
    public String edit(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        Map<String, Object> insuranceBooking = insuranceService.findInsuranceBookingForIdNoById(id);
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Properties prop = new Properties();
        InputStream is = InsuranceBookingList.class.getResourceAsStream("/config/customerServiceStaff.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String cno_pwd = prop.getProperty(currentManager.getManager().getCode());
        String reqUrl = "http://api.clink.cn/interface/PreviewOutcall?enterpriseId=3001162";
        reqUrl += cno_pwd;
        reqUrl += "&customerNumber=" + insuranceBooking.get("CUSTOMER_PHONE");
        model.addAttribute("reqUrl", reqUrl);
        model.addAttribute("insuranceBooking", insuranceBooking);
        return "/business/insurance/booking/edit";
    }

    @RequestMapping("/business/insurance/order/editsel/{ids}")
    public String editSel(HttpServletRequest request, Model model, @PathVariable("ids") String ids) {
        if (StringHelper.isNotBlank(ids)) {
            // ids = ids.substring(1, ids.length());
            String[] splitId = ids.split(",");
            model.addAttribute("selNum", splitId.length);
        }

        model.addAttribute("ids", ids);
        return "/business/insurance/booking/editSel";
    }

    @RequestMapping("/business/insurance/order/exportexcel")
    public String exportExcel(HttpServletRequest request, HttpServletResponse response, Model model, String companyName, String insuranceName, String upperAndLowerFrame, String customerName, String customerPhone, String dateRange) {
        Map<String, Object> params = new HashMap<String, Object>();
        String startDate = null;
        String endDate = null;
        if (StringHelper.isNotBlank(dateRange)) {
            startDate = dateRange.substring(0, 10);
            endDate = dateRange.substring(13, 23);
        }

        params.put("companyName", StringHelper.isNotEmpty(companyName) == true ? companyName : null);
        params.put("insuranceName", StringHelper.isNotEmpty(insuranceName) == true ? insuranceName : null);
        params.put("upperAndLowerFrame", StringHelper.isNotEmpty(upperAndLowerFrame) == true ? upperAndLowerFrame : null);
        params.put("customerName", StringHelper.isNotEmpty(customerName) == true ? customerName : null);
        params.put("customerPhone", StringHelper.isNotEmpty(customerPhone) == true ? customerPhone : null);
        params.put("startDate", StringHelper.isNotEmpty(startDate) == true ? startDate : null);
        params.put("endDate", StringHelper.isNotEmpty(endDate) == true ? endDate : null);

        Page page = new Page(request, insuranceService.findInsuranceBookingsTotalCount(params).intValue());
        List<Map<String, Object>> resultList = insuranceService.findInsuranceBookings(params, page.getRowStart(), page.getTotalRow());
        for (Map<String, Object> fmap : resultList) {
            fmap.put("COMPANY_NAME", CodeHelper.getValueByCode("insurance.companyName", fmap.get("COMPANY_NAME").toString()));
            fmap.put("STATUS", CodeHelper.getValueByCode("insurance.status", fmap.get("STATUS").toString()));
        }
        StringBuffer sta_title = new StringBuffer();
        sta_title.append("统计：共 ").append(page.getTotalRow()).append("条记录");
        String sheeTTitle = "保险产品预约记录";
        String fileName = "保险产品预约记录" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, sta_title.toString(), pTitle, resultList, null);
        return null;
    }

    @RequestMapping("/business/insurance/order/save")
    public String save(HttpServletRequest request, String id, String status, String userName, String statusRemark) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        InsuranceBooking insuranceBooking = insuranceService.findInsuranceBookingById(id);
        if (insuranceBooking != null) {
            insuranceBooking.setStatus(status);
            insuranceBooking.setUserName(userName);
            insuranceBooking.setStatusRemark(statusRemark);
            insuranceBooking.setEditorId(currentManager.getManager().getId());
            insuranceBooking.setEditorName(currentManager.getManager().getName());
            insuranceBooking.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()).toString());
            insuranceService.editInsuranceBooking(insuranceBooking);
        }

        return "redirect:/business/insurance/order/list";
    }

    @RequestMapping("/business/insurance/order/savesel")
    public String saveSel(HttpServletRequest request, String ids, String status, String userName, String statusRemark) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        if (StringHelper.isNotBlank(ids)) {
            String[] splitId = ids.split(",");
            for (String id : splitId) {
                InsuranceBooking insuranceBooking = insuranceService.findInsuranceBookingById(id);
                if (insuranceBooking != null) {
                    insuranceBooking.setStatus(status);
                    insuranceBooking.setUserName(userName);
                    insuranceBooking.setStatusRemark(statusRemark);
                    insuranceBooking.setEditorId(currentManager.getManager().getId());
                    insuranceBooking.setEditorName(currentManager.getManager().getName());
                    insuranceBooking.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()).toString());
                    insuranceService.editInsuranceBooking(insuranceBooking);
                }
            }
        }

        return "redirect:/business/insurance/order/list";
    }

    @RequestMapping("/business/insurance/order/list")
    public String userList(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return insuranceService.findInsuranceBookings(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) insuranceService.findInsuranceBookingsTotalCount(params);
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

        /*
         * final Map<String, Object> params = new HashMap<String, Object>();
         * String startDate = null; String endDate = null; if
         * (StringHelper.isNotBlank(dateRange)) { startDate =
         * dateRange.substring(0, 10); endDate = dateRange.substring(13, 23); }
         * params.put("companyName", StringHelper.isNotEmpty(companyName) ==
         * true ? companyName : null); params.put("insuranceName",
         * StringHelper.isNotEmpty(insuranceName) == true ? insuranceName :
         * null); params.put("upperAndLowerFrame",
         * StringHelper.isNotEmpty(upperAndLowerFrame) == true ?
         * upperAndLowerFrame : null); params.put("customerName",
         * StringHelper.isNotEmpty(customerName) == true ? customerName : null);
         * params.put("customerPhone", StringHelper.isNotEmpty(customerPhone) ==
         * true ? customerPhone : null); params.put("startDate",
         * StringHelper.isNotEmpty(startDate) == true ? startDate : null);
         * params.put("endDate", StringHelper.isNotEmpty(endDate) == true ?
         * endDate : null);
         *
         * Collection<?> items = TableModelUtils.getItems("grid", "restore",
         * request, new PageItems() { public int getTotalRows(Limit limit) {
         * return (int)
         * insuranceService.findInsuranceBookingsTotalCount(params).intValue();
         * } public Collection<?> getItems(Limit limit) { return
         * insuranceService.findInsuranceBookings(params,
         * limit.getRowSelect().getRowStart(),
         * limit.getRowSelect().getRowEnd()); } });
         *
         *
         * model.addAttribute("companyName", companyName);
         * model.addAttribute("insuranceName", insuranceName);
         * model.addAttribute("upperAndLowerFrame", upperAndLowerFrame);
         * model.addAttribute("customerName", customerName);
         * model.addAttribute("customerPhone", customerPhone);
         * model.addAttribute("dateRange", dateRange);
         * model.addAttribute("results", items);
         */
        Map<String, Object> bookingCount = insuranceService.findInsuranceBookingForBookingTotalCount();
        model.addAttribute("today", bookingCount.get("TODAY"));
        model.addAttribute("yesterday", bookingCount.get("YESTERDAY"));
        model.addAttribute("total", insuranceService.findInsuranceBookingsTotalCount(params).intValue());
        return "/business/insurance/booking/list";
    }
}