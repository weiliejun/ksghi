package com.itech.ups.base.web.components;

import com.itech.core.util.BeanHelper;
import com.itech.core.util.DateHelper;
import com.itech.ups.app.system.monitor.application.service.MonitorService;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/*
 * ===========================================================================
 * Copyright 2009 CHENGANG Corp. All Rights Reserved.
 * @version 2.0, 2009-7-26
 * @author  Jack Chen
 * ===========================================================================
 *
 */
@Component
public class AbstractComponentParent {

    protected static final String connectJunyuanUrl = "http://wx.kingstartimes.com/QuerySecurityNetValues?token=Vu8azqQ__";
    protected static final String newConnectJunyuanUrl = "http://wx.kingstartimes.com/QuerySecurityInfo?token=Vu8azqQ__";
    protected static final int len = 4;
    private static final Log logger = LogFactory.getLog(AbstractComponentParent.class);

    /**
     * 记录业务日志
     *
     * @param request
     * @param msg
     * @param data
     */

    protected void saveBusinessLog(String functionModule, String functionDescription, Object data, HttpServletRequest request) {
        try {
            CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
            ApplicationContext context = (ApplicationContext) request.getSession().getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
            MonitorService monitorService = (MonitorService) context.getBean("monitorService");
            String operationData = BeanHelper.getProperties(data);
            if (operationData != null && operationData.length() > 1300) {
                operationData = operationData.substring(0, 1300);
            }
            String message = "操作人员:" + currentManager.getManager().getName() + " 操作时间:" + DateHelper.getYMDHMSFormatDate(new Date()) + " 操作功能模块：" + functionModule + " 操作功能描述:" + functionDescription + " 操作数据:" + operationData;
            logger.info(message);
            monitorService.saveBusinessLog(currentManager, functionModule, functionDescription, operationData);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    protected void setPromptInfo(String promptInfo, HttpServletRequest request) {
        request.getSession().setAttribute(ApplicationSessionKeys.PROMPT_INFO, promptInfo);
    }

}
