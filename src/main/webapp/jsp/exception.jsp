<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html  
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"  
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>异常信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<s:url value='/css/import.css" rel="stylesheet" type="text/css'/>" />
<script type="text/javascript">
	function showErrors() {
		var err_el = document.getElementById('errors');
		if (err_el.style.display == 'none') {
			err_el.style.display = '';
		} else {
			err_el.style.display = 'none';
		}
	}
</script>
</head>
<body >
<br />
<h1 style="border-bottom-style: dotted;"></h1>
<center><h3 style="color: red;font-size: large;">发生异常</h3></center>
<h1 style="border-bottom-style: dotted;"></h1>
<div style="max-height:600px;overflow: scroll;height: 600px;outline-style: hidden;border-bottom-style: dotted;">
${ex}，您可以<a href="javascript:showErrors();">查看详情</a>或直接
	<a href="javascript:window.back(-1);">返回</a>。

	<div style="display: none; color: red;padding-left: 20%;" id="errors">
		<c:forEach items="${ex.stackTrace }" var="e">  
        		${e }<br />
		</c:forEach> 
	</div>

</div>
${mybatis}
<!-- <div style="margin-bottom: 40%;">
</div> -->
</body>
</html>
