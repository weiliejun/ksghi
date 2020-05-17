package com.itech.ups.app.business.ccxbd.application.infrastruture;

import com.itech.ups.app.ccxbd.application.domain.Ccxbd;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CcxbdRepository extends AbstractRepositoryParent {

    public Ccxbd addCcxbd(Ccxbd ccxbd) {
        ccxbd.setId(generateIdentifier());
        sqlMapClientTemplate.insert("KSGHI_CCXBD.insertSelective", ccxbd);
        return ccxbd;
    }

    public List<Ccxbd> findCcxbd(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<Ccxbd>) sqlMapClientTemplate.queryForList("KSGHI_CCXBD.selectCcxbd", params);
    }

    public Ccxbd findCcxbdById(String id) {
        Ccxbd ccxbd = (Ccxbd) sqlMapClientTemplate.queryForObject("KSGHI_CCXBD.selectByPrimaryKey", id);
        return ccxbd;
    }

    public int findCcxbdCount(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("KSGHI_CCXBD.selectCcxbdTotalCount", params);
    }

    public Ccxbd updateCcxbd(Ccxbd ccxbd) {
        sqlMapClientTemplate.update("KSGHI_CCXBD.updateByPrimaryKeySelective", ccxbd);
        return ccxbd;
    }

    public void deleteCcxbd(String id) {
        sqlMapClientTemplate.delete("KSGHI_CCXBD.deleteByPrimaryKey", id);
    }

}
