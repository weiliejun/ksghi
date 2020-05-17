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
                <li>保险产品修改</li>
            </ul>
        </div>
    </div>
    <!-- page content start -->
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>保险产品修改</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-10">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/insurance/input/updatesave"
                          enctype="multipart/form-data" role="form">
                        <input type="hidden" id="id" name="id" value="${productInsurance.id}"/>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>保险产品修改
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div id="auditDiv">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">审核状态</label>
                                        <div>
                                            <itech:code type="text" code="insurance.auditStatus" property="auditStatus"
                                                        value="${productInsurance.auditStatus}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">审核意见</label>
                                        <div>${productInsurance.auditDesc}</div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">审核时间</label>
                                        <div>${productInsurance.auditTime}</div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">审核人</label>
                                        <div>${productInsurance.auditorName}</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>产品编号</label>
                                    <div class="col-md-2">
                                        <input id="code" name="code" type="text" class="form-control" maxlength="50"
                                               value="${productInsurance.code}" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>产品名称</label>
                                    <div class="col-md-2">
                                        <input id="name" name="name" type="text" class="form-control"
                                               value="${productInsurance.name}" maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">推荐语(20字以内)</label>
                                    <div class="col-md-2">
                                        <input id="recommendations" name="recommendations" type="text"
                                               class="form-control" value="${productInsurance.recommendations}"
                                               maxlength="40"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>保险公司</label>
                                    <div class="col-md-3">
                                        <itech:code type="select" code="insurance.companyName" property="companyName"
                                                    value="${productInsurance.companyName}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>保险类型</label>
                                    <div class="col-md-3">
                                        <input id="category" name="category" type="text" class="form-control"
                                               value="${productInsurance.category}" maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>投保范围</label>
                                    <div class="col-md-3">
                                        <input id="insuranceCoverage" name="insuranceCoverage" type="text"
                                               class="form-control" value="${productInsurance.insuranceCoverage}"
                                               maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>保险期间</label>
                                    <div class="col-md-3">
                                        <input id="timeLimit" name="timeLimit" type="text" class="form-control"
                                               value="${productInsurance.timeLimit}" maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>交费方式</label>
                                    <div class="col-md-3">
                                        <input id="payType" name="payType" type="text" class="form-control"
                                               value="${productInsurance.payType}" maxlength="50"/>
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
                                                style="width: 770px; height: 300px;">${productInsurance.graphicDetails}</script>
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
                                        style = "width: 770px; height: 300px;" >${productInsurance.responsibility}</script>
                                        <input type="hidden" name="responsibility" id="responsibility"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>投保币种</label>
                                    <div class="col-md-2">
                                        <input id="currencyType" name="currencyType" type="text" class="form-control"
                                               value="${productInsurance.currencyType}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="red">建议先【保存】，在列表页操作栏点击【预览】，信息准确无误后，再提交审核。</div>
                                <div class="form-group">
                                    <div class="col-md-offset-3 col-md-9">
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
	<textarea id="viewDetailFileTmpl" rows="0" cols="0">
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
		<p class="help-block">请上传格式为：jpg、png、pdf的文件且文件大小在10MB以内</p>
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

    function deleteFile(_this) {
        bootbox.confirm('您确定要删除该文件吗？', function (confirmed) {
            if (confirmed) {
                var dataField = $.parseJSON("{" + $(_this).attr("data-field") + "}");

                $.ajax({
                    type: "POST",
                    dataType: "json",
                    data: {
                        id: "${productInsurance.id}",
                        fileParam: dataField.fileParam,
                        inputName: dataField.inputName
                    },
                    url: "${pageContext.request.contextPath}/business/insurance/input/deleteadvertisepictuefile",
                    success: function (data) {
                        if (data) {
                            var data = {
                                inputName: dataField.inputName
                            };
                            $(_this).parent().parent().setTemplateElement("fileTmpl");
                            $(_this).parent().parent().processTemplate(data);
                        } else {
                            bootbox.alert("删除失败，请稍后重试！");
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        bootbox.alert("请求失败，请刷新页面后重试！");
                        return false;
                    }
                });
            }
        });
    }

    function jsonArrayIsNotEmpty(jsonAryStr) {
        if (jsonAryStr != null && jsonAryStr != '' &&
            jsonAryStr != '[]') {
            return true;
        }
        return false;
    }

    $(function () {
        var contextPath = "${pictureServerURL}";
        if (jsonArrayIsNotEmpty('${productInsurance.advertisePictue }')) {
            var jsonAry = $.parseJSON('${productInsurance.advertisePictue }');
            var jsonObj = jsonAry[0];
            var data = {
                path: contextPath + jsonObj.path,
                name: jsonObj.name,
                thumbnail: contextPath + jsonObj.thumbnail,
                inputName: "advertisePictueFile",
                fileParam: "ap_" + jsonObj.id
            };
            $("#advertisePictueDiv").setTemplateElement("viewFileTmpl");
            $("#advertisePictueDiv").processTemplate(data);
        } else {
            $("#advertisePictueDiv").setTemplateElement("fileTmpl");
            $("#advertisePictueDiv").processTemplate({inputName: "advertisePictueFile"});
        }

        if (jsonArrayIsNotEmpty('${productInsurance.advertisePictueDetail }')) {
            var jsonAry = $.parseJSON('${productInsurance.advertisePictueDetail }');
            var jsonObj = jsonAry[0];
            var data = {
                path: contextPath + jsonObj.path,
                name: jsonObj.name,
                thumbnail: contextPath + jsonObj.thumbnail,
                inputName: "advertisePictueDetailFile",
                fileParam: "ap_" + jsonObj.id
            };
            $("#advertisePictueDetailDiv").setTemplateElement("viewDetailFileTmpl");
            $("#advertisePictueDetailDiv").processTemplate(data);
        } else {
            $("#advertisePictueDetailDiv").setTemplateElement("fileTmpl");
            $("#advertisePictueDetailDiv").processTemplate({inputName: "advertisePictueDetailFile"});
        }

        var searchFormValidate = $("#searchForm").validate({
            rules: {
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
                    extension: "jpg|jpeg|png|pdf",
                    acceptFileSize: [0, 10]
                },
                advertisePictueDetailFile: {
                    required: true,
                    extension: "jpg|jpeg|png|pdf",
                    acceptFileSize: [0, 10]
                },
                currencyType: {
                    required: true
                }
            }
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

<script>
    window.onload = function () {
        var audit = "${productInsurance.auditStatus}";
        if (audit == 'unsubmit') {
            $("#auditDiv").hide();
        } else {
            $("#auditDiv").show();
        }
    }
</script>
</html>
