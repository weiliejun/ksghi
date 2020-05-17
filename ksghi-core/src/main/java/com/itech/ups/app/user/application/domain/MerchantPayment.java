package com.itech.ups.app.user.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class MerchantPayment implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 9095674788203402331L;

    private String id;

    private String tenderId;

    private String userInfoId;

    private String usrCustId;

    private String productId;

    private BigDecimal repayAmount;

    private String repayAmountType;

    private String repayPlanDate;

    private String repayTime;

    private String respContent;

    private String respStatus;

    private String respDesc;

    private String requestContent;

    private String status;

    private String remark;

    private String createTime;

    private String dataStatus;

    private boolean saveSuccess = false;// 保存状态

    private Tender tender;

    private String depoBankSeq;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenderId() {
        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUsrCustId() {
        return usrCustId;
    }

    public void setUsrCustId(String usrCustId) {
        this.usrCustId = usrCustId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public String getRepayAmountType() {
        return repayAmountType;
    }

    public void setRepayAmountType(String repayAmountType) {
        this.repayAmountType = repayAmountType;
    }

    public String getRepayPlanDate() {
        return repayPlanDate;
    }

    public void setRepayPlanDate(String repayPlanDate) {
        this.repayPlanDate = repayPlanDate;
    }

    public String getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(String repayTime) {
        this.repayTime = repayTime;
    }

    public String getRespContent() {
        return respContent;
    }

    public void setRespContent(String respContent) {
        this.respContent = respContent;
    }

    public String getRespStatus() {
        return respStatus;
    }

    public void setRespStatus(String respStatus) {
        this.respStatus = respStatus;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public boolean isSaveSuccess() {
        return saveSuccess;
    }

    public void setSaveSuccess(boolean saveSuccess) {
        this.saveSuccess = saveSuccess;
    }

    public Tender getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public String getDepoBankSeq() {
        return depoBankSeq;
    }

    public void setDepoBankSeq(String depoBankSeq) {
        this.depoBankSeq = depoBankSeq;
    }

}