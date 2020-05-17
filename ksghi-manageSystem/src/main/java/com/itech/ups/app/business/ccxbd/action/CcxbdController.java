package com.itech.ups.app.business.ccxbd.action;

import com.itech.core.util.*;
import com.itech.ups.app.business.ccxbd.application.service.CcxbdService;
import com.itech.ups.app.ccxbd.application.domain.Ccxbd;
import com.itech.ups.app.monitor.application.domain.BusinessLog;
import com.itech.ups.app.system.monitor.application.service.MonitorService;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.util.FileContentTypeHelper;
import com.itech.ups.base.web.action.AbstractActionParent;
import com.itech.ups.base.web.bean.FileTemp;
import net.sf.json.JSONArray;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.*;

@Controller
public class CcxbdController extends AbstractActionParent {
    private final Logger logger = Logger.getLogger(CcxbdController.class);
    @Autowired
    private CcxbdService service;
    @Autowired
    private MonitorService monitorService;

    private String[] pTitle = {"投保日期:tbrq:15:center", "打印日期:dyrq:15:center", "被保险人:bbr:15:left", "保单号:bdh:22:center", "品名:xzmc:22:center", "批单号:pdh:22:center", "保险费:hsbf:15:center", "保险公司结算手续费比例:sxfbl:15:center", "手续费:sxfje:15:center", "结算比例:jsbl:15:center", "佣金金额:yjje:15:center", "国恒公司:ghgsyj:15:center", "结算人:ywy:15:center", "佣金结算日期:yjjsrq:15:center", "佣金结算公司:cbgs:30:center"};

