/**
 *   Field和运算符都是用数字表示，对应表如下：
  Field
    Protocol     = 1 	协议
    Host         = 2		域名
    Port         = 3		端口
    Path         = 4		路径
    Anchor       = 5		锚
    QueryString  = 6		参数内容
    QueryItem    = 7		参数名
    Content      = 8		内容
  运算符
    like         = 1 蓝色
    not like     = 2 红色
    reglike      = 3 黄色
    not reglike  = 4 紫色
 * 
 * 将精简的使用代号表示的规则表达式转化为有语法高亮的规则文本
 * "1","1","http","2","1","blog.sina*" 
 * ---> 协议<span class="blue">符合</span>http且域名<span class="blue">符合</span>blog.sina*
 */
 
 //用来保存需要update的规则
var updateRule = "";
var ruleModifying = false;
var currentRuleId = "";
var delRuleId="";
var testRule="";

function simpleRule2Text(simpleRule){
    var i=0;
    var ruleAttrs = getJLCSVFields(simpleRule);
    var retUrl="";
    var field=new Array();
    var oprator=new Array();
    field[2]="域名";field[1] = "协议"; field[3]="端口"; field[4]="路径";field[5]="锚"; field[6]="参数字符串";field[7]="参数选项";field[8]="内容";
    oprator[1] = "<span class='fontBlue'>符合</span>";    oprator[2] = "<span class='red'>不符合</span>";
    oprator[3] = "<span class='yellow'>正则匹配</span>"; oprator[4] = "<span class='purple'>正则不匹配</span>";
    while(i<ruleAttrs.length){
        if(i % 3==0){
            retUrl += field[ruleAttrs[i].trim("\"")];
        }else if(i % 3==1){
            retUrl += oprator[ruleAttrs[i].trim("\"")];
        }else{   
            retUrl += (HtmlEncode(ruleAttrs[i].trim(" "))+" 且 ");
        }
        i++;
    }
    if(retUrl.lastIndexOf(("且")) >= 0) 
    return retUrl.substring(0,retUrl.lastIndexOf("且"));
    else return retUrl;
}

//点击某条规则，回到编辑状态待修改
function editCurrentRule(currentSpan, ruleId){
	var currentRule = $("input[name='hidden']", $(currentSpan).parent()).val();	
	var ruleAttrs = getJLCSVFields(currentRule);
	var rowNum = ruleAttrs.length / 3;
	
	//生成编辑框
	var templateRow = $("#ruleAttr tr:first");
	$("#ruleAttr").html("<tr>" + templateRow.html() + "</tr>");
	var i = 0;
	while( i < rowNum - 1 ){
		$("#ruleAttr").append("<tr>" + templateRow.html() + "</tr>");
		i++;
	}
	var rows = $("#ruleAttr tr");
	var j = 1;
	while(j<rows.length){
		$("img:first", $(rows[j])).click(function(){
			deleteThisAttr(this);
		});
		j++;
	}

	//将当前要编辑的规则填入到编辑框中
	for(var k=0; k<rowNum; k++){
		selectOne = ruleAttrs[k * 3];
		selectTwo = ruleAttrs[k * 3 + 1];
		text = ruleAttrs[k * 3 + 2];
		$("select:first", $(rows[k])).attr("value", selectOne.substring(1,selectOne.length-1));
		$("select:first", $(rows[k])).selectedIndex = selectOne.substring(1,selectOne.length-1);
		showContain($("select:first", $(rows[k])));
		$("select:last", $(rows[k])).attr("value", selectTwo.substring(1,selectTwo.length-1));
		$("select:last", $(rows[k])).selectedIndex = selectTwo.substring(1,selectTwo.length-1);
		$("input", $(rows[k])).val(text.substring(0, text.length));
	}
	ruleModifying = true;
	
	//加入编辑标志
	$("#ruleList tr").each(function(){
		 if($(this).attr("name")=="edit") $(this).removeAttr("name");
	});
	$(currentSpan).parent().parent().attr("name", "edit");
	currentRuleId = ruleId;	
}

