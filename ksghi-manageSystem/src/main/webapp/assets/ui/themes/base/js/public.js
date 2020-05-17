$(document).ready(function() {
	var scrolltoTop = $("#scroll-top");
	$(scrolltoTop).hide();
	$(window).scroll(function() {
		if ($(window).scrollTop() == "0") {
			$(scrolltoTop).fadeOut("fast");
		} else {
			$(scrolltoTop).fadeIn("fast");
		}
	});
	$(scrolltoTop).click(function() {
		$("html,body").animate({
			scrollTop : 0
		}, 1000);
		return false;
	});
});

function openmodal(src, title, width, height) {
	var iframe = '<div id="simplemodal-modal-content">' + '<div id="simplemodal-modal-title">' + '<div class="close"><a href="#" class="simplemodal-close">x</a></div>' + title + '</div>' + '<div id="simplemodal-modal-data">' + '<iframe width="' + (width - 30) + '" height="' + (height - 60) + '"src="' + src + '" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe>' + '</div>' + '</div>';
	var option = {
	escClose : true,
	close : true,
	minHeight : height,
	minWidth : width,
	autoResize : true,
	closeHTML : null,
	opacity : 65,
	position : ['0', ],
	overlayClose : true
	};
	$.simplemodal(iframe, option);
}

function setAllCheckboxState(formname, checkboxname, checked) {
	var form = document.getElementsByName(formname)[0];
	if (!form.elements[checkboxname]) {
		return;
	}
	for (i = 0; i < form.elements[checkboxname].length; i++) {
		if (!form.elements[checkboxname][i].disabled) {
			form.elements[checkboxname][i].checked = checked;
		}
	}
};

function getRadioValue(formobj, radioName) {
	var value = "";
	for (var j = 0; j < formobj.elements.length; j++) {
		if (formobj.elements[j].type == "radio" && formobj.elements[j].name == radioName) {
			if (formobj.elements[j].checked == true) {
				value = formobj.elements[j].value;
				break;
			}
		}
	}
	return value;
}

function getCheckboxValue(formobj, checkboxName, separator) {
	var totalValues = "";
	with (formobj) {
		for (var j = 0; j < elements.length; j++) {
			if ((elements[j].type == "checkbox") && (elements[j].name == checkboxName)) {
				if (elements[j].checked == true) {
					var idx = elements[j].value;
					totalValues = totalValues + separator + idx;
				}
			}
		}
		if (totalValues.length > 0) {
			totalValues = totalValues.substring(1, totalValues.length);
		}
	}
	return totalValues;
}

function shorten(str, len) {
	if (typeof str === null) {
		return;
	}

	if (str.length > len) {
		return str.substring(0, len) + "…";
	} else {
		return str;
	}
}

function timeAgo(date_str) {
	date_str = date_str.replace('+0000', 'Z');
	var time_formats = [[60, 'just now', 1], [120, '1 minute ago', '1 minute from now'], [3600, 'minutes ago', 60], [7200, '1 hour ago', '1 hour from now'], [86400, 'hours ago', 3600], [172800, 'yesterday', 'tomorrow'], [604800, 'days ago', 86400], [1209600, 'last week', 'next week'], [2419200, 'weeks ago', 604800], [4838400, 'last month', 'next month'], [29030400, 'months ago', 2419200], [58060800, 'last year', 'next year'], [2903040000, 'years ago', 29030400], [5806080000, 'last century', 'next century'], [58060800000, 'centuries ago', 2903040000]];
	var time = ('' + date_str).replace(/-/g, "/").replace(/[TZ]/g, " ").replace(/^\s\s*/, '').replace(/\s\s*$/, '');
	if (time.substr(time.length - 4, 1) == ".")
		time = time.substr(0, time.length - 4);
	var seconds = (new Date - new Date(time)) / 1000;
	var token = '', list_choice = 1;
	if (seconds < 0) {
		seconds = Math.abs(seconds);
		token = 'ago';
		list_choice = 2;
	}
	var i = 0, format;
	while (format = time_formats[i++])
		if (seconds < format[0]) {
			if (typeof format[2] == 'string')
				return format[list_choice];
			else
				return Math.floor(seconds / format[2]) + ' ' + format[1] + ' ' + token;
		}
	return time;
}

