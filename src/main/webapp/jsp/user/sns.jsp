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
<li><a href="<%=request.getContextPath()%>/user/profile" title="个人资料">个人资料</a> </li>
<li><a href="<%=request.getContextPath()%>/user/account" title="密码设置">帐号密码</a></li>
<li><a href="<%=request.getContextPath()%>/user/notification" title="通知设置">通知设置</a></li>
<li><a class="ui-tab-current" href="<%=request.getContextPath()%>/user/sns" title="绑定设置">绑定设置</a></li>
</ul>
</div>
</div>

<div class="content">
<ul class="snsaccounts">
<li><label for="user_accounts_sina">新浪微博帐号:</label><div class="ui-button ui-button-green"><span><a href="<%=request.getContextPath()%>/session/connect?provider=sina">绑定</a></span></div>
</li>
<li><label for="user_accounts_tencent">腾讯微博帐号:</label><div class="ui-button ui-button-green"><span><a href="<%=request.getContextPath()%>/session/connect?provider=tencent">绑定</a></span></div>
</li>
<li><label for="user_accounts_qzone">QQ空间帐号:</label><div class="ui-button ui-button-green"><span><a href="<%=request.getContextPath()%>/session/connect?provider=qzone">绑定</a></span></div>
</li>
<li><label for="user_accounts_douban">豆瓣帐号:</label><div class="ui-button ui-button-green"><span><a href="<%=request.getContextPath()%>/session/connect?provider=douban">绑定</a></span></div>
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
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$.ui_notification.ready({url:'http://nf-2.demohour.com',data:{"new_comments_count":0,"new_messages_count":0,"new_notifications_count":0,"new_posts_count":0}});$("body").on("click","a.ui-popup-delete",function(e){$("#ui_popup_delete").find("div.ui-popup-content").css("top",$(window).height()/2-120),$("#ui_popup_delete").find("p.ui-popup-text").html($(e.target).attr("title")),$("#ui_popup_delete").find("a.ui-popup-url").attr("href",$(e.target).attr("href")),$("#ui_popup_delete").toggle(),e.preventDefault()}),$("body").on("click","a.ui-popup-message",function(e){$("#ui_popup_message").find("div.ui-popup-content").css("top",$(window).height()/2-150),$("#ui_popup_message").find("form").attr("action",$(e.target).attr("href")),$("#ui_popup_message").find("span.ui-popup-title").html($(e.target).attr("title")),$("#ui_popup_message").toggle(),$("#ui_popup_message").find("textarea").val($(e.target).attr("data-message-attachment")),$("#ui_popup_message").find("textarea").focus(),$(e.target).attr("href").indexOf("?recipient_id=")>0?($("#ui_popup_message_url").show(),$("#ui_popup_message_email").hide(),$("#ui_popup_message_url").find("a").attr("href",$(e.target).attr("href").replace("?recipient_id=","/"))):($("#ui_popup_message_url").hide(),$("#ui_popup_message_email").show()),e.preventDefault()});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-09-01 21:36:42 +0800'});});
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