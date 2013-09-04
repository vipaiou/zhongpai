/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by Cloudream (cloudream@gmail.com). */
jQuery(function($){
	$.datepicker.regional['zh_CN'] = {
		closeText: '关闭',
		clearText: '清空',
		prevText: '&#x3c;上月',
		nextText: '下月&#x3e;',
		currentText: '今天',
		monthNames: ['01月','02月','03月','04月','05月','06月',
		'07月','08月','09月','10月','11月','12月'],
		monthNamesShort: ['01月','02月','03月','04月','05月','06月',
		'07月','08月','09月','10月','11月','12月'],
		dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
		dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
		dayNamesMin: ['日','一','二','三','四','五','六'],
		weekHeader: '周',
		dateFormat: 'yy-mm-dd',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: true,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['zh_CN']);
});
