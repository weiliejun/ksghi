<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>修改问题分类</title>
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
                <li>问答管理</li>
                <li class="active">修改问题分类</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>修改问题分类</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post" role="form">
                        <input type="hidden" id="categoryId" name="categoryId" value="${problemCategory.id}">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>分类信息
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>分类名称：</label>
                                    <div class="col-md-6">
                                        <input name="name" size="30" type="text" class="form-control"
                                               value="${problemCategory.name }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>父类：</label>
                                    <div class="col-md-4">
                                        <select id="parentId" name="parentId" class="form-control">
                                            <option value="0">版块根结点</option>
                                            <c:forEach var="category" items="${categoryList}">
                                                <option value="${category.ID}">
                                                    &nbsp;&nbsp;&nbsp;&nbsp;${category.NAME}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>分类顺序：</label>
                                    <div class="col-md-2">
                                        <input name="sequnum" id="sequnum" size="30" type="text" class="form-control"
                                               value="${problemCategory.sequnum}" maxlength="15"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">描述：</label>
                                    <div class="col-md-8">
                                        <textarea id="description" name="description" rows="10" cols="100"
                                                  maxlength="330">${problemCategory.description }</textarea>
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
    $(function () {
        $("#parentId").val("${problemCategory.parentId}");
    });
    var searchFormValidate = $("#searchForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                maxlength: 20
            },
            description: {
                maxlength: 330
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
        var categoryId = $("#categoryId").val();
        var name = $("input[name='name']").val();
        var parentId = $("#parentId").val();
        var sequnum = $("input[name='sequnum']").val();
        var description = $("#description").text();
        if (searchFormValidate.form()) {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/business/website/problem/category/edit/save",
                dataType: "html",
                data: {
                    "categoryId": categoryId,
                    "name": name,
                    "parentId": parentId,
                    "sequnum": sequnum,
                    "description": description
                },
                success: function (data) {
                    if (data == "success") {
                        bootbox.alert("修改成功");
                        window.location.href = "${pageContext.request.contextPath}/business/website/problem/category/list";
                    } else if (data == "haveProblem") {
                        bootbox.alert("该分类下有问题，不能将其更改为版块根节点！");
                    } else if (data == "haveSubCategories") {
                        bootbox.alert("该分类下有子分类，不能将其更改为子分类！");
                    }
                }
            });
        }
    });

</script>
</html>
