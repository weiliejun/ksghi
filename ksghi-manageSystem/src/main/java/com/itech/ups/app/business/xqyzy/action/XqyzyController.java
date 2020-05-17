package com.itech.ups.app.business.xqyzy.action;

import com.itech.core.util.*;
import com.itech.ups.app.business.fjxInfo.application.service.FjxInfoService;
import com.itech.ups.app.business.xqyzy.application.service.XqyzyService;
import com.itech.ups.app.fjxinfo.application.domain.FjxInfo;
import com.itech.ups.app.monitor.application.domain.BusinessLog;
import com.itech.ups.app.system.monitor.application.service.MonitorService;
import com.itech.ups.app.xqyinfo.application.domain.XqyInfo;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.util.FileContentTypeHelper;
import com.itech.ups.base.web.action.AbstractActionParent;
import com.itech.ups.base.web.bean.FileTemp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class XqyzyController extends AbstractActionParent {
    private final Logger logger = Logger.getLogger(XqyzyController.class);
    @Autowired
    private XqyzyService service;
    @Autowired
    private FjxInfoService fjxInfoService;
    @Autowired
    private MonitorService monitorService;

    private String[] pTitle = {"投保人:tbr:22:center", "被保险人:bbr:22:center", "被保险人身份证号:bbrzjhm:22:center","投保单号:tbdh:15:center","保单号:bdh:15:center", "保险公司:bxgs:20:center", "险种:xzdm:15:center", "险种名称:xzmc:15:center", "保额:bxje:15:center", "缴费方式:jffs:15:center", "缴费年期:jfnq:15:center", "保险期间:bxqj:15:center", "规模保费:sjbf:15:center", "标准保费:sjxj:15:center", "投保日期:tbrq:15:center", "签收回执日期:hzqsrq:15:center", "犹豫期过期日期:yyqgqrq:15:center",  "代理人姓名:ywy:15:center", "结算人姓名:jsr:15:center", "实际销售人:sjxsr:15:center", "投保日期:tbrq:15:center", "承保日期:cbrq:15:center", "承保状态:cbshzt:15:center", "邮寄状态:yjzt:15:center", "清单结算状态:qdjszt:15:center"};

    @RequestMapping("/business/xqyzy/ysbd/bdmb")
    public void download(HttpServletRequest request, HttpServletResponse response, Model model) {
        FileTemp temp = new FileTemp();
        temp.setFilename("国华人寿.xlsx");
        temp.setFileurl(request.getSession().getServletContext().getRealPath("//WEB-INF//classes//config//template//国华人寿.xlsx"));
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

    @RequestMapping(value = {"/business/xqyzy/ysbd/delete"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteAppPushManageById(@RequestParam("id") String id) {
        XqyInfo xqyzy = new XqyInfo();
        xqyzy.setId(id);
        try {
            service.deleteXqyInfo(xqyzy);
        } catch (Exception e) {
            logger.error("/business/xqyzy/ysbd/delete! id:" + id, e);
        }
        return "redirect:/business/xqyzy/query?cxmk=ysbd";
    }

    @RequestMapping(value = {"/business/xqyzy/ysbd/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findXqyInfoById(Model model, @RequestParam(value = "id", required = false) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
        }
        return "business/xqyzy/ysbd/add";
    }

    @RequestMapping(value = {"/business/xqyzy/ysbd/bdcb/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String bdcb(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/ysbd/bdcb";
    }

    @RequestMapping(value = {"/business/xqyzy/bdcb/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String bdcbsh(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/bdcb/add";
    }

    @RequestMapping(value = {"/business/xqyzy/bdhz/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String bdhz(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/bdhz/add";
    }

    @RequestMapping(value = {"/business/xqyzy/bdhf/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String bdhf(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/bdhz/addHf";
    }

    @RequestMapping(value = {"/business/xqyzy/yyqcd/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String yyqcd(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/yyqcd/add";
    }

    @RequestMapping(value = {"/business/xqyzy/ysbd/bdcj/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String bdcj(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/ysbd/bdcj";
    }

    @RequestMapping(value = {"/business/xqyzy/yjbd/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String yjbd(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/yjbd/add";
    }

    @RequestMapping(value = {"/business/xqyzy/yjbd/send"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String send(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/yjbd/send";
    }

    @RequestMapping(value = {"/business/xqyzy/qdjs/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String qdjs(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/qdjs/add";
    }

    @RequestMapping(value = {"/business/xqyzy/yjbd/view"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String viewYjbd(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/yjbd/view";
    }

    @RequestMapping(value = {"/business/xqyzy/qdjs/view"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String viewQdjs(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/qdjs/view";
    }

    @RequestMapping(value = {"/business/xqyzy/ysbd/view"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findById(Model model, @RequestParam(value = "id", required = true) String id) {
        XqyInfo xqyzy = service.findXqyInfoById(id);
        model.addAttribute("xqyzy", xqyzy);
        if (xqyzy.getId() != null) {
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqyzy/ysbd/view";
    }

    @RequestMapping(value = {"/business/xqyzy/query"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String queryYsbdlList(Model model, HttpServletRequest request) {
        final Map<String, Object> params = selectParams(request);
        if (params.get("cxmk").equals("bdhz")) {
            params.put("cbshzt", "已承保");
        } else if (params.get("cxmk").equals("yyqcd")) {
            params.put("cbshzt", "已承保");
        } else if (params.get("cxmk").equals("yjbd")) {
            params.put("cbshzt", "已承保");
        } else if (params.get("cxmk").equals("qdjs")) {
            params.put("cbshzt", "已承保");
        } else if (params.get("cxmk").equals("ysbd")) {
            if(params.get("cbshzt")!=null&&StringHelper.isNotBlank(params.get("cbshzt").toString())){

            }else {
                params.put("cbshzt", "");
            }
        }
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return service.findXqyInfo(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) service.findXqyInfoCount(params);
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
        if (params.get("cxmk").equals("bdcb")) {
            params.put("cbshzt", "");
            return "business/xqyzy/bdcb/list";
        } else if (params.get("cxmk").equals("bdhz")) {
            params.put("cbshzt", "");
            return "business/xqyzy/bdhz/list";
        } else if (params.get("cxmk").equals("yyqcd")) {
            params.put("cbshzt", "");
            model.addAttribute("today", DateHelper.getYMDFormatDate(new Date()));
            return "business/xqyzy/yyqcd/list";
        } else if (params.get("cxmk").equals("yjbd")) {
            params.put("cbshzt", "");
            return "business/xqyzy/yjbd/list";
        } else if (params.get("cxmk").equals("qdjs")) {
            params.put("cbshzt", "");
            return "business/xqyzy/qdjs/list";
        } else if (params.get("cxmk").equals("ysbd")) {
            return "business/xqyzy/ysbd/list";
        }

        return "business/xqyzy/ysbd/list";
    }

    @RequestMapping("/business/xqyzy/ysbd/save")
    public String save(HttpServletRequest request, XqyInfo xqyzy) throws Exception {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        //计算保费合计
        BigDecimal fjxSjbf = new BigDecimal(0);
        if (xqyzy.getId() != null && StringHelper.isNotBlank(xqyzy.getId())) {
            XqyInfo xqyInfo = service.findXqyInfoById(xqyzy.getId());
            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            for (FjxInfo fjx : fjxInfo) {
                if (fjx.getSjbf() != null) {
                    fjxSjbf = fjxSjbf.add(fjx.getSjbf());
                }
            }
            BeanHelper.copyProperties(xqyzy,xqyInfo,BeanHelper.getNullPropertyNames(xqyzy));
            BeanHelper.copyProperties(xqyInfo,xqyzy,BeanHelper.getNullPropertyNames(xqyInfo));
            xqyzy.setBfhj(xqyInfo.getSjbf().add(fjxSjbf));
        }

        if (StringHelper.isNotBlank(xqyzy.getCjrq())) {
            xqyzy.setCbshzt("撤件");
        } else if (StringHelper.isNotBlank(xqyzy.getCdsj())) {
            xqyzy.setCbshzt("撤单");
        }
        if (StringHelper.isNotBlank(xqyzy.getJcrq())) {
            xqyzy.setYjzt("已寄出");
        } else if (StringHelper.isNotBlank(xqyzy.getSdrq())) {
            xqyzy.setYjzt("已收到");
        }
        if (StringHelper.isNotBlank(xqyzy.getJsrq())) {
            xqyzy.setQdjszt("已结算");
        } else {
            xqyzy.setQdjszt("未结算");
        }
        if (StringHelper.isNotBlank(xqyzy.getCbrq())) {
            xqyzy.setCbshzt("已承保");
        } else {
            xqyzy.setCbshzt("待处理");
        }
        if (StringHelper.isNotBlank(xqyzy.getHzqsrq())) {
            final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(format.parse(xqyzy.getHzqsrq()));
            calendar.add(Calendar.DAY_OF_MONTH, 15);
            xqyzy.setYyqgqrq(DateHelper.getCalendarFormat(calendar));
        }
        if (StringHelper.isNotBlank(xqyzy.getId())) {
            xqyzy = service.editXqyInfo(xqyzy);
        } else {
            xqyzy.setYjzt("未邮寄");
            xqyzy.setQdjszt("未结算");
            xqyzy = service.addXqyInfo(xqyzy);
        }
        saveBusinessLog("投保保单操作", "投保保单操作", xqyzy, request);

        if (request.getParameter("cxmk").equals("bdcb")) {
            return "redirect:/business/xqyzy/query?cxmk=bdcb";
        } else if (request.getParameter("cxmk").equals("bdhz")) {
            return "redirect:/business/xqyzy/query?cxmk=bdhz";
        } else if (request.getParameter("cxmk").equals("yyqcd")) {
            return "redirect:/business/xqyzy/query?cxmk=yyqcd";
        } else if (request.getParameter("cxmk").equals("yjbd")) {
            return "redirect:/business/xqyzy/query?cxmk=yjbd";
        } else if (request.getParameter("cxmk").equals("qdjs")) {
            return "redirect:/business/xqyzy/query?cxmk=qdjs";
        } else if (request.getParameter("cxmk").equals("ysbd")) {
            return "redirect:/business/xqyzy/query?cxmk=ysbd";
        }
        return "redirect:/business/xqyzy/query?cxmk=ysbd";
    }

    @RequestMapping(value = {"/business/xqyzy/bdcb/updateStatusById"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String plcbsh(@RequestParam("id") String id, @RequestParam("status") String status) {
        String[] ids = id.split(";");
        try {
            for (String xqyId : ids) {
                //将json字符串转化为JSONObject
                JSONObject jsonObject = JSONObject.fromObject(xqyId);
                //通过getString("")分别取出里面的信息
                String id1 = jsonObject.getString("id");
                XqyInfo xqyzy = new XqyInfo();
                xqyzy.setId(id1);
                if (status.equalsIgnoreCase("tg")) {
                    xqyzy.setCbshzt("审核通过");
                } else if (status.equalsIgnoreCase("bh")) {
                    xqyzy.setCbshzt("驳回");
                }
                service.editXqyInfo(xqyzy);
            }
        } catch (Exception e) {
            logger.error("/business/xqyzy/bdcb/updateStatusById error! id:" + id, e);
        }
        return "redirect:/business/xqyzy/query?cxmk=bdcb";
    }

    @RequestMapping(value = {"/business/xqyzy/bdhz/updateStatusById"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String plhz(@RequestParam("id") String id, @RequestParam("status") String status) {
        String[] ids = id.split(";");
        try {
            for (String xqyId : ids) {
                //将json字符串转化为JSONObject
                JSONObject jsonObject = JSONObject.fromObject(xqyId);
                //通过getString("")分别取出里面的信息
                String id1 = jsonObject.getString("id");
                XqyInfo xqyzy = new XqyInfo();
                xqyzy.setId(id1);
                if (status.equalsIgnoreCase("hz")) {
                    xqyzy.setHzqsrq(DateHelper.getYMDFormatDate(new Date()));
                    xqyzy.setHzlrrq(DateHelper.getYMDFormatDate(new Date()));
                } else if (status.equalsIgnoreCase("hf")) {
                    xqyzy.setHfcgrq(DateHelper.getYMDFormatDate(new Date()));
                }

                service.editXqyInfo(xqyzy);
            }
        } catch (Exception e) {
            logger.error("/business/xqyzy/bdhz/updateStatusById error! id:" + id, e);
        }
        return "redirect:/business/xqyzy/query?cxmk=bdhz";
    }

    @RequestMapping("/business/xqyzy/ysbd/exportExcel")
    public String exportExcel(HttpServletRequest request, HttpServletResponse response, Model model) {
        final Map<String, Object> params = selectParams(request);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        if (new Integer(params.get("size").toString()).intValue() > 0) {
            List<XqyInfo> users = (List<XqyInfo>) service.findXqyInfo(params, 0, (int) service.findXqyInfoCount(params));

            int i = 1;
            for (Object object : users) {
                XqyInfo map = (XqyInfo) object;
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
                temp.put("cbshzt", map.getCbshzt() == null ? "" : map.getCbshzt().toString());
                temp.put("cbrq", map.getCbrq() == null ? "" : map.getCbrq().toString());
                temp.put("yjzt", map.getYjzt() == null ? "" : map.getYjzt().toString());
                temp.put("qdjszt", map.getQdjszt() == null ? "" : map.getQdjszt().toString());

                temp.put("jsr", map.getJsr() == null ? "" : map.getJsr().toString());
                temp.put("sjxsr", map.getSjxsr() == null ? "" : map.getSjxsr().toString());
                temp.put("hzqsrq", map.getHzqsrq() == null ? "" : map.getHzqsrq().toString());
                temp.put("yyqgqrq", map.getYyqgqrq() == null ? "" : map.getYyqgqrq().toString());

                temp.put("bbrzjhm", map.getBbrzjhm() == null ? "" : map.getBbrzjhm().toString());
                temp.put("bdh", map.getBdh() == null ? "" : map.getBdh().toString());
                temp.put("xzdm", map.getXzdm() == null ? "" : map.getXzdm().toString());
                temp.put("sjxj", map.getSjxj() == null ? "" : map.getSjxj().toString());
                result.add(temp);
                i++;
            }
        }

        String sheeTTitle = "投保保单列表";
        String fileName = "投保保单列表" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);
        return null;
    }

    @RequestMapping(value = {"/business/xqyzy/ysbd/importXqyInfoBatch"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String importXqyInfoBatch(Model model) {
        return "business/xqyzy/ysbd/importXqyInfoBatch";
    }

    @RequestMapping(value = {"/business/xqyzy/ysbd/importXqyInfo"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String importXqyInfo(Model model) {
        return "business/xqyzy/ysbd/importXqyInfo";
    }

    @RequestMapping(value = {"/business/xqyzy/ysbd/saveImportXqyInfo"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String saveData(Model model, HttpServletRequest request) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        MultipartHttpServletRequest files = (MultipartHttpServletRequest) request;
        Iterator<String> it = files.getFileNames();

        Set<String> newData = new HashSet<String>();

        // 导入投保保单
        while (it.hasNext()) {
            String fileName = it.next();

            MultipartFile mfile = files.getFile(fileName);
            if (mfile != null && !mfile.isEmpty()) {
                BusinessLog businessLog = monitorService.selectByOperationData(mfile.getOriginalFilename());
                if (businessLog != null) {
                    setPromptInfo("此文件已经导入了!", request);
                    continue;
                }
                XqyInfoImportExcel excel = new XqyInfoImportExcel();
                List<XqyInfoImportData> data = null;
                // 读取数据，返回实体
                try {
                    if ((mfile.getContentType() + ";charset=utf-8").equals(FileContentTypeHelper.getContentType("xlsx"))) {
                        data = excel.readEXCEL2007(mfile.getInputStream(), (new XqyInfoImportData()).getClass());
                    } else {
                        data = excel.readEXCEL2003(mfile.getInputStream(), (new XqyInfoImportData()).getClass());
                    }

                    if(data!=null) {
                        service.addXqyInfos(data);
                        setPromptInfo("导入成功!", request);
                        saveBusinessLog("投保保单管理", "投保保单导入文件:" + mfile.getOriginalFilename(), JSONArray.fromObject(data).toString(), request);
                    }else{
                        setPromptInfo("请检查数据文件，数据没有导入成功!", request);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    setPromptInfo("导入发生错误，请检查是否文件格式有误或者重复导入!", request);
                }
            }
        }

        return "redirect:/business/xqyzy/ysbd/importXqyInfo";
    }
}
