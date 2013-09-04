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
<li><a href="<%=request.getContextPath()%>/faq" title="常见问题">常见问题</a></li>
<li><a href="<%=request.getContextPath()%>/terms_of_service" title="服务条款">服务条款</a></li>
<li><a href="<%=request.getContextPath()%>/privacy_policy" title="隐私权政策">隐私权政策</a></li>
<li><a href="<%=request.getContextPath()%>/about" class="ui-tab-current" title="团队介绍">团队介绍</a></li>
</ul>
</div>
</div>
<div class="content">
<div class="help-end">
<div class="help-end-960">
<p class="help-end-l-t help-end-l-top">核心团队</p>
<div class="tuanduis"><img src="<%=request.getContextPath()%>/demohour-index_files/peter-387a06af39296837d85c6f79e35d10ae.gif">
<div class="tuanduis-r">
<p>张佑　众拍网共同创始人兼CEO　<a target="_blank" href="http://weibo.com/artdesigner">微博</a></p>
<p>出生于台北。体内流动着创作的血液。视一切美的事物为理所当然。</p>
<p>抗拒所谓的大众教育，走出校园，最后在美国找到另一种人生的学习方式。</p>
<p>1997接触网路后从此无法分割。偏执与完美主义，择善固执又喜爱幻想。旧金山中文电台、人间烟火、蛮秀网路电台、意慾蔓延、哇塞中文网、华渊、新
浪网、lycosasia、skysoft愿境网讯、yahoo!奇摩、联络家、奥美广告、戏楼、快拍公园、cnex…都可以找到曾经留下的痕迹。</p>

</div>
</div>

<div class="tuanduis"><img src="<%=request.getContextPath()%>/demohour-index_files/caixiao-8ffc8d05ae8815143e2a5ff5396c776e.gif">
<div class="tuanduis-r">
<p>蔡啸　众拍网共同创始人，负责产品战略与实现　<a target="_blank" href="http://weibo.com/2245430395">微博</a></p>
<p>毕业于北京理工大学计算机系，性格直率，精力旺盛，喜欢玩摇滚</p>
<p>曾经担任新浪搜索引擎软件工程师，创办过互联网广告技术服务公司，之后从事多年面向欧洲市场的独立软件开发服务</p>
<p>丰富的项目管理，产品设计及开发经验</p>
</div></div>
<p class="help-end-l-t">董事长</p>
<div class="tuanduis"><img src="<%=request.getContextPath()%>/demohour-index_files/ben-6f14abb677b556f3edd34b00401a4fb7.gif">
<div class="tuanduis-r">
<p>蒋显斌　董事长　<a target="_blank" href="http://weibo.com/bentsiang">微博</a></p>
<p>在斯坦福求学期间，蒋显斌与朋友共同创办新浪网，从此十余年浸淫于互联网行业。但他一直对设计与文化情有独钟，不曾稍减。2006年，蒋显斌与友人建立华语纪录片制作平台 cnex。2011年，又再度参与建立众拍网。</p>
<p>蒋显斌以工程学士学位毕业于台湾大学。之后就读斯坦福大学，获硕士学位。</p>
</div>
</div>
<p class="help-end-l-t">联系我们</p>
<div class="div-indent"><p>有问题？想在众拍网发起你的项目？<br>
客服邮箱：contact#demohour.com (把#替换为@)<br>
<br></p>
<p>北京众拍网科技有限公司</p>
<p>邮箱：contact#demohour.com (把#替换为@)</p>
<p>电话：+86-010-64012257</p>
<p>地址：中国 北京市朝阳区 广渠东路三号 竞园一号库 东二层</p>
<p>邮编：100022</p>
<p>微博：<a target="_blank" href="http://weibo.com/demohour">http://weibo.com/demohour</a></p>
</div>
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
<p>© 2013北京众拍网科技有限公司　Demohour.com 版权所有<br>电信与信息服务业务经营许可证120183号　京ICP备11032157号　京公网安备110105015321</p>
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