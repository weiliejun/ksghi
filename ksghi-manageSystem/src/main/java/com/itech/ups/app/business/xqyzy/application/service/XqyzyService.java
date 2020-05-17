package com.itech.ups.app.business.xqyzy.application.service;


import com.itech.ups.app.business.xqyzy.action.XqyInfoImportData;
import com.itech.ups.app.xqyinfo.application.domain.XqyInfo;

import java.util.List;
import java.util.Map;


public interface XqyzyService {

    public XqyInfo addXqyInfo(XqyInfo xqyInfo);

    public void deleteXqyInfo(XqyInfo xqyInfo);

    public XqyInfo editXqyInfo(XqyInfo xqyInfo);

    public List<XqyInfo> findXqyInfo(Map<String, Object> params, int rowStart, int rowEnd);

    public XqyInfo findXqyInfoByBdh(String bdh);

    public XqyInfo findXqyInfoById(String id);

    public long findXqyInfoCount(Map<String, Object> params);

    public void addXqyInfos(List<XqyInfoImportData> list);


}
