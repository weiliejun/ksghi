package com.itech.ups.app.business.xsyrgl.application.infrastruture;

import com.itech.ups.app.xsrygl.application.domain.Xsrygl;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class XsryglRepository extends AbstractRepositoryParent {

    public Xsrygl addXsrygl(Xsrygl xsrygl) {
        xsrygl.setId(generateIdentifier());
        sqlMapClientTemplate.insert("KSGHI_XSRYGL.insertSelective", xsrygl);
        return xsrygl;
    }

    public List<Xsrygl> findXsrygl(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<Xsrygl>) sqlMapClientTemplate.queryForList("KSGHI_XSRYGL.selectXsrygl", params);
    }

    public Xsrygl findXsryglById(String id) {
        Xsrygl xsrygl = (Xsrygl) sqlMapClientTemplate.queryForObject("KSGHI_XSRYGL.selectByPrimaryKey", id);
        return xsrygl;
    }

    public Xsrygl findXsryglByName(String name) {
        Xsrygl xsrygl = (Xsrygl) sqlMapClientTemplate.queryForObject("KSGHI_XSRYGL.findXsryglByName", name);
        return xsrygl;
    }


    public int findXsryglCount(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("KSGHI_XSRYGL.selectXsryglTotalCount", params);
    }

    public Xsrygl updateXsrygl(Xsrygl xsrygl) {
        sqlMapClientTemplate.update("KSGHI_XSRYGL.updateByPrimaryKeySelective", xsrygl);
        return xsrygl;
    }

}
