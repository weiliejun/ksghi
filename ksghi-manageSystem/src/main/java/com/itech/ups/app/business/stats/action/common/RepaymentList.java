package com.itech.ups.app.business.stats.action.common;

import com.itech.ups.app.business.stats.application.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RepaymentList {

    @Autowired
    private StatsService service;

    @RequestMapping(value = "/business/stats/common/repaymentlist", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> query(HttpServletRequest request, String productId, String tenderId) {
        final Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> model = new HashMap<String, Object>();
        params.put("productId", productId);
        params.put("tenderId", tenderId);
        List<Map<String, Object>> resultList = service.findRepayments(params);
        model.put("total", resultList.size());
        model.put("rows", resultList);
        return model;
    }
}
