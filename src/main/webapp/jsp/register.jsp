<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../include/header.jsp" %>
<form accept-charset="UTF-8" action="/users?url=http%3A%2F%2Fwww.demohour.com%2F" class="new_user" id="new_user" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="4MEd9ulc0V+2tyLPlgl03mLX77UM0sIfuhfR1MeprGk=" type="hidden"></div>
<div class="signuploginbg">
<div class="signuplogin">
<div class="left">
<ul class="siglog">
<li class="linh2"><span>已是众拍网会员！<a href="<%=request.getContextPath()%>/login">登录</a></span>注册</li>


<li id="useremail">
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" class="email-icon" id="user_email" name="user[email]" placeholder="输入邮箱" size="30" type="text">
</div>
</div>
</li>

<li id="username">
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" class="username-icon" id="user_name" name="user[name]" placeholder="昵称（中英文/数字/下划线/减号）" size="30" type="text">
</div>
</div>
</li>

<li id="userpassword">
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" class="password-icon" id="user_password" name="user[password]" placeholder="密码（至少6个字符）" size="30" type="password">
</div>
</div>
</li>
<li class="service_login"><a href="<%=request.getContextPath()%>/terms_of_service" target="_blank">众拍网服务条款</a></li>
<li class="denglu"><div class="ui-button-green ui-button"><span><button type="submit">同意并注册</button></span></div></li>
</ul></div>
<div class="right">
<ul class="siglog">
<li class="linh2">快速通过合作网站帐号登录</li>
<li class="weibodl">
<a href="<%=request.getContextPath()%>/session/connect?provider=sina&amp;url=http%3A%2F%2Fwww.demohour.com%2F" title="新浪微博账号登陆" class="ui-sns-sina" rel="nofollow"></a>
<a href="<%=request.getContextPath()%>/session/connect?provider=tencent&amp;url=http%3A%2F%2Fwww.demohour.com%2F" title="腾讯微博账号登陆" class="ui-sns-qq" rel="nofollow"></a>
<a href="<%=request.getContextPath()%>/session/connect?provider=qzone&amp;url=http%3A%2F%2Fwww.demohour.com%2F" title="QQ空间账号登陆" class="ui-sns-qzone" rel="nofollow"></a>
<a href="<%=request.getContextPath()%>/session/connect?provider=douban&amp;url=http%3A%2F%2Fwww.demohour.com%2F" title="豆瓣账号登陆" class="ui-sns-douban" rel="nofollow"></a>
</li>
</ul>
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
<div id="backtop" class="backtop"><a href="#top"></a></div>
</div>
</div>


<script src="<%=request.getContextPath()%>/demohour-index_files/ga.js" async="" type="text/javascript"></script><script src="<%=request.getContextPath()%>/demohour-index_files/application-ffd788692166a3012f8373c435f5c0c2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/demohour-index_files/users-81a8e5c3f0f88ef37b5abe40fcd3aa03.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$.ui_core.notice("user",{});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-09-02 21:25:16 +0800'});});
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