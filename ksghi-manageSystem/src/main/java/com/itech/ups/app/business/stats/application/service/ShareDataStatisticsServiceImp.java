package com.itech.ups.app.business.stats.application.service;

import com.itech.ups.app.business.stats.application.infrastructure.ShareDataStatisticsRepository;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 版本信息：v1.0 日期：2014年7月1日 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

@Service("ShareDataStatisticsService")
public class ShareDataStatisticsServiceImp extends AbstractServiceParent implements ShareDataStatisticsService {

    @Autowired
    private ShareDataStatisticsRepository repository;

    /*
     * 数据分享数据 2014-12-08 下午 苏冰雪
     */
    @Override
    public List findSharedata(Map params, int rowStart, int rowEnd) {
        return repository.findSharedata(params, rowStart, rowEnd);
    }

    @Override
    public long findSharedataTotalCount(Map params) {
        return repository.findSharedataTotalCount(params);
    }
}
