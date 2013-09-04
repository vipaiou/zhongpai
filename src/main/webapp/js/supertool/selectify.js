(function() {
  var $, Selector, checkTitle, defaultMsg, template, toDiv;
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };
  $ = jQuery;
  template = function(ul) {
    return "<div class=\"drop-container\" style=\"display:inline;\">\n  <div class=\"drop-head\">\n    <a class=\"drop-title\" href=\"javascript:void(0);\">\n      <span></span>\n    </a>\n  </div>\n  <div class=\"drop-content\">\n    <input type=\"text\" class=\"search\" />\n    " + ul + "\n  </div>\n</div>";
  };
  defaultMsg = '--请选择--';
  Selector = (function() {
    function Selector(select, isInit) {
      var selected;
      this.select = select;
      this.div = toDiv(select, isInit);
      this.head = this.div.find('drop-head');
      this.title = this.div.find('a.drop-title');
      this.content = this.div.find('div.drop-content');
      this.div.find('input.search').first().watermark("搜索: ");
      selected = $(select).find(':selected');
      checkTitle(isInit, selected, this.head, this.title);
      this.associateOptions();
      this.mouseInside = false;
    }
    Selector.prototype.associateOptions = function() {
      var content, div, select, title;
      title = this.title;
      content = this.content;
      select = this.select;
      div = this.div;
      this.div.find('li').click(function() {
        var old, oldText, val;
        oldText = title.find('span').text();
        title.find('span').text($(this).text());
        val = $(this).find('input').val();
        old = $(select).val();
        if (oldText === defaultMsg || val !== old) {
          $(select).val(val);
          $(select).trigger('change');
        }
        title.removeClass('menu-open');
        return content.hide();
      });
      this.div.hover(__bind(function() {
        return this.mouseInside = true;
      }, this), __bind(function() {
        return this.mouseInside = false;
      }, this));
      return this.title.click(__bind(function(event) {
        if (!this.title.hasClass('menu-open')) {
          $('body').one('mouseup', __bind(function() {
            if (!this.mouseInside) {
              this.close();
              return false;
            }
          }, this));
          return this.open();
        } else {
          return this.close();
        }
      }, this));
    };
    Selector.prototype.clean = function() {
      $(this.select).empty();
      return this.div.remove();
    };
    Selector.prototype.close = function() {
      this.title.removeClass('menu-open');
      return this.content.hide();
    };
    Selector.prototype.open = function() {
      this.title.addClass('menu-open');
      return this.content.show();
    };
    Selector.prototype.disable = function() {
      return this.title.hide();
    };
    return Selector;
  })();
  toDiv = function(select, isInit) {
    var div, opt, optHtml, optVal, ul, _i, _len, _ref;
    ul = [];
    ul.push("<ul>");
    _ref = $(select).find('option');
    for (_i = 0, _len = _ref.length; _i < _len; _i++) {
      opt = _ref[_i];
      optVal = $(opt).val();
      optHtml = $(opt).html();
      ul.push("<li> <input type='hidden' value=\"" + optVal + "\" />" + optHtml + "</li>");
    }
    ul.push("</ul>");
    div = $(template(ul.join("")));
    return div;
  };
  $.fn.selectify = function(isInit) {
        if (isInit != null) {
      isInit;
    } else {
      isInit = true;
    };
    return $(this).each(function() {
      var selector, title;
      selector = new Selector(this, isInit);
      title = "ABC";
      $(this).hide().after(selector.div);
      return $(this).data('selectify', selector);
    });
  };
  checkTitle = function(isInit, selected, head, title) {
    if (isInit) {
      return title.find('span').text(defaultMsg);
    } else {
      return title.find('span').text(selected.text());
    }
  };
}).call(this);
