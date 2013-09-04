/**
Vertigo Tip by www.vertigo-project.com
Requires jQuery
*/
(function($) {
    $.fn.tip = function(options) {
        if (options === undefined) {
            options = {x:-10, y:10};
        }
        var xOffset = options.x;
        var yOffset = options.y;
        var noArrow = options.noArrow || false;
        var current;
        $(this).each(function() {
            var that = $(this);
            $(this).unbind('hover').hover(function(e) {
                var THIS = this;
                var top = (e.pageY + yOffset);
                var left = (e.pageX + xOffset);
                var div = $('#vtip');
                if(e.target != current){
                    current = e.target;
                    var data = THIS.title;
                    if(data != ""){
                        THIS.timer = setTimeout(function() {
                            if (div.size() == 0) {
                                $('body').append('<div id="vtip"><img id="vtipArrow" />' + data + '</div>' );
                            } else {
                                div.html(data);
                            }
                            if (!noArrow) {
                                $('#vtipArrow').attr("src", S.url('css/images/vtip_arrow.png'));
                            }
                            $('#vtip').css("top", top+"px").css("left", left+"px").show();
                        }, 500);
                        this.t = this.title;
                        this.title = '';
                    }
                } else {
                    clearTimeout(THIS.timer);
                }
            }, function() {
                current = null;
                if (this.t) {
                    this.title = this.t;
                }
                clearTimeout(that[0].timer);
                $("#vtip").hide();
            });
        });
    };
})(jQuery);