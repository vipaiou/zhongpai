<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../include/header.jsp" %>
<link href="<s:url value="/demohour-index_files/projects-9afed8175e89fa73647b287e62737440.css" />" media="screen" rel="stylesheet" type="text/css">
<div class="ui-tab">
<div class="ui-tab-top">
<h1><a href="<%=request.getContextPath()%>/projects/view/${project.id}">${project.name }</a></h1>
</div>
<div class="ui-tab-layout">
<ul class="ui-tab-menu">
<li><a href="<%=request.getContextPath()%>/projects/view/${project.id}">项目主页</a></li>
<li><a class="ui-tab-current" href="<%=request.getContextPath()%>/projects/topics/${project.id}">话题<span id="posts_count">${topicnum }</span></a></li>
<li><a href="<%=request.getContextPath()%>/projects/focuses/${project.id}">关注者<span id="favorites_count">${focusnum }</span></a></li>
</ul>
<div class="ui-tab-menu-right">
<div class="ui-button ui-button-blue"><span><a href="#ui_invite_popup" class="ui-popup-open invite_popup" data-popup-height="180" title="帮忙转发">帮忙转发</a></span></div>
<div id="project_322072_favorite1" class="ui-button ui-button-blue ui-button-ajax"><span><a href="<%=request.getContextPath()%>/projects/focus/${project.id }" data-remote="true">+关注此项目</a></span>
<div class="ui-help ui-help-prompt-left">
<div class="ui-help-prompt">
<p>关注后，你将会在此项目有<br>新的动态时收到通知提醒。</p>
</div>
<div class="ui-help-prompt-bottom">bottom</div>
</div>
</div>

</div>
</div>
</div>
<div id="ui_popup_preview" class="ui-popup" style="display:none">
<div class="ui-popup-background">
<div class="ui-popup-content ui-draggable">
<div class="returns-contents-img-popup">
<a href="#close" class="ui-popup-close">关闭</a>
<div class="returns-contents-img-arrow">
<a href="#prev" class="returns-contents-img-l-on" id="ui_popup_preview_prev">上一张</a>
<a href="" class="returns-contents-img-m" target="_blank" id="ui_popup_preview_open">查看原图</a>
<a href="#next" class="returns-contents-img-r-on" id="ui_popup_preview_next">下一张</a>
</div>
<table border="0" cellpadding="0" cellspacing="0" width="700">
<tbody><tr>
<td id="ui_popup_preview_image" align="center" height="526" valign="middle"></td>
</tr>
</tbody></table>
</div>
</div> 
</div>
</div>
<div id="invite_popup" class="ui-popup ui-popup-blank ui-popup-invite" style="display:none">
<div class="ui-popup-background">
<div class="ui-popup-content ui-draggable">
<table class="ui-popup-table" align="center" border="0" cellpadding="0" cellspacing="0">
<tbody><tr><td class="ui-popup-top-l" width="25"></td>
<td class="ui-popup-top"></td>
<td class="ui-popup-top-r" width="25"><a href="#close" class="ui-popup-close">关闭</a></td></tr>
<tr><td class="ui-popup-mid-l"></td>
<td class="ui-popup-mid">
<ul>
<li class="ui-popup-invite-t">邀请更多的朋友关注此项目！</li>
<li class="ui-popup-invite-i">
<label>邀请链接：</label>
<div class="ui-text">
<div class="ui-text-right">
<input id="invite_url" name="invite_url" autocomplete="off" value="<%=request.getContextPath()%>/projects/322072?u=1121568" type="text">
</div>
</div>
</li>
<li class="ui-popup-invite-c">复制上面链接，通过EMAIL或QQ发送给你的亲朋好友<br>或者通过下列按钮分享给你的网友粉丝，让大家一起转发扩散！
</li>
<li>	
<div class="jiathis_style_24x24">
<a title="分享到新浪微博" class="jiathis_button_tsina"><span class="jiathis_txt jtico jtico_tsina"></span></a>
<a title="分享到腾讯微博" class="jiathis_button_tqq"><span class="jiathis_txt jtico jtico_tqq"></span></a>
<a title="分享到QQ空间" class="jiathis_button_qzone"><span class="jiathis_txt jtico jtico_qzone"></span></a>
<a title="分享到豆瓣" class="jiathis_button_douban"><span class="jiathis_txt jtico jtico_douban"></span></a>
<a title="分享到人人网" class="jiathis_button_renren"><span class="jiathis_txt jtico jtico_renren"></span></a>
<a title="分享到淘江湖" class="jiathis_button_taobao"><span class="jiathis_txt jtico jtico_taobao"></span></a>
<a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
</div>
</li>
</ul>
</td>
<td class="ui-popup-mid-r"></td></tr>
<tr><td class="ui-popup-bottom-l"></td><td class="ui-popup-bottom"></td><td class="ui-popup-bottom-r"></td></tr>
</tbody></table>
</div>
</div>
</div>

<div id="project_intro" class="projects-home">
<div class="projects-home-left">
<div class="timeline-box">
<div class="timeline-box-right">
<div class="timeline-box-title">
<div class="comment-title-avatar">
<a class="timeline-comment-avatar" target="_blank" href="/1114419"><img src="http://aliyun.demohour.com/demohour-upload/user_avatars-files-000-109-219-109219-small.jpg?1376829564"></a>
</div>
<div class="comment-title-avatar-r">
<p><a href="/posts/21494">[公告] 回报说明</a></p>
<span><a class="comment-title-avatar-r-n" target="_blank" href="/1114419">王婆</a>
<a class="icon-user-f" href="#">项目发起人</a>
<a title="私信给 王婆" class="ui-popup-message post-private-letter" href="/messages?recipient_id=1114419">发私信</a>
</span>
<div data-timestamp="2013-08-31 19:29:37 +0800" class="timeline-box-title-date">1天以前</div>
</div>
</div>
<div class="timeline-box-explain">
<div class="timeline-box-explain-text"><p>回报中所提及的组装完毕的迷你四旋翼飞行器包含空机一架以及350mah电池一节，并提供android手机app，ios版测试app。如需使用遥控器遥控则需额外购买第三方遥控器。</p></div>
</div>

