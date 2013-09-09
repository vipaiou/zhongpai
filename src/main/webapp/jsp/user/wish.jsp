<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../include/header.jsp" %>
<link href="<s:url value="/demohour-index_files/projects-9afed8175e89fa73647b287e62737440.css" />" media="screen" rel="stylesheet" type="text/css">
<style>
<!--
body {TEXT-ALIGN: center;}
#wrapper { 
	MARGIN-RIGHT: auto; 
	MARGIN-LEFT: auto; 
 	clear: both;
    display: block;
    margin: 20px auto 0;
    overflow: hidden;
    padding-bottom: 40px;
    text-align: left;
    width: 960px;
}
.userpage_left {
    /* padding-right: 40px; */
    width: 660px;
    float: left;
    overflow: hidden;
    /* text-align: center; */
}
.userpage_right{
	float: right;
    width: 300px;
    float: right;
    overflow: hidden;
}
.projectwrap {
    clear: both;
    display: block;
    margin: 0 auto;
    overflow: hidden;
    padding: 0;
    width: 620px;
}

.project-list, .cooperate-list {
    width: 620px;
}
-->
</style>
<div id="wrapper" class="projects-home">
<div class="userpage_left">
<div class="topshow">
<div class="topshowmenu">
<div class="profilewarp">
<img src="<%=request.getContextPath()%>/demohour-index_files/user_avatars-files-000-106-730-106730-large.jpg">
<div class="profile-bio">
<div class="profile-bio-r">
<strong>${user.UserName }</strong>
</div>
<div class="post-private-letter">
	<a href="<%=request.getContextPath()%>/messages?recipient_id=${user.UserId}" class="ui-popup-message" title="私信给 aiou">发私信</a>
   <a class="a-btn-add mr10 j a_show_login" href="#">关注此人</a>
</div>
<p class="jiaru">${user.CreateDate } 加入众拍网</p>
<p><a>新浪微博 </a> <a>qq</a> <a>豆瓣</a> <a>腾讯微博</a> </p>
<p><a>影愿</a>  <a>镜头说</a>  <a>留言板</a>  <a>收藏秀</a></p>
</div>
</div>
<div>
</div>
<div ><div id="new_post" class="projects-posts-add comment-posts-add">
<div class="new-comment-top ui-faq-title-size">我要发新鲜事</div>
<form method="post" data-remote="true" action="<%=request.getContextPath() %>/activity/add" accept-charset="UTF-8"><div style="margin:0;padding:0;display:inline"><input type="hidden" value="✓" name="utf8"><input type="hidden" value="mXPrIAvBs23PnmOfF1PE+JbSsr4Af0qcf0L0VwNiNsQ=" name="authenticity_token"></div>
<input type="hidden" value="0" name="text_post[sns_sync]">
<div class="projects-posts-add-title">
<div class="ui-text">
<div class="ui-text-right">
<!-- <input type="text" placeholder="请输入标题" name="title" id="post_title">	 -->
<!-- <input type="hidden" name="projectid" value="4">
<input type="hidden" name="isfirst" value="1"> -->
</div>
</div>
</div>
<div id="post_content_error"></div>
<div class="projects-posts-add-c comment-new-list-reply-textarea ">

	<div class="ui-textarea">
<div class="ui-textarea-border">
<textarea id="comment_content" name="content" placeholder="我要评论" style="width:554px"></textarea>
</div>
</div>	
</div>
<div class="comment-posts-add-category">
<div class="ui-radio">
<label><input type="radio" value="0" name="category" id="post_attribute_id_2" class="ui-radio radio post_attribute_id">分类1</label>
<label><input type="radio" value="1" name="category" id="post_attribute_id_3" class="ui-radio radio post_attribute_id">分类2</label>
<label><input type="radio" value="2" name="category" id="post_attribute_id_1" class="ui-radio radio post_attribute_id">分类3</label>
</div>
</div>
<div class="projects-posts-add-b">
<div id="post_content_1_error"></div>
<div class="ui-button ui-button-green ui-button-ajax"><span><button type="submit">发送</button></span></div>
</div>
</form></div>
</div>
<ul class="topmenutabs">
<li><a href="<%=request.getContextPath()%>/user/${user.UserId}">全部活动 </a></li>
<li class="selected"><a href="<%=request.getContextPath()%>/user/${user.UserId}/projects/?filter=yingyuan" class="select_projects">影愿<span>0</span></a></li>
<li><a href="<%=request.getContextPath()%>/user/${user.UserId}/projects" class="select_projects">支持的项目 <span>0</span></a></li>
<li><a href="<%=request.getContextPath()%>/user/${user.UserId}/supports" class="select_projects">发起的项目 <span>0</span></a></li>
</ul>
</div></div>
<div class="projectwrap myprojects">
<div class="project-list tabs" id="projects">
	<c:forEach items="${activities }" var="activity">
	
	</c:forEach>
