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
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FinaPlannerCustomerInvest extends AbstractActionParent {
    private final String[] pTitle = {"推荐人:GRANDFATHER_NAME:20:center", "推荐人昵称:GRANDFATHER_NICK_NAME:30:center", "产品名称:PNAME:40:center", "合同编号:BORROW_CONTRACT_NO:50:center", "出借人姓名:UNAME:30:center", "关系等级:LEV:30:center", "手机号:MOBILE:30:center", "身份证号:ID_NO:35:center", "出借金额(元):AMOUNT:30:right", "出借时间:CREATE_TIME:30:center", "预期收益:ANNUAL_RATE:20:right", "出借期限(月):TIME_LIMIT:20:center", "正式起息日:REPAY_START_DATE:30:center", "产品到期日:REPAY_END_DATE:30:center", "收益方式:REPAY_TYPE:40:center", "持有天数(天):HOLDDAYS:20:center", "状态:STATUS:20:center", "备注:REM:40:center", "已付息合计(元):INTEREST:40:right", "已还本合计(元):PRINCIPAL:40:right", "推荐机构:ORG_NAME:40:center"};
    @Autowired
    private StatsService statsService;

    @RequestMapping(value = {"/business/stats/finaplannercustomerinvest/query"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> finaPlannerCustomerInvest(HttpServletRequest request, String pname, String status, String name, String borrowContractNo, String leve, String startDate, String endDate, String createStartDate, String createEndDate, String type) {
        Map<String, Object> params = selectParamsEasyui(request);
        Map<String, Object> totalMap = null;
        Page page = null;

        Map<String, Object> resultMap = resultList(request, params, "query");
        page = (Page) resultMap.get("page");
        List<Map<String, Object>> resList = (List<Map<String, Object>>) page.getList();
        totalMap = (Map<String, Object>) resultMap.get("totalMap");

        if (resList != null) {
            for (Map m : resList) {
                m.put("AMOUNT", ThousandsHelper.formateThousands(m.get("AMOUNT"), true));
                m.put("PRINCIPAL", ThousandsHelper.formateThousands(m.get("PRINCIPAL"), true));
                m.put("INTEREST", ThousandsHelper.formateThousands(m.get("INTEREST"), true));
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
        request.getSession().setAttribute(request.getContextPath() + "/business/stats/finaplannercustomerinvest/list", params);

        return model;
    }

    @RequestMapping(value = {"/business/stats/finaplannercustomerinvest/exportExcel"})
    public String finaPlannerCustomerInvestExportExcel(HttpServletRequest request, HttpServletResponse response, String pname, String name, String borrowContractNo, String leve, String status, String startDate, String endDate, String createStartDate, String createEndDate, String type) {
        Map<String, Object> params = selectParamsEasyui(request);
        Page page = null;
        Map<String, Object> totalMap = null;
        BigDecimal sumAmount = new BigDecimal(0);
        String sheeTTitle = "推荐人-客户出借明细表";
        String fileName = "推荐人-客户出借明细表" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        StringBuffer title = new StringBuffer();
        Map<String, Object> resultMap = resultList(request, params, "exportExcel");
        page = (Page) resultMap.get("page");
        List<Map<String, Object>> resList = (List<Map<String, Object>>) page.getList();

        if (resList != null) {
            for (Map m : resList) {
                m.put("AMOUNT", m.get("AMOUNT") == null ? 0.00 : m.get("AMOUNT"));
                m.put("PRINCIPAL", m.get("PRINCIPAL") == null ? 0.00 : m.get("PRINCIPAL"));
                m.put("INTEREST", m.get("INTEREST") == null ? 0.00 : m.get("INTEREST"));
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

        title.append("共").append(proCount).append("个产品，").append(userCount).append("个出借者,").append("总出借金额").append(ThousandsHelper.formateThousands(sumAmount, true)).append("元");
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, title.toString(), pTitle, resList, null);

        return null;
    }

    @RequestMapping("/business/stats/finaplannercustomerinvest/list")
    public String finaPlannerCustomerInvestList(HttpServletRequest request, Model model) {
        Map<String, Object> params = selectParamsEasyui(request);

        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        model.addAllAttributes((Map<String, Object>) request.getSession().getAttribute(request.getRequestURI()));
        return "/business/stats/finaplannercustomerinvest";
    }

    @RequestMapping(value = {"/business/stats/finaplannercustomerinvest/findusers"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> findUsersByName(HttpServletRequest request, HttpServletResponse response, String name) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        List<Map<String, Object>> listUser = statsService.findUsersByName(map);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("listUser", listUser);
        model.put("total", listUser.size());
        model.put("rows", listUser);
        model.put("success", "success");
        return model;
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
        Map<String, Object> totalMap = statsService.finaPlannerCustomerInvestTotal(params);

        // ///这里要这么修改/ 这里是对当前页的记录
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
            resList = statsService.finaPlannerCustomerInvestByPage(params, page.getRowStart(), page.getRowEnd());
        } else if (type.equals("exportExcel")) {
            resList = statsService.finaPlannerCustomerInvestByPage(params, 0, ((BigDecimal) totalMap.get("TOTAL")).intValue());
        }
        if (resList != null) {
            for (Map m : resList) {
                int lev = Integer.valueOf(m.get("LEV").toString()) - 1;
                m.put("LEV", (lev == 0 ? "客户" : lev + "级客户"));
                m.put("STATUS", (m.get("REPAY_TYPE") == null || m.get("REPAY_TYPE") == "" ? null : CodeHelper.getValueByCode("product.status", m.get("STATUS").toString())));
                m.put("REPAY_TYPE", (m.get("REPAY_TYPE") == null || m.get("REPAY_TYPE") == "" ? null : CodeHelper.getValueByCode("product.repayType", m.get("REPAY_TYPE").toString())));
                m.put("HOLDDAYS", (m.get("HOLDDAYS") == null || m.get("HOLDDAYS") == "" ? 0 : Integer.valueOf(m.get("HOLDDAYS").toString()) < 0 ? 0 : m.get("HOLDDAYS")));
                m.put("ANNUAL_RATE", m.get("ANNUAL_RATE") + "%");
                String mobile = m.get("MOBILE").toString();
                if (roleName.equalsIgnoreCase("隐私保护")) {
                    m.put("MOBILE", mobile);
                } else {
                    m.put("MOBILE", mobile.substring(0, 3) + "****" + mobile.substring(mobile.length() - 4, mobile.length()));
                }
                if (m.get("TYPE").equals("sellCredit")) {
                    m.put("REM", (m.get("REM") == null ? "" : m.get("REM").toString()) + "已转出");
                } else if (m.get("TYPE").equals("buyCredit")) {
                    m.put("REM", (m.get("REM") == null ? "" : m.get("REM").toString()) + "买入债权");
                }

            }
        }
        page.setList(resList);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("page", page);
        resultMap.put("totalMap", totalMap);
        return resultMap;
    }

}
