//产品累计收益
$(function () {
	var colorSt = [ '#0077bb', '#ff9911', '#e04d2b'];
        createChart = function (seriesOptions,domObj) {
    		Highcharts.setOptions({
                lang:{
    	            loading:'loading',
    	            rangeSelectorZoom:[ '选择时间'],
    	            months: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'], 
    	            shortMonths: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'], 
    	            weekdays: ['星期天', '星期一', '星期二', '星期三', '星期四', '星期11', '星期六']
                }
           });

    		$(domObj).highcharts('StockChart', {
    			chart: {
                    marginRight: 200
                },
    			exporting:{  enabled:false },
                credits:{  enabled: false},
                scrollbar:{
                    enabled:false
                },
                navigator:{
                    enabled: false
                },
                xAxis:{  
                    // 如果X轴刻度是日期或时间，该配置是格式化日期及时间显示格式  
                    dateTimeLabelFormats: {  
                        day: '%Y<br/>%m-%d',  
                        week: '%Y<br/>%m-%d',  
                        month: '%Y-%m',  
                        year: '%Y'  
                    }
                },
                yAxis: {
                	opposite:false,
                	tickAmount: 5,
                    labels: {           	
                        formatter: function () {
                            return (this.value > 0 ? ' + ' : '') + Highcharts.numberFormat(this.value, 2) +'%';
                        },
                        x:-8,
                        align: "left", 
                    }
                },
                
                plotOptions: {
                    series: {
                        compare: 'percent'
                    }
                },
    			rangeSelector: {  
                    buttons: [
                       {  
                            type: 'month',  
                            count: 1,  
                            text: '近1月'  
                        },{  
                            type: 'month',  
                            count: 3,  
                            text: '近3月'  
                        }, {  
                            type: 'month',  
                            count: 6,  
                            text: '近6月'  
                        }, {  
                            type: 'year',  
                            count: 1,  
                            text: '近1年'  
                        } , {
                        	type: 'ytd',
                        	text: '今年以来'
                        }, {  
                            type: 'all',  
                            text: '成立以来'  
                        }], 
                        
	        	 selected: 3,  
	             inputEnabled: false ,
	             buttonTheme: {
	            	 width: 50,
	            	 height: 16,
	            	 padding: 1,
	            	 r: 0,
	            	 stroke: '#68A',
	            	 zIndex: 7
	            	 }
	            
	            },
    	        title : {
    	            text : ''
    	        },
    	        legend:{
            	    align: "right", 
   					verticalAlign: "right", 
					enabled: true,
					floating: false,
					itemDistance: 20,
					itemHiddenStyle:{},
					itemHoverStyle: {},
					itemMarginBottom: 10,
					itemMarginTop: 10,
					itemWidth: 100,
					itemHight: 10,
					layout: "vertical",
					x:-20,
					y:100
               },
	    	   tooltip: {
	                    dateTimeLabelFormats: {  
	                        millisecond:"Y-%m-%d, %H:%M:%S.%L",
	                  	    second:"Y-%m-%d, %H:%M:%S",
	                  	    minute:"Y-%m-%d, %H:%M",
	                  	    hour:"Y-%m-%d, %H:%M",
	                  	    day: '%Y-%m-%d',  
	                  	    week:"Y-%m-%d, %A",
	                  	    month: '%Y-%m',  
	                  	    year:"%Y"
	                  }  ,
	              pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.change}</b> %<br/>',
	              valueDecimals: 2
	          },
	          colors:colorSt,
	    	  series: seriesOptions
    	  });
       };
      //产品净值  
        createChartWorth = function (seriesOptionsworth,domObj) {
           Highcharts.setOptions({
	             lang:{  
		            loading:'loading',
		            rangeSelectorZoom:[ '选择时间'],
		            months: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'], 
		            shortMonths: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'], 
		            weekdays: ['星期天', '星期一', '星期二', '星期三', '星期四', '星期11', '星期六']
	             }
	        });

            $(domObj).highcharts('StockChart', {
            	 chart: {
                     marginRight: 200
                 },
               	 exporting:{  enabled:false },
                 credits:{  enabled: false},
                 scrollbar:{
                	 enabled:false
                 },
                 navigator:{
                	 enabled: false
                 },
                 //
                 xAxis:{  
                     // 如果X轴刻度是日期或时间，该配置是格式化日期及时间显示格式  
                     dateTimeLabelFormats: {  
                         day: '%Y<br/>%m-%d',  
                         week: '%Y<br/>%m-%d',  
                         month: '%Y-%m',  
                         year: '%Y'  
                     }  ,
                     plotLines: [{
                     value: 0,
                     width: 1,
                     color: 'silver'
                 }]
                 },
                 yAxis: {
                	 //tickPositions: [0, 20, 50, 100] // 指定竖轴坐标点的值
                	 //allowDecimals:false ,//是否允许刻度有小数
                	 //tickInterval: 0.0001,  //自定义刻度  
                	 opposite:false,
                	 tickAmount: 5,
                	 labels: {
                		 formatter: function () {
                			// return '';
                			 return (this.value > 0 ? ' + ' : '') + Highcharts.numberFormat(this.value, 2)   ;
                		 }
                	 },
                	 plotLines: [{
                		 value: 0,
                		 width: 2,
                		 color: 'silver'
                	 }]
                 },
                 //
                 rangeSelector: {  
                        buttons: [
                           {  
                                type: 'month',  
                                count: 3,  
                                text: '近3月'  
                            }, {  
                                type: 'month',  
                                count: 6,  
                                text: '近6月'  
                            }, {  
                                type: 'year',  
                                count: 1,  
                                text: '近1年'  
                            } , {
                            	type: 'ytd',
                            	text: '今年以来'
                            },{  
                                type: 'all',  
                                text: '成立以来'  
                            }],  
            	 selected: 3,  
                 inputEnabled: false ,
                 buttonTheme: {
                	 width: 50,
                	 height: 16,
                	 padding: 1,
                	 r: 0,
                	 stroke: '#68A',
                	 zIndex: 7
                	 }
                
                }, 
                title : {
    	            text : ''
    	        },
                legend:{
                	    align: "right", 
	   					verticalAlign: "right", 
						enabled: true,
						floating: false,
						itemDistance: 20,
						itemHiddenStyle:{},
						itemHoverStyle: {},
						itemMarginBottom: 10,
						itemMarginTop: 10,
						itemWidth: 100,
						itemHight: 10,
						layout: "vertical",
						x:-20,
						y:100
                },
                tooltip: {
                     /* dateTimeLabelFormats: {  
                        day: '%Y-%m-%d',  
                        week: '%-Y%m-%d',  
                        month: '%Y-%m',  
                        year: '%Y'  
                    }  ,*/
                	dateTimeLabelFormats:{
                	    millisecond:"Y-%m-%d, %H:%M:%S.%L",
                	    second:"Y-%m-%d, %H:%M:%S",
                	    minute:"Y-%m-%d, %H:%M",
                	    hour:"Y-%m-%d, %H:%M",
                	    day: '%Y-%m-%d',  
                	    week:"Y-%m-%d, %A",
                	    month: '%Y-%m',  
                	    year:"%Y"
                	},
                    pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> <br/>',
                    valueDecimals: 2
                },
                colors:colorSt,
                series: seriesOptionsworth
            });
        };

});


