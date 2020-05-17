package com.itech.ups.app.business.stats.application.infrastructure;

import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 张可乐
 * @version 1.0
 * @description 互联网金融信息披露数据、企业数据报送
 * @update 2017-9-19 下午3:09:23
 */
@Repository
public class OperatorDataRepository extends AbstractRepositoryParent {

    public List<Map<String, Object>> selectFinancialDisclosure(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return sqlMapClientTemplate.queryForList("operatorData.selectFinancialDisclosure", params);
    }

    public int selectFinancialDisclosureTotalCount(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("operatorData.selectFinancialDisclosureTotalCount", params);
    }

    public List<Map<String, Object>> selectenterpriseData(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return sqlMapClientTemplate.queryForList("operatorData.selectenterpriseData", params);
    }

    public int selectenterpriseDataTotalCount(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("operatorData.selectenterpriseDataTotalCount", params);
    }


}
