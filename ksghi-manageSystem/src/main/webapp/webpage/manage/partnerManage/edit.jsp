<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>合作平台息录入管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/form.jsp" %>
    <%@ include file="/webpage/common/plugins/address.jsp" %>
</head>

<body>
<div id="wrapper">

    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站用户管理</li>
                <li>合作平台管理</li>
                <li><a href="${pageContext.request.contextPath}/manage/partnerManage/list">合作平台查询</a></li>
                <li class="active">新增合作平台</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>新增合作平台</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default form-horizontal">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <i class="icon-pencil"></i>合作平台信息
                            </h3>
                        </div>
                        <div class="panel-body">
                            <form class="" id="searchFormPartner" method="post"
                                  action="${pageContext.request.contextPath}/manage/partnerManage/edit" role="form">
                                <input type="hidden" id="id" name="id" value="${partner.id }"/>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>合作平台网站名称：</label>
                                    <div class="col-md-3">
                                        <input id="name" name="name" value="${partner.name }" type="text"
                                               class="form-control" maxlength="100"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">合作平台简称：</label>
                                    <div class="col-md-3">
                                        <input id="shortName" name="shortName" value="${partner.shortName }" type="text"
                                               class="form-control" maxlength="50"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>合作平台网站地址：</label>
                                    <div class="col-md-3">
                                        <input id="url" name="url" value="${partner.url }" type="text"
                                               class="form-control" maxlength="100"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>合作平台网站ip：</label>
                                    <div class="col-md-3">
                                        <input id="ip" name="ip" value="${partner.ip }" type="text" class="form-control"
                                               maxlength="2000"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">法人代表：</label>
                                    <div class="col-md-3">
                                        <input id="ownerName" name="ownerName" value="${partner.ownerName }" type="text"
                                               class="form-control" maxlength="100"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">电话：</label>
                                    <div class="col-md-3">
                                        <input id="phone" name="phone" value="${partner.phone }" type="text"
                                               class="form-control" maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">传真：</label>
                                    <div class="col-md-3">
                                        <input id="fax" name="fax" value="${partner.fax }" type="text"
                                               class="form-control" maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">邮编：</label>
                                    <div class="col-md-3">
                                        <input id="post" name="post" value="${partner.post }" type="text"
                                               class="form-control" maxlength="50"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>所属行业：</label>
                                    <div class="col-md-3">
                                        <itech:code property="industry" code="industry" type="select"
                                                    value="${partner.industry }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>所在地区：</label>
                                    <div class="col-md-9 row">
                                        <div class="col-md-2">
                                            <select id="province" name="province" class="form-control"></select>
                                        </div>
                                        <div class="col-md-2">
                                            <select id="city" name="city" class="form-control"></select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">公司地址：</label>
                                    <div class="col-md-6">
                                        <textarea id="address" name="address" class="form-control" rows="5"
                                                  maxlength="500">${partner.address }</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">公司情况介绍：</label>
                                    <div class="col-md-6">
                                        <textarea id="summary" name="summary" class="form-control" rows="5"
                                                  maxlength="2000">${partner.summary }</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">备注：</label>
                                    <div class="col-md-6">
                                        <textarea id="remark" name="remark" class="form-control" rows="5"
                                                  maxlength="2000">${partner.remark }</textarea>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="panel-footer text-center">
                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-10 ">
                                    <button id="saveButton" type="button" class="btn btn-primary">
                                        <i class="icon-disk"></i>保存
                                    </button>
                                    <button onclick="javascript:history.go(-1);" type="button" class="btn btn-primary">
                                        <i class="icon-undo2"></i>取消
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-offset-6 col-sm-12"></div>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>

<script type="text/javascript">
    $(function () {
        //表单校验
        var searchFormValidatePartner = $("#searchFormPartner").validate({
            rules: {
                name: {required: true, maxlength: 100},
                shortName: {maxlength: 50},
                url: {required: true, isUrl: true, maxlength: 200},
                ip: {required: true, ip: false, maxlength: 2000},
                ownerName: {maxlength: 100},
                phone: {isPhone: true, maxlength: 50},
                fax: {maxlength: 50},
                address: {maxlength: 500},
                summary: {maxlength: 2000},
                remark: {maxlength: 2000}
            }
        });
        //保存
        $("#saveButton").click(function () {
            if (searchFormValidatePartner.form()) {
                $("#searchFormPartner").submit();
                /* jQuery.ajax({
                    type: "POST",
                    url: '
                ${pageContext.request.contextPath}/manage/partnerManage/add',
			    data:$("#searchFormPartner").serialize(),
			    success: function (data) {
			    }
			}); */
            }
        });

        $.areaLinkage.invert({
            "provinceSelectId": "province",
            "provinceSelectValue": "${partner.province}",
            "citySelectId": "city",
            "citySelectValue": "${partner.city}",
            "valueType": "name"
        });
    });


</script>
</html>
