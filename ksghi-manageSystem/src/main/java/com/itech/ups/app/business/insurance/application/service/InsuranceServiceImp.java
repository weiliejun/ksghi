package com.itech.ups.app.business.insurance.application.service;

import com.itech.ups.app.business.insurance.application.infrastructure.InsuranceRepository;
import com.itech.ups.app.insurance.application.domain.InsuranceBooking;
import com.itech.ups.app.insurance.application.domain.InsuranceSalesRecord;
import com.itech.ups.app.insurance.application.domain.ProductInsurance;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * @author  daishuli  2015-09-06
 */
@Service("InsuranceService")
public class InsuranceServiceImp extends AbstractServiceParent implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public InsuranceSalesRecord addInsuranceSalesRecord(InsuranceSalesRecord insuranceSalesRecord) {
        return insuranceRepository.addInsuranceSalesRecord(insuranceSalesRecord);
    }

    @Override
    public ProductInsurance addProductInsurance(ProductInsurance productInsurance) {
        return insuranceRepository.addProductInsurance(productInsurance);
    }

    @Override
    public InsuranceBooking editInsuranceBooking(InsuranceBooking insuranceBooking) {
        return insuranceRepository.editInsuranceBooking(insuranceBooking);
    }

    @Override
    public InsuranceSalesRecord editInsuranceSalesRecord(InsuranceSalesRecord insuranceSalesRecord) {
        return insuranceRepository.editInsuranceSalesRecord(insuranceSalesRecord);
    }

    @Override
    public ProductInsurance editProductInsurance(ProductInsurance productInsurance) {
        return insuranceRepository.editProductInsurance(productInsurance);
    }

    @Override
    public InsuranceBooking findInsuranceBookingById(String id) {
        return insuranceRepository.findInsuranceBookingById(id);
    }

    @Override
    public Map<String, Object> findInsuranceBookingForBookingTotalCount() {
        return insuranceRepository.findInsuranceBookingForBookingTotalCount();
    }

    @Override
    public Map<String, Object> findInsuranceBookingForIdNoById(String id) {
        return insuranceRepository.findInsuranceBookingForIdNoById(id);
    }

    @Override
    public List<Map<String, Object>> findInsuranceBookings(Map<String, Object> param, int rowStart, int rowEnd) {
        List<Map<String, Object>> list = insuranceRepository.findInsuranceBookings(param, rowStart, rowEnd);
        return list;
    }

    @Override
    public Integer findInsuranceBookingsTotalCount(Map<String, Object> param) {
        return insuranceRepository.findInsuranceBookingsTotalCount(param);
    }

    @Override
    public List<Map<String, Object>> findInsuranceProducts(Map<String, Object> param, int rowStart, int rowEnd) {
        List<Map<String, Object>> list = insuranceRepository.findInsuranceProducts(param, rowStart, rowEnd);
        return list;
    }

    @Override
    public List<Map<String, Object>> findInsuranceProductsForSale(Map<String, Object> param, int rowStart, int rowEnd) {
        List<Map<String, Object>> list = insuranceRepository.findInsuranceProductsForSale(param, rowStart, rowEnd);
        return list;
    }

    @Override
    public Integer findInsuranceProductsForSaleTotalCount(Map<String, Object> param) {
        return insuranceRepository.findInsuranceProductsForSaleTotalCount(param);
    }

    @Override
    public Integer findInsuranceProductsTotalCount(Map<String, Object> param) {
        return insuranceRepository.findInsuranceProductsTotalCount(param);
    }

    @Override
    public Map<String, Object> findInsuranceSalesDetailForCustomerAndInsuranceTotalCount(Map<String, Object> param) {
        return insuranceRepository.findInsuranceSalesDetailForCustomerAndInsuranceTotalCount(param);
    }

    @Override
    public List<Map<String, Object>> findInsuranceSalesDetails(Map<String, Object> param, int rowStart, int rowEnd) {
        List<Map<String, Object>> list = insuranceRepository.findInsuranceSalesDetails(param, rowStart, rowEnd);
        return list;
    }

    @Override
    public Integer findInsuranceSalesDetailsTotalCount(Map<String, Object> param) {
        return insuranceRepository.findInsuranceSalesDetailsTotalCount(param);
    }

    @Override
    public InsuranceSalesRecord findInsuranceSalesRecordByProductId(String productId) {
        return insuranceRepository.findInsuranceSalesRecordByProductId(productId);
    }

    @Override
    public List<Map<String, Object>> findProductInsuranceByCode(String code) {
        return insuranceRepository.findProductInsuranceByCode(code);
    }

    @Override
    public ProductInsurance findProductInsuranceById(String id) {
        return insuranceRepository.findProductInsuranceById(id);
    }
}