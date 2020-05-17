package com.itech.ups.app.system.manager.action;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.components.redis.RedisClient;
import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.app.system.manager.application.service.ManagerService;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 版本信息：v1.0 日期：2011-12-19 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class DeleteManager extends AbstractActionParent {
    @Autowired
    private ManagerService service;

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/system/manager/delete/{id}")
    public String edit(HttpServletRequest request, @PathVariable("id") String id) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Manager manager = service.findManager(id);
        manager.setCode(manager.getCode() + "_" + DateHelper.getYMDHMSFormatDate(new Date()));
        manager.setEditorId(currentManager.getManager().getId());
        manager.setEditorName(currentManager.getManager().getName());
        manager.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        manager.setDataStatus("invalid");// invalid-删除 valid有效
        service.editManager(manager);
        saveBusinessLog("管理员管理", "删除管理员", manager, request);
        return "redirect:/system/manager/list";
    }

    //解除三次登录错误限制

    @SuppressWarnings("unused")
    @RequestMapping("/system/manager/remove/{code}")
    public String remove(HttpServletRequest request, @PathVariable("code") String code) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        redisClient.delStringOperate(code);
        return "redirect:/system/manager/list";
    }
}
