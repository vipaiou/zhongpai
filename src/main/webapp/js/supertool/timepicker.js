(function() {
  var $;
  $ = jQuery;
  $.fn.datetimeRange = function(options) {
    var dates, end, start;
    if ($(this).length !== 2) {
      return;
    }
    start = $(this).first();
    end = $(this).last();
    dates = $(this);
    $.extend(options, {
      onClose: function(text, inst, dt_inst) {
        var date, option, that, thatDate, thatVal, thisVal;
        thisVal = text;
        option = $(this).is(start) ? "minDate" : "maxDate";
        date = $(this).datetimepicker('getDate');
        that = dates.not(this);
        thatVal = that.val();
        thatDate = $(that).datetimepicker('getDate');
        that.datetimepicker('option', option, date);
        that.datetimepicker('option', option + 'Time', date);
        if (option === "minDate") {
          if (date < thatDate) {
            that.val(thatVal);
          } else {
            that.val(thisVal);
          }
        } else if (option === "maxDate") {
          if (date > thatDate) {
            that.val(thatVal);
          } else {
            that.val(thisVal);
          }
        }
        return true;
      }
    });
    return dates.datetimepicker(options);
  };
  /*
  #timpicker自带的 ('option', 'minDate')函数有问题，hack
  */
  $.fn.datetimeMinDate = function(minDate) {
    var date, val;
    date = $(this).datetimepicker('getDate');
    val = $(this).val();
    $(this).datetimepicker('option', 'minDate', date);
    $(this).datetimepicker('option', 'minDateTime', date);
    if (date > minDate) {
      return $(this).val(val);
    } else {
      return $(this).val(minDate.format('yyyy-MM-dd HH:mm'));
    }
  };
}).call(this);
