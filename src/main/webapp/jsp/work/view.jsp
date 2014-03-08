<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../include/header.jsp" %>
<link href="<s:url value="/demohour-index_files/projects-9afed8175e89fa73647b287e62737440.css" />" media="screen" rel="stylesheet" type="text/css">

<div class="top-slidebar" style="width:100%;height:auto;background-color:#000">
<div id="top-slidebar" class="top-slideba-bg-s">
<div style="background-image: url('<%=request.getContextPath()%>/demohour-index_files/slides-files-000-000-278-278-original.jpg?1372525084'); display: block;"><a href="<%=request.getContextPath()%>" target="_blank"></a></div></div>
</div>
<%-- <div class="ui-tab">
<div class="ui-tab-top">
<h1><a href="<%=request.getContextPath()%>/projects/view/${project.id}">${project.name }</a></h1>
</div>
<div class="ui-tab-layout">
<ul class="ui-tab-menu">
<li><a class="ui-tab-current" href="<%=request.getContextPath()%>/projects/view/${project.id}">项目主页</a></li>
</ul>
</div>
</div> --%>
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
<style>
.projects-home-left, .projects-backers-left {
    float: right;
    overflow: hidden;
    /* text-align: center; */
    width: 570px;
}
.projects-home-right, .projects-backers-right {
    float: left;
    overflow: hidden;
    width: 360px;
}

</style>
<div id="project_intro" class="projects-home">
<div class="projects-home-right">
<style>
.hm_mainNav{
 	border: 1px solid #E3E3E3;
    color: #333333;
    margin: 0;
    overflow: hidden;
    padding: 14px 0 12px 15px;
    background: none no-repeat scroll 0 0 #F2F2F2;
    z-index:100;
}
.hm_mainNav li{
height:40px;
}
.hm_mainNav a{
	font-size:16px;
}
#menuwrapper{
	height:238px;
}
#projectpic{
fload:left;
}
</style>
<div id="menuwrapper">
<div id="navmenu" class="hm_mainNav">
<img id="projectpic" alt="" src="${imagehost }/project-medium-${project.picture}">
<ul style="width: 90px; float: right; text-align:right; padding-right:10px">
   	<li class="hm_navContribute"><a href="#">出品人</a></li>
   	<li class="hm_navIdea"><a href="#">主创团队</a></li>
   	<li class="hm_navHeima"><a href="#">创意设计</a></li>
	<li class="hm_navxsb"><a href="#">城市见面会</a></li>
   	<li class="hm_navHot"><a href="#">预算回报</a></li>
</ul>
</div>
</div>
<%-- <div class="sidebar-warming">
<div class="sidebar-money-raised-top">
<div class="sidebar-money-raised-num-t"><p>目标</p><b><b>1400</b>人关注</b><span><span>/</span>已达</span></div>
<div class="sidebar-money-raised-num"><b><b>${focusnum }</b>人</b></div>
</div>
<div class="sidebar-percentage">
<span class="sidebar-percentage-progress-span">21%</span>
<div style="width:21%;" class="sidebar-percentage-progress"></div>
</div>
<div class="sidebar-number-days">
<div class="sidebar-number-days-l"><span>话题总数</span><b><b>${topicnum }</b>条</b></div>
<div class="sidebar-number-days-m"><span>浏览人数</span><b><b>${project.viewnum }</b>人</b></div>
<div class="sidebar-number-days-r"><span>已经预热</span><b><b>18</b>天</b></div>
</div>
</div> --%>
<div class="project-by">
<div class="project-by-dotty">项目发起人</div>
<div class="project-by-img"><a href="<%=request.getContextPath()%>/${project.createuser }" target="_blank">
<img src="<%=request.getContextPath()%>/demohour-index_files/thumb.png" height="80" width="80"></a>
<div class="project-by-img-r"><a href="<%=request.getContextPath()%>/${project.createuser }" class="project-by-img-r-author" target="_blank">${createuser.UserName }</a>
<div class="project-by-last-time">上次登录时间：2013/08/17
<div class="post-private-letter"><a href="<%=request.getContextPath()%>/messages?recipient_id=${createuser.UserId }" class="ui-popup-message" title="私信给 ${createuser.UserName }">发私信</a></div>
</div>
<div class="project-by-post">
<a href="<%=request.getContextPath()%>/${project.createuser }" target="_blank">支持的项目：<span>0</span></a>
<a href="<%=request.getContextPath()%>/${project.createuser }" target="_blank">发起的项目：<span>1</span></a>
</div>
</div>
</div>
</div>
<div class="">
<button style="width:90px; height:30px" type="button">加入我们</button>
&nbsp;
<button style="width:90px; height:30px" type="button">支持我们</button>
</div>
<div class="reward-options">
<c:forEach items="${returns }" var="return" varStatus="s">
	<ul>
	<li class="support-amount">
	支持 <b>¥</b>${return.money }
	<span>（0 位支持者）</span>
	</li>
	<c:if test="${return.limit=='1' }">
	<li class="supporter-number"><div class="supporter-limit">
	<p>限额 ${return.limitnum }位，剩余 ${return.limitnum-return.supported } 位</p>
	</div></li></c:if>
	<li class="returns-contents"><p>${return.content }</p></li>
	<li class="returns-contents-img">
	</li>
	<li class="returns-contents-time">
	<p><c:if test="${return.freepost=='1' }">包邮（大陆地区）</c:if></p>
	<p>预计回报发放时间：项目成功结束后${return.days }天内</p>
	</li>
	<li>
	<div class="ui-button ui-button-special"><span><a href="#ui_warming_popup" class="ui-popup-open" data-popup-height="180">支持<b>¥</b>${return.money }</a></span></div>
	</li>
	</ul>
