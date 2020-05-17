package com.itech.ups.app.business.website.news.application.service;

import com.itech.ups.app.business.website.news.application.infrastructure.NewsRepository;
import com.itech.ups.app.news.application.domain.News;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
@Service("newsService")
public class NewsServiceImp extends AbstractServiceParent implements NewsService {

    @Autowired
    private NewsRepository repository;

    @Override
    public News addNews(News news) {
        news.setDataStatus("valid"); // invalid-删除 valid有效
        return repository.addNews(news);
    }

    @Override
    public News editNews(News news) {
        return repository.editNews(news);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<News> findNews(Map params, int rowStart, int rowEnd) {
        return repository.findNews(params, rowStart, rowEnd);
    }

    @Override
    public News findNews(String id) {
        return repository.findNews(id);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public long findNewsTotalCount(Map params) {
        return repository.findNewsTotalCount(params);
    }
}