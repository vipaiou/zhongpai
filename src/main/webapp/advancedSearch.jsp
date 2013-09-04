<%@ page pageEncoding="utf-8"%>
<%@page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>M&amp;M 媒体管理系统</title>
<base href="<%=basePath%>"/>
<link href="../css/import.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../css/alerts/jquery.alerts.css" />
<link rel="stylesheet" type="text/css" href="../css/jqueryui/jquery-ui-1.7.2.custom.css"/>	
<script type="text/javascript" src="../js/common/tabColor.js"></script>
<script type="text/javascript" src="../js/Dialog/Dialog.js"></script>
<script type="text/javascript" src="../js/jquery/jquery-1.3.2.min.js"> </script>
<script type="text/javascript" src="../js/alerts/jquery.alerts.js"></script>
<script type="text/javascript" src="../js/jqueryui/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript" src="../js/json/jquery.json-2.2.min.js"></script>
<style>
th,td {
    padding:2px 4px;
    border:1px solid #a2c0cb;
    border-collapse:collapse;
    overflow:hidden;
    white-space:nowrap; 
}
</style>
<script>
$(document).ready(function(){
	initial(0);
	$(".filter").hide();
	$("#filterBtn").click(function(){
		if($("#usageDiv").css("display") == "none"){
			$(".filter").show();
		}else{
			$(".filter").hide();
		}
	});
	
	$("#sButton").click(function(){
		search();
	});
	$(".All").click(function(){
		checkSiblings(this);
	});
	
	$(".group").click(function(){
		if($(this).attr("checked")){
            var checked = true;
            $("input[class='group']",$(this).parent()).each(function(){
                if(!$(this).attr("checked")) checked=false;
            });
            $(".All",$(this).parent()).attr("checked",checked);
        }else{
            $(".All",$(this).parent()).attr("checked",false); 
        }
	});
	
	$(".one").click(function(){
        checkOne(this);
    });
	
	//type
	$("#web,#nonAtom,#atom").click(function(){
		if($("#web").attr("checked") || $("#nonAtom").attr("checked") || $("#atom").attr("checked")){
			$("#nonAdPositionDiv").show();
		}else{
			$("#nonAdPositionDiv").hide();
		}
	});
	$("#adPosition").click(function(){
        showChooseResult($(this),$("#adPositionDiv"));
    });
	$("#spID").click(function(){
        showChooseResult($(this),$("#spIDDiv"));
    });
	$("#apID").click(function(){
        showChooseResult($(this),$("#apIDDiv"));
    });
	$("#campaign").click(function(){
        showChooseResult($(this),$("#campaignDiv"));
    });
	
	//scope
	$(".scope").click(function(){
		$("#chooseMedia").val("");
		checkOne(this);
	});
	$("#chooseMedia").click(function(){
		var dialog = new Dialog("selectMedia");
        dialog.ShowButtonRow = false;
        dialog.Width = 800;
        dialog.Height = 480;
        dialog.Title = "选择媒体来源";
        dialog.URL="/advancedSearch/selectMedia.jsp?ids="+$("#mediaIds").val()+"&idAndNames="+$("#idAndNames").val();
        dialog.show();
	});
	
	if('${scope}'){
		$("#currentAndChildren").attr("disabled",false);
		$("#current").attr("disabled",false);
		$("#global").attr("checked",false);
        $("#current").attr("checked",false);
        $("#currentAndChildren").attr("checked",true);
	}
	
	$("#userNames").click(function(){
		var dialog = new Dialog("selectUser");
        dialog.ShowButtonRow = false;
        dialog.Width = 800;
        dialog.Height = 480;
        dialog.Title = "选择修改用户";
        dialog.URL="/user/selectMultipleUser.jsp?userIds="+$("#userIds").val()+"&userNames="+$("#userNames").val();
        dialog.show();
	});
	
	$("#materialTypes").click(function(){
        var dialog = new Dialog("selectMaterialType");
        dialog.ShowButtonRow = false;
        dialog.Width = 750;
        dialog.Height = 230;
        dialog.Title = "选择物料类型";
        dialog.URL="/material.do?method=select&materialTypeIds";
        dialog.show();
    });
	
	//campaignTime
	var dates = $('#campaignStartTime, #campaignEndTime').datepicker({
        changeMonth : true,
        changeYear : true,
        showOtherMonths : true,
        selectOtherMonths : true,
        dateFormat : 'yy-mm-dd',
        numberOfMonths : 1, //显示的月数
        onSelect : function(selectedDate) {
            var option = this.id == "campaignStartTime" ? "minDate": "maxDate";
            var instance = $(this).data("datepicker");
            var date = $.datepicker.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat,selectedDate, instance.settings);
            dates.not(this).datepicker("option", option, date);
        }
    });
 	$("#ui-datepicker-div").hide();
});

