package com.itech.ups.base.application.service;

import com.itech.core.util.BeanHelper;
import com.itech.core.util.DateHelper;
import com.itech.ups.app.system.monitor.application.service.MonitorService;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * ===========================================================================
 * Copyright 2009 CHENGANG Corp. All Rights Reserved.
 * @version 2.0, 2009-7-26
 * @author  Jack Chen
 * ===========================================================================
 *
 */
@Service("abstractServiceParent")
public class AbstractServiceParent {

    // scale 表示表示需要精确到小数点以后几位。
    protected static final int scale = 4;
    private static final Log logger = LogFactory.getLog(AbstractServiceParent.class);

    // @Autowired
    // protected HttpSession session;
    //
    // @Autowired
    // protected HttpServletRequest request;

    public String generateOrdId() {
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String uuid = format.format(new Date().getTime()) + new Double(Math.random() * 100000).intValue();
        while (uuid.length() < 22) {
            uuid = uuid + "0";
        }
        uuid = uuid.substring(2);
        return uuid;
    }

    /**
     * 记录业务日志
     *
     * @param request
     * @param msg
     * @param data
     */
    protected void saveBusinessLog(String functionModule, String functionDescription, Object data, HttpServletRequest request) {
        logger.info("进入记录业务日志处理");
        try {
            CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
            ApplicationContext context = (ApplicationContext) request.getSession().getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
            MonitorService monitorService = (MonitorService) context.getBean("monitorService");
            String operationData = BeanHelper.getProperties(data);
            logger.info("异常调试！");
            if (operationData != null && operationData.length() > 1300) {
                operationData = operationData.substring(0, 1300);
            }
            String message = "操作人员:" + currentManager.getManager().getName() + " 操作时间:" + DateHelper.getYMDHMSFormatDate(new Date()) + " 操作功能模块：" + functionModule + " 操作功能描述:" + functionDescription + " 操作数据:" + operationData;
            logger.info(message);
            monitorService.saveBusinessLog(currentManager, functionModule, functionDescription, operationData);
        } catch (Exception e) {
            logger.error(e);
        }
        logger.info("记录业务日志处理结束！");
    }

    protected void setPromptInfo(HttpServletRequest request, String promptInfo) {
        request.getSession().setAttribute(ApplicationSessionKeys.PROMPT_INFO, promptInfo);
    }
}
