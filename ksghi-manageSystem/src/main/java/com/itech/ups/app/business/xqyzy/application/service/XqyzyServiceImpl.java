package com.itech.ups.app.business.xqyzy.application.service;

import com.itech.core.util.DateHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.fjxInfo.application.infrastruture.FjxInfoRepository;
import com.itech.ups.app.business.xqyzy.action.XqyInfoImportData;
import com.itech.ups.app.business.xqyzy.application.infrastruture.XqyzyRepository;
import com.itech.ups.app.business.xsyrgl.application.infrastruture.XsryglRepository;
import com.itech.ups.app.fjxinfo.application.domain.FjxInfo;
import com.itech.ups.app.xqyinfo.application.domain.XqyInfo;
import com.itech.ups.app.xsrygl.application.domain.Xsrygl;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
@Service("XqyzyService")
public class XqyzyServiceImpl extends AbstractServiceParent implements XqyzyService {
    @Autowired
    private XqyzyRepository repository;
    @Autowired
    private FjxInfoRepository fjxInfoRepository;
    @Autowired
    private XsryglRepository xsryglRepository;

    @Override
    public XqyInfo addXqyInfo(XqyInfo xqyInfo) {
        xqyInfo.setDataStatus("valid"); // invalid-删除 valid有效
        xqyInfo.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        return repository.addXqyInfo(xqyInfo);
    }

    @Override
    public void deleteXqyInfo(XqyInfo xqyInfo) {
        xqyInfo.setDataStatus("invalid");
        repository.updateXqyInfo(xqyInfo);
    }

    @Override
    public XqyInfo editXqyInfo(XqyInfo xqyInfo) {
        return repository.updateXqyInfo(xqyInfo);
    }

    @Override
    public List<XqyInfo> findXqyInfo(Map<String, Object> params, int rowStart, int rowEnd) {
        return repository.findXqyInfo(params, rowStart, rowEnd);
    }

    @Override
    public XqyInfo findXqyInfoById(String id) {
        return repository.findXqyInfoById(id);
    }

    @Override
    public XqyInfo findXqyInfoByBdh(String bdh) {
        return repository.findXqyInfoByBdh(bdh);
    }

    @Override
    public long findXqyInfoCount(Map<String, Object> params) {
        return repository.findXqyInfoCount(params);
    }

    @Override
    public void addXqyInfos(List<XqyInfoImportData> list) {
        if (list != null && list.size() > 0) {
            HashMap hm = new HashMap();
            for (XqyInfoImportData xqyInfoImportData : list) {
                if (xqyInfoImportData.getXzmc().indexOf("附加") < 0) {
                    XqyInfo xqyzy = new XqyInfo();
                    BeanUtils.copyProperties(xqyInfoImportData, xqyzy);
                    if (StringHelper.isNotBlank(xqyzy.getCjrq())) {
                        xqyzy.setCbshzt("撤件");
                    } else if (StringHelper.isNotBlank(xqyzy.getCdsj())) {
                        xqyzy.setCbshzt("撤单");
                    }
                    if (StringHelper.isNotBlank(xqyzy.getJcrq())) {
                        xqyzy.setYjzt("已寄出");
                    } else if (StringHelper.isNotBlank(xqyzy.getSdrq())) {
                        xqyzy.setYjzt("已收到");
                    } else {
                        xqyzy.setYjzt("未邮寄");
                    }
                    if (StringHelper.isNotBlank(xqyzy.getJsrq())) {
                        xqyzy.setQdjszt("已结算");
                    } else {
                        xqyzy.setQdjszt("未结算");
                    }
                    if (StringHelper.isNotBlank(xqyzy.getCbrq())) {
                        xqyzy.setCbshzt("已承保");
                    } else {
                        xqyzy.setCbshzt("待处理");
                    }

                    //查询销售人员信息
                    Xsrygl ywy = xsryglRepository.findXsryglByName(xqyzy.getYwy());
                    if (ywy != null) {
                        xqyzy.setDlgs(ywy.getSsgs());
                        xqyzy.setDept(ywy.getDept());
                        xqyzy.setYwybh(ywy.getCode());
                    }
                    Xsrygl jsr = xsryglRepository.findXsryglByName(xqyzy.getJsr());
                    if (jsr != null) {
                        xqyzy.setJsrbh(jsr.getCode());
                    }
                    Xsrygl sjxsr = xsryglRepository.findXsryglByName(xqyzy.getSjxsr());
                    if (sjxsr != null) {
                        xqyzy.setSjxsrbh(sjxsr.getCode());
                    }
                    //转换日期格式
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
                    try {
                        if(xqyzy.getTbrq().indexOf("-")>0){
                            xqyzy.setTbrq(xqyzy.getTbrq());
                        }else {
                            xqyzy.setTbrq(sdf.format(df.parse(xqyzy.getTbrq())));
                        }
                        if(xqyzy.getCbrq().indexOf("-")>0){
                            xqyzy.setCbrq(xqyzy.getCbrq());
                        }else {
                            xqyzy.setCbrq(sdf.format(df.parse(xqyzy.getCbrq())));
                        }
                        if(xqyzy.getHzqsrq().indexOf("-")>0){
                            xqyzy.setHzqsrq(xqyzy.getHzqsrq());
                        }else {
                            xqyzy.setHzqsrq(sdf.format(df.parse(xqyzy.getHzqsrq())));
                        }
                        if(xqyzy.getYyqgqrq().indexOf("-")>0){
                            xqyzy.setYyqgqrq(xqyzy.getYyqgqrq());
                        }else {
                            xqyzy.setYyqgqrq(sdf.format(df.parse(xqyzy.getYyqgqrq())));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    //设置生效日期
                    xqyzy.setSxrq(xqyzy.getCbrq());
                    //保存
                    xqyzy = addXqyInfo(xqyzy);
                    hm.put(xqyzy.getTbdh(), xqyzy.getId());
                    System.out.println(xqyzy.getTbdh());
                } else {
                    FjxInfo fjxInfo = new FjxInfo();
                    BeanUtils.copyProperties(xqyInfoImportData, fjxInfo);
                    if(hm.get(xqyInfoImportData.getTbdh())!=null) {
                        fjxInfo.setXqyId(hm.get(xqyInfoImportData.getTbdh()).toString());
                        fjxInfoRepository.addFjxInfo(fjxInfo);
                    }
                }
            }
        }
    }
}