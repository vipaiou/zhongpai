<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../include/header.jsp" %>
<link href="<s:url value="/demohour-index_files/projects-9afed8175e89fa73647b287e62737440.css" />" media="screen" rel="stylesheet" type="text/css">
<div class="ui-tab">
<div class="ui-tab-top">
<h2>
<a href="<%=request.getContextPath()%>/projects/view/${project.id}">${project.name}</a>
<span>/</span>
项目管理
</h2>
</div>
<div class="ui-tab-layout">
<ul class="ui-tab-menu">
<li><a href="<%=request.getContextPath()%>/projects/edit/${project.id}">项目说明</a></li>
<li><a class="ui-tab-current" href="<%=request.getContextPath()%>/projects/editreturn/${project.id}">回报设置</a></li>
<li><a href="<%=request.getContextPath()%>/projects/editstatus/${project.id}">项目状态</a></li>
</ul>
<div class="ui-tab-menu-right">
<div class="ui-button ui-button-blue"><span><a href="<%=request.getContextPath()%>/messages?recipient_id=1013487" title="私信给 众拍网客服" class="ui-popup-message">联系客服</a></span></div>
<div class="ui-button ui-button-blue"><span><a href="<%=request.getContextPath()%>/projects/view/${project.id}" target="_blank"><div class="ui-button-icon"><img src="<%=request.getContextPath()%>/demohour-index_files/ui-button-icon1-7be09a1379f6cfe4a4e5fc45fcd64435.gif"></div>预览</a></span></div>
</div></div></div>


<div id="new_project" class="projects-new">
<div class="stepintro "><strong>小提示：</strong>
<ul>
<li>【3个以上的回报】多些选择能提高项目的支持率。</li>
<li>【几十、几百、上千元的支持档位】3个不同的档次的回报，能让你的项目更快成功。</li>
<li>【回报必须低于市价】给第一批支持者最好最优惠的回报，感谢他们的支持。</li>
<li>【回报最好是项目的衍生品】，与项目内容有关的回报更能吸引大家的支持。</li>
</ul>
</div>
<div class="return">
<div class="newreturn">*回报项将会按照金额由低至高排列</div>
<div id="pledge_list" class="returnlist">

<c:forEach items="${returns}" var="return" varStatus="s">
<div id="pledge_${return.id }_show" class="returnlistnormal">
<div class="returnlista"><span class="pledge_amount" title="${return.money }"><b>¥</b>${return.money}</span></div>
<div class="returnlistb"><c:choose>
   <c:when test="${return.limit=='1'}">限人${return.limitnum }</c:when>
   <c:otherwise>无限额</c:otherwise>
