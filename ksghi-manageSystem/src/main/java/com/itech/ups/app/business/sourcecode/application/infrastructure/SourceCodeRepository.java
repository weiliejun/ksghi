package com.itech.ups.app.business.sourcecode.application.infrastructure;

import com.itech.ups.app.sourcecode.application.domain.SourceCode;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @功能：
 * @作者：jxc @时间：2017/1/11
 */
@Repository
public class SourceCodeRepository extends AbstractRepositoryParent {

    public List<SourceCode> selectSourceCodesByParam(Map<String, Object> params) {
        return sqlMapClientTemplate.queryForList("sourceCode.selectSourceCodesByParam", params);
    }

    public Integer selectSourceCodesCountByParam(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("sourceCode.selectSourceCodesCountByParam", params);
    }

    public SourceCode selectSourceCodeById(String id) {
        return (SourceCode) sqlMapClientTemplate.queryForObject("sourceCode.selectSourceCodeById", id);
    }

    public void updateSourceCode(SourceCode sourceCode) {
        sqlMapClientTemplate.update("sourceCode.updateSourceCode", sourceCode);
    }

    public void addSourceCode(SourceCode sourceCode) {
        sourceCode.setId(generateIdentifier());
        sqlMapClientTemplate.insert("sourceCode.addSourceCode", sourceCode);
    }

    public SourceCode findSourceCodeByCode(String code) {
        return (SourceCode) sqlMapClientTemplate.queryForObject("sourceCode.findSourceCodeByCode", code);
    }
}
