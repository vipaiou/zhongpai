var pop = (function(document){
	var clientX,clientY,left,top,maxLeft,maxTop, minLeft, minTop;
	var container = null;
	var titleNode = null;
	var isStrict = document.compatMode == "CSS1Compat";
	var pop = function(options){
		this.init();
		this.popWidth = 400;
		this.popHeight = 300;
		this.useMask = true;
		this.extendsOptions(options);
		this.popHolder = null;
	};
	pop.prototype = {
		init : function(){
			var that = this;
			var bd = document.body;
			var de = document.documentElement;
			if(!isStrict){
				this.getWidth = function(){return bd.clientWidth;};
				this.getHeight = function(){return bd.clientHeight;};
				this.getScrollTop = function(){return bd.scrollTop;};
				this.getScrollLeft = function(){return bd.scrollLeft;};
				this.getScrollHeight = function(){return bd.scrollHeight};
				this.getScrollWidth = function(){return bd.scrollWidth;};
			}else{
				this.getWidth = function(){return de.clientWidth;};
				this.getHeight = function(){return de.clientHeight;};
				this.getScrollTop = function(){return de.scrollTop || bd.scrollTop;};
				this.getScrollLeft = function(){return de.scrollLeft || bd.scrollLeft;};
				this.getScrollHeight = function(){return de.scrollHeight || bd.scrollHeight};
				this.getScrollWidth = function(){return de.scrollWidth || bd.scrollWidth;};
			}
		},
		extendsOptions : function(options){
			for(var o in options){
				this[o] = options[o];
			}
		},
		load : function(url){
			if(!this.popHolder){
				var that = this;
				container = this.popHolder = document.createElement('div');
				this.popHolder.className = 'popContainer';
				
				titleNode = this.popTitle = document.createElement('div');
				this.popTitle.className = 'popTitle';
				var titleTxt = document.createElement('span');
				titleTxt.className = 'titleTxt';
				titleTxt.innerHTML = this.title || 'qwqwqw';
				
				var closeBtn = document.createElement('span');
				closeBtn.className = 'closeBtn';
				closeBtn.innerHTML = 'X&nbsp;';
				this.popTitle.appendChild(titleTxt);
				this.popTitle.appendChild(closeBtn);
				this.popHolder.appendChild(this.popTitle);
				
				this.iframeContainer = document.createElement('div');
				this.iframeContainer.style.padding = "10px";
				this.ifm = document.createElement("iframe");
				this.ifm.setAttribute("frameborder", "0");
				this.ifm.setAttribute("scrolling", "no");
				this.ifm.setAttribute("marginwidth", "0");
				this.ifm.setAttribute("marginheight", "0");
				
				this.iframeContainer.appendChild(this.ifm);
				this.popHolder.appendChild(this.iframeContainer);
				document.body.appendChild(this.popHolder);
				if(this.useMask){
					this.mask = document.createElement('div');
					this.mask.className = 'popMask';
					document.body.appendChild(this.mask);
				}
				addEvent(this.popTitle, 'mousedown', mdown);
				addEvent(document, 'select', function(){return false;});
				addEvent(closeBtn, 'click', function(){that.hide.call(that);});
			}
			this.iframeContainer.style.width = this.popWidth + 'px';
			this.popHolder.style.width = this.popWidth + 20 + 'px';
			this.iframeContainer.style.height = this.popHeight + 'px';
			this.popHolder.style.height = this.popHeight + 50 + 'px';
			this.popHolder.style.left = this.getScrollLeft() + (this.getWidth() - this.popWidth) / 2 + 'px';
			this.popHolder.style.top = this.getScrollTop() + (this.getHeight() - this.popHeight) / 2 + 'px';
			this.ifm.width = this.popWidth;
			this.ifm.height = this.popHeight;
			this.ifm.src = url;
			if(this.useMask){
				this.mask.style.width = this.getScrollWidth() + 'px';
				this.mask.style.height = this.getScrollHeight() + 'px';
			}
			this.show();
		},
		show : function(){
			this.popHolder.style.display = 'block';
			if(this.useMask){
				this.mask.style.display = 'block';
			}
		},
		hide : function(){
			this.onclose();
			this.popHolder.style.display = 'none';
			if(this.useMask){
				this.mask.style.display = 'none';
			}
		},
		onclose : function(){
		}
	};
	function addEvent(obj, type, fun){
		if(window.addEventListener){
			obj.addEventListener(type, fun, true);
		}else if(window.attachEvent){
			obj.attachEvent('on' + type, fun);
		}else{
			obj['on' + type] = fun;
		}
	};
	function delEvent(obj, type, fun){
		if(window.removeEventListener){
			obj.removeEventListener(type, fun, true);
		}else if(window.detachEvent){
			obj.detachEvent('on' + type, fun);
		}else{
			obj['on' + type] = null;
		}
	};
	
	
	function mdown(e){
		e = e || window.event;
		clientX = e.clientX;
		clientY = e.clientY;
		minLeft = isStrict ? document.documentElement.scrollLeft : document.body.scrollLeft;
		minTop = isStrict ? document.documentElement.scrollTop : document.body.scrollTop;
		maxLeft = isStrict ? document.documentElement.clientWidth + document.documentElement.scrollLeft- container.offsetWidth : document.body.clientWidth + document.body.scrollLeft- container.offsetWidth;
		maxTop = isStrict ? document.documentElement.clientHeight + document.documentElement.scrollTop - container.offsetHeight : document.body.clientHeight + document.body.scrollTop - container.offsetHeight;
		left = parseInt(container.style.left);
		top = parseInt(container.style.top);
		addEvent(document, 'mousemove', mmove);
		addEvent(document, 'mouseup', mup);
		if(titleNode.setCapture){
			titleNode.setCapture();
		}
	};
	function mmove(e){
		ve = e || window.event;
		var l = left + (e.clientX - clientX);
		var t = top + (e.clientY - clientY);
		if (l < minLeft){
			l = minLeft;
		}else if (l > maxLeft){
			l = maxLeft;
		}
		if (t < minTop){
			t = minTop;
		}else if (t > maxTop){
			t = maxTop;
		}
		container.style.left = l + "px";
		container.style.top = t + "px";
	};
	function mup(){
		if (titleNode.releaseCapture){
			titleNode.releaseCapture();
		}
		delEvent(document, 'mousemove', mmove);
		delEvent(document, 'mouseup', mup);
	};
	return pop;
})(document);
