/**
 * 给表格加上斑马条纹
 * @deprecated
 * @param id
 * @return
 */

if (typeof jQuery != 'undefined') {
    (function($) {
        $.extend($.fn, {
            /**
             * 给表格加上斑马条文
             * 注：stripe本身就是斑马条纹的意思
             * 用法：$('#tableId').stripe();
             */
            stripe: function(options) {
                if (options === undefined) options = {};
                var thead = $(this).find('thead');
                if(!thead) thead = $(this);
                thead.each(function(){
                    $(this).find('>tr').each(function() {
                        $(this).find('th:eq(0)').addClass('border');
                    });
                });
                var tbody = $(this).find('>tbody');
                if (!tbody) tbody = $(this);
                var class1 = 't1';
                var class2 = 't2';
                if (options.reverse) {
                    class1 = 't2';
                    class2 = 't1';
                }
                tbody.each(function(){
                    var cnt = 0;
                    $(this).find('>tr').each(function() {
                        $(this).find('td:eq(0)').addClass('border');
                    });
                    $(this).find('>tr:not(.no-stripe)').each(function(){
                        if ($(this).css('display') != 'none') {
                            if($(this).hasClass("tr-group")){
                                var prev = $(this).prev();
                                if(prev.hasClass("tr-group")){
                                    $(this).addClass((prev.hasClass("t2") ? 't2' : "t1") + " no-highlight");
                                }else{
                                    $(this).addClass((prev.hasClass("t2") ? 't1' : "t2") + " no-highlight");
                                    cnt++;
                                }
                            }else{
                                if (cnt++ % 2) {
                                    $(this).removeClass(class2).addClass(class1);
                                } else {
                                    $(this).removeClass(class1).addClass(class2);
                                }
                            }
                        }
                    });
                });
                tbody.find('>tr:not(.no-highlight):not(.no-stripe):not(.tr-group)').mouseover(function(){
                    $(this).addClass('t3');
                }).mouseout(function(){
                    $(this).removeClass('t3');
                });
            }
        });
    })(jQuery);
};
