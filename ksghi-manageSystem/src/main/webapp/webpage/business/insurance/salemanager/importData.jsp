<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>导入保险销售记录数据</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/address.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="row">
            <div class="col-md-12 page-header">
                <h4>导入保险销售记录数据</h4>
            </div>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div id="breadcrumb-wrapper">
                <div class="container-fluid"/>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <form id="searchFormPerson" method="post" enctype="multipart/form-data"
                          action="${pageContext.request.contextPath}/business/insurance/sale/savedata" role="form">
                        <div class="form-group">
                            <label class="col-md-3 control-label">请选择附件：</label>
                            <div id="mbusiFileDiv" class="col-md-9">
                                <ul class="list-inline">
                                    <li><input id="mbusiFile" name="mbusiFile" type="file" class="input-file"/></li>
                                    <li><i class="icon-close" style="cursor: pointer;"
                                           onclick="$(this).parent().prev().children().val('')"></i></li>
                                </ul>
                                <p class="help-block">请上传格式为：xls,xlsx的文件且文件大小在20MB以内</p>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <button id="saveButton" type="button" class="btn btn-primary">
                            <i class="icon-disk"></i>提交数据
                        </button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button id="returnButton" type="button" class="btn btn-primary">
                            <i class="icon-disk"></i>返回列表
                        </button>
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
    $().ready(function () {
        $(".view-details").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});
        var searchFormValidatePerson = $("#searchFormPerson").validate({
            rules: {
                mbusiFile: {required: true, extension: "xlsx|xls", acceptFileSize: [0, 20]}
            }
        });
        $("#saveButton").click(function () {
            if (confirm("确定提交数据吗？")) {
                $("#searchFormPerson").attr("action", "${pageContext.request.contextPath}/business/insurance/sale/savedata");
                $("#searchFormPerson").submit();
            }
        });
        $("#returnButton").click(function () {
            window.location.href = "${pageContext.request.contextPath}/business/insurance/sale/list";
        });
    });
</script>
</html>
