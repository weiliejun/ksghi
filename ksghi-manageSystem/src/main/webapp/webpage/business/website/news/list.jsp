<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>媒体报道信息列表</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>信息发布管理</li>
                <li class="active">媒体报道管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>媒体报道数据信息列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form name="searchForm" id="searchForm"
                          action="${pageContext.request.contextPath}/business/website/news/list" class="form-inline"
                          role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-7">
                                    <div class="input-group">
                                        <span class="input-group-addon">标题</span> <input class="form-control"
                                                                                         type="text" name="topic"
                                                                                         value="${topic}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-5">
                                    <div class="input-group">
                                        <span class="input-group-addon">类型</span>
                                        <itech:code type="select" code="news.type" property="type"
                                                    defaultValue="${type}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-4 col-xs-7">
                                    <div class="input-group">
                                        <span class="input-group-addon">所属频道</span>
                                        <div class="form-control">
                                            <itech:code type="checkbox" code="news.channel" property="channel"
                                                        value="${channel}"/>
                                            <input type="hidden" name="channel" value="" checked="checked">
                                        </div>
                                    </div>
                                    <%-- <input id="channelHide" type="hidden" value="${channel}"/> --%>
                                </div>
                                <div class="form-group col-md-3 col-xs-5">
                                    <div class="input-group">
                                        <span class="input-group-addon">发布状态</span>
                                        <itech:code property="publishStatus" code="publishStatus" type="select"
                                                    value="${publishStatus}"/>
                                    </div>
                                </div>
                                <!-- 总开始 -->
                                <!--开始 -->
                                <div class="form-group col-md-3 col-xs-7">
                                    <div class="input-group">
                                        <span class="input-group-addon">报道开始日期</span>
                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-5">
                                    <div class="input-group">
                                        <span class="input-group-addon">报道结束日期</span>
                                        <div class="num fl">
                                            <input id="endDate" name="endDate" size="30" type="text"
                                                   class="form-control data2 loanDatepicker" readonly="readonly"
                                                   value="${endDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <!--结束 -->
                                <!-- 开始 -->
                                <div class="form-group col-md-4 col-xs-6">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="clearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>

                                </div>
                                <!--结束 -->
                            </div>
                            <!-- 总结束 -->

                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="topic" title="标题" width="20%"/>
                                        <table:htmlColumn property="type" title="类型" width="10%">
                                            <itech:code type="text" code="news.type" value="${bean.type }"></itech:code>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="channel" title="频道" width="10%">
                                            <itech:code type="text" code="news.channel"
                                                        value="${bean.channel }"></itech:code>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="views" title="浏览数" width="15%"/>
                                        <table:htmlColumn property="publishStatus" title="发布状态" width="15%">
                                            <itech:code code="publishStatus" type="text" value="${bean.publishStatus}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="reportDate" title="报道日期" width="15%"/>
                                        <table:htmlColumn title="数据操作" width="15%" sortable="false">
                                            <a href="${pageContext.request.contextPath}/business/website/news/edit/${bean.id}"
                                               title="修改媒体报道信息"><i class="icon-pencil"></i></a>
                                            <a href="javascript:deleteData('${bean.id}')" title="删除媒体报道信息"><i
                                                    class="icon-remove2"></i></a>
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
                <div class="col-md-offset-8 col-md-2">
                    <a href="${pageContext.request.contextPath}/business/website/news/add" class="btn btn-primary"><i
                            class="icon-plus"></i>新增媒体报道</a>
                </div>
            </div>

        </div>
    </div>
    <!-- page content end -->
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});
        //复选框有值时, 默认选中
        //checkedDefault($("#channelHide").val());
    });

    function deleteData(id) {
        bootbox.confirm('您确定要删除该条媒体报道信息吗？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/website/news/delete/' + id;
                return false;
            }
        });
    }

    function clearForm(formId) {
        $(':input', '#' + formId).not(':button,:submit,:reset,:hidden,:checkbox').val('').removeAttr('selected');
        $("#" + formId + " input:checked").removeAttr('checked');
    }
</script>
</html>
