<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>处理客户留言</title>
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
                <li class="active">处理客户留言</li>
            </ul>
        </div>
    </div>
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>处理客户留言</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <form class="form-horizontal" id="searchForm" method="post"
                              action="${pageContext.request.contextPath}/business/website/problem/reply/edit/save"
                              role="form">
                            <div class="panel-body">
                                <fieldset>
                                    <legend>客户留言基本信息</legend>
                                    <c:if test="${reply.userInfoId!=null}">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">客户姓名：</label>
                                        <div class="col-md-6">
                                            <p class="form-control-static">
                                                    ${reply.name }&nbsp;&nbsp;&nbsp;&nbsp;<a class="view-details"
                                                                                             href="${pageContext.request.contextPath}/business/user/common/view/${reply.userInfoId }">详情信息</a>
                                            </p>
                                        </div>
                                        </c:if>
                                        <input type="hidden" name="id" value="${reply.id }">
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">客户性别：</label>
                                        <div class="col-md-6">
                                            <p class="form-control-static">
                                                <itech:code property="sex" code="sex" type="text" value="${reply.sex}"/>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">留言类型：</label>
                                        <div class="col-md-6">
                                            <p class="form-control-static">
                                                <itech:code property="type" code="problemReply.type" type="text"
                                                            value="${reply.type}"/>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">留言内容：</label>
                                        <div class="col-md-6">
                                            <p class="form-control-static">${reply.content }</p>
                                        </div>
                                    </div>

                                </fieldset>
                                <fieldset>
                                    <legend>反馈内容</legend>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">回复类型：</label>
                                        <div class="col-md-6">
                                            <p class="form-control-static">
                                                <itech:code property="replyType" code="problemReply.replyType"
                                                            type="text" value="${reply.replyType}"/>
                                            </p>
                                        </div>
                                    </div>
                                    <c:if test="${reply.replyType=='email'}">
                                        <div class="form-group email-div">
                                            <label class="col-md-2 control-label">邮箱：</label>
                                            <div class="col-md-6">
                                                <p class="form-control-static">${reply.email }</p>
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${reply.replyType=='mobile'}">
                                        <div class="form-group email-div">
                                            <label class="col-md-2 control-label">手机号码：</label>
                                            <div class="col-md-6">
                                                <p class="form-control-static">${reply.mobile }</p>
                                            </div>
                                        </div>
                                    </c:if>
                                    <div class="form-group form-group-align">
                                        <label class="col-md-2 control-label">反馈内容：</label>
                                        <div class="col-md-8">
                                            <p class="form-control-static">
                                                <textarea name="replyContent" class="form-control" cols="8"
                                                          rows="8">${reply.replyContent }</textarea>
                                            </p>
                                        </div>
                                    </div>
                                </fieldset>
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
                        </form>
                    </div>
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
        $(".view-details").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});
    });
    $().ready(function () {
        var searchFormValidate = $("#searchForm").validate({
            rules: {
                replyContent: {
                    required: true,
                    minlength: 2,
                    maxlength: 1300
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
