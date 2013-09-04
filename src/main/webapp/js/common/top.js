// JavaScript Document by Richbox
function resizeFrame() {
	if($("topSize").value!=""&$("leftSize").value!="") {
		try {
			parent.resetFrameSize($("topSize").value,$("leftSize").value);
			visibleObj($("sizeReseter"),false);
		} catch(e) {
			alert(e);
		}
	} else {
		alert("²»ÔÊÐíÎª¿Õ");
	}
}
function getFrameSize() {
	try {
		var o=parent.getFrameSize();
		$("topSize").value=o.h;
		$("leftSize").value=o.w;
	} catch(e) {
		alert(e);
	}
}
function swfGetFrameSize() {
	var o=parent.getFrameSize();
	return o;
}
function swfSetFrameSize(o) {
	parent.resetFrameSize(o.h,o.w);
}
function visibleObj(Obj,v) {
	if(v==null||v=="undefind") {
		if(Obj.style.display=="block") {
			Obj.style.display="none";
		} else {
			Obj.style.display="block";
		}
	} else {
		if(v==true) {
			Obj.style.display="block";
		} else {
			Obj.style.display="none";
		}
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
function initTree(t) {
	var tree=$(t);
	var lis=tree.getElementsByTagName("li");
	var sucess = 0;
	//alert(lis.length);
	for(var i=0;i<lis.length;i++) {
		lis[i].nu=i;
		lis[i].onclick=function() {
		
			for(var j=0;j<lis.length;j++) {
				if(j==this.nu) {
					this.className="selected";
					document.body.focus();
					sucess = 1;
				} else {
					lis[j].className="";
				}
			}
			if(sucess = 0)
			{
				lis[0].className="selected";
			}
		}
	}
}
function goURL(num) {
	var link1="";
	var link2="";
	switch(num) {
		case 0:
		link1="";
		link2="start.html";
		break;
		case 1:
		link1="";
		link2="success.html";
		break;
		default:
		link1="";
		link2="start.html";
		break;
	}
	parent.document.getElementById("leftFrame").src=link1;
	parent.document.getElementById("mainFrame").src=link2;
}