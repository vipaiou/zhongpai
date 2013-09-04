var dragSelector = (function(){
    var _dragSelector = function(option){
      this.name = option.name;
        this.mutiAble = (option.mutiAble === false) ? false : true;
        this.reverseAble = option.reverseAble;
        this.holderNode = option.holderNode;
        this.startX = null;
        this.endX = null;
        this.maskNode = null;
        this.enableEvent = true;
        this.type = option.type == 'week' ? 'week' : 'hour';
        this.unitPre = this.holderNode.attr('id') + '_span' || 'span_' + Math.random()*1000 + "_";
        this.init();
    };
    _dragSelector.activeObj = null;
    _dragSelector.prototype.ondragup = function(){};
    _dragSelector.prototype.init = function(){
        var that = this;
        var warpSpan = document.createElement('span');
        warpSpan.style.position = 'relative';
        if(this.type == 'week'){
            this.squaresLen = 7;
            for(var i=0; i<7; i++){
                this.createSquare(warpSpan, dragSelector['week' + i], i);
            }
        }else{
            this.squaresLen = 24;
            for(var i=0; i<10; i++){
                this.createSquare(warpSpan, '0' + i, i);
            }
            for(var i=10; i<24; i++){
                this.createSquare(warpSpan, i, i);
            }
        }
        this.holderNode[0].onselectstart = function(){return false;};
        this.holderNode.append(warpSpan).mousedown(function(e){
            if(!that.enableEvent) return;
            that.offsetX = $(this).offset().left;
            that.flg = true;
            that.startX = e.pageX;//相对于页面的距离
            if(!that.maskNode){
                that.maskNode = $("<div></div>");
                that.maskNode.css({
                    "position":"absolute",
                    "height": that.holderNode[0].offsetHeight + "px",
                    "opacity":0.3,
                    "background":"blue",
                    "top": '0px'
                });
                $(warpSpan).append(that.maskNode);
            }
            that.maskNode.css({
                "width": 0
            });
            if(!that.mutiAble){
                for(var j=0; j<that.squaresLen; j++){
                    _removeClass(document.getElementById(that.unitPre + j), 'select-drag-selected');
                }
            }
            _dragSelector.activeObj = that;
            e.preventDefault();
            e.stopPropagation();
        }).css('cursor', 'pointer');
        if(this.name){
            this.hiddenNode = $('<input type="hidden" name="' + this.name + '" />');
            this.holderNode.append(this.hiddenNode);
        }
        $(document).mousemove(function(e){
            if(!that.enableEvent) return;
            if(that.flg){
                var x = e.pageX;
                if(x > that.offsetX + that.holderNode[0].offsetWidth){
                    x = that.offsetX + that.holderNode[0].offsetWidth;
                }else if(x <= that.offsetX){
                    x = that.offsetX;
                }
                var distance = x - that.startX;
                if(distance > 0){
                    that.maskNode.css({
                        "left":that.startX - that.offsetX + "px",
                        "width":distance + "px",
                        "right":that.startX - that.offsetX + distance + "px"
                    });
                }else if(distance < 0){
                    that.maskNode.css({
                        "right":that.startX - that.offsetX + "px",
                        "width":-distance + "px",
                        "left":that.startX - that.offsetX + distance + "px"
                    });
                }
            }
        }).mouseup(function(e){
            that.flg = false;
            if(!that.enableEvent) return;
            if(_dragSelector.activeObj === null) return;
            _dragSelector.activeObj.maskNode.width(0);
            _dragSelector.activeObj.endX = e.pageX;
            _dragSelector.activeObj.drawSelecteds();
            if(that.name){
                _dragSelector.activeObj.hiddenNode.val(_dragSelector.activeObj.getVal());
            }
            _dragSelector.activeObj.ondragup();
            _dragSelector.activeObj.startX = null;
            _dragSelector.activeObj.endX = null;
            _dragSelector.activeObj = null;
            e.stopPropagation();
        });
    };
    _dragSelector.prototype.createSquare = function(parentNode, txt, idx){
        var span = document.createElement('span');
        span.className = "select-drag-span";
        span.style.padding = "1px 5px";
        span.id = this.unitPre + idx;
        span.innerHTML = txt;
        parentNode.appendChild(span);
    };
    _dragSelector.prototype.setDisabled = function(status){
        this.enableEvent = !status;
        if(status){
            this.holderNode.find('span').css('cursor', 'default');
        }else{
            this.holderNode.find('span').css('cursor', 'pointer');
        }
    };
    _dragSelector.prototype.drawSelecteds = function(){
        if(this.startX === null) return;
        var end = Math.max(this.endX, this.startX);
        var start = Math.min(this.endX, this.startX);
        var activeEles = [];
        for(var i=0; i<this.squaresLen; i++){
            var node = $("#" + this.unitPre + i);
            var dnode = node[0];
            var x = node.offset().left;
            if((x >= start) && (x < end)){
                activeEles.push(dnode);
            }else if((x < start) && (x + dnode.offsetWidth > start)){
                activeEles.push(dnode);
            }else if((x < end) && (x + dnode.offsetWidth > end)){
                activeEles.push(dnode);
                this.reverseSelectedStatus(dnode);
            }
        }
        var len = activeEles.length;
        if(this.reverseAble){
            for(var i=0; i<len; i++){
                this.reverseSelectedStatus(activeEles[i]);
            }
        }else{
            if(len == 1){
                this.reverseSelectedStatus(activeEles[0]);
            }else{
                for(var i=0; i<len; i++){
                    _hasClass(activeEles[i], 'select-drag-selected') || _addClass(activeEles[i], 'select-drag-selected');
                }
            }
        }
    };
    _dragSelector.prototype.reverseSelectedStatus = function(dragNode){
        dragNode.style.backgroundColor = _hasClass(dragNode, 'select-drag-selected') ? _removeClass(dragNode, 'select-drag-selected') : _addClass(dragNode, 'select-drag-selected');
    };
    _dragSelector.prototype.getVal = function(){
        var vals = [], that = this;
        var spans = this.holderNode.find('span.select-drag-span');
        var len = spans.size();
        spans.each(function(idx){
            if(_hasClass(this, 'select-drag-selected')){
                if(that.type == 'week'){
                    vals.push((idx + 1) % len);
                }else{
                    vals.push(idx);
                }
            }
        });
        return vals.join('-');
    };
    _dragSelector.prototype.setVal = function(val){
        if(val === false){
            val = '';
        }
        var set = _Arr2Set([].concat(val));
        var tempArr = [], that = this;
        var spans = this.holderNode.find('span.select-drag-span');
        var len = spans.size();
        spans.each(function(idx){
            if(that.type == 'week'){
                idx = (idx + 1) % len;
            }
            if(set[idx] || val === true){
                !_hasClass(this, 'select-drag-selected') && _addClass(this, 'select-drag-selected');
                tempArr.push(idx);
            }else{
                _hasClass(this, 'select-drag-selected') && _removeClass(this, 'select-drag-selected');
            }
        });
        if(this.name){
            this.hiddenNode.val(tempArr.join('-'));
        }
    };
    function _Arr2Set(arr){
        var set = {};
        for(var i=0,len=arr.length; i<len; i++){
            set[arr[i]] = true;
        }
        return set;
    };
    function _hasClass(node, cls){
        return new RegExp("(^|\\s)" + cls + "(\\s|$)").test(node.className);
    };
    function _addClass(node, cls){
        node.className += " " + cls;
    };
    function _removeClass(node, cls){
        node.className = node.className.replace(new RegExp("(^|\\s+)" + cls + "(\\s+|$)"), "");
    };
    return function(option){
        var _this = new _dragSelector(option);
        this.getVal = function(){
            return _this.getVal();
        };
        this.setVal = function(vals){
            _this.setVal(vals);
        };
        this.setDisabled = function(status){
            _this.setDisabled(status);
        };
        this.ondragup = function(fun){
            _this.ondragup = fun;
        };
    };
})();