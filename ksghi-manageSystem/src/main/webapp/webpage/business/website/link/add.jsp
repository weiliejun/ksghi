<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增友情链接</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
</head>

<body>
<div id="wrapper">

    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>信息发布管理</li>
                <li><a href="${pageContext.request.contextPath}/business/website/link/list">友情链接管理</a></li>
                <li class="active">新增友情链接</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>新增友情链接</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/website/link/add/save" role="form"
                          ENCTYPE="multipart/form-data">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>友情链接信息
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group ">
                                    <label class="col-md-2 control-label"><font color="red">*</font>网站名称：</label>
                                    <div class="col-md-4">
                                        <input name="name" id="name" type="text" class="form-control" maxlength="50"/>
                                    </div>
                                    <div id="nameIsExist">
                                        <font color='red'>网站名称已经存在</font>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>网站地址：</label>
                                    <div class="col-md-4">
                                        <input name="url" type="text" class="form-control" maxlength="120"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>序号：</label>
                                    <div class="col-md-4">
                                        <input name="sequnum" type="text" class="form-control" maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>网站类型：</label>
                                    <div class="col-md-9">
                                        <itech:code property="type" code="link.type" type="radio" defaultValue="news"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">网站简介：</label>
                                    <div class="col-md-9">
                                        <input name="description" type="text" class="form-control" maxlength="120"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">备注：</label>
                                    <div class="col-md-9">
                                        <textarea class="form-control" rows="3" name="remark"
                                                  maxlength="1100"></textarea>
                                    </div>
                                </div>
                                <div class="form-group" id="imgGroup">
                                    <label class="col-md-2 control-label">网站LOGO：</label>
                                    <div class="col-md-9">
                                        <input class="input-file" type="file" id="picture" name="pictureFile">
                                    </div>
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

    //form字段验证
    $().ready(function () {

        var nameIsExistDiv = $("#nameIsExist");
        nameIsExistDiv.hide();
        var nameIsExist = true;
        $("#name").focusout(function () {
            $.ajax({
                type: "POST",
                async: false,
                url: "${pageContext.request.contextPath}/business/website/link/isexist/isexist",
                data: {name: $("#name").val()},
                success: function (data) {
                    if (data.flag == true) {
                        nameIsExistDiv.show();
                    } else {
                        nameIsExistDiv.hide();
                        nameIsExist = false;
                    }
                }
            });
        });

        var searchFormValidate = $("#searchForm").validate({
            rules: {
                name: {required: true, maxlength: 50},
                url: {required: true, maxlength: 1000},
                sequnum: {required: true, digits: true, min: 1, max: 10000},
            }
        });


        //form提交
        $("#saveButton").click(function () {
            //验证 name是否包含","
            var nameval = $("#name").val();
            var test = new RegExp(",", "g");//创建正则表达式对象
            var result = nameval.match(test);
            if (!result) {
                if (searchFormValidate.form()) {
                    if (!nameIsExist)
                        $("#searchForm").submit();
                }
            } else {
                nameIsExistDiv.css("color", "red");
                nameIsExistDiv.text("编码包含非法字符");
                nameIsExistDiv.show();
            }
        });

        //图片验证
        $("#picture").change(function () {
            var imgUrl = $(this).val();
            var message = "只允许上传：jpg,jpeg,png格式的图片";
            var permitFileType = ["jpg", "jpeg", "png"];
            if (imgUrl != "" && imgUrl != null) {
                $(this).rules("remove", "required");
                $(this).next(".error").css("display", "none");
            }
            var fileType = imgUrl.substring(imgUrl.lastIndexOf(".") + 1);
            var resultFlag = false;
            $.each(permitFileType, function (i, n) {
                if (fileType.toLowerCase() == n) {
                    resultFlag = true;
                    return;
                }
            });

            if (!resultFlag) {
                $(this).val('');
                bootbox.alert(message);
                $(this).rules("add", {required: true});
                return;
            }
        });
    });
</script>
</html>
