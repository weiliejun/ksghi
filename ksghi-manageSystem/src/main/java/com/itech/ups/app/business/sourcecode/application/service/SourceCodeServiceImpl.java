package com.itech.ups.app.business.sourcecode.application.service;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.sourcecode.application.infrastructure.SourceCodeRepository;
import com.itech.ups.app.sourcecode.application.domain.SourceCode;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("sourceCodeService")
public class SourceCodeServiceImpl extends AbstractServiceParent implements SourceCodeService {

    @Autowired
    private SourceCodeRepository sourceCodeRepository;

    @Override
    public List<SourceCode> selectSourceCodesByParam(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return sourceCodeRepository.selectSourceCodesByParam(params);
    }

    @Override
    public Integer selectSourceCodesCountByParam(Map<String, Object> params) {
        return sourceCodeRepository.selectSourceCodesCountByParam(params);
    }

    @Override
    public SourceCode selectSourceCodeById(String id) {
        return sourceCodeRepository.selectSourceCodeById(id);
    }

    @Override
    public void updateSourceCode(SourceCode sourceCode) {
        sourceCodeRepository.updateSourceCode(sourceCode);
    }

    @Override
    public void saveSourceCode(SourceCode sourceCode) {
        // 判断ID是否为空，然后执行添加或者修改
        if (StringUtils.isBlank(sourceCode.getId())) {
            sourceCode.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
            sourceCode.setDataStatus("valid");
            sourceCodeRepository.addSourceCode(sourceCode);
        } else {
            updateSourceCode(sourceCode);
        }
    }

    @Override
    public SourceCode findSourceCodeByCode(String code) {
        return sourceCodeRepository.findSourceCodeByCode(code);
    }

}
