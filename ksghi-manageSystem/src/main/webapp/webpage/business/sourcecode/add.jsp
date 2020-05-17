<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增用户来源</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/ztree.jsp" %>
    <%@ include file="/webpage/common/plugins/multiselect.jsp" %>
</head>

<body>
<div id="wrapper">

    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>运营管理</li>
                <li>用户来源管理</li>
                <li class="active">新增用户来源信息</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>新增用户来源信息</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/sourcecode/save" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>用户来源
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i
                                            class="icons-mark-required"></i>用户来源网站</label>
                                    <div class="col-md-3">
                                        <input id="sourceWebsite" name="sourceWebsite" size="30" type="text"
                                               class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i
                                            class="icons-mark-required"></i>用户来源名称</label>
                                    <div class="col-md-3">
                                        <input id="sourceName" name="sourceName" size="30" type="text"
                                               class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i
                                            class="icons-mark-required"></i>用户来源code</label>
                                    <div class="col-md-3">
                                        <input id="sourceCode" name="sourceCode" size="30" type="text"
                                               class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><i class="icons-mark-required"></i>状态：</label>
                                    <div class="col-md-10">
                                        <itech:code property="status" code="advertise.status" type="radio"
                                                    defaultValue="unable"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">备注</label>
                                    <div class="col-md-8">
                                        <textarea name="remark" class="form-control" rows="3"></textarea>
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
                sourceWebsite: {
                    required: true,
                    maxlength: 50
                },
                sourceName: {
                    required: true,
                    maxlength: 50
                },
                sourceCode: {
                    required: true,
                    maxlength: 20,
                    remote: {
                        cache: false,
                        async: false,
                        type: 'post',
                        url: '${pageContext.request.contextPath}/business/sourcecode/validate/soucecode?data=' + new Date(),
                        data: {
                            'code': function () {
                                return $("#sourceCode").val();
                            },
                            'id': function () {
                                return $("#id").val();
                            }
                        }
                    }
                },
                remark: {
                    maxlength: 2000
                }
            },

            messages: {
                sourceWebsite: {
                    required: '请输入用户来源网站',
                    maxlength: '用户来源网站不能超过50字'
                },
                sourceName: {
                    required: '请输入用户来源名称',
                    maxlength: '用户来源名称不能超过50字'
                },
                sourceCode: {
                    required: '请输入用户来源code',
                    maxlength: '用户来源code不能超过20位',
                    remote: '用户来源code已存在'
                },
                remark: {
                    maxlength: '备注信息不能超过2000字'
                }
            }

        });

        $("#saveButton").click(function () {
            if (searchFormValidate.form) {
                $("#searchForm").submit();
            }
        });

    });

</script>
</html>