</c:choose></div>
<div class="returnlistc"><p>${return.content }</p></div>
<div class="returnlistd"><!-- 将提示支持者填写收货信息 --></div>
<div class="returnliste">
<a href="#pledge_${return.id }" class="ui-action-edit">编辑</a>
<a href="<%=request.getContextPath()%>/projects/${project.id}/remove/${return.id}" class="ui-popup-delete" rel="nofollow" title="确认要删除这项回报？">移除</a>
</div>
</div>
<div id="pledge_${return.id }_edit" style="display:none" class="launchprojects returnborder">
<form accept-charset="UTF-8" action="<s:url value="/projects/${project.id}/editreturn/${return.id }"/>" class="edit_pledge" data-remote="true" id="edit_pledge_${return.id }" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="_method" value="put" type="hidden">
<input name="authenticity_token" value="mXPrIAvBs23PnmOfF1PE+JbSsr4Af0qcf0L0VwNiNsQ=" type="hidden"></div>
<ul class="launchleft">
<li class="shortinput"><label for="pledge_${return.id }_amount">支持金额:</label>
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" class="pledge_amount" id="pledge_${return.id }_amount" name="money" placeholder="" size="30" value="${return.money }" type="text">
<input type="hidden" value="${project.id }" name="projectId"/>
</div>
</div>
<strong class="textprompts-r">元</strong>
<span id="pledge_${return.id }_amount_prompt" class="textprompts" style="display:none">通常50元与10元回报的支持者并没有多少差别，但更能有助于促成你的项目</span>
</li>
<li><label>回报内容:</label>
<div class="ui-textarea">
<div class="ui-textarea-border">
<textarea id="pledge_${return.id }_content" name="content">${return.content }</textarea>
</div>
</div>
</li>
<li class="projects-new-return-li"><label>说明图片:</label>
<div id="pledge_${return.id }_photos_button"></div>
<!--<object id="SWFUpload_1" type="application/x-shockwave-flash" data="<%=request.getContextPath()%>/demohour-index_files/swfupload.swf" class="swfupload" height="32" width="80"><param name="wmode" value="window"><param name="movie" value="/assets/swfupload/swfupload.swf?preventswfcaching=1376729085946"><param name="quality" value="high"><param name="menu" value="false"><param name="allowScriptAccess" value="always"><param name="wmode" value="transparent"><param name="flashvars" value="movieName=SWFUpload_1&amp;uploadURL=%2Fattachments%3Fsign%3D7da18432c35b9b16103c070e043e728fde427564dc042401dfcfca81be4cedfe%26amp%3Btarget_id%3D${return.id }%26amp%3Btype%3Dpledge_photo%26amp%3Buser_id%3D1121568&amp;useQueryString=false&amp;requeueOnError=false&amp;httpSuccess=&amp;assumeSuccessTimeout=0&amp;params=&amp;filePostName=Filedata&amp;fileTypes=*.jpg%3B*.jpeg%3B*.gif%3B*.png&amp;fileTypesDescription=%E5%9B%BE%E7%89%87%E6%96%87%E4%BB%B6&amp;fileSizeLimit=5120&amp;fileUploadLimit=3&amp;fileQueueLimit=0&amp;debugEnabled=false&amp;buttonImageURL=%2Fassets%2Fupload.gif&amp;buttonWidth=80&amp;buttonHeight=32&amp;buttonText=&amp;buttonTextTopPadding=0&amp;buttonTextLeftPadding=0&amp;buttonTextStyle=color%3A%20%23000000%3B%20font-size%3A%2016pt%3B&amp;buttonAction=-110&amp;buttonDisabled=false&amp;buttonCursor=-1"></object>-->
<span class="textprompts">支持jpg、jpeg、png、gif格式，不超过5MB，最多三张</span>
<div id="pledge_${return.id }_photos" class="projects-new-return-img">
<div id="pledge_photo_${return.id }" class="swfupload-preview timeline-add-pic-preview">
<c:set value="${ fn:split(return.images, ',') }" var="imgs" />
<c:forEach items="${imgs }" var="img">
<div><img src="<%=request.getContextPath()%>/demohour-index_files/${img}">
<input id="pledge_photo__id" name="pledge_photo[][id]" value="13563" type="hidden">	
<a href="<%=request.getContextPath()%>/attachments/13563?sign=c58d6041079ba08e091d5ed53ef109f02ef1a94dd0b21dcd1994d0171de51a3d&amp;type=pledge_photo" class="ui-popup-delete" rel="nofollow" title="确认要删除这张图片？">删除</a>
</div>
</c:forEach>
</div>
</div>
</li>
<li class="returntime placeslimited"><label for="pledge_${return.id }_quantity_limit">限定名额:</label>
<div class="ui-radio">
<label class="ui-radio-checked"><input checked="checked" class="ui-radio radio pledge_quantity_limit" id="pledge_${return.id }_quantity_limit_false" name="limit" value="0" type="radio">否</label>
<label><input class="ui-radio radio pledge_quantity_limit" id="pledge_${return.id }_quantity_limit_true" name="limit" value="1" type="radio">是</label>
</div>
<div id="pledge_${return.id }_quantity_limit" class="placeslimitedclear" style="display:none"><label for="pledge_${return.id }_quantity">名额数量:</label>
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" id="pledge_${return.id }_quantity" name="limitnum" placeholder="" size="30" type="text">
</div>
</div><strong>个</strong></div>
</li>
<li class="returntime sendpost"><label>是否邮寄:</label>
<div id="pledge_${return.id }_shipping" class="ui-radio">
<label><input class="ui-radio radio" id="pledge_${return.id }_shipping_0" name="post" value="0" type="radio">否</label>
<label style="width:30px"><input class="ui-radio radio" id="pledge_${return.id }_shipping_2" name="post" value="1" type="radio">快递</label>
<label class="ui-radio-checked" style="width:30px"><input checked="checked" class="ui-radio radio" id="pledge_${return.id }_shipping_1" name="post" value="2" type="radio">平邮</label>
</div>
</li>
<li class="returntime sendpost"><label>是否包邮:</label>
<div id="pledge_${return.id }_shipping_fee" class="ui-radio">
<label><input class="ui-radio radio" id="pledge_${return.id }_shipping_fee_true" name="freepost" value="0" type="radio">否</label>
<label class="ui-radio-checked" style="width:55px"><input checked="checked" class="ui-radio radio" id="pledge_${return.id }_shipping_fee_false" name="freepost" value="1" type="radio">大陆包邮</label>
</div>
</li>
<li class="returntime placeslimited"><label>回报时间:</label>
<div class="placeslimitedclear"><p>项目成功结束后预计</p>
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" id="pledge_${return.id }_shipping_days" name="days" placeholder="" size="30" value="20" type="text">
</div>
</div><strong>天</strong></div>
</li>
<li class="newreturnsubmit newreturnsubmit-t">
<div class="ui-button ui-button-green ui-button-ajax"><span><button type="submit">保存</button></span></div>
<a href="#pledge_${return.id }" class="ui-action-edit pledge-edit-r">取消修改</a>
</li>
</ul>
<div id="pledge_${return.id }_example" class="projects-home-right">
</div>
</form></div>

