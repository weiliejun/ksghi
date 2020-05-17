package com.itech.ups.base.web.listener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebAppContextListener implements ServletContextListener {
    public static WebApplicationContext springContext;

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        WebAppContextListener.springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
    }
}
