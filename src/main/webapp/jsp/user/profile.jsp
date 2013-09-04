<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../include/header.jsp" %>
<div class="ui-tab">
<div class="ui-tab-top">
<h2>帐号设置</h2>
</div>
<div class="ui-tab-layout">
<ul class="ui-tab-menu">
<li><a class="ui-tab-current" href="<%=request.getContextPath()%>/user/profile" title="个人资料">个人资料</a> </li>
<li><a href="<%=request.getContextPath()%>/user/account" title="密码设置">帐号密码</a></li>
<li><a href="<%=request.getContextPath()%>/user/notification" title="通知设置">通知设置</a></li>
<li><a href="<%=request.getContextPath()%>/user/sns" title="绑定设置">绑定设置</a></li>
</ul>
</div>
</div>

<div class="content">
<form accept-charset="UTF-8" action="/settings/update_profile" enctype="multipart/form-data" id="edit_profile" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="WgCQl1g0l5r3m2JHy6Ry3Z6wZyCNMrtEtpJ9/hjEy6U=" type="hidden"></div>
<div class="left">
<ul class="gerenleft">
<li class="topli"><label for="user_name">显示名称:</label><input class="inputregoff" id="user_name" name="user[name]" onblur="this.className='inputregoff'" onfocus="this.className='inputregon'" size="30" value="aiou" type="text">
<span>将显示在你的个人档案上</span></li>
<li><label for="user_province">所在地:</label>
<select id="user_province" name="user[province]"><option selected="selected" value="">请选择</option><option value="北京">北京</option><option value="上海">上海</option><option value="广东">广东</option><option value="浙江">浙江</option><option value="江苏">江苏</option><option value="安徽">安徽</option><option value="重庆">重庆</option><option value="福建">福建</option><option value="甘肃">甘肃</option><option value="广西">广西</option><option value="贵州">贵州</option><option value="海南">海南</option><option value="河北">河北</option><option value="河南">河南</option><option value="黑龙江">黑龙江</option><option value="湖北">湖北</option><option value="湖南">湖南</option><option value="吉林">吉林</option><option value="江西">江西</option><option value="辽宁">辽宁</option><option value="内蒙古">内蒙古</option><option value="宁夏">宁夏</option><option value="青海">青海</option><option value="山东">山东</option><option value="山西">山西</option><option value="陕西">陕西</option><option value="四川">四川</option><option value="天津">天津</option><option value="西藏">西藏</option><option value="新疆">新疆</option><option value="云南">云南</option><option value="香港">香港</option><option value="澳门">澳门</option><option value="台湾">台湾</option><option value="海外">海外</option></select>
<select id="user_city" name="user[city]"><option selected="selected" value="">请选择</option></select>
<span id="user_province_error"></span><span id="user_city_error"></span></li>
<li><label for="user_biography">自我介绍:</label>
<textarea class="inputregoff" cols="40" id="user_intro" name="user[intro]" onblur="this.className='inputregoff'" onfocus="this.className='inputregon'" rows="20"></textarea>
<span class="input-tip-textarea">这里可以输入大约300字的自我介绍，让大家多了解你</span> </li>
<li class="websites"><label for="user_websites">博客或微博:</label> 
<div class="usersurlsfields">
<div><input class="inputregoff" onfocus="this.className='inputregon'" onblur="this.className='inputregoff'" size="30" name="user[blogs][]" type="text">
</div>
<a href="#more" id="new_blog">更多</a>
</div></li>
</ul>
<div class="form-submit"><div class="ui-button-green"><span><button type="submit" class="ui-button">保存最新的设置</button></span></div></div>
</div>
<div class="right gerenright">
<label for="user_picture">个人头像:</label>
<div class="removeable">
<object id="SWFUpload_0" type="application/x-shockwave-flash" data="<%=request.getContextPath()%>/demohour-index_files/swfupload.swf" class="swfupload" height="32" width="80"><param name="wmode" value="window"><param name="movie" value="/assets/swfupload/swfupload.swf?preventswfcaching=1378041985066"><param name="quality" value="high"><param name="menu" value="false"><param name="allowScriptAccess" value="always"><param name="wmode" value="transparent"><param name="flashvars" value="movieName=SWFUpload_0&amp;uploadURL=%2Fattachments%3Fsign%3Dedba173733c2ecc072352357379cfba944060dc6c7fd39601bfcc6ad1cb48571%26amp%3Btype%3Duser_avatar%26amp%3Buser_id%3D1121568&amp;useQueryString=false&amp;requeueOnError=false&amp;httpSuccess=&amp;assumeSuccessTimeout=0&amp;params=&amp;filePostName=Filedata&amp;fileTypes=*.jpg%3B*.gif%3B*.png%3B*.jpeg&amp;fileTypesDescription=%E5%9B%BE%E7%89%87%E6%96%87%E4%BB%B6&amp;fileSizeLimit=5120&amp;fileUploadLimit=0&amp;fileQueueLimit=0&amp;debugEnabled=false&amp;buttonImageURL=http%3A%2F%2Fassets.demohour.com%2Fassets%2Fupload-285b64cf3f94c8753e53c69150208bce.gif&amp;buttonWidth=80&amp;buttonHeight=32&amp;buttonText=&amp;buttonTextTopPadding=0&amp;buttonTextLeftPadding=0&amp;buttonTextStyle=color%3A%20%23000000%3B%20font-size%3A%2016pt%3B&amp;buttonAction=-100&amp;buttonDisabled=false&amp;buttonCursor=-1"></object>
<div id="user_avatar_url_error" class="llrfgfdg"></div>
<div id="user_avatar_preview">
<div id="user_avatar_106730">
<img src="<%=request.getContextPath()%>/demohour-index_files/user_avatars-files-000-106-730-106730-thumb.jpg">
<a href="<%=request.getContextPath()%>/attachments/106730?sign=4f8c8bee08a707652f8196e66a94ef02d9bd487b14e94428b084975947c30a23&amp;type=user_avatar&amp;url=http%3A%2F%2Fwww.demohour.com%2Fsettings%2Fprofile" data-method="delete" rel="nofollow">删除</a>
</div>

