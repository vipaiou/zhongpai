<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>众筹系统  - 管理平台 </title>

</head>
<frameset frameborder="10" framespacing="0" border="0" rows="75, *,32">
<frame src="<%=request.getContextPath() %>/manage/project/m.htm" name="top" frameborder="0" noresize="noresize" marginwidth="0" marginheight="0" scrolling="no"/>
<frameset frameborder="0" framespacing="0" border="0" cols="200, 7, *" id="frame-body"/>
	<frame src="<%=request.getContextPath() %>/manage/project/m_002.htm" frameborder="0" id="menu-frame" name="menu"/>
    <frame src="<%=request.getContextPath() %>/manage/project/m_003.htm" id="drag-frame" name="drag-frame" frameborder="no" scrolling="no"/>
	<frame src="<%=request.getContextPath() %>/manage/project/m_004.htm" frameborder="0" id="main-frame" name="main"/>
</frameset>
<frame src="<%=request.getContextPath() %>/manage/project/m_005.htm" name="footer" frameborder="0" noresize="noresize" marginwidth="0" marginheight="0" scrolling="no"/>
</frameset>
<noframes></noframes>
</html>