</c:forEach>

</div>
<div class="newreturn1"><div class="ui-button ui-button-gray ui-action-new"><span><a href="#new">添加新的回报</a></span></div></div>
<div id="pledge_new" style="display:none">
<form accept-charset="UTF-8" action="<%=request.getContextPath() %>/projects/savereturn" class="new_pledge" data-remote="true" id="new_pledge" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="mXPrIAvBs23PnmOfF1PE+JbSsr4Af0qcf0L0VwNiNsQ=" type="hidden"></div>
<div class="launchprojects returnborder">
<ul class="launchleft">
<li class="shortinput"><label for="pledge_amount">支持金额:</label>
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" class="pledge_amount" id="pledge_amount" name="money" placeholder="" size="30" type="text">
<input type="hidden" value="${project.id }" name="projectid"/>
</div>
</div>
<strong class="textprompts-r">元</strong>
<span id="pledge_amount_prompt" class="textprompts" style="display:none">通常50元与10元回报的支持者并没有多少差别，但更能有助于促成你的项目</span>
</li>
<li><label>回报内容:</label>
<div class="ui-textarea">
<div class="ui-textarea-border">
<textarea id="pledge_content" name="content"></textarea>
</div>
</div>
</li>
<li class="projects-new-return-li"><label>说明图片:</label>
<div id="pledge_photos_button"></div> 
<!--<object id="SWFUpload_0" type="application/x-shockwave-flash" data="<%=request.getContextPath()%>/demohour-index_files/swfupload_002.swf" class="swfupload" height="32" width="80"><param name="wmode" value="window"><param name="movie" value="/assets/swfupload/swfupload.swf?preventswfcaching=1376729085944"><param name="quality" value="high"><param name="menu" value="false"><param name="allowScriptAccess" value="always"><param name="wmode" value="transparent"><param name="flashvars" value="movieName=SWFUpload_0&amp;uploadURL=%2Fattachments%3Fsign%3D4cb3d8f25aadacd1a292b8a165296380a8c7a640d9b28465a9aa58ba4e29089a%26amp%3Btype%3Dpledge_photo%26amp%3Buser_id%3D1121568&amp;useQueryString=false&amp;requeueOnError=false&amp;httpSuccess=&amp;assumeSuccessTimeout=0&amp;params=&amp;filePostName=Filedata&amp;fileTypes=*.jpg%3B*.jpeg%3B*.gif%3B*.png&amp;fileTypesDescription=%E5%9B%BE%E7%89%87%E6%96%87%E4%BB%B6&amp;fileSizeLimit=5120&amp;fileUploadLimit=3&amp;fileQueueLimit=0&amp;debugEnabled=false&amp;buttonImageURL=%2Fassets%2Fupload.gif&amp;buttonWidth=80&amp;buttonHeight=32&amp;buttonText=&amp;buttonTextTopPadding=0&amp;buttonTextLeftPadding=0&amp;buttonTextStyle=color%3A%20%23000000%3B%20font-size%3A%2016pt%3B&amp;buttonAction=-110&amp;buttonDisabled=false&amp;buttonCursor=-1"></object>-->
<span class="textprompts">支持jpg、jpeg、png、gif格式，不超过5MB，最多三张</span>
<div id="pledge_photos" class="projects-new-return-img">
</div>
</li>
<li class="returntime placeslimited"><label for="pledge_quantity_limit">限定名额:</label>
<div class="ui-radio">
<label><input class="ui-radio radio pledge_quantity_limit" id="pledge_quantity_limit_false" name="limit" value="false" type="radio">否</label>
<label><input class="ui-radio radio pledge_quantity_limit" id="pledge_quantity_limit_true" name="limit" value="true" type="radio">是</label>
</div>
<div id="pledge_quantity_limit" class="placeslimitedclear" style="display:none"><label for="pledge_quantity">名额数量:</label>
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" id="pledge_quantity" name="limitnum" placeholder="" size="30" type="text">
</div>
</div><strong>个</strong></div>
</li>
<li class="returntime sendpost"><label>是否邮寄:</label>
<div id="pledge_shipping" class="ui-radio">
<label><input class="ui-radio radio pledge_shipping" id="pledge_shipping_0" name="post" value="0" type="radio">否</label>
<label style="width:30px"><input class="ui-radio radio pledge_shipping" id="pledge_shipping_1" name="post" value="1" type="radio">快递</label>
<label style="width:30px"><input class="ui-radio radio pledge_shipping" id="pledge_shipping_2" name="post" value="2" type="radio">平邮</label>
</div>
</li>
<li class="returntime sendpost"><label>是否包邮:</label>
<div id="pledge_shipping_fee" class="ui-radio">
<label><input class="ui-radio radio pledge_shipping_fee" id="pledge_shipping_fee_true" name="freepost" value="0" type="radio">否</label>
<label style="width:55px"><input class="ui-radio radio pledge_shipping_fee" id="pledge_shipping_fee_false" name="freepost" value="1" type="radio">大陆包邮</label>
</div>
</li>
<li class="returntime placeslimited"><label for="pledge_shipping_days">回报时间:</label>
<div class="placeslimitedclear"><p>项目成功结束后预计</p>
<div class="ui-text">
<div class="ui-text-right">
<input autocomplete="off" id="pledge_shipping_days" name="days" placeholder="" size="30" type="text">
</div>
</div><strong>天</strong></div>
</li>
<li class="newreturnsubmit newreturnsubmit-t">
<div class="ui-button ui-button-green ui-button-ajax"><span><button type="submit">保存</button></span></div>
<a href="#new" class="ui-action-new pledge-edit-r">取消添加</a>
</li>
</ul>
<div class="projects-home-right">
</div>
</div>
</form>

