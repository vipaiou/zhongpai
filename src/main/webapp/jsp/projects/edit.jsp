<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../include/header.jsp" %>
<link href="<s:url value="/demohour-index_files/projects-9afed8175e89fa73647b287e62737440.css" />" media="screen" rel="stylesheet" type="text/css">
	<div class="ui-tab">
		<div class="ui-tab-top">
			<h2>发起我的项目</h2>
		</div>
		<div class="ui-tab-layout">
			<ul class="ui-tab-menu">
				<li><a class="ui-tab-current"
					href="<%=request.getContextPath()%>/projects/edit/${project.id}">项目说明</a></li>
				<li><a href="<%=request.getContextPath()%>/projects/editreturn/${project.id}">回报设置</a></li>
				<li><a href="<%=request.getContextPath()%>/projects/editstatus/${project.id}">项目状态</a></li>
			</ul>
			<div class="ui-tab-menu-right">
				<div class="ui-button ui-button-blue">
					<span><a
						href="<%=request.getContextPath()%>messages?recipient_id=1013487"
						title="私信给 众拍网客服" class="ui-popup-message">联系客服</a></span>
				</div>
			</div>
		</div>
	</div>


	<form accept-charset="UTF-8"
		action="<s:url value="/projects/editbasic" />" class="edit_project"
		id="edit_project" method="post">
		<div style="margin: 0; padding: 0; display: inline">
			<input name="utf8" value="✓" type="hidden"><input
				name="_method" value="put" type="hidden"><input
				name="authenticity_token"
				value="mXPrIAvBs23PnmOfF1PE+JbSsr4Af0qcf0L0VwNiNsQ=" type="hidden">
				<input name="id" value="${projectId }" type="hidden">
		</div>
		<div id="new_project" class="projects-new">
			<div class="launchleft">
				<ul class="launchprojects">
					<li class="projecttype"><label>选择类别:</label>
						<div class="ui-radio">
						<c:forEach items="${categories }" var="category">
							<a href="#${category.id }" class="project_category">${category.name }</a>
						</c:forEach>
							<!-- <a href="#927151" class="project_category">设计</a> <a
								href="#927158" class="project_category">科技</a> <a href="#927159"
								class="project_category">音乐</a> <a href="#927156"
								class="project_category">影视</a> <a href="#927163"
								class="project_category">食品</a> <a href="#927152"
								class="project_category">动漫</a> <a href="#927161"
								class="project_category">出版</a> <a href="#927164"
								class="project_category">游戏</a> <a href="#927157"
								class="project_category">摄影</a> <a href="#927162"
								class="project_category">其他</a> -->
						</div> <input id="project_category_id" name="category" type="hidden" value=""${project.category }>
					</li>
					<li><label for="a001">项目名称:</label>
						<div class="ui-text">
							<div class="ui-text-right">
								<input autocomplete="off" id="project_name" name="name" value="${project.name }"
									placeholder="不超过25个字" size="30" type="text">
							</div>
						</div></li>
					<li class="launchsite"><label>发起地点:</label> <select
						id="project_province" name="province"><option
								selected="selected" value="">请选择</option>
							<option value="北京">北京</option>
							<option value="上海">上海</option>
							<option value="广东">广东</option>
							<option value="浙江">浙江</option>
							<option value="江苏">江苏</option>
							<option value="安徽">安徽</option>
							<option value="重庆">重庆</option>
							<option value="福建">福建</option>
							<option value="甘肃">甘肃</option>
							<option value="广西">广西</option>
							<option value="贵州">贵州</option>
							<option value="海南">海南</option>
							<option value="河北">河北</option>
							<option value="河南">河南</option>
							<option value="黑龙江">黑龙江</option>
							<option value="湖北">湖北</option>
							<option value="湖南">湖南</option>
							<option value="吉林">吉林</option>
							<option value="江西">江西</option>
							<option value="辽宁">辽宁</option>
							<option value="内蒙古">内蒙古</option>
							<option value="宁夏">宁夏</option>
							<option value="青海">青海</option>
							<option value="山东">山东</option>
							<option value="山西">山西</option>
							<option value="陕西">陕西</option>
							<option value="四川">四川</option>
							<option value="天津">天津</option>
							<option value="西藏">西藏</option>
							<option value="新疆">新疆</option>
							<option value="云南">云南</option>
							<option value="香港">香港</option>
							<option value="澳门">澳门</option>
							<option value="台湾">台湾</option>
							<option value="海外">海外</option></select> <select id="project_city"
						name="city"><option selected="selected" value="">请选择</option></select></li>
					<li><label>项目简介:</label>
						<div class="ui-textarea">
							<div class="ui-textarea-border">
								<textarea cols="0" id="project_summary" name="summary"
									placeholder="不超过75个字！" rows="0">${project.summary }</textarea>
							</div>
						</div></li>

					<li class="thumbnail launchleftthumbnail"><label>封面图片:</label>
						<div id="project_poster_button"></div> 
						<!-- <object id="SWFUpload_0" type="application/x-shockwave-flash" data="<%=request.getContextPath()%>/demohour-index_files/swfupload.swf" class="swfupload" height="32" width="80"><param name="wmode" value="window"><param name="movie" value="<%=request.getContextPath()%>/demohour-index_files/swfupload.swf?preventswfcaching=1376565941671"><param name="quality" value="high"><param name="menu" value="false"><param name="allowScriptAccess" value="always"><param name="wmode" value="transparent"><param name="flashvars" value="movieName=SWFUpload_0&amp;uploadURL=%2Fattachments%3Fsign%3D422aad69c1d0de87f36699ffee2c20cf89cd5a19fbf3c74aa75aeedca5b188d9%26amp%3Btarget_id%3D322193%26amp%3Btype%3Dproject_poster%26amp%3Buser_id%3D1121568&amp;useQueryString=false&amp;requeueOnError=false&amp;httpSuccess=&amp;assumeSuccessTimeout=0&amp;params=&amp;filePostName=Filedata&amp;fileTypes=*.jpg%3B*.gif%3B*.png%3B*.jpeg&amp;fileTypesDescription=%E5%9B%BE%E7%89%87%E6%96%87%E4%BB%B6&amp;fileSizeLimit=5120&amp;fileUploadLimit=0&amp;fileQueueLimit=0&amp;debugEnabled=false&amp;buttonImageURL=http%3A%2F%2Fassets.demohour.com%2Fassets%2Fupload-285b64cf3f94c8753e53c69150208bce.gif&amp;buttonWidth=80&amp;buttonHeight=32&amp;buttonText=&amp;buttonTextTopPadding=0&amp;buttonTextLeftPadding=0&amp;buttonTextStyle=color%3A%20%23000000%3B%20font-size%3A%2016pt%3B&amp;buttonAction=-100&amp;buttonDisabled=false&amp;buttonCursor=-1"></object> -->
						<span class="textprompts">支持jpg、jpeg、png、gif格式。不超过5MB！</span><span
						id="project_poster_url_error"></span><span id="project_poster"></span>
					</li>


					<li><label for="a001">宣传视频:</label>
						<div class="ui-text">
							<div class="ui-text-right">
								<input autocomplete="off" id="project_video_url" name="video" value="${project.video }"
									placeholder="（可选）输入视频地址（支持优酷、土豆、酷6、新浪视频）" size="30" type="text">
							</div>
						</div> <span id="project_video_url_error"></span></li>

					<li><label>详细描述:</label>
						<div id="ueditor_link_popup0"
							class="edui-popup-all edui-popup-img" style="display: none;">
							<div class="edui-popup-background">
								<div style="top: 83.5px;" class="edui-popup-all-content">
									<div class="edui-popup-table">
										<div class="edui-popup-top" id="ueditor_link_popup_top0">
											<span class="edui-dialog-caption">添加链接</span><a href="#"
												title="关闭" onfocus="this.blur();"
												class="ueditor_link_close0">关闭</a>
										</div>
										<div class="edui-popup-table-content">
											<input id="ueditor_link_href0" placeholder="输入链接地址"
												type="text"><span id="ueditor_link_error_msg0"></span>
											<div class="upload-img-list-b">
												<div class="upload-img-list-b-r">
													<a href="#" class="ueditor_link_close0" title="取消"
														onfocus="this.blur();">取消</a><a href="#"
														id="ueditor_link_submit0" title="确定"
														class="edui-upload-button" onfocus="this.blur();">确定</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="ueditor_video_popup0"
							class="edui-popup-all edui-popup-img" style="display: none;">
							<div class="edui-popup-background">
								<div style="top: 83.5px;" class="edui-popup-all-content">
									<div class="edui-popup-table">
										<div class="edui-popup-top" id="ueditor_video_popup_top0">
											<span class="edui-dialog-caption">添加视频</span><a href="#"
												title="关闭" onfocus="this.blur();"
												class="ueditor_video_close0">关闭</a>
										</div>
										<div class="edui-popup-table-content">
											<input id="ueditor_video_convert_url0"
												+="" value="/attachments?sign=b6f53725ce2cc8d6dd3325a9ea5636468fa26f1cd8765e8fb24e25b46b5594fe&target_id=322193&type=project_video&user_id=1121568"
												style="display: none"><input id="ueditor_video_url0"
												placeholder="输入视频地址（支持优酷、土豆、酷6、新浪视频）" type="text"><span
												id="ueditor_video_error_msg0"></span>
											<div class="upload-img-list-b">
												<div class="upload-img-list-b-r">
													<a href="#" class="ueditor_video_close0" title="取消"
														onfocus="this.blur();">取消</a><a href="#"
														id="ueditor_video_submit0" title="确定"
														class="edui-upload-button" onfocus="this.blur();">确定</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="ueditor_image_popup0"
							class="edui-popup-all edui-popup-img" style="display: none;">
							<div class="edui-popup-background">
								<div style="top: 83.5px;" class="edui-popup-all-content">
									<div class="edui-popup-table">
										<div class="edui-popup-top" id="ueditor_image_popup_top0">
											<span class="edui-dialog-caption">添加图片</span><a href="#"
												title="关闭" onfocus="this.blur();"
												class="ueditor_image_upload_close0">关闭</a>
										</div>
										<div class="edui-popup-table-content">
											<div class="edui-popup-table-upload">
												<div id="ueditor_image_upload_btn0"></div>
												<!-- <object id="SWFUpload_1" type="application/x-shockwave-flash" data="<%=request.getContextPath()%>/demohour-index_files/swfupload_002.swf" class="swfupload" height="32" width="78"><param name="wmode" value="window"><param name="movie" value="<%=request.getContextPath()%>/demohour-index_files/swfupload.swf?preventswfcaching=1376565941838"><param name="quality" value="high"><param name="menu" value="false"><param name="allowScriptAccess" value="always"><param name="wmode" value="transparent"><param name="flashvars" value="movieName=SWFUpload_1&amp;uploadURL=%2Fattachments%3Fsign%3D93b1e27aac1cca7a52cc6e4d45387a9255e7f7a28af0f237b31b30cde0446df8%26amp%3Btarget_id%3D322193%26amp%3Btype%3Dproject_photo%26amp%3Buser_id%3D1121568&amp;useQueryString=false&amp;requeueOnError=false&amp;httpSuccess=&amp;assumeSuccessTimeout=0&amp;params=&amp;filePostName=Filedata&amp;fileTypes=*.jpg%3B*.gif%3B*.png%3B*.jpeg&amp;fileTypesDescription=JPG%20Images&amp;fileSizeLimit=5%20MB&amp;fileUploadLimit=6&amp;fileQueueLimit=6&amp;debugEnabled=false&amp;buttonImageURL=%2Fassets%2Fueditor%2Fdefault%2Fimages%2Fupload.gif&amp;buttonWidth=78&amp;buttonHeight=32&amp;buttonText=&amp;buttonTextTopPadding=0&amp;buttonTextLeftPadding=0&amp;buttonTextStyle=color%3A%20%23000000%3B%20font-size%3A%2016pt%3B&amp;buttonAction=-110&amp;buttonDisabled=false&amp;buttonCursor=-2"></object> -->
												<span>单张最大5 MB，每次最多传6张，总共允许上传20张。</span>
											</div>
											<div class="edui-upload-img-list"
												id="ueditor_upload_image_progress0"></div>
											<div id="ueditor_upload_image_thumbnails0"
												style="display: none"></div>
											<div class="upload-img-list-b">
												<div class="upload-img-list-b-l">
													<input id="ueditor_image_upload_cancel_all0" value="取消上传"
														onclick="cancelQueue(swfu);" disabled="disabled"
														style="display: none" type="button">
												</div>
												<div class="upload-img-list-b-r">
													<a href="#" class="ueditor_image_upload_close0" title="取消"
														onfocus="this.blur();">取消</a><a href="#"
														id="ueditor_image_upload_submit0" title="确定"
														class="edui-upload-button" onfocus="this.blur();">确定</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="" id="project_intro_1">
							<div style="z-index: 999;" id="edui1" class="edui-editor ">
								<div id="edui1_toolbarbox" class="edui-editor-toolbarbox">
									<div id="edui1_toolbarboxouter"
										class="edui-editor-toolbarboxouter">
										<div class="edui-editor-toolbarboxinner">
											<div style="-moz-user-select: none;" id="edui2"
												class="edui-toolbar  " onselectstart="return false;"
												onmousedown='return $EDITORUI["edui2"]._onMouseDown(event, this);'>
												<div id="edui3" class="edui-box edui-button edui-for-bold">
													<div id="edui3_state"
														onmousedown='$EDITORUI["edui3"].Stateful_onMouseDown(event, this);'
														onmouseup='$EDITORUI["edui3"].Stateful_onMouseUp(event, this);'
														onmouseover='$EDITORUI["edui3"].Stateful_onMouseOver(event, this);'
														onmouseout='$EDITORUI["edui3"].Stateful_onMouseOut(event, this);'>
														<div class="edui-button-wrap">
															<div data-original-title="插入标题" id="edui3_body"
																unselectable="on" class="edui-button-body"
																onmousedown="return false;"
																onclick='return $EDITORUI["edui3"]._onClick();'>
																<div class="edui-box edui-icon"></div>
															</div>
														</div>
													</div>
												</div>
												<div id="edui4" class="edui-box edui-button edui-for-indent">
													<div id="edui4_state"
														onmousedown='$EDITORUI["edui4"].Stateful_onMouseDown(event, this);'
														onmouseup='$EDITORUI["edui4"].Stateful_onMouseUp(event, this);'
														onmouseover='$EDITORUI["edui4"].Stateful_onMouseOver(event, this);'
														onmouseout='$EDITORUI["edui4"].Stateful_onMouseOut(event, this);'>
														<div class="edui-button-wrap">
															<div data-original-title="自动排版" id="edui4_body"
																unselectable="on" class="edui-button-body"
																onmousedown="return false;"
																onclick='return $EDITORUI["edui4"]._onClick();'>
																<div class="edui-box edui-icon"></div>
															</div>
														</div>
													</div>
												</div>
												<div id="edui5" class="edui-box edui-separator "></div>
												<div id="edui6" class="edui-box edui-button edui-for-print">
													<div id="edui6_state"
														onmousedown='$EDITORUI["edui6"].Stateful_onMouseDown(event, this);'
														onmouseup='$EDITORUI["edui6"].Stateful_onMouseUp(event, this);'
														onmouseover='$EDITORUI["edui6"].Stateful_onMouseOver(event, this);'
														onmouseout='$EDITORUI["edui6"].Stateful_onMouseOut(event, this);'>
														<div class="edui-button-wrap">
															<div data-original-title="插入图片" id="edui6_body"
																unselectable="on" class="edui-button-body"
																onmousedown="return false;"
																onclick='return $EDITORUI["edui6"]._onClick();'>
																<div class="edui-box edui-icon"></div>
															</div>
														</div>
													</div>
												</div>
												<div id="edui7"
													class="edui-box edui-button edui-for-insertvideo">
													<div id="edui7_state"
														onmousedown='$EDITORUI["edui7"].Stateful_onMouseDown(event, this);'
														onmouseup='$EDITORUI["edui7"].Stateful_onMouseUp(event, this);'
														onmouseover='$EDITORUI["edui7"].Stateful_onMouseOver(event, this);'
														onmouseout='$EDITORUI["edui7"].Stateful_onMouseOut(event, this);'>
														<div class="edui-button-wrap">
															<div data-original-title="插入视频" id="edui7_body"
																unselectable="on" class="edui-button-body"
																onmousedown="return false;"
																onclick='return $EDITORUI["edui7"]._onClick();'>
																<div class="edui-box edui-icon"></div>
															</div>
														</div>
													</div>
												</div>
												<div id="edui8" class="edui-box edui-button edui-for-link">
													<div id="edui8_state"
														onmousedown='$EDITORUI["edui8"].Stateful_onMouseDown(event, this);'
														onmouseup='$EDITORUI["edui8"].Stateful_onMouseUp(event, this);'
														onmouseover='$EDITORUI["edui8"].Stateful_onMouseOver(event, this);'
														onmouseout='$EDITORUI["edui8"].Stateful_onMouseOut(event, this);'>
														<div class="edui-button-wrap">
															<div data-original-title="插入链接" id="edui8_body"
																unselectable="on" class="edui-button-body"
																onmousedown="return false;"
																onclick='return $EDITORUI["edui8"]._onClick();'>
																<div class="edui-box edui-icon"></div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div id="edui1_toolbarmsg" class="edui-editor-toolbarmsg"
										style="display: none;">
										<div id="edui1_upload_dialog"
											class="edui-editor-toolbarmsg-upload"
											onclick='$EDITORUI["edui1"].showWordImageDialog();'>点此上传</div>
										<div class="edui-editor-toolbarmsg-close"
											onclick='$EDITORUI["edui1"].hideToolbarMsg();'>x</div>
										<div id="edui1_toolbarmsg_label"
											class="edui-editor-toolbarmsg-label"></div>
										<div style="height: 0; overflow: hidden; clear: both;"></div>
									</div>
								</div>
								<div style="overflow: hidden; height: 586px;"
									id="edui1_iframeholder" class="edui-editor-iframeholder">
									<iframe id="baidu_editor_0" frameborder="0" height="100%"
										width="100%"></iframe>
								</div>
								<div id="edui1_bottombar" class="edui-editor-bottomContainer">
									<table>
										<tbody>
											<tr>
												<td id="edui1_elementpath" class="edui-editor-bottombar"></td>
												<td id="edui1_wordcount" class="edui-editor-wordcount"></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div> <span id="project_intro_1_error"></span></li>

					<li><label>退款说明:</label>
						<div class="ui-textarea">
							<div class="ui-textarea-border">
								<textarea cols="0" id="project_risk" name="paybackinfo"
									placeholder="筹资成功后，可能会出现项目无法执行、不能按时发送回报或回报远低于预期的情况，如果出现投诉，请说明你是否会采取退款或其他补偿措施"
									rows="0">${project.paybackintro }</textarea>
							</div>
						</div></li>

					<li class="shortinput failure-money"><label>筹集金额:</label>
						<div class="ui-text">
							<div class="ui-text-right">
								<input autocomplete="off" id="project_target_amount" value="${project.money }"
									name="money" placeholder="不少于500元" size="30" type="text">
							</div>
						</div> 元 <span id="project_target_amount_prompt" class="textprompts"
						style="display: none">包括众拍网手续费、回报成本等。</span></li>
					<li class="shortinput failure-days"><label>募集天数:</label>
						<div class="ui-text">
							<div class="ui-text-right">
								<input autocomplete="off" id="project_target_days" name="day" value="${project.day}"
									placeholder="15-60天" size="30" type="text">
							</div>
						</div> 天</li>
				</ul>
				<div class="form-submit">
					<div class="ui-button ui-button-gray">
						<span><button type="submit">保存</button></span>
					</div>
					<div class="ui-button ui-button-green ui-button-next">
						<span><button type="submit">保存，下一步</button></span>
					</div>
				</div>
			</div>
			<div class="launchright">
				<ul class="examples project-one" id="project_preview">
					<li class="project-thumbnail"><a name="#"><div
								id="project_poster_preview">
								<img
									src="${imagehost }project-medium-${project.picture }">
							</div></a></li>
					<li class="project-titile" id="project_name_preview"><a
						name="#">${project.name }</a></li>
					<li class="project-list-stats">
						<div class="projectpledgedwrap">
							<div style="width: 0%;" class="projectpledged"></div>
						</div>
						<div class="projectstats">
							<p class="widtha">
								<strong>0%</strong>达到
							</p>
							<p class="widthb">
								<strong><span><b>¥</b>0</span></strong>金额
							</p>
							<p class="widthc">
								<strong> 0分钟 </strong>剩余时间
							</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</form>
	<div id="ui_popup_delete"
		class="ui-popup ui-popup-blank ui-popup-delete">
		<div class="ui-popup-background">
			<div class="ui-popup-content ui-draggable">
				<table class="ui-popup-table" align="center" border="0"
					cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td class="ui-popup-top-l" width="25"></td>
							<td class="ui-popup-top"></td>
							<td class="ui-popup-top-r" width="25"><a href="#close"
								class="ui-popup-close">关闭</a></td>
						</tr>
						<tr>
							<td class="ui-popup-mid-l"></td>
							<td class="ui-popup-mid">
								<p class="ui-popup-text"></p>
								<div class="ui-button-green ui-button">
									<span><a class="ui-popup-url" href="#"
										data-method="delete" data-remote="true" rel="nofollow">删除</a></span>
								</div> <a href="#close" class="ui-popup-close ui-popup-delete-cancel">取消</a>
							</td>
							<td class="ui-popup-mid-r"></td>
						</tr>
						<tr>
							<td class="ui-popup-bottom-l"></td>
							<td class="ui-popup-bottom"></td>
							<td class="ui-popup-bottom-r"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div id="ui_popup_message" class="ui-popup ui-popup-textarea">
		<div class="ui-popup-background">
			<div class="ui-popup-content ui-draggable">
				<form accept-charset="UTF-8" action="/messages" data-remote="true"
					method="post">
					<div style="margin: 0; padding: 0; display: inline">
						<input name="utf8" value="✓" type="hidden"><input
							name="authenticity_token"
							value="mXPrIAvBs23PnmOfF1PE+JbSsr4Af0qcf0L0VwNiNsQ="
							type="hidden">
					</div>
					<table class="ui-popup-table" align="center" border="0"
						cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<td class="ui-popup-top-l" width="25"></td>
								<td class="ui-popup-top"><span class="ui-popup-title"></span></td>
								<td class="ui-popup-top-r" width="25"><a href="#close"
									class="ui-popup-close">关闭</a></td>
							</tr>
							<tr>
								<td class="ui-popup-mid-l"></td>
								<td class="ui-popup-mid">
									<div class="ui-textarea">
										<div class="ui-textarea-border">
											<textarea id="message_content" name="message[content]"
												class="ui-text-fixed"></textarea>
										</div>
									</div>
									<div class="ui-popup-textarea-b">
										<span id="ui_popup_message_url"><a
											href="<%=request.getContextPath()%>messages">查看私信记录</a></span> <span
											id="ui_popup_message_email" style="display: none"><label><input
												name="message[email_sync]" value="1" type="checkbox">
												同时发送邮件</label></span> <span id="message_content_error"></span>
										<div class="ui-button ui-button-green ui-button-ajax">
											<span><button type="submit">发送</button></span>
										</div>
									</div>
								</td>
								<td class="ui-popup-mid-r"></td>
							</tr>
							<tr>
								<td class="ui-popup-bottom-l"></td>
								<td class="ui-popup-bottom"></td>
								<td class="ui-popup-bottom-r"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div class="footerwrap">
		<div class="footer">
			<a href="<%=request.getContextPath()%>projects/new">发起项目</a> <a
				href="<%=request.getContextPath()%>intro">服务介绍</a> <a
				href="<%=request.getContextPath()%>guideline">项目规范</a> <a
				href="<%=request.getContextPath()%>faq">常见问题</a> <a
				href="<%=request.getContextPath()%>terms_of_service">服务条款</a> <a
				href="<%=request.getContextPath()%>privacy_policy">隐私权政策</a> <a
				href="<%=request.getContextPath()%>about">关于我们</a> <a
				href="<%=request.getContextPath()%>projects/313907">建议反馈</a> <a
				href="http://weibo.com/demohour" target="_blank">官方微博</a> <a
				href="http://blog.demohour.com/" target="_blank">官方博客</a> <a
				href="<%=request.getContextPath()%>?screen=mobile" class="last">手机版</a>
			<p>
				© 2013北京众拍网科技有限公司 Demohour.com 版权所有<br>电信与信息服务业务经营许可证120183号
				京ICP备11032157号 京公网安备110105015321
			</p>
			<div id="backtop" class="backtop">
				<a href="#top"></a>
			</div>
		</div>
	</div>


	<script src="<%=request.getContextPath()%>/demohour-index_files/ga.js"
		async="" type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/demohour-index_files/application-ffd788692166a3012f8373c435f5c0c2.js"
		type="text/javascript"></script>
	<script
		<%-- src="<%=request.getContextPath()%>/demohour-index_files/projects-1ab927eb13eddbb381c44171a7060594.js" --%>
		src="<%=request.getContextPath()%>/demohour-index_files/demohour.js"
		type="text/javascript"></script>
	<script type="text/javascript">
