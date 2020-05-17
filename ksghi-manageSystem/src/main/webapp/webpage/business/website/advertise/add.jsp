<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增广告位</title>
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
                <li><a href="${pageContext.request.contextPath}/business/website/advertise/list">网站广告位管理</a></li>
                <li class="active">新增广告位信息</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>新增广告位信息</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/website/advertise/add/save" role="form"
                          ENCTYPE="multipart/form-data">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>广告位信息
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group ">
                                    <label class="col-md-2 control-label"><font color="red">*</font>编码：</label>
                                    <div class="col-md-4">
                                        <input name="code" id="code" type="text" class="form-control" maxlength="50"/>
                                    </div>
                                    <div id="codeIsExist">
                                        <font color='red'>编码已存在！</font>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>名称：</label>
                                    <div class="col-md-4">
                                        <input name="name" type="text" class="form-control" maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>所属模块：</label>
                                    <div class="col-md-4">
                                        <itech:code property="channel" code="advertise.location" type="select"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">序号：</label>
                                    <div class="col-md-4">
                                        <input name="sequnum" type="text" class="form-control" maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>目标地址：</label>
                                    <div class="col-md-9">
                                        <input name="targetUrl" type="text" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>功能描述：</label>
                                    <div class="col-md-9">
                                        <textarea class="form-control" rows="3" name="description"
                                                  maxlength="1100"></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>展现形式：</label>
                                    <div class="col-md-9">
                                        <itech:code property="type" code="advertiseType" type="radio"
                                                    defaultValue="img"/>
                                    </div>
                                </div>
                                <div class="form-group hide" id="videoGroup">
                                    <label class="col-md-2 control-label"><font color="red">*</font>广告视频：</label>
                                    <div class="col-md-9">
                                        <input class="input-file" type="file" id="video" name="videoFile">
                                    </div>
                                </div>
                                <div class="form-group" id="imgGroup">
                                    <label class="col-md-2 control-label"><font color="red">*</font>宣传图片：</label>
                                    <div class="col-md-9">
                                        <input class="input-file" type="file" id="picture" name="pictureFile">
                                    </div>
                                </div>
                                <div class="form-group hide" id="textGroup">
                                    <label class="col-md-2 control-label"><font color="red" class="font hide">*</font>宣传文字：</label>
                                    <div class="col-md-9">
                                        <textarea class="form-control" rows="3" name="advertiseText"
                                                  maxlength="330"></textarea>
                                    </div>
                                </div>

                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-2 col-md-9">
                                        <button id="saveButton" type="button" class="btn btn-primary"
                                                data-loading-text="Loading..." autocomplete="off">
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

        var codeIsExistDiv = $("#codeIsExist");
        codeIsExistDiv.hide();
        var codeIsExist = true;
        $("#code").focusout(function () {
            $.ajax({
                type: "POST",
                async: false,
                url: "${pageContext.request.contextPath}/business/website/advertise/isexist/isexist",
                data: {code: $("#code").val()},
                success: function (data) {
                    if (data.flag == true) {
                        codeIsExistDiv.show();
                    } else {
                        codeIsExistDiv.hide();
                        codeIsExist = false;
                    }
                }
            });
        });

        var searchFormValidate = $("#searchForm").validate({
            rules: {
                code: {required: true, maxlength: 50},
                name: {required: true, maxlength: 50},
                channel: {required: true, maxlength: 100},
                targetUrl: {required: true},
                description: {required: true, maxlength: 4000},
                pictureFile: {required: true},
                sequnum: {digits: true, min: 1, max: 10000},
                advertiseText: {maxlength: 330},
                textGroup: {maxlength: 1000}
            }
        });


        //form提交
        $("#saveButton").click(function () {
            //验证 code是否包含","
            var codeval = $("#code").val();
            var test = new RegExp(",", "g");//创建正则表达式对象
            var result = codeval.match(test);
            if (!result) {
                if (searchFormValidate.form()) {
                    if (!codeIsExist) {
                        $("#searchForm").submit();
                        $(this).button('loading');
                    }
                }
            } else {
                codeIsExistDiv.css("color", "red");
                codeIsExistDiv.text("编码包含非法字符");
                codeIsExistDiv.show();
            }
        });

        //展现方式
        var textGroup = $("#textGroup");
        var text = textGroup.find("textarea");
        var imgGroup = $("#imgGroup");
        var videoGroup = $("#videoGroup");
        var img = imgGroup.find("input");
        var video = videoGroup.find("input");
        textGroup.removeClass("hide");
        textGroup.find('.font').addClass("hide");
        $(":radio").click(function () {
            if (this.value == "img" || this.value == "carousel") {
                if (this.value == "img") {
                    textGroup.removeClass("hide");
                    textGroup.find('.font').addClass("hide");
                    text.rules("remove", "required");
                } else {
                    textGroup.addClass("hide");
                    text.val("");
                    text.rules("remove", "required");
                }

                videoGroup.addClass("hide");
                video.val("");
                video.rules("remove", "required");

                imgGroup.removeClass("hide");
                img.rules("add", {required: true});
            } else if (this.value == "text") {
                textGroup.removeClass("hide");
                text.rules("add", {required: true, maxlength: 1000});
                textGroup.find('.font').removeClass("hide");

                imgGroup.addClass("hide");
                img.val("");
                img.rules("remove", "required");

                videoGroup.addClass("hide");
                video.val("");
                video.rules("remove", "required");

            } else if (this.value == "video") {
                textGroup.removeClass("hide");
                textGroup.find('.font').addClass("hide");
                text.rules("remove", "required");

                imgGroup.removeClass("hide");
                img.rules("add", {required: true});

                videoGroup.removeClass("hide");
                video.rules("add", {required: true});
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
        //视频验证
        $("#video").change(function () {
            var videoUrl = $(this).val();
            message = "只允许上传：asx，asf，mpg，wmv，3gp，mp4，avi，flv格式的视频";
            permitFileType = ["asx", "asf", "mpg", "wmv", "3gp", "mp4", "avi", "flv"];
            if (videoUrl != "" && videoUrl != null) {
                $(this).rules("remove", "required");
                $(this).next(".error").css("display", "none");
            }
            var resultFlag = false;
            var fileType = videoUrl.substring(videoUrl.lastIndexOf(".") + 1);
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
