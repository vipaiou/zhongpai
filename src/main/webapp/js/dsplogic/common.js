// JavaScript Document by Richbox
function initPage() {
	//
}
/**/
function initBody() {
	//
}
function getTop(e){
	var offset=e.offsetTop;
	if(e.offsetParent!=null) offset+=getTop(e.offsetParent);
	return offset;
} 
function getLeft(e){
	var offset=e.offsetLeft;
	if(e.offsetParent!=null) offset+=getLeft(e.offsetParent);
	return offset;
}
function isIe() {
	if(navigator["appVersion"].substr(22,1)==6) {
		return true;
	} else {
		return false;
	}
}
function visibleObj(Obj,v) {
	if(v==true) {
		Obj.style.display="block";
	} else {
		Obj.style.display="none";
	}
}
function $(Obj) {
	var o=document.getElementById(Obj);
	if(o!=null) {
		return o;
	} else {
		return false;
	}
}
function handleIEhasLayout(){
	//trigger re-rendering
	document.body.style.zoom = 1.1;
	//restore it
	document.body.style.zoom = '';
}