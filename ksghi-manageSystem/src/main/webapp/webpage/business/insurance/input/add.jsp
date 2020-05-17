<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>保险产品录入</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/address.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
    <%@ include file="/webpage/common/commoneditor.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>产品管理</li>
                <li>保险信息管理</li>
                <li>保险产品录入</li>
            </ul>
        </div>
    </div>
    <!-- page content start -->
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>保险产品录入</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-10">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/insurance/input/save"
                          enctype="multipart/form-data" role="form">
                        <input type="hidden" id="auditStatus" name="auditStatus" value="unsubmit"/>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>保险产品录入
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>产品编号</label>
                                    <div class="col-md-2">
                                        <input id="code" name="code" type="text" class="form-control" maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>产品名称</label>
                                    <div class="col-md-2">
                                        <input id="name" name="name" type="text" class="form-control" maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i class="icons-mark-required"></i>推荐语(20字以内)</label>
                                    <div class="col-md-2">
                                        <input id="recommendations" name="recommendations" type="text"
                                               class="form-control" maxlength="20"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>保险公司</label>
                                    <div class="col-md-2">
                                        <itech:code type="select" code="insurance.companyName" property="companyName"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>保险类型</label>
                                    <div class="col-md-2">
                                        <input id="category" name="category" type="text" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>投保范围</label>
                                    <div class="col-md-2">
                                        <input id="insuranceCoverage" name="insuranceCoverage" type="text"
                                               class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>保险期间</label>
                                    <div class="col-md-2">
                                        <input id="timeLimit" name="timeLimit" type="text" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>交费方式</label>
                                    <div class="col-md-2">
                                        <input id="payType" name="payType" type="text" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>产品宣传图</label>
                                    <div id="advertisePictueDiv" class="col-md-9">
                                        <ul class="list-inline">
                                            <li><input id="advertisePictueFile" name="advertisePictueFile" type="file"
                                                       class="input-file"/></li>
                                            <li><i class="icon-close" style="cursor: pointer;"
                                                   onclick="$(this).parent().prev().children().val('')"></i></li>
                                        </ul>
                                        <p class="help-block">请上传格式为：jpg、png、pdf的文件且文件大小在10MB以内</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i class="icons-mark-required"></i>产品宣传图(详情页)</label>
                                    <div id="advertisePictueDetailDiv" class="col-md-9">
                                        <ul class="list-inline">
                                            <li><input id="advertisePictueDetailFile" name="advertisePictueDetailFile"
                                                       type="file" class="input-file"/></li>
                                            <li><i class="icon-close" style="cursor: pointer;"
                                                   onclick="$(this).parent().prev().children().val('')"></i></li>
                                        </ul>
                                        <p class="help-block">请上传格式为：jpg、png、pdf的文件且文件大小在10MB以内</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>产品详情：</label>
                                    <div class="col-md-6">
                                        <script id="editor" type="text/plain"
                                                style="width: 770px; height: 300px;">${product.graphicDetails}</script>
                                        <
                                        input
                                        type = "hidden"
                                        name = "graphicDetails"
                                        id = "graphicDetails" / >
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "form-group" >
                                            < label
                                        class
                                        = "col-md-3 control-label" > 产品详情扩展：<
                                        /label>
                                        < div
                                        class
                                        = "col-md-6" >
                                            < script
                                        id = "editorRsponsibility"
                                        type = "text/plain"
                                        style = "width: 770px; height: 300px;" >${product.responsibility}</script>
                                        <input type="hidden" name="responsibility" id="responsibility"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>投保币种</label>
                                    <div class="col-md-2">
                                        <input id="currencyType" name="currencyType" type="text" class="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="red" align="center">建议先【保存】，在列表页操作栏点击【预览】，信息准确无误后，再提交审核。</div>
                                    <div class="col-md-offset-3 col-md-9" align="center">
                                        <button id="saveButton" type="button" class="btn btn-primary">
                                            <i class="icon-disk"></i>保存
                                        </button>
                                        <button id="pendingAuditButton" type="button" class="btn btn-primary">
                                            <i class="icon-disk"></i>提交审核
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
<p style="display: none">
	<textarea id="viewFileTmpl" rows="0" cols="0">
	<!--
		<div>
			<a href="{$T.path}" target="_blank" title="{$T.name}">
				<img alt="{$T.name}" src="{$T.thumbnail}" height="120" width="120" class="img-rounded" class="img-thumbnail"/>
			</a>
			<i class="icon-close" style="cursor: pointer;" onclick="deleteFile(this)" data-field='"inputName":"{$T.inputName}","fileParam":"{$T.fileParam}"'></i>
		</div>
	-->
	</textarea>
</p>
<p style="display: none">
	<textarea id="fileTmpl" rows="0" cols="0">
	<!--
		<ul class="list-inline">
			<li><input name="{$T.inputName}" id="{$T.inputName}" type="file" class="input-file"/></li>
			<li><i class="icon-close" style="cursor: pointer;" onclick="$(this).parent().prev().children().val('')"></i></li>
		</ul>		
		<p class="help-block">请上传格式为：jpg、png的文件且文件大小在10MB以内</p>
	-->
	</textarea>
</p>
<style>
    .red {
        #d94a48

    }
</style>

<script type="text/javascript"><!--
var ue = UE.getEditor('editor');
--></script>
<script type="text/javascript">
    var ue = UE.getEditor('editor');
    var ue = UE.getEditor('editorRsponsibility');

    $(function () {

        var searchFormValidate = $("#searchForm").validate({
            rules: {
                code: {
                    required: true
                },
                name: {
                    required: true
                },
                recommendations: {
                    required: true
                },
                companyName: {
                    required: true
                },
                category: {
                    required: true
                },
                insuranceCoverage: {
                    required: true
                },
                timeLimit: {
                    required: true
                },
                payType: {
                    required: true
                },
                graphicDetails: {
                    required: true
                },
                advertisePictueFile: {
                    required: true,
                    extension: "jpg|jpeg|png",
                    acceptFileSize: [0, 10],
                },
                advertisePictueDetailFile: {
                    required: true,
                    extension: "jpg|jpeg|png",
                    acceptFileSize: [0, 10],
                }
            }
        });

        $('#code').bind('input propertychange', function () {
            jQuery.ajax({
                type: "POST",
                url: '${pageContext.request.contextPath}/business/insurance/input/check',
                data: {code: $('#code').val()},
                success: function (data) {
                    if (data == false) {
                        alert("产品编号已存在！");
                    }
                }
            });
        });

        $("#saveButton").click(function () {
            $("#graphicDetails").val(UE.getEditor('editor').getContent());
            $("#responsibility").val(UE.getEditor('editorRsponsibility').getContent());
            if (searchFormValidate.form()) {
                if ($("#graphicDetails").val() == undefined || $("#graphicDetails").val() == "") {
                    $("#editor").append("<span for='editor' generated='true' class='error help-block'>必填项</span>");
                    return;
                }
                $("#searchForm").submit();
            }
        });

        $("#pendingAuditButton").click(function () {
            $("#auditStatus").val("pendingAudit");
            $("#graphicDetails").val(UE.getEditor('editor').getContent());
            $("#responsibility").val(UE.getEditor('editorRsponsibility').getContent());
            if (searchFormValidate.form()) {

                if ($("#graphicDetails").val() == undefined || $("#graphicDetails").val() == "") {
                    $("#editor").append("<span for='editor' generated='true' class='error help-block'>必填项</span>");
                    return;
                }
                $("#searchForm").submit();
            }
        });
    });
</script>
<itech:promptInfo type="alert"></itech:promptInfo>
</html>
