<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html><head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/manage_files/style.css"/>
<script type="text/javascript">
 	var VAR_MODULE = "m";
	var VAR_ACTION = "a";
	var MODULE_NAME	=	'DealCate';
	var ACTION_NAME	=	'index';
	var ROOT = '/m.php';
	var ROOT_PATH = '';
	var CURRENT_URL = '/m.php?m=DealCate&a=index&';
	var INPUT_KEY_PLEASE = "INPUT_KEY_PLEASE";
	var TMPL = '/admin/Tpl/default/';
	var APP_ROOT = '';
</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/jquery_002.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/lang.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage_files/kindeditor.js"></script>
</head>
<body>
<div id="info"></div>

<div class="main">
<div class="main_title">分类列表</div>
<div class="blank5"></div>
<div class="button_row">
	<input class="button" value="新增" onclick="add();" type="button"/>
	<input class="button" value="删除" onclick="foreverdel();" type="button"/>
</div>
<div class="blank5"></div>
<!-- Think 系统列表组件开始 -->
<table id="dataTable" class="dataTable" cellpadding="0" cellspacing="0"><tbody><tr><td colspan="5" class="topTd">&nbsp; </td></tr><tr class="row"><th width="8"><input id="check" onclick="CheckAll('dataTable')" type="checkbox"></th><th width="50px"><a href="javascript:sortBy('id','1','DealCate','index')" title="按照编号升序排列 ">编号<img src="<%=request.getContextPath() %>/manage_files/desc.gif" align="absmiddle" border="0" height="17" width="12"></a></th><th><a href="javascript:sortBy('name','1','DealCate','index')" title="按照分类名称升序排列 ">分类名称</a></th><th><a href="javascript:sortBy('sort','1','DealCate','index')" title="按照排序升序排列 ">排序</a></th><th>操作</th></tr><tr class="row"><td><input name="key" class="key" value="11" type="checkbox"></td><td>&nbsp;11</td><td>&nbsp;<a href="javascript:edit('11')">123</a></td><td>&nbsp;<span class="sort_span" onclick="set_sort(11,11,this);">11</span></td><td><a href="javascript:edit('11')">编辑</a>&nbsp;<a href="javascript:%20foreverdel('11')">删除</a>&nbsp;</td></tr><tr class="row"><td><input name="key" class="key" value="10" type="checkbox"></td><td>&nbsp;10</td><td>&nbsp;<a href="javascript:edit('10')">其他</a></td><td>&nbsp;<span class="sort_span" onclick="set_sort(10,10,this);">10</span></td><td><a href="javascript:edit('10')">编辑</a>&nbsp;<a href="javascript:%20foreverdel('10')">删除</a>&nbsp;</td></tr><tr class="row"><td><input name="key" class="key" value="9" type="checkbox"></td><td>&nbsp;9</td><td>&nbsp;<a href="javascript:edit('9')">旅行</a></td><td>&nbsp;<span class="sort_span" onclick="set_sort(9,9,this);">9</span></td><td><a href="javascript:edit('9')">编辑</a>&nbsp;<a href="javascript:%20foreverdel('9')">删除</a>&nbsp;</td></tr><tr class="row"><td><input name="key" class="key" value="8" type="checkbox"></td><td>&nbsp;8</td><td>&nbsp;<a href="javascript:edit('8')">游戏</a></td><td>&nbsp;<span class="sort_span" onclick="set_sort(8,8,this);">8</span></td><td><a href="javascript:edit('8')">编辑</a>&nbsp;<a href="javascript:%20foreverdel('8')">删除</a>&nbsp;</td></tr><tr class="row"><td><input name="key" class="key" value="7" type="checkbox"></td><td>&nbsp;7</td><td>&nbsp;<a href="javascript:edit('7')">活动</a></td><td>&nbsp;<span class="sort_span" onclick="set_sort(7,7,this);">7</span></td><td><a href="javascript:edit('7')">编辑</a>&nbsp;<a href="javascript:%20foreverdel('7')">删除</a>&nbsp;</td></tr><tr class="row"><td><input name="key" class="key" value="6" type="checkbox"></td><td>&nbsp;6</td><td>&nbsp;<a href="javascript:edit('6')">出版</a></td><td>&nbsp;<span class="sort_span" onclick="set_sort(6,6,this);">6</span></td><td><a href="javascript:edit('6')">编辑</a>&nbsp;<a href="javascript:%20foreverdel('6')">删除</a>&nbsp;</td></tr><tr class="row"><td><input name="key" class="key" value="5" type="checkbox"></td><td>&nbsp;5</td><td>&nbsp;<a href="javascript:edit('5')">音乐</a></td><td>&nbsp;<span class="sort_span" onclick="set_sort(5,5,this);">5</span></td><td><a href="javascript:edit('5')">编辑</a>&nbsp;<a href="javascript:%20foreverdel('5')">删除</a>&nbsp;</td></tr><tr class="row"><td><input name="key" class="key" value="4" type="checkbox"></td><td>&nbsp;4</td><td>&nbsp;<a href="javascript:edit('4')">摄影</a></td><td>&nbsp;<span class="sort_span" onclick="set_sort(4,4,this);">4</span></td><td><a href="javascript:edit('4')">编辑</a>&nbsp;<a href="javascript:%20foreverdel('4')">删除</a>&nbsp;</td></tr><tr class="row"><td><input name="key" class="key" value="3" type="checkbox"></td><td>&nbsp;3</td><td>&nbsp;<a href="javascript:edit('3')">影视</a></td><td>&nbsp;<span class="sort_span" onclick="set_sort(3,3,this);">3</span></td><td><a href="javascript:edit('3')">编辑</a>&nbsp;<a href="javascript:%20foreverdel('3')">删除</a>&nbsp;</td></tr><tr class="row"><td><input name="key" class="key" value="2" type="checkbox"></td><td>&nbsp;2</td><td>&nbsp;<a href="javascript:edit('2')">科技</a></td><td>&nbsp;<span class="sort_span" onclick="set_sort(2,2,this);">2</span></td><td><a href="javascript:edit('2')">编辑</a>&nbsp;<a href="javascript:%20foreverdel('2')">删除</a>&nbsp;</td></tr><tr class="row"><td><input name="key" class="key" value="1" type="checkbox"></td><td>&nbsp;1</td><td>&nbsp;<a href="javascript:edit('1')">设计</a></td><td>&nbsp;<span class="sort_span" onclick="set_sort(1,1,this);">1</span></td><td><a href="javascript:edit('1')">编辑</a>&nbsp;<a href="javascript:%20foreverdel('1')">删除</a>&nbsp;</td></tr><tr><td colspan="5" class="bottomTd"> &nbsp;</td></tr></tbody></table>
<!-- Think 系统列表组件结束 -->
 

<div class="blank5"></div>
<div class="page"> 11 条记录 1/1 页          </div>
</div>

</body></html>