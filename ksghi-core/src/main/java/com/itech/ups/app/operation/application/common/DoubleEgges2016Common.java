package com.itech.ups.app.operation.application.common;

/**
 * function： Christmas of 2016 And New Year's Day
 */
public class DoubleEgges2016Common {

    public static final String ACTIVITY_ID = "16122117441116835480"; // "16060817130954771547";
    // //2016双旦活动-id
    public static final String ACTIVITY_NAME = "2016双旦活动"; // 活动名称
    public static final String ACTIVITY_START_TIME = "2016-12-22 00:00:00"; // 活动开始日期
    public static final String ACTIVITY_END_TIME = "2017-02-13 23:59:59";// "2017-01-21
    // 23:59:59";
    // //活动结束日期

    public static final String CHRISTMAS_DAY = "2016-12-25"; // Christmas's Day
    public static final String NEW_YEAR_DAY = "2017-01-01"; // New Year's Day

    // --------------start 奖蛋类型 ------
    public static final String LOGIN_EGG = "loginEgg"; // 登录蛋
    public static final String INVEST_EGG = "investEgg"; // 出借蛋
    public static final String SHARE_EGG = "shareEgg"; // 分享蛋
    public static final String NEWUSER_EGG = "newUserEgg"; // 新手蛋
    public static final String REWARD_EGG = "rewardEgg"; // 奖励蛋
    public static final String INTEGRAL_EGG = "integralEgg"; // 积分蛋
    public static final String TENDER_EGG = "tenderEgg"; // 投标蛋

    // --------------start 奖品类型 ---------
    public static final String INTEREST = "interest"; // 加息券
    public static final String CASH = "cash"; // 抽奖蛋现金红包（促销送现金）-参照后台code
    public static final String INVITED_REGISTER_CASH = "invitedRegisterCash"; // 奖励蛋现金红包（邀请送现金）-参照后台code
    public static final String VOCHER = "vocher"; // 代金券
    public static final String IPHONE7 = "iPhone7"; // iPhone7 128G
    public static final String INTEGRAL = "integral"; // 积分
    public static final String QIY_VIP_CARD = "QIY_VIP_CARD"; // 爱奇艺VIP月卡
    public static final String JD_SHOPPING_CARD = "jdShopCard";// "JD_SHOPPING_CARD";
    // //京东卡

    /*--------------start  抽奖蛋（100%中奖）[登录蛋/出借蛋/分享蛋]
     * 出奖规则：A. 加息券98%（0.8加息券 ，0.5加息券    各有49%）
     *           B. 红包1%（18元0.8%，68元0.2%）
     *           C. 京东购物卡1%（100元，200元）
     *           D. 双旦当天，各出一个 IPhone7（2016-12-25，2017-01-01）
     */
    public static final String IPHONE7_OBJ = "{'prizeId':'7', 'prizeName':'iphone7 128G手机', 'prizeType':'" + IPHONE7 + "',  'amount':'0',  'probability':'0.10',    'activityLotteryId':''}";

    public static final String PRIZE_OBJ = "[" + "{'prizeId':'1', 'prizeName':'0.8%加息券',     'prizeType':'" + INTEREST + "',        'amount':'0.008', 'probability':'0.50',  'activityLotteryId':'16122117441126742905'}," // 0.49
            + "{'prizeId':'2', 'prizeName':'0.5%加息券',     'prizeType':'" + INTEREST + "',        'amount':'0.005', 'probability':'0.50',  'activityLotteryId':'16122117441121194993'}" // 0.49
            // + "{'prizeId':'3', 'prizeName':'18元现金红包', 'prizeType':'"+CASH+"',
            // 'amount':'18', 'probability':'0.00' }," //0.008
            // + "{'prizeId':'4', 'prizeName':'68元现金红包', 'prizeType':'"+CASH+"',
            // 'amount':'68', 'probability':'0.00' }," //0.002
            // + "{'prizeId':'5', 'prizeName':'100元京东购物卡',
            // 'prizeType':'"+JD_SHOPPING_CARD+"', 'amount':'100',
            // 'probability':'0.00' }," //0.005
            // + "{'prizeId':'6', 'prizeName':'200元京东购物卡',
            // 'prizeType':'"+JD_SHOPPING_CARD+"', 'amount':'200',
            // 'probability':'0.00' }" //0.005
            + "]";

    /*
     * "[" //测试使用 + "{'prizeId':'1', 'prizeName':'0.8%加息券',     'prizeType':'"
     * +INTEREST+"',        'amount':'0.008', 'probability':'0.15',  'activityLotteryId':'16122117441126742905'},"
     * + "{'prizeId':'2', 'prizeName':'0.5%加息券',     'prizeType':'"
     * +INTEREST+"',        'amount':'0.005', 'probability':'0.15',  'activityLotteryId':'16122117441121194993'},"
     * + "{'prizeId':'3', 'prizeName':'18元现金红包',	   'prizeType':'"
     * +CASH+"',            'amount':'18',    'probability':'0.15'   }," //0.008
     * 0.49 + "{'prizeId':'4', 'prizeName':'68元现金红包',    'prizeType':'"
     * +CASH+"',             'amount':'68',    'probability':'0.15'  }," //0.002
     * + "{'prizeId':'5', 'prizeName':'100元京东购物卡',  'prizeType':'"
     * +JD_SHOPPING_CARD+"', 'amount':'100',   'probability':'0.15'  },"
     * //'0.005' + "{'prizeId':'6', 'prizeName':'200元京东购物卡',  'prizeType':'"
     * +JD_SHOPPING_CARD+"', 'amount':'200',    'probability':'0.15' }"
     * //'0.005' + "]";
     */

    public static void main(String[] args) {

    }
}