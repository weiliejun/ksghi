<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>保险产品购买明细</title>
    <%@ include file="/webpage/common/plugins/easyui.jsp" %>
</head>

<body>
<div id="breadcrumb-wrapper">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i>产品管理</li>
            <li>保险产品信息管理</li>
            <li class="active">保险产品购买明细</li>
        </ul>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 page-header">
            <h4>
                保险产品购买明细
                <small></small>
            </h4>
        </div>
        <form id="searchForm">
            <input type="hidden" id="productId" name="productId" value="${productId}">
        </form>
        <div class="col-sm-offset-6 col-sm-12"></div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="clearfix">
                <table id='list'></table>
            </div>
        </div>
    </div>
    <div class="panel-footer">
        <div class="form-group">
            <div class="col-md-offset-3 col-md-9">
                <button onclick="javascript:history.go(-1);" type="button" class="btn btn-primary">
                    <i class="icon-undo2"></i>返回
                </button>
            </div>
        </div>
    </div>
</div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#list').datagrid({
            url: '${pageContext.request.contextPath}/business/insurance/sale/detail/query?productId=' + $('#productId').val(),
            frozenColumns: [[
                {field: 'CONTRACT_CODE', title: '合同编号', width: 100, align: 'center'},
                {field: 'INSURANCE_NAME', title: '保险产品名称', width: 150, align: 'center', halign: 'center'},
                {field: 'COMPANYNAME', title: '保险公司', width: 200, align: 'center', halign: 'center'},
                {field: 'CATEGORY', title: '保险类型', width: 100, align: 'center', halign: 'center'},
                {field: 'NIKE_NAME', title: '用户昵称', width: 100, align: 'center', halign: 'center'},
                {field: 'CUSTOMER_NAME', title: '客户姓名', width: 100, align: 'center', halign: 'center'},
                {field: 'CUSTOMER_PHONE', title: '投保人手机号', width: 100, align: 'center', halign: 'center'},
                {field: 'PAY_WAY', title: '交费方式', width: 80, align: 'center', halign: 'center'},
                {field: 'PAID_PREMIUM', title: '已交保费', width: 80, align: 'center', halign: 'center'},
                {field: 'INSURANCE_DATE', title: '投保日期', width: 80, align: 'center', halign: 'center'},
                {field: 'RECENT_PAYMENT_DATE', title: '最近交费日期', width: 80, align: 'center', halign: 'center'},
                {field: 'RECENTLY_PAY_DATE', title: '合同生效日期', width: 80, align: 'center', halign: 'center'},
                {field: 'CONTRACT_EFFECTIVE_DATE', title: '合同失效日期', width: 80, align: 'center', halign: 'center'},
                {field: 'INSURANCE_STATUS', title: '保单状态', width: 80, align: 'center', halign: 'center'},
                {field: 'INSURANCE_REMARK', title: '保单状态说明', width: 170, align: 'left', halign: 'center'}
            ]],
            pagination: true,
            nowrap: true,
            pageSize: 10,
            pageList: [10, 20, 30],
            onLoadSuccess: function (data) {
                $("#totalCount").html(data.total);
            }
        });
    });
</script>
</html>
