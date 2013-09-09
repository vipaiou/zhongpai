<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../include/header.jsp" %>
<div class="ui-tab">
<div class="ui-tab-top">
<h2>帐号设置</h2>
</div>
<div class="ui-tab-layout">
<ul class="ui-tab-menu">
<li><a class="ui-tab-current" href="<%=request.getContextPath()%>/user/profile" title="个人资料">个人资料</a> </li>
<li><a href="<%=request.getContextPath()%>/user/account" title="密码设置">帐号密码</a></li>
<li><a href="<%=request.getContextPath()%>/user/notification" title="通知设置">通知设置</a></li>
<li><a href="<%=request.getContextPath()%>/user/sns" title="绑定设置">绑定设置</a></li>
</ul>
</div>
</div>

<div class="content">
<form accept-charset="UTF-8" action="<%=request.getContextPath()%>/user/updateprofile" enctype="multipart/form-data" id="edit_profile" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="WgCQl1g0l5r3m2JHy6Ry3Z6wZyCNMrtEtpJ9/hjEy6U=" type="hidden"></div>
<div class="left">
<ul class="gerenleft">
<li class="topli"><label for="user_name">显示名称:</label><input class="inputregoff" id="user_name" name="username" value="${user.UserName }" onblur="this.className='inputregoff'" onfocus="this.className='inputregon'" size="30" value="aiou" type="text">
<span>将显示在你的个人档案上</span></li>
<li><label for="user_province">所在地:</label>
<select id="user_province" name="province"><option selected="selected" value="">请选择</option><option value="北京">北京</option><option value="上海">上海</option><option value="广东">广东</option><option value="浙江">浙江</option><option value="江苏">江苏</option><option value="安徽">安徽</option><option value="重庆">重庆</option><option value="福建">福建</option><option value="甘肃">甘肃</option><option value="广西">广西</option><option value="贵州">贵州</option><option value="海南">海南</option><option value="河北">河北</option><option value="河南">河南</option><option value="黑龙江">黑龙江</option><option value="湖北">湖北</option><option value="湖南">湖南</option><option value="吉林">吉林</option><option value="江西">江西</option><option value="辽宁">辽宁</option><option value="内蒙古">内蒙古</option><option value="宁夏">宁夏</option><option value="青海">青海</option><option value="山东">山东</option><option value="山西">山西</option><option value="陕西">陕西</option><option value="四川">四川</option><option value="天津">天津</option><option value="西藏">西藏</option><option value="新疆">新疆</option><option value="云南">云南</option><option value="香港">香港</option><option value="澳门">澳门</option><option value="台湾">台湾</option><option value="海外">海外</option></select>
<select id="user_city" name="city"><option selected="selected" value="">请选择</option></select>
<span id="user_province_error"></span><span id="user_city_error"></span></li>
<li><label for="user_biography">自我介绍:</label>
<textarea class="inputregoff" cols="40" id="user_intro" name="description" onblur="this.className='inputregoff'" onfocus="this.className='inputregon'" rows="20">${user.Description }</textarea>
<span class="input-tip-textarea">这里可以输入大约300字的自我介绍，让大家多了解你</span> </li>
<li class="websites"><label for="user_websites">博客或微博:</label> 
<div class="usersurlsfields">
<div>
<input class="inputregoff" onfocus="this.className='inputregon'" onblur="this.className='inputregoff'" size="30" name="qq" value="${user.qq }" type="text">
</div>
<div>
<input class="inputregoff" onfocus="this.className='inputregon'" onblur="this.className='inputregoff'" size="30" name="weibo" value="${user.weibo }"  type="text">
</div>
<div>
<input class="inputregoff" onfocus="this.className='inputregon'" onblur="this.className='inputregoff'" size="30" name="douban" value="${user.douban }"  type="text">
</div>
<div>
<input class="inputregoff" onfocus="this.className='inputregon'" onblur="this.className='inputregoff'" size="30" name="renren" value="${user.renren }"  type="text">
</div>
<!-- <a href="#more" id="new_blog">更多</a> -->
</div></li>
<li>

<style>

