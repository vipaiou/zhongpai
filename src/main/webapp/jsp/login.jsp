<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../include/header.jsp" %>
<%--  <div class="content">
 		
     <form action="<s:url value="/j_spring_security_check"/>" method="post">
       <ul>
          <li><input id="user" name="j_username" type="text" value='<c:if test="${flag ==1}"><c:out escapeXml="false" value="${sessionScope.username}"/></c:if>' class="text" onfocus="this.className='textHover';this.onmouseout='';" onblur="this.className='text';this.onmouseout=function(){this.className='text'};" onmousemove="this.className='textHover'" onmouseout="this.className='text'"/></li>
          <li><input id="password" type="password" name="j_password" class="text tip-ele" onfocus="this.className='textHover';this.onmouseout='';" onblur="this.className='text';this.onmouseout=function(){this.className='text'};" onmousemove="this.className='textHover'" onmouseout="this.className='text'"/></li>
          <li class="btWidth"><input type="button" id= "loginBtn" class="btn" value="<s:message code='login.in'/>" ></li>
          <li class="forgotPw"><a href="<s:url value='/user/forgetPwd/username'/>" target="_blank"><s:message code="login.forgot.password"/></a></li>
          <li class="loginPw" >
          <input name="_spring_security_remember_me" type="checkbox" class="checkbox" id="checkbox" /><s:message code="login.signed"/></li>
       </ul>
  
          <div style="color: #FF7200;height:25px;text-align:left;clear:both;padding-left:5px;" id="msg">&nbsp;${msg}
        </div>
	
     </form>
</div>  --%>
<form accept-charset="UTF-8" action="<s:url value="/j_spring_security_check"/>" id="new_session" method="post">
<div style="margin:0;padding:0;display:inline">
<input name="utf8" value="✓" type="hidden">
<input name="authenticity_token" value="nPLDiZrbtDnUgGCM1nO8dI6jwXh5VgFcNKJDqS11f5A=" type="hidden"></div>
<div class="signuploginbg">
<div id="login" class="signuplogin">
<div class="left">
<ul class="siglog">
<li class="linh2"><span>没有帐号？<a href="<%=request.getContextPath() %>/register?url=<%=request.getContextPath() %>">注册</a></span>登录</li>

<li id="useremail">
<div class="ui-text">
<div class="ui-text-right">

<input id="user_email" name="j_username" value="" autocomplete="off" class="email-icon" placeholder="输入用戶名">
</div>
</div>
</li>

<li id="useremail">
<div class="ui-text">
<div class="ui-text-right">
<input id="user_password" name="j_password" value="" autocomplete="off" placeholder="输入密码" class="password-icon" type="password">
</div>
</div>
<a href="http://www.demohour.com/forgot?email=vipaiou%40gmail.com" class="lostpassword">忘记密码?</a></li>
<!-- <li>
	<div class="ui-checkbox"><label class="ui-checkbox-checked">
		<input name="_spring_security_remember_me" value="0" type="hidden">
		<input value="1" name="_spring_security_remember_me" id="auto_login" class="ui-checkbox" checked="checked" type="checkbox">记住我 (下次自动登录)</label>
	</div>
</li> -->
<li class="loginPw" ><input name="_spring_security_remember_me" type="checkbox" class="checkbox" id="checkbox" /><s:message code="login.signed"/></li>
<li class="denglu"><div class="ui-button-green ui-button"><span><button type="submit">登录</button></span></div></li>
</ul>
<div style="color: #FF7200;height:25px;text-align:left;clear:both;padding-left:5px;" id="msg">&nbsp;${msg}</div>
</div>

<div class="right">
<ul class="siglog">
<li class="linh2">快速通过合作网站帐号登录</li>
<li class="weibodl">
<a href="http://www.demohour.com/session/connect?provider=sina&amp;url=http%3A%2F%2Fwww.demohour.com%2F" title="新浪微博账号登陆" class="ui-sns-sina" rel="nofollow"></a>
<a href="http://www.demohour.com/session/connect?provider=tencent&amp;url=http%3A%2F%2Fwww.demohour.com%2F" title="腾讯微博账号登陆" class="ui-sns-qq" rel="nofollow"></a>
<a href="http://www.demohour.com/session/connect?provider=qzone&amp;url=http%3A%2F%2Fwww.demohour.com%2F" title="QQ空间账号登陆" class="ui-sns-qzone" rel="nofollow"></a>
<a href="http://www.demohour.com/session/connect?provider=douban&amp;url=http%3A%2F%2Fwww.demohour.com%2F" title="豆瓣账号登陆" class="ui-sns-douban" rel="nofollow"></a>
</li>
</ul>
</div>
</div>
</div>
</form>
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
<div id="backtop" class="backtop"><a href="#top"></a></div>
</div>
</div>


<script src="<%=request.getContextPath()%>/demohour-index_files/ga.js" async="" type="text/javascript"></script><script src="<%=request.getContextPath()%>/demohour-index_files/application-ffd788692166a3012f8373c435f5c0c2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/demohour-index_files/sessions-81a8e5c3f0f88ef37b5abe40fcd3aa03.js" type="text/javascript"></script>

<script type="text/javascript">
	 <c:if test="${msg==''}">
 	$("#msg").text("");
 	 var strCookie = document.cookie;
 	    var arrCookie = strCookie.split("; ");
 	    for (var i = 0; i < arrCookie.length; i++) {
 	        var arr = arrCookie[i].split("=");
 	        //console.log(arr[0]+"="+arr[1]);
 	        if ("SPRING_SECURITY_REMEMBER_ME_COOKIE" == arr[0] && arr[1] != 'undifine') {  	
 	            var url="<s:url value='/'/>";
 	            //window.location=url;
 	            break;
 	        }
 	    }
 	   $("#loginBtn").click(function(){
	      				$("form").submit();
		}); 
  	document.onkeydown = function(e){    
  	    var ev = document.all ? window.event : e;  
  	    if(ev.keyCode==13) {// 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
  	        //要处理的事件  
  	        $("#loginBtn").click();
  	    }  
  	  } ; 
 	</c:if>
	</script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$.ui_core.flash("login",[],{delay:2e4});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-08-22 20:59:15 +0800'});});
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