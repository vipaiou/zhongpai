var selector = (function() {
	var CLASS_CACHE = {};
    var _selector = function(option) {
        this.selectHolder = option.holder;
        this.selectedId = option.selectedId;
        this.name = option.name;
        this.mapKeys = {id:"id", text:"text"};
        this.zIndex = option.zIndex || _selector.zIndex--;
        this.width = option.width || 160;
        this.height = option.height || 20;
        this.maxHeight = option.maxHeight || 200;
        this.searchAble = option.searchAble;
        this.mutiAble = option.mutiAble;
        this.allCheckAble = option.allCheckAble;
        this.defaultMsg = option.defaultMsg || selector.defaultMsg;
        this.noResultMsg = option.noResultMsg || selector.noResultMsg;
        this.checkAll = option.checkAll || selector.checkAll;
        this.cancelAll = option.cancelAll || selector.cancelAll;
        this.searchMsg = option.searchMsg || selector.searchMsg;
        this.canel = option.canel || selector.canel;
        this.confirm = option.confirm || selector.confirm;
        this.initSelectConstructor();
    };
    _selector.zIndex = 100;
    _selector.prototype.setMapKeys = function(map) {
        if(map){
        	for(var o in map){
				this.mapKeys[o] = map[o];
			}
        }
    };
    _selector.prototype.initSelectConstructor = function() {
        var currentNode = $('<div class="current-div"></div>'), textDiv = $('<div class="text-div"></div>'), imgDivWrap = $('<div class="img-div-wrap"></div>'), imgDiv = $('<div class="img-div img-div-close"></div>'), selectNode = $('<div class="select-div"></div>'), hiddenNode, i, len, obj, option, searchNode;
        currentNode.css({
            'width' : this.width + 10 + "px",
            'height' : this.height + "px",
            'line-height' : this.height + "px",
            "z-index" : this.zIndex
        });
        textDiv.css({
            'width' : this.width - 17 + "px",
            'height' : this.height + "px",
            'line-height' : this.height + "px",
            "z-index" : this.zIndex
        });
        if(this.name){
            hideNode = $('<input type="hidden" name="' + this.name + '"/>');
            this.hideNode = hideNode;
            selectNode.append(hideNode);
        }
        currentNode.append(textDiv);
        imgDivWrap.append(imgDiv);
        currentNode.append(imgDivWrap);
        this.selectHolder.append(currentNode);
        this.currentNode = currentNode;
        this.textDiv = textDiv;
        this.imgDivWrap = imgDivWrap;
        this.imgDiv = imgDiv;
        this.selectHolder.addClass('select-div-handle');
        this.selectHolder.css({
            'width' : this.width + "px",
            'height' : this.height + "px",
            'line-height' : this.height + "px",
            "z-index" : this.zIndex
        });
        if (this.searchAble) {
            searchNode = this.searchNode = $('<div class="searchNode">');
            searchNode.css({
                'top' : this.height + "px",
                'width' : this.width + 13 + "px",
                'height' : this.height + "px",
                'line-height' : this.height + "px"
            });
            this.searchText = $('<input type="text" class="searchText"/>').css({
                'width' : this.width - 23 + "px",
                'height' : this.height + "px",
                'line-height' : this.height + "px"
            }).attr('placeholder', this.searchMsg);
            this.searchButton = $('<button class="searchButton" hideFocus>').css({
                'height' : this.height + "px"
            });
            searchNode.append(this.searchText).append(this.searchButton);
            this.selectHolder.append(searchNode);
        }
        selectNode.css({
            "z-index" : this.zIndex,
            'width' : this.width + "px",
            "top" : this.height + "px"
        });
        this.selectNode = selectNode;
        if (this.searchAble) {
            selectNode.css("top", this.height * 2 + "px");
        }
        this.selectHolder.append(selectNode);
        var buttonDiv = $('<div class="button-div">');
        buttonDiv.css({
            'width' : this.width + 10 + "px"
        });
        if (this.mutiAble) {
            var yes = $('<input type="button" class="yes action-button" hideFocus value="' + this.confirm + '" />');
            var no = $('<input type="button" class="no action-button" hideFocus value="' + this.canel + '" />');
            yes.css({
                'height' : this.height - 4 + "px"
            });
            no.css({
                'height' : this.height - 4 + "px",
                'margin-left' : "5px"
            });
            if(this.allCheckAble){
                var checkAll = $('<input type="button" class="check-all action-button" hideFocus value="' + this.checkAll + '" />');
                var cancelAll = $('<input type="button" class="cancel-all action-button" hideFocus value="' + this.cancelAll + '" />');
                checkAll.css({
                    'height' : this.height - 4 + "px"
                });
                cancelAll.css({
                    'height' : this.height - 4 + "px",
                    'margin-left' : "5px"
                });
                buttonDiv.append(checkAll).append(cancelAll);
                yes.css({
                    'margin-left' : "5px"
                });
            }
            buttonDiv.append(yes).append(no);
            this.selectHolder.append(buttonDiv);
            this.buttonDiv = buttonDiv;
        }
        this.addEvent();
    };
    _selector.prototype.setVal = function(val) {
        var that = this;
        if (this.mutiAble) {
            var valMap = {};
            var vals = [].concat(val);
            for ( var i = 0, len = vals.length; i < len; i++) {
                valMap[vals[i]] = true;
            }
            var checkedsVal = checkedsTxt = "";
            this.selectNode.children(".option-div").each(function() {
                var val = $(this).attr("val");
                if (valMap[val]) {
                    checkedsVal += "," + val;
                    checkedsTxt += "," + this.title;
                    this.firstChild.checked = true;
                }else{
                    this.firstChild.checked = false;
                }
            });
            if (checkedsVal.length > 0) {
                checkedsVal = checkedsVal.substr(1);
                checkedsTxt = checkedsTxt.substr(1);
            } else {
                checkedsVal = -1;
                checkedsTxt = that.defaultMsg;
            }
            that.name && that.hideNode.val(checkedsVal);
            that.currentNode.attr("val", checkedsVal);
            that.currentNode.attr("title", checkedsTxt);
            that.textDiv.text(checkedsTxt);
            that.selectedId = checkedsVal;
        } else {
            this.selectNode.children(".option-div").each(function() {
                if ($(this).attr("val") == val) {
                    var txt = $(this.firstChild).text();
                    that.name && that.hideNode.val(val);
                    that.currentNode.attr("val", val);
                    that.currentNode.attr("title", txt);
                    that.textDiv.text(txt);
                    that.selectedId = val;
                    return false;
                }
            });
        }
    };
    _selector.prototype.clearOption = function() {
        this.currentNode.attr("idx", -1);
        this.currentNode.attr("val", -1);
        this.currentNode.attr("title", this.defaultMsg);
        this.textDiv.text(this.defaultMsg);
        this.name && this.hideNode.val(-1);
        this.selectedId = -1;
        this.currentNode.css("height", this.height + "px");
        this.selectNode.find('.option-div').each(function(){
            this.parentNode.removeChild(this);
        });
    };
    _selector.prototype.setDisabled = function(status, node) {
        var node = node || this.currentNode;
        if (status) {
            node.addClass('disabled');
        } else {
            node.removeClass('disabled');
        }
    };
    _selector.prototype.modifyModel = function(model){};
    _selector.prototype.loadData = function(data, selectedId) {
        var i, len, option, id, text;
        this.clearOption();
        if (!data || data.length == 0) return;
        for (i = 0, len = data.length; i < len; i++) {
            obj = data[i];
            this.modifyModel(obj);
            id = obj[this.mapKeys.id];
            text = obj[this.mapKeys.text];
            option = $('<div class="option-div" idx="' + i + '" val="' + id + '" title="' + text + '">');
            var textDiv = $('<div class="text-div">');
            textDiv.text(text);
            if (this.mutiAble) {
                var cbx = $('<input class="checkbox" type="checkbox" />');
                textDiv.css({
                    left:'15px',
                    top:'0px',
                    width:this.width -30 + 'px'
                });
                option.append(cbx).append(textDiv);
            } else {
                option.append(textDiv);
            }
            this.modifyNode(option, obj);
            option.css({
                'height' : this.height + "px",
                'line-height' : this.height + "px",
                'width' : this.width + "px"
            });
            this.selectNode.append(option);
            option.mouseover(function() {
                if ($(this).data('isDeleted')) {
                    $(this).removeClass('option-deleted');
                }
                $(this).addClass('option-mouseover');
            });
            option.mouseout(function() {
                $(this).removeClass('option-mouseover');
                if ($(this).data('isDeleted')) {
                    $(this).addClass('option-deleted');
                }
            });
        }
        this.setVal(selectedId);
        this.name && this.hideNode.val(this.getVal());
        this.afterLoad(this.selectNode);
    };
    _selector.prototype.afterLoad = function(node){
    };
    _selector.prototype.modifyNode = function(node, data) {
    };
    _selector.prototype.getSelected = function() {
        return {
            id : this.getVal(),
            text : this.currentNode.text()
        };
    };
    _selector.prototype.getVal = function() {
        return this.currentNode.attr('val');
    };
    _selector.prototype.change = function(val) {
    };
    _selector.prototype.open = function() {
    };
    _selector.prototype.close = function() {
    };
    _selector.prototype.filterOption = function(val) {
        var hasOption = false, that = this;
        this.selectNode.children('.option-div').each(function() {
            if ($(this).text().toLowerCase().indexOf(val.toLowerCase()) < 0) {
                $(this).hide();
            } else {
                $(this).show();
                hasOption = true;
            }
        });
        this.selectNode.find(".div-msg-tip").remove();
        if (!hasOption) {
            var tipNode = $("<div class='div-msg-tip'><a href='javascript:void(0);'>" + this.noResultMsg + "</a></div>")
                    .css({
                        'width' : this.width + "px",
                        'height' : this.height + "px",
                        'line-height' : this.height + "px",
                        "z-index" : this.zIndex
                    });
            this.selectNode.append(tipNode);
            tipNode.click(function(e) {
                this.parentNode.removeChild(this);
                that.showOptions();
                that.resetSelectHeight();
                e.stopPropagation();
            });
            this.tipNode = tipNode;
        }
        this.resetSelectHeight();
    };
    _selector.prototype.showOptions = function() {
        this.selectNode.children('.option-div').each(function() {
            $(this).show();
        });
    };
    _selector.prototype.resetSelectHeight = function() {
        var selectHeight = this.selectNode.find('.option-div:visible').size() * this.height + this.selectNode.find('.div-msg-tip:visible').size() * this.height;
        if (selectHeight > this.maxHeight) {
            this.selectNode.height(this.maxHeight);
        } else {
            this.selectNode.height(selectHeight);
        }
        if (this.mutiAble) {
            if (this.searchAble) {
                this.buttonDiv.css("top", this.selectNode.height() + this.height * 2 + "px");
            } else {
                this.buttonDiv.css("top", this.selectNode.height() + this.height + "px");
            }
        }
        if (selectHeight < this.height) {
            this.selectNode.css("border", 0);
        } else {
            this.selectNode.css("border", "1px solid #aaa");
        }
    };
    _selector.prototype.addEvent = function() {
        this.selectNode.hide();
        var that = this;
        this.selectHolder.click(function(e) {
            that.clickEvent(e);
        });
        if (this.searchAble) {
            this.searchNode.click(function(e) {
                e.stopPropagation();
            });
            this.searchText.keydown(function(e) {
                if (e.keyCode == 13) {
                    that.filterOption($.trim(this.value));
                    return false;
                }
            });
            this.searchButton.click(function(e) {
                that.filterOption($.trim(that.searchText.val()));
                return false;
            });
        }
        var fun = document.onclick;
        $(document).click(function(e) {
            if (fun) {
                document.onclick = null;
                fun.call(this, e);
            }
            if ($(e.target).hasClass('option-div')) {
                return;
            }
            that.selectNode.hide();
            if (that.searchAble) {
                that.searchNode.hide();
            }
            if (that.mutiAble) {
                that.buttonDiv.hide();
            }
            that.imgDiv.removeClass("img-div-open").addClass("img-div-close");
        });
    };
    _selector.prototype.clickEvent = function(e) {
        if (this.currentNode.hasClass("disabled")) return;
        var target = e.target, that = this, currentNode = that.currentNode[0], selectNode = that.selectNode[0], textDiv = that.textDiv[0], imgDivWrap = that.imgDivWrap[0], imgDiv = that.imgDiv[0], isOpen = that.imgDiv
                .hasClass("img-div-open"), $target, selectedId;
        var cls = target.className;
        if (target == currentNode || target == textDiv || target == imgDiv || target == imgDivWrap) {
            if (isOpen) {
                that.selectNode.hide();
                if (that.searchAble) {
                    that.searchNode.hide();
                }
                if (that.mutiAble) {
                    that.buttonDiv.hide();
                }
                that.imgDiv.removeClass("img-div-open").addClass("img-div-close");
                that.close();
            } else {
                that.selectNode.find(".div-msg-tip").remove();
                that.selectNode.show();
                that.showOptions();
                that.imgDiv.removeClass("img-div-close").addClass("img-div-open");
                if(that.selectNode.find('.option-div:visible').size()){
                    if (that.searchAble) {
                        that.searchNode.show();
                    }
                    if (that.mutiAble) {
                        that.buttonDiv.show();
                    }
                }
                that.open();
            }
            that.resetSelectHeight();
        } else if (target != selectNode) {
            if (this.mutiAble) {
                if (_hasClass(cls, 'option-div')) {
                    if(!_hasClass(cls, 'disabled'))
                        target.firstChild.checked = !target.firstChild.checked;
                } else if (_hasClass(cls, 'action-button')) {
                    if (_hasClass(cls, 'yes')) {
                        var checkedsVal = checkedsTxt = "";
                        that.selectNode.find('.option-div').each(function() {
                            if (this.firstChild.checked) {
                                checkedsTxt += "," + this.title;
                                checkedsVal += "," + $(this).attr('val');
                            }
                        });
                        if (checkedsTxt.length > 0) {
                            checkedsTxt = checkedsTxt.substr(1);
                            checkedsVal = checkedsVal.substr(1);
                        } else {
                            checkedsVal = -1;
                            checkedsTxt = that.defaultMsg;
                        }
                        that.currentNode.attr("val", checkedsVal);
                        that.currentNode.attr("title", checkedsTxt);
                        that.textDiv.text(checkedsTxt);
                        if (that.selectedId != checkedsVal) {
                            that.name && that.hideNode.val(checkedsVal);
                            that.change(checkedsVal);
                            that.selectedId = checkedsVal;
                        }
                    }else if(_hasClass(cls, 'check-all')){
                        var checkedsVal = checkedsTxt = "";
                        that.selectNode.find('.option-div').each(function() {
                        	checkedsTxt += "," + this.title;
                            checkedsVal += "," + $(this).attr('val');
                            this.firstChild.checked = true;
                        });
                        if (checkedsTxt.length > 0) {
                            checkedsTxt = checkedsTxt.substr(1);
                            checkedsVal = checkedsVal.substr(1);
                        } else {
                            checkedsVal = -1;
                            checkedsTxt = that.defaultMsg;
                        }
                        that.currentNode.attr("val", checkedsVal);
                        that.currentNode.attr("title", checkedsTxt);
                        that.textDiv.text(checkedsTxt);
                        if (that.selectedId != checkedsVal) {
                            that.name && that.hideNode.val(checkedsVal);
                            that.change(checkedsVal);
                            that.selectedId = checkedsVal;
                        }
                    }else if(_hasClass(cls, 'cancel-all')){
                        var checkedsVal = checkedsTxt = "";
                        that.selectNode.find('.option-div').each(function() {
                            this.firstChild.checked = false;
                        });
                        checkedsVal = -1;
                        checkedsTxt = that.defaultMsg;
                        that.currentNode.attr("val", checkedsVal);
                        that.currentNode.attr("title", checkedsTxt);
                        that.textDiv.text(checkedsTxt);
                        if (that.selectedId != checkedsVal) {
                            that.name && that.hideNode.val(checkedsVal);
                            that.change(checkedsVal);
                            that.selectedId = checkedsVal;
                        }
                    }
                    that.selectNode.hide();
                    if (that.searchAble) {
                        that.searchNode.hide();
                    }
                    if (that.mutiAble) {
                        that.buttonDiv.hide();
                    }
                    that.imgDiv.removeClass("img-div-open").addClass("img-div-close");
                    that.close();
                }else if(_hasClass(cls, 'text-div')){
                    if(!_hasClass(target.parentNode.className, 'disabled'))
                        target.previousSibling.checked = !target.previousSibling.checked;
                }else{
                }
            } else {
                if (_hasClass(cls, 'option-div')) {
                    $target = $(target);
                }else{
                    $target = $(target.parentNode);
                }
                if($target.hasClass('disabled')) return ;
                var text = $target.find(":first-child").text();
                selectedId = $target.attr("val");
                that.currentNode.attr("idx", $target.attr("idx"));
                that.currentNode.attr("val", selectedId);
                that.currentNode.attr("title", text);
                that.textDiv.text(text);
                that.selectNode.hide();
                if (that.searchAble) {
                    that.searchNode.hide();
                }
                that.imgDiv.removeClass("img-div-open").addClass("img-div-close");
                if (that.selectedId != selectedId) {
                    that.name && that.hideNode.val(selectedId);
                    that.change(selectedId);
                    that.selectedId = selectedId;
                }
                that.close();
            }
        }
        e.stopPropagation();
    };
    var __selector = function(option) {
        var _this = new _selector(option);
        this.getVal = function() {
            return _this.getVal();
        };
        this.getSelected = function() {
            return _this.getSelected();
        };
        this.change = function(fun) {
            _this.change = fun;
        };
        this.open = function(fun) {
            _this.open = fun;
        };
        this.close = function(fun) {
            _this.close = fun;
        };
        this.loadData = function(data, selectedId) {
            _this.loadData(data, selectedId);
        };
        this.setVal = function(val) {
            _this.setVal(val);
        };
        this.clearOption = function() {
            _this.clearOption();
        };
        this.setDisabled = function(status, node) {
            _this.setDisabled(status, node);
        };
        this.modifyNode = function(fun) {
            _this.modifyNode = fun;
        };
        this.modifyModel = function(fun) {
                _this.modifyModel = fun;
        };
        this.afterLoad = function(fun) {
            _this.afterLoad = fun;
        };
        this.setMapKeys = function(map) {
            _this.setMapKeys(map);
        };
    };
    function _hasClass(txt, cls){
		var _className = '(?:^|\\s)' + cls + '(?:\\s|$)';
        var re = CLASS_CACHE[_className] || (CLASS_CACHE[_className] = new RegExp(_className));
        return re.test(txt);
    }
    return __selector;
})();