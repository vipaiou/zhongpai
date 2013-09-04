var tree = (function() {
	var CHECKED = 'checked';
	var UNCHECKED = 'unchecked';
	var HALF = 'halfchecked';
	var LOADING = 'loading';
	var SWITCH = 'switch';
	var CHECKBOX = 'checkbox';
	var NO_OFFSET = 'no-offset';
	var HIDE = 'hide';
	var TREE = 'tree';
	var STATUS = [ CHECKED, UNCHECKED, HALF ];
	var CLASS_CACHE = {};
	var TREE_CACHE = {};
	var tree = function(option) {
		this.holderNode = option.holderNode;
		this.checkAble = (option.checkAble === false) ? false : true;
		this.isUnfolded = option.isUnfolded;
		this.visible = (option.visible === false) ? false : true;
		this.mapKeys = {
			id : 'id',
			text : 'text',
			isLeaf : 'isLeaf',
			nodes : 'nodes'
		};
		this.ajax = option.ajax;
		this.pre = (this.holderNode.id || 't' + 1000 * Math.random()) + '_';
		this.initRoot();
	};
	tree.prototype.initRoot = function() {
		var root = document.createElement('ul');
		this.rootNode = root;
		_addClass(root, TREE);
		this.holderNode.appendChild(root);
		TREE_CACHE[this.pre] = this;
		root.setAttribute('treeKey', this.pre);
		this.isView = !this.checkAble && !this.visible;
	};
	tree.prototype.setMapKeys = function(map) {
		if (map) {
			for ( var o in map) {
				this.mapKeys[o] = map[o];
			}
		}
	};
	tree.prototype.tree = function(data, node, status) {
		if (data) {
			if (node) {
				this.renderTree(data, node, false, status);
			} else {
				this.renderTree(data, this.rootNode, true, status);
			}
		}
	};
	tree.prototype.ajaxTree = function(node, status) {
		var that = this, preClass = '', ulNode;
		var param = this.ajax.param || {};
		if (node) {
			preClass = node.className;
			_removeClass(node, preClass);
			param[this.mapKeys.id] = node.previousSibling.id.replace(this.pre, '');
			ulNode = node.nextSibling.nextSibling;
		} else {
			node = this.rootNode;
			param[this.mapKeys.id] = -1;
		}
		_addClass(node, SWITCH);
		_addClass(node, LOADING);
		$.ajax({
			url : this.ajax.url,
			type : 'POST',
			data : param,
			dataType : 'json',
			cache : false,
			success : function(data) {
				node.setAttribute('hasData', true);
				that.tree(data, ulNode, status);
				_removeClass(node, LOADING);
				_removeClass(node, SWITCH);
				_addClass(node, preClass);
				if (that.ajax.success) {
					that.ajax.success.apply(that, arguments);
				}
			}
		});
	};
	tree.prototype.cancelAll = function() {
		this.updateAll(false);
	};
	tree.prototype.checkAll = function() {
		this.updateAll(true);
	};
	tree.prototype.updateAll = function(status) {
		var isView = this.isView;
		this.traverse(function(e) {
			_updateCheckboxStatus(e, status, isView);
		});
	};
	tree.prototype.traverse = function(fun, node) {
		if (node) {
			var nodeName = node.nodeName;
			if (nodeName == 'BUTTON' && _hasClass(node, CHECKBOX)) {
				if (fun.call(this, node))
					return;
				node = node.parentNode.lastChild;
			}
		}
		if (!node){
		    node = this.rootNode;
		}
		this.traverseChilds(fun, node, 0);
		this.traverseParents(fun, node);
	};
	/**
	 * 包括递归子级节点
	 */
	tree.prototype.traverseChilds = function(fun, node, level) {
		if (node.nodeName != 'UL')
			return;
		var li = node.firstChild;
		var level = level || 0;
		++level;
		while (li) {
			var cbx = li.firstChild;
			if (!fun.call(this, cbx, level)) {
				var lastNode = li.lastChild;
				if (lastNode.nodeName == 'UL') {
					this.traverseChilds(fun, lastNode, level);
				}
			}
			li = li.nextSibling;
		}
	};
	/**
	 * 包括递归父级节点
	 */
	tree.prototype.traverseParents = function(fun, node) {
		if (!_isRoot(node)) {
			var parentUl = node.parentNode.parentNode;
			if (!_isRoot(parentUl)) {
				var parentLi = parentUl.parentNode;
				var cbx = parentLi.firstChild;
				if (!fun.call(this, cbx)) {
					if (parentUl.nodeName != 'UL')
						return;
					this.traverseParents(fun, parentUl);
				}
			}
		}
	};
	tree.prototype.onToggleNode = function(ele) {
	};
	tree.prototype.onCheckboxClick = function(ele) {
	};
	tree.prototype.onTextClick = function(ele) {
	};
	tree.prototype.modifyNode = function(node, nodeData) {
	};
	tree.prototype.getVal = function() {
		var result = [];
		this.traverse(function(e) {
			if (this.isChecked(e)) {
				result.push(e.id.replace(this.pre, ''));
				return true;
			}
		});
		return result;
	};
	tree.prototype.setVal = function(ids) {
		this.cancelAll();
		var isView = this.isView;
		if ('' === ids || undefined === ids || null === ids || ids.length == 0) {
			ids = [];
		}
		var ids = [].concat(ids);
		for ( var i = 0, len = ids.length; i < len; i++) {
			var cbx = document.getElementById(this.pre + ids[i]);
			if(cbx){
			    _updateCheckboxStatus(cbx, true, isView);
	            this.traverseChilds(function(e) {
	                _updateCheckboxStatus(e, true, isView);
	            }, cbx.parentNode.lastChild);
			}
		}
		for ( var i = 0, len = ids.length; i < len; i++) {
			var cbx = document.getElementById(this.pre + ids[i]);
			if(cbx){
			    this.traverseParents(function(e) {
	                return _updateParentStatus(e, true, isView);
	            }, cbx.parentNode.lastChild);
			}
		}
	};
	tree.prototype.isChecked = function(ele) {
		return _hasClass(ele, CHECKED);
	};
	tree.prototype.isUnChecked = function(ele) {
		return _hasClass(ele, UNCHECKED);
	};
	tree.prototype.isHalf = function(ele) {
		return _hasClass(ele, HALF);
	};
	tree.prototype.hasChild = function(ele) {
	    return _hasChild(ele);
	};
	tree.prototype.hide = function(ele) {
		_addClass(ele, HIDE);
	};
	tree.prototype.show = function(ele) {
		_removeClass(ele, HIDE);
	};
	tree.prototype.open = function(ele) {
		ele.className = ele.className.replace('close', 'open');
	};
	tree.prototype.close = function(ele) {
		ele.className = ele.className.replace('open', 'close');
	};
	tree.prototype.reverseStatus = function(ele) {
		if (this.isChecked(ele)) {
			_removeClass(ele, CHECKED);
			_addClass(ele, UNCHECKED);
		} else if (this.isUnChecked(ele)) {
			_removeClass(ele, UNCHECKED);
			_addClass(ele, CHECKED);
		}
	};
	tree.prototype.updateBranch = function(cbx, status) {
		var isView = this.isView;
		var ul = cbx.parentNode.lastChild;
		_updateCheckboxStatus(cbx, status, isView);
		this.traverseChilds(function(e) {
			_updateCheckboxStatus(e, status, isView);
		}, ul);
		this.traverseParents(function(e) {
			return _updateParentStatus(e, status, isView);
		}, ul);
	};
	tree.prototype.search = function(txt){
	    this.traverse(function(e, level){
	        var textNode = e.nextSibling.nextSibling;
	        if(txt.length == 0){
	            textNode.innerHTML = textNode.title;
	            this.show(e.parentNode);
	        }else{
	            if(level == 1){
	                if(textNode.title.indexOf(txt) > -1){
	                    textNode.innerHTML = textNode.title.replace(txt, '<span style="color:#f00">' + txt + '</span>');
	                    this.show(e.parentNode);
	                }else{
	                    textNode.innerHTML = textNode.title;
	                    this.hide(e.parentNode);
	                }
	            }else{
	                if(textNode.title.indexOf(txt) > -1){
	                    var l = level;
	                    while(l > 1){
	                        e = e.parentNode.parentNode.parentNode.firstChild;
	                        l--;
	                    }
	                    textNode.innerHTML = textNode.title.replace(txt, '<span style="color:#f00">' + txt + '</span>');
	                    this.show(e.parentNode);
	                }else{
	                    textNode.innerHTML = textNode.title;
	                }
	            }
	        }
        });
	};
	tree.prototype.modifyModel = function(modelData) {
	};
	tree.prototype.renderTree = function(data, parentNode, isRoot, status) {
		var id, text, isLeaf, childs, swtCls = SWITCH, aCls = '';
		if (data) {
			for ( var i = 0, len = data.length; i < len; i++) {
				var nodeData = data[i];
				this.modifyModel(nodeData);
				id = nodeData[this.mapKeys.id];
				text = nodeData[this.mapKeys.text];
				isLeaf = nodeData[this.mapKeys.isLeaf];
				childs = nodeData[this.mapKeys.nodes];
				var node = document.createElement('li');
				node.onclick = _fireClick;
				var cbx = document.createElement('button');
				cbx.setAttribute('type', 'button');
				cbx.id = this.pre + id;
				cbx.onfocus = _ignoreFocus;
				_addClass(cbx, CHECKBOX);
				if (status) {
					_addClass(cbx, CHECKED);
				} else {
					_addClass(cbx, UNCHECKED);
				}
				node.appendChild(cbx);
				if (!this.checkAble) {
					_addClass(cbx, HIDE);
					aCls = swtCls = NO_OFFSET;
					if (!this.visible) {
						_addClass(node, HIDE);
					}
				}
				var switchBtn = document.createElement('button');
				switchBtn.setAttribute('type', 'button');
				_addClass(switchBtn, swtCls);
				switchBtn.onfocus = _ignoreFocus;
				if (isRoot && i == 0) {
					if (isLeaf) {
						var position = '';
						if (len == 1) {
							position = 'root';
						} else {
							position = 'top';
						}
						_addClass(switchBtn, position + '-line');
					} else {
						_addClass(switchBtn, 'root-close');
					}
				} else {
					var position = '';
					var type = '';
					if (isLeaf) {
						type = 'line';
					} else {
						type = 'close';
					}
					if (i == len - 1) {
						position = 'bottom';
					} else {
						position = 'center';
					}
					_addClass(switchBtn, position + '-' + type);
				}
				if (this.isView) {
					if (this.isUnfolded) {
						switchBtn.className = SWITCH + ' open';
					} else {
						switchBtn.className = SWITCH + ' close';
					}
				} else {
					if (this.isUnfolded) {
						switchBtn.className = switchBtn.className.replace(
								'close', 'open');
					}
				}
				node.appendChild(switchBtn);
				var textNode = document.createElement('a');
				_addClass(textNode, aCls);
				textNode.innerHTML = textNode.title = text;
				textNode.href = 'javascript:void(0)';
				node.appendChild(textNode);
				parentNode.appendChild(node);
				this.modifyNode(node, nodeData);
				if (!isLeaf) {
					var nextLevel = document.createElement('ul');
					if (!this.isUnfolded) {
						_addClass(nextLevel, HIDE);
					}
					if (len !== i + 1) {
						!this.isView && _addClass(nextLevel, 'line');
					}
					node.appendChild(nextLevel);
					this.renderTree(childs || [], nextLevel, false, status);
				}
			}
		}
	};
	function _getTreeObj(node, nodeName) {
		var ul = null;
		if (nodeName == 'LI') {
			ul = node.parentNode;
		} else {
			ul = node.parentNode.parentNode;
		}
		while (ul) {
			if (ul.nodeName == 'UL' && _isRoot(ul)) {
				return TREE_CACHE[ul.getAttribute('treeKey')];
			}
			ul = ul.parentNode.parentNode;
		}
		return null;
	};
	function _isRoot(node) {
		return node && node.nodeName == 'UL' && _hasClass(node, TREE);
	};
	function _hasChild(cbx) {
	    var cld = cbx.parentNode.lastChild;
	    return cld.nodeName == 'UL' && cld.childNodes.length > 0;
	};
	function _fireClick(evt) {
		var node = _getEleByEvent(evt);
		var nodeName = node.nodeName;
		var treeObj = _getTreeObj(node, nodeName);
		if (nodeName == 'BUTTON') {
			if (_hasClass(node, CHECKBOX)) {
				_checkboxClk(node, treeObj);
				treeObj.onCheckboxClick(node);
			} else {
				_switchClk(node, treeObj);
				treeObj.onToggleNode(node);
			}
		} else if (nodeName == 'A') {
			_textClk(node, treeObj);
			treeObj.onTextClick(node);
		}
		return false;
	};
	function _getEleByEvent(e) {
		var node = null;
		if (e) {
			node = e.target;
			e.stopPropagation();
		} else {
			e = window.event;
			e.cancelBubble = true;
			node = e.srcElement;
		}
		return node;
	};
	function _hasClass(node, cls) {
		var _className = '(?:^|\\s)' + cls + '(?:\\s|$)';
		var re = CLASS_CACHE[_className]
				|| (CLASS_CACHE[_className] = new RegExp(_className));
		return re.test(node.className);
	};
	function _addClass(node, cls) {
		!_hasClass(node, cls)
				&& (node.className = node.className
						+ (node.className ? ' ' : '') + cls);
	};
	function _removeClass(node, cls) {
		var _className = '(?:^|\\s)' + cls + '(?:\\s|$)';
		var re = CLASS_CACHE[_className]
				|| (CLASS_CACHE[_className] = new RegExp(_className));
		_hasClass(node, cls)
				&& (node.className = node.className.replace(re, ' '));
	};
	function _updateCheckboxStatus(node, status, isView) {
		_removeClass(node, HALF);
		_removeClass(node, STATUS[status % 2]);
		if (isView) {
			if (status) {
				_removeClass(node.parentNode, HIDE);
			} else {
				_addClass(node.parentNode, HIDE);
			}
		}
		_addClass(node, STATUS[1 - status % 2]);
	};
	function _updateParentStatus(node, status, isView) {
		var preStatus = _getStatus(node);
		var ul = node.parentNode.lastChild;
		if (_isRoot(node))
			return true;
		var len = ul.childNodes.length;
		if (!status) {
			if (_hasClass(node, CHECKED)) {
				if (len == 1) {
					_addClass(node, UNCHECKED);
					_removeClass(node, CHECKED);
					_removeClass(node, HALF);
					isView && _addClass(node.parentNode, HIDE);
				} else {
					_addClass(node, HALF);
					_removeClass(node, CHECKED);
					_removeClass(node, UNCHECKED);
					isView && _removeClass(node.parentNode, HIDE);
				}
			} else if (_hasClass(node, HALF)) {
				_removeClass(node, CHECKED);
				_removeClass(node, UNCHECKED);
				_removeClass(node, HALF);
				var cls = _getCheckboxStatusByUl(ul);
				_addClass(node, cls);
				if (isView) {
					if (cls == UNCHECKED) {
						_addClass(node.parentNode, HIDE);
					} else {
						_removeClass(node.parentNode, HIDE);
					}
				}
				if (preStatus == cls) {
					return true;
				}
			} else if (!isView) {
				return true;
			}
		} else {
			if (_hasClass(node, UNCHECKED)) {
				if (len == 1) {
					_addClass(node, CHECKED);
					_removeClass(node, HALF);
				} else {
					_addClass(node, HALF);
					_removeClass(node, CHECKED);
				}
				_removeClass(node, UNCHECKED);
				isView && _removeClass(node.parentNode, HIDE);
			} else if (_hasClass(node, HALF)) {
				_removeClass(node, CHECKED);
				_removeClass(node, UNCHECKED);
				_removeClass(node, HALF);
				var cls = _getCheckboxStatusByUl(ul);
				_addClass(node, cls);
				isView && _removeClass(node.parentNode, HIDE);
				if (preStatus == cls) {
					return true;
				}
			} else if (!isView) {
				return true;
			}
		}
	};
	function _checkboxClk(node, tree) {
		var status = !_hasClass(node, CHECKED);
		tree.updateBranch(node, status);
	};
	function _switchClk(node, tree) {
		var cls = node.className;
		var ulNode = node.nextSibling.nextSibling;
		if (cls.indexOf('close') > -1) {
			node.className = cls.replace('close', 'open');
			if (ulNode) {
				_removeClass(ulNode, HIDE);
				if (tree.ajax) {
					if (!node.getAttribute('hasData')) {
						tree.ajaxTree(node, _hasClass(node.previousSibling,
								CHECKED));
					}
				}
			}
		} else {
			node.className = cls.replace('open', 'close');
			if (ulNode) {
				_addClass(ulNode, HIDE);
			}
		}
	};
	function _textClk(node, tree) {
	};
	function _ignoreFocus() {
		this.blur();
	};
	function _getStatus(node) {
		var cls = node.className;
		if (cls.indexOf(UNCHECKED) > -1)
			return UNCHECKED;
		if (cls.indexOf(HALF) > -1)
			return HALF;
		if (cls.indexOf(CHECKED) > -1)
			return CHECKED;
	};
	function _getCheckboxStatusByUl(ul) {
		if (ul) {
			var count = 0;
			var lis = ul.childNodes;
			var len = lis.length;
			for ( var i = 0; i < len; i++) {
				var cbx = lis[i].firstChild;
				if (_hasClass(cbx, HALF)) {
					return HALF;
				}
				if (_hasClass(cbx, CHECKED)) {
					count++;
				}
			}
			if (count == 0) {
				return UNCHECKED;
			} else if (count == len) {
				return CHECKED;
			}
			return HALF;
		}
	};
	var __tree = function(option) {
		var _this = new tree(option);
		this.tree = function(data) {
			_this.tree(data);
			return this;
		};
		this.onCheckboxClick = function(fun) {
			_this.onCheckboxClick = fun;
			return this;
		};
		this.onToggleNode = function(fun) {
			_this.onToggleNode = fun;
			return this;
		};
		this.onTextClick = function(fun) {
			_this.onTextClick = fun;
			return this;
		};
		this.setMapKeys = function(map) {
			_this.setMapKeys(map);
			return this;
		};
		this.modifyModel = function(fun) {
			_this.modifyModel = fun;
			return this;
		};
		this.modifyNode = function(fun) {
			_this.modifyNode = fun;
			return this;
		};
		this.getVal = function() {
			return _this.getVal();
		};
		this.setVal = function(ids) {
			_this.setVal(ids);
			return this;
		};
		this.ajaxTree = function(node) {
			_this.ajaxTree(node);
			return this;
		};
		this.cancelAll = function() {
			_this.cancelAll();
			return this;
		};
		this.checkAll = function() {
			_this.checkAll();
			return this;
		};
		this.updateBranch = function(node, status) {
			_this.updateBranch(node, status);
			return this;
		};
		this.isChecked = function(ele) {
			return _this.isChecked(ele);
		};
		this.isUnChecked = function(ele) {
			return _this.isUnChecked(ele);
		};
		this.isHalf = function(ele) {
			return _this.isHalf(ele);
		};
		this.traverse = function(fun, ele) {
			_this.traverse(fun, ele);
			return this;
		};
		this.hide = function(ele) {
			_this.hide(ele);
			return this;
		};
		this.isRoot = function(ele) {
			return _isRoot(ele);
		};
		this.hasChild = function(ele) {
		    return _this.hasChild(ele);
		};
		this.open = function(ele) {
			_this.open(ele);
			return this;
		};
		this.close = function(ele) {
			_this.close(ele);
			return this;
		};
		this.reverseStatus = function(ele) {
			_this.reverseStatus(ele);
			return this;
		};
		this.search = function(txt) {
            _this.search(txt);
            return this;
        };
		this.pre = _this.pre;
	};
	return __tree;
})();