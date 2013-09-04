<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>众筹系统  管理平台</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/manage_files/style.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/manage_files/top.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/jquery_002.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/top.js"></script>
<%-- <script type="text/javascript">
	var send_span = 2000;
</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/msg_sender.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/notify_sender.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/lang.js"></script> --%>
</head>

<body>
	<div id="info"></div>
	<div id="logo"></div>
	
	
	<div id="tips">
		<a href="<%=request.getContextPath() %>" target="_blank">查看首页</a>
		<a href="http://zc.35eb.com/m.php?m=Index&amp;a=change_password&amp;" target="main">修改密码</a>
		<a href="http://zc.35eb.com/m.php?m=Cache&amp;a=index&amp;" target="main">清除缓存</a>
		<a href="http://zc.35eb.com/m.php?m=Public&amp;a=do_loginout&amp;" target="_parent">注销</a>
	</div>
	
	<div class="blank5"></div>
	<div id="navs">
		<ul>
			<li><a class=" " href="http://zc.35eb.com/m.php?m=Index&amp;a=left&amp;id=1">首页</a></li>
			<li><a href="http://zc.35eb.com/m.php?m=Index&amp;a=left&amp;id=5">会员管理</a></li>
			<li><a class="current" href="http://zc.35eb.com/m.php?m=Index&amp;a=left&amp;id=13">项目管理</a></li>
			<li><a href="http://zc.35eb.com/m.php?m=Index&amp;a=left&amp;id=14">支付管理</a></li>
			<li><a href="http://zc.35eb.com/m.php?m=Index&amp;a=left&amp;id=10">短信邮件</a></li>
			<li><a href="http://zc.35eb.com/m.php?m=Index&amp;a=left&amp;id=3">系统设置</a></li>		
			</ul>
	</div>

	<div id="deal_msg" style="display:none; color:#ccc; font-size:12px; position:absolute; right:115px; top:40px;">业务队列发送中</div>
	<div id="promote_msg" style="display:none; color:#ccc; font-size:12px; position:absolute; right:15px; top:40px;">推广队列发送中</div>
	<div id="apns_msg" style="display:none; color:#ccc; font-size:12px; position:absolute; right:15px; top:40px;">PROMOTE_MSG_LIST_RUNNING</div>


</body></html>