package com.itech.ups.base.web.listener;

import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.bean.SessionManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author 张可乐
 * @version 1.0
 * @description 监听session属性的变化
 * @update 2017-2-28 下午2:07:35
 */
public class ApplicationSessionAtributeListener implements HttpSessionAttributeListener {

    private static final Log logger = LogFactory.getLog(ApplicationSessionAtributeListener.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // 登录后将CurrentManager 实例对象存入SessionManager中
        if ("CurrentManager".equals(event.getName())) {
            CurrentManager currentManager = (CurrentManager) event.getValue();
            SessionManager.setCurrentManager(currentManager);
            Manager manager = currentManager.getManager();
            SessionManager.setManager(manager);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // 每次访问将CurrentManager 实例对象存入SessionManager中，由VisitInterceptor控制
        if ("CurrentManager".equals(event.getName())) {
            CurrentManager currentManager = (CurrentManager) event.getValue();
            SessionManager.setCurrentManager(currentManager);
            Manager manager = currentManager.getManager();
            SessionManager.setManager(manager);
        }
    }
}
