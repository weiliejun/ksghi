package com.itech.ups.app.business.stats.application.service;

import com.itech.ups.app.business.stats.application.infrastructure.StatsRepository;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 版本信息：v1.0 日期：2014年7月1日 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

@Service("statsService")
public class StatsServiceImp extends AbstractServiceParent implements StatsService {

    @Autowired
    private StatsRepository repository;

    @Override
    public List<Map<String, Object>> finaPlannerCustomerInvestByPage(Map<String, Object> param, int rowStart, int rowEnd) {
        return repository.finaPlannerCustomerInvestByPage(param, rowStart, rowEnd);
    }

    @Override
    public Map<String, Object> finaPlannerCustomerInvestTotal(Map<String, Object> param) {
        return repository.finaPlannerCustomerInvestTotal(param);
    }

    @Override
    public List findActivityLotterys(Map<String, Object> params, int rowStart, int rowEnd) {
        return repository.findActivityLotterys(params, rowStart, rowEnd);
    }

    // 奖券统计 苏冰雪 2015-03-26
    @Override
    public long findActivityLotterysTotalCount(Map<String, Object> params) {
        return repository.findActivityLotterysTotalCount(params);
    }

    @Override
    public List findAlreadyPayments(Map<String, Object> params, int rowStart, int rowEnd) {
        return repository.findAlreadyPayments(params, rowStart, rowEnd);
    }

    @Override
    public long findAlreadyPaymentTotalCount(Map<String, Object> params) {
        return repository.findAlreadyPaymentTotalCount(params);
    }

    @Override
    public Map findAlreadyPaymentTotalMap() {
        return repository.findAlreadyPaymentTotalMap();
    }

    @Override
    public List<Map<String, Object>> findFinaPlannerCredits(Map<String, Object> param, int rowStart, int rowEnd) {
        List<Map<String, Object>> list = repository.findFinaPlannerCredits(param, rowStart, rowEnd);
        return list;
    }

    @Override
    public Map<String, Object> findFinaPlannerCreditsTotalCount(Map<String, Object> param) {
        Map<String, Object> map = repository.findFinaPlannerCreditsTotalCount(param);
        return map;
    }

    @Override
    public List<Map<String, Object>> findInsteadRepayments(Map<String, Object> param, int rowStart, int rowEnd) {
        List<Map<String, Object>> list = repository.findInsteadRepayments(param, rowStart, rowEnd);
        return list;
    }

    @Override
    public List<Map<String, Object>> findInsteadRepaymentsTotalInfo(Map<String, Object> param) {
        List<Map<String, Object>> list = repository.findInsteadRepaymentsTotalInfo(param);
        return list;
    }

    @Override
    public List<Map<String, Object>> findInterestReport(Map<String, Object> param, int rowStart, int rowEnd) {
        param.put("rowStart", rowStart);
        param.put("rowEnd", rowEnd);
        List<Map<String, Object>> list = repository.findInterestReport(param);
        return list;
    }

    @Override
    public Map<String, Object> findInterestReportTotalCount(Map<String, Object> param) {
        Map<String, Object> map = repository.findInterestReportTotalCount(param);
        return map;
    }

    @Override
    public List<Map<String, Object>> findMerchantPayments(Map<String, Object> map, int rowStart, int rowEnd) {
        return repository.findMerchantPayments(map, rowStart, rowEnd);
    }

    @Override
    public List findOughtPayments(Map<String, Object> params, int rowStart, int rowEnd) {
        return repository.findOughtPayments(params, rowStart, rowEnd);
    }

    @Override
    public long findOughtPaymentTotalCount(Map<String, Object> params) {
        return repository.findOughtPaymentTotalCount(params);
    }

    @Override
    public Map findOughtPaymentTotalMap() {
        return repository.findOughtPaymentTotalMap();
    }

    @Override
    public List<Map<String, Object>> findPageProductSales(Map<String, Object> map, int rowStart, int rowEnd) {
        return repository.findPageProductSales(map, rowStart, rowEnd);
    }

