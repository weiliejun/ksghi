<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增问题</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/ztree.jsp" %>
    <%@ include file="/webpage/common/plugins/multiselect.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
    <%@ include file="/webpage/common/commoneditor.jsp" %>
</head>

<body>
<div id="wrapper">

    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>问答管理</li>
                <li class="active">新增问题</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>新增问题</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/website/problem/save" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>问题信息
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>标题：</label>
                                    <div class="col-md-6">
                                        <input name="topic" size="30" type="text" class="form-control" maxlength="40"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>分类名称：</label>
                                    <div class="col-md-4">
                                        <select id="problemCategoryId" name="problemCategoryId" class="form-control">
                                            <option value="">请选择</option>
                                            <c:forEach var="category" items="${categoryList}">
                                                <option value="${category.ID}">
                                                    &nbsp;&nbsp;&nbsp;&nbsp;${category.NAME }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>角色类型：</label>
                                    <div class="col-md-9">
                                        <itech:code property="roleType" code="roleType" type="checkbox"
                                                    value="${roleType}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>问题顺序：</label>
                                    <div class="col-md-2">
                                        <input name="sequnum" id="sequnum" size="30" type="text" class="form-control"
                                               maxlength="10"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>问题答案：</label>
                                    <div class="col-md-9">
                                        <script id="editor" type="text/plain"
                                                style="width: 1024px; height: 500px;"></script>
                                        <
                                        input
                                        type = "hidden"
                                        name = "problemAnswer"
                                        id = "problemAnswer" / >
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
                                        = "col-md-2 control-label" > 编码：<
                                        /label>
                                        < div
                                        class
                                        = "col-md-4" >
                                            < input
                                        name = "code"
                                        size = "30"
                                        type = "text"
                                        class
                                        = "form-control"
                                        maxlength = "50" / > < span
                                        class
                                        = "code-span" > < /span>
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
                                        = "col-md-offset-2 col-md-10" >
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


                                        $("textarea[name='content']").redactor({
                                            imageUpload: '${pageContext.request.contextPath}/portal/file/upload'
                                        });
                                        $("textarea[name='problemAnswer']").redactor({
                                            imageUpload: '${pageContext.request.contextPath}/portal/file/upload'
                                        });
                                        $().ready(function () {
                                            var searchFormValidate = $("#searchForm").validate({
                                                rules: {
                                                    topic: {
                                                        required: true,
                                                        minlength: 2,
                                                        maxlength: 40
                                                    },
                                                    problemAnswer: {
                                                        required: true
                                                    },
                                                    problemCategoryId: {
                                                        required: true
                                                    },
                                                    roleType: {
                                                        required: true
                                                    },
                                                    code: {
                                                        maxlength: 50
                                                    },
                                                    sequnum: {
                                                        required: true,
                                                        digits: true,
                                                        max: 99999,
                                                        min: 0
                                                    }
                                                }
                                            });
                                            $("#saveButton").click(function () {
                                                var codeVali = ajaxCheckCode();
                                                if (searchFormValidate.form() && codeVali) {
                                                    $("#problemAnswer").val(UE.getEditor('editor').getContent());
                                                    $("#searchForm").submit();
                                                }
                                            });
                                        });

                                        function ajaxCheckCode() {
                                            var codeValidate = false;
                                            var code = $("input[name='code']").val();
                                            $.ajax({
                                                type: "POST",
                                                data: {code: code},
                                                url: "${pageContext.request.contextPath}/business/website/problem/checkcode",
                                                dataType: 'json',
                                                async: false,
                                                success: function (data) {
                                                    if (data.flag == "true") {
                                                        var message = data.exist;
                                                        $('.code-span').css("color", "red");
                                                        $('.code-span').html(message);
                                                    } else {
                                                        codeValidate = true;
                                                    }
                                                }
                                            });
                                            return codeValidate;
                                        }
                                        </script>
</html>
