package com.itech.ups.app.business.wnxInfo.application.service;


import com.itech.ups.app.wnxinfo.application.domain.WnxInfo;

import java.util.List;
import java.util.Map;


public interface WnxInfoService {

    public WnxInfo addWnxInfo(WnxInfo wnxInfo);

    public void deleteWnxInfo(WnxInfo wnxInfo);

    public WnxInfo editWnxInfo(WnxInfo wnxInfo);

    public List<WnxInfo> findWnxInfo(Map<String, Object> params, int rowStart, int rowEnd);

    public WnxInfo findWnxInfoById(String id);

    public long findWnxInfoCount(Map<String, Object> params);

}
