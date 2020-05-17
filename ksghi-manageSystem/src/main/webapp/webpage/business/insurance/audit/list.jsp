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
            <li class="active">保险审核管理</li>
        </ul>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 page-header">
            <h4>
                保险审核管理
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
                                    <label>保险公司</label>
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
                                    <label>审核状态</label>
                                    <itech:code type="select" code="insurance.auditStatusAuditUsed"
                                                property="auditStatus"/>
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
                <label>统计：共<strong class="stat_strong" id="totalCount"></strong>个产品， 待审核<strong class="stat_strong"
                                                                                                id="pendingAudit"></strong>个，已驳回
                    <strong class="stat_strong" id="rejected"></strong> 个， 审核通过<strong class="stat_strong"
                                                                                       id="auditPass"></strong>个 &nbsp;&nbsp;&nbsp;&nbsp;
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
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#list').datagrid({
            url: '${pageContext.request.contextPath}/business/insurance/audit/query',
            frozenColumns: [[
                {field: 'CODE', title: '保险产品编号', width: 100, align: 'center'},
                {field: 'NAME', title: '保险产品名称', width: 150, align: 'center', halign: 'center'},
                {field: 'RECOMMENDATIONS', title: '推荐语', width: 242, align: 'center', halign: 'center'},
                {field: 'COMPANYNAME', title: '保险公司', width: 200, align: 'center', halign: 'center'},
                {field: 'CATEGORY', title: '保险类型', width: 100, align: 'center', halign: 'center'},
                {field: 'INSURANCE_COVERAGE', title: '投保范围', width: 120, align: 'center', halign: 'center'},
                {field: 'TIME_LIMIT', title: '保险期间', width: 120, align: 'center', halign: 'center'},
                {field: 'PAY_TYPE', title: '交费方式', width: 100, align: 'center', halign: 'center'},
                {field: 'CURRENCY_TYPE', title: '投保币种', width: 80, align: 'center', halign: 'center'}
            ]],
            columns: [[
                {field: 'CREATE_TIME', title: '创建时间', width: 150, align: 'center'},
                {field: 'AUDITSTATUS', title: '审核状态', width: 100, align: 'center', halign: 'center'},
                {field: 'OPERATION', title: '操作', width: 120, align: 'center', halign: 'center'}
            ]],
            pagination: true,
            nowrap: true,
            pageSize: 10,
            pageList: [10, 20, 30],
            onLoadSuccess: function (data) {
                $("#totalCount").html(data.total);
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
            auditStatus: $("input[name='auditStatus']").val()
        };
        $('#list').datagrid('load', param);
    }

    function view(id) {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/audit/view/" + id;
    }

    function updatePass(id) {
        $.messager.confirm("确定", "修改产品信息后需要重新审核！", function (r) {
            if (r) {
                window.location.href = "${pageContext.request.contextPath}/business/insurance/audit/update/" + id;
            }
        });
        return false;
    }

    function update(id) {

        window.location.href = "${pageContext.request.contextPath}/business/insurance/audit/update/" + id;
    }

    function submitAudit(id) {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/audit/submitAudit/" + id;
    }
</script>
</html>
