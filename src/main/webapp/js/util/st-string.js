var StringUtil = window.StringUtil || {};
StringUtil.version = 0.1;
StringUtil.format = function(val, ch, len){
	ch = ch || ",";
	len = len || 3;
	return ("" + val).replace(new RegExp("(\\d{1," + len + "})(?=(\\d{" + len + "})+(?:$|\\.))", "g"), "$1" + ch);
};
StringUtil.fill = function(val, ch, len, right){
	var v = val+"";
	ch = ch || "0";
	len = len || 2;
	for(var i=0,len=len-v.length;i<len;i++){
		v = right ? v + ch : ch + v;
	}
	return v;
};
