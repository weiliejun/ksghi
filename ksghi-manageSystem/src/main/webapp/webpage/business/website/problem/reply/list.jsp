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
                <li class="active">客户留言管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>留言列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form name="searchForm" id="searchForm"
                          action="${pageContext.request.contextPath}/business/website/problem/reply/list"
                          class="form-inline" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">用户姓名</span> <input class="form-control"
                                                                                           type="text" name="name"
                                                                                           value="${name}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">问题类型</span>
                                        <itech:code property="type" code="problemReply.type" type="select"
                                                    value="${type}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">回复方式</span>
                                        <itech:code property="replyType" code="problemReply.replyType" type="select"
                                                    value="${replyType}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">处理状态</span>
                                        <itech:code property="operateStatus" code="problem.operateStatus" type="select"
                                                    value="${operateStatus}"/>
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
                                        <table:htmlColumn property="userInfoId" title="用户ID" width="15%">
                                            <c:if test="${bean.userInfoId!=null }">${bean.userInfoId }</c:if>
                                            <c:if test="${bean.userInfoId==null }">(匿名用户)</c:if>
                                        </table:htmlColumn>

                                        <table:htmlColumn property="name" title="用户姓名" width="15%"/>
                                        <table:htmlColumn property="type" title="问题类型" width="15%">
                                            <c:if test="${bean.type=='consultation'}">咨询</c:if>
                                            <c:if test="${bean.type=='advice'}">建议</c:if>
                                            <c:if test="${bean.type=='complaint'}">投诉</c:if>
                                            <c:if test="${bean.type=='other'}">其他</c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="replyType" title="回复方式" width="15%">
                                            <c:if test="${bean.replyType=='noreply'}">无需回复</c:if>
                                            <c:if test="${bean.replyType=='email'}">邮件回复</c:if>
                                            <c:if test="${bean.replyType=='mobile'}">电话回复</c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="operateStatus" title="处理状态" width="15%">
                                            <c:if test="${bean.operateStatus=='false'}">
                                                <span style="color: red">未处理</span>
                                            </c:if>
                                            <c:if test="${bean.operateStatus=='true'}">已处理</c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="createTime" title="创建时间" width="15%"/>
                                        <table:htmlColumn title="数据操作" width="15%" sortable="false">
                                            <a href="javascript:edit('${bean.id }')" title="编辑"><i
                                                    class="icon-pencil"></i></a>
                                            <a href="javascript:deleteData('${bean.id}')" title="删除"><i
                                                    class="icon-remove2"></i></a>
                                        </table:htmlColumn>
                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                        </div>
                        <script type="text/javascript">
                            function onInvokeAction(id) {
                                $.jmesa.setExportToLimit(id, '');
                                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
                            }
                        </script>
                    </form>
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
        window.location.href = '${pageContext.request.contextPath}/business/website/problem/reply/edit/' + id;
    }

    function deleteData(id) {
        bootbox.confirm(
            '您确定要删除该问题吗？',
            function (confirmed) {
                if (confirmed) {
                    location.href = '${pageContext.request.contextPath}/business/website/problem/reply/delete/' + id;
                }
            });
    }
</script>
</html>
