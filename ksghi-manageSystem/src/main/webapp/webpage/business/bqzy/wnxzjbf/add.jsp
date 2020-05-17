<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>财产险保单录入</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
    <%@ include file="/webpage/common/commoneditor.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>财产险保单管理－财产险保单录入</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/xqyzy/ysbd/save" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>财产险保单信息
                                </h3>
                            </div>
                            <input name="id" type="hidden" class="form-control" maxlength="50"
                                   value="${xqyzy/ysbd.id}"/>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label">代理公司：</label>
                                    <div class="col-md-3">
                                        北京国恒保险代理有限公司
                                    </div>
                                    <label class="col-md-2 control-label">投保日期：<font color="red">*</font></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <div class="input-group date">
                                                <input id="tbrq" name="tbrq" type="text" class="form-control"
                                                       readonly="readonly" value="${xqyzy/ysbd.tbrq }"/>
                                                <span class="input-group-addon"> <span
                                                        class="glyphicon glyphicon-calendar"></span></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保人：<font color="red">*</font></label>
                                    <div class="col-md-3">
                                        <input name="tbr" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy/ysbd.tbr}"/>
                                    </div>
                                    <label class="col-md-2 control-label">被保人：<font color="red">*</font></label>
                                    <div class="col-md-3">
                                        <input name="bbr" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy/ysbd.bbr}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">保单号：<font color="red">*</font></label>
                                    <div class="col-md-3">
                                        <input name="bdh" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy/ysbd.bdh}"/>
                                    </div>
                                    <label class="col-md-2 control-label">团个标识：</label>
                                    <div class="col-md-3">
                                        <itech:code property="tdgr" code="xqyzy/ysbd.tdgr" type="select"
                                                    value="${xqyzy/ysbd.tdgr }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">保险公司：<font color="red">*</font></label>
                                    <div class="col-md-3">
                                        <input name="cbgs" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy/ysbd.cbgs}"/>
                                    </div>
                                    <label class="col-md-2 control-label">承保机构：</label>
                                    <div class="col-md-3">
                                        <input name="cbjg" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy/ysbd.cbjg}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">是否共保：</label>
                                    <div class="col-md-3">
                                        <itech:code property="sfgb" code="xqyzy/ysbd.sf" type="select"
                                                    value="${xqyzy/ysbd.sfgb }"/>
                                    </div>
                                    <label class="col-md-2 control-label">共保公司：</label>
                                    <div class="col-md-3">
                                        <input name="gbgs" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy/ysbd.gbgs}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">险种名称：<font color="red">*</font></label>
                                    <div class="col-md-3">
                                        <input name="xzmc" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy/ysbd.xzmc}"/>
                                    </div>
                                    <label class="col-md-2 control-label">含税保费：<font color="red">*</font></label>
                                    <div class="col-md-3">
                                        <input name="hsbf" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy/ysbd.hsbf}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">手续费金额：</label>
                                    <div class="col-md-3">
                                        <input name="sxfje" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy/ysbd.sxfje}"/>
                                    </div>
                                    <label class="col-md-2 control-label">手续费比例：</label>
                                    <div class="col-md-3">
                                        <input name="sxfbl" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy/ysbd.sxfbl}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">代理人：<font color="red">*</font></label>
                                    <div class="col-md-3">
                                        <input name="ywy" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy/ysbd.ywy}"/>
                                    </div>
                                    <label class="col-md-2 control-label">是否结算：<font color="red">*</font></label>
                                    <div class="col-md-3">
                                        <itech:code property="sfjs" code="xqyzy/ysbd.sf" type="select"
                                                    value="${xqyzy/ysbd.sfjs }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">备注：</label>
                                    <div class="col-md-8">
                                        <textarea class="form-control" rows="3" name="remark"
                                                  maxlength="1100">${xqyzy/ysbd.remark}</textarea>
                                    </div>
                                </div>

                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-2 col-md-9">
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


<script type="text/javascript">
    $("#tbrq").datetimepicker({
        format: "YYYY-MM-DD",
        useSeconds: false
    });

    function goBack() {
        window.location.href = "${pageContext.request.contextPath}/business/xqyzy/ysbd/query";
    }

    $(function () {
        var searchFormValidate = $("#searchForm").validate({
            rules: {
                tbrq: {
                    required: true
                },
                tbr: {
                    required: true
                },
                bbr: {
                    required: true
                },
                bdh: {
                    required: true
                },
                cbgs: {
                    required: true
                },
                xzmc: {
                    required: true
                },
                hsbf: {
                    required: true
                },
                ywy: {
                    required: true
                },
                sfjs: {
                    required: true
                },
                hsbf: {
                    required: true,
                    number: true,
                    isDecimal: [0, 999999999, 2]
                },
                sxfje: {
                    number: true,
                    isDecimal: [0, 999999999, 2]
                },
                sxfbl: {
                    number: true,
                    isDecimal: [0, 100, 2]
                }

            }
        });
        $("#saveButton").click(function () {
            if (searchFormValidate.form()) {
                $("#searchForm").submit();
            }
        });
    });

    function reUpload() {
        $("#showFile").addClass("hide");
        $("#uploadFile").addClass("show");
    }
</script>
<itech:promptInfo type="alert"></itech:promptInfo>
</html>
