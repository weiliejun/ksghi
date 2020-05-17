<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增活动展示</title>
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
                <li class="active">新增活动展示</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>新增活动展示</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/website/activityzone/add/save" role="form"
                          ENCTYPE="multipart/form-data">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>新增活动展示
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group ">
                                    <label class="col-md-2 control-label"><font color="red">*</font>活动名称：</label>
                                    <div class="col-md-4">
                                        <input name="name" id="name" type="text" class="form-control" maxlength="50"/>
                                    </div>
                                </div>
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
                                    <label class="col-md-2 control-label"><font color="red">*</font>是否有时间限制：</label>
                                    <div class="col-md-9" id="timer">
                                        <itech:code property="isTimeLimit" code="istimelimit" type="radio"
                                                    defaultValue="no"/>
                                    </div>
                                </div>
                                <div class="form-group hide" id="imgGroup">
                                    <div class="form-group" id="timediv">
                                        <label class="col-md-2 control-label">活动时间：</label>
                                        <div class="input-group col-md-3" style="padding-left: 20px">
                                            <span class="input-group-addon"><i class="icon-calendar"></i></span> <input
                                                id="dateRange" name="dateRange" size="30" type="text"
                                                class="form-control" readonly="readonly" value="${dateRange}"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group" id="statusGroup">
                                    <label class="col-md-2 control-label"><font color="red">*</font>活动状态：</label>
                                    <div class="col-md-9">
                                        <itech:code property="status" code="activitystatus" type="radio"
                                                    defaultValue="issue"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>是否置顶：</label>
                                    <div class="col-md-9">
                                        <itech:code property="isPlacedTop" code="activityistop" type="radio"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>活动说明：</label>
                                    <div class="col-md-9">
                                        <textarea class="form-control" rows="3" name="description"
                                                  maxlength="1100"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>活动链接URL：</label>
                                    <div class="col-md-4">
                                        <input name="activityUrl" type="text" class="form-control" maxlength="120"/>
                                    </div>
                                </div>
                                <div class="form-group" id="imgGroup">
                                    <label class="col-md-2 control-label"><font color="red">*</font>上传图片：</label>
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
                        <div class="col-sm-offset-6 col-sm-12"></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>


<script type="text/javascript">
    $(document).ready(function () {
        $('#dateRange').daterangepicker();

    });
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
                isTimeLimit: {required: true, maxlength: 100},
                status: {required: true, maxlength: 120},
                description: {required: true, maxlength: 200},
                dateRange: {required: true},
                isPlacedTop: {required: true, maxlength: 50},
                activityUrl: {required: true, maxlength: 200},

                pictureFile: {maxlength: 330},
                startDate: {
                    required: true,
                    maxlength: 20
                },
                endDate: {
                    required: true,
                    maxlength: 20
                }
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
                    if (!codeIsExist)
                        $("#searchForm").submit();
                }
            } else {
                codeIsExistDiv.css("color", "red");
                codeIsExistDiv.text("编码包含非法字符");
                codeIsExistDiv.show();
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

    //展现方式
    var textGroup = $("#textGroup");
    var imgGroup = $("#imgGroup");
    var statusGroup = $("#statusGroup");
    var text = textGroup.find("textarea");
    var img = imgGroup.find("input");
    var status = statusGroup.find("input");
    $("#timer :radio").click(function () {
        if (this.value == "yes") {
            textGroup.addClass("hide");
            text.val("");
            imgGroup.removeClass("hide");
            statusGroup.addClass("hide");
            text.rules("remove", "required");
            img.rules("add", {required: true});
            status.rules("remove", {required: true});
        } else if (this.value == "no") {
            textGroup.removeClass("hide");
            imgGroup.addClass("hide");
            statusGroup.removeClass("hide");
            img.val("");
            status.val("");
            text.rules("add", {required: true, maxlength: 1000});
            img.rules("remove", "required");
            status.rules("add", "required");
        } else {

        }
    });

</script>
</html>
