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
                <small>
            </h4>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="stats_search_group">
                <form id="searchForm">
                    <table>
                        <tr>
                            <td>
                                <div class="stats_td_div">
                                    <label for="companyName">保险公司</label>
                                    <itech:code type="select" code="insurance.companyName" property="companyName"/>
                                </div>
                            </td>
                            <td>
                                <div class="stats_td_div">
                                    <label for="name">保险产品名称</label> <input type="text" id="insuranceName"
                                                                            name="insuranceName"/>
                                </div>
                            </td>
                            <td>
                                <div class="stats_td_div ">
                                    <label for="fundStatus">上架状态</label>
                                    <itech:code type="select" code="fund.shelfState" property="upperAndLowerFrame"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="stats_td_div">
                                    <label for="companyName">客户姓名</label> <input type="text" id="customerName"
                                                                                 name="customerName"/>
                                </div>
                            </td>
                            <td>
                                <div class="stats_td_div">
                                    <label for="name">投保人手机号</label> <input type="text" id="customerPhone"
                                                                            name="customerPhone" maxlength="11"/>
                                </div>
                            </td>
                            <td>
                                <div class="stats_td_div ">
                                    <label for="fundStatus">保单状态</label>
                                    <itech:code type="select" code="insurance.insuranceStatus"
                                                property="insuranceStatus"/>
                                </div>
                            </td>
                            <td>
                                <div class="stats_td_div col-md-2">
                                    <button type="button" onclick="search()" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary"
                                            onclick="$('#searchForm select,input').val('')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                    <button type="button" id="exportBtn" class="btn btn-primary">
                                        <i class="icon-search"></i>导出明细
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="form-group">
                <label>统计：共<strong class="stat_strong" id="totalCount"></strong>条购买记录，涉及<strong class="stat_strong"
                                                                                                id="insuranceNum"></strong>
                    个产品，<strong class="stat_strong" id="customerNum"></strong>个客户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <span style="color: red">说明：购买人指投标单中的投保人，数据按用户注册手机号进行匹配，故此表不包含投保时手机号不一致或未填写手机号的客户。</span></label>
            </div>
            <div class="clearfix">
                <table id='list'></table>
            </div>
        </div>
    </div>
</div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#list').datagrid({
            url: '${pageContext.request.contextPath}/business/insurance/buy/query',
            frozenColumns: [[
                {field: 'CONTRACT_CODE', title: '合同编号', width: 100, align: 'center'},
                {field: 'INSURANCE_NAME', title: '保险产品名称', width: 150, align: 'center', halign: 'center'},
                {field: 'COMPANYNAME', title: '保险公司', width: 150, align: 'center', halign: 'center'},
                {field: 'CATEGORY', title: '保险类型', width: 100, align: 'center', halign: 'center'},
                {field: 'NIKE_NAME', title: '用户昵称', width: 80, align: 'center', halign: 'center'},
                {field: 'CUSTOMER_NAME', title: '客户姓名', width: 89, align: 'center', halign: 'center'},
                {field: 'CUSTOMER_PHONE', title: '投保人手机号', width: 100, align: 'center', halign: 'center'},
                {field: 'PAY_WAY', title: '交费方式', width: 70, align: 'center', halign: 'center'},
                {field: 'PAID_PREMIUM', title: '已交保费', width: 60, align: 'left', halign: 'center'},
                {field: 'INSURANCE_DATE', title: '投保日期', width: 80, align: 'left', halign: 'center'},
                {field: 'RECENT_PAYMENT_DATE', title: '最近交费日期', width: 80, align: 'center', halign: 'center'},
                {field: 'RECENTLY_PAY_DATE', title: '合同生效日期', width: 80, align: 'center', halign: 'center'},
                {field: 'CONTRACT_EFFECTIVE_DATE', title: '合同失效日期', width: 80, align: 'center', halign: 'center'},
                {field: 'INSURANCE_STATUS', title: '保单状态', width: 60, align: 'center', halign: 'center'},
                {field: 'INSURANCE_REMARK', title: '保单状态说明', width: 200, align: 'left', halign: 'center'}
            ]],
            columns: [[
                {field: 'OPERATION', title: '操作', width: 100, align: 'center', halign: 'center'}
            ]],
            pagination: true,
            nowrap: true,
            pageSize: 10,
            pageList: [10, 20, 30],
            onLoadSuccess: function (data) {
                $("#totalCount").html(data.total);
                $("#insuranceNum").html(data.insuranceNum);
                $("#customerNum").html(data.customerNum);
                $("#pictureServerURL").val(data.pictureServerURL);
            }
        });
    });

    function search() {
        var param = {
            companyName: $('#companyName').val(),
            insuranceName: $('#insuranceName').val(),
            upperAndLowerFrame: $('#upperAndLowerFrame').val(),
            customerName: $('#customerName').val(),
            customerPhone: $('#customerPhone').val(),
            insuranceStatus: $('#insuranceStatus').val()
        };
        $('#list').datagrid('load', param);
    }

    $("#exportBtn").bind("click", function () {
        var companyName = $('#companyName').val();
        var insuranceName = $('#insuranceName').val();
        var upperAndLowerFrame = $('#upperAndLowerFrame').val();
        var customerName = $('#customerName').val();
        var customerPhone = $('#customerPhone').val();
        var insuranceStatus = $('#insuranceStatus').val();
        window.location.href = "${pageContext.request.contextPath }/business/insurance/buy/exportexcel?companyName=" + companyName + "&insuranceName=" + insuranceName + "&upperAndLowerFrame=" + upperAndLowerFrame + "&customerName=" + customerName + "&customerPhone=" + customerPhone + "&insuranceStatus=" + insuranceStatus;
    });

    function view(contractAttachments) {
        window.location.href = "${pageContext.request.contextPath }/business/insurance/buy/view?contractAttachments=" + contractAttachments;
    }
</script>
</html>
