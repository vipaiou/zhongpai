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
<li><a href="<%=request.getContextPath()%>/guideline" class="ui-tab-current" title="项目规范">项目规范</a></li>
<li><a href="<%=request.getContextPath()%>/faq" title="常见问题">常见问题</a></li>
<li><a href="<%=request.getContextPath()%>/terms_of_service" title="服务条款">服务条款</a></li>
<li><a href="<%=request.getContextPath()%>/privacy_policy" title="隐私权政策">隐私权政策</a></li>
<li><a href="<%=request.getContextPath()%>/about" title="团队介绍">团队介绍</a></li>
</ul>
</div>
</div>
<div class="content">
<div class="help-end">
<div class="help-end-960">
<div class="div-indent">
<p>众拍网是中国最大的众筹平台。不论你是农民工、学生，还是白领，不论你从事什么行业，只要你真心想做一件事，需要资金的支持，都可以在众拍网展示你的项目，得到大家的支持!</p>
<p>以下是众拍网发起项目的基本要求，不合要求的项目，将会被拒绝或删除。如果你有疑问，可以通过邮件</p>
<p>联系我们：contact#demohour.com (发送邮件时请把 # 替换为 @)</p>
<p>附注：某些规范会随着时间而更新或者调整，会导致一些旧项目并不能完全符合最新规范。</p>
</div>
<p class="help-end-l-t">项目发起人资格：</p>
<ul>
<li>18周岁以上;</li>
<li>中华人民共和国公民，或能提供长期在中国居住证明的非中华人民共和国公民;</li>
<li>拥有能够在中国地区接收人民币汇款的银行卡或者支付宝、财付通账户;</li>
<li>提供必要的身份认证和资质认证，根据项目内容，有可能包括但不限于：身份证，护照，学历证明等;</li>
<li>其他根据项目发起、执行需求相关的必须条件。</li>
</ul>
<p class="help-end-l-t">项目发布：</p>
<ul>
<li>根据相关法律法规，项目提交后，须经过大众评审和众拍网工作人员审核后才能发布</li>
<li>根据项目的内容，众拍网会要求发起人提供相关材料，证明项目的可行性，以及发起人的执行能力</li>
<li>众拍网对提交筹资审核的项目是否拥有上线资格具有最终决定权（具备筹资上线资格的项目的上线时间由项目发起人自行决定）</li>
<li>众拍网大众评审对提交预热审核的项目具有决定权</li>
<li>项目在众拍网上线期间，不能在中国大陆其他类似的众筹平台同时发布。无论项目是否筹资成功，一经发现将立即下线处理，其项目上线期间所筹得的金额将被立即退回给支持者在众拍网上开立的账户中。</li>
</ul>
<p class="help-end-l-t"><a name="content">项目内容规范（不符合以下内容规范的项目将被退回）：</a></p>
<div class="div-indent">
<p>1. 项目内容框架必须包含“关于我”、“我想要做什么”、“项目的进展和风险”、“为什么需要你的支持”、“我的承诺与回报”等重要板块。</p>
<p>2. 项目内容必须完整、合理、具有可行性；有完整的计划和执行能力，且图片、视频不能借用或盗用非本人/公司拍摄的内容。</p>
<p>3. 项目应该有明确的目标，如制作一张专辑、出一本书或完成一件艺术品。可以完成的，有具体完成时间的才叫“项目”。创立一家公司就不是一种项目。</p>
<p>4. 项目类别必须是如下分类：设计、科技、音乐、影视、漫画、出版、游戏、摄影、创新公益。</p>
<p>5. 项目不得为个人公益项目。个人不得为慈善或某项事业筹资。例如，禁止为红十字会募资，禁止把筹集到的资金或未来利润转用于慈善或某项事业。</p>
<p>6. 项目不得为销售货物的项目。项目必须为有创意、有想法、有设计感的项目，而非网店销售商品之项目。</p>
<p>7. 项目不得为网站类型的项目。由于网站需要长久经营，风险较大。无论是电子商务网站或社交网站的项目都将不被允许上线。</p>
<p>8. 对于开发新硬件或新产品的设计和科技项目，发起人必须在项目页面上展示原型(3D原型或实体模型)和具体执行过相关经验的信息。</p>
<p>9. 项目不得为“资助我”或满足个人物质需求为主的项目(例如，资助我的学费或债务、资助我旅行或度假而创建项目)。</p>
<p>10. 以下类别的项目和内容将不被允许在此发布：</p>
</div>
<ul>
<li>酒相关(同样禁止作为回报)</li>
<li>婴儿用品相关</li>
<li>洗浴和美容产品相关</li>
<li>竞赛(为了获得资助而在项目中允诺提供竞赛报名费和奖金等)</li>
<li>化妆品相关</li>
<li>毒品、类似毒品的物质、吸毒用具、烟等相关</li>
<li>运动与健身产品相关</li>
<li>财政奖励(所有权、利润份额、还款贷款等)</li>
<li>枪支、武器和刀具相关</li>
<li>加热和制冷产品相关</li>
<li>家装产品相关</li>
<li>医疗产品或安全用品相关</li>
<li>多级直销和传销类相关</li>
<li>营养补充剂相关</li>
<li>令人反感的内容(仇恨言论、不适当内容等)</li>
<li>色情内容相关</li>
<li>支持或反对政治党派的项目</li>
<li>推广或美化暴力行为的项目</li>
<li>对奖、彩票和抽奖活动相关</li>
<li>房地产相关</li>
<li>开店相关（如小卖部、饭店、旅馆、俱乐部、农场、客栈等性质）</li>
<li>饮食类相关</li>