<div class="timeline-box-explain-text-thumbnail">
</div>

<div class="projects-share projects-comment-share">
<p>
<a href="/posts/21494">6条回应，查看全文 &gt;&gt;</a>
<span data-visited-id="21494" data-visited-time="2013-08-31 19:29:37 +0800" class="list-icon-new" style="display: none;">新</span>
</p>
</div>
</div>
</div>	
<div class="timeline-box">
<div class="timeline-box-right">
<div class="timeline-box-title">
<div class="comment-title-avatar">
<a class="timeline-comment-avatar" target="_blank" href="/1114419"><img src="http://aliyun.demohour.com/demohour-upload/user_avatars-files-000-109-219-109219-small.jpg?1376829564"></a>
</div>
<div class="comment-title-avatar-r">
<p><a href="/posts/22082">[公告] 求破万，求破万，特搞小活动(被秒，活动结束)</a></p>
<span><a class="comment-title-avatar-r-n" target="_blank" href="/1114419">王婆</a>
<a class="icon-user-f" href="#">项目发起人</a>
<a title="私信给 王婆" class="ui-popup-message post-private-letter" href="/messages?recipient_id=1114419">发私信</a>
</span>
<div data-timestamp="2013-08-30 18:26:05 +0800" class="timeline-box-title-date">2天以前</div>
</div>
</div>
<div class="timeline-box-explain">
<div class="timeline-box-explain-text"><p>求破万，求破万，特搞小活动，来抢吧，23元小飞机一架。</p><p>活动结束，恭喜<a href="http://www.demohour.com/1113495">梦,依旧在做</a>！出来说两句吧。</p></div>
</div>

<div class="timeline-box-explain-text-thumbnail">
</div>

<div class="projects-share projects-comment-share">
<p>
<a href="/posts/22082">24条回应，查看全文 &gt;&gt;</a>
<span data-visited-id="22082" data-visited-time="2013-08-30 18:26:05 +0800" class="list-icon-new" style="display: none;">新</span>
</p>
</div>
</div>
</div>	
<div class="timeline-box">
<div class="timeline-box-right">
<div class="timeline-box-title">
<div class="comment-title-avatar">
<a class="timeline-comment-avatar" target="_blank" href="/1114419"><img src="http://aliyun.demohour.com/demohour-upload/user_avatars-files-000-109-219-109219-small.jpg?1376829564"></a>
</div>
<div class="comment-title-avatar-r">
<p><a href="/posts/22098">[公告] 非常感谢chuyue同学帮忙设计的UI，非常精美。</a></p>
<span><a class="comment-title-avatar-r-n" target="_blank" href="/1114419">王婆</a>
<a class="icon-user-f" href="#">项目发起人</a>
<a title="私信给 王婆" class="ui-popup-message post-private-letter" href="/messages?recipient_id=1114419">发私信</a>
</span>
<div data-timestamp="2013-08-30 17:38:34 +0800" class="timeline-box-title-date">2天以前</div>
</div>
</div>
<div class="timeline-box-explain">
<div class="timeline-box-explain-text"><p>非常感谢chuyue同学帮忙设计的UI，非常精美。</p></div>
</div>

<div class="timeline-box-explain-text-thumbnail">
<a href="/posts/22098"><img src="http://aliyun.demohour.com/demohour-upload/post_photos-files-000-006-689-6689-thumb.jpg?1377851204"></a>
</div>

