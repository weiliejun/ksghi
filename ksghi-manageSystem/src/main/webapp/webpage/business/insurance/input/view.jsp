<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>保险产品录入</title>
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
                <li>保险产品预览</li>
            </ul>
        </div>
    </div>
    <!-- page content start -->
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>保险产品预览</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-10">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/insurance/input/updatesave"
                          enctype="multipart/form-data" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>保险产品预览
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>产品编号</label>
                                    <div class="col-md-2">${productInsurance.code}</div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>产品名称</label>
                                    <div class="col-md-2">${productInsurance.name}</div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">推荐语(20字以内)</label>
                                    <div class="col-md-2">${productInsurance.recommendations}</div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>保险公司</label>
                                    <div class="col-md-9">
                                        <itech:code type="text" code="insurance.companyName" property="companyName"
                                                    value="${productInsurance.companyName}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>保险类型</label>
                                    <div class="col-md-9">${productInsurance.category}</div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>投保范围</label>
                                    <div class="col-md-9">${productInsurance.insuranceCoverage}</div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>保险期间</label>
                                    <div class="col-md-9">${productInsurance.timeLimit}</div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>交费方式</label>
                                    <div class="col-md-9">${productInsurance.payType}</div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>投保币种</label>
                                    <div class="col-md-2">${productInsurance.currencyType}</div>
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
                                            class="icons-mark-required"></i>产品详情</label>
                                    <div class="col-md-9">
											<textarea cols="150" rows="10" readonly="readonly">
                                                ${productInsurance.graphicDetails}
                                            </textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">产品详情扩展</label>
                                    <div class="col-md-9">
											<textarea cols="150" rows="10" readonly="readonly">
                                                ${productInsurance.responsibility}
                                            </textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button onclick="javascript:history.go(-1);" type="button"
                                                class="btn btn-primary">
                                            <i class="icon-undo2"></i>返回
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
		<p class="help-block">请上传格式为：jpg、png、pdf的文件且文件大小在10MB以内</p>
	-->
	</textarea>
</p>
<style>
    .red {
        #d94a48

    }
</style>
<script type="text/javascript">
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
            $("#advertisePictueDetailDiv").setTemplateElement("viewFileTmpl");
            $("#advertisePictueDetailDiv").processTemplate(data);
        } else {
            $("#advertisePictueDetailDiv").setTemplateElement("fileTmpl");
            $("#advertisePictueDetailDiv").processTemplate({inputName: "advertisePictueDetailFile"});
        }

    });

</script>
</html>
