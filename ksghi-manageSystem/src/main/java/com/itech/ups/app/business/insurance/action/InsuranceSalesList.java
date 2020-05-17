package com.itech.ups.app.business.insurance.action;

import com.itech.core.excel.domain.FileExcel;
import com.itech.core.util.CodeHelper;
import com.itech.core.util.DateHelper;
import com.itech.core.util.EncodeType;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.insurance.application.service.InsuranceService;
import com.itech.ups.app.business.stats.action.common.Page;
import com.itech.ups.app.insurance.application.domain.InsuranceSalesRecord;
import com.itech.ups.app.insurance.application.domain.InsuranceSalesRecordDynamicData;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.util.FileContentTypeHelper;
import com.itech.ups.base.web.action.AbstractActionParent;
import com.itech.ups.base.web.bean.FileTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.*;

/*
 * @author  daishuli  2015-09-08
 */
@Controller
public class InsuranceSalesList extends AbstractActionParent {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping("/business/insurance/sale/view/{productId}")
    public String detail(Model model, HttpServletRequest request, @PathVariable("productId") String productId) {
        model.addAttribute("productId", productId);
        return "/business/insurance/salemanager/detail";
    }

    @RequestMapping("/business/insurance/sale/downloadtemp")
    public void download(HttpServletRequest request, HttpServletResponse response, Model model) {
        FileTemp temp = new FileTemp();
        temp.setFilename("InsuranceProductSaleRecord.xlsx");
        temp.setFileurl(request.getSession().getServletContext().getRealPath("//WEB-INF//classes//config//template//InsuranceProductSaleRecord.xlsx"));
        temp.setFiletype(FileContentTypeHelper.getContentType("xlsx"));
        try {
            int len;
            String filePath = temp.getFileurl();
            if (temp.getSubmittype() != null) {
                filePath = URLDecoder.decode(filePath, EncodeType.UTF.toString());
            }
            InputStream inStream = new FileInputStream(filePath);

            response.reset();
            response.setContentType(temp.getFiletype());
            response.setHeader("Content-Disposition", "attachment; filename=" + CodeHelper.encodeString(temp.getFilename(), EncodeType.UTF));

            byte[] b = new byte[1024];

            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/business/insurance/sale/importdata")
    public String importData() {
        return "/business/insurance/salemanager/importData";
    }

    @RequestMapping("/business/insurance/sale/list")
    public String list() {
        return "/business/insurance/salemanager/list";
    }

    @RequestMapping(value = "/business/insurance/sale/detail/query", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> query(HttpServletRequest request, String productId) {
        final Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> model = new HashMap<String, Object>();
        params.put("productId", StringHelper.isNotEmpty(productId) == true ? productId : null);

        Page page = new Page(request, insuranceService.findInsuranceSalesDetailsTotalCount(params).intValue());
        List<Map<String, Object>> resultList = insuranceService.findInsuranceSalesDetails(params, page.getRowStart(), page.getRowEnd());
        if (resultList != null && resultList.size() > 0) {
            for (Map<String, Object> fmap : resultList) {
                fmap.put("INSURANCE_STATUS", CodeHelper.getValueByCode("insurance.insuranceStatus", fmap.get("INSURANCE_STATUS").toString()));
                fmap.put("COMPANYNAME", CodeHelper.getValueByCode("insurance.companyName", fmap.get("COMPANY_NAME").toString()));
            }
        }

        page.setList(resultList);
        model.put("total", page.getTotalRow());
        model.put("rows", page.getList());
        return model;
    }

    @RequestMapping(value = "/business/insurance/sale/query", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> query(HttpServletRequest request, String name, String upperAndLowerFrame, String companyName) {
        final Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> model = new HashMap<String, Object>();
        params.put("companyName", StringHelper.isNotEmpty(companyName) == true ? companyName : null);
        params.put("upperAndLowerFrame", StringHelper.isNotEmpty(upperAndLowerFrame) == true ? upperAndLowerFrame : null);
        params.put("name", StringHelper.isNotEmpty(name) == true ? name : null);
        Page page = new Page(request, insuranceService.findInsuranceProductsForSaleTotalCount(params).intValue());
        List<Map<String, Object>> resultList = insuranceService.findInsuranceProductsForSale(params, page.getRowStart(), page.getRowEnd());
        long purchaseNum = 0;
        if (resultList != null && resultList.size() > 0) {
            for (Map<String, Object> fmap : resultList) {
                fmap.put("COMPANYNAME", CodeHelper.getValueByCode("insurance.companyName", fmap.get("COMPANY_NAME").toString()));
                fmap.put("OPERATION", "<a href='#' onclick=\"view(\'" + fmap.get("PRODUCT_ID").toString() + "\')\";>查看购买明细</a>");
                BigDecimal purchase = (BigDecimal) fmap.get("BUY_COUNT");
                purchaseNum = purchaseNum + purchase.longValue();
                fmap.put("UPPER_AND_LOWER_FRAME", CodeHelper.getValueByCode("fund.shelfState", fmap.get("UPPER_AND_LOWER_FRAME").toString()));
            }
        }
        page.setList(resultList);

        // 下载模板相关信息
        FileTemp temp = new FileTemp();
        temp.setFilename("InsuranceProductSaleRecord.xlsx");
        temp.setFileurl(request.getSession().getServletContext().getRealPath("//WEB-INF//classes//config//template//InsuranceProductSaleRecord.xlsx"));
        temp.setFiletype(FileContentTypeHelper.getContentType("xlsx"));
        model.put("temp", temp);
        model.put("total", page.getTotalRow());
        model.put("purchaseNum", purchaseNum);
        model.put("rows", page.getList());
        return model;
    }

    @RequestMapping("/business/insurance/sale/savedata")
    public String saveData(Model model, HttpServletRequest request, boolean flag) throws Exception {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        MultipartHttpServletRequest files = (MultipartHttpServletRequest) request;
        Iterator<String> it = files.getFileNames();

        while (it.hasNext()) {
            MultipartFile mfile = files.getFile(it.next());
            if (mfile != null && !mfile.isEmpty()) {
                FileExcel excel = new FileExcel();
                List<Object> data = null;
                String fileName = mfile.getOriginalFilename();
                // 读取数据，返回实体
                if (fileName.substring(fileName.length() - 4, fileName.length()).equals("xlsx")) {
                    data = excel.readEXCEL2007(mfile.getInputStream(), (new InsuranceSalesRecordDynamicData()).getClass());
                } else {
                    data = excel.readEXCEL2003(mfile.getInputStream(), (new InsuranceSalesRecordDynamicData()).getClass());
                }

                // if
                // (mfile.getContentType().equals(FileContentTypeHelper.getContentType("xlsx")))
                // {
                // data = excel.readEXCEL2007(mfile.getInputStream(), (new
                // InsuranceSalesRecordDynamicData()).getClass());
                // } else {
                // data = excel.readEXCEL2003(mfile.getInputStream(), (new
                // InsuranceSalesRecordDynamicData()).getClass());
                // }

                for (int i = 0; i < data.size(); i++) {
                    InsuranceSalesRecordDynamicData insuranceSalesRecordDynamicData = (InsuranceSalesRecordDynamicData) data.get(i);

                    InsuranceSalesRecord insuranceSalesRecord = new InsuranceSalesRecord();

                    if (insuranceSalesRecordDynamicData != null) {
                        List<Map<String, Object>> productInsuranceList = insuranceService.findProductInsuranceByCode(insuranceSalesRecordDynamicData.getCode());
                        if (productInsuranceList != null && productInsuranceList.size() == 1) {
                            String productId = productInsuranceList.get(0).get("ID").toString();
                            InsuranceSalesRecord existInsuranceSalesRecord = insuranceService.findInsuranceSalesRecordByProductId(productId);
                            if (existInsuranceSalesRecord != null) {
                                existInsuranceSalesRecord.setProductName(insuranceSalesRecordDynamicData.getProductName());
                                existInsuranceSalesRecord.setCompanyName(productInsuranceList.get(0).get("COMPANY_NAME").toString());
                                existInsuranceSalesRecord.setCategory(insuranceSalesRecordDynamicData.getCategory());
                                existInsuranceSalesRecord.setInsuranceCoverage(insuranceSalesRecordDynamicData.getInsuranceCoverage());
                                existInsuranceSalesRecord.setTimeLimit(insuranceSalesRecordDynamicData.getTimeLimit());
                                existInsuranceSalesRecord.setPayType(insuranceSalesRecordDynamicData.getPayType());
                                existInsuranceSalesRecord.setUpperAndLowerFrame(productInsuranceList.get(0).get("UPPER_AND_LOWER_FRAME").toString());
                                existInsuranceSalesRecord.setBuyCount(insuranceSalesRecordDynamicData.getBuyCount());
                                existInsuranceSalesRecord.setEditorId(currentManager.getManager().getId());
                                existInsuranceSalesRecord.setEditorName(currentManager.getManager().getName());
                                existInsuranceSalesRecord.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
                                insuranceService.editInsuranceSalesRecord(existInsuranceSalesRecord);
                            } else {
                                insuranceSalesRecord.setProductId(productInsuranceList.get(0).get("ID").toString());
                                insuranceSalesRecord.setProductName(insuranceSalesRecordDynamicData.getProductName());
                                insuranceSalesRecord.setCompanyName(productInsuranceList.get(0).get("COMPANY_NAME").toString());
                                insuranceSalesRecord.setCategory(insuranceSalesRecordDynamicData.getCategory());
                                insuranceSalesRecord.setInsuranceCoverage(insuranceSalesRecordDynamicData.getInsuranceCoverage());
                                insuranceSalesRecord.setTimeLimit(insuranceSalesRecordDynamicData.getTimeLimit());
                                insuranceSalesRecord.setPayType(insuranceSalesRecordDynamicData.getPayType());
                                insuranceSalesRecord.setUpperAndLowerFrame(productInsuranceList.get(0).get("UPPER_AND_LOWER_FRAME").toString());
                                insuranceSalesRecord.setBuyCount(insuranceSalesRecordDynamicData.getBuyCount());

                                insuranceSalesRecord.setCreatorId(currentManager.getManager().getId());
                                insuranceSalesRecord.setCreatorName(currentManager.getManager().getName());
                                insuranceSalesRecord.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
                                insuranceSalesRecord.setEditorId(currentManager.getManager().getId());
                                insuranceSalesRecord.setEditorName(currentManager.getManager().getName());
                                insuranceSalesRecord.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
                                insuranceSalesRecord.setDataStatus("valid");
                                insuranceService.addInsuranceSalesRecord(insuranceSalesRecord);
                            }
                        }
                    }
                }
            }
        }
        return "redirect:/business/insurance/sale/list";
    }
}