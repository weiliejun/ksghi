package com.itech.ups.app.business.stats.application.service;

import com.itech.ups.app.business.stats.application.infrastructure.OperatorDataRepository;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OperatorDataServiceImp extends AbstractServiceParent implements OperatorDataService {

    @Autowired
    public OperatorDataRepository operatorDataRepository;


    @Override
    public List<Map<String, Object>> selectFinancialDisclosure(
            Map<String, Object> params, int rowStart, int rowEnd) {
        return operatorDataRepository.selectFinancialDisclosure(params, rowStart, rowEnd);
    }

    @Override
    public int selectFinancialDisclosureTotalCount(Map<String, Object> params) {
        return operatorDataRepository.selectFinancialDisclosureTotalCount(params);
    }

    @Override
    public List<Map<String, Object>> selectenterpriseData(
            Map<String, Object> params, int rowStart, int rowEnd) {
        return operatorDataRepository.selectenterpriseData(params, rowStart, rowEnd);
    }

    @Override
    public int selectenterpriseDataTotalCount(Map<String, Object> params) {
        return operatorDataRepository.selectenterpriseDataTotalCount(params);
    }

}
