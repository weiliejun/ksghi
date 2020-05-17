package com.itech.ups.base.web.bean;

import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.base.application.domain.CurrentManager;

/**
 * @author 张可乐
 * @version 1.0
 * @description 用ThreadLocal存放Manager对象，便于在dao层和service取用
 * @update 2017-2-28 下午2:25:56
 */
public class SessionManager {
    private static ThreadLocal<CurrentManager> currentManagerLocal = new ThreadLocal<CurrentManager>();
    private static ThreadLocal<Manager> managerlocal = new ThreadLocal<Manager>();

    public static CurrentManager getCurrentManager() {
        return currentManagerLocal.get();
    }

    public static void setCurrentManager(CurrentManager currentManager) {
        currentManagerLocal.set(currentManager);
    }

    public static Manager getManager() {
        return managerlocal.get();
    }

    public static void setManager(Manager manager) {
        managerlocal.set(manager);
    }
}
