(function() {
    var $, Drifter;
    var __bind = function(fn, me) {
        return function() {
            return fn.apply(me, arguments);
        };
    };
    $ = jQuery;
    Drifter = (function() {
        function Drifter(elem, callback) {
            var dftTitle;
            this.head = elem.find('div.head');
            this.body = elem.find('div.body');
            this.body.bind('mouseup', function(e) {
                e.stopPropagation();
            });
            this.title = this.head.find('.title');
            if (this.title.size() === 0) {
                this.title = this.head.append("<button class=\"title\"></button>").find('.title');
            }
            this.icon = this.head.find('.icon');
            if (this.icon.size() === 0) {
                this.icon = this.head
                        .append(
                                '<button class="icon"><center style=\"*margin-left:-8px;\"><span class=\"close\">&nbsp;&nbsp;&nbsp;&nbsp;</span></center></button>')
                        .find('.icon');
            }
            this.title.click(function(e) {
                return e.preventDefault();
            });
            this.icon.click(function(e) {
                return e.preventDefault();
            });
            this.iconPic = this.icon.find('span');
            this.mouseInside = false;
            this.title.click(__bind(function() {
                return this.icon.trigger('click');
            }, this));
            this.icon.click(__bind(function() {
                return this.toggleBody();
            }, this));
            elem.hover(__bind(function() {
                this.mouseInside = true;
                return true;
            }, this), __bind(function() {
                this.mouseInside = false;
                return true;
            }, this));
            callback.call(this);
        }
        Drifter.prototype.toggleBody = function() {
            if (this.iconPic.hasClass('close')) {

                return this.open();
            } else {
                return this.close();
            }
        };
        Drifter.prototype.open = function() {
            $('body').one('mouseup', __bind(function() {
                if (!this.mouseInside) {
                    this.close();
                    return false;
                }
            }, this));
            this.body.show();
            this.iconPic.removeClass('close');
            return this.iconPic.addClass('open');
        };
        Drifter.prototype.close = function() {
            this.body.hide();
            this.iconPic.removeClass('open');
            return this.iconPic.addClass('close');
        };
        return Drifter;
    })();
    $.fn.drift = function(callback) {
        var THIS, drifter;
        THIS = $(this);
        drifter = new Drifter(THIS, callback);
        THIS.data('drifter', drifter);
        return drifter;
    };
}).call(this);
