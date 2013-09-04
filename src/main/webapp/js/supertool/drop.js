(function() {
  var $, Drop, DropChecker, LiDropChecker, checkTitle, defaultMsg, dftTemplate, makeContent, toDrop;
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; }, __hasProp = Object.prototype.hasOwnProperty, __extends = function(child, parent) {
    for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; }
    function ctor() { this.constructor = child; }
    ctor.prototype = parent.prototype;
    child.prototype = new ctor;
    child.__super__ = parent.prototype;
    return child;
  };
  $ = jQuery;
  Drop = (function() {
    function Drop(elem, options) {
      var content, originalContent, transform, _ref, _ref2;
      this.elem = elem;
      this.options = options != null ? options : {};
      originalContent = (_ref = this.options.content) != null ? _ref : this.findContent();
      transform = (_ref2 = this.options.transform) != null ? _ref2 : this.transform;
      content = makeContent(originalContent, transform);
      this.drop = toDrop(this.template(), content);
      this.head = this.drop.find('div.drop-head');
      this.title = this.drop.find('a.drop-title');
      this.content = this.drop.find('div.drop-content');
      this.onContentOK();
      this.mouseInside = false;
      this.initEvents();
    }
    Drop.prototype.template = function() {
      return dftTemplate;
    };
    Drop.prototype.transform = function(x) {
      return x;
    };
    Drop.prototype.findContent = function() {
      return this.elem.find('.content');
    };
    Drop.prototype.findItems = function() {
      return this.content.find('li');
    };
    Drop.prototype.onContentOK = function() {};
    Drop.prototype.onItemClick = function(event, item) {
      return this.elem.trigger('itemClick', [item]);
    };
    Drop.prototype.getVal = function(item) {
      return item.val();
    };
    Drop.prototype.initEvents = function() {
      this.findItems().click(__bind(function(e) {
        return this.onItemClick.apply(this, [e, $(e.target)]);
      }, this));
      this.drop.hover(__bind(function() {
        this.mouseInside = true;
        return true;
      }, this), __bind(function() {
        this.mouseInside = false;
        return true;
      }, this));
      $('body').mouseup(__bind(function(e) {
        if (!this.mouseInside) {
          return this.close();
        }
      }, this));
      return this.title.click(__bind(function(event) {
        if (this.disabled()) {
          return;
        }
        if (!this.title.hasClass('menu-open')) {
          return this.open();
        } else {
          return this.close();
        }
      }, this));
    };
    Drop.prototype.clean = function() {
      this.elem.empty();
      return this.content.empty();
    };
    Drop.prototype.refresh = function() {
      var content;
      content = makeContent(this.findContent(), this.transform);
      this.content.empty().html(content);
      this.findItems().click(__bind(function(e) {
        return this.onItemClick.apply(this, [e, $(e.target)]);
      }, this));
      return this.onContentOK();
    };
    Drop.prototype.close = function() {
      this.title.removeClass('menu-open');
      return this.content.hide();
    };
    Drop.prototype.open = function() {
      this.title.addClass('menu-open');
      return this.content.show();
    };
    Drop.prototype.disabled = function() {
      return this.title.hasClass('disabled');
    };
    Drop.prototype.disable = function() {
      this.close();
      return this.title.addClass('disabled');
    };
    Drop.prototype.enable = function() {
      return this.title.removeClass('disabled');
    };
    return Drop;
  })();
  LiDropChecker = (function() {
    __extends(LiDropChecker, Drop);
    function LiDropChecker() {
      LiDropChecker.__super__.constructor.apply(this, arguments);
    }
    LiDropChecker.prototype.findContent = function() {
      return this.elem.find('li');
    };
    LiDropChecker.prototype.transform = function(contents) {
      var li, res, _i, _len;
      res = [];
      for (_i = 0, _len = contents.length; _i < _len; _i++) {
        li = contents[_i];
        var hidden = $(li).hasClass('hidden') ? 'hidden' : '';
        res.push("<span class=\"checker " + hidden + "\">\n<input type=\"checkbox\" class=\"checkbox " + hidden + "\" value=\"" + ($(li).attr('value')) + "\" " + ($(li).attr("on") === 'on' ? "checked=\"checked\"" : "") + "/>\n<label>" + ($(li).text()) + "</label>\n</span>");
      }
      return res.join("");

    };
    LiDropChecker.prototype.findItems = function() {
      return this.content.find('input:checkbox');
    };
    LiDropChecker.prototype.onContentOK = function() {
      this.content.css({
        "width": "500px",
        "display": "block",
        "min-width": "70px",
        "display": "none"
      });
      if (this.options.title != null) {
        this.head.empty().append(this.options.title);
      }
      this.title = this.head.find('.drop-title');
      return this.content.mouseup(function(e) {
        e.preventDefault();
        return false;
      });
    };
    return LiDropChecker;
  })();
  DropChecker = (function() {
    __extends(DropChecker, Drop);
    function DropChecker() {
      DropChecker.__super__.constructor.apply(this, arguments);
    }
    DropChecker.prototype.findContent = function() {
      return this.elem.find('option');
    };
    DropChecker.prototype.transform = function(content) {
      var opt, res, _i, _len;
      res = [];
      for (_i = 0, _len = content.length; _i < _len; _i++) {
        opt = content[_i];
        var hidden = $(li).hasClass('hidden') ? 'hidden' : '';
        res.push("<span class=\"checker " + hidden + "\">\n<input type=\"checkbox\" class=\"checkbox\" value=\"" + ($(opt).val()) + "\" " + ($(opt).is(":selected") ? "checked=\"checked\"" : "") + "/>\n<label>" + ($(opt).text()) + "</label>\n</span>");
      }
      return res.join("");
    };
    DropChecker.prototype.findItems = function() {
      return this.content.find('input:checkbox');
    };
    DropChecker.prototype.onContentOK = function() {
      this.content.css({
        "width": "500px",
        "display": "block",
        "min-width": "70px",
        "display": "none"
      });
      if (this.options.title != null) {
        this.head.empty().append(this.options.title);
      }
      this.title = this.head.find('.drop-title');
      return this.content.mouseup(function(e) {
        e.preventDefault();
        return false;
      });
    };
    return DropChecker;
  })();
  dftTemplate = function(content, search) {
    return "<div class=\"drop-container\" style=\"display:inline;\">\n  <div class=\"drop-head\">\n    <a class=\"drop-title\" href=\"javascript:void(0);\">\n      <span></span>\n    </a>\n  </div>\n  <div class=\"drop-content\">\n    " + content + "\n  </div>\n</div>";
  };
  defaultMsg = '--请选择--';
  makeContent = function(content, transform) {
    if ($.isFunction(transform)) {
      return transform.apply(this, [content]);
    } else {
      return content;
    }
  };
  toDrop = function(template, content) {
    return $(template(content));
  };
  /*
  # 将options转化为ul
  */
  Drop.options_to_ul = function(options) {
    var ul;
    ul = [];
    ul.push("<ul>");
    options.each(function() {
      var optHtml, optVal;
      optVal = $(this).val();
      optHtml = $(this).html();
      return ul.push("<li> <input type=\"hidden\" value=\"" + optVal + "\" />" + optHtml + "</li>");
    });
    ul.push("</ul>");
    return ul.join("");
  };
  $.fn.dropChecker = function(options) {
    var drop;
    drop = new LiDropChecker($(this), options);
    $(this).hide().after(drop.drop);
    $(this).data('dropdown', drop);
    return drop;
  };
  
  checkTitle = function(isInit, selected, head, title) {
    if (isInit) {
      return title.find('span').text(defaultMsg);
    } else {
      return title.find('span').text(selected.text());
    }
  };
}).call(this);
