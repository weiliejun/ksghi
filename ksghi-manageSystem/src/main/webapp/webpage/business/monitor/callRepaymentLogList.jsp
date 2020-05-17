<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>还款提醒管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>结算管理</li>
                <li>交易结算管理</li>
                <li class="active">还款提醒管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav nav-tabs" style="margin-bottom: 15px;">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/business/monitor/callrepaymentlog/list">还款接口日志</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/business/trade/repayment/remind/log">还款监控</a>
                        </li>

                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>
                        还款接口日志列表
                        <small></small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-inline" id="searchForm"
                          action="${pageContext.request.contextPath}/business/monitor/callrepaymentlog/list">
                        <!--<div class="panel panel-search">
					         <div class="panel-body">
					            <div class="form-group">
								    <label>产品名称</label>
								    <input name="productName" type="text" class="form-control" value="${productName}"/>
							    </div>
					            <div class="form-group">
								    <label class="input-label">借款人/公司名称</label>
							    	<input class="form-control" type="text"  name="borrowerName" value="${borrowerName}">
								</div>
								<div class="form-group" style="padding-left:0px;">
								    <label class="control-label">还款计划日期</label>
								    <div class="input-group-div" style="margin-left:80px;">
									   <div class="input-group">
										  <span class="input-group-addon"><i class="icon-calendar"></i></span>
										  <input id="dateRange"  name="dateRange" size="30" type="text" class="form-control" readonly="readonly" value="${dateRange}"/>
										</div>
								    </div>
								</div>
							    <div class="form-group">
							    	<button type="submit" class="btn btn-primary"><i class="icon-search"></i>查询</button>
							    	<button type="button" class="btn btn-primary" onclick="myClearForm('searchForm');"><i class="icon-loop2"></i>清空</button>
							    </div>
							 </div>
						</div>
						-->
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit }" items="${results }" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="REPAY_PLAN_DATE" title="还款计划日期" width="10%">
                                            <span class="repay-plan-date-span">${bean.REPAY_PLAN_DATE}</span>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="PRODUCT_NAME" title="出借产品名称" width="16%">
                                            <a class="view-details"
                                               href="${pageContext.request.contextPath}/business/product/common/view/${bean.PRODUCT_ID}"
                                               title="产品详情"> ${fnx:substringWithEllipsis(bean.PRODUCT_NAME, 0, 25) } </a>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="PERIOD" title="期数" width="5%"/>
                                        <table:htmlColumn property="UN_REPAY_AMOUNT_TOTAL" title="本期待还款总额(元)"
                                                          width="10%"/>
                                        <table:htmlColumn property="BORROWER_NAME" title="借款人" width="10%">
                                            <a class="view-details"
                                               href="${pageContext.request.contextPath}/business/borrower/common/view/${bean.BORROWER_ID}">${bean.BORROWER_NAME}</a>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="USER_INFO_NAME" title="借款人网站注册用户" width="10%">
                                            <a class="view-details"
                                               href="${pageContext.request.contextPath}/business/user/common/view/${bean.USER_INFO_ID}">${bean.USER_INFO_NAME}</a>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="ACCOUNT_BALANCE" title="借款人账户资金(元)" width="10%"/>
                                        <table:htmlColumn property="AVAILABLE_BALANCE" title="借款人账户可用资金(元)" width="10%">
                                            ${bean.AVAILABLE_BALANCE}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="FROZEN_BALANCE" title="借款人账户冻结资金(元)" width="10%"/>
                                        <table:htmlColumn title="数据操作" width="9%" sortable="false">
                                            <a class="view-details"
                                               href="${pageContext.request.contextPath}/business/trade/product/tendersinfo/${bean.PRODUCT_ID}"
                                               title="还款">产品标的情况</a>
                                        </table:htmlColumn>
                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                        </div>
                    </form>
                    <script type="text/javascript">
                        function onInvokeAction(id) {
                            $.jmesa.setExportToLimit(id, '');
                            $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
                        }
                    </script>
                </div>
                <div class="col-sm-offset-6 col-sm-12"></div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>
<script type="text/javascript">

    $().ready(function () {
        $('#dateRange').daterangepicker();
        $(".view-details").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});

        $(".repay-plan-date-span").each(function () {
            var $this = $(this);
            var str = ($this.html()).split("-");
            var planDate = new Date(str[0], str[1], str[2]);
            var today = new Date();
            var todayDate = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
            var now2day = -(todayDate - planDate) / 1000 / 60 / 60 / 24;
            if (now2day <= 1) {
                $this.parent().parent().css({color: "#FF0000", background: "#FFFF66"});
            } else if (now2day <= 3 && now2day > 1) {
                $this.parent().parent().css({color: "#ff6600", background: "#FFFF66"});
            } else if (now2day <= 5 && now2day > 3) {
                $this.parent().parent().css({color: "#FF9966", background: "#FFFF66"});
            }
        });
    });
</script>
</html>