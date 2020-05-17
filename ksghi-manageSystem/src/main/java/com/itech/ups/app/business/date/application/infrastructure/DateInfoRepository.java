package com.itech.ups.app.business.date.application.infrastructure;

import com.itech.ups.app.user.application.domain.DateInfo;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DateInfoRepository extends AbstractRepositoryParent {

    public DateInfo addDateInfo(DateInfo dateInfo) {
        sqlMapClientTemplate.insert("dateInfo.insertDateInfo", dateInfo);
        return dateInfo;
    }

    public Map addMoreDateInfo(Map map) {
        sqlMapClientTemplate.insert("dateInfo.insertMoreDateInfo", map);
        return map;
    }

    public void deleteDateInfo(String time) {
        sqlMapClientTemplate.delete("dateInfo.deleteDateInfo", time);
    }

    public void deleteDateInfoByYear(String year) {
        sqlMapClientTemplate.delete("dateInfo.deleteDateInfoByYear", year);
    }

    public DateInfo findDateInfoByDate(String time) {
        DateInfo dateInfo = (DateInfo) sqlMapClientTemplate.queryForObject("dateInfo.selectDateInfoByDate", time);
        return dateInfo;
    }

    public List findDateInfoByYear(String year) {
        List dateInfoList = sqlMapClientTemplate.queryForList("dateInfo.selectDateInfoByYear", year);
        return dateInfoList;
    }

    public List<DateInfo> findNextWorkday(String time) {
        List<DateInfo> dateInfoList = sqlMapClientTemplate.queryForList("dateInfo.selectNextWorkday", time);
        return dateInfoList;
    }
}