.setup_main {
    /* clear: both; */
    overflow: hidden;
/*     border-color: #D7F5FF;
    border-style: none solid solid;
    border-width: 1px 1px; */
}
.index_title {
    clear: both;
    overflow: hidden;
/*     border-color: #D7F5FF;
    border-style: none solid solid;
    border-width: 1px 0px 0px; */
}
.setupTag_boxR {
    background: none repeat scroll 0 0 #FFFFFF;
    display: inline;
    float: right;
    height: 110px;
    margin: 10px 10px 0 0;
    padding: 1px 20px;
/*     width: 290px; */
}
.setupTag_box {
    /* height: 160px; */
    margin-top: 10px;
    overflow: hidden;
}
.setupTag_boxL {
    float: left;
    padding-left: 24px;
/*     padding-top: 60px; */
   /*  width: 360px; */
}
.setupTag_input .btn_normal em {
    background-position: right -530px;
   /*  color: #FFFFFF; */
    font-size: 14px;
    height: 28px;
    line-height: 28px;
}.setupTag_tit {
    -moz-border-bottom-colors: none;
    -moz-border-left-colors: none;
    -moz-border-right-colors: none;
    -moz-border-top-colors: none;
/*     background: none repeat scroll 0 0 #EDFAFF;
    border-color: #D7F5FF #D7F5FF -moz-use-text-color; */
/*     border-image: none;
    border-style: solid solid none;
    border-width: 1px 1px 0; */
    clear: both;
    overflow: hidden;
    /* padding: 15px 20px 0; */
}
.setupTag_list02 {
    -moz-border-bottom-colors: none;
    -moz-border-left-colors: none;
    -moz-border-right-colors: none;
    -moz-border-top-colors: none;
/*     background: none repeat scroll 0 0 #EDFAFF;
    border-color: -moz-use-text-color #D7F5FF #D7F5FF; */
/*     border-image: none;
    border-right: 1px solid #D7F5FF;
    border-style: none solid solid;
    border-width: 0 1px 1px; */
    clear: both;
    /* height: 60px; */
    overflow: hidden;
    padding: 5px 20px;
}.setupTag_input .btn_normal em {
    background-position: right -530px;
    color: #FFFFFF;
    font-size: 14px;
    height: 28px;
    line-height: 28px;
}
.setupTag_list01 {
    clear: both;
    height: 78px;
    margin-top: 5px;
    overflow: hidden;
    width: auto;
}.setupTag_list01 a {
    background-color: #DAF5FA;
    color: #4184BB;
    display: inline-block;
    font-size: 14px;
    height: 24px;
    line-height: 24px;
    margin: 0 2px 2px 0;
    padding: 0 10px;
}
.setupTag_list01 a em {
    color: #4184BB;
    font-family: Arial;
    font-size: 17px;
    font-weight: bold;
    margin-right: 2px;
    vertical-align: -2px;
}.tagList {
    display: block;
    font-size: 12px;
    width: 480px;
}
.setupTag_list02 .tagList {
    overflow: hidden;
   /*  width: 695px; */
}.tagList li {
    background: none repeat scroll 0 0 #FFFFFF;
    border: 1px solid #B7D7F0;
    float: left;
    height: 20px;
    line-height: 20px;
    margin: 2px 5px 2px 0;
    white-space: nowrap;
    clear:none;
}	.tagList li, .setupTag_list02 li {
    margin-right: 5px;
}.setupTag_list02 li {
    margin-bottom: 7px;
}.tagList li {
    font-size: 14px;
    padding-top: 1px;
}.tagList li {
    font-size: 14px;
    padding: 3px 1px;
    float: left;
    list-style:none;
	display:inline;
}
.tagList li a.a1 {
    display: inline;
    line-height: 19px;
    padding: 0 3px 0 7px;
    vertical-align: 4px;
}.tagList li a.a2 img {
    background: url("http://img.t.sinajs.cn/t4/style/images/setup/t36/closebg.gif") no-repeat scroll 3px -83px transparent;
    display: inline-block;
    height: 12px;
    margin: 2px 4px 2px 0;
    width: 12px;
}.setupTag_input .setupTag_txt {
    border: 1px solid #DDDDDD;
    color: #CCCCCC;
    height: 24px;
    line-height: 24px;
    margin-right: 5px;
    padding: 2px 0 0 2px;
    width: 250px;
    margin-bottom: 5px;
}.btn_normal {
    background-position: -400px -100px;
    height: 24px;
    line-height: 24px;
    padding-left: 20px;
}.rt {
    float: right;
}
</style>