</div>
</div>
</div></form></div>
<div class="none" id="blog"><div class="url new"><input class="inputregoff" onfocus="this.className='inputregon'" onblur="this.className='inputregoff'" size="30" name="user[blogs][]" type="text">
<a href="#more" class="add remove_blog">删除</a></div></div>
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
<form accept-charset="UTF-8" action="/messages" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="WgCQl1g0l5r3m2JHy6Ry3Z6wZyCNMrtEtpJ9/hjEy6U=" type="hidden"></div>
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
<span id="ui_popup_message_url"><a href="<%=request.getContextPath()%>/messages">查看私信记录</a></span>
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
<a href="<%=request.getContextPath()%>/projects/new">发起项目</a>
<a href="<%=request.getContextPath()%>/intro">服务介绍</a>
<a href="<%=request.getContextPath()%>/guideline">项目规范</a>
<a href="<%=request.getContextPath()%>/faq">常见问题</a>
<a href="<%=request.getContextPath()%>/terms_of_service">服务条款</a>
<a href="<%=request.getContextPath()%>/privacy_policy">隐私权政策</a>
<a href="<%=request.getContextPath()%>/about">关于我们</a>
<a href="<%=request.getContextPath()%>/projects/313907">建议反馈</a>
<a href="http://weibo.com/demohour" target="_blank">官方微博</a>
<a href="http://blog.demohour.com/" target="_blank">官方博客</a>
<a href="<%=request.getContextPath()%>/?screen=mobile" class="last">手机版</a>
<p>© 2013北京众拍网科技有限公司　Demohour.com 版权所有<br>电信与信息服务业务经营许可证120183号　京ICP备11032157号　京公网安备110105015321</p>
<div id="backtop" class="backtop"><a href="#top"></a></div>
</div>
</div>


