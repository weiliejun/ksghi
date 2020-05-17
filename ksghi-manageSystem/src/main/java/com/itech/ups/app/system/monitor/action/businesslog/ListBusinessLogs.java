package com.itech.ups.app.system.monitor.action.businesslog;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.ups.app.monitor.application.domain.BusinessLog;
import com.itech.ups.app.system.monitor.application.service.MonitorService;
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
 * 文件名：ListBusinessLog.java 版本信息：v1.0 日期：2011-12-19 Copyright Mike
 * Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class ListBusinessLogs extends AbstractActionParent {

    private String[] pTitle = {"管理员账号:MANAGER_CODE:20:center", "管理员姓名:MANAGER_NAME:20:center", "IP地址:IP:20:left", "操作时间:OPERATION_TIME:25:center", "操作功能模块:FUNCTION_MODULE:25:center", "操作功能描述:FUNCTION_DESCRIPTION:25:center", "操作数据:OPERATION_DATA:100:center"};

    @Autowired
    private MonitorService service;

    @RequestMapping("/system/monitor/businesslog/list")
    public String list(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return service.findBusinessLogs(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) service.findBusinessLogsTotalCount(params);
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

        return "system/monitor/businesslog/list";
    }

    @RequestMapping("/system/monitor/businesslog/list/exportExcel")
    public String listUsersExportExcel(HttpServletRequest request, HttpServletResponse response, Model model) {
        final Map<String, Object> params = selectParams(request);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        if (new Integer(params.get("size").toString()).intValue() > 0) {
            List<BusinessLog> businessLogs = service.findBusinessLogs(params, 0, (int) service.findBusinessLogsTotalCount(params));
            for (BusinessLog businessLog : businessLogs) {
                Map<String, Object> temp = new HashMap<String, Object>();
                temp.put("MANAGER_CODE", businessLog.getManagerCode());
                temp.put("MANAGER_NAME", businessLog.getManagerName());
                temp.put("IP", businessLog.getIp());
                temp.put("OPERATION_TIME", businessLog.getOperationTime());
                temp.put("FUNCTION_MODULE", businessLog.getFunctionModule());
                temp.put("FUNCTION_DESCRIPTION", businessLog.getFunctionDescription());
                temp.put("OPERATION_DATA", businessLog.getOperationData());
                result.add(temp);
            }
        }

        String sheeTTitle = "操作日志列表";
        String fileName = "操作日志列表" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);
        return null;
    }
}
