<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Access Denied</title>
    <style type="text/css">
	div.error {
    	width: 260px;
    	border: 2px solid green;
    	background-color: yellow;
    	text-align: center;
	}
    </style>
  </head>
  <body>
    <h2>您无权访问本页面，请联系系统管理员为您分配相应访问的权限后进行！
    (0546-8785888-88)</h2>
    <hr>
    <div class="error">访问被拒绝<br>
    <c:if test="requestScope['SPRING_SECURITY_403_EXCEPTION']!=null">
      ${requestScope['SPRING_SECURITY_403_EXCEPTION'].message}
    </c:if>
      
    </div>
    <hr>
  </body>
</html>

