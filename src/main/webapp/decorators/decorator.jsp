<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="no-js ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]>    <html class="no-js ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]>    <html class="no-js ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <title><decorator:title default="选手操作平台" /></title>
        <decorator:head />


        <c:set var="locale" value="${sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE']}" />
        <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame Remove this if you use the .htaccess -->

        <!-- Main CSS -->
  
        <link href="<s:url value='/css/jquery-ui.css'/>" rel="stylesheet" type="text/css" />
        <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css" />
        <link href="<s:url value='/css/alerts/jquery-alerts.css'/>" rel="stylesheet" type="text/css" />
         <link href="<s:url value='/js/st-pop/st-pop.css'/>" rel="stylesheet" type="text/css" />
        <link href="<s:url value='/js/st-grid/css/st-grid.css'/>" rel="stylesheet" type="text/css" />
        <link href="<s:url value='/js/st-validate2.0/css/st-validate.css'/>" rel="stylesheet" type="text/css" />
         <link href="<s:url value='/js/st-select/css/st-select.css'/>" rel="stylesheet" type="text/css" />
          <link href="<s:url value='/js/st-date-selector2.0/css/st-date-selector.css'/>" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/st-drag-selector.css" />" />
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/st-tree.css" />" />
        
        <link rel="shortcut icon" href="<s:url value="/favicon.ico" />" type="image/x-icon" />
        <!-- Basic JS -->
        <script src="<s:url value="/js/modernizr-2.0.6.js" />"></script>

        <!-- jquery 相关库 -->
        <script src="<s:url value="/js/jquery.js" />"></script>
        
        <script src="<s:url value="/js/st-pop/st-pop.js" />"></script>
        <script src="<s:url value="/js/st-date-selector/st-date-selector_zn_CN.properties" />"></script>
		  <script src="<s:url value="/js/st-grid/js/st-grid.js" />"></script>
		  <script src="<s:url value="/js/st-select/js/st-select.js" />"></script>
		  <script src="<s:url value="/js/st-date-selector2.0/js/st-date-selector.js" />"></script>
		  <script src="<s:url value="/js/st-date-selector2.0/js/st-dom.js" />"></script>
		  <script src="<s:url value="/js/st-date-selector2.0/js/st-date-selector_zh.js" />"></script>
		  <script src="<s:url value="/js/st-select/js/st-select_zh.js" />"></script>
		  <script src="<s:url value="/js/st-validate2.0/js/st-validate2.0.js" />"></script>
		  <script src="<s:url value="/js/dateformat.js" />"></script>
        <script src="<s:url value="/js/jquery/jquery-ui-1.8.1.js" />"></script>
        <c:if test="${locale != null}">
            <script src="<s:url value="/js/i18n/jquery.ui.datepicker-${locale}.js" />"></script>
        </c:if>
        <script>
            //设置JAlert，JConfirm按钮国际化
            if (typeof i18n == 'undefined') {
                i18n={};
            }
            i18n.ui_ok = '<s:message code="sure"/>';
            i18n.ui_cancel = '<s:message code="cancel"/>';
        </script>
        <script src="<s:url value="/js/alerts/jquery-alerts.js"/>"></script>
        <script src="<s:url value="/js/jquery-metadata.js"/>"></script>
        <script src="<s:url value="/js/jquery-loading.js"/>"></script>
        <script src="<s:url value="/js/jquery-watermark.js"/>"></script>
        <script src="<s:url value="/js/jquery-tip.js" />"></script>

        <!-- 非jquery相关 -->
        <script src="<s:url value="/js/json/jquery.json-2.2.js" />"></script>
       <script src="<s:url value="/js/security/escape.js" />"></script> 

        <!-- 自主开发的库，依赖jquery -->
        <script src="<s:url value="/js/dspui/util.js" />"></script>
          <script src="<s:url value="/js/util/stringutil.js" />"></script>
        <c:if test="${locale != null}">
            <script src="<s:url value="/js/dspui/i18n/messages-${locale}.js" />"></script>
        </c:if>
        <c:if test="${locale == null }">
            <script src="<s:url value="/js/dspui/i18n/messages-zh_CN.js" />"></script>
        </c:if>
        <script src="<s:url value="/js/supertool/jquery.js" />"></script>
        <script src="<s:url value="/js/supertool/log.js" />"></script>
        <script src="<s:url value="/js/supertool/jquery-ui.js" />"></script>
        <script src="<s:url value="/js/supertool/jquery-form.js" />"></script>
        <script src="<s:url value="/js/supertool/stvalidate.js" />"></script>
        <script src="<s:url value="/js/supertool/grid-parse.js" />"></script>
        <script src="<s:url value="/js/supertool/grid.js" />"></script>
        <script src="<s:url value="/js/supertool/avatar.js" />"></script>
        <script src="<s:url value="/js/supertool/stripe.js" />"></script>
        <script src="<s:url value="/js/supertool/grid-columns.js" />"></script>
        <script src="<s:url value="/js/supertool/st-drag-selector.js" />"></script>
        <c:if test="${locale != null}">
            <script src="<s:url value="/js/supertool/st-drag-selector_${locale}.js" />"></script>
        </c:if>
        <c:if test="${locale == null }">
            <script src="<s:url value="/js/supertool/st-drag-selector_zh.js" />"></script>
        </c:if>
        <script src="<s:url value="/js/supertool/st-tree.js" />"></script>
        <script src="<s:url value="/js/dspui/validate.js" />"></script>
        <script>
            $.ajaxSetup({
                cache: false
            });
            /****
             * Scripts that needs access to JSP variables
             */
            S.basePath = '<s:url value="/" />';
            
        </script>
    </head>
    <body>
        <div class="container">
            <header>
                <%@include file="top.jsp" %>
            </header>
            <div id="main" class="span-24 last">
                <decorator:body />
            </div>
            <footer>
                <%@include file="bottom.jsp" %>
            </footer>
        </div>
        <script src="<s:url value="/js/supertool/dialog.js" />"></script>
        <%-- <script type="text/javascript">
             $(function(){
                 $.get('<s:url value="/message/count.json"/>', {}, 
                         function(data){
                              $('#infoUnRead').html(data.unRead);
                              $("#sysInfoLink").attr("title", "<s:message code='systemMsg'/>(" + $('#infoUnRead').html() + ")");
                         }, "json");
             });
        </script> --%>
    </body>
</html>