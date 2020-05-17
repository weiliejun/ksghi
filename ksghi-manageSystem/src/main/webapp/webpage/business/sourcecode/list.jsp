<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>运营管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>
<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>运营管理</li>
                <li class="active">用户来源管理</li>
            </ul>
        </div>
    </div>
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>用户来源管理</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 right-border">
                    <form id="searchForm" class="form-inline"
                          action="${pageContext.request.contextPath}/business/sourcecode/list" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">用户来源名称</span> <input name="sourceName"
                                                                                             type="text"
                                                                                             class="form-control"
                                                                                             value="${sourceName }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">用户来源code</span> <input name="sourceCode"
                                                                                               type="text"
                                                                                               class="form-control"
                                                                                               value="${sourceCode }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">创建人姓名</span> <input name="creatorName"
                                                                                            type="text"
                                                                                            class="form-control"
                                                                                            value="${creatorName }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">状态:</span>
                                        <itech:code property="status" code="advertise.status" type="select"
                                                    value="${status}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-4 col-xs-6">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="myClearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                </div>
                            </div>
                        </div>

                        <table:tableModel id="grid" limit="${limit }" items="${results }" var="beanMap">
                            <table:htmlTable width="100%">
                                <table:htmlRow sortable="true" filterable="false">
                                    <table:htmlColumn property="sourceWebsite" title="用户来源网站" width="13%">
                                        <%-- 网站前需要加上 // --%>
                                        <a href="${beanMap.sourceWebsite }"
                                           target="_blank">${beanMap.sourceWebsite }</a>
                                    </table:htmlColumn>
                                    <table:htmlColumn property="sourceName" title="用户来源名称" width="13%"/>
                                    <table:htmlColumn property="sourceCode" title="用户来源code" width="8%"/>
                                    <table:htmlColumn property="creatorName" title="创建人姓名" width="10%"/>
                                    <table:htmlColumn title="状态" property="status" width="5%">
                                        <itech:code code="advertise.status" type="text" value="${beanMap.status }"/>
                                    </table:htmlColumn>
                                    <table:htmlColumn property="createTime" title="创建时间" width="8%"/>
                                    <table:htmlColumn property="remark" title="备注信息" width="18%"/>
                                    <table:htmlColumn title="操作" width="14%" sortable="false">
                                        <a class="view-details"
                                           href="${pageContext.request.contextPath }/business/sourcecode/edit/${beanMap.id }">修改</a>
                                        <a href="javascript:deleteData('${beanMap.id }')" title="删除"> 删除 </a>
                                        <c:if test="${beanMap.status == 'unable' }">
                                            <a href="${pageContext.request.contextPath }/business/sourcecode/enable/${beanMap.id }"
                                               title="启用">已停用</a>
                                        </c:if>
                                        <c:if test="${beanMap.status == 'enable' }">
                                            <a href="${pageContext.request.contextPath }/business/sourcecode/unable/${beanMap.id }"
                                               title="停用">已启用</a>
                                        </c:if>
                                    </table:htmlColumn>
                                </table:htmlRow>
                            </table:htmlTable>
                        </table:tableModel>
                    </form>
                    <div class="col-sm-offset-6 col-sm-12"></div>
                    <script type="text/javascript">
                        function onInvokeAction(id) {
                            $.jmesa.setExportToLimit(id, '');
                            $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
                        }
                    </script>
                </div>
                <div class="row">
						<span class="col-md-2 col-md-offset-10">
							<ul class="list-inline">
								<a href="${pageContext.request.contextPath}/business/sourcecode/add"
                                   class="btn btn-primary"><i class="icon-plus"></i>新增用户来源</a>
							</ul>
						</span>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>
<script type="text/javascript">
    function deleteData(id) {
        bootbox.confirm("您确定要删除吗？", function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/sourcecode/delete/' + id;
                return false;
            }
        });
    }

    function doTimeStack(url, info) {
        $.ajax({
            async: false,
            dataType: "text",
            url: url,
            data: "info=" + info,
            success: function (data) {
                if (data == 'true') {
                    bootbox.alert("操作成功！");
                } else {
                    bootbox.alert("操作失败！");
                }
            },
            error: function () {
                bootbox.alert("发送失败，刷新页面重试！");
            }
        });

    }

</script>
</html>
