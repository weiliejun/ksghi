<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增论坛版块</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/ztree.jsp" %>
    <%@ include file="/webpage/common/plugins/multiselect.jsp" %>
</head>

<body>
<div id="wrapper">

    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>论坛管理</li>
                <li class="active">新增论坛版块</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>新增论坛版块</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/website/forum/save" role="form"
                          enctype="multipart/form-data">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>版块信息
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>版块名称：</label>
                                    <div class="col-md-6">
                                        <input name="name" size="30" type="text" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">父类：</label>
                                    <div class="col-md-4">
                                        <select id="parentId" name="parentId" class="form-control">
                                            <option value="0">版块根结点</option>
                                            <c:forEach var="forum" items="${forumList}">
                                                <option value="${forum.id}">
                                                    &nbsp;&nbsp;&nbsp;&nbsp;${forum.name }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>版块顺序：</label>
                                    <div class="col-md-2">
                                        <input name="sequnum" id="sequnum" size="30" type="text" class="form-control"
                                               value="${sequnum}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">版块logo：</label>
                                    <div class="col-md-4">
                                        <input name="logoFile" id="logoFile" type="file"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">编码：</label>
                                    <div class="col-md-2">
                                        <input id="code" name="code" type="text" class="form-control"/><span
                                            class="code-span"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">简介：</label>
                                    <div class="col-md-8">
                                        <textarea id="description" name="description" rows="10" cols="100"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-2 col-md-10">
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
    $().ready(function () {
        var searchFormValidate = $("#searchForm").validate({
            rules: {
                name: {
                    required: true,
                    minlength: 2,
                    maxlength: 50
                },
                description: {
                    maxlength: 330
                },
                sequnum: {
                    required: true,
                    digits: true,
                    max: 99999,
                    min: 0
                },
                code: {
                    maxlength: 30
                }
            }
        });
        $("#saveButton").click(function () {
            var codeVali = ajaxCheckCode();
            if (codeVali && searchFormValidate.form()) {
                $("#searchForm").submit();
            }
        });
    });

    function ajaxCheckCode() {
        var codeValidate = false;
        $.ajax({
            type: "POST",
            data: {code: $("#code").val()},
            url: "${pageContext.request.contextPath}/business/website/forum/checkcode",
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.flag == "true") {
                    $('.code-span').css("color", "red");
                    $('.code-span').html("该编码已存在！");
                } else {
                    codeValidate = true;
                }
            }
        });
        return codeValidate;
    }
</script>
</html>
