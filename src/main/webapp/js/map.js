  
  Map = function(){
    this._array = new Array();
    }

    MapObj = function(k,v){
    this.K = k;
    this.V = v;
    this.getK = function(){
    return this.K;
    }

    this.getV = function(){
    return this.V;
    }

    this.toString = function(){
    return "[" + this.K + "," + this.V + "]";
    }
    }

    Map.prototype.indexOf = function(K) {
    for(var i=0;i<this.size();i++){
    if(this._array[i].getK() == K){
    return i;
    }
    }
    return -1;
    }

    Map.prototype.put = function(K,V){  // put Method
    var index = this.indexOf(K);
    index != -1 ? this._array[index].V = V : this._array.push(new MapObj(K,V));
    }

    Map.prototype.get = function(K){  // get Method
    var index = this.indexOf(K);
    return (index != -1 ? this._array[index].getV() : null);
    }

    Map.prototype.keySet = function(){  // keySet Method
    var keys = new Array();
    for(var i=0;i<this.size();i++){
    var key = this._array[i].getK();
    keys.push(key);
    }
    return keys;
    }

    Map.prototype.values = function(){  // values Method
    var values = new Array();
    for(var i=0;i<this.size();i++){
    var value = this._array[i].getV();
    values.push(value);
    }
    return values;
    }

    Map.prototype.size = function(){    //size Method
    return this._array.length;
    }

    Map.prototype.remove = function(K){  //remove Method
    var index = this.indexOf(K);
    if(index != -1){
    for(var i=index;i<this.size();i++){
    this._array[i] = this._array[i+1];
    }
    this._array.length --;
    }
    }

    Map.prototype.isEmpty = function(){  // isEmpty Method
    return this.size() == 0;
    }

    Map.prototype.entrySet = function(){  // entrySet Method
    return this._array;
    }

    Map.prototype.containsKey = function(K){  // containsKey Method
    return (this.indexOf(K) != -1 ? true : false);
    }

    Map.prototype.containsValues = function(V){  //containsValues Method
    for(var i=0;i<this.size();i++){
    if(this._array[i].getV() == V){
    return true;
    }
    }
    return false;
    }

    Map.prototype.clear = function(){  //clear Method
    for(var i=0;i<this.size();i++){
    this._array[i] = null;
    }
    this._array.length = 0;
    }