<div class="projects-share projects-comment-share">
<p>
<a href="/posts/22098">3条回应，查看全文 &gt;&gt;</a>
<span data-visited-id="22098" data-visited-time="2013-08-30 17:38:34 +0800" class="list-icon-new" style="display: none;">新</span>
</p>
</div>
</div>
</div>	
<div class="timeline">
<div class="timeline-box" id="post_21109">
<div class="timeline-box-right">
<div class="timeline-box-title">
<div class="comment-title-avatar">
<a class="timeline-comment-avatar" target="_blank" href="/1013487"><img src="http://aliyun.demohour.com/demohour-upload/user_avatars-files-000-110-795-110795-small.jpg?1377576265"></a>
</div>
<div class="comment-title-avatar-r">
<p><a href="/posts/21109">[公告] #迷你四旋翼飞行器#上线了！</a></p>
<span><a target="_blank" href="/1013487">众拍网客服</a>
<a title="私信给 众拍网客服" class="ui-popup-message post-private-letter" href="/messages?recipient_id=1013487">发私信</a>
</span>
<div data-timestamp="2013-08-29 18:54:23 +0800" class="timeline-box-title-date">3天以前</div>
</div>
</div>
<div class="timeline-box-explain">
<div class="timeline-box-explain-text">
由 王婆 发起的项目「迷你四旋翼飞行器」上线了！<br>
此项目必须在 2013年10月20日 19:06 之前，达到 <b>¥</b>5,000 的目标才可成功。<br><br>
<span id="project_306978_favorite2">325人关注了此项目</span><br>
</div>
</div>
<div class="projects-share projects-comment-share">
<p>
<a href="/posts/21109">2条回应，查看全文 &gt;&gt;</a>
<span data-visited-id="21109" data-visited-time="2013-08-29 18:54:23 +0800" class="list-icon-new" style="display: none;">新</span>
</p>
</div>
</div>
</div>
</div>	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
<div id="posts" class="new-comment">
<div class="new-tab">
<ul class="new-tab-menu">
<li><a class="new-tab-current" data-remote="true" href="/posts/list?project_id=321238&amp;refresh=1377949433.7063155" id="filter_all"><div class="new-tab-left-radius"></div>全部<span>49</span></a></li>
<li><a data-remote="true" href="/posts/list?filter=0&amp;project_id=321238">公告<span>4</span></a></li>
<li><a data-remote="true" href="/posts/list?filter=1&amp;project_id=321238">问答<span>16</span></a></li>
<li><a data-remote="true" href="/posts/list?filter=2&amp;project_id=321238">顶<span>28</span></a></li>
<li><a data-remote="true" href="/posts/list?filter=3&amp;project_id=321238">倒<span>1</span></a></li>
</ul>
</div>
<table cellspacing="0" cellpadding="0" border="0" class="new-comment-list">
<tbody>
<tr class="new-comment-t">
<td width="365" align="left" colspan="2">话题</td>
<td width="97" align="left">作者</td>
<td width="40" align="center">回应</td>
<td width="68" align="right">最后回应</td>
</tr>
<c:forEach items="${topics}" var="topic" varStatus="s"> 
<tr class="new-comment-ding">
<td align="center">
<div class="comment-icon">[<a href="<%=request.getContextPath()%>/posts/list?filter=0&amp;limit=40&amp;project_id=${topic.projectId}" data-remote="true">告</a>]</div>
</td>
<td align="left" width="336"><a href="<%=request.getContextPath()%>/posts/${topic.id }" class="c5 c5-length" title="#${topic.title }">${topic.title }</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-08-17 13:15:59 +0800" data-visited-id="20518">新</div></td>
<td align="left">
<a href="<%=request.getContextPath()%>/${topic.userid }" class="c9 c9-length" target="_blank" title="众拍网客服">${topic.userid }</a>
</td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/${topic.id}" class="c5">4</a></td>
<td class="timeline-posted-at" align="right"><a href="<%=request.getContextPath()%>/posts/${topic.id }?latest=1" data-timestamp="2013-08-17 13:15:59 +0800">11小时以前</a></td>
</tr>
</c:forEach>
<tr>
<td align="center">
<div class="comment-icon">[<a data-remote="true" href="/posts/list?filter=1&amp;limit=40&amp;project_id=321238">问</a>]</div>
</td>
<td width="336" align="left"><a title="电池  ？  控制模式？ " class="c5 c5-length" href="/posts/21933">电池  ？  控制模式？ </a><div data-visited-id="21933" data-visited-time="2013-08-31 19:41:31 +0800" class="list-icon-new" style="display: none;">新</div></td>
<td align="left">
<a title="小心灰" target="_blank" class="c9 c9-length" href="/1075874">小心灰</a>
</td>
<td align="center"><a class="c5" href="/posts/21933">4</a></td>
<td align="right" class="timeline-posted-at"><a data-timestamp="2013-08-31 19:41:31 +0800" href="/posts/21933?latest=1">1天以前</a></td>
</tr>
</tbody>
</table>
<div class="ui-pagination"><ul><li class="ui-pagination-prev"><a data-remote="true" class="prev_page" href="/posts/list?limit=40&amp;project_id=321238&amp;page=1">/posts/list?limit=40&amp;project_id=321238&amp;page=1</a></li><li class="ui-pagination-current"><a data-remote="true" href="/posts/list?limit=40&amp;project_id=321238&amp;page=1"><span>1</span></a></li><li><a data-remote="true" href="/posts/list?limit=40&amp;project_id=321238&amp;page=2"><span>2</span></a></li><li class="ui-pagination-next"><a data-remote="true" class="next_page" href="/posts/list?limit=40&amp;project_id=321238&amp;page=2">下一页 &amp;raquo;</a></li></ul></div>
</div>

