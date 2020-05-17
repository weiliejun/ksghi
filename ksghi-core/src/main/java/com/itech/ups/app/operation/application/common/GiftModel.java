package com.itech.ups.app.operation.application.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 积分兑换礼品模型信息
 */
public class GiftModel {

    // 翻翻风扇
    public static final String FAN_GIFT = "{\"name\":\"翻翻风扇\",\"integra\":\"1380\",\"giftType\":\"fan\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满1380可兑换翻翻风扇一台\",\"description\":\"1380积分兑换翻翻风扇一台\"}";
    // cooksclub冰沙杯
    public static final String ZO_GIFT = "{\"name\":\"cooksclub冰沙杯\",\"integra\":\"3380\",\"giftType\":\"zo\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满3380可兑换cooksclub冰沙杯一个\",\"description\":\"3380积分兑换cooksclub冰沙杯一个\"}";
    // BQL-A08A1冰淇淋机
    public static final String BQL_GIFT = "{\"name\":\"BQL-A08A1冰淇淋机\",\"integra\":\"3580\",\"giftType\":\"bql\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满3580可兑换BQL-A08A1冰淇淋机一台\",\"description\":\"3580积分兑换BQL-A08A1冰淇淋机一台\"}";
    // 静享灭蚊灯
    public static final String LAMP_GIFT = "{\"name\":\"静享灭蚊灯\",\"integra\":\"5360\",\"giftType\":\"lamp\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满5360可兑换静享灭蚊灯一台\",\"description\":\"5360积分兑换静享灭蚊灯一台\"}";
    // 乐扣保温水杯
    public static final String WARM_CUP_GIFT = "{\"name\":\"乐扣保温水杯\",\"integra\":\"1380\",\"giftType\":\"warmCup\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满1380可兑换乐扣保温水杯一个\",\"description\":\"1380积分兑换乐扣保温水杯一个\"}";
    // 上海迪士尼门票
    public static final String DISNEY_TICKET_GIFT = "{\"name\":\"上海迪士尼门票\",\"integra\":\"9980\",\"giftType\":\"disneyTicket\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满9980可兑换上海迪士尼门票一张\",\"description\":\"9980积分兑换上海迪士尼门票一张\"}";
    // 海边3日游(青岛)
    public static final String TRAVEL_GIFT = "{\"name\":\"海边3日游(青岛)\",\"integra\":\"27800\",\"giftType\":\"qdTravel\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满27800可兑换海边3日游(青岛)一次\",\"description\":\"27800积分兑换海边3日游(青岛)一次\"}";
    // 稻香村月饼礼盒
    public static final String MOONCAKE_GIFT = "{\"name\":\"稻香村月饼礼盒\",\"integra\":\"998\",\"giftType\":\"mooncake\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满998可兑换稻香村月饼礼盒一盒\",\"description\":\"998积分兑换稻香村月饼礼盒一盒\"}";
    // 阳澄湖大闸蟹券
    public static final String CRAB_GIFT = "{\"name\":\"阳澄湖大闸蟹券\",\"integra\":\"3960\",\"giftType\":\"crab\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满3960可兑换阳澄湖大闸蟹券一张\",\"description\":\"3960积分兑换阳澄湖大闸蟹券一张\"}";
    /**
     * 中秋专场
     */
    // 中粮山萃谷物杂粮礼盒
    public static final String GRAIN_GIFT = "{\"name\":\"中粮山萃谷物杂粮礼盒\",\"integra\":\"1180\",\"giftType\":\"grain\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满1180可兑换中粮山萃谷物杂粮礼盒一盒\",\"description\":\"1180积分兑换中粮山萃谷物杂粮礼盒一盒\"}";
    // 野餐垫
    public static final String FOODPAD_GIFT = "{\"name\":\"多功能野餐防潮垫\",\"integra\":\"780\",\"giftType\":\"foodpad\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满780可兑换多功能野餐防潮垫一张\",\"description\":\"780积分兑换多功能野餐防潮垫一张\"}";
    // 暖手宝
    public static final String WARMTH_TREASURE = "{\"name\":\"暖手宝\",\"integra\":\"1580\",\"giftType\":\"warmthTreasure\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满1580可兑换暖手宝一个\",\"description\":\"1580积分兑换暖手宝一个\"}";
    // 松下空气净化器
    public static final String AIR_CLEAN = "{\"name\":\"松下空气净化器\",\"integra\":\"17980\",\"giftType\":\"airClean\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满17980可兑换松下空气净化器一台\",\"description\":\"17980积分兑换松下空气净化器一台\"}";
    // 味多美提货卡
    public static final String GOODSCARD_GIFT = "{\"name\":\"100元味多美提货卡\",\"integra\":\"2000\",\"giftType\":\"goodscard\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满2000可兑换味多美提货卡一张（￥100）\",\"description\":\"2000积分兑换味多美提货卡一张（￥100）\"}";
    // 京东购物卡
    public static final String SHOP_CARD_GIFT = "{\"name\":\"200元京东购物卡\",\"integra\":\"4000\",\"giftType\":\"jdShopCard\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满4000可兑换京东购物卡（￥200）\",\"description\":\"4000积分兑换京东购物卡（￥200）一张\"}";
    // 血压计
    public static final String BLOODPRESSURE_GIFT = "{\"name\":\"血压计\",\"integra\":\"3180\",\"giftType\":\"bloodpressure\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满3180可兑换血压计一支\",\"description\":\"3180积分兑换血压计一支\"}";
    // 乐扣微波炉玻璃套装饭盒
    public static final String LUNCHBOX_GIFT = "{\"name\":\"乐扣微波炉玻璃套装饭盒\",\"integra\":\"5980\",\"giftType\":\"lunchbox\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满5980可兑换乐扣微波炉玻璃套装饭盒一张\",\"description\":\"5980积分兑换阳乐扣微波炉玻璃套装饭盒一套\"}";
    // 飞利浦加湿器
    public static final String HUMIDIFIER_GIFT = "{\"name\":\"飞利浦加湿器\",\"integra\":\"7180\",\"giftType\":\"humidifier\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满7180可兑换飞利浦加湿器一台\",\"description\":\"7180积分兑换飞利浦加湿器一台\"}";
    // 美的吸尘器
    public static final String VACUUMCLEANER_GIFT = "{\"name\":\"美的吸尘器\",\"integra\":\"9380\",\"giftType\":\"vacuumcleaner\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满9380可兑换美的吸尘器一台\",\"description\":\"9380积分兑换美的吸尘器一台\"}";
    // 蓝牙自拍杆
    public static final String SELFIE_STICK_GIFT = "{\"name\":\"多功能蓝牙自拍杆(通用)\",\"integra\":\"2500\",\"giftType\":\"selfieStick\",\"exchangeType\":\"gift\",\"activateCondition\":\"积分换好礼活动，微积分满2500可兑换多功能蓝牙自拍杆(通用)一个\",\"description\":\"9380积分兑换多功能蓝牙自拍杆(通用)一个\"}";
    /**
     * 庆积分兑换奖券信息,giftType值为该奖券的id值
     */
    // 0.5%加息券
    public static final String INTEREST_ONE_LOTTERY = "{\"id\":\"16080410251260877362\",\"name\":\"0.5%加息券\",\"lotteryValue\":\"0.5\",\"integra\":\"5000\",\"giftType\":\"oneLottery\",\"exchangeType\":\"lottery\",\"activateCondition\":\"积分换好礼活动，微积分满5000可兑换0.5%加息券一张\",\"description\":\"5000积分兑换0.5%加息券一张\"}";
    // 0.8%加息券
    public static final String TRAVEL_TWO_LOTTERY = "{\"id\":\"16080410251263218587\",\"name\":\"0.8%加息券\",\"lotteryValue\":\"0.8\",\"integra\":\"8000\",\"giftType\":\"twoLottery\",\"exchangeType\":\"lottery\",\"activateCondition\":\"积分换好礼活动，微积分满8000可兑换0.8%加息券一张\",\"description\":\"8000积分兑换0.8%加息券一张\"}";
    // 1%加息券
    public static final String TRAVEL_THREE_LOTTERY = "{\"id\":\"16080410251262550865\",\"name\":\"1%加息券\",\"lotteryValue\":\"1\",\"integra\":\"10000\",\"giftType\":\"threeLottery\",\"exchangeType\":\"lottery\",\"activateCondition\":\"积分换好礼活动，微积分满10000可兑换1%加息券一张\",\"description\":\"10000积分兑换1%加息券一张\"}";
    // 1.5%加息券
    public static final String TRAVEL_FOUR_LOTTERY = "{\"id\":\"16080410251261867885\",\"name\":\"1.5%加息券\",\"lotteryValue\":\"1.5\",\"integra\":\"15000\",\"giftType\":\"fourLottery\",\"exchangeType\":\"lottery\",\"activateCondition\":\"积分换好礼活动，微积分满15000可兑换1.5%加息券一张\",\"description\":\"15000积分兑换1.5%加息券一张\"}";
    public static Map<String, JSONObject> gifts = new HashMap<String, JSONObject>();

