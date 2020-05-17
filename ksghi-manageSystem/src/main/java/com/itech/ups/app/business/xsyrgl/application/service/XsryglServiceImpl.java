package com.itech.ups.app.business.xsyrgl.application.service;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.xsyrgl.application.infrastruture.XsryglRepository;
import com.itech.ups.app.xsrygl.application.domain.Xsrygl;
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
@Service("XsryglService")
public class XsryglServiceImpl extends AbstractServiceParent implements XsryglService {
    @Autowired
    private XsryglRepository repository;

    @Override
    public Xsrygl addXsrygl(Xsrygl xsrygl) {
        xsrygl.setDataStatus("valid"); // invalid-删除 valid有效
        xsrygl.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        return repository.addXsrygl(xsrygl);
    }

    @Override
    public void deleteXsrygl(Xsrygl xsrygl) {
        xsrygl.setDataStatus("invalid");
        repository.updateXsrygl(xsrygl);
    }

    @Override
    public Xsrygl editXsrygl(Xsrygl xsrygl) {
        return repository.updateXsrygl(xsrygl);
    }

    @Override
    public List<Xsrygl> findXsrygl(Map<String, Object> params, int rowStart, int rowEnd) {
        return repository.findXsrygl(params, rowStart, rowEnd);
    }

    @Override
    public Xsrygl findXsryglById(String id) {
        return repository.findXsryglById(id);
    }

    @Override
    public long findXsryglCount(Map<String, Object> params) {
        return repository.findXsryglCount(params);
    }

}