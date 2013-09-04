function checkPermission(pID){
	var permission = false;
	$.ajax({
 		url: '/permission.do?method=checkPermission',
 		async:false,
 		type:"POST",
 		data:{
 			permissionID:pID 								
 		},
 		complete:function(response){
 			var result = response.responseText;
 			if(result=="true"){
 				permission = true;
 			}
 			else{
 				permission = false;
 			}
 		}
 	});
	return permission;
}