// 检查身份证是否是正确格式
function checkCard(cId) {
	var pattern;
	if (cId.length == 15) {
		pattern = /^\d{15}$/;// 正则表达式,15位且全是数字
		if (pattern.exec(cId) == null) {
			return false;
		}
		if (!isdate("19" + cId.substring(6, 8), cId.substring(8, 10), cId.substring(10, 12))) {
			return false;
		}
	} else if (cId.length == 18) {
		pattern = /^\d{17}(\d|x|X)$/;// 正则表达式,18位且前17位全是数字，最后一位只能数字,x,X
		if (pattern.exec(cId) == null) {
			return false;
		}
		if (!isdate(cId.substring(6, 10), cId.substring(10, 12), cId.substring(12, 14))) {
			return false;
		}
		var strJiaoYan = ["1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"];
		var intQuan = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1];
		var intTemp = 0;
		for (var i = 0; i < cId.length - 1; i++)
			intTemp += cId.substring(i, i + 1) * intQuan[i];
		intTemp %= 11;
		if (cId.substring(cId.length - 1, cId.length).toUpperCase() != strJiaoYan[intTemp]) {
			return false;
		}
	} else {
		return false;
	}
	return true;
}

function isdate(intYear, intMonth, intDay) {
	if (isNaN(intYear) || isNaN(intMonth) || isNaN(intDay))
		return false;
	if (intMonth > 12 || intMonth < 1)
		return false;
	if (intDay < 1 || intDay > 31)
		return false;
	if ((intMonth == 4 || intMonth == 6 || intMonth == 9 || intMonth == 11) && (intDay > 30))
		return false;
	if (intMonth == 2) {
		if (intDay > 29)
			return false;
		if ((((intYear % 100 == 0) && (intYear % 400 != 0)) || (intYear % 4 != 0)) && (intDay > 28))
			return false;
	}
	return true;
}

function formatNum(str) {
	var newStr = "";
	var count = 0;

	if (str.indexOf(".") == -1) {
		for (var i = str.length - 1; i >= 0; i--) {
			if (count % 3 == 0 && count != 0) {
				newStr = str.charAt(i) + "," + newStr;
			} else {
				newStr = str.charAt(i) + newStr;
			}
			count++;
		}
		str = newStr + ".00"; // 自动补小数点后两位
		console.log(str)
	} else {
		for (var i = str.indexOf(".") - 1; i >= 0; i--) {
			if (count % 3 == 0 && count != 0) {
				newStr = str.charAt(i) + "," + newStr; // 碰到3的倍数则加上“,”号
			} else {
				newStr = str.charAt(i) + newStr; // 逐个字符相接起来
			}
			count++;
		}
		str = newStr + (str + "00").substr((str + "00").indexOf("."), 3);
		console.log(str)
	}
}

function phoneCall(callurl) {
	// url="http://api.clink.cn/interface/PreviewOutcall?enterpriseId=3001162&cno=1003&pwd=0a87901f6d325604709242e8f9de4c49&customerNumber=15321151619";
	var url = pageContext.contextPath + "/business/user/manage/callphone?url=" + encodeURIComponent(callurl);
	// alert(url);
	$.ajax({
	type : "get",
	async : false,
	url : url,
	dataType : 'text',
	success : function(json) {
		var obj = jQuery.parseJSON(json); // 由JSON字符串转换为JSON对象
		if (obj.res == 0) {
			bootbox.alert("座席已接听");
		} else if (obj.res == 1) {
			bootbox.alert("呼叫座席失败");
		} else if (obj.res == 2) {
			bootbox.alert("参数不正确");
		} else if (obj.res == 3) {
			bootbox.alert("用户验证没有通过");
		} else if (obj.res == 4) {
			bootbox.alert("账号被停用");
		} else if (obj.res == 5) {
			bootbox.alert("资费不足");
		} else if (obj.res == 6) {
			bootbox.alert("指定的业务尚未开通");
		} else if (obj.res == 7) {
			bootbox.alert("电话号码不正确");
		} else if (obj.res == 8) {
			bootbox.alert("座席工号（cno）不存在");
		} else if (obj.res == 9) {
			bootbox.alert("座席状态不为空闲，可能未登录或忙");
		} else if (obj.res == 10) {
			bootbox.alert("其他错误");
		} else if (obj.res == 11) {
			bootbox.alert("电话号码为黑名单");
		} else if (obj.res == 12) {
			bootbox.alert("座席不在线");
		} else if (obj.res == 13) {
			bootbox.alert("座席正在通话/呼叫中");
		} else if (obj.res == 14) {
			bootbox.alert("透传号码不正确");
		}
	},
	error : function(XMLHttpRequest, textStatus, errorThrown) {
		alert(errorThrown);
	}
	});
}