<div class="MIB_setup">
  <!--个人资料-->
  <div class="setup_main"> 
 <div class="index_title">
    <!--this page title-->
    <label for="user_picture">个人标签:</label>
    	添加描述自己职业、兴趣爱好等方面的词语，让更多人找到你，让你找到更多同类人
    <!--/this page title-->
   </div>
    <div class="setupTag">
    <div class="setupTag_box">
    	<div class="setupTag_boxL">
    	<div class="setupTag_input">
		  	<input type="text" class="setupTag_txt" id="tag_input" placeholder="多个标签词之间请用空格分开">
		  	<button class="ui-button" type="button" onclick="javascript:addtag($('#tag_input').val());">添加</button>
		  </div>
		  <div class="error_color" id="tip_or_error" style="display:none">含有非法字符，请修改</div>
    	</div>
    	<div class="setupTag_boxR">
	    	<p class="setupTag_tip2"><span class="rt lightblue"><a href="#">换一换</a></span><label>你可能感兴趣的标签:</label></p>
		  	<div class="setupTag_list01">
			  	<a title="添加标签" href="javascript:addtag('白羊')" tagid="16451"><em>+</em>白羊</a>
			  	<a title="添加标签" href="#" tagid="7279"><em>+</em>B型血</a>
			  	<a title="添加标签" href="#" tagid="735"><em>+</em>房产</a>
			  	<a title="添加标签" href="#" tagid="42065"><em>+</em>瓶邪</a>
			  	<a title="添加标签" href="#" tagid="1837"><em>+</em>高考</a>
			  	<a title="添加标签" href="#" tagid="2470"><em>+</em>韩寒</a>
			  	<a title="添加标签" href="#" tagid="16728"><em>+</em>布丁</a>
			  	<a title="添加标签" href="#" tagid="303571340004918951"><em>+</em>黑龙江生活</a>
			  	<a title="添加标签" href="#" tagid="2424"><em>+</em>性感</a>
			  	<a title="添加标签" href="#" tagid="10992"><em>+</em>金在中</a>
		  	</div>
	  	</div>
	    
	    <div id="mytagshow2" class="setupTag_list02">
	    <label for="user_picture">已经添加的标签:</label>
	    <ul id="taglist" class="tagList">
	    	<!-- <li node-type="li" title="广告" onmouseover="this.className='bg';" onmouseout="this.className='';">
	    	<a class="a1" href="http://s.weibo.com/user/&amp;tag=%E5%B9%BF%E5%91%8A" node-type="text">广告</a>
	    	<a class="a2" node-type="del" title="删除标签" tagid="545" href="#" onclick="return false;"><img src="http://img.t.sinajs.cn/t36/style/images/common/transparent.gif"></a>
	    	</li>
	    	<li node-type="li" title="北京生活" onmouseover="this.className='bg';" onmouseout="this.className='';">
	    	<a class="a1" href="http://s.weibo.com/user/&amp;tag=%E5%8C%97%E4%BA%AC%E7%94%9F%E6%B4%BB" node-type="text">北京生活</a>
	    	<a class="a2" node-type="del" title="删除标签" tagid="169940" href="#" onclick="return false;"><img src="http://img.t.sinajs.cn/t36/style/images/common/transparent.gif"></a>
	    	</li>
	    	<li node-type="li" title="美女" onmouseover="this.className='bg';" onmouseout="this.className='';">
	    	<a class="a1" href="http://s.weibo.com/user/&amp;tag=%E7%BE%8E%E5%A5%B3" node-type="text">美女</a>
	    	<a class="a2" node-type="del" title="删除标签" tagid="13" href="#" onclick="return false;"><img src="http://img.t.sinajs.cn/t36/style/images/common/transparent.gif"></a>
	    	</li> -->
	    </ul>
	    <div class="clear"></div>
	    </div>
	    
    </div>
    	
    <!-- 
    <div class="setupTag_titnew">
    <div class="setupTag_tit gray6 MIB_linedot">关于标签：</div>
    <div class="setupTag_txtList gray9">
    <p>·标签是自定义描述自己职业、兴趣爱好的关键词，让更多人找到你，让你找到更多同类。</p>
    <p>·已经添加的标签将显示在“我的微博”页面右侧栏中，方便大家了解你。</p>
    <p>·在此查看你自己添加的所有标签，还可以方便地管理，最多可添加10个标签。 </p>
    <p>·点击你已添加的标签，可以搜索到有同样兴趣的人。</p>
    </div>
    </div> -->
    </div>
  </div>
  
   
  <!--/个人资料--> 
</div>
</li>
</ul>
<div class="form-submit"><div class="ui-button-green"><span><button type="submit" class="ui-button">保存最新的设置</button></span></div></div>
</div>
<div class="right gerenright">
<div style="height:170px">
<label for="user_picture">个人头像:</label>
<div class="removeable">
<div id="user_avatar_button"></div>
<div id="user_avatar_url_error" class="llrfgfdg"></div>
<div id="user_avatar_preview">
<div id="user_avatar_106730">
<img src="${ imagehost }avatar-medium-${user.avatar}">
<%-- <a href="<%=request.getContextPath()%>/attachments/106730?sign=4f8c8bee08a707652f8196e66a94ef02d9bd487b14e94428b084975947c30a23&amp;type=user_avatar&amp;url=http%3A%2F%2Fwww.demohour.com%2Fsettings%2Fprofile" data-method="delete" rel="nofollow">删除</a> --%>
</div>

