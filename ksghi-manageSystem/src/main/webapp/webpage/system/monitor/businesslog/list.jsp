<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>操作日志监控</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统管理</li>
                <li>系统监控数据管理</li>
                <li class="active">操作日志监控</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>操作日志列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" name="searchForm"
                          action="${pageContext.request.contextPath}/system/monitor/businesslog/list">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-7">
                                    <div class="input-group">
                                        <span class="input-group-addon">管理员账号</span> <input class="form-control"
                                                                                            type="text"
                                                                                            name="managerCode"
                                                                                            value="${managerCode}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-5">
                                    <div class="input-group">
                                        <span class="input-group-addon">管理员姓名</span> <input class="form-control"
                                                                                            type="text"
                                                                                            name="managerName"
                                                                                            value="${managerName}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-5">
                                    <div class="input-group">
                                        <span class="input-group-addon">操作功能模块</span> <input class="form-control"
                                                                                             type="text"
                                                                                             name="functionModule"
                                                                                             value="${functionModule}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-7">
                                    <div class="input-group">
                                        <span class="input-group-addon">操作开始日期</span>
                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-5">
                                    <div class="input-group">
                                        <span class="input-group-addon">操作结束日期</span>
                                        <div class="num fl">
                                            <input id="endDate" name="endDate" size="30" type="text"
                                                   class="form-control data2 loanDatepicker" readonly="readonly"
                                                   value="${endDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-4 col-xs-6">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="myClearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                    <button type="button" id="exportBtn" class="btn btn-primary">
                                        <i class="icon-file-excel"></i>导出Excel
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="managerCode" title="管理员账号" width="12%"/>
                                        <table:htmlColumn property="managerName" title="管理员姓名" width="12%"/>
                                        <table:htmlColumn property="ip" title="Ip地址" width="12%"/>
                                        <table:htmlColumn property="operationTime" title="操作时间" width="12%"/>
                                        <table:htmlColumn property="functionModule" title="操作功能模块" width="20%"/>
                                        <table:htmlColumn property="functionDescription" title="操作功能描述" width="20%"/>
                                        <table:htmlColumn title="操作数据" width="12%" sortable="false">
                                            <a style="cursor: pointer;" onclick="viewContent(this)"
                                               data-Field="${bean.id}" title="${fn:escapeXml(bean.operationData)}">&lt;操作数据&gt;</a>
                                            <div id="content_${bean.id}"
                                                 style="display: none;">${fn:escapeXml(bean.operationData)}</div>
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
    $(document).ready(function () {
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});

        $("#exportBtn").bind("click", function () {
            window.location.href = "${pageContext.request.contextPath }/system/monitor/businesslog/list/exportExcel?" + $('#searchForm').serialize();
        });
    });

    function viewContent(currentObj) {
        var id = $(currentObj).attr("data-Field");
        $.colorbox({html: $("#content_" + id).html(), width: "60%", height: "60%", scrolling: true});
    }
</script>
</html>
