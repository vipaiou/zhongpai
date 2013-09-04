(function() {
    var $;
    var __bind = function(fn, me) {
        return function() {
            return fn.apply(me, arguments);
        };
    };
    $ = jQuery;
    /*
     * # Util
     */
    $.fn.attrs = function(attrs) {
        var k, v;
        if (!(attrs != null)) {
            $(this)[0].attributes;
        }
        if ($.isPlainObject(attrs)) {
            for (k in attrs) {
                v = attrs[k];
                $(this).attr(k, v);
            }
        }
        return $(this);
    };
    $.fn.vals = function() {
        return $(this).map(function() {
            return this.value;
        });
    };
    $.fn.disable = function() {
        if (!($(this).is('button') || $(this).is('input'))) {
            return;
        }
        this.addClass('disabled');
        this[0].disabled = true;
    };
    $.fn.enable = function() {
        this.removeClass('disabled');
        this[0].disabled = false;
    };
    $.fn.switchFor = function(cond) {
        if (cond) {
            return this.enable();
        } else {
            return this.disable();
        }
    };
    /*
     * # Events
     */
    $.fn.valueChange = function(handler) {
        var bindName;
        bindName = 'input';
        if ($.browser.isIE) {
            bindName = 'propertychange';
        }
        return $(this).bind(bindName, handler);
    };
    $.fn.enter = function(handler, other) {
        return $(this).keydown(__bind(function(event, elem) {
            if (event.keyCode === 13) {
                handler.apply(this, [ event ]);
                return false;
            } else {
                if ((other != null) && $.isFunction(other)) {
                    return other.apply(this, [ event ]);
                } else {
                    return true;
                }
            }
        }, this));
    };
    $.fn.delegateEnter = function(selector, handler, other) {
        return $(this).delegate(selector, 'keydown', __bind(function(event, elem) {
            if (event.keyCode === 13) {
                handler.call(this, event);
                return false;
            } else {
                if ((other != null) && $.isFunction(other)) {
                    return other.call(this, event);
                } else {
                    return true;
                }
            }
        }, this));
    };
    $.fn.disableLink = function() {
        return $(this).addClass('disabled');
    };
    $.fn.enableLink = function() {
        return $(this).removeClass('disabled');
    };
}).call(this);
