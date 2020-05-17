<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>保险产品</title>
    <%@ include file="/webpage/common/plugins/easyui.jsp" %>
</head>

<body>
<div id="breadcrumb-wrapper">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li><i class="icon-home"></i>产品管理</li>
            <li>保险信息管理</li>
            <li class="active">保险销售记录管理</li>
        </ul>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 page-header">
            <h4>
                保险销售记录管理
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
                                    <label for="name">保险产品名称</label> <input type="text" id="name" name="name"/>
                                </div>
                            </td>
                            <td>
                                <div class="stats_td_div ">
                                    <label for="fundStatus">上架状态</label>
                                    <itech:code type="select" code="fund.shelfState" property="upperAndLowerFrame"/>
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
                                    <button type="button" id="tempbutton" class="btn btn-primary">
                                        <i class="icon-search"></i>下载数据模板
                                    </button>
                                    <button type="button" onclick="importData()" class="btn btn-primary">
                                        <i class="icon-search"></i>上传销售数据
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="form-group">
                <label>统计：共<strong class="stat_strong" id="totalCount"></strong>个产品，购买总人数<strong class="stat_strong"
                                                                                                 id="purchaseNum"></strong>人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </label>
            </div>
            <div class="clearfix">
                <table id='list'></table>
            </div>
            <div class="col-sm-offset-6 col-sm-12"></div>
        </div>
    </div>
</div>
<!-- page content end -->
</div>
<form class="form-inline" id="myForm" action="${pageContext.request.contextPath}/business/insurance/sale/downloadtemp"
      method="post">
    <input type="hidden" name="filename" id="filename"/> <input type="hidden" name="filetype" id="filetype"/> <input
        type="hidden" name="fileurl" id="fileurl"/>
</form>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#list').datagrid({
            url: '${pageContext.request.contextPath}/business/insurance/sale/query',
            frozenColumns: [[
                {field: 'CODE', title: '保险产品编号', width: 176, align: 'center'},
                {field: 'PRODUCT_NAME', title: '保险产品名称', width: 200, align: 'center', halign: 'center'},
                {field: 'COMPANYNAME', title: '保险公司', width: 200, align: 'center', halign: 'center'},
                {field: 'CATEGORY', title: '保险类型', width: 150, align: 'center', halign: 'center'},
                {field: 'INSURANCE_COVERAGE', title: '投保范围', width: 179, align: 'center', halign: 'center'},
                {field: 'TIME_LIMIT', title: '保险期间', width: 120, align: 'center', halign: 'center'},
                {field: 'PAY_TYPE', title: '交费方式', width: 120, align: 'center', halign: 'center'}
            ]],
            columns: [[
                {field: 'UPPER_AND_LOWER_FRAME', title: '上架状态', width: 120, align: 'center', halign: 'center'},
                {field: 'BUY_COUNT', title: '购买人数', width: 120, align: 'center', halign: 'center'},
                {field: 'OPERATION', title: '操作', width: 200, align: 'center', halign: 'center'}
            ]],
            pagination: true,
            nowrap: true,
            pageSize: 10,
            pageList: [10, 20, 30],
            onLoadSuccess: function (data) {
                $("#totalCount").html(data.total);
                $("#purchaseNum").html(data.purchaseNum);
                $("#filename").val(data.temp.filename);
                $("#filetype").val(data.filetype);
                $("#fileurl").val(data.temp.fileurl);
            }
        });
        $("#tempbutton").click(function () {
            $("#myForm").submit();
        });

        $("#importData").click(function () {
            window.location.href = "${pageContext.request.contextPath}/business/insurance/sale/importdata";
        });
    });

    function search() {
        var param = {
            name: $('#name').val(),
            companyName: $('#companyName').val(),
            upperAndLowerFrame: $('#upperAndLowerFrame').val()
        };
        $('#list').datagrid('load', param);
    }

    function view(productId) {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/sale/view/" + productId;
    }

    function importData() {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/sale/importdata";
    }
</script>
</html>
