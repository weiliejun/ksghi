package com.itech.ups.app.business.wnxInfo.application.service;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.wnxInfo.application.infrastruture.WnxInfoRepository;
import com.itech.ups.app.wnxinfo.application.domain.WnxInfo;
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
@Service("WnxInfoService")
public class WnxInfoServiceImpl extends AbstractServiceParent implements WnxInfoService {
    @Autowired
    private WnxInfoRepository repository;

    @Override
    public WnxInfo addWnxInfo(WnxInfo ccxbd) {
        ccxbd.setDataStatus("valid"); // invalid-删除 valid有效
        ccxbd.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        return repository.addWnxInfo(ccxbd);
    }

    @Override
    public void deleteWnxInfo(WnxInfo ccxbd) {
        ccxbd.setDataStatus("invalid");
        repository.updateWnxInfo(ccxbd);
    }

    @Override
    public WnxInfo editWnxInfo(WnxInfo ccxbd) {
        return repository.updateWnxInfo(ccxbd);
    }

    @Override
    public List<WnxInfo> findWnxInfo(Map<String, Object> params, int rowStart, int rowEnd) {
        return repository.findWnxInfo(params, rowStart, rowEnd);
    }

    @Override
    public WnxInfo findWnxInfoById(String id) {
        return repository.findWnxInfoById(id);
    }

    @Override
    public long findWnxInfoCount(Map<String, Object> params) {
        return repository.findWnxInfoCount(params);
    }

}