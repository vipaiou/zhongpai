/**
 * 对Jquery.Validate插件的扩展:
 * 
 * 1. 失去焦点时必然检验
 * 
 * 2. 在控件右侧放一个<span>来存放事前信息： 
 * <code>
 *      <span class="hint">
 *          <label class="fontGray">{事前信息}</label>
 *      </span>
 * </code>
 * 
 *    验证后的错误和正确信息，都会覆盖式填入这个<span>中(事前信息的label被隐藏)
 * 
 * 3. 如果一行有几个input控件，则应当把他们组合起来，错误信息统一输出到该行最右侧的事前信息<span>里
 *    如：
 *    $('theForm').validate({
 *       rules: {
 *          'firstName' : { ..blahblah.. },
 *          'lastName' : {..blahblah.. }
 *       },
 *       groups: {
 *          'userName' : "firstName lastName"
 *       }
 *    });
 *    这样的话，firstName和lastName的错误信息会输出到同一个<span>中
 * 
 * 4. 声明rules时，可以在开头写一个depends属性，用来控制控件下的全部rule是否被校验
 * (默认的jquery.validate只能在具体的rule一层单独声明depends:
 * 
 * 例如：
 * 
 * $('theForm').validate({
 *    rules: {
 *        'userName' : {
 *           depends: function() { return $('#selectUser').val() == '1'; },
 *           required: true,
 *           minlength: 10,
 *           maxlength: 100
 *        },
 *    }
 * })
 * 
 * 表示'userName'这个控件只有在 '#selectUser'的下拉框选择值等于 '1' 时才进行校验.
 * 
 * 相当于未扩展之前的
 * $('theForm').validate({
 *    rules: {
 *        'userName' : {
 *           required: function() { return $('#selectUser').val() == '1'; },
 *           minlength: {
 *              depends: function() { return $('#selectUser').val() == '1'; },
 *              value: 10,
 *           }
 *           maxlength: {
 *              depends: function() { return $('#selectUser').val() == '1'; },
 *              value: 10,
 *           }
 *        },
 *    }
 * })
 * 
 * P.S.:
 * 
 * 另外，并不是每次声明validate都需要写message属性，如果没写，会使用defaults里面的message
 * 我们已经对系统默认的message添加了国际化支持，放在
 *    /jsp/include/validate.jsp
 * 里。
 * 
 * 以后使用jquery.validate时，直接在JSP页面的<head>里导入
 * <%@ include file="/jsp/include/validate.jsp" %>
 * 即可
 */
