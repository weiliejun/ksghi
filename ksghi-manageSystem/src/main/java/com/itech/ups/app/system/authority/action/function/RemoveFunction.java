package com.itech.ups.app.system.authority.action.function;

import com.itech.ups.app.system.authority.application.service.AuthorityService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 版本信息：v1.0
 * 日期：2017-8-17
 * Copyright xsp 版权所有
 */
@Controller
public class RemoveFunction extends AbstractActionParent {
    @Autowired
    private AuthorityService service;

    /**
     * 删除某节点及其所有子节点
     *
     * @param request
     * @param code    要删除节点的code
     * @return
     */
    @RequestMapping(value = "/system/authority/function/removeNode", produces = "application/json")
    public @ResponseBody
    Map<String, ?> funcitonSubmit(HttpServletRequest request, String code) {
        service.removeTreeNode(code);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("flag", "true");
        model.put("msg", "删除成功！");
        return model;
    }

}
