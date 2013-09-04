var grid = function(options) {
	this.trReg = /@([^(]+)\(([^)]*)\)|\{([^}]+)\}/g;
	this.propReg = /\{([^}]+)\}/;
	this.dotReg = /\s*,\s*/;
	this.pageReg = /\{([^}]+)\}/g;
    this.holderNode = null;
    this.url = null;
    this.nopage = false;
    this.pageNode = null;
    this.mapKeys = {
        currentPage : 'currentPage',
        prePageRows : 'prePageRows',
        searchIdx : 'searchIdx',
        searchTxt : 'searchTxt',
        rows : 'rows',
        order : 'order',
        orderBy : 'orderBy',
        totalCount : 'totalCount',
        totalPage : 'totalPage'
    };
    this.initParams(options);
};
grid.prototype = {
    initParams : function(options) {
        this.initMapKeys(options.mapKeys);
        this.holderNode = options.holderNode;
        this.template = options.template;
        this.pageTemplate = options.pageTemplate
                || '共{totalCount}条记录&nbsp;&nbsp;共{totalPage}页&nbsp;&nbsp;<input type="button" value="首页" class="bt first-page" title="首页">&nbsp;&nbsp;<input type="button" value="上一页" class="bt pre-page" title="上一页">&nbsp;&nbsp;第{currentPage}页&nbsp;&nbsp;<input type="button" value="下一页" class="bt next-page" title="下一页">&nbsp;&nbsp;<input type="button" value="末页" class="bt last-page" title="末页">&nbsp;&nbsp;跳转至&nbsp;&nbsp;<input type="text" size="4" maxlength="5" class="some-page"/>';
        this.url = options.url;
        this.params = options.params || {};
        this.nopage = options.nopage;
        this.defaultParams();
        options.orderBy && (this.params[this.mapKeys.orderBy] = options.orderBy);
        options.order && (this.params[this.mapKeys.order] = options.order);
        if (!this.nopage) {
            options.currentPage && (this.params[this.mapKeys.currentPage] = options.currentPage);
            options.prePageRows && (this.params[this.mapKeys.prePageRows] = options.prePageRows);
        }
        this.initSort();
        this.holderNode.style.tableLayout = "fixed";
        this.holderNode.className = this.holderNode.className ? this.holderNode.className + " grid" : "grid";
    },
    initSort : function() {
        var that = this;
        var ths = $(this.holderNode.tHead).find('th');
        for ( var i = 0, len = ths.length; i < len; i++) {
            var th = ths[i];
            var column = th.getAttribute("column");
            if (column) {
                var sp = document.createElement('span');
                sp.className = 'sort-default';
                sp.innerHTML = '&nbsp;';
                th.appendChild(sp);
                $(th).click(function() {
                    var span = $(this).find('span');
                    var order = 'desc';
                    if($(span).hasClass('sort-desc')){
                        order = 'asc';
                    }
                    that.setOrderColumn(span, 'sort-' + (that.params[that.mapKeys.order] = order));
                    that.params[that.mapKeys.orderBy] = this.getAttribute("column");
                    that.send();
                }).css('cursor', 'pointer');
            }
        }
    },
    setOrderColumn : function(column, status) {
        $(column).removeClass().addClass(status);
    },
    fill : function(data) {
        if (data && typeof data == 'object') {
            var rows = data[this.mapKeys.rows];
            if (rows && rows.length > 0) {
                var trs = "";
                for ( var i = 0, len = rows.length; i < len; i++) {
                    var model = rows[i];
                    model = this.modifyModel(model);
                    trs += this.modifyNode(this.parseTemplate(model), model);
                }
                $(this.holderNode.tBodies[0]).html(trs); // 如果用原生JS，IE还需要处理table的innerHTML问题
            } else {
                var colspan = 0;
                $(this.holderNode.tHead).find('tr:eq(0)').find('th').each(function() {
                    colspan += this.colSpan;
                });
                // empty
                $(this.holderNode.tBodies[0]).html(
                        '<tr><td style="text-align:center;" colspan="' + colspan + '">没有数据</td></tr>');
                if (!this.nopage) {
					data[this.mapKeys.totalPage] = 0;
					data[this.mapKeys.currentPage] = 0;
				}
            }
        } else {
            var colspan = 0;
            $(this.holderNode.tHead).find('tr:eq(0)').find('th').each(function() {
                colspan += this.colSpan;
            });
            $(this.holderNode.tBodies[0]).html(
                    '<tr><td style="text-align:center;" colspan="' + colspan + '">没有数据</td></tr>');
            if (!this.nopage) {
				data[this.mapKeys.totalPage] = 0;
				data[this.mapKeys.currentPage] = 0;
			}
        }
        if (!this.nopage) {
            this.initPage(data);
        }
        this.highlight();
        this.onfilled(data);
    },
    parseTemplate : function(model) {
		var that = this;
        return this.template.replace(this.trReg, function() {
            var fun = arguments[1];
            var args = arguments[2];
            var prop = arguments[3];
            if (fun) {
                var paramArr = args.split(that.dotReg);
                var arr = [];
                for ( var i = 0; i < paramArr.length; i++) {
                    var isRep = that.propReg.exec(paramArr[i]);
                    if (isRep) {
                        if (typeof model[isRep[1]] == 'string'){
                        	arr.push(escapeJS(model[isRep[1]]));
                        }else{
                        	arr.push(model[isRep[1]]);
                        }
                    } else {
                        if (typeof paramArr[i] == 'string'){
                        	arr.push(escapeJS(paramArr[i]));
                        }else{
                        	arr.push(paramArr[i]);
                        }
                    }
                }
                return new Function("return " + fun + ".apply(null,[" + arr.join(",") + "])")();
            } else if (prop) {
                return model[prop] === undefined ? '' : model[prop];
            }
        });
    },
    highlight : function() {
        // 高亮当前行
        $(this.holderNode.tBodies[0]).find('tr').each(function(idx, obj) {
            if (idx & 1) {
                $(obj).removeClass("mouseout-odd").addClass("mouseout");
            } else {
                $(obj).removeClass("mouseout-odd").addClass("mouseout-odd");
            }
            $(obj).mouseover(function() {
                $(this).addClass("mouseover");
            }).mouseout(function() {
                $(this).removeClass("mouseover");
            });
        });
    },
    initPage : function(data) {
        var that = this;
        if (!this.pageNode) {
            this.pageNode = document.createElement('div');
            this.holderNode.parentNode.insertBefore(this.pageNode, this.holderNode.nextSibling);
            this.pageNode.className = 'pageFlip';
        }
        var txt = this.pageTemplate.replace(this.pageReg, function() {
            return that.params[that.mapKeys[arguments[1]]] = data[that.mapKeys[arguments[1]]];
        });
        this.pageNode.innerHTML = txt;
		var pageNode = $(this.pageNode);
        var btns = [
					pageNode.find('.first-page')[0],
					pageNode.find('.pre-page')[0],
					pageNode.find('.next-page')[0],
					pageNode.find('.last-page')[0],
					pageNode.find('.some-page')[0]
					];
        this.setPageDisabled(btns);
        this.addPageEvent(btns);
    },
    setPageDisabled : function(btns) {
        if (this.params[this.mapKeys.currentPage] <= 1) {
            btns[0].disabled = true;
            btns[1].disabled = true;
            $(btns[0]).addClass("btDis");
            $(btns[1]).addClass("btDis");
        }
        if (this.params[this.mapKeys.currentPage] >= this.params[this.mapKeys.totalPage]) {
            btns[2].disabled = true;
            btns[3].disabled = true;
            $(btns[2]).addClass("btDis");
            $(btns[3]).addClass("btDis");
        }
        if (this.params[this.mapKeys.currentPage] > 1 && this.params[this.mapKeys.currentPage] < this.params[this.mapKeys.totalPage]) {
            btns[0].disabled = false;
            btns[1].disabled = false;
            btns[2].disabled = false;
            btns[3].disabled = false;
            $(btns[0]).removeClass("btDis");
            $(btns[1]).removeClass("btDis");
            $(btns[2]).removeClass("btDis");
            $(btns[3]).removeClass("btDis");
        }
    },
    initMapKeys : function(keysMap) {
        if (typeof keysMap == 'object') {
            for ( var o in keysMap) {
                this.mapKeys[o] = keysMap[o];
            }
        }
    },
    addPageEvent : function(btns) {
        var that = this;
        btns[0].onclick = function() {
            that.goTo(1);
        };
        btns[1].onclick = function() {
            that.goTo(that.params[that.mapKeys.currentPage] - 1);
        };
        btns[2].onclick = function() {
            that.goTo(that.params[that.mapKeys.currentPage] + 1);
        };
        btns[3].onclick = function() {
            that.goTo(that.params[that.mapKeys.totalPage]);
        };
        btns[4].onkeydown = function(e) {
            e = e || window.event;
            var code = e.keyCode;
            var val = (e.target || e.srcElement)['value'];
            if (code == 13) {
                that.goTo(val);
            }
        };
        btns[4].style.imeMode = 'disabled';
        btns[4].oncontextmenu = function() {
            return false;
        };
    },
    defaultParams : function() {
        if (!this.nopage) {
            this.params[this.mapKeys.currentPage] = 1;
            this.params[this.mapKeys.prePageRows] = 10;
        }
        this.params[this.mapKeys.searchIdx] = "";
        this.params[this.mapKeys.searchTxt] = "";
        this.params[this.mapKeys.order] = "desc";
        this.params[this.mapKeys.orderBy] = "Id";
    },
    onerror : function(e) {
        alert("ajax grid error");//window.location.href = "/ExchangeWebsite/error.jsp";
    },
    onfilled : function() {
    },
    modifyNode : function(tr, model) {
        return tr;
    },
    modifyModel : function(model) {
        return model;
    },
    send : function(params) {
        if (typeof params == 'object') {
            for ( var p in params) {
                var k = this.mapKeys[p];
                this.params[k || p] = params[p];
            }
        }
        if(this.params[this.mapKeys.currentPage] === 0){
            this.params[this.mapKeys.currentPage] = 1;
        }
        var orderBy = this.params[this.mapKeys.orderBy];
        if(orderBy){
            var ths = $(this.holderNode.tHead).find('th');
            var currentSpan = null;
            for ( var i = 0, len = ths.length; i < len; i++) {
                var th = ths[i];
                var column = th.getAttribute("column");
                if (column) {
                    var span = $(th).find('span');
                    if (column == orderBy) {
                    	currentSpan = span;
                    } else {
                        this.setOrderColumn(span, 'sort-default');
                    }
                }
            }
            currentSpan && this.setOrderColumn(currentSpan, 'sort-' + this.params[this.mapKeys.order]);
        }
        $.ajax({
            url : this.url,
            data : this.params,
            type : this.method || 'POST',
            dataType : 'json',
            context : this,
            success : this.fill,
            error : this.onerror
        });
    },
    goTo : function(page) {
        if (!/^\d+$/.test(page))
            return;
        if (page < 1)
            page = 1;
        if (page > this.params[this.mapKeys.totalPage])
            page = this.params[this.mapKeys.totalPage];
        this.send({
            currentPage : page
        });
    }
};
var jsMeta = {
    '\b' : '\\b',
    '\t' : '\\t',
    '\n' : '\\n',
    '\f' : '\\f',
    '\r' : '\\r',
    '\\' : '\\\\'
};
var htmlMeta = {
    '&' : '&amp;',
    '<' : '&lt;',
    '>' : '&gt;',
    '"' : '&quot;',
    "'" : '&#39;',
    '\\' : '\\\\',
    '\"' : '\\"'
};
var escapeHTML = function(txt) {
    if (typeof txt == 'undefined')
        return "";
    if (typeof txt != 'string')
        return txt;
    return txt.replace(/\\|\"|&|<|>|"|'/g, function() {
        return htmlMeta[arguments[0]];
    });
};
var escapeJS = function(str) {
    if (typeof str == 'undefined')
        return "";
    str = str.replace(/[\x00-\x1f\\]/g, function(chr) {
        var special = jsMeta[chr];
        return special ? special : '\\u' + ('0000' + chr.charCodeAt(0).toString(16)).slice(-4);
    });
    return '"' + str.replace(/"/g, '\\"') + '"';
};