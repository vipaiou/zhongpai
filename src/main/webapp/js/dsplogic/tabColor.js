function initial(id)
{
  var tr = $('#tabColor' + id).find('>tbody>tr');
	for(var i=1;i<tr.length;i++){
	   if(i%2==0){
      $(tr[i]).removeClass("t2").addClass("t1");
	   }else{
      $(tr[i]).removeClass("t1").addClass("t2");
	   }
     var clazz = $(this).attr("class");
     $(tr[i]).mouseover(function() {
      $(this).addClass("t3");
     }).mouseout(function() {
      $(this).removeClass("t3");
     });
	}
}
