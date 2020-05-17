package com.itech.ups.base.constant;

/**
 * 消息常量
 */
public class MessageConstant {
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

    //------------------系统通知 start----------------------------------------
    //注册成功
    public static final String REGISTER_SUCCESS = "registerSuccess";
    //开通资金托管账户
    public static final String OPEN_ACCOUNT = "openAccount";
    //邮箱认证
    public static final String ATTESTATION_EMAIL = "emailConfirm";
    //风险评估
    public static final String RISK_ASSESSMENT = "riskAssessment";
    //修改登录密码
    public static final String EDIT_PASSWORD = "passwordEdit";
    //修改手机号码
    public static final String EDIT_MOBILE = "mobileEdit";
    //修改邮箱地址
    public static final String EDIT_EMAIL = "emailEdit";
    //重置登录密码
    public static final String RESET_PASSWORD = "resetPassword";
    //-------------------系统通知end---------------------------------------

    //-------------------交易通知start------------------------------------
    //放款成功
    public static final String LOAN_SUCCESS = "loanSuccess";
    //撤销
    public static final String REVOCATION_TENDER = "revocationTender";
    //流标
    public static final String LEAVE_TENDER = "failTender";
    //债权售出
    public static final String CREDITASSIGNMENT_SELL = "sellCredit";
    //购买债权
    public static final String CREDITASSIGNMENT_BUY = "buyCredit";
    //提前回款到账通知
    public static final String RECEIVABLE_ACCOUNT = "investmentDebtService";
    //正常回款到账通知
    public static final String RECEIVABLE_ACCOUNT_NORMAL = "investmentDebtServiceNormal";
    //回款提醒
    public static final String RECEIVABLE_NOTIFY = "receivableNotify";
    //提前还款
    public static final String PREPAYMENT = "prepayment";
    //-------------------交易通知end---------------------------------------

    //-------------------奖品通知start------------------------------------
    //获得奖励
    public static final String RECEIVE_AWARD = "receiveAward";
    //奖券到期
    public static final String LOTTERY_EXPIRE = "lotteryExpire";
    //实物奖品派发
    public static final String PAYOUT_AWARD = "payoutAward";
    //积分兑换
    public static final String EXCHANGE_INTEGRAL = "exchangeIntegral";
    //-------------------奖品通知end------------------------------------

    //-------------------新标通知start------------------------------------
    public static final String NEW_TENDER = "productPublish";

    public static final String PRODUCT_TENDER = "productTender";

    //信息模板
    public static final String INVITE_CODE = "inviteCode";

    public static final String REGISTER = "register";

    public static final String LOGIN_RESET = "loginRet";

    public static final String MOBILE_BIND = "mobileBind";

    public static final String EMAIL_CONFIRM_SUCCESS = "emailConfirmSuccess";

    public static final String EMAIL_BIND = "emailBind";

    public static final String INTEGRAL_AWARD = "integralAward";

    public static final String INTEGRAL_CONVERT = "integralConvert";

    public static final String UNFREEZE_FUND = "unfreezeFund";

    public static final String PAYMENT_SUCCESS = "paymentSuccess";

    public static final String CALLLOAN = "callLoan";

    public static final String REPAYMENT_WARN = "repaymentWarn";

    public static final String PROMPT = "prompt";

    public static final String REPAYMENT_FREEZE = "repaymentFreeze";

    public static final String BORROWER_DEBT_SERVICE = "borrowerDebtService";

    //public static final String  INVESTMENT_DEBT_SERVICE ="investmentDebtService";汇款到账通知

    public static final String REPLACE_REPAYMENT_GUARANTEE = "replaceRepaymentGuarantee";

    public static final String REOLACE_REPAYMENT_BORROWER = "replaceRepaymentBorrower";

    public static final String PRODUCT_WAIT_AUDIT = "productWaitAudit";

    public static final String NOTENDER_AUDIT = "noTenderAudit";

    public static final String FULL_TENDER_AUDIT_PAYER = "fullTenderAuditPayer";

    public static final String FULL_TENDER_AUDIT_ADMIN = "fullTenderAuditAdmin";