</c:forEach>
</div>
<!-- <div class="payment-refund">关于预热项目：<p></p>
预热项目是筹资前的一个热身，目的是希望更多的朋友能关注项目，给项目提意见，帮助发起人完善项目的各项内容。<p></p>
当项目成熟时，发起人可以随时提交审核开始筹资。
</div> -->
</div>
<div class="projects-home-left">
<%-- <div class="projects-home-synopsis-open">
<div class="projects-home-synopsis">
<div class="projects-home-left-top">
<img src="${imagehost }/project-large-${project.picture}">
</div>
<div class="projects-home-left-synopsis">
${project.content }
<br>
<div class="projects-home-left-seat">标签：
<a href="<%=request.getContextPath()%>/projects/category/technology" target="_blank">科技${project.category }</a>&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/1120565" target="_blank">${createuser.UserName }</a>&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/projects/location/${project.province }" target="_blank">${project.province }${project.city }</a>
</div>
</div>

</div>
</div> --%>
<style>
.WB_feed_type {
    margin: 0 20px;
    padding: 20px 0 0;
}
.WB_detail {
    margin-left: 85px;
}
.WB_face {
    float: left;
    position: relative;
    width: 50px;
}.W_face_radius {
    border-radius: 2px 2px 2px 2px;
}
.WB_func .WB_handle {
    float: right;
}.WB_name {
    font-size: 14px;
    font-weight: bold;
    line-height: 16px;
}
body, legend, .S_txt1, .S_func1, .SW_fun .S_func1, .SW_fun2 .S_func3, .current .S_func1:hover {
    color: #333333;
    text-decoration: none;
}
.producer{
text-align: left
}
.producertitle{
 	clear: both;
    display: block;
    font-size: 18px;
    font-weight: bold;
    height: 24px;
    line-height: 24px;
    margin-bottom: 5px;
    overflow: hidden;
    text-align: left;
}
.role{
    font-size: 18px;
    font-weight: bold;
    height: 24px;
    line-height: 24px;
    margin-bottom: 5px;
    overflow: hidden;
    float:right;
}
</style>
<div class="producertitle">出品人</div>
<div class="producer">
<div class="WB_feed_datail S_line2 clearfix">
            <div class="WB_face">
                <a title="出品人名称" href="/zhilikuaican" class="W_face_radius"><img width="80" height="90" src="http://tp2.sinaimg.cn/2767596585/50/5671260895/0" alt="" title="西安智锦丽食餐饮服务有限公司" usercard="id=2767596585"></a>
            </div>
            <div class="WB_detail">
                <div class="WB_info">
                <a usercard="id=2767596585" href="/zhilikuaican" title="出品人名称" nick-name="出品人名称" class="WB_name S_func1">
               		 出品人名称</a>
               		 <span class="role">出品人</span>
                </div>
                <div node-type="feed_list_content" class="WB_text">
                	一句话简介</div>
                <div node-type="feed_list_funcLink" class="WB_func clearfix">
                    <div class="WB_handle">
                        <a title="赞" action-data="version=mini&amp;qid=heart&amp;mid=3625009723677758&amp;like_src=1" action-type="feed_list_like" href="javascript:void(0);">喜欢</a><i class="S_txt3">|</i>
                        <a action-type="feed_list_favorite" diss-data="fuid=2767596585" href="javascript:void(0);" suda-data="key=smart_feed&amp;value=fav_by_genius">加关注</a><i class="S_txt3">|</i>
                        <a action-data="ouid=2767596585&amp;location=home" action-type="feed_list_comment" href="javascript:void(0);" suda-data="key=smart_feed&amp;value=comment_by_genius">写信</a>
                    </div>
                    <div class="WB_from">
                    <a suda-data="key=smart_feed&amp;value=details_feed" node-type="feed_list_item_date" class="S_link2 WB_time" date="1379753128000" title="2013-09-21 16:45" href="/2767596585/AauCgfqKG" target="_blank">北京</a>&nbsp;&nbsp;
                    <a rel="nofollow" href="http://app.weibo.com/t/feed/4ACxed" target="_blank" action-type="app_source" suda-data="key=tblog_home_new&amp;value=feed_come_from" class="S_link2">西城区</a>
                    <%-- <span class="hover">
                        <em class="S_txt3">|</em>&nbsp;
                        <a onclick="javascript:window.open('http://service.account.weibo.com/reportspam?rid=3625009723677758&amp;type=1&amp;from=10101&amp;url=&amp;bottomnav=1&amp;wvr=5', 'newwindow', 'height=700, width=550, toolbar =yes, menubar=no, scrollbars=yes, resizable=yes, location=no, status=no');" href="javascript:void(0);">举报</a>
                    </span> --%>
					</div>
                </div>
				<div style="display:none;" class="WB_media_expand repeat S_line1 S_bg4" node-type="feed_list_repeat"></div>
			</div>
        </div>
<%-- <div class="profilewarp">
<img src="http://localhost/zhongpaipic/avatar-large-0959d2920d35908181b7e35139600269.jpg">
<div class="profile-bio">
<div class="profile-bio-r">
<strong>supertool</strong>
</div>
<div class="post-private-letter">
	<a title="私信给 supertool" class="ui-popup-message" href="/zp/messages?to=1">发私信</a>
   <a title="关注supertool" href="#" class="a-btn-add mr10 j a_show_login">关注</a>