//显示所有规则 js取得所有rule数据,js往显示规则的表格中插入行.每条ruleId,rule;ruleId,rule;....
function showRuleList(ruleList, date, endDate, ruleVersion){
	if(!ruleList || ruleList==""){
		return ;
	}
	var rules = ruleList.split("##");
	var textRuleList ="";
	for(var i=0;i<rules.length;i++){
		insertRuleRow(rules[i], date, endDate, ruleVersion);
	}
}

function addChildrenMediaRule(mediaId, date, endDate, ruleVersion){
    var ctrl = getBusyOverlay("viewport", 
    {
        color: "black",
        opacity: 0.5,
        text: "正在添加子媒体规则，请等待...",
        style:'text-decoration:blink;font-weight:bold;font-size:12px;color:white'
    },{
        color:'#fff',
        size:64,
        type:'o'
    });
		var frontRules = "";
		$("#ruleList tr input[name='hidden']").each(function(){
		   frontRules += $(this).val()+"##";
		});	
		if(frontRules.indexOf("##") >= 0) frontRules = frontRules.substring(0,frontRules.lastIndexOf("##")); 
		$.ajax({
			url:"/urlMatch.do?method=chilrenMediaRuleList",
			type:"post",
			data:{
				"mediaId":mediaId,
			    "frontRules":frontRules,
			    "date":date,
			    "endDate":endDate,
			    "rule":ruleVersion
			},
			complete:function(data){
				if(data&&data!=null){
					var ruleList = data.responseText;
					if(!ruleList || ruleList==""){
						ctrl.remove();
						return ;
					}
					var rules = ruleList.split("##");
					/*
					if($("#ruleList tr:last") != null){
		 				var lastRule = $("#ruleList tr:last").html() +  "<td width=\"10%\">或者</td>";
		 				$("#ruleList tr:last").html(lastRule);
		 			}
					*/
					for(var i=0;i<rules.length;i++){
					    var id_rule = rules[i].split("@");
		 				var ruleId = id_rule[0];
		 				var rule = id_rule[1];
		 				var matchedUrlNum = id_rule[2];
		 				var realRuleId = id_rule[3];
						var textRule = simpleRule2Text(rule);
		 				textRule = "<tr style='background:lightYellow'><td style=\"border:1px solid #A2C0CB; \"><span style=\"cursor:pointer;\" onclick=\"editCurrentRule(this, " + ruleId + ");\" name = \"textRule\">" + textRule +
		  					"</span>&nbsp;&nbsp;&nbsp;" + "<input name=\"hidden\" type=\"hidden\"/>" + "<img style='cursor:pointer' src=\"../css/pic/del.gif\" width=\"10\" height=\"10\" onclick=deleteRuleRow(this,"+ruleId+") /></td>"+ 
		 					"<td style=\" border:1px solid #A2C0CB; \">" + matchedUrlNum + "</td>" +
            				"<td style=\" border:1px solid #A2C0CB; \"><a href=\"#\" onclick='Dialog.fastShow(\"randomUrlList\",\"/urlMatch/randomUrlList.jsp" +
            				"?ruleId=" + realRuleId + "&date=" + date + "&endDate=" + endDate + "&rule=" + ruleVersion + "\",\"随机URL列表\",600,400,false);return false;'>查看</a></td></tr>";
		 				$("#ruleList").append(textRule); 
		 				$("#ruleList tr:last input[name='hidden']").val(rule);
		 				testRule+="0@" + rule + "::";
					}//for
					/*
					//去掉最后一个规则之后的或者
					if(rules.length > 0){
						$("#ruleList tr:last td:last").remove();
					}
					*/
			   }//if
			   ctrl.remove();
		  }//complete
	});
}

//气泡显示规则
function showRuleList1(ruleList){
	if(!ruleList || ruleList==""){
	var textRule = "暂无规则";
	 	$("#poprule").append(textRule);
		return ;
	}
	var rules = ruleList.split("##");
	for(var i=0;i<rules.length;i++){
		insertRuleRow1(rules[i]);
	}
}

function insertRuleRow1(rule){
	var id_rule = rule.split("@"),
		 ruleId = id_rule[0],
		 rule = id_rule[1],	
		 textRule = simpleRule2Text(rule);
      if($("#poprule tr:last") != null)
		 {
		 	lastRule = $("#poprule tr:last").html();// +  "或者";
		 	$("#poprule tr:last").html(lastRule);
		 }
		 textRule = "<tr><td ><span name = \"textRule\">" + textRule +
		  		"</span>&nbsp;&nbsp;&nbsp;</td>"+ 
		 		"</tr>";  

	    $("#poprule").append(textRule);
}

