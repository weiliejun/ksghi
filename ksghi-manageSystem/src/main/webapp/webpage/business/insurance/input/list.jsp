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
            <li class="active">保险录入管理</li>
        </ul>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 page-header">
            <h4>
                保险录入管理
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
                                    <label for="name">保险产品名称</label> <input type="text" id="name" name="name"
                                                                            maxlength="50"/>
                                </div>
                            </td>
                            <td>
                                <div class="stats_td_div ">
                                    <label for="fundStatus">审核状态</label>
                                    <itech:code type="select" code="insurance.auditStatus" property="auditStatus"/>
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
            </div>
            <div class="form-group">
                <label>统计：共<strong class="stat_strong" id="totalCount"></strong>个产品，未提交<strong class="stat_strong"
                                                                                               id="unsubmit"></strong>个，
                    待审核<strong class="stat_strong" id="pendingAudit"></strong>个，已驳回 <strong class="stat_strong"
                                                                                            id="rejected"></strong> 个，
                    审核通过<strong class="stat_strong" id="auditPass"></strong>个 &nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" id="add" onclick="addInsuranceProduct()" class="btn btn-primary">
                        <i class="icon-plus"></i>新增保险产品
                    </button>
                </label>
            </div>
            <div class="clearfix">
                <table id='list' style="height: auto;"></table>
            </div>
            <div class="col-sm-offset-6 col-sm-12"></div>
        </div>
    </div>
</div>
<!-- page content end -->
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#list').datagrid({
            url: '${pageContext.request.contextPath}/business/insurance/input/query',
            frozenColumns: [[
                {field: 'CODE', title: '保险产品编号', width: 100, align: 'center'},
                {field: 'NAME', title: '保险产品名称', width: 120, align: 'center', halign: 'center'},
                {field: 'RECOMMENDATIONS', title: '推荐语', width: 210, align: 'center', halign: 'center'},
                {field: 'COMPANYNAME', title: '保险公司', width: 100, align: 'center', halign: 'center'},
                {field: 'CATEGORY', title: '保险类型', width: 100, align: 'center', halign: 'center'},
                {field: 'INSURANCE_COVERAGE', title: '投保范围', width: 200, align: 'center', halign: 'center'},
                {field: 'TIME_LIMIT', title: '保险期间', width: 120, align: 'center', halign: 'center'},
                {field: 'PAY_TYPE', title: '交费方式', width: 100, align: 'center', halign: 'center'},
                {field: 'CURRENCY_TYPE', title: '投保币种', width: 80, align: 'center', halign: 'center'}
            ]],
            columns: [[
                {field: 'CREATE_TIME', title: '创建时间', width: 150, align: 'center'},
                {field: 'AUDITSTATUS', title: '审核状态', width: 100, align: 'center', halign: 'center'},
                {field: 'OPERATION', title: '操作', width: 200, align: 'center', halign: 'center'}
            ]],
            pagination: true,
            nowrap: true,
            pageSize: 10,
            pageList: [10, 20, 30],
            onLoadSuccess: function (data) {
                $("#totalCount").html(data.total);
                $("#unsubmit").html(data.unsubmit);
                $("#pendingAudit").html(data.pendingAudit);
                $("#rejected").html(data.rejected);
                $("#auditPass").html(data.auditPass);
            }
        });
    });

    function search() {
        var param = {
            name: $('#name').val(),
            companyName: $('#companyName').val(),
            auditStatus: $('#auditStatus').val(),
        };
        $('#list').datagrid('load', param);
    }

    function addInsuranceProduct() {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/input/add";

    }

    function view(id) {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/input/view/" + id;
    }

    function deleteInsurance(id) {
        var flag = confirm('您确认要删除该产品么？');
        if (flag) {
            location.href = '${pageContext.request.contextPath}/business/insurance/input/delete/' + id;
            return false;
        }
    }

    function update(id) {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/input/update/" + id;
    }

    function submitAudit(id) {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/input/submitAudit/" + id;
    }

    function fundNetDetail(id) {
        window.location.href = "${pageContext.request.contextPath}/business/fund/input/net/todetail/" + id;
    }

    $("#tempbutton").click(function () {
        $("#myForm").submit();
    });
    $("#saveButton").click(function () {
        window.location.href = "${pageContext.request.contextPath}/business/fund/input/net/tosaveData";
    });
</script>
</html>