</div>
<p class="jiaru">2013-09-06 08:00:00.0 加入众拍网</p>
<p><a href="http://adsf.weibo.com" target="_blank">新浪微博 </a> <a href="314768964d" target="_blank">qq</a> <a href="http://asdf.douban.com" target="_blank">豆瓣</a> <a href="http://asdf.renren.com" target="_blank">人人</a> </p>
<p><a>影愿</a>  <a><del>镜头说</del></a>  <a><del>留言板</del></a>  <a><del>收藏秀</del></a></p>
</div>
</div> --%>
</div>
<br>

<div class="producertitle">主创团队</div>
<div class="producer">
<div class="WB_feed_datail S_line2 clearfix">
    <div class="WB_face">
        <a title="出品人名称" href="/zhilikuaican" class="W_face_radius"><img width="50" height="50" src="http://tp2.sinaimg.cn/2767596585/50/5671260895/0" alt="" title="西安智锦丽食餐饮服务有限公司" usercard="id=2767596585"></a>
    </div>
	<div class="WB_detail">
		<div class="WB_info">
	        <a usercard="id=2767596585" href="/zhilikuaican" title="出品人名称" nick-name="出品人名称" class="WB_name S_func1">出品人名称</a>
	        <span class="role">导演</span>
        </div>
        <div node-type="feed_list_content" class="WB_text">一句话简介</div>
         <div node-type="feed_list_funcLink" class="WB_func clearfix">
             <div class="WB_handle">
                 <a title="赞" action-data="version=mini&amp;qid=heart&amp;mid=3625009723677758&amp;like_src=1" action-type="feed_list_like" href="javascript:void(0);">喜欢</a><i class="S_txt3">|</i>
                 <a action-type="feed_list_favorite" diss-data="fuid=2767596585" href="javascript:void(0);" suda-data="key=smart_feed&amp;value=fav_by_genius">加关注</a><i class="S_txt3">|</i>
                 <a action-data="ouid=2767596585&amp;location=home" action-type="feed_list_comment" href="javascript:void(0);" suda-data="key=smart_feed&amp;value=comment_by_genius">写信</a>
             </div>
             <div class="WB_from">
                    <a suda-data="key=smart_feed&amp;value=details_feed" node-type="feed_list_item_date" class="S_link2 WB_time" date="1379753128000" title="2013-09-21 16:45" href="/2767596585/AauCgfqKG" target="_blank">北京</a>&nbsp;&nbsp;
                    <a rel="nofollow" href="http://app.weibo.com/t/feed/4ACxed" target="_blank" action-type="app_source" suda-data="key=tblog_home_new&amp;value=feed_come_from" class="S_link2">西城区</a>
                    <%-- <span class="hover">
                        <em class="S_txt3">|</em>&nbsp;
                        <a onclick="javascript:window.open('http://service.account.weibo.com/reportspam?rid=3625009723677758&amp;type=1&amp;from=10101&amp;url=&amp;bottomnav=1&amp;wvr=5', 'newwindow', 'height=700, width=550, toolbar =yes, menubar=no, scrollbars=yes, resizable=yes, location=no, status=no');" href="javascript:void(0);">举报</a>
                    </span> --%>
					</div>
  		</div>
		<div style="display:none;" class="WB_media_expand repeat S_line1 S_bg4" node-type="feed_list_repeat"></div>
	</div>
	</div>
</div>
<div class="producertitle">城市见面会</div>
<div class="producer">
<div class="WB_feed_datail S_line2 clearfix">
    <div class="WB_face">
        <a title="出品人名称" href="/zhilikuaican" class="W_face_radius"><img width="50" height="50" src="http://tp2.sinaimg.cn/2767596585/50/5671260895/0" alt="" title="西安智锦丽食餐饮服务有限公司" usercard="id=2767596585"></a>
    </div>
	<div class="WB_detail">
		<div class="WB_info">
	        <a usercard="id=2767596585" href="/zhilikuaican" title="出品人名称" nick-name="出品人名称" class="WB_name S_func1">见面会名称</a>
	        <span class="role">时间</span>
        </div>
        <div node-type="feed_list_content" class="WB_text">一句话简介</div>
         <div node-type="feed_list_funcLink" class="WB_func clearfix">
             <div class="WB_handle">
                 <a title="赞" action-data="version=mini&amp;qid=heart&amp;mid=3625009723677758&amp;like_src=1" action-type="feed_list_like" href="javascript:void(0);">喜欢</a><i class="S_txt3">|</i>
                 <a action-type="feed_list_favorite" diss-data="fuid=2767596585" href="javascript:void(0);" suda-data="key=smart_feed&amp;value=fav_by_genius">加关注</a><i class="S_txt3">|</i>
                 <a action-data="ouid=2767596585&amp;location=home" action-type="feed_list_comment" href="javascript:void(0);" suda-data="key=smart_feed&amp;value=comment_by_genius">报名</a>
             </div>
             <div class="WB_from">
             		地址xxxxxxx
                    <!-- <a suda-data="key=smart_feed&amp;value=details_feed" node-type="feed_list_item_date" class="S_link2 WB_time" date="1379753128000" title="2013-09-21 16:45" href="/2767596585/AauCgfqKG" target="_blank">北京</a>&nbsp;&nbsp;
                    <a rel="nofollow" href="http://app.weibo.com/t/feed/4ACxed" target="_blank" action-type="app_source" suda-data="key=tblog_home_new&amp;value=feed_come_from" class="S_link2">西城区</a> -->
                    <%-- <span class="hover">
                        <em class="S_txt3">|</em>&nbsp;
                        <a onclick="javascript:window.open('http://service.account.weibo.com/reportspam?rid=3625009723677758&amp;type=1&amp;from=10101&amp;url=&amp;bottomnav=1&amp;wvr=5', 'newwindow', 'height=700, width=550, toolbar =yes, menubar=no, scrollbars=yes, resizable=yes, location=no, status=no');" href="javascript:void(0);">举报</a>
                    </span> --%>
					</div>
  		</div>
		<div style="display:none;" class="WB_media_expand repeat S_line1 S_bg4" node-type="feed_list_repeat"></div>
	</div>
	</div>
