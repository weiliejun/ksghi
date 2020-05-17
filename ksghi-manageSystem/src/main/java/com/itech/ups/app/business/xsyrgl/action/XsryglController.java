package com.itech.ups.app.business.xsyrgl.action;

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
public class XsryglController extends AbstractActionParent {
    private final Logger logger = Logger.getLogger(XsryglController.class);
    @Autowired
    private XsryglService service;

//    private String[] pTitle = {"员工姓名:name:15:center", "员工工号:code:15:center", "手机号码:mobile:15:left", "身份证号:idno:22:center", "职级:rank:22:center", "部门（机构）:dept:22:center", "推荐人:tjr:15:center", "推荐人工号:tjrgh:15:center", "直接上级:zjsj:15:center", "直接上级工号:zjsjgh:15:center", "状态:status:15:center", "入司时间:rssj:15:center"};
private String[] pTitle = {"员工姓名:name:15:center", "员工工号:code:15:center", "手机号码:mobile:15:left", "身份证号:idno:22:center", "职级:rank:22:center", "所属公司:ssgs:22:center", "部门（机构）:dept:22:center", "状态:status:15:center", "入司时间:rssj:15:center"};

    @RequestMapping(value = {"/business/xsrygl/delete"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteAppPushManageById(@RequestParam("id") String id) {
        Xsrygl xsrygl = new Xsrygl();
        xsrygl.setId(id);
        try {
            service.deleteXsrygl(xsrygl);
        } catch (Exception e) {
            logger.error("/business/xsrygl/delete! id:" + id, e);
        }
        return "redirect:/business/xsrygl/query";
    }

    @RequestMapping(value = {"/business/xsrygl/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findXsryglById(Model model, @RequestParam(value = "id", required = false) String id, HttpServletRequest request) {
        if (id != null) {
            Xsrygl xsrygl = service.findXsryglById(id);
            final Map<String, Object> params = selectParams(request);
            if (params.get("status").equals("zsyg")) {
                xsrygl.setStatus("正式员工");
            } else if (params.get("status").equals("lz")) {
                xsrygl.setStatus("离职");
            } else if (params.get("status").equals("xz")) {
                xsrygl.setStatus("新入职");
            }
            model.addAttribute("xsrygl", xsrygl);
        }
        return "business/xsrygl/add";
    }

    @RequestMapping(value = {"/business/xsrygl/view"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findById(Model model, @RequestParam(value = "id", required = false) String id) {
        Xsrygl xsrygl = service.findXsryglById(id);
        model.addAttribute("xsrygl", xsrygl);
        return "business/xsrygl/view";
    }

    @RequestMapping(value = {"/business/xsrygl/query"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String queryXsryglList(Model model, HttpServletRequest request) {
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
        if (params.get("cxmk").equals("bgcx")) {
            return "business/xsrygl/list2";
        } else if (params.get("cxmk").equals("xsry")) {
            return "business/xsrygl/list";
        } else if (params.get("cxmk").equals("selectTjr")) {
            model.addAttribute("type", "selectTjr");
            return "business/xsrygl/selectList";
        } else if (params.get("cxmk").equals("selectZjsj")) {
            model.addAttribute("type", "selectZjsj");
            return "business/xsrygl/selectList";
        } else if (params.get("cxmk").equals("selectYwy")) {
            model.addAttribute("type", "selectYwy");
            return "business/xsrygl/selectList";
        } else if (params.get("cxmk").equals("selectSqr")) {
            model.addAttribute("type", "selectSqr");
            return "business/xsrygl/selectList";
        }else if (params.get("cxmk").equals("selectJsr")) {
            model.addAttribute("type", "selectJsr");
            return "business/xsrygl/selectList";
        }else if (params.get("cxmk").equals("selectSjxsr")) {
            model.addAttribute("type", "selectSjxsr");
            return "business/xsrygl/selectList";
        }
        return "business/xsrygl/list";
    }

    @RequestMapping("/business/xsrygl/save")
    public String save(HttpServletRequest request, Xsrygl xsrygl) throws Exception {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        xsrygl.setCreatorId(currentManager.getManager().getId());
        xsrygl.setCreatorName(currentManager.getManager().getName());
        if (StringHelper.isNotBlank(xsrygl.getId())) {
            xsrygl.setEditorId(currentManager.getManager().getId());
            xsrygl.setEditorName(currentManager.getManager().getName());
            xsrygl.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
            xsrygl = service.editXsrygl(xsrygl);
        } else {
            xsrygl = service.addXsrygl(xsrygl);
        }
        saveBusinessLog("销售人员信息管理", "销售员申请入职信息录入", xsrygl, request);
        return "redirect:/business/xsrygl/query?cxmk=xsry";
    }

    @RequestMapping(value = {"/business/xsrygl/updateStatusById"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String updateStatusById(@RequestParam("id") String id, @RequestParam("status") String status) {

        try {
            Xsrygl xsrygl = new Xsrygl();
            xsrygl.setId(id);
            service.editXsrygl(xsrygl);
        } catch (Exception e) {
            logger.error("/business/xsrygl/updateStatusById error! id:" + id, e);
        }
        return "redirect:/business/xsrygl/query";
    }

    @RequestMapping("/business/xsrygl/exportExcel")
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
                temp.put("ssgs", map.getSsgs() == null ? "" : map.getSsgs().toString());
                temp.put("dept", map.getDept() == null ? "" : map.getDept().toString());
                /*temp.put("tjr", map.getTjr() == null ? "" : map.getTjr().toString());
                temp.put("tjrgh", map.getTjrgh() == null ? "" : map.getTjrgh().toString());
                temp.put("zjsj", map.getZjsj() == null ? "" : map.getZjsj().toString());
                temp.put("zjsjgh", map.getZjsjgh() == null ? "" : map.getZjsjgh().toString());*/
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
