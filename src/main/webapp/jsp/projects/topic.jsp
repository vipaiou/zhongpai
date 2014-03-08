<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@ include file="../../include/header.jsp" %>
<link href="<s:url value="/demohour-index_files/projects-9afed8175e89fa73647b287e62737440.css" />" media="screen" rel="stylesheet" type="text/css">
<div class="ui-tab">
<div class="ui-tab-top">
<h1><a href="<%=request.getContextPath()%>/projects/view/${topic.projectId}">${project.name }</a></h1>
</div>
<div class="ui-tab-layout">
<ul class="ui-tab-menu">
<li><a href="<%=request.getContextPath()%>/projects/view/${topic.projectId}">项目主页</a></li>
<li><a class="ui-tab-current" href="<%=request.getContextPath()%>/projects/${topic.projectId}/topics/">话题<span id="posts_count">${topicnum }</span></a></li>
<li><a href="<%=request.getContextPath()%>/projects/focuses/${topic.projectId}">关注者<span id="favorites_count">${focusnum }</span></a></li>
</ul>
<div class="ui-tab-menu-right">
<div class="ui-button ui-button-blue"><span><a href="#ui_invite_popup" class="ui-popup-open invite_popup" data-popup-height="180" title="帮忙转发">帮忙转发</a></span></div>
<div id="project_322072_favorite1" class="ui-button ui-button-blue ui-button-ajax">
<span>
<c:choose>
	<c:when test="${focused != 0}">
	已关注
	</c:when>
	<c:otherwise>
		<a id="focus" href="<%=request.getContextPath()%>/projects/focus/${project.id }" data-remote="true">+关注此项目</a>
	</c:otherwise>
</c:choose>
</span>
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

<div class="projects-home">
<div id="show_post" class="projects-home-left">
<div class="comment-end-p-n">
<a class="comment-end-return" href="<%=request.getContextPath() %>/projects/${topic.projectId }/topics/">&lt;&lt; 返回列表</a>
<!-- <a class="comment-end-next" href="/posts/23614">下一则</a> -->
</div>  
<div class="timeline">
<div class="timeline-box">
<div class="timeline-box-right">
<div class="timeline-box-title">
<div class="comment-title-avatar">
<a class="timeline-comment-avatar" target="_blank" href="<%=request.getContextPath() %>/user/${topic.userid}"><img src="${imagehost }avatar-medium-${topic.avatar}"></a>
</div>
<div class="comment-title-avatar-r">
<p>
	<c:if test="${topic.type=='0' }">
		[普通话题]
	</c:if>
	<c:if test="${topic.type=='1' }">
		[公告]
	</c:if>
	<c:if test="${topic.type=='2' }">
		[常见问答]
	</c:if>
	<c:if test="${topic.type=='3' }">
		[问题]
	</c:if>
	<c:if test="${topic.type=='4' }">
		[顶]
	</c:if>
	<c:if test="${topic.type=='5' }">
		[倒]
	</c:if>
	 ${topic.title }
</p>
<span><a class="comment-title-avatar-r-n" target="_blank" href="<%=request.getContextPath() %>/user/${topic.userid}">${topic.username }</a>
<a title="私信给  ${topic.username }" class="ui-popup-message post-private-letter" href="/messages?recipient_id=${topic.userid }">发私信</a>
</span>
<div data-timestamp="${fn:substring(topic.createdate,0,19) } +0800" class="timeline-box-title-date">${topic.createdate }</div>
</div>
</div>
<div class="timeline-box-function">
<a data-message-attachment="相关链接：<%=request.getContextPath() %>/projects/${topic.projectId}/topic/${topic.id}" class="ui-popup-message timeline-box-delete" title="举报给 项目客服" href="/messages?recipient_id=1013487">举报</a>
</div>
<div class="timeline-box-explain">
<div class="timeline-box-explain-text">
由 创智工作室 发起的项目「Talking Timer（对讲提示器）」上线了！<br>
此项目正在预热中，暂不筹资，欢迎大家参与讨论。<br><br>
${topic.content }<br>
<span id="project_322072_favorite2">${focusnum }人关注了此项目，
<c:choose>
	<c:when test="${focused != 0}">
	您已关注此项目
	</c:when>
	<c:otherwise>
		<a data-remote="true" href="<%=request.getContextPath() %>/focus/${project.id }">立即关注</a> 此项目</span>
	</c:otherwise>