</div>

<div class="producertitle">设计标</div>
<div class="producer">
<div class="WB_feed_datail S_line2 clearfix">
    <div class="WB_face">
        <a title="出品人名称" href="/zhilikuaican" class="W_face_radius"><img width="50" height="50" src="http://tp2.sinaimg.cn/2767596585/50/5671260895/0" alt="" title="西安智锦丽食餐饮服务有限公司" usercard="id=2767596585"></a>
    </div>
	<div class="WB_detail">
		<div class="WB_info">
	        <a usercard="id=2767596585" href="/zhilikuaican" title="出品人名称" nick-name="出品人名称" class="WB_name S_func1">设计标名称</a>
	        <span class="role">分类</span>
        </div>
        <div node-type="feed_list_content" class="WB_text">一句话简介</div>
         <div node-type="feed_list_funcLink" class="WB_func clearfix">
             <div class="WB_handle">
                 <a title="赞" action-data="version=mini&amp;qid=heart&amp;mid=3625009723677758&amp;like_src=1" action-type="feed_list_like" href="javascript:void(0);">喜欢</a><i class="S_txt3">|</i>
                 <a action-type="feed_list_favorite" diss-data="fuid=2767596585" href="javascript:void(0);" suda-data="key=smart_feed&amp;value=fav_by_genius">加关注</a><i class="S_txt3">|</i>
                 <a action-data="ouid=2767596585&amp;location=home" action-type="feed_list_comment" href="javascript:void(0);" suda-data="key=smart_feed&amp;value=comment_by_genius">投标</a>
             </div>
             <div class="WB_from">
                    <!-- <a suda-data="key=smart_feed&amp;value=details_feed" node-type="feed_list_item_date" class="S_link2 WB_time" date="1379753128000" title="2013-09-21 16:45" href="/2767596585/AauCgfqKG" target="_blank">北京</a>&nbsp;&nbsp;
                    <a rel="nofollow" href="http://app.weibo.com/t/feed/4ACxed" target="_blank" action-type="app_source" suda-data="key=tblog_home_new&amp;value=feed_come_from" class="S_link2">西城区</a> -->
                    <%-- <span class="hover">
                        <em class="S_txt3">|</em>&nbsp;
                        <a onclick="javascript:window.open('http://service.account.weibo.com/reportspam?rid=3625009723677758&amp;type=1&amp;from=10101&amp;url=&amp;bottomnav=1&amp;wvr=5', 'newwindow', 'height=700, width=550, toolbar =yes, menubar=no, scrollbars=yes, resizable=yes, location=no, status=no');" href="javascript:void(0);">举报</a>
                    </span> --%>
					</div>
  		</div>
		<div style="display:none;" class="WB_media_expand repeat S_line1 S_bg4" node-type="feed_list_repeat"></div>
	</div>
	</div>
</div>

<div class="producertitle">预算</div>
<table class="new-comment-list" cellspacing="0" cellpadding="0" border="0">
<tr>
<th  width="365"  align="left">项目</th>
<th  width="97"  align="left">单价</th>
<th  width="40"  align="left">数量</th>
<th  width="68"  align="left">总价</th>
</tr>
<thead>
</thead>
<tbody>
<tr>
	<td align="left">嘻嘻嘻</td>
	<td align="left">123</td>
	<td align="left">2</td>
	<td align="left">246</td>
</tr>
<tr>
	<td align="left">嘻嘻嘻</td>
	<td align="left">123</td>
	<td align="left">2</td>
	<td align="left">246</td>
</tr> 	
</tbody>
</table>

<%-- <div class="new-comment" id="posts">
<div class="new-tab">
<ul class="new-tab-menu">
<li><a id="filter_all" href="<%=request.getContextPath()%>/posts/list?project_id=322072&refresh=1376757331.657914" data-remote="true" class="new-tab-current"><div class="new-tab-left-radius"></div>全部<span>${topicnum}</span></a></li>
<li><a href="<%=request.getContextPath()%>/posts/list?filter=0&project_id=322072" data-remote="true">公告<span>1</span></a></li>
<li><a href="<%=request.getContextPath()%>/posts/list?filter=1&project_id=322072" data-remote="true">问答<span>10</span></a></li>
<li><a href="<%=request.getContextPath()%>/posts/list?filter=2&project_id=322072" data-remote="true">顶<span>29</span></a></li>
<li><a href="<%=request.getContextPath()%>/posts/list?filter=3&project_id=322072" data-remote="true">倒<span>0</span></a></li>
</ul>
</div>
<table class="new-comment-list" border="0" cellpadding="0" cellspacing="0">
<tbody>
<tr class="new-comment-t">
<td colspan="2" align="left" width="365">话题</td>
<td align="left" width="97">作者</td>
<td align="center" width="40">回应</td>
<td align="right" width="68">最后回应</td>
</tr>

