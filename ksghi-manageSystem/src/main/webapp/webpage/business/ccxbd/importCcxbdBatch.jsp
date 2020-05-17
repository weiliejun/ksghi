<%@ page contentType="text/html;charset=UTF-8" %>
<%
    double perMaxSize = 3;//单个文件允许的max大小
    String sizeUnit = "MB";//perMaxSize数据对应的单位
    String ext = "*.xls";//允许上传的文件类型
    //文件上传提交的目标页面
    StringBuffer uploadUrl = new StringBuffer("http://");
    uploadUrl.append(request.getHeader("Host"));
    uploadUrl.append(request.getContextPath());
    uploadUrl.append("/admin/swfuploadexample/UploadFileExampleSubmit.jsp");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>批量文件上传</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/swfupload/default.css"
          rel="stylesheet" type="text/css"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/swfupload/swfupload.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/swfupload/swfupload.swfobject.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/swfupload/swfupload.queue.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/swfupload/fileprogress.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/swfupload/handlers.js"></script>
    <script type="text/javascript">

        var swfu;
        window.onload = function () {
            var settings = {
                flash_url: "${pageContext.request.contextPath}/swfupload/swfupload.swf",
                flash9_url: "${pageContext.request.contextPath}/swfupload/swfupload_fp9.swf",
                //upload_url: "${pageContext.request.contextPath}/UploadFilesAction.do?method=importTestQuesWordBatch",  // Relative to the SWF file
                upload_url: "${pageContext.request.contextPath}/uploadFiles?method=importTestQuesWordBatch&lmsframeworkSessionid=<%= request.getSession().getId() %>",	// Relative to the SWF file
                post_params: {
                    "isopen": getRadioValue(document.forms[0], "isopen"),
                    "user_id": "stephen830",
                    "pass_id": "123456"
                },
                file_size_limit: "<%=perMaxSize%> <%=sizeUnit%>",
                file_types: "<%=ext%>",
                file_types_description: "<%=ext%>",
                file_upload_limit: 0,
                file_queue_limit: 0,
                custom_settings: {
                    progressTarget: "fsUploadProgress",
                    cancelButtonId: "btnCancel",
                    uploadButtonId: "btnUpload",
                    startButton: "startButton",
                    myFileListTarget: "idFileList"
                },
                debug: false,
                auto_upload: false,
                use_query_string: true,
                file_post_name: "imageFile",

                // Button Settings
                button_image_url: "${pageContext.request.contextPath}/swfupload/XPButtonNoText_61x22.png",	// Relative to the SWF file
                button_placeholder_id: "spanButtonPlaceholder",
                button_text: '<span class="theFont">选择文件</span>',
                button_text_style: ".theFont { font-size: 12; }",
                //button_text_style : ".redText { color: #FF0000; }",
                button_text_left_padding: 3,
                button_text_top_padding: 2,
                button_action: SWFUpload.BUTTON_ACTION.SELECT_FILES,
                button_width: 61,
                button_height: 22,

                // The event handler functions are defined in handlers.js
                swfupload_loaded_handler: swfUploadLoaded,
                file_queued_handler: fileQueued,
                file_queue_error_handler: fileQueueError,
                file_dialog_complete_handler: fileDialogComplete,
                upload_start_handler: uploadStart,
                upload_progress_handler: uploadProgress,
                upload_error_handler: uploadError,
                upload_success_handler: uploadSuccess,
                upload_complete_handler: uploadComplete,
                queue_complete_handler: queueComplete,	// Queue plugin event

                // SWFObject settings
                minimum_flash_version: "9.0.28",
                swfupload_pre_load_handler: swfUploadPreLoad,
                swfupload_load_failed_handler: swfUploadLoadFailed
            };

            swfu = new SWFUpload(settings);
        }

        function _changeIsopen(isopen) {
            swfu.setPostParams({'isopen': '1'});
        }
    </script>
</head>
<body bgcolor="#FCFCFC" topmargin="0px" leftmargin="10px"
      rightmargin="10px" scroll="yes">

<table width="100%" cellspacing="4" cellpadding="4" border="0"
       bgcolor="#FCFCFC">
    <tr>
        <td class="DH1">
            <table width="100%" cellspacing="4" cellpadding="4" border="0"
                   bgcolor="#FCFCFC">
                <tr>
                    <td class="DH2">
                        <STRONG>批量上传文件 （支持的文件类型：<%=ext%>；单个文件最大不能超过：<%=perMaxSize%>
                            <%=sizeUnit%>）</STRONG>
                    </td>
                    <td class="DH2" align="right"></td>
                </tr>
            </table>
            <div id="content">
                <form id="form1" action="" method="post"
                      enctype="multipart/form-data">
                    <table width="100%" cellspacing="4" cellpadding="4" border="0"
                           bgcolor="#FCFCFC">
                        <html:hidden property="isopen" value="1"/>
                        <%--<tr>
                            <td width="15%">
                                <bean:message key="resourecemanage.resourcebasic.isopen"
                                    bundle="resourcemanage" />
                                ：
                            </td>
                            <td colspan="3">
                                <INPUT TYPE="radio" NAME="isopen" value="1" checked
                                    onclick="_changeIsopen(this.value);">
                                完全公开 &nbsp;
                                <INPUT TYPE="radio" NAME="isopen" value="3"
                                    onclick="_changeIsopen(this.value);">
                                不公开
                                <font color="red">*</font>
                            </td>
                        </tr>
                    --%></table>
                    <div
                            style="width: 90%; height: 18px; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
                        <table width="90%" cellspacing="0" cellpadding="0" border="0">
                            <tr>
                                <td>
                                    <span id="spanButtonPlaceholder"></span>&nbsp;&nbsp;
                                    <input id="btnUpload" type="button" value="上传文件" class="theFont"
                                           onclick="swfu.startUpload();"/>
                                    <input id="btnCancel" type="button" value="取消全部上传"
                                           disabled="disabled" class="theFont"/>
                                    <input id="prtCancel" type="button" value="打印页面" class="theFont"
                                           onclick="javascript:window.print();"/>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <table id="idFileList" class="uploadFileList">
                        <tr class="uploadTitle">
                            <td>
                                <B>文件名</B>
                            </td>
                            <td>
                                <B>文件大小</B>
                            </td>
                            <td width=100px>
                                <B>状态</B>
                            </td>
                            <td width=35px>
                                &nbsp;
                            </td>
                        </tr>
                    </table>
                    等待上传
                    <span id="idFileListCount">0</span> 个 ，成功上传
                    <span id="idFileListSuccessUploadCount">0</span> 个
                    <div id="divSWFUploadUI" style="visibility: hidden;"></div>
                    <noscript
                            style="display: block; margin: 10px 25px; padding: 10px 15px;">
                        很抱歉，文件上传界面无法载入，请将浏览器设置成支持JavaScript。
                    </noscript>
                    <div id="divLoadingContent" class="content"
                         style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
                        文件上传界面正在载入，请稍后...
                    </div>
                    <div id="divLongLoading" class="content"
                         style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
                        文件上传界面载入失败，请确保浏览器已经开启对JavaScript的支持，并且已经安装可以工作的Flash插件版本。
                    </div>
                    <div id="divAlternateContent" class="content"
                         style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
                        很抱歉，文件上传界面无法载入，请安装或者升级您的Flash插件。 请访问：
                        <a
                                href="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"
                                target="_blank">Adobe网站</a> 获取最新的Flash插件。
                    </div>
                </form>
            </div>
        </td>
    </tr>
</table>
</body>
</html>