</c:choose>

<br>
</div>
</div>
<%-- <div class="projects-share projects-comment-share">
<span>分享到：</span>
<p>
</p><div id="ckepop">
<a class="jiathis_button_tsina" title="分享到新浪微博"><span class="jiathis_txt jtico jtico_tsina"></span></a>
<a class="jiathis_button_tqq" title="分享到腾讯微博"><span class="jiathis_txt jtico jtico_tqq"></span></a>
<a class="jiathis_button_qzone" title="分享到QQ空间"><span class="jiathis_txt jtico jtico_qzone"></span></a>
<a class="jiathis_button_douban" title="分享到豆瓣"><span class="jiathis_txt jtico jtico_douban"></span></a>
<a class="jiathis_button_renren" title="分享到人人网"><span class="jiathis_txt jtico jtico_renren"></span></a>
<a target="_blank" class="jiathis jiathis_txt jiathis_separator jtico jtico_jiathis" href="http://www.jiathis.com/share" style="">更多</a>
<a class="jiathis_counter_style"><span class="jiathis_button_expanded jiathis_counter jiathis_bubble_style" id="jiathis_counter_52" title="累计分享4次">4</span></a>
</div>
<p></p>
</div> --%>
<div id="post_20518_comment">
<div class="timeline-box-function">
<a class="timeline-box-comment ui-action-comment" href="#">评论(${fn:length(comments)})</a>
</div>
<div class="comment-new-list">
<ul class="comment-new-list-ul">
<c:forEach items="${comments }" var="comment">
	<li id="comment_${comment.id }">
		<a class="comment-new-list-avatar" target="_blank" href="<%=request.getContextPath() %>/user/${comment.userid}">
		<c:if test="${comment.avatar == ''}"><img src="<%=request.getContextPath()%>/demohour-index_files/thumb.png"></c:if>
		<c:if test="${comment.avatar != ''}"><img src="${imagehost }avatar-medium-${comment.avatar}"></c:if>
		</a>
		<div class="comment-new-list-avatar-r">
		<div class="comment-new-list-avatar-r-title">
		<a class="comment-new-list-avatar-r-title-l" target="_blank" href="<%=request.getContextPath() %>/user/${comment.userid}">${comment.username}</a>
		<c:if test="${project.createuser == comment.userid}"><span class="icon-user-f">项目发起人</span></c:if>
		<!-- <div class="icon-sun-s"><a title="支持者勋章：级别1" target="_blank" href="http://www.demohour.com/posts/9138">1</a></div> -->
		<div class="comment-new-list-avatar-r-title-r">
		<div data-timestamp="${fn:substring(comment.createdate,0,19) } +0800" class="comment-new-list-avatar-r-date timeline-commented-at">${fn:substring(comment.createdate,0,19)}</div>
		</div>
		</div>
		<div class="comment-new-list-text">
		<c:if test="${comment.replyid > 0 }">
		<div class="comment-new-list-text-reply">
		<a class="comment-new-list-text-reply-r" target="_blank" href="<%=request.getContextPath() %>/user/${comment.replyuserid}">${comment.replyusername}</a>
		<p>${comment.reply}</p></div>
		</c:if>
		${comment.content }
		</div>
		<div class="comment-reply">
		<div class="comment-reply-delete">
		<a title="回复${comment.username }" rel="nofollow" class="ui-action-reply timeline-comment-reply timeline-comment-delete" href="#post_new_comment" onclick="reply('${comment.id }','${comment.userid}','${comment.username}')">回复</a>
		</div>
		</div>
		</div>
	</li>
</c:forEach>
</ul>

