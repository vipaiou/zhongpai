(function() {
  var $, SelectGroup;
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };
  $ = jQuery;
  SelectGroup = (function() {
    function SelectGroup(selects) {
      this.selects = selects;
      this.first = this.selects.first();
      this.opts = this.first.find('options');
      this.others = this.find(this.first);
      this.find(this.first).hide();
      this.selects.focus(function() {
        return $(this).data('old', $(this).val());
      });
      this.selects.change(__bind(function(e) {
        return this.onSelect(e.target);
      }, this));
    }
    SelectGroup.prototype.onSelect = function(elem) {
      var oldVal, val;
      val = $(elem).val();
      this.find(elem, val).hide();
      oldVal = $(elem).data('old');
      return this.find(elem, oldVal).show();
    };
    SelectGroup.prototype.find = function(elem, val) {
      return this.selects.not(elem).find('option[value=' + val + ']');
    };
    return SelectGroup;
  })();
  (typeof exports !== "undefined" && exports !== null ? exports : this).SelectGroup = SelectGroup;
}).call(this);