    @RequestMapping("/business/ccxbd/bdmb")
    public void download(HttpServletRequest request, HttpServletResponse response, Model model) {
        FileTemp temp = new FileTemp();
        temp.setFilename("财产险类投保台账.xls");
        temp.setFileurl(request.getSession().getServletContext().getRealPath("//WEB-INF//classes//config//template//财产险类投保台账.xls"));
        temp.setFiletype(FileContentTypeHelper.getContentType("xls"));
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

    @RequestMapping(value = {"/business/ccxbd/delete"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteCcxbdById(@RequestParam("id") String id) {
        try {
            service.deleteCcxbd(id);
        } catch (Exception e) {
            logger.error("/business/ccxbd/delete! id:" + id, e);
        }
        return "redirect:/business/ccxbd/query";
    }

    @RequestMapping(value = {"/business/ccxbd/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findCcxbdById(Model model, @RequestParam(value = "id", required = false) String id) {
        if (id != null) {
            Ccxbd ccxbd = service.findCcxbdById(id);
            model.addAttribute("ccxbd", ccxbd);
        }
        return "business/ccxbd/add";
    }

    @RequestMapping(value = {"/business/ccxbd/findByid"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findById(Model model, @RequestParam(value = "id", required = false) String id) {
        Ccxbd ccxbd = service.findCcxbdById(id);
        model.addAttribute("ccxbd", ccxbd);
        return "business/ccxbd/edit";
    }

    @RequestMapping(value = {"/business/ccxbd/query"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String queryList(Model model, HttpServletRequest request) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return service.findCcxbd(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) service.findCcxbdCount(params);
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
        return "business/ccxbd/list";
    }

    @RequestMapping("/business/ccxbd/save")
    public String save(HttpServletRequest request, Ccxbd ccxbd) {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        try {
            if (StringHelper.isNotBlank(ccxbd.getId())) {
                ccxbd = service.editCcxbd(ccxbd);
            } else {
                ccxbd = service.addCcxbd(ccxbd);
            }
            saveBusinessLog("财产险保单管理", "财产险保单录入", ccxbd, request);
        } catch (Exception e) {
            e.printStackTrace();
            setPromptInfo("保存发生错误，请检查是否保单号重复!", request);
        }

        return "redirect:/business/ccxbd/query";
    }

    @RequestMapping(value = {"/business/ccxbd/updateStatusById"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String updateStatusById(@RequestParam("id") String id, @RequestParam("status") String status) {

        try {
            Ccxbd ccxbd = new CcxbdImportData();
            ccxbd.setId(id);
            service.editCcxbd(ccxbd);
        } catch (Exception e) {
            logger.error("/business/ccxbd/updateStatusById error! id:" + id, e);
        }
        return "redirect:/business/ccxbd/query";
    }

    @RequestMapping(value = {"/business/ccxbd/importCcxbdBatch"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String importCcxbdBatch(Model model) {
        return "business/ccxbd/importCcxbdBatch";
    }

    @RequestMapping(value = {"/business/ccxbd/importCcxbd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String importCcxbd(Model model) {
        return "business/ccxbd/importCcxbd";
    }

    @RequestMapping(value = {"/business/ccxbd/saveImportCcxbd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String saveData(Model model, HttpServletRequest request) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        MultipartHttpServletRequest files = (MultipartHttpServletRequest) request;
        Iterator<String> it = files.getFileNames();

        Set<String> newData = new HashSet<String>();

        // 导入财产险保单
        while (it.hasNext()) {
            String fileName = it.next();

            MultipartFile mfile = files.getFile(fileName);
            if (mfile != null && !mfile.isEmpty()) {
                BusinessLog businessLog = monitorService.selectByOperationData(mfile.getOriginalFilename());
                if (businessLog != null) {
                    setPromptInfo("此文件已经导入了!", request);
                    continue;
                }
                CcxbdImportExcel excel = new CcxbdImportExcel();
                List<CcxbdImportData> data = null;
                // 读取数据，返回实体
                try {
                    if ((mfile.getContentType() + ";charset=utf-8").equals(FileContentTypeHelper.getContentType("xlsx"))) {
                        data = excel.readEXCEL2007(mfile.getInputStream(), (new CcxbdImportData()).getClass());
                    } else {
                        data = excel.readEXCEL2003(mfile.getInputStream(), (new CcxbdImportData()).getClass());
                    }
                    if (data != null) {
                        service.addCcxbds(data);
                        setPromptInfo("导入成功!", request);
                        saveBusinessLog("财产险保单管理", "财产险保单导入文件:" + mfile.getOriginalFilename(), JSONArray.fromObject(data).toString(), request);
                    } else {
                        setPromptInfo("请检查数据文件，数据没有导入成功!", request);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    setPromptInfo("导入发生错误，请检查是否文件格式有误或者重复导入!", request);
                }
            }
        }

        return "redirect:/business/ccxbd/importCcxbd";
    }

    @RequestMapping("/business/ccxbd/exportExcel")
    public String listCcxbdsExportExcel(HttpServletRequest request, HttpServletResponse response, Model model) {
        final Map<String, Object> params = selectParams(request);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        if (new Integer(params.get("size").toString()).intValue() > 0) {
            List<Ccxbd> users = (List<Ccxbd>) service.findCcxbd(params, 0, (int) service.findCcxbdCount(params));

            int i = 1;
            for (Object object : users) {
                Ccxbd map = (Ccxbd) object;
                Map<String, Object> temp = new HashMap<String, Object>();
                temp.put("tbrq", map.getTbrq() == null ? "" : map.getTbrq().toString());
                temp.put("dyrq", map.getDyrq() == null ? "" : map.getDyrq().toString());
                temp.put("bbr", map.getBbr() == null ? "" : map.getBbr().toString());
                temp.put("bdh", map.getBdh() == null ? "" : map.getBdh().toString());
                temp.put("xzmc", map.getXzmc() == null ? "" : map.getXzmc().toString());
                temp.put("pdh", map.getPdh() == null ? "" : map.getPdh().toString());
                temp.put("hsbf", map.getHsbf() == null ? "" : map.getHsbf().toString());
                temp.put("sxfbl", map.getSxfbl() == null ? "" : map.getSxfbl().toString());
                temp.put("sxfje", map.getSxfje() == null ? "" : map.getSxfje().toString());
                temp.put("jsbl", map.getJsbl() == null ? "" : map.getJsbl().toString());
                temp.put("yjje", map.getYjje() == null ? "" : map.getYjje().toString());
                temp.put("ghgsyj", map.getGhgsyj() == null ? "" : map.getGhgsyj().toString());
                temp.put("ywy", map.getYwy() == null ? "" : map.getYwy().toString());
                temp.put("yjjsrq", map.getYjjsrq() == null ? "" : map.getYjjsrq().toString());
                temp.put("cbgs", map.getCbgs() == null ? "" : map.getCbgs().toString());
                result.add(temp);
                i++;
            }
        }

        String sheeTTitle = "财产险类投保台账";
        String fileName = "财产险类投保台账" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);
        return null;
    }
}
