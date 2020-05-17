<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>版本信息录入管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
</head>

<body>
<div id="wrapper">

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>版本管理－新增版本</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/version/add" enctype="multipart/form-data">
                        <input id="id" name="id" maxlength="36" type="hidden" class="form-control"
                               value="${version.id }"/>
                        <div class="panel panel-default">

                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>终端类型：</label>
                                    <div class="col-md-9">
                                        <itech:code type="radio" code="app.versionType" property="type"
                                                    value="${version.type }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>版本号：</label>
                                    <div class="col-md-3">
                                        <input id="version" name="version" maxlength="36" type="text"
                                               class="form-control" value="${version.version }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>当前状态：</label>
                                    <div class="col-md-2">
                                        <itech:code type="select" code="app.apkStatus" property="status"
                                                    value="${version.status }"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>强制更新：</label>
                                    <div class="col-md-2">
                                        <itech:code type="select" code="app.forcedUpgrade" property="forcedUpgrade"
                                                    value="${version.forcedUpgrade }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">上线时间：</label>
                                    <div class="col-md-3">
                                        <input id="onlineTime" name="onlineTime" maxlength="36" type="text"
                                               class="form-control" readonly="readonly" value="${version.onlineTime }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">下线时间：</label>
                                    <div class="col-md-3">
                                        <input id="offlineTime" name="offlineTime" maxlength="36" type="text"
                                               class="form-control" readonly="readonly"
                                               value="${version.offlineTime }"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-3 control-label">备注：</label>
                                    <div class="col-md-6">
                                        <textarea id="remark" name="remark" class="form-control" rows="8"
                                                  maxlength="200">${version.remark}</textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-3 control-label">上传apk：</label>
                                    <div class="col-md-9" id="showFile">
                                        <input id="path" name="path" style="width: 600px ! important;" type="text"
                                               class="form-control" readonly="readonly"
                                               value="${pictureServerURL}${version.path }"/> <a
                                            onclick="javascript:reUpload()">重新上传apk</a>
                                    </div>
                                    <div class="col-md-9" id="uploadFile" style="display: none;">
                                        <input class="input-file" type="file" id="file" name="file"/>
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
        window.location.href = "${pageContext.request.contextPath}/version/query";
    }

    $(function () {
        var searchFormValidate = $("#searchForm").validate({
            rules: {
                type: {
                    required: true
                },
                name: {
                    required: true
                },
                version: {
                    required: true
                },
                status: {
                    required: true
                },
                file: {
                    required: true
                }
            }
        });
        $("#onlineTime").datetimepicker({
            format: "YYYY-MM-DD HH:mm",
            useSeconds: true
        });
        $("#offlineTime").datetimepicker({
            format: "YYYY-MM-DD HH:mm",
            useSeconds: true
        });
        $("#saveButton").click(function () {
            if (searchFormValidate.form()) {
                $("#searchForm").submit();
            }
        });

    });

    function reUpload() {
        $("#showFile").hide();
        $("#uploadFile").show();
    }
</script>
</html>
