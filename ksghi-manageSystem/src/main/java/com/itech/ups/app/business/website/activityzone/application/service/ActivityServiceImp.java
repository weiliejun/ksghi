package com.itech.ups.app.business.website.activityzone.application.service;

import com.itech.ups.app.activityzone.application.domain.ActivityZone;
import com.itech.ups.app.business.website.activityzone.application.infrastructure.ActivityRepository;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("activityservice")
public class ActivityServiceImp extends AbstractServiceParent implements ActivityService {
    @Autowired
    private ActivityRepository activityrepository;

    @Override
    public ActivityZone addActivity(ActivityZone activityzone) {
        // TODO Auto-generated method stub
        return activityrepository.addActivity(activityzone);
    }

    @Override
    public ActivityZone editActivity(ActivityZone activityzone) {
        // TODO Auto-generated method stub
        return activityrepository.editActivity(activityzone);
    }

    @Override
    public ActivityZone findActivityById(String id) {
        // TODO Auto-generated method stub
        return activityrepository.findActivityById(id);
    }

    @SuppressWarnings({"rawtypes"})
    @Override
    public List<ActivityZone> findActivityList(Map params, int rowStart, int rowEnd) {
        // TODO Auto-generated method stub
        List<ActivityZone> activityzonelist = activityrepository.findActivity(params, rowStart, rowEnd);
        for (ActivityZone a : activityzonelist) {
            String date = "";
            if (a.getStartDate() != null && a.getEndDate() != null) {
                date = a.getStartDate() + "至" + a.getEndDate();
                a.setStartDate(date);
            } else {
                a.setStartDate("长期有效");
            }
        }
        return activityzonelist;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public long findActivityTotalCount(Map params) {
        return activityrepository.findActivityTotalCount(params);
    }

}