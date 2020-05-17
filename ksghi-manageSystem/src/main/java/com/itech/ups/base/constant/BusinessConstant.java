package com.itech.ups.base.constant;

import com.itech.core.util.StringHelper;

/**
 * 业务常量
 */
public class BusinessConstant {
    //----------------------key值常量（start）---------------------
    public static final String USERID = "userId";// 用户Id
    public static final String BUSI_MSG_TYPE = "busiMsgType";// 业务消息类型
    public static final String SEND_MSG_TYPE = "sendMsgType";// 发送消息的方式
    public static final String SEND_TYPE_MOBILE = "sendTypeMobile";// 发送手机短信
    public static final String SEND_TYPE_EMAIL = "sendTypeEmail";// 发送邮件
    public static final String SEND_WEBSITE_MOBILE = "sendTypeWebsite";// 发送网站消息
    public static final String SEND_TYPE_WECHAT = "sendTypeWechat";// 发送微信消息
    // ------------------数据的有效性 （data_status） start-------------
    public static final String DATA_STATUS_VALID = "valid";// 有效
    public static final String DATA_STATUS_INVALID = "invalid";// 无效

    //----------------------key值常量（end）-----------------------
    // ------------------奖券类型 start-------------
    public static final String LOTTERY_TYPE_INTEGRAL = "integral";// 积分券
    public static final String LOTTERY_TYPE_CASH = "cash";// 现金券
    // ------------------奖券类型 end-------------
    public static final String LOTTERY_TYPE_INTEREST = "interest";// 加息券
    public static final String LOTTERY_TYPE_GIFT = "gift";// 礼品券
    public static final String LOTTERY_TYPE_EBATE = "ebate";// 返利券
    public static final String LOTTERY_TYPE_VOCHER = "vocher";// 代金券
    public static final String LOTTERY_TYPE_FIRSTINVEST = "firstInvest";// 首投券
    public static final String DATE_REPAY = "0.0004";// 日利率
    // 微信公众号自定义菜单级别
    public static final int MENU_LEVLE1 = 1;
    public static final int MENU_LEVLE2 = 2;

    // ------------------奖券类型 end-------------
    // 微信的access_token
    public static final String WECHAT_ACCESS_TOKEN = "wechatAccessToken";
    /**
     * 消息通知标识
     */
    // 关注通知
    public static final String ATTENTION_NOTIFY = "attentionNotify";
    // 充值成功通知
    public static final String DRAWING_CASH = "drawingCash";
    // 提现成功通知
    public static final String WITHDRAWING_CASH = "withdrawingCash";
    // 投标成功通知
    public static final String INVESTMENT = "investment";
    // ------------------菁英计划start-------------
    public static final String HIGTH_LIMIT = "200000";// 最高额度
    public static final String DAY_RETE = "0.04";// 日利率
    public static final String SOURCE = "platform";// 来源
    public static final String ELITE_NAME = "菁英计划";// 菁英计划名字常量
    // -----------------消息管理新增微信通知start 2017-10-20 cyp	----------------
    //------------------系统通知 start----------------------------------------
    //注册成功
    public static final String REGISTER_SUCCESS = "registerSuccess";
    //开通资金托管账户
    public static final String OPEN_ACCOUNT = "openAccount";

    // -----------------菁英计划end----------------
    //邮箱认证
    public static final String ATTESTATION_EMAIL = "attestationEmail";
    //风险评估
    public static final String RISK_ASSESSMENT = "riskAssessment";
    //修改登录密码
    public static final String EDIT_PASSWORD = "passwordEdit";
    //修改手机号码
    public static final String EDIT_MOBILE = "editMobile";
    //修改邮箱地址
    public static final String EDIT_EMAIL = "editEmail";
    //重置登录密码
    public static final String RESET_PASSWORD = "resetPassword";
    //-------------------交易通知start------------------------------------
    //放款成功
    public static final String LOAN_SUCCESS = "loanSuccess";
    //撤销
    public static final String REVOCATION_TENDER = "revocationTender";
    //-------------------系统通知end---------------------------------------
    //流标
    public static final String LEAVE_TENDER = "failTender";
    //债权售出
    public static final String CREDITASSIGNMENT_SELL = "sellCredit";
    //购买债权
    public static final String CREDITASSIGNMENT_BUY = "buyCredit";
    //回款到账
    public static final String RECEIVABLE_ACCOUNT = "investmentDebtService";
    //提前还款
    public static final String PREPAYMENT = "prepayment";
    //-------------------奖品通知start------------------------------------
    //获得奖励
    public static final String RECEIVE_AWARD = "receiveAward";
    //奖券到期
    public static final String LOTTERY_EXPIRE = "lotteryExpire";
    //-------------------交易通知end---------------------------------------
    //实物奖品派发
    public static final String PAYOUT_AWARD = "payoutAward";
    //积分兑换
    public static final String EXCHANGE_INTEGRAL = "exchangeIntegral";
    //-------------------新标通知start------------------------------------
    public static final String NEW_TENDER = "newTender";
    //存管账户
    public static final String ACCOUNT_NAME = "accountName";
    //-------------------奖品通知end------------------------------------
    //修改密码项目常量
    public static final String EDIT_PASSWORD_TYPE = "登录密码";
    //客服热线
    public static final String SERVICE_ONLINE = "若您有任何疑问，请在此微信下方留言，或致电官方客服热线：400-086-1590";
    //后台发送短信的备注
    public static final String REMARK = "感谢您的使用，祝您出借愉快";
    //--------------消息频道channel---------------
    public static String REDIS_MSG_CHANNEL = null;

    static {
        /**
         * 初始化频道
         * 每次启动都会生成新的频道，这样可以保证每个服务只订阅自己的频道
         */
        String randomStr = StringHelper.generateRandomStr(8);
        REDIS_MSG_CHANNEL = "systemManager.msg." + randomStr;

    }


}
