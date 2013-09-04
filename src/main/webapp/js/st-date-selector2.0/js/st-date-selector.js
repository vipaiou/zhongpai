/*!
 * Date Selector Library v2.0
 *
 * Copyright 2013, zhangshaolong
 * QQ: 369669902
 * email: zhangshaolongjj@163.com
 *
 */
;var dateSelector = (function(doc) {
	var Element = function(ele){
		this.limit = {};
		this.element = ele;
	};
	Element.prototype.addLimit = function(limit){
		this.limit = limit || {};
		return this;
	};
	Element.prototype.removeLimit = function(limit){
		if(limit){
			var constructor = limit.constructor;
			if(String == constructor){
				delete this.limit[limit];
			}else if(Array == constructor){
				for(var i=0,len=limit.length; i<len; i++){
					delete this.limit[limit[i]];
				}
			}
		}else{
			this.limit = {};
		}
		return this;
	};
    var dateSelector = function() {
    	this.per = 'selector_' + new Date().getTime() + '_';
        this.dayMap = {0:31,2:31,3:30,4:31,5:30,6:31,7:31,8:30,9:31,10:30,11:31};// 使用hash存储每个月的天数（除了2月）。
        this.currentDate = getCurrentDate(this);// 记录当前的日期，突出显示，格式为yyyy_m(m)_d(d)。
        this.elements = [];
        this.limit = null;
        this.currentElement = null;
        createSelector(this);// 把日期控件的结构创建好。
        bindEvent(this);// 绑定日期控件的所有事件。
    };
    var getElement = function(o, element){
    	for(var i=0,len=o.elements.length; i<len; i++){
    		if(o.elements[i].element === element){
    			return o.elements[i];
    		}
    	}
    }
    var getCurrentDate = function(o) {
        var today = new Date();
        o.today = today;
        return today.getFullYear() + "_" + today.getMonth() + "_" + today.getDate();
    };
    var setDatePosition = function(o, element) {
    	element = $(element);
    	var offset = element.offset();
        o.selectorHolder.css({
            top : offset.top + element[0].offsetHeight + "px",
            left : offset.left + "px"
        }).show();
    };
    var createSelector = function(o) {
        var selectorHolder = o.selectorHolder = $('<div>');
        selectorHolder.addClass('date-holder');
		var btDiv = $('<div>');
		btDiv.addClass('border-top');
		var blDiv = $('<div>');
		blDiv.addClass('border-left');
		var bbDiv = $('<div>');
		bbDiv.addClass('border-bottom');
		var brDiv = $('<div>');
		brDiv.addClass('border-right');
		var ltDiv = $('<div>');
		ltDiv.addClass('left-top');
		var lbDiv = $('<div>');
		lbDiv.addClass('left-bottom');
		var rtDiv = $('<div>');
		rtDiv.addClass('right-top');
		var rbDiv = $('<div>');
		rbDiv.addClass('right-bottom');
		selectorHolder.append(btDiv).append(blDiv).append(bbDiv).append(brDiv).append(ltDiv).append(lbDiv).append(rtDiv).append(rbDiv);
        var topDiv = o.topDiv = $('<div>');
        topDiv.addClass('top-div');
        var preYearDiv = o.preYearDiv = $('<div></div>');
        preYearDiv.addClass('jump-div pre-year-div');
        var preMonthDiv = o.preMonthDiv = $('<div></div>');
        preMonthDiv.addClass('jump-div pre-month-div');
        var dateText = o.dateText = $('<span>');
        dateText.addClass('date-text-span');
        var nextMonthDiv = o.nextMonthDiv = $('<div></div>');
        nextMonthDiv.addClass('jump-div next-month-div');
        var nextYearDiv = o.nextYearDiv = $('<div></div>');
        nextYearDiv.addClass('jump-div next-year-div');
        var table = o.table = $('<table>');
        table.addClass('date-table');
        var thead = o.thead = $('<thead>');
        var week = '<tr><th title="' + resource.weekTitle.Su + '">' + resource.week.Su + '</th><th title="'
                + resource.weekTitle.Mo + '">' + resource.week.Mo + '</th>' + '<th title="' + resource.weekTitle.Tu
                + '">' + resource.week.Tu + '</th><th title="' + resource.weekTitle.We + '">' + resource.week.We
                + '</th>' + '<th title="' + resource.weekTitle.Th + '">' + resource.week.Th + '</th><th title="'
                + resource.weekTitle.Fr + '">' + resource.week.Fr + '</th>' + '<th title="' + resource.weekTitle.Sa
                + '">' + resource.week.Sa + '</td></tr>';
        thead.html(week);
        var tbody = o.tbody = $('<tbody>');
        setTimeout(function() {
            $(doc.body).append(
                    selectorHolder.append(
                            topDiv.append(preYearDiv).append(preMonthDiv).append(dateText).append(nextYearDiv).append(
                            		nextMonthDiv)).append(table.append(thead).append(tbody)));
        }, 0);
    };
    var bindEvent = function(o) {
        o.selectorHolder.click(function(e) {
            var target = e.target;
            if (target.nodeName == 'TD') {
            	var $target = $(target);
            	var date = $.trim($target.text());
                if (date && !$target.hasClass('date-disabled')) {
                	var dateTxt = o.year + "-" + make2SameLen(o.month + 1) + "-" + make2SameLen(date);
                    o.currentElement.value = dateTxt;
                    o.selectedDate = o.year + "_" + o.month + "_" + date;
                    o.onselected(o.currentElement, dateTxt);
                    o.close($(this));
                }
            }
            e.stopPropagation();
        });
        $(doc).click(function() {
        	if(o.selectorHolder.is(":visible")){
        		o.close(o.selectorHolder);
        	}
        });
        o.preYearDiv.click(function() {
            if (!$(this).hasClass('action-disabled')) {
                o.date.setFullYear(o.year - 1);
                updateDate(o, o.date);
                updateSelector(o);
            }
        }).mouseover(function() {
            if (!$(this).hasClass('action-disabled')) {
                $(this).addClass('mouse-over');
            }
        }).mouseout(function() {
            $(this).removeClass('mouse-over');
        });
        o.preMonthDiv.click(function() {
            if (!$(this).hasClass('action-disabled')) {
				o.date.setDate(1);
                o.date.setMonth(o.month - 1);
                updateDate(o, o.date);
                updateSelector(o);
            }
        }).mouseover(function() {
            if (!$(this).hasClass('action-disabled')) {
                $(this).addClass('mouse-over');
            }
        }).mouseout(function() {
            $(this).removeClass('mouse-over');
        });
        o.nextYearDiv.click(function() {
            if (!$(this).hasClass('action-disabled')) {
                o.date.setFullYear(o.year + 1);
                updateDate(o, o.date);
                updateSelector(o);
            }
        }).mouseover(function() {
            if (!$(this).hasClass('action-disabled')) {
                $(this).addClass('mouse-over');
            }
        }).mouseout(function() {
            $(this).removeClass('mouse-over');
        });
        o.nextMonthDiv.click(function() {
            if (!$(this).hasClass('action-disabled')) {
				o.date.setDate(1);
                o.date.setMonth(o.month + 1);
                updateDate(o, o.date);
                updateSelector(o);
            }
        }).mouseover(function() {
            if (!$(this).hasClass('action-disabled')) {
                $(this).addClass('mouse-over');
            }
        }).mouseout(function() {
            $(this).removeClass('mouse-over');
        });
    };
    // 把显示的月份格式化为2位。
    var make2SameLen = function(val) {
        return +val < 10 ? "0" + val : val;
    };
    var updateDate = function(o, date) {
        o.date = date;
        o.dateOfMonth = date.getDate();
        o.month = date.getMonth();
        o.year = date.getFullYear();
    };
    // 验证日期是否合法，错误返回false，正确返回正确的日期，主要是避免后面再次创建日期。
    var checkDate = function(val) {
        if (!/^\d{4}-\d{2}-\d{2}$/.test(val)) {
            return false;
        }
        var arr = val.split('-');
        var dt = new Date(+arr[0], +arr[1] - 1, +arr[2]);
        if (dt.getFullYear() != +arr[0]) {
            return false;
        }
        if (dt.getMonth() != +arr[1] - 1) {
            return false;
        }
        if (dt.getDate() != +arr[2]) {
            return false;
        }
        return dt;
    };
    // 是否是闰年，为了计算2月的天数
    var isLeapYear = function(o) {
        var year = o.year;
        return ((year % 100 != 0) && (year % 4 == 0)) || (year % 400 == 0);
    };
    var getDaysCount = function(o) {
        if (o.month != 1) {
            return o.dayMap[o.month];
        } else {
            if (isLeapYear(o)) {
                return 29;
            }
            return 28;
        }
    };
    // 获取月初是周几
    var getDay = function(o) {
        var dt = o.date,
        day = dt.getDay(),
        offset = o.dateOfMonth;
        return (day - (offset - 1) % 7 + 7) % 7;
    };
    // 根据设置的limit增加选择日期的限制。
    var setLimitDate = function(o, date, limit) {
        if (date.constructor == Date) {
            getElement(o, o.currentElement).limit[limit] = {
                year : date.getFullYear(),
                month : date.getMonth(),
                date : date.getDate()
            };
        } else if (date.constructor == String) {
            var result = checkDate(date);
            if (result) {
            	getElement(o, o.currentElement).limit[limit] = {
                    year : result.getFullYear(),
                    month : result.getMonth(),
                    date : result.getDate()
                };
            }
        } else if (date.constructor == Function) {
            setLimitDate(o, date.call(), limit);
        }
    };
    var bindTdsEvent = function(o) {
        o.tbody.mouseover(
			function(e) {
				var target = e.target;
				var $target = $(target);
				if (target.nodeName == 'TD' && $.trim($target.text()).length
						&& !$target.hasClass('date-disabled')) {
					$target.addClass('mouse-over');
				}
			}
		).mouseout(function(e) {
			var target = e.target;
			var $target = $(target);
			if (target.nodeName == 'TD') {
				$target.removeClass('mouse-over');
			}
		});
    };
    var createLineDate = function(o, tr, offset, days, firstClass, secondClass) {
        var tds = "", td, date;
        date = 7 * tr - offset + 1;
        if ((date > 0) && (date <= days)) {
            tds += "<td id='" + o.per + o.year + "_" + o.month + "_" + date + "' " + firstClass + ">" + date
                    + "</td>";
        } else {
            tds += "<td " + firstClass + ">&nbsp;</td>";
        }
        for ( td = 1; td < 7; td++) {
            date = td + 7 * tr - offset + 1;
            if ((date > 0) && (date <= days)) {
                tds += "<td id='" + o.per + o.year + "_" + o.month + "_" + date + "' " + secondClass + ">" + date
                        + "</td>";
            } else {
                tds += "<td " + secondClass + ">&nbsp;</td>";
            }
        }
        return "<tr style='border:1px solid #ccc'>" + tds + "</tr>";
    };
    var fillDateData = function(o) {
        var offset = getDay(o),
        days = getDaysCount(o),
        length = Math.ceil((days + offset) / 7) - 1,
        trs = "", tr;
        for (tr = 0; tr < length; tr++) {
            trs += createLineDate(o, tr, offset, days, "class='no-border-left'", "");
        }
        trs += createLineDate(o, length, offset, days, "class='no-border-left no-border-bottom'",
                "class='no-border-bottom'");
        o.tbody.html(trs);
    };
    var isCurrentMonth = function(o, year_month) {
        return !!$("#" + o.per + year_month + "_1").size();
    };
    // 设置不可选择的天。
    var setDisabledDates = function(o, date, direction) {
        var year_month = o.year + "_" + o.month,
        idx = (direction > 0) ? getDaysCount(o) : 1;
        while (direction * (idx - date) > 0) {
            $("#" + o.per + year_month + "_" + idx).addClass('date-disabled');
            idx = idx - direction;
        }
    };
    // 设置上一年和下一年是否可点击。
    var setDisabledYear = function(o, year, month, direction) {
        var node = direction > 0 ? 'nextYearDiv' : 'preYearDiv';
        if (direction * (year - o.year) <= 0) {
            o[node].addClass('action-disabled');
        } else if (year == (o.year + direction) && (direction * (month - o.month) < 0)) {
            o[node].addClass('action-disabled');
        } else {
            o[node].removeClass('action-disabled');
        }
    };
    // 设置上一月和下一月是否可点击。
    var setDisabledMonth = function(o, year, month, direction) {
        var node = direction > 0 ? 'nextMonthDiv' : 'preMonthDiv';
        if (o.year == year) {
            if (direction * (o.month - month) >= 0) {
                o[node].addClass('action-disabled');
            } else {
                o[node].removeClass('action-disabled');
            }
        } else if (direction * (o.year - year) > 0) {
            o[node].addClass('action-disabled');
        } else {
            o[node].removeClass('action-disabled');
        }
    };
    // 设置一个月里不可选择的日期。
    var setDisabledMonthOfDates = function(o, year, month, date, direction) {
        var year_month = year + "_" + month,
        idx = direction > 0 ? 0 : getDaysCount(o) + 1;
        if (isCurrentMonth(o, year_month)) {
            setDisabledDates(o, date, direction);
        } else {
            if (direction * (o.year - year) > 0) {
                setDisabledDates(o, idx, direction);
            } else if (o.year == year) {
                if (direction * (o.month - month) > 0) {
                    setDisabledDates(o, idx, direction);
                }
            }
        }
    };
    var updateByLimit = function(o, direction) {
        var year, month, date, yearNode, monthNode, limit;
        if (direction > 0) {
            yearNode = 'nextYearDiv';
            monthNode = 'nextMonthDiv';
            limit = 'end';
        } else {
            yearNode = 'preYearDiv';
            monthNode = 'preMonthDiv';
            limit = 'start';
        }
        var obj = getElement(o, o.currentElement).limit[limit];
        if (obj && obj.year) {
            year = obj.year;
            month = obj.month;
            date = obj.date;
            setDisabledYear(o, year, month, direction);
            setDisabledMonth(o, year, month, direction);
            setDisabledMonthOfDates(o, year, month, date, direction);
        } else {
            o[yearNode].removeClass('action-disabled');
            o[monthNode].removeClass('action-disabled');
        }
    };
    // 设置日期选择依赖条件
    var runLimit = function(o) {
        var limit = getElement(o, o.currentElement).limit, start, end;
        if(limit){
        	start = limit.start;
            end = limit.end;
            if (start) {
                setLimitDate(o, start, 'start');
            }
            if (end) {
                setLimitDate(o, end, 'end');
            }
            updateByLimit(o, -1);
            updateByLimit(o, 1);
        }
    };
    // 设置显示的年和月。
    var updateDateText = function(o) {
        o.dateText.text(o.year + ' ' + make2SameLen(o.month + 1));
        $("#" + o.per + o.selectedDate).addClass('selected-date');
		if(!$("#" + o.per + o.currentDate).hasClass('date-disabled')){
			$("#" + o.per + o.currentDate).addClass('current-date');
		}else{
			$("#" + o.per + o.currentDate).addClass('current-date-disabled');
		}
    };
    var updateSelector = function(o) {
        fillDateData(o);
        runLimit(o);
        bindTdsEvent(o);
        updateDateText(o);
    };

    dateSelector.prototype.bind = function(element) {
    	if(element){
    		var constructor = element.constructor;
    		if(Array == constructor){
    			for(var i=0,len=element.length;i<len;i++){
    				this.bind(element[i]);
    			}
    		}else{
    			element = new Element(DomUtil.getNode(element));
    			if(this.limit){
    				element.addLimit(this.limit);
    			}
    		}
    		this.elements.push(element);
    		var that = this;
            // 为注册使用日期控件的input注册弹出日期控件的事件。同时解析输入框的值。如果格式正确，日期自动展示到此日期，如果错误，提示，清空text，展示当前月。
            $(element.element).bind('click',
                function(e) {
                    var val = $.trim(this.value), result;
                    e.stopPropagation();
                    that.currentElement = this;
                    // 计算并设置日期控件弹出的位置。
                    setDatePosition(that, this);
                    // 文本没有日期，日期自动显示当天所在的月的日期。
                    if (val.length == 0) {
                        result = new Date();
                        that.selectedDate = null;
                    } else {
                        result = checkDate(val);
                        result
                                && (that.selectedDate = result.getFullYear() + "_" + result.getMonth() + "_"
                                        + result.getDate());// TODO设置text对应的日期高亮
                    }
                    if (result) {
                        // 假如text为空，当天高亮显示的话，可以把TODO的代码放在这里
                        updateDate(that, result);
                        updateSelector(that);
                    } else {
                        alert('日期格式错误，点击确定后会把错误格式的日期清空，可继续选择日期');
                        this.value = '';
                        result = new Date();
                        that.selectedDate = null;
                        updateDate(that, result);
                        updateSelector(that);
                    }
                }
            );
    	}
        return element;
    };
    dateSelector.prototype.setZIndex = function(zIndex) {
    	this.selectorHolder.css("z-index", zIndex);
    	return this;
    };
    // 可增加日期设置的最大值和最小值的限制，可以指定字符串的日期格式（yyyy-mm-dd）和正确格式的日期还可以是返回前2种的function
    dateSelector.prototype.addLimit = function(limit, element) {
    	this.limit = limit;
    	if(!element){
    		for(var i=0,len=this.elements.length; i<len; i++){
    			this.elements[i].addLimit(limit);
    		}
    	}else{
    		getElement(this, DomUtil.getNode(element)).addLimit(limit);
    	}
        return this;
    };
    dateSelector.prototype.removeLimit = function(limit, element){
    	if(!element){
    		for(var i=0,len=this.elements.length; i<len; i++){
    			this.elements[i].removeLimit(limit);
    		}
    	}else{
    		getElement(this, DomUtil.getNode(element)).removeLimit(limit);
    	}
    	return this;
    };
    dateSelector.prototype.onselected = function(ele, val) {
        return this;
    };
    dateSelector.prototype.close = function(ele) {
    	ele.hide();
    	this.onclosed(this.currentElement);
        return this;
    };
    dateSelector.prototype.onclosed = function(ele) {
        return this;
    };
    return dateSelector;
})(document);