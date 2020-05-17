package com.itech.ups.app.business.website.link.action;

import com.itech.ups.app.business.website.link.application.service.LinkService;
import com.itech.ups.app.link.application.domain.Link;
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
 * @version 1.0, 2014-5-4
 * @author  jxy
 *
 */

@Controller
public class IsExistLink extends AbstractActionParent {

    @Autowired
    private LinkService service;

    @RequestMapping(value = {"/business/website/link/isexist/isexist"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> isUniqueCode(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "name", required = true) String name) throws UnsupportedEncodingException {
        Map<String, Boolean> model = new HashMap<String, Boolean>();
        boolean flag = true;
        Link link = service.findLinkByName(name);
        if (link == null) {
            flag = false;
        }
        model.put("flag", flag);
        return model;
    }

}
