function checkChildren(obj){
     if($(obj).attr("checked")) {
          $("input[type='checkbox']",obj.parentNode).each(function(){
               $(this).attr("checked",true);
             });
          $(".permission",obj.parentNode).each(function(){
        	  $(this).attr("disabled",false);
          });
    }else{
         $("input[type='checkbox']",obj.parentNode).each(function(){
               $(this).attr("checked",false);
            });
         $(".permission",obj.parentNode).each(function(){
       	  $(this).attr("disabled",true);
         });
     }
}

function checkParent(obj){
	if($(obj).attr("checked")){
		var checked = true;
		$("input[type='checkbox']",obj.parentNode).each(function(){
          if(!$(this).attr("checked")) checked=false;
        });
      $(obj).parent().parent().children(":eq(0)").children(":eq(0)").attr("checked",checked);
	}else{
		$(obj).parent().parent().children(":eq(0)").children(":eq(0)").attr("checked",false);
	}
}

function checkSublings(obj){
	if($(obj).attr("checked")){
		//var checked = true;
		$(".permission",obj.parentNode).each(function(){
         $(this).attr("disabled",false);
        });
	}else{
		$(".permission",obj.parentNode).each(function(){
			$(this).attr("checked",false);
         $(this).attr("disabled",true);
        });
	}
}
//add
function initCheckbox(){
	$("input[type=checkbox]").attr("checked",false);
	$("#NoFreezed").attr("checked",true);
	
	$("#permissionTable .permission").attr("disabled",true);
	$("#permissionTable").not(".permission").attr("disabled",false);
	
	$(".groupPer").each(function(){
		$(this).click(function(){
			checkChildren(this);
		});
	});
   $(".permission").each(function(){
	    $(this).click(function(){
	   	checkParent(this);
	    });
    });
    $(".basePer").each(function(){
    	$(this).click(function(){
	   	checkParent(this);
	   	checkSublings(this);
	    });
    });
   
    common("add");
}
//common
function common(x){
	 
	 $(".permission,.basePer").each(function(){
		    $(this).click(function(){
		    var o=null;
		    if(x=="add"){
		    	o=$(this).parent().get(0);
		    }else if(x=="modify"){
		    	o=$(this).parent().parent().get(0);
		    }
		    
		    var all=true;
		   $(".permission,.basePer",o).each(function(i){
		    		if(!$(this).attr("checked")){	    			
		    			all=false;
		    			return ;
		    		}
			   
		    });	    
		    $(".groupPer",o).attr("checked",all);

		    });
	    });
	    $("#permissionTable input[type=checkbox]").not("#authority").each(function(){
		    $(this).click(function(){
		    var all=true;
		    $("#permissionTable input[type=checkbox]").not("#authority").each(function(){
		    		if(!$(this).attr("checked")){	    			
		    			all=false;
		    			return ;
		    		}
			   
		    });	    
		    $("#authority").attr("checked",all);

		    });
	    });
}
//modify
function initPermission(){
	$("#permissionTable input[type=checkbox]").attr("checked",false);
	$("#NoFreezed").attr("checked",true);
	
	$("#permissionTable .permission").attr("disabled",true);
	$("#permissionTable").not(".permission").attr("disabled",false);
	
	$(".groupPer").each(function(){
		$(this).click(function(){
		 	var o=$(this).parent().parent().get(0);

			if($(this).attr("checked")){
					$("input[type=checkbox]",o).attr("checked",true);
					$(".permission",o).attr("disabled",false);
			}else{
				$("input[type=checkbox]",o).attr("checked",false);
				$(".permission",o).attr("disabled",true);
			} 
	});

	});
	$(".basePer").each(function(){
		$(this).click(function(){
		 	var o=$(this).parent().parent().get(0);

			if($(this).attr("checked")){
					$(".permission",o).attr("checked",true);
					$(".permission",o).attr("disabled",false);
			}else{
				$(".permission",o).attr("checked",false);
				$(".permission",o).attr("disabled",true);
			} 
	});
	});
	$("#authority").click(function(){
		if($(this).attr("checked")){
			$("#permissionTable input[type=checkbox]").attr("checked",true);			
			$("#permissionTable .permission").attr("disabled",false);
		}else{
			$("#permissionTable input[type=checkbox]").attr("checked",false);
			$("#permissionTable .permission").attr("disabled",true);
		}
	});
	common("modify");
}

