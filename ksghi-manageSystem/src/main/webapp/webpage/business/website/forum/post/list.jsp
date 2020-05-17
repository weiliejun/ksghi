<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>论坛贴子管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>论坛管理</li>
                <li class="active">论坛贴子管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>论坛贴子列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form name="roleForm" class="form-inline" id="searchForm"
                          action="${pageContext.request.contextPath}/business/website/forum/post/list" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">帖子标题</span> <input class="form-control"
                                                                                           type="text" name="topic"
                                                                                           value="${topic}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">创建者</span> <input class="form-control"
                                                                                          type="text" name="creatorName"
                                                                                          value="${creatorName}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">所属版块</span> <select class="form-control"
                                                                                            name="forumId">
                                        <option value="">请选择</option>
                                        <c:forEach items="${forumList }" var="forum">
                                            <c:if test="${forumId==forum.id}">
                                                <c:if test="${forum.parentId=='0' }">
                                                    <option value="${forum.id}"
                                                            selected="selected">${forum.name}</option>
                                                </c:if>
                                                <c:if test="${forum.parentId!='0' }">
                                                    <option value="${forum.id}" selected="selected">&nbsp;&nbsp;&nbsp;&nbsp;${forum.name}</option>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${forumId!=forum.id}">
                                                <c:if test="${forum.parentId=='0' }">
                                                    <option value="${forum.id}">${forum.name}</option>
                                                </c:if>
                                                <c:if test="${forum.parentId!='0' }">
                                                    <option value="${forum.id}">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;${forum.name}</option>
                                                </c:if>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">状态</span>
                                        <itech:code type="select" code="status" property="status" value="${status }"/>
                                    </div>
                                </div>
                                <!-- 总开始 -->
                                <!--开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">发帖开始日期</span>

                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">发帖结束日期</span>

                                        <div class="num fl">
                                            <input id="endDate" name="endDate" size="30" type="text"
                                                   class="form-control data2 loanDatepicker" readonly="readonly"
                                                   value="${endDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <!--结束 -->
                                <!-- 开始 -->
                                <div class="form-group col-md-4 col-xs-6">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="myClearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                </div>
                            </div>
                            <!--结束 -->
                            <!-- 总结束 -->

                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="topic" title="标题" width="20%">
                                            ${bean['TOPIC'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="fname" title="所属版块" width="10%">
                                            ${bean['FNAME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="creatorName" title="创建者" width="10%">
                                            ${bean['CREATOR_NAME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="status" title="状态" width="6%">
                                            <c:if test="${bean['STATUS']=='valid' }">有效</c:if>
                                            <c:if test="${bean['STATUS']=='invalid' }">无效</c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="viewNum" title="浏览数" width="9%">
                                            ${bean['VIEW_NUM'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="replyNum" title="回复数" width="10%">
                                            ${bean['REPLY_NUM'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="createTime" title="发帖时间" width="15%">
                                            ${bean['CREATE_TIME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn title="数据操作" width="10%" sortable="false">
                                            <a href="javascript:edit('${bean['ID']}')" title="贴子编辑"><i
                                                    class="icon-pencil"></i></a>
                                            <a href="javascript:showPostsReplies('${bean['ID']}')" title="贴子回复编辑"><i
                                                    class="icon-pencil"></i></a>
                                            <a href="javascript:deleteData('${bean['ID']}')" title="贴子删除"><i
                                                    class="icon-remove2"></i></a>
                                        </table:htmlColumn>
                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                        </div>
                    </form>
                    <div class="col-sm-offset-6 col-sm-12"></div>
                    <script type="text/javascript">
                        function onInvokeAction(id) {
                            $.jmesa.setExportToLimit(id, '');
                            $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
                        }
                    </script>
                </div>
                <div class="col-sm-offset-6 col-sm-12"></div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>

</body>
<script>
    $(document).ready(function () {
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});
    });

    function edit(id) {
        window.location.href = '${pageContext.request.contextPath}/business/website/forum/post/edit/' + id;
    }

    function deleteData(id) {
        bootbox.confirm('您确定要删除该贴子吗？', function (confirmed) {
            if (confirmed) {
                jQuery.ajax({
                    type: "GET",
                    url: '${pageContext.request.contextPath}/business/website/forum/post/reply/check/' + id,
                    dataType: 'html',
                    success: function (data) {
                        if (data != '0') {
                            bootbox.alert("该贴子下有有效回复，不能删除!");
                        } else {
                            location.href = '${pageContext.request.contextPath}/business/website/forum/post/delete/' + id;
                        }
                        return false;
                    }
                });
            }
        });
    }

    function showPostsReplies(id) {
        location.href = '${pageContext.request.contextPath}/business/website/forum/post/reply/list/' + id;
    }
</script>
</html>
