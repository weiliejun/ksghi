<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>机构详情</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>业务角色管理</li>
                <li>推广出借端合作机构管理</li>
                <li class="active">机构详情</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>
                        机构详情
                        <small></small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 right-border">
                    <form id="searchForm" class="form-inline" name="roleForm"
                          action="${pageContext.request.contextPath}/business/cooperateorg/manage/detail/${id}"
                          role="form">
                        <!--增加新的查询条件的表头  -->
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <!--媒体查询的条件  -->
                                <c:if test="${orgType == 'media'}">
                                    <div class="form-group col-md-3 col-xs-4">
                                        <div class="input-group">
                                            <span class="input-group-addon">用户姓名</span> <input class="form-control"
                                                                                               type="text"
                                                                                               name="orgName"
                                                                                               value="${orgName}">
                                        </div>
                                    </div>
                                </c:if>
                                <!--渠道的查询条件  -->
                                <c:if test="${orgType == 'channel' || orgType == 'franchisee'}">
                                    <div class="form-group col-md-3 col-xs-4">
                                        <div class="input-group">
                                            <span class="input-group-addon">机构员工</span> <input class="form-control"
                                                                                               type="text"
                                                                                               name="orgName"
                                                                                               value="${orgName}">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-3 col-xs-4">
                                        <div class="input-group">
                                            <span class="input-group-addon">推荐码</span> <input class="form-control"
                                                                                              type="text" name="orgCode"
                                                                                              value="${orgCode}">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-3 col-xs-4">
                                        <div class="input-group">
                                            <span class="input-group-addon">是否离职</span>
                                            <itech:code property="userStatus" code="user.status" type="select"
                                                        value="${userStatus}"/>
                                        </div>
                                    </div>
                                </c:if>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">昵称</span> <input class="form-control"
                                                                                         type="text" name="nickName"
                                                                                         value="${nickName}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">身份证号</span> <input class="form-control"
                                                                                           onkeyup="this.value=this.value.toUpperCase()"
                                                                                           type="text" name="idNo"
                                                                                           value="${idNo}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">手机号</span> <input class="form-control"
                                                                                          type="text" name="mobile"
                                                                                          value="${mobile}">
                                    </div>
                                </div>

                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">是否绑卡</span>
                                        <itech:code property="bankCardStatus" code="bankCardStatus" type="select"
                                                    value="${bankCardStatus}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">是否开户</span>
                                        <itech:code property="openAccountStatus" code="openAccountStatus" type="select"
                                                    value="${openAccountStatus}"/>
                                    </div>
                                </div>

                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">创建开始日期 <i class="icon-calendar"></i></span>
                                        <input id="startDate" name="startDate" readonly="readonly" type="text"
                                               class="form-control" value="${startDate}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">创建结束日期 <i class="icon-calendar"></i></span>
                                        <input id="endDate" name="endDate" readonly="readonly" type="text"
                                               class="form-control" value="${endDate}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-4 col-xs-6">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="myClearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                    <button type="button" id="exportBtn" class="btn btn-primary">
                                        <i class="icon-file-excel"></i>导出Excel
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="select-label"> <input type="hidden" value="${result.id}" name="id"> <c:if
                                    test="${orgType == 'channel'}">
                                渠道名称
                            </c:if> <c:if test="${orgType == 'franchisee'}">
                                加盟商名称
                            </c:if> <c:if test="${orgType == 'media'}">
                                媒体名称
                            </c:if> :${result.orgName }&nbsp;&nbsp;&nbsp;
                            </label>

                            <c:if test="${orgType == 'franchisee'}">
                                渠道经理姓名：${result.channelDirectorName}&nbsp;&nbsp;&nbsp;
                                区域总监姓名 ：${result.regionalManagerName}
                            </c:if>
                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <!-- 渠道类型 -->
                                        <c:if test="${orgType == 'channel' || orgType == 'franchisee'}">
                                            <table:htmlColumn property="NAME" title="机构员工" width="7%"/>
                                            <table:htmlColumn property="ORGCODE" title="推荐码" width="5%"/>
                                            <table:htmlColumn property="MOBILE" title="手机号" width="8%">
                                                <c:if test="${bean.MOBILE != null}">
                                                    ${fn:substring(bean.MOBILE,0,3)}****${fn:substring(bean.MOBILE,(fn:length(bean.MOBILE) -4),fn:length(bean.MOBILE))}
                                                </c:if>
                                            </table:htmlColumn>
                                            <table:htmlColumn property="NICK_NAME" title="昵称" width="5%"/>
                                            <table:htmlColumn property="ID_NO" title="身份证号" width="5%"/>
                                            <table:htmlColumn property="BANK_CARD_STATUS" title="是否绑卡" width="5%">
                                                <itech:code code="isTrue" type="text" value="${bean.BANK_CARD_STATUS}"/>
                                            </table:htmlColumn>
                                            <table:htmlColumn property="OPEN_ACCOUNT_STATUS" title="是否开户" width="5%">
                                                <itech:code code="isTrue" type="text"
                                                            value="${bean.OPEN_ACCOUNT_STATUS}"/>
                                            </table:htmlColumn>
                                            <table:htmlColumn property="userStatus" title="是否离职" width="5%">
                                                <itech:code code="user.status" type="text" value="${bean.USERSTATUS}"/>
                                            </table:htmlColumn>
                                            <table:htmlColumn property="CREATETIME" title="加入时间" width="8%"/>
                                        </c:if>
                                        <!-- 媒体类型 -->
                                        <c:if test="${orgType == 'media'}">
                                            <table:htmlColumn property="NAME" title="用户姓名" width="7%"/>
                                            <table:htmlColumn property="MOBILE" title="手机号" width="8%">
                                                <c:if test="${bean.MOBILE != null}">
                                                    ${fn:substring(bean.MOBILE,0,3)}****${fn:substring(bean.MOBILE,(fn:length(bean.MOBILE) -4),fn:length(bean.MOBILE))}
                                                </c:if>
                                            </table:htmlColumn>
                                            <table:htmlColumn property="NICK_NAME" title="昵称" width="5%"/>
                                            <table:htmlColumn property="ID_NO" title="身份证号" width="5%"/>
                                            <table:htmlColumn property="BANK_CARD_STATUS" title="是否绑卡" width="5%">
                                                <itech:code code="isTrue" type="text" value="${bean.BANK_CARD_STATUS}"/>
                                            </table:htmlColumn>
                                            <table:htmlColumn property="OPEN_ACCOUNT_STATUS" title="是否开户" width="5%">
                                                <itech:code code="isTrue" type="text"
                                                            value="${bean.OPEN_ACCOUNT_STATUS}"/>
                                            </table:htmlColumn>
                                            <table:htmlColumn property="CREATE_TIME" title="注册时间" width="8%"/>
                                        </c:if>
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
            <div class="row">
                <div class="col-md-offset-10 col-md-2">
                    <a href="${pageContext.request.contextPath}/business/cooperateorg/manage/list" type="button"
                       class="btn btn-primary"> <i class="icon-undo2"></i>返回
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>

<script type="text/javascript">
    $().ready(function () {
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});

        $("#exportBtn").bind("click", function () {
            window.location.href = "${pageContext.request.contextPath }/business/cooperateorg/manage/detail/exportExcel?" + $('#searchForm').serialize();
        });
    });
</script>
</html>