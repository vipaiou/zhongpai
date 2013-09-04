
$(document).ready(function() {

    $(".drop-content").hide();
    $(".drop-title").removeClass("menu-open");
    $(".drop-title").click(function(e) {
        e.preventDefault();
        var content = $(this).parent().next(".drop-content");
        content.toggle();
        content.css("min-width", $(this).width() - 12);
        $(this).toggleClass("menu-open");
    });
    $(".drop-content ul li").click(function() {
        var container = $(this).parents(".drop-container");
        container.find(".drop-title span").text($(this).text());
        container.find(".drop-content").hide();
        container.find(".drop-title").removeClass("menu-open");
    });

    $(".drop-content").mouseup(function() {
        return false;
    });
    $(document).mouseup(function(e) {
        if($(e.target).parent("a.drop-title").length==0) {
            $(".drop-title").removeClass("menu-open");
            $(".drop-content").hide();
        }
    });

});
