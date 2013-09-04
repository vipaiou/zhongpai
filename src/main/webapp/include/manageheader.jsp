<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

<title>众拍网 - 中国最大视频众筹平台！一切从这里开始！</title>
<meta http-equiv="X-UA-Compatible" content="IE=7, IE=9">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="description" content="众拍网是一个让你发起和支持创意项目的平台！在这里，你可以展示你的创意，并获得大家的支持。你也可以浏览，并支持你所喜欢的项目。">
<meta name="keywords" content="众筹, crowdfunding, 梦想, 创意, 支持创意, 点子网, 创意交易, 创意交易平台, 社会化筹资, 创意融资, 创意筹资, 创意网站, kickstarter, 中国kickstarter">
<meta property="qc:admins" content="15503656176455707526375">
<link rel="apple-touch-icon" href="http://assets.demohour.com/assets/57_icon-c332fee81f2e72b16961f10ca0ecc6d0.png" >
<link rel="apple-touch-icon" sizes="72x72" href="http://assets.demohour.com/assets/72_icon-405ccd3d1e4e6ed052e142dc484e9b1a.png" >
<link rel="apple-touch-icon" sizes="114x114" href="http://assets.demohour.com/assets/114_icon-c329c91ebc51b168fe1ac70a5ed9f6b7.png">
<meta content="authenticity_token" name="csrf-param">
<meta content="fPhVWp5NrTUcOZoH/rWI6LfATW8BlPRHdr/K/dqoCmI=" name="csrf-token">
<link href="<s:url value="/demohour-index_files/application-94208702999ddf09b2bc238d558425cd.css" />" media="screen" rel="stylesheet" type="text/css">
<link href="<s:url value="/demohour-index_files/projects-9afed8175e89fa73647b287e62737440.css" />" media="screen" rel="stylesheet" type="text/css">
</head>

<body>
<div id="headwrap">
<div class="head">
<div class="layer-message" id="ui_notification" style="display:none">
<a href="http://www.demohour.com/notifications/close_all" data-remote="true" class="layer-message-close">关闭</a>
<ul><li>没有消息</li></ul>
</div>
<a href="<s:url value="/"/>" class="logo"><img src="<s:url value="/demohour-index_files/logo-5af45a5a816b116ece5ae45f49c0f1d7.png" />" title="点名时间"></a>
<div class="head-l">
<div class="head-l-menu">
<%-- <a href="<s:url value="/"/>" class="menu-h">首页</a> --%>
<a href="<s:url value="manage/projects"/>" class="menu-p">项目管理</a>
<a href="<s:url value="manage/users"/>" class="menu-p">用户管理</a>
<a href="<s:url value="manage/payment"/>" class="menu-p">支付管理 </a>
</div>
</div>
<%-- <div class="head-search">
<form action="<s:url value="/search"/>" method="get">
<input name="q" class="head-search-l" autocomplete="off" placeholder="搜索项目">
<input value="" class="head-search-r" onfocus="this.blur()" type="submit">
</form>
</div> --%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.context.SecurityContextImpl"%>
<%@ page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@ page import="com.supertool.dspui.context.UserContext"%>
<%@ page import="com.supertool.dspui.security.UserDetailsImpl"%>

<%
String username = "";
SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT"); 
System.out.println(securityContextImpl);
Object principal = null;
if(securityContextImpl != null){
	principal = securityContextImpl.getAuthentication().getPrincipal();//SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
}   
if (principal instanceof UserDetails) { 
	username = ((UserDetailsImpl)principal).getUser().getUsername();
%>
<div class="head-r">
<ul class="head-r-menu">
<li class="head-myproject ui-dropbox"><a href="#"><span>我的项目</span></a>
<ul class="menulist" style="display:none;">
<li class="toplines"><img src="<s:url value="/demohour-index_files/toplines-77db07bc10a3e6f451da4b801840616c.gif" />"></li>
<li><a href="<s:url value="/projects/created"/>">发起的(0)</a></li>
<li><a href="<s:url value="/projects/backed"/>">支持的(0)</a></li>
<li><a href="<s:url value="/projects/favorite"/>">关注的(1)</a></li>
</ul>
</li>
<li class="head-messages ui-dropbox"><a href="#"><span>消息</span></a>
<ul class="menulist" style="display:none;">
<li class="toplines"><img src="<s:url value="/demohour-index_files/toplines-77db07bc10a3e6f451da4b801840616c.gif" />"></li>
<li><a href="<s:url value="/posts"/>">我的话题</a></li>
<li><a href="<s:url value="/comments"/>">我的评论</a></li>
<li><a href="<s:url value="/messages"/>">我的私信</a></li>
<li><a href="<s:url value="/notifications"/>">站内通知</a></li>
</ul>
</li>
<li class="head-mydemohour ui-dropbox">
<a href="#">
<img src="<s:url value="/demohour-index_files/user_avatars-files-000-106-730-106730-small.jpg" />" align="absmiddle"><span><%=username %></span></a>
<ul class="menulist" id="mydemohour_list" style="display:none;">
<li class="toplines"><img src="<s:url value="/demohour-index_files/toplines-77db07bc10a3e6f451da4b801840616c.gif" />"></li>
<li><a href="<s:url value="/transactions"/>">支持记录</a></li>
<li><a href="<s:url value="/settings"/>">帐号设置</a></li>
<li><a href="<s:url value="/1121568"/>" target="_blank">个人主页</a></li>
</ul>
</li>
<li><a href="<s:url value="/logout" />">登出</a></li>
</ul>
</div>
<%
	/* System.out.println("用户名:" + ((UserDetailsImpl)principal).getUser().getUsername());   
    username = ((UserDetailsImpl)principal).getUser().getUsername(); */
} else{
%>
<div class="head-r">
<ul class="head-r-menu">
<li><a href="/intro">服务介绍</a><span class="head-r-menu-l">|</span></li>
<li><a href="<%=request.getContextPath() %>/signup?url=http%3A%2F%2Fwww.demohour.com%2F">注册</a></li>
<li><a href="<%=request.getContextPath() %>/login?url=http%3A%2F%2Fwww.demohour.com%2F">登录</a></li>
<li class="sns-login">
<a rel="nofollow" href="/session/connect?provider=sina&amp;url=http%3A%2F%2Fwww.demohour.com%2F"><img title="新浪微博登录" src="<%=request.getContextPath()%>/demohour-index_files/sns_sina-36e6b6e2dbfa277f2e5acfb742150438.gif"></a>
<a rel="nofollow" href="/session/connect?provider=tencent&amp;url=http%3A%2F%2Fwww.demohour.com%2F"><img title="腾讯微博登录" src="<%=request.getContextPath()%>/demohour-index_files/sns_tencent-7f9e26f43e595fd88a06099083435e34.gif"></a>
<a rel="nofollow" href="/session/connect?provider=qzone&amp;url=http%3A%2F%2Fwww.demohour.com%2F"><img title="qzone登录" src="<%=request.getContextPath()%>/demohour-index_files/sns_qzone-e3cddf71aa8a573feca94a8edac0a8e8.gif"></a>
<a rel="nofollow" href="/session/connect?provider=douban&amp;url=http%3A%2F%2Fwww.demohour.com%2F"><img title="豆瓣登录" src="<%=request.getContextPath()%>/demohour-index_files/sns_douban-45d7b3742e3d0ce567da340feb6ddb32.gif"></a>
</li>
</ul>
</div>
<% } %>
</div>
</div>