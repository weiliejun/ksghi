package com.itech.ups.base.web.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * ===========================================================================
 * Copyright 2008 CHENGANG Corp. All Rights Reserved.
 * @version 2.0, 2008-10-5
 * @author  Jack Chen
 * ===========================================================================
 *
 */
public class ShutdownQuartzListener implements ServletContextListener {
    private static final Log logger = LogFactory.getLog(ShutdownQuartzListener.class);

    /*
     * 获取相关bean进行shutdown
     *
     * @seejavax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
     * ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        WebApplicationContext webApplicationContext = (WebApplicationContext) arg0.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        org.quartz.impl.StdScheduler startQuertz = (org.quartz.impl.StdScheduler) webApplicationContext.getBean("schedulerFactoryBean");
        if (startQuertz != null) {
            startQuertz.shutdown();
            logger.debug("关闭quartz任务");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
     * .ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        logger.debug("启动应用");
    }

}
