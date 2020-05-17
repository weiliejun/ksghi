<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增媒体报道</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
    <%@ include file="/webpage/common/commoneditor.jsp" %>
</head>

<body>
<div id="wrapper">

    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>信息发布管理</li>
                <li><a href="${pageContext.request.contextPath}/business/websit/news/list">媒体报道管理</a></li>
                <li class="active">新增媒体报道信息</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>新增媒体报道信息</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/website/news/edit/save" role="form"
                          ENCTYPE="multipart/form-data">
                        <input type="hidden" name="id" value="${id }"/>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>媒体报道信息
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>类型：</label>
                                    <div class="col-md-9 topic">
                                        <itech:code type="radio" code="news.type" property="type"
                                                    value="${news.type }"></itech:code>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>所属频道：</label>
                                    <div class="col-md-9 topic">
                                        <itech:code type="checkbox" code="news.channel" property="channel"
                                                    value="${news.channel }"></itech:code>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>标题：</label>
                                    <div class="col-md-9 topic">
                                        <input name="topic" size="500" type="text" class="form-control"
                                               value="${news.topic }" maxlength="160"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">关键字（keywords）：</label>
                                    <div class="col-md-9 topic">
                                        <input name="keywords" size="100" type="text" class="form-control"
                                               value="${news.keywords }" maxlength="100"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">描述（description）：</label>
                                    <div class="col-md-9 topic">
                                        <textarea name="description"
                                                  class="form-control"> ${news.description }</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">报道内容：</label>
                                    <div class="col-md-9">
                                        <%-- 	<textarea name="content" class="form-control">
                                     ${news.content }
                                </textarea> --%>
                                        <script id="editor" type="text/plain"
                                                style="width: 1024px; height: 500px;"> ${news.content }</script>
                                        <
                                        input
                                        type = "hidden"
                                        name = "content"
                                        id = "content" / >
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "form-group" >
                                            < label
                                        class
                                        = "col-md-2 control-label" > 作者：<
                                        /label>
                                        < div
                                        class
                                        = "col-md-4" >
                                            < input
                                        name = "author"
                                        size = "50"
                                        type = "text"
                                        class
                                        = "form-control"
                                        value = "${news.author }" / >
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "form-group" >
                                            < label
                                        class
                                        = "col-md-2 control-label" > 来源：<
                                        /label>
                                        < div
                                        class
                                        = "col-md-9" >
                                            < input
                                        name = "source"
                                        size = "200"
                                        type = "text"
                                        class
                                        = "form-control"
                                        value = "${news.source }" / >
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "form-group" >
                                            < label
                                        class
                                        = "col-md-2 control-label" > < font
                                        color = "red" > * < /font>来源Logo类型：</
                                        label >
                                        < div
                                        class
                                        = "col-md-9" >
                                            <itech:code type="radio" code="news.logoType" property="logoType" value="${news.logoType }"></itech:code>
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "form-group" >
                                            < label
                                        class
                                        = "col-md-2 control-label" > 来源Logo图片：<
                                        /label>
                                        < div
                                        class
                                        = "col-md-9"
                                        id = "showFile"
                                        style = "display: block" >
                                            <c:if test="${news.sourceLogo!=null }">
                                            < a
                                        href = "${pictureServerURL}${news.sourceLogo }"
                                        target = "_blank" > 查看图片 < /a>
                                            </c:if>
                                            < a
                                        onclick = "javascript:reUpload($('#uploadFile'),$('#showFile'))" > 重新上传 < /a>
                                            < /div>
                                            < div
                                        class
                                        = "col-md-9"
                                        id = "uploadFile"
                                        style = "display: none" >
                                            < input
                                        class
                                        = "input-file"
                                        type = "file"
                                        id = "sourceLogo"
                                        name = "sourceLogoFile"
                                        onchange = "fileTypeJudge(this);" / >
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "form-group"
                                        id = "videoUrlDiv"
                                        style = "display: none" >
                                            < label
                                        class
                                        = "col-md-2 control-label" > 来源Logo视频：<
                                        /label>
                                        < div
                                        class
                                        = "col-md-9"
                                        id = "showVideo" >
                                            <c:if test="${news.videoUrl!=null }">
                                            < video
                                        width = "250px"
                                        height = "190px"
                                        style = "background-color: #000;"
                                        src = "${pictureServerURL}${news.videoUrl }"
                                        class
                                        = "video"
                                        controls = "controls"
                                        poster = "${pictureServerURL}${news.videoUrl }" > < /video>
                                            </c:if>
                                            < a
                                        onclick = "javascript:reUpload($('#uploadVideo'),$('#showVideo'))" > 重新上传 < /a>
                                            < /div>
                                            < div
                                        class
                                        = "col-md-9"
                                        id = "uploadVideo"
                                        style = "display: none" >
                                            < input
                                        class
                                        = "input-file"
                                        type = "file"
                                        id = "videoUrl"
                                        name = "videoFile" / >
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "form-group" >
                                            < label
                                        class
                                        = "col-md-2 control-label" > 来源Url：<
                                        /label>
                                        < div
                                        class
                                        = "col-md-9" >
                                            < input
                                        name = "sourceUrl"
                                        size = "1000"
                                        type = "text"
                                        class
                                        = "form-control"
                                        value = "${news.sourceUrl }"
                                        placeholder = "如：http://www.wjk.com" / >
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "form-group" >
                                            < label
                                        class
                                        = "col-md-2 control-label" > < font
                                        color = "red" > * < /font>报道日期：</
                                        label >
                                        < div
                                        class
                                        = "col-md-4" >
                                            < div
                                        class
                                        = "input-group" >
                                            < span
                                        class
                                        = "input-group-addon" > < i
                                        class
                                        = "icon-calendar" > < /i></s
                                        pan > < input
                                        id = "reportDate"
                                        name = "reportDate"
                                        type = "text"
                                        class
                                        = "form-control"
                                        readonly = "readonly"
                                        value = "${news.reportDate }" / >
                                            < /div>
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "form-group" >
                                            < label
                                        class
                                        = "col-md-2 control-label" > < font
                                        color = "red" > * < /font>发布状态：</
                                        label >
                                        < div
                                        class
                                        = "col-md-9" >
                                            <itech:code property="publishStatus" code="publishStatus" type="radio" defaultValue="issue" value="${news.publishStatus }" />
                                            < /div>
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "panel-footer" >
                                            < div
                                        class
                                        = "form-group" >
                                            < div
                                        class
                                        = "col-md-offset-2 col-md-9" >
                                            < button
                                        id = "saveButton"
                                        type = "button"
                                        class
                                        = "btn btn-primary" >
                                            < i
                                        class
                                        = "icon-disk" > < /i>保存
                                            < /button>
                                            < button
                                        onclick = "javascript:history.go(-1);"
                                        type = "button"
                                        class
                                        = "btn btn-primary" >
                                            < i
                                        class
                                        = "icon-undo2" > < /i>取消
                                            < /button>
                                            < /div>
                                            < /div>
                                            < /div>
                                            < /div>
                                            < /form>
                                            < div
                                        class
                                        = "col-sm-offset-6 col-sm-12" > < /div>
                                            < /div>
                                            < /div>
                                            < /div>
                                            < /div>
                                            <!-- page content end -->
                                            < /div>
                                            < /body>


                                            < script
                                        type = "text/javascript" >
                                            //中文字两个字节
                                            jQuery.validator.addMethod("videoValidator", function (value, element) {
                                                var videoUrl = value;
                                                permitFileType = ["asx", "asf", "mpg", "wmv", "3gp", "mp4", "avi", "flv"];
                                                if (videoUrl != "" && videoUrl != null) {
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
                                                return resultFlag;
                                            }, $.validator.format("只允许上传：asx，asf，mpg，wmv，3gp，mp4，avi，flv格式的视频"));

                                        //视频验证
                                        $("input[name='logoType']").bind('click', function () {
                                            var logoType = $("input[name='logoType']:checked").val();
                                            if (logoType == 'video') {
                                                $('#videoUrlDiv').show();
                                                $('#videoUrl').rules("add", "videoValidator");
                                            } else {
                                                $('#videoUrlDiv').hide();
                                                $('#videoUrl').rules("remove", "videoValidator");
                                            }

                                        });
                                        //实例化编辑器
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        var ue = UE.getEditor('editor');

                                        $("input[name='reportDate']").datepicker({
                                            format: 'yyyy-mm-dd',
                                        });

                                        function reUpload(show, hide) {
                                            hide.hide();
                                            show.show();
                                            var display = $('#uploadVideo').css('display');
                                            if (display != undefined && display == 'block') {
                                                $('#videoUrl').rules("add", "videoValidator");
                                            }
                                        }

                                        function fileTypeJudge(_this) {
                                            message = "只允许上传：";
                                            var permitFileType = ["jpg", "jpeg", "png"];
                                            var fileType = $(_this).val().substring($(_this).val().indexOf(".") + 1);
                                            var resultFlag = false;
                                            (function () {
                                                var type = typeof fileType;
                                                if (type == "string") {
                                                    $.each(permitFileType, function (i, n) {
                                                        message += n + (i < permitFileType.length - 1 ? ',' : '');
                                                        if (fileType.toLowerCase() == n) {
                                                            resultFlag = true;
                                                            return;
                                                        }
                                                    });
                                                }
                                                message += "格式！";
                                                return;
                                            })();
                                            if (!resultFlag) {
                                                $(_this).val('');
                                                bootbox.alert(message);
                                            }
                                        }

                                        $().ready(function () {
                                            var logoType = $("input[name='logoType']:checked").val();
                                            if ('video' == logoType) {
                                                $('#videoUrlDiv').show();
                                            }
                                            var redactor = $("textarea[name='content']").redactor({
                                                imageUpload: '${pageContext.request.contextPath}/portal/file/upload'
                                            });
                                            var searchFormValidate = $("#searchForm").validate({
                                                rules: {
                                                    type: {
                                                        required: true
                                                    },
                                                    channel: {
                                                        required: true
                                                    },
                                                    topic: {
                                                        required: true,
                                                        minlength: 2,
                                                        maxlength: 160
                                                    },
                                                    keywords: {
                                                        maxlength: 100
                                                    },
                                                    description: {
                                                        maxlength: 140
                                                    },
                                                    author: {
                                                        maxlength: 16
                                                    },
                                                    source: {
                                                        maxlength: 65
                                                    },
                                                    sourceUrl: {
                                                        maxlength: 330
                                                    },
                                                    reportDate: {
                                                        required: true,
                                                        maxlength: 10
                                                    },
                                                    sourceLogo: {
                                                        required: true
                                                    },
                                                    logoType: {
                                                        required: true
                                                    }
                                                }
                                            });
                                            $("#saveButton").click(function () {
                                                if (searchFormValidate.form()) {
                                                    /* if(redactor.isEmpty()) {
                                                        bootbox.alert("报道内容必填项");
                                                        return false;
                                                    }
                                                    redactor.sync; */
                                                    $("#content").val(UE.getEditor('editor').getContent());
                                                    $("#searchForm").submit();
                                                    $(this).button('loading');
                                                }
                                            });
                                        });
                                        </script>
</html>
