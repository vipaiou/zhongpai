<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../include/header.jsp" %>
<div class="ui-tab">
<div class="categories-top">
<%-- <a href="<%=request.getContextPath()%>/projects/discover/0_0_0_0">浏览项目</a>
<span>/</span>
推荐项目 --%>
浏览项目
</div>
</div>
<div class="ui-categories">
<div class="ui-categories-l">
<div class="ui-categories-icon-1">属性：</div>
<div class="ui-categories-l-line"></div>
<div class="ui-categories-icon-1">分类：</div>
<div class="ui-categories-l-line"></div>
<div class="ui-categories-icon-1" style="height:93px">地区：</div>
<div class="ui-categories-l-line"></div>
<div class="ui-categories-icon-2">排序：</div>
</div>
<div class="ui-categories-r">
<a href="<%=request.getContextPath()%>/projects/discover/0_${c2 }_${c3 }_${c4 }" id="attribute_0">所有项目</a>
<a class="ui-categories-current" href="<%=request.getContextPath()%>/projects/discover/1_${c2 }_${c3 }_${c4 }" id="attribute_1">推荐项目</a>
<a href="<%=request.getContextPath()%>/projects/discover/2_${c2 }_${c3 }_${c4 }" id="attribute_2">经典项目</a>
<a href="<%=request.getContextPath()%>/projects/discover/3_${c2 }_${c3 }_${c4 }" id="attribute_3">预热中</a>
<a href="<%=request.getContextPath()%>/projects/discover/4_${c2 }_${c3 }_${c4 }" id="attribute_4">筹资中</a>
<a href="<%=request.getContextPath()%>/projects/discover/5_${c2 }_${c3 }_${c4 }" id="attribute_5">筹资成功</a>
<a href="<%=request.getContextPath()%>/projects/discover/6_${c2 }_${c3 }_${c4 }" id="attribute_${c4 }">筹资失败</a>
<div class="ui-categories-r-line"></div>
<a class="ui-categories-current" href="<%=request.getContextPath()%>/projects/discover/${c1}_0_${c3 }_${c4 }" id="category_0">所有分类</a>
<c:forEach items="${categories }" var="category">
<a href="<%=request.getContextPath() %>/projects/discover/${c1 }_${category.id }_${c3 }_${c4 }" id="category_${category.id }">${category.name }</a>
</c:forEach>
<!-- <a href="http://www.demohour.com/projects/discover/1_927158_0_6" id="category_927158">科技</a>
<a href="http://www.demohour.com/projects/discover/1_927159_0_6" id="category_927159">音乐</a>
<a href="http://www.demohour.com/projects/discover/1_927156_0_6" id="category_927156">影视</a>
<a href="http://www.demohour.com/projects/discover/1_927163_0_6" id="category_927163">食品</a>
<a href="http://www.demohour.com/projects/discover/1_927152_0_6" id="category_927152">动漫</a>
<a href="http://www.demohour.com/projects/discover/1_927161_0_6" id="category_927161">出版</a>
<a href="http://www.demohour.com/projects/discover/1_927164_0_6" id="category_927164">游戏</a>
<a href="http://www.demohour.com/projects/discover/1_927157_0_6" id="category_927157">摄影</a>
<a href="http://www.demohour.com/projects/discover/1_927162_0_6" id="category_927162">其他</a> -->
<div class="ui-categories-r-line"></div>
<a class="ui-categories-current" href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_0_${c4 }" id="location_0">所有地区</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_北京_${c4 }" id="location_北京">北京</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_广东_${c4 }" id="location_广东">广东</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_上海_${c4 }" id="location_上海">上海</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_浙江_${c4 }" id="location_浙江">浙江</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_江苏_${c4 }" id="location_江苏">江苏</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_四川_${c4 }" id="location_四川">四川</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_山东_${c4 }" id="location_山东">山东</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_福建_${c4 }" id="location_福建">福建</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_湖南_${c4 }" id="location_湖南">湖南</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_湖北_${c4 }" id="location_湖北">湖北</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_天津_${c4 }" id="location_天津">天津</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_重庆_${c4 }" id="location_重庆">重庆</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_云南_${c4 }" id="location_云南">云南</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_陕西_${c4 }" id="location_陕西">陕西</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_辽宁_${c4 }" id="location_辽宁">辽宁</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_安徽_${c4 }" id="location_安徽">安徽</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_甘肃_${c4 }" id="location_甘肃">甘肃</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_广西_${c4 }" id="location_广西">广西</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_贵州_${c4 }" id="location_贵州">贵州</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_海南_${c4 }" id="location_海南">海南</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_河北_${c4 }" id="location_河北">河北</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_河北_${c4 }" id="location_河南">河南</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_黑龙江_${c4 }" id="location_黑龙江">黑龙江</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_吉林_${c4 }" id="location_吉林">吉林</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_江西_${c4 }" id="location_江西">江西</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_内蒙古_${c4 }" id="location_内蒙古">内蒙古</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_宁夏_${c4 }" id="location_宁夏">宁夏</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_青海_${c4 }" id="location_青海">青海</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_陕西_${c4 }" id="location_陕西">陕西</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_西藏_${c4 }" id="location_西藏">西藏</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_新疆_${c4 }" id="location_新疆">新疆</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_香港_${c4 }" id="location_香港">香港</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_澳门_${c4 }" id="location_澳门">澳门</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_台湾_${c4 }" id="location_台湾">台湾</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_海外_${c4 }" id="location_海外">海外</a>
<div class="ui-categories-r-line"></div>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_${c3 }_0" id="sort_0">创建时间</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_${c3 }_1" id="sort_1">金额最高</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_${c3 }_2" id="sort_2">话题最多</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_${c3 }_3" id="sort_3">支持最多</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_${c3 }_4" id="sort_4">关注最多</a>
<a href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_${c3 }_5" id="sort_5">评价最高</a>
<a class="ui-categories-current" href="<%=request.getContextPath()%>/projects/discover/${c1}_${c2 }_${c3 }_6" id="sort_6">最新上线</a>
</div>
</div>

