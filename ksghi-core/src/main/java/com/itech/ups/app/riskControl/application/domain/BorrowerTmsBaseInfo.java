package com.itech.ups.app.riskControl.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class BorrowerTmsBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String borrowerId;

    private String userInfoId;

    private String userTmsId;

    private String name;

    private String mobile;

    private String idNo;

    private String sex;

    private String age;

    private String maritalStatus;

    private String borrowType;

    private String mateName;

    private String mateIdno;

    private String mateMobile;

    private String homeAddress;

    private String customerCategory; // 客户类别

    private String litigationStatus; // 诉讼情况（第三方）

    private String houseStatus;

    private String localResident;

    private String childrenNumber;

    private String healthStatus;

    private String badHabit;

    private String createTime;

    private String dataStatus;

    private String remark;

    /* 以下非原生 start **/
    private String openAccountStatus;

    private String registerStatus;

    private String auditStatus;

    private String creditGrade;

    private BigDecimal creditLimit;

    private BigDecimal creditScoreCalc;

    private String approvalStatus;

    private String auditEffectiveness;

    /* 以下非原生 end **/

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

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserTmsId() {
        return userTmsId;
    }

    public void setUserTmsId(String userTmsId) {
        this.userTmsId = userTmsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getBorrowType() {
        return borrowType;
    }

    public void setBorrowType(String borrowType) {
        this.borrowType = borrowType;
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    public String getMateIdno() {
        return mateIdno;
    }

    public void setMateIdno(String mateIdno) {
        this.mateIdno = mateIdno;
    }

    public String getMateMobile() {
        return mateMobile;
    }

    public void setMateMobile(String mateMobile) {
        this.mateMobile = mateMobile;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    public String getLitigationStatus() {
        return litigationStatus;
    }

    public void setLitigationStatus(String litigationStatus) {
        this.litigationStatus = litigationStatus;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getLocalResident() {
        return localResident;
    }

    public void setLocalResident(String localResident) {
        this.localResident = localResident;
    }

    public String getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(String childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getBadHabit() {
        return badHabit;
    }

    public void setBadHabit(String badHabit) {
        this.badHabit = badHabit;
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

    public String getOpenAccountStatus() {
        return openAccountStatus;
    }

    public void setOpenAccountStatus(String openAccountStatus) {
        this.openAccountStatus = openAccountStatus;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getCreditGrade() {
        return creditGrade;
    }

    public void setCreditGrade(String creditGrade) {
        this.creditGrade = creditGrade;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getCreditScoreCalc() {
        return creditScoreCalc;
    }

    public void setCreditScoreCalc(BigDecimal creditScoreCalc) {
        this.creditScoreCalc = creditScoreCalc;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getAuditEffectiveness() {
        return auditEffectiveness;
    }

    public void setAuditEffectiveness(String auditEffectiveness) {
        this.auditEffectiveness = auditEffectiveness;
    }

}