<c:forEach items="${topics}" var="topic" varStatus="s"> 
<tr class="new-comment-ding">
<td align="center">
<div class="comment-icon">[<a href="<%=request.getContextPath()%>/posts/list?filter=0&limit=40&project_id=${topic.projectId}" data-remote="true">告</a>]</div>
</td>
<td align="left" width="336"><a href="<%=request.getContextPath()%>/posts/${topic.id }" class="c5 c5-length" title="#${topic.title }">${topic.title }</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-08-17 13:15:59 +0800" data-visited-id="20518">新</div></td>
<td align="left">
<a href="<%=request.getContextPath()%>/${topic.userid }" class="c9 c9-length" target="_blank" title="众拍网客服">${topic.userid }</a>
</td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/${topic.id}" class="c5">4</a></td>
<td class="timeline-posted-at" align="right"><a href="<%=request.getContextPath()%>/posts/${topic.id }?latest=1" data-timestamp="2013-08-17 13:15:59 +0800">11小时以前</a></td>
</tr>
</c:forEach>
<tr class="new-comment-ding">
<td align="center">
<div class="comment-icon">[<a href="<%=request.getContextPath()%>/posts/list?filter=0&limit=40&project_id=322072" data-remote="true">告</a>]</div>
</td>
<td align="left" width="336"><a href="<%=request.getContextPath()%>/posts/20518" class="c5 c5-length" title="#Talking Timer（对讲提示器）#上线了！">#Talking Timer（对讲提示器）#上线了！</a><div style="display: none;" class="list-icon-new" data-visited-time="2013-08-17 13:15:59 +0800" data-visited-id="20518">新</div></td>
<td align="left">
<a href="<%=request.getContextPath()%>/1013487" class="c9 c9-length" target="_blank" title="众拍网客服">众拍网客服</a>
</td>
<td align="center"><a href="<%=request.getContextPath()%>/posts/20518" class="c5">4</a></td>
<td class="timeline-posted-at" align="right"><a href="<%=request.getContextPath()%>/posts/20518?latest=1" data-timestamp="2013-08-17 13:15:59 +0800">11小时以前</a></td>
</tr>
</tbody>
</table>

</div> --%>

