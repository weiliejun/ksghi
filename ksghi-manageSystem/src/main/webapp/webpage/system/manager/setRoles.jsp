<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>设置管理员权限</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/ztree.jsp" %>
    <%@ include file="/webpage/common/plugins/multiselect.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统管理</li>
                <li>管理员权限管理</li>
                <li><a href="${pageContext.request.contextPath}/system/manager/list?restore=true">管理员管理</a></li>
                <li class="active">设置管理员权限</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>设置管理员权限</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/system/manager/setroles/save" role="form">
                        <input type="hidden" id="id" name="id" value="${manager.id}"/>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>管理员权限信息
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label">管理员账号：</label>
                                    <div class="col-md-4">
                                        <input class="form-control" id="code" name="code" size="30" type="text"
                                               value="${manager.code}" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">管理员姓名：</label>
                                    <div class="col-md-4">
                                        <input class="form-control" id="name" name="name" size="30" type="text"
                                               value="${manager.name}" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">管理员角色设置：</label>
                                    <div class="col-md-9">
                                        <select multiple name="allRoles" id="allRoles" class="form-control">
                                            <c:forEach var="role" items="${allRoles}">
                                                <c:if test="${role.id!=null}">
                                                    <option value="${role.id}">${role.name}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select> <select multiple name="roles" id="roles" class="form-control">
                                        <c:forEach var="role" items="${managerRoles}">
                                            <option value="${role.id}">${role.name}</option>
                                        </c:forEach>
                                    </select>
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
    $(document).ready(function () {
        $("#saveButton").click(function () {
            $("#roles option").each(function () {
                $(this).attr("selected", "selected");//打勾
            });
            $("#searchForm").submit();
        });
        createMovableOptions("allRoles", "roles", 600, 180, '所有系统角色', '已选择的系统角色');
    });
</script>
</html>
