<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="top">

    <div class="logo">
        <a href="<s:url value="/campaign/index"/>">
            <img src="<s:url value="/images/logo.png" />" width="180px" height="65px" />
        </a>
    </div>
    <div id="userInfo" class="user-info">
        <ul>
            <li class="welcome">
                <s:message code="welcome"/>
                 <sec:authentication property="name"/>
            </li>
            
           
                <li id="change-info">
                    <a href="<s:url value='/personalinfo/index'/>" title="<s:message code="personalInfo"/>"><s:message code="personalInfo"/></a>
                </li>
           
                <li id="system-info">
                    <a href="<s:url value="/setting/index" />" title="<s:message code="systemSetting"/>"><s:message code="systemSetting"/></a>
                </li>
           
            <li>
                <a href="<s:url value="/logout" />" title="<s:message code="logout"/>"><s:message code="logout"/></a>
            </li>
           <%--  <li>
                <select id="changeLocale" onchange="changeLocale();">
                    <option value="zh_CN" <c:if test="${locale=='zh_CN'}">selected</c:if>>简体中文</option>
                    <option value="en" <c:if test="${locale=='en'}">selected</c:if>>English</option>
                </select>
            </li> --%>
        </ul>

    </div>
    <div id="siteNav" class="site-menu">
      
        <span id="campaignNav" ><a title="<s:message code="campaignManagement"/>" href="<s:url value="/campaign/index" />"><s:message code="campaignManagement"/></a></span>
       
            <span id="auditNav"><a title="<s:message code="materialAudit"/>" href="<s:url value="/material/audit/index"/>"><s:message code="materialAudit"/></a></span>
       
        	<span id="mediaNav"><a title="<s:message code="mediaResource"/>" href="<s:url value="/media/index"/>"><s:message code="mediaResource"/></a></span>
        	
        	<span id="summaryNav"><a title="<s:message code="下载报表 "/>" href="<s:url value="/report/index" />">下载报表</a></span>
       
            <span id="advertiserNav"><a title="广告主管理" href="<s:url value="/advertiser/index"/>">广告主管理</a></span>
            
            <span id="datasourceNav"><a title="数据源管理" href="<s:url value="/datasource/index"/>">数据源管理</a></span>
            
            <span id="algorithmNav"><a title="算法测试" href="<s:url value="/algorithm/test"/>">算法测试</a></span>
            
    </div>
    <script type="text/javascript">
         function chooseTab(tab){
             $('div.site-menu span').each(function(){
                 $(this).removeClass('selected'); 
              });
              $('div.user-info li').each(function(){
                  $(this).removeClass('selected'); 
               });
              $('#' + tab).addClass('selected');
         }
         
         function changeLocale(){
             var locale = $('#changeLocale').val();
             $.get("<s:url value='/local/change.json'/>", {"locale" : locale}, function(){
                window.location.reload(); 
             });
         }
    </script>
</div>
