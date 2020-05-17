package com.itech.ups.app.guarantycorp.application.domain;

import java.math.BigDecimal;

public class GuarantyCorp implements java.io.Serializable {
    private String id;

    private String userInfoId;

    private String mobile;

    private String inviteCode;

    private String name;

    private String nature;

    private BigDecimal registeredCapital;

    private String province;

    private String city;

    private String address;

    private String postCode;

    private String phone;

    private String fax;

    private String corpOwnerName;

    private String corpOwnerPhone;

    private String corpOwnerIdNo;

    private String creditLevel;

    private String creditDescription;

    private String summary;

    private String busiCode;

    private String busiAddress;

    private String instuCode;

    private String taxCode;

    private String busiPermitsCode;

    private String accountsPermitsFile;

    private String riskControlFile;

    private String balanceSheetFile;

    private String illegalFile;

    private String busiFile;

    private String instuFile;

    private String taxFile;

    private String busiPermitsFile;

    private String frameworkFile;

    private String creditFile;

    private String corpRuleFile;

    private String cooperationAgreementFile;

    private String agentName;

    private String agentSex;

    private String agentPosition;

    private String agentMobile;

    private String agentPhone;

    private String agentIdNo;

    private String agentEmail;

    private String agentHomeAddress;

    private String agentRemark;

    private String status;

    private String auditStatus;

    private String auditDesc;

    private String auditTime;

    private String auditorId;

    private String auditorName;

    private String remark;

    private String dataStatus;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String editTime;

    private String editorId;

    private String editorName;
    // 公司公司简介
    private String shortName;

    // 开户状态：为关联查询接受值用并不是该表的字段
    private String openAccountStatus;

    private String activateStatus;
    private String licStartDate;
    private String licEndDate;

    public String getLicStartDate() {
        return licStartDate;
    }

    public void setLicStartDate(String licStartDate) {
        this.licStartDate = licStartDate;
    }

    public String getLicEndDate() {
        return licEndDate;
    }

    public void setLicEndDate(String licEndDate) {
        this.licEndDate = licEndDate;
    }

    public String getActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(String activateStatus) {
        this.activateStatus = activateStatus;
    }

    public String getAccountsPermitsFile() {
        return accountsPermitsFile;
    }

    public void setAccountsPermitsFile(String accountsPermitsFile) {
        this.accountsPermitsFile = accountsPermitsFile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public String getAgentHomeAddress() {
        return agentHomeAddress;
    }

    public void setAgentHomeAddress(String agentHomeAddress) {
        this.agentHomeAddress = agentHomeAddress;
    }

    public String getAgentIdNo() {
        return agentIdNo;
    }

    public void setAgentIdNo(String agentIdNo) {
        this.agentIdNo = agentIdNo;
    }

    public String getAgentMobile() {
        return agentMobile;
    }

    public void setAgentMobile(String agentMobile) {
        this.agentMobile = agentMobile;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getAgentPosition() {
        return agentPosition;
    }

    public void setAgentPosition(String agentPosition) {
        this.agentPosition = agentPosition;
    }

    public String getAgentRemark() {
        return agentRemark;
    }

    public void setAgentRemark(String agentRemark) {
        this.agentRemark = agentRemark;
    }

    public String getAgentSex() {
        return agentSex;
    }

    public void setAgentSex(String agentSex) {
        this.agentSex = agentSex;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getBalanceSheetFile() {
        return balanceSheetFile;
    }

    public void setBalanceSheetFile(String balanceSheetFile) {
        this.balanceSheetFile = balanceSheetFile;
    }

    public String getBusiAddress() {
        return busiAddress;
    }

    public void setBusiAddress(String busiAddress) {
        this.busiAddress = busiAddress;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public String getBusiFile() {
        return busiFile;
    }

    public void setBusiFile(String busiFile) {
        this.busiFile = busiFile;
    }

    public String getBusiPermitsCode() {
        return busiPermitsCode;
    }

    public void setBusiPermitsCode(String busiPermitsCode) {
        this.busiPermitsCode = busiPermitsCode;
    }

    public String getBusiPermitsFile() {
        return busiPermitsFile;
    }

    public void setBusiPermitsFile(String busiPermitsFile) {
        this.busiPermitsFile = busiPermitsFile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCooperationAgreementFile() {
        return cooperationAgreementFile;
    }

    public void setCooperationAgreementFile(String cooperationAgreementFile) {
        this.cooperationAgreementFile = cooperationAgreementFile;
    }

    public String getCorpOwnerIdNo() {
        return corpOwnerIdNo;
    }

    public void setCorpOwnerIdNo(String corpOwnerIdNo) {
        this.corpOwnerIdNo = corpOwnerIdNo;
    }

    public String getCorpOwnerName() {
        return corpOwnerName;
    }

    public void setCorpOwnerName(String corpOwnerName) {
        this.corpOwnerName = corpOwnerName;
    }

    public String getCorpOwnerPhone() {
        return corpOwnerPhone;
    }

    public void setCorpOwnerPhone(String corpOwnerPhone) {
        this.corpOwnerPhone = corpOwnerPhone;
    }

    public String getCorpRuleFile() {
        return corpRuleFile;
    }

    public void setCorpRuleFile(String corpRuleFile) {
        this.corpRuleFile = corpRuleFile;
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

    public String getCreditDescription() {
        return creditDescription;
    }

    public void setCreditDescription(String creditDescription) {
        this.creditDescription = creditDescription;
    }

    public String getCreditFile() {
        return creditFile;
    }

    public void setCreditFile(String creditFile) {
        this.creditFile = creditFile;
    }

    public String getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
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

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFrameworkFile() {
        return frameworkFile;
    }

    public void setFrameworkFile(String frameworkFile) {
        this.frameworkFile = frameworkFile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIllegalFile() {
        return illegalFile;
    }

    public void setIllegalFile(String illegalFile) {
        this.illegalFile = illegalFile;
    }

    public String getInstuCode() {
        return instuCode;
    }

    public void setInstuCode(String instuCode) {
        this.instuCode = instuCode;
    }

    public String getInstuFile() {
        return instuFile;
    }

    public void setInstuFile(String instuFile) {
        this.instuFile = instuFile;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getOpenAccountStatus() {
        return openAccountStatus;
    }

    public void setOpenAccountStatus(String openAccountStatus) {
        this.openAccountStatus = openAccountStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public BigDecimal getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(BigDecimal registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRiskControlFile() {
        return riskControlFile;
    }

    public void setRiskControlFile(String riskControlFile) {
        this.riskControlFile = riskControlFile;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTaxFile() {
        return taxFile;
    }

    public void setTaxFile(String taxFile) {
        this.taxFile = taxFile;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

}