function addMedia(id,type){
   var url = "../media.do?method=create&addForURLMatch=true&currentMediaId=" + id;
   title = "标准媒体－新建";
   if("C" == type){
       width = 900;
       height = 600;
   }
   else{
       width =  800;
       height = 490;
   }
   Dialog.fastShow("add",url,title,width,height,false);
}

function release(){
    jConfirm(
		'您确定要发布新版本吗?',
		'来自 http://mm.miaozhen.com 页面说：',
		function(result){	
			if(result){
				var ctrl = getBusyOverlay("viewport", 
					{
						color: "black",
						opacity: 0.5,
						text: "正在发布版本，请等待...",
						style:'text-decoration:blink;font-weight:bold;font-size:12px;color:white'
					},
					{
						color:'#fff',
						size:128,
						type:'o'
					}
				);
				$.ajax({
					url:"/urlMatch.do?method=releaseMediaRule",
					complete:function(result){												
						ctrl.remove();
						if(result.responseText=="1"){
							$("#currentReleased").load("/urlMatch.do?method=getLatestReleasedNum");
							alert("发布成功");
						}else{
							alert("发布失败");
						}
					}
				});//ajax
			}
		}
	);
	$("#popup_container").css('left','150px');
	$("#popup_container").css('top','310px');
}

function closeDialog(name,message,isfresh){
   parent.window.Dialog.closeDialog(name);
   if(isfresh){
       reloadTable(parentId,parentUrlNum,mediaType,"default","true");
   }
}