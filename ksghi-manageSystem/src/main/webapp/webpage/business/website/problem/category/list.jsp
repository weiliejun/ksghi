<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>问题分类管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>问答管理</li>
                <li class="active">问题分类管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>问题分类列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form name="roleForm" id="searchForm" class="form-inline"
                          action="${pageContext.request.contextPath}/business/website/problem/category/list"
                          role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">分类名称</span> <select class="form-control"
                                                                                            name="parentId">
                                        <option value="">请选择</option>
                                        <c:if test="${parentId=='0' }">
                                            <option value="0" selected="selected">板块根节点</option>
                                        </c:if>
                                        <c:if test="${parentId!='0' }">
                                            <option value="0">板块根节点</option>
                                        </c:if>
                                        <c:forEach items="${parentPromCategories }" var="category">
                                            <c:if test="${category.ID==parentId }">
                                                <option value="${category.ID}"
                                                        selected="selected">${category.NAME}</option>
                                            </c:if>
                                            <c:if test="${category.ID!=parentId}">
                                                <option value="${category.ID}">${category.NAME}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                    </div>
                                </div>

                                <div class="form-group col-md-4 col-xs-4">
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
                                        <table:htmlColumn property="NAME" title="分类名称" width="25%">
                                            ${bean['NAME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="PNAME" title="所属父分类名称" width="15%">
                                            <c:if test="${bean['PNAME']==null }">
                                                板块跟节点
                                            </c:if>
                                            <c:if test="${bean['PNAME']!=null }">
                                                ${bean['PNAME']}
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="SEQUNUM" title="显示顺序" width="15%">
                                            ${bean['SEQUNUM'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="CREATOR_NAME" title="创建人" width="15%">
                                            ${bean['CREATOR_NAME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="CREATE_TIME" title="创建时间" width="15%">
                                            ${bean['CREATE_TIME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn title="数据操作" width="15%" sortable="false">
                                            <a href="javascript:edit('${bean.ID}')" title="编辑"><i
                                                    class="icon-pencil"></i></a>
                                            <a href="javascript:deleteData('${bean.ID}')" title="删除"><i
                                                    class="icon-remove2"></i></a>
                                        </table:htmlColumn>
                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                            <script type="text/javascript">
                                function onInvokeAction(id) {
                                    $.jmesa.setExportToLimit(id, '');
                                    $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
                                }
                            </script>
                        </div>
                        <div class="col-sm-offset-6 col-sm-12"></div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-md-offset-10 col-md-2">
                    <a href="${pageContext.request.contextPath}/business/website/problem/category/add"
                       class="btn btn-primary"><i class="icon-plus"></i>新增问题分类</a>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>

</body>
<script>

    function edit(id) {
        window.location.href = '${pageContext.request.contextPath}/business/website/problem/category/edit/' + id;
    }

    function deleteData(id) {
        bootbox.confirm('您确定要删除该分类吗？', function (confirmed) {
            if (confirmed) {
                jQuery.ajax({
                    type: "GET",
                    url: '${pageContext.request.contextPath}/business/website/problem/check/' + id,
                    dataType: 'html',
                    success: function (data) {
                        if (data == 'haveProblem') {
                            bootbox.alert("该分类下有有效问题，不能删除!");
                        } else if (data == 'haveSubCategory') {
                            bootbox.alert("该分类下子分类，不能删除!");
                        } else if (data == 'ok') {
                            location.href = '${pageContext.request.contextPath}/business/website/problem/category/delete/' + id;
                        }
                        return false;
                    }
                });
            }
        });
    }
</script>
</html>
