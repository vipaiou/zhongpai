var Dates = {};

Dates.plus = function (date, n) {
	return new Date(date.getTime() + 86400000 * n);
};


Dates.parseDate = function(s) {
    var isoExp = /^\s*(\d{4})-(\d\d)-(\d\d)\s*$/,
        date = new Date(NaN), month,
        parts = isoExp.exec(s);
    if(parts) {
      month = parts[2];
      date.setFullYear(parts[1], month - 1, parts[3]);
      if(month != date.getMonth() + 1) {
        date.setTime(NaN);
      }
    }
    return date;
};

/**
 * 解析时间，现在支持的格式 yyyy-MM-dd'T'HH:mm，注意因为不需要支持，所以秒、毫秒和时区都忽略了。
 * Note: 需要引入date-format.js
 * @param s
 * @returns {Date}
 */
Dates.parseTime = function(s) {
    var isoExp = /^\s*(\d{4})-(\d\d)-(\d\d)[ T](\d\d):(\d\d).*$/;
    var parts = isoExp.exec(s);
    if(parts) {
      var month = parts[2];
      var date = new Date(parts[1], month - 1, parts[3], parts[4], parts[5], 0, 0);
      if(month != date.getMonth() + 1) {
        date.setTime(NaN);
      }
      return date;
    } else {
        return new Date(NaN);
    }
};



Dates.formatDate = function(str) {
    if (!str) {
        return "";
    }
	if (str.constructor == Date) {
		return str.format('date');
	}
    str = str.replace(/([+-]\d\d)(\d\d)$/, '$1:$2');
    str = str.substring(0,10).replace(/(-)/g,"/");
    return new Date(str).format("date");
};


Dates.formatTime = function(str) {
	if (!str) {
		return "";
	}
	if (str.constructor == Date) {
		return str.format('minute');
	}
    return S.parseTime(str).format('minute');
};