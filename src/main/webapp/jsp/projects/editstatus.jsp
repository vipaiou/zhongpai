<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../include/header.jsp" %>
<link href="<s:url value="/demohour-index_files/projects-9afed8175e89fa73647b287e62737440.css" />" media="screen" rel="stylesheet" type="text/css">
<div class="ui-tab">
<div class="ui-tab-top">
<h2>
<a href="<%=request.getContextPath()%>/projects/view/${project.id}">${project.name}</a>
<span>/</span>
项目管理
</h2>
</div>
<div class="ui-tab-layout">
<ul class="ui-tab-menu">
<li><a href="<%=request.getContextPath()%>/projects/edit/${project.id}">项目说明</a></li>
<li><a href="<%=request.getContextPath()%>/projects/editreturn/${project.id}">回报设置</a></li>
<li><a class="ui-tab-current" href="<%=request.getContextPath()%>/projects/editstatus/${project.id}">项目状态</a></li>
</ul>
<div class="ui-tab-menu-right">
<div class="ui-button ui-button-blue"><span><a href="<%=request.getContextPath()%>/messages?recipient_id=1013487" title="私信给 众拍网客服" class="ui-popup-message">联系客服</a></span></div>
<div class="ui-button ui-button-blue"><span><a href="<%=request.getContextPath()%>/projects/view/${project.id}" target="_blank"><div class="ui-button-icon"><img src="<%=request.getContextPath()%>/demohour-index_files/ui-button-icon1-7be09a1379f6cfe4a4e5fc45fcd64435.gif"></div>预览</a></span></div>
</div></div></div>


<div id="new_project" class="projects-new">
<form accept-charset="UTF-8" action="<%=request.getContextPath()%>/projects/submitaudit" class="edit_project" id="edit_project" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="_method" value="put" type="hidden"><input name="authenticity_token" value="mXPrIAvBs23PnmOfF1PE+JbSsr4Af0qcf0L0VwNiNsQ=" type="hidden"></div>
<div class="stepintro"><strong>准备提交审核</strong>提示：提交审核后众拍网将在3个工作日内完成审核，请留意站内通知以及你的邮箱。审核通过后，你的项目将会立即上线！
</div>
<ul class="snsaccounts projects-new-contact">
<li class="projects-new-contact-title"><strong>填写项目筹资目标（必填）</strong></li>
<li>
<label>筹集金额:</label>
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" id="project_target_amount" name="money" placeholder="不少于500元" size="30" value="5000" type="text">
<input type="hidden" value="${project.id }" name="id"/>
</div>
</div>
</li>
<li>
<label>筹集天数:</label>
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" id="project_target_days" name="day" placeholder="15-60天" size="30" value="111" type="text" value="${project.day }">
</div>
</div>
</li>
</ul>
<ul class="snsaccounts projects-new-contact">
<li class="projects-new-contact-title"><strong>填写你的姓名及联系方式（必填）</strong></li>
<li><label>真实姓名:</label>
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" id="user_detail_name" name="realname" placeholder="" size="30" type="text" value="${project.realname }">
</div>
</div>
</li>
<li class="photo-id-sex"><label>性别:</label>
<div class="ui-radio">
<label><input class="ui-radio radio" id="user_detail_gender_1" name="gender" value="1" type="radio" <c:if test="${project.sex=='1'}"> checked</c:if> />男</label>
<label><input class="ui-radio radio" id="user_detail_gender_0" name="gender" value="0" type="radio" <c:if test="${project.sex=='0'}"> checked</c:if> />女</label>
</div>
<div id="user_detail_gender_error"></div>
</li>
<li>
<label>手机号码:</label>
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" id="user_detail_mobile" name="phone" placeholder="" size="30" type="text" value="${project.phone }">
</div>
</div>
</li>
<li>
<label>QQ号码:</label>
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" id="user_detail_qq" name="qq" placeholder="" size="30" type="text" value="${project.qq }">
</div>
</div>
</li>
</ul>
<div>注：提交审核前，请认真阅读<a href="http://www.demohour.com/guideline" target="_blank">《项目规范》</a>，确认项目内容及回报符合众拍网项目规范</div>
<div class="form-submit form-submit-edit-end">
<div class="ui-button ui-button-green"><span><button type="submit">提交审核</button></span></div>
</div>
</form>
<ul class="related-log">
<li><strong>项目日志：</strong></li>
<li><label>2013-08-17 16:35</label>
<p class="showtext">
创建
</p>
</li>
</ul>
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
<script src="<%=request.getContextPath()%>/demohour-index_files/projects-1ab927eb13eddbb381c44171a7060594.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$.ui_notification.ready({url:'http://nf-2.demohour.com',data:{"new_comments_count":0,"new_messages_count":0,"new_notifications_count":0,"new_posts_count":0}});$.ui_core.flash("new_project",[]),$.ui_core.notice("project",{}),$.ui_core.notice("user_detail",{}),$("#edit_project").on("submit",function(e){$("#project_step_3").length>0&&!$("#project_step_3").is(":checked")&&!$("#project_step_6").is(":checked")&&($("html, body").animate({scrollTop:0},500),$.ui_core.flash("edit_project",[["failure","请选择项目类型"]]),e.preventDefault())}),$("body").on("click","a.ui-popup-delete",function(e){$("#ui_popup_delete").find("div.ui-popup-content").css("top",$(window).height()/2-120),$("#ui_popup_delete").find("p.ui-popup-text").html($(e.target).attr("title")),$("#ui_popup_delete").find("a.ui-popup-url").attr("href",$(e.target).attr("href")),$("#ui_popup_delete").toggle(),e.preventDefault()}),$("body").on("click","a.ui-popup-message",function(e){$("#ui_popup_message").find("div.ui-popup-content").css("top",$(window).height()/2-150),$("#ui_popup_message").find("form").attr("action",$(e.target).attr("href")),$("#ui_popup_message").find("span.ui-popup-title").html($(e.target).attr("title")),$("#ui_popup_message").toggle(),$("#ui_popup_message").find("textarea").val($(e.target).attr("data-message-attachment")),$("#ui_popup_message").find("textarea").focus(),$(e.target).attr("href").indexOf("?recipient_id=")>0?($("#ui_popup_message_url").show(),$("#ui_popup_message_email").hide(),$("#ui_popup_message_url").find("a").attr("href",$(e.target).attr("href").replace("?recipient_id=","/"))):($("#ui_popup_message_url").hide(),$("#ui_popup_message_email").show()),e.preventDefault()});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-08-17 16:45:31 +0800'});});
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