function getJLCSVFields(line) {
        
      if(line === undefined || "" == line.replace(/(^\s*)|(\s*$)/g,"") ){
      	return "";
        }
      if("\"" != line.substring(0, 1) || "\"" != line.substring(line.length-1)) {
      	return "";
        } 
      var fields = new Array();
      var index = line.indexOf("\",", 0);
      var idx = 1;
      while (index != -1) {
      	var item = line.substring(idx, index);
      	var i = numberOfChar(item, "\"");
      	if (i % 2 === 0) {
         	item = item.replace(/""/g, "\"");
            fields.push(item);
            idx = index + 3;
            index = line.indexOf("\",", idx);                
         } else { 
            index = line.indexOf("\",", index + 1);
            }
        }
      var item = line.substring(idx, line.length - 1).replace(/""/g, "\"");
      fields.push(item);
      return fields;
 }

//统计字符串str中包含多少个字符c
function numberOfChar(str,c){
     	var n = 0;
      var i = str.indexOf(c);
      while (i != -1) {
      	n++;
      	i = str.indexOf(c, i + 1);
        }
      return n;
 }