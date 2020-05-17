package com.itech.ups.app.business.sourcecode.application.service;

import com.itech.ups.app.sourcecode.application.domain.SourceCode;

import java.util.List;
import java.util.Map;


public interface SourceCodeService {

    List<SourceCode> selectSourceCodesByParam(Map<String, Object> params, int rowStart, int rowEnd);

    Integer selectSourceCodesCountByParam(Map<String, Object> params);

    SourceCode selectSourceCodeById(String id);

    void updateSourceCode(SourceCode sourceCode);

    /**
     * @Description: 保存新增或者编辑的内容
     * @author Jxc
     * @date 2017/2/9
     */
    void saveSourceCode(SourceCode sourceCode);

    SourceCode findSourceCodeByCode(String code);

}
