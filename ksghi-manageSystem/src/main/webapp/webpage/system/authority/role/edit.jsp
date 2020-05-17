<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>修改角色</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/ztree.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统管理</li>
                <li>管理员权限管理</li>
                <li><a href="${pageContext.request.contextPath}/system/authority/role/list?restore=true">角色管理</a></li>
                <li class="active">修改角色信息</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>修改角色</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/system/authority/role/edit/save" role="form">
                        <input type="hidden" id="id" name="id" value="${role.id}"/> <input type="hidden"
                                                                                           id="functionCodes"
                                                                                           name="functionCodes"
                                                                                           value=""/>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>角色信息
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i
                                            class="icons-mark-required"></i>角色名称：</label>
                                    <div class="col-md-6">
                                        <input name="name" size="30" type="text" class="form-control"
                                               value="${role.name}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i
                                            class="icons-mark-required"></i>功能描述：</label>
                                    <div class="col-md-6">
                                        <textarea name="description" class="form-control"
                                                  rows="3">${role.description}</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i
                                            class="icons-mark-required"></i>是否有效：</label>
                                    <div class="col-md-6">
                                        <itech:code property="status" code="status" type="radio" defaultValue="valid"
                                                    value="${role.status}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">角色功能权限：</label>
                                    <div class="col-md-6">
                                        <ul id="functionTree" class="ztree"></ul>
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
                    required: true,
                    maxlength: 1000
                }
            }
        });
        $("#saveButton").click(function () {
            if (searchFormValidate.form()) {
                var functionCodes = getCheckFunctions();
                $("#functionCodes").val(functionCodes);
                $("#searchForm").submit();
            }
        });
    });

    var setting = {
        data: {
            simpleData: {
                enable: true
            }
        },
        check: {
            enable: true
        }
    };
    var zNodes = [${treeText}];

    function getCheckFunctions() {
        var zTree = $.fn.zTree.getZTreeObj("functionTree");
        var nodes = zTree.getCheckedNodes(true);
        var functions = "";
        for (var i = 0; i < nodes.length; i++) {
            functions += nodes[i].id + ",";
        }
        return functions;
    }

    $(document).ready(function () {
        $.fn.zTree.init($("#functionTree"), setting, zNodes);
    });
</script>
</html>
