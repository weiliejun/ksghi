<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>管理控制台首页</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/highcharts.jsp" %>
    <style type="text/css">
        .page-header {
            padding: 0 0 10px 30px;
            margin: 20px 0 30px;
            border-bottom: 1px solid #eee;
        }

        .page-header h4 {
            color: #3764a0;
            font-size: 18px;
            font-weight: bold;
        }

        .list-group {
            margin-right: 20px;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>管理控制台首页</h4>
                </div>
            </div>
            <div class="row hide">
                <div class="col-md-9 right-border">
                    <div id="chart-container" style="min-width: 500px; height: 100%"></div>
                </div>

                <div id="right-panel" class="col-md-3">
                    <div class="list-group">
                        <a href="#" class="list-group-item active">网站今日访问统计</a> <a href="#" class="list-group-item">网站最近7日访问统计</a>
                        <a href="#" class="list-group-item">网站最近30日访问统计</a>
                    </div>
                    <div class="callout callout-info">
                        <ul class="link-groups">
                            <li class="header">其它链接</li>
                            <!-- <li><a href="javascript:changePassword();return;"><i class="icon-key"></i>修改密码</a></li> -->
                            <li><a href="#"><i class="icon-file4"></i>操作指南</a></li>
                            <li><a href="#"><i class="icon-bubble2"></i>在线帮助</a></li>
                            <li><a href="#"><i class="icon-phone"></i>电话咨询</a></li>
                            <li class="last"><a href="#"><i class="icon-envelope"></i>建议反馈</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">

    $(document).ready(function () {


    });

    function changePassword() {
        $.colorbox({
            href: "${pageContext.request.contextPath}/index/password/change",
            iframe: true,
            width: "560px",
            height: "430px"
        });
    }


    $(function () {
        $('#chart-container').highcharts({
            colors: ['#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4'],
            chart: {
                type: 'spline'
            },
            title: {
                text: '网站今日访问统计',
                style: {
                    color: '#666',
                    font: '16px "Open Sans",Arial,"Hiragino Sans GB","Microsoft YaHei","微软雅黑",STHeiti,"WenQuanYi Micro Hei",SimSun,sans-serif'
                }
            },
            subtitle: {
                text: ''
            },
            xAxis: {
                title: {text: '访问时间（0点-24点）'},
                min: 1,
                max: 24,
                tickInterval: 1
            },
            yAxis: {
                title: {text: '访问次数'},
                min: 0
            },
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + '</b><br/>' + (this.x == 0 ? '昨日23' : (this.x - 1)) + '点—' + this.x + '点 : ' + this.y + ' 次访问';
                }
            },
            series: [
                {
                    name: 'PV访问量',
                    data: [[1, 120], [2, 133], [3, 140], [4, 150], [5, 165], [6, 185], [7, 195], [8, 200], [9, 1000], [10, 1202], [11, 1300], [12, 1200], [13, 1102], [14, 987], [15, 765], [16, 1200], [17, 1102], [18, 1002], [19, 879], [20, 600], [21, 400], [22, 201], [23, 167], [24, 137]]
                },
                {
                    name: 'UV访问量',
                    data: [[1, 60], [2, 73], [3, 60], [4, 60], [5, 65], [6, 85], [7, 95], [8, 100], [9, 400], [10, 602], [11, 500], [12, 700], [13, 502], [14, 487], [15, 365], [16, 500], [17, 702], [18, 502], [19, 479], [20, 300], [21, 200], [22, 101], [23, 87], [24, 67]]
                }
            ]
        });
    });

</script>
</html>