</div>
<br>
<div class="comment-new-list-reply-textarea" id="post_new_comment">
<form method="post" data-remote="true" action="<%=request.getContextPath() %>/topic/addcomment?pid=${topic.id }" accept-charset="UTF-8" id="commentform">
<div style="margin:0;padding:0;display:inline"><input type="hidden" value="✓" name="utf8">
<input type="hidden" value="aj5z6znYr5g0W7t0XTZlds9vWsFZ3Rq0ORolNzN07mU=" name="authenticity_token"></div>
<input type="hidden" name="replyid" id="replyid" value="0">
<input type="hidden" name="commentuserid" id="commentuserid" value="0">
<input type="hidden" name="projectid" id="projectid" value="${project.id }">
<div class="ui-textarea">
<div class="ui-textarea-border">
<textarea placeholder="回复本话题" name="content" id="comment_content"></textarea>
</div>
</div>
<div class="projects-posts-add-b">
<div id="post_20518_comment_content_error"></div>
<div class="ui-button ui-button-green ui-button-ajax"><span><button type="button" onclick="resetreply(); ">重置</button></span></div>
<div class="ui-button ui-button-green ui-button-ajax"><span><button type="submit">发送</button></span></div>
</div>
</form></div>



</div>
</div>
</div>

</div>
</div>
<div class="projects-home-right">
<table width="100%" cellspacing="0" cellpadding="0" border="0" class="new-comment-list">
<tbody><tr class="new-comment-t">
<td width="310" valign="top" align="left" colspan="2">话题列表</td>
<td width="50" align="right">回应</td>
</tr>

<c:forEach items="${topics}" var="topic1" varStatus="s">
<c:if test="${topic.id == topic1.id }">
<tr class="new-comment-on">
</c:if> 
<c:if test="${topic.id != topic1.id }">
<tr class="">
</c:if> 
<td width="30" align="center">
	<c:if test="${topic1.type=='0' }">
		[普]
	</c:if>
	<c:if test="${topic1.type=='1' }">
		[告]
	</c:if>
	<c:if test="${topic1.type=='2' }">
		[常]
	</c:if>
	<c:if test="${topic1.type=='3' }">
		[问]
	</c:if>
	<c:if test="${topic1.type=='4' }">
		[顶]
	</c:if>
	<c:if test="${topic.type=='5' }">
		[倒]
	</c:if>
