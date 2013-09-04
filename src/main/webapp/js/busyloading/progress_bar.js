var currentProgressForImportSpotsPlan;
var currentProgressForRenderSpotsPlan;
var fakeProgress = 80;
var element;
var xval, tval, bval, rval, lval;
//case 1:	get and show the real progress
function block_viewport_for_import_spots_plan() {
	currentProgressForImportSpotsPlan = 0;
	xval=getBusyOverlay('viewport',{color:'black', opacity:0.5, text:'loading', style:'text-decoration:blink;font-weight:bold;font-size:12px;color:white'},{color:'#f8b602', size:128, type:'o'});
	if(xval) {
		xval.ntime=window.setInterval("get_progress_for_import_spots_plan()",1000);
	}
}
 
function block_viewport_for_save_spots_plan() {
	currentProgressForImportSpotsPlan = 0;
	xval=getBusyOverlay('viewport',{color:'black', opacity:0.5, text:'loading', style:'text-decoration:blink;font-weight:bold;font-size:12px;color:white'},{color:'#f8b602', size:128, type:'o'});
	if(xval) {
		xval.ntime=window.setInterval("get_progress_for_save_spots_plan()",10);
	}
}
//case 2:	show the fake progress
function block_viewport_for_render_spots_plan() {
	currentProgressForRenderSpotsPlan = 0;
	xval=getBusyOverlay('viewport',{color:'blue',opacity:0.25, text:'loading', style:'text-decoration:blink;font-weight:bold;font-size:12px;color:white'},{color:'#fff', size:128, type:'o'});
	if(xval) {
		xval.ntime=window.setInterval("show_fake_progress_for_render_spots_plan()",200);
	}
}

//case 1:	first step -> get the real progress periodically
function get_progress_for_import_spots_plan(){
	url="/ajax/AjaxGetProgress";
	if(xmlHttp){
		xmlHttp.open("GET",url,true);
		xmlHttp.onreadystatechange=show_progress_for_import_spots_plan;
		xmlHttp.send(null);
	}
}
function get_progress_for_save_spots_plan(){
	url="/ajax/AjaxGetProgress";
	if(xmlHttp){
		xmlHttp.open("GET",url,true);
		xmlHttp.onreadystatechange=show_progress_for_save_spots_plan;
		xmlHttp.send(null);
	}
}
//case 1:	second step -> show the real progress asynchronously
function show_progress_for_import_spots_plan(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var xml=xmlHttp.responseXML;
			var progress=xml.getElementsByTagName("progress")[0].firstChild.nodeValue;
			if (progress <= 100) {
				while (currentProgressForImportSpotsPlan <= progress){
					xval.settext('正在导入排期文件...'+ currentProgressForImportSpotsPlan +'%'); currentProgressForImportSpotsPlan++;
				}
			} else {
				while (currentProgressForImportSpotsPlan <= 100){
					xval.settext('正在导入排期文件...'+ currentProgressForImportSpotsPlan +'%'); currentProgressForImportSpotsPlan++;
				}
			}
			if (currentProgressForImportSpotsPlan > 100){
				window.clearInterval(xval.ntime); xval.remove();
			}
		}
	}
}
function show_progress_for_save_spots_plan(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var xml=xmlHttp.responseXML;
			var progress=xml.getElementsByTagName("progress")[0].firstChild.nodeValue;
			if (progress <= 100) {
				while (currentProgressForImportSpotsPlan <= progress){
					xval.settext('正在保存排期...'+ currentProgressForImportSpotsPlan +'%'); currentProgressForImportSpotsPlan++;
				}
			} else {
				while (currentProgressForImportSpotsPlan <= 100){
					xval.settext('正在保存排期...'+ currentProgressForImportSpotsPlan +'%'); currentProgressForImportSpotsPlan++;
				}
			}
			if (currentProgressForImportSpotsPlan > 100){
				window.clearInterval(xval.ntime); xval.remove();
			}
		}
	}
}
//case 2:	show the fake progress periodically
function show_fake_progress_for_render_spots_plan(){
	if (currentProgressForRenderSpotsPlan <= 100) {
		xval.settext('正在加载排期...'+ currentProgressForRenderSpotsPlan +'%'); currentProgressForRenderSpotsPlan++;
	} else {
		window.clearInterval(xval.ntime); xval.remove();
	}
}


//--------------------
//可以更新指定 element的进度数字
function get_progress(elementStr){
	element = elementStr;
	url="/ajax/AjaxGetProgress";
	if(xmlHttp){
		xmlHttp.open("GET",url,true);
		xmlHttp.onreadystatechange=show_progress;
		xmlHttp.send(null);
	}
}