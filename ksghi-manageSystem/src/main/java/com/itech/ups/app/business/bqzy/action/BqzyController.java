package com.itech.ups.app.business.bqzy.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.bqinfo.application.domain.BqInfo;
import com.itech.ups.app.business.bqzy.application.service.BqzyService;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class BqzyController extends AbstractActionParent {
    private final Logger logger = Logger.getLogger(BqzyController.class);
    @Autowired
    private BqzyService service;
    @Autowired
    private XqyzyService xqyService;
    @Autowired
    private FjxInfoService fjxInfoService;

    private String[] pTitle = {"投保单号:tbdh:15:center", "投保日期:tbrq:15:center", "投保人:tbr:22:center", "手机号码:tbrlxdh:15:left", "被保人:bbr:22:center", "手机号码:bbrlxdh:22:center", "关系:tbrgx:15:center", "保险公司:bxgs:20:center", "险种名称:xzmc:15:center", "缴费方式:jffs:15:center", "缴费年期:jfnq:15:center", "保险期间:bxqj:15:center", "保险金额:bxje:15:center", "实缴保费:sjbf:15:center", "代理公司:dlgs:15:center", "部门（机构）:dept:15:center", "业务员:ywy:15:center", "业务员编号:ywybh:15:center", "承保日期:cbrq:15:center", "保全申请状态:bqshzt:15:center"};

    @RequestMapping(value = {"/business/bqzy/bqsq/delete"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String delete(@RequestParam("id") String id) {
        BqInfo bqzy = new BqInfo();
        bqzy.setId(id);
        try {
            service.deleteBqInfo(bqzy);
        } catch (Exception e) {
            logger.error("/business/bqzy/bqsq/delete! id:" + id, e);
        }
        return "redirect:/business/bqzy/query?cxmk=bqsq";
    }

    @RequestMapping(value = {"/business/bqzy/bqsq/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String bqsq(Model model, @RequestParam(value = "id", required = false) String id) {
        if (id != null) {
            BqInfo bqzy = service.findBqInfoById(id);
            model.addAttribute("bqzy", bqzy);
        }
        return "business/bqzy/bqsq/add";
    }

    @RequestMapping(value = {"/business/bqzy/bqsh/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String qdjs(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            BqInfo bqzy = service.findBqInfoById(id);
            model.addAttribute("bqzy", bqzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(bqzy.getXqyId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/bqzy/bqsh/add";
    }

    @RequestMapping(value = {"/business/bqzy/bqsh/view"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String viewQdjs(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            BqInfo bqzy = service.findBqInfoById(id);
            model.addAttribute("bqzy", bqzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(bqzy.getXqyId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/bqzy/bqsh/view";
    }

    @RequestMapping(value = {"/business/bqzy/bqsq/findByid"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findById(Model model, @RequestParam(value = "id", required = false) String id) {
        BqInfo bqzy = service.findBqInfoById(id);
        model.addAttribute("bqzy", bqzy);
        return "business/bqzy/bqsq/edit";
    }

    @RequestMapping(value = {"/business/bqzy/bdcx"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String bdcx(Model model, @RequestParam(value = "bdh", required = true) String bdh) {
        XqyInfo xqyzy = xqyService.findXqyInfoByBdh(bdh);
        BqInfo bqInfo = new BqInfo();
        BeanUtils.copyProperties(xqyzy, bqInfo);
        bqInfo.setXqyId(bqInfo.getId());
        bqInfo.setId(null);
        bqInfo.setRemark(null);
        model.addAttribute("bqzy", bqInfo);
        model.addAttribute("bdh", bdh);
        if (xqyzy.getId() != null) {
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/bqzy/bqsq/add";
    }

    @RequestMapping(value = {"/business/bqzy/query"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String query(Model model, HttpServletRequest request) {
        final Map<String, Object> params = selectParams(request);
        if (params.get("cxmk").equals("bqsh")) {
            params.put("bqshcx", "未提交");
            params.put("bqshzt", "");
        } else if (params.get("cxmk").equals("bqsq")) {
            params.put("bqshcx", "");
            params.put("bqshzt", "未提交");
        }
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return service.findBqInfo(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) service.findBqInfoCount(params);
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
        if (params.get("cxmk").equals("bqsq")) {
            return "business/bqzy/bqsq/list";
        } else if (params.get("cxmk").equals("bqsh")) {
            return "business/bqzy/bqsh/list";
        } else if (params.get("cxmk").equals("wnxzjbf")) {
            return "business/bqzy/wnxzjbf/list";
        }

        return "business/bqzy/bqsq/list";
    }

    @RequestMapping("/business/bqzy/bqsq/save")
    public String save(HttpServletRequest request, BqInfo bqzy) throws Exception {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        if (StringHelper.isNotBlank(bqzy.getId())) {
            bqzy = service.editBqInfo(bqzy);
        } else {
            bqzy.setBqshzt("未提交");
            bqzy = service.addBqInfo(bqzy);
        }
        saveBusinessLog("财产险保单管理", "财产险保单录入", bqzy, request);

        if (StringHelper.isBlank(bqzy.getBqshzt())||bqzy.getBqshzt().equalsIgnoreCase("未提交")) {
            return "redirect:/business/bqzy/query?cxmk=bqsq";
        }
        return "redirect:/business/bqzy/query?cxmk=bqsh";
    }

    @RequestMapping(value = {"/business/bqzy/bqsq/updateStatusById"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String updateStatusById(@RequestParam("id") String id, @RequestParam("status") String status) {

        try {
            BqInfo bqzy = new BqInfo();
            bqzy.setId(id);
            bqzy.setBqshzt("未审核");
            service.editBqInfo(bqzy);
        } catch (Exception e) {
            logger.error("/business/bqzy/bqsq/updateStatusById error! id:" + id, e);
        }
        return "redirect:/business/bqzy/query?cxmk=bqsq";
    }

    @RequestMapping("/business/bqzy/bqsq/exportExcel")
    public String exportExcel(HttpServletRequest request, HttpServletResponse response, Model model) {
        final Map<String, Object> params = selectParams(request);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        if (new Integer(params.get("size").toString()).intValue() > 0) {
            List<BqInfo> users = (List<BqInfo>) service.findBqInfo(params, 0, (int) service.findBqInfoCount(params));

            int i = 1;
            for (Object object : users) {
                BqInfo map = (BqInfo) object;
                Map<String, Object> temp = new HashMap<String, Object>();
                temp.put("tbdh", map.getTbdh() == null ? "" : map.getTbdh().toString());
                temp.put("tbrq", map.getTbrq() == null ? "" : map.getTbrq().toString());
                temp.put("tbr", map.getTbr() == null ? "" : map.getTbr().toString());
                temp.put("tbrlxdh", map.getTbrlxdh() == null ? "" : map.getTbrlxdh().toString());
                temp.put("bbr", map.getBbr() == null ? "" : map.getBbr().toString());
                temp.put("bbrlxdh", map.getBbrlxdh() == null ? "" : map.getBbrlxdh().toString());
                temp.put("tbrgx", map.getTbrgx() == null ? "" : map.getTbrgx().toString());
                temp.put("bxgs", map.getBxgs() == null ? "" : map.getBxgs().toString());
                temp.put("xzmc", map.getXzmc() == null ? "" : map.getXzmc().toString());
                temp.put("jffs", map.getJffs() == null ? "" : map.getJffs().toString());
                temp.put("jfnq", map.getJfnq() == null ? "" : map.getJfnq().toString());
                temp.put("bxqj", map.getBxqj() == null ? "" : map.getBxqj().toString());
                temp.put("bxje", map.getBxje() == null ? "" : map.getBxje().toString());
                temp.put("sjbf", map.getSjbf() == null ? "" : map.getSjbf().toString());
                temp.put("dlgs", map.getDlgs() == null ? "" : map.getDlgs().toString());
                temp.put("dept", map.getDept() == null ? "" : map.getDept().toString());
                temp.put("ywy", map.getYwy() == null ? "" : map.getYwy().toString());
                temp.put("ywybh", map.getYwybh() == null ? "" : map.getYwybh().toString());
                temp.put("cbrq", map.getCbrq() == null ? "" : map.getCbrq().toString());
                temp.put("bqshzt", map.getBqshzt() == null ? "" : map.getBqshzt().toString());

                result.add(temp);
                i++;
            }
        }

        String sheeTTitle = "保全申请列表";
        String fileName = "保全申请列表" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);
        return null;
    }
}
