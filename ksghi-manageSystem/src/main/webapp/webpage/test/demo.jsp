<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>


<html>
<head>
    <title>管理控制台首页</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">

    <div id="breadcrumb-wrapper">
        <div class="container">
            <ul class="breadcrumb">
                <li>资讯管理</li>
                <li><a href="#">新闻管理</a></li>
                <li class="active">新增新闻资讯</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>
                        新闻资讯列表
                        <small>次标题</small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-search">
                        <div class="panel-body">
                            <form class="form-inline" role="form">
                                <div class="form-group">
                                    <label>新闻标题</label> <input type="text" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>作者</label> <input type="text" class="form-control">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>


                    <%
                        java.util.List results = new java.util.ArrayList();
                        java.util.Map map = new java.util.HashMap();
                        map.put("topic", "测试标题");
                        results.add(map);
                        request.setAttribute("results", results);
                    %>
                    <form name="searchForm" action="${pageContext.request.contextPath}/admin/information/news/list">
                        <table:tableModel id="informationGrid" items="${results}" var="bean" stateAttr="restore">
                            <table:htmlTable width="100%">
                                <table:htmlRow sortable="false" filterable="false">
                                    <table:htmlColumn property="topic" title="新闻标题" width="50%">
                                        <a href="${pageContext.request.contextPath}/portal/enterprise/information/details/${bean.id}"
                                           target="_blank" title="预览">${bean.topic}</a>
                                    </table:htmlColumn>
                                    <table:htmlColumn property="isTop" title="是否置顶" width="10%">
                                        <span id="information-${bean.id}"><itech:code code="isTrue" type="text"
                                                                                      value="${bean.isTop}"/></span>
                                        <a href="javascript:putTopOrDown('${bean.id}','information-${bean.id}')"
                                           title="切换是否置顶"><i class="icon-refresh"></i></a>
                                    </table:htmlColumn>
                                    <table:htmlColumn property="publishStatus" title="发布状态" width="10%">
                                        <itech:code code="publishStatus" type="text" value="${bean.publishStatus}"/>
                                    </table:htmlColumn>
                                    <table:htmlColumn property="createTime" title="创建时间" width="15%"/>
                                    <table:htmlColumn title="数据操作" width="15%">
                                        <a href="${pageContext.request.contextPath}/admin/enterprise/information/edit/${bean.id}"
                                           title="修改"><i class="icon-pencil"></i></a>
                                        <a href="javascript:deleteData('${bean.id}')" title="删除"><i
                                                class="icon-remove2"></i></a>
                                    </table:htmlColumn>
                                </table:htmlRow>
                            </table:htmlTable>
                        </table:tableModel>
                    </form>
                    <script type="text/javascript">
                        function onInvokeAction(id) {
                            $.jmesa.setExportToLimit(id, '');
                            $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
                        }
                    </script>
                    <br>

                    <form class="form-horizontal" role="form" style="display: none1;">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>form表单标题
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label">静态文本示例</label>
                                    <div class="col-md-10">
                                        <p class="form-control-static">email@example.com</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">text输入项示例</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">disabled text输入项示例</label>
                                    <div class="col-md-6">
                                        <input class="form-control" type="text" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">textarea输入项示例</label>
                                    <div class="col-md-6">
                                        <textarea class="form-control" rows="3"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">radio输入项示例</label>
                                    <div class="col-md-6">
                                        <label class="radio-inline"><input type="radio" value="yes"> Yes</label> <label
                                            class="radio-inline"><input type="radio" value="no"> No</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">checkbox输入项示例</label>
                                    <div class="col-md-6">
                                        <label class="checkbox-inline"><input type="checkbox" value="yes"> Yes</label>
                                        <label class="checkbox-inline"><input type="checkbox" value="no"> No</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">单选项示例</label>
                                    <div class="col-md-6">
                                        <select class="chosen col-md-6">
                                            <option>1980</option>
                                            <option selected>1990</option>
                                            <option>2000</option>
                                            <option>2010</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">多选项示例</label>
                                    <div class="col-md-6">
                                        <select class="chosen col-md-12" multiple="multiple">
                                            <option>1980</option>
                                            <option>1990</option>
                                            <option>2000</option>
                                            <option>2010</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">时间选择示例</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="icon-clock"></i></span> <input
                                                id="time" name="time" type="text" class="form-control"
                                                readonly="readonly"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">日期选择示例</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="icon-calendar"></i></span> <input
                                                id="date" name="date" type="text" class="form-control"
                                                readonly="readonly"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">日期段选择示例</label>
                                    <div class="col-md-6">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="icon-calendar"></i></span> <input
                                                id="dateRange" name="dateRange" type="text" class="form-control"
                                                readonly="readonly"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">选择文件示例</label>
                                    <div class="col-md-6">
                                        <input type="file">
                                        <p class="help-block">字段提示信息示例-Example block-level help text here.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-2 col-md-10">
                                        <button type="button" class="btn btn-primary">
                                            <i class="icon-disk"></i>保存
                                        </button>
                                        <button type="button" class="btn btn-primary">
                                            <i class="icon-undo2"></i>取消
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="col-md-offset-10 col-md-2">
                    <a href="${pageContext.request.contextPath}/system/authority/role/add" class="btn btn-primary"><i
                            class="icon-plus"></i>新增角色</a>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/webpage/common/footer.jsp"/>
</body>


<script type="text/javascript">
    $(document).ready(function () {
        $("#time").timepicker({
            minuteStep: 5,
            showSeconds: false,
            showMeridian: false
        });
        $('#date').datepicker({
            format: 'yyyy-mm-dd'
        });
        $('#dateRange').daterangepicker();
    });
</script>
</html>
