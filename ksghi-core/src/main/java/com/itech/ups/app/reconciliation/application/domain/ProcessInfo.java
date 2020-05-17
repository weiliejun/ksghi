package com.itech.ups.app.reconciliation.application.domain;

import java.io.Serializable;

public class ProcessInfo implements Serializable {

    private static final long serialVersionUID = 6415943827494884696L;

    private String id;

    private String processDate;

    private String processStatus;

    private String saveProcessDesc;

    private String saveProcessTime;

    private String saveProcessorId;

    private String saveProcessorName;

    private String cashProcessDesc;

    private String cashProcessTime;

    private String cashProcessorId;

    private String cashProcessorName;

    private String trfProcessDesc;

    private String trfProcessTime;

    private String trfProcessorId;

    private String trfProcessorName;

    private String remark;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String loansProcessDesc;

    private String loansProcessTime;

    private String loansProcessorId;

    private String loansProcessorName;

    private String repaymentProcessDesc;

    private String repaymentProcessTime;

    private String repaymentProcessorId;

    private String repaymentProcessorName;

    public String getCashProcessDesc() {
        return cashProcessDesc;
    }

    public void setCashProcessDesc(String cashProcessDesc) {
        this.cashProcessDesc = cashProcessDesc;
    }

    public String getCashProcessorId() {
        return cashProcessorId;
    }

    public void setCashProcessorId(String cashProcessorId) {
        this.cashProcessorId = cashProcessorId;
    }

    public String getCashProcessorName() {
        return cashProcessorName;
    }

    public void setCashProcessorName(String cashProcessorName) {
        this.cashProcessorName = cashProcessorName;
    }

    public String getCashProcessTime() {
        return cashProcessTime;
    }

    public void setCashProcessTime(String cashProcessTime) {
        this.cashProcessTime = cashProcessTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoansProcessDesc() {
        return loansProcessDesc;
    }

    public void setLoansProcessDesc(String loansProcessDesc) {
        this.loansProcessDesc = loansProcessDesc;
    }

    public String getLoansProcessorId() {
        return loansProcessorId;
    }

    public void setLoansProcessorId(String loansProcessorId) {
        this.loansProcessorId = loansProcessorId;
    }

    public String getLoansProcessorName() {
        return loansProcessorName;
    }

    public void setLoansProcessorName(String loansProcessorName) {
        this.loansProcessorName = loansProcessorName;
    }

    public String getLoansProcessTime() {
        return loansProcessTime;
    }

    public void setLoansProcessTime(String loansProcessTime) {
        this.loansProcessTime = loansProcessTime;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRepaymentProcessDesc() {
        return repaymentProcessDesc;
    }

    public void setRepaymentProcessDesc(String repaymentProcessDesc) {
        this.repaymentProcessDesc = repaymentProcessDesc;
    }

    public String getRepaymentProcessorId() {
        return repaymentProcessorId;
    }

    public void setRepaymentProcessorId(String repaymentProcessorId) {
        this.repaymentProcessorId = repaymentProcessorId;
    }

    public String getRepaymentProcessorName() {
        return repaymentProcessorName;
    }

    public void setRepaymentProcessorName(String repaymentProcessorName) {
        this.repaymentProcessorName = repaymentProcessorName;
    }

    public String getRepaymentProcessTime() {
        return repaymentProcessTime;
    }

    public void setRepaymentProcessTime(String repaymentProcessTime) {
        this.repaymentProcessTime = repaymentProcessTime;
    }

    public String getSaveProcessDesc() {
        return saveProcessDesc;
    }

    public void setSaveProcessDesc(String saveProcessDesc) {
        this.saveProcessDesc = saveProcessDesc;
    }

    public String getSaveProcessorId() {
        return saveProcessorId;
    }

    public void setSaveProcessorId(String saveProcessorId) {
        this.saveProcessorId = saveProcessorId;
    }

    public String getSaveProcessorName() {
        return saveProcessorName;
    }

    public void setSaveProcessorName(String saveProcessorName) {
        this.saveProcessorName = saveProcessorName;
    }

    public String getSaveProcessTime() {
        return saveProcessTime;
    }

    public void setSaveProcessTime(String saveProcessTime) {
        this.saveProcessTime = saveProcessTime;
    }

    public String getTrfProcessDesc() {
        return trfProcessDesc;
    }

    public void setTrfProcessDesc(String trfProcessDesc) {
        this.trfProcessDesc = trfProcessDesc;
    }

    public String getTrfProcessorId() {
        return trfProcessorId;
    }

    public void setTrfProcessorId(String trfProcessorId) {
        this.trfProcessorId = trfProcessorId;
    }

    public String getTrfProcessorName() {
        return trfProcessorName;
    }

    public void setTrfProcessorName(String trfProcessorName) {
        this.trfProcessorName = trfProcessorName;
    }

    public String getTrfProcessTime() {
        return trfProcessTime;
    }

    public void setTrfProcessTime(String trfProcessTime) {
        this.trfProcessTime = trfProcessTime;
    }
}