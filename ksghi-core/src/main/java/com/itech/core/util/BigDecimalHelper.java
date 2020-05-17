package com.itech.core.util;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class BigDecimalHelper {
    private static Logger logger = Logger.getLogger(BigDecimalHelper.class);

    public static BigDecimal getScale2Up(BigDecimal big) {
        return big.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 利率/100 * 金额 ，保留两位小数
     *
     * @param rate  利率
     * @param mount 金额
     * @return rate/100 * mount
     */
    public static BigDecimal movePointLeftScale2UpMul(BigDecimal rate, BigDecimal mount) {
        return getScale2Up(rate.multiply(mount).divide(new BigDecimal(100)));
    }

    /**
     * 利率/100 * 金额 ,保留四位小数
     *
     * @param rate  利率
     * @param mount 金额
     * @return rate/100 * mount
     */

    public static BigDecimal movePointLeftScale4UpMul(BigDecimal rate, BigDecimal mount) {
        // return rate.movePointLeft(2).multiply(mount).setScale(4,
        // BigDecimal.ROUND_HALF_UP);
        return rate.multiply(mount).divide(new BigDecimal(100), 4);
    }

    /**
     * 字符串转换成BigDecimal
     */

    public static BigDecimal StringToBigdecimal(String str) {
        if (str == null || str.length() < 1) {
            return BigDecimal.ZERO;
        }
        str = str.replaceAll(",", "");
        return new BigDecimal(str);
    }

    /***
     * 两个值相加
     *
     * @param sum
     * @param repayedAmount
     * @return
     * @author yanminfeng
     */
    public static BigDecimal getBigDecimalValue(BigDecimal sum, BigDecimal repayedAmount) {
        if (repayedAmount != null) {
            if (sum != null && sum.compareTo(new BigDecimal(0.00)) == 1) {
                sum = sum.add(repayedAmount);
            } else {
                sum = repayedAmount;
            }
        }
        return sum == null ? new BigDecimal("0.00") : sum;
    }

    /**
     * -------返回0.00数据
     *
     * @param value
     * @return
     */
    public static String getStringXXValue(BigDecimal value) {
        java.text.DecimalFormat myformat = new java.text.DecimalFormat("0.00");
        String str = myformat.format(value);
        return str;
    }

    /*
     * 计算公式1 相减求百分比（保留2位小数） XXXX={XXX1-XXX2}÷XXX2×100
     */
    public static BigDecimal computational(BigDecimal BigDecimal1, BigDecimal BigDecimal2) {
        java.math.BigDecimal bd3 = new java.math.BigDecimal(100);
        DecimalFormat df = new DecimalFormat("######0.00");
        BigDecimal d = BigDecimal1.subtract(BigDecimal2);
        BigDecimal e = d.divide(BigDecimal2, 6, BigDecimal.ROUND_HALF_UP);
        BigDecimal d2ToBigDeWithPre = new BigDecimal(df.format(e.multiply(bd3).doubleValue()));
        return d2ToBigDeWithPre;
    }

    /*
     * 计算公式1 相减求百分比 ,取整 XXXX={XXX1-XXX2}÷XXX2×100
     */
    public static BigDecimal computationalTrunc(BigDecimal BigDecimal1, BigDecimal BigDecimal2) {
        java.math.BigDecimal bd3 = new java.math.BigDecimal(100);
        BigDecimal d = BigDecimal1.subtract(BigDecimal2).multiply(bd3);
        BigDecimal d2ToBigDeWithPre = d.divide(BigDecimal2, 0, BigDecimal.ROUND_HALF_UP);
        return d2ToBigDeWithPre;
    }

    /**
     * 计算公式2 相除求百分比（保留2位小数，金额、利息计算） XXXX=XXX1÷XXX2×100 （四舍五入）
     */
    public static BigDecimal calculatePercent(BigDecimal dividend, BigDecimal divisor) {
        BigDecimal percent = new BigDecimal("0.00");
        if (dividend == null || divisor == null) {
            return percent;
        }
        if (divisor.compareTo(new BigDecimal("0.00")) == 0) {
            return percent;
        }
        java.math.BigDecimal hundred = new java.math.BigDecimal(100);
        DecimalFormat df = new DecimalFormat("######0.00");
        BigDecimal e = dividend.divide(divisor, 6, BigDecimal.ROUND_HALF_UP);
        percent = new BigDecimal(df.format(e.multiply(hundred).doubleValue()));
        return percent;
    }

    /**
     * 计算公式2 相除求百分比 XXXX=XXX1÷XXX2×100 应用：我的账户-金额百分比值显示，避免出现0.000X取2位小数为0.00
     *
     * @param dividend
     * @param divisor
     * @param df       格式化
     * @return （保留2位小数，舍去）
     */
    public static BigDecimal calculatePercentXXXX(BigDecimal dividend, BigDecimal divisor, DecimalFormat df) {
        BigDecimal percent = new BigDecimal("0.00");
        if (dividend == null || divisor == null) {
            return percent;
        }
        if (divisor.compareTo(new BigDecimal("0.00")) == 0) {
            return percent;
        }
        java.math.BigDecimal hundred = new java.math.BigDecimal(100);
        BigDecimal e = dividend.divide(divisor, 6, BigDecimal.ROUND_HALF_DOWN);
        percent = new BigDecimal(df.format(e.multiply(hundred).doubleValue()));
        return percent;
    }

    /**
     * 计算公式2 相除求百分比,取整 XXXX=XXX1÷XXX2×100
     */
    public static BigDecimal calculatePercentTrunc(BigDecimal dividend, BigDecimal divisor) {
        BigDecimal percent = new BigDecimal("0");
        if (dividend == null || divisor == null) {
            return percent;
        }
        if (divisor.compareTo(new BigDecimal("0")) == 0) {
            return percent;
        }
        java.math.BigDecimal hundred = new java.math.BigDecimal(100);
        // BigDecimal e = dividend.divide(divisor,6,BigDecimal.ROUND_HALF_UP);
        percent = dividend.multiply(hundred).divide(divisor, 0, BigDecimal.ROUND_HALF_UP);
        ;
        return percent;
    }

    /**
     * 获取最小值
     */
    public static BigDecimal getMin(List<BigDecimal> list) {
        BigDecimal min = new BigDecimal(0);
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                min = list.get(i);
            } else {
                if (list.get(i).compareTo(min) < 0) {
                    min = list.get(i);
                }
            }
        }
        return min;
    }

    /**
     * 获取最大值
     */
    public static BigDecimal getMax(List<BigDecimal> list) {
        BigDecimal max = new BigDecimal(0);
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                max = list.get(i);
            } else {
                if (list.get(i).compareTo(max) > 0) {
                    max = list.get(i);
                }
            }
        }
        return max;
    }

    public static boolean isNumber(String str) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后一位的数字的正则表达式
        java.util.regex.Matcher match = pattern.matcher(str);
        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 格式化为0.00格式
     */
    public static String format(BigDecimal decimal) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(decimal).toString();
    }

    /**
     * 以万为单位，格式化为#.##,最多包含两位小数
     */
    public static String countInTenThousands(Object decimal) {
        BigDecimal result = BigDecimal.ZERO;
        if (decimal instanceof java.lang.String) {
            if (decimal != null && !"".equals(decimal)) {
                result = new BigDecimal((String) decimal);
            }
        }
        if (decimal instanceof java.math.BigDecimal) {
            if (decimal != null) {
                result = (BigDecimal) decimal;
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        result = result.multiply(new BigDecimal("0.0001"));
        return df.format(result).toString();
    }

    /**
     * 金额格式化
     *
     * @param s   金额
     * @param len 小数位数
     * @return 格式后的金额
     */
    public static String insertComma(String s, int len) {
        if (s == null || s.length() < 1) {
            return "";
        }
        NumberFormat formater = null;
        double num = Double.parseDouble(s);
        if (len == 0) {
            formater = new DecimalFormat("###,##0");

        } else {
            StringBuffer buff = new StringBuffer();
            buff.append("###,##0.");
            for (int i = 0; i < len; i++) {
                buff.append("0");
            }
            formater = new DecimalFormat(buff.toString());
        }
        return formater.format(num);
    }

    public static void main(String[] args) {
        /*
         * BigDecimal REBATEPROPORTION = new BigDecimal(25);//佣金比例百分比 BigDecimal
         * amount = new BigDecimal(0.3);//单位万元
         *
         * REBATEPROPORTION=REBATEPROPORTION.divide(new
         * BigDecimal(100),2,BigDecimal.ROUND_HALF_UP); amount=amount.divide(new
         * BigDecimal(0.0001),0,BigDecimal.ROUND_HALF_UP); logger.info(amount);
         * logger.info(REBATEPROPORTION.multiply(amount)); BigDecimal aa =
         * calculatePercent(new BigDecimal(11),new BigDecimal(30));
         * logger.info(aa); List<BigDecimal> list = new ArrayList<BigDecimal>();
         * list.add(new BigDecimal(3)); list.add(new BigDecimal(2));
         * list.add(new BigDecimal(12)); logger.info(getMin(list));
         */

        /*
         * BigDecimal test1 = calculatePercentTrunc(new BigDecimal(9),new
         * BigDecimal(30)); //BigDecimal test2 = computationalTrunc(new
         * BigDecimal(39),new BigDecimal(30)); BigDecimal test2 =
         * calculatePercent(new BigDecimal("5.35"),new BigDecimal("1096.64"));
         *
         * BigDecimal d=new BigDecimal("100").subtract(test1).subtract(test1);
         *
         * logger.info("test1========"+test1+"------d:"+d);
         * logger.info("test2========"+test2);
         *
         */
        // 29,693,813.10 52,024,626.55 16948250.57 98666690.22
        BigDecimal re0 = BigDecimalHelper.calculatePercentXXXX(new BigDecimal("1000000"), new BigDecimal("3000010"), new DecimalFormat("#.####"));
        logger.info("test2========" + re0);
        BigDecimal re = BigDecimalHelper.calculatePercentXXXX(new BigDecimal("2000000"), new BigDecimal("3000010"), new DecimalFormat("#.####"));
        logger.info("test2========" + re);
        BigDecimal re1 = BigDecimalHelper.calculatePercentXXXX(new BigDecimal("10"), new BigDecimal("3000010"), new DecimalFormat("#.####"));
        logger.info("test2========" + re1 + "----format:::" + new DecimalFormat("######0.00").format(re) + "========" + new BigDecimal("100").subtract(re0));
        logger.info("test2========" + re1.add(re0.add(re)));

        // BigDecimal rr = new BigDecimal("1").divide(new BigDecimal("3"));
        logger.info("test2========" + new BigDecimal("0.05").compareTo(new BigDecimal("0.05")));

        logger.info("test211========" + BigDecimalHelper.insertComma("3213210", 0));
    }
}
