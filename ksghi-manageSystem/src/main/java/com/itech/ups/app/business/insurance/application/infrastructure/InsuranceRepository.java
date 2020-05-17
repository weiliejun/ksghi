package com.itech.ups.app.business.insurance.application.infrastructure;

import com.itech.core.util.ComDateUtils;
import com.itech.core.util.DateHelper;
import com.itech.ups.app.insurance.application.domain.InsuranceBooking;
import com.itech.ups.app.insurance.application.domain.InsuranceSalesRecord;
import com.itech.ups.app.insurance.application.domain.ProductInsurance;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author  daishuli  2015-09-06
 */
@Repository
public class InsuranceRepository extends AbstractRepositoryParent {

    public InsuranceSalesRecord addInsuranceSalesRecord(InsuranceSalesRecord insuranceSalesRecord) {
        insuranceSalesRecord.setId(generateIdentifier());
        sqlMapClientTemplate.insert("insurancesalesrecord.insertInsuranceSalesRecord", insuranceSalesRecord);
        return insuranceSalesRecord;
    }

    public ProductInsurance addProductInsurance(ProductInsurance productInsurance) {
        sqlMapClientTemplate.insert("productinsurance.insertProductInsurance", productInsurance);
        return productInsurance;
    }

    public InsuranceBooking editInsuranceBooking(InsuranceBooking insuranceBooking) {
        sqlMapClientTemplate.update("insurancebooking.updateInsuranceBooking", insuranceBooking);
        return insuranceBooking;
    }

    public InsuranceSalesRecord editInsuranceSalesRecord(InsuranceSalesRecord insuranceSalesRecord) {
        sqlMapClientTemplate.update("insurancesalesrecord.updateInsuranceSalesRecord", insuranceSalesRecord);
        return insuranceSalesRecord;
    }

    public ProductInsurance editProductInsurance(ProductInsurance productInsurance) {
        sqlMapClientTemplate.update("productinsurance.updateProductInsurance", productInsurance);
        return productInsurance;
    }

    public InsuranceBooking findInsuranceBookingById(String id) {
        return (InsuranceBooking) sqlMapClientTemplate.queryForObject("insurancebooking.selectInsuranceBookingById", id);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> findInsuranceBookingForBookingTotalCount() {
        String currentTime = DateHelper.getYMDHMSFormatDate(new Date());
        Date yesterday = ComDateUtils.getAddDay(-1, DateHelper.getCurrentDate());
        String yesterdayTime = DateHelper.getYMDHMSFormatDate(yesterday);
        String todayTime = DateHelper.getYMDHMSFormatDate(ComDateUtils.getAddDay(1, yesterday));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentTime", currentTime);
        map.put("yesterdayTime", yesterdayTime);
        map.put("todayTime", todayTime);
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("insurancebooking.InsuranceBookingForBookingTotalCount", map);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> findInsuranceBookingForIdNoById(String id) {
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("insurancebooking.selectInsuranceBookingForIdNoById", id);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findInsuranceBookings(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> list = sqlMapClientTemplate.queryForList("insurancebooking.selectInsuranceBookings", map);
        return list;
    }

    public Integer findInsuranceBookingsTotalCount(Map<String, Object> param) {
        return (Integer) sqlMapClientTemplate.queryForObject("insurancebooking.selectInsuranceBookingsTotalCount", param);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findInsuranceProducts(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> list = sqlMapClientTemplate.queryForList("productinsurance.selectInsuranceProducts", map);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findInsuranceProductsForSale(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> list = sqlMapClientTemplate.queryForList("insurancesalesrecord.selectInsuranceProductsForSale", map);
        return list;
    }

    public Integer findInsuranceProductsForSaleTotalCount(Map<String, Object> param) {
        return (Integer) sqlMapClientTemplate.queryForObject("insurancesalesrecord.selectInsuranceProductsForSaleTotalCount", param);
    }

    public Integer findInsuranceProductsTotalCount(Map<String, Object> param) {
        return (Integer) sqlMapClientTemplate.queryForObject("productinsurance.selectInsuranceProductsTotalCount", param);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> findInsuranceSalesDetailForCustomerAndInsuranceTotalCount(Map<String, Object> param) {
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("insurancesalesdetail.selectInsuranceSalesDetailForCustomerAndInsuranceTotalCount", param);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findInsuranceSalesDetails(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> list = sqlMapClientTemplate.queryForList("insurancesalesdetail.selectInsuranceSalesDetails", map);
        return list;
    }

    public Integer findInsuranceSalesDetailsTotalCount(Map<String, Object> param) {
        return (Integer) sqlMapClientTemplate.queryForObject("insurancesalesdetail.selectInsuranceSalesDetailsTotalCount", param);
    }

    public InsuranceSalesRecord findInsuranceSalesRecordByProductId(String productId) {
        return (InsuranceSalesRecord) sqlMapClientTemplate.queryForObject("insurancesalesrecord.selectInsuranceSalesRecordByProductId", productId);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findProductInsuranceByCode(String code) {
        List<Map<String, Object>> list = sqlMapClientTemplate.queryForList("productinsurance.selectProductInsuranceByCode", code);
        return list;
    }

    public ProductInsurance findProductInsuranceById(String id) {
        return (ProductInsurance) sqlMapClientTemplate.queryForObject("productinsurance.selectProductInsuranceById", id);
    }
}