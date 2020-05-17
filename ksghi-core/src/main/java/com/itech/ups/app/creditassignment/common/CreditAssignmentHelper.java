package com.itech.ups.app.creditassignment.common;

import java.math.BigDecimal;
import java.util.Calendar;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-6-7
 * @author  zqs
 * ===========================================================================
 *
 */
public class CreditAssignmentHelper {

    public static int CHARGE_DAYS = 60;// 出让手续费：持有60天以内按交易金额的百分比收取；持有60天及以上免手续费；

    /**
     * 四舍五入格式化保留两位小数
     *
     * @param orgVal
     * @return
     */
    public static BigDecimal formatDecimalDigits(BigDecimal orgVal) {
        return orgVal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 获得两个日历区间的相差的总天数
     *
     * @param beginCalendar
     * @param endCalendar
     * @return
     */
    public static int getDifferentDate(Calendar beginCalendar, Calendar endCalendar) {
        long beginTime = beginCalendar.getTimeInMillis();
        long endTime = endCalendar.getTimeInMillis();

        long differentDate = (endTime - beginTime) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(differentDate));
    }
}