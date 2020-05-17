package com.itech.ups.app.portal.action;

import com.itech.ups.app.system.monitor.application.service.MonitorService;
import com.itech.ups.base.ApplicationServletContextKeys;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

/**
 * 文件名：Loginoff.java 版本信息：v1.0 日期：2011-12-24 Copyright Mike
 * Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class Logoff extends AbstractActionParent {

    @Autowired
    private MonitorService monitorService;

    @RequestMapping(value = {"/portal/logoff"}, method = RequestMethod.GET)
    public String logoff(HttpServletRequest request, Model model) {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        if (currentManager != null) {
            // 记录下线日志
            monitorService.saveLogoffLog(currentManager);
            // 从在线用户集合中删除当前用户
            synchronized (this) {
                Map allManagers = (Map) request.getSession().getServletContext().getAttribute(ApplicationServletContextKeys.ONLINE_MANAGERS);
                if (allManagers != null && allManagers.containsKey(currentManager.getManager().getCode())) {
                    allManagers.remove(currentManager.getManager().getCode());
                    request.getSession().getServletContext().setAttribute(ApplicationServletContextKeys.ONLINE_MANAGERS, allManagers);
                }

                Map allManagerSessions = (Map) request.getSession().getServletContext().getAttribute(ApplicationServletContextKeys.ONLINE_MANAGERS_SESSIONS);
                if (allManagerSessions != null && allManagerSessions.containsKey(currentManager.getManager().getCode())) {
                    allManagerSessions.remove(currentManager.getManager().getCode());
                    request.getSession().getServletContext().setAttribute(ApplicationServletContextKeys.ONLINE_MANAGERS_SESSIONS, allManagerSessions);
                }
            }
        }
        HttpSession session = request.getSession(false);
        if (session != null) {
            Enumeration en = session.getAttributeNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                session.removeAttribute(key);
            }
            session.invalidate();
        }
        return "redirect:/portal/login";
    }
}
