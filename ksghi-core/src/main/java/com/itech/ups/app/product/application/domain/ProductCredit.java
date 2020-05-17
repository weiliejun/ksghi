package com.itech.ups.app.product.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductCredit implements Serializable {

    private static final long serialVersionUID = -6893786698130720742L;

    private String id;

    private String productId;

    private String isHaveOverdue;

    private Integer overdueNum;

    private Integer overdueMaxinum;

    private BigDecimal borrowBalance;

    private BigDecimal gurantyBalance;

    private String creditReportFile;

    private BigDecimal totalAsset;

    private BigDecimal netAsset;

    private BigDecimal totalLiability;

    private String balanceSheetFile;

    private String guaranteeName;

    private BigDecimal guaranteeWorth;

    private BigDecimal guaranteeRate;

    private String guaranteeRatingFile;

    private String pledgeName;

    private BigDecimal pledgeWorth;

    private BigDecimal pledgeRate;

    private String pledgeRatingFile;

    private String remark;

    private String dataStatus;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String editTime;

    private String editorId;

    private String editorName;

    private String isHaveLoan;

    private String monthlyIncome;

    private String monthlyDebt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getIsHaveOverdue() {
        return isHaveOverdue;
    }

    public void setIsHaveOverdue(String isHaveOverdue) {
        this.isHaveOverdue = isHaveOverdue;
    }

    public Integer getOverdueNum() {
        return overdueNum;
    }

    public void setOverdueNum(Integer overdueNum) {
        this.overdueNum = overdueNum;
    }

    public Integer getOverdueMaxinum() {
        return overdueMaxinum;
    }

    public void setOverdueMaxinum(Integer overdueMaxinum) {
        this.overdueMaxinum = overdueMaxinum;
    }

    public BigDecimal getBorrowBalance() {
        return borrowBalance;
    }

    public void setBorrowBalance(BigDecimal borrowBalance) {
        this.borrowBalance = borrowBalance;
    }

    public BigDecimal getGurantyBalance() {
        return gurantyBalance;
    }

    public void setGurantyBalance(BigDecimal gurantyBalance) {
        this.gurantyBalance = gurantyBalance;
    }

    public String getCreditReportFile() {
        return creditReportFile;
    }

    public void setCreditReportFile(String creditReportFile) {
        this.creditReportFile = creditReportFile;
    }

    public BigDecimal getTotalAsset() {
        return totalAsset;
    }

    public void setTotalAsset(BigDecimal totalAsset) {
        this.totalAsset = totalAsset;
    }

    public BigDecimal getNetAsset() {
        return netAsset;
    }

    public void setNetAsset(BigDecimal netAsset) {
        this.netAsset = netAsset;
    }

    public BigDecimal getTotalLiability() {
        return totalLiability;
    }

    public void setTotalLiability(BigDecimal totalLiability) {
        this.totalLiability = totalLiability;
    }

    public String getBalanceSheetFile() {
        return balanceSheetFile;
    }

    public void setBalanceSheetFile(String balanceSheetFile) {
        this.balanceSheetFile = balanceSheetFile;
    }

    public String getGuaranteeName() {
        return guaranteeName;
    }

    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName;
    }

    public BigDecimal getGuaranteeWorth() {
        return guaranteeWorth;
    }

    public void setGuaranteeWorth(BigDecimal guaranteeWorth) {
        this.guaranteeWorth = guaranteeWorth;
    }

    public BigDecimal getGuaranteeRate() {
        return guaranteeRate;
    }

    public void setGuaranteeRate(BigDecimal guaranteeRate) {
        this.guaranteeRate = guaranteeRate;
    }

    public String getGuaranteeRatingFile() {
        return guaranteeRatingFile;
    }

    public void setGuaranteeRatingFile(String guaranteeRatingFile) {
        this.guaranteeRatingFile = guaranteeRatingFile;
    }

    public String getPledgeName() {
        return pledgeName;
    }

    public void setPledgeName(String pledgeName) {
        this.pledgeName = pledgeName;
    }

    public BigDecimal getPledgeWorth() {
        return pledgeWorth;
    }

    public void setPledgeWorth(BigDecimal pledgeWorth) {
        this.pledgeWorth = pledgeWorth;
    }

    public BigDecimal getPledgeRate() {
        return pledgeRate;
    }

    public void setPledgeRate(BigDecimal pledgeRate) {
        this.pledgeRate = pledgeRate;
    }

    public String getPledgeRatingFile() {
        return pledgeRatingFile;
    }

    public void setPledgeRatingFile(String pledgeRatingFile) {
        this.pledgeRatingFile = pledgeRatingFile;
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

    public String getIsHaveLoan() {
        return isHaveLoan;
    }

    public void setIsHaveLoan(String isHaveLoan) {
        this.isHaveLoan = isHaveLoan;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getMonthlyDebt() {
        return monthlyDebt;
    }

    public void setMonthlyDebt(String monthlyDebt) {
        this.monthlyDebt = monthlyDebt;
    }
}