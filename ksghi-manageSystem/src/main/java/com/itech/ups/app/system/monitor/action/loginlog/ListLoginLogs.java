package com.itech.ups.app.system.monitor.action.loginlog;

import com.itech.core.util.CodeHelper;
import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.ups.app.system.monitor.application.service.MonitorService;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 文件名：ListLoginLog.java 版本信息：v1.0 日期：2011-12-19 Copyright Mike
 * Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class ListLoginLogs extends AbstractActionParent {
    private String[] pTitle = {"登录账号:managerCode:20:center", "登录人姓名:managerName:20:center", "登录人昵称:nickName:20:center", "用户分类:userClassName:20:center", "ip地址:ip:25:center", "登录时间:loginTime:20:center", "登录终端:loginTerminal:20:center", "下线时间:logoffTime:20:center", "登录人角色类型:roleType:20:center"};
    @Autowired
    private MonitorService service;

    @RequestMapping("/system/monitor/loginlog/list")
    public String list(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return service.findLoginLogs(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) service.findLoginLogsTotalCount(params);
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
        // ////
        return "system/monitor/loginlog/list";
    }

    @RequestMapping("/system/monitor/loginlog/list/exportExcel")
    public String listLoginLogsExportExcel(HttpServletRequest request, HttpServletResponse response) {
        final Map<String, Object> params = selectParams(request);

        List<Map<String, Object>> logs = service.findLoginLogs(params, 0, (int) service.findLoginLogsTotalCount(params));

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> loginLog : logs) {
            Map<String, Object> temp = new HashMap<String, Object>();
            if (ApplicationConstant.PLATFORM_SUPER_ADMIN_ROLE_TYPE.equals(loginLog.get("ROLE_TYPE"))) {
                temp.put("managerCode", loginLog.get("MANAGER_CODE") == null ? "" : loginLog.get("MANAGER_CODE").toString());
            } else {
                String managerCodeTemp = loginLog.get("MANAGER_CODE") == null ? "" : loginLog.get("MANAGER_CODE").toString();
                temp.put("managerCode", managerCodeTemp.substring(0, 3) + "****" + managerCodeTemp.substring(managerCodeTemp.length() - 4, managerCodeTemp.length()));
            }
            temp.put("managerName", loginLog.get("MANAGER_NAME") == null ? "" : loginLog.get("MANAGER_NAME").toString());
            temp.put("userClassName", loginLog.get("USER_CLASS_NAME") == null ? "" : loginLog.get("USER_CLASS_NAME").toString());
            temp.put("ip", loginLog.get("IP") == null ? "" : loginLog.get("IP").toString());
            temp.put("loginTime", loginLog.get("LOGIN_TIME") == null ? "" : loginLog.get("LOGIN_TIME").toString());
            temp.put("loginTerminal", loginLog.get("TERMINAL") == null ? "" : loginLog.get("TERMINAL").toString());
            temp.put("logoffTime", loginLog.get("LOGOFF_TIME") == null ? "" : loginLog.get("LOGOFF_TIME").toString());
            temp.put("roleType", CodeHelper.getValueByCode("loginlog.roleType", loginLog.get("ROLE_TYPE") == null ? "" : loginLog.get("ROLE_TYPE").toString()));
            temp.put("nickName", loginLog.get("NICK_NAME"));
            result.add(temp);
        }

        String sheeTTitle = "登录日志列表信息";
        String fileName = "登录日志列表信息" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);

        return null;
    }
}
