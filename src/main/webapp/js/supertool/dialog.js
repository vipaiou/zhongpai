S.dialog = null;

$(function() {
    S.dialog = $('<div id="dialogHolder" style="display:none"></div>').appendTo('body');
});
S.showDialog = function(url, title, width, height, callback) {
    if (url === undefined) {
        $('div.ui-dialog', parent.document).show();
    } else {
        // load remote content
        S.dialog.load(url, function() {
            var params = {
                width : 800,
                height : 500
            };
            if (title !== undefined) {
                params.title = title;
            }
            if (width !== undefined) {
                params.width = width;
            }
            if (height !== undefined) {
                params.height = height;
            }
            params.modal = true;
            S.dialog.dialog(params);
            S.dialog.parents('div.ui-dialog').show();
            S.dialog.find('input.btDefault,input.btOk').unbind().click(function() {
                S.dialog.parents('div.ui-dialog').hide();
            });
            if ($.isFunction(callback)) {
                callback.call(this);
            }
        });
    }
};

S.closeDialog = function() {
    $('#dialogHolder', parent.document).dialog('close');
};

S.hideDialog = function() {
    $('div.ui-dialog', parent.document).hide();
};

S.hasDialog = function() {
    var dialogDiv = $('div.ui-dialog', parent.document);
    if (!dialogDiv) return false;
    else {
        return dialogDiv[0] ? dialogDiv[0].children.length > 0 : false;
    }
};

