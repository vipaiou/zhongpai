/*
 **
 * jqGrid (http://trirand.com/blog/) integration with jquery.bbq library (http://benalman.com/projects/jquery-bbq-plugin/)
 * by Craig Stuntz (http://blogs.teamb.com/craigstuntz/)
 * 
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl-2.0.html
 **/

/*
 **用途：浏览器历史支持jqGrid搜索，排序，分页ajax前进，后退
 * 注意：支持搜索ajax前进，后退使用前提：
 * 1、搜索使用jqGrid，filter搜索
 * 2、同一组checkbox或radio控件使用同一name，同组的控件value不同
 * 3、除checkbox或radio控件外，其余控件name必须唯一
 **/
(function($) {
	$.jgrid.history = {
		// global options -- you can overwrite these elsewhere, if need be, before calling $().jqGridHistory
		getPropertyValue : function(gridOptions, name, historyOptions) {
			var nameFragments = name.split('.');
			if (nameFragments.length === 1) {
				return gridOptions[name];
			}
			if (nameFragments[0] === "postData") {
				return gridOptions.postData
						&& gridOptions.postData[nameFragments[1]];
			}
		},
		// this is the GLOBAL prefix. There is also a per-grid prefix in options.history.hashPrefix
		globalHashPrefix : "",
		// compute name of hashName for URI -- result will be the "rowNum" part of http://site/Foo#rowNum=20
		hashPrefix : function(historyOptions, propertyName) {
			return (historyOptions.hashPrefix || this.globalHashPrefix)
					+ propertyName;
		},
		jqGridInternalDefaults : {
			// these are hard-coded into the grid constructor :( so I've copied them here.
			page : 1,
			rowNum : 20,
			records : 0,
			sortorder : "asc",
			sortname : ""
		},
		persist : [ "url", "page", "rowNum", "sortname", "sortorder" ], // options to store in hash
		// change gridOptions[name] to value. Replace this to customize assignment when it's not a direct mapping.
		// historyOptions are for reference only; the method should only change gridOptions
		setPropertyValue : function(gridOptions, name, value, historyOptions) {
			var nameFragments = name.split('.');
			if (nameFragments.length === 1) {
				gridOptions[name] = value;
			} else {
				if (nameFragments[0] === "postData") {
					gridOptions.postData = gridOptions.postData || {};
					gridOptions.postData[nameFragments[1]] = value;
				}
			}
		}
	};
	var createHashChangeHandler = function(gridSelector) {
		return function(event) {
			var grid = $(gridSelector);
			var gridOptions = grid.getGridParam();
			var history = gridOptions.history;
			var hash = history.bbq.getState();
			var gp = {};
			var reloadNeeded = false;
			var persist = gridOptions.history.persist;
			var postData = gridOptions.postData;
			var allParam = $.extend(true, {}, pageDefault, hash);
			for ( var name in allParam) {
				if ("_search" == name || "nd" == name) {
					continue;
				}
				if (postData[name] != hash[name]) {
					reloadNeeded = true;
				}
				var newVal = hash[name] || pageDefault[name] || "";
				if (persist.contain(persistMap(name))) {
					gp[persistMap(name)] = newVal;
				} else {
					syncPageElement(name, newVal);
				}
				hash[name] = newVal;
			}
			if (reloadNeeded) {
				grid.setGridParam(gp);
				grid.setPostData(hash);
				grid.trigger("reloadGrid");
			}
		};
	};
	var gridCompleteSetHash = function() {
		var p = this.p || this; // "this" changed in jqGrid 3.7; I want to support 3.6 and 3.7.
		var history = p.history;
		var hashPrefix = history.hashPrefix || "";
		var hash = history.bbq.getState();
		var changedHash = false;
		var postData = p.postData;
		postData["url"] = p.url;
		
		if (firstLoad) {
			firstLoad = false;
			for ( var name in postData) {
				var src = postData;
				var dest = pageDefault;
				copyObj(src, dest);
			}
			setPageDefaultElement();
			for ( var name in postData) {
				if ("_search" == name || "nd" == name) {
					continue;
				}
				var newVal = postData[name];
				syncPageElement(name, newVal);
			}
		}

		for ( var name in postData) {
			if ("_search" == name || "nd" == name) {
				continue;
			}
			var hashValue = hash[hashPrefix + name];
			var defaultValue = pageDefault[name];
			if (postData[name] != hashValue && postData[name] != defaultValue) {
				changedHash = true;
			}
		}

		if (changedHash) {
			history.bbq.pushState(postData, 2);
		}
	};
	var optionsWithHistory = function(options) {
		var defaults = $.extend($.jgrid.history.jqGridInternalDefaults,
				$.jgrid.defaults, options);
		var newOptions = {};
		newOptions.history = options.history || {};
		// use local default of jQuery BBQ library if not stubbed out for unit testing
		newOptions.history.bbq = newOptions.history.bbq || $.bbq;
		var hash = newOptions.history.bbq.getState();
		newOptions.history.defaults = newOptions.history.defaults || {};
		newOptions.history.hashPrefix = newOptions.history.hashPrefix || "";
		newOptions.history.grid = this;
		newOptions.history.persist = newOptions.history.persist
				|| $.jgrid.history.persist;
		for ( var i = 0; i < newOptions.history.persist.length; i++) {
			var name = newOptions.history.persist[i];
			// copy over only the values in persist, not all defaults.
			newOptions.history.defaults[name] = newOptions.history.defaults[name]
					|| $.jgrid.history.getPropertyValue(defaults, name,
							newOptions.history);
			var val = hash[newOptions.history.hashPrefix + name];
			if (val) {
				$.jgrid.history.setPropertyValue(newOptions, name, val,
						newOptions.history);
			}
		};
		
		//将url中参数以post方式提交
		var loc = window.location + "";
		loc = decodeURI(loc);
		var postData = newOptions.postData || {};
		if (loc.indexOf("#") >= 0) {
			var paramStr = loc.substring(loc.indexOf("#") + 1, loc.length);
			var paramArray = paramStr.split("&");
			for ( var i = 0; i < paramArray.length; i++) {
				var item = paramArray[i].split("=");
				if (item.length != 2) {
					continue;
				}
				var name = item[0];
				var val = item[1];
				if(newOptions.history.persist.contain( persistMap(name) ) && "url" != name){
					newOptions[persistMap(name)] = val;
				}
				postData[name] = val;
			}
			newOptions.postData = postData;
		}
		
		if (options.gridComplete) {
			var originalGridComplete = options.gridComplete;
			newOptions.gridComplete = function() {
				// first call passed gridComplete
				originalGridComplete.apply(this, arguments);
				// then "our" gridComplete
				gridCompleteSetHash.apply(this, arguments);
			}
		} else {
			newOptions.gridComplete = gridCompleteSetHash;
		}
		return $.extend(true, options, newOptions);
	};

	$.fn.jqGridHistory = function(options) {
		var newOptions = optionsWithHistory.call(this, options);
		var hashChangeHandler = createHashChangeHandler(this);
		$(window).bind('hashchange', hashChangeHandler);
		return this.jqGrid(newOptions);
	};

	Array.prototype.contain = function(elem) {
		for ( var i = 0; i < this.length; i++) {
			if (this[i] == elem)
				return true;
		}
		return false;
	};

	var persistMap = function(postName) {
		switch (postName) {
		case 'url':
			return 'url';
			break;
		case 'page':
			return "page";
			break;
		case 'rows':
			return "rowNum";
			break;
		case 'sidx':
			return "sortname";
			break;
		case 'sord':
			return "sortorder";
			break;
		default:
			return postName;
			break;
		}
	}

	var pageDefault = {};
	var firstLoad = true;
	var copyObj = function(src, dest) {
		for ( var name in src) {
			if (src[name] instanceof Object) {
				dest[name] = {};
				dest[name] = copyObj(src[name], dest[name]);
			} else {
				dest[name] = src[name];
			}
		}
		return dest;
	};

	var syncPageElement = function(name, newVal) {
		$("#filter input[name='" + name + "'],select[name='" + name + "']")
				.each(function() {
					var type = $(this).attr("type");
					if ("checkbox" == type || "radio" == type) {
						if (newVal == $(this).val()) {
							$(this).attr("checked", true);
						} else {
							$(this).attr("checked", false);
						}
					} else {
						$(this).val(newVal);
					}
				});
	};

	var setPageDefaultElement = function() {
		$("#filter input").each(function() {
			var id = $(this).attr("id");
			var name = $(this).attr("name");
			var type = $(this).attr("type");
			var value = $(this).val();
			switch (type) {
			case "checkbox":
				if ($(this).attr("checked")) {
					pageDefault[name] = value;
				}
				break;
			case "radio":
				if ($(this).attr("checked")) {
					pageDefault[name] = value;
				}
				break;
			case "text":
				pageDefault[name] = value;
				break;
			default:
				break;
			}
		});
		$("#filter select").each(function() {
			var id = $(this).attr("id");
			var name = $(this).attr("name");
			var value = $(this).val();
			pageDefault[name] = value;
		});
	};
})(jQuery);