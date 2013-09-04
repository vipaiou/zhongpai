<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <title> </title>
 <style type="text/css">
body {
  margin: 0;
  padding: 0;
  background: #DFDFDF url(<%=request.getContextPath() %>/manage_files/images/body_bg.gif) repeat-y ;
  cursor: E-resize;
}
</style><script type="text/javascript" language="JavaScript">
<!--
var pic = new Image();
pic.src="<%=request.getContextPath() %>/manage_files/images/bar_open.gif";

function toggleMenu()
{
  frmBody = parent.document.getElementById('frame-body');
  imgArrow = document.getElementById('img');

  if (frmBody.cols == "0, 7, *")
  {
    frmBody.cols="200, 7, *";
    imgArrow.src = "<%=request.getContextPath() %>/manage_files/images/bar_close.gif";
  }
  else
  {
    frmBody.cols="0, 7, *";
    imgArrow.src = "<%=request.getContextPath() %>/manage_files/images/bar_open.gif";
  }
}

var orgX = 0;
document.onmousedown = function(e)
{
  var evt = Utils.fixEvent(e);
  orgX = evt.clientX;

  if (Browser.isIE) document.getElementById('tbl').setCapture();
}

document.onmouseup = function(e)
{
  var evt = Utils.fixEvent(e);

  frmBody = parent.document.getElementById('frame-body');
  frmWidth = frmBody.cols.substr(0, frmBody.cols.indexOf(','));
  frmWidth = (parseInt(frmWidth) + (evt.clientX - orgX));

  frmBody.cols = frmWidth + ", 7, *";

  if (Browser.isIE) document.releaseCapture();
}

var Browser = new Object();

Browser.isMozilla = (typeof document.implementation != 'undefined') && (typeof document.implementation.createDocument != 'undefined') && (typeof HTMLDocument != 'undefined');
Browser.isIE = window.ActiveXObject ? true : false;
Browser.isFirefox = (navigator.userAgent.toLowerCase().indexOf("firefox") != - 1);
Browser.isSafari = (navigator.userAgent.toLowerCase().indexOf("safari") != - 1);
Browser.isOpera = (navigator.userAgent.toLowerCase().indexOf("opera") != - 1);

var Utils = new Object();

Utils.fixEvent = function(e)
{
  var evt = (typeof e == "undefined") ? window.event : e;
  return evt;
}
//-->
</script></head>



<body onselect="return false;">
<table style="border-left:1px solid #BFBFBF;" id="tbl" cellpadding="0" cellspacing="0" height="100%">
  <tbody><tr><td><a href="javascript:toggleMenu();" onfocus="this.blur();"><img src="<%=request.getContextPath() %>/manage_files/images/bar_close.gif" id="img" border="0" height="60" width="6"></a></td></tr>
</tbody></table>

</body></html>