<div class="projects-posts-add comment-posts-add" id="new_post">
<div class="new-comment-top ui-faq-title-size">留言</div>
<form accept-charset="UTF-8" action="<%=request.getContextPath()%>/topic/add" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="mXPrIAvBs23PnmOfF1PE+JbSsr4Af0qcf0L0VwNiNsQ=" type="hidden"></div>
<input name="text_post[sns_sync]" value="0" type="hidden">
<div class="projects-posts-add-title">
<div class="ui-text">
<div class="ui-text-right">
<input id="post_title" name="title" placeholder="请输入标题" type="text">	
<input type="hidden" value="${project.id }" name="projectid"/>
<input type="hidden" value="1" name="isfirst"/>
</div>
</div>
</div>
<!-- <div class="comment-posts-add-category">
<div class="ui-radio">
<label><input class="ui-radio radio post_attribute_id" id="post_attribute_id_2" name="category" value="2" type="radio">顶（支持）</label>
<label><input class="ui-radio radio post_attribute_id" id="post_attribute_id_3" name="category" value="3" type="radio">倒（不支持）</label>
<label><input class="ui-radio radio post_attribute_id" id="post_attribute_id_1" name="category" value="1" type="radio">提问</label>
</div>
</div> -->
<div id="post_content_error"></div>
<div class="projects-posts-add-c comment-new-list-reply-textarea ">
<%-- <div id="ueditor_link_popup0" class="edui-popup-all edui-popup-img" style="display:none;"><div class="edui-popup-background">
<div style="top: 296.5px;" class="edui-popup-all-content"><div class="edui-popup-table">
<div class="edui-popup-top" id="ueditor_link_popup_top0">
<span class="edui-dialog-caption">添加链接</span><a href="#" title="关闭" onfocus="this.blur();" class="ueditor_link_close0">关闭</a></div>
<div class="edui-popup-table-content"><input id="ueditor_link_href0" placeholder="输入链接地址" type="text"><span id="ueditor_link_error_msg0"></span><div class="upload-img-list-b"><div class="upload-img-list-b-r"><a href="#" class="ueditor_link_close0" title="取消" onfocus="this.blur();">取消</a><a href="#" id="ueditor_link_submit0" title="确定" class="edui-upload-button" onfocus="this.blur();">确定</a></div></div></div></div></div></div></div>
<div id="ueditor_video_popup0" class="edui-popup-all edui-popup-img" style="display:none;"><div class="edui-popup-background"><div style="top: 296.5px;" class="edui-popup-all-content"><div class="edui-popup-table"><div class="edui-popup-top" id="ueditor_video_popup_top0"><span class="edui-dialog-caption">添加视频</span><a href="#" title="关闭" onfocus="this.blur();" class="ueditor_video_close0">关闭</a></div><div class="edui-popup-table-content"><input id="ueditor_video_convert_url0" +="" value="/attachments?sign=fe20660471609e35acc4dbf24af782fdba18fd536a3147090103407ee9b68495&type=post_video&user_id=1121568" style="display:none"><input id="ueditor_video_url0" placeholder="输入视频地址（支持优酷、土豆、酷6、新浪视频）" type="text"><span id="ueditor_video_error_msg0"></span><div class="upload-img-list-b"><div class="upload-img-list-b-r"><a href="#" class="ueditor_video_close0" title="取消" onfocus="this.blur();">取消</a><a href="#" id="ueditor_video_submit0" title="确定" class="edui-upload-button" onfocus="this.blur();">确定</a></div></div></div></div></div></div></div><div id="ueditor_image_popup0" class="edui-popup-all edui-popup-img" style="display:none;"><div class="edui-popup-background"><div style="top: 296.5px;" class="edui-popup-all-content"><div class="edui-popup-table"><div class="edui-popup-top" id="ueditor_image_popup_top0"><span class="edui-dialog-caption">添加图片</span><a href="#" title="关闭" onfocus="this.blur();" class="ueditor_image_upload_close0">关闭</a></div><div class="edui-popup-table-content"><div class="edui-popup-table-upload">
<!-- <object id="SWFUpload_0" type="application/x-shockwave-flash" data="demohour-index_files/swfupload.swf" class="swfupload" height="32" width="78"><param name="wmode" value="window"><param name="movie" value="/assets/swfupload/swfupload.swf?preventswfcaching=1376758794020"><param name="quality" value="high"><param name="menu" value="false"><param name="allowScriptAccess" value="always"><param name="wmode" value="transparent"><param name="flashvars" value="movieName=SWFUpload_0&uploadURL=%2Fattachments%3Fsign%3D6d2c0f52ea30040e8c3c0aff34adc72431e2ef08ca5ee6f52371940156737d85%26amp%3Btype%3Dpost_photo%26amp%3Buser_id%3D1121568&useQueryString=false&requeueOnError=false&httpSuccess=&assumeSuccessTimeout=0&params=&filePostName=Filedata&fileTypes=*.jpg%3B*.gif%3B*.png%3B*.jpeg&fileTypesDescription=JPG%20Images&fileSizeLimit=5%20MB&fileUploadLimit=6&fileQueueLimit=6&debugEnabled=false&buttonImageURL=%2Fassets%2Fueditor%2Fdefault%2Fimages%2Fupload.gif&buttonWidth=78&buttonHeight=32&buttonText=&buttonTextTopPadding=0&buttonTextLeftPadding=0&buttonTextStyle=color%3A%20%23000000%3B%20font-size%3A%2016pt%3B&buttonAction=-110&buttonDisabled=false&buttonCursor=-2"></object> -->
<div id="post_content_1"></div>
<span>单张最大5 MB，每次最多传6张，总共允许上传20张。</span>
</div>
<div class="edui-upload-img-list" id="ueditor_upload_image_progress0"></div>
<div id="ueditor_upload_image_thumbnails0" style="display:none"></div>
<div class="upload-img-list-b">
	<div class="upload-img-list-b-l"><input id="ueditor_image_upload_cancel_all0" value="取消上传" onclick="cancelQueue(swfu);" disabled="disabled" style="display:none" type="button"></div>
	<div class="upload-img-list-b-r"><a href="#" class="ueditor_image_upload_close0" title="取消" onfocus="this.blur();">取消</a><a href="#" id="ueditor_image_upload_submit0" title="确定" class="edui-upload-button" onfocus="this.blur();">确定</a></div></div></div></div></div></div></div>
	<div class="" id="post_content_1">
	<div style="z-index: 999;" id="edui1" class="edui-editor ">
	<div style="" id="edui1_toolbarbox" class="edui-editor-toolbarbox">
	<div id="edui1_toolbarboxouter" class="edui-editor-toolbarboxouter">
	<div class="edui-editor-toolbarboxinner">
	<div style="-moz-user-select: none;" id="edui2" class="edui-toolbar  " onselectstart="return false;" onmousedown='return $EDITORUI["edui2"]._onMouseDown(event, this);'><div id="edui3" class="edui-box edui-button edui-for-bold"><div id="edui3_state" onmousedown='$EDITORUI["edui3"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui3"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui3"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui3"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="插入标题" id="edui3_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui3"]._onClick();'><div class="edui-box edui-icon"></div></div></div></div></div><div id="edui4" class="edui-box edui-button edui-for-indent"><div id="edui4_state" onmousedown='$EDITORUI["edui4"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui4"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui4"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui4"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="自动排版" id="edui4_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui4"]._onClick();'><div class="edui-box edui-icon"></div></div></div></div></div><div id="edui5" class="edui-box edui-separator "></div><div id="edui6" class="edui-box edui-button edui-for-print"><div id="edui6_state" onmousedown='$EDITORUI["edui6"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui6"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui6"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui6"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="插入图片" id="edui6_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui6"]._onClick();'><div class="edui-box edui-icon"></div></div></div></div></div><div id="edui7" class="edui-box edui-button edui-for-insertvideo"><div id="edui7_state" onmousedown='$EDITORUI["edui7"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui7"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui7"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui7"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="插入视频" id="edui7_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui7"]._onClick();'><div class="edui-box edui-icon"></div></div></div></div></div><div id="edui8" class="edui-box edui-button edui-for-link"><div id="edui8_state" onmousedown='$EDITORUI["edui8"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui8"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui8"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui8"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="插入链接" id="edui8_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui8"]._onClick();'><div class="edui-box edui-icon"></div></div></div></div></div></div></div></div><div id="edui1_toolbarmsg" class="edui-editor-toolbarmsg" style="display:none;"><div id="edui1_upload_dialog" class="edui-editor-toolbarmsg-upload" onclick='$EDITORUI["edui1"].showWordImageDialog();'>点此上传</div><div class="edui-editor-toolbarmsg-close" onclick='$EDITORUI["edui1"].hideToolbarMsg();'>x</div><div id="edui1_toolbarmsg_label" class="edui-editor-toolbarmsg-label"></div><div style="height:0;overflow:hidden;clear:both;"></div></div></div><div style="overflow: hidden; height: 140px;" id="edui1_iframeholder" class="edui-editor-iframeholder"><iframe id="baidu_editor_0" frameborder="0" height="100%" width="100%"></iframe></div><div id="edui1_bottombar" class="edui-editor-bottomContainer"><table><tbody><tr><td id="edui1_elementpath" class="edui-editor-bottombar"></td><td id="edui1_wordcount" class="edui-editor-wordcount"></td></tr></tbody></table></div></div></div> --%>
	<div class="ui-textarea">
