<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>预览LOGO</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/ui/core/plugins/table/jmesa/css/jmesa.css"></link>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/ui/core/plugins/date/daterangepicker/css/daterangepicker.css"></link>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/table/jmesa/js/jquery.jmesa.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/table/jmesa/js/jmesa.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/date/daterangepicker/js/date.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/date/daterangepicker/js/daterangepicker.js"></script>
</head>

<body>
<div id="wrapper">
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>LOGO运营管理-预览LOGO</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <i class="icon-pencil"></i>预览LOGO信息
                            </h3>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <label class="col-md-2 control-label"
                                       style="text-align: right; line-height: 36px;">名称：</label>
                                <div class="col-md-6" style="line-height: 36px;">
                                    <p class="form-control-static">${appLogoManage.logoName}</p>
                                </div>
                            </div>
                            <div style="clear: both;"></div>
                            <div class="form-group">
                                <label class="col-md-2 control-label" style="text-align: right; line-height: 36px;">地址URL：</label>
                                <div class="col-md-6" style="line-height: 36px;">
                                    <p class="form-control-static">${appLogoManage.url}</p>
                                </div>
                            </div>
                            <div style="clear: both;"></div>
                            <div class="form-group">
                                <label class="col-md-2 control-label"
                                       style="text-align: right; line-height: 36px;">备注：</label>
                                <div class="col-md-6" style="line-height: 36px;">
                                    <p class="form-control-static">${appLogoManage.remark}</p>
                                </div>
                            </div>
                            <div style="clear: both;"></div>
                            <div class="form-group">
                                <label class="col-md-2 control-label" style="text-align: right; line-height: 36px;">创建时间：</label>
                                <div class="col-md-6" style="line-height: 36px;">
                                    <p class="form-control-static">${appLogoManage.createTime}</p>
                                </div>
                            </div>
                            <div style="clear: both;"></div>
                            <div class="form-group">
                                <label class="col-md-2 control-label" style="text-align: right; line-height: 36px;">启用时间：</label>
                                <div class="col-md-6" style="line-height: 36px;">
                                    <p class="form-control-static">${appLogoManage.startTime}</p>
                                </div>
                            </div>
                            <div style="clear: both;"></div>
                            <div class="form-group">
                                <label class="col-md-2 control-label" style="text-align: right; line-height: 36px;">停用时间：</label>
                                <div class="col-md-6" style="line-height: 36px;">
                                    <p class="form-control-static">${appLogoManage.endTime}</p>
                                </div>
                            </div>
                            <div style="clear: both;"></div>
                            <div class="form-group">
                                <label class="col-md-2 control-label"
                                       style="text-align: right; line-height: 36px;">状态：</label>
                                <div class="col-md-6" style="line-height: 36px;">
                                    <p class="form-control-static">
                                        <c:if test="${appLogoManage.status=='stop'}">已停用</c:if>
                                        <c:if test="${appLogoManage.status=='used'}">已启用</c:if>
                                        <c:if test="${appLogoManage.status=='unuse'}">未启用</c:if>
                                    </p>

                                </div>
                            </div>
                            <div style="clear: both;"></div>
                            <div class="form-group">
                                <label class="col-md-2 control-label" style="text-align: right; line-height: 36px;">Logo地址：</label>
                                <div class="col-md-6" style="line-height: 36px;">
                                    <p class="form-control-static">
                                        <a href="${appLogoManage.upload}" target="_blank">查看图片</a>
                                    </p>
                                </div>
                            </div>
                            <div style="clear: both;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>


<script type="text/javascript">


    //form字段验证
    $().ready(function () {
        var pictureServerURL = "${pictureServerURL}";
        if (jsonArrayIsNotEmpty('${productBorrower.corpRuleFile }')) {
            var jsonAry = $.parseJSON('${productBorrower.corpRuleFile }');
            var jsonObj = jsonAry[0];
            var data = {
                path: pictureServerURL + jsonObj.path,
                name: jsonObj.name,
                thumbnail: pictureServerURL + jsonObj.thumbnail
            };

            $("#mCorpRuleFileDiv").setTemplateElement("viewFileTmpl");
            $("#mCorpRuleFileDiv").processTemplate(data);
        }
    });
</script>
</html>