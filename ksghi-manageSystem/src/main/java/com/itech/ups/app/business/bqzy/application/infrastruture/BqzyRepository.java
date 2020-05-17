package com.itech.ups.app.business.bqzy.application.infrastruture;

import com.itech.ups.app.bqinfo.application.domain.BqInfo;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BqzyRepository extends AbstractRepositoryParent {

    public BqInfo addBqInfo(BqInfo bqInfo) {
        bqInfo.setId(generateIdentifier());
        sqlMapClientTemplate.insert("KSGHI_BQ_INFO.insertSelective", bqInfo);
        return bqInfo;
    }

    public List<BqInfo> findBqInfo(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<BqInfo>) sqlMapClientTemplate.queryForList("KSGHI_BQ_INFO.selectBqInfo", params);
    }

    public BqInfo findBqInfoById(String id) {
        BqInfo bqInfo = (BqInfo) sqlMapClientTemplate.queryForObject("KSGHI_BQ_INFO.selectByPrimaryKey", id);
        return bqInfo;
    }

    public int findBqInfoCount(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("KSGHI_BQ_INFO.selectBqInfoTotalCount", params);
    }

    public BqInfo updateBqInfo(BqInfo bqInfo) {
        sqlMapClientTemplate.update("KSGHI_BQ_INFO.updateByPrimaryKeySelective", bqInfo);
        return bqInfo;
    }

}
