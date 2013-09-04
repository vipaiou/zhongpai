(function() {
  var $, Log, hasConsole, log;
  $ = jQuery;
  Log = (function() {
    function Log() {}
    return Log;
  })();
  hasConsole = function() {
    return (typeof console !== "undefined" && console !== null) && (console.log != null);
  };
  log = function(fun) {
    return function() {
      if (!(fun != null)) {
        return;
      }
      try {
        return fun.apply(this, arguments);
      } catch (e) {
        try {
          return fun(Array.apply(null, arguments));
        } catch (e) {

        }
      }
    };
  };
  Log.debug = function() {
    if (hasConsole()) {
      if ($.isFunction(console.debug)) {
        return log(console.debug).apply(null, arguments);
      }
    }
  };
  Log.info = function() {
    if (hasConsole()) {
      if ($.isFunction(console.info)) {
        return log(console.info).apply(null, arguments);
      }
    }
  };
  Log.warn = function() {
    if (hasConsole()) {
      if ($.isFunction(console.warn)) {
        return log(console.warn).apply(null, arguments);
      }
    }
  };
  Log.error = function() {
    if (hasConsole()) {
      if ($.isFunction(console.error)) {
        return log(console.error).apply(null, arguments);
      }
    }
  };
  (typeof exports !== "undefined" && exports !== null ? exports : this).Log = Log;
}).call(this);
