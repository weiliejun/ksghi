package com.itech.ups.app.business.ccxbd.application.service;

import com.itech.core.util.DateHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.ccxbd.application.infrastruture.CcxbdRepository;
import com.itech.ups.app.ccxbd.application.domain.Ccxbd;
import com.itech.ups.app.business.ccxbd.action.CcxbdImportData;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.BeanUtils;
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
@Service("CcxbdService")
public class CcxbdServiceImpl extends AbstractServiceParent implements CcxbdService {
    @Autowired
    private CcxbdRepository repository;

    @Override
    public Ccxbd addCcxbd(Ccxbd ccxbd) {
        ccxbd.setDataStatus("valid"); // invalid-删除 valid有效
        ccxbd.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        return repository.addCcxbd(ccxbd);
    }

    @Override
    public void addCcxbds(List<CcxbdImportData> list) {
        if (list != null && list.size() > 0) {
            for (CcxbdImportData ccxbdImportData : list) {
                Ccxbd ccxbd = new Ccxbd();
                BeanUtils.copyProperties(ccxbdImportData, ccxbd);
                ccxbd.setTbr(ccxbd.getBbr());
                if (StringHelper.isNotBlank(ccxbd.getYjjsrq())) {
                    ccxbd.setSfjs("是");
                } else {
                    ccxbd.setSfjs("否");
                }
                if (StringHelper.isNotBlank(ccxbd.getGbgs())) {
                    ccxbd.setSfgb("是");
                } else {
                    ccxbd.setSfgb("否");
                }
                if (ccxbd.getBbr().contains("公司")) {
                    ccxbd.setTdgr("团队");
                } else {
                    ccxbd.setTdgr("个人");
                }
                addCcxbd(ccxbd);
            }
        }
    }

    @Override
    public void deleteCcxbd(String id) {
        repository.deleteCcxbd(id);
    }

    @Override
    public Ccxbd editCcxbd(Ccxbd ccxbd) {
        return repository.updateCcxbd(ccxbd);
    }

    @Override
    public List<Ccxbd> findCcxbd(Map<String, Object> params, int rowStart, int rowEnd) {
        return repository.findCcxbd(params, rowStart, rowEnd);
    }

    @Override
    public Ccxbd findCcxbdById(String id) {
        return repository.findCcxbdById(id);
    }

    @Override
    public long findCcxbdCount(Map<String, Object> params) {
        return repository.findCcxbdCount(params);
    }

}