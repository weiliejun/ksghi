package com.itech.ups.app.components.domain;

/**
 * 消息类型枚举类
 */

public enum MessageBusiType {
    //-----------------系统通知 start -------------------
    //关注通知
    attentionNotify("关注通知提醒"),
    // 注册成功
    registerSuccess("注册成功提醒"),
    // 开户成功
    openAccount("开通资金托管账户成功提醒"),
    //邮箱认证
    emailConfirm("邮箱认证"),
    // 风险评估
    riskAssessment("风险评估完成提醒"),
    // 修改登录密码
    passwordEdit("修改登录密码成功提醒"),
    // 重置密码
    passwordRes("用户重置密码成功提醒"),
    //修改手机号码
    mobileEdit("修改手机号码提醒"),
    //修改邮箱
    emailEdit("修改邮箱提醒"),
    //重置登录密码
    resetPassword("重置登录密码提醒"),
    //-----------------系统通知 end ----------------------


    // -------------------交易通知start------------------------------------
    //放款成功
    loanSuccess("放款成功提醒"),
    //撤销
    revocationTender("投标撤销提醒"),
    //流标
    failTender("流标提醒"),
    //债权售出
    sellCredit("债权售出时发送提醒"),
    //购买债权
    buyCredit("债权购买成功时发送提醒"),
    //回款到账
    receivableAccount("回款到账提醒"),
    // 提前还款
    prepayment("用户提前还款成功提醒"),
    //充值
    drawingCash("充值成功发送提醒"),
    //提现
    withdrawingCash("提现申请成功发送提醒"),
    //投标成功
    investment("投标成功，账户资金冻结时发送提醒"),
    // -------------------交易通知end------------------------------------

    // -------------------奖品通知start------------------------------------
    //获得奖励
    receiveAward("获得奖励提醒"),
    //奖券到期
    lotteryExpire("奖券到期提醒"),
    //实物奖品派发
    payoutAward("实物奖品派发提醒"),
    // 积分兑换
    exchangeIntegral("积分兑换提醒"),
    // -------------------奖品通知end------------------------------------


    //新产品发布
    productPublish("新产品发布时发送提醒"),

    productTender("产品募集期开始前【1小时】发送提醒"),

    inviteCode,

    register,

    loginRet,

    mobileBind,

    emailConfirmSuccess,

    emailBind,

    integralAward("获取积分奖励发送提醒"),

    integralConvert,

    unfreezeFund("未满标，账户资金解冻后发送提醒"),

    paymentSuccess("满标放款后，资金划拨至借款方账户时发送提醒"),

    callLoan,

    repaymentWarn,

    prompt,

    repaymentFreeze,

    borrowerDebtService,

    investmentDebtService("已出借项目，收款到账时发送提醒"),

    replaceRepaymentGuarantee,

    replaceRepaymentBorrower,

    productWaitAudit,

    noTenderAudit,

    fullTenderAuditPayer,

    fullTenderAuditAdmin,

    birthday,

    holiday,

    integraForRecommendation,

    integraForOpenAccount,

    recommendFriends,

    withdrawingCashApply,

    investConfirm,

    confirmProAndContracts,

    integralCashReceiving("积分红包到账时发送提醒"),

    creditCancelForPrepayment("债权下架（提前还款）时发送提醒"),

    creditCancelForExpiration("债权下架（到期下架）时发送提醒"),

    creditassignment,

    cANotificationForBorrower,

    cANotificationForThirdCorp,

    microLetterReproduced,

    microLetterRanking,

    microLetterDraw,

    registerActivity,

    registerVochersActivity,

    registerFirstInvestActivity,

    gainLetterword("用户获得奖券"),

    uselottery("用户使用奖券"),

    integralExchangeGift,

    loanApply,

    firstInvest("首投送红包"),

    firstInvestJifen("首投送积分"),

    mobileEditSuccess,


    gainLottery,

    smashIntegralEgg,

    friendsNotInvest,

    friendsFirstInvested,

    defrayRet,

    integraConvert,

    replaceRepayment,

    fullTenderAudit,

    autoRemindLotteryExpired,
    // 撤标
    tenderCancel("用户撤标成功提醒"),
    // 奖品发放
    exchangeGiftSend("奖品成功发放提醒");
    // 消息类型描述，用于用户消息设置表
    private String description;

    private MessageBusiType() {
        this.description = "";
    }

    private MessageBusiType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}