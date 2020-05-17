package com.itech.ups.app.business.stats.action;

import com.itech.core.util.CodeHelper;
import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.core.util.ThousandsHelper;
import com.itech.ups.app.authority.application.domain.Role;
import com.itech.ups.app.business.stats.action.common.Page;
import com.itech.ups.app.business.stats.application.service.StatsService;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FinaPlannerCredit extends AbstractActionParent {

    private final String[] pTitle = {"出让人推荐人:GFNAME:20:center", "出让人推荐人手机号:GFMOBILE:30:center", "出让人姓名:SELLER_NAME:30:center", "出让人关系等级:LEV:30:center", "出让人手机号:MOBILE:30:center", "出让人身份证号:ID_NO:35:center", "受让人姓名:BNAME:30:center", "受让人手机号:BMOBILE:30:center", "受让人身份证号:BID_NO:35:center", "受让人关系等级:BLEV:30:center", "受让人推荐人:BGFNAME:20:center", "受让人推荐人手机号:BGFMOBILE:30:center", "产品名称:PNAME:40:center", "出让金额(元):TRANS_AMOUNT:30:right", "预期收益:ANNUAL_RATE:20:right", "出借期限(月):TIME_LIMIT:20:center", "正式起息日:REPAY_START_DATE:30:center", "产品到期日:REPAY_END_DATE:30:center", "收益方式:REPAY_TYPE:40:center", "状态:pSTATUS:20:center", "出借时间:TCREATE_TIME:30:right", "转出时间:TRANSFER_TIME:30:right", "持有天数(天):CREDIT_HOLD_DAYS:20:center", "出让人应收利息(元):SELLER_INTEREST:40:right", "备注:REM:40:center"};
    @Autowired
    private StatsService statsService;

    @RequestMapping(value = "/business/stats/finaplannercredit/query", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> FinaPlannerCredit(HttpServletRequest request, String pname, String name, String bgfname, String sellName, String borrowContractNo, String pstatus, String startDate, String endDate, String transferStartDate, String transferEndDate, String lev, String tcreateStartDate, String tcreateEndDate) {
        Map<String, Object> params = selectParamsEasyui(request);
        Map<String, Object> totalMap = null;
        Page page = null;

        Map<String, Object> resultMap = resultList(request, params, "query");
        page = (Page) resultMap.get("page");
        List<Map<String, Object>> resList = (List<Map<String, Object>>) page.getList();
        totalMap = (Map<String, Object>) resultMap.get("totalMap");

        if (resList != null) {
            for (Map m : resList) {
                m.put("TRANS_AMOUNT", ThousandsHelper.formateThousands(m.get("TRANS_AMOUNT"), true));
                m.put("SELLER_INTEREST", ThousandsHelper.formateThousands(m.get("SELLER_INTEREST"), true));
            }
        }
        page.setList(resList);
        Map<String, Object> model = new HashMap<String, Object>();
        model.putAll(params);
        model.put("total", page.getTotalRow());
        model.put("rows", page.getList());
        model.put("userCount", totalMap != null ? totalMap.get("USER_COUNT").toString() : 0);
        model.put("proCount", totalMap != null ? totalMap.get("PRO_COUNT").toString() : 0);
        model.put("sumAmount", totalMap != null ? ThousandsHelper.formateThousands(totalMap.get("SUM_AMOUNT"), true) : 0.00);

        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        request.getSession().setAttribute(request.getContextPath() + "/business/stats/finaplannercredit/list", params);

        return model;
    }

    @RequestMapping(value = {"/business/stats/finaplannercredit/exportExcel"})
    public String FinaPlannerCreditExportExcel(HttpServletRequest request, HttpServletResponse response, String pname, String name, String bgfname, String sellName, String borrowContractNo, String pstatus, String startDate, String endDate, String transferStartDate, String transferEndDate, String lev, String tcreateStartDate, String tcreateEndDate) {
        Map<String, Object> params = selectParamsEasyui(request);
        Page page = null;
        Map<String, Object> totalMap = null;
        BigDecimal sumAmount = new BigDecimal(0);
        String sheeTTitle = "推荐人-债权转让明细表";
        String fileName = "推荐人-债权转让明细表" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        StringBuffer title = new StringBuffer();
        Map<String, Object> resultMap = resultList(request, params, "exportExcel");
        page = (Page) resultMap.get("page");
        List<Map<String, Object>> resList = (List<Map<String, Object>>) page.getList();

        if (resList != null) {
            for (Map m : resList) {
                m.put("TRANS_AMOUNT", m.get("CREDIT_AMOUNT") == null ? 0.00 : m.get("CREDIT_AMOUNT"));// 转让金额
                m.put("PRINCIPAL", m.get("SELLER_INTEREST") == null ? 0.00 : m.get("SELLER_INTEREST"));
            }
        }
        long userCount = 0;
        long proCount = 0;
        totalMap = (Map<String, Object>) resultMap.get("totalMap");
        if (totalMap != null) {
            userCount = Integer.valueOf(totalMap.get("USER_COUNT").toString());
            proCount = Integer.valueOf(totalMap.get("PRO_COUNT").toString());
            sumAmount = (BigDecimal) totalMap.get("SUM_AMOUNT");
        }
        title.append("共").append(proCount).append("个产品，").append(userCount).append("个转让人,").append("总转让金额").append(ThousandsHelper.formateThousands(sumAmount, true)).append("元");
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, title.toString(), pTitle, resList, null);

        return null;
    }

    @RequestMapping("/business/stats/finaplannercredit/list")
    public String finaPlannerCreditList(HttpServletRequest request, Model model) {
        Map<String, Object> params = selectParamsEasyui(request);

        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        model.addAllAttributes((Map<String, Object>) request.getSession().getAttribute(request.getRequestURI()));

        return "/business/stats/finaplannercredit";
    }

    private Map<String, Object> resultList(HttpServletRequest request, Map<String, Object> params, String type) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        List<Role> roles = currentManager.getRoles();
        String roleName = "";
        if (roles != null && roles.size() > 0) {
            for (Role role : roles) {
                if (role.getName().equals("隐私保护")) {
                    roleName = role.getName();
                }
            }
        }

        List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
        Map<String, Object> totalMap = statsService.findFinaPlannerCreditsTotalCount(params);

        // ///这里要这么修改//////////////////////////
        Page page = null;
        if (new Integer(params.get("size").toString()).intValue() > 0) {
            if (params.get("page") != null && !request.getParameter("page").equals("1") && !request.getParameter("page").equalsIgnoreCase(params.get("page").toString())) {
                page = new Page(params.get("page").toString(), params.get("rows").toString(), ((BigDecimal) totalMap.get("TOTAL")).intValue());
            } else {
                page = new Page(request, ((BigDecimal) totalMap.get("TOTAL")).intValue());
            }
        } else {
            page = new Page(request, ((BigDecimal) totalMap.get("TOTAL")).intValue());
        }

        if (type.equals("query")) {
            resList = statsService.findFinaPlannerCredits(params, page.getRowStart(), page.getRowEnd());
        } else if (type.equals("exportExcel")) {
            resList = statsService.findFinaPlannerCredits(params, 0, ((BigDecimal) totalMap.get("TOTAL")).intValue());
        }

        for (Map m : resList) {
            int leve = Integer.valueOf(m.get("LEV").toString()) - 1;
            m.put("LEV", (leve == 0 ? "客户" : leve + "级客户"));
            int bleve = m.get("BLEV") == null ? 0 : (Integer.valueOf(m.get("BLEV").toString()) - 1);
            m.put("BLEV", (bleve == 0 ? "客户" : bleve + "级客户"));
            m.put("PSTATUS", CodeHelper.getValueByCode("product.status", m.get("PSTATUS").toString()));
            m.put("REPAY_TYPE", CodeHelper.getValueByCode("product.repayType", m.get("REPAY_TYPE").toString()));
            m.put("ANNUAL_RATE", m.get("ANNUAL_RATE") + "%");
            String mobile = m.get("MOBILE") == null ? "" : m.get("MOBILE").toString();
            String bmobile = m.get("BMOBILE") == null ? "" : m.get("BMOBILE").toString();
            String gfmobile = m.get("GFMOBILE") == null ? "" : m.get("GFMOBILE").toString();
            String bgfmobile = m.get("BGFMOBILE") == null ? "" : m.get("BGFMOBILE").toString();
            if (roleName.equalsIgnoreCase("隐私保护")) {
                m.put("MOBILE", mobile);
            } else {
                m.put("MOBILE", m.get("MOBILE") == null ? "" : (mobile.substring(0, 3) + "****" + mobile.substring(mobile.length() - 4, mobile.length())));
                m.put("BMOBILE", m.get("BMOBILE") == null ? "" : (bmobile.substring(0, 3) + "****" + bmobile.substring(mobile.length() - 4, bmobile.length())));
                m.put("GFMOBILE", m.get("GFMOBILE") == null ? "" : (gfmobile.substring(0, 3) + "****" + gfmobile.substring(gfmobile.length() - 4, gfmobile.length())));
                m.put("BGFMOBILE", m.get("BGFMOBILE") == null ? "" : (bgfmobile.substring(0, 3) + "****" + bgfmobile.substring(bgfmobile.length() - 4, bgfmobile.length())));
            }
        }
        page.setList(resList);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("page", page);
        resultMap.put("totalMap", totalMap);
        return resultMap;
    }

    private Map<String, Object> resultList(HttpServletRequest request, String pname, String name, String bgfname, String sellName, String borrowContractNo, String pstatus, String startDate, String endDate, String transferStartDate, String transferEndDate, String tcreateStartDate, String tcreateEndDate, String lev, String type, Page page, Map<String, Object> totalMap) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        List<Role> roles = currentManager.getRoles();
        String roleName = "";
        if (roles != null && roles.size() > 0) {
            for (Role role : roles) {
                if (role.getName().equals("隐私保护")) {
                    roleName = role.getName();
                }
            }
        }
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("bgfname", bgfname);
        map.put("pname", pname);
        map.put("sellName", sellName);
        map.put("pstatus", pstatus);
        map.put("borrowContractNo", borrowContractNo);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("transferStartDate", transferStartDate);
        map.put("transferEndDate", transferEndDate);
        map.put("tcreateStartDate", tcreateStartDate);
        map.put("tcreateEndDate", tcreateEndDate);
        map.put("lev", lev);
        List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
        totalMap = statsService.findFinaPlannerCreditsTotalCount(map);
        page = new Page(request, ((BigDecimal) totalMap.get("TOTAL")).intValue());
        if (type.equals("query")) {
            resList = statsService.findFinaPlannerCredits(map, page.getRowStart(), page.getRowEnd());
        } else if (type.equals("exportExcel")) {
            resList = statsService.findFinaPlannerCredits(map, 0, ((BigDecimal) totalMap.get("TOTAL")).intValue());
        }
        for (Map m : resList) {
            int leve = Integer.valueOf(m.get("LEV").toString()) - 1;
            m.put("LEV", (leve == 0 ? "客户" : leve + "级客户"));
            int bleve = m.get("BLEV") == null ? 0 : Integer.valueOf(m.get("BLEV").toString()) - 1;
            m.put("BLEV", (bleve == 0 ? "客户" : bleve + "级客户"));
            m.put("PSTATUS", CodeHelper.getValueByCode("product.status", m.get("PSTATUS").toString()));
            m.put("REPAY_TYPE", CodeHelper.getValueByCode("product.repayType", m.get("REPAY_TYPE").toString()));
            m.put("ANNUAL_RATE", m.get("ANNUAL_RATE") + "%");
            String mobile = m.get("MOBILE").toString();
            String gfmobile = m.get("GFMOBILE").toString();
            String bgfmobile = m.get("BGFMOBILE").toString();
            if (roleName.equalsIgnoreCase("隐私保护")) {
                m.put("MOBILE", mobile);
            } else {
                m.put("MOBILE", mobile.substring(0, 3) + "****" + mobile.substring(mobile.length() - 4, mobile.length()));
                m.put("GFMOBILE", gfmobile.substring(0, 3) + "****" + gfmobile.substring(gfmobile.length() - 4, gfmobile.length()));
                m.put("BGFMOBILE", bgfmobile.substring(0, 3) + "****" + bgfmobile.substring(bgfmobile.length() - 4, bgfmobile.length()));
            }
        }
        page.setList(resList);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("page", page);
        resultMap.put("totalMap", totalMap);
        return resultMap;
    }

}
