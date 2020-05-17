package com.itech.ups.app.business.xqyzy.application.infrastruture;

import com.itech.ups.app.xqyinfo.application.domain.XqyInfo;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class XqyzyRepository extends AbstractRepositoryParent {

    public XqyInfo addXqyInfo(XqyInfo xqyInfo) {
        xqyInfo.setId(generateIdentifier());
        sqlMapClientTemplate.insert("KSGHI_XQY_INFO.insertSelective", xqyInfo);
        return xqyInfo;
    }

    public List<XqyInfo> findXqyInfo(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<XqyInfo>) sqlMapClientTemplate.queryForList("KSGHI_XQY_INFO.selectXqyInfo", params);
    }

    public XqyInfo findXqyInfoById(String id) {
        XqyInfo xqyInfo = (XqyInfo) sqlMapClientTemplate.queryForObject("KSGHI_XQY_INFO.selectByPrimaryKey", id);
        return xqyInfo;
    }

    public XqyInfo findXqyInfoByBdh(String bdh) {
        XqyInfo xqyInfo = (XqyInfo) sqlMapClientTemplate.queryForObject("KSGHI_XQY_INFO.selectByBdh", bdh);
        return xqyInfo;
    }

    public int findXqyInfoCount(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("KSGHI_XQY_INFO.selectXqyInfoTotalCount", params);
    }

    public XqyInfo updateXqyInfo(XqyInfo xqyInfo) {
        sqlMapClientTemplate.update("KSGHI_XQY_INFO.updateByPrimaryKeySelective", xqyInfo);
        return xqyInfo;
    }

}
