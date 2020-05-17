<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>问题管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>问答管理</li>
                <li class="active">问题管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>问题列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form name="roleForm" id="searchForm"
                          action="${pageContext.request.contextPath}/business/website/problem/list" class="form-inline"
                          role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">标题</span> <input class="form-control"
                                                                                         type="text" name="topic"
                                                                                         value="${topic}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">编码</span> <input class="form-control"
                                                                                         type="text" name="code"
                                                                                         value="${code}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">问题分类</span> <select class="form-control"
                                                                                            name="problemCategoryId">
                                        <option value="">请选择</option>
                                        <c:forEach var="category" items="${categoryList}">
                                            <c:if test="${problemCategoryId==category.id}">
                                                <c:if test="${category.parentId=='0'}">
                                                    <option value="${category.id}"
                                                            selected="selected">${category.name }</option>
                                                </c:if>
                                                <c:if test="${category.parentId!='0'}">
                                                    <option value="${category.id}" selected="selected">&nbsp;&nbsp;&nbsp;&nbsp;${category.name }</option>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${problemCategoryId!=category.id}">
                                                <c:if test="${category.parentId=='0'}">
                                                    <option value="${category.id}">${category.name }</option>
                                                </c:if>
                                                <c:if test="${category.parentId!='0'}">
                                                    <option value="${category.id}">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;${category.name }</option>
                                                </c:if>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">发布状态</span>
                                        <itech:code property="publishStatus" code="publishStatus" type="select"
                                                    value="${publishStatus}"/>
                                    </div>
                                </div>
                                <!-- 总开始 -->
                                <!--开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">创建开始日期</span>
                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">创建结束日期</span>
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
                                <!--结束 -->
                                <!-- 总结束 -->
                            </div>
                        </div>

                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="TOPIC" title="标题" width="25%">
                                            ${bean['TOPIC'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="NAME" title="问题分类" width="15%">
                                            ${bean['NAME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="SEQUNUM" title="显示顺序" width="10%">
                                            ${bean['SEQUNUM'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="CODE" title="编码" width="10%">
                                            ${bean['CODE'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="CREATOR_NAME" title="创建人" width="10%">
                                            ${bean['CREATOR_NAME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="createTime" title="创建时间" width="10%">
                                            ${bean['CREATE_TIME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="PUBLISH_STATUS" title="发布状态" width="10%">
                                            <itech:code code="publishStatus" type="text"
                                                        value="${bean.PUBLISH_STATUS}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn title="数据操作" width="10%" sortable="false">
                                            <a href="javascript:edit('${bean['ID'] }')" title="编辑"><i
                                                    class="icon-pencil"></i></a>
                                            <a href="javascript:deleteData('${bean['ID']}')" title="删除"><i
                                                    class="icon-remove2"></i></a>
                                        </table:htmlColumn>
                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                        </div>
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
                    <a href="${pageContext.request.contextPath}/business/website/problem/add" class="btn btn-primary"><i
                            class="icon-plus"></i>新增问题</a>
                </div>
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
        window.location.href = '${pageContext.request.contextPath}/business/website/problem/edit/' + id;
    }

    function deleteData(id) {
        bootbox.confirm('您确定要删除该问题吗？',
            function (confirmed) {
                if (confirmed) {
                    location.href = '${pageContext.request.contextPath}/business/website/problem/delete/' + id;
                    return false;
                }
            });
    }
</script>
</html>
