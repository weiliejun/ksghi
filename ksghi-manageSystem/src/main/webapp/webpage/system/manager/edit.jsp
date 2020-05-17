<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>修改管理员权限</title>
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
                <li class="active">修改管理员信息</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>修改管理员信息</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/system/manager/edit/save" role="form">
                        <input type="hidden" id="id" name="id" value="${manager.id}"/>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>管理员信息
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i
                                            class="icons-mark-required"></i>管理员账号：</label>
                                    <div class="col-md-3">
                                        <input id="code" name="code" size="30" type="text" class="form-control"
                                               value="${manager.code}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i class="icons-mark-required"></i>手机：</label>
                                    <div class="col-md-3">
                                        <input id="mobile" name="mobile" type="text" class="form-control"
                                               value="${manager.mobile }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i class="icons-mark-required"></i>邮箱：</label>
                                    <div class="col-md-3">
                                        <input id="email" name="email" type="text" class="form-control"
                                               value="${manager.email }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i
                                            class="icons-mark-required"></i>管理员状态：</label>
                                    <div class="col-md-10">
                                        <itech:code property="status" code="status" type="radio"
                                                    value="${manager.status}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i
                                            class="icons-mark-required"></i>管理员姓名：</label>
                                    <div class="col-md-3">
                                        <input name="name" size="30" type="text" class="form-control"
                                               value="${manager.name}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i
                                            class="icons-mark-required"></i>职责描述：</label>
                                    <div class="col-md-8">
                                        <input name="duty" size="30" type="text" class="form-control"
                                               value="${manager.duty}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">备注：</label>
                                    <div class="col-md-8">
                                        <textarea name="remark" class="form-control"
                                                  rows="3">${manager.remark}</textarea>
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
                code: {
                    required: true,
                    minlength: 2,
                    maxlength: 30
                },
                name: {
                    required: true,
                    minlength: 2,
                    maxlength: 30
                },
                duty: {
                    required: true,
                    maxlength: 1000
                },
                remark: {
                    maxlength: 1000
                },
                mobile: {
                    required: true,
                    maxlength: 11,
                    isMobile: true
                },
                email: {
                    required: true,
                    email: true,
                    maxlength: 60
                }
            }
        });
        $("#saveButton").click(function () {
            if (searchFormValidate.form()) {
                jQuery.ajax({
                    type: "POST",
                    url: '${pageContext.request.contextPath}/system/manager/isexit/' + $("#code").val() + "?managerId=" + $("#id").val(),
                    success: function (data) {
                        if (data.flag == "true") {
                            bootbox.alert('您输入的管理员账号已被占用，请核对.', null);
                        } else if (data.flag == "false") {
                            $("#searchForm").submit();
                        }
                    }
                });
            }
        });
    });
</script>
</html>
