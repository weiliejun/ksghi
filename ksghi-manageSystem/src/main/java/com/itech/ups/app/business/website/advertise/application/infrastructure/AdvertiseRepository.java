package com.itech.ups.app.business.website.advertise.application.infrastructure;

import com.itech.ups.app.advertise.application.domain.Advertise;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

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
@Repository
public class AdvertiseRepository extends AbstractRepositoryParent {

    public Advertise addAdvertise(Advertise advertise) {
        advertise.setId(generateIdentifier());
        sqlMapClientTemplate.insert("website.insertAdvertise", advertise);
        return advertise;
    }

    public Advertise editAdvertise(Advertise advertise) {
        sqlMapClientTemplate.update("website.updateAdvertise", advertise);
        return advertise;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<Advertise> findAdvertise(Map params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        List<Advertise> results = sqlMapClientTemplate.queryForList("website.selectAdvertises", params);
        return results;
    }

    public Advertise findAdvertise(String id) {
        Advertise advertise = (Advertise) sqlMapClientTemplate.queryForObject("website.selectAdvertise", id);
        return advertise;
    }

    public Advertise findAdvertiseByCode(String code) {
        Advertise advertise = (Advertise) sqlMapClientTemplate.queryForObject("website.selectAdvertiseByCode", code);
        return advertise;
    }

    @SuppressWarnings("rawtypes")
    public long findAdvertisesTotalCount(Map params) {
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("website.selectAdvertisesTotalCount", params);
        return totalCount;
    }
}