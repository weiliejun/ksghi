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
            <li class="active">保险产品上下架管理</li>
        </ul>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 page-header">
            <h4>
                保险产品上下架管理
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
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
                <div class="col-sm-offset-6 col-sm-12"></div>
            </div>
            <div class="form-group">
                <label>统计：共<strong class="stat_strong" id="totalCount"></strong>个产品， 已上架<strong class="stat_strong"
                                                                                                id="yesShelf"></strong>个，已下架
                    <strong class="stat_strong" id="noShelf"></strong> 个&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <span style="color: red">审核通过的新产品默认为&nbsp; &quot;已下架&quot;&nbsp; 状态，请进行上架操作后，客户可见。</span>
                </label>
            </div>
            <div class="clearfix">
                <table id='list'></table>
            </div>
        </div>
    </div>
</div>
<!-- page content end -->
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#list').datagrid({
            url: '${pageContext.request.contextPath}/business/insurance/frame/query',
            frozenColumns: [[
                {field: 'CODE', title: '保险产品编号', width: 100, align: 'center'},
                {field: 'NAME', title: '保险产品名称', width: 127, align: 'center', halign: 'center'},
                {field: 'RECOMMENDATIONS', title: '推荐语', width: 210, align: 'center', halign: 'center'},
                {field: 'COMPANYNAME', title: '保险公司', width: 200, align: 'center', halign: 'center'},
                {field: 'CATEGORY', title: '保险类型', width: 80, align: 'center', halign: 'center'},
                {field: 'INSURANCE_COVERAGE', title: '投保范围', width: 80, align: 'center', halign: 'center'},
                {field: 'TIME_LIMIT', title: '保险期间', width: 80, align: 'center', halign: 'center'},
                {field: 'PAY_TYPE', title: '交费方式', width: 80, align: 'center', halign: 'center'},
                {field: 'CURRENCY_TYPE', title: '投保币种', width: 80, align: 'center', halign: 'center'}
            ]],
            columns: [[
                {field: 'CREATE_TIME', title: '创建时间', width: 120, align: 'center'},
                {field: 'UPPER_AND_LOWER_FRAME', title: '上架状态', width: 84, align: 'center', halign: 'center'},
                {field: 'UPLOW_REMARK', title: '下架原因', width: 220, align: 'center', halign: 'center'},
                {field: 'OPERATION', title: '操作', width: 120, align: 'center', halign: 'center'}
            ]],
            pagination: true,
            nowrap: true,
            pageSize: 10,
            pageList: [10, 20, 30],
            onLoadSuccess: function (data) {
                $("#totalCount").html(data.total);
                $("#noShelf").html(data.noShelf);
                $("#yesShelf").html(data.yesShelf);
            }
        });
    });

    function search() {
        var param = {
            name: $('#name').val(),
            companyName: $('#companyName').val(),
            upperAndLowerFrame: $('#upperAndLowerFrame').val(),
        };
        $('#list').datagrid('load', param);
    }

    function view(id) {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/frame/view/" + id;
    }

    function update(id) {
        $.messager.confirm("确定", "修改产品信息后需要重新审核并上架！", function (r) {
            if (r) {
                window.location.href = "${pageContext.request.contextPath}/business/insurance/frame/update/" + id;
            }
        });
        return false;

    }

    function submitAudit(id, istoshlef) {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/frame/submitAudit/" + id;
    }
</script>
</html>