<div class="ui-textarea-border">
<textarea style="width:554px" placeholder="我要留言" name="content" id="comment_content" style=""></textarea>
</div>
</div>	
</div>
<div class="projects-posts-add-b">
<div id="post_content_1_error"></div>
<div class="ui-button ui-button-green ui-button-ajax"><span><button type="submit">发送</button></span></div>
</div>
</form></div>

</div>

<div id="warming_popup" class="ui-popup ui-popup-blank ui-popup-invite" style="display:none">
<div class="ui-popup-background">
<div class="ui-popup-content ui-draggable">
<table class="ui-popup-table" align="center" border="0" cellpadding="0" cellspacing="0">
<tbody><tr><td class="ui-popup-top-l" width="25"></td>
<td class="ui-popup-top"></td>
<td class="ui-popup-top-r" width="25"><a href="#close" class="ui-popup-close">关闭</a></td></tr>
<tr><td class="ui-popup-mid-l"></td>
<td class="ui-popup-mid">
<ul>
<li class="ui-popup-invite-t">项目正在预热中，目前还不能进行现金支持！</li>
<li class="ui-popup-invite-c">
预热是筹资前的一个热身，目的是希望更多的朋友能关注项目，<br>
给项目提意见，帮助发起人完善项目的各项内容，最终能够成功完成筹资。
</li>
<li>	
<div class="project-invite-title">别错过了项目的最新动态！请立即关注此项目</div>
<div class="ui-button ui-button-blue"><span><a href="<%=request.getContextPath()%>/projects/322072/invite" title="+关注此项目">+关注此项目</a></span></div>	
</li>
</ul>
</td>
<td class="ui-popup-mid-r"></td></tr>
<tr><td class="ui-popup-bottom-l"></td><td class="ui-popup-bottom"></td><td class="ui-popup-bottom-r"></td></tr>
</tbody></table>
</div>
</div>
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
<li><a href="<%=request.getContextPath()%>/intro" target="_blank" class="h-media-reports-b-r-more">查看完整服务介绍</a></li>
</ul>
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
<a href="http://weibo.com/zhongpai" target="_blank">官方微博</a>
<a href="http://blog.zhongpai.com/" target="_blank">官方博客</a>
<a href="<%=request.getContextPath()%>/?screen=mobile" class="last">手机版</a>
<p>© 2013北京众拍网科技有限公司　zhongpai.com 版权所有<br>电信与信息服务业务经营许可证120183号　京ICP备11032157号　京公网安备110105015321</p>
<div style="display: block;" id="backtop" class="backtop"><a href="#top"></a></div>
</div>
</div>


<%-- <script src="<s:url value="/demohour-index_files/jia.js"/>" async="" type="text/javascript"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/demohour-index_files/ga.js" async="" type="text/javascript"></script> --%>
<script src="<s:url value="/demohour-index_files/application-ffd788692166a3012f8373c435f5c0c2.js"/>" type="text/javascript"></script>
<script src="<s:url value="/demohour-index_files/projects-1ab927eb13eddbb381c44171a7060594.js"/>" type="text/javascript"></script>
<script type="text/javascript">
<!--
var FixedBox=function(el){
	this.element=el;
	this.BoxY=getXY(this.element).y;
	};
	FixedBox.prototype={
	setCss:function(){
	var windowST=(document.compatMode && document.compatMode!="CSS1Compat")? document.body.scrollTop:document.documentElement.scrollTop||window.pageYOffset;
	if(windowST>this.BoxY){
		this.element.style.cssText='position:fixed; top:0px;width:343px;';
	}else{
		this.element.style.cssText="";
	}
	}
	};
	function addEvent(elm, evType, fn, useCapture) {
	if (elm.addEventListener) {
	elm.addEventListener(evType, fn, useCapture);
	return true;
	}else if (elm.attachEvent) {
	var r = elm.attachEvent('on' + evType, fn);
	return r;
	}
	else {
	elm['on' + evType] = fn;
	}
	}
	function getXY(el) {
	return document.documentElement.getBoundingClientRect && (function() {
	var pos = el.getBoundingClientRect();
	return { x: pos.left + document.documentElement.scrollLeft, y: pos.top + document.documentElement.scrollTop };
	})() || (function() {
	var _x = 0, _y = 0;
	do {
	_x += el.offsetLeft;
	_y += el.offsetTop;
	} while (el = el.offsetParent);
	return { x: _x, y: _y };
	})();
	}
	var divA=new FixedBox(document.getElementById("navmenu"));
	addEvent(window,"scroll",function(){
		divA.setCss();
	}); 
