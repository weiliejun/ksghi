package com.itech.ups.app.product.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Liquidation implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6060859756548324253L;

    private String id;

    private String productId;

    private String repayPlanDate;// 还款计划时间 清算申请日期

    private String repayType;// 还款类型

    private BigDecimal repayTotalAmount;// 到期结算资产总额(元)

    private BigDecimal repayAllotAmount;// 产品可分配收益总额(元)=到期结账资产-账户管理费

    private BigDecimal productRepayRate;// 产品到期收益率(年化)（作废）

    private BigDecimal investorRepayRate;// 出借人到期收益率(年化)

    private BigDecimal accountManagementFee;// 账户管理费合计(元)

    private BigDecimal platformServiceFee;// 平台服务费合计(元)

    private BigDecimal investorInterestAmount;// 出借人到期收益合计

    private BigDecimal investmentOtherAmount;// 投顾收益（自投部分）

    private BigDecimal investorInterestAmountTemp;// 出借人到期收益合计(优先)

    private BigDecimal investorIncomeAmountTemp;// 出借人到期收益（超额）

    private BigDecimal investorIncomeAmount;// 投顾收益合计(元)

    private BigDecimal investorRepayAmount;// 应付出借人合计(元)--

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String editTime;

    private String editorId;

    private String editorName;

    private String remark;

    private String status;// init: 未清算 processing：清算中 cancel：取消 finish 清算完成

    private String dataStatus;

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

    public String getRepayPlanDate() {
        return repayPlanDate;
    }

    public void setRepayPlanDate(String repayPlanDate) {
        this.repayPlanDate = repayPlanDate;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public BigDecimal getRepayTotalAmount() {
        return repayTotalAmount;
    }

    public void setRepayTotalAmount(BigDecimal repayTotalAmount) {
        this.repayTotalAmount = repayTotalAmount;
    }

    public BigDecimal getRepayAllotAmount() {
        return repayTotalAmount.subtract(accountManagementFee);
    }

    public void setRepayAllotAmount(BigDecimal repayAllotAmount) {
        this.repayAllotAmount = repayAllotAmount;
    }

    public BigDecimal getProductRepayRate() {
        return productRepayRate;
    }

    public void setProductRepayRate(BigDecimal productRepayRate) {
        this.productRepayRate = productRepayRate;
    }

    public BigDecimal getInvestorRepayRate() {
        return investorRepayRate;
    }

    public void setInvestorRepayRate(BigDecimal investorRepayRate) {
        this.investorRepayRate = investorRepayRate;
    }

    public BigDecimal getAccountManagementFee() {
        return accountManagementFee;
    }

    public void setAccountManagementFee(BigDecimal accountManagementFee) {
        this.accountManagementFee = accountManagementFee;
    }

    public BigDecimal getPlatformServiceFee() {
        return platformServiceFee;
    }

    public void setPlatformServiceFee(BigDecimal platformServiceFee) {
        this.platformServiceFee = platformServiceFee;
    }

    public BigDecimal getInvestorInterestAmount() {
        return investorInterestAmount;
    }

    public void setInvestorInterestAmount(BigDecimal investorInterestAmount) {
        this.investorInterestAmount = investorInterestAmount;
    }

    public BigDecimal getInvestmentOtherAmount() {
        return investmentOtherAmount;
    }

    public void setInvestmentOtherAmount(BigDecimal investmentOtherAmount) {
        this.investmentOtherAmount = investmentOtherAmount;
    }


    public BigDecimal getInvestorIncomeAmount() {
        return investorIncomeAmount;
    }

    public void setInvestorIncomeAmount(BigDecimal investorIncomeAmount) {
        this.investorIncomeAmount = investorIncomeAmount;
    }

    public BigDecimal getInvestorRepayAmount() {
        return investorRepayAmount;
    }

    public void setInvestorRepayAmount(BigDecimal investorRepayAmount) {
        this.investorRepayAmount = investorRepayAmount;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getInvestorInterestAmountTemp() {
        return investorInterestAmountTemp;
    }

    public void setInvestorInterestAmountTemp(BigDecimal investorInterestAmountTemp) {
        this.investorInterestAmountTemp = investorInterestAmountTemp;
    }

    public BigDecimal getInvestorIncomeAmountTemp() {
        return investorIncomeAmountTemp;
    }

    public void setInvestorIncomeAmountTemp(BigDecimal investorIncomeAmountTemp) {
        this.investorIncomeAmountTemp = investorIncomeAmountTemp;
    }

}