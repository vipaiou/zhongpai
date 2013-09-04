<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${ctx}/resources/swfupload/css/default.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="${ctx}/resources/swfupload/css/button.css"
	type="text/css" />

<link rel="stylesheet" type="text/css"
	href="${ctx}/resources/swfupload/ext/resources/css/ext-all.css" />
<script type="text/javascript"
	src="${ctx}/resources/swfupload/ext/adapter/ext/ext-base.js">
</script>
<script type="text/javascript"
	src="${ctx}/resources/swfupload/ext/ext-all.js">
</script>
<script type="text/javascript"
	src="${ctx}/resources/swfupload/ext/ext-lang-zh_CN.js">
</script>

<script type="text/javascript"
	src="${ctx}/resources/swfupload/js/swfupload/swfupload.js">
	
</script>
<script type="text/javascript"
	src="${ctx}/resources/swfupload/js/swfupload/handlers.js">
	
</script>
<script type="text/javascript"
	src="${ctx}/resources/swfupload/js/swfupload/swfupload.js">
	
</script>
<script type="text/javascript"
	src="${ctx}/resources/swfupload/js/swfupload/handlers.js">
	
</script>

<script type="text/javascript">
	var swfu;
	window.onload = function() {
		swfu = new SWFUpload(
				{
					upload_url : "${ctx}/picUpload/upload.html",
					post_params : {
						"photoName" : document.getElementById("photoName").value
					},
					// File Upload Settings
					file_size_limit : "100 MB", // 1000MB
					file_types : "*.jpg;*.jpeg;*.bmp;*.gif",
					file_types_description : "图片格式",
					file_upload_limit : "0",

					file_queue_error_handler : fileQueueError,
					file_dialog_complete_handler : fileDialogComplete,//选择好文件后提交
					file_queued_handler : fileQueued,
					upload_progress_handler : uploadProgress,
					upload_error_handler : uploadError,
					upload_success_handler : uploadSuccess,
					upload_complete_handler : uploadComplete,

					// Button Settings
					button_image_url : "/gduser/resources/swfupload/images/SmallSpyGlassWithTransperancy_17x18.png",
					button_placeholder_id : "spanButtonPlaceholder",
					button_width : 180,
					button_height : 18,
					button_text : '<span class="button">选择图片 <span class="buttonSmall">(100 MB Max)</span></span>',
					button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; } .buttonSmall { font-size: 10pt; }',
					button_text_top_padding : 0,
					button_text_left_padding : 18,
					button_window_mode : SWFUpload.WINDOW_MODE.TRANSPARENT,
					button_cursor : SWFUpload.CURSOR.HAND,

					// Flash Settings
					flash_url : "/gduser/resources/swfupload/js/swfupload/swfupload.swf",

					custom_settings : {
						upload_target : "divFileProgressContainer"
					},
					// Debug Settings
					debug : false
				//是否显示调试窗口
				});
	};
	function startUploadFile() {
		var access = true;
		access = $('#myForm').validationEngine({
			returnIsValid : true
		})
		if (access == true) {
			swfu.startUpload();
		}

	}
	var win = new Ext.Window({
		title : 'SwfUpload',
		closeAction : 'hide',
		width : 750,
		height : 360,
		resizable : false,
		modal : true,
		html : '<iframe src="index.jsp" width="100%" height="100%"></iframe>'
	});
	function showExtShow() {
		win.show();
	}
</script>
</head>
<body>
	<div id="scrollContent">


		<div class="box2" panelWidth="700" panelHeight="400" panelTitle="照片上传"
			roller="true">
			<form id="myForm" action="${ctx}/picUpload/upload.html" method="post">
				<input type="hidden" value="${photoName}" id="photoName"
					name="photoName" />
				<div class="box1" panelWidth="650" panelHeight="330" roller="true">
					<table>
						<tr>
							<td><span id="spanButtonPlaceholder"></span></td>
							<td><input id="btnUpload" type="button" value="上  传"
								onclick="startUploadFile();" class="btn3_mouseout"
								onMouseUp="this.className='btn3_mouseup'"
								onmousedown="this.className='btn3_mousedown'"
								onMouseOver="this.className='btn3_mouseover'"
								onmouseout="this.className='btn3_mouseout'" /></td>
							<td><input id="btnCancel" type="button" value="取消所有上传"
								onclick="cancelUpload();" disabled="disabled"
								class="btn3_mouseout" onMouseUp="this.className='btn3_mouseup'"
								onmousedown="this.className='btn3_mousedown'"
								onMouseOver="this.className='btn3_mouseover'"
								onmouseout="this.className='btn3_mouseout'" /></td>
						</tr>
					</table>

					<div id="divFileProgressContainer"></div>
					<div id="thumbnails">
						<table id="infoTable" border="0" width="530"
							style="display: inline; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px; margin-top: 8px;">
						</table>
					</div>
				</div>
			</form>
		</div>

	</div>
</body>
</html>