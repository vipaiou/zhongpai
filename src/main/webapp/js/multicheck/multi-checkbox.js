function MultiCheckbox(table, checkAllBox, checkboxes, ids) {
    this.table = table;
    this.checkAllBox = checkAllBox;
    this.checkCount = 0;
    // 当选中的计数超过maxChecks时，全选框变为选中
    this.maxChecks = 20;
    this.checkboxes = checkboxes;
    this.ids = ids || {};
    var e = this;
    this.checkAllBox.click(function () {
        e.toggleAll();
    });
    // TODO: 需要一个更明确的事件名称
    // TODO: 把MultiCheck和Grid集成起来
    this.table.bind('beforeLoadComplete', function(event, data) {
        e.onRefreshPage(data.rows.length);
    });
}

/**
 * 当页面刷新时（翻页或排序）后，需要重新刷新checkbox的状态
 * @param rows
 * @return
 */
MultiCheckbox.prototype.onRefreshPage = function(rows) {
    var checkboxes = this.checkboxes();
    var e = this;
    var cnt = 0;
    this.maxChecks = rows;
    this.checkCount = 0;
    this.updateCheckAll();
    checkboxes.each(function() {
        if (e.ids[$(this).attr('id')]) {
            e._check($(this));
        }
    });
    debug(e)
    checkboxes.unbind('click').click(function() {
        e.toggle($(this));
    });
};

/**
 * 切换一个checkbox的操作
 * @param checkbox
 * @return
 */
MultiCheckbox.prototype.toggle = function(checkbox) {
    var id = checkbox.attr('id');
    if (checkbox.attr('checked')) {
        this.check(checkbox);
    } else {
        this.uncheck(checkbox);
    }
};

/**
 * 选中一个checkbox
 * @param checkbox
 * @return
 */

MultiCheckbox.prototype._check = function(checkbox) {
    checkbox.attr('checked', true);
    var id = checkbox.attr('id');
    if (this.ids[id] == undefined) {
        this.ids[id] = id;
    }
    if (typeof this.onCheck != 'undefined' && $.isFunction(this.onCheck)) {
        this.onCheck(id, checkbox);
    }
};

MultiCheckbox.prototype.check = function(checkbox) {
    this._check(checkbox);
    this.updateCheckAll();
};

MultiCheckbox.prototype.updateCheckAll = function() {
    this.checkAllBox.attr('checked', false);
    var checks = this.checkboxes();
    var max = checks.size();
    var e = this;
    var cnt = 0;
    checks.each(function() {
        if (e.ids[$(this).attr('id')] != undefined) {
            cnt++;
        }
    });
    if (cnt >= max && cnt > 0) {
        this.checkAllBox.attr('checked', true);
    }
};
/**
 * 取消一个checkbox
 * @param checkbox
 * @return
 */
MultiCheckbox.prototype.uncheck = function(checkbox) {
    checkbox.attr('checked', false);
    var id = checkbox.attr('id');
    if (id in this.ids) {
        delete this.ids[id];
    }
    if (typeof this.onUncheck != 'undefined' && $.isFunction(this.onUncheck)) {
        this.onUncheck(id, checkbox);
    }
    this.checkAllBox.attr('checked', false);
};

MultiCheckbox.prototype.put = function(id, value) {
    this.ids[id] = value;
};
/**
 * 切换全选框
 * @return
 */
MultiCheckbox.prototype.toggleAll = function() {
    if (this.checkAllBox.attr('checked')) {
        this.checkAll();
    } else {
        this.uncheckAll();
    }
};

/**
 * 选中全选框
 * @return
 */
MultiCheckbox.prototype.checkAll = function() {
    this.checkAllBox.attr('checked', true);
    var e = this;
    this.checkboxes().each(function () {
        e.check($(this));
    });
};

/**
 * 取消全选框
 * @return
 */
MultiCheckbox.prototype.uncheckAll = function() {
    this.checkAllBox.attr('checked', false);
    var e = this;
    this.checkboxes().each(function() {
        e.uncheck($(this));
    });
};

