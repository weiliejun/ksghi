<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增运营LOGO</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>LOGO运营管理－新增运营LOGO</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/appLogoManage/save" role="form"
                          ENCTYPE="multipart/form-data">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>运营LOGO
                                </h3>
                            </div>
                            <input name="id" type="hidden" class="form-control" maxlength="50"
                                   value="${appLogoManage.id}"/>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>名称</label>
                                    <div class="col-md-4">
                                        <input name="logoName" type="text" class="form-control" maxlength="50"
                                               value="${appLogoManage.logoName}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">地址URL</label>
                                    <div class="col-md-9">
                                        <input name="url" type="text" class="form-control" maxlength="120"
                                               value="${appLogoManage.url}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>备注</label>
                                    <div class="col-md-9">
                                        <textarea class="form-control" rows="3" name="remark"
                                                  maxlength="1100">${appLogoManage.remark}</textarea>
                                    </div>
                                </div>
                                <div class="form-group" id="imgGroup">
                                    <c:if test="${empty appLogoManage.id}">
                                        <label class="col-md-2 control-label"><font color="red">*</font>上传图片</label>
                                        <div class="col-md-9">
                                            <input class="input-file" type="file" id="upload" name="upload"/> <span>图片大小不超过200K，支持JPG 、png、bmp等格式</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty appLogoManage.id}">
                                        <label class="col-md-2 control-label"><font color="red">*</font>上传图片：</label>
                                        <div class="col-md-9" id="showFile">
                                            <a href="${pictureServerURL}${appLogoManage.upload}"
                                               target="_blank">查看图片</a> <a onclick="javascript:reUpload()">重新上传</a>
                                        </div>
                                        <div class="col-md-9" id="uploadFile" style="display: none;">
                                            <input class="input-file" type="file" id="upload" name="upload"/> <span>图片大小不超过200K，支持JPG 、png、bmp等格式</span>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-2 col-md-9">
                                        <button id="saveButton" type="button" class="btn btn-primary">
                                            <i class="icon-disk"></i>保存
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


<script type="text/javascript">
    function goBack() {
        window.location.href = "${pageContext.request.contextPath}/appLogoManage/query";
    }

    $(function () {
        var searchFormValidate = $("#searchForm").validate({
            rules: {
                name: {
                    required: true
                },
                url: {
                    required: true
                },
                remark: {
                    required: true
                },
                upload: {
                    required: true
                }
            }
        });
        $("#saveButton").click(function () {
            if (searchFormValidate.form()) {
                $("#searchForm").submit();
            }
        });
    });

    function reUpload() {
        $("#showFile").addClass("hide");
        $("#uploadFile").addClass("show");
    }
</script>
</html>
