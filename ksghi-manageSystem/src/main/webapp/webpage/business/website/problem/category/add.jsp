<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增问题分类</title>
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
                <li class="active">新增问题分类</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>新增问题分类</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/website/problem/category/save"
                          role="form">
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
                                        <input name="name" size="30" type="text" class="form-control" maxlength="10"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>父类：</label>
                                    <div class="col-md-4">
                                        <select id="parentId" name="parentId" class="form-control">
                                            <option value="0">版块根结点</option>
                                            <c:forEach var="category" items="${categoryList}">
                                                <option value="${category.ID}">
                                                    &nbsp;&nbsp;&nbsp;&nbsp;${category.NAME }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>分类顺序：</label>
                                    <div class="col-md-2">
                                        <input name="sequnum" id="sequnum" size="30" type="text" class="form-control"
                                               value="${sequnum}" maxlength="15"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">描述：</label>
                                    <div class="col-md-8">
                                        <textarea id="description" name="description" rows="10" cols="100"
                                                  maxlength="330"></textarea>
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
                }
            }
        });
        $("#saveButton").click(function () {
            if (searchFormValidate.form()) {
                $("#searchForm").submit();
            }
        });
    });

</script>
</html>
