package com.itech.ups.app.business.yjcxfx.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.xsyrgl.application.service.XsryglService;
import com.itech.ups.app.xsrygl.application.domain.Xsrygl;
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
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class YjcxfxController extends AbstractActionParent {
    private final Logger logger = Logger.getLogger(YjcxfxController.class);
    @Autowired
    private XsryglService service;

    private String[] pTitle = {"员工姓名:name:15:center", "员工工号:code:15:center", "手机号码:mobile:15:left", "身份证号:idno:22:center", "职级:rank:22:center", "部门（机构）:dept:22:center", "推荐人:tjr:15:center", "推荐人工号:tjrgh:15:center", "直接上级:zjsj:15:center", "直接上级工号:zjsjgh:15:center", "状态:status:15:center", "入司时间:rssj:15:center"};

    @RequestMapping(value = {"/business/yjcxfx/ysbd/delete"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteAppPushManageById(@RequestParam("id") String id) {
        Xsrygl yjcxfx = new Xsrygl();
        yjcxfx.setId(id);
        try {
            service.deleteXsrygl(yjcxfx);
        } catch (Exception e) {
            logger.error("/business/yjcxfx/ysbd/delete! id:" + id, e);
        }
        return "redirect:/business/yjcxfx/ysbd/query";
    }

    @RequestMapping(value = {"/business/yjcxfx/ysbd/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findXsryglById(Model model, @RequestParam(value = "id", required = false) String id) {
        if (id != null) {
            Xsrygl yjcxfx = service.findXsryglById(id);
            model.addAttribute("yjcxfx", yjcxfx);
        }
        return "business/yjcxfx/ysbd/add";
    }

    @RequestMapping(value = {"/business/yjcxfx/ysbd/findByid"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findById(Model model, @RequestParam(value = "id", required = false) String id) {
        Xsrygl yjcxfx = service.findXsryglById(id);
        model.addAttribute("yjcxfx", yjcxfx);
        return "business/yjcxfx/ysbd/edit";
    }

    @RequestMapping(value = {"/business/yjcxfx/query"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String queryYsbdlList(Model model, HttpServletRequest request) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return service.findXsrygl(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) service.findXsryglCount(params);
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
        if (params.get("cxmk").equals("xsrycx")) {
            return "business/yjcxfx/xsrycx";
        } else if (params.get("cxmk").equals("tdxxcx")) {
            return "business/yjcxfx/tdxxcx";
        } else if (params.get("cxmk").equals("grysyjcx")) {
            return "business/yjcxfx/grysyjcx";
        } else if (params.get("cxmk").equals("tdysyjcx")) {
            return "business/yjcxfx/tdysyjcx";
        } else if (params.get("cxmk").equals("tdcbyjcx")) {
            return "business/yjcxfx/tdcbyjcx";
        } else if (params.get("cxmk").equals("yjbdcx")) {
            return "business/yjcxfx/yjbdcx";
        } else if (params.get("cxmk").equals("grcbyjcx")) {
            return "business/yjcxfx/grcbyjcx";
        }

        return "business/yjcxfx/xsrycx";
    }

    @RequestMapping("/business/yjcxfx/ysbd/save")
    public String save(HttpServletRequest request, Xsrygl yjcxfx) throws Exception {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        if (StringHelper.isNotBlank(yjcxfx.getId())) {
            yjcxfx = service.editXsrygl(yjcxfx);
        } else {
            yjcxfx = service.addXsrygl(yjcxfx);
        }
        saveBusinessLog("财产险保单管理", "财产险保单录入", yjcxfx, request);
        return "redirect:/business/yjcxfx/ysbd/query";
    }

    @RequestMapping(value = {"/business/yjcxfx/ysbd/updateStatusById"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String updateStatusById(@RequestParam("id") String id, @RequestParam("status") String status) {

        try {
            Xsrygl yjcxfx = new Xsrygl();
            yjcxfx.setId(id);
            service.editXsrygl(yjcxfx);
        } catch (Exception e) {
            logger.error("/business/yjcxfx/ysbd/updateStatusById error! id:" + id, e);
        }
        return "redirect:/business/yjcxfx/ysbd/query";
    }

    @RequestMapping("/business/yjcxfx/ysbd/exportExcel")
    public String listXsryglsExportExcel(HttpServletRequest request, HttpServletResponse response, Model model) {
        final Map<String, Object> params = selectParams(request);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        if (new Integer(params.get("size").toString()).intValue() > 0) {
            List<Xsrygl> users = (List<Xsrygl>) service.findXsrygl(params, 0, (int) service.findXsryglCount(params));

            int i = 1;
            for (Object object : users) {
                Xsrygl map = (Xsrygl) object;
                Map<String, Object> temp = new HashMap<String, Object>();
                temp.put("name", map.getName() == null ? "" : map.getName().toString());
                temp.put("code", map.getCode() == null ? "" : map.getCode().toString());
                temp.put("mobile", map.getMobile() == null ? "" : map.getMobile().toString());
                temp.put("idno", map.getIdNo() == null ? "" : map.getIdNo().toString());
                temp.put("rank", map.getRank() == null ? "" : map.getRank().toString());
                temp.put("dept", map.getDept() == null ? "" : map.getDept().toString());
                temp.put("tjr", map.getTjr() == null ? "" : map.getTjr().toString());
                temp.put("tjrgh", map.getTjrgh() == null ? "" : map.getTjrgh().toString());
                temp.put("zjsj", map.getZjsj() == null ? "" : map.getZjsj().toString());
                temp.put("zjsjgh", map.getZjsjgh() == null ? "" : map.getZjsjgh().toString());
                temp.put("status", map.getStatus() == null ? "" : map.getStatus().toString());
                temp.put("rssj", map.getRssj() == null ? "" : map.getRssj().toString());

                result.add(temp);
                i++;
            }
        }

        String sheeTTitle = "销售人员信息管理";
        String fileName = "销售人员信息管理" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);
        return null;
    }
}