//<![CDATA[
$(document).ready(function() {
    $.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');
    $('input, textarea').placeholder();
    $(window).scroll(function() {
        if ($(window).scrollTop() > 48) {
            $('#ui_notification').addClass('layer-message-fixed');

        } else {
            $('#ui_notification').removeClass('layer-message-fixed');

        }

    });
/*     $.ui_notification.ready({
        url: 'http://nf-2.demohour.com',
        data: {
            "new_comments_count": 0,
            "new_messages_count": 0,
            "new_notifications_count": 0,
            "new_posts_count": 0

        }

    }); */
    $.ui_core.notice("project", {}),
    $.ui_core.flash("new_project", []),
    $(".project_category").click(function(e) {
        $("a.project_category").removeClass("ui-radio-checked"),
        $(e.target).addClass("ui-radio-checked"),
        $("#project_category_id").val($(e.target).attr("href").split("#")[1]),
        $("#project_category_id").next("em").remove()

    }),

    $("a[href=\#${project.category}]").addClass("ui-radio-checked"),
    $("#project_category_id").val("${project.category}"),
    $("#project_category_id").next("em").remove(),
    
    $("#project_province, #project_city").cascade({
        defaults: ['${project.province}', '${project.city}'],
        prompts: ["请选择", "请选择"]

    }),
    $("#project_province, #project_city").change(function() {
        $("#project_location_preview").children("span").html($("#project_province").val() + $("#project_city").val()),
        $("#project_location_preview").addClass("lihover"),
        setTimeout(function() {
            $("#project_location_preview").removeClass("lihover")

        },
        500)

    }),
    $("#project_name, #project_summary").click(function(e) {
        $("#" + e.target.id + "_preview").addClass("lihover"),
        setTimeout(function() {
            $("#" + e.target.id + "_preview").removeClass("lihover")

        },
        500)

    }),
    $("#project_name, #project_summary").keyup(function(e) {
        $("#" + e.target.id + "_preview").html($(e.target).val())

    }),
    $("#project_target_days").keyup(function(e) {
        $("#" + e.target.id + "_preview").html($(e.target).val() + "天")

    }),
    $.swfupload.load("project_poster_button", {
        upload_url: "<%=request.getContextPath()%>/image/upload4Cover?sign=422aad69c1d0de87f36699ffee2c20cf89cd5a19fbf3c74aa75aeedca5b188d9&projectId=${projectId}&type=project_poster&user_id=1121568",
        flash_url: "<%=request.getContextPath()%>/demohour-index_files/swfupload.swf",
        file_size_limit: "5120",
        //file_types: "*.jpg;*.gif;*.png;*.jpeg",
        file_types: "*.jpg;*.jpeg",
        file_types_description: "图片文件",
        file_queue_error_handler: function(e, t) {
            t == SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED ? $.ui_core.notice("project", {
                poster_url: "超过允许上载的文件数量"

            }) : t == SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT ? $.ui_core.notice("project", {
                poster_url: "文件超过尺寸限制"

            }) : $.ui_core.notice("project", {
                poster_url: "文件上传错误"

            })

        },
        file_dialog_start_handler: function() {
            $("#project_poster_url_error").html("")

        },
        file_dialog_complete_handler: function() {
            this.startUpload()

        },
        upload_progress_handler: function(e, t, o) {
            $("#project_poster_url_error").html($("<em>文件上传中 " + Math.ceil(99 * (t / o)) + "%</em>"))

        },
        upload_error_handler: function() {
            this.startUpload(),
            $.ui_core.notice("project", {
                poster_url: "文件上传错误"

            })

        },
        upload_success_handler: function(e, t) {
        	var img = "<img src='"+t+"'/>";
            $("#project_poster_preview").html(img),
            $($("#project_poster_preview").children()).fadeIn(1500),
            $("#project_poster_url_error").html("")

        },
        upload_complete_handler: function() {
            this.startUpload()

        },
        button_action: SWFUpload.BUTTON_ACTION.SELECT_FILE,
        button_image_url: "http://assets.demohour.com/assets/upload-285b64cf3f94c8753e53c69150208bce.gif",
        button_width: 80,
        button_height: 32

    }),
    $("#project_intro_1").ueditor({
        autosave: !1,
        image: {
            url: "<%=request.getContextPath()%>/image/upload?sign=93b1e27aac1cca7a52cc6e4d45387a9255e7f7a28af0f237b31b30cde0446df8&target_id=322193&type=project_photo&user_id=1121568",
            flash_url: "<%=request.getContextPath()%>/demohour-index_files/swfupload.swf",
            button_image_url: "http://assets.demohour.com/assets/upload-285b64cf3f94c8753e53c69150208bce.gif",
            total_file_upload_limit: "20"

        },
        video: {
            url: "<%=request.getContextPath()%>/video/upload?sign=b6f53725ce2cc8d6dd3325a9ea5636468fa26f1cd8765e8fb24e25b46b5594fe&target_id=322193&type=project_video&user_id=1121568",
            default_image: "<%=request.getContextPath()%>/demohour-index_files/video.png"

        },
        editor_config_options: {
            minFrameHeight: 350,
            initialContent: '${project.content}'
        }
    }),
    $("body").on("click", "a.ui-popup-delete", 
    function(e) {
        $("#ui_popup_delete").find("div.ui-popup-content").css("top", $(window).height() / 2 - 120),
        $("#ui_popup_delete").find("p.ui-popup-text").html($(e.target).attr("title")),
        $("#ui_popup_delete").find("a.ui-popup-url").attr("href", $(e.target).attr("href")),
        $("#ui_popup_delete").toggle(),
        e.preventDefault()

    }),
    $("body").on("click", "a.ui-popup-message", 
    function(e) {
        $("#ui_popup_message").find("div.ui-popup-content").css("top", $(window).height() / 2 - 150),
        $("#ui_popup_message").find("form").attr("action", $(e.target).attr("href")),
        $("#ui_popup_message").find("span.ui-popup-title").html($(e.target).attr("title")),
        $("#ui_popup_message").toggle(),
        $("#ui_popup_message").find("textarea").val($(e.target).attr("data-message-attachment")),
        $("#ui_popup_message").find("textarea").focus(),
        $(e.target).attr("href").indexOf("?recipient_id=") > 0 ? ($("#ui_popup_message_url").show(), $("#ui_popup_message_email").hide(), $("#ui_popup_message_url").find("a").attr("href", $(e.target).attr("href").replace("?recipient_id=", "/"))) : ($("#ui_popup_message_url").hide(), $("#ui_popup_message_email").show()),
        e.preventDefault()

    });;
    $.ui_core.backtop('#backtop');
    $.ui_core.distance({
        now: '2013-08-15 19:25:37 +0800'

    });

});
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-23451409-1']);
_gaq.push(['_trackPageview']);
(function() {
var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();
//]]>
</script>
	<div
		style="position: fixed; left: 0px; top: 0px; width: 0px; height: 0px;"
		id="edui_fixedlayer">
		<div style="display: none;" id="edui9"
			class="edui-dialog edui-for-link">
			<div class="edui-dialog-wrap">
				<div id="edui9_body" class="edui-dialog-body">
					<div class="edui-dialog-shadow"></div>
					<div id="edui9_titlebar" class="edui-dialog-titlebar">
						<div class="edui-dialog-draghandle"
							onmousedown='$EDITORUI["edui9"]._onTitlebarMouseDown(event, this);'>
							<span class="edui-dialog-caption">超链接</span>
						</div>
						<div id="edui12"
							class="edui-box edui-button edui-dialog-closebutton">
							<div id="edui12_state"
								onmousedown='$EDITORUI["edui12"].Stateful_onMouseDown(event, this);'
								onmouseup='$EDITORUI["edui12"].Stateful_onMouseUp(event, this);'
								onmouseover='$EDITORUI["edui12"].Stateful_onMouseOver(event, this);'
								onmouseout='$EDITORUI["edui12"].Stateful_onMouseOut(event, this);'>
								<div class="edui-button-wrap">
									<div data-original-title="关闭对话框" id="edui12_body"
										unselectable="on" class="edui-button-body"
										onmousedown="return false;"
										onclick='return $EDITORUI["edui12"]._onClick();'>
										<div class="edui-box edui-icon"></div>
										<div class="edui-box edui-label"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="edui9_content" class="edui-dialog-content"></div>
					<div class="edui-dialog-foot">
						<div id="edui9_buttons" class="edui-dialog-buttons">
							<div id="edui13" class="edui-box edui-button edui-okbutton">
								<div id="edui13_state"
									onmousedown='$EDITORUI["edui13"].Stateful_onMouseDown(event, this);'
									onmouseup='$EDITORUI["edui13"].Stateful_onMouseUp(event, this);'
									onmouseover='$EDITORUI["edui13"].Stateful_onMouseOver(event, this);'
									onmouseout='$EDITORUI["edui13"].Stateful_onMouseOut(event, this);'>
									<div class="edui-button-wrap">
										<div data-original-title="" id="edui13_body" unselectable="on"
											class="edui-button-body" onmousedown="return false;"
											onclick='return $EDITORUI["edui13"]._onClick();'>
											<div class="edui-box edui-icon"></div>
											<div class="edui-box edui-label">确认</div>
										</div>
									</div>
								</div>
							</div>
							<div id="edui14" class="edui-box edui-button edui-cancelbutton">
								<div id="edui14_state"
									onmousedown='$EDITORUI["edui14"].Stateful_onMouseDown(event, this);'
									onmouseup='$EDITORUI["edui14"].Stateful_onMouseUp(event, this);'
									onmouseover='$EDITORUI["edui14"].Stateful_onMouseOver(event, this);'
									onmouseout='$EDITORUI["edui14"].Stateful_onMouseOut(event, this);'>
									<div class="edui-button-wrap">
										<div data-original-title="" id="edui14_body" unselectable="on"
											class="edui-button-body" onmousedown="return false;"
											onclick='return $EDITORUI["edui14"]._onClick();'>
											<div class="edui-box edui-icon"></div>
											<div class="edui-box edui-label">取消</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div style="display: none;" id="edui10"
			class="edui-mask  edui-dialog-modalmask"
			onmousedown='return $EDITORUI["edui10"]._onMouseDown(event, this);'></div>
		<div style="display: none;" id="edui11"
			class="edui-mask  edui-dialog-dragmask"
			onmousedown='return $EDITORUI["edui11"]._onMouseDown(event, this);'></div>
		<div style="display: none;" id="edui15"
			class="edui-dialog edui-for-insertvideo">
			<div class="edui-dialog-wrap">
				<div id="edui15_body" class="edui-dialog-body">
					<div class="edui-dialog-shadow"></div>
					<div id="edui15_titlebar" class="edui-dialog-titlebar">
						<div class="edui-dialog-draghandle"
							onmousedown='$EDITORUI["edui15"]._onTitlebarMouseDown(event, this);'>
							<span class="edui-dialog-caption">视频</span>
						</div>
						<div id="edui16"
							class="edui-box edui-button edui-dialog-closebutton">
							<div id="edui16_state"
								onmousedown='$EDITORUI["edui16"].Stateful_onMouseDown(event, this);'
								onmouseup='$EDITORUI["edui16"].Stateful_onMouseUp(event, this);'
								onmouseover='$EDITORUI["edui16"].Stateful_onMouseOver(event, this);'
								onmouseout='$EDITORUI["edui16"].Stateful_onMouseOut(event, this);'>
								<div class="edui-button-wrap">
									<div data-original-title="关闭对话框" id="edui16_body"
										unselectable="on" class="edui-button-body"
										onmousedown="return false;"
										onclick='return $EDITORUI["edui16"]._onClick();'>
										<div class="edui-box edui-icon"></div>
										<div class="edui-box edui-label"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="edui15_content" class="edui-dialog-content"></div>
					<div class="edui-dialog-foot">
						<div id="edui15_buttons" class="edui-dialog-buttons">
							<div id="edui17" class="edui-box edui-button edui-okbutton">
								<div id="edui17_state"
									onmousedown='$EDITORUI["edui17"].Stateful_onMouseDown(event, this);'
									onmouseup='$EDITORUI["edui17"].Stateful_onMouseUp(event, this);'
									onmouseover='$EDITORUI["edui17"].Stateful_onMouseOver(event, this);'
									onmouseout='$EDITORUI["edui17"].Stateful_onMouseOut(event, this);'>
									<div class="edui-button-wrap">
										<div data-original-title="" id="edui17_body" unselectable="on"
											class="edui-button-body" onmousedown="return false;"
											onclick='return $EDITORUI["edui17"]._onClick();'>
											<div class="edui-box edui-icon"></div>
											<div class="edui-box edui-label">确认</div>
										</div>
									</div>
								</div>
							</div>
							<div id="edui18" class="edui-box edui-button edui-cancelbutton">
								<div id="edui18_state"
									onmousedown='$EDITORUI["edui18"].Stateful_onMouseDown(event, this);'
									onmouseup='$EDITORUI["edui18"].Stateful_onMouseUp(event, this);'
									onmouseover='$EDITORUI["edui18"].Stateful_onMouseOver(event, this);'
									onmouseout='$EDITORUI["edui18"].Stateful_onMouseOut(event, this);'>
									<div class="edui-button-wrap">
										<div data-original-title="" id="edui18_body" unselectable="on"
											class="edui-button-body" onmousedown="return false;"
											onclick='return $EDITORUI["edui18"]._onClick();'>
											<div class="edui-box edui-icon"></div>
											<div class="edui-box edui-label">取消</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div style="display: none;" id="edui19"
			class="edui-popup  edui-bubble">
			<div id="edui19_body" class="edui-popup-body">
				<iframe
					style="position: absolute; z-index: -1; left: 0; top: 0; background-color: white;"
					src="javascript:" frameborder="0" height="100%" width="100%"></iframe>
				<div class="edui-shadow"></div>
				<div id="edui19_content" class="edui-popup-content"></div>
			</div>
		</div>
	</div>
</body>
</html>