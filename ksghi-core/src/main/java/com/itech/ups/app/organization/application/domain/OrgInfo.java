package com.itech.ups.app.organization.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrgInfo implements Serializable {

    private static final long serialVersionUID = -805409856261116557L;

    private String id;

    private String orgName;

    private String companyMobile;

    private String adminUserInfoId;

    private String adminName;

    private String adminMobile;

    private String agentName;

    private String agentMobile;

    private String orgCode;

    private String orgType;

    private String createTime;

    private String timeLimit;

    private String dataStatus;

    private String consociationStartdate;

    private String consociationEnddate;

    private BigDecimal brokerageMoney;

    private BigDecimal brokerageRate;

    private BigDecimal jumpPoint1;

    private BigDecimal jumpPoint1Rate;

    private BigDecimal jumpPoint2;

    private BigDecimal jumpPoint2Rate;

    private BigDecimal jumpPoint3;

    private BigDecimal jumpPoint3Rate;

    private BigDecimal jumpPoint4;

    private BigDecimal jumpPoint4Rate;

    private BigDecimal jumpPoint5;

    private BigDecimal jumpPoint5Rate;

    private BigDecimal myselfRate;

    private BigDecimal oneLevelRate;

    private BigDecimal secondLevelRate;

    private BigDecimal threeLevelRate;

    private BigDecimal fourLevelRate;

    private BigDecimal fiveLevelRate;

    private Integer regCommission;

    private BigDecimal firstTenderRate;

    private String status;

    private String stopDate;

    private String editIme;

    private String editorId;

    private String editorName;

    private String type;

    private BigDecimal repeatTenderRate;

    private String firstByInvest;

    private String repeatByInvest;

    private String regional;

    private String channelDirectorId;

    private String channelDirectorName;

    private String channelDirectorMobile;

    private String regionalManagerId;

    private String regionalManagerName;

    private String regionalManagerMobile;

    private String paymentType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getCompanyMobile() {
        return companyMobile;
    }

    public void setCompanyMobile(String companyMobile) {
        this.companyMobile = companyMobile;
    }

    public String getAdminUserInfoId() {
        return adminUserInfoId;
    }

    public void setAdminUserInfoId(String adminUserInfoId) {
        this.adminUserInfoId = adminUserInfoId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminMobile() {
        return adminMobile;
    }

    public void setAdminMobile(String adminMobile) {
        this.adminMobile = adminMobile;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentMobile() {
        return agentMobile;
    }

    public void setAgentMobile(String agentMobile) {
        this.agentMobile = agentMobile;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getConsociationStartdate() {
        return consociationStartdate;
    }

    public void setConsociationStartdate(String consociationStartdate) {
        this.consociationStartdate = consociationStartdate;
    }

    public String getConsociationEnddate() {
        return consociationEnddate;
    }

    public void setConsociationEnddate(String consociationEnddate) {
        this.consociationEnddate = consociationEnddate;
    }

    public BigDecimal getBrokerageMoney() {
        return brokerageMoney;
    }

    public void setBrokerageMoney(BigDecimal brokerageMoney) {
        this.brokerageMoney = brokerageMoney;
    }

    public BigDecimal getBrokerageRate() {
        return brokerageRate;
    }

    public void setBrokerageRate(BigDecimal brokerageRate) {
        this.brokerageRate = brokerageRate;
    }

    public BigDecimal getJumpPoint1() {
        return jumpPoint1;
    }

    public void setJumpPoint1(BigDecimal jumpPoint1) {
        this.jumpPoint1 = jumpPoint1;
    }

    public BigDecimal getJumpPoint1Rate() {
        return jumpPoint1Rate;
    }

    public void setJumpPoint1Rate(BigDecimal jumpPoint1Rate) {
        this.jumpPoint1Rate = jumpPoint1Rate;
    }

    public BigDecimal getJumpPoint2() {
        return jumpPoint2;
    }

    public void setJumpPoint2(BigDecimal jumpPoint2) {
        this.jumpPoint2 = jumpPoint2;
    }

    public BigDecimal getJumpPoint2Rate() {
        return jumpPoint2Rate;
    }

    public void setJumpPoint2Rate(BigDecimal jumpPoint2Rate) {
        this.jumpPoint2Rate = jumpPoint2Rate;
    }

    public BigDecimal getJumpPoint3() {
        return jumpPoint3;
    }

    public void setJumpPoint3(BigDecimal jumpPoint3) {
        this.jumpPoint3 = jumpPoint3;
    }

    public BigDecimal getJumpPoint3Rate() {
        return jumpPoint3Rate;
    }

    public void setJumpPoint3Rate(BigDecimal jumpPoint3Rate) {
        this.jumpPoint3Rate = jumpPoint3Rate;
    }

    public BigDecimal getJumpPoint4() {
        return jumpPoint4;
    }

    public void setJumpPoint4(BigDecimal jumpPoint4) {
        this.jumpPoint4 = jumpPoint4;
    }

    public BigDecimal getJumpPoint4Rate() {
        return jumpPoint4Rate;
    }

    public void setJumpPoint4Rate(BigDecimal jumpPoint4Rate) {
        this.jumpPoint4Rate = jumpPoint4Rate;
    }

    public BigDecimal getJumpPoint5() {
        return jumpPoint5;
    }

    public void setJumpPoint5(BigDecimal jumpPoint5) {
        this.jumpPoint5 = jumpPoint5;
    }

    public BigDecimal getJumpPoint5Rate() {
        return jumpPoint5Rate;
    }

    public void setJumpPoint5Rate(BigDecimal jumpPoint5Rate) {
        this.jumpPoint5Rate = jumpPoint5Rate;
    }

    public BigDecimal getMyselfRate() {
        return myselfRate;
    }

    public void setMyselfRate(BigDecimal myselfRate) {
        this.myselfRate = myselfRate;
    }

    public BigDecimal getOneLevelRate() {
        return oneLevelRate;
    }

    public void setOneLevelRate(BigDecimal oneLevelRate) {
        this.oneLevelRate = oneLevelRate;
    }

    public BigDecimal getSecondLevelRate() {
        return secondLevelRate;
    }

    public void setSecondLevelRate(BigDecimal secondLevelRate) {
        this.secondLevelRate = secondLevelRate;
    }

    public BigDecimal getThreeLevelRate() {
        return threeLevelRate;
    }

    public void setThreeLevelRate(BigDecimal threeLevelRate) {
        this.threeLevelRate = threeLevelRate;
    }

    public BigDecimal getFourLevelRate() {
        return fourLevelRate;
    }

    public void setFourLevelRate(BigDecimal fourLevelRate) {
        this.fourLevelRate = fourLevelRate;
    }

    public BigDecimal getFiveLevelRate() {
        return fiveLevelRate;
    }

    public void setFiveLevelRate(BigDecimal fiveLevelRate) {
        this.fiveLevelRate = fiveLevelRate;
    }

    public Integer getRegCommission() {
        return regCommission;
    }

    public void setRegCommission(Integer regCommission) {
        this.regCommission = regCommission;
    }

    public BigDecimal getFirstTenderRate() {
        return firstTenderRate;
    }

    public void setFirstTenderRate(BigDecimal firstTenderRate) {
        this.firstTenderRate = firstTenderRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getEditIme() {
        return editIme;
    }

    public void setEditIme(String editIme) {
        this.editIme = editIme;
    }

    public String getEditorId() {
        return editorId;
    }

    public void setEditorId(String editorId) {
        this.editorId = editorId;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getRepeatTenderRate() {
        return repeatTenderRate;
    }

    public void setRepeatTenderRate(BigDecimal repeatTenderRate) {
        this.repeatTenderRate = repeatTenderRate;
    }

    public String getFirstByInvest() {
        return firstByInvest;
    }

    public void setFirstByInvest(String firstByInvest) {
        this.firstByInvest = firstByInvest;
    }

    public String getRepeatByInvest() {
        return repeatByInvest;
    }

    public void setRepeatByInvest(String repeatByInvest) {
        this.repeatByInvest = repeatByInvest;
    }

    public String getChannelDirectorMobile() {
        return channelDirectorMobile;
    }

    public void setChannelDirectorMobile(String channelDirectorMobile) {
        this.channelDirectorMobile = channelDirectorMobile;
    }

    public String getRegionalManagerMobile() {
        return regionalManagerMobile;
    }

    public void setRegionalManagerMobile(String regionalManagerMobile) {
        this.regionalManagerMobile = regionalManagerMobile;
    }

    public String getChannelDirectorId() {
        return channelDirectorId;
    }

    public void setChannelDirectorId(String channelDirectorId) {
        this.channelDirectorId = channelDirectorId;
    }

    public String getRegionalManagerId() {
        return regionalManagerId;
    }

    public void setRegionalManagerId(String regionalManagerId) {
        this.regionalManagerId = regionalManagerId;
    }


    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getChannelDirectorName() {
        return channelDirectorName;
    }

    public void setChannelDirectorName(String channelDirectorName) {
        this.channelDirectorName = channelDirectorName;
    }

    public String getRegionalManagerName() {
        return regionalManagerName;
    }

    public void setRegionalManagerName(String regionalManagerName) {
        this.regionalManagerName = regionalManagerName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

}