package com.itech.ups.app.riskControl.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class RiskCreditIndex implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String kpiCode;

    private String kpiName;

    private BigDecimal kpiScoreOverdueYes;

    private BigDecimal kpiScoreOverdueNo;

    private BigDecimal kpiScoreBadYes;

    private BigDecimal kpiScoreBadNo;

    private String createTime;

    private String dataStatus;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BigDecimal getKpiScoreOverdueYes() {
        return kpiScoreOverdueYes;
    }

    public void setKpiScoreOverdueYes(BigDecimal kpiScoreOverdueYes) {
        this.kpiScoreOverdueYes = kpiScoreOverdueYes;
    }

    public BigDecimal getKpiScoreOverdueNo() {
        return kpiScoreOverdueNo;
    }

    public void setKpiScoreOverdueNo(BigDecimal kpiScoreOverdueNo) {
        this.kpiScoreOverdueNo = kpiScoreOverdueNo;
    }

    public BigDecimal getKpiScoreBadYes() {
        return kpiScoreBadYes;
    }

    public void setKpiScoreBadYes(BigDecimal kpiScoreBadYes) {
        this.kpiScoreBadYes = kpiScoreBadYes;
    }

    public BigDecimal getKpiScoreBadNo() {
        return kpiScoreBadNo;
    }

    public void setKpiScoreBadNo(BigDecimal kpiScoreBadNo) {
        this.kpiScoreBadNo = kpiScoreBadNo;
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