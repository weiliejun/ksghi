package com.itech.ups.app.business.website.advertise.application.service;

import com.itech.ups.app.advertise.application.domain.Advertise;

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

public interface AdvertiseService {

    Advertise addAdvertise(Advertise advertise);

    void deleteAdvertise(Advertise advertise);

    Advertise editAdvertise(Advertise advertise);

    @SuppressWarnings({"rawtypes"})
    List<Advertise> findAdvertise(Map params, int rowStart, int rowEnd);

    Advertise findAdvertise(String id);

    Advertise findAdvertiseByCode(String code);

    @SuppressWarnings("rawtypes")
    long findAdvertisesTotalCount(Map params);
}
