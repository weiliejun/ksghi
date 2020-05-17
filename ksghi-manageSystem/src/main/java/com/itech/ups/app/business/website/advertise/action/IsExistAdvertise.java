package com.itech.ups.app.business.website.advertise.action;

import com.itech.ups.app.advertise.application.domain.Advertise;
import com.itech.ups.app.business.website.advertise.application.service.AdvertiseService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-5-5
 * @author  zhaoyl
 * ===========================================================================
 *
 */
@Controller
public class IsExistAdvertise extends AbstractActionParent {

    @Autowired
    private AdvertiseService service;

    @RequestMapping(value = {"/business/website/advertise/isexist/isexist"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> isUniqueCode(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "code", required = true) String code) throws UnsupportedEncodingException {
        Map<String, Boolean> model = new HashMap<String, Boolean>();
        boolean flag = true;
        Advertise advertise = service.findAdvertiseByCode(code);
        if (advertise == null) {
            flag = false;
        }
        model.put("flag", flag);
        return model;
    }
}