</td>
<td width="260"><a title="${topic1.title }" class="c5 c5-length" href="<%=request.getContextPath() %>/projects/${topic1.projectId }/topic/${topic1.id}">${topic1.title }</a><div data-visited-id="${topic1.id }" data-visited-time="${topic1.createdate } +0800" class="list-icon-new" style="display: none;">新</div></td>
<td width="50" align="right"><span class="c5-length-r">${topic1.commentnum }</span></td>    
</tr>
</c:forEach>
</tbody></table>

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
            $('.new-comment-list').addClass('layer-message-fixed');
        } else {
            $('.new-comment-list').removeClass('layer-message-fixed');
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
/*     function() {
        var e = document.createElement("script");
        e.type = "text/javascript",
        e.async = !0,
        e.src = ("https:" == document.location.protocol ? "https://": "http://") + "v2.jiathis.com/code/jia.js";
        var t = document.getElementsByTagName("script")[0];
        t.parentNode.insertBefore(e, t)
    } (), */
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
/*     $("#new_post").find("form").on('ajax:success', function(data) {
        alert(data);
    }), */
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
        //now: '2013-08-18 00:59:49 +0800'
    });
    $("#commentform").on('ajax:success', function(data) {
    	//alert(data);
    	window.location.href="<%=request.getContextPath() %>/projects/${topic.projectId}/topic/${topic.id}";
    });
});
function reply(commentid, commentuserid, commentusername){
	if(commentuserid != $("#commentuserid").val() ){
		$("#comment_content").val("");
	}
	$("#commentuserid").val(commentuserid);
	$("#replyid").val(commentid);
	$("#comment_content").attr("placeholder","回复 " + commentusername);
}
function resetreply(){
	$("#replyid").val(0);
	$("#comment_content").attr("placeholder","回复本话题");
	$("#comment_content").val("");
}
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-23451409-1']);
_gaq.push(['_trackPageview']);
/* (function() {
var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})(); */
//]]>
</script>
<div style="position: fixed; left: 0px; top: 0px; width: 0px; height: 0px;" id="edui_fixedlayer"><div style="display: none;" id="edui9" class="edui-dialog edui-for-link"><div class="edui-dialog-wrap"><div id="edui9_body" class="edui-dialog-body"><div class="edui-dialog-shadow"></div><div id="edui9_titlebar" class="edui-dialog-titlebar"><div class="edui-dialog-draghandle" onmousedown='$EDITORUI["edui9"]._onTitlebarMouseDown(event, this);'><span class="edui-dialog-caption">超链接</span></div><div id="edui12" class="edui-box edui-button edui-dialog-closebutton"><div id="edui12_state" onmousedown='$EDITORUI["edui12"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui12"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui12"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui12"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="关闭对话框" id="edui12_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui12"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label"></div></div></div></div></div></div><div id="edui9_content" class="edui-dialog-content"></div><div class="edui-dialog-foot"><div id="edui9_buttons" class="edui-dialog-buttons"><div id="edui13" class="edui-box edui-button edui-okbutton"><div id="edui13_state" onmousedown='$EDITORUI["edui13"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui13"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui13"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui13"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui13_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui13"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">确认</div></div></div></div></div><div id="edui14" class="edui-box edui-button edui-cancelbutton"><div id="edui14_state" onmousedown='$EDITORUI["edui14"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui14"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui14"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui14"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui14_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui14"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">取消</div></div></div></div></div></div></div></div></div></div><div style="display: none;" id="edui10" class="edui-mask  edui-dialog-modalmask" onmousedown='return $EDITORUI["edui10"]._onMouseDown(event, this);'></div><div style="display: none;" id="edui11" class="edui-mask  edui-dialog-dragmask" onmousedown='return $EDITORUI["edui11"]._onMouseDown(event, this);'></div><div style="display: none;" id="edui15" class="edui-dialog edui-for-insertvideo"><div class="edui-dialog-wrap"><div id="edui15_body" class="edui-dialog-body"><div class="edui-dialog-shadow"></div><div id="edui15_titlebar" class="edui-dialog-titlebar"><div class="edui-dialog-draghandle" onmousedown='$EDITORUI["edui15"]._onTitlebarMouseDown(event, this);'><span class="edui-dialog-caption">视频</span></div><div id="edui16" class="edui-box edui-button edui-dialog-closebutton"><div id="edui16_state" onmousedown='$EDITORUI["edui16"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui16"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui16"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui16"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="关闭对话框" id="edui16_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui16"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label"></div></div></div></div></div></div><div id="edui15_content" class="edui-dialog-content"></div><div class="edui-dialog-foot"><div id="edui15_buttons" class="edui-dialog-buttons"><div id="edui17" class="edui-box edui-button edui-okbutton"><div id="edui17_state" onmousedown='$EDITORUI["edui17"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui17"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui17"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui17"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui17_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui17"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">确认</div></div></div></div></div><div id="edui18" class="edui-box edui-button edui-cancelbutton"><div id="edui18_state" onmousedown='$EDITORUI["edui18"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui18"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui18"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui18"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui18_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui18"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">取消</div></div></div></div></div></div></div></div></div></div><div style="display: none;" id="edui19" class="edui-popup  edui-bubble"> <div id="edui19_body" class="edui-popup-body"> <iframe style="position:absolute;z-index:-1;left:0;top:0;background-color: white;" src="javascript:" frameborder="0" height="100%" width="100%"></iframe> <div class="edui-shadow"></div> <div id="edui19_content" class="edui-popup-content">  </div> </div></div></div></body></html>