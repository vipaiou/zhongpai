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
<li><a href="<%=request.getContextPath()%>/privacy_policy" class="ui-tab-current" title="隐私权政策">隐私权政策</a></li>
<li><a href="<%=request.getContextPath()%>/about" title="团队介绍">团队介绍</a></li>
</ul>
</div>
</div>
<div class="content">
<div class="help-end">
<div class="help-end-960">
<p class="help-end-l-t help-end-l-top">一、隐私权政策适用范围</p>
<p>包括众拍网如何收集、处理、保护：</p>
<p>(1)用户在登录本网站和服务器时留下的个人身份信息;</p>
<p>(2)用户通过本网站和服务器与其他用户或非用户之间传送的各种资讯;以及</p>
<p>(3)众拍网与商业伙伴共享的其他用户或非用户的各种信息。</p>

<p class="help-end-l-t">二、信息和资讯收集和使用</p>
<p>你提供的信息和资讯</p>
<p>在你登记注册众拍网帐户，或使用该帐户，或参加其他众拍网及与之相关需要注册的服务或推广活动时，我们会要求你提供个人信息(包括但不限于你的
电子邮件地址、帐户密码以及昵称等)。这些信息会以加密方式保存在安全的服务器上。我们会将从你的帐户下采集的个人信息和资讯与其他从众拍网服务中或从
第三方获得的信息和资讯进行整合，以便向你提供更好的用户体验和改善我们的服务质量。在某些服务中，我们会给予提示，由你亲自决定是否参与上述信息和资讯
的整合。</p><br>

<p>饼干(cookie)</p>
<p>当你访问众拍网时，我们会向你的电脑发送一个或多个饼干(cookie) - 包含有一串字符的小文件 - 
它能够对你的浏览器进行辨识。我们通过饼干技术来记录用户的使用偏好和习惯并跟踪用户倾向(诸如用户常用的搜索方式等)，以具有针对性的改善我们的服务质
量。大多数浏览器都能在默认设置的状态下接受cookie，但是你也可以重新设置浏览器来拒绝所有cookie，或者让浏览器在是否接受cookie时进
行提示。需要注意的是，如果你将浏览器设置为拒绝接受cookie，则一些众拍网的特色功能或服务可能会无法正常运行。我们允许那些在众拍网网页上发
布广告的公司在用户电脑上设定或取用Cookie。</p><br>

<p>日志资讯</p>
<p>当你使用众拍网的服务时，我们的主机会自动记录你的浏览器在访问网站时所发送的信息和资讯。主机日志资讯包括但不限于你的网路请求、IP地址、浏览器类型、浏览器使用的语言、请求的日期和时间，以及一个或多个可以对你的浏览器进行辨识的cookie。</p><br>

<p>用户交流</p>
<p>当你与众拍网通过电子邮件或其他方式进行交流时，我们可能会记录这些交流内容用以处理你的问题以及改善我们的服务。</p>
<p>众拍网仅对本隐私权政策和/或具体服务的隐私声明中允许的目的而对用户的个人信息和资讯进行处理。除上述已列明部分外，这些目的还包括：向用户提
供产品或服务，包括列明定制的内容和广告;审计、调研和分析，以维持、保护和改善众拍网的服务;确保网站的技术运作;开发新服务;以及其他众拍网运营
所需要的目的。</p>

<p class="help-end-l-t">三、资讯公开与共享</p>
<p>众拍网不会将你的个人信息和资讯故意透露、出租或出售给任何第三方。但以下情况除外：</p>
<p>(1)用户本人同意与第三方共享信息和资讯;</p>
<p>(2)只有透露用户的个人信息和资讯，才能提供用户所要求的某种产品和服务;</p>
<p>(3)应代表众拍网提供产品或服务的主体的要求提供(除非我们另行通知，否则该等主体无权将相关用户个人信息和资讯用于提供产品和服务之外的其他用途)：根据法律法规<br>
　或行政命令的要求提供;因外部审计需要而提供;用户违反了众拍网服务条款或任何其他产品及服务的使用规定;经众拍网评估，用户的帐户存在风险，需要加以保护。</p>

<p class="help-end-l-t">四、编辑和删除个人帐户资料的权限</p>
<p>你有权在任何时候编辑你在众拍网的帐户信息和资讯，你也可以填写相关申请表格，要求删除个人帐户，但是你无条件同意在你的帐户删除后，该帐户内及与该帐户相关的信息和资讯仍然保留在众拍网档案记录中，除上述第三条规定的情况外，我们将为你保密。</p>

<p class="help-end-l-t">五、安全保障</p>
<p>你的众拍网帐户具有密码保护功能，以确保你的隐私及信息和资讯安全。</p>

<p class="help-end-l-t">六、隐私权政策的修订</p>
<p>众拍网会不时对隐私权政策进行修改。如有修改，我们会在修改后及时公告相关修改内容及新规定，以便你知悉和使用。</p>

<p class="help-end-l-t">七、问题与建议</p>
<p>如果你有任何问题和建议，请随时通知我们。</p>

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