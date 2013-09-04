/**
 * "鑷畾涔夊垪"鐩稿叧鐨勬搷浣� */

var dropdown = null;
var nCols = $('#columnSelector li').vals();

/**
 * 姣忔鍔犺浇鏁版嵁鎴愬姛鍚庯紝鏍规嵁鈥滆嚜瀹氫箟鍒椻�閲岀殑閫夋嫨锛岄噸鏂板埛鏂板摢浜涘垪鏄剧ず/闅愯棌
 */
function swipeColumns(grid) {
    var parent = grid.table.parent();
    grid.table.detach();
    var cols = dropdown.findItems().map(function() {
        if ($(this).is(':checked')) {
            return this.value;
        }
    }).toArray();
    grid.showCols(cols);
    parent.append(grid.table);
}


function initColumnSelector(grid) {
	// dropChecker函数参见 /js/supertool/drop.js
    dropdown = $('#columnSelector').dropChecker({
        title: '<span class="drop-title"><input id="csAll" class=\"checkbox\" type="checkbox" /><span>' + msg.dropdown.columns + '</span></span>'
    });
    $('#columnSelector').bind('itemClick', function(event, item) {
        var n = Number(item.val());
        grid.switchCol(n, item.is(':checked'));
        resetGridSize(grid.table, true);
    });
    $('#csAll').click(function(event) {
        items = dropdown.findItems().filter(':checkbox');
        var parent = grid.table.parent();
        grid.table.detach();
        if ($(this).is(':checked')) {
            items.attr('checked', true);
            grid.showCols(nCols);
        } else {
            items.attr('checked', false);
            var size = grid.thead.find('th').size();
            var columns = [];
            for (var i = 0; i < size; ++i) {
                columns.push(i);
            }
            var showColumns = S.arrayDiff(columns, nCols);
            grid.showCols(showColumns);
        }
        parent.append(grid.table);
        resetGridSize(grid.table, true);
        event.stopPropagation();
    });
    dropdown.findItems().click(function() {
        
        if($("#csAll")[0]!=undefined){
            var total=$("input[id!='csAll']:checkbox").size();
            var selectTotal= $("input[id!='csAll']:checkbox:checked").size();
            if(total==selectTotal){
                $("#csAll").attr("checked","checked");
            }
            else{
                $("#csAll").attr("checked",false);
            }
        }
    });
}
function resetGridSize(table, needScroll) {
    var totalViewRatio = 0;
    var hasScrollRatio = 100;
    var scrollRatio = 0;
    var ths = [];
    if(table.find('thead').size()){
        ths = table.find('thead').first().find("th");
    }else{
        ths = table.find('tbody').first().find("tr:eq(0)").find("td");
    }
    var count = 0;
    ths.each(function(){
        if(!$(this).hasClass('hidden')) {
            count++;
            totalViewRatio += +$(this).attr("ratio");
        }else{
            this.style.width = "0";
        }
    });
    ths.each(function(){
        if(!$(this).hasClass('hidden')) {
            $(this).css("width", Math.round(($(this).attr("ratio") / totalViewRatio) * 100) + "%");
        }
    });
    scrollRatio = totalViewRatio / hasScrollRatio;
    if(scrollRatio > 1){
        table.width(Math.ceil($(document.body).width()*scrollRatio));
        if (needScroll !== undefined && needScroll == true) {
            table.parent('div').css("height", parseInt(table.css('height')) + 16 + "px");
        }
    }else{
        table.css('width', "100%");
        if (needScroll !== undefined && needScroll == true) {
            table.parent('div').css("width", table.attr('clientWidth') + "px");
            table.parent('div').css("height", table.css('height'));
        }
    }
    var trs = table.find('tbody').first().find("tr");
    if(table.data("_hasData") === false){
        if(trs.size() > 0){
            trs.first().find("td:eq(0)").attr("colspan", count);
        }
    }else{
        trs.first().find("td:eq(0)").attr("colspan", 1);
    }
}