</div>
<style>
.mbtr2 {
    margin-bottom: 20px;
    overflow: hidden;
}.pl2 {
    color: #666666;
    font: 14px/150% Arial,Helvetica,sans-serif;
}#note .note {
	font-family: Arial,Helvetica,sans-serif;
    font-size: 13px;
    line-height: 1.62;
    margin-top: 10px;
    overflow: hidden;
    white-space: pre-wrap;
    width: 100%;
    word-wrap: break-word;
    font-size: 12px;
    line-height: 1.62;
    white-space: pre-wrap;
}.note .ll {
    padding: 0 16px 16px 0;float: left;
}
.content {
	width:auto;
}
.clear {
    clear: both;
    font-size: 0;
    line-height: 0;
}

.clearfix:after {
    clear: both;
    content: ".";
    display: block;
    height: 0;
    visibility: hidden;
}.clearfix:after {
    clear: both;
    content: ".";
    display: block;
    height: 0;
    visibility: hidden;
}
.clearfix:after {
    clear: both;
    content: ".";
    display: block;
    height: 0;
    visibility: hidden;
}
.clearfix:after {
    clear: both;
    content: ".";
    display: block;
    height: 0;
    visibility: hidden;
}.S_txt3 {
    color: #AEAEAE;
}
.S_link1, .S_func1:hover, .SW_fun:hover .S_func1, .SW_fun2:hover .S_func3, .SW_fun2:hover .S_func4 {
    color: #0A8CD2;
}
.WB_handle{
	float: right;
}.ll {
    float: left;
}
#note .title{
    color: #007722;
    font: 15px/150% Arial,Helvetica,sans-serif;
    margin: 0 0 12px;
}
</style>
<div id="note" class=" ">
    <span class="title">
        ${user.UserName} 的影愿 &nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·
            <span class="pl">&nbsp;(<a target="_self" href="http://www.douban.com/people/Pearls/notes">全部</a>) </span>
    </span>
    <div class="content">
        <div class="mbtr2">
	        <div class="note-header pl2">
	        <a class="ll" href="http://www.douban.com/note/300400475/" title="布鲁斯教你批量删除Kindle图书馆的已经推送内容">布鲁斯教你批量删除Kindle图书馆的已经推送内容</a>
	        <br>
	        </div>
        <div class="clear"></div>
        <div id="note_300400475_short" class="note">
	        <div class="ll">
		        <a href="http://www.douban.com/note/300400475/">
		        <img alt="" src="http://img3.douban.com/icon/ul56323439-103.jpg">
		        </a>
	        </div>
        	推送到kindle上的文件都会存放在Kindle Library里，怎么能批量删除Kindle Library里的文件呢？ 最近遇到这个问题了，找到如下方法和大家分享下  可以在安全策略不是那么严格的浏览器(Chrome因为安全原因依旧不可以)下美国主站Amazon.com使用 bookmark 方式也是可以的，把bookmark 【电视遭遇网络：渐进改良，还是彻底革命？】互联网与电视的结合俨然已是今年最大的产业热点。爱奇艺与TCL婚恋前日，康佳也宣布了推出自己的线上品牌KKTV，互联网势力与传统势力的竞争越发激烈，暗战升级，当然，也有合作与融合。这两种势力，究竟会向何种发向发展？让我们期待！......&nbsp; &nbsp; 
        </div>
        <div node-type="feed_list_funcLink" class="WB_func clearfix">
             <div class="WB_handle">
                 <a title="喜欢" action-data="version=mini&amp;qid=heart&amp;mid=3619887354692844&amp;like_src=1" action-type="feed_list_like" href="javascript:void(0);"><em class="W_ico20 icon_praised_b"></em>喜欢(16)</a><i class="S_txt3">|</i>
                 <a action-data="allowForward=1&amp;url=http://weibo.com/1711479641/A8lmnjGP2&amp;mid=3619887354692844&amp;name=北大新媒体&amp;uid=1711479641&amp;domain=looooker" action-type="feed_list_forward" href="javascript:void(0);" suda-data="key=smart_feed&amp;value=repost_by_genius">关注(172)</a><i class="S_txt3">|</i>
                 <a action-type="feed_list_favorite" diss-data="fuid=1711479641" href="javascript:void(0);" suda-data="key=smart_feed&amp;value=fav_by_genius">竞拍出品人</a><i class="S_txt3">|</i>
                 <a action-data="ouid=1711479641&amp;location=home" action-type="feed_list_comment" href="javascript:void(0);" suda-data="key=smart_feed&amp;value=comment_by_genius">评论(30)</a>
             </div>
             <div class="WB_from">
             <a suda-data="key=smart_feed&amp;value=details_feed" node-type="feed_list_item_date" class="S_link2 WB_time" date="1378531861000" title="2013-09-07 13:31" href="/1711479641/A8lmnjGP2" target="_blank"><span class="pl">2013-09-06 14:35:37</span></a>
         	</div>
         </div>
        </div>
        <div class="clear"></div>
           
        <div class="clear"></div>
    <div class="clear"></div>
    </div>