(function($) {
$.extend($.validator.defaults, {
    errorClass: 'validateError',
    // 失去焦点： 直接校验
    onfocusout: function(element) {
    //    if ( !this.checkable(element) && (element.name in this.submitted || !this.optional(element)) ) {
    //        this.element(element);
    //    }
        if ($(element).hasClass('ignored')) return;
        if ($(element).hasClass('validateOnChange')) return;
        if ($(element).hasClass('datepicker')) {
            if (datapicker.exist()) {
                return;
            }
        }
        this.element(element);
//        if (this.check(element)) {
//            this.showErrorFor(element);
//        } else {
//            var siblings = this.siblingsOf(element);
//            var succMap = {};
//            for (var i = 0; i < siblings.length; ++i) {
//                succMap[siblings[i].name] = this.check(siblings[i]);
//            }
//        }
    },

    onkeyup: function(element) {
      //  if ( element.name in this.submitted || element == this.lastElement ) {
      //      this.element(element);
      //  }
    },
    // 显示错误信息: 寻找'.hint'的span，覆盖填入
    errorPlacement: function(error, element) {
        var hint = element.nextAll('.hint').first();
        if(hint[0]) {
            hint.find('label.fontGray').hide().end()
                .append(error);
        } else {
            error.text(error.text());
            error.insertAfter(element);
        }
    }, 
    success: function(label) {
        label.removeClass('validateError').addClass('valid').html('&nbsp;&nbsp;');
    }

});


$.extend($.validator.prototype, {

    element: function( element, force ) {
        if(force){
            $.data($(element)[0], "previousValue", {
                old: null,
                valid: true,
                message: this.defaultMessage( $(element)[0], "remote" )
            });
        }
        var e = this;
        function doElement(ele) {
            ele = e.clean(ele);
            e.lastElement = ele;
            e.prepareElement( ele );
            e.currentElements = $(ele);
            return result = e.check(ele);
        }
        if (doElement(element)) {
            delete this.invalid[element.name];
            var siblings = this.siblingsOf(element);
            for (var i = 0; i < siblings.length; ++i) {
                var sib = siblings[i];
                //if ($.inArray(sib, this.invalidElements()) < 0) continue;
                if (doElement(sib)) {
                    delete this.invalid[sib.name];
                } else {
                    this.invalid[sib.name] = true;
                    break;
                }
            }
            this.showErrors();
        } else {
            this.invalid[element.name] = true;
            this.showErrors();
        }
        if ( !this.numberOfInvalids() ) {
            // Hide error containers on last error
            this.toHide = this.toHide.add( this.containers );
        }
        return result;
    },
    // 校验元素控件，先检验是否有depends属性
    check: function( element ) {
        element = this.clean( element );
        
        // if radio/checkbox, validate first element in group instead
        if (this.checkable(element)) {
            element = this.findByName( element.name )[0];
        }
        
        var rules = $(element).rules();
        
        // {{ 扩展： 增加对整个rule定义的depends支持
        var rules = $(element).rules();
        if ('depends' in rules) {
            if (!rules.depends) {
                this.successList.push(element);
                return true;
            }
            delete rules.depends;
        }
        // }}
 
        var dependencyMismatch = false;
        for( method in rules ) {
            var rule = { method: method, parameters: rules[method] };
            try {
                var result = $.validator.methods[method].call( this, element.value.replace(/\r/g, ""), element, rule.parameters );
                
                // if a method indicates that the field is optional and therefore valid,
                // don't mark it as valid when there are no other rules
                if ( result == "dependency-mismatch" ) {
                    dependencyMismatch = true;
                    continue;
                }
                dependencyMismatch = false;
                
                if ( result == "pending" ) {
                    this.toHide = this.toHide.not( this.errorsFor(element) );
                    return;
                }
                
                if( !result ) {
                    this.formatAndAdd( element, rule );
                    return false;
                }
            } catch(e) {
                this.settings.debug && window.console && console.log("exception occured when checking element " + element.id
                     + ", check the '" + rule.method + "' method", e);
                throw e;
            }
        }
        if (dependencyMismatch)
            return;
        if ( this.objectLength(rules) )
            this.successList.push(element);
        return true;
    },

    showLabel: function(element, message) {
        var label = $.merge(this.errorsFor( element ), this.validsFor(element));
        if ( label.length ) {
            // refresh error/success class
            label.removeClass().addClass( this.settings.errorClass );
            // check if we have a generated label, replace the message then
            label.attr("generated") && label.html(message);
        } else {
            // create label
            label = $("<" + this.settings.errorElement + "/>")
                .attr({"for":  this.idOrName(element), generated: true})
                .addClass(this.settings.errorClass)
                .html(message || "");
            if ( this.settings.wrapper ) {
                // make sure the element is visible, even in IE
                // actually showing the wrapped element is handled elsewhere
                label = label.hide().show().wrap("<" + this.settings.wrapper + "/>").parent();
            }
            if ( !this.labelContainer.append(label).length )
                this.settings.errorPlacement
                    ? this.settings.errorPlacement(label, $(element) )
                    : label.insertAfter(element);
        }
        if ( !message && this.settings.success ) {
            label.text("");
            if ($.trim($(element).val()).length == 0) {
                label.hide();
            } else {
                typeof this.settings.success == "string"
                    ? label.addClass( this.settings.success )
                    : this.settings.success( label );
            }
        }
        this.toShow = this.toShow.add(label);
    },

    defaultShowErrors: function() {
        // 把默认的错误显示顺序从先显示错误再显示成功 变为 先显示成功再显示错误信息
        // 以防止在组合校验时，错误信息被后来的成功信息覆盖的问题
        // first: show success
        if (this.settings.success) {
            for ( var i = 0; this.successList[i]; i++ ) {
                this.showLabel( this.successList[i] );
            }
        }
        // second: show errors
        for ( var i = 0; this.errorList[i]; i++ ) {
            var error = this.errorList[i];
            this.settings.highlight && this.settings.highlight.call( this, error.element, this.settings.errorClass, this.settings.validClass );
            this.showLabel( error.element, error.message );
        }
        if( this.errorList.length ) {
            this.toShow = this.toShow.add( this.containers );
        }
        if (this.settings.unhighlight) {
            for ( var i = 0, elements = this.validElements(); elements[i]; i++ ) {
                this.settings.unhighlight.call( this, elements[i], this.settings.errorClass, this.settings.validClass );
            }
        }
        this.toHide = this.toHide.not( this.toShow );
        this.hideErrors();
        this.addWrapper( this.toShow ).show();
    },
    siblingsOf: function(element) {
        if (element.name in this.groups) {
            var groupName = this.groups[element.name];
            var memberNames = this.settings.groups[groupName].split(' ');
            var members = [];
            for (var i = 0; i < memberNames.length; ++i) {
                members = members.concat($(element).siblings('[name="' + memberNames[i] + '"]').toArray());
            }
            return members;
        } else {
            return [];
        }
    },
    groupOf: function(element) {
        var members = [element];
        if (element.name in this.groups) {
            var groupName = this.groups[element.name];
            var memberNames = this.settings.groups[groupName].split(' ');
            for (var i = 0; i < memberNames.length; ++i) {
                members = members.concat($(element).siblings('[name="' + memberNames[i] + '"]').toArray());
            }
        }
        return members;
    },
    addGroup: function(group) {
        $.extend(this.settings.groups, group);
        var curGroups = this.groups;
        if (!curGroups) this.groups = {};
        $.each(group, function(key, value) {
            $.each(value.split(/\s/), function(index, name) {
                curGroups[name] = key;
            });
        });
    },
    valids: function() {
        return $( this.settings.errorElement + "." + this.settings.validClass, this.errorContext );
    },
    
    validsFor: function(element) {
        var name = this.idOrName(element);
        return this.valids().filter(function() {
            return $(this).attr('for') == name;
        });
    },
    resetMessages: function() {
        $(this.currentForm).find('span.hint').show().each(function() {
            $(this).find('label.fontGray').show();
            $(this).find('label.valid,label.validateError').remove();
        });
        $(this.currentForm).find('label.valid,label.validateError').remove();
    }

    /*,
    optional: function(element) {
        //return !$.validator.methods.required.call(this, $.trim(element.value), element) && "dependency-mismatch";
        return true;
    }
    ,
    
    idOrName: function(element) {
        //return this.groups[element.name] || (this.checkable(element) ? element.name : element.id || element.name);
        return (this.checkable(element) ? element.name : element.id || element.name);
    }*/
});

})(jQuery);