<script src="<%=request.getContextPath()%>/demohour-index_files/ga.js" async="" type="text/javascript"></script><script src="<%=request.getContextPath()%>/demohour-index_files/application-ffd788692166a3012f8373c435f5c0c2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/demohour-index_files/settings-5916087ed52d314ff9fc032599a500cd.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$.ui_notification.ready({url:'http://nf-2.demohour.com',data:{"new_comments_count":0,"new_messages_count":0,"new_notifications_count":0,"new_posts_count":0}});$.ui_core.flash("edit_profile",[]),$.ui_core.notice("user",{}),$(".remove_blog").click(function(e){$(e.target).parent("div").remove()}),$("#new_blog").click(function(e){$(e.target).before($($("#blog").html())),$(".remove_blog").click(function(e){$(e.target).parent("div").remove()})}),$("#user_province, #user_city").cascade({defaults:["",""],prompts:["请选择","请选择"]}),$.swfupload.load("user_avatar_button",{upload_url:"/attachments?sign=edba173733c2ecc072352357379cfba944060dc6c7fd39601bfcc6ad1cb48571&amp;type=user_avatar&amp;user_id=1121568",flash_url:"/assets/swfupload/swfupload.swf",file_size_limit:"5120",file_types:"*.jpg;*.gif;*.png;*.jpeg",file_types_description:"图片文件",file_queue_error_handler:function(e,t){t==SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED?$.ui_core.notice("user",{avatar_url:"超过允许上载的文件数量"}):t==SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT?$.ui_core.notice("user",{avatar_url:"文件超过尺寸限制"}):$.ui_core.notice("user",{avatar_url:"文件上传错误"})},file_dialog_start_handler:function(){$("#user_avatar_url_error").html("")},file_dialog_complete_handler:function(){this.startUpload()},upload_progress_handler:function(e,t,a){$("#user_avatar_url_error").html($("<em>文件上传中 "+Math.ceil(99*(t/a))+"%</em>"))},upload_error_handler:function(){this.startUpload(),$.ui_core.notice("user",{avatar_url:"文件上传错误"})},upload_success_handler:function(e,t){$("#user_avatar_preview").html($(t)),$("#user_avatar_url_error").html("")},upload_complete_handler:function(){$("#edit_profile").submit()},button_action:SWFUpload.BUTTON_ACTION.SELECT_FILE,button_image_url:"http://assets.demohour.com/assets/upload-285b64cf3f94c8753e53c69150208bce.gif",button_width:80,button_height:32}),$("body").on("click","a.ui-popup-delete",function(e){$("#ui_popup_delete").find("div.ui-popup-content").css("top",$(window).height()/2-120),$("#ui_popup_delete").find("p.ui-popup-text").html($(e.target).attr("title")),$("#ui_popup_delete").find("a.ui-popup-url").attr("href",$(e.target).attr("href")),$("#ui_popup_delete").toggle(),e.preventDefault()}),$("body").on("click","a.ui-popup-message",function(e){$("#ui_popup_message").find("div.ui-popup-content").css("top",$(window).height()/2-150),$("#ui_popup_message").find("form").attr("action",$(e.target).attr("href")),$("#ui_popup_message").find("span.ui-popup-title").html($(e.target).attr("title")),$("#ui_popup_message").toggle(),$("#ui_popup_message").find("textarea").val($(e.target).attr("data-message-attachment")),$("#ui_popup_message").find("textarea").focus(),$(e.target).attr("href").indexOf("?recipient_id=")>0?($("#ui_popup_message_url").show(),$("#ui_popup_message_email").hide(),$("#ui_popup_message_url").find("a").attr("href",$(e.target).attr("href").replace("?recipient_id=","/"))):($("#ui_popup_message_url").hide(),$("#ui_popup_message_email").show()),e.preventDefault()});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-09-01 21:26:19 +0800'});});
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
</body></html>