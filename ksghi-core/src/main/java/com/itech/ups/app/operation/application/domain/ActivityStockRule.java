package com.itech.ups.app.operation.application.domain;

import java.math.BigDecimal;

public class ActivityStockRule {

    public static final String RECOMMEND_CODE = "1A0001";// 指定推荐码

    public static final long REGISTER_COUNT = 100;// 每天注册人数

    public static final BigDecimal INVESTORS_INTEREST_COUNT = new BigDecimal(100000);// 利息总额
    // 默认10万

    public static final String ACTIVITY_PRODUCT_ID = "15042316403156419583";//

    public static final BigDecimal EXPERIENCE_AMOUNT = new BigDecimal(5000);// 体验金

    public static final BigDecimal RECOMMEND_EXPERIENCE_AMOUNT = new BigDecimal(10);// 现金红包

    public static final BigDecimal DEFAULT_INTEREST = new BigDecimal(0);// 默认收益

    public static final String ACTIVITY_DATE = "2015-07-10";// 活动时间

}