/**
 * 修改验证URL的算法 (http://头可以没有)
 */
$.extend($.validator.methods, {
    imgUrl: function(value, element) {
        return checkImg(value);
    },
    flashUrl: function(value, element) {
        return checkFls(value);
    },
    normalUrl: function(value, element) {
        return checkUrl(value);
    },
    flvUrl: function(value, element) {
        return checkFlv(value);
    },
    urlRequired: function(value, element) {
        return checkUrlRequired(value, element);
    },
    urlOptional: function(value, element) {
        return !checkUrlRequired(value, element) || checkUrl(value);
    },
	
	maxbytelength: function(value, element, param) {		
		return this.optional(element) || value.replace(/[^\x00-\xff]/g,'**').length <= param;
	},
	match: function(value, element, param){
		return this.optional(element) || param.test(value);
	},
	contain :function(value,element,param){
		return value.indexOf(param)!=-1;
	},
	classConflict : function(value, element, param){
		if ( this.optional(element) )
		return "dependency-mismatch";
		
		var previous = this.previousValue(element);
		
		if (!this.settings.messages[element.name] )
		this.settings.messages[element.name] = {};
		this.settings.messages[element.name].remote = typeof previous.message == "function" ? previous.message(value) : previous.message;
		
		param = typeof param == "string" && {url:param} || param; 
		
		if ( previous.old !== value ) {
		previous.old = value;
		var validator = this;
		this.startRequest(element);
		var data = {};
		data[element.name] = value;
		$.ajax($.extend(true, {
			url: param,
			mode: "abort",
			port: "validate" + element.name,
			dataType: "json",
			data: data,
			success: function(response) {
				var valid = response === true;
				if ( valid ) {
					var submitted = validator.formSubmitted;
					validator.prepareElement(element);
					validator.formSubmitted = submitted;
					validator.successList.push(element);
					validator.showErrors();
				} else {
					var errors = {};
					errors[element.name] = previous.message = response || validator.defaultMessage( element, "classConflict" );
					validator.showErrors(errors);
				}
				previous.valid = valid;
				validator.stopRequest(element, valid);
	}
}, param));
return "pending";
} else if( this.pending[element.name] ) {
return "pending";
}
return previous.valid;
}
});
function checkImg(value){
    return /\.((jpe?g)|(gif)|(bmp)|(png))$/i.test(value);
}
function checkFls(value){
    return /\.swf$/i.test(value);
}
function checkFlv(value){
    return /\.flv$/i.test(value);
}
function checkUrl(value){
    if(/^((https?|ftp):\/\/)/i.test(value)){
        return /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(value);
    }else{
        return /^(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(value);
    }
}
function checkUrlRequired(value, element){
    $(element).val($.trim($(element).val()));
    return value.replace(/^((https?|ftp):\/\/)/i, "").length > 0;
}

/**
 * 扩充验证算法
 */
$.validator.addMethod('isContentRootNO', function(value, element, param) {
	return $.trim(value) != "0";
}, "0为根节点标识，请重新输入");

$.validator.addMethod('validGlobalID', function(value, element, param) {
	var regx  = new RegExp("^[a-zA-Z0-9-_+=&#.]*$");
	return regx.test($.trim(value));
}, "not valid global id");

$.validator.addMethod('globalId', function(value, element, param) {
    var regx  = new RegExp("^[a-zA-Z0-9-]*$");
    return regx.test($.trim(value));
}, "not valid global id");

$.validator.addMethod('validCharacter', function(value, element, param) {
	var regx  = new RegExp("^[^\/\:\：\*\?\？\"\“\<\>\|\\\\]*$");
	return regx.test(value);
}, "not valid character");

$.validator.addMethod('time', function(value, element) {
    function validTime(timeStr) {
        if (typeof(timeStr) != 'string') return false;
        var pattern = /^((([0]?[1-9]|1[0-2])(:)[0-5][0-9]((:)[0-5][0-9])?( )?(AM|am|aM|Am|PM|pm|pM|Pm))|(([0]?[0-9]|1[0-9]|2[0-3])(:)[0-5][0-9]((:)[0-5][0-9])?))$/;
        return (pattern.test(timeStr));
    }
    return this.optional(element) || validTime(value);
}, "Error Time Format, correct: hh:mm");

$.validator.addMethod('regex', function(value, element, param) {
    return this.optional(element) || param.test(value);
}, "Regex test failed");

$.validator.addMethod('password', function(value, element, param) {
    //var pattern = /^[A-Za-z0-9.-_!~#%]{6,16}$/;
    var pattern = /^[\S]{6,16}$/;
    return this.optional(element) || pattern.test(value);
}, "Password format invalid ");

$.validator.addMethod('mail', function(value, element, param) {
    // 与ConditionalEmailFieldValidator保持一致。
    //var pattern = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))+\.?$/i;
    var pattern = /^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*[0-9a-zA-Z]+))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|NET|com|COM|gov|GOV|mil|MIL|org|ORG|edu|EDU|int|INT|cn|CN|tv|)$/i;
    //var pattern = /\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*$)\b/;
    //var pattern = /.*@.*/;
    return this.optional(element) || pattern.test(value);
}, "Email format invalid");


