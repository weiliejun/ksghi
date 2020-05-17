<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>推送信息录入管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
</head>

<body>
<div id="wrapper">

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>推送消息管理－修改消息</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/appPushManage/add" enctype="multipart/form-data">
                        <div class="panel panel-default">
                            <input id="id" name="id" maxlength="36" type="hidden" class="form-control"
                                   value="${appPushManage.id}"/>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>消息名称：</label>
                                    <div class="col-md-3">
                                        <input id="messageName" name="messageName" maxlength="36" type="text"
                                               value="${appPushManage.messageName}" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>消息类型：</label>
                                    <div class="col-md-3">
                                        <itech:code type="select" code="appPushManageType" property="type"
                                                    value="${appPushManage.type}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>消息内容：</label>
                                    <div class="col-md-6">
                                        <textarea id="content" name="content" class="form-control" rows="8"
                                                  maxlength="500">${appPushManage.content}</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>自动推送：</label>
                                    <div class="col-md-9">
                                        <itech:code type="radio" code="app.isAutoPush" property="isAutoPush"
                                                    value="${appPushManage.isAutoPush}"
                                                    defaultValue="${appPushManage.isAutoPush == null ? 'false' : appPushManage.isAutoPush }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>推送时间：</label>
                                    <div class="col-md-3">
                                        <input id="pushTime" name="pushTime" maxlength="36" type="text"
                                               class="form-control" value="${appPushManage.pushTime }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>终端类型：</label>
                                    <div class="col-md-9">
                                        <itech:code type="radio" code="app.pushAppType" property="apptype"
                                                    value="${appPushManage.apptype}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="saveButton" type="button" class="btn btn-primary">
                                            <i class="icon-disk"></i>保存
                                        </button>
                                        <button onclick="goBack();" type="button" class="btn btn-primary">
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
<script type="text/javascript">
    function goBack() {
        window.location.href = "${pageContext.request.contextPath}/appPushManage/query";
    }

    $(function () {
        var searchFormValidate = $("#searchForm").validate({
            rules: {
                messageName: {
                    required: true
                },
                type: {
                    required: true
                },
                content: {
                    required: true
                },
                isAutoPush: {
                    required: true
                },
                pushTime: {
                    required: true
                },
                apptype: {
                    required: true
                }
            }
        });
        $("#pushTime").datetimepicker({
            format: "YYYY-MM-DD HH:mm",
            useSeconds: true
        });
        $("#saveButton").click(function () {
            if (searchFormValidate.form()) {
                $("#searchForm").submit();
            }
        });

    });
</script>
</html>
