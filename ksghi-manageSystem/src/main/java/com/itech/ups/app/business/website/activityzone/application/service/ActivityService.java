package com.itech.ups.app.business.website.activityzone.application.service;

import com.itech.ups.app.activityzone.application.domain.ActivityZone;

import java.util.List;
import java.util.Map;


/*
 * @author  huangguohu  2015-08-18
 */

public interface ActivityService {

    ActivityZone addActivity(ActivityZone activityzone);

    ActivityZone editActivity(ActivityZone activityzone);

    ActivityZone findActivityById(String id);

    @SuppressWarnings({"rawtypes"})
    List<ActivityZone> findActivityList(Map params, int rowStart, int rowEnd);

    @SuppressWarnings("rawtypes")
    long findActivityTotalCount(Map params);
}