<div id="new_post" class="projects-posts-add comment-posts-add">
<div class="new-comment-top ui-faq-title-size">我要发起话题</div>
<form method="post" data-remote="true" action="/posts?project_id=321238&amp;target=project" accept-charset="UTF-8"><div style="margin:0;padding:0;display:inline"><input type="hidden" value="✓" name="utf8"><input type="hidden" value="WgCQl1g0l5r3m2JHy6Ry3Z6wZyCNMrtEtpJ9/hjEy6U=" name="authenticity_token"></div>
<input type="hidden" value="0" name="text_post[sns_sync]">
<div class="projects-posts-add-title">
<div class="ui-text">
<div class="ui-text-right">
<input type="text" placeholder="请输入标题" name="post[title]" id="post_title">	
</div>
</div>
</div>
<div class="comment-posts-add-category">
<div class="ui-radio">
<label><input type="radio" value="2" name="post[attribute_id]" id="post_attribute_id_2" class="ui-radio radio post_attribute_id">顶（支持）</label>
<label><input type="radio" value="3" name="post[attribute_id]" id="post_attribute_id_3" class="ui-radio radio post_attribute_id">倒（不支持）</label>
<label><input type="radio" value="1" name="post[attribute_id]" id="post_attribute_id_1" class="ui-radio radio post_attribute_id">提问</label>
</div>
</div>
<div id="post_content_error"></div>
<div class="projects-posts-add-c">
<div style="display:none;" class="edui-popup-all edui-popup-img" id="ueditor_link_popup0"><div class="edui-popup-background"><div class="edui-popup-all-content" style="top: 133.5px;"><div class="edui-popup-table"><div id="ueditor_link_popup_top0" class="edui-popup-top"><span class="edui-dialog-caption">添加链接</span><a class="ueditor_link_close0" onfocus="this.blur();" title="关闭" href="#">关闭</a></div><div class="edui-popup-table-content"><input type="text" placeholder="输入链接地址" id="ueditor_link_href0"><span id="ueditor_link_error_msg0"></span><div class="upload-img-list-b"><div class="upload-img-list-b-r"><a onfocus="this.blur();" title="取消" class="ueditor_link_close0" href="#">取消</a><a onfocus="this.blur();" class="edui-upload-button" title="确定" id="ueditor_link_submit0" href="#">确定</a></div></div></div></div></div></div></div><div style="display:none;" class="edui-popup-all edui-popup-img" id="ueditor_video_popup0"><div class="edui-popup-background"><div class="edui-popup-all-content" style="top: 133.5px;"><div class="edui-popup-table"><div id="ueditor_video_popup_top0" class="edui-popup-top"><span class="edui-dialog-caption">添加视频</span><a class="ueditor_video_close0" onfocus="this.blur();" title="关闭" href="#">关闭</a></div><div class="edui-popup-table-content"><input style="display:none" value="/attachments?sign=fe20660471609e35acc4dbf24af782fdba18fd536a3147090103407ee9b68495&amp;type=post_video&amp;user_id=1121568" +="" id="ueditor_video_convert_url0"><input type="text" placeholder="输入视频地址（支持优酷、土豆、酷6、新浪视频）" id="ueditor_video_url0"><span id="ueditor_video_error_msg0"></span><div class="upload-img-list-b"><div class="upload-img-list-b-r"><a onfocus="this.blur();" title="取消" class="ueditor_video_close0" href="#">取消</a><a onfocus="this.blur();" class="edui-upload-button" title="确定" id="ueditor_video_submit0" href="#">确定</a></div></div></div></div></div></div></div><div style="display:none;" class="edui-popup-all edui-popup-img" id="ueditor_image_popup0"><div class="edui-popup-background"><div class="edui-popup-all-content" style="top: 133.5px;"><div class="edui-popup-table"><div id="ueditor_image_popup_top0" class="edui-popup-top"><span class="edui-dialog-caption">添加图片</span><a class="ueditor_image_upload_close0" onfocus="this.blur();" title="关闭" href="#">关闭</a></div><div class="edui-popup-table-content"><div class="edui-popup-table-upload"><object width="78" height="32" class="swfupload" data="/assets/swfupload/swfupload.swf?preventswfcaching=1378037562019" type="application/x-shockwave-flash" id="SWFUpload_0"><param value="window" name="wmode"><param value="/assets/swfupload/swfupload.swf?preventswfcaching=1378037562019" name="movie"><param value="high" name="quality"><param value="false" name="menu"><param value="always" name="allowScriptAccess"><param value="transparent" name="wmode"><param value="movieName=SWFUpload_0&amp;uploadURL=%2Fattachments%3Fsign%3D6d2c0f52ea30040e8c3c0aff34adc72431e2ef08ca5ee6f52371940156737d85%26amp%3Btype%3Dpost_photo%26amp%3Buser_id%3D1121568&amp;useQueryString=false&amp;requeueOnError=false&amp;httpSuccess=&amp;assumeSuccessTimeout=0&amp;params=&amp;filePostName=Filedata&amp;fileTypes=*.jpg%3B*.gif%3B*.png%3B*.jpeg&amp;fileTypesDescription=JPG%20Images&amp;fileSizeLimit=5%20MB&amp;fileUploadLimit=6&amp;fileQueueLimit=6&amp;debugEnabled=false&amp;buttonImageURL=%2Fassets%2Fueditor%2Fdefault%2Fimages%2Fupload.gif&amp;buttonWidth=78&amp;buttonHeight=32&amp;buttonText=&amp;buttonTextTopPadding=0&amp;buttonTextLeftPadding=0&amp;buttonTextStyle=color%3A%20%23000000%3B%20font-size%3A%2016pt%3B&amp;buttonAction=-110&amp;buttonDisabled=false&amp;buttonCursor=-2" name="flashvars"></object><span>单张最大5 MB，每次最多传6张，总共允许上传20张。</span></div><div id="ueditor_upload_image_progress0" class="edui-upload-img-list"></div><div style="display:none" id="ueditor_upload_image_thumbnails0"></div><div class="upload-img-list-b"><div class="upload-img-list-b-l"><input type="button" style="display:none" disabled="disabled" onclick="cancelQueue(swfu);" value="取消上传" id="ueditor_image_upload_cancel_all0"></div><div class="upload-img-list-b-r"><a onfocus="this.blur();" title="取消" class="ueditor_image_upload_close0" href="#">取消</a><a onfocus="this.blur();" class="edui-upload-button" title="确定" id="ueditor_image_upload_submit0" href="#">确定</a></div></div></div></div></div></div></div><div id="post_content_1" class=""><div class="edui-editor " id="edui1" style="z-index: 999;"><div class="edui-editor-toolbarbox" id="edui1_toolbarbox"><div class="edui-editor-toolbarboxouter" id="edui1_toolbarboxouter"><div class="edui-editor-toolbarboxinner"><div onmousedown="return $EDITORUI[&quot;edui2&quot;]._onMouseDown(event, this);" onselectstart="return false;" class="edui-toolbar  " id="edui2" style="-moz-user-select: none;"><div class="edui-box edui-button edui-for-bold" id="edui3"><div onmouseout="$EDITORUI[&quot;edui3&quot;].Stateful_onMouseOut(event, this);" onmouseover="$EDITORUI[&quot;edui3&quot;].Stateful_onMouseOver(event, this);" onmouseup="$EDITORUI[&quot;edui3&quot;].Stateful_onMouseUp(event, this);" onmousedown="$EDITORUI[&quot;edui3&quot;].Stateful_onMouseDown(event, this);" id="edui3_state"><div class="edui-button-wrap"><div onclick="return $EDITORUI[&quot;edui3&quot;]._onClick();" onmousedown="return false;" class="edui-button-body" unselectable="on" id="edui3_body" data-original-title="插入标题"><div class="edui-box edui-icon"></div></div></div></div></div><div class="edui-box edui-button edui-for-indent" id="edui4"><div onmouseout="$EDITORUI[&quot;edui4&quot;].Stateful_onMouseOut(event, this);" onmouseover="$EDITORUI[&quot;edui4&quot;].Stateful_onMouseOver(event, this);" onmouseup="$EDITORUI[&quot;edui4&quot;].Stateful_onMouseUp(event, this);" onmousedown="$EDITORUI[&quot;edui4&quot;].Stateful_onMouseDown(event, this);" id="edui4_state"><div class="edui-button-wrap"><div onclick="return $EDITORUI[&quot;edui4&quot;]._onClick();" onmousedown="return false;" class="edui-button-body" unselectable="on" id="edui4_body" data-original-title="自动排版"><div class="edui-box edui-icon"></div></div></div></div></div><div class="edui-box edui-separator " id="edui5"></div><div class="edui-box edui-button edui-for-print" id="edui6"><div onmouseout="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseOut(event, this);" onmouseover="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseOver(event, this);" onmouseup="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseUp(event, this);" onmousedown="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseDown(event, this);" id="edui6_state"><div class="edui-button-wrap"><div onclick="return $EDITORUI[&quot;edui6&quot;]._onClick();" onmousedown="return false;" class="edui-button-body" unselectable="on" id="edui6_body" data-original-title="插入图片"><div class="edui-box edui-icon"></div></div></div></div></div><div class="edui-box edui-button edui-for-insertvideo" id="edui7"><div onmouseout="$EDITORUI[&quot;edui7&quot;].Stateful_onMouseOut(event, this);" onmouseover="$EDITORUI[&quot;edui7&quot;].Stateful_onMouseOver(event, this);" onmouseup="$EDITORUI[&quot;edui7&quot;].Stateful_onMouseUp(event, this);" onmousedown="$EDITORUI[&quot;edui7&quot;].Stateful_onMouseDown(event, this);" id="edui7_state"><div class="edui-button-wrap"><div onclick="return $EDITORUI[&quot;edui7&quot;]._onClick();" onmousedown="return false;" class="edui-button-body" unselectable="on" id="edui7_body" data-original-title="插入视频"><div class="edui-box edui-icon"></div></div></div></div></div><div class="edui-box edui-button edui-for-link" id="edui8"><div onmouseout="$EDITORUI[&quot;edui8&quot;].Stateful_onMouseOut(event, this);" onmouseover="$EDITORUI[&quot;edui8&quot;].Stateful_onMouseOver(event, this);" onmouseup="$EDITORUI[&quot;edui8&quot;].Stateful_onMouseUp(event, this);" onmousedown="$EDITORUI[&quot;edui8&quot;].Stateful_onMouseDown(event, this);" id="edui8_state"><div class="edui-button-wrap"><div onclick="return $EDITORUI[&quot;edui8&quot;]._onClick();" onmousedown="return false;" class="edui-button-body" unselectable="on" id="edui8_body" data-original-title="插入链接"><div class="edui-box edui-icon"></div></div></div></div></div></div></div></div><div style="display:none;" class="edui-editor-toolbarmsg" id="edui1_toolbarmsg"><div onclick="$EDITORUI[&quot;edui1&quot;].showWordImageDialog();" class="edui-editor-toolbarmsg-upload" id="edui1_upload_dialog">点此上传</div><div onclick="$EDITORUI[&quot;edui1&quot;].hideToolbarMsg();" class="edui-editor-toolbarmsg-close">x</div><div class="edui-editor-toolbarmsg-label" id="edui1_toolbarmsg_label"></div><div style="height:0;overflow:hidden;clear:both;"></div></div></div><div class="edui-editor-iframeholder" id="edui1_iframeholder" style="overflow: hidden; height: 140px;"><iframe width="100%" height="100%" frameborder="0" id="baidu_editor_0"></iframe></div><div class="edui-editor-bottomContainer" id="edui1_bottombar"><table><tbody><tr><td class="edui-editor-bottombar" id="edui1_elementpath"></td><td class="edui-editor-wordcount" id="edui1_wordcount"></td></tr></tbody></table></div></div></div>	
</div>
<div class="projects-posts-add-b">
<div id="post_content_1_error"></div>
<div class="ui-button ui-button-green ui-button-ajax"><span><button type="submit">发送</button></span></div>
</div>
</form></div>

