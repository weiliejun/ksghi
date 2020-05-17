package com.itech.ups.base.web.listener;

import com.itech.ups.app.system.monitor.application.service.MonitorService;
import com.itech.ups.base.ApplicationServletContextKeys;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/*
 * ===========================================================================
 * Copyright 2008 CHENGANG Corp. All Rights Reserved.
 * @version 2.0, 2008-10-5
 * @author  Jack Chen
 * ===========================================================================
 *
 */
public class ApplicationSessionListener implements HttpSessionListener, ServletContextListener {

    private static final Log logger = LogFactory.getLog(ApplicationSessionListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // On Application Shutdown, please…
        // 1. Go fetch that DataSource
        ApplicationContext context = (ApplicationContext) arg0.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        ComboPooledDataSource dataSource = (ComboPooledDataSource) context.getBean("dataSource");
        try {
            dataSource.getClass().getMethod("close").invoke(dataSource);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            super.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.gc();
        System.exit(0);
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {

    }

    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        logger.debug("Created session " + session.getId());
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        logger.debug("Destroy session " + event.getSession().getId());

        CurrentManager currentManager = (CurrentManager) event.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        if (currentManager != null) {
            // 记录下线日志
            ApplicationContext context = (ApplicationContext) event.getSession().getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
            MonitorService monitorService = (MonitorService) context.getBean("monitorService");
            monitorService.saveLogoffLog(currentManager);
            // 从在线用户集合中删除当前用户
            synchronized (this) {
                Map onlineManagers = (Map) event.getSession().getServletContext().getAttribute(ApplicationServletContextKeys.ONLINE_MANAGERS);
                if (onlineManagers != null && onlineManagers.containsKey(currentManager.getManager().getCode())) {
                    onlineManagers.remove(currentManager.getManager().getCode());
                    event.getSession().getServletContext().setAttribute(ApplicationServletContextKeys.ONLINE_MANAGERS, onlineManagers);
                }
            }
        }
    }

}