// TODO: le, ge 因为之用在时间判断上过，因此错误的做了时间判定，以后应该改为 'before', 'after'之类，le, ge应当是数字大小的判断
$.validator.addMethod('le', function(value, element, param) {
    var pattern = /^((([0]?[1-9]|1[0-2])(:|\.)[0-5][0-9]((:|\.)[0-5][0-9])?( )?(AM|am|aM|Am|PM|pm|pM|Pm))|(([0]?[0-9]|1[0-9]|2[0-3])(:|\.)[0-5][0-9]((:|\.)[0-5][0-9])?))$/;
    if (!pattern.test(param)) return true;
    if (!pattern.test(value)) return true;
    return value <= param;
}, "Value should be less or equal to {0}");

$.validator.addMethod('ge', function(value, element, param) {
    var pattern = /^((([0]?[1-9]|1[0-2])(:|\.)[0-5][0-9]((:|\.)[0-5][0-9])?( )?(AM|am|aM|Am|PM|pm|pM|Pm))|(([0]?[0-9]|1[0-9]|2[0-3])(:|\.)[0-5][0-9]((:|\.)[0-5][0-9])?))$/;
    if (!pattern.test(param)) return true;
    if (!pattern.test(value)) return true;
    return value >= param;
}, "Value should be greater or equal to {0}");