<div class="categorieswrap">
<div id="projects" class="project-list">
<c:forEach items="${projects}" var="project" varStatus="s"> 

<ul class="project-one">
<li class="project-thumbnail">
<a href="<%=request.getContextPath()%>/projects/view/${project.id}" title="史上第一部众筹电影《十万个冷笑话》，征求十万个微赞助商" target="_blank"><img src="${ imagehost }project-medium-${project.picture}" />"></a></li>
<li class="project-titile"><a href="<%=request.getContextPath()%>/projects/view/${project.id}" title="史上第一部众筹电影《十万个冷笑话》，征求十万个微赞助商">${project.name }</a></li>
<li class="project-function">
<a href="<%=request.getContextPath()%>/projects/${project.id}/posts" title="此项目有414个话题" class="project-p-on">话题：414</a>
<a href="<%=request.getContextPath()%>/projects/${project.id}/backers" title="5408用户支持此项目" class="project-g-on">支持：5408</a>
<a href="<%=request.getContextPath()%>/projects/discover/4_0_0_0" class="project-g-running">${project.status }筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>135%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>1,354,394</span></strong>已获支持</p>
<p class="widthc"><strong>
9天
</strong>剩余时间</p>
</div>
</li>
</ul>
</c:forEach>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/320816" title="多用途定位器--“找找”让我们不再失去彼此！" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-739-11739-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/320816" title="多用途定位器--“找找”让我们不再失去彼此！">多用途定位器--“找找”让我们不再失去彼此！</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/320816/posts" title="此项目有26个话题" class="project-p-on">话题：26</a>
<a href="http://www.demohour.com/projects/320816/backers" title="0用户支持此项目" class="project-g-on">支持：0</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:0%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>0%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>0</span></strong>已获支持</p>
<p class="widthc"><strong>
59天
</strong>剩余时间</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/317996" title="声控 双向 智能家居系统，真正的全宅智能家居！" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-010-913-10913-medium.gif"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/317996" title="声控 双向 智能家居系统，真正的全宅智能家居！">声控 双向 智能家居系统，真正的全宅智能家居！</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/317996/posts" title="此项目有61个话题" class="project-p-on">话题：61</a>
<a href="http://www.demohour.com/projects/317996/subscribers" title="678用户关注此项目" class="project-g-on">关注：678</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:48%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>48%</strong>热度</p>
<p class="widthb"><strong><span>11153</span></strong>浏览人数</p>
<p class="widthc"><strong>58天</strong>已经预热</p>
</div>
</li>
</ul>

</div>

</div>
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
<li><a href="<%=request.getContextPath()%>/intro" target="_blank" class="h-media-reports-b-r-more">查看完整服务介绍</a></li>
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
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$.ui_notification.ready({url:'http://nf-2.demohour.com',data:{"new_comments_count":0,"new_messages_count":0,"new_notifications_count":0,"new_posts_count":0}});$.ui_core.paginate("#project-list-more"),$("#attribute_1").addClass("ui-categories-current"),$("#category_0").addClass("ui-categories-current"),$("#location_0").addClass("ui-categories-current"),$("#sort_6").addClass("ui-categories-current"),$("#projects_tabs").length>0&&$(window).scroll(function(){$(window).scrollTop()>166?$("#projects_tabs").addClass("scrollon"):$("#projects_tabs").removeClass("scrollon")}),$("body").on("click","a.ui-popup-delete",function(e){$("#ui_popup_delete").find("div.ui-popup-content").css("top",$(window).height()/2-120),$("#ui_popup_delete").find("p.ui-popup-text").html($(e.target).attr("title")),$("#ui_popup_delete").find("a.ui-popup-url").attr("href",$(e.target).attr("href")),$("#ui_popup_delete").toggle(),e.preventDefault()}),$("body").on("click","a.ui-popup-message",function(e){$("#ui_popup_message").find("div.ui-popup-content").css("top",$(window).height()/2-150),$("#ui_popup_message").find("form").attr("action",$(e.target).attr("href")),$("#ui_popup_message").find("span.ui-popup-title").html($(e.target).attr("title")),$("#ui_popup_message").toggle(),$("#ui_popup_message").find("textarea").val($(e.target).attr("data-message-attachment")),$("#ui_popup_message").find("textarea").focus(),$(e.target).attr("href").indexOf("?recipient_id=")>0?($("#ui_popup_message_url").show(),$("#ui_popup_message_email").hide(),$("#ui_popup_message_url").find("a").attr("href",$(e.target).attr("href").replace("?recipient_id=","/"))):($("#ui_popup_message_url").hide(),$("#ui_popup_message_email").show()),e.preventDefault()});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-08-15 23:38:17 +0800'});});
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