<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>保险产品</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/address.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>产品管理</li>
                <li>保险信息管理</li>
                <li>保险产品预览</li>
            </ul>
        </div>
    </div>
    <!-- page content start -->
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>保险产品预览</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/insurance/frame/updatesave"
                          enctype="multipart/form-data" role="form">
                        <input type="hidden" id="id" name="id" value="${productInsurance.id }"/>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>保险产品预览
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">产品编号</label>
                                    <div class="col-md-2">
                                        <input id="code" name="code" type="text" class="form-control"
                                               value="${productInsurance.code}" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">产品名称</label>
                                    <div class="col-md-2">
                                        <input id="name" name="name" type="text" class="form-control"
                                               value="${productInsurance.name}" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">推荐语(20字以内)</label>
                                    <div class="col-md-2">
                                        <input id="recommendations" name="recommendations" type="text"
                                               class="form-control" value="${productInsurance.recommendations}"
                                               readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">保险公司</label>
                                    <div class="col-md-3">
                                        <itech:code type="text" code="insurance.companyName" property="companyName"
                                                    value="${productInsurance.companyName}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">保险类型</label>
                                    <div class="col-md-3">
                                        <input id="category" name="category" type="text" class="form-control"
                                               value="${productInsurance.category}" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">投保范围</label>
                                    <div class="col-md-3">
                                        <input id="insuranceCoverage" name="insuranceCoverage" type="text"
                                               class="form-control" value="${productInsurance.insuranceCoverage}"
                                               readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">保险期间</label>
                                    <div class="col-md-3">
                                        <input id="timeLimit" name="timeLimit" type="text" class="form-control"
                                               value="${productInsurance.timeLimit}" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">交费方式</label>
                                    <div class="col-md-3">
                                        <input id="payType" name="payType" type="text" class="form-control"
                                               value="${productInsurance.payType}" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>投保币种</label>
                                    <div class="col-md-2">
                                        <input id="currencyType" name="currencyType" type="text" class="form-control"
                                               value="${productInsurance.currencyType}" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class="panel-footer">
                                    <div class="form-group">
                                        <div class="col-md-offset-3 col-md-3">
                                            <button onclick="javascript:list();" type="button" class="btn btn-primary">
                                                <i class="icon-undo2"></i>返回
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
    function list() {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/frame/list";
    }
</script>
</html>
