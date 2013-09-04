<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../include/header.jsp" %>
<link href="<s:url value="/demohour-index_files/projects-9afed8175e89fa73647b287e62737440.css" />" media="screen" rel="stylesheet" type="text/css">
<div class="ui-tab">
<div class="ui-tab-top">
<h2>我的话题</h2></div>
<div class="ui-tab-layout">
<ul class="ui-tab-menu">
<li><a href="<%=request.getContextPath()%>/topic/" class="ui-tab-current">最近更新</a></li>
<li><a href="<%=request.getContextPath()%>/topic/created">我发起的</a></li>
<li><a href="<%=request.getContextPath()%>/topic/commented">我评论的</a></li>
</ul>
</div>
</div>
<div class="my-home">
<table id="posts" class="new-comment-list-my" border="0" cellpadding="0" cellspacing="0">
<tbody>
<tr class="new-comment-t">
<td colspan="2" align="left" width="360">话题</td>
<td align="left" width="97">作者</td>
<td align="center" width="40">回应</td>
<td align="right" width="68">最后回应</td>
<td class="new-comment-list-my-01" align="left">项目</td>
</tr>
<tr>
<td align="center" width="30">
<div class="comment-icon">[顶]</div>
</td><td width="330"><a href="<%=request.getContextPath()%>/posts/19724" class="c5 c5-length" title="什么时候开始筹款啊？" target="_blank">什么时候开始筹款啊？</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-08-21 17:59:08 +0800" data-visited-id="19724">新</div></td>
<td align="left"><a href="<%=request.getContextPath()%>/1075802" class="c9 c9-length" target="_blank" title="阿舞游泳和存钱要两手抓">阿舞游泳和存钱要两手抓</a></td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/19724" class="c5">1</a></td>
<td align="right"><a href="<%=request.getContextPath()%>/posts/19724?latest=2" target="_blank" class="timeline-posted-at" data-timestamp="2013-08-21 17:59:08 +0800">11天以前</a></td>
<td class="my-01" align="left">
<a href="<%=request.getContextPath()%>/projects/320283/posts" target="_blank" title="&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆">"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆</a>
</td>    
</tr>

<tr>
<td align="center" width="30">
<div class="comment-icon">[顶]</div>
</td><td width="330"><a href="<%=request.getContextPath()%>/posts/19304" class="c5 c5-length" title="支持！" target="_blank">支持！</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-07-12 11:37:28 +0800" data-visited-id="19304">新</div></td>
<td align="left"><a href="<%=request.getContextPath()%>/1114536" class="c9 c9-length" target="_blank" title="爱宝贝">爱宝贝</a></td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/19304" class="c5">1</a></td>
<td align="right"><a href="<%=request.getContextPath()%>/posts/19304?latest=2" target="_blank" class="timeline-posted-at" data-timestamp="2013-07-12 11:37:28 +0800">1月以前</a></td>
<td class="my-01" align="left">
<a href="<%=request.getContextPath()%>/projects/320283/posts" target="_blank" title="&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆">"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆</a>
</td>    
</tr>

<tr>
<td align="center" width="30">
<div class="comment-icon">[告]</div>
</td><td width="330"><a href="<%=request.getContextPath()%>/posts/19269" class="c5 c5-length" title="内蒙拍摄地之一清水河概况  " target="_blank">内蒙拍摄地之一清水河概况  </a><div style="display: none;" class="list-icon-new" data-visited-time="2013-07-09 10:32:27 +0800" data-visited-id="19269">新</div></td>
<td align="left"><a href="<%=request.getContextPath()%>/1021804" class="c9 c9-length" target="_blank" title="立夏">立夏</a></td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/19269" class="c5">0</a></td>
<td align="right"><a href="<%=request.getContextPath()%>/posts/19269?latest=2" target="_blank" class="timeline-posted-at" data-timestamp="2013-07-09 10:32:27 +0800">1月以前</a></td>
<td class="my-01" align="left">
<a href="<%=request.getContextPath()%>/projects/320283/posts" target="_blank" title="&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆">"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆</a>
</td>    
</tr>

<tr>
<td align="center" width="30">
<div class="comment-icon">[顶]</div>
</td><td width="330"><a href="<%=request.getContextPath()%>/posts/18873" class="c5 c5-length" title="支持支持，支持支持" target="_blank">支持支持，支持支持</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-07-08 16:30:41 +0800" data-visited-id="18873">新</div></td>
<td align="left"><a href="<%=request.getContextPath()%>/1110132" class="c9 c9-length" target="_blank" title="Midwinter1001">Midwinter1001</a></td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/18873" class="c5">3</a></td>
<td align="right"><a href="<%=request.getContextPath()%>/posts/18873?latest=2" target="_blank" class="timeline-posted-at" data-timestamp="2013-07-08 16:30:41 +0800">1月以前</a></td>
<td class="my-01" align="left">
<a href="<%=request.getContextPath()%>/projects/320283/posts" target="_blank" title="&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆">"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆</a>
</td>    
</tr>

