package com.itech.ups.app.business.xqgl.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.fjxInfo.application.service.FjxInfoService;
import com.itech.ups.app.business.xqyzy.application.service.XqyzyService;
import com.itech.ups.app.fjxinfo.application.domain.FjxInfo;
import com.itech.ups.app.xqyinfo.application.domain.XqyInfo;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class XqglController extends AbstractActionParent {
    private final Logger logger = Logger.getLogger(XqglController.class);
    @Autowired
    private XqyzyService service;
    @Autowired
    private FjxInfoService fjxInfoService;

    //    private String[] pTitle = {"投保单号:tbdh:15:center", "投保日期:tbrq:15:center", "投保人:tbr:22:center", "手机号码:tbrlxdh:15:left", "被保人:bbr:22:center", "手机号码:bbrlxdh:22:center", "关系:tbrgx:15:center", "保险公司:bxgs:20:center", "险种名称:xzmc:15:center", "缴费方式:jffs:15:center", "缴费年期:jfnq:15:center", "保险期间:bxqj:15:center", "保险金额:bxje:15:center", "实缴保费:sjbf:15:center", "代理公司:dlgs:15:center", "部门（机构）:dept:15:center", "业务员:ywy:15:center", "业务员编号:ywybh:15:center", "续费日期:cbrq:15:center"};
    private String[] pTitle = {"投保人:tbr:22:center", "被保险人:bbr:22:center", "被保险人身份证号:bbrzjhm:22:center", "投保单号:tbdh:15:center", "保单号:bdh:15:center", "保险公司:bxgs:20:center", "险种:xzdm:15:center", "险种名称:xzmc:15:center", "保额:bxje:15:center", "缴费方式:jffs:15:center", "缴费年期:jfnq:15:center", "保险期间:bxqj:15:center", "规模保费:sjbf:15:center", "标准保费:sjxj:15:center", "投保日期:tbrq:15:center", "签收回执日期:hzqsrq:15:center", "犹豫期过期日期:yyqgqrq:15:center", "代理人姓名:ywy:15:center", "结算人姓名:jsr:15:center", "实际销售人:sjxsr:15:center", "投保日期:tbrq:15:center", "承保日期:cbrq:15:center", "承保状态:cbshzt:15:center", "邮寄状态:yjzt:15:center", "清单结算状态:qdjszt:15:center", "续费日期:sxrq:15:center"};

    @RequestMapping(value = {"/business/xqyzy/xqjf/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String xqjf(Model model, @RequestParam(value = "id", required = true) String id) {
        if (id != null) {
            XqyInfo xqyzy = service.findXqyInfoById(id);
            model.addAttribute("xqyzy", xqyzy);
            model.addAttribute("jfjl", xqyzy.getJfjl() == null ? "" :JSONArray.fromObject(xqyzy.getJfjl()));

            List<FjxInfo> fjxInfo = fjxInfoService.findFjxInfosByXqyId(xqyzy.getId());
            model.addAttribute("fjxInfo", fjxInfo);
        }
        return "business/xqgl/xqjf/add";
    }

    @RequestMapping("/business/xqgl/xqjf/save")
    public String save(HttpServletRequest request, XqyInfo xqyzy, String xjrq, String xjbf) throws Exception {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        XqyInfo xqyInfo = service.findXqyInfoById(xqyzy.getId());
        HashMap hm = new HashMap();
        hm.put("xjrq", xjrq);
        hm.put("xjbf", xjbf);
        ArrayList list = new ArrayList();
        list.add(hm);
        String jfjl = xqyInfo.getJfjl();
        JSONArray jsonObject = new JSONArray();
        if (StringHelper.isNotBlank(jfjl)) {
            jsonObject = jsonObject.fromObject(jfjl);
        }
        jsonObject.addAll(list);
        xqyzy.setJfjl(jsonObject.toString());
        xqyzy = service.editXqyInfo(xqyzy);

        saveBusinessLog("续期缴费录入操作", "续期缴费录入操作", xqyzy, request);

        return "redirect:/business/xqgl/query?cxmk=xqjf";
    }

    @RequestMapping(value = {"/business/xqgl/query"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String queryYsbdlList(Model model, HttpServletRequest request) {
        final Map<String, Object> params = selectParams(request);
        String sxrqStartDate = null;
        String sxrqEndDate = null;
        if (StringHelper.isNotBlank((String) params.get("sxrqStartDate"))) {
            sxrqStartDate = params.get("sxrqStartDate").toString();
            params.put("sxrqStartDate", sxrqStartDate.substring(5));
        }
        if (StringHelper.isNotBlank((String) params.get("sxrqEndDate"))) {
            sxrqEndDate = params.get("sxrqEndDate").toString();
            params.put("sxrqEndDate", sxrqEndDate.substring(5));
        }
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    List<XqyInfo> list = service.findXqyInfo(params, rowStart, rowEnd);
                    List<XqyInfo> rtn = new ArrayList<XqyInfo>();
                    for (XqyInfo xqyInfo : list) {
                        if (!xqyInfo.getCbshzt().equalsIgnoreCase("已承保")) {
                            //未生效的保单不展示
                        } else if (xqyInfo.getJfnq().equalsIgnoreCase("趸交") || xqyInfo.getJfnq().equalsIgnoreCase("1年")) {
                            //这2种状态不展示
                        } else {
                            try {
                                int n = 0;
                                if (xqyInfo.getJfnq().equalsIgnoreCase("2年")) {
                                    n = 1;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("3年")) {
                                    n = 2;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("4年")) {
                                    n = 3;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("5年")) {
                                    n = 4;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("6年")) {
                                    n = 5;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("7年")) {
                                    n = 6;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("8年")) {
                                    n = 7;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("9年")) {
                                    n = 8;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("10年")) {
                                    n = 9;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("11年")) {
                                    n = 10;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("12年")) {
                                    n = 11;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("13年")) {
                                    n = 12;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("14年")) {
                                    n = 13;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("15年")) {
                                    n = 14;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("16年")) {
                                    n = 15;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("17年")) {
                                    n = 16;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("18年")) {
                                    n = 17;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("19年")) {
                                    n = 18;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("20年")) {
                                    n = 19;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("21年")) {
                                    n = 20;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("22年")) {
                                    n = 21;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("23年")) {
                                    n = 22;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("24年")) {
                                    n = 23;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("25年")) {
                                    n = 24;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("26年")) {
                                    n = 25;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("27年")) {
                                    n = 26;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("28年")) {
                                    n = 27;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("29年")) {
                                    n = 28;
                                } else if (xqyInfo.getJfnq().equalsIgnoreCase("30年")) {
                                    n = 29;
                                }

                                Calendar calendar = Calendar.getInstance();
                                int year = calendar.get(Calendar.YEAR);
                                calendar.setTime(format.parse(xqyInfo.getSxrq()));
                                calendar.add(Calendar.YEAR, n);
                                int month = calendar.get(Calendar.MONTH) + 1;
                                int day = calendar.get(Calendar.DATE);
                                if (DateHelper.getCurrentDate().after(calendar.getTime())) {
                                    //当前日期已经过了最后缴费期不展示
                                } else {
                                    calendar.set(year, month - 1, day);
                                    if (DateHelper.getCurrentDate().after(calendar.getTime())) {
                                        //当前日期已经过了今年缴费期不展示
                                    } else {
                                        calendar.add(Calendar.MONTH, -1);
                                        logger.info("rq:" + calendar.getTime().toString());
                                        if (DateHelper.getCurrentDate().after(calendar.getTime())) {
                                            calendar.set(year, month - 1, day);
                                            xqyInfo.setSxrq(DateHelper.getCalendarFormat(calendar));
                                            rtn.add(xqyInfo);
                                        }
                                    }
                                }
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                    return rtn;
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
        params.put("sxrqStartDate", sxrqStartDate);
        params.put("sxrqEndDate", sxrqEndDate);
        savePageParams(request, params, model);
        if (params.get("cxmk").equals("xqcj")) {
            return "business/xqgl/xqcj/list";
        } else if (params.get("cxmk").equals("xqjf")) {
            return "business/xqgl/xqjf/list";
        }

        return null;
    }

    @RequestMapping("/business/xqgl/xqcj/exportExcel")
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
                temp.put("sxrq", map.getSxrq() == null ? "" : DateHelper.getDate(new Date(), "yyyy-MM-dd").substring(0, 4) + map.getSxrq().toString().substring(4));

                if (temp.get("sxrq") != null && DateHelper.daysBetween(DateHelper.getDate(new Date(), "yyyy-MM-dd"), temp.get("sxrq").toString()) <= 30 && DateHelper.daysBetween(DateHelper.getDate(new Date(), "yyyy-MM-dd"), temp.get("sxrq").toString()) >= 0) {
                    result.add(temp);
                }
                i++;
            }
        }

        String sheeTTitle = "续期催缴保单列表";
        String fileName = "续期催缴保单列表" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);
        return null;
    }
}