//点击加号 增加搜索条件
function addLine(img){
	var row = img.parentNode;
	var cloneRow = $(row).clone();
	if( $("#logic",cloneRow).length <= 0){
	   cloneRow.prepend("<select style='width:56' id='logic'>"
                                + "<option value='and'>与</option>"
                                + "<option value='or'>或</option>"
                                + "</select>");
	}
	$("#keyStr",cloneRow).val("");
	$("#minus",cloneRow).click(function(){
		deleteLine(this);
	});
	$(row).after(cloneRow);
}

//点击减号 删除搜索条件
function deleteLine(img){
	var row = img.parentNode;
	$(row).remove();
}

function checkSiblings(obj){
    if($(obj).attr("checked")){
        $("input[type='checkbox']",obj.parentNode).each(function(){
            $(this).attr("checked",true);
        });
    }else{
        $("input[type='checkbox']",obj.parentNode).each(function(){
            $(this).attr("checked",false);
        });
    }
}

function checkOne(obj){
	if($(obj).attr("checked")){
		$(obj).siblings().attr("checked",false);
    }
}

/*
 * 根据checkbox 选择展示div
 * @param {Object} checkbox
 * @param {Object} div
 */
function showChooseResult(checkbox,div){
	if( checkbox.attr("checked") ){
		div.show();
	}else{
		div.hide();
	}
}
 
 function search(){
	 //type
	 $("#type").val( getGroupCheck($("#typeDiv")) );
	 
	 //scope
	 if($("#chooseMedia").val()){
		 $("#mediaIds").val($("#chooseMedia").val());
	 }
	 
	 //condition
	 var condition = {};
	 var conditionList = new Array();
	 $("div[id='conditionDiv']").each(function(){
		 var subcondition = {};
		 if( $("#logic",this).val() ){
			 subcondition.logic = $("#logic",this).val();
		 }
		 subcondition.field = $("#field",this).val();
		 subcondition.match = $("#match",this).val();
		 subcondition.keyStr = $("#keyStr",this).val();
		 if(subcondition.keyStr){
		     conditionList.push(subcondition);
		 }
	 });
	 if(conditionList.length > 0){
	     condition.conditionList = conditionList;
	     $("#condition").val($.toJSON(condition));
	 }
	 
	 //usege
	 $("#usage").val( getGroupCheck2($("#usageDiv")) );
	 
	 //urlRuleTypes;
	 $("#urlRuleTypes").val(getGroupCheck2($("#urlRuleTypesDiv")));
	 	 
	 //expressionType
     $("#expressionTypeIds").val( getGroupCheck2($("#expressionTypeDiv")) );
	 
	 //priceUnit
	 $("#priceUnit").val( getGroupCheck2($("#priceUnitDiv")) );

	 //areaSizeWidthCondition
	 var areaSizeWidthCondition = {};
	 var areaSizeWidthConditionList = new Array();
     $("span[id='areaSizeWidthConditionSpan']",$("#areaSizeWidthDiv")).each(function(){
         var subcondition = {};
         if( $("#logic",this).val() ){
             subcondition.logic += $("#logic",this).val();
         }
         subcondition.field = "areaSizeWidth";
         subcondition.match = $("#match",this).val();
         subcondition.keyStr = $("#keyStr",this).val(); 
         if(subcondition.keyStr){
             areaSizeWidthConditionList.push(subcondition);
         }
     });
     if(areaSizeWidthConditionList.length > 0){
        areaSizeWidthCondition.areaSizeWidthConditionList = areaSizeWidthConditionList;
        $("#areaSizeWidthCondition").val($.toJSON(areaSizeWidthCondition));
     }
     
     //areaSizeHeightCondition
     var areaSizeHeightCondition = {};
     var areaSizeHeightConditionList = new Array();
     $("span[id='areaSizeHeightConditionSpan']",$("#areaSizeHeightDiv")).each(function(){
         var subcondition = {};
         if( $("#logic",this).val() ){
             subcondition.logic += $("#logic",this).val();
         }
         subcondition.field = "areaSizeHeight";
         subcondition.match = $("#match",this).val();
         subcondition.keyStr = $("#keyStr",this).val(); 
         if(subcondition.keyStr){
             areaSizeHeightConditionList.push(subcondition);
         }
     });
     if(areaSizeHeightConditionList.length > 0){
        areaSizeHeightCondition.areaSizeHeightConditionList = areaSizeHeightConditionList;
        $("#areaSizeHeightCondition").val($.toJSON(areaSizeHeightCondition));
     }
	 
     //fileSizeCondition
     var fileSizeCondition = {};
     var fileSizeConditionList = new Array();
     $("span[id='fileSizeConditionSpan']",$("#fileSizeDiv")).each(function(){
         var subcondition = {};
         if( $("#logic",this).val() ){
             subcondition.logic += $("#logic",this).val();
         }
         subcondition.field = "maxFileSize";
         subcondition.match = $("#match",this).val();
         subcondition.keyStr = $("#keyStr",this).val(); 
         if(subcondition.keyStr){
             fileSizeConditionList.push(subcondition);
         }
     });
     if(fileSizeConditionList.length > 0){
        fileSizeCondition.fileSizeConditionList = fileSizeConditionList;
        $("#fileSizeCondition").val($.toJSON(fileSizeCondition));
     }
     
     //priceCondition
     var priceCondition = {};
     var priceConditionList = new Array();
     $("span[id='priceConditionSpan']",$("#priceDiv")).each(function(){
         var subcondition = {};
         if( $("#logic",this).val() ){
             subcondition.logic += $("#logic",this).val();
         }
         subcondition.field = "price";
         subcondition.match = $("#match",this).val();
         subcondition.keyStr = $("#keyStr",this).val(); 
         if(subcondition.keyStr){
             priceConditionList.push(subcondition);
         }
     });
     if(priceConditionList.length > 0){
        priceCondition.priceConditionList = priceConditionList;
        $("#priceCondition").val($.toJSON(priceCondition));
     }
     
     //pvCondition
     var pvCondition = {};
     var pvConditionList = new Array();
     $("span[id='pvConditionSpan']",$("#pvDiv")).each(function(){
         var subcondition = {};
         if( $("#logic",this).val() ){
             subcondition.logic += $("#logic",this).val();
         }
         subcondition.field = "LastWeekMonitorPvData";
         subcondition.match = $("#match",this).val();
         subcondition.keyStr = $("#keyStr",this).val(); 
         if(subcondition.keyStr){
             pvConditionList.push(subcondition);
         }
     });
     if(pvConditionList.length > 0){
        pvCondition.pvConditionList = pvConditionList;
        $("#pvCondition").val($.toJSON(pvCondition));
	 }
     
	 //nonAdPosition
     $("#nonAdPositionColumns").val( getGroupCheck($("#nonAdPositionDiv")) );
	 
	 //adPosition
     $("#adPositionColumns").val( getGroupCheck($("#adPositionDiv")) );
	 
	 //spID
     $("#spIDColumns").val( getGroupCheck($("#spIDDiv")) );
	 
	 //apID
	 $("#apIDColumns").val( getGroupCheck($("#apIDDiv")) );
	 
	 //campaign
	 $("#campaignColumns").val( getGroupCheck($("#campaignDiv")) );
	 
	 $("#searchForm").submit();
 }
 
 /**
  * 获取一个div中被check中的checkbox值，“全选”checkbox除外
  * @param {Object} div
  */
 function getGroupCheck(div){
	 var str = "";
     $("input[type='checkbox']",div).each(function(){
         if( $(this).attr("checked") && $(this).val() ){
             str += $(this).val() + ",";
         } 
     });
     if(str.indexOf(",") >= 0){
         str = str.substring(0,str.lastIndexOf(","));
     }
     return str;
 }
  
  /**
  * 获取一个div中被check中的checkbox值，“全选”checkbox除外
  * @param {Object} div
  */
 function getGroupCheck2(div){
     var str = "";
     if($("input[class='All']",div).attr("checked")){
         return str;
     }
     $("input[type='checkbox']",div).each(function(){
         if( $(this).attr("checked") && $(this).val() ){
             str += $(this).val() + ",";
         } 
     });
     if(str.indexOf(",") >= 0){
         str = str.substring(0,str.lastIndexOf(","));
     }
     return str;
 }
