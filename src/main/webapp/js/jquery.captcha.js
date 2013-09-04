(function($) {
    $.fn.captcha = function(options) {
        var defaults = {
            borderColor : "",
            captchaDir : ".",
            url : "getRandomNumber",
            formId : "myForm",
            text : "Verify that you are a human,<br />drag <span>scissors</span> into the circle.",
            items : Array("pencil", "scissors", "clock", "heart", "note"),
            photoName : {
                pencil : "pencil",
                scissors : "scissors",
                clock : "clock",
                heart : "heart",
                note : "note"
            }
        };

        var options = $.extend(defaults, options);

        if (window.XMLHttpRequest) { // Mozilla, Safari,IE7
            $(this)
                    .html(
                            "<b class='ajax-fc-rtop'><b class='ajax-fc-r1'></b> <b class='ajax-fc-r2'></b> <b class='ajax-fc-r3'></b> <b class='ajax-fc-r4'></b></b><div id='ajax-fc-content'><div id='ajax-fc-left'><ul id='ajax-fc-task'><li class='ajax-fc-0'><img src='"
                                    + options.captchaDir
                                    + "/css/captcha/imgs/item-none.png' alt='' /></li><li class='ajax-fc-1'><img src='"
                                    + options.captchaDir
                                    + "/css/captcha/imgs/item-none.png' alt='' /></li><li class='ajax-fc-2'><img src='"
                                    + options.captchaDir
                                    + "/css/captcha/imgs/item-none.png' alt='' /></li><li class='ajax-fc-3'><img src='"
                                    + options.captchaDir
                                    + "/css/captcha/imgs/item-none.png' alt='' /></li><li class='ajax-fc-4'><img src='"
                                    + options.captchaDir
                                    + "/css/captcha/imgs/item-none.png' alt='' /></li></ul><br/><p id='ajax-fc-task'>"
                                    + options.text
                                    + "</p></div><div id='ajax-fc-right'><p id='ajax-fc-circle'></p></div></div><div id='ajax-fc-corner-spacer'></div><b class='ajax-fc-rbottom'><b class='ajax-fc-r4'></b> <b class='ajax-fc-r3'></b> <b class='ajax-fc-r2'></b> <b class='ajax-fc-r1'></b></b>");

        } else {
            $(this)
                    .html(
                            "<b class='ajax-fc-rtop'><b class='ajax-fc-r1'></b> <b class='ajax-fc-r2'></b> <b class='ajax-fc-r3'></b> <b class='ajax-fc-r4'></b></b><div id='ajax-fc-content'><div id='ajax-fc-left'><ul id='ajax-fc-task'><li class='ajax-fc-0'><img src='"
                                    + options.captchaDir
                                    + "/css/captcha/imgs/item-none.png' alt='' /></li><li class='ajax-fc-1'><img src='"
                                    + options.captchaDir
                                    + "/css/captcha/imgs/item-none.png' alt='' /></li><li class='ajax-fc-2'><img src='"
                                    + options.captchaDir
                                    + "/css/captcha/imgs/item-none.png' alt='' /></li><li class='ajax-fc-3'><img src='"
                                    + options.captchaDir
                                    + "/css/captcha/imgs/item-none.png' alt='' /></li><li class='ajax-fc-4'><img src='"
                                    + options.captchaDir
                                    + "/css/captcha/imgs/item-none.png' alt='' /></li></ul><br/><p id='ajax-fc-task_' style='line-height:10px;padding: 1px 0 0 1px;'>"
                                    + options.text
                                    + "</p></div><div id='ajax-fc-right'><p id='ajax-fc-circle'></p></div></div><div id='ajax-fc-corner-spacer'></div><b class='ajax-fc-rbottom'><b class='ajax-fc-r4'></b> <b class='ajax-fc-r3'></b> <b class='ajax-fc-r2'></b> <b class='ajax-fc-r1'></b></b>");

        }

        var rand = $.ajax( {
            url : options.url,
            async : false
        }).responseText;
        var pic = randomNumber();
        $(".ajax-fc-" + rand).html(
                "<img src=\"" + options.captchaDir + "/css/captcha/imgs/item-" + options.items[pic]
                        + ".png\" alt=\"\" />");
        if (window.XMLHttpRequest) { // Mozilla, Safari,IE7
            $("p#ajax-fc-task span").html(options.photoName[options.items[pic]]);
            }
        else{
            $("p#ajax-fc-task_ span").html(options.photoName[options.items[pic]]);
            }
        $(".ajax-fc-" + rand).addClass('ajax-fc-highlighted');
        $(".ajax-fc-" + rand).draggable( {
            containment : '#ajax-fc-content'
        });
        var used = Array();
        for ( var i = 0; i < 5; i++) {
            if (i != rand && i != pic) {
                $(".ajax-fc-" + i).html(
                        "<img src=\"" + options.captchaDir + "/css/captcha/imgs/item-" + options.items[i]
                                + ".png\" alt=\"\" />");
                used[i] = options.items[i];
            }
        }
        $(".ajax-fc-container, .ajax-fc-rtop *, .ajax-fc-rbottom *").css("background-color", options.borderColor);
        $("#ajax-fc-circle").droppable(
                {
                    drop : function(event, ui) {
                        $(".ajax-fc-" + rand).draggable("disable");
                        $("#" + options.formId).append(
                                "<input type=\"hidden\" style=\"display: none;\" name=\"captcha\" value=\"" + rand
                                        + "\">");
                    },
                    tolerance : 'touch'
                });
    };

})(jQuery);

function randomNumber() {
    var chars = "01234";
    chars += ".";
    var size = 1;
    var i = 1;
    var ret = "";
    while (i <= size) {
        $max = chars.length - 1;
        $num = Math.floor(Math.random() * $max);
        $temp = chars.substr($num, 1);
        ret += $temp;
        i++;
    }
    return ret;
}