/**
 * 重置数据
 * @param id
 * @return
 */
MultiCheckbox.prototype.reset = function(id) {
    this.ids = {};
};

/**
 * 获取选中的ID列表
 * @return
 */
MultiCheckbox.prototype.idList = function() {
    var ret = [];
    for (var i in this.ids) {
        ret.push(i);
    }
    return ret;
};

MultiCheckbox.prototype.idArray = function() {
    var ret = [];
    for (var i in this.ids) {
        var t = i.split("_");
        if (t.length > 1) {
            ret.push(t[t.length - 1]);
        } else {
            ret.push(i);
        }
    }
    return ret;
};


MultiCheckbox.prototype.valueArray = function(filterMap) {
    var ret = [];
    if (filterMap === undefined) {
        for (var i in this.ids) {
            ret.push(this.ids[i]);
        }
        return ret;
    } else {
        for (var i in this.ids) {
            if (i in filterMap) {
                ret.push(this.ids[i]);
            }
        }
        return ret;
    }
};


/**************************
 * 页面选择相关
 **************************/

function initMultiCheck(text) {
    if (text === undefined || text == 0) {
        return;
    }
    // text的格式是
    // ID::NAME1-NAME2-NAME3##ID::NAME1-NAME2-NAME3
    // 各条数据之间的分隔符四 '##'
    // ID和PATH之间的分隔符是 '::'
    var values = text.split('##');
    for (var i = 0; i < values.length; ++i) {
        if ('' != values[i]) {
            value = values[i].split('::');
            multiCheck.put(value[0], values[i]);
        }
    }
}

function arrayToMap(arr) {
    var map = {};
    for (var i = 0; i < arr.length; ++i) {
        map[arr[i]] = true;
    }
    return map;
}
function arrayToMap1(arr) {
    var map = {};
    for (var i = 0; i < arr.length; ++i) {
        map[arr[i]] = arr[i];
    }
    return map;
}
function mapToArray(map) {
    var arr = [];
    for (var i in map) {
        arr.push(i);
    }
    return arr;
}

/**
 * 将选中行的深层链接隐藏掉
 * TODO： 这个功能不属于multiCheckbox通用的，因此应当放出去，默认情况下，multiCheck.onCheck和onUncheck应当为$.noop
 * @param id
 * @param checkbox
 * @return
 */
MultiCheckbox.prototype.onCheck = function(id, checkbox) {
    if (checkbox.next('input').size() > 0) {
        multiCheck.put(id, checkbox.next('input').val());
        checkbox.parents('tr').find("a.list").each(function() { grey($(this)); });
    }
};

MultiCheckbox.prototype.onUncheck = function(id, checkbox) {
    if (checkbox.next('input').size() > 0) {
        checkbox.parents('tr').find("span.list").each(function() { lightup($(this)); });
    }
};

function grey(a) {
    var parent = a.parent();
    parent.data('back', a);
    parent.html($('<span/>').text(a.text()).addClass('list'));
}

function lightup(a) {
    var parent = a.parent();
    a.remove();
    parent.html(parent.data('back'));
}

function trimSplitName(s, sep) {
    if (s === undefined || s == "") {
        return [];
    }
    var parts = s.split(sep);
    var ret = [];
    for (var i = 0; i < parts.length; ++i) {
        if (parts[i] != "" && parts[i] !="-1") {
            ret.push(parseName(parts[i]));
        }
    }
    return ret;
}
function parseName(idName) {
    var parts = idName.split(',');
    if (parts.length == 2) {
        return parts[1];
    } else {
        return idName;
    }
}

function onMultiCheckSelected(parentCallBack, dialogId) {
    var values= multiCheck.valueArray();
    if ($.isFunction(parentCallBack)) {
        parentCallBack(values.join('##'));
    }
    //if (parent.Dialog) {
       // parent.Dialog.closeDialog(dialogId);
    //}
}
