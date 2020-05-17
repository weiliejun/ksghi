<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>网站公告列表</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>信息发布管理</li>
                <li class="active">网站公告管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>网站公告信息列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" action="${pageContext.request.contextPath}/business/website/bulletin/list"
                          class="form-inline" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">标题</span> <input class="form-control"
                                                                                         type="text" name="topic"
                                                                                         value="${topic}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">类型</span>
                                        <itech:code property="type" code="bulletin.type" type="select" value="${type}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-4 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">角色</span>
                                        <div class="form-control">
                                            <itech:code property="roleType" code="roleType" type="checkbox"
                                                        value="${roleType}"/>
                                            <input type="hidden" name="roleType" value="" checked="checked">
                                        </div>
                                        <%-- <input id="roleTypeHide" type="hidden" value="${roleType}"/> --%>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">发布状态</span>
                                        <itech:code property="publishStatus" code="publishStatus" type="select"
                                                    value="${publishStatus}"/>
                                    </div>
                                </div>
                                <!-- 总开始 -->
                                <!--开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">发布开始日期</span>
                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">发布结束日期</span>
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
                                        <table:htmlColumn property="topic" title="标题" width="30%"/>
                                        <table:htmlColumn property="sequnum" title="序号" width="5%"/>
                                        <table:htmlColumn property="type" title="类型" width="10%">
                                            <itech:code code="bulletin.type" type="text" value="${bean.type }"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="roleType" title="角色" width="15%">
                                            <itech:code code="roleType" type="text" value="${bean.roleType }"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="views" title="浏览数" width="7%"/>
                                        <table:htmlColumn property="publishStatus" title="发布状态" width="7%">
                                            <itech:code code="publishStatus" type="text" value="${bean.publishStatus}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="publishTime" title="发布时间" width="11%"/>
                                        <table:htmlColumn title="数据操作" width="10%" sortable="false">
                                            <a href="${pageContext.request.contextPath}/business/website/bulletin/edit/${bean.id}"
                                               title="修改网站公告信息"><i class="icon-pencil"></i></a>
                                            <a href="javascript:deleteData('${bean.id}')" title="删网站公告信息"><i
                                                    class="icon-remove2"></i></a>
                                            <c:if test="${bean.topMark =='no' }">
                                                <a href="${pageContext.request.contextPath}/business/website/bulletin/top/${bean.id}"
                                                   title="置顶">未置顶</a>
                                            </c:if>
                                            <c:if test="${bean.topMark =='yes' }">
                                                <a href="${pageContext.request.contextPath}/business/website/bulletin/cancelTop/${bean.id}"
                                                   title="取消置顶">已置顶</a>
                                            </c:if>
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
                    <a href="${pageContext.request.contextPath}/business/website/bulletin/add"
                       class="btn btn-primary"><i class="icon-plus"></i>新增网站公告</a>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>
<script type="text/javascript">
    function deleteData(id) {
        bootbox.confirm('您确定要删除该条网站公告吗？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/website/bulletin/delete/' + id;
                return false;
            }
        });
    }

    $(document).ready(function () {
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});
        //复选框有值时, 默认选中
        //checkedDefault($("#roleTypeHide").val());
    });

    function clearForm(formId) {
        $(':input', '#' + formId).not(':button,:submit,:reset,:hidden,:checkbox').val('').removeAttr('selected');
        $("#" + formId + " input:checked").removeAttr('checked');
    }
</script>
</html>
