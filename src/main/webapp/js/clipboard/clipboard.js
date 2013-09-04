//剪切板，现在无用

function encode_copy(str){
//	str=str.replace(/"/g,"");
//	str=str.replace(/'/g,"");
	return str;
}

function decode_copy(str){
	str=str.replace(/&lt;/g,"<");
	str=str.replace(/&gt;/g,">");
	str=str.replace(/&amp;/g,"&");
	return str;
}

function ie_copy_innerHTML(id){
	if (window.clipboardData){
		var str=document.getElementById(id).innerHTML;
		str=decode_copy(str);
		window.clipboardData.setData("Text", str);
	}
}

function ie_copy_value(id){
	if (window.clipboardData){
		var str=document.getElementById(id).value;
		str=decode_copy(str);
		window.clipboardData.setData("Text", str);
	}
}

/*
function CopyText(id){
	copy(document.getElementById(id).innerHTML);
}

function copy(text2copy) {
	if (window.clipboardData) {
		window.clipboardData.setData("Text",text2copy);
	} else {
		var flashcopier = 'flashcopier';
		if(!document.getElementById(flashcopier)) {
			var divholder = document.createElement('div');
			divholder.id = flashcopier;
			document.body.appendChild(divholder);
		}
		document.getElementById(flashcopier).innerHTML = '';
		var divinfo = '<embed src="_clipboard.swf" FlashVars="clipboard=\''+encode_copy(text2copy)+'\'" width="0" height="0" type="application/x-shockwave-flash"></embed>';//这里是关键
		document.getElementById(flashcopier).innerHTML = divinfo;
	}
}*/

