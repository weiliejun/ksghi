<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>友情链接管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>信息发布管理</li>
                <li class="active">友情链接管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>友情链接信息列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" action="${pageContext.request.contextPath}/business/website/link/list"
                          class="form-inline" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">网站名称</span> <input name="name" type="text"
                                                                                           class="form-control"
                                                                                           value="${name }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">网站类型</span>
                                        <itech:code property="type" code="link.type" type="select" value="${type }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-4 col-xs-4">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="myClearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                </div>
                            </div>
                        </div>

                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="name" title="网站名称" width="10%"/>
                                        <table:htmlColumn property="url" title="网站地址" width="20%"/>
                                        <table:htmlColumn property="type" title="网站类型" width="10%">
                                            <itech:code code="link.type" type="text" value="${bean.type}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="description" title="网站简介" width="18%"/>
                                        <table:htmlColumn property="views" title="浏览次数" width="8%"/>
                                        <table:htmlColumn property="createTime" title="创建时间" width="10%"/>
                                        <table:htmlColumn property="remark" title="备注" width="15%"/>
                                        <table:htmlColumn title="数据操作" width="10%" sortable="false">
                                            <a href="${pageContext.request.contextPath}/business/website/link/edit/${bean.id}"
                                               title="修改网站信息"><i class="icon-pencil"></i></a>
                                            <a href="javascript:deleteData('${bean.id}')" title="删除广告位信息"><i
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
                <div class="col-md-offset-10 col-md-2">
                    <a href="${pageContext.request.contextPath}/business/website/link/add" class="btn btn-primary"><i
                            class="icon-plus"></i>新增友情链接</a>
                </div>
            </div>

        </div>
    </div>
    <!-- page content end -->
</div>
</body>
<script type="text/javascript">
    function deleteData(id) {
        bootbox.confirm("您确定要删除该友情链接信息吗？", function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/website/link/delete/' + id;
                return false;
            }
        });
    }
</script>
</html>
