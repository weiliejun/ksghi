package com.itech.ups.app.business.website.news.application.service;

import com.itech.ups.app.news.application.domain.News;

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

public interface NewsService {

    News addNews(News news);

    News editNews(News news);

    @SuppressWarnings({"rawtypes"})
    List<News> findNews(Map params, int rowStart, int rowEnd);

    News findNews(String id);

    @SuppressWarnings("rawtypes")
    long findNewsTotalCount(Map params);
}
