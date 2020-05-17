package com.itech.ups.app.system.monitor.action.onlinemanager;

import com.itech.ups.base.ApplicationServletContextKeys;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 文件名：ListOnlineManagers.java 版本信息：v1.0 日期：2011-12-19 Copyright Mike
 * Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class ListOnlineManagers extends AbstractActionParent {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping("/system/monitor/onlinemanager/list")
    public String list(HttpServletRequest request, Model model) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        final List items1 = new ArrayList();
        Map onlineManagers = (Map) request.getSession().getServletContext().getAttribute(ApplicationServletContextKeys.ONLINE_MANAGERS);
        if (onlineManagers != null) {
            Collection onlineManagersColl = onlineManagers.values();
            for (Iterator itr = onlineManagersColl.iterator(); itr.hasNext(); ) {
                CurrentManager manager = (CurrentManager) itr.next();
                if (null != manager && !manager.getManager().getId().equals("10000")) {
                    Map<String, String> temp = new HashMap<String, String>();
                    temp.put("managerId", manager.getManager().getId());
                    temp.put("managerCode", manager.getManager().getCode());
                    temp.put("managerName", manager.getManager().getName());
                    temp.put("ip", manager.getIp());
                    temp.put("loginTime", manager.getLoginTime());
                    temp.put("sessionId", manager.getSessionId());
                    items1.add(temp);
                }
            }
        }

        final Map<String, Object> params = selectParams(request);
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    List results = new ArrayList();
                    for (int i = rowStart; i < rowEnd; i++) {
                        results.add(items1.get(i));
                    }
                    return results;
                }

                public int getTotalRows(Limit limit) {
                    return (int) items1.size();
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
        return "system/monitor/onlinemanager/list";
    }
}
