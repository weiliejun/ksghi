package com.itech.ups.app.merCashContract.application.domain;

import java.io.Serializable;

public class Mercashcontract implements Serializable {


    private static final long serialVersionUID = 1L;

    private String id;

    private String userInfoId;

    private String usrCustId;

    private String ordId;

    private String dayLimitAmt;

    private String signNo;

    private String endDate;

    private String signReqContent;

    private String signRespContent;

    private String signRespStatus;

    private String signRespCode;

    private String signRespDesc;

    private String signDepoBankSeq;

    private String cancelReqContent;

    private String cancelRespContent;

    private String cancelRespStatus;

    private String cancelRespCode;

    private String cancelRespDesc;

    private String cancelDepoBankSeq;

    private String status;

    private String createTime;

    private String dataStatus;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getDayLimitAmt() {
        return dayLimitAmt;
    }

    public void setDayLimitAmt(String dayLimitAmt) {
        this.dayLimitAmt = dayLimitAmt;
    }

    public String getSignNo() {
        return signNo;
    }

    public void setSignNo(String signNo) {
        this.signNo = signNo;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSignReqContent() {
        return signReqContent;
    }

    public void setSignReqContent(String signReqContent) {
        this.signReqContent = signReqContent;
    }

    public String getSignRespContent() {
        return signRespContent;
    }

    public void setSignRespContent(String signRespContent) {
        this.signRespContent = signRespContent;
    }

    public String getSignRespStatus() {
        return signRespStatus;
    }

    public void setSignRespStatus(String signRespStatus) {
        this.signRespStatus = signRespStatus;
    }

    public String getSignRespCode() {
        return signRespCode;
    }

    public void setSignRespCode(String signRespCode) {
        this.signRespCode = signRespCode;
    }

    public String getSignRespDesc() {
        return signRespDesc;
    }

    public void setSignRespDesc(String signRespDesc) {
        this.signRespDesc = signRespDesc;
    }

    public String getSignDepoBankSeq() {
        return signDepoBankSeq;
    }

    public void setSignDepoBankSeq(String signDepoBankSeq) {
        this.signDepoBankSeq = signDepoBankSeq;
    }

    public String getCancelReqContent() {
        return cancelReqContent;
    }

    public void setCancelReqContent(String cancelReqContent) {
        this.cancelReqContent = cancelReqContent;
    }

    public String getCancelRespContent() {
        return cancelRespContent;
    }

    public void setCancelRespContent(String cancelRespContent) {
        this.cancelRespContent = cancelRespContent;
    }

    public String getCancelRespStatus() {
        return cancelRespStatus;
    }

    public void setCancelRespStatus(String cancelRespStatus) {
        this.cancelRespStatus = cancelRespStatus;
    }

    public String getCancelRespCode() {
        return cancelRespCode;
    }

    public void setCancelRespCode(String cancelRespCode) {
        this.cancelRespCode = cancelRespCode;
    }

    public String getCancelRespDesc() {
        return cancelRespDesc;
    }

    public void setCancelRespDesc(String cancelRespDesc) {
        this.cancelRespDesc = cancelRespDesc;
    }

    public String getCancelDepoBankSeq() {
        return cancelDepoBankSeq;
    }

    public void setCancelDepoBankSeq(String cancelDepoBankSeq) {
        this.cancelDepoBankSeq = cancelDepoBankSeq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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