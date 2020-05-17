package com.itech.ups.app.business.website.news.application.infrastructure;

import com.itech.ups.app.news.application.domain.News;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-3-27
 * @author  zqs
 * ===========================================================================
 *
 */
@Repository
public class NewsRepository extends AbstractRepositoryParent {

    public News addNews(News news) {
        news.setId(generateIdentifier());
        sqlMapClientTemplate.insert("website.insertNews", news);
        return news;
    }

    public News editNews(News news) {
        sqlMapClientTemplate.update("website.updateNews", news);
        return news;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<News> findNews(Map params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        List<News> results = sqlMapClientTemplate.queryForList("website.selectNews", params);
        return results;
    }

    public News findNews(String id) {
        News news = (News) sqlMapClientTemplate.queryForObject("website.selectNewsById", id);
        return news;
    }

    @SuppressWarnings("rawtypes")
    public long findNewsTotalCount(Map params) {
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("website.selectNewsTotalCount", params);
        return totalCount;
    }
}