<tr>
<td align="center" width="30">
<div class="comment-icon">[顶]</div>
</td><td width="330"><a href="<%=request.getContextPath()%>/posts/18668" class="c5 c5-length" title="加油。你做的是我曾经想做却一直未做的。" target="_blank">加油。你做的是我曾经想做却一直未做的。</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-06-28 16:55:14 +0800" data-visited-id="18668">新</div></td>
<td align="left"><a href="<%=request.getContextPath()%>/1007198" class="c9 c9-length" target="_blank" title="谈天天">谈天天</a></td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/18668" class="c5">1</a></td>
<td align="right"><a href="<%=request.getContextPath()%>/posts/18668?latest=2" target="_blank" class="timeline-posted-at" data-timestamp="2013-06-28 16:55:14 +0800">2月以前</a></td>
<td class="my-01" align="left">
<a href="<%=request.getContextPath()%>/projects/320283/posts" target="_blank" title="&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆">"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆</a>
</td>    
</tr>

<tr>
<td align="center" width="30">
<div class="comment-icon">[顶]</div>
</td><td width="330"><a href="<%=request.getContextPath()%>/posts/18629" class="c5 c5-length" title="支持" target="_blank">支持</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-06-27 22:30:41 +0800" data-visited-id="18629">新</div></td>
<td align="left"><a href="<%=request.getContextPath()%>/1110739" class="c9 c9-length" target="_blank" title="三叉神经 精益求精 张龙">三叉神经 精益求精 张龙</a></td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/18629" class="c5">1</a></td>
<td align="right"><a href="<%=request.getContextPath()%>/posts/18629?latest=2" target="_blank" class="timeline-posted-at" data-timestamp="2013-06-27 22:30:41 +0800">2月以前</a></td>
<td class="my-01" align="left">
<a href="<%=request.getContextPath()%>/projects/320283/posts" target="_blank" title="&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆">"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆</a>
</td>    
</tr>

<tr>
<td align="center" width="30">
<div class="comment-icon">[顶]</div>
</td><td width="330"><a href="<%=request.getContextPath()%>/posts/18575" class="c5 c5-length" title="加油" target="_blank">加油</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-06-27 21:22:30 +0800" data-visited-id="18575">新</div></td>
<td align="left"><a href="<%=request.getContextPath()%>/1110231" class="c9 c9-length" target="_blank" title="焦广平">焦广平</a></td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/18575" class="c5">2</a></td>
<td align="right"><a href="<%=request.getContextPath()%>/posts/18575?latest=2" target="_blank" class="timeline-posted-at" data-timestamp="2013-06-27 21:22:30 +0800">2月以前</a></td>
<td class="my-01" align="left">
<a href="<%=request.getContextPath()%>/projects/320283/posts" target="_blank" title="&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆">"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆</a>
</td>    
</tr>

<tr>
<td align="center" width="30">
<div class="comment-icon">[顶]</div>
</td><td width="330"><a href="<%=request.getContextPath()%>/posts/18562" class="c5 c5-length" title="这是一件纯粹的事情，需要立夏的坚持和我们的支持。" target="_blank">这是一件纯粹的事情，需要立夏的坚持和我们的支持。</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-06-27 17:40:04 +0800" data-visited-id="18562">新</div></td>
<td align="left"><a href="<%=request.getContextPath()%>/1110091" class="c9 c9-length" target="_blank" title="金桂楠">金桂楠</a></td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/18562" class="c5">1</a></td>
<td align="right"><a href="<%=request.getContextPath()%>/posts/18562?latest=2" target="_blank" class="timeline-posted-at" data-timestamp="2013-06-27 17:40:04 +0800">2月以前</a></td>
<td class="my-01" align="left">
<a href="<%=request.getContextPath()%>/projects/320283/posts" target="_blank" title="&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆">"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆</a>
</td>    
</tr>

