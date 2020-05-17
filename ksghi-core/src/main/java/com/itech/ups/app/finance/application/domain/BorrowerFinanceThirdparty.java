package com.itech.ups.app.finance.application.domain;

import java.io.Serializable;

public class BorrowerFinanceThirdparty implements Serializable {
    /**
     * @fields serialVersionUID
     */

    private static final long serialVersionUID = 1L;

    private String id;

    private String borrowerId;

    private String litigationStatus;

    private String dishonestType;

    private String litigationRemark;

    private String enterpriseCredit;

    private String otherNegativeInfo;

    private String negativeInfoDesc;

    private String infoType;

    private String blacklist;

    private String dataStatus;

    private String createTime;

    private String createrId;

    private String createrName;

    private String editTime;

    private String editorId;

    private String editorName;

    private String remark;

    private String enrollmentVerify;

    private String loanApplicationId;

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

    public String getLitigationStatus() {
        return litigationStatus;
    }

    public void setLitigationStatus(String litigationStatus) {
        this.litigationStatus = litigationStatus;
    }

    public String getDishonestType() {
        return dishonestType;
    }

    public void setDishonestType(String dishonestType) {
        this.dishonestType = dishonestType;
    }

    public String getLitigationRemark() {
        return litigationRemark;
    }

    public void setLitigationRemark(String litigationRemark) {
        this.litigationRemark = litigationRemark;
    }

    public String getEnterpriseCredit() {
        return enterpriseCredit;
    }

    public void setEnterpriseCredit(String enterpriseCredit) {
        this.enterpriseCredit = enterpriseCredit;
    }

    public String getOtherNegativeInfo() {
        return otherNegativeInfo;
    }

    public void setOtherNegativeInfo(String otherNegativeInfo) {
        this.otherNegativeInfo = otherNegativeInfo;
    }

    public String getNegativeInfoDesc() {
        return negativeInfoDesc;
    }

    public void setNegativeInfoDesc(String negativeInfoDesc) {
        this.negativeInfoDesc = negativeInfoDesc;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(String blacklist) {
        this.blacklist = blacklist;
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

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEnrollmentVerify() {
        return enrollmentVerify;
    }

    public void setEnrollmentVerify(String enrollmentVerify) {
        this.enrollmentVerify = enrollmentVerify;
    }

    public String getLoanApplicationId() {
        return loanApplicationId;
    }

    public void setLoanApplicationId(String loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
    }

}