<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>修改论坛贴子</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/ztree.jsp" %>
    <%@ include file="/webpage/common/plugins/multiselect.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
</head>

<body>
<div id="wrapper">

    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>论坛管理</li>
                <li class="active">修改论坛贴子</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>修改论坛贴子</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/website/forum/post/edit/save" role="form"
                          enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${forumPosts.id }">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>贴子信息
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><font color="red">*</font>标题：</label>
                                    <div class="col-md-9">
                                        <input name="topic" size="30" type="text" class="form-control"
                                               value="${forumPosts.topic }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">报道内容：</label>
                                    <div class="col-md-9">
                                        <textarea id="content" name="content" class="form-control"
                                                  maxlength="1300">${forumPosts.content }</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">贴子状态：</label>
                                    <div class="col-md-9">
                                        <itech:code property="status" code="status" type="radio"
                                                    value="${forumPosts.status}"/>
                                        <p class="help-block">注：无效状态时，该信息将在网站端不进行显示.</p>
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

    $("textarea[name='content']").redactor({
        imageUpload: true
    });


    $().ready(function () {
        var searchFormValidate = $("#searchForm").validate({
            rules: {
                topic: {
                    required: true,
                    minlength: 2,
                    maxlength: 30
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