<tr>
<td align="center" width="30">
<div class="comment-icon">[顶]</div>
</td><td width="330"><a href="<%=request.getContextPath()%>/posts/18584" class="c5 c5-length" title="温暖在人间" target="_blank">温暖在人间</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-06-27 17:38:28 +0800" data-visited-id="18584">新</div></td>
<td align="left"><a href="<%=request.getContextPath()%>/1110298" class="c9 c9-length" target="_blank" title="指天踏地夜如何">指天踏地夜如何</a></td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/18584" class="c5">1</a></td>
<td align="right"><a href="<%=request.getContextPath()%>/posts/18584?latest=2" target="_blank" class="timeline-posted-at" data-timestamp="2013-06-27 17:38:28 +0800">2月以前</a></td>
<td class="my-01" align="left">
<a href="<%=request.getContextPath()%>/projects/320283/posts" target="_blank" title="&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆">"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆</a>
</td>    
</tr>

<tr>
<td align="center" width="30">
<div class="comment-icon">[问]</div>
</td><td width="330"><a href="<%=request.getContextPath()%>/posts/18578" class="c5 c5-length" title="项目预计实施时间的几时?" target="_blank">项目预计实施时间的几时?</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-06-27 17:13:46 +0800" data-visited-id="18578">新</div></td>
<td align="left"><a href="<%=request.getContextPath()%>/1047895" class="c9 c9-length" target="_blank" title="_DON">_DON</a></td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/18578" class="c5">1</a></td>
<td align="right"><a href="<%=request.getContextPath()%>/posts/18578?latest=2" target="_blank" class="timeline-posted-at" data-timestamp="2013-06-27 17:13:46 +0800">2月以前</a></td>
<td class="my-01" align="left">
<a href="<%=request.getContextPath()%>/projects/320283/posts" target="_blank" title="&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆">"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆</a>
</td>    
</tr>

<tr>
<td align="center" width="30">
<div class="comment-icon">[告]</div>
</td><td width="330"><a href="<%=request.getContextPath()%>/posts/18538" class="c5 c5-length" title="#&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆#上线了！" target="_blank">#"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆#上线了！</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-06-26 11:37:18 +0800" data-visited-id="18538">新</div></td>
<td align="left"><a href="<%=request.getContextPath()%>/1013487" class="c9 c9-length" target="_blank" title="众拍网客服">众拍网客服</a></td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/18538" class="c5">0</a></td>
<td align="right"><a href="<%=request.getContextPath()%>/posts/18538?latest=2" target="_blank" class="timeline-posted-at" data-timestamp="2013-06-26 11:37:18 +0800">2月以前</a></td>
<td class="my-01" align="left">
<a href="<%=request.getContextPath()%>/projects/320283/posts" target="_blank" title="&quot;我们在一起&quot;  第二期·内蒙  用摄影撷取一朵温暖的记忆">"我们在一起"  第二期·内蒙  用摄影撷取一朵温暖的记忆</a>
</td>    
</tr>

</tbody></table>
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
<script src="<%=request.getContextPath()%>/demohour-index_files/posts-cee7846e0147c9be9a0b484efae2fd79.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$.ui_notification.ready({url:'http://nf-2.demohour.com',data:{"new_comments_count":0,"new_messages_count":0,"new_notifications_count":0,"new_posts_count":0}});$.ui_core.paginate("#project-list-more"),$.ui_core.visit({until:"2013-09-01 17:43:40 +0800"}),$("a").on("click",function(e){$(e.target).parent().find("div.list-icon-new").hide()}),$("body").on("click","a.ui-popup-delete",function(e){$("#ui_popup_delete").find("div.ui-popup-content").css("top",$(window).height()/2-120),$("#ui_popup_delete").find("p.ui-popup-text").html($(e.target).attr("title")),$("#ui_popup_delete").find("a.ui-popup-url").attr("href",$(e.target).attr("href")),$("#ui_popup_delete").toggle(),e.preventDefault()}),$("body").on("click","a.ui-popup-message",function(e){$("#ui_popup_message").find("div.ui-popup-content").css("top",$(window).height()/2-150),$("#ui_popup_message").find("form").attr("action",$(e.target).attr("href")),$("#ui_popup_message").find("span.ui-popup-title").html($(e.target).attr("title")),$("#ui_popup_message").toggle(),$("#ui_popup_message").find("textarea").val($(e.target).attr("data-message-attachment")),$("#ui_popup_message").find("textarea").focus(),$(e.target).attr("href").indexOf("?recipient_id=")>0?($("#ui_popup_message_url").show(),$("#ui_popup_message_email").hide(),$("#ui_popup_message_url").find("a").attr("href",$(e.target).attr("href").replace("?recipient_id=","/"))):($("#ui_popup_message_url").hide(),$("#ui_popup_message_email").show()),e.preventDefault()});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-09-01 21:43:40 +0800'});});
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