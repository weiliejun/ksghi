package com.itech.ups.app.user.application.domain;

import com.itech.ups.app.product.application.domain.Product;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 出借结算
 *
 * @author hasee
 */
public class LiquidationData implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2549254484692622310L;
    private static Logger logger = Logger.getLogger(LiquidationData.class);
    private static DecimalFormat df = new DecimalFormat("#.00");

    private static BigDecimal par = new BigDecimal(365);
    private static BigDecimal par100 = new BigDecimal(100);

    /**
     * 产品资产总值计算 罗顺锋:上午11:14:17
     * 结算资产总额为扣除外部交易系统的各项手续费后，参与出借人、投顾（借款人）、平台方三方结算的资产总额。
     * 产品资产总值=到期单位净值×出借本金+账户管理费合计
     *
     * @param dayWorth到期单位净值
     * @param tenderAmount出借本金
     * @param accountManagementFee账户管理费合计 罗顺锋
     */
    public static BigDecimal getTotalAssets(BigDecimal dayWorth, BigDecimal tenderAmount, BigDecimal accountManagementFee) {
        BigDecimal result = (dayWorth.multiply(tenderAmount)).add(accountManagementFee);
        // return result;
        return BigDecimal.valueOf(result.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

    /**
     * 罗顺锋:上午11:31:39
     *
     * @param tenderAmount出借本金
     * @param dayWorth到期单位净值   产品资产净值=出借本金×单位净值(到期结算时按最后一个交易日的单位净值结算收益。)
     * @return
     */
    public static BigDecimal getNetAssetvalue(BigDecimal tenderAmount, BigDecimal dayWorth) {
        return dayWorth.multiply(tenderAmount);
    }

    /**
     * 出借年化利率=（单位净值-1）×365÷实际运行天数 罗顺锋:上午11:39:37
     *
     * @param dayWorth单位净值
     * @param runningDays实际运行天数
     * @return
     */
    public static BigDecimal getAnnualYield(BigDecimal dayWorth, BigDecimal runningDays) {
        BigDecimal par = new BigDecimal(1);
        BigDecimal par2 = new BigDecimal(365);
        // BigDecimal result =
        // (dayWorth.subtract(par)).multiply(par2).divide(runningDays);
        BigDecimal result = (dayWorth.subtract(par)).multiply(par2).divide(runningDays, 8, BigDecimal.ROUND_HALF_UP);
        return result;
    }

    /**
     * 出借人优先收益 出借人优先收益= 若出借年化利率＞优先分配年化利率，出借人优先收益=（出借本金*优先分配收益率*实际运行天数÷365）
     * 出借人优先收益 = 若出借年化利率≤优先分配年化利率，出借人优先收益=出借本金×出借年化利率×实际运行天数÷365； 罗顺锋:上午11:50:52
     *
     * @param tenderAmount出借本金
     * @param annualYield出借年化利率
     * @param firstAnnualYield优先分配收益率
     * @param excessReturns超额收益分配出借人占比 (由于库中存的是整数因此需要在此除以100)
     * @param runningDays实际运行天数
     * @return
     */
    public static BigDecimal getFirstTotalRevenue(BigDecimal tenderAmount, BigDecimal dayWorth, Product p, BigDecimal runningDays) {
        // BigDecimal tenderAmount = p.getTenderAmount();
        BigDecimal annualYield = getAnnualYield(dayWorth, runningDays);
        BigDecimal firstAnnualYield = p.getPriorityRate() == null ? new BigDecimal(0) : p.getPriorityRate();
        firstAnnualYield = firstAnnualYield.divide(par100);// 由于库中存的是整数因此需要在此除以100
        BigDecimal excessReturns = p.getOvertopInvestorRate();
        excessReturns = excessReturns.divide(par100);// 由于库中存的是整数因此需要在此除以100
        BigDecimal result = new BigDecimal(0);
        if (annualYield.compareTo(firstAnnualYield) > 0) {
            result = (tenderAmount.multiply(firstAnnualYield).multiply(runningDays).divide(par, 2, BigDecimal.ROUND_HALF_UP));
        } else {
            result = tenderAmount.multiply(annualYield).multiply(runningDays).divide(par, 2, BigDecimal.ROUND_HALF_UP);
        }
        // return BigDecimal.valueOf(result.setScale(2,
        // BigDecimal.ROUND_HALF_UP).doubleValue());
        return result;
    }

    /**
     * 出借人超额收益收益 出借人超额收益收益= 若出借年化利率＞优先分配年化利率，出借人超额收益收益=（{出借本金×（出借年化利率-优先分配收益率）
     * ×超额收益分配出借人占比×实际运行天数÷365} 出借人超额收益收益=
     * 若出借年化利率≤优先分配年化利率，出借人超额收益收益=出借本金×出借年化利率×实际运行天数÷365；（不存在） 罗顺锋:上午11:50:52
     *
     * @param tenderAmount出借本金
     * @param annualYield出借年化利率
     * @param firstAnnualYield优先分配收益率
     * @param excessReturns超额收益分配出借人占比 (由于库中存的是整数因此需要在此除以100)
     * @param runningDays实际运行天数
     * @return
     */
    public static BigDecimal getTotalRevenue(BigDecimal tenderAmount, BigDecimal dayWorth, Product p, BigDecimal runningDays) {
        // BigDecimal tenderAmount = p.getTenderAmount();
        BigDecimal annualYield = getAnnualYield(dayWorth, runningDays);
        BigDecimal firstAnnualYield = p.getPriorityRate() == null ? new BigDecimal(0) : p.getPriorityRate();
        firstAnnualYield = firstAnnualYield.divide(par100);// 由于库中存的是整数因此需要在此除以100
        BigDecimal excessReturns = p.getOvertopInvestorRate();
        excessReturns = excessReturns.divide(par100);// 由于库中存的是整数因此需要在此除以100
        BigDecimal result = new BigDecimal(0);
        if (annualYield.compareTo(firstAnnualYield) > 0) {
            result = tenderAmount.multiply(annualYield.subtract(firstAnnualYield)).multiply(excessReturns).multiply(runningDays).divide(par, 2, BigDecimal.ROUND_HALF_UP);
        }
        // else{
        // result =
        // tenderAmount.multiply(annualYield).multiply(runningDays).divide(par,BigDecimal.ROUND_HALF_UP);
        // }
        // df.format(result)
        // return BigDecimal.valueOf(result.setScale(2,
        // BigDecimal.ROUND_HALF_UP).doubleValue());
        return result;
    }
    /**
     * 出借收益=（单位净值-1）*100 罗顺锋:下午2:07:41
     *
     * @return
     */
    // public static BigDecimal getInvestmentReturnRate(BigDecimal dayWorth){
    // BigDecimal parm = new BigDecimal(1);
    // BigDecimal result = (dayWorth.subtract(parm)).multiply(new
    // BigDecimal(100));
    // return BigDecimal.valueOf(result.setScale(2,
    // BigDecimal.ROUND_HALF_UP).doubleValue());
    // // return result;
    // }

    /**
     * 若出借年化利率＞优先分配年化利率， 投顾收益=实际借款金额*（出借收益率-优先分配收益率）×超额收益分配投顾占比×实际运行天数÷365；
     * 若出借年化利率≤优先分配年化利率，投顾收益=0；投顾收益需展示给投顾个人用户界面 罗顺锋:下午1:30:43
     *
     * @param realBorrowing实际借款金额     ==产品投标总额
     * @param annualYield出借年化利率
     * @param investmentReturnRate    出借收益率
     * @param firstAnnualYield优先分配收益率 (由于库中存的是整数因此需要在此除以100)
     * @param excessReturns超额收益分配投顾占比 (由于库中存的是整数因此需要在此除以100)
     * @param runningDays实际运行天数
     * @return
     */
    public static BigDecimal getInvestmentIncome(BigDecimal realBorrowing, BigDecimal dayWorth, Product p, BigDecimal runningDays) {
        // BigDecimal realBorrowing = p.getTenderAmount();
        BigDecimal annualYield = getAnnualYield(dayWorth, runningDays);
        ;
        // BigDecimal investmentReturnRate = getInvestmentReturnRate(dayWorth);
        BigDecimal firstAnnualYield = p.getPriorityRate();
        firstAnnualYield = firstAnnualYield.divide(par100);// 由于库中存的是整数因此需要在此除以100
        BigDecimal excessReturns = p.getOvertopInvestConsultantRate();
        excessReturns = excessReturns.divide(par100);// 由于库中存的是整数因此需要在此除以100
        BigDecimal result = new BigDecimal(0);
        if (annualYield.compareTo(firstAnnualYield) > 0) {
            result = realBorrowing.multiply(annualYield.subtract(firstAnnualYield)).multiply(excessReturns).multiply(runningDays).divide(par, 2, BigDecimal.ROUND_HALF_UP);
        }
        // return BigDecimal.valueOf(result.setScale(2,
        // BigDecimal.ROUND_HALF_UP).doubleValue());
        return result;
    }

    /**
     * 若出借年化利率＞优先分配年化利率，平台服务费=实际借款金额×（出借年化利率-优先分配年化利率）×超额收益分配平台方占比×实际运行天数÷ 365；
     * 若出借年化利率≤优先分配年化利率，平台服务费=0； 罗顺锋:下午2:15:09
     *
     * @param realBorrowing实际借款金额
     * @param annualYield出借年化利率
     * @param firstAnnualYield优先分配收益率  (由于库中存的是整数因此需要在此除以100)
     * @param excessReturns超额收益分配出借人占比 (由于库中存的是整数因此需要在此除以100)
     * @param runningDays实际运行天数
     * @return
     */
    public static BigDecimal getPlatformFee(BigDecimal realBorrowing, BigDecimal dayWorth, Product p, BigDecimal runningDays) {
        // BigDecimal realBorrowing,BigDecimal annualYield,BigDecimal
        // firstAnnualYield,BigDecimal excessReturns,
        // BigDecimal realBorrowing = p.getTenderAmount();
        BigDecimal annualYield = getAnnualYield(dayWorth, runningDays);
        ;
        BigDecimal firstAnnualYield = p.getPriorityRate();
        firstAnnualYield = firstAnnualYield.divide(par100);// 由于库中存的是整数因此需要在此除以100
        BigDecimal excessReturns = p.getOvertopPlatformRate();
        excessReturns = excessReturns.divide(par100);// 由于库中存的是整数因此需要在此除以100
        BigDecimal result = new BigDecimal(0);
        if (annualYield.compareTo(firstAnnualYield) > 0) {
            result = realBorrowing.multiply(annualYield.subtract(firstAnnualYield)).multiply(excessReturns).multiply(runningDays).divide(par, 2, BigDecimal.ROUND_HALF_UP);
        }
        // return BigDecimal.valueOf(result.setScale(2,
        // BigDecimal.ROUND_HALF_UP).doubleValue());
        return result;
    }

    /**
     * 应付出借人汇款合计=出借本金+出借人收益 罗顺锋:下午2:18:29
     *
     * @param tenderAmount出借本金
     * @param TotalRevenue     +出借人收益(两部分，优先和超额)
     * @return
     */
    public static BigDecimal getInvestorsBack(BigDecimal realBorrowing, BigDecimal dayWorth, Product p, BigDecimal runningDays) {
        BigDecimal result = realBorrowing.add(getTotalRevenue(realBorrowing, dayWorth, p, runningDays)).add(getFirstTotalRevenue(realBorrowing, dayWorth, p, runningDays));
        // return BigDecimal.valueOf(result.setScale(2,
        // BigDecimal.ROUND_HALF_UP).doubleValue());
        return result;
    }

    /**
     * 到期收益率=（1-最后一个交易日累计净值）×100% 罗顺锋:上午9:54:45
     *
     * @param dayWorth
     * @return
     */
    // public static BigDecimal getinvestorRepayRate(BigDecimal dayWorth){
    // BigDecimal parm = new BigDecimal(1);
    // return BigDecimal.valueOf(dayWorth.subtract(parm).setScale(2,
    // BigDecimal.ROUND_HALF_UP).doubleValue());
    // }
    public static void main(String[] args) {
        // logger.info(getTotalAssets(new BigDecimal(1.0099), new
        // BigDecimal(10000), new BigDecimal(0.55)));
        BigDecimal b = new BigDecimal(1.0099);
        logger.info(df.format(b));
        logger.info(getAnnualYield(b, new BigDecimal(1)));
    }
}
