package com.itech.ups.app.business.timer.job;

import com.itech.core.util.DateAPI;
import com.itech.ups.app.business.date.application.service.DateInfoService;
import com.itech.ups.base.web.components.AbstractComponentParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自动添加 当前年的日期信息 xsp 2017-06-20
 */
@Component(value = "autoAddDateInfo")
public class AutoAddDateInfo extends AbstractComponentParent {

    @Autowired
    private DateInfoService dateInfoService;

    // 每年1月1日0点执行
    @Scheduled(cron = "0 0 0 1 1 ?")
    public void execute() throws Exception {
        Map map = new HashMap();
        // 获取当前年的节假日
        List<Map<String, String>> list = DateAPI.getWorkDays();
        map.put("dateInfoList", list);
        Calendar a = Calendar.getInstance();
        int year = a.get(Calendar.YEAR);
        // 先将当前年份的数据删除
        dateInfoService.deleteDateInfoByYear(String.valueOf(year));
        dateInfoService.addMoreDateInfo(map);
    }
}
