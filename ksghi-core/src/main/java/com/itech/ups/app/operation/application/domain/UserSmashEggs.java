package com.itech.ups.app.operation.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserSmashEggs implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1981601476152715756L;

    private String id;

    private String smashEggsId;

    private String userInfoId;

    private String userNickName;

    private String usrCustId;

    private BigDecimal amount;

    private String repayStatus;

    private String createTime;

    private String remark;

    private String dataStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSmashEggsId() {
        return smashEggsId;
    }

    public void setSmashEggsId(String smashEggsId) {
        this.smashEggsId = smashEggsId;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUsrCustId() {
        return usrCustId;
    }

    public void setUsrCustId(String usrCustId) {
        this.usrCustId = usrCustId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRepayStatus() {
        return repayStatus;
    }

    public void setRepayStatus(String repayStatus) {
        this.repayStatus = repayStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }
}