//-->
</script>
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
    $.ui_core.visit({
        until: "2013-08-17 20:59:49 +0800"
    }),
    $(".projects-home-left-synopsis").find("img").click(function() {
        $(this).attr("src").indexOf("large") > 0 && window.open("/attachments?url=" + $(this).attr("src").replace("large", "original"), "original_image")
    }),
    $.ui_core.flash("project_intro", []),
    jiathis_config = {
        summary: "${project.summary}",
        title: "${project.name}"
    },
    function() {
        var e = document.createElement("script");
        e.type = "text/javascript",
        e.async = !0,
        e.src = ("https:" == document.location.protocol ? "https://": "http://") + "v2.jiathis.com/code/jia.js";
        var t = document.getElementsByTagName("script")[0];
        t.parentNode.insertBefore(e, t)
    } (),
    $(".invite_popup").click(function() {
        jiathis_config.url = "<%=request.getContextPath()%>/projects/322072?u=1121568"
    }),
    $("#invite_url").click(function() {
        $(this).select();
    }),
    $("#new_post").find("form").on("submit", 
    	function() {
        	$(".ui-flash").remove()
    }),
    $("#new_post").find("form").on('ajax:success', function(data) {
        alert(data);
    }),
    editors = $("#post_content_1").ueditor({
        autosave: !1,
        image: {
            url: "/attachments?sign=6d2c0f52ea30040e8c3c0aff34adc72431e2ef08ca5ee6f52371940156737d85&type=post_photo&user_id=1121568",
            flash_url: "/assets/swfupload/swfupload.swf",
            button_image_url: "/assets/ueditor/default/images/upload.gif",
            total_file_upload_limit: "20"
        },
        video: {
            url: "/attachments?sign=fe20660471609e35acc4dbf24af782fdba18fd536a3147090103407ee9b68495&type=post_video&user_id=1121568",
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
        now: '2013-08-18 00:59:49 +0800'
    });
    $("#focus").on('ajax:success', function(data) {
    	$("#focus").parent().html('<a id="focus" href="javascript:void(0);">已关注</a>');
    	$("#favorites_count").text(data);
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
<div style="position: fixed; left: 0px; top: 0px; width: 0px; height: 0px;" id="edui_fixedlayer"><div style="display: none;" id="edui9" class="edui-dialog edui-for-link"><div class="edui-dialog-wrap"><div id="edui9_body" class="edui-dialog-body"><div class="edui-dialog-shadow"></div><div id="edui9_titlebar" class="edui-dialog-titlebar"><div class="edui-dialog-draghandle" onmousedown='$EDITORUI["edui9"]._onTitlebarMouseDown(event, this);'><span class="edui-dialog-caption">超链接</span></div><div id="edui12" class="edui-box edui-button edui-dialog-closebutton"><div id="edui12_state" onmousedown='$EDITORUI["edui12"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui12"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui12"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui12"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="关闭对话框" id="edui12_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui12"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label"></div></div></div></div></div></div><div id="edui9_content" class="edui-dialog-content"></div><div class="edui-dialog-foot"><div id="edui9_buttons" class="edui-dialog-buttons"><div id="edui13" class="edui-box edui-button edui-okbutton"><div id="edui13_state" onmousedown='$EDITORUI["edui13"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui13"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui13"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui13"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui13_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui13"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">确认</div></div></div></div></div><div id="edui14" class="edui-box edui-button edui-cancelbutton"><div id="edui14_state" onmousedown='$EDITORUI["edui14"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui14"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui14"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui14"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui14_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui14"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">取消</div></div></div></div></div></div></div></div></div></div><div style="display: none;" id="edui10" class="edui-mask  edui-dialog-modalmask" onmousedown='return $EDITORUI["edui10"]._onMouseDown(event, this);'></div><div style="display: none;" id="edui11" class="edui-mask  edui-dialog-dragmask" onmousedown='return $EDITORUI["edui11"]._onMouseDown(event, this);'></div><div style="display: none;" id="edui15" class="edui-dialog edui-for-insertvideo"><div class="edui-dialog-wrap"><div id="edui15_body" class="edui-dialog-body"><div class="edui-dialog-shadow"></div><div id="edui15_titlebar" class="edui-dialog-titlebar"><div class="edui-dialog-draghandle" onmousedown='$EDITORUI["edui15"]._onTitlebarMouseDown(event, this);'><span class="edui-dialog-caption">视频</span></div><div id="edui16" class="edui-box edui-button edui-dialog-closebutton"><div id="edui16_state" onmousedown='$EDITORUI["edui16"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui16"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui16"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui16"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="关闭对话框" id="edui16_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui16"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label"></div></div></div></div></div></div><div id="edui15_content" class="edui-dialog-content"></div><div class="edui-dialog-foot"><div id="edui15_buttons" class="edui-dialog-buttons"><div id="edui17" class="edui-box edui-button edui-okbutton"><div id="edui17_state" onmousedown='$EDITORUI["edui17"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui17"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui17"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui17"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui17_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui17"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">确认</div></div></div></div></div><div id="edui18" class="edui-box edui-button edui-cancelbutton"><div id="edui18_state" onmousedown='$EDITORUI["edui18"].Stateful_onMouseDown(event, this);' onmouseup='$EDITORUI["edui18"].Stateful_onMouseUp(event, this);' onmouseover='$EDITORUI["edui18"].Stateful_onMouseOver(event, this);' onmouseout='$EDITORUI["edui18"].Stateful_onMouseOut(event, this);'><div class="edui-button-wrap"><div data-original-title="" id="edui18_body" unselectable="on" class="edui-button-body" onmousedown="return false;" onclick='return $EDITORUI["edui18"]._onClick();'><div class="edui-box edui-icon"></div><div class="edui-box edui-label">取消</div></div></div></div></div></div></div></div></div></div><div style="display: none;" id="edui19" class="edui-popup  edui-bubble"> <div id="edui19_body" class="edui-popup-body"> <iframe style="position:absolute;z-index:-1;left:0;top:0;background-color: white;" src="javascript:" frameborder="0" height="100%" width="100%"></iframe> <div class="edui-shadow"></div> <div id="edui19_content" class="edui-popup-content">  </div> </div></div></div></body></html>