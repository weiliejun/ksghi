<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>角色管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统管理</li>
                <li>管理员权限管理</li>
                <li class="active">角色管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>角色列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form name="roleForm" action="${pageContext.request.contextPath}/system/authority/role/list"
                          role="form">
                        <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean" stateAttr="restore">
                            <table:htmlTable width="100%">
                                <table:htmlRow sortable="true" filterable="false">
                                    <table:htmlColumn property="name" title="角色名称" width="15%"/>
                                    <table:htmlColumn property="description" title="角色描述" width="55%"/>
                                    <table:htmlColumn property="status" title="有效状态" width="15%">
                                        <itech:code code="status" type="text" value="${bean.status}"/>
                                    </table:htmlColumn>
                                    <table:htmlColumn title="数据操作" width="15%" sortable="false">
                                        <a href="${pageContext.request.contextPath}/system/authority/role/edit/${bean.id}"
                                           title="修改角色"><i class="icon-pencil"></i></a>
                                        <a href="javascript:deleteData('${bean.id}')" title="删除角色"><i
                                                class="icon-remove2"></i></a>
                                    </table:htmlColumn>
                                </table:htmlRow>
                            </table:htmlTable>
                        </table:tableModel>
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
                    <a href="${pageContext.request.contextPath}/system/authority/role/add" class="btn btn-primary"><i
                            class="icon-plus"></i>新增角色</a>
                </div>
            </div>

        </div>
    </div>
    <!-- page content end -->
</div>
</body>

<script type="text/javascript">
    function deleteData(id) {
        bootbox.confirm('您确定要删除该条数据吗？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/system/authority/role/delete/' + id;
            }
        });
    }
</script>
</html>