</div>
</div>
</div>

</div>

</form></div>
<div class="none" id="blog">
<div class="url new">
<input class="inputregoff" onfocus="this.className='inputregon'" onblur="this.className='inputregoff'" size="30" name="user[blogs][]" type="text">
<a href="#more" class="add remove_blog">删除</a></div></div>
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
<script src="<%=request.getContextPath()%>/demohour-index_files/settings-5916087ed52d314ff9fc032599a500cd.js" type="text/javascript"></script>
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
   /*  $.ui_notification.ready({
        url: 'http://nf-2.demohour.com',
        data: {
            "new_comments_count": 0,
            "new_messages_count": 0,
            "new_notifications_count": 0,
            "new_posts_count": 0
        }
    }); */
    $.ui_core.flash("edit_profile", []),
    $.ui_core.notice("user", {}),
    $(".remove_blog").click(function(e) {
        $(e.target).parent("div").remove()
    }),
    $("#new_blog").click(function(e) {
        $(e.target).before($($("#blog").html())),
        $(".remove_blog").click(function(e) {
            $(e.target).parent("div").remove()
        })
    }),
    $("#user_province, #user_city").cascade({
        defaults: ["${user.province}", "${user.city}"],
        prompts: ["请选择", "请选择"]
    }),
    $.swfupload.load("user_avatar_button", {
        upload_url: "<%=request.getContextPath()%>/image/uploadavatar?userid=${user.UserId}",
        flash_url: "<%=request.getContextPath()%>/demohour-index_files/swfupload.swf",
        file_size_limit: "5120",
       /*  file_types: "*.jpg;*.gif;*.png;*.jpeg", */
        file_types: "*.jpg;*.png;*.jpeg",
        file_types_description: "图片文件",
        file_queue_error_handler: function(e, t) {
            t == SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED ? $.ui_core.notice("user", {
                avatar_url: "超过允许上载的文件数量"
            }) : t == SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT ? $.ui_core.notice("user", {
                avatar_url: "文件超过尺寸限制"
            }) : $.ui_core.notice("user", {
                avatar_url: "文件上传错误"
            })
        },
        file_dialog_start_handler: function() {
            $("#user_avatar_url_error").html("")
        },
        file_dialog_complete_handler: function() {
            this.startUpload()
        },
        upload_progress_handler: function(e, t, a) {
            $("#user_avatar_url_error").html($("<em>文件上传中 " + Math.ceil(99 * (t / a)) + "%</em>"))
        },
        upload_error_handler: function() {
            this.startUpload(),
            $.ui_core.notice("user", {
                avatar_url: "文件上传错误"
            })
        },
        upload_success_handler: function(e, t) {
        	var img = "<img src='"+t+"'/>";
            $("#user_avatar_preview").html(img),
            $("#user_avatar_url_error").html("")
        },
        upload_complete_handler: function() {
            //$("#edit_profile").submit()
        },
        button_action: SWFUpload.BUTTON_ACTION.SELECT_FILE,
        button_image_url: "http://assets.demohour.com/assets/upload-285b64cf3f94c8753e53c69150208bce.gif",
        button_width: 80,
        button_height: 32
    }),
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
        now: '2013-09-01 21:26:19 +0800'
    });
    setupTag();
    
});

function setupTag(){
	tgs = tags.split(" ");
    var tg = ''
    for(var i=0; i < tgs.length; i++){
    	tg += ""+
    	'<li node-type="li" title="'+tgs[i]+'" onmouseover="this.className=\'bg\';" onmouseout="this.className=\'\';">'+
    	'<a class="a1" href="<%=request.getContextPath()%>/user/?tag='+tgs[i]+'" node-type="text">'+tgs[i]+'</a>'+
    	'<a class="a2" node-type="del" title="删除标签" tagid="545" href="#" onclick="return false;"><img src="http://img.t.sinajs.cn/t36/style/images/common/transparent.gif"></a></li>';
    }
    $("#taglist").html(tg);
}
function addtag(tag){
	$.ajax({
		url: "<%=request.getContextPath()%>/user/addtag?"+new Date().getTime(),
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		type:"post",
		data: {tag:tag},
		success: function(){
	        tags = tags+" " + tag;
	        setupTag();
	      },
	      error:function(){
	    	  alert('添加失败');
	      }
	});
}
var tags = '${user.tags}';
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