//规则内部排序：协议－域名－端口－路径－锚点－参数字符串－参数选项－内容	             			
function sortRule(simpleRule){
    var ruleAttrs = getJLCSVFields(simpleRule);
    var length = ruleAttrs.length;
    if( length % 3 != 0) return simpleRule;
    var subRule = new Array();
    for(var i=0; i < length; i=i+3){
        subRule.push("\"" + ruleAttrs[i] +"\",\"" + ruleAttrs[i+1] +"\",\"" + ruleAttrs[i+2] +"\"");
    }
    subRule.sort(function(a,b){
        return a.localeCompare(b);
    });
    var rule = "";
    for(var i=0; i<subRule.length; i++){
        rule += subRule[i] + ",";
    }
    if(rule.indexOf(",") >= 0) rule = rule.substring(0,rule.lastIndexOf(","));
    return rule;   
}

//添加一条规则
function insertRuleRow(rule, date, endDate, ruleVersion){
    var id_rule = rule.split("@"),
    ruleId = id_rule[0],
    ruleContent = sortRule(id_rule[1]),
    matchedUrlNum = id_rule[2];
    textRule = simpleRule2Text(ruleContent);
    /*
    if($("#ruleList tr:last") != null)
    {
        lastRule = $("#ruleList tr:last").html() +  "<td width=\"10%\">或者</td>";
        $("#ruleList tr:last").html(lastRule);
    }
    */
    textRule = "<tr><td style=\" border:1px solid #A2C0CB; \"><span style=\"cursor:pointer;\" onclick=\"editCurrentRule(this, " + ruleId + ");\" name = \"textRule\">" + textRule +
            "</span>&nbsp;&nbsp;&nbsp;" + "<input name=\"hidden\" type=\"hidden\"/>" + "<img style='cursor:pointer' src=\"../css/pic/del.gif\" width=\"10\" height=\"10\" onclick=deleteRuleRow(this,"+ruleId+") /></td>";
    if(ruleId == 0){
        textRule += "<td style=\" border:1px solid #A2C0CB; \"></td>" +
            "<td style=\" border:1px solid #A2C0CB; \"></td>";
    }else{
        textRule += "<td style=\" border:1px solid #A2C0CB; \">" + matchedUrlNum + "</td>" +
            "<td style=\" border:1px solid #A2C0CB; \"><a href=\"#\" onclick='Dialog.fastShow(\"randomUrlList\",\"/urlMatch/randomUrlList.jsp" +
            "?ruleId=" + ruleId +"&date=" + date + "&endDate=" + endDate + "&rule=" + ruleVersion + "\",\"随机URL列表\",600,400,false);return false;'>查看</a></td>";
    }
    textRule += "</tr>";
            
    $("#ruleList").append(textRule); 
    $("#ruleList tr:last input[name='hidden']").val(ruleContent);
}

//更新一条规则
function updateRuleRow(rule){
	var id_rule = rule.split("@"),
		 ruleId = id_rule[0],
		 ruleContent = sortRule(id_rule[1]),
		 textRule = simpleRule2Text(ruleContent);
	var modifyingRow = $("#ruleList tr[name='edit']");
	var spanArea = $("span[name='textRule']", modifyingRow);
	var inputArea = $("input[name='hidden']",modifyingRow);
	var currentRule = inputArea.val();
	//还要考虑的情况是，如果事先在前端添加的规则，然后做修改，这样testRule中已经保留一条记录了,此时标记为删除
	if(testRule != ""){
	  	testRule = testRule.substring(0,testRule.lastIndexOf("::")); 
		var testRules = testRule.split("::");
		var rules;
		for(var p = 0; p < testRules.length; p++){
			if(testRules[p] != ""){
				rules = testRules[p].split("@");
				if(rules[1] == currentRule)  testRules[p] = -1 + "@" + rules[1];
			}
		}
		testRule = "";
		for(var p = 0; p < testRules.length; p++){
			testRule = testRule + testRules[p] + "::";
		}
	}
	spanArea.html(textRule);
	inputArea.val(ruleContent);
	modifyingRow.removeAttr("name");
	ruleModifying = false;
	updateRule += ruleId +"@"+ ruleContent + "::";
}