</script>
</head>
<body id="page">
		<div id="content_map">
			<div id="content_map_left"></div>
			<div id="content_map_center" style="padding-bottom: 4px">
				您现在所在的位置:
				<span  id="link">高级搜索-><span id='keyword_label' class="fontBlue">搜索页</span>
				</span>
			</div>
			<div id="content_map_right"></div>
		</div>
		<div id="tab">
			<form id="searchForm" action="/advancedSearch/searchResult.jsp" method="post">
			<div id="tab_content">
			     <table width="100%" border="0" cellspacing="0" cellpadding="0" id="tabColor0">
					<tr>
					<td width="11%">搜索内容：<input type="hidden" id="type" name="type"/></td>
					<td width="89%" id="typeDiv">
						&nbsp;&nbsp;<input type="checkbox" id="web" value="P"/>网站
						&nbsp;&nbsp;<input type="checkbox" id="nonAtom" value="N"/>非原子频道
						&nbsp;&nbsp;<input type="checkbox" id="atom" value="C"/>原子频道
						&nbsp;&nbsp;<input type="checkbox" id="adPosition" value="A"/>广告位
						&nbsp;&nbsp;<input type="checkbox" id="spID" value="spID"/>监测点
						&nbsp;&nbsp;<input type="checkbox" id="apID" value="apID"/>周边广告位
						&nbsp;&nbsp;<input type="checkbox" id="campaign" value="campaign"/>广告活动
					</td>
					</tr>
				     <tr>
				     <td>搜索范围：</td>
					 <td id="scopeDiv">
						&nbsp;&nbsp;<input type="radio" name="scope" class="scope" id="current" disabled value="current"/>当前媒体
						&nbsp;&nbsp;<input type="radio" name="scope" class="scope" id="global" checked value="global"/>全局媒体
						&nbsp;&nbsp;<input type="radio" name="scope" class="scope" id="currentAndChildren" disabled value="currentAndChildren"/>当前媒体及子媒体
						&nbsp;&nbsp;&nbsp;指定媒体<input id="chooseMedia" type="text" readonly/>
						<input type="hidden" id="mediaIds" name="mediaIds" value="${mediaIds}"/>
						<input type="hidden" id="idAndNames" name="idAndNames"/>
					 </td>
					 </tr>
					 <tr>  
				     <td>搜索条件：<input type="hidden" id="condition" name="condition"/></td>
					 <td>	
		             	 <div id="conditionDiv">
		             	 		<select id="field">
		                    		<option value="mediaName">媒体名称</option>
		                    		<option value="mediaID">ID</option>
		                    		<option value="domain">URL</option>
		                    		<option value="classIds">分类ID</option>
		                    		<option value="className">分类</option>
		                    		<option value="spID">spID</option>
		                    		<option value="apID">apID</option>
		                    		<option value="campaignID">广告活动ID</option>
		                  		</select>
		                    	<select id="match">
		                      		<option value="equal">符合</option>
		                      		<option value="notEqual">不符合</option>	             
		                    	 </select>
		                    	<input id="keyStr" type="text"/>
		                  		<img id="minus"  width="9" height="9" src="../css/pic/minus.gif" style="cursor: pointer;"/>
		                  		<img id="add"  width="9" height="9" onclick="addLine(this)"  src="../css/pic/plus.gif" style="cursor: pointer;"/>
					      </div>
					 </td>
					 </tr>
				       <tr>
				       <th colspan="2">
						筛选条件：<img align="center" id="filterBtn" width="19" height="21" src="../css/pic/upArrow.gif"></img>
					   </th>
					   </tr>
				<!-- <div id="tabColor1" style="display:none;"> -->
					    <tr id="usageDiv" class="filter">
					    <td>
					    用途<input type="hidden" id="usage" name="usage"/>
					    </td>
					    <td>
						<input type="checkbox" class="All" value="" checked/>全选
						<input type="checkbox" class="group" value="P" checked/>planner使用
						<input type="checkbox" class="group" value="R" checked/>研发使用
						<input type="checkbox" class="group" value="M" checked/>monitor使用 
						</td>
						</tr>
						<tr id="statusDiv" class="filter">
						<td>状态</td> 
						<td>
						<input type="radio" class="one" name="status" value="" checked/>全部
						<input type="radio" class="one" name="status" value="0"/>停用 
						<input type="radio" class="one" name="status" value="1"/>活动
						</td>
						</tr>
						<tr class="filter">
						<td>有无监测点</td> 
						<td><input type="radio" class="one" name="hasSpots" value="" checked/>全部
						<input type="radio" class="one" name="hasSpots" value="yes"/>有 
						<input type="radio" class="one" name="hasSpots" value="no"/>无
						</td>
						</tr>
						<tr class="filter">
						<td>有无周边广告位</td>
						<td> 
						<input type="radio" class="one" name="hasAdposition" value="" checked/>全部
						<input type="radio" class="one" name="hasAdposition" value="yes"/>有 
						<input type="radio" class="one" name="hasAdposition" value="no"/>无
						</td>
						</tr>
						<tr class="filter"><td>有无分类</td> 
						<td>
						<input type="radio" class="one" name="hasClassIds" value="" checked/>全部
						<input type="radio" class="one" name="hasClassIds" value="yes"/>有 
						<input type="radio" class="one" name="hasClassIds" value="no"/>无
						</td>
						</tr>
						<tr class="filter"><td>是否为叶子节点</td>
						<td> 
                        <input type="radio" class="one" name="isLeafNode" value="" checked/>全部
                        <input type="radio" class="one" name="isLeafNode" value="yes"/>是 
                        <input type="radio" class="one" name="isLeafNode" value="no"/>否
                        </td>
                        </tr>
						<!--  <div style="padding-top: 10px;">有无媒体 
						&nbsp;&nbsp;<input type="radio" class="one" name="hasMedia" value="" checked/>全部
						&nbsp;&nbsp;<input type="radio" class="one" name="hasMedia" value="yes"/>有 
						&nbsp;&nbsp;<input type="radio" class="one" name="hasMedia" value="no"/>无
					 　  </div>-->
					    <tr class="filter"><td>有无规则</td>
						<td><input type="radio" class="one" name="hasRule" value="" checked/>全部
						<input type="radio" class="one" name="hasRule" value="yes"/>有 
						<input type="radio" class="one" name="hasRule" value="no"/>无
					 	</td>
					 	</tr>
					 	<tr class="filter"><td>有无媒体组合关联</td>
						<td><input type="radio" class="one" name="hasMediaGroupID" value="" checked/>全部
						<input type="radio" class="one" name="hasMediaGroupID" value="yes"/>有 
						<input type="radio" class="one" name="hasMediaGroupID" value="no"/>无
						</td>
						</tr>
						<tr class="filter"><td>监测时间</td>
						<td>
						<input type="radio" class="one" name="monitorDate" value="" checked/>全部
						<input type="radio" class="one" name="monitorDate" value="inWeek"/>一周内 
						<input type="radio" class="one" name="monitorDate" value="inMonth"/>一月内
					    <input type="radio" class="one" name="monitorDate" value="inHalfYear"/>半年内
						<input type="radio" class="one" name="monitorDate" value="beforeHalfYear"/>半年前 
						</td>
						</tr>
						<tr class="filter"><td>修改时间</td>
						<td><input type="radio" class="one" name="updateDate" value="" checked/>全部
						<input type="radio" class="one" name="updateDate" value="inWeek"/>一周内 
						<input type="radio" class="one" name="updateDate" value="inMonth"/>一月内
					    <input type="radio" class="one" name="updateDate" value="inHalfYear"/>半年内
						<input type="radio" class="one" name="updateDate" value="beforeHalfYear"/>半年前 
						</td>
						</tr>
						<tr class="filter"><td>修改用户
						<input type="hidden" id="userIds" name="userIds"/>
						</td>
						<td>
						<input type="checkbox" id="selectAllUser" value="" checked/>所有用户
						<input type="text" id="userNames" name="userNames"/>
			      	    </td>
			      	    </tr>
			      	    <tr id="materialTypeDiv" class="filter">
			      	    <td>物料类型 </td>
			      	    <td><input id="materialTypes" size="40" type="text" readonly />
                        <input id="materialTypeIds" name="materialTypeIds" type="hidden" />
				   	    </td>
				   	    </tr>
				   	    <tr id="urlRuleTypesDiv" class="filter">
				   	    <td>URL规则类型<input id="urlRuleTypes" name="urlRuleTypes" type="hidden"/></td>
				   	    <td>
				   	    <input type="checkbox" class="All" value="" checked/>全选
                        <input type="checkbox" class="group" value="2" checked/>域名&nbsp;&nbsp;
                        <input type="checkbox" class="group" value="1" checked/>协议&nbsp;&nbsp;
                        <input type="checkbox" class="group" value="3" checked/>端口&nbsp;&nbsp; 
                        <input type="checkbox" class="group" value="4" checked/>路径&nbsp;&nbsp; 
                        <input type="checkbox" class="group" value="5" checked/>锚&nbsp;&nbsp; 
                        <input type="checkbox" class="group" value="6" checked/>参数字符串&nbsp;&nbsp; 
                        <input type="checkbox" class="group" value="7" checked/>参数选项&nbsp;&nbsp; 
                        <input type="checkbox" class="group" value="8" checked/>内容 
				   	    </td>
				   	    </tr>
				   	    <tr id="expressionTypeDiv" class="filter">
				   	    <td>展现形式<input id="expressionTypeIds" name="expressionTypeIds" type="hidden"/></td>
				   	    <td><input type="checkbox" class="All" value="" checked/>全选&nbsp;&nbsp;
				   	          <%int expressionTypeCount =1; %>
				   	          <logic:iterate name="allExpressionTypes" id="eType">
				   	          <input type="checkbox" class="group" value="${eType.id}" checked/><bean:write name="eType" property="name"/>&nbsp;&nbsp;
                              <%expressionTypeCount++; 
                                if(expressionTypeCount>11){
                                    out.print("</br>");
                                    expressionTypeCount = 0;
                                } 
                              %>
                              </logic:iterate>
                        </td>
						</tr>
						<tr id="priceUnitDiv" class="filter">
						<td>价格单位<input id="priceUnit" name="priceUnit" type="hidden"/></td>
						<td>
						<input type="checkbox" class="All" value="" checked/>全选
						<input type="checkbox" class="group" value="/perDay" checked/>￥/天
  					    <input type="checkbox" class="group" value="/perHour" checked/>￥/时段
						<input type="checkbox" class="group" value="/perWeek" checked/>￥/周
						<input type="checkbox" class="group" value="/perMonth" checked/>￥/月
						<input type="checkbox" class="group" value="/perYear" checked/>￥/年
						<input type="checkbox" class="group" value="/cpm" checked/>￥/CPM
						</td>
						</tr>
						<tr id="campaignTimeDiv" class="filter">
						<td>广告活动投放时间</td>
						<td>
						开始时间<input type="text" size="20" id="campaignStartTime" name="campaignStartTime" readonly="readonly"/>
  						&nbsp;&nbsp;结束时间
  						<input type="text" size="20" id="campaignEndTime" name="campaignEndTime" readonly="readonly"/>
						</td>
						</tr>
						<tr id="areaSizeWidthDiv" class="filter">
						<td>尺寸宽<input id="areaSizeWidthCondition"  name="areaSizeWidthCondition" type="hidden" value=""/></td>
						<td>
						   <span id="areaSizeWidthConditionSpan">
                                <select id="match" style="width:40px;">
                                    <option value="=">=</option>
                                    <option value="&lt">&lt</option>
                                    <option value="&gt">&gt</option>
                                 </select>
                                <input id="keyStr" type="text"/>
                                <img id="minus"  width="9" height="9" src="../css/pic/minus.gif" style="cursor: pointer;"/>
                                <img id="add"  width="9" height="9" onclick="addLine(this)"  src="../css/pic/plus.gif" style="cursor: pointer;"/>
                                <br/>
                            </span>
                        </td>
                        </tr>
                        <tr id="areaSizeHeightDiv" class="filter">
                        <td>尺寸高<input id="areaSizeHeightCondition"  name="areaSizeHeightCondition" type="hidden" value=""/></td>
                        <td>
                           <span id="areaSizeHeightConditionSpan">
                                <select id="match" style="width:40px;">
                                    <option value="=">=</option>
                                    <option value="&lt">&lt</option>
                                    <option value="&gt">&gt</option>
                                 </select>
                                <input id="keyStr" type="text"/>
                                <img id="minus"  width="9" height="9" src="../css/pic/minus.gif" style="cursor: pointer;"/>
                                <img id="add"  width="9" height="9" onclick="addLine(this)"  src="../css/pic/plus.gif" style="cursor: pointer;"/>
                                <br/>
                            </span>
                        </td>
                        </tr>
                        <tr id="fileSizeDiv" class="filter">
                        <td>文件大小<input id="fileSizeCondition"  name="fileSizeCondition" type="hidden" value=""/></td>
                        <td><span id="fileSizeConditionSpan">
                                <select id="match" style="width:40px;">
                                    <option value="=">=</option>
                                    <option value="&lt">&lt</option>
                                    <option value="&gt">&gt</option>
                                 </select>
                                <input id="keyStr" type="text"/>
                                <img id="minus"  width="9" height="9" src="../css/pic/minus.gif" style="cursor: pointer;"/>
                                <img id="add"  width="9" height="9" onclick="addLine(this)"  src="../css/pic/plus.gif" style="cursor: pointer;"/>
                                <br/>
                            </span>
                        </td>
                        </tr>
                        <tr id="priceDiv" class="filter">
                        <td>价格<input id="priceCondition"  name="priceCondition" type="hidden" value=""/></td>
                        <td><span id="priceConditionSpan">
                                <select id="match" style="width:40px;">
                                    <option value="=">=</option>
                                    <option value="&lt">&lt</option>
                                    <option value="&gt">&gt</option>
                                 </select>
                                <input id="keyStr" type="text"/>
                                <img id="minus"  width="9" height="9" src="../css/pic/minus.gif" style="cursor: pointer;"/>
                                <img id="add"  width="9" height="9" onclick="addLine(this)"  src="../css/pic/plus.gif" style="cursor: pointer;"/>
                                <br/>
                            </span>
                        </td>
                        </tr>
                        <tr id="pvDiv" class="filter">
                        <td>pv量<input id="pvCondition"  name="pvCondition" type="hidden" value=""/></td>
                        <td><span id="pvConditionSpan">
                                <select id="match" style="width:40px;">
                                    <option value="=">=</option>
                                    <option value="&lt">&lt</option>
                                    <option value="&gt">&gt</option>
                                 </select>
                                <input id="keyStr" type="text"/>
                                <img id="minus"  width="9" height="9" src="../css/pic/minus.gif" style="cursor: pointer;"/>
                                <img id="add"  width="9" height="9" onclick="addLine(this)"  src="../css/pic/plus.gif" style="cursor: pointer;"/>
                                <br/>
                            </span>
                        </td>
                        </tr>
					<tr>
					   <td>显示结果项：</td><td></td>
					</tr>
					<tr id="nonAdPositionDiv" style="display:none;">
					       <td></td>
					       <td>
					       <input id="nonAdPositionColumns" name="nonAdPositionColumns" type="hidden"/>
					       <input class="All" type="checkbox" value=""/>全部  
					       &nbsp;&nbsp;<input type="checkbox" class="group" value="mediaId" checked/>ID
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="mediaName" checked/>名称
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="domain" checked/>url
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="useage" checked/>用途
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="status"/>状态 
                           <!-- &nbsp;&nbsp;<input type="checkbox" value="mediaCount"/>媒体数量
                           &nbsp;&nbsp;<input type="checkbox" value="adPositionCount"/>广告位数量-->
                           
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="matchedSpotsNum"/>匹配监测点次数
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="hasRule"/>有无规则
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="classIds"/>分类ID
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="className"/>分类                           
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="lastMonitorPvDate"/>最近监测PV时间
                           <br/>
                           <input type="checkbox" class="group" value="lastWeekMonitorPvData"/>最近一星期PV量                 
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="updateDate"/>修改时间
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="updateUser"/>修改用户
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="parentName"/>所属媒体
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="parentClass"/>所属媒体分类
                           </td>
					   </tr>
					   <tr id="adPositionDiv" style="display:none;">
					       <td></td>
					       <td>
					       <input id="adPositionColumns" name="adPositionColumns" type="hidden"/>
					       <input class="All" type="checkbox" value=""/>全部  
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="mediaId" checked/>ID
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="mediaName" checked/>名称
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="useage" checked/>用途
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="status" checked/>状态
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="matchedSpotsNum"/>匹配监测点次数 
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="updateDate"/>修改时间
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="updateUser"/>修改用户
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="parentWeb"/>所属网站
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="materialType"/>物料类型
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="expressionType"/>展现形式
                           <br/><input type="checkbox" class="group" value="areaSizeWidth"/>尺寸宽
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="areaSizeHeight"/>尺寸高
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="maxFileSize"/>文件大小
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="price"/>价格
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="priceUnit"/>价格单位
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="mediaGroupId"/>媒体组合关联ID
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="channelPath"/>所属媒体路径
					       </td>
					   </tr>
					   <tr id="spIDDiv" style="display:none;">
					       <td></td>
					       <td>
					       <input id="spIDColumns" name="spIDColumns" type="hidden"/>
					       <input class="All" type="checkbox" value=""/>全部  
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="spID" checked/>spID
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="spotsName" checked/>名称
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="mCampaignID" checked/>广告活动ID
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="mCampaignName" checked/>广告活动名称
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="mediaId" checked/>广告位ID
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="AdPositionDisplayName" checked/>广告位名称 
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="parentWeb" checked/>所属网站
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="updateDate" checked/>匹配时间
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="updateUser"/>匹配用户
                           <br/><input type="checkbox" class="group" value="spots_plan_startTime_min"/>监测点投放开始时间
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="spots_plan_startTime_max"/>监测点投放结束时间
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="mCampaign_startTime"/>广告活动投放开始时间
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="mCampaign_endTime"/>广告活动投放结束时间
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="AreaSize"/>监测点尺寸
                           <br/><input type="checkbox" class="group" value="MaxFileSize"/>监测点大小
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="areaSizeWidth"/>广告位尺寸宽
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="areaSizeHeight"/>广告位尺寸高
                           <td>
					   </tr>
					   <tr id="apIDDiv" style="display:none;">
					       <td></td>
					       <td>
					       <input id="apIDColumns" name="apIDColumns" type="hidden"/>
					       <input class="All" type="checkbox" value=""/>全部 
                           <input type="checkbox" class="group" value="apID" checked/>apID
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="pediaName" checked/>名称
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="organizationId" checked/>客户ID
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="organizationName" checked/>客户名称
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="productName" checked/>来源
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="mediaId" checked/>广告位ID
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="adPositionName" checked/>广告位名称
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="parentWeb" checked/>所属网站
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="matchingDate" checked/>匹配时间
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="matchingUser"/>匹配用户
                           <br/>
                           <!-- todo_zl -->
                           <input type="checkbox" class="group" value="AreaSize"/>广告位尺寸
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="MaxFileSize"/>广告位大小
					       </td>
					   </tr>
					   <tr id="campaignDiv" style="display:none;">
					       <td></td>
					       <td>
					       <input id="campaignColumns" name="campaignColumns" type="hidden"/>
					       <input class="All" type="checkbox" value="" checked/>全部 
                           <input type="checkbox" class="group" value="mCampaignId" checked/>广告活动ID
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="mCampaignName" checked/>广告活动名称
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="startTime" checked/>广告活动投放开始时间
                           &nbsp;&nbsp;<input type="checkbox" class="group" value="endTime" checked/>广告活动投放结束时间
					       </td>
					 </tr>
		        </table>
			    <div class="pageBack">
					<input id="sButton" class="bt" type="button" value="搜索"/>
					<input class="bt" type="reset" value="重置"/>
				</div>
      </div>
      </form>
      </div>
      <div id="notice">
            <div id="notice_left"></div>
            <div id="notice_right"></div>
       </div>
    <script>
        goIndex(7);
    </script>
</body>
</html>