    static {
        gifts.put("fan", JSON.parseObject(FAN_GIFT));
        gifts.put("zo", JSON.parseObject(ZO_GIFT));
        gifts.put("bql", JSON.parseObject(BQL_GIFT));
        gifts.put("lamp", JSON.parseObject(LAMP_GIFT));
        gifts.put("warmCup", JSON.parseObject(WARM_CUP_GIFT));
        gifts.put("jdShopCard", JSON.parseObject(SHOP_CARD_GIFT));
        gifts.put("disneyTicket", JSON.parseObject(DISNEY_TICKET_GIFT));
        gifts.put("qdTravel", JSON.parseObject(TRAVEL_GIFT));

        // ---------中秋专场
        gifts.put("grain", JSON.parseObject(GRAIN_GIFT));
        gifts.put("foodpad", JSON.parseObject(FOODPAD_GIFT));
        gifts.put("warmthTreasure", JSON.parseObject(WARMTH_TREASURE));
        gifts.put("airClean", JSON.parseObject(AIR_CLEAN));
        gifts.put("goodscard", JSON.parseObject(GOODSCARD_GIFT));
        gifts.put("bloodpressure", JSON.parseObject(BLOODPRESSURE_GIFT));
        gifts.put("lunchbox", JSON.parseObject(LUNCHBOX_GIFT));
        gifts.put("humidifier", JSON.parseObject(HUMIDIFIER_GIFT));
        gifts.put("vacuumcleaner", JSON.parseObject(VACUUMCLEANER_GIFT));
        gifts.put("selfieStick", JSON.parseObject(SELFIE_STICK_GIFT));

        // ------------加息券
        gifts.put("oneLottery", JSON.parseObject(INTEREST_ONE_LOTTERY));
        gifts.put("twoLottery", JSON.parseObject(TRAVEL_TWO_LOTTERY));
        gifts.put("threeLottery", JSON.parseObject(TRAVEL_THREE_LOTTERY));
        gifts.put("fourLottery", JSON.parseObject(TRAVEL_FOUR_LOTTERY));

        // ---------中秋专场

    }

}