</div>
<div class="projects-home-right">
<div class="projects-home-right">
<div class="sidebar-warming">
<div class="sidebar-money-raised-top">
<div class="sidebar-money-raised-num-t"><p>目标</p><b><b>1400</b>人关注</b><span><span>/</span>已达</span></div>
<div class="sidebar-money-raised-num"><b><b>${focusnum }</b>人</b></div>
</div>
<div class="sidebar-percentage">
<span class="sidebar-percentage-progress-span">21%</span>
<div style="width:21%;" class="sidebar-percentage-progress"></div>
</div>
<div class="sidebar-number-days">
<div class="sidebar-number-days-l"><span>话题总数</span><b><b>${topicnum }</b>条</b></div>
<div class="sidebar-number-days-m"><span>浏览人数</span><b><b>${project.viewnum }</b>人</b></div>
<div class="sidebar-number-days-r"><span>已经预热</span><b><b>18</b>天</b></div>
</div>
</div>
<div class="project-by">
<div class="project-by-dotty">项目发起人</div>
<div class="project-by-img"><a href="<%=request.getContextPath()%>/${project.createuser }" target="_blank">
<img src="<%=request.getContextPath()%>/demohour-index_files/thumb.png" height="80" width="80"></a>
<div class="project-by-img-r"><a href="<%=request.getContextPath()%>/${project.createuser }" class="project-by-img-r-author" target="_blank">${createuser.UserName }</a>
<div class="project-by-last-time">上次登录时间：2013/08/17
<div class="post-private-letter"><a href="<%=request.getContextPath()%>/messages?recipient_id=${createuser.UserId }" class="ui-popup-message" title="私信给 ${createuser.UserName }">发私信</a></div>
</div>
<div class="project-by-post">
<a href="<%=request.getContextPath()%>/${project.createuser }" target="_blank">支持的项目：<span>0</span></a>
<a href="<%=request.getContextPath()%>/${project.createuser }" target="_blank">发起的项目：<span>1</span></a>
</div>
</div>
</div>
</div>
<div class="reward-options">
<c:forEach items="${returns }" var="return" varStatus="s">
	<ul>
	<li class="support-amount">
	支持 <b>¥</b>${return.money }
	<span>（0 位支持者）</span>
	</li>
	<c:if test="${return.limit=='1' }">
	<li class="supporter-number"><div class="supporter-limit">
	<p>限额 ${return.limitnum }位，剩余 ${return.limitnum-return.supported } 位</p>
	</div></li></c:if>
	<li class="returns-contents"><p>${return.content }</p></li>
	<li class="returns-contents-img">
	</li>
	<li class="returns-contents-time">
	<p><c:if test="${return.freepost=='1' }">包邮（大陆地区）</c:if></p>
	<p>预计回报发放时间：项目成功结束后${return.days }天内</p>
	</li>
	<li>
	<div class="ui-button ui-button-special"><span><a href="#ui_warming_popup" class="ui-popup-open" data-popup-height="180">支持<b>¥</b>${return.money }</a></span></div>
	</li>
	</ul>
