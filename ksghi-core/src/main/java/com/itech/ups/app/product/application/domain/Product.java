package com.itech.ups.app.product.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class Product implements Serializable {

    private static final long serialVersionUID = -8907618150277364610L;

    private String id;

    private String name;

    private String category;

    private String type;

    private String code;

    private Long amount;

    private Integer timeLimit;

    private String timeLimitUnit;

    private BigDecimal annualRate;

    private String repayType;

    private String projectFundsPurpose;

    private String projectRepaySource;

    private String projectSummary;

    private String isCreditMeasures;

    private String creditMeasuresType;

    private String guaranteeType;

    private String tenderStartTime;

    private String tenderEndTime;

    private BigDecimal tenderInitAmount;

    private BigDecimal tenderIncreaseAmount;

    private Short repayInterestDay;

    private String isInvestTransferable;

    private Integer investTransferDayLimit;

    private BigDecimal investTransferFeeRate;

    private BigDecimal prepayFeeRate;

    private BigDecimal serviceFeeRate;

    private String repayModelStartDate;

    private String repayModelEndDate;

    private String borrowerType;

    private String borrowerId;

    private String borrowerUserInfoId;

    private String borrowerName;

    private String borrowContractNo;

    private String guarantyCorpType;

    private String guarantyCorpId;

    private String coprBorrowerUserInfoId;

    private String coprBorrowerId;

    private String coprBorrowerName;

    private String guarantyCorpUserInfoId;

    private String guarantyCorpName;

    private Short guarantyCorpLevel;

    private BigDecimal guarantyCorpFeeRate;

    private String loanCorpId;

    private String loanCorpUserInfoId;

    private String loanCorpName;

    private Short loanCorpLevel;

    private BigDecimal loanCorpFeeRate;

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

    private BigDecimal tenderAmount;

    private Long tenderUsers;

    private String tenderAuditorId;

    private String tenderAuditorName;

    private String tenderAuditTime;

    private String repayStartDate;

    private String repayEndDate;

    private String publishStatus;

    private String publishTime;

    private String publisherId;

    private String publisherName;

    private String status;

    private String tenderAuditStatus;

    private BigDecimal floatAnnualRate;

    private String pactAudit;

    private Integer investTransferDayLimitEnd;

    private String productAgreementType;

    private String creditAgreementType;

    private String noviceProduct;

    private String productAdvantage;

    private String controlMeasures;

    private String productCategory;

    private String subCategory;

    private BigDecimal targetRateLow;

    private BigDecimal targetRateHigh;

    private BigDecimal stopLine;

    private BigDecimal priorityRate;

    private BigDecimal overtopInvestorRate;

    private BigDecimal overtopInvestConsultantRate;

    private BigDecimal overtopPlatformRate;

    private Long highSingleInvest;

    private String ifLimitSingle;

    private Long highInvestCount;

    private String ifLimitCount;

    private BigDecimal accountManageRate;

    private String tradingAccountNo;

    private String guarantyCorpShortName;

    private String investLeaderPhoto;

    private String investLeaderName;

    private String investLeaderPosition;

    private String investLeaderIntruduction;

    private String investLeaderRecommendation;

    private String preInvestAmount;

    private String financialRegulation;

    private String partnerInf;

    private BigDecimal consultantInvestAmount;

    private String consultantInvestCode;

    private String consultantBorrowerId;

    // 出借者风险类型（1、保守型 2、谨慎性 3、稳健性 4、积极型 5、激进型）
    private String userType;
    // 风险等级（1、低风险 2、中低风险 3、中风险 4、终稿风险 5、高风险）
    private String riskRank;
    // 增信措施
    private String trustMeasures;

    private BigDecimal borrowRate;

    private String financialAdvisersType;

    // 3.17 菁英计划新增逾期利率
    private BigDecimal overDueRate;
    // 安心签合同编号
    private String trustContractNo;

    //17.06.07  贵州银行接口 新增字段
    private String proId;

    private String bidType;

    private String fundsPurposeType;

    private String directrfauthStatus;

    private String messageCategory;

    private String messagePublishTime;
    private Map<String, Object> BusExpansion;// 业务扩展域

    public BigDecimal getBorrowRate() {
        return borrowRate;
    }

    public void setBorrowRate(BigDecimal borrowRate) {
        this.borrowRate = borrowRate;
    }

    public String getFinancialAdvisersType() {
        return financialAdvisersType;
    }

    public void setFinancialAdvisersType(String financialAdvisersType) {
        this.financialAdvisersType = financialAdvisersType;
    }

    public String getConsultantBorrowerId() {
        return consultantBorrowerId;
    }

    public void setConsultantBorrowerId(String consultantBorrowerId) {
        this.consultantBorrowerId = consultantBorrowerId;
    }

    public BigDecimal getConsultantInvestAmount() {
        return consultantInvestAmount;
    }

    public void setConsultantInvestAmount(BigDecimal consultantInvestAmount) {
        this.consultantInvestAmount = consultantInvestAmount;
    }

    public String getConsultantInvestCode() {
        return consultantInvestCode;
    }

    public void setConsultantInvestCode(String consultantInvestCode) {
        this.consultantInvestCode = consultantInvestCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getTimeLimitUnit() {
        return timeLimitUnit;
    }

    public void setTimeLimitUnit(String timeLimitUnit) {
        this.timeLimitUnit = timeLimitUnit;
    }

    public BigDecimal getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(BigDecimal annualRate) {
        this.annualRate = annualRate;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getProjectFundsPurpose() {
        return projectFundsPurpose;
    }

    public void setProjectFundsPurpose(String projectFundsPurpose) {
        this.projectFundsPurpose = projectFundsPurpose;
    }

    public String getProjectRepaySource() {
        return projectRepaySource;
    }

    public void setProjectRepaySource(String projectRepaySource) {
        this.projectRepaySource = projectRepaySource;
    }

    public String getProjectSummary() {
        return projectSummary;
    }

    public void setProjectSummary(String projectSummary) {
        this.projectSummary = projectSummary;
    }

    public String getIsCreditMeasures() {
        return isCreditMeasures;
    }

    public void setIsCreditMeasures(String isCreditMeasures) {
        this.isCreditMeasures = isCreditMeasures;
    }

    public String getCreditMeasuresType() {
        return creditMeasuresType;
    }

    public void setCreditMeasuresType(String creditMeasuresType) {
        this.creditMeasuresType = creditMeasuresType;
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public String getTenderStartTime() {
        return tenderStartTime;
    }

    public void setTenderStartTime(String tenderStartTime) {
        this.tenderStartTime = tenderStartTime;
    }

    public String getTenderEndTime() {
        return tenderEndTime;
    }

    public void setTenderEndTime(String tenderEndTime) {
        this.tenderEndTime = tenderEndTime;
    }

    public BigDecimal getTenderInitAmount() {
        return tenderInitAmount;
    }

    public void setTenderInitAmount(BigDecimal tenderInitAmount) {
        this.tenderInitAmount = tenderInitAmount;
    }

    public BigDecimal getTenderIncreaseAmount() {
        return tenderIncreaseAmount;
    }

    public void setTenderIncreaseAmount(BigDecimal tenderIncreaseAmount) {
        this.tenderIncreaseAmount = tenderIncreaseAmount;
    }

    public Short getRepayInterestDay() {
        return repayInterestDay;
    }

    public void setRepayInterestDay(Short repayInterestDay) {
        this.repayInterestDay = repayInterestDay;
    }

    public String getIsInvestTransferable() {
        return isInvestTransferable;
    }

    public void setIsInvestTransferable(String isInvestTransferable) {
        this.isInvestTransferable = isInvestTransferable;
    }

    public Integer getInvestTransferDayLimit() {
        return investTransferDayLimit;
    }

    public void setInvestTransferDayLimit(Integer investTransferDayLimit) {
        this.investTransferDayLimit = investTransferDayLimit;
    }

    public BigDecimal getInvestTransferFeeRate() {
        return investTransferFeeRate;
    }

    public void setInvestTransferFeeRate(BigDecimal investTransferFeeRate) {
        this.investTransferFeeRate = investTransferFeeRate;
    }

    public BigDecimal getPrepayFeeRate() {
        return prepayFeeRate;
    }

    public void setPrepayFeeRate(BigDecimal prepayFeeRate) {
        this.prepayFeeRate = prepayFeeRate;
    }

    public BigDecimal getServiceFeeRate() {
        return serviceFeeRate;
    }

    public void setServiceFeeRate(BigDecimal serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate;
    }

    public String getRepayModelStartDate() {
        return repayModelStartDate;
    }

    public void setRepayModelStartDate(String repayModelStartDate) {
        this.repayModelStartDate = repayModelStartDate;
    }

    public String getRepayModelEndDate() {
        return repayModelEndDate;
    }

    public void setRepayModelEndDate(String repayModelEndDate) {
        this.repayModelEndDate = repayModelEndDate;
    }

    public String getBorrowerType() {
        return borrowerType;
    }

    public void setBorrowerType(String borrowerType) {
        this.borrowerType = borrowerType;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerUserInfoId() {
        return borrowerUserInfoId;
    }

    public void setBorrowerUserInfoId(String borrowerUserInfoId) {
        this.borrowerUserInfoId = borrowerUserInfoId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowContractNo() {
        return borrowContractNo;
    }

    public void setBorrowContractNo(String borrowContractNo) {
        this.borrowContractNo = borrowContractNo;
    }

    public String getGuarantyCorpType() {
        return guarantyCorpType;
    }

    public void setGuarantyCorpType(String guarantyCorpType) {
        this.guarantyCorpType = guarantyCorpType;
    }

    public String getGuarantyCorpId() {
        return guarantyCorpId;
    }

    public void setGuarantyCorpId(String guarantyCorpId) {
        this.guarantyCorpId = guarantyCorpId;
    }

    public String getCoprBorrowerUserInfoId() {
        return coprBorrowerUserInfoId;
    }

    public void setCoprBorrowerUserInfoId(String coprBorrowerUserInfoId) {
        this.coprBorrowerUserInfoId = coprBorrowerUserInfoId;
    }

    public String getCoprBorrowerId() {
        return coprBorrowerId;
    }

    public void setCoprBorrowerId(String coprBorrowerId) {
        this.coprBorrowerId = coprBorrowerId;
    }

    public String getCoprBorrowerName() {
        return coprBorrowerName;
    }

    public void setCoprBorrowerName(String coprBorrowerName) {
        this.coprBorrowerName = coprBorrowerName;
    }

    public String getGuarantyCorpUserInfoId() {
        return guarantyCorpUserInfoId;
    }

    public void setGuarantyCorpUserInfoId(String guarantyCorpUserInfoId) {
        this.guarantyCorpUserInfoId = guarantyCorpUserInfoId;
    }

    public String getGuarantyCorpName() {
        return guarantyCorpName;
    }

    public void setGuarantyCorpName(String guarantyCorpName) {
        this.guarantyCorpName = guarantyCorpName;
    }

    public Short getGuarantyCorpLevel() {
        return guarantyCorpLevel;
    }

    public void setGuarantyCorpLevel(Short guarantyCorpLevel) {
        this.guarantyCorpLevel = guarantyCorpLevel;
    }

    public BigDecimal getGuarantyCorpFeeRate() {
        return guarantyCorpFeeRate;
    }

    public void setGuarantyCorpFeeRate(BigDecimal guarantyCorpFeeRate) {
        this.guarantyCorpFeeRate = guarantyCorpFeeRate;
    }

    public String getLoanCorpId() {
        return loanCorpId;
    }

    public void setLoanCorpId(String loanCorpId) {
        this.loanCorpId = loanCorpId;
    }

    public String getLoanCorpUserInfoId() {
        return loanCorpUserInfoId;
    }

    public void setLoanCorpUserInfoId(String loanCorpUserInfoId) {
        this.loanCorpUserInfoId = loanCorpUserInfoId;
    }

    public String getLoanCorpName() {
        return loanCorpName;
    }

    public void setLoanCorpName(String loanCorpName) {
        this.loanCorpName = loanCorpName;
    }

    public Short getLoanCorpLevel() {
        return loanCorpLevel;
    }

    public void setLoanCorpLevel(Short loanCorpLevel) {
        this.loanCorpLevel = loanCorpLevel;
    }

    public BigDecimal getLoanCorpFeeRate() {
        return loanCorpFeeRate;
    }

    public void setLoanCorpFeeRate(BigDecimal loanCorpFeeRate) {
        this.loanCorpFeeRate = loanCorpFeeRate;
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

    public BigDecimal getTenderAmount() {
        return tenderAmount;
    }

    public void setTenderAmount(BigDecimal tenderAmount) {
        this.tenderAmount = tenderAmount;
    }

    public Long getTenderUsers() {
        return tenderUsers;
    }

    public void setTenderUsers(Long tenderUsers) {
        this.tenderUsers = tenderUsers;
    }

    public String getTenderAuditorId() {
        return tenderAuditorId;
    }

    public void setTenderAuditorId(String tenderAuditorId) {
        this.tenderAuditorId = tenderAuditorId;
    }

    public String getTenderAuditorName() {
        return tenderAuditorName;
    }

    public void setTenderAuditorName(String tenderAuditorName) {
        this.tenderAuditorName = tenderAuditorName;
    }

    public String getTenderAuditTime() {
        return tenderAuditTime;
    }

    public void setTenderAuditTime(String tenderAuditTime) {
        this.tenderAuditTime = tenderAuditTime;
    }

    public String getRepayStartDate() {
        return repayStartDate;
    }

    public void setRepayStartDate(String repayStartDate) {
        this.repayStartDate = repayStartDate;
    }

    public String getRepayEndDate() {
        return repayEndDate;
    }

    public void setRepayEndDate(String repayEndDate) {
        this.repayEndDate = repayEndDate;
    }

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTenderAuditStatus() {
        return tenderAuditStatus;
    }

    public void setTenderAuditStatus(String tenderAuditStatus) {
        this.tenderAuditStatus = tenderAuditStatus;
    }

    public BigDecimal getFloatAnnualRate() {
        return floatAnnualRate;
    }

    public void setFloatAnnualRate(BigDecimal floatAnnualRate) {
        this.floatAnnualRate = floatAnnualRate;
    }

    public String getPactAudit() {
        return pactAudit;
    }

    public void setPactAudit(String pactAudit) {
        this.pactAudit = pactAudit;
    }

    public Integer getInvestTransferDayLimitEnd() {
        return investTransferDayLimitEnd;
    }

    public void setInvestTransferDayLimitEnd(Integer investTransferDayLimitEnd) {
        this.investTransferDayLimitEnd = investTransferDayLimitEnd;
    }

    public String getProductAgreementType() {
        return productAgreementType;
    }

    public void setProductAgreementType(String productAgreementType) {
        this.productAgreementType = productAgreementType;
    }

    public String getCreditAgreementType() {
        return creditAgreementType;
    }

    public void setCreditAgreementType(String creditAgreementType) {
        this.creditAgreementType = creditAgreementType;
    }

    public String getNoviceProduct() {
        return noviceProduct;
    }

    public void setNoviceProduct(String noviceProduct) {
        this.noviceProduct = noviceProduct;
    }

    public String getProductAdvantage() {
        return productAdvantage;
    }

    public void setProductAdvantage(String productAdvantage) {
        this.productAdvantage = productAdvantage;
    }

    public String getControlMeasures() {
        return controlMeasures;
    }

    public void setControlMeasures(String controlMeasures) {
        this.controlMeasures = controlMeasures;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public BigDecimal getTargetRateLow() {
        return targetRateLow;
    }

    public void setTargetRateLow(BigDecimal targetRateLow) {
        this.targetRateLow = targetRateLow;
    }

    public BigDecimal getTargetRateHigh() {
        return targetRateHigh;
    }

    public void setTargetRateHigh(BigDecimal targetRateHigh) {
        this.targetRateHigh = targetRateHigh;
    }

    public BigDecimal getStopLine() {
        return stopLine;
    }

    public void setStopLine(BigDecimal stopLine) {
        this.stopLine = stopLine;
    }

    public BigDecimal getPriorityRate() {
        return priorityRate;
    }

    public void setPriorityRate(BigDecimal priorityRate) {
        this.priorityRate = priorityRate;
    }

    public BigDecimal getOvertopInvestorRate() {
        return overtopInvestorRate;
    }

    public void setOvertopInvestorRate(BigDecimal overtopInvestorRate) {
        this.overtopInvestorRate = overtopInvestorRate;
    }

    public BigDecimal getOvertopInvestConsultantRate() {
        return overtopInvestConsultantRate;
    }

    public void setOvertopInvestConsultantRate(BigDecimal overtopInvestConsultantRate) {
        this.overtopInvestConsultantRate = overtopInvestConsultantRate;
    }

    public BigDecimal getOvertopPlatformRate() {
        return overtopPlatformRate;
    }

    public void setOvertopPlatformRate(BigDecimal overtopPlatformRate) {
        this.overtopPlatformRate = overtopPlatformRate;
    }

    public Long getHighSingleInvest() {
        return highSingleInvest;
    }

    public void setHighSingleInvest(Long highSingleInvest) {
        this.highSingleInvest = highSingleInvest;
    }

    public String getIfLimitSingle() {
        return ifLimitSingle;
    }

    public void setIfLimitSingle(String ifLimitSingle) {
        this.ifLimitSingle = ifLimitSingle;
    }

    public Long getHighInvestCount() {
        return highInvestCount;
    }

    public void setHighInvestCount(Long highInvestCount) {
        this.highInvestCount = highInvestCount;
    }

    public String getIfLimitCount() {
        return ifLimitCount;
    }

    public void setIfLimitCount(String ifLimitCount) {
        this.ifLimitCount = ifLimitCount;
    }

    public BigDecimal getAccountManageRate() {
        return accountManageRate;
    }

    public void setAccountManageRate(BigDecimal accountManageRate) {
        this.accountManageRate = accountManageRate;
    }

    public String getTradingAccountNo() {
        return tradingAccountNo;
    }

    public void setTradingAccountNo(String tradingAccountNo) {
        this.tradingAccountNo = tradingAccountNo;
    }

    public String getGuarantyCorpShortName() {
        return guarantyCorpShortName;
    }

    public void setGuarantyCorpShortName(String guarantyCorpShortName) {
        this.guarantyCorpShortName = guarantyCorpShortName;
    }

    public String getInvestLeaderPhoto() {
        return investLeaderPhoto;
    }

    public void setInvestLeaderPhoto(String investLeaderPhoto) {
        this.investLeaderPhoto = investLeaderPhoto;
    }

    public String getInvestLeaderName() {
        return investLeaderName;
    }

    public void setInvestLeaderName(String investLeaderName) {
        this.investLeaderName = investLeaderName;
    }

    public String getInvestLeaderPosition() {
        return investLeaderPosition;
    }

    public void setInvestLeaderPosition(String investLeaderPosition) {
        this.investLeaderPosition = investLeaderPosition;
    }

    public String getInvestLeaderIntruduction() {
        return investLeaderIntruduction;
    }

    public void setInvestLeaderIntruduction(String investLeaderIntruduction) {
        this.investLeaderIntruduction = investLeaderIntruduction;
    }

    public String getInvestLeaderRecommendation() {
        return investLeaderRecommendation;
    }

    public void setInvestLeaderRecommendation(String investLeaderRecommendation) {
        this.investLeaderRecommendation = investLeaderRecommendation;
    }

    public String getPreInvestAmount() {
        return preInvestAmount;
    }

    public void setPreInvestAmount(String preInvestAmount) {
        this.preInvestAmount = preInvestAmount;
    }

    public String getFinancialRegulation() {
        return financialRegulation;
    }

    public void setFinancialRegulation(String financialRegulation) {
        this.financialRegulation = financialRegulation;
    }

    public Map<String, Object> getBusExpansion() {
        return BusExpansion;
    }

    public void setBusExpansion(Map<String, Object> busExpansion) {
        BusExpansion = busExpansion;
    }

    public String getPartnerInf() {
        return partnerInf;
    }

    public void setPartnerInf(String partnerInf) {
        this.partnerInf = partnerInf;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getRiskRank() {
        return riskRank;
    }

    public void setRiskRank(String riskRank) {
        this.riskRank = riskRank;
    }

    public String getTrustMeasures() {
        return trustMeasures;
    }

    public void setTrustMeasures(String trustMeasures) {
        this.trustMeasures = trustMeasures;
    }

    public BigDecimal getOverDueRate() {
        return overDueRate;
    }

    public void setOverDueRate(BigDecimal overDueRate) {
        this.overDueRate = overDueRate;
    }

    public String getTrustContractNo() {
        return trustContractNo;
    }

    public void setTrustContractNo(String trustContractNo) {
        this.trustContractNo = trustContractNo;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getBidType() {
        return bidType;
    }

    public void setBidType(String bidType) {
        this.bidType = bidType;
    }

    public String getFundsPurposeType() {
        return fundsPurposeType;
    }

    public void setFundsPurposeType(String fundsPurposeType) {
        this.fundsPurposeType = fundsPurposeType;
    }

    public String getDirectrfauthStatus() {
        return directrfauthStatus;
    }

    public void setDirectrfauthStatus(String directrfauthStatus) {
        this.directrfauthStatus = directrfauthStatus;
    }

    public String getMessageCategory() {
        return messageCategory;
    }

    public void setMessageCategory(String messageCategory) {
        this.messageCategory = messageCategory;
    }

    public String getMessagePublishTime() {
        return messagePublishTime;
    }

    public void setMessagePublishTime(String messagePublishTime) {
        this.messagePublishTime = messagePublishTime;
    }

}