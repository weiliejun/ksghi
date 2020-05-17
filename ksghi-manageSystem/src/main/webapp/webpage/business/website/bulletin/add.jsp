<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增网站公告信息</title>
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
                <li><a href="${pageContext.request.contextPath}/business/websit/bulletin/list">网站公告管理</a></li>
                <li class="active">新增网站公告信息</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>新增网站公告信息</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/website/bulletin/add/save"
                          ENCTYPE="multipart/form-data">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>网站公告信息
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>类别：</label>
                                    <div class="col-md-3">
                                        <itech:code property="type" code="bulletin.type" type="radio"
                                                    defaultValue="system"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>标题：</label>
                                    <div class="col-md-9 topic">
                                        <input name="topic" size="50" maxlength="160" type="text" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">关键字（keywords）：</label>
                                    <div class="col-md-9 topic">
                                        <input name="keywords" size="100" maxlength="100" type="text"
                                               class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">描述（description）：</label>
                                    <div class="col-md-9">
                                        <textarea name="description" class="form-control"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">内容：</label>
                                    <div class="col-md-9">
                                        <script id="editorContent" type="text/plain"
                                                style="width: 1024px; height: 500px;"></script>
                                        <
                                        input
                                        type = "hidden"
                                        name = "content"
                                        id = "content" / >

                                            < !--
                                            < textarea
                                        name = "content"
                                        class
                                        = "form-control" >
                                            ${bulletin.content }
                                            < /textarea>
                                        -- >
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
                                            <itech:code property="publishStatus" code="publishStatus" type="radio" defaultValue="issue" />
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "form-group" >
                                            < label
                                        class
                                        = "col-md-2 control-label" > < font
                                        color = "red" > * < /font>角色类型：</
                                        label >
                                        < div
                                        class
                                        = "col-md-9" >
                                            <itech:code property="roleType" code="roleType" type="checkbox" value="${roleType}" />
                                            < /div>
                                            < /div>
                                            < div
                                        class
                                        = "form-group" >
                                            < label
                                        class
                                        = "col-md-2 control-label" > < font
                                        color = "red" > * < /font>序号：</
                                        label >
                                        < div
                                        class
                                        = "col-md-9 topic" >
                                            < input
                                        name = "sequnum"
                                        size = "50"
                                        maxlength = "160"
                                        type = "text"
                                        class
                                        = "form-control" / >
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
                                        //实例化编辑器
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        var ue = UE.getEditor('editor');
                                        var ue = UE.getEditor('editorContent');


                                        $("textarea[name='content']").redactor({
                                            imageUpload: '${pageContext.request.contextPath}/portal/file/upload'
                                        });

                                        $().ready(function () {
                                            var searchFormValidate = $("#searchForm").validate({
                                                rules: {
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
                                                    sequnum: {
                                                        required: true,
                                                        digits: true,
                                                        max: 10000
                                                    },
                                                    roleType: {
                                                        required: true
                                                    }
                                                }
                                            });
                                            $("#saveButton").click(function () {
                                                if (searchFormValidate.form()) {
                                                    $("#content").val(UE.getEditor('editorContent').getContent());
                                                    $("#searchForm").submit();
                                                }
                                            });
                                        });
                                        </script>
</html>
