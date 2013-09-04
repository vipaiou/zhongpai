// 需要先导入messages-{locale}.js
vmsg = msg.validate;

/**
 * 元素的包裹，可以获取相应的规则，默认值，信息框等
 * 
 * @param ele
 * @returns
 */
var ElemWrapper = function(ele) {
    this.ele = ele;
    this.rules = [];
    this.defaultVal;
    this.hint = null;
    this.preVal = null;
    this.messages = {};
    // TODO: val 应该改为函数
    this.val = ElemWrapper.getVal(ele);
    this.msgNode = null;
    this.required = false;
    this.checkOnBlur = true;
    this.validator = null;
    this.noTick = false;
    this.afterValidate = function(result){};
    return this;
};

/**
 * 获得元素的值 
 */
ElemWrapper.getVal = function(ele) {
    var type = ele && ele.type && ele.type.toLowerCase();
    if (type == 'text' || type == 'textarea' || type == 'password' || type == 'hidden') {
        return ele.value.replace(/^\s+|\s+$/g, '');
    } else {
        return $(ele).val() || "";
    }
};

ElemWrapper.prototype = {
    rulesType : {
        required : function() {
            if (this.val == null) {
                return false;
            }
            return this.required = this.val.length > 0;
        },
        en : function() {
            if (!this.required && (this.val.length == 0))
                return true;
            return /^[a-z]+$/i.test(this.val);
        },
        minLen : function(min) {
            if (!this.required && (this.val.length == 0))
                return true;
            return this.val.length >= min;
        },
        maxLen : function(max) {
            if (!this.required && (this.val.length == 0))
                return true;
            return this.val.length <= max;
        },
        number : function() {
            if (!this.required && (this.val.length == 0))
                return true;
            return /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(this.val);
        },
        gt: function(min) {
            if (!this.required && (this.val.length == 0))
                return true;
            return +(this.val) > min;
        },
        lt: function(min) {
            if (!this.required && (this.val.length == 0))
                return true;
            return +(this.val) < min;
        },
        min : function(min) {
            if (!this.required && (this.val.length == 0))
                return true;
            return +(this.val) >= min;
        },
        max : function(max) {
            if (!this.required && (this.val.length == 0))
                return true;
            return +(this.val) <= max;
        },
        ne : function(v) {
            if (!this.required && (this.val.length == 0))
                return true;
            return this.val != v;
        },
        notin: function(arr) {
            if (!this.required && (this.val.length == 0))
                return true;
            return $.inArray(this.val, arr) < 0;
        },
        depend : function() {
            return false;
        },
        remote : function(options) {
            // 对于服务器验证，如果当前值没有变化，则不再去校验。
            var flg = false;
            var isEmpty = true;
            $.ajax({
                url : options.url,
                type : "POST",
                cache : false,
                dataType : "json",
                data : options.param.call(this) || {},
                context : this,
                async : false,
                success : function(result) {
                    isEmpty = S.isEmptyObj(result);
                    if(isEmpty){
                    }else{
                        flg = result === true;
                        this.updateMsg(this.messages.remote, flg);
                    }
                },
                error : function(){
                    window.location.href = S.url('logout');
                }
            });
            return isEmpty ? '' : flg;
        },
        specialChar : function() {
            return !/[\/\\\:\*\?"<>\|]/g.test(this.val);
        },
        dateFormat: function() {
            return /^\d{4}-\d{2}-\d{2}$/g.test(this.val);
        },
        timeFormat: function() {
            return /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}$/g.test(this.val);
        },
        validDate : function() {
            function isValidDate(d) {
                if ( Object.prototype.toString.call(d) !== "[object Date]" )
                    return false;
                return !isNaN(d.getTime());
            }
            var isFormat =  /^\d{4}-\d{2}-\d{2}$/g.test(this.val);
            var isValid = isValidDate(S.parseDate(this.val));
            return isFormat && isValid;
        },
        validTime: function() {
            function isValidTime(d) {
                if ( Object.prototype.toString.call(d) !== "[object Date]" )
                    return false;
                return !isNaN(d.getTime());
            }
            var ss = this.val.split(' ');
            if (ss.length != 2) {
                return false;
            }
            var dateText = ss[0];
            var timeText = ss[1];
            return isValidTime(new Date(dateText + 'T' + timeText));
        },
        url: function() {
            if (!this.required && (this.val.length == 0))
                return true;
            return /^((https?|ftp):\/\/)?(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(this.val);
        },
        email: function() {
            return /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/.test(this.val);
        }
    },
    remove: function() {
        var eles = this.validator.elements;
        eles.splice(this.index, 1);
        //每次删除元素后需要更新元素的index
        for(var i = 0; i < eles.length; i++){
            eles[i].index = i;
        }
        $(this.ele).data('velem', null);
    },
    /**
     * 给元素添加校验规则
     * 
     * @param rules
     * @returns {ElemWrapper}
     */
    addRules : function(rules) {
        if (rules) {
            var i, o, len = rules.length;
            for (i = 0; i < len; i++) {
                var rule = rules[i];
                if (rule === undefined) {
                    continue;
                }
                var type = rule.constructor;
                if (String == type) {
                    var obj = {};
                    obj[rule] = true;
                    this.rules.push(obj);
                    if (rule == 'required') {
                        this.required = true;
                    }
                } else if (Object == type) {
                    for (o in rule) {
                        var status = rule[o];
                        if (status !== undefined) {
                            var obj = {};
                            obj[o] = status;
                            this.rules.push(obj);
                            if (o == 'required') {
                                this.required = status;
                            }
                        }
                    }
                } else if (Array == type) {
                    var r = rule[0];
                    var msg = rule[1];
                    var tp = r.constructor;
                    if (String == tp) {
                        var obj = {};
                        obj[r] = true;
                        this.rules.push(obj);
                        this.messages[r] = msg;
                        if (r == 'required') {
                            this.required = true;
                        }
                    } else if (Object == tp) {
                        for (o in r) {
                            var status = r[o];
                            if (status !== undefined) {
                                var obj = {};
                                obj[o] = status;
                                this.rules.push(obj);
                                this.messages[o] = msg;
                                if (o == 'required') {
                                    this.required = status;
                                }
                            }
                        }
                    }
                }
            }
        }
        this.bindValidEvent();
        return this;
    },
    updateMsg : function(rule, status) {
        if (!this.msgNode) {
            this.msgNode = this.createMsgNode();
        }
        var forEle = this.msgNode.getAttribute("forele");
        if(!forEle){
            forEle = this.ele.id || this.ele.name;
        }
        if(!(forEle == (this.ele.id || this.ele.name))){
            if(this.msgNode.className.indexOf("error") > -1){
                return ;
            }
        }
        this.msgNode.setAttribute("forele", this.ele.id || this.ele.name);
        if (status) {
            if (this.noTick) {
                this.msgNode.className = "";
                this.msgNode.innerHTML = '';
            } else {
                this.msgNode.className = "valid";
                this.msgNode.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
            }
        } else if(status === false){
            this.msgNode.innerHTML = this.messages[rule] || vmsg.error;
            this.msgNode.className = "error";
        } else {
            this.msgNode.className = "";
            this.msgNode.innerHTML = '';
        }
    },
    addMessages : function(msgObj) {
        if (typeof msgObj == 'object') {
            var dftMsg = msgObj.hint;
            if (dftMsg) {
                this.hint = dftMsg;
                if (!this.msgNode) {
                    this.msgNode = this.createMsgNode();
                }
                delete msgObj.hint;
            }
            for ( var o in msgObj) {
                this.messages[o] = msgObj[o];
            }
        }
        if (this.hint) {
            var that = this;
            $(this.ele).focus(function() {
                that.doHint();
            });
        }
        return this;
    },
    setMsgNode: function(elem) {
        if (typeof elem == 'string') {
            elem = $(elem);
        }
        this.msgNode = elem[0];
        return this;
    },
    createMsgNode : function(rule, status) {
        var next = this.ele.nextSibling;
        var parent = this.ele.parentNode;
        if (next) {
            if (next.nodeType == 1) {
                if (next.nodeName.toLowerCase() == 'span') {
                    return next;
                }
            }
            var span = document.createElement("span");
            parent.insertBefore(span, next);
            return span;
        } else {
            var span = document.createElement("span");
            parent.appendChild(span);
            return span;
        }
    },
    setHint : function(msg) {
    //    if (!this.msgNode) {
    //        this.msgNode = this.createMsgNode();
    //    }
        this.hint = msg || this.hint;
    //    this.msgNode.innerHTML = this.hint;
    //    this.msgNode.className = "hint";
    },
    resetElement : function() {
        this.ele.value = this.defaultVal;
        if (!this.msgNode) {
            this.msgNode = this.createMsgNode();
        }
        this.setHint();
    },
    validate : function() {
        try {
            var o = this;
            var ele = this.ele;
            o.val = ElemWrapper.getVal(ele);
            //if(o.val === o.preVal) return true;
            // o.preVal = o.val;
            // 需要被验证的规则
            var rules = o.rules;
            for ( var i = 0; i < rules.length; i++) {
                var ruleObj = rules[i];
                for ( var rule in ruleObj) {
                    var status = ruleObj[rule];
                    // 系统支持的几种简单验证
                    var fun = o.rulesType[rule];
                    if (fun) {
                        if (typeof status == 'function') {
                            // 是否是依赖关系验证
                            if (rule == 'depend') {
                                if (!status.call(o)) {
                                    o.setHint();
                                    return true;
                                }
                            } else {
                                // 认为是重写了系统默认的验证
                                if (rule == 'required') {
                                    o.required = status.call(o);
                                    if (o.required && !fun.call(o)) {
                                        o.updateMsg.call(o, rule, false);
                                        o.afterValidate(false);
                                        return false;
                                    }
                                } else {
                                    if (o.val.length > 0 && !status.call(o)) {
                                        o.updateMsg.call(o, rule, false);
                                        o.afterValidate(false);
                                        return false;
                                    }
                                }
                            }
                        } else {
                            if (status !== undefined) {
                                if (rule == 'required') {
                                    if ((o.required = status) && !fun.call(o, status)) {
                                        o.updateMsg.call(o, rule, false);
                                        o.afterValidate(false);
                                        return false;
                                    }
                                } else {
                                    var rst = fun.call(o, status);
                                    if (o.val.length > 0 && !rst) {
                                        o.updateMsg.call(o, rule, rst);
                                        o.afterValidate(false);
                                        return false;
                                    }
                                }
                            }
                        }
                    } else {
                        // 自定义事件
                        if (typeof status == 'function') {
                            if (!status.call(o)) {
                                o.updateMsg.call(o, rule, false);
                                o.afterValidate(false);
                                return false;
                            };
                        } else {
                            Log.warn("不支持的简单验证规则：[" + rule + "]");
                        }
                    }
                }
            }
            o.updateMsg.call(o, '', true);
            o.afterValidate(true);
            return true;
        } catch (e) {
            Log.error(e);
            return false;
        }
    },
    setAfterValidate : function(fun){
        this.afterValidate = fun;
    }
};

var Validator = function(options) {
    var that = this;
    this.elements = [];
    this.groups = [];
    this.resetCheckboxNames = {};
    this.resetRadioNames = {};
    this.resetSelectedNames = {};
    this.resetOtherNames = {};
    this.form = typeof options.form == "string" ? $(options.form)[0] : options.form;
    this.beforeSubmit = function(){return true;};
    var submitObj = options.submit;
    if (submitObj) {
        if (typeof submitObj == 'string') {
            submitObj = {
                node : submitObj
            };
        }
        var submitNode = typeof submitObj.node == 'string' ? $(submitObj.node)[0] : submitObj.node;
        var method = submitObj.method || 'normal';
        var url = submitObj.url || this.form.action;
        var param = submitObj.param || {};
        if ($.isFunction(param)) {
            param = param();
        }

        var fn = submitObj.callback;
        submitNode.clickCount = 0;
        submitNode.onclick = function(e) {
            if (this.clickCount++ > 0) {
                return false;
            }
            if(!that.beforeSubmit()) return false;
            var valid = false;
            if (method == 'ajax') {
                valid = that.ajaxSubmit(url, param, fn);
            } else {
                valid = that.submitForm(url);
            }
            if (!valid) {
                this.clickCount = 0;
            }
            return valid;
        };
    }
    var resetNode = options.reset;
    if (resetNode) {
        resetNode.onclick = function(e) {
            if (e && e.preventDefault)
                e.preventDefault();
            else
                window.event.returnValue = false;
            that.resetForm();
        };
        this.setOtherDefaultVal();
    }
};


Validator.prototype = {
    element : function(ele) {
        if (!ele)
            return false;
        ele = typeof ele == 'string' ? $(ele)[0] : ele;
        delete this.resetOtherNames[ele.name];
        var o = new ElemWrapper(ele);
        o.defaultVal = ElemWrapper.getVal(ele);
        o.index = this.elements.length;
        o.validator = this;
        $(ele).data('velem', o);
        $(ele).bind('validate', function() {
            var valid = o.validate();
            if (valid) {
                $(ele).trigger('validate-success');
            }
            return valid;
        });
        this.elements.push(o);
        return o;
    },
    resetForm : function() {
        // 重设验证的ele
        for ( var i = 0; i < this.elements.length; i++) {
            var ElemWrapper = this.elements[i];
            ElemWrapper.resetElement();
        }
        // 重设checkbox
        for ( var o in this.resetCheckboxNames) {
            for ( var so in this.resetCheckboxNames[o]) {
                var eles = document.getElementsByName(o);
                for ( var j = 0; j < eles.length; j++) {
                    if (eles[j].value === so) {
                        eles[j].checked = this.resetCheckboxNames[o][so];
                        break;
                    }
                }
            }
        }
        // 重设radio
        for ( var o in this.resetRadioNames) {
            for ( var so in this.resetRadioNames[o]) {
                var eles = document.getElementsByName(o);
                for ( var j = 0; j < eles.length; j++) {
                    if (eles[j].value === so) {
                        eles[j].checked = this.resetRadioNames[o][so];
                        break;
                    }
                }
            }
        }
        // 重设select
        for ( var o in this.resetSelectedNames) {
            document.getElementsByName(o)[0].value = this.resetSelectedNames[o];
        }
        // 重设text，password，textarea
        for ( var o in this.resetOtherNames) {
            document.getElementsByName(o)[0].value = this.resetOtherNames[o];
        }
    },
    submitForm : function(url) {
        var valid = this.validate();
        if (!valid) {
            if (url)
                this.form.action = url;
            return false;
        };
        return true;
    },
    validate: function() {
        var flag = true;
        for ( var i = 0; i < this.elements.length; i++) {
            var eleWapper = this.elements[i];
            if (!eleWapper.validate()) {
                flag =  false;
            }
        }
        for (var i = 0; i < this.groups.length; ++i) {
            if ('valid' != this.groups[i].validateAll()) {
                flag = false;
            }
        }
        return flag;
    },
    ajaxSubmit : function(url, param, fn) {
        var flg = true;
        for ( var i = 0; i < this.elements.length; i++) {
            var eleWapper = this.elements[i];
            if (!eleWapper.validate())
                flg = false;
        }
        if (flg) {
            $.ajax({
                url : url,
                type : "POST",
                cache : false,
                dataType : "json",
                data : param,
                context : this,
                async : false,
                success : fn
            });
        }
        return false;
    },
    setOtherDefaultVal : function() {
        for ( var i = 0; i < this.form.elements.length; i++) {
            var ele = this.form.elements[i];
            if (ele.name) {
                var type = ele.type;
                switch (type) {
                case 'radio':
                    if (!this.resetRadioNames[ele.name]) {
                        this.resetRadioNames[ele.name] = {};
                    }
                    this.resetRadioNames[ele.name][ele.value] = ele.checked;
                    break;
                case 'checkbox':
                    if (!this.resetCheckboxNames[ele.name]) {
                        this.resetCheckboxNames[ele.name] = {};
                    }
                    this.resetCheckboxNames[ele.name][ele.value] = ele.checked;
                    break;
                case 'select-one':
                    if (!this.resetSelectedNames[ele.name]) {
                        this.resetSelectedNames[ele.name] = ele.value;
                    }
                    break;
                case 'text':
                case 'password':
                case 'textarea':
                    if (!this.resetOtherNames[ele.name]) {
                        this.resetOtherNames[ele.name] = ele.value;
                    }
                }
            }
        }
    }
};

(function($) {
    $.fn.validate = function() {
        var velem = $(this).data('velem');
        if (velem) {
            return velem.validate();
        }
        return false;
    };
})(jQuery);