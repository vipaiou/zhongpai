<%@page contentType="text/html; charset=utf-8" %>
<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
function loadTree(){
	d = new dTree('d');
   d.config.target = "mainFrame";
   d.config.useCheckBox=true;
   d.config.imageDir = '../css/dtree/img';
   d.reSetImagePath();
   d.config.folderLinks = true;
   d.config.closeSameLevel = false;
   d.config.check=true;//显示复选框
   d.config.mycheckboxName="ids";//设置<input type='checkbox' name="ids"/>name的属性根节点
	var isOpen;
	<c:forEach var="contentBean" items="${contentBeanList}" step="1">
		d.add('${contentBean.id }@${contentBean.id }','${contentBean.contentName }','${contentBean.unique }','${contentBean.path }');
	</c:forEach>
	 d.closeAll();
  	 document.write(d);
}