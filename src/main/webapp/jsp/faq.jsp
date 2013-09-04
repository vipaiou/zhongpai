<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../include/header.jsp" %>
<div class="ui-tab">
<div class="ui-tab-top">
<h2><a href="<%=request.getContextPath()%>/intro">关于众拍网</a></h2>
</div>
<div class="ui-tab-layout">
<ul class="ui-tab-menu">
<li><a href="<%=request.getContextPath()%>/intro" title="服务介绍">服务介绍</a></li>
<li><a href="<%=request.getContextPath()%>/guideline" title="项目规范">项目规范</a></li>
<li><a href="<%=request.getContextPath()%>/faq" class="ui-tab-current" title="常见问题">常见问题</a></li>
<li><a href="<%=request.getContextPath()%>/terms_of_service" title="服务条款">服务条款</a></li>
<li><a href="<%=request.getContextPath()%>/privacy_policy" title="隐私权政策">隐私权政策</a></li>
<li><a href="<%=request.getContextPath()%>/about" title="团队介绍">团队介绍</a></li>
</ul>
</div>
</div>
<div class="content">
<div class="help-home">
<div class="help-home-top"><img src="<%=request.getContextPath()%>/demohour-index_files/flow-a1f46402a7096b8652e490c8babb3b31.gif" title="项目孵化流程"></div>
<div class="help-home-l">
<a href="<%=request.getContextPath()%>/faq?chapter=site">认识众拍网</a>
<p>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a1">众拍网是什么?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a2">为什么大家会掏钱支持项目?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a3">这是非法集资吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a4">什么样的项目可以在众拍网发起?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a5">什么样的人可以发起项目?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a6">我要如何发起项目?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a7">众拍网是否收费呢</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a8">什么叫项目成功，什么叫项目失败</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a9">什么样的项目比较容易成功</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a10">怎么保证我支持了项目，就能得到回报呢?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a11">我支持的钱什么时候会给项目发起人</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a12">我怎么浏览更多的项目呢?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a13">如果项目发起人拿了钱跑掉了怎么办</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a14">如果项目筹资成功但却无法完成怎么办</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a15">为什么这么好的网站我都没有听说过!</a>
<a href="<%=request.getContextPath()%>/faq?chapter=site#a16">众拍网的含义是什么?</a>
</p>
</div>

