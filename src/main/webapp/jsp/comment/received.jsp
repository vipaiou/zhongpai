<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../include/header.jsp" %>
<div class="ui-tab">
<div class="ui-tab-top">
<h2>我的评论</h2>
</div>
<div class="ui-tab-layout">
<ul class="ui-tab-menu">
<li><a class="ui-tab-current" href="<%=request.getContextPath()%>/comment/received">收到的评论</a></li>
<li><a href="<%=request.getContextPath()%>/comment/sent">发出的评论</a></li>
</ul>
</div>
</div>
<div class="content private-letter-page">
<div class="letter-page-left">	
<div class="private-letter-title">共<span id="comment_count">2</span>条</div>
<ul class="private-letter-list">
<li id="comment_98058">
<a href="<%=request.getContextPath()%>/1021804" target="_blank" class="private-letter-list-l">
<img src="<%=request.getContextPath()%>/demohour-index_files/user_avatars-files-000-035-953-35953-small.jpg"></a>
<div class="private-letter-list-r">
<div class="private-letter-list-t">
<a href="<%=request.getContextPath()%>/1021804" target="_blank">立夏</a>
<div class="icon-sun-s"><a href="<%=request.getContextPath()%>/posts/9138" target="_blank" title="支持者勋章：级别1">1</a></div>
：嗯，改了，谢谢~
</div>
<div class="private-letter-original">
回复 我 的评论： 
<a href="<%=request.getContextPath()%>/comments/98058">哦，我看你的  2，购置耗材如：打印纸，墨盒等。以为只...</a>
</div>
<div class="private-letter-list-b"><span class="private-letter-list-date" data-timestamp="2013-08-06 17:47:32 +0800">26天以前</span>
<a href="#98058" class="ui-action-reply timeline-comment-reply" rel="nofollow" title="回复 立夏">回复</a>
<span>|</span>
<a href="<%=request.getContextPath()%>/comments/98058" class="timeline-comment-reply" rel="nofollow" title="查看原文">原文</a>
<span>|</span>
<a href="<%=request.getContextPath()%>/comments/98058?target=post&amp;target_id=6256" class="ui-popup-delete timeline-comment-delete" rel="nofollow" title="确认要删除这条评论吗？">删除</a></div>
<div id="comment_98058_reply" class="comment-list-reply" style="display:none">
<form accept-charset="UTF-8" action="/comments?from=comments&amp;target=post&amp;target_id=6256" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="WgCQl1g0l5r3m2JHy6Ry3Z6wZyCNMrtEtpJ9/hjEy6U=" type="hidden"></div>
<input name="comment[target_id]" value="6256" type="hidden">
<input name="comment[comment_id]" value="98058" type="hidden">
<input name="comment[comment_user_id]" value="1021804" type="hidden">
<input name="comment[sns_sync]" value="0" type="hidden">
<div class="ui-textarea">
<div class="ui-textarea-border">
<textarea id="comment_98058_content" name="comment[content]"></textarea>
</div>
</div>
<div class="timeline-box-textarea-b">
<div id="comment_98058_content_error"></div>
<div class="ui-button ui-button-green ui-button-ajax"><span><button type="submit">发送</button></span></div>
</div>
</form></div>

</div>
</li>

