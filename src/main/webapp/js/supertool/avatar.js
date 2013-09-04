(function() {
  var $, Avatar;
  $ = jQuery;
  Avatar = (function() {
    function Avatar(elem, target, options) {
      this.elem = elem;
      if (typeof target === 'string') {
        target = $(target);
      }
      this.target = target;
      this.options = options != null ? options : {};
      this.hidden = true;
    }
    Avatar.prototype.get = function() {
      return this.target;
    };
    Avatar.prototype.show = function() {
      this.target.show();
      this.elem.hide();
      return this.hidden = false;
    };
    Avatar.prototype.hide = function() {
      this.target.hide();
      this.elem.show();
      return this.hidden = true;
    };
    Avatar.prototype.toggle = function() {
      if (this.hidden) {
        return this.show();
      } else {
        return this.hide();
      }
    };
    return Avatar;
  })();
  $.fn.avatar = function(target, options) {
    var av, rebirth, _ref;
        if (options != null) {
      options;
    } else {
      options = {};
    };
    rebirth = (_ref = options.rebirth) != null ? _ref : false;
    av = $(this).data('avatar');
    if (!av || rebirth) {
      av = new Avatar($(this), target, options);
      $(this).after(av.get());
      $(this).data('avatar', av);
      av.show();
    }
    return av;
  };
  $.fn.showAvatar = function() {
    return $(this).data('avatar').show();
  };
  $.fn.hideAvatar = function() {
    return $(this).data('avatar').hide();
  };
}).call(this);