    public static final String BIRTHDAY = "birthday";

    public static final String HOLIDAY = "holiday";

    public static final String INTEGRA_FOR_RECOMMENDATION = "integraForRecommendation";

    public static final String INTEGRA_FOR_OPEN_ACCOUNT = "integraForOpenAccount";

    public static final String RECOMMEND_FRIENDS = "recommendFriends";

    public static final String WITHDRAWING_CASH_APPLY = "withdrawingCashApply";

    public static final String INVEST_CONFIRM = "investConfirm";

    public static final String CONFIRM_PRO_AND_CONTRACTS = "confirmProAndContracts";

    public static final String INTEGRAL_CASH_RECEIVING = "integralCashReceiving";

    public static final String CREDIT_CANCEL_FOR_PREPAYMENT = "creditCancelForPrepayment";

    public static final String CREDIT_CANCEL_FOR_EXPIRATION = "creditCancelForExpiration";

    public static final String CREDITASSIGMENT = "creditassignment";

    public static final String CANOTIFICATION_FOR_BORROWER = "cANotificationForBorrower";

    public static final String CANOTIFICATION_FOR_THIRD_CORP = "cANotificationForThirdCorp";

    public static final String MICRO_LETTER_REPRODUCED = "microLetterReproduced";

    public static final String MICRO_LETTER_RANKING = "microLetterRanking";

    public static final String MICRO_LETTER_DRAW = "microLetterDraw";

    public static final String REGISTER_ACTIVITY = "registerActivity";

    public static final String REGISTER_VOCHER_ACTIVITY = "registerVochersActivity";

    public static final String REGISTER_FIRST_INVEST_ACTIVITY = "registerFirstInvestActivity";

    public static final String GAIN_letter_word = "gainLetterword";

    public static final String USE_LOTTERY = "uselottery";

    public static final String INTEGRAL_EXCHANGE_GIFT = "integralExchangeGift";

    public static final String LOAV_APPLY = "loanApply";

    public static final String FIRST_INVEST = "firstInvest";

    public static final String FIRST_INVEST_JIFEN = "firstInvestJifen";

    public static final String MOBILE_EDIT_SUCCESS = "mobileEditSuccess";

    public static final String PASSWORD_EDIT = "passwordEdit";

    public static final String PASSWORD_RESET = "passwordRes";

    public static final String GAIN_LOTTERY = "gainLottery";

    public static final String SMASH_INTEGRAL_EGG = "smashIntegralEgg";

    public static final String FRIENDS_NOT_INVEST = "friendsNotInvest";

    public static final String FRINEDS_FIRST_INVESTED = "friendsFirstInvested";

    //微信业务命名
    public static final String INVESTMENT_FIRST = "投标的";

    public static final String DRAWING_CASH_FIRST = "尊敬的用户，充值金额已成功到账";

    public static final String WITHDRAWING_CASH_FIRST = "尊敬的用户，提现申请已提交";

    public static final String OPEN_ACCOUNT_FIRST = "尊敬的用户，恭喜您银行存管账户开通成功";

    public static final String EDIT_PASSWORD_FIRST = "尊敬的用户，登录密码修改成功";

    public static final String EDIT_MOBILE_FIRST = "尊敬的用户，手机号码修改成功";

    public static final String REVOCATION_TENDER_FIRST = "尊敬的用户，很抱歉，您出借的项目抢标失败，资金已返还至您的账户";

    public static final String CREDITASSIGNMENT_SELL_FIRST = "尊敬的用户，您发布的债权已转让成功，资金已入账到您的账户";

    public static final String LOAN_SUCCESS_FIRST = "尊敬的用户，您出借的标的已满标放款成功";

    public static final String LEAVE_TENDER_FIRST = "尊敬的用户，您的出借已流标";

    public static final String RECEIVABLE_NOTIFY_FIRST = "尊敬的用户，您有一个出借项目即将到期";

    public static final String RECEIVABLE_ACCOUNT_FIRST = "尊敬的用户，您有一笔提前还款已到账";

    public static final String RECEIVABLE_ACCOUNT_NORMAL_FIRST = "尊敬的用户，您有一笔回款已到账";


}
