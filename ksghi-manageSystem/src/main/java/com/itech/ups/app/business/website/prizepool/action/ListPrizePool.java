package com.itech.ups.app.business.website.prizepool.action;

import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ListPrizePool extends AbstractActionParent {

    @RequestMapping("/business/website/prizepool/list")
    public String list(Model model, HttpServletRequest request, String topic, String publishStatus, String dateRange) {

        return "business/operation/activity/prizePoolList";
    }
}