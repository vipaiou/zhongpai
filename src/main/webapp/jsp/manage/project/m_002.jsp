<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>方维众筹系统  fanwe.com 管理平台</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/manage_files/style.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/manage_files/left.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/jquery_002.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/left.js"></script>
</head>

<body>
	<dl class="menu">
		<dt>项目管理</dt>
			<dd><a class="current" href="<%=request.getContextPath() %>/manage/categorys">分类列表</a></dd>
			<dd><a href="http://zc.35eb.com/m.php?m=Deal&amp;a=online_index&amp;">上线项目列表</a></dd>
			<dd><a href="http://zc.35eb.com/m.php?m=Deal&amp;a=submit_index&amp;">未审核项目</a></dd>
			<dd><a href="http://zc.35eb.com/m.php?m=Deal&amp;a=delete_index&amp;">回收站</a></dd><dt>项目支持</dt>
			<dd><a href="http://zc.35eb.com/m.php?m=DealOrder&amp;a=index&amp;">项目支持</a></dd><dt>项目点评</dt>
			<dd><a href="http://zc.35eb.com/m.php?m=DealComment&amp;a=index&amp;">项目点评</a></dd>	</dl>
	

</body></html>