package com.itech.ups.app.business.stats.application.infrastructure;

import com.itech.core.util.ThousandsHelper;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 */

@Repository
public class StatsRepository extends AbstractRepositoryParent {
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> finaPlannerCustomerInvestByPage(Map<String, Object> param, int rowStart, int rowEnd) {
        param.put("rowStart", rowStart);
        param.put("rowEnd", rowEnd);
        return sqlMapClientTemplate.queryForList("stats.finaPlannerCustomerInvestByPage", param);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> finaPlannerCustomerInvestTotal(Map<String, Object> param) {
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("stats.finaPlannerCustomerInvestTotal", param);
    }

    public List findActivityLotterys(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<Map<String, Object>>) sqlMapClientTemplate.queryForList("stats.selectActivityLotterys", params);
    }

    // 奖券统计 苏冰雪 2015-03-26
    public long findActivityLotterysTotalCount(Map<String, Object> params) {
        return (Long) sqlMapClientTemplate.queryForObject("stats.selectActivityLotterysTotalCount", params);
    }

    public List findAlreadyPayments(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<Map<String, Object>>) sqlMapClientTemplate.queryForList("stats.selectAlreadyPayments", params);
    }

    public long findAlreadyPaymentTotalCount(Map<String, Object> params) {
        return (Long) sqlMapClientTemplate.queryForObject("stats.selectAlreadyPaymentTotalCount", params);
    }

    public Map findAlreadyPaymentTotalMap() {
        return (Map) sqlMapClientTemplate.queryForObject("stats.selectAlreadyPaymentTotalMap");
    }

    public List<Map<String, Object>> findFinaPlannerCredits(Map<String, Object> param, int rowStart, int rowEnd) {
        param.put("rowStart", rowStart);
        param.put("rowEnd", rowEnd);
        return (List<Map<String, Object>>) sqlMapClientTemplate.queryForList("stats.selectFinaPlannerCredits", param);
    }

    public Map<String, Object> findFinaPlannerCreditsTotalCount(Map<String, Object> param) {
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("stats.selectFinaPlannerCreditsTotalCount", param);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findInsteadRepayments(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> list = sqlMapClientTemplate.queryForList("stats.selectInsteadRepayments", map);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findInsteadRepaymentsTotalInfo(Map<String, Object> param) {
        List<Map<String, Object>> list = sqlMapClientTemplate.queryForList("stats.selectInsteadRepaymentsTotalInfo", param);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findInterestReport(Map<String, Object> param) {
        return sqlMapClientTemplate.queryForList("stats.selectInterestReport", param);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> findInterestReportTotalCount(Map<String, Object> param) {
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("stats.selectInterestReportTotalCount", param);
    }

    public List<Map<String, Object>> findMerchantPayments(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        return sqlMapClientTemplate.queryForList("stats.selectMerchantPayments", map);
    }

    public List<Map<String, Object>> findOughtPayments(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<Map<String, Object>>) sqlMapClientTemplate.queryForList("stats.selectOughtPayments", params);
    }

    public long findOughtPaymentTotalCount(Map<String, Object> params) {
        return (Long) sqlMapClientTemplate.queryForObject("stats.selectOughtPaymentTotalCount", params);
    }

    public Map findOughtPaymentTotalMap() {
        return (Map) sqlMapClientTemplate.queryForObject("stats.selectOughtPaymentTotalMap");
    }

    public List<Map<String, Object>> findPageProductSales(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> productSales = sqlMapClientTemplate.queryForList("stats.selectPageProductSales", map);
        return productSales;
    }

    public List<Map<String, Object>> findPageRecharges(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> recharges = sqlMapClientTemplate.queryForList("stats.selectPageRecharges", map);
        return recharges;
    }

    public List<Map<String, Object>> findPageWithdraws(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> withdraws = sqlMapClientTemplate.queryForList("stats.selectPageWithdraws", map);
        return withdraws;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findProductPayments(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> list = sqlMapClientTemplate.queryForList("stats.selectProductPayments", map);
        return list;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> findProductPaymentsTotalInfo(Map<String, Object> param) {
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("stats.selectProductPaymentsTotalInfo", param);
    }

    public Map<String, Object> findProductSalesTotalCount(Map<String, Object> map) {
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("stats.selectProductSalesTotalCount", map);
    }

    public List<Map<String, Object>> findPromotionPlans(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<Map<String, Object>>) sqlMapClientTemplate.queryForList("stats.selectPromotionPlans", params);
    }

    public long findPromotionPlanTotalCount(Map<String, Object> params) {
        return (Long) sqlMapClientTemplate.queryForObject("stats.selectPromotionPlansTotalCount", params);
    }

    public Map findPromotionPlanTotalMap() {
        return (Map) sqlMapClientTemplate.queryForObject("stats.selectPromotionPlansTotalMap");
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findPromptsByRepayPlanDate(Map<String, String> param) {
        return sqlMapClientTemplate.queryForList("stats.selectPromptsByRepayPlanDate", param);
    }

    public Map<String, Object> findRechargesTotalCount(Map<String, Object> map) {
        Map<String, Object> totalMap = (Map<String, Object>) sqlMapClientTemplate.queryForObject("stats.selectRechargesTotalCount", map);
        return totalMap;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findRepayByRepayPlanDate(Map<String, String> param) {
        return sqlMapClientTemplate.queryForList("stats.selectRepayByRepayPlanDate", param);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findRepayments(Map<String, Object> params) {
        List<Map<String, Object>> list = sqlMapClientTemplate.queryForList("stats.selectRepayments", params);
        int len = list.size();
        if (len > 0) {
            Map<String, Object> lastMap = list.get(len - 1);
            int prepayPeriod = 0;// 期次从1开始
            if ("prepay".equals(lastMap.get("REPAY_TYPE"))) {
                prepayPeriod = Integer.parseInt(lastMap.get("PERIOD").toString());

                list.remove(lastMap);
                if (list.size() > 1) {
                    list.remove((prepayPeriod > list.size() ? list.size() : prepayPeriod) - 1);
                    list.add((prepayPeriod > list.size() ? list.size() : prepayPeriod) - 1, lastMap);
                } else {
                    if (list.size() == 1) {
                        list.remove(0);
                    }
                    list.add(0, lastMap);
                }

            }
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                map.put("REPAY_AMOUNT", ThousandsHelper.formateThousands(map.get("REPAY_AMOUNT") == null ? "" : map.get("REPAY_AMOUNT").toString(), true));
                if (map.get("REPAY_USER_TYPE") != null && !map.get("REPAY_USER_TYPE").equals("borrower"))
                    map.put("REMARK", map.get("REPAY_USER_NAME").toString() + "代偿");
                if (map.get("REPAY_TYPE") != null && map.get("REPAY_TYPE").equals("prepay"))
                    map.put("REMARK", map.get("REPAY_TIME") == null ? "" : map.get("REPAY_TIME").toString() + "提前还款结清");
                if (!map.get("STATUS").equals("repayed")) {
                    map.put("REPAY_AMOUNTY", 0);
                } else {
                    map.put("REPAY_AMOUNTY", map.get("REPAY_AMOUNT"));
                }
                if (map.get("STATUS").equals("cancel")) {
                    map.put("REPAY_AMOUNTY", "-");
                    map.put("REPAY_TIME", "-");
                    map.put("REMARK", "-");
                }
            }
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findTopUser(Map<String, String> param) {
        return sqlMapClientTemplate.queryForList("stats.selectTopUser", param);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findUserincomes(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> list = sqlMapClientTemplate.queryForList("stats.selectUserincomes", map);
        return list;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> findUserincomesTotalInfo(Map<String, Object> param) {
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("stats.selectUserincomesTotalInfo", param);
    }

    public List<Map<String, Object>> findUserIntegras(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> userIntegras = sqlMapClientTemplate.queryForList("stats.selectUserIntegras", map);
        return userIntegras;
    }

    public Map<String, Object> findUserIntegrasTotalCount(Map<String, Object> map) {
        Map<String, Object> totalCount = (Map<String, Object>) sqlMapClientTemplate.queryForObject("stats.selectUserIntegrasTotalCount", map);
        return totalCount;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findUserReceivedPayments(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        List<Map<String, Object>> list = sqlMapClientTemplate.queryForList("stats.selectUserReceivedPayments", map);
        return list;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> findUserReceivedPaymentsTotalInfo(Map<String, Object> param) {
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("stats.selectUserReceivedPaymentsTotalInfo", param);
    }

    public List<Map<String, Object>> findUsersByName(Map<String, Object> map) {
        return sqlMapClientTemplate.queryForList("stats.findUsersByName", map);
    }

    public Map<String, Object> findWithdrawsTotalCount(Map<String, Object> map) {
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("stats.selectWithdrawsTotalCount", map);
    }

    public Map<String, Object> selectMerchantPaymentsTotalCount(Map<String, Object> map) {
        return (Map<String, Object>) sqlMapClientTemplate.queryForObject("stats.selectMerchantPaymentsTotalCount", map);
    }

}