</c:forEach>
</div>
<div class="payment-refund">关于预热项目：<p></p>
预热项目是筹资前的一个热身，目的是希望更多的朋友能关注项目，给项目提意见，帮助发起人完善项目的各项内容。<p></p>
当项目成熟时，发起人可以随时提交审核开始筹资。
</div>
</div>
<div id="warming_popup" class="ui-popup ui-popup-blank ui-popup-invite" style="display:none">
<div class="ui-popup-background">
<div class="ui-popup-content ui-draggable">
<table class="ui-popup-table" align="center" border="0" cellpadding="0" cellspacing="0">
<tbody><tr><td class="ui-popup-top-l" width="25"></td>
<td class="ui-popup-top"></td>
<td class="ui-popup-top-r" width="25"><a href="#close" class="ui-popup-close">关闭</a></td></tr>
<tr><td class="ui-popup-mid-l"></td>
<td class="ui-popup-mid">
<ul>
<li class="ui-popup-invite-t">项目正在预热中，目前还不能进行现金支持！</li>
<li class="ui-popup-invite-c">
预热是筹资前的一个热身，目的是希望更多的朋友能关注项目，<br>
给项目提意见，帮助发起人完善项目的各项内容，最终能够成功完成筹资。
</li>
<li>	
<div class="project-invite-title">别错过了项目的最新动态！请立即关注此项目</div>
<div class="ui-button ui-button-blue"><span><a href="http://www.demohour.com/projects/322072/invite" title="+关注此项目">+关注此项目</a></span></div>	
</li>
</ul>
</td>
<td class="ui-popup-mid-r"></td></tr>
<tr><td class="ui-popup-bottom-l"></td><td class="ui-popup-bottom"></td><td class="ui-popup-bottom-r"></td></tr>
</tbody></table>
</div>
</div>
</div>

</div>
</div>
<div class="bottom-interest-title"><a href="http://www.demohour.com/projects/slide?target=footer" data-remote="true">换一换</a>你可能感兴趣的项目</div>
<div class="bottom-interest" id="footer_slides">
<div id="projects" class="project-list">
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/321583" title="T-EYE， 让智能手机变身google眼镜" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-012-069-12069-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/321583" title="T-EYE， 让智能手机变身google眼镜">T-EYE， 让智能手机变身google眼镜</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/321583/posts" title="此项目有41个话题" class="project-p-on">话题：41</a>
<a href="http://www.demohour.com/projects/321583/subscribers" title="318用户关注此项目" class="project-g-on">关注：318</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:37%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>37%</strong>热度</p>
<p class="widthb"><strong><span>5976</span></strong>浏览人数</p>
<p class="widthc"><strong>25天</strong>已经预热</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/316845" title="超 •手柄革命 多功能蓝牙游戏手柄 Dark Hammer " target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-010-037-10037-medium.png"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/316845" title="超 •手柄革命 多功能蓝牙游戏手柄 Dark Hammer ">超 •手柄革命 多功能蓝牙游戏手柄 Dark Hammer </a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/316845/posts" title="此项目有24个话题" class="project-p-on">话题：24</a>
<a href="http://www.demohour.com/projects/316845/subscribers" title="115用户关注此项目" class="project-g-on">关注：115</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:3%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>3%</strong>热度</p>
<p class="widthb"><strong><span>3928</span></strong>浏览人数</p>
<p class="widthc"><strong>95天</strong>已经预热</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/319612" title="ppt多能助手（iphone手机外挂设备）" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-344-11344-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/319612" title="ppt多能助手（iphone手机外挂设备）">ppt多能助手（iphone手机外挂设备）</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/319612/posts" title="此项目有18个话题" class="project-p-on">话题：18</a>
<a href="http://www.demohour.com/projects/319612/subscribers" title="108用户关注此项目" class="project-g-on">关注：108</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:77%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>77%</strong>热度</p>
<p class="widthb"><strong><span>4866</span></strong>浏览人数</p>
<p class="widthc"><strong>72天</strong>已经预热</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/321626" title="中美合拍悬疑电影《破镜》 华人电影精英纽约联合制作" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-012-089-12089-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/321626" title="中美合拍悬疑电影《破镜》 华人电影精英纽约联合制作">中美合拍悬疑电影《破镜》 华人电影精英纽约联合制作</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/321626/posts" title="此项目有24个话题" class="project-p-on">话题：24</a>
<a href="http://www.demohour.com/projects/321626/backers" title="45用户支持此项目" class="project-g-on">支持：45</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:53%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>53%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>15,900</span></strong>已获支持</p>
<p class="widthc"><strong>
25天
</strong>剩余时间</p>
</div>
</li>
</ul>

</div>

</div>
<div style="display: block;" id="favorite_tips" class="registration-tip registration-tip2">
<div class="inner">
<div class="tip"><p>别错过了项目的最新动态！立即关注此项目：</p></div>
<div class="ui-button ui-button-blue"><span><a href="<%=request.getContextPath() %>/projects/322072/invite" title="+关注此项目">+ 关注此项目</a></span></div>
<a href="#ui_favorite_tips" class="ui-action-close close">关闭</a>
</div></div>

<div class="footer2" style="background:#f2f2f2;">
<div class="h-media-reports-b">
<ul>
<li>
<p>众拍网的运作模式</p>     
每个项目都有目标金额和时间限制，项目必须在发起人预设的时间内达到或超过目标金额才算成功。没有达到目标的项目，支持款项将全额退回给所有支持者。<br><br>所有项目发起人都经过实名认证。项目筹资前都已通过工作人员及大众评委审核。项目发起人会清楚标示项目的潜在风险，以及将采取的补救措施。
</li>
</ul>
<ul>
<li><p>众拍网收费吗？</p>       
众拍网是一个开放，免费的众筹平台，无论项目成功与否众拍网都不收取任何手续费。
<i><span>“</span>这几乎是我现在最需要的平台，并且它兼具了筹款、销售、营销推广的功能！<span>”</span><strong> —— 孙杨《纸品的美好》项目发起人</strong></i>
</li>
</ul>
<ul class="h-media-reports-b-r">
<li><p>为什么需要设置回报？</p>         
众筹具有一定的公益属性，回报是吸引公众支持的重要因素，也是区别于传统公益的主要特征。<br><br>公众基于对项目、发起人和回报的认同，通过资助的方式参与和支持创新。项目发起人在接受支持的同时给予支持者一定的回报（可以是实物，也可以是非实物，但不能涉及资金或股权）作为感谢。
</li>
<li><a href="http://www.demohour.com/intro" target="_blank" class="h-media-reports-b-r-more">查看完整服务介绍</a></li>
</ul>
</div>

