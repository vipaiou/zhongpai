var leftDataItemNumber = 0;

String.prototype.Trim = function()
{
   return this.replace(/(^\s*)|(\s*$)/g, "");
}

function isIp(s){
	var checkIP=function(v){try{return (v<=255 && v>=0)}catch(x){return false}};
	var re=s.split(".");
	return (re.length==4)?(checkIP(re[0]) && checkIP(re[1]) && checkIP(re[2]) && checkIP(re[3])):false;
}

function check(item){
	var temp = item;
	var temp1='';
	var temp2='';
	var rulePattern = /^R\d+$/; 
	//var ipPattern = /^IP:/; 
	//var dayPartPattern = /^DP:[0-23]$/;
	var operatorPattern = /^[&|!]$/;
	if (item == null || typeof(item)=="undefined"){
		return false;
	}else {
		if (leftDataItemNumber<0){
			alert("运算符过多");
			return false;
		}

		//1.	dataItem
		if (item.indexOf('IP:') == 0){
			temp = item.substring(3);
			if (temp.indexOf('-') > 0){
				temp1 = temp.substring(0, temp.indexOf('-'));
				if (!isIp(temp1)){ 
					alert("IP段下界不对");
					return false
				}
				temp2 = temp.substring(temp.indexOf('-') + 1, temp.length);
				if (!isIp(temp2)){ 
					alert("IP段上界不对");
					return false
				}
			}
		}else if (item.indexOf('DP:') == 0){
			temp = parseInt(item.substring(3));
			if (temp < 0 || temp > 23){
				alert("DayPart格式不对");
				return false;
			}
		}else if (item.indexOf('R') == 0){
			if (!rulePattern.test(item)){
				alert("RuleId格式不对");
				return false;
			}
		}//2.	operator or empty string
		else if (operatorPattern.test(item) || item == ""){
			// do noting
		}
		//3. other invalid chars
		else{
			alert("非法字符（串）" + item);
			return false;
		}	 
	}
	return true;
}

function trl_check(){
	var TRL = document.getElementById("targetRule");
	var tmpTRL="";
	var items = new Array();
	if (TRL == null || typeof(TRL)=="undefined"){
		return false;
	}else {
		tmpTRL = TRL.value.Trim();
		if (tmpTRL.lastIndexOf(',') != tmpTRL.length - 1){
			alert("最后一个输入字符必须是','");
			return false;
		}
		items = tmpTRL.split(",");
		for (var i=0; i<items.length; i++ )   
		{    
			var tmp = items[i];
			tmp = tmp.Trim();
			if (tmp == '!'){ //当遇到一元运算符!
				leftDataItemNumber--;
				if (!check(tmp)){
				 leftDataItemNumber = 0;
				 return;
				 }
				leftDataItemNumber++;
			}else if (tmp == '&' || tmp == '|'){ //当遇到二元运算符&|
				leftDataItemNumber-=2;
				if (!check(tmp)){
				 leftDataItemNumber = 0;
				 return;
				 }
				leftDataItemNumber++;
			}else if (tmp == ''){//empty string
			//do nothing
			}else{//当遇到其他元素（包括 基本项）
				if (!check(tmp)){
				 leftDataItemNumber = 0;
				 return;
				 }
				leftDataItemNumber++;
			}
		}
		if (leftDataItemNumber != 1){
			alert('TRL语法有错误,请检查');
		}
		leftDataItemNumber = 0;
	}
}