$.validator.addMethod('lt', function(value, element, param) {
    return +value < +param;
}, "Value should be less than {0}");

$.validator.addMethod('gt', function(value, element, param) {
    return +value > +param;
}, "Value should be greater than {0}");

$.validator.addMethod('between', function(value, element, param) {
    return value >= param[0] && value <= param[1];
}, "Value should be between {0}, {1}");

$.validator.addMethod('equalToExpressionType', function(value, element, param) {
    return this.optional(element) || value == param;
}, "the defaultCreative expresstionType should be equal to the selected expressionType");

$.validator.addMethod('nomalName', function(value, element, param) {
    var pattern = /^[\u3E00-\u9FA5a-zA-Z0-9_]+$/;
    return this.optional(element) || pattern.test($.trim(value));
}, "名字只能输入汉字，字母，数字或_，请重新输入。");

$.validator.addMethod('unique', function(value, element, param) {

    if ( this.optional(element) )
        return "dependency-mismatch";

    var prefix = '';
    if (undefined !== param.form && '' != param.form) {
        prefix = param.form + '.';
    }
    var data = {};
    for (var i in param.data) {
        data[prefix + i] = param.data[i];
    }
    if (undefined !== param.uniqueField && '' != param.uniqueField) {
        data[prefix + 'uniqueField'] = param.uniqueField;
    } else {
        var name = $(element).attr('name');
        var parts = name.split('.');
        if (parts.length > 1) {
            name = parts[parts.length - 1];
        }
        data[prefix + 'uniqueField'] = name;
    }

    if (undefined !== param.uniqueValue && '' != param.uniqueValue) {
        data[prefix + 'uniqueValue'] = param.uniqueField;
    } else {
        data[prefix + 'uniqueValue'] = $(element).val();
    }

    
    var previous = this.previousValue(element);
    if (!this.settings.messages[element.name] )
        this.settings.messages[element.name] = {};
    previous.originalMessage = this.settings.messages[element.name].remote;
    this.settings.messages[element.name].remote = previous.message;
    
    var url;
    if (typeof param == "string") {
        url = param;
    } else {
        url = param.url;
    }
    
    if ( previous.old !== value ) {
        previous.old = value;
        var validator = this;
        this.startRequest(element);
        $.ajax($.extend(true, {
            url: url,
            mode: "abort",
            port: "validate" + element.name,
            type: 'POST',
            dataType: "json",
            data: data,
            success: function(response) {
                validator.settings.messages[element.name].remote = previous.originalMessage;
                var valid = response === true;
                if ( valid ) {
                    var submitted = validator.formSubmitted;
                    validator.prepareElement(element);
                    validator.formSubmitted = submitted;
                    validator.successList.push(element);
                    validator.showErrors();
                } else {
                    var errors = {};
                    var message = (previous.message = response || validator.defaultMessage( element, "unique" ));
                    errors[element.name] = $.isFunction(message) ? message(value) : message;
                    validator.showErrors(errors);
                }
                previous.valid = valid;
                validator.stopRequest(element, valid);
            }
        }, param));
        return "pending";
    } else if( this.pending[element.name] ) {
        return "pending";
    }
    return previous.valid;
}, "the field is not unique");
$.validator.addMethod('checkUsername',function(value, element, param) {
	if ( this.optional(element) ) {
		return "dependency-mismatch";
	}
	var previous = this.previousValue(element);
	if (!this.settings.messages[element.name] ) {
		this.settings.messages[element.name] = {};
	}
	previous.originalMessage = this.settings.messages[element.name].remote;
	this.settings.messages[element.name].remote = previous.message;

	param = typeof param === "string" && {url:param} || param;

	if ( this.pending[element.name] ) {
		return "pending";
	}
	if ( previous.old === value ) {
		return previous.valid;
	}

	previous.old = value;
	var validator = this;
	this.startRequest(element);
	var data = {};
	data[element.name] = value;
	$.ajax($.extend(true, {
		url: param,
		mode: "abort",
		port: "validate" + element.name,
		dataType: "json",
		data: data,
		success: function(response) {
			validator.settings.messages[element.name].remote = previous.originalMessage;
			var valid = response === true || response === "true";
			if ( valid ) {
				var submitted = validator.formSubmitted;
				validator.prepareElement(element);
				validator.formSubmitted = submitted;
				validator.successList.push(element);
				delete validator.invalid[element.name];
				validator.showErrors();
			} else {
				var errors = {};
				var message = response || validator.defaultMessage( element, "checkUsername" );
				errors[element.name] = previous.message = $.isFunction(message) ? message(value) : message;
				validator.invalid[element.name] = true;
				validator.showErrors(errors);
			}
			previous.valid = valid;
			validator.stopRequest(element, valid);
		}
	}, param));
	return "pending";
},"!!!");
function checkPassword(value, element, param) {
	if ( this.optional(element) ) {
		return "dependency-mismatch";
	}

	var previous = this.previousValue(element);
	if (!this.settings.messages[element.name] ) {
		this.settings.messages[element.name] = {};
	}
	previous.originalMessage = this.settings.messages[element.name].remote;
	this.settings.messages[element.name].remote = previous.message;

	param = typeof param === "string" && {url:param} || param;

	if ( this.pending[element.name] ) {
		return "pending";
	}
	if ( previous.old === value ) {
		return previous.valid;
	}

	previous.old = value;
	var validator = this;
	this.startRequest(element);
	var data = {};
	data[element.name] = value;
	$.ajax($.extend(true, {
		url: param,
		mode: "abort",
		port: "validate" + element.name,
		dataType: "json",
		data: data,
		success: function(response) {
			validator.settings.messages[element.name].remote = previous.originalMessage;
			var valid = response === true || response === "true";
			if ( valid ) {
				var submitted = validator.formSubmitted;
				validator.prepareElement(element);
				validator.formSubmitted = submitted;
				validator.successList.push(element);
				delete validator.invalid[element.name];
				validator.showErrors();
			} else {
				var errors = {};
				var message = response || validator.defaultMessage( element, "remote" );
				errors[element.name] = previous.message = $.isFunction(message) ? message(value) : message;
				validator.invalid[element.name] = true;
				validator.showErrors(errors);
			}
			previous.valid = valid;
			validator.stopRequest(element, valid);
		}
	}, param));
	return "pending";
}
/**
 * 限制TextArea的输入长度最大限制
 * @return
 */
function maxLength() {
    $('textarea[maxlength]').unbind('propertychange').bind('propertychange', limitLength).unbind('input').bind('input', limitLength);
    function  limitLength(){
        //get the limit from maxlength attribute
        var limit = Number($(this).attr('maxlength'));
        //get the current text inside the textarea
        var text = $(this).val();
        //count the number of characters in the text
        var chars = text.length;
        //check if there are more characters then allowed
        if(chars > limit){
            //and if there are use substr to get the text before the limit
            var new_text = text.substr(0, limit);
            //and change the current text with the new text
            $(this).val(new_text);
        }
    }
}
/*
 * 
 */
//直接对所有的textarea添加限制
$(document).ready(function() {
    maxLength();
});