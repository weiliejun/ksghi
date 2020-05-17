package com.itech.ups.app.business.bqzy.application.service;


import com.itech.ups.app.bqinfo.application.domain.BqInfo;

import java.util.List;
import java.util.Map;


public interface BqzyService {

    public BqInfo addBqInfo(BqInfo bqInfo);

    public void deleteBqInfo(BqInfo bqInfo);

    public BqInfo editBqInfo(BqInfo bqInfo);

    public List<BqInfo> findBqInfo(Map<String, Object> params, int rowStart, int rowEnd);

    public BqInfo findBqInfoById(String id);

    public long findBqInfoCount(Map<String, Object> params);

}
