<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>出借端合作机构信息录入</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/address.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>业务角色管理</li>
                <li>推广出借端合作机构管理</li>
                <li>出借端合作机构录入</li>
            </ul>
        </div>
    </div>
    <!-- page content start -->
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>新增出借端合作机构</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/cooperateorg/manage/edit/save"
                          enctype="multipart/form-data" role="form">
                        <input type="hidden" id="id" name="id" value="${orgInfo.id }"/>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>出借端合作机构信息录入
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>管理员手机号</label>
                                    <div class="col-md-2">
                                        <c:if test="${orgInfo != null && orgInfo.orgType == 'media' }">
                                            <input id="adminMobile" name="adminMobile" type="text" class="form-control"
                                                   readonly="readonly" value="${orgInfo.adminMobile }"
                                                   oninput="checkAdminMobile('yes');"/>
                                        </c:if>
                                        <c:if test="${orgInfo.orgType != 'media' }">
                                            <input id="adminMobile" name="adminMobile" type="text" class="form-control"
                                                   value="${orgInfo.adminMobile }" oninput="checkAdminMobile('yes');"/>
                                        </c:if>
                                        <span id="adminMobileError"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">管理员姓名</label>
                                    <div class="col-md-2">
                                        <c:if test="${orgInfo != null && orgInfo.orgType == 'media' }">
                                            <input id="adminName" name="adminName" readonly="readonly"
                                                   value="${orgInfo.adminName }" type="text" class="form-control"/>
                                        </c:if>
                                        <c:if test="${orgInfo.orgType != 'media' }">
                                            <input id="adminName" name="adminName" value="${orgInfo.adminName }"
                                                   type="text" class="form-control"/>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>公司名称</label>
                                    <div class="col-md-2">
                                        <c:if test="${orgInfo != null && orgInfo.orgType == 'media' }">
                                            <input name="orgName" value="${orgInfo.orgName}" type="text"
                                                   class="form-control" readonly="readonly"/>
                                        </c:if>
                                        <c:if test="${orgInfo.orgType != 'media' }">
                                            <input name="orgName" value="${orgInfo.orgName}" type="text"
                                                   class="form-control"/>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>公司电话</label>
                                    <div class="col-md-2">
                                        <c:if test="${orgInfo != null && orgInfo.orgType == 'media' }">
                                            <input name="companyMobile" type="text" class="form-control"
                                                   readonly="readonly" value="${orgInfo.companyMobile}"/>
                                        </c:if>
                                        <c:if test="${orgInfo.orgType != 'media' }">
                                            <input name="companyMobile" type="text" class="form-control"
                                                   value="${orgInfo.companyMobile}"/>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>公司代理人</label>
                                    <div class="col-md-2">
                                        <c:if test="${orgInfo != null && orgInfo.orgType == 'media' }">
                                            <input name="agentName" type="text" class="form-control" readonly="readonly"
                                                   value="${orgInfo.agentName}"/>
                                        </c:if>
                                        <c:if test="${orgInfo.orgType != 'media' }">
                                            <input name="agentName" type="text" class="form-control"
                                                   value="${orgInfo.agentName}"/>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>代理人手机号</label>
                                    <div class="col-md-2">
                                        <c:if test="${orgInfo != null && orgInfo.orgType == 'media' }">
                                            <input name="agentMobile" type="text" class="form-control"
                                                   readonly="readonly" value="${orgInfo.agentMobile}"/>
                                        </c:if>
                                        <c:if test="${orgInfo.orgType != 'media' }">
                                            <input name="agentMobile" type="text" class="form-control"
                                                   value="${orgInfo.agentMobile}"/>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i class="icons-mark-required"></i>机构码</label>
                                    <div class="col-md-2">
                                        <c:if test="${orgInfo != null && orgInfo.orgType == 'media' }">
                                            <input id="orgCode" name="orgCode" type="text" class="form-control"
                                                   readonly="readonly" value="${orgInfo.orgCode}"
                                                   onkeyup="checkOrgCode();"/>
                                        </c:if>
                                        <c:if test="${orgInfo.orgType != 'media' }">
                                            <input id="orgCode" name="orgCode" type="text" class="form-control"
                                                   value="${orgInfo.orgCode}" onkeyup="checkOrgCode();"/>
                                        </c:if>
                                        <span id="orgCodeError"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>结算周期</label>
                                    <div class="col-md-2">
                                        <div class="input-group">
                                            <c:if test="${orgInfo != null && orgInfo.orgType == 'media' }">
                                                <input name="timeLimit" type="text" class="form-control"
                                                       readonly="readonly" value="${orgInfo.timeLimit}"/>
                                                <span class="input-group-addon">月 </span>
                                            </c:if>
                                            <c:if test="${orgInfo.orgType != 'media' }">
                                                <input name="timeLimit" type="text" class="form-control"
                                                       value="${orgInfo.timeLimit}"/>
                                                <span class="input-group-addon">月 </span>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>合作时间：</label>
                                    <div class="col-md-2">
                                        <div class="input-group">
                                            <div id="consociationStartdateDiv" class="input-group date">
                                                <input id="consociationStartdate" name="consociationStartdate"
                                                       type="text" class="form-control" readonly="readonly"
                                                       value="${orgInfo.consociationStartdate}"/>
                                                <c:if test="${orgInfo.orgType != 'media' }">
														<span class="input-group-addon"> <span
                                                                class="glyphicon glyphicon-calendar"></span>
														</span>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                    <label class="control-label" style="float: left; margin-left: -28px">至</label>
                                    <div class="col-md-2">
                                        <div class="input-group">
                                            <div id="consociationEnddateDiv" class="input-group date">
                                                <input id="consociationEnddate" name="consociationEnddate"
                                                       class="form-control" readonly="readonly"
                                                       value="${orgInfo.consociationEnddate}"/>
                                                <c:if test="${orgInfo.orgType != 'media' }">
														<span class="input-group-addon"> <span
                                                                class="glyphicon glyphicon-calendar"></span>
														</span>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>机构类型</label>
                                    <div class="col-md-3">
                                        <itech:code type="radio" property="orgType" code="organization.orgType"
                                                    defaultValue="${orgInfo.orgType == null ? 'channel' : orgInfo.orgType}"/>
                                    </div>
                                </div>
                                <div id="media_div">

                                    <div class="form-group">
                                        <label class="col-md-3 control-label"><i class="icons-mark-required"></i>首次出借佣金比例</label>
                                        <div class="col-md-2">
                                            <div class="input-group">
                                                <c:if test="${orgInfo != null && orgInfo.orgType == 'media' }">
                                                    <input id="firstTenderRate" name="firstTenderRate" type="text"
                                                           class="form-control" readonly="readonly"
                                                           value="${orgInfo.firstTenderRate}"/>
                                                    <span class="input-group-addon">%/年 </span>
                                                </c:if>
                                                <c:if test="${orgInfo.orgType != 'media' }">
                                                    <input id="firstTenderRate" name="firstTenderRate" type="text"
                                                           class="form-control" value="${orgInfo.firstTenderRate}"/>
                                                    <span class="input-group-addon">%/年 </span>
                                                </c:if>
                                            </div>
                                        </div>
                                        <label class="control-label" style="float: left; margin-left: 9px"> <c:if
                                                test="${orgInfo != null }">
                                            <input type="hidden" name="firstByInvest"
                                                   value="${orgInfo.firstByInvest }"/>
                                            <c:if test="${orgInfo.firstByInvest == 'yes'  }">
                                                <input id="firstByInvest" name="firstByInvest" type="checkbox"
                                                       disabled="disabled" checked class="form-control" value="yes"/>
                                            </c:if>
                                            <c:if test="${orgInfo.firstByInvest != 'yes' }">
                                                <input id="firstByInvest" name="firstByInvest" type="checkbox"
                                                       disabled="disabled" class="form-control" value="yes"/>
                                            </c:if>
                                        </c:if> <c:if test="${orgInfo == null }">
                                            <input id="firstByInvest" name="firstByInvest" type="checkbox"
                                                   class="form-control" value="yes"/>
                                        </c:if>
                                        </label>
                                        <div class="col-md-2" style="margin-top: 4px; margin-left: -4px;">按出借来源计算佣金
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label"><i class="icons-mark-required"></i>复投佣金比例</label>
                                        <div class="col-md-2 ">
                                            <div class="input-group">
                                                <c:if test="${orgInfo != null && orgInfo.orgType == 'media' }">
                                                    <input id="repeatTenderRate" name="repeatTenderRate" type="text"
                                                           class="form-control" readonly="readonly"
                                                           value="${orgInfo.repeatTenderRate}"/>
                                                    <span class="input-group-addon">%/年</span>
                                                </c:if>
                                                <c:if test="${ orgInfo.orgType != 'media' }">
                                                    <input id="repeatTenderRate" name="repeatTenderRate" type="text"
                                                           class="form-control" value="${orgInfo.repeatTenderRate}"/>
                                                    <span class="input-group-addon">%/年</span>
                                                </c:if>
                                            </div>
                                        </div>
                                        <label class="control-label" style="float: left; margin-left: 9px"> <c:if
                                                test="${ orgInfo != null}">
                                            <input type="hidden" name="repeatByInvest"
                                                   value="${orgInfo.repeatByInvest }"/>
                                            <c:if test="${orgInfo.repeatByInvest == 'yes' }">
                                                <input id="repeatByInvest" name="repeatByInvest" type="checkbox"
                                                       disabled="disabled" checked class="form-control" value="yes"/>
                                            </c:if>
                                            <c:if test="${orgInfo.repeatByInvest != 'yes' }">
                                                <input id="repeatByInvest" name="repeatByInvest" type="checkbox"
                                                       disabled="disabled" class="form-control" value="yes"/>
                                            </c:if>
                                        </c:if> <c:if test="${ orgInfo == null}">
                                            <input id="repeatByInvest" name="repeatByInvest" type="checkbox"
                                                   class="form-control" value="yes"/>
                                        </c:if>
                                        </label>
                                        <div class="col-md-2" style="margin-top: 4px; margin-left: -4px;">按出借来源计算佣金
                                        </div>

                                    </div>

                                </div>
                                <!-- 加盟商类型开始 -->
                                <div id="franchisee_div">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label"><i
                                                class="icons-mark-required"></i>所属区域：</label>
                                        <div class="col-md-2">
                                            <itech:code property="regional" code="regional" type="select"
                                                        value="${orgInfo.regional }"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label"><i class="icons-mark-required"></i>渠道经理姓名</label>
                                        <div class="col-md-2">
                                            <input id="channelDirectorName" name="channelDirectorName" type="text"
                                                   class="form-control" value="${orgInfo.channelDirectorName}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label"><i class="icons-mark-required"></i>渠道经理手机号</label>
                                        <div class="col-md-2">
                                            <input id="channelDirectorMobile" name="channelDirectorMobile" type="text"
                                                   class="form-control" value="${orgInfo.channelDirectorMobile}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label"><i class="icons-mark-required"></i>区域总监姓名</label>
                                        <div class="col-md-2">
                                            <input id="regionalManagerName" name="regionalManagerName" type="text"
                                                   class="form-control" value="${orgInfo.regionalManagerName}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label"><i class="icons-mark-required"></i>区域总监手机号</label>
                                        <div class="col-md-2">
                                            <input id="regionalManagerMobile" name="regionalManagerMobile" type="text"
                                                   class="form-control" value="${orgInfo.regionalManagerMobile}"/>
                                        </div>
                                    </div>
                                </div>
                                <!-- 加盟商块的结束 -->
                                <%-- 	<div id="channel_div">
                                    <div class="form-group">
                                         <label class="col-md-3 control-label"><i class="icons-mark-required"></i>员工推荐出借所得佣金比例</label>
                                         <div class="col-md-9">
                                             <div class="input-group">
                                                 <div class="table-responsive">
                                                        <table class="table table-hover table-bordered ">
                                                            <thead style="background-color: #ccc;text-align: center;">
                                                                <tr>
                                                                    <th>自投佣金比例(%/年）</th>
                                                                    <th>1级佣金比例(%/年）</th>
                                                                    <th>2级佣金比例(%/年）</th>
                                                                    <th>3级佣金比例(%/年）</th>
                                                                    <th>4级佣金比例(%/年）</th>
                                                                    <th>5级佣金比例(%/年）</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <td> <input id="myselfRate" name="myselfRate"  type="text" class="form-control"   value="${orgInfo.myselfRate}" /></td>
                                                                    <td> <input id="oneLevelRate" name="oneLevelRate"  type="text" class="form-control"  value="${orgInfo.oneLevelRate}"/></td>
                                                                    <td> <input id="secondLevelRate" name="secondLevelRate"  type="text" class="form-control"  value="${orgInfo.secondLevelRate}"/></td>
                                                                    <td> <input id="threeLevelRate" name="threeLevelRate"  type="text" class="form-control"  value="${orgInfo.threeLevelRate}"/></td>
                                                                    <td> <input id="fourLevelRate" name="fourLevelRate"  type="text" class="form-control"  value="${orgInfo.fourLevelRate}"/></td>
                                                                    <td> <input id="fiveLevelRate" name="fiveLevelRate"  type="text" class="form-control"  value="${orgInfo.fiveLevelRate}"/></td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                 </div>
                                            </div>
                                         </div>
                                    </div>
                                <div class="form-group">
                                         <label class="col-md-3 control-label"><i class="icons-mark-required"></i>获得佣金基础出借总额</label>
                                         <div class="col-md-2 " style="float: left">
                                             <div class="input-group">
                                                    <input id ="brokerageMoney" name="brokerageMoney"  type="text" class="form-control" value="${orgInfo.brokerageMoney}"/><span  class="input-group-addon">元以下</span>
                                             </div>
                                         </div>
                                         <label class="col-md-1 control-label"><i class="icons-mark-required"></i>佣金比例</label>
                                         <div class="col-md-2 input-group" style="float: left">
                                                <input id="brokerageRate" name="brokerageRate"  type="text" class="form-control"  maxlength="60" value="${orgInfo.brokerageRate}"/>
                                                <span class="input-group-addon">  %/年 </span>

                                         </div>
                                    </div>
                                    <div class="form-group">
                                         <label class="col-md-3 control-label">跳点所得佣金比例</label>
                                        <div class="col-md-3">
                                             <div class="input-group">
                                                 <div class="table-responsive">
                                                        <table class="table table-hover table-bordered ">
                                                            <thead style="text-align: center;">
                                                                <tr >
                                                                    <th >跳点区间</th>
                                                                    <th>比例(%/年）</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <td> <div class="input-group"><label class="control-label col-md-4" style="float:left; "><i class="icons-mark-required" ></i>>=</label> <div class="col-md-8"> <input id ="brokerageMoney" name="brokerageMoney"  type="text" class="form-control" value="${orgInfo.brokerageMoney}"/></div></div></td>
                                                                    <td><label class="control-label col-md-3">  <i class="icons-mark-required"></i></label> <div class="col-md-9"><input  id="brokerageRate" name="brokerageRate"  type="text" class="form-control"  maxlength="60" placeholder="0" value="${orgInfo.brokerageRate}"/></div></td>
                                                                </tr>
                                                                <tr>
                                                                    <td> <div class="input-group"><label class="control-label col-md-4">>=</label> <div class="col-md-8"><input id="jumpPoint1"  name="jumpPoint1"  type="text" class="form-control"  value="${orgInfo.jumpPoint1}"/></div></div></td>
                                                                    <td> <label class="control-label col-md-3">  </label><div class="col-md-9"><input id="jumpPoint1Rate"  name="jumpPoint1Rate"  type="text" class="form-control" placeholder="0" value="${orgInfo.jumpPoint1Rate}"/></div></td>
                                                                </tr>
                                                                <tr>
                                                                    <td> <div class="input-group"><label class="control-label col-md-4">>=</label> <div class="col-md-8"><input id="jumpPoint2"  name="jumpPoint2"  type="text" class="form-control" value="${orgInfo.jumpPoint2}" /></div></div></td>
                                                                    <td> <label class="control-label col-md-3">  </label><div class="col-md-9"><input id="jumpPoint2Rate"  name="jumpPoint2Rate"  type="text" class="form-control" placeholder="0" value="${orgInfo.jumpPoint2Rate}"/></div></td>
                                                                </tr>
                                                                <tr>
                                                                    <td> <div class="input-group"><label class="control-label col-md-4">>=</label> <div class="col-md-8"><input id="jumpPoint3"  name="jumpPoint3"  type="text" class="form-control" value="${orgInfo.jumpPoint3}" /></div></div></td>
                                                                    <td> <label class="control-label col-md-3">  </label><div class="col-md-9"><input id="jumpPoint3Rate"  name="jumpPoint3Rate"  type="text" class="form-control" placeholder="0" value="${orgInfo.jumpPoint3Rate}"/></div></td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                 </div>
                                            </div>
                                         </div>
                                    </div>
                               </div>--%>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i class="icons-mark-required"></i>类型</label>
                                    <div class="col-md-3">
                                        <itech:code type="radio" property="type" code="organization.type"
                                                    defaultValue="${orgInfo.type==null?'outside':orgInfo.type}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>是否合作</label>
                                    <div class="col-md-3">
                                        <itech:code type="radio" property="status" code="organization.status"
                                                    defaultValue="${orgInfo.status==null?'cooperation':orgInfo.status}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>支付方式</label>
                                    <div class="col-md-3">
                                        <itech:code type="radio" property="paymentType" code="organization.paymentType"
                                                    defaultValue="${orgInfo.paymentType==null?'offline':orgInfo.paymentType}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="saveButton" type="button" class="btn btn-primary">
                                            <i class="icon-disk"></i>提交
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
<style>
    .red {
        #d94a48

    }
</style>
<script type="text/javascript">
    function checkAdminMobile(isName) {
        var flag = false;
        var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(17[0-9]{1})|(18[0-9]{1})|(19[0-9]{1}))+\d{8})$/;
        if ($("#adminMobile").val() == null || $("#adminMobile").val() == '') {
            $("#adminMobileError").html("");
        } else {
            if (reg.test($("#adminMobile").val())) {
                if ('' != '${orgInfo.adminMobile}' && $("#adminMobile").val() != '${orgInfo.adminMobile}') {
                    $.ajax({
                        async: false,
                        type: "GET",
                        url: "${pageContext.request.contextPath}/business/user/common/isexit",
                        data: {adminMobile: $("#adminMobile").val()},
                        success: function (data) {
                            if (data.flag == false) {
                                $("#adminMobileError").addClass("red");
                                $("#adminMobileError").html(data.message);
                                $("#adminName").val('');
                            } else if (data.flag) {
                                flag = true;
                                if (isName == 'yes')
                                    $("#adminName").val(data.name);
                                $("#adminMobileError").html("");
                                if (data.orgCode != '' && data.orgCode != null) {
                                    $('#orgCode').val(data.orgCode);
                                    $.validator.addMethod("eqOrgCode", function (value, element, param) {
                                        return this.optional(element) || (value.toUpperCase() == param);
                                    }, "机构码应与该用户的机构码相同，方可成为该机构管理员");
                                    $("#orgCode").rules("add", {eqOrgCode: data.orgCode});
                                } else {
                                    $("#orgCode").rules("remove", "eqOrgCode");
                                }

                            }
                        },
                        error: function (data) {
                        }
                    });

                } else if ('' == '${orgInfo.adminMobile}') {
                    $.ajax({
                        async: false,
                        type: "GET",
                        url: "${pageContext.request.contextPath}/business/user/common/isexit",
                        data: {adminMobile: $("#adminMobile").val()},
                        success: function (data) {
                            if (data.flag == false) {
                                flag = false;
                                $("#adminMobileError").addClass("red");
                                $("#adminMobileError").html(data.message);
                                $("#adminName").val('');
                            } else if (data.flag) {
                                flag = true;
                                if (isName == 'yes')
                                    $("#adminName").val(data.name);
                                $("#adminMobileError").html("");
                                if (data.orgCode != '' && data.orgCode != null) {
                                    $('#orgCode').val(data.orgCode);
                                    $.validator.addMethod("eqOrgCode", function (value, element, param) {
                                        return this.optional(element) || (value.toUpperCase() == param);
                                    }, "机构码应与该用户的机构码相同，方可成为该机构管理员");
                                    $("#orgCode").rules("add", {eqOrgCode: data.orgCode});
                                } else {
                                    $("#orgCode").rules("remove", "eqOrgCode");
                                }
                            }
                        },
                        error: function (data) {
                            flag = false;
                        }
                    });

                } else {
                    flag = true;
                    $("#adminMobileError").html("");
                }
            } else {
                $("#adminMobileError").html("");
            }
        }
        return flag;
    }

    $.validator.addMethod("codeisexit", function (value, element) {
        var flag = false;
        $.ajax({
            async: false,
            type: "GET",
            url: "${pageContext.request.contextPath}/business/cooperateorg/manage/orgcodeisexit",
            data: {orgCode: value},
            success: function (data) {
                if (data) {
                    flag = true;
                } else {
                    flag = false;
                }
            },
            error: function (data) {
                flag = false;
            }
        });
        return flag;

    }, "该机构码已存在，请重新输入");
    $.validator.addMethod("hasstaff", function (value, element) {
        var flag = false;
        $.ajax({
            async: false,
            type: "GET",
            url: "${pageContext.request.contextPath}/business/cooperateorg/manage/hasstaff",
            data: {orgCode: '${orgInfo.orgCode }'},
            success: function (data) {
                if (data) {
                    flag = true;
                } else {
                    flag = false;
                }
            },
            error: function (data) {
                flag = false;
            }
        });
        return flag;
    }, "该机构已经有员工了，不能修改");

    function checkOrgCode() {
        var flag = false;
        if ('${orgInfo.id }' == null || '${orgInfo.id}' == '') {
            //添加机构
            $("#orgCode").rules("add", {codeisexit: true});
        } else {
            var orgCode = $('#orgCode').val() == '' ? "" : $('#orgCode').val().toUpperCase();
            if (orgCode != '${orgInfo.orgCode}') {
                $("#orgCode").rules("add", {codeisexit: true});
                $("#orgCode").rules("add", {hasstaff: true});
            } else {
                $("#orgCode").rules("remove", "codeisexit");
                $("#orgCode").rules("remove", "hasstaff");
                flag = true;
            }
        }
        return flag;
    }

    $(function () {
        $("#consociationStartdateDiv").datetimepicker({
            format: "YYYY-MM-DD",
            pickTime: false
        });
        $("#consociationEnddateDiv").datetimepicker({
            format: "YYYY-MM-DD",
            pickTime: false
        });
        $.validator.addMethod("consociationDate", function (value, element, param) {
            return this.optional(element) || (value >= $("#consociationStartdate").val());
        }, "结束日期不能小于开始日期");
        // 判断是否为合法字符(a-zA-Z0-9-_)
        $.validator.addMethod("isRightfulString", function (value, element) {
            return this.optional(element) || /^[A-Za-z]+$/.test(value);
        }, "输入不合法，必须由字母组成");

        /*    $.validator.addMethod("moreThan", function(value, element,param) {
               var lastVal=$(param).val();
               if(value!='')
                   return this.optional(element) || (Number(value) > Number(lastVal));
               else return true;
            }, "输入值应大于上一输入值");
             */
        var searchFormValidate = $("#searchForm").validate({
            rules: {
                adminMobile: {
                    required: true,
                    isMobile: true
                },
                orgName: {
                    required: true,
                    maxlength: 50
                },
                companyMobile: {
                    required: true,
                    maxlength: 50
                },
                adminName: {
                    maxlength: 50
                },
                agentName: {
                    required: true,
                    maxlength: 50
                },
                agentMobile: {
                    required: true,
                    isMobile: true
                },
                orgCode: {
                    required: true,
                    isRightfulString: true,
                    minlength: 3,
                    maxlength: 6

                },
                orgType: {
                    required: true
                },
                timeLimit: {
                    required: true,
                    digits: true,
                    maxlength: 5
                },
                consociationStartdate: {
                    required: true,
                },
                consociationEnddate: {
                    required: true,
                    consociationDate: true
                },
                status: {
                    required: true
                },

                type: {
                    required: true
                }
            }

        });

        $('#dateRange').daterangepicker();

        var orgType = $("input[name='orgType'][checked]").val();
        checkOrgType(orgType, 'init');
        orgTypeMedia(orgType);
        $("input[name='orgType']").on("click", function () {
            // 这里需要更新
            orgType = $(this).val();
            checkOrgType(this.value, 'noinit');
            orgTypeMedia($(this).val());

        });

        function checkOrgType(orgType, init) {
            if (orgType == 'channel') {
                $('#media_div').hide();
                $('#franchisee_div').hide();
                if (init != 'init')
                    $("#media_div :input").val("");
                //$('#channel_div').show();
                //addChannelFormValidate();
                $("#firstTenderRate,#repeatTenderRate").rules("remove");
            } else if (orgType == 'franchisee') {
                $('#media_div').hide();
                $('#channel_div').hide();
                if (init != 'init')
                    $('#franchisee_div').show();
                addFranchiseeFormValidate();
            } else {
                $('#channel_div').hide();
                $('#franchisee_div').hide();
                if (init != 'init')
                //$("#channel_div :input").val("");
                    $('#media_div').show();
                addMediaFormValidate();
                //$("#brokerageMoney,#brokerageRate,#jumpPoint1,#jumpPoint3,#jumpPoint1Rate,#jumpPoint2Rate,#jumpPoint3Rate,#myselfRate,#oneLevelRate,#secondLevelRate,#threeLevelRate,#fourLevelRate,#fiveLevelRate").rules("remove");
            }
        }

        function addMediaFormValidate() {
            $("#firstTenderRate").rules("add", {required: true, number: true, isDecimal: [0, 999999999, 2]});
            $("#repeatTenderRate").rules("add", {required: true, number: true, isDecimal: [0, 999, 2]});
        }

        /* 加盟商js必填验证 */
        function addFranchiseeFormValidate() {
            $("#channelDirectorName").rules("add", {required: true, maxlength: 50});
            $("#channelDirectorMobile").rules("add", {required: true, isMobile: true});
            $("#regionalManagerName").rules("add", {required: true, maxlength: 50});
            $("#regionalManagerMobile").rules("add", {required: true, isMobile: true});
        }

        /* 	function addChannelFormValidate(){
                $("#brokerageMoney").rules("add", {required: true, number: true,isDecimal:[0,999999999,2]});
                $("#brokerageRate").rules("add", {required: true, number: true, isDecimal:[0,999,2]});
                $("#myselfRate").rules("add", {required: true, number: true, isDecimal:[0,999,2]});
                $("#oneLevelRate").rules("add", {required: true, number: true, isDecimal:[0,999,2]});
                $("#secondLevelRate").rules("add", {required: true, number: true, isDecimal:[0,999,2]});
                $("#threeLevelRate").rules("add", {required: true, number: true, isDecimal:[0,999,2]});
                $("#fourLevelRate").rules("add", {required: true, number: true, isDecimal:[0,999,2]});
                $("#fiveLevelRate").rules("add", {required: true, number: true, isDecimal:[0,999,2]});
            }
             */
        $("#saveButton").click(function () {
            checkOrgCode();
            if (searchFormValidate.form() && checkAdminMobile('no')) {
                $("#searchForm").submit();
            }
        });

        function orgTypeMedia(org) {
            if (org == 'media') {
                $("input[name='type']").attr("disabled", "disabled");
                //$("#orgType").attr("disabled","disabled");
            } else if (orgType == 'franchisee') {
                $("input[name='type']").removeAttr("disabled");
                $("#orgType").removeAttr("disabled");
            } else {
                $("input[name='type']").removeAttr("disabled");
                $("#orgType").removeAttr("disabled");
            }
        }
    });
</script>
</html>
