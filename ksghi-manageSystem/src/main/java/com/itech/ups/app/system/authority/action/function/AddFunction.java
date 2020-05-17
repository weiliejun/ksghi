package com.itech.ups.app.system.authority.action.function;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.app.system.authority.application.service.AuthorityService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 版本信息：v1.0
 * 日期：2017-8-17
 * Copyright yanmin Feng 版权所有
 */
@Controller
public class AddFunction extends AbstractActionParent {
    @Autowired
    private AuthorityService service;


    /**
     * 系统菜单树 [节点详情]
     *
     * @param request
     * @param model
     * @param code
     * @return
     */
    @RequestMapping(value = "/system/authority/function/details", produces = "application/json")
    public @ResponseBody
    Map<String, ?> functionDetails(HttpServletRequest request, String code, String operation) {
        Function record = null;
        Map<String, Object> model = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(code)) {
            record = service.findTreeFunctionByCode(code);
            if ("edit".equals(operation)) {
                model.put("id", record.getId());
                model.put("parentCode", record.getParentCode());
                model.put("parentName", record.getParentName());
                model.put("code", record.getCode());
                model.put("name", record.getName());
                model.put("url", record.getUrl());
                model.put("status", record.getStatus());
                model.put("seqnum", record.getSeqnum());
                model.put("nodeType", record.getNodeType());
            } else {
                model.put("parentCode", record.getCode());
                model.put("parentName", record.getName());
            }
        } else {
            record = new Function();
        }

        model.put("record", record);
        model.put("operation", operation);
        return model;
    }

    /**
     * 提交节点信息 [新增、修改]
     *
     * @param request
     * @param operation    :add / edit
     * @param nodeTypePro: nodeType属性与jQuery校验冲突
     * @param code
     * @return
     */
    @RequestMapping(value = "/system/authority/function/submit", produces = "application/json")
    public @ResponseBody
    Map<String, ?> funcitonSubmit(HttpServletRequest request, Function function, String operation, String nodeTypePro) {
        Function newFuction = null;
        function.setNodeType(nodeTypePro);
        if ("add".equals(operation)) {
            newFuction = service.addFunction(function);
        } else if ("edit".equals(operation)) {
            newFuction = service.editFunction(function);
        }

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("record", newFuction);
        model.put("operation", operation);

        return model;
    }

    /**
     * code 是否存在[remote远程调用  必须返回boolean类型]
     *
     * @param request
     * @param model
     * @param code
     * @return true:不存在 ， false存在
     */
    @RequestMapping(value = {"/system/authority/function/isCodeExist"}, method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    boolean isCodeExist(HttpServletRequest request, @RequestParam(value = "code", required = true) String code) {
        boolean flag = true;
        //页面传递过来的时候进行了加密处理
        try {
            if (StringUtils.isNotEmpty(code)) {
                code = URLDecoder.decode(code, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Function record = service.findTreeFunctionByCode(code);
        if (record != null && StringUtils.isNotEmpty(record.getId())) {
            flag = false;
        }
        return flag;
    }
}
