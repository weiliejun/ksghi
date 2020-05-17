package com.itech.ups.app.business.fjxInfo.application.infrastruture;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.fjxinfo.application.domain.FjxInfo;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class FjxInfoRepository extends AbstractRepositoryParent {

    public FjxInfo addFjxInfo(FjxInfo xqyInfo) {
        xqyInfo.setId(generateIdentifier());
        xqyInfo.setDataStatus("valid"); // invalid-删除 valid有效
        xqyInfo.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        sqlMapClientTemplate.insert("KSGHI_FJX_INFO.insertSelective", xqyInfo);
        return xqyInfo;
    }

    public List<FjxInfo> findFjxInfo(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);

        return (List<FjxInfo>) sqlMapClientTemplate.queryForList("KSGHI_FJX_INFO.selectFjxInfo", params);
    }

    public FjxInfo findFjxInfoById(String id) {
        FjxInfo xqyInfo = (FjxInfo) sqlMapClientTemplate.queryForObject("KSGHI_FJX_INFO.selectByPrimaryKey", id);
        return xqyInfo;
    }

    public int findFjxInfoCount(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("KSGHI_FJX_INFO.selectFjxInfoTotalCount", params);
    }

    public FjxInfo updateFjxInfo(FjxInfo xqyInfo) {
        sqlMapClientTemplate.update("KSGHI_FJX_INFO.updateByPrimaryKeySelective", xqyInfo);
        return xqyInfo;
    }

    public List<FjxInfo> findFjxInfosByXqyId(String xqyId) {
        FjxInfo fjxInfo = new FjxInfo();
        fjxInfo.setXqyId(xqyId);
//        fjxInfo.setZfx("附加险");
        List<FjxInfo> fjxInfoList = (List<FjxInfo>) sqlMapClientTemplate.queryForList("KSGHI_FJX_INFO.findFjxInfosByXqyId", xqyId);
        if (fjxInfoList == null || fjxInfoList.size() == 0) {
            fjxInfoList.add(fjxInfo);
        }
        return fjxInfoList;
    }
}
