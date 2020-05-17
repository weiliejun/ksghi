package com.itech.ups.app.business.fjxInfo.application.service;


import com.itech.ups.app.fjxinfo.application.domain.FjxInfo;

import java.util.List;
import java.util.Map;


public interface FjxInfoService {

    public FjxInfo addFjxInfo(FjxInfo xqyInfo);

    public void deleteFjxInfo(FjxInfo xqyInfo);

    public FjxInfo editFjxInfo(FjxInfo xqyInfo);

    public List<FjxInfo> findFjxInfo(Map<String, Object> params, int rowStart, int rowEnd);

    public FjxInfo findFjxInfoById(String id);

    public long findFjxInfoCount(Map<String, Object> params);

    public List<FjxInfo> findFjxInfosByXqyId(String xqyId);
}
