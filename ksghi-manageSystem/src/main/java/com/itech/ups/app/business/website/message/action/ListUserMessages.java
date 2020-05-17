package com.itech.ups.app.business.website.message.action;

import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.website.message.application.service.UserMessageService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.apache.commons.lang.StringUtils;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-4-12
 * @author  zqs
 * ===========================================================================
 *
 */
@Controller
public class ListUserMessages extends AbstractActionParent {

    @Autowired
    private UserMessageService service;

    @RequestMapping("/business/website/message/list")
    public String list(HttpServletRequest request, String userName, String busiType) throws UnsupportedEncodingException {

        final Map<String, String> params = new HashMap<String, String>();
        if (StringUtils.isNotBlank(userName)) {
            params.put("userName", userName);
        }
        if (StringHelper.isNotBlank(busiType)) {
            params.put("busiType", busiType);
        }

        Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
            public Collection<?> getItems(Limit limit) {
                return service.findUserMessages(params, limit.getRowSelect().getRowStart(), limit.getRowSelect().getRowEnd());
            }

            public int getTotalRows(Limit limit) {
                return (int) service.findUserMessagesTotalCount(params);
            }
        });

        request.setAttribute("userName", userName);
        request.setAttribute("busiType", busiType);
        request.setAttribute("results", items);

        return "/business/website/message/list";
    }
}