//删除一条规则	  通过规则id删除一条规则,删除完成后删除规则table中的删除行
function deleteRuleRow(img,ruleId){
    //成功删除规则后删除表格一行
    var row = img.parentNode.parentNode;
    if(ruleId == 0){
    	//前端删除，只在前端添加，同时又在前端删除，在这里操作
        var deleRule = $("span[name='textRule']", $(row)).text();
        var testRules = testRule.split('::');
        testRule="";
        var splitRules;
        for(var sample = 0; sample < testRules.length; sample++){
            if(testRules[sample] != ""){
                splitRules = testRules[sample].split("@");
                if(splitRules[0] == 0){
                    if(simpleRule2Text(splitRules[1]) != ""){
                    	var textSampleRule = simpleRule2Text(splitRules[1]);
                        textSampleRule = "<span>" + textSampleRule + "</span>";
                        if( $(textSampleRule).text() != deleRule ){
                            testRule += testRules[sample] + "::";
                        }else{
                            testRule += "-1" + "@" + splitRules[1] + "::"; 
                        } 
                    }
                }
            }
        }
        //如果更新规则中也有新添加的，也要删除
        if(updateRule != ""){
            var updateRules = updateRule.split("::");
            var i;
            var testUpdateRule;
            for(var i = 0; i < updateRules.length; i++){
                if(updateRules[i] != ""){
                    testUpdateRule = updateRules[i].split("@");
                    if(testUpdateRule[0] == 0){
                        var textUpdateRule = simpleRule2Text(testUpdateRule[1]);
                        textUpdateRule = "<span>" + textUpdateRule + "</span>";
                        if($(textUpdateRule).text() == deleRule){
                            testUpdateRule[0] = -1;
                            updateRules[i] = testUpdateRule[0] + "@" + testUpdateRule[1];
                        }
                    }
                }
            }
            updateRule = "";
            for(var i = 0; i < updateRules.length; i++){
                updateRule += updateRules[i] + "::";
            }
        }
    }else{
        delRuleId+=ruleId+"::";
    }
    if(row.rowIndex + 1 == $("#ruleList tr").size()){
        $("#ruleList tr:last").remove();
        //$("#ruleList tr:last td:last").remove();
    }else {
        row.parentNode.deleteRow(row.rowIndex - 1);
    }
}

