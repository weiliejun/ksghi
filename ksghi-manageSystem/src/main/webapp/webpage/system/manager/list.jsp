<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>管理员管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/bootstrapmultiselect.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统管理</li>
                <li>管理员权限管理</li>
                <li class="active">管理员管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>管理员列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" name="roleForm"
                          action="${pageContext.request.contextPath}/system/manager/list" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-7">
                                    <div class="input-group">
                                        <span class="input-group-addon">管理员账号</span> <input class="form-control"
                                                                                            type="text" name="code"
                                                                                            value="${code}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-5">
                                    <div class="input-group">
                                        <span class="input-group-addon">管理员姓名</span> <input class="form-control"
                                                                                            type="text" name="name"
                                                                                            value="${name}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-5">
                                    <div class="input-group">
                                        <span class="input-group-addon">管理员状态</span>
                                        <itech:code property="status" code="dataStatus" type="select"
                                                    value="${status}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">拥有角色</span>
                                        <itech:code property="managerRole" code="managerRole" type="multiSelect"
                                                    value="" defaultValue="${managerRole}"/>
                                        <input type="hidden" name="managerRole" value=""/>
                                    </div>
                                </div>
                                <div class="form-group col-md-4 col-xs-6">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="myClearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="code" title="管理员账号" width="15%"/>
                                        <table:htmlColumn property="name" title="管理员姓名" width="15%"/>
                                        <table:htmlColumn property="roles" title="拥有角色" width="40%"/>
                                        <table:htmlColumn property="status" title="管理员状态" width="15%">
                                            <itech:code code="status" type="text" value="${bean.status}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn title="数据操作" width="15%" sortable="false">
                                            <a href="javascript:alterPassword('${bean.id}','${bean.name}')"
                                               title="重置密码"><i class="icon-key"></i></a>
                                            <a href="javascript:setRoles('${bean.id}')" title="设置权限"><i
                                                    class="icon-cog"></i></a>
                                            <a href="${pageContext.request.contextPath}/system/manager/edit/${bean.id}"
                                               title="修改管理员"><i class="icon-pencil"></i></a>
                                            <a href="javascript:deleteData('${bean.id}')" title="删除管理员"><i
                                                    class="icon-remove2"></i></a>
                                            <c:if test="${codeName==true && bean.lock==true}">
                                                <a href="javascript:removeLogin('${bean.code}')" title="解除登录锁定"><i
                                                        class="icon-unlocked"></i></a>
                                            </c:if>
                                        </table:htmlColumn>
                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                        </div>
                    </form>
                    <script type="text/javascript">
                        function onInvokeAction(id) {
                            $.jmesa.setExportToLimit(id, '');
                            $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
                        }
                    </script>
                </div>
                <div class="col-sm-offset-6 col-sm-12"></div>
            </div>
            <div class="row">
                <div class="col-md-offset-10 col-md-2">
                    <a href="${pageContext.request.contextPath}/system/manager/add" class="btn btn-primary"><i
                            class="icon-plus"></i>新增管理员</a>
                </div>
            </div>

        </div>
    </div>
    <!-- page content end -->
</div>

</body>

<script type="text/javascript">

    function setRoles(id) {
        window.location.href = '${pageContext.request.contextPath}/system/manager/setroles/' + id;
    }

    function alterPassword(id, name) {

        bootbox.confirm("您确定要重置管理员 '" + name + "' 密码吗？", function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/system/manager/alterpassword/' + id;
                return false;
            }
        });
    }

    function deleteData(id) {
        bootbox.confirm('您确定要取消该人员的管理员身份吗？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/system/manager/delete/' + id;
                return false;
            }
        });
    }

    function removeLogin(code) {
        bootbox.confirm('您确定要解除该人员的登录锁定吗？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/system/manager/remove/' + code;
                return false;
            }
        });
    }
</script>
</html>