<div class="h-media-reports">
<p>感谢国内外媒体报道支持</p>
<a href="http://site.douban.com/widget/notes/4422127/note/218531103/" title="新周刊" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-01-04e39a7307d5119ac4df50d9e51dbbbd.gif"></a>
<a href="http://site.douban.com/widget/notes/4422127/note/215977583/" title="南方都市报" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-02-39101939abd2a818f930b2c3f436e38a.gif"></a>
<a href="http://site.douban.com/widget/notes/4422127/note/216279901/" title="南方周刊" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-03-bf5f2628a4a9548b1fd6750de0d8f05e.gif"></a>
<a href="http://finance.cnr.cn/gs/201201/t20120112_509051989.shtml" title="经济之声" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-04-1a732a930611e6960263b399816b0a1a.gif"></a>
<a href="http://news.xinhuanet.com/book/2012-06/25/c_123324750.htm" title="北京青年报" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-05-bd5f1c3bab1f62bd218702c792f4222c.gif"></a>
<a href="http://site.douban.com/widget/notes/4422127/note/217068128/" title="北京晚报" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-06-dbe57a3ff106dfdc5bf5d26734595676.gif"></a>
<a href="http://site.douban.com/widget/notes/4422127/note/213505558/" title="商业周刊/中文版" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-07-f940ef6cca208ef3e8ca12c58aa4cc7b.gif"></a>
<a href="http://news.xinhuanet.com/2013-04/12/c_115370793.htm" title="新华网" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/new.jpg"></a>



</div>
</div>

<div id="ui_popup_delete" class="ui-popup ui-popup-blank ui-popup-delete">
<div class="ui-popup-background">
<div class="ui-popup-content ui-draggable">
<table class="ui-popup-table" align="center" border="0" cellpadding="0" cellspacing="0">
<tbody><tr><td class="ui-popup-top-l" width="25"></td>
<td class="ui-popup-top"></td>
<td class="ui-popup-top-r" width="25"><a href="#close" class="ui-popup-close">关闭</a></td></tr>
<tr><td class="ui-popup-mid-l"></td>
<td class="ui-popup-mid">
<p class="ui-popup-text"></p>
<div class="ui-button-green ui-button"><span><a class="ui-popup-url" href="#" data-method="delete" data-remote="true" rel="nofollow">删除</a></span></div>
<a href="#close" class="ui-popup-close ui-popup-delete-cancel">取消</a>
</td>
<td class="ui-popup-mid-r"></td></tr>
<tr><td class="ui-popup-bottom-l"></td><td class="ui-popup-bottom"></td><td class="ui-popup-bottom-r"></td></tr>
</tbody></table>
</div>
</div>
</div>
<div id="ui_popup_message" class="ui-popup ui-popup-textarea">
<div class="ui-popup-background">
<div class="ui-popup-content ui-draggable">
<form accept-charset="UTF-8" action="/messages" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="mXPrIAvBs23PnmOfF1PE+JbSsr4Af0qcf0L0VwNiNsQ=" type="hidden"></div>
<table class="ui-popup-table" align="center" border="0" cellpadding="0" cellspacing="0">
<tbody><tr><td class="ui-popup-top-l" width="25"></td>
<td class="ui-popup-top"><span class="ui-popup-title"></span></td>
<td class="ui-popup-top-r" width="25"><a href="#close" class="ui-popup-close">关闭</a></td></tr>
<tr><td class="ui-popup-mid-l"></td>
<td class="ui-popup-mid">
<div class="ui-textarea">
<div class="ui-textarea-border">
<textarea id="message_content" name="message[content]" class="ui-text-fixed"></textarea>
</div>
</div>
<div class="ui-popup-textarea-b">
<span id="ui_popup_message_url"><a href="http://www.demohour.com/messages">查看私信记录</a></span>
<span id="ui_popup_message_email" style="display:none"><label><input name="message[email_sync]" value="1" type="checkbox"> 同时发送邮件</label></span>
<span id="message_content_error"></span>
<div class="ui-button ui-button-green ui-button-ajax"><span><button type="submit">发送</button></span></div>
</div>
</td>
<td class="ui-popup-mid-r"></td></tr>
<tr><td class="ui-popup-bottom-l"></td><td class="ui-popup-bottom"></td><td class="ui-popup-bottom-r"></td></tr>
</tbody></table>
</form></div>
</div> 
</div>
<div class="footerwrap">
<div class="footer">
<a href="http://www.demohour.com/projects/new">发起项目</a>
<a href="http://www.demohour.com/intro">服务介绍</a>
<a href="http://www.demohour.com/guideline">项目规范</a>
<a href="http://www.demohour.com/faq">常见问题</a>
<a href="http://www.demohour.com/terms_of_service">服务条款</a>
<a href="http://www.demohour.com/privacy_policy">隐私权政策</a>
<a href="http://www.demohour.com/about">关于我们</a>
<a href="http://www.demohour.com/projects/313907">建议反馈</a>
<a href="http://weibo.com/demohour" target="_blank">官方微博</a>
<a href="http://blog.demohour.com/" target="_blank">官方博客</a>
<a href="http://www.demohour.com/?screen=mobile" class="last">手机版</a>
<p>© 2013北京众拍网科技有限公司　Demohour.com 版权所有<br>电信与信息服务业务经营许可证120183号　京ICP备11032157号　京公网安备110105015321</p>
<div style="display: block;" id="backtop" class="backtop"><a href="#top"></a></div>
</div>
</div>


