<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>项目佣金比例设置</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>业务角色管理</li>
                <li>推广出借端合作机构管理</li>
                <li><a href="${pageContext.request.contextPath}/business/cooperateorg/manage/list">出借端合作机构管理</a></li>
                <li class="active">出借端合作机构项目佣金管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>
                        出借端合作机构项目佣金管理列表
                        <small></small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 right-border">
                    <form id="searchForm" class="form-inline" name="roleForm"
                          action="${pageContext.request.contextPath}/business/cooperateorg/manage/orgCommission/list/${orgId}"
                          role="form">

                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="productCategory" title="项目" width="8%">
                                            <itech:code type="text" code="product.productCategory"
                                                        property="productCategory"
                                                        value="${bean['PRODUCT_CATEGORY'] }"></itech:code>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="brokerageMoney" title="佣金基础出借金额" width="8%">
                                            ${bean['BROKERAGE_MONEY'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="brokerageRate" title="基础出借佣金比率" width="8%">
                                            ${bean['BROKERAGE_RATE'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="myselfRate" title="自投佣金比例" width="8%">
                                            ${bean['MYSELF_RATE'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="oneLevelRate" title="一级佣金比例" width="8%">
                                            ${bean['ONE_LEVEL_RATE'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="secondLevelRate" title="二级佣金比例" width="8%">
                                            ${bean['SECOND_LEVEL_RATE'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="threeLevelRate" title="三级佣金比例" width="8%">
                                            ${bean['THREE_LEVEL_RATE'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="fourLevelRate" title="四级佣金比例" width="8%">
                                            ${bean['FOUR_LEVEL_RATE'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="fiveLevelRate" title="五级佣金比例" width="8%">
                                            ${bean['FIVE_LEVEL_RATE'] }
                                        </table:htmlColumn>
                                        <%--  <table:htmlColumn property="jumpPoint1" title="跳点1"  width="10%">
                                 ${bean['JUMP_POINT1'] }
                                </table:htmlColumn>
                                <table:htmlColumn property="jumpPoint1Rate" title="跳点1比率"  width="10%">
                                 ${bean['JUMP_POINT1_RATE'] }
                                </table:htmlColumn> --%>
                                        <table:htmlColumn property="remark" title="备注" width="8%">
                                            ${bean['REMARK'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="createTime" title="创建时间" width="8%">
                                            ${bean['CREATE_TIME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn title="数据操作" width="12%" sortable="false">
                                            <a href="${pageContext.request.contextPath}/business/cooperateorg/manage/orgCommission/edit?orgId=${orgId}&id=${bean['ID']}">查看详情</a>
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
                    <a href="${pageContext.request.contextPath}/business/cooperateorg/manage/orgCommission/edit?orgId=${orgId}"
                       class="btn btn-primary"><i class="icon-plus"></i>添加</a>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>


</html>