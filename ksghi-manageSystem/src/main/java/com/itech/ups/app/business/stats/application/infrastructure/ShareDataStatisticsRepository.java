package com.itech.ups.app.business.stats.application.infrastructure;

import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ShareDataStatisticsRepository extends AbstractRepositoryParent {

    /*
     * 数据分享数据 2014-12-08 下午 苏冰雪
     */

    public List findSharedata(Map params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        List results = sqlMapClientTemplate.queryForList("sharedatas.selectfindSharedata", params);
        return results;
    }

    public long findSharedataTotalCount(Map params) {
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("sharedatas.selectSharedataTotalCount", params);
        return totalCount;
    }
}