<div class="help-home-m">
<a href="<%=request.getContextPath()%>/faq?chapter=backer">我想支持项目</a>
<p>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a1">如何支持项目?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a2">支持项目的具体流程是什么?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a3">如果我支持一个项目，项目发起人会收到哪些信息?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a4">我能进行匿名支持吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a5">如果我支持的项目成功，我能否得到通知?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a6">我有关于项目的问题，想要联系项目发起人，怎么办?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a7">如何更改支持的选项?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a7-1">能否取消支持?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a8">我支持的项目筹资失败了，怎么办?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a9">如何申请取现?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a10">项目发起人是否负责履行项目的承诺?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a11">怎样知道项目发起人的身份是否属实?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a12">为什么我一直没有收到退款?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a13">我支持的项目被迫暂停了，怎么办?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a14">怎么保证我支持了项目，就能得到回报呢?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a15">我没有收到回报。这时应该怎么做?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a16">如何知道项目回报发送的时间?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a17">我可以更改我的账户昵称吗?怎样绑定微博?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a18">我忘记了密码，该如何登陆?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a19">如何更改与我的邮箱地址?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a20">怎样绑定微博及取消绑定?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a21">怎样查看我支持过的项目?怎样查询账户余额?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a21-1">如何退订邮件或调整接收哪些电子邮件?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a22">怎样修改订单?怎样取消支持?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a23">怎样查询寄给我的回报的物流信息?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a24">我可以重复支持一个项目吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=backer#a25">如果项目发起人拿了钱跑掉了怎么办?</a>
</p>
</div>
<div class="help-home-r">
<a href="<%=request.getContextPath()%>/faq?chapter=creator">我想发起项目</a>
<p>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a1">如何发起项目?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a2">谁可以发起项目</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a3">任何项目都可以发起吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a4">在发起项目之前，我应做哪些准备?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a5">发起一个项目需要多长时间?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a6">项目内容需要包含哪些信息?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a7">能否发起一个公益的项目?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a8">我们做电子商务项目的，可以发起众筹吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a9">我就是想交朋友找搭档，可以发起项目吗?必须要筹资吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a10">众拍网可以帮助线下推广吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a11">项目审核流程大致是如何?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a12">项目审核需要多久?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a13">审核中的项目别人可以看到吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a14">如何确保我的构想不会被抄袭?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a15">你们可以帮我修改一下文案吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a16">怎样的项目文案比较有吸引力?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a17">写项目文案的流程是怎样的?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a18">“简要说明”是什么?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a19">怎样插入封面图片?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a20">怎样插入视频?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a21">为什么我上传图片失败?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a22">哪些东西可以作为回报?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a23">怎样设置回报?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a24">回报可以设定名额限制吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a25">预计回报发放时间是什么意思?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a26">回报的邮寄费用怎么设置?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a27">怎么设置我想要筹资的金额和天数?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a28">如何绑定微博?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a29">可以为项目筹集超出目标的资金吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a30">预热天数算在筹资天数之内吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a31">我的项目提交了审核，怎么查询我的项目审核建议?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a32">为什么现在不接受旅行和个人公益项目了?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a33">不是说不上线旅行项目了吗?为什么我能看到首页有旅行类的项目分类?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a34">为什么要我提交预热审核?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a35">怎样提交预热审核?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a36">为什么说我的项目不适合在众拍网发起?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a37">我的项目没有违反《项目规范》但还是被拒绝了。应该怎么办?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a38">什么是目标关注人数?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a39">我的项目已经预热，我什么时候可以开始筹资?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a40">我的项目已经预热，如何修改筹资金额?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a41">支持者可以取消支持吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a42">项目开始筹资后，是否还能修改编辑?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a43">项目筹资成功后，还可以编辑项目内容吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a44">如何删除项目?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a45">请问我的项目如何能够得到推广呢?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a46">我的项目筹资上线了，我能否更改目标筹资金额?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a47">能否一次进行一个以上的项目?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a48">项目内容会在众拍网网站上保留多久?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a49">在回答支持者和网友的问题时，我需注意些什么?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a50">我的项目怎么样才会出现在首页? 出现后又是如何排序的呢?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a51">因为某些因素，我无法按时完成回报怎么办?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a52">项目成功后我需要注册支付宝等网上支付通道账户吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a53">我的项目成功了，如何得到我的筹资金额?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a54">项目如果失败了，我可以重新发起项目吗?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a55">怎么进行发回报的网页操作?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a56">如何查看支持者的信息(邮箱地址、他选择的型号等)，以便发送回报?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a57">我要发回报，可以导出名单吗?哪里可以群发私信?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a58">我的项目被迫暂停了?为什么?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a59">项目被迫暂停会怎样?</a>
<a href="<%=request.getContextPath()%>/faq?chapter=creator#a60">我能否支持自己的项目?</a>
</p>
</div>
</div>
</div>

