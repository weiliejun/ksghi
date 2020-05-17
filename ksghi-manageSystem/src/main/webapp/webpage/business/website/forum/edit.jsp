<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>修改论坛版块</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">

    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>论坛管理</li>
                <li class="active">修改论坛版块</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>修改论坛版块</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/website/forum/edit/save" role="form"
                          enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${forum.id }">
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
                                        <input name="name" size="30" type="text" class="form-control"
                                               value="${forum.name }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">父类：</label>
                                    <div class="col-md-4">
                                        <select id="parentId" name="parentId" onchange="getSequnum(this.value)"
                                                class="form-control">
                                            <c:if test="${flagShow=='true' }">
                                                <option value="0">版块根结点</option>
                                            </c:if>
                                            <c:forEach var="currentForum" items="${forumList}">
                                                <c:if test="${currentForum.id == forum.parentId}">
                                                    <option value="${currentForum.id}" selected>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;${currentForum.name }</option>
                                                </c:if>
                                                <c:if test="${currentForum.id != forum.parentId}">
                                                    <option value="${currentForum.id}">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;${currentForum.name }</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>版块顺序：</label>
                                    <div class="col-md-2">
                                        <input name="sequnum" id="sequnum" size="30" type="text" class="form-control"
                                               value="${forum.sequnum}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">版块logo：</label>
                                    <div class="col-md-6" id="showPic" style="display: block">
                                        <c:if test="${forum.logo!=null}">
                                            <a href="${pageContext.request.contextPath}${forum.logo}" target="_blank">查看图片</a>
                                            <a onclick="javascript:reUpload()">重新上传</a>
                                        </c:if>
                                        <c:if test="${forum.logo==null}">
                                            <input name="logoFile" id="logoFile" type="file"/>
                                        </c:if>
                                    </div>
                                    <div class="col-md-4" id="upPic" style="display: none">
                                        <input name="logoFile" id="logoFile" type="file"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">编码：</label>
                                    <div class="col-md-2">
                                        <input name="code" id="code" type="text" class="form-control"
                                               value="${forum.code }"/><span class="code-span"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">简介：</label>
                                    <div class="col-md-8">
                                        <textarea id="description" name="description" rows="10"
                                                  cols="100">${forum.description }</textarea>
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
    function reUpload() {
        $("#showPic").hide();
        $("#upPic").show();
    }

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

    function getSequnum(id) {
        jQuery.ajax({
            type: "GET",
            url: '${pageContext.request.contextPath}/business/website/forum/getsequnum/' + id,
            dataType: 'html',
            success: function (data) {
                $("#sequnum").val(data);
            }
        });
    }

    function ajaxCheckCode() {
        var codeValidate = false;
        if ($("#code").val() != '${forum.code }') {
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
        } else {
            codeValidate = true;
        }
        return codeValidate;
    }
</script>

</html>
