// jQuery Alert Dialogs Plugin
//
// Version 1.1
//
// Cory S.N. LaViska
// A Beautiful Site (http://abeautifulsite.net/)
// 14 May 2009
//
// Visit http://abeautifulsite.net/notebook/87 for more information
//
// Usage:
//      jAlert( message, [title, callback] )
//      jConfirm( message, [title, callback] )
//      jPrompt( message, [value, title, callback] )
//      jValidatePrompt( message, [value, title, callback] )             //对输入值进行验证，如果为空，则确定按钮不可点
// 
// History:
//
//      1.00 - Released (29 December 2008)
//
//      1.01 - Fixed bug where unbinding would destroy all resize events
//
// License:
// 
// This plugin is dual-licensed under the GNU General Public License and the MIT License and
// is copyright 2008 A Beautiful Site, LLC. 
//
(function($) {
    if (typeof i18n == 'undefined') {
        i18n = {};
        i18n.ui_ok = '确定';
        i18n.ui_cancel = '取消';
    }

    $.alerts = {
        
        // These properties can be read/written by accessing $.alerts.propertyName from your scripts at any time
        
        verticalOffset: -75,                // vertical offset of the dialog from center screen, in pixels
        horizontalOffset: 0,                // horizontal offset of the dialog from center screen, in pixels/
        repositionOnResize: true,           // re-centers the dialog on window resize
        overlayOpacity: .01,                // transparency level of overlay
        overlayColor: '#FFF',               // base color of overlay
        draggable: true,                    // make the dialogs draggable (requires UI Draggables plugin)
        okButton: i18n.ui_ok,         // text for the OK button
        cancelButton: i18n.ui_cancel, // text for the Cancel button
        dialogClass: null,                  // if specified, this class will be applied to all dialogs
        
        // Public methods
        
        alert: function(message, title, callback) {
            if( title == null ) title = 'Alert';
            $.alerts._show(title, message, null, 'alert', function(result) {
                if( callback ) callback(result);
            });
        },
        
        confirm: function(message, title, callback) {
            if( title == null ) title = 'Confirm';
            $.alerts._show(title, message, null, 'confirm', function(result) {
                if( callback ) callback(result);
            });
        },
            
        prompt: function(message, value, title, callback) {
            if( title == null ) title = 'Prompt';
            $.alerts._show(title, message, value, 'prompt', function(result) {
                if( callback ) callback(result);
            });
        },
        
        validatePrompt: function(message, value, title, callback) {
            if(title == null) title = 'Prompt';
            $.alerts._show(title, message, value, 'validatePrompt', function(result){
                if(callback) callback(result);
            });
        },
        
        // Private methods
        
        _show: function(title, msg, value, type, callback) {
            
            $.alerts._hide();
            $.alerts._overlay('show');
            
            $("BODY").append(
              '<div id="popup_container">' +
                '<div id="popup_title" style="height: 24px;width:0px"></div>' +
                '<div id="popup_content">' +
                  '<div id="popup_message" style="margin-left:27px;"></div>' +
                '</div>' +
              '</div>');
            
            if( $.alerts.dialogClass ) $("#popup_container").addClass($.alerts.dialogClass);
            
            // IE6 Fix
            var pos = ($.browser.msie && parseInt($.browser.version) <= 9 ) ? 'absolute' : 'fixed'; 
            
            $("#popup_container").css({
                position: pos,
                zIndex: 99999,
                padding: 0,
                margin: 0
            });
            
            $("#popup_title").text(title);
            $("#popup_content").addClass(type);
            if($.isFunction(Escape.html)){
                msg = Escape.html(msg);
            }
            $("#popup_message").text(msg);
            $("#popup_message").html( $("#popup_message").text().replace(/\n|&#10;/g, '<br />') );
            
            $("#popup_container").css({
                minWidth: $("#popup_container").outerWidth(),
                maxWidth: $("#popup_container").outerWidth()
            });
            if($("#popup_container").width() > 600){
                $("#popup_container").css("width", "600px");
            }
            setTimeout(function(){
                $("#popup_title").width($("#popup_container").width()-2);
            }, 0);
            $.alerts._reposition();
            $.alerts._maintainPosition(true);
            switch( type ) {
                case 'alert':
                    $("#popup_message").after('<div id="popup_panel"><input class="bt" type="button" value="' + $.alerts.okButton + '" id="popup_ok" /></div>');
                    $("#popup_ok").click( function() {
                        $.alerts._hide();
                        callback(true);
                    });
                    $("#popup_ok").focus().keypress( function(e) {
                        if( e.keyCode == 13 || e.keyCode == 27 ) $("#popup_ok").trigger('click');
                    });
                break;
                case 'confirm':
                    $("#popup_message").after('<div id="popup_panel"><input class="bt" type="button" value="' + $.alerts.okButton + '" id="popup_ok" /> <input class="bt" type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /></div>');
                    $("#popup_ok").click( function() {
                        $.alerts._hide();
                        if( callback ) callback(true);
                    });
                    $("#popup_cancel").click( function() {
                        $.alerts._hide();
                        if( callback ) callback(false);
                    });
                    $("#popup_ok").focus();
                    $("#popup_ok, #popup_cancel").keypress( function(e) {
                        if( e.keyCode == 13 ) $("#popup_ok").trigger('click');
                        if( e.keyCode == 27 ) $("#popup_cancel").trigger('click');
                    });
                break;
                case 'prompt':
                    $("#popup_message").append('<br /><input type="text" size="30" id="popup_prompt" />').after('<div id="popup_panel"><input class="bt" type="button" value="' + $.alerts.okButton + '" id="popup_ok" /> <input class="bt" type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /></div>');
                    $("#popup_prompt").width( $("#popup_message").width() );
                    $("#popup_ok").click( function() {
                        var val = $("#popup_prompt").val();
                        $.alerts._hide();
                        if( callback ) callback( val );
                    });
                    $("#popup_cancel").click( function() {
                        $.alerts._hide();
                        if( callback ) callback( null );
                    });
                    $("#popup_prompt, #popup_ok, #popup_cancel").keypress( function(e) {
                        if( e.keyCode == 13 ) $("#popup_ok").trigger('click');
                        if( e.keyCode == 27 ) $("#popup_cancel").trigger('click');
                    });
                    if( value ) $("#popup_prompt").val(value);
                    $("#popup_prompt").focus().select();
                break;
                case 'validatePrompt':
                    $("#popup_message").append('<span class="red">*</span>：<br /><input type="text" size="30" id="popup_prompt" />').after('<div id="popup_panel"><input class="bt" type="button" disabled="disabled" value="' + $.alerts.okButton + '" id="popup_ok" /> <input class="bt" type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /></div>');
                    $("#popup_prompt").width( $("#popup_message").width() );
                    $('#popup_prompt').keydown(function(){
                        var val = $("#popup_prompt").val();
                        if(val != null && $.trim(val) != ''){
                            $('#popup_ok').removeAttr('disabled');
                        }
                    });
                    $('#popup_prompt').focus(function(){
                        $('#popup_ok').removeAttr('disabled');
                    });
                    $('#popup_prompt').blur(function(){
                        var val = $("#popup_prompt").val();
                        if(val != null && $.trim(val) != ''){
                            $('#popup_ok').removeAttr('disabled');
                        }else{
                            $('#popup_ok').attr('disabled', 'disabled');
                        }
                    });
                    $("#popup_ok").click( function() {
                        var val = $("#popup_prompt").val();
                        $.alerts._hide();
                        if( callback ) callback( val );
                    });
                    $("#popup_cancel").click( function() {
                        $.alerts._hide();
                        if( callback ) callback( null );
                    });
                    $("#popup_prompt, #popup_ok, #popup_cancel").keypress( function(e) {
                        if( e.keyCode == 13 ) $("#popup_ok").trigger('click');
                        if( e.keyCode == 27 ) $("#popup_cancel").trigger('click');
                    });
                    if( value ) $("#popup_prompt").val(value);
                    $("#popup_prompt").focus().select();
            }
            
            // Make draggable
            if( $.alerts.draggable ) {
                try {
                    $("#popup_container").draggable({ handle: $("#popup_title") });
                    $("#popup_title").css({ cursor: 'move' });
                } catch(e) { /* requires jQuery UI draggables */ }
            }
        },
        
        _hide: function() {
            $("#popup_container").remove();
            $.alerts._overlay('hide');
            $.alerts._maintainPosition(false);
        },
        
        _overlay: function(status) {
            switch( status ) {
                case 'show':
                    $.alerts._overlay('hide');
                    $("BODY").append('<div id="popup_overlay"></div>');
                    $("#popup_overlay").css({
                        position: 'absolute',
                        zIndex: 99998,
                        top: '0px',
                        left: '0px',
                        width: '100%',
                        height: $(document).height(),
                        background: $.alerts.overlayColor,
                        opacity: $.alerts.overlayOpacity
                    });
                break;
                case 'hide':
                    $("#popup_overlay").remove();
                break;
            }
        },
        
        _reposition: function() {
            var top = (($(window).height() / 2) - ($("#popup_container").outerHeight() / 2)) + $.alerts.verticalOffset;
            var left = (($(window).width() / 2) - ($("#popup_container").outerWidth() / 2)) + $.alerts.horizontalOffset;
            if( top < 0 ) top = 0;
            if( left < 0 ) left = 0;
            
            // IE fix
            if($.browser.msie) top = top + $(window).scrollTop();
            
            $("#popup_container").css({
                top: top + 'px',
                left: left + 'px'
            });
            $("#popup_overlay").height( $.browser.msie ? ($(document).height() - 4) : $(document).height());
        },
        
        _maintainPosition: function(status) {
            if( $.alerts.repositionOnResize ) {
                switch(status) {
                    case true:
                        $(window).bind('resize', $.alerts._reposition);
                    break;
                    case false:
                        $(window).unbind('resize', $.alerts._reposition);
                    break;
                }
            }
        }
        
    },
    
    // Shortuct functions
    jAlert = function(message, title, callback) {
        $.alerts.alert(message, title, callback);
    };
    
    jConfirm = function(message, title, callback) {
        $.alerts.confirm(message, title, callback);
    };
        
    jPrompt = function(message, value, title, callback) {
        $.alerts.prompt(message, value, title, callback);
    };
    
    jValidatePrompt = function(message, value, title, callback) {
        $.alerts.validatePrompt(message, value, title, callback);
    };
    
})(jQuery);