<script src="<s:url value="/demohour-index_files/jia.js"/>" async="" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/demohour-index_files/ga.js" async="" type="text/javascript"></script>
<script src="<s:url value="/demohour-index_files/application-ffd788692166a3012f8373c435f5c0c2.js"/>" type="text/javascript"></script>
<script src="<s:url value="/demohour-index_files/projects-1ab927eb13eddbb381c44171a7060594.js"/>" type="text/javascript"></script>
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
    $.ui_core.visit({
        until: "2013-08-17 20:59:49 +0800"
    }),
    $(".projects-home-left-synopsis").find("img").click(function() {
        $(this).attr("src").indexOf("large") > 0 && window.open("/attachments?url=" + $(this).attr("src").replace("large", "original"), "original_image")
    }),
    $.ui_core.flash("project_intro", []),
    jiathis_config = {
        summary: "Talking Timer是什么？很简单，如同它的名字，是一款可以对话的提示器。",
        title: "#Talking Timer（对讲提示器）#"
    },
    function() {
        var e = document.createElement("script");
        e.type = "text/javascript",
        e.async = !0,
        e.src = ("https:" == document.location.protocol ? "https://": "http://") + "v2.jiathis.com/code/jia.js";
        var t = document.getElementsByTagName("script")[0];
        t.parentNode.insertBefore(e, t)
    } (),
    $(".invite_popup").click(function() {
        jiathis_config.url = "http://www.demohour.com/projects/322072?u=1121568"
    }),
    $("#invite_url").click(function() {
        $(this).select();
    }),
    $("#new_post").find("form").on("submit", 
    	function() {
        	$(".ui-flash").remove()
    }),
    $("#new_post").find("form").on('ajax:success', function(data) {
        alert(data);
    }),
    editors = $("#post_content_1").ueditor({
        autosave: !1,
        image: {
            url: "/attachments?sign=6d2c0f52ea30040e8c3c0aff34adc72431e2ef08ca5ee6f52371940156737d85&amp;type=post_photo&amp;user_id=1121568",
            flash_url: "/assets/swfupload/swfupload.swf",
            button_image_url: "/assets/ueditor/default/images/upload.gif",
            total_file_upload_limit: "20"
        },
        video: {
            url: "/attachments?sign=fe20660471609e35acc4dbf24af782fdba18fd536a3147090103407ee9b68495&amp;type=post_video&amp;user_id=1121568",
            default_image: "/assets/ueditor/default/images/video.png"
        },
        editor_config_options: {
            minFrameHeight: 140
        }
    }),
    setInterval(function() {
        var e = !0;
        $("div.ui-popup").each(function() {
            "block" == $(this).css("display") && (e = !1)
        }),
        e && "none" == $("#favorite_tips").css("display") && $("#favorite_tips").show("slide", {
            direction: "down"
        },
        500)
    },
    3e4),
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
        now: '2013-08-18 00:59:49 +0800'
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
<div style="position: fixed; left: 0px; top: 0px; width: 0px; height: 0px;" id="edui_fixedlayer"><div style="display: none;" id="edui9" class="edui-dialog edui-for-link"><div class="edui-dialog-wrap"><div id="edui9_body" class="edui-dialog-body"><div class="edui-dialog-shadow"></div><div id="edui9_titlebar" class="edui-dialog-titlebar"><div class="edui-dialog-draghandle" onmousedown='$EDITORUI["edui9"]._onTitlebarMouseDown(event, this);'><span class="edui-dialog-caption">超链接</span></div><div id="edui12" class="edui-box edui-button edui-dialog-closebutton"><div id="edui12_state" onmousedown='$EDITORUI["edui12"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui12"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui12"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui12"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="关闭对话框" id="edui12_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui12"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label"></div></div></div></div></div></div><div id="edui9_content" class="edui-dialog-content"></div><div class="edui-dialog-foot"><div id="edui9_buttons" class="edui-dialog-buttons"><div id="edui13" class="edui-box edui-button edui-okbutton"><div id="edui13_state" onmousedown='$EDITORUI["edui13"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui13"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui13"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui13"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui13_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui13"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">确认</div></div></div></div></div><div id="edui14" class="edui-box edui-button edui-cancelbutton"><div id="edui14_state" onmousedown='$EDITORUI["edui14"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui14"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui14"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui14"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui14_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui14"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">取消</div></div></div></div></div></div></div></div></div></div><div style="display: none;" id="edui10" class="edui-mask  edui-dialog-modalmask" onmousedown='return $EDITORUI["edui10"]._onMouseDown(event, this);'></div><div style="display: none;" id="edui11" class="edui-mask  edui-dialog-dragmask" onmousedown='return $EDITORUI["edui11"]._onMouseDown(event, this);'></div><div style="display: none;" id="edui15" class="edui-dialog edui-for-insertvideo"><div class="edui-dialog-wrap"><div id="edui15_body" class="edui-dialog-body"><div class="edui-dialog-shadow"></div><div id="edui15_titlebar" class="edui-dialog-titlebar"><div class="edui-dialog-draghandle" onmousedown='$EDITORUI["edui15"]._onTitlebarMouseDown(event, this);'><span class="edui-dialog-caption">视频</span></div><div id="edui16" class="edui-box edui-button edui-dialog-closebutton"><div id="edui16_state" onmousedown='$EDITORUI["edui16"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui16"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui16"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui16"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="关闭对话框" id="edui16_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui16"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label"></div></div></div></div></div></div><div id="edui15_content" class="edui-dialog-content"></div><div class="edui-dialog-foot"><div id="edui15_buttons" class="edui-dialog-buttons"><div id="edui17" class="edui-box edui-button edui-okbutton"><div id="edui17_state" onmousedown='$EDITORUI["edui17"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui17"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui17"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui17"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui17_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui17"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">确认</div></div></div></div></div><div id="edui18" class="edui-box edui-button edui-cancelbutton"><div id="edui18_state" onmousedown='$EDITORUI["edui18"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui18"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui18"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui18"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui18_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui18"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">取消</div></div></div></div></div></div></div></div></div></div><div style="display: none;" id="edui19" class="edui-popup  edui-bubble"> <div id="edui19_body" class="edui-popup-body"> <iframe style="position:absolute;z-index:-1;left:0;top:0;background-color: white;" src="javascript:" frameborder="0" height="100%" width="100%"></iframe> <div class="edui-shadow"></div> <div id="edui19_content" class="edui-popup-content">  </div> </div></div></div></body></html>