</div>
</div>
</div>
<div class="userpage_right">
<style>
.infobox .bd:after {
    clear: both;
    content: " ";
    display: block;
}
.bd {
    -moz-border-bottom-colors: none;
    -moz-border-left-colors: none;
    -moz-border-right-colors: none;
    -moz-border-top-colors: none;
    background: none repeat scroll 0 0 #FFF6ED;
    border-color: #FAEFE3;
    border-image: none;
    border-style: solid;
    border-width: 0 1px;
    padding: 4px 9px;
    word-wrap: break-word;
} .userface {
    float: left;
    margin: 1px 10px 8px 0;
}.user-info {
    overflow: hidden;color: #666666;
}.pl {
    color: #666666;
    font: 12px/150% Arial,Helvetica,sans-serif;
}.user-opt {
    clear: both;padding: 8px 0;
}
.sep-line {
    border-bottom: 1px solid #F5E9DB;
    clear: both;
    font-size: 0;
    height: 0;
    margin: 5px;
    overflow: hidden;
}.user-intro {
    color: #666666;
    overflow: hidden;
    word-wrap: break-word;
}
.edtext {
    margin: 7px 0 15px;
    width: 100%;
}.pl {
    color: #666666;
    font: 12px/150% Arial,Helvetica,sans-serif;
}
</style>
<div class="bd">
<img alt="" class="userface" width="60" height="60" src="http://img3.douban.com/icon/ul56323439-103.jpg">
<div class="user-info">
<b style="font-size:20px">众投人</b>&nbsp;&nbsp;TA支持过&nbsp;<a href="<%=request.getContextPath()%>/user/${user.UserId}/projects">2个${projectnum }</a>&nbsp;项目<br>
常居:&nbsp;<a href="http://shanghai.douban.com/">上海</a><br>
<div class="pl">
Hexuejun <br> 
2011-11-24加入
</div>
</div>
<div class="user-opt">
   <a class="a-btn-add mr10 j a_show_login" href="#"><img src="" width="10" height="10"/>喜欢&nbsp;34</a>
   <a class="a-btn-add mr10 j a_show_login" href="#">关注&nbsp;34</a>
</div>
<div class="sep-line"></div>
<div class="user-intro">
    <div class="j edtext pl" id="edit_intro">
        <span id="intro_display"><br>相遇即是缘分，感谢并珍惜关注我的每一位友邻，你们都是我的宝石。<br><br><br></span>
        
        <form mothod="post" name="edit_intro" action="/j/people/Hexuejun/edit_intro" style="display: none;">
            <textarea name="intro" style="overflow: hidden;">相遇即是缘分，感谢并珍惜关注我的每一位友邻，你们都是我的宝石。

</textarea><br>
            <input type="submit" value="保存" class="submit" id="intro_submit">
            <input type="button" value="取消" class="cancel" id="intro_cancel">
        <div style="position: absolute; display: none; word-wrap: break-word; font-weight: 400; width: 282px; font-family: Arial; line-height: 15px; font-size: 12px; padding: 3px;">相遇即是缘分，感谢并珍惜关注我的每一位友邻，你们都是我的宝石。<br><br><br>&nbsp;</div></form>

        <span style="display: none;" class="attn" id="intro_error"></span>
    </div>

</div>

