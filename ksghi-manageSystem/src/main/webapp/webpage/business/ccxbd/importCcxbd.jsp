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
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <div class="caption">
                            <form class="" id="searchFormPerson" method="post" enctype="multipart/form-data"
                                  action="${pageContext.request.contextPath}/business/ccxbd/saveImportCcxbd" role="form">

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
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-8">
                    <div class="thumbnail">
                        <div class="form-group">
                            <label class="col-md-3 control-label text-right">样例模板：</label>
                            <div class="col-md-5">
                                <a href="${pageContext.request.contextPath}/business/ccxbd/bdmb">财产险类投保台账</a>
                            </div>
                            <div class="col-sm-offset-6 col-sm-12"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <label class="col-md-3 control-label text-right">数据导入失败常见问题：</label>
                            <div class="col-md-5 well well-sm">
                                <p class="form-control-static">1、表头“结算比例”不能带百分比，比如“结算比例91.50%”会导入失败。</p>
                                <p class="form-control-static">2、数据内容不能是公式形式：需转换成数值格式（转换方式：选中所有带公式的数据，按ctrl+C后，右键选择“粘体为数值”，并且在excel表的菜单-选项-重新计算-工作簿选项中，勾选上“以显示精度为准”，再点击保存）。</p>
                                <p class="form-control-static">3、数据前后不能有空字符串：数据单元格左上角有绿色小三角，选中有黄色感叹号，鼠标点击提示“该内容前后有空字符串”，转换方式同第二条。</p>
                                <p class="form-control-static">4、如有其他异常，请联系技术部。</p>
                            </div>
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
                    <%--location.href = '${pageContext.request.contextPath}/business/ccxbd/saveImportCcxbd';--%>
                    $("#searchFormPerson").attr("action", "${pageContext.request.contextPath}/business/ccxbd/saveImportCcxbd");
                    $("#searchFormPerson").submit();
                    return false;
                }
            });
        });

        $("#returnButton").click(function () {
            window.parent.location.href = "${pageContext.request.contextPath}/business/ccxbd/query";
        });

    });


</script>
<itech:promptInfo type="alert"></itech:promptInfo>
</html>