</ul>

<p class="help-end-l-t"><a name="pledge">项目回报规范（不符合以下回报规范的项目将被退回）：</a></p>
<div class="div-indent">
<p>1. 项目的回报内容不得是股权、债券、分红、利息形式等。</p>
<p>2. 因平邮寄送会产生很多问题，故回报形式不得是平邮明信片(用快递寄送的套装明信片则不在此限)。</p>
<p>3. 项目不得以不可行、不合理的承诺作为回报。</p>
<p>4. 项目回报必须是项目的衍生品，即不得是与项目无关的回报内容。</p>


</div>

<p class="help-end-l-t"><a name="recommend">项目推荐标准：</a></p>
<div class="div-indent">
<p>举报：不符合<a href="#content">《项目内容规范》</a>或<a href="#pledge">《项目回报规范》</a></p>
<p>合格：符合<a href="#content">《项目内容规范》</a>和<a href="#pledge">《项目回报规范》</a></p>
<p>推荐：合格并且满足下列标准中的任意1-3项（含3项），视为推荐</p>
<p>强烈推荐：合格并且满足下列标准中的任意3项以上，视为强烈推荐</p>
<p>1. 项目内容有逻辑、完整清晰合理、可执行，有完整的计划和能力，以及相关的图片和视频（图片、视频不能借用或盗用非本人/公司拍摄的）</p>
<p>2. 项目发起人有推广渠道、媒体资源、或在公众平台上有一定的影响力</p>
<p>3. 项目内容有故事性、有热点，具备可传播性</p>
<p>4. 项目内容有创意、创新；非山寨、抄袭、跟风，在其他渠道买不到</p>
<p>5. 筹资总金额合理，达成率高，回报金额满足支持者多元化需求，回报内容性价比高，回报发送保证众拍网首发</p>
</div>
</div>
</div>
</div>
<form accept-charset="UTF-8" action="/session" id="new_session" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="4MEd9ulc0V+2tyLPlgl03mLX77UM0sIfuhfR1MeprGk=" type="hidden"></div>
<input id="popup_login_url" name="url" value="<%=request.getContextPath()%>/guideline" type="hidden">
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
<li class="new-user-r"><span>新用户？<a href="<%=request.getContextPath()%>/signup?url=http%3A%2F%2Fwww.demohour.com%2Fguideline">注册</a></span></li>
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
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$("body").on("click","a.ui-popup-login",function(o){$("#ui_popup_login").find("div.ui-popup-content").css("top",$(window).height()/2-200),$("#ui_popup_login").toggle(),$.browser.msie&&$.browser.version<7||("B"==$(o.target).get(0).tagName?$("#popup_login_url").val($(o.target).parent("a").attr("href")):$("#popup_login_url").val($(o.target).attr("href")),o.preventDefault())});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-09-02 21:46:59 +0800'});});
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