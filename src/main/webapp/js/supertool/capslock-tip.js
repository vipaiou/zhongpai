/**
 * 提示大写锁定Tooltip
 */
var capslockTip = function(checkEles, msg, position) {
    this.checkEles = checkEles;
    this.msg = msg || '';
    this.position = position || {x: "345px", y: "90px"};
};
capslockTip.prototype.tip = function() {
    var oldPasswordCapsLock;
    var that = this;
    var tipEle = $('<div id="tip" class="sexy-tooltip" style="position: absolute; top: '+that.position.y+'; left: '+that.position.x+'; z-index: 70000; display: block; width: 200px; display:none"></div>');
    tipEle.html('<div class="alert"><div class="tooltip-tl" style="width: 200px;"><div class="tooltip-tr"><div class="tooltip-t"></div></div></div><div class="tooltip-l" style="width: 200px;"><div class="tooltip-r"><div class="tooltip-m">'+that.msg+'</div></div></div><div class="tooltip-bl" style="width: 200px;"><div class="tooltip-br"><div class="tooltip-b"><div class="tooltip-l-arrow"></div></div></div></div></div>');
    $("body").append(tipEle);
    $(document).keypress(function(event) {
        var evt = event || window.event;
        var obj = evt.target || evt.srcElement;
        var keyCode = evt.keyCode || evt.which; // 获取按键的keyCode
        if (keyCode == 27) {
            tipEle.hide();
            oldPasswordCapsLock = false;
            evt.returnValue = false;
            return false;
        } else if (keyCode == 20) {
            if (typeof oldPasswordCapsLock == 'undefined')
                return;
            oldPasswordCapsLock = !oldPasswordCapsLock;
            if (!oldPasswordCapsLock)
                tipEle.hide();
        } else {
            var isShift = evt.shiftKey ? evt.shiftKey : (evt.modifiers ? !!(evt.modifiers & 4) : false); // shift键是否按住
            var id = obj.id; // get target control's id, for jquery selector.
            var isCheckedEle = false;
            that.checkEles.each(function(){
                if(this.id == id){
                    isCheckedEle = true;
                    return false;
                }
            });
            if (!isCheckedEle) {
                return;
            }
            // 判断shift键是否按住
            if (((keyCode >= 65 && keyCode <= 90) && !isShift)/* Caps Lock 打开，且没有按住shift键 */
                    || ((keyCode >= 97 && keyCode <= 122) && isShift)/* Caps Lock 打开，且按住shift键 */) {

                tipEle.show();
                oldPasswordCapsLock = true;
            } else {
                tipEle.hide();
                oldPasswordCapsLock = false;
            }
        }
    });
    that.checkEles.mouseover(function() {
        if (oldPasswordCapsLock == true) {
            tipEle.show();
        } else {
            tipEle.hide();
        }
    });
};