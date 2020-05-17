<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>论坛版块管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>论坛管理</li>
                <li class="active">论坛版块管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>论坛版块列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form name="roleForm" action="${pageContext.request.contextPath}/business/website/forum/list"
                          role="form">
                        <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean" stateAttr="restore">
                            <table:htmlTable width="100%">
                                <table:htmlRow sortable="true" filterable="false">
                                    <table:htmlColumn property="name" title="版块标题" width="20%">
                                        ${bean['NAME'] }
                                    </table:htmlColumn>
                                    <table:htmlColumn property="pname" title="父版块标题" width="15%">
                                        <c:if test="${bean['PARENT_ID']!='0' }">${bean['PNAME'] }</c:if>
                                        <c:if test="${bean['PARENT_ID']=='0' }">版块根节点</c:if>
                                    </table:htmlColumn>
                                    <table:htmlColumn property="sequnum" title="显示顺序" width="10%">
                                        ${bean['SEQUNUM'] }
                                    </table:htmlColumn>
                                    <table:htmlColumn property="postsNum" title="帖子数" width="10%">
                                        ${bean['POSTS_NUM'] }
                                    </table:htmlColumn>
                                    <table:htmlColumn property="postsReplyNum" title="回复数" width="10%">
                                        ${bean['POSTS_REPLY_NUM'] }
                                    </table:htmlColumn>
                                    <table:htmlColumn property="creatorName" title="创建人" width="10%">
                                        ${bean['CREATOR_NAME'] }
                                    </table:htmlColumn>
                                    <table:htmlColumn property="createTime" title="发布时间" width="10%">
                                        ${bean['CREATE_TIME'] }
                                    </table:htmlColumn>
                                    <table:htmlColumn title="数据操作" width="15%" sortable="false">
                                        <a href="javascript:edit('${bean['ID']}')" title="编辑"><i
                                                class="icon-pencil"></i></a>
                                        <a href="javascript:deleteData('${bean['ID']}')" title="删除"><i
                                                class="icon-remove2"></i></a>
                                    </table:htmlColumn>
                                </table:htmlRow>
                            </table:htmlTable>
                        </table:tableModel>
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
            <div class="row">
                <div class="col-md-offset-10 col-md-2">
                    <a href="${pageContext.request.contextPath}/business/website/forum/add" class="btn btn-primary"><i
                            class="icon-plus"></i>新增论坛版块</a>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>

</body>
<script>

    function edit(id) {
        window.location.href = '${pageContext.request.contextPath}/business/website/forum/edit/' + id;
    }

    function deleteData(id) {
        bootbox.confirm('您确定要删除该版块吗？', function (confirmed) {
            if (confirmed) {
                jQuery.ajax({
                    type: "GET",
                    url: '${pageContext.request.contextPath}/business/website/forum/post/check/' + id,
                    dataType: 'html',
                    success: function (data) {
                        if (data != 'ok') {
                            if (data == 'havePosts') {
                                bootbox.alert("该版块下有贴子，不能删除!");
                            } else if (data == 'haveChildForum') {
                                bootbox.alert("该版块下有子版块，不能删除!");
                            }
                        } else {
                            location.href = '${pageContext.request.contextPath}/business/website/forum/delete/' + id;
                        }
                        return false;
                    }
                });
            }
        });
    }
</script>
</html>
