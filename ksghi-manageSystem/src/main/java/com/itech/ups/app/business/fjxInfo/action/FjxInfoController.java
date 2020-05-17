package com.itech.ups.app.business.fjxInfo.action;

import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.fjxInfo.application.service.FjxInfoService;
import com.itech.ups.app.business.xqyzy.application.service.XqyzyService;
import com.itech.ups.app.fjxinfo.application.domain.FjxInfo;
import com.itech.ups.app.xqyinfo.application.domain.XqyInfo;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.apache.log4j.Logger;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class FjxInfoController extends AbstractActionParent {
    private final Logger logger = Logger.getLogger(FjxInfoController.class);
    @Autowired
    private FjxInfoService service;
    @Autowired
    private XqyzyService xqyService;

    private String[] pTitle = {"投保单号:tbdh:15:center", "投保日期:tbrq:15:center", "投保人:tbr:22:center", "手机号码:tbrlxdh:15:left", "被保人:bbr:22:center", "手机号码:bbrlxdh:22:center", "关系:tbrgx:15:center", "保险公司:bxgs:20:center", "险种名称:xzmc:15:center", "缴费方式:jffs:15:center", "缴费年期:jfnq:15:center", "保险期间:bxqj:15:center", "保险金额:bxje:15:center", "实缴保费:sjbf:15:center", "业务员:ywy:15:center", "业务员编号:ywybh:15:center", "状态:cbshzt:15:center"};

    @RequestMapping(value = {"/business/xqyzy/fjxInfo/toAdds"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String toAdds(Model model, @RequestParam(value = "xqyId", required = true) String xqyId) {
        if (xqyId != null) {
            List<FjxInfo> fjxInfo = service.findFjxInfosByXqyId(xqyId);
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/fjxInfo/add";
    }

    @RequestMapping(value = {"/business/xqyzy/fjxInfo/delete"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String delete(@RequestParam("id") String id, @RequestParam("xqyId") String xqyId) {
        FjxInfo fjxInfo = new FjxInfo();
        fjxInfo.setId(id);
        try {
            service.deleteFjxInfo(fjxInfo);
        } catch (Exception e) {
            logger.error("/business/xqyzy/fjxInfo/delete! id:" + id, e);
        }
        return "redirect:/business/xqyzy/fjxInfo/toAdds?xqyId=" + xqyId;
    }

    @RequestMapping(value = {"/business/xqyzy/fjxInfo/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String toAdd(Model model, @RequestParam(value = "id", required = false) String id) {
        if (id != null) {
            FjxInfo fjxInfo = service.findFjxInfoById(id);
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/fjxInfo/add";
    }

    @RequestMapping(value = {"/business/xqyzy/fjxInfo/view"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String view(Model model, @RequestParam(value = "id", required = false) String id) {
        FjxInfo fjxInfo = service.findFjxInfoById(id);
        model.addAttribute("fjxInfo", fjxInfo);
        return "business/xqyzy/fjxInfo/view";
    }

    @RequestMapping(value = {"/business/xqyzy/fjxInfo/query"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String queryFjxInfolList(Model model, HttpServletRequest request) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return service.findFjxInfo(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) service.findFjxInfoCount(params);
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

        return "business/xqyzy/fjxInfo/list";
    }

    @RequestMapping("/business/xqyzy/fjxInfo/save")
    public String save(HttpServletRequest request, FjxInfoData fjxInfoList) throws Exception {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        //计算保费合计
        BigDecimal fjxSjbf = new BigDecimal(0);
        if (fjxInfoList != null && fjxInfoList.getXqyId() != null) {
            for (int j = 0; j < fjxInfoList.getXqyId().split(",").length; j++) {
                FjxInfo fjxInfo = new FjxInfo();
                fjxInfo.setBxgs(fjxInfoList.getBxgs().split(",")[j]);
                fjxInfo.setBxje(fjxInfoList.getBxje().toString().split(",")[j]);
                fjxInfo.setBxqj(fjxInfoList.getBxqj().split(",")[j]);
                fjxInfo.setId(fjxInfoList.getId().split(",")[j]);
                fjxInfo.setJffs(fjxInfoList.getJffs().split(",")[j]);
                fjxInfo.setJfnq(fjxInfoList.getJfnq().split(",")[j]);
                fjxInfo.setSjbf(new BigDecimal(fjxInfoList.getSjbf().toString().split(",")[j]));
                fjxInfo.setXqyId(fjxInfoList.getXqyId().split(",")[j]);
                fjxInfo.setXzdm(fjxInfoList.getXzdm().split(",")[j]);
                fjxInfo.setXzmc(fjxInfoList.getXzmc().split(",")[j]);
                fjxInfo.setSjxj(new BigDecimal(fjxInfoList.getSjxj().toString().split(",")[j]));
                if (StringHelper.isNotBlank(fjxInfo.getXqyId())) {
                    if (StringHelper.isNotBlank(fjxInfo.getId())) {
                        fjxInfo.setZfx("附加险");
                        fjxInfo = service.editFjxInfo(fjxInfo);
                    } else {
                        fjxInfo.setZfx("附加险");
                        fjxInfo = service.addFjxInfo(fjxInfo);
                    }
                    saveBusinessLog("附加险录入", "附加险录入", fjxInfo, request);
                }
                fjxSjbf = fjxSjbf.add(fjxInfo.getSjbf());
            }

            XqyInfo xqyInfo = xqyService.findXqyInfoById(fjxInfoList.getXqyId().split(",")[0]);
            xqyInfo.setBfhj(xqyInfo.getSjbf().add(fjxSjbf));
            xqyService.editXqyInfo(xqyInfo);
        }
        return "redirect:/business/xqyzy/query?cxmk=ysbd";
    }

    @RequestMapping(value = {"/business/xqyzy/fjxInfo/updateStatusById"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String updateStatusById(@RequestParam("id") String id, @RequestParam("status") String status) {

        try {
            FjxInfo fjxInfo = new FjxInfo();
            fjxInfo.setId(id);
            service.editFjxInfo(fjxInfo);
        } catch (Exception e) {
            logger.error("/business/xqyzy/fjxInfo/updateStatusById error! id:" + id, e);
        }
        return "redirect:/business/xqyzy/fjxInfo/query";
    }

}
