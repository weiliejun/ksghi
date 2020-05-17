package com.itech.ups.app.business.wnxInfo.application.infrastruture;

import com.itech.ups.app.wnxinfo.application.domain.WnxInfo;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WnxInfoRepository extends AbstractRepositoryParent {

    public WnxInfo addWnxInfo(WnxInfo wnxInfo) {
        wnxInfo.setId(generateIdentifier());
        sqlMapClientTemplate.insert("KSGHI_WNX_INFO.insertSelective", wnxInfo);
        return wnxInfo;
    }

    public List<WnxInfo> findWnxInfo(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<WnxInfo>) sqlMapClientTemplate.queryForList("KSGHI_WNX_INFO.selectWnxInfo", params);
    }

    public WnxInfo findWnxInfoById(String id) {
        WnxInfo wnxInfo = (WnxInfo) sqlMapClientTemplate.queryForObject("KSGHI_WNX_INFO.selectByPrimaryKey", id);
        return wnxInfo;
    }

    public int findWnxInfoCount(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("KSGHI_WNX_INFO.selectWnxInfoTotalCount", params);
    }

    public WnxInfo updateWnxInfo(WnxInfo wnxInfo) {
        sqlMapClientTemplate.update("KSGHI_WNX_INFO.updateByPrimaryKeySelective", wnxInfo);
        return wnxInfo;
    }

}
