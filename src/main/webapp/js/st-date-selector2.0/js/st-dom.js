var DomUtil = (function(win, doc){
	var jsMeta = {
	    '\b' : '\\b',
	    '\t' : '\\t',
	    '\n' : '\\n',
	    '\f' : '\\f',
	    '\r' : '\\r',
	    '\\' : '\\\\'
	},
	htmlMeta = {
	    '&' : '&amp;',
	    '<' : '&lt;',
	    '>' : '&gt;',
	    '"' : '&quot;',
	    "'" : '&#39;',
	    '\\' : '\\\\',
	    '\"' : '\\"'
	};
	var DomUtil = window.DomUtil || {};
	DomUtil.getNode = function(ele){
		return typeof ele == 'string' ? doc.getElementById(ele) : ele.nodeName ? ele : ele[0];
	};
	DomUtil.getPoint = function(ele){
		ele = DomUtil.getNode(ele);
		var t = ele.offsetTop;
		var l = ele.offsetLeft;
		while (ele = ele.offsetParent) {
			t += ele.offsetTop;
			l += ele.offsetLeft;
		}
		return {
			'top' : t,
			'left' : l
		};
	};
	DomUtil.escapeHTML = function(txt) {
	    if (typeof txt == 'undefined')
	        return "";
	    if (typeof txt != 'string')
	        return txt;
	    return txt.replace(/\\|\"|&|<|>|"|'/g, function() {
	        return htmlMeta[arguments[0]];
	    });
	};
	DomUtil.escapeJS = function(str) {
	    if (typeof str == 'undefined')
	        return "";
	    str = str.replace(/[\x00-\x1f\\]/g, function(chr) {
	        var special = jsMeta[chr];
	        return special ? special : '\\u' + ('0000' + chr.charCodeAt(0).toString(16)).slice(-4);
	    });
	    return '"' + str.replace(/"/g, '\\"') + '"';
	};
	return DomUtil;
})(window, document);