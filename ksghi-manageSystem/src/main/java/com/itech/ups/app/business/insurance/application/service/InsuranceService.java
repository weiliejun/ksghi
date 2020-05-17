package com.itech.ups.app.business.insurance.application.service;

import com.itech.ups.app.insurance.application.domain.InsuranceBooking;
import com.itech.ups.app.insurance.application.domain.InsuranceSalesRecord;
import com.itech.ups.app.insurance.application.domain.ProductInsurance;

import java.util.List;
import java.util.Map;


/*
 * @author  daishuli  2015-09-06
 */
public interface InsuranceService {

    InsuranceSalesRecord addInsuranceSalesRecord(InsuranceSalesRecord insuranceSalesRecord);

    ProductInsurance addProductInsurance(ProductInsurance productInsurance);

    InsuranceBooking editInsuranceBooking(InsuranceBooking insuranceBooking);

    InsuranceSalesRecord editInsuranceSalesRecord(InsuranceSalesRecord insuranceSalesRecord);

    ProductInsurance editProductInsurance(ProductInsurance productInsurance);

    InsuranceBooking findInsuranceBookingById(String id);

    Map<String, Object> findInsuranceBookingForBookingTotalCount();

    Map<String, Object> findInsuranceBookingForIdNoById(String id);

    List<Map<String, Object>> findInsuranceBookings(Map<String, Object> param, int rowStart, int rowEnd);

    Integer findInsuranceBookingsTotalCount(Map<String, Object> param);

    List<Map<String, Object>> findInsuranceProducts(Map<String, Object> param, int rowStart, int rowEnd);

    List<Map<String, Object>> findInsuranceProductsForSale(Map<String, Object> param, int rowStart, int rowEnd);

    Integer findInsuranceProductsForSaleTotalCount(Map<String, Object> param);

    Integer findInsuranceProductsTotalCount(Map<String, Object> param);

    Map<String, Object> findInsuranceSalesDetailForCustomerAndInsuranceTotalCount(Map<String, Object> param);

    List<Map<String, Object>> findInsuranceSalesDetails(Map<String, Object> param, int rowStart, int rowEnd);

    Integer findInsuranceSalesDetailsTotalCount(Map<String, Object> param);

    InsuranceSalesRecord findInsuranceSalesRecordByProductId(String productId);

    List<Map<String, Object>> findProductInsuranceByCode(String code);

    ProductInsurance findProductInsuranceById(String id);
}