</div>
<div class="" style="margin-top:10px">
<img src="http://img3.douban.com/icon/ul56323439-103.jpg" alt="banner" width="100%" height="100"/>
</div>
<style>
.mod:after {
    clear: both;
    content: " ";
    display: block;
}.mod {
    margin-bottom: 30px;width: auto;
}
#db-sites .item {
    margin-bottom: 20px;
}#db-sites .item {
    overflow: hidden;
}#db-sites .item .pic {
    float: left;
    margin-right: 12px;
}#db-sites .item .info {
    color: #999999;
    overflow: hidden;
}
</style>
<div class="mod" style="margin-top:10px">
<div id="db-sites">
    <div class="hd">
    <h2>
        联合出品的电影
            &nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·
            <span class="pl">&nbsp;(
                
                    <a target="_self" href="http://www.douban.com/group/explore">更多</a>
                ) </span>
    </h2>
    </div>
    <div class="bd">
        <div class="content">
            
        <div class="item">
            <div class="pic" width="223px" height="165px;">
                <a href="http://www.douban.com/group/shijie2/">
                    <img width="223" height="165" alt="这世界真2" src="http://img3.douban.com/icon/g248665-3.jpg">
                </a>
            </div>
            <div class="info"style="float: left; width: 100%;">
                <h3><a href="http://www.douban.com/group/shijie2/">电影名称</a></h3>
	            <div style="float: left; width: 100%;">
	               	出品人：影片本身
	            </div>
	            <div style="float: left; width: 100%;">
	               	导演：影片本身
	            </div>
	            <div style="float: left; width: 100%;">
	                	主演：影片本身
	            </div>
            </div>
            <div style="float: left; width: 100%;">
               TA投给了：影片本身
            </div>
            <div style="float: left; width: 100%;">
                	简介简介简介简介简介简介简介简介简介简介简介
            </div>
        </div>
        <div class="item">
            <div class="pic" width="223px" height="165px;">
                <a href="http://www.douban.com/group/shijie2/">
                    <img width="223" height="165" alt="这世界真2" src="http://img3.douban.com/icon/g248665-3.jpg">
                </a>
            </div>
            <div class="info"style="float: left; width: 100%;">
                <h3><a href="http://www.douban.com/group/shijie2/">电影名称</a></h3>
	            <div style="float: left; width: 100%;">
	               	出品人：影片本身
	            </div>
	            <div style="float: left; width: 100%;">
	               	导演：影片本身
	            </div>
	            <div style="float: left; width: 100%;">
	                	主演：影片本身
	            </div>
            </div>
            <div style="float: left; width: 100%;">
               TA投给了：影片本身
            </div>
            <div style="float: left; width: 100%;">
                	简介简介简介简介简介简介简介简介简介简介简介
            </div>
        </div>
        </div>
    </div>
</div>
</div>
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
<script src="<%=request.getContextPath()%>/demohour-index_files/users-81a8e5c3f0f88ef37b5abe40fcd3aa03.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$.ui_notification.ready({url:'http://nf-2.demohour.com',data:{"new_comments_count":0,"new_messages_count":0,"new_notifications_count":0,"new_posts_count":0}});$.ui_core.paginate("#project-list-more"),$("body").on("click","a.ui-popup-delete",function(e){$("#ui_popup_delete").find("div.ui-popup-content").css("top",$(window).height()/2-120),$("#ui_popup_delete").find("p.ui-popup-text").html($(e.target).attr("title")),$("#ui_popup_delete").find("a.ui-popup-url").attr("href",$(e.target).attr("href")),$("#ui_popup_delete").toggle(),e.preventDefault()}),$("body").on("click","a.ui-popup-message",function(e){$("#ui_popup_message").find("div.ui-popup-content").css("top",$(window).height()/2-150),$("#ui_popup_message").find("form").attr("action",$(e.target).attr("href")),$("#ui_popup_message").find("span.ui-popup-title").html($(e.target).attr("title")),$("#ui_popup_message").toggle(),$("#ui_popup_message").find("textarea").val($(e.target).attr("data-message-attachment")),$("#ui_popup_message").find("textarea").focus(),$(e.target).attr("href").indexOf("?recipient_id=")>0?($("#ui_popup_message_url").show(),$("#ui_popup_message_email").hide(),$("#ui_popup_message_url").find("a").attr("href",$(e.target).attr("href").replace("?recipient_id=","/"))):($("#ui_popup_message_url").hide(),$("#ui_popup_message_email").show()),e.preventDefault()});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-09-01 21:16:03 +0800'});});
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