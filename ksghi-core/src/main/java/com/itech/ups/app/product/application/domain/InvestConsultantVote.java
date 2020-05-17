package com.itech.ups.app.product.application.domain;

import java.io.Serializable;

public class InvestConsultantVote implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6836333011394016337L;

    private String id;

    private String investConsultantId;

    private String userInfoId;

    private String type;

    private String remark;

    private String dataStatus;

    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvestConsultantId() {
        return investConsultantId;
    }

    public void setInvestConsultantId(String investConsultantId) {
        this.investConsultantId = investConsultantId;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}