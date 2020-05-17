package com.itech.ups.app.borrower.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Borrower implements Serializable {

    private static final long serialVersionUID = -7140390645485155992L;

    private String id;

    private String userInfoId;

    private String type;

    private String mobile;

    private String inviteCode;

    private String name;

    private String nature;

    private BigDecimal registeredCapital;

    private String province;

    private String city;

    private String corpAddress;

    private String postCode;

    private String phone;

    private String fax;

    private String corpOwnerName;

    private String corpOwnerPhone;

    private String corpOwnerIdNo;

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

    private String idFile;

    private String incomeVerificationFile;

    private String sex;

    private String position;

    private String idNo;

    private String email;

    private String homeAddress;

    private String workUnit;

    private BigDecimal personalIncome;

    private BigDecimal homeIncome;

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

    private String corpRemark;

    private String corpPhone;

    private String corpName;

    private String openAccountStatus;
    // 星座
    private String constellation;
    // 属相
    private String zodiac;
    // 血型
    private String bloodType;

    // 信用等级
    private String creditGrade;
    // 信用额度
    private BigDecimal creditLimit;
    // 増信额度
    private BigDecimal additionAmount;
    // 可用额度
    private BigDecimal availableAmount;
    // 时效性
    private String auditEffectiveness;

    private String approvalStatus;

    private String versionFileid;
    // 来源
    private String terminal;
    // 审批成功时间
    private String approvalTime;

    // 新增加的字段,菁英计划(2.10--2.28)
    private String university;

    private String department;

    private String major;

    private String course;

    private String graduationTime;

    private String qualificationsNum;

    private String hightDegree;

    private String presentProvince;

    private String presentCity;

    private String presentAddress;

    private String localResident;

    private String maritalStatus;

    private String mateName;

    private String mateIdNo;

    private String mateMobile;

    private String personCorpPhone;

    private String personCorpProvince;

    private String personCorpCity;

    private String personcorpAddress;

    private String personWorkLimit;

    private String personMonthIncome;

    private String socialCreditCode;

    private String contributedCapital;

    private String registerDate;

    private String busiScope;

    private String coopOrgId;
    // 2017.09.25 新增 所属行业
    private String workingField;

    private String age;

    private String idStartDate;

    private String idEndDate;

    private String activateStatus;

    private String loanCardFile;

    private String idStatus;

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
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

    public BigDecimal getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(BigDecimal registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCorpAddress() {
        return corpAddress;
    }

    public void setCorpAddress(String corpAddress) {
        this.corpAddress = corpAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public String getBusiAddress() {
        return busiAddress;
    }

    public void setBusiAddress(String busiAddress) {
        this.busiAddress = busiAddress;
    }

    public String getInstuCode() {
        return instuCode;
    }

    public void setInstuCode(String instuCode) {
        this.instuCode = instuCode;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getBusiPermitsCode() {
        return busiPermitsCode;
    }

    public void setBusiPermitsCode(String busiPermitsCode) {
        this.busiPermitsCode = busiPermitsCode;
    }

    public String getAccountsPermitsFile() {
        return accountsPermitsFile;
    }

    public void setAccountsPermitsFile(String accountsPermitsFile) {
        this.accountsPermitsFile = accountsPermitsFile;
    }

    public String getRiskControlFile() {
        return riskControlFile;
    }

    public void setRiskControlFile(String riskControlFile) {
        this.riskControlFile = riskControlFile;
    }

    public String getBalanceSheetFile() {
        return balanceSheetFile;
    }

    public void setBalanceSheetFile(String balanceSheetFile) {
        this.balanceSheetFile = balanceSheetFile;
    }

    public String getIllegalFile() {
        return illegalFile;
    }

    public void setIllegalFile(String illegalFile) {
        this.illegalFile = illegalFile;
    }

    public String getBusiFile() {
        return busiFile;
    }

    public void setBusiFile(String busiFile) {
        this.busiFile = busiFile;
    }

    public String getInstuFile() {
        return instuFile;
    }

    public void setInstuFile(String instuFile) {
        this.instuFile = instuFile;
    }

    public String getTaxFile() {
        return taxFile;
    }

    public void setTaxFile(String taxFile) {
        this.taxFile = taxFile;
    }

    public String getBusiPermitsFile() {
        return busiPermitsFile;
    }

    public void setBusiPermitsFile(String busiPermitsFile) {
        this.busiPermitsFile = busiPermitsFile;
    }

    public String getFrameworkFile() {
        return frameworkFile;
    }

    public void setFrameworkFile(String frameworkFile) {
        this.frameworkFile = frameworkFile;
    }

    public String getCreditFile() {
        return creditFile;
    }

    public void setCreditFile(String creditFile) {
        this.creditFile = creditFile;
    }

    public String getCorpRuleFile() {
        return corpRuleFile;
    }

    public void setCorpRuleFile(String corpRuleFile) {
        this.corpRuleFile = corpRuleFile;
    }

    public String getCooperationAgreementFile() {
        return cooperationAgreementFile;
    }

    public void setCooperationAgreementFile(String cooperationAgreementFile) {
        this.cooperationAgreementFile = cooperationAgreementFile;
    }

    public String getIdFile() {
        return idFile;
    }

    public void setIdFile(String idFile) {
        this.idFile = idFile;
    }

    public String getIncomeVerificationFile() {
        return incomeVerificationFile;
    }

    public void setIncomeVerificationFile(String incomeVerificationFile) {
        this.incomeVerificationFile = incomeVerificationFile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public BigDecimal getPersonalIncome() {
        return personalIncome;
    }

    public void setPersonalIncome(BigDecimal personalIncome) {
        this.personalIncome = personalIncome;
    }

    public BigDecimal getHomeIncome() {
        return homeIncome;
    }

    public void setHomeIncome(BigDecimal homeIncome) {
        this.homeIncome = homeIncome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getCorpRemark() {
        return corpRemark;
    }

    public void setCorpRemark(String corpRemark) {
        this.corpRemark = corpRemark;
    }

    public String getCorpPhone() {
        return corpPhone;
    }

    public void setCorpPhone(String corpPhone) {
        this.corpPhone = corpPhone;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getOpenAccountStatus() {
        return openAccountStatus;
    }

    public void setOpenAccountStatus(String openAccountStatus) {
        this.openAccountStatus = openAccountStatus;
    }

    public String getCorpOwnerIdNo() {
        return corpOwnerIdNo;
    }

    public void setCorpOwnerIdNo(String corpOwnerIdNo) {
        this.corpOwnerIdNo = corpOwnerIdNo;
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

    public BigDecimal getAdditionAmount() {
        return additionAmount;
    }

    public void setAdditionAmount(BigDecimal additionAmount) {
        this.additionAmount = additionAmount;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public String getAuditEffectiveness() {
        return auditEffectiveness;
    }

    public void setAuditEffectiveness(String auditEffectiveness) {
        this.auditEffectiveness = auditEffectiveness;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getVersionFileid() {
        return versionFileid;
    }

    public void setVersionFileid(String versionFileid) {
        this.versionFileid = versionFileid;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getQualificationsNum() {
        return qualificationsNum;
    }

    public void setQualificationsNum(String qualificationsNum) {
        this.qualificationsNum = qualificationsNum;
    }

    public String getHightDegree() {
        return hightDegree;
    }

    public void setHightDegree(String hightDegree) {
        this.hightDegree = hightDegree;
    }

    public String getPresentProvince() {
        return presentProvince;
    }

    public void setPresentProvince(String presentProvince) {
        this.presentProvince = presentProvince;
    }

    public String getPresentCity() {
        return presentCity;
    }

    public void setPresentCity(String presentCity) {
        this.presentCity = presentCity;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getLocalResident() {
        return localResident;
    }

    public void setLocalResident(String localResident) {
        this.localResident = localResident;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    public String getMateIdNo() {
        return mateIdNo;
    }

    public void setMateIdNo(String mateIdNo) {
        this.mateIdNo = mateIdNo;
    }

    public String getMateMobile() {
        return mateMobile;
    }

    public void setMateMobile(String mateMobile) {
        this.mateMobile = mateMobile;
    }

    public String getPersonCorpPhone() {
        return personCorpPhone;
    }

    public void setPersonCorpPhone(String personCorpPhone) {
        this.personCorpPhone = personCorpPhone;
    }

    public String getPersonCorpProvince() {
        return personCorpProvince;
    }

    public void setPersonCorpProvince(String personCorpProvince) {
        this.personCorpProvince = personCorpProvince;
    }

    public String getPersonCorpCity() {
        return personCorpCity;
    }

    public void setPersonCorpCity(String personCorpCity) {
        this.personCorpCity = personCorpCity;
    }

    public String getPersoncorpAddress() {
        return personcorpAddress;
    }

    public void setPersoncorpAddress(String personcorpAddress) {
        this.personcorpAddress = personcorpAddress;
    }

    public String getPersonWorkLimit() {
        return personWorkLimit;
    }

    public void setPersonWorkLimit(String personWorkLimit) {
        this.personWorkLimit = personWorkLimit;
    }

    public String getPersonMonthIncome() {
        return personMonthIncome;
    }

    public void setPersonMonthIncome(String personMonthIncome) {
        this.personMonthIncome = personMonthIncome;
    }

    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    public String getContributedCapital() {
        return contributedCapital;
    }

    public void setContributedCapital(String contributedCapital) {
        this.contributedCapital = contributedCapital;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getBusiScope() {
        return busiScope;
    }

    public void setBusiScope(String busiScope) {
        this.busiScope = busiScope;
    }

    public String getCoopOrgId() {
        return coopOrgId;
    }

    public void setCoopOrgId(String coopOrgId) {
        this.coopOrgId = coopOrgId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdStartDate() {
        return idStartDate;
    }

    public void setIdStartDate(String idStartDate) {
        this.idStartDate = idStartDate;
    }

    public String getIdEndDate() {
        return idEndDate;
    }

    public void setIdEndDate(String idEndDate) {
        this.idEndDate = idEndDate;
    }

    public String getActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(String activateStatus) {
        this.activateStatus = activateStatus;
    }

    public String getLoanCardFile() {
        return loanCardFile;
    }

    public void setLoanCardFile(String loanCardFile) {
        this.loanCardFile = loanCardFile;
    }

    public String getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(String idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public String toString() {
        return "Borrower [id=" + id + ", userInfoId=" + userInfoId + ", type="
                + type + ", mobile=" + mobile + ", inviteCode=" + inviteCode
                + ", name=" + name + ", nature=" + nature
                + ", registeredCapital=" + registeredCapital + ", province="
                + province + ", city=" + city + ", corpAddress=" + corpAddress
                + ", postCode=" + postCode + ", phone=" + phone + ", fax="
                + fax + ", corpOwnerName=" + corpOwnerName
                + ", corpOwnerPhone=" + corpOwnerPhone + ", corpOwnerIdNo="
                + corpOwnerIdNo + ", summary=" + summary + ", busiCode="
                + busiCode + ", busiAddress=" + busiAddress + ", instuCode="
                + instuCode + ", taxCode=" + taxCode + ", busiPermitsCode="
                + busiPermitsCode + ", accountsPermitsFile="
                + accountsPermitsFile + ", riskControlFile=" + riskControlFile
                + ", balanceSheetFile=" + balanceSheetFile + ", illegalFile="
                + illegalFile + ", busiFile=" + busiFile + ", instuFile="
                + instuFile + ", taxFile=" + taxFile + ", busiPermitsFile="
                + busiPermitsFile + ", frameworkFile=" + frameworkFile
                + ", creditFile=" + creditFile + ", corpRuleFile="
                + corpRuleFile + ", cooperationAgreementFile="
                + cooperationAgreementFile + ", idFile=" + idFile
                + ", incomeVerificationFile=" + incomeVerificationFile
                + ", sex=" + sex + ", position=" + position + ", idNo=" + idNo
                + ", email=" + email + ", homeAddress=" + homeAddress
                + ", workUnit=" + workUnit + ", personalIncome="
                + personalIncome + ", homeIncome=" + homeIncome + ", status="
                + status + ", auditStatus=" + auditStatus + ", auditDesc="
                + auditDesc + ", auditTime=" + auditTime + ", auditorId="
                + auditorId + ", auditorName=" + auditorName + ", remark="
                + remark + ", dataStatus=" + dataStatus + ", createTime="
                + createTime + ", creatorId=" + creatorId + ", creatorName="
                + creatorName + ", editTime=" + editTime + ", editorId="
                + editorId + ", editorName=" + editorName + ", corpRemark="
                + corpRemark + ", corpPhone=" + corpPhone + ", corpName="
                + corpName + ", openAccountStatus=" + openAccountStatus
                + ", constellation=" + constellation + ", zodiac=" + zodiac
                + ", bloodType=" + bloodType + "]";
    }

    public String getWorkingField() {
        return workingField;
    }

    public void setWorkingField(String workingField) {
        this.workingField = workingField;
    }

}