package com.itech.ups.app.business.insurance.action;

import com.itech.core.util.CodeHelper;
import com.itech.core.util.DateHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.insurance.application.service.InsuranceService;
import com.itech.ups.app.business.stats.action.common.Page;
import com.itech.ups.app.components.filesync.MoreSystemFileSynchronizer;
import com.itech.ups.app.insurance.application.domain.ProductInsurance;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author  daishuli  2015-09-07
 */
@Controller
public class InsuranceShelfList extends AbstractActionParent {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private MoreSystemFileSynchronizer moreSystemFileSynce;

    // 新增图片服务器访问地址
    @Value("${product.pictureServerURL}")
    private String pictureServerURL;

    @RequestMapping("/business/insurance/frame/list")
    public String list() {
        return "/business/insurance/shelf/list";
    }

    @RequestMapping(value = "/business/insurance/frame/query", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> query(HttpServletRequest request, String name, String companyName, String upperAndLowerFrame) {
        final Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> model = new HashMap<String, Object>();
        params.put("companyName", StringHelper.isNotEmpty(companyName) == true ? companyName : null);
        params.put("upperAndLowerFrame", StringHelper.isNotEmpty(upperAndLowerFrame) == true ? upperAndLowerFrame : null);
        params.put("name", StringHelper.isNotEmpty(name) == true ? name : null);
        params.put("isShelf", "isShelf");
        Page page = new Page(request, insuranceService.findInsuranceProductsTotalCount(params).intValue());
        List<Map<String, Object>> resultList = insuranceService.findInsuranceProducts(params, page.getRowStart(), page.getRowEnd());

        if (resultList != null && resultList.size() > 0) {
            for (Map<String, Object> fmap : resultList) {
                fmap.put("AUDITSTATUS", CodeHelper.getValueByCode("fund.auditStatus", fmap.get("AUDIT_STATUS").toString()));
                fmap.put("COMPANYNAME", CodeHelper.getValueByCode("insurance.companyName", fmap.get("COMPANY_NAME").toString()));
                if (fmap.get("UPPER_AND_LOWER_FRAME").toString().equals("yesShelf")) {
                    fmap.put("OPERATION", "<a href='#' onclick=\"view(\'" + fmap.get("ID").toString() + "\')\";>预览</a> <a href='#' onclick=\"update(\'" + fmap.get("ID").toString() + "\')\";>修改</a>  <a href='#' onclick=\"submitAudit(\'" + fmap.get("ID").toString() + "\',\'" + fmap.get("UPPER_AND_LOWER_FRAME").toString() + "\')\";>下架</a>");
                } else if (fmap.get("UPPER_AND_LOWER_FRAME").toString().equals("noShelf")) {
                    fmap.put("OPERATION", "<a href='#' onclick=\"view(\'" + fmap.get("ID").toString() + "\')\";>预览</a> <a href='#' onclick=\"update(\'" + fmap.get("ID").toString() + "\')\";>修改</a>  <a href='#' onclick=\"submitAudit(\'" + fmap.get("ID").toString() + "\',\'" + fmap.get("UPPER_AND_LOWER_FRAME").toString() + "\')\";>上架</a>");
                }
                fmap.put("UPPER_AND_LOWER_FRAME", CodeHelper.getValueByCode("fund.shelfState", fmap.get("UPPER_AND_LOWER_FRAME").toString()));
            }
        }

        long noShelf = 0;
        long yesShelf = 0;
        List<Map<String, Object>> countList = insuranceService.findInsuranceProducts(params, page.getRowStart(), page.getTotalRow());
        for (Map<String, Object> count : countList) {
            String status = count.get("UPPER_AND_LOWER_FRAME").toString();
            if ("yesShelf".equals(status)) {
                yesShelf++;
            } else if ("noShelf".equals(status)) {
                noShelf++;
            }
        }

        page.setList(resultList);
        model.put("total", page.getTotalRow());
        model.put("rows", page.getList());
        model.put("noShelf", noShelf);
        model.put("yesShelf", yesShelf);
        return model;
    }

    @RequestMapping("/business/insurance/frame/submitAudit/{id}{istoshlef}")
    public String submitAudit(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        ProductInsurance productInsurance = insuranceService.findProductInsuranceById(id);
        if (productInsurance != null) {
            productInsurance.setEditorId(currentManager.getManager().getId());
            productInsurance.setEditorName(currentManager.getManager().getName());
            productInsurance.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
            if ("noShelf".equals(productInsurance.getUpperAndLowerFrame())) {
                productInsurance.setUpperAndLowerFrame("yesShelf");
                productInsurance.setUplowRemark("");
                insuranceService.editProductInsurance(productInsurance);
                return "/business/insurance/shelf/list";
            }
            model.addAttribute("productInsurance", productInsurance);
        }

        return "/business/insurance/shelf/shelf";
    }

    @RequestMapping("/business/insurance/frame/submitAudit")
    public String submitAudit(HttpServletRequest request, String id, String upperAndLowerFrame, String description) {
        ProductInsurance productInsurance = insuranceService.findProductInsuranceById(id);
        productInsurance.setUpperAndLowerFrame(upperAndLowerFrame);
        productInsurance.setUplowRemark(description);
        insuranceService.editProductInsurance(productInsurance);
        return "/business/insurance/shelf/list";
    }

    @RequestMapping("/business/insurance/frame/update/{id}")
    public String update(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        ProductInsurance productInsurance = insuranceService.findProductInsuranceById(id);
        model.addAttribute("productInsurance", productInsurance);
        model.addAttribute("pictureServerURL", pictureServerURL);
        return "/business/insurance/shelf/update";
    }

    @RequestMapping("/business/insurance/frame/updatesave")
    public String updatesave(HttpServletRequest request, ProductInsurance productInsurance, MultipartHttpServletRequest files) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        ProductInsurance oldProductInsurance = insuranceService.findProductInsuranceById(productInsurance.getId());
        if (oldProductInsurance != null) {
            oldProductInsurance.setName(productInsurance.getName());
            oldProductInsurance.setRecommendations(productInsurance.getRecommendations());
            oldProductInsurance.setCompanyName(productInsurance.getCompanyName());
            oldProductInsurance.setCategory(productInsurance.getCategory());
            oldProductInsurance.setInsuranceCoverage(productInsurance.getInsuranceCoverage());
            oldProductInsurance.setTimeLimit(productInsurance.getTimeLimit());
            oldProductInsurance.setPayType(productInsurance.getPayType());
            oldProductInsurance.setEditorId(currentManager.getManager().getId());
            oldProductInsurance.setEditorName(currentManager.getManager().getName());
            oldProductInsurance.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
            oldProductInsurance.setAuditStatus("pendingAudit");
            oldProductInsurance.setUplowRemark("");
            oldProductInsurance.setUpperAndLowerFrame("noShelf");
            insuranceService.editProductInsurance(oldProductInsurance);
        }
        return "/business/insurance/shelf/list";
    }

    @RequestMapping("/business/insurance/frame/view/{id}")
    public String view(HttpServletRequest request, Model model, @PathVariable("id") String id) {
        ProductInsurance productInsurance = insuranceService.findProductInsuranceById(id);
        model.addAttribute("productInsurance", productInsurance);
        model.addAttribute("pictureServerURL", pictureServerURL);
        return "/business/insurance/shelf/view";
    }
}