<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>定时任务管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统监控数据管理</li>
                <li class="active">执行定时任务</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>
                        执行定时任务
                        <small></small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <%-- <div class="form-group">
                    <form id="batchOpenAcountForm" action="${pageContext.request.contextPath}/data/migration/batch/openaccount">
                        产品Id:<input type="text" name="productId" />
                        <button type="button" class="btn btn-primary" onclick="reapalBatchTest('batchOpenAcountForm')">融托富批量开户测试</button>
                    </form>
                </div>
                <div class="form-group">
                    <form id="batchPublishProductForm" action="${pageContext.request.contextPath}/data/migration/batch/publishproduct">
                        产品Id:<input type="text" name="productId" />
                        <button type="button" class="btn btn-primary" onclick="reapalBatchTest('batchPublishProductForm')">融托富未还款标的测试</button>
                    </form>
                </div> --%>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/testMail')">发送邮件测试
                    </button>
                </div>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doCsaiControllerJob')">希财网</button>
                </div> --%>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doAutoBatchSyncUserBalance')">
                        批量同步平台所有账户余额
                    </button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doAutoProductAudit')">
                        新手标自动满标审核
                    </button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doBirthday')">生日提醒
                    </button>
                </div>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doCashAuditSystemJob')">系统批量发送审核提现请求</button>
                </div> --%>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doChannelPaymentByProduct')">
                        立即生成佣金结算信息
                    </button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoCalcOrgCommission')">
                        自动生成佣金在线支付记录
                    </button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doCreditAssignmentJob')">
                        取消债权转让定时任务
                    </button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doFullTenderAudit')">
                        满标复核通知
                    </button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/complementTenderAudit')">
                        补标通知
                    </button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doLotteryExpired')">
                        奖券过期
                    </button>
                </div>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doMediaPayment')">媒体佣金</button>
                </div> --%>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doMerchantQuartzPayment')">
                        商户返利（全部执行）
                    </button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doNoTenderAudit')">
                        未满标复核通知
                    </button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doProductTender')">
                        出借产品开标提醒
                    </button>
                </div>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doReconciliation')">自动对账</button>
                </div> --%>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doRepaymentWarnAndPrompt')">
                        还款提醒 催款通知
                    </button>
                </div>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoUpdateUserBankCard','all')">同步所有绑卡信息</button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoUpdateUserBankCard','error')">同步系统绑卡信息有误的绑卡信息</button>
                </div> --%>
                <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doRelationCheck('false')">用户推荐关系检测</button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doRelationCheck('true')">用户推荐关系更改</button>
                </div>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doAutoAttentionProduct')">关注投顾新产品发布提醒</button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doAutoInsuranceBookings')">预约保险记录提醒</button>
                </div> --%>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStackProduct('${pageContext.request.contextPath}/business/timer/doAutofindproductTenders')">向融途网推送产品信息</button>
                </div> --%>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doMerchantAccountRemind')">
                        平台商账户充值提醒
                    </button>
                </div>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doAutoSynchroFundNet')">同步前一天基金净值信息</button>
                    <a type="button" id="sysFundNetButton" class="btn btn-primary" href="${pageContext.request.contextPath}/business/fund/input/net/sysFundNet"> 同步指定日期净值数据</a>
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/doAutoSynchroFundGroupNet')">更新所有基金组合以往净值数据</button>
                </div> --%>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoRemindLotteryExpired')">
                        提醒奖券将要过期的用户
                    </button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoRemindProductExpiredToDep')">
                        次月产品到期提醒
                    </button>
                </div>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoUpdateRechargeLimit')">快捷充值限额同步</button>
                </div> --%>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoCalcOverdueInterest')">
                        立即生成逾期利息
                    </button>
                </div>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/userfeepayment/doUserFeePaymentQuartzJob')">用户向商户支付</button>
                </div> --%>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoElitePlanAvailableAmount')">立即更新可用额度(菁英计划)</button>
                </div> --%>
                <%-- <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoAddDateInfo')">更新当前年的节假日信息(计算提现手续费)</button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary" onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoMerCashCancel')">更新商户代取现签约到期信息(到期变为解约)</button>
                </div> --%>
                <div class="form-group">
                    <button type="button" class="btn btn-primary"
                            onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoEditUserMobile')">
                        同步用户签约手机号
                    </button>
                </div>
                <div class="form-group" id="autoSaveDisclosureFile">
                    <button type="button" class="btn btn-primary"
                            disabled="disabled" <%-- onclick="doTimeStack('${pageContext.request.contextPath}/business/timer/autoSaveDisclosureFile')" --%>>
                        下载互金披露企业数据表格
                    </button>

                    <c:forEach items="${fileNames}" var="fileName">
                        <br/><br/>
                        <a href="${pageContext.request.contextPath}/business/stats/operatordata/download/${fileName }">${fileName }.xls</a>
                    </c:forEach>
                </div>

            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>
