package com.itech.ups.app.riskControl.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class RiskGrade implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String riskGrade;

    private BigDecimal riskScoreStart;

    private BigDecimal riskScoreEnd;

    private BigDecimal creditLimitStart;

    private BigDecimal creditLimitEnd;

    private String createTime;

    private String dataStatus;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRiskGrade() {
        return riskGrade;
    }

    public void setRiskGrade(String riskGrade) {
        this.riskGrade = riskGrade;
    }

    public BigDecimal getRiskScoreStart() {
        return riskScoreStart;
    }

    public void setRiskScoreStart(BigDecimal riskScoreStart) {
        this.riskScoreStart = riskScoreStart;
    }

    public BigDecimal getRiskScoreEnd() {
        return riskScoreEnd;
    }

    public void setRiskScoreEnd(BigDecimal riskScoreEnd) {
        this.riskScoreEnd = riskScoreEnd;
    }

    public BigDecimal getCreditLimitStart() {
        return creditLimitStart;
    }

    public void setCreditLimitStart(BigDecimal creditLimitStart) {
        this.creditLimitStart = creditLimitStart;
    }

    public BigDecimal getCreditLimitEnd() {
        return creditLimitEnd;
    }

    public void setCreditLimitEnd(BigDecimal creditLimitEnd) {
        this.creditLimitEnd = creditLimitEnd;
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