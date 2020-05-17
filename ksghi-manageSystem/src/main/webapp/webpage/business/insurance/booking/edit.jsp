<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>编辑预约状态</title>
    <%@ include file="/webpage/common/public.jsp" %>

</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>产品管理</li>
                <li>保险信息管理</li>
                <li>编辑预约状态</li>
            </ul>
        </div>
    </div>
    <!-- page content start -->
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>预约详情</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/insurance/order/save"
                          enctype="multipart/form-data" role="form">
                        <input type="hidden" id="id" name="id" value="${insuranceBooking.ID }"/>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>预约详情
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">保险产品名称</label>
                                    <div class="col-md-2">
                                        <input class="form-control" type="text" id="productName" name="productName"
                                               value="${insuranceBooking.PRODUCT_NAME }" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">预约时间</label>
                                    <div class="col-md-2">
                                        <input class="form-control" type="text" id="orderTime" name="orderTime"
                                               value="${insuranceBooking.CREATE_TIME }" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">用户昵称</label>
                                    <div class="col-md-2">
                                        <input class="form-control" type="text" id="nikeName" name="nikeName"
                                               value="${insuranceBooking.NIKE_NAME }" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">注册手机</label>
                                    <div class="col-md-2">
                                        <a onclick="javascript:phoneCall('${reqUrl}')"> <img alt="拨打客户电话"
                                                                                             src="${pageContext.request.contextPath}/assets/ui/themes/base/img/dianhua.jpg"> ${insuranceBooking.CUSTOMER_PHONE }
                                        </a>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">客户姓名</label>
                                    <div class="col-md-2">
                                        <input class="form-control" type="text" id="customerName" name="customerName"
                                               value="${insuranceBooking.CUSTOMER_NAME }" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">身份证号</label>
                                    <div class="col-md-2">
                                        <input class="form-control" type="text" id="idNo" name="idNo"
                                               onkeyup="this.value=this.value.toUpperCase()"
                                               value="${insuranceBooking.ID_NO }" readonly="readonly"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-3 control-label">预约状态</label>
                                    <itech:code type="radio" code="insurance.status" property="status"
                                                value="${insuranceBooking.STATUS }"/>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">推荐人姓名</label>
                                    <div class="col-md-3">
                                        <input type="text" id="userName" name="userName" maxlength="50"
                                               value="${insuranceBooking.USER_NAME }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">预约状态说明</label>
                                    <div class="col-md-3">
                                        <input type="text" id="statusRemark" name="statusRemark" maxlength="50"
                                               value="${insuranceBooking.STATUS_REMARK }"/>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-3 col-md-9">
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
                        </div>
                    </form>
                    <div class="col-sm-offset-6 col-sm-12"></div>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>
<style>
    .red {
        #d94a48

    }
</style>
<script type="text/javascript">
    $("#saveButton").click(function () {
        $("#searchForm").submit();
    });
</script>
</html>
