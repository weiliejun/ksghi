<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>审核反馈</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/address.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>产品管理</li>
                <li>保险信息管理</li>
                <li>审核反馈</li>
            </ul>
        </div>
    </div>
    <!-- page content start -->
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>审核反馈</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/insurance/audit/submitAudit"
                          enctype="multipart/form-data" role="form">
                        <input type="hidden" id="selectcode" name="selectcode"/> <input type="hidden" id="id" name="id"
                                                                                        value="${productInsurance.id }"/>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>审核反馈
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">保险产品名称</label>
                                    <div class="col-md-2">
                                        <input class="form-control" type="text" id="name" name="name"
                                               value="${productInsurance.name }" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">保险公司</label>
                                    <div class="col-md-2">
                                        <itech:code type="text" code="insurance.companyName" property="companyName"
                                                    value="${productInsurance.companyName }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">产品编号</label>
                                    <div class="col-md-2">
                                        <input class="form-control" type="text" id="code" name="code"
                                               value="${productInsurance.id }" readonly="readonly"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-3 control-label">审核状态</label>
                                    <div class="col-md-2">
                                        <itech:code type="radio" code="insurance.auditStatusAuditUsed"
                                                    property="auditStatus" value="${productInsurance.auditStatus }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">审核意见</label>
                                    <div class="col-md-3">
                                        <textarea class="form-control" rows="2" name="description" maxlength="1000"
                                                  style="text-align: left;"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">审核时间</label>
                                    <div class="col-md-3">
                                        <input class="form-control" type="text" id="auditTime" name="auditTime"
                                               value="${productInsurance.auditTime }" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">审核人</label>
                                    <div class="col-md-3">
                                        <input class="form-control" type="text" id="auditorName" name="auditorName"
                                               value="${productInsurance.auditorName }" readonly="readonly"/>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="saveButton" type="button" class="btn btn-primary">
                                            <i class="icon-disk"></i>提交
                                        </button>
                                        <button onclick="javascript:history.go(-1);" type="button"
                                                class="btn btn-primary">
                                            <i class="icon-undo2"></i>取消
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="col-sm-offset-6 col-sm-12"></div>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>
<style>
    .red {
        #d94a48

    }
</style>
<script type="text/javascript">
    $("#saveButton").click(function () {
        $("#searchForm").submit();
    });
</script>
</html>
