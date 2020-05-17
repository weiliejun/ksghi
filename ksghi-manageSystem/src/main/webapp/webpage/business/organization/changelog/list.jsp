<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户帐户管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>业务角色管理</li>
                <li>推广出借端合作机构管理</li>
                <li class="active">机构变更日志</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>
                        机构变更日志列表
                        <small></small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 right-border">
                    <form id="searchForm" class="form-inline" name="roleForm"
                          action="${pageContext.request.contextPath}/business/cooperateorg/changelog/list" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div style="overflow: hidden; float: left;">
                                    <div class="form-group col-md-3 col-xs-6">
                                        <div class="input-group">
                                            <span class="input-group-addon">机构名称</span> <input class="form-control"
                                                                                               type="text"
                                                                                               name="orgName"
                                                                                               value="${orgName}">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-3 col-xs-6">
                                        <div class="input-group">
                                            <span class="input-group-addon">砸彩蛋开始日期：</span>

                                            <div class="num fl">
                                                <input id="startDate" name="startDate" type="text"
                                                       class="fl form-control data2 expireDatepicker"
                                                       readonly="readonly" value="${startDate}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-3 col-xs-6">
                                        <div class="input-group">
                                            <span class="input-group-addon">砸彩蛋结束日期：</span>

                                            <div class="num fl">
                                                <input id="endDate" name="endDate" size="30" type="text"
                                                       class="form-control data2 loanDatepicker" readonly="readonly"
                                                       value="${endDate}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-3 col-xs-6">
                                        <div class="input-group">
                                            <span class="input-group-addon">原推荐码</span> <input class="form-control"
                                                                                               type="text"
                                                                                               name="oldOrgCode"
                                                                                               value="${oldOrgCode}">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-3 col-xs-6">
                                        <div class="input-group">
                                            <span class="input-group-addon">现推荐码</span> <input class="form-control"
                                                                                               type="text"
                                                                                               name="newOrgCode"
                                                                                               value="${newOrgCode}">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-4 col-xs-6">
                                        <div class="input-group">
                                            <button type="submit" class="btn btn-primary">
                                                <i class="icon-search"></i>查询
                                            </button>
                                            <button type="button" class="btn btn-primary"
                                                    onclick="myClearForm('searchForm')">
                                                <i class="icon-loop2"></i>清空
                                            </button>
                                            <button type="button" id="exportBtn" class="btn btn-primary">
                                                <i class="icon-file-excel"></i>导出Excel
                                            </button>
                                        </div>
                                        <!--结束 -->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="CREATE_TIME" title="变更时间" width="9%"/>
                                        <table:htmlColumn property="ORG_NAME" title="机构名称" width="10%"/>
                                        <table:htmlColumn property="USER_NAME" title="客户姓名" width="8%"/>
                                        <table:htmlColumn property="MOBILE" title="客户手机号" width="8%">
                                            <c:if test="${bean.MOBILE != null}">
                                                ${fn:substring(bean.MOBILE,0,3)}****${fn:substring(bean.MOBILE,(fn:length(bean.MOBILE) -4),fn:length(bean.MOBILE))}
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="OLD_ORG_PERSON_CODE" title="原推荐码" width="8%"/>
                                        <table:htmlColumn property="OLD_USER_NAME" title="原推荐人姓名" width="5%"/>
                                        <table:htmlColumn property="NEW_ORG_PERSON_CODE" title="现推荐码" width="5%"/>
                                        <table:htmlColumn property="NEW_USER_NAME" title="现推荐人姓名" width="10%"/>
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

            </div>
        </div>
    </div>
    <div class="col-sm-offset-6 col-sm-12"></div>
    <!-- page content end -->
</div>
</body>

<script type="text/javascript">
    $().ready(function () {
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});
        $("#exportBtn").bind("click", function () {
            window.location.href = "${pageContext.request.contextPath }/business/cooperateorg/changelog/list/exportExcel?" + $('#searchForm').serialize();
        });
    });
</script>
</html>
