(function() {
  var $, Form;
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };
  $ = jQuery;
  $.fn.form = function(options) {
    var f;
    if (!(options != null)) {
      f = $(this).data('form');
      if (!(f != null)) {
        f = new Form({
          form: $(this)
        });
        $(this).data('form', f);
      }
      return f;
    } else {
      f = $(this).data('form');
      if (!(f != null)) {
        $["extends"](options, {
          form: $(this)
        });
        f = new Form(options);
        $(this).data('form', f);
        return f;
      } else {
        f.option(options);
        return f;
      }
    }
  };
  $.fn.focusNext = function() {
    var form;
    form = $(this).closest('form');
    return form.form().focusNext();
  };
  Form = (function() {
    function Form(options) {
      this.options = options;
      this.form = options.form;
      this.form.submit(__bind(function() {
        this.form.trigger('beforesubmit');
        return true;
      }, this));
    }
    Form.prototype.options = function(options) {
      return $["extends"](this.options, options);
    };
    Form.prototype.inputs = function() {
      return this.form.find(':input:not(:hidden):not(button)');
    };
    Form.prototype.focusNext = function() {
      var cur, inputs, next;
      cur = this.form.find(':focus');
      inputs = this.inputs();
      next = inputs.eq(inputs.index(cur) + 1);
      return next.focus();
    };
    Form.prototype.autoTab = function() {
    	return;
    	/**
      return this.form.delegateEnter(':input:not(:hidden):not(button)', __bind(function() {
        return this.focusNext();
      }, this));
      **/
    };
    return Form;
  })();
}).call(this);