<li id="comment_97407">
<a href="<%=request.getContextPath()%>/1021804" target="_blank" class="private-letter-list-l">
<img src="<%=request.getContextPath()%>/demohour-index_files/user_avatars-files-000-035-953-35953-small.jpg"></a>
<div class="private-letter-list-r">
<div class="private-letter-list-t">
<a href="<%=request.getContextPath()%>/1021804" target="_blank">立夏</a>
<div class="icon-sun-s"><a href="<%=request.getContextPath()%>/posts/9138" target="_blank" title="支持者勋章：级别1">1</a></div>
：相纸呢
</div>
<div class="private-letter-original">
回复 我 的评论： 
<a href="<%=request.getContextPath()%>/comments/97407">用白纸打印的相片？</a>
</div>
<div class="private-letter-list-b"><span class="private-letter-list-date" data-timestamp="2013-08-01 18:36:59 +0800">1月以前</span>
<a href="#97407" class="ui-action-reply timeline-comment-reply" rel="nofollow" title="回复 立夏">回复</a>
<span>|</span>
<a href="<%=request.getContextPath()%>/comments/97407" class="timeline-comment-reply" rel="nofollow" title="查看原文">原文</a>
<span>|</span>
<a href="<%=request.getContextPath()%>/comments/97407?target=post&amp;target_id=6256" class="ui-popup-delete timeline-comment-delete" rel="nofollow" title="确认要删除这条评论吗？">删除</a></div>
<div id="comment_97407_reply" class="comment-list-reply" style="display:none">
<form accept-charset="UTF-8" action="/comments?from=comments&amp;target=post&amp;target_id=6256" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="WgCQl1g0l5r3m2JHy6Ry3Z6wZyCNMrtEtpJ9/hjEy6U=" type="hidden"></div>
<input name="comment[target_id]" value="6256" type="hidden">
<input name="comment[comment_id]" value="97407" type="hidden">
<input name="comment[comment_user_id]" value="1021804" type="hidden">
<input name="comment[sns_sync]" value="0" type="hidden">
<div class="ui-textarea">
<div class="ui-textarea-border">
<textarea id="comment_97407_content" name="comment[content]"></textarea>
</div>
</div>
<div class="timeline-box-textarea-b">
<div id="comment_97407_content_error"></div>
<div class="ui-button ui-button-green ui-button-ajax"><span><button type="submit">发送</button></span></div>
</div>
</form></div>

</div>
</li>

</ul>
<div class="private-letter-paginationss">
<div class="ui-pagination"><ul></ul></div>
</div>
</div>
<div class="letter-page-right">
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
<script src="<%=request.getContextPath()%>/demohour-index_files/comments-81a8e5c3f0f88ef37b5abe40fcd3aa03.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$.ui_notification.ready({url:'http://nf-2.demohour.com',data:{"new_comments_count":0,"new_messages_count":0,"new_notifications_count":0,"new_posts_count":0}});$("body").on("click","a.ui-action-reply",function(e){var t=$(e.target).attr("href").split("#")[1];$("#comment_"+t+"_reply").toggle(),$("#comment_"+t+"_reply").find("textarea").focus(),$("#comment_"+t+"_reply").find("textarea").attr("placeholder",$(e.target).attr("title"))}),$("body").on("click","a.ui-popup-delete",function(e){$("#ui_popup_delete").find("div.ui-popup-content").css("top",$(window).height()/2-120),$("#ui_popup_delete").find("p.ui-popup-text").html($(e.target).attr("title")),$("#ui_popup_delete").find("a.ui-popup-url").attr("href",$(e.target).attr("href")),$("#ui_popup_delete").toggle(),e.preventDefault()}),$("body").on("click","a.ui-popup-message",function(e){$("#ui_popup_message").find("div.ui-popup-content").css("top",$(window).height()/2-150),$("#ui_popup_message").find("form").attr("action",$(e.target).attr("href")),$("#ui_popup_message").find("span.ui-popup-title").html($(e.target).attr("title")),$("#ui_popup_message").toggle(),$("#ui_popup_message").find("textarea").val($(e.target).attr("data-message-attachment")),$("#ui_popup_message").find("textarea").focus(),$(e.target).attr("href").indexOf("?recipient_id=")>0?($("#ui_popup_message_url").show(),$("#ui_popup_message_email").hide(),$("#ui_popup_message_url").find("a").attr("href",$(e.target).attr("href").replace("?recipient_id=","/"))):($("#ui_popup_message_url").hide(),$("#ui_popup_message_email").show()),e.preventDefault()});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-09-01 21:52:24 +0800'});});
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