function getEditRule(){
    var rule = "";
    var rows = $("#ruleAttr tr");
    for(var i=0;i<rows.length;i++){
        elems = $("select,:text",rows[i]);
        for(var j=0;j<elems.length;j++){
            rule += "\""+elems[j].value.trim(" ").replace(/"/g, '""""')+"\",";
        }
    }
    if(rule.lastIndexOf(",") >= 0)  rule = rule.substring(0,rule.lastIndexOf(","));
    return rule;
}

function validateRule(mediaId,rule){
    
    var rows = $("#ruleAttr tr"),
        elems = [];
    
	//不为空，域名验证
	for(var i=0;i<rows.length;i++){
		elems = $("select,:text",rows[i]);
		if(elems[2].value==""){
			document.getElementById("info").innerHTML="输入规则不能为空！";
			return false;
		}
		else if(elems[0].value=="2" && (elems[2].value.indexOf("http://")==0 || elems[2].value.indexOf("https://")==0) ){
			document.getElementById("info").innerHTML="域名中不要包括http,https等协议名，协议名在协议中填写！"
			return false;
		}
	}
    
	//重名验证
	var flag = "fresh";
	rule = sortRule(rule);
	var textRule = simpleRule2Text(rule);
	textRule = "<span>" + textRule + "</span>";
	$("#ruleList tr span[name='textRule']").each(function(){
		if($(this).text() == $(textRule).text()){
			flag = "old";
			document.getElementById("info").innerHTML="该媒体规则已经添加，请重新编辑规则！";
		}
	});
	if(flag == "old") return false;
	document.getElementById("info").innerHTML="";
	return true;
}

function addTestRule(mediaId){
	var rule = getEditRule();
	var tmp = rule ; 
    if( validateRule(mediaId,rule) ){
        testRule+="0@" + sortRule(rule) + "::";
        insertRuleRow("0@"+rule+"@", null, null, null);
        deleteAllAttr();
    }
}

function updateTestRule(mediaId){
	var rule = getEditRule();
	if( validateRule(mediaId,rule) ){
		updateRuleRow(currentRuleId + "@" +rule);
		deleteAllAttr();
	}
}

//存储编辑规则
function saveRule(mediaId){
    var ruleId=delRuleId,rule=testRule;
    var ctrl = getBusyOverlay("viewport", 
    {
        color: "black",
        opacity: 0.5,
        text: "正在保存媒体规则，请等待...",
        style:'text-decoration:blink;font-weight:bold;font-size:12px;color:white'
    },{
        color:'#fff',
        size:64,
        type:'o'
    });
    $.ajax({
        url:"/urlMatch.do?method=saveRules",
        data:{"mediaId":mediaId,"rule":rule,"ruleId":ruleId,"updateRule":updateRule},
        type:"POST",
        complete:function(data){
            if(data&&data!=null){
                var ruleId = data.responseText;
                parent.window.Dialog.closeDialog('mediaList')
            }
            ctrl.remove();
        }
    });
}
//添加一条规则的子规则		点加号,增加一行
function addRuleAttr(img){
	var row = img.parentNode.parentNode,
		 cloneRow = row.cloneNode(true),
		 minus_img = cloneRow.getElementsByTagName("img")[0];
		 cloneRow.getElementsByTagName("span")[0].innerHTML="";
		 row.parentNode.appendChild(cloneRow);
	var attrTable = $("#ruleAttr"),
		 rows = $("tr",attrTable),
	    elems = [];
	    showContain($("#field",rows[rows.length-1]));
	    elems = $("select,:text",rows[rows.length-1]);
	    elems[2].value="";
       document.getElementById("info").innerHTML="";
	    $(minus_img).click(function(){
		   deleteThisAttr(this);
	      });
}
//点击减号 删除当前子规则
function deleteThisAttr(img){
	var row = img.parentNode.parentNode;
	row.parentNode.deleteRow(row.rowIndex);
}
//清除  清除所有行保留一行
function deleteAllAttr(mediaId){
  var attrTable = $("#ruleAttr"),
		 rows = $("tr",attrTable),
		 rule="",
		 elems = [];
	for(var i=0;i<rows.length;i++){
		elems = $("select,:text",rows[i]);
		for(var j=0;j<elems.length;j++)
			rule = rule+ "\""+elems[j].value+"\",";
	}
	rule +="\n";
	rule = rule.substring(8,rule.length-2); 
	 
	var table = document.getElementById("ruleAttr"),
		 length = table.rows.length;
	for(var i=length-1;i>0;i--){
		table.deleteRow(i);
		
		}
		elems = $("select,:text",rows[0]);
		elems[2].value=""
	 $("#info").empty()
}

//测试		测试完成后在下方测试结果显示区显示测试结果.测试结果以分号与逗号分割,像url,无；url,新浪-体育频道；.....
function showTestResult(resultStr){
	var rows = resultStr.split(";"),
		 table = $("#testResult"),
		 row,url,result;
	table.innerHTML= "";
	for(var i=0;i<rows.length;i++){
		row = table.insertRow(-1);
		var url_result = rule.split(",");
		 url = url_result[0]; 
		 result = url_result[1];	
		 row.insertCell(-1).innerHTML = url;
		 row.inserCell(-1).innerHTML = result;;
	}
}

//增加媒体 		增加媒体后刷新媒体列表,改变其排序规则为按更新时间排序

String.prototype.trim = function(trimStr){
	var reg = new RegExp("^"+trimStr+"+|"+trimStr+"+$","g");
	return this.replace(reg,"");
}

function showContain(sel){
		var v = sel.val();
		var node = sel.parent().children("#match");
		if(v=='8'){
		   node.children("#like").hide();
		   node.children("#notLike").hide();
		   node.children("#regLike").show();
		   node.children("#notRegLike").show();
		   node.val(node.children("#regLike").html());
		}else{
		   node.children("#like").show();
		   node.children("#notLike").show();
		   node.children("#regLike").hide();
		   node.children("#notRegLike").hide();
		   node.val(node.children("#like").html());
		}
}