    @Override
    public List<Map<String, Object>> findPageRecharges(Map<String, Object> map, int rowStart, int rowEnd) {
        return repository.findPageRecharges(map, rowStart, rowEnd);
    }

    @Override
    public List<Map<String, Object>> findPageWithdraws(Map<String, Object> map, int rowStart, int rowEnd) {
        return repository.findPageWithdraws(map, rowStart, rowEnd);
    }

    @Override
    public List<Map<String, Object>> findProductPayments(Map<String, Object> param, int rowStart, int rowEnd) {
        return repository.findProductPayments(param, rowStart, rowEnd);
    }

    @Override
    public Map<String, Object> findProductPaymentsTotalInfo(Map<String, Object> param) {
        return repository.findProductPaymentsTotalInfo(param);
    }

    @Override
    public Map<String, Object> findProductSalesTotalCount(Map<String, Object> map) {
        return repository.findProductSalesTotalCount(map);
    }

    @Override
    public List findPromotionPlans(Map<String, Object> params, int rowStart, int rowEnd) {
        return repository.findPromotionPlans(params, rowStart, rowEnd);
    }

    @Override
    public long findPromotionPlanTotalCount(Map<String, Object> params) {
        return repository.findPromotionPlanTotalCount(params);
    }

    @Override
    public Map findPromotionPlanTotalMap() {
        return repository.findPromotionPlanTotalMap();
    }

    @Override
    public List<Map<String, Object>> findPromptsByRepayPlanDate(Map<String, String> param) {
        return repository.findPromptsByRepayPlanDate(param);
    }

    @Override
    public Map<String, Object> findRechargesTotalCount(Map<String, Object> map) {
        return repository.findRechargesTotalCount(map);
    }

    @Override
    public List<Map<String, Object>> findRepayByRepayPlanDate(Map<String, String> param) {
        return repository.findRepayByRepayPlanDate(param);
    }

    @Override
    public List<Map<String, Object>> findRepayments(Map<String, Object> params) {
        return repository.findRepayments(params);
    }

    @Override
    public List<Map<String, Object>> findTopUser(Map<String, String> param) {
        return repository.findTopUser(param);
    }

    @Override
    public List<Map<String, Object>> findUserincomes(Map<String, Object> param, int rowStart, int rowEnd) {
        List<Map<String, Object>> list = repository.findUserincomes(param, rowStart, rowEnd);
        return list;
    }

    @Override
    public Map<String, Object> findUserincomesTotalInfo(Map<String, Object> param) {
        return repository.findUserincomesTotalInfo(param);
    }

    @Override
    public List<Map<String, Object>> findUserIntegras(Map<String, Object> map, int rowStart, int rowEnd) {
        return repository.findUserIntegras(map, rowStart, rowEnd);
    }

    @Override
    public Map<String, Object> findUserIntegrasTotalCount(Map<String, Object> map) {
        return repository.findUserIntegrasTotalCount(map);
    }

    @Override
    public List<Map<String, Object>> findUserReceivedPayments(Map<String, Object> param, int rowStart, int rowEnd) {
        List<Map<String, Object>> list = repository.findUserReceivedPayments(param, rowStart, rowEnd);
        return list;
    }

    @Override
    public Map<String, Object> findUserReceivedPaymentsTotalInfo(Map<String, Object> param) {
        return repository.findUserReceivedPaymentsTotalInfo(param);
    }

    @Override
    public List<Map<String, Object>> findUsersByName(Map<String, Object> map) {
        return repository.findUsersByName(map);
    }

    @Override
    public Map<String, Object> findWithdrawsTotalCount(Map<String, Object> map) {
        return repository.findWithdrawsTotalCount(map);
    }

    @Override
    public Map<String, Object> selectMerchantPaymentsTotalCount(Map<String, Object> map) {
        return repository.selectMerchantPaymentsTotalCount(map);
    }
}
