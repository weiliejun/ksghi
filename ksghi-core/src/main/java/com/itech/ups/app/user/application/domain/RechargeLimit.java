package com.itech.ups.app.user.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class RechargeLimit implements Serializable {

    private static final long serialVersionUID = -1308753979238070489L;

    private String id;

    private String bankName;

    private String accessWay;

    private String singleLimit;

    private String remark;

    private String createTime;

    private String dataStatus;

    private String totalLimit;

    private String status;

    private String acronym;

    private BigDecimal bankIndex;

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccessWay() {
        return accessWay;
    }

    public void setAccessWay(String accessWay) {
        this.accessWay = accessWay;
    }

    public String getSingleLimit() {
        return singleLimit;
    }

    public void setSingleLimit(String singleLimit) {
        this.singleLimit = singleLimit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(String totalLimit) {
        this.totalLimit = totalLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getBankIndex() {
        return bankIndex;
    }

    public void setBankIndex(BigDecimal bankIndex) {
        this.bankIndex = bankIndex;
    }
}