<script type="text/javascript">
    var loading = '<img src="${pageContext.request.contextPath }/assets/ui/themes/base/img/finance/loading.gif">处理中...';

    function doTimeStack(url, info) {
        $.ajax({
            async: false,
            dataType: "text",
            url: url,
            data: "info=" + info,
            beforeSend: function () {
                dialog = bootbox.dialog({
                    message: loading,
                    closeButton: false
                });
            },
            complete: function () {
                dialog.modal("hide");
            },
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

    function reapalBatchTest(formId) {
        var productId = $("#" + formId + " input[name=productId]").val();
        /* if(!productId){
            return;
        } */
        var $form = $("#" + formId);
        var url = $form.attr("action");
        $.ajax({
            type: "post",
            dataType: "json",
            url: url,
            data: $form.serialize(),
            beforeSend: function () {
                dialog = bootbox.dialog({
                    message: loading,
                    closeButton: false
                });
            },
            complete: function () {
                dialog.modal("hide");
            },
            success: function (data) {
                var total = data.total;
                var message = data.message;
                bootbox.alert(message);
            },
            error: function () {
                bootbox.alert("发送失败，刷新页面重试！");
            }
        });

    }

    function doTimeStackProduct(url, info) {
        $.ajax({
            async: false,
            dataType: "text",
            url: url,
            data: "info=" + info,
            beforeSend: function () {
                dialog = bootbox.dialog({
                    message: loading,
                    closeButton: false
                });
            },
            complete: function () {
                dialog.modal("hide");
            },
            success: function (data) {
                if (data == 'false') {
                    bootbox.alert("操作失败！");
                } else {
                    var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
                    var code = obj.code;
                    var returnflag = returnFlag(code);
                    bootbox.alert(returnflag);
                }
            },
            error: function () {
                bootbox.alert("发送失败，刷新页面重试！");
            }
        });

    }

    function returnFlag(code) {
        if (code == "1") {
            return "操作成功！";
        } else if (code == "-1") {
            return "正在招标的数据为空或返回格式有误（参数borrow为空或者格式不对）！";
        } else if (code == "-2") {
            return "平台数据为空或返回格式有误（参数list为空或者格式不对）！";
        } else if (code == "-3") {
            return "档案id不合法（不是数字或者小于0，或未通过审核）！";
        } else if (code == "-4") {
            return "标的id为空！";
        } else if (code == "-5") {
            return "借款人为空！";
        } else if (code == "-6") {
            return "标名称为空！";
        } else if (code == "-7") {
            return "标详细地址为空！";
        } else if (code == "-8") {
            return "标类型为空！";
        } else if (code == "-9") {
            return "标的借款金额非法！";
        } else if (code == "-10") {
            return "已经成功借款的金额非法！";
        } else if (code == "-11") {
            return "年利率不合法！";
        } else if (code == "-12") {
            return "类型为天标，但是天数为0！";
        } else if (code == "-13") {
            return "类型为天标，但是月数不为0！";
        } else if (code == "-14") {
            return "类型为月标，但是天数不为0！";
        } else if (code == "-15") {
            return "类型为月标，但是月数为0！";
        } else if (code == "-16") {
            return "还款方式为空！";
        } else if (code == "-17") {
            return "奖励类型为百分比，但是百分比为0！";
        } else if (code == "-18") {
            return "奖励类型为实际奖励，但是实际奖励为0！";
        } else if (code == "-19") {
            return "发标时间为空！";
        } else if (code == "-20") {
            return "起投金额不合法！";
        } else if (code == "-21") {
            return "30天内每天的平均年利率不符合要求（不足30天，或不是数组格式）！";
        } else if (code == "-22") {
            return "平台借款期限分布为空或不合法！";
        } else if (code == "-23") {
            return "30天内借款金额分布不符合要求（不足30天，或不是数组格式）！";
        } else if (code == "-24") {
            return "30天内每天成交量不符合要求（不足30天，或不是数组格式）！";
        } else if (code == "-25") {
            return "平台总成交量为空或0！";
        } else if (code == "-26") {
            return "平台总待还为空或0！";
        } else if (code == "-27") {
            return "前一天的平均利率为空或者0！";
        } else if (code == "-28") {
            return "请求时间太频繁！";
        } else if (code == "-29") {
            return "借款金额为0或者为空！";
        } else if (code == "-30") {
            return "标必须是二维数组！";
        } else if (code == "-31") {
            return "当前标投标次数为空！";
        } else if (code == "-32") {
            return "当前标已完成投标额度为空！";
        } else if (code == "-33") {
            return "unix时间戳为空！";
        } else if (code == "-34") {
            return "奖励比例为空或者不大于0！";
        } else if (code == "-35") {
            return "借款人为空！";
        } else if (code == "-36") {
            return "标名为空！";
        }

    }

    function doRelationCheck(condition) {
        var url = "${pageContext.request.contextPath}/business/timer/doUserRecommendRelationCheck?condition=" + condition;
        if (condition == 'true') {
            bootbox.confirm('您确定要对用户关系数据进行更改么?', function (confirmed) {
                if (confirmed) {
                    doTimeStack(url);
                }
            });
        } else {
            doTimeStack(url);
        }
    }

    $("#sysFundNetButton").colorbox({iframe: true, width: "50%", height: "60%", scrolling: true});

    //下载xls文件
    /* $(function(){
    	
    	var d = new Date();
    	var year = d.getFullYear();
    	var month = d.getMonth();
    	var len = (year - 2018) * 12 + (month - 2 + 1);
    	for(var i = 1; i <= len; i++) {
    		var d1 = Date.parse("2018-02");
        	d1.setMonth(d1.getMonth() + i - 1);
        	var preTime = dateFmt("yyyy-MM",d1);
        	var month = d1.getMonth() + 1;
    		$("#autoSaveDisclosureFile").append('<br/><br/>'
    				+ '<a href="${pageContext.request.contextPath}/business/stats/operatordata/download/企业数据报送_' + preTime +'">企业数据报送_' + preTime + '.xls</a>'
    				+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
					+ '<a href="${pageContext.request.contextPath}/business/stats/operatordata/download/互金信息披露报数_' + preTime +'">互金信息披露报数' + preTime + '.xls</a>');
    	}
    }) */

</script>
</html>