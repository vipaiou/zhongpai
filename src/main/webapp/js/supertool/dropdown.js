(function() {
    var DropDown, DropDownData, ElemData, Feeder, JsData, SearchableMultiCheckDropDown, SearchableMultiCheckFeeder, SearchableSelectDropDown, SearchableSelectFeeder, SelectData, SelectDropDown, SelectFeeder, bodyTemplate, containerTemplate, ddmsg, headTemplate;
    var __bind = function(fn, me) {
        return function() {
            return fn.apply(me, arguments);
        };
    }, __hasProp = Object.prototype.hasOwnProperty, __extends = function(child, parent) {
        for ( var key in parent) {
            if (__hasProp.call(parent, key))
                child[key] = parent[key];
        }
        function ctor() {
            this.constructor = child;
        }
        ctor.prototype = parent.prototype;
        child.prototype = new ctor;
        child.__super__ = parent.prototype;
        return child;
    };
    if (!(window.msg != null)) {
        window.msg = {};
    }
    /*
     * # 国际化
     */
    if (!(window.msg.dropdown != null)) {
        window.msg.dropdown = {
            title : '--请选择--',
            multicheck : {
                title : '--请选择--'
            },
            search : '搜索',
            nodata : '没有匹配的记录',
            selectAll: '全选',
            flipAll: '反选',
            cancelAll: '取消',
            ok: '确定',
            cancel: '取消'
        };
    }
    ddmsg = window.msg.dropdown;
    containerTemplate = function(head, body) {
        return "<div class=\"dropdown\">\n  <div class=\"head\">\n    " + head
                + "\n  </div>\n  <div class=\"body\">\n    " + body + "\n  </div>\n</div>";
    };
    headTemplate = function(items) {
        return ""
                + items
                + "\n<button type=\"button\" class=\"title\">"
                + "</button><button type=\"button\" class=\"icon\"><center style=\"*margin-left:-8px;\"><span class=\"close\">&nbsp;&nbsp;&nbsp;&nbsp;</span></center></button>";
    };
    bodyTemplate = function(toolbar, items, bottom) {
        return "<div class=\"toolbar\">\n  " + toolbar
                + "\n</div>\n<div class=\"content\">\n  <div class=\"scroll\">\n  " + items
                + "\n  </div>\n</div>\n<div class=\"bottom\">\n  " + bottom + "\n</div>";
    };
    /*
     * DropDown容器，只提供框架和位置，具体格式由Feeder填入
     */
    DropDown = (function() {
        function DropDown(elem, feeder) {
            this.elem = elem;
            this.feeder = feeder;
            this.html = containerTemplate(this._headTemplate(this._headItems()), this._bodyTemplate(this
                    ._toolbar(), this._bodyItems(), this._bottom()));
            this.div = $(this.html);
            this.div.insertAfter(this.elem);
            this.elem.addClass('invisible');
            this.head = this.div.find('.head');
            this.body = this.div.find('.body');
            this.title = this.head.find('.title');
            this.icon = this.head.find('.icon');
            this.title.click(function(e) {
                return e.preventDefault();
            });
            this.icon.click(function(e) {
                return e.preventDefault();
            });
            this.iconPic = this.icon.find('span');
            this.mouseInside = false;
            this.head.click(__bind(function() {
                return this.toggleBody();
            }, this));
            this.div.hover(__bind(function() {
                this.mouseInside = true;
                return true;
            }, this), __bind(function() {
                this.mouseInside = false;
                return true;
            }, this));
            this.content = this.body.find('.content');
            this.afterfill();
            this.elem.bind('refill', __bind(function() {
                return this.refill();
            }, this));
            if (this.feeder.isEmpty) {
                this.disable();
            }
        }
        DropDown.prototype.afterfill = function() {
            var size;
            this.feeder.onComplete(this);
            size = this.elem.find('option').size();
            this.setTitle(this.feeder.getTitle(), 10);
            if (size <= 1) {
                if (size === 1) {
                    this.elem.trigger('change');
                }
                return this.head.addClass('unique');
            } else {
                return this.head.removeClass('unique');
            }
        };
        DropDown.prototype.setTitle = function(text, maxLength) {
            if (maxLength === undefined) {
                maxLength = 10;
            }
            this.title.html(S.textOverflow2Html(text, maxLength));
            this.title.attr('title', text);
        };
        DropDown.prototype.refill = function() {
            this.enable();
            this.feeder.refill();
            this.body.find('.scroll').empty().html(this.feeder.bodyItems());
            this.afterfill();
        };
        DropDown.prototype.items = function() {
            return this.body.find('ul.items li');
        };
        DropDown.prototype.toggleBody = function() {
            if (this.disabled()) {
                return;
            }
            if (this.items().size() <= 1) {
                return;
            }
            if (this.body.is(':hidden')) {
                return this.open();
            } else {
                return this.close();
            }
        };
        DropDown.prototype.open = function() {
            $('body').one('mouseup', __bind(function() {
                if (!this.mouseInside) {
                    this.close();
                    return false;
                }
            }, this));
            if (!this.head.is(':hidden')) {
                var pos = this.head.position();
                this.body.css('top', pos.top + 15).css('left', pos.left);
            }
            this.body.show();
            this.iconPic.removeClass('close');
            this.elem.trigger('open');
            var height = this.body.find('div.scroll')[0].clientHeight;
            if(height > 200){
                this.body.find('div.scroll').css("height", "200px");
            }
            return this.iconPic.addClass('open');
        };
        DropDown.prototype.close = function() {
            this.body.hide();
            this.iconPic.removeClass('open');
            return this.iconPic.addClass('close');
        };
        DropDown.prototype.hide = function() {
            this.head.hide();
            return this.close();
        };
        DropDown.prototype.show = function() {
            return this.head.show();
        };
        DropDown.prototype.disable = function() {
            Log.debug('disable');
            this.close();
            this.head.addClass('disabled');
            this.head.find('button').attr('disabled', true);
            return this.setTitle(ddmsg.title);
        };
        DropDown.prototype.suspend = function() {
            this.close();
            this.head.addClass('disabled');
            this.head.find('button').attr('disabled', true);
            return this;
        };        
        DropDown.prototype.enable = function() {
            this.head.removeClass('disabled');
            return this.head.find('button').attr('disabled', false);
        };
        DropDown.prototype.disabled = function() {
            return this.head.hasClass('disabled');
        };

        /**
         * TODO: 现在_set的作用只剩下设置title了，应该和setTitle合起来
         * @param val
         * @returns
         */
        DropDown.prototype._set = function(val) {
            var item;
            item = this.content.find('li[val="' + val + '"]');
            var text = '';
            if (item.length == 0) {
                text = ddmsg.title;
            } else {
                var span = item.find('span');
                var title = span.attr('title');
                if (typeof title != 'undefined') {
                    text = title;
                } else {
                    text = span.text();
                }
            }
            return this.setTitle(text);
        };

        DropDown.prototype._headTemplate = headTemplate;
        DropDown.prototype._bodyTemplate = bodyTemplate;

        DropDown.prototype._headItems = function() {
            return this.feeder.headItems();
        };
        DropDown.prototype._toolbar = function() {
            return this.feeder.toolbar();
        };
        DropDown.prototype._bodyItems = function() {
            return this.feeder.bodyItems();
        };
        DropDown.prototype._bottom = function() {
            var _ref;
            return (_ref = this.feeder.bottom()) != null ? _ref : '';
        };
        DropDown.prototype.trigger = function(e) {
            return this.elem.trigger(e);
        };
        return DropDown;
    })();
    SearchableSelectDropDown = (function() {
        __extends(SearchableSelectDropDown, DropDown);
        function SearchableSelectDropDown(select, options) {
            SearchableSelectDropDown.__super__.constructor.call(this, select, new SearchableSelectFeeder(select, options));
        }
        return SearchableSelectDropDown;
    })();
    SelectDropDown = (function() {
        __extends(SelectDropDown, DropDown);
        function SelectDropDown(select, options) {
            SelectDropDown.__super__.constructor.call(this, select, new SelectFeeder(select, options));
        }
        return SelectDropDown;
    })();
    SearchableMultiCheckDropDown = (function() {
        __extends(SearchableMultiCheckDropDown, DropDown);
        function SearchableMultiCheckDropDown(select) {
            SearchableMultiCheckDropDown.__super__.constructor.call(this, select,
                    new SearchableMultiCheckFeeder(select));
        }
        return SearchableMultiCheckDropDown;
    })();
    DropDown.TITLE = ddmsg.title;
    /*
     * # 从Data里获得数据，再组装成HTML，传给DropDown类填入
     */
    Feeder = (function() {
        function Feeder() {
        }
        Feeder.prototype.constuctor = function(data, options) {
            this.data = data;
            this.options = options || {};
        };
        Feeder.prototype.getTitle = function() {
            return '';
        };
        Feeder.prototype.headItems = function() {
            return '';
        };
        Feeder.prototype.toolbar = function() {
            return '';
        };
        Feeder.prototype.bodyItems = function() {
            return '';
        };
        Feeder.prototype.bottom = function() {
            return '';
        };
        Feeder.prototype.onComplete = function() {
        };
        return Feeder;
    })();
    SelectFeeder = (function() {
        __extends(SelectFeeder, Feeder);
        function SelectFeeder(select, options) {
            this.data = new SelectData(select);
            this.initDataItems();
            this.options = options || {};
        }
        SelectFeeder.prototype.initDataItems = function() {
            this.dataItems = this.data.items();
            return this.isEmpty = this.dataItems.length === 0;
        };
        SelectFeeder.prototype.getTitle = function() {
            return this.title;
        };
        SelectFeeder.prototype.findItemByValue= function(val) {
            for (var i = 0; i < this.dataItems.length; ++i) {
                var item = this.dataItems[i];
                if (item.val == val) {
                    return item;
                }
            }
            return null;
        };
        SelectFeeder.prototype.bodyItems = function() {
            var item, ul, _i, _len, _ref;
            ul = [];
            if (this.dataItems.length === 0) {
                return '';
            }
            ul.push('<ul class="items">');
            _ref = this.dataItems;
            for (_i = 0, _len = _ref.length; _i < _len; _i++) {
                item = _ref[_i];
                ul.push("<li val=\"" + item.val + "\">" + S.textOverflow2Html(item.html, 10) + "</li>");
            }
            ul.push('</ul>');
            return ul.join('');
        };
        SelectFeeder.prototype.refill = function() {
            this.initDataItems();
        };
        SelectFeeder.prototype.onComplete = function(dropdown) {
            var body = dropdown.body;
            body.mouseup(function(e) {
                e.preventDefault();
                return false;
            });
            var val = dropdown.elem.val();
            
            var isSelected = this.options.selected;
            // 当没有选中的数据时，给elem前面加一个“请选择”选项，以免直接选中第一个
            if (this.dataItems.length > 1 && !isSelected && !this.options.startOnFirst) {
                val = '-1';
                dropdown.elem.prepend('<option value="-1">' + ddmsg.title + '</option>');
                setTimeout(function() {
                    dropdown.elem.val('-1');
                }, 0);
            }
            this.val = val;
            // 处理标题, dropdown 会在onComplete()后调用标题
            if (this.isEmpty) {
                this.title = 'N/A';
            } else if (this.dataItems.length === 1) {
                this.title = this.dataItems[0].html;
            } else {
                if (isSelected) {
                if (typeof this.val != 'undefined') {
                        var item = this.findItemByValue(this.val);
                        if (null != item) {
                            this.title = item.html;
                        } else {
                            this.title = ddmsg.title;
                        }
                    } else {
                        this.title = ddmsg.title;
                    }
                } else {
                    if (!this.options.startOnFirst) {
                        this.title = ddmsg.title;
                    } else {
                        this.title = this.dataItems[0].html;
                    }
                }
            }
            this.val = val;
            var div = dropdown.div;
            this.ul = div.find('ul.items').delegate('li', 'click', function() {
                that = $(this);
                val = that.attr('val');
                old = dropdown.elem.val();
                if (old !== val) {
                    dropdown.elem.val(val);
                    dropdown._set(val);
                    dropdown.trigger('change');
                } else if (val == '-1') { // '-1'时，表示选择了'N/A',这是用'N/A'替换'--请选择--'
                    dropdown._set(val);
                }
                return dropdown.close();
            });
        };
        return SelectFeeder;
    })();

    /**
     * 带搜索的下拉选择框
     */
    SearchableSelectFeeder = (function() {
        __extends(SearchableSelectFeeder, SelectFeeder);
        function SearchableSelectFeeder(select, options) {
            SearchableSelectFeeder.__super__.constructor.call(this, select, options);
            this.data = new SelectData(select);
            this.initDataItems();
        }
        SearchableSelectFeeder.prototype.toolbar = function() {
            return '<input type="text" size="10" class="search-value" /><button type="button" class="search"></button>';
        };
        SearchableSelectFeeder.prototype.onComplete = function(dropdown) {
            SearchableSelectFeeder.__super__.onComplete.call(this, dropdown);
            var body, div, ul;
            body = dropdown.body;
            this.search = body.find('input.search-value');
            this.searchBtn = body.find('button.search');
            if (this.dataItems.length <= 1) {
                this.search.hide();
            } else {
                this.search.show();
            }
            body.mouseup(function(e) {
                e.preventDefault();
                return false;
            });
            this.search.enter(__bind(function() {
                return this.searchBtn.trigger('click');
            }, this));
            var ul = this.ul;
            this.searchBtn.click(__bind(function(e) {
                var str;
                str = $.trim(this.search.val()).toLowerCase();
                var cur=this; 
                var total=ul.find('li').size(); 
                var count=0;
                ul.parent().find("a").remove(".no-data");
                ul.find('li').each(function() {
                    var text, that;
                    that = $(this);
                    text = $.trim(that.text()).toLowerCase();
                    if (str === '') {
                        count = total;
                        that.show();
                    } else if (text.indexOf(str) === -1) {
                        that.hide();
                    } else {
                        count++;
                        that.show();
                    }
                });
                if(count == 0){
                    var a = ul.prevAll("a.no-data");
                    if(a.size() == 1){
                        a.show();
                    }else{
                        ul.parent().find("a").remove(".no-data");
                        a = $("<a class='no-data' href='javascript:void(0);'>无匹配的内容</a>");
                        a.insertBefore(ul);
                    }
                    a.click(function(){
                        $(this).hide();
                        $(this).next().find("li").show();
                        cur.search.val('');
                    });
                }else{
                    ul.parent().find("a").remove(".no-data");
                }
            }, this));
            if ($.isFunction($.fn.watermark)) {
                return this.search.watermark(ddmsg.search);
            }
        };
        return SearchableSelectFeeder;
    })();
    SearchableMultiCheckFeeder = (function() {
        __extends(SearchableMultiCheckFeeder, Feeder);
        function SearchableMultiCheckFeeder(select) {
            this.data = new SelectData(select);
            this.dataItems = this.data.items();
        }
        SearchableMultiCheckFeeder.prototype.getTitle = function() {
            return ddmsg.multicheck.title;
        };
        SearchableMultiCheckFeeder.prototype.toolbar = function() {
            return '<input type="text" size="10" class="search-value" /><button type="button" class="search"></button>';
        };
        SearchableMultiCheckFeeder.prototype.bodyItems = function() {
            var item, ul, _i, _len, _ref;
            ul = [];
            ul.push('<a class="hidden empty" href="#">' + ddmsg.nodata + '</a>');
            if (this.dataItems.length === 0) {
                return '';
            }
            ul.push('<ul class="items">');
            _ref = this.dataItems;
            for (_i = 0, _len = _ref.length; _i < _len; _i++) {
                item = _ref[_i];
                ul.push("<li>\n  <input class=\"checkbox\" type=\"checkbox\" value=\"" + item.val + "\" />" + S.textOverflow2Html(item.html) + "\n</li>");
            }
            ul.push('</ul>');
            return ul.join('');
        };
        SearchableMultiCheckFeeder.prototype.bottom = function() {
            return '<div class="opPane">'
                 + '<a href="#" class="checkAll">' + msg.dropdown.selectAll + '</a> <a href="#" class="flipAll">' + msg.dropdown.flipAll + '</a></div> <a href="#" class="hidden uncheckAll">' + msg.dropdown.uncheckAll + '</a>'
                 + '<div class="buttonPane"><button class="ok" type="button">' + msg.dropdown.ok + '</button> <button class="cancel" type="button">' + msg.dropdown.cancel + '</button></div>';
        };
        SearchableMultiCheckFeeder.prototype.onComplete = function(dropdown) {
            var body, div, items, ul;
            div = dropdown.div;
            body = div.find('div.body');
            items = div.find('div.body li');
            div.mouseup(function(e) {
                e.preventDefault();
                return false;
            });
            this.search = body.find('input.search-value');
            this.searchBtn = body.find('button.search');
            if (this.dataItems.length <= 1) {
                this.search.hide();
            } else {
                this.search.show();
            }
            body.mouseup(function(e) {
                e.preventDefault();
                return false;
            });
            ul = body.find('ul.items');
            this.search.enter(__bind(function() {
                return this.searchBtn.trigger('click');
            }, this));
            this.searchBtn.click(__bind(function(e) {
                var str;
                str = $.trim(this.search.val()).toLowerCase();
                ul.find('li').each(function() {
                    var text, that;
                    that = $(this);
                    text = $.trim(that.text()).toLowerCase();
                    if (str === '') {
                        return that.show();
                    } else if (text.indexOf(str) === -1) {
                        return that.hide();
                    } else {
                        return that.show();
                    }
                });
                if (ul.find('li:not(:hidden)').size() === 0) {
                    return body.find('a.empty').show();
                } else {
                    return body.find('a.empty').hide();
                }
            }, this));
            body.find('a.empty').click(__bind(function(e) {
                var elem, that;
                elem = e.target;
                that = $(elem);
                that.hide();
                ul.show();
                ul.find('li').show();
                return false;
            }, this));
            if ($.isFunction($.fn.watermark)) {
                this.search.watermark(ddmsg.search);
            }
            /*
             * #* 事件-全选/反选
             */
            div.find('a.checkAll').click(function() {
                items.find('input:checkbox').attr('checked', true);
                return false;
            });
            div.find('a.flipAll').click(function() {
                items.find('input:checkbox').each(function() {
                    this.checked = !this.checked;
                });
                return false;
            });
            div.find('a.uncheckAll').click(function() {
                items.find('input:checkbox').attr('checked', false);
                return false;
            });
            /*
             * #* 事件 - 确定/取消
             */
            div.find('button.ok').click(function() {
                dropdown.close();
                return dropdown.elem.trigger('ok');
            });
            return div.find('button.cancel').click(function() {
                dropdown.close();
                return dropdown.elem.trigger('cancel');
            });
        };
        return SearchableMultiCheckFeeder;
    })();
    DropDownData = (function() {
        function DropDownData() {
        }
        DropDownData.prototype.items = function() {
        };
        return DropDownData;
    })();
    ElemData = (function() {
        __extends(ElemData, DropDownData);
        function ElemData(elem) {
            this.elem = elem;
        }
        return ElemData;
    })();
    SelectData = (function() {
        __extends(SelectData, ElemData);
        function SelectData(elem) {
            SelectData.__super__.constructor.call(this, elem);
        }
        SelectData.prototype.contentItems = function() {
            return this.items();
        };
        SelectData.prototype.items = function() {
            var items;
            this.opts = this.elem.find('option');
            items = [];
            this.opts.each(function() {
                var html, val;
                val = $(this).val();
                html = $(this).html();
                if ("" !== val) {
                    return items.push({
                        val : val,
                        html : html
                    });
                }
            });
            return items;
        };
        return SelectData;
    })();
    $.fn.searchable = function(options) {
        var dropdown, dropdowns, that;
        that = $(this);
        if (that.size() > 1) {
            dropdowns = {};
            $(this).each(function() {
                var dropdown;
                dropdown = new SearchableSelectDropDown($(this), options);
                $(this).data('dropdown', dropdown);
                return dropdowns[$(this).attr('name')] = dropdown;
            });
            return dropdowns;
        } else {
            dropdown = new SearchableSelectDropDown($(this), options);
            $(this).data('dropdown', dropdown);
            return dropdown;
        }
    };
    $.fn.multiCheck = function(options) {
        var data = $(this).data('dropdown');
        if (data != null) {
            return data;
        }
        var dropdown = new SearchableMultiCheckDropDown($(this), options);
        $(this).data('dropdown', dropdown);
        return dropdown;
    };
    $.fn.dropdown = function(options) {
        var data;
        data = $(this).data('dropdown');
        if (!(data != null)) {
            data = new SelectDropDown($(this), options);
            return data;
        } else {
            return data;
        }
    };
    (typeof exports !== "undefined" && exports !== null ? exports : this).Searchable = SearchableSelectDropDown;
    (typeof exports !== "undefined" && exports !== null ? exports : this).DropDown = DropDown;
}).call(this);