<form accept-charset="UTF-8" action="/session" id="new_session" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="4MEd9ulc0V+2tyLPlgl03mLX77UM0sIfuhfR1MeprGk=" type="hidden"></div>
<input id="popup_login_url" name="url" value="<%=request.getContextPath()%>/intro" type="hidden">
<div id="ui_popup_login" class="ui-popup popup-login" style="display:none">
<div class="ui-popup-background">
<div class="ui-popup-content ui-draggable">
<table class="ui-popup-table" align="center" border="0" cellpadding="0" cellspacing="0">
<tbody><tr><td class="ui-popup-top-l" width="25"></td>
<td class="ui-popup-top"><span>登录</span></td>
<td class="ui-popup-top-r" width="25"><a href="#close" class="ui-popup-close">关闭</a></td></tr>
<tr><td class="ui-popup-mid-l"></td>
<td class="ui-popup-mid">
<div class="pop-up-login">
<div class="pop-up-login-l">
<ul>
<li class="pop-up-login-l-title">你可以通过合作网站的帐号登录</li>
<li class="weibodl">
<a href="#sina" onclick="window.location.href=('/session/connect?provider=sina&amp;url='+$('#popup_login_url').val())" title="新浪微博账号登陆" class="ui-sns-sina" rel="nofollow"></a>
<a href="#tencent" onclick="window.location.href=('/session/connect?provider=tencent&amp;url='+$('#popup_login_url').val())" title="腾讯微博账号登陆" class="ui-sns-qq" rel="nofollow"></a>
<a href="#qzone" onclick="window.location.href=('/session/connect?provider=qzone&amp;url='+$('#popup_login_url').val())" title="QQ空间账号登陆" class="ui-sns-qzone" rel="nofollow"></a>
<a href="#douban" onclick="window.location.href=('/session/connect?provider=douban&amp;url='+$('#popup_login_url').val())" title="豆瓣账号登陆" class="ui-sns-douban" rel="nofollow"></a>
</li>
<li>登录众拍网<br>
如果你真心想做一件事，全世界都会来帮助你<br>
</li>
<li class="new-user-r"><span>新用户？<a href="<%=request.getContextPath()%>/signup?url=http%3A%2F%2Fwww.demohour.com%2Fintro">注册</a></span></li>
</ul>
</div>
<div class="pop-up-login-r">
<ul>
<li><label for="user_email">电子邮件</label></li>
<li><div class="ui-text"><div class="ui-text-right"><input id="user_email" name="email" value="vipaiou@gmail.com" autocomplete="off" placeholder="输入邮箱" class="username-icon" type="text"></div></div></li>
<li><label for="password">用户密码</label></li>
<li><div class="ui-text"><div class="ui-text-right"><input id="user_password" name="password" value="" placeholder="输入密码" class="password-icon" type="password"></div></div><a href="<%=request.getContextPath()%>/forgot?email=vipaiou%40gmail.com" class="lostpassword">忘记密码?</a></li>
<li><div class="ui-checkbox"><label class="ui-checkbox-checked"><input name="auto_login" value="0" type="hidden"><input value="1" name="auto_login" id="auto_login" class="ui-checkbox" checked="checked" type="checkbox">记住我 (下次自动登录)</label></div></li>
<li class="denglu"><div class="ui-button-green ui-button"><span><button type="submit">登　 录</button></span></div><a title="取消登陆" href="#close" class="button-cancel ui-popup-close">取消登录</a></li>
</ul>
</div>
</div>
</td>
<td class="ui-popup-mid-r"></td></tr>
<tr><td class="ui-popup-bottom-l"></td><td class="ui-popup-bottom"></td><td class="ui-popup-bottom-r"></td></tr>
</tbody></table>
</div> 
</div>
</div>
</form>
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
<p>© 2013北京因为网络科技有限公司　Demohour.com 版权所有<br>电信与信息服务业务经营许可证120183号　京ICP备11032157号　京公网安备110105015321</p>
<div style="display: block;" id="backtop" class="backtop"><a href="#top"></a></div>
</div>
</div>


<script src="<%=request.getContextPath()%>/demohour-index_files/ga.js" async="" type="text/javascript"></script><script src="<%=request.getContextPath()%>/demohour-index_files/application-ffd788692166a3012f8373c435f5c0c2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/demohour-index_files/home-ad57123aded690e93b8c0452f3ab9a41.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$("body").on("click","a.ui-popup-login",function(o){$("#ui_popup_login").find("div.ui-popup-content").css("top",$(window).height()/2-200),$("#ui_popup_login").toggle(),$.browser.msie&&$.browser.version<7||("B"==$(o.target).get(0).tagName?$("#popup_login_url").val($(o.target).parent("a").attr("href")):$("#popup_login_url").val($(o.target).attr("href")),o.preventDefault())});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-09-02 21:39:11 +0800'});});
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