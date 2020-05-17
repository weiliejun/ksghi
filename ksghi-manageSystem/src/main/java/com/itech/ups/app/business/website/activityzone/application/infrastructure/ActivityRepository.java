package com.itech.ups.app.business.website.activityzone.application.infrastructure;

/*
 * @author  huangguohu  2015-08-18
 */

import com.itech.ups.app.activityzone.application.domain.ActivityZone;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ActivityRepository extends AbstractRepositoryParent {
    public ActivityZone addActivity(ActivityZone activityzone) {
        activityzone.setId(generateIdentifier());
        sqlMapClientTemplate.insert("activityzone.insertSelective", activityzone);
        return activityzone;
    }

    public ActivityZone editActivity(ActivityZone activityzone) {
        sqlMapClientTemplate.update("activityzone.updateByPrimaryKeySelective", activityzone);
        return activityzone;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<ActivityZone> findActivity(Map params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        List<ActivityZone> results = sqlMapClientTemplate.queryForList("activityzone.selectActivityList", params);
        return results;
    }

    public ActivityZone findActivityById(String id) {
        ActivityZone activityzone = (ActivityZone) sqlMapClientTemplate.queryForObject("activityzone.selectByPrimaryKey", id);
        return activityzone;
    }

    @SuppressWarnings("rawtypes")
    public long findActivityTotalCount(Map params) {
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("activityzone.selectActivityTotalCount", params);
        return totalCount;
    }
}