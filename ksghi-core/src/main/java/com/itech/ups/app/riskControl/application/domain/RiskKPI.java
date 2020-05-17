package com.itech.ups.app.riskControl.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class RiskKPI implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String kpiType;

    private String kpiCode;

    private String kpiName;

    private BigDecimal kpiScoreStart;

    private BigDecimal kpiScoreEnd;

    private BigDecimal creditScore;

    private String createTime;

    private String dataStatus;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKpiType() {
        return kpiType;
    }

    public void setKpiType(String kpiType) {
        this.kpiType = kpiType;
    }

    public String getKpiCode() {
        return kpiCode;
    }

    public void setKpiCode(String kpiCode) {
        this.kpiCode = kpiCode;
    }

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public BigDecimal getKpiScoreStart() {
        return kpiScoreStart;
    }

    public void setKpiScoreStart(BigDecimal kpiScoreStart) {
        this.kpiScoreStart = kpiScoreStart;
    }

    public BigDecimal getKpiScoreEnd() {
        return kpiScoreEnd;
    }

    public void setKpiScoreEnd(BigDecimal kpiScoreEnd) {
        this.kpiScoreEnd = kpiScoreEnd;
    }

    public BigDecimal getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(BigDecimal creditScore) {
        this.creditScore = creditScore;
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