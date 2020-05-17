package com.itech.ups.app.business.stats.application.service;

import java.util.List;
import java.util.Map;

public interface StatsService {
    List<Map<String, Object>> finaPlannerCustomerInvestByPage(Map<String, Object> param, int rowStart, int rowEnd);

    Map<String, Object> finaPlannerCustomerInvestTotal(Map<String, Object> param);

    List findActivityLotterys(Map<String, Object> params, int rowStart, int rowEnd);

    // 奖券统计 苏冰雪 2015-03-26
    long findActivityLotterysTotalCount(Map<String, Object> params);

    List findAlreadyPayments(Map<String, Object> params, int rowStart, int rowEnd);

    long findAlreadyPaymentTotalCount(Map<String, Object> params);

    Map findAlreadyPaymentTotalMap();

    List<Map<String, Object>> findFinaPlannerCredits(Map<String, Object> param, int rowStart, int rowEnd);

    Map<String, Object> findFinaPlannerCreditsTotalCount(Map<String, Object> param);

    List<Map<String, Object>> findInsteadRepayments(Map<String, Object> param, int rowStart, int rowEnd);

    List<Map<String, Object>> findInsteadRepaymentsTotalInfo(Map<String, Object> param);

    // Map<String, Object> findInsteadRepaymentsTotalInfo(Map<String,
    // Object> param);

    List<Map<String, Object>> findInterestReport(Map<String, Object> param, int rowStart, int rowEnd);

    Map<String, Object> findInterestReportTotalCount(Map<String, Object> param);

    List<Map<String, Object>> findMerchantPayments(Map<String, Object> map, int rowStart, int rowEnd);

    List findOughtPayments(Map<String, Object> params, int rowStart, int rowEnd);

    long findOughtPaymentTotalCount(Map<String, Object> params);

    Map findOughtPaymentTotalMap();

    List<Map<String, Object>> findPageProductSales(Map<String, Object> map, int rowStart, int rowEnd);

    List<Map<String, Object>> findPageRecharges(Map<String, Object> map, int rowStart, int rowEnd);

    List<Map<String, Object>> findPageWithdraws(Map<String, Object> map, int rowStart, int rowEnd);

    List<Map<String, Object>> findProductPayments(Map<String, Object> param, int rowStart, int rowEnd);

    Map<String, Object> findProductPaymentsTotalInfo(Map<String, Object> param);

    Map<String, Object> findProductSalesTotalCount(Map<String, Object> map);

    List findPromotionPlans(Map<String, Object> params, int rowStart, int rowEnd);

    long findPromotionPlanTotalCount(Map<String, Object> params);

    Map findPromotionPlanTotalMap();

    List<Map<String, Object>> findPromptsByRepayPlanDate(Map<String, String> param);

    Map<String, Object> findRechargesTotalCount(Map<String, Object> map);

    List<Map<String, Object>> findRepayByRepayPlanDate(Map<String, String> param);

    List<Map<String, Object>> findRepayments(Map<String, Object> params);

    List<Map<String, Object>> findTopUser(Map<String, String> param);

    List<Map<String, Object>> findUserincomes(Map<String, Object> map, int rowStart, int rowEnd);

    Map<String, Object> findUserincomesTotalInfo(Map<String, Object> param);

    List<Map<String, Object>> findUserIntegras(Map<String, Object> map, int rowStart, int rowEnd);

    Map<String, Object> findUserIntegrasTotalCount(Map<String, Object> map);

    List<Map<String, Object>> findUserReceivedPayments(Map<String, Object> map, int rowStart, int rowEnd);

    Map<String, Object> findUserReceivedPaymentsTotalInfo(Map<String, Object> param);

    List<Map<String, Object>> findUsersByName(Map<String, Object> map);

    Map<String, Object> findWithdrawsTotalCount(Map<String, Object> map);

    Map<String, Object> selectMerchantPaymentsTotalCount(Map<String, Object> map);

}
