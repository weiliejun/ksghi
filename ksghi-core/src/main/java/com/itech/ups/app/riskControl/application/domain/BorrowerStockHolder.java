package com.itech.ups.app.riskControl.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class BorrowerStockHolder implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String borrowerId;

    private String borrowerTmsId;

    private String stockholderName;

    private BigDecimal holdScale;

    private String position;

    private String relation;

    private String createTime;

    private String dataStatus;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerTmsId() {
        return borrowerTmsId;
    }

    public void setBorrowerTmsId(String borrowerTmsId) {
        this.borrowerTmsId = borrowerTmsId;
    }

    public String getStockholderName() {
        return stockholderName;
    }

    public void setStockholderName(String stockholderName) {
        this.stockholderName = stockholderName;
    }

    public BigDecimal getHoldScale() {
        return holdScale;
    }

    public void setHoldScale(BigDecimal holdScale) {
        this.holdScale = holdScale;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}