function CloseWebPage() {
	if (navigator.userAgent.indexOf("MSIE") > 0) {
		if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
			window.opener = null;
			window.close();
		} else {
			window.open('', '_top');
			window.top.close();
		}
	} else if (navigator.userAgent.indexOf("Firefox") > 0) {
		window.location.href = 'about:blank ';
		// window.history.go(-2);
	} else {
		window.opener = null;
		window.open('', '_self', '');
		window.close();
	}
}

function myClearForm(formId) {
	$(':input', '#' + formId).not(':button,:submit,:reset,:hidden,:checkbox').val('').removeAttr('selected');
	$("#" + formId +" input:checked").removeAttr('checked');
	$('#' + formId + ' select[multiple=multiple]').each(function() {
		var $this = $(this);
		var id = $this.attr("id");
		if (id) {
			$("#" + id).multiselect().val([]).multiselect("refresh");// 清空Bootstrap
																		// Multiselect多选框
		}
	});
}
/*
 * 循环表格的校验，将表单的name属性还原
 * formId:表单Id
 * separator:分隔符
 * */
function resetInputName(formId,separator){
	$(':input', '#' + formId).not(':button,:submit,:reset').each(function(){
		var $this = $(this);
		var name = $this.attr("name");
		if(name){
			var index = name.indexOf(separator);
			if(index >= 0){
				 $this.attr("name",name.substring(0,index));
			}
		}
	});
}

//将form表格里的数据，序列化成JSON 对象形式  (例如:{"id":"22","name":"xsp","createTime":"2016-11-11"}),传入参数为表单 id
function serializeJSON(id){
	var dataArray = $("#"+id).serializeArray();
	var o={};  
	jQuery.each(dataArray, function(i, dataArray){  
		if(o[this.name]){      
			if(!o[this.name].push){     
				o[this.name]=[o[this.name]];      
			}    
			o[this.name].push(this.value || ''); 
		}else{    
			o[this.name]=this.value || '';  
		}  
	});
	//将json对象转换成json字符串
	//JSON.stringify(o);
	return o;
}

//复选框   默认选中，支持(1、[a,b,c]; 2、["a","b","c"]; 3、"a,b,c")形式的数据             author:xsp;
function checkedDefault(data){
	var dataOrg = data.replace(/\s+/g, "").replace(/\"/g,"").replace("[","").replace("]","");
	var datas = dataOrg.split(",");
	for(var i = 0 ; i < datas.length; i++){
		var dataRes = datas[i];
		$("input[type='checkbox'][value='"+dataRes+"']").attr("checked","checked");
	}
}

/******************************时间格式化处理********2018.02.22*****xsp***********************/
function dateFmt(fmt,date)   
{ //author: meizz   
  var o = {   
    "M+" : date.getMonth()+1,                 //月份   
    "d+" : date.getDate(),                    //日   
    "h+" : date.getHours(),                   //小时   
    "m+" : date.getMinutes(),                 //分   
    "s+" : date.getSeconds(),                 //秒   
    "q+" : Math.floor((date.getMonth()+3)/3), //季度   
    "S"  : date.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}
