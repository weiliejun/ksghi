package com.itech.ups.app.business.website.news.action;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.website.news.application.service.NewsService;
import com.itech.ups.app.news.application.domain.News;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-4-5
 * @author  zqs
 * ===========================================================================
 *
 */
@Controller
public class DeleteNews extends AbstractActionParent {

    @Autowired
    private NewsService service;

    @RequestMapping("/business/website/news/delete/{id}")
    public String delete(HttpServletRequest request, @PathVariable("id") String id) {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        News news = service.findNews(id);
        news.setDataStatus("invalid");
        news.setEditorId(currentManager.getManager().getId());
        news.setEditorName(currentManager.getManager().getName());
        news.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));

        service.editNews(news);

        saveBusinessLog("媒体报道管理", "删除媒体报道信息", news, request);

        return "redirect:/business/website/news/list";
    }
}
