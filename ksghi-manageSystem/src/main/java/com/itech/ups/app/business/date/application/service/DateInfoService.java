package com.itech.ups.app.business.date.application.service;

import com.itech.ups.app.user.application.domain.DateInfo;

import java.util.List;
import java.util.Map;


public interface DateInfoService {

    DateInfo addDateInfo(DateInfo dateInfo);

    Map addMoreDateInfo(Map map);

    void deleteDateInfo(String time);

    void deleteDateInfoByYear(String year);

    DateInfo findDateInfoByDate(String time);

    List findDateInfoByYear(String year);

}