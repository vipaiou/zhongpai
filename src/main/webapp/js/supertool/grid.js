(function() {
    /*
     * Grid
     */var $, DFT_OPTIONS, DFT_PAGE_NO, DFT_PAGE_SIZE, Grid, Pager, get, isDigit, isOperation, parseHtml, parseJs;
    var __bind = function(fn, me) {
        return function() {
            return fn.apply(me, arguments);
        };
    };
    $ = jQuery;
    if (!(window.msg != null)) {
        window.msg = {};
    }
    if (!(window.msg.grid != null)) {
        window.msg.grid = {
            dft : {
                noDataHint : '没有匹配的记录'
            },
            pageNo : '第{0}页'
        };
    }
    /*
     * 将form的数据转化成Map
     */
    $.fn.toMap = function() {
        var array, item, map, _i, _len;
        map = {};
        array = $(this).serializeArray();
        for (_i = 0, _len = array.length; _i < _len; _i++) {
            item = array[_i];
            map[item.name] = $.trim(item.value);
        }
        return map;
    };
    DFT_PAGE_SIZE = 15;
    DFT_PAGE_NO = 1;
    /*
     * 默认的Grid参数
     */
    DFT_OPTIONS = {
        /*
         * 当paged为false时，要求后台传过来的数据是json数组
         */
        paged : true,
        fillEmpty : true,
        pageNo : DFT_PAGE_NO,
        pageSize : DFT_PAGE_SIZE,
        noDataHint : window.msg.grid.dft.noDataHint,
        stripe : true
    };
    Grid = (function() {
        function Grid(options) {
            var nCol, _base, _base2, _base3, _base4, _ref, _ref2, _ref3, _ref4, _ref5, _ref6, _ref7;
            this.options = options;
            this.table = this.options.table;
            this.table.addClass('grid');
            this.thead = this.table.find('thead:not(.format)');
            this.tbody = this.table.find('tbody');
            this.template = this.options.format;
            this.format = this.parseFormat();
            if ((_ref = (_base = this.options).pageSize) != null) {
                _ref;
            } else {
                _base.pageSize = DFT_PAGE_SIZE;
            }
            ;
            if ((_ref2 = (_base2 = this.options).noDataHint) != null) {
                _ref2;
            } else {
                _base2.noDataHint = DFT_OPTIONS.noDataHint;
            }
            ;
            if ((_ref3 = (_base3 = this.options).fillEmpty) != null) {
                _ref3;
            } else {
                _base3.fillEmpty = DFT_OPTIONS.fillEmpty;
            }
            ;
            if ((_ref4 = (_base4 = this.options).stripe) != null) {
                _ref4;
            } else {
                _base4.stripe = DFT_OPTIONS.stripe;
            }
            ;
            nCol = this.template.find('td:not(.hidden)').length;
            this.initSearch();
            this.data = (_ref5 = this.options.data) != null ? _ref5 : {};
            this.paged = (_ref6 = this.options.paged) != null ? _ref6 : true;
            if (this.paged) {
                this.pager = new Pager((_ref7 = this.options.pager) != null ? _ref7 : $('#pager'), this);
                this.updateData({
                    pageNo : DFT_PAGE_NO,
                    pageSize : this.options.pageSize
                });
            }
            this.initSort();
        }
        Grid.prototype.initSearch = function() {
            var qsearchBtn, _ref;
            this.searchForm = (_ref = this.options.searchForm) != null ? _ref : $('form.search');
            qsearchBtn = $('#qsearch-button');
            return qsearchBtn.click(__bind(function() {
                return this.search;
            }, this));
        };
        Grid.prototype.initSort = function() {
            var columns, order, orderby, sorters, _ref, _ref2, _ref3, _ref4, _ref5, _ref6, _ref7;
            columns = this.thead.find('th[column]');
            if (this.options.orderBy != null) {
                _ref = this.options.orderBy;
                for (orderby in _ref) {
                    order = _ref[orderby];
                    this.defaultSortColumn = $('th[column=' + orderby + ']');
                    this.defaultOrder = order;
                }
            }
            if ((_ref2 = this.defaultSortColumn) != null) {
                _ref2;
            } else {
                this.defaultSortColumn = (_ref3 = (_ref4 = this.options.sort) != null ? _ref4.by : void 0) != null ? _ref3
                        : columns.first();
            }
            ;
            columns.each(function() {
                if ($(this).find('span.sort').size() === 0) {
                    return $(this).append('<span class="sort">&nbsp;&nbsp;&nbsp;&nbsp;</span>');
                }
            });
            sorters = columns.find('span.sort');
            sorters.each(function() {
                return $(this).attr('column', $(this).parent().attr('column'));
            });
            this.defaultSorter = this.defaultSortColumn.find('span.sort');
            if ((_ref5 = this.defaultOrder) != null) {
                _ref5;
            } else {
                this.defaultOrder = (_ref6 = (_ref7 = this.options.sort) != null ? _ref7.order : void 0) != null ? _ref6
                        : 'desc';
            }
            ;
            this.defaultSorter.addClass(this.defaultOrder);
            sorters.unbind('click').click(__bind(function(e) {
                var col;
                col = $(e.target);
                order = 'desc';
                if (col.hasClass('desc')) {
                    order = 'asc';
                }
                sorters.removeClass('desc asc').addClass('sort');
                col.addClass(order);
                col.trigger('sort', [ order ]);
                return this.sort(col.attr('column'), order);
            }, this));
            return this.updateData({
                orderBy : this.defaultSorter.attr('column'),
                order : this.defaultOrder
            });
        };
        Grid.prototype.search = function(param) {
            var data;
            data = this.searchForm.toMap();
            $.extend(data, {
                pageNo : 1
            });
            if (param != null) {
                $.extend(data, param);
            }
            return this.load(data);
        };
        Grid.prototype.sort = function(orderBy, order) {
            return this.load({
                orderBy : orderBy,
                order : order
            });
        };
        Grid.prototype.parseFormat = function() {
            var html;
            html = this.options.format.html().replace(/%7B/g, '{').replace(/%7D/g, '}');
            return this.format = new RowParser(html);
        };
        Grid.prototype.updateData = function(data) {
            if (data != null) {
                return $.extend(this.data, data);
            }
        };
        Grid.prototype.setPageSize = function(pageSize) {
            this.options.pageSize = pageSize;
            return this.updateData({
                pageSize : pageSize
            });
        };
        Grid.prototype.clear = function() {
            this.tbody.empty();
        };
        Grid.prototype.reload = function() {
            return this.load();
        };
        Grid.prototype.load = function(data) {
            if (data != null) {
                $.extend(this.data, data);
            }
            this.table.showLoading();
            $.ajax({
                url : this.options.url,
                data : this.data,
                type : 'POST',
                dataType : 'json',
                success : __bind(function(json) {
                    return this.fill(json);
                }, this),
                error : this.options.error,
                complete : __bind(function() {
                    return this.table.hideLoading();
                }, this)
            });
            return this;
        };
        Grid.prototype.fill = function(json) {
            this.table.trigger('beforeFill', [ json ]);
            var cnt, cols, empty, emptyHtml, i, len, pageInfo, rest, row, rows, _i, _len, _ref;
            rows = this.paged ? json.rows : json;
            cols = this.thead.find('tr').first().find('th:not(.hidden)').size();
            this.tbody.detach();
            this.tbody.empty();
            len = (_ref = rows != null ? rows.length : void 0) != null ? _ref : 0;
            if (len === 0) {
                this.table.data("_hasData", false);
                if (this.paged) {
                    this.tbody.append(
                       "<tr class=\"empty\"><td class=\"empty\" colspan=\"" + cols + "\">" + this.options.noDataHint + "</td></tr>");
                } else {
                    this.tbody.append(
                       "<tr class=\"empty\"><td class=\"empty-nopage\" colspan=\"" + cols + "\">" + this.options.noDataHint + "</td></tr>");
                    this.tbody.find('td').css('height', this.tbody.parentsUntil('div').height());
                }
            } else {
                this.table.data("_hasData", true);
                cnt = 0;
                for (_i = 0, _len = rows.length; _i < _len; _i++) {
                    row = rows[_i];
                    cnt++;
                    this.tbody.append(this.format.parse(row));
                    this.table.trigger('onRow', [ this.tbody.find('tr').last(), row, json ]);
                    if (this.paged && cnt > this.options.pageSize) {
                        break;
                    }
                }
                /*
                 * 用空行填补剩余的行数
                 */
                if (this.paged && this.options.fillEmpty) {
                    if (cnt < this.options.pageSize) {
                        rest = this.options.pageSize - cnt - 1;
                        empty = this.template.clone();
                        empty.find('td').empty();
                        emptyHtml = empty.html();
                        for (i = 0; 0 <= rest ? i <= rest : i >= rest; 0 <= rest ? i++ : i--) {
                            this.tbody.append(emptyHtml);
                        }
                    }
                }
            }
            this.table.append(this.tbody);
            /*
             * 更新pageInfo
             */
            if (this.paged) {
                pageInfo = {
                    totalPages : json.totalPages,
                    pageNo : json.pageNo,
                    totalRecords : json.totalRecords
                };
                this.pager.update(pageInfo);
            }
            /*
             * 斑马
             */
            if (this.options.stripe) {
                if ($.isFunction(this.table.stripe)) {
                    this.table.stripe();
                }
            }
            return this.table.trigger('filled', [ json ]);
        };
        Grid.prototype.hideCol = function(n) {
            return this.nthCol(n).addClass('hidden');
        };
        Grid.prototype.showCol = function(n) {
            return this.nthCol(n).removeClass('hidden');
        };
        Grid.prototype.toggleCol = function(n) {
            return this.nthCol(n).toggle();
        };
        Grid.prototype.switchCol = function(n, isOn) {
            if (isOn) {
                return this.showCol(n);
            } else {
                return this.hideCol(n);
            }
        };
        Grid.prototype.nthCol = function(n) {
            var tds, ths;
            ths = this.thead.find('tr').find('th:eq(' + n + ')');
            tds = this.tbody.find('tr').find('td:eq(' + n + ')');
            return ths.add(tds);
        };
        Grid.prototype.findTds = function(tr, positions) {
            var i, ret, tds, _i, _len;
            tds = tr.find('td');
            ret = [];
            for (_i = 0, _len = positions.length; _i < _len; _i++) {
                i = positions[_i];
                ret.push(tds[i]);
            }
            return ret;
        };
        Grid.prototype.findThs = function(tr, positions) {
            var i, ret, ths, _i, _len;
            ths = tr.find('th');
            ret = [];
            for (_i = 0, _len = positions.length; _i < _len; _i++) {
                i = positions[_i];
                ret.push(ths[i]);
            }
            return ret;
        };
        Grid.prototype.showCols = function(positions, f) {
            var findTds, th, that, ths, _i, _len;
            this.thead.find('tr th:not(.fixed)').addClass('hidden');
            ths = this.findThs(this.thead.find('tr'), positions);
            for (_i = 0, _len = ths.length; _i < _len; _i++) {
                th = ths[_i];
                $(th).removeClass('hidden');
            }
            that = this;
            findTds = this.findTds;
            this.tbody.find('tr').each(function() {
                $(this).find('td:not(.fixed):not(.empty)').addClass('hidden');
                var td, tds, _j, _len2, _results;
                tds = findTds($(this), positions);
                for (_j = 0, _len2 = tds.length; _j < _len2; _j++) {
                    td = tds[_j];
                    $(td).removeClass('hidden');
                }
            });
            return this;
        };

        Grid.prototype.bind = function(event, f) {
            return this.table.bind(event, f);
        };
        Grid.prototype.one = function(event, f) {
            return this.table.one(event, f);
        };
        Grid.prototype.unbind = function(event) {
            return this.table.unbind(event);
        };
        return Grid;
    })();
    parseHtml = function(html) {
        return html.replace(/(\n|\s{2,})/g, ' ').replace(/"/g, '\\"').replace(/@{(([^}]|}[^@])*)}@/g, function() {
            return parseJs(arguments[1]);
        }).replace(/{([^}]+)}/g, '", get(row, "$1"), "').replace(/%7B(([^%]|%[^7]|%7[^D])+)%7D/g,
                '", get(row, "$1"), "');
    };
    parseJs = function(text) {
        return '", '
                + text.replace(/{([^}]+)}/g, 'get(row, "$1")').replace(/%7B(([^%]|%[^7]|%7[^D])+)%7D/g,
                        'get(row, "$1")') + ', "';
    };
    /*
     * 根据path指定的路径从o对象中取得子元素，如果中途遇到null，则返回""
     */
    get = function(o, path) {
        var p, ps, ret, _i, _len;
        ps = path.split(/\./);
        ret = o;
        if (!(ret != null)) {
            return;
        }
        for (_i = 0, _len = ps.length; _i < _len; _i++) {
            p = ps[_i];
            if (null === ret[p]) {
                return "";
            }
            ret = ret[p];
            if (!(ret != null)) {
                return;
            }
        }
        return ret;
    };
    /*
     * 分页器
     */
    Pager = (function() {
        function Pager(pagerDiv, grid) {
            this.pager = pagerDiv;
            this.grid = grid;
            this.pageInfo = {};
            this.firstBtn = this.pager.find('button.first');
            this.lastBtn = this.pager.find('button.last');
            this.prevBtn = this.pager.find('button.prev');
            this.nextBtn = this.pager.find('button.next');
            this.pageAt = this.pager.find('label.pageAt');
            this.pageNo = this.pager.find('input.pageNo');
            this.goBtn = this.pager.find('button.go');
            this.totalPages = this.pager.find('span.totalPages');
            this.totalRecords = this.pager.find('span.totalRecords');
            this.init();
        }
        Pager.prototype.init = function() {
            var pageInfo;
            pageInfo = {
                totalPages : 10,
                totalRecords : 150,
                pageNo : 1
            };
            this.update(pageInfo);
            this.firstBtn.click(__bind(function() {
                return this.first();
            }, this));
            this.lastBtn.click(__bind(function() {
                return this.last();
            }, this));
            this.prevBtn.click(__bind(function() {
                return this.prev();
            }, this));
            this.nextBtn.click(__bind(function() {
                return this.next();
            }, this));
            this.goBtn.click(__bind(function() {
                return this.go(Number(this.pageNo.val()));
            }, this));
            return this.pageNo.enter(__bind(function(event) {
                return this.goBtn.click();
            }, this), __bind(function(event) {
                var num, val;
                val = this.pageNo.val();
                if (isDigit(event)) {
                    num = val + String.fromCharCode(event.keyCode);
                    if (num == 0 || num == '`') {
                    	return false;
                    } else if (num.length > 5) {
                        return false;
                    } else {
                        return true;
                    }
                }
                if (isOperation(event)) {
                    return true;
                }
                return false;
            }, this));
        };
        Pager.prototype.go = function(pageNo) {
            if (pageNo > this.pageInfo.totalPages) {
                pageNo = this.pageInfo.totalPages;
            }
            if (pageNo < 1) {
                pageNo = 1;
            }
            return this.grid.load({
                pageNo : pageNo
            });
        };
        Pager.prototype.first = function() {
            return this.go(1);
        };
        Pager.prototype.last = function() {
            return this.go(this.pageInfo.totalPages);
        };
        Pager.prototype.prev = function() {
            return this.go(this.pageInfo.pageNo - 1);
        };
        Pager.prototype.next = function() {
            return this.go(this.pageInfo.pageNo + 1);
        };
        Pager.prototype.update = function(pageInfo) {
            var options, totalPagesChanged;
            totalPagesChanged = this.pageInfo.totalPages !== pageInfo.totalPages;
            $.extend(this.pageInfo, pageInfo);
            this.totalPages.text(this.pageInfo.totalPages);
            this.totalRecords.text(this.pageInfo.totalRecords);
            if (this.pageInfo.totalPages === 0) {
                this.pageAt.text(S.msg(msg.grid.pageNo, 0));
            } else {
                this.pageAt.text(S.msg(msg.grid.pageNo, this.pageInfo.pageNo));
            }
            if (totalPagesChanged) {
                options = this.pages();
                this.pager.find('select').empty().append(options.join(''));
            }
            this.firstBtn.switchFor(this.pageInfo.pageNo > 1);
            this.lastBtn.switchFor(this.pageInfo.pageNo < this.pageInfo.totalPages);
            this.prevBtn.switchFor(this.pageInfo.pageNo > 1);
            return this.nextBtn.switchFor(this.pageInfo.pageNo < this.pageInfo.totalPages);
        };
        Pager.prototype.selectedOption = function() {
            return this.pager.find('select option[value=' + this.pageInfo.pageNo + ']');
        };
        Pager.prototype.pages = function() {
            var i, _ref, _results;
            _results = [];
            for (i = 1, _ref = this.pageInfo.totalPages; 1 <= _ref ? i <= _ref : i >= _ref; 1 <= _ref ? i++ : i--) {
                _results.push("<option value=\"" + i + "\">第" + i + "页</option>");
            }
            return _results;
        };
        return Pager;
    })();
    isDigit = function(event) {
        var keyCode;
        keyCode = event.keyCode;
        return (keyCode >= 48 && keyCode <= 57 && !event.shiftKey)
                || (keyCode >= 96 && keyCode <= 105 && !event.shiftKey);
    };
    isOperation = function(event) {
        var keyCode;
        keyCode = event.keyCode;
        return $.inArray(keyCode, [ 8, 9, 17, 18, 20, 27, 32, 35, 36, 37, 39, 46, 116 ]) >= 0 || event.ctrlKey
                && keyCode !== 86;
    };
    (typeof exports !== "undefined" && exports !== null ? exports : this).Grid = Grid;
    (typeof exports !== "undefined" && exports !== null ? exports : this).parseHtml = parseHtml;
    (typeof exports !== "undefined" && exports !== null ? exports : this).get = get;
}).call(this);
