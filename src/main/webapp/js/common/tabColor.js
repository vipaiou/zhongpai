function initial(id)
{
	var tr=document.getElementById("tabColor"+id).getElementsByTagName("tr");
	for(var i=1;i<tr.length;i++){
	   if(i%2==0){
	   	tr[i].className="t1";
	   }else{
	   	tr[i].className="t2";
	   }
	   tr[i].onmouseover=Function("trs=this.className;this.className='t3';");
	   tr[i].onmouseout=Function("this.className=trs");
	}
}
String.prototype.replaceAll  = function(s1,s2){   
 return this.replace(new RegExp(s1,"gm"),s2);   
 } 
Array.prototype.contains = function (element) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == element) {
            return true;
        }
    }
    return false;
}
Array.prototype.remove=function(dx){
   if(isNaN(dx)||dx>this.length){
   return false;
   		}
   for(var i=0,n=0;i<this.length;i++){
     if(this[i]!=this[dx]){
       this[n++]=this[i]
        }
    }
    this.length-=1
} 
Array.prototype.indexOf=function(element){
    for (var i = 0; i < this.length; i++) {
        if (this[i] == element) {
            return i;
        }
    }
    return -1;
}
function getTabSelected(id){
	$(".selected").removeClass("selected");
	$("#"+id).addClass("selected");
} 
String.prototype.Trim = function()
{
return this.replace(/(^\s*)|(\s*$)/g, "");
}

