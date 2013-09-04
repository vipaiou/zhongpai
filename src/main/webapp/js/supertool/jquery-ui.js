(function() {
  var $;
  $ = jQuery;
  $.datepicker.setDefaults({
    dateFormat: 'yy-mm-dd'
  });
  $.fn.dateRange = function(options) {
    var dates, from, to, userDefinedOnSelect;
    if ($(this).length !== 2) {
      return;
    }
    dates = $(this);
    from = $(this).first();
    to = $(this).last();
    userDefinedOnSelect = options.onSelect;
    $.extend(options, {
      onSelect: function(selectedDate, inst) {
        var date, instance, option, _ref;
        if ($.isFunction(userDefinedOnSelect)) {
          userDefinedOnSelect.call(this, selectedDate, inst);
        }
        option = $(this).is(from) ? "minDate" : "maxDate";
        instance = $(this).data("datepicker");
        date = $.datepicker.parseDate((_ref = instance.settings.dateFormat) != null ? _ref : $.datepicker._defaults.dateFormat, selectedDate, instance.settings);
        return dates.not(this).datepicker("option", option, date);
      }
    });
    return $(this).datepicker(options);
  };
}).call(this);
