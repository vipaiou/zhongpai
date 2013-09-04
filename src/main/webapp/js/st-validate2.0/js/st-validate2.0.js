;var validator = (function(){
	var eleWapper = function(ele){
		this.ele = ele;
		this.rules = [];
		this.val = this.defaultVal = ele.value;
		this.massages = {};
		this.msgNode = null;
		this.defaultMsg = '';
		this.beforeValidateFun = null;
		this.afterValidateFun = null;
	};
	eleWapper.prototype = {
		rulesType : {
			required : function(val, status){
				return !status || !!val && val.length > 0;
			},
			en : function(val){
				return /^[a-z]+$/i.test(val);
			},
			number : function(val){
				return /^[1-9]{1}\d*|^0$/i.test(val);
			},
			money : function(val){
				return /^[1-9]{1}\d*\.[0-9]{2}|^0\.[0-9]{2}$/i.test(val);
			},
			character : function(val){
				return /^[u4e00-u9fa5]+$/.test(val);
			},
			validname : function(val){
				var regx  = new RegExp("^[^\/\:\*\?\"\“\”\'\<\>\|\\\\]*$");
				return regx.test(val);
			},
			minLen : function(val, min){ 
				return !!val && val.length >= min;
			},
			maxLen : function(val, max){
				return !!val && val.length <= max;
			},
			min : function(val, min){
				return !!val && +val >= min;
			},
			max : function(val, max){
				return !!val && +val <= max;
			},
			depend : function(){return !1;},
			remote : function(val, options){
				var flg = !1;
				var param = options.param || {};
				if(param.constructor == Function){
					param = (options.param)();
				}
				$.ajax({
					url : options.url,
					type : "POST",
					cache:!1,
					dataType : "json",
					data :  param,
					context : this,
					async : !1,
					success : function(result){
						if(typeof result == 'boolean'){
							flg = this.updateMsg(result ? 'valid' : 'remote');
						}else{
							flg = this.updateMsg(result);
						}
					}
				});
				return flg;
			}
		},
		_checkRule : function(rule, type, msg){
			if(String == type){
				var obj = {};
				obj[rule] = !0;
				this.rules.push(obj);
				msg && (this.massages[rule] = msg);
			}else if(Object == type){
				for(var o in rule){
					var status = rule[o];
					if(status !== undefined){
						obj = {};
						obj[o] = status;
						this.rules.push(obj);
						msg && (this.massages[o] = msg);
					}
				}
			}
		},
		addRules : function(rules){
			if(rules){
				var i,len= rules.length,obj;
				for(i=0;i<len;i++){
					var rule = rules[i];
					var type = rule.constructor;
					if(Array == type){
						var r = rule[0];
						var msg = rule[1];
						var tp = r.constructor;
						if(Function == tp || RegExp == tp){
							(this._un && this._un++) || (this._un = 1);
							obj = {};
							var _o = "_un" + this._un;
							if(RegExp == tp)
								obj[_o] = (function(r, t){return function(){ return r.test(t.val);};})(r, this);
							else
								obj[_o] = r;
							this.rules.push(obj);
							this.massages[_o] = msg;
						}else{
							this._checkRule(r, tp, msg);
						}
					}else{
						this._checkRule(rule, type);
					}
				}
			}
			return this;
		},
		updateMsg : function(rule){
			var msgNode = this.getMsgNode();
			msgNode.style.padding = 0;
			if(rule == 'pass'){
				this.setDefaultMsg();
				return !0;
			}else if(rule == 'valid'){
				msgNode.className = "validMsg";
				msgNode.style.padding = "0 7px";
				msgNode.innerHTML = '&nbsp;';
				this.afterValidateFun && this.afterValidateFun(!0);
				return !0;
			}else{
				msgNode.innerHTML = this.massages[rule];
				msgNode.className = "errorMsg";
				this.afterValidateFun && this.afterValidateFun(!1);
				return !1;
			}
		},
		message : function(msgObj){
			if(typeof msgObj == 'object'){
				var dftMsg = msgObj.defaultMsg;
				if(dftMsg){
					this.setDefaultMsg(dftMsg);
					//delete msgObj.defaultMsg;
				}
				for(var o in msgObj){
					this.massages[o] = msgObj[o];
				}
			}
			return this;
		},
		getMsgNode : function(){
			if(this.msgNode){
				return this.msgNode;
			}
			var next = this.ele.nextSibling;
			var parent = this.ele.parentNode;
			if(next){
				if(next.nodeType == 1){
					if(next.nodeName.toLowerCase() == 'span'){
						return this.msgNode = next;
					}
				}
				var span = document.createElement("span");
				parent.insertBefore(span, next);
				return this.msgNode = span;
			}else{
				var span = document.createElement("span");
				parent.appendChild(span);
				return this.msgNode = span;
			}
		},
		setMsgNode : function(node){
			this.msgNode = validator.getNode(node);
			return this;
		},
		setDefaultMsg : function(msg){
			var msgNode = this.getMsgNode();
			msgNode.innerHTML = (this.defaultMsg = msg || this.defaultMsg);
			msgNode.className = "defaultMsg";
			return this;
		},
		resetElement : function(){
			this.ele.value = this.defaultVal;
			this.setDefaultMsg();
		},
		bindValidEvent : function(eventType){
			var that = this;
			this.ele["on" + (eventType || "blur")] = function(){that.validate();};
			return this;
		},
		beforeValidate : function(fun){
			this.beforeValidateFun = fun;
			return this;
		},
		afterValidate : function(fun){
			this.afterValidateFun = fun;
			return this;
		},
		validate : function(){
			if(this.beforeValidateFun){
				this.beforeValidateFun(this.getVal());
			}
			try{
				var o = this, result;
				o.val = this.getVal();
				// 需要被验证的规则
				var rules = o.rules;
				for(var i=0;i<rules.length;i++){
					var ruleObj = rules[i];
					for(var rule in ruleObj){
						var status = ruleObj[rule];
						// 系统支持的几种简单验证
						var fun = o.rulesType[rule];
						if(fun){
							if(typeof status == 'function'){
								// 是否是依赖关系验证
								if(rule == 'depend'){
									if(!status.call(o)) {
										return o.updateMsg('pass');
									}
								}else{
									// 认为是重写了系统默认的验证
									result = o.validateRule(status, rule);
									if(result === !1) return !1;
								}
							}else{
								if(status !== undefined) {
									if(rule == 'required'){
										if(!status){
											if(this.getVal().length == 0){
												return o.updateMsg('valid');
											}else{
												continue;
											}
										}
									}
									result = o.validateRule(fun, rule, status);
									if(result === !1) return !1;
								}
							}
						}else{
							// 自定义事件
							if(typeof status == 'function'){
								result = o.validateRule(status, rule);
								if(result === !1) return !1;
							}
						}
					}
				}
				return o.updateMsg('valid');
			}catch(e){
				return o.updateMsg(0);
			}
		},
		validateRule : function(fun, rule, status){
			var result = fun.call(this, this.val, status);
			if(typeof result == 'boolean'){
				if(!result){
					return this.updateMsg(rule);
				}
			}else{
				return this.updateMsg(result);
			}
		},
		getVal : function(){
			var ele = this.ele;
			var type = ele && ele.type && ele.type.toLowerCase();
			if(type == 'text' || type == 'textarea' || type == 'password' || type == 'hidden' || (type && type.indexOf('select') == 0) || type =='file'){
				return ele.value.replace(/^\s+|\s+$/g, '');
			}
			
		},
		setVal : function(val){
			this.ele.value = val;
		},
		overrideFun : function(funName, newFun){
			this[funName] = newFun;
			return this;
		}
	};
	var validator = function(options){
		this.elements = [];
		this.eleMap = {};
		this.init(options);
	};
	validator.getNode = function(ele){
		return typeof ele == 'string' ? document.getElementById(ele) : ele.nodeName ? ele : ele[0];
	};
	validator.prototype = {
		init : function(options){
			if(options){
				this.url = options.url;
				this.dataType = options.dataType || 'json';
				this.type = options.type || 'POST';
				this.fun = options.fun || function(){};
				this.beforeValidateAll = options.beforeValidateAll || function(){};
				this.params = options.params || {};
				if(options.submitNode){
					var that = this;
					this.submitNode = validator.getNode(options.submitNode);
					this.submitNode.onclick = function(){that.submitParams.call(that)};
				}
			}
		},
		addElement : function(ele, eventType){
			if(!ele) return !1;
			ele = validator.getNode(ele);
			var o = new eleWapper(ele);
			o.bindValidEvent(eventType);
			this.elements.push(o);
			this.eleMap[ele.id || ele.name] = o;
			return o;
		},
		getElementWapper : function(ele, eventType){
			if(!ele) return !1;
			ele = validator.getNode(ele);
			for(var i=0,len=this.elements.length; i<len; i++){
				if(this.elements[i].ele === ele){
					return this.elements[i];
				}
			}
		},
		resetElement : function(ele){
			var eleWapper = this.getElementWapper(ele,null);
			if(!eleWapper) return !1;
			eleWapper.resetElement();
			/*this.ele.value = this.defaultVal;
			this.setDefaultMsg();*/
		},
		removeElement : function(ele){
			if(!ele) return !1;
			ele = validator.getNode(ele);
			for(var i=0,len=this.elements.length; i<len; i++){
				if(this.elements[i] === ele){
					break;
				}
			}
			if(i < len){
				delete this.eleMap[ele.id || ele.name];
				this.elements.splice(i,1);
			}
		},
		getEleKey: function(eleWp){
			var ele = eleWp.ele;
			if(!ele){
				ele = validator.getNode(eleWp);
			}
			return ele.id || ele.name;
		},
		validElement : function(ele){
			if(!ele) return !1;
			ele = validator.getNode(ele);
			return this.eleMap[ele.id || ele.name].validate();
		},
		validateAll: function(){
			if(this.beforeValidateAll){
				this.beforeValidateAll();
			}
			var flg = !0;
			for(var i=0;i<this.elements.length;i++){
				var eleWapper = this.elements[i];
				if(!eleWapper.validate()) flg = !1;
			}
			return flg;
		},
		submitParams : function(){
			var flg = this.validateAll();
			if(flg) {
				this.beforeSend();
				this.ajaxSubmit(this.url, this.eles2Params(), this.fun);
			}
		},
		eles2Params : function(){
			var params = this.params;
			if(params.constructor == Function){
				params = params();
			}
			for(var i=0,len=this.elements.length; i<len; i++){
				var ele = this.elements[i].ele;
				params[ele.name || ele.id] = ele.value;
			}
			return params;
		},
		ajaxSubmit : function(url, param, fun){
			$.ajax({
				url : url,
				type : "POST",
				cache:!1,
				dataType : "json",
				data : param,
				context : this,
				async : !1,
				success : fun
			});
		},
		beforeSend : function(xhp){}
	};
	return validator;
})();
