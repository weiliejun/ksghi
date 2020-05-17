<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>导入交易数据</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/form.jsp" %>
    <%@ include file="/webpage/common/plugins/address.jsp" %>
</head>

<body>

<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="row">
            <div class="col-md-12 page-header">
                <h4>导入交易数据</h4>
            </div>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div id="content-breadcrumb-wrapper">
                <div class="container-fluid"></div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <form class="" id="searchFormPerson" method="post" enctype="multipart/form-data"
                          action="${pageContext.request.contextPath}/business/xqyzy/ysbd/saveImportXqyInfo" role="form">

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
                        <div id="showdata"></div>
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

                <div class="col-md-6">
                    <div class="form-group">
                        <label class="col-md-2 control-label">样例模板：</label>
                        <div class="col-md-4">
                            <a href="${pageContext.request.contextPath}/business/xqyzy/ysbd/bdmb">国华人寿</a>
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
    $().ready(function () {
        $(".view-details").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});
        var searchFormValidatePerson = $("#searchFormPerson").validate({
            rules: {
                mbusiFile: {required: true, extension: "xlsx|xls", acceptFileSize: [0, 20]}
            }
        });
        $("#saveButton").click(function () {
            bootbox.confirm("确定提交数据吗？", function (confirmed) {
                if (confirmed) {
                    <%--location.href = '${pageContext.request.contextPath}/business/xqyInfo/saveImportXqyInfo';--%>
                    $("#searchFormPerson").attr("action", "${pageContext.request.contextPath}/business/xqyzy/ysbd/saveImportXqyInfo");
                    $("#searchFormPerson").submit();
                    return false;
                }
            });
        });

        $("#returnButton").click(function () {
            window.parent.location.href = "${pageContext.request.contextPath}/business/xqyzy/query?cxmk=ysbd";
        });

    });


</script>
<itech:promptInfo type="alert"></itech:promptInfo>
</html>
