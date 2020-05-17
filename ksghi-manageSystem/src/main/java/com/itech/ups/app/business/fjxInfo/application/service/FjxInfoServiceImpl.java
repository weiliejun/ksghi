package com.itech.ups.app.business.fjxInfo.application.service;

import com.itech.ups.app.business.fjxInfo.application.infrastruture.FjxInfoRepository;
import com.itech.ups.app.fjxinfo.application.domain.FjxInfo;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("FjxInfoService")
public class FjxInfoServiceImpl extends AbstractServiceParent implements FjxInfoService {
    @Autowired
    private FjxInfoRepository repository;

    @Override
    public FjxInfo addFjxInfo(FjxInfo xqyInfo) {
        return repository.addFjxInfo(xqyInfo);
    }

    @Override
    public void deleteFjxInfo(FjxInfo xqyInfo) {
        xqyInfo.setDataStatus("invalid");
        repository.updateFjxInfo(xqyInfo);
    }

    @Override
    public FjxInfo editFjxInfo(FjxInfo xqyInfo) {
        return repository.updateFjxInfo(xqyInfo);
    }

    @Override
    public List<FjxInfo> findFjxInfo(Map<String, Object> params, int rowStart, int rowEnd) {
        return repository.findFjxInfo(params, rowStart, rowEnd);
    }

    @Override
    public FjxInfo findFjxInfoById(String id) {
        return repository.findFjxInfoById(id);
    }

    @Override
    public long findFjxInfoCount(Map<String, Object> params) {
        return repository.findFjxInfoCount(params);
    }

    @Override
    public List<FjxInfo> findFjxInfosByXqyId(String xqyId) {
        return repository.findFjxInfosByXqyId(xqyId);
    }
}