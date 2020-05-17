package com.itech.ups.app.business.date.application.service;

import com.itech.ups.app.business.date.application.infrastructure.DateInfoRepository;
import com.itech.ups.app.user.application.domain.DateInfo;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dateInfoService")
public class DateInfoServiceImp extends AbstractServiceParent implements DateInfoService {

    @Autowired
    private DateInfoRepository repository;

    @Override
    public DateInfo addDateInfo(DateInfo dateInfo) {
        return repository.addDateInfo(dateInfo);
    }

    @Override
    public Map addMoreDateInfo(Map map) {
        return repository.addMoreDateInfo(map);
    }

    @Override
    public void deleteDateInfo(String time) {
        repository.deleteDateInfo(time);
    }

    @Override
    public void deleteDateInfoByYear(String year) {
        repository.deleteDateInfoByYear(year);
    }

    @Override
    public DateInfo findDateInfoByDate(String time) {
        return repository.findDateInfoByDate(time);
    }

    @Override
    public List findDateInfoByYear(String year) {
        return repository.findDateInfoByYear(year);
    }

}
