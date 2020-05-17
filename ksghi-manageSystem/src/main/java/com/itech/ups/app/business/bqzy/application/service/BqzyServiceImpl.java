package com.itech.ups.app.business.bqzy.application.service;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.bqinfo.application.domain.BqInfo;
import com.itech.ups.app.business.bqzy.application.infrastruture.BqzyRepository;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2019-12-20
 * @author  魏列军
 * ===========================================================================
 *
 */
@Service("BqzyService")
public class BqzyServiceImpl extends AbstractServiceParent implements BqzyService {
    @Autowired
    private BqzyRepository repository;

    @Override
    public BqInfo addBqInfo(BqInfo bqInfo) {
        bqInfo.setDataStatus("valid"); // invalid-删除 valid有效
        bqInfo.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        return repository.addBqInfo(bqInfo);
    }

    @Override
    public void deleteBqInfo(BqInfo bqInfo) {
        bqInfo.setDataStatus("invalid");
        repository.updateBqInfo(bqInfo);
    }

    @Override
    public BqInfo editBqInfo(BqInfo bqInfo) {
        return repository.updateBqInfo(bqInfo);
    }

    @Override
    public List<BqInfo> findBqInfo(Map<String, Object> params, int rowStart, int rowEnd) {
        return repository.findBqInfo(params, rowStart, rowEnd);
    }

    @Override
    public BqInfo findBqInfoById(String id) {
        return repository.findBqInfoById(id);
    }

    @Override
    public long findBqInfoCount(Map<String, Object> params) {
        return repository.findBqInfoCount(params);
    }

}