</div>
<div class="form-submit">
<div class="ui-button ui-button-green"><span><a href="#ui_edit_project" class="ui-action-skip">下一步</a></span></div>
</div>
<div id="pledge_popup" class="ui-popup ui-popup-blank">
<div class="ui-popup-background">
<div class="ui-popup-content ui-draggable">
<form accept-charset="UTF-8" action="<%=request.getContextPath() %>/projects/editstatus/${project.id}" class="edit_project" id="edit_project" method="post"><div style="margin:0;padding:0;display:inline">
<input name="utf8" value="✓" type="hidden">
<input name="_method" value="put" type="hidden">
<input name="authenticity_token" value="mXPrIAvBs23PnmOfF1PE+JbSsr4Af0qcf0L0VwNiNsQ=" type="hidden">
</div>
<table class="ui-popup-table" align="center" border="0" cellpadding="0" cellspacing="0">
<tbody><tr><td class="ui-popup-top-l" width="25"></td>
<td class="ui-popup-top"></td>
<td class="ui-popup-top-r" width="25"><a href="#close" class="ui-popup-close">关闭</a></td></tr>
<tr><td class="ui-popup-mid-l"></td>
<td class="ui-popup-mid">
<div class="stepintro "><strong>小提示：</strong>
<ul>
<li>【3个以上的回报】多些选择能提高项目的支持率。</li>
<li>【几十、几百、上千元的支持档位】3个不同的档次的回报，能让你的项目更快成功。</li>
<li>【回报必须低于市价】给第一批支持者最好最优惠的回报，感谢他们的支持。</li>
<li>【回报最好是项目的衍生品】，与项目内容有关的回报更能吸引大家的支持。</li>
</ul>
</div>
<div class="form-submit-prompts">
<div class="ui-button-green ui-button"><span><a href="#close" class="ui-popup-close">返回修改</a></span></div>
<div class="ui-button-green ui-button"><span><button type="submit">下一步</button></span></div>
</div>
</td>
<td class="ui-popup-mid-r"></td></tr>
<tr><td class="ui-popup-bottom-l"></td><td class="ui-popup-bottom"></td><td class="ui-popup-bottom-r"></td></tr>
</tbody></table>
</form></div>
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
<form accept-charset="UTF-8" action="<%=request.getContextPath() %>/messages" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="mXPrIAvBs23PnmOfF1PE+JbSsr4Af0qcf0L0VwNiNsQ=" type="hidden"></div>
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
$(document).ready(function() {
    $.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');
    $('input, textarea').placeholder();
    $(window).scroll(function() {
        if ($(window).scrollTop() > 48) {
            $('#ui_notification').addClass('layer-message-fixed');
        } else {
            $('#ui_notification').removeClass('layer-message-fixed');
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
    $.ui_core.flash("new_project", []),
    $("body").on("click", ".ui-action-edit", 
    function(t) {
        var e = $(t.target).attr("href").split("#")[1];
        $("#" + e + "_show, #" + e + "_edit").toggle("blind", {},
        500)
    }),
    $("body").on("click", ".ui-action-new", 
    function() {
        $("#pledge_new").toggle("blind", 
        function() {
            $(".newreturn1").toggle(),
            $(".form-submit").toggle(),
            $("html, body").animate({
                scrollTop: $("#pledge_new").position().top
            },
            1e3),
            $("#pledge_amount").focus()
        })
    }),
    $("body").on("click", ".ui-action-next", 
    function(t) {
        var e = j = k = !1;
        $("span.pledge_amount").each(function() {
            $(this).attr("title") < 100 && (e = !0),
            $(this).attr("title") >= 100 && $(this).attr("title") < 1e3 && (j = !0),
            $(this).attr("title") >= 1e3 && (k = !0)
        }),
        $("#too_simple, #too_little").show(),
        e && j && k && $("#too_simple").hide(),
        $("span.pledge_amount").length >= 3 && $("#too_little").hide(),
        e && j && k && $("span.pledge_amount").length >= 3 ? $("#edit_project").submit() : ($("#pledge_popup").show(), t.preventDefault())
    }),
    $("body").on("click", ".ui-action-skip", 
    function() {
        $("#edit_project").submit()
    }),
    $("body").on("click", ".pledge_quantity_limit", 
    function() {
        "true" == $(this).val() ? $("#" + $(this).attr("id").replace("_true", "")).show() : $("#" + $(this).attr("id").replace("_false", "")).hide()
    }),
    $.swfupload.multiple("pledge_photos_button", {
        upload_url: "<%=request.getContextPath()%>/image/upload?type=pledge_photo&user_id=1121568",
        flash_url: "<%=request.getContextPath()%>/demohour-index_files/swfupload.swf",
        button_image_url: "http://assets.demohour.com/assets/upload-285b64cf3f94c8753e53c69150208bce.gif",
        upload_complete_handler: function() {
            this.startUpload(),
            $("#pledge_photos_preview").html(""),
            $("#pledge_photos").find("img").each(function() {
                $("#pledge_photos_preview").append($('<a href="#"><img src="' + $(this).attr("src") + '"></a>'))
            })
        },
        file_upload_limit: "3"
    }),
    <c:forEach items="${returns}" var="return">
    $.swfupload.multiple("pledge_${return.id}_photos_button", {
        upload_url: "<%=request.getContextPath()%>/image/upload?&target_id=${return.id}&type=pledge_photo&user_id=1121568",
        flash_url: "<%=request.getContextPath()%>/demohour-index_files/swfupload.swf",
        button_image_url: "http://assets.demohour.com/assets/upload-285b64cf3f94c8753e53c69150208bce.gif",
        upload_complete_handler: function() {
            this.startUpload(),
            $("#pledge_photos_preview").html(""),
            $("#pledge_photos").find("img").each(function() {
                $("#pledge_photos_preview").append($('<a href="#"><img src="' + $(this).attr("src") + '"></a>'))
            })
        },
        file_upload_limit: "3"
    }),
    </c:forEach>
    $("body").on("click", "a.ui-popup-delete", 
    function(t) {
        $("#ui_popup_delete").find("div.ui-popup-content").css("top", $(window).height() / 2 - 120),
        $("#ui_popup_delete").find("p.ui-popup-text").html($(t.target).attr("title")),
        $("#ui_popup_delete").find("a.ui-popup-url").attr("href", $(t.target).attr("href")),
        $("#ui_popup_delete").toggle(),
        t.preventDefault()
    }),
    $("body").on("click", "a.ui-popup-message", 
    function(t) {
        $("#ui_popup_message").find("div.ui-popup-content").css("top", $(window).height() / 2 - 150),
        $("#ui_popup_message").find("form").attr("action", $(t.target).attr("href")),
        $("#ui_popup_message").find("span.ui-popup-title").html($(t.target).attr("title")),
        $("#ui_popup_message").toggle(),
        $("#ui_popup_message").find("textarea").val($(t.target).attr("data-message-attachment")),
        $("#ui_popup_message").find("textarea").focus(),
        $(t.target).attr("href").indexOf("?recipient_id=") > 0 ? ($("#ui_popup_message_url").show(), $("#ui_popup_message_email").hide(), $("#ui_popup_message_url").find("a").attr("href", $(t.target).attr("href").replace("?recipient_id=", "/"))) : ($("#ui_popup_message_url").hide(), $("#ui_popup_message_email").show()),
        t.preventDefault()
    });;
    $.ui_core.backtop('#backtop');
    $.ui_core.distance({
        now: '2013-08-17 16:44:41 +0800'
    });
});
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