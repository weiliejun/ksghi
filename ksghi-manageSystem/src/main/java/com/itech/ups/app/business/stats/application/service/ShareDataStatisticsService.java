package com.itech.ups.app.business.stats.application.service;

import java.util.List;
import java.util.Map;

public interface ShareDataStatisticsService {

    /*
     * 数据分享数据 2014-12-08 下午 苏冰雪
     */
    List findSharedata(Map params, int rowStart, int rowEnd);

    long findSharedataTotalCount(Map params);

}
