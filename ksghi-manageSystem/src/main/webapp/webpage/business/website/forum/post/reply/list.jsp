<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>论坛贴子回复管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>论坛管理</li>
                <li class="active">论坛贴子回复管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>论坛贴子回复列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <i class="icon-pencil"></i>贴子回复信息
                            </h3>
                        </div>
                        <div class="panel-body">
                            <c:forEach var="postsReply" items="${results}" varStatus="lns">
                                <input type="hidden" name="id${lns.index}" id="id${lns.index}" value="${postsReply.id}">
                                <input type="hidden" name="forumPostsId${lns.index }" id="forumPostsId${lns.index }"
                                       value="${postsReply.forumPostsId}">
                                <div class="row">
                                    <div class="col-md-10">
                                        <div class="form-group">
                                            <label class="col-md-2 control-label">${startNum+lns.index+1}楼回复内容：</label>
                                            <div class="col-md-10">
                                                <textarea name="content${lns.index}" id="content${lns.index}"
                                                          class="form-control" disabled="disabled"
                                                          maxlength="1300">${postsReply.content }</textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-2 control-label">回复状态：</label>
                                            <div class="col-md-10">
                                                <label class='radio-inline'><input type='radio'
                                                                                   name='status${lns.index }'
                                                                                   value="valid"
                                                                                   <c:if test="${postsReply.status=='valid'}">checked</c:if>>有效</label>
                                                <label class='radio-inline'><input type='radio'
                                                                                   name='status${lns.index }'
                                                                                   value="invalid"
                                                                                   <c:if test="${postsReply.status=='invalid'}">checked</c:if>>无效</label>
                                                <p class="help-block">注：无效状态时，该信息将在网站端不进行显示.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <div class="col-md-12 text-right">
                                                <p>
                                                    <button onclick="save(${lns.index})" class="btn btn-primary">
                                                        <i class="icon-disk"></i>修改
                                                    </button>
                                                </p>
                                                <p>
                                                    <button onclick="delReply('${postsReply.id}','${postsReply.forumPostsId}')"
                                                            type="button" class="btn btn-primary">
                                                        <i class="icon-disk"></i>删除
                                                    </button>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="row pull-right">
                                <div class="pager" class="col-md-12">
                                    <pg:pager url="" items="${totalCount}" maxPageItems="${pageSize}" maxIndexPages="10"
                                              isOffset="true" export="offset,currentPageNumber=pageNumber"
                                              scope="request">
                                        <pg:index>
                                            <pg:first export="firstPageUrl=pageUrl">
                                                <a href="${firstPageUrl}">首页</a>
                                            </pg:first>
                                            <pg:pages>
                                                <c:choose>
                                                    <c:when test="${currentPageNumber eq pageNumber}">
                                                        <a href="#" class="current">${pageNumber }</a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="${pageUrl}">${pageNumber }</a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </pg:pages>
                                            <pg:last export="lastPageUrl=pageUrl">
                                                <a href="${lastPageUrl}">尾页</a>
                                            </pg:last>
                                        </pg:index>
                                    </pg:pager>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <div class="text-right">
                                <a class="btn btn-primary" onclick="javascript:history.go(-1);"><i
                                        class="icon-undo2"></i>返回</a>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>

</body>
<script>
    var count = "${count}";
    count = parseInt(count);
    for (var a = 0; a < count; a++) {
        var editorName = "_editor" + a;
        var content = "content" + a;
        $("textarea[name='" + content + "']").redactor({
            imageUpload: true
        });
    }

    function delReply(id, forumPostsId) {
        bootbox.confirm('您确定要删除该回复吗？', function (confirmed) {
            if (confirmed) {
                location.href = "${pageContext.request.contextPath}/business/website/forum/post/reply/delete/" + id + "," + forumPostsId + "";
                return false;
            }
        });
    }

    function save(index) {
        var replyId = $("#id" + index + "").val();
        var replyPostId = $("#forumPostsId" + index + "").val();
        var content = $("#content" + index + "").val();
        var status = $('input[name="status' + index + '"]:checked').val();
        jQuery.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/business/website/forum/post/reply/edit/save/',
            data: "replyId=" + replyId + "&replyPostId=" + replyPostId + "&content=" + content + "&status=" + status + "",
            dataType: 'html',
            aysnc: false,
            success: function (data) {
                if (data == 'success') {
                    bootbox.alert('保存成功!', function () {
                        window.location.reload();
                    });
                } else {
                    bootbox.alert("保存失败!");
                }
                return false;
            }
        });
    }
    }
</script>
</html>
