package com.itech.ups.app.business.website.advertise.application.service;

import com.itech.core.util.CodeHelper;
import com.itech.ups.app.advertise.application.domain.Advertise;
import com.itech.ups.app.business.website.advertise.application.infrastructure.AdvertiseRepository;
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
 * @version 1.0, 2014-5-5
 * @author  zhaoyl
 * ===========================================================================
 *
 */
@Service("AdvertiseService")
public class AdvertiseServiceImp extends AbstractServiceParent implements AdvertiseService {

    @Autowired
    private AdvertiseRepository repository;

    public Advertise addAdvertise(Advertise advertise) {
        advertise.setDataStatus("valid"); // invalid-删除 valid有效
        advertise.setClicks(new Long(0));
        return repository.addAdvertise(advertise);
    }

    public void deleteAdvertise(Advertise advertise) {
        advertise.setDataStatus("invalid");
        repository.editAdvertise(advertise);
    }

    @Override
    public Advertise editAdvertise(Advertise advertise) {
        return repository.editAdvertise(advertise);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Advertise> findAdvertise(Map params, int rowStart, int rowEnd) {
        List<Advertise> advertiseList = repository.findAdvertise(params, rowStart, rowEnd);
        for (Advertise a : advertiseList) {
            a.setChannel(CodeHelper.getValueByCode("advertise.location", a.getChannel()));
            // String[] codes= a.getCode().split("-");
            // a.setCode(codes[1]);
        }
        return advertiseList;
    }

    @Override
    public Advertise findAdvertise(String id) {
        return repository.findAdvertise(id);
    }

    public Advertise findAdvertiseByCode(String code) {
        return repository.findAdvertiseByCode(code);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public long findAdvertisesTotalCount(Map params) {
        return repository.findAdvertisesTotalCount(params);
    }
}