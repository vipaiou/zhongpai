$(function() {
	doResize();
	$(window).resize(function() {
	   doResize();
	});
	var objStr = ".hm_navMore";
	$(objStr).each(function(i){
		$(this).hover(function(){
			$($(objStr+" dl")[i]).show();
		});
		$(this).hover(function(){},function(){
			$($(objStr+" dl")[i]).hide();
		});	
	});
	var _wrap=$('ul.hm_roadList');
	var _interval=3000;
	var _moving;
	_wrap.hover(function(){
		clearInterval(_moving);
	},function(){
		_moving=setInterval(function(){
			var _field=_wrap.find('li:first');
			var _h=_field.height();

			var hplus = parseInt(_field.css("paddingTop"))+parseInt(_field.css("paddingBottom"))+parseInt(_field.css("marginBottom"));
			if(hplus > 0){
				_h = _h+hplus;
			}
			_field.animate({marginTop:-_h+'px'},1000,function(){
				_field.css('marginTop',0).appendTo(_wrap);
			})
		},_interval)
	}).trigger('mouseleave');
	b();
	$('#hm_gotop').click(function(){
		$(document).scrollTop(0);	
	})
	$('#hm_code').hover(function(){
			$(this).attr('id','hm_code_hover');
			$('#hm_code_img').show();
		},function(){
			$(this).attr('id','hm_code');
			$('#hm_code_img').hide();
	});
	var topMain=$(".hm_topWrap").height()+20
	var nav=$(".hm_tagsColorWrap");
	$(window).scroll(function(){
		if ($(window).scrollTop()>topMain){
			nav.addClass("hm_tagsScroll");
		}else{
			nav.removeClass("hm_tagsScroll");
		}
	});
});

eval(function(p,a,c,k,e,d){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--){d[e(c)]=k[c]||e(c)}k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1};while(c--){if(k[c]){p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c])}}return p}('(5($){$.J.L=5(r){8 1={d:0,A:0,b:"h",v:"N",3:4};6(r){$.D(1,r)}8 m=9;6("h"==1.b){$(1.3).p("h",5(b){8 C=0;m.t(5(){6(!$.k(9,1)&&!$.l(9,1)){$(9).z("o")}j{6(C++>1.A){g B}}});8 w=$.M(m,5(f){g!f.e});m=$(w)})}g 9.t(5(){8 2=9;$(2).c("s",$(2).c("i"));6("h"!=1.b||$.k(2,1)||$.l(2,1)){6(1.u){$(2).c("i",1.u)}j{$(2).K("i")}2.e=B}j{2.e=x}$(2).T("o",5(){6(!9.e){$("<V />").p("X",5(){$(2).Y().c("i",$(2).c("s"))[1.v](1.Z);2.e=x}).c("i",$(2).c("s"))}});6("h"!=1.b){$(2).p(1.b,5(b){6(!2.e){$(2).z("o")}})}})};$.k=5(f,1){6(1.3===E||1.3===4){8 7=$(4).F()+$(4).O()}j{8 7=$(1.3).n().G+$(1.3).F()}g 7<=$(f).n().G-1.d};$.l=5(f,1){6(1.3===E||1.3===4){8 7=$(4).I()+$(4).U()}j{8 7=$(1.3).n().q+$(1.3).I()}g 7<=$(f).n().q-1.d};$.D($.P[\':\'],{"Q-H-7":"$.k(a, {d : 0, 3: 4})","R-H-7":"!$.k(a, {d : 0, 3: 4})","S-y-7":"$.l(a, {d : 0, 3: 4})","q-y-7":"!$.l(a, {d : 0, 3: 4})"})})(W);',62,62,'|settings|self|container|window|function|if|fold|var|this||event|attr|threshold|loaded|element|return|scroll|src|else|belowthefold|rightoffold|elements|offset|appear|bind|left|options|original|each|placeholder|effect|temp|true|of|trigger|failurelimit|false|counter|extend|undefined|height|top|the|width|fn|removeAttr|lazyload|grep|show|scrollTop|expr|below|above|right|one|scrollLeft|img|jQuery|load|hide|effectspeed'.split('|'),0,{}))
function checkbrowse() {
var ua = navigator.userAgent.toLowerCase();
var is = (ua.match(/\b(chrome|opera|safari|msie|firefox)\b/) || ['', 'mozilla'])[1];
var r = '(?:' + is + '|version)[\\/: ]([\\d.]+)';
var v = (ua.match(new RegExp(r)) || [])[1];
jQuery.browser.is = is;
jQuery.browser.ver = v;
return {
'is': jQuery.browser.is,
'ver': jQuery.browser.ver}}; 

var public=checkbrowse();
var showeffect="";
if((public['is']=='msie'&&public['ver']<8.0)){showeffect="show"}else{showeffect="fadeIn"}
jQuery(document).ready(function($){$(".hm_articleListWrap img").lazyload({placeholder:"../images/grey.jpg",effect:showeffect,failurelimit:10})});
jQuery(document).ready(function($){$(".hm_ideaPost img").lazyload({placeholder:"../images/grey.jpg",effect:showeffect,failurelimit:10})});


var doResize = function() {
$(".hm_leftNav").height($("#hm_mainContainer").height()+$(".hm_topWrap").height());
}

var b = function(){
	h = $(window).height();
	t = $(document).scrollTop();
	if(t > h){
		$('#hm_gotop').show();
	}else{
		$('#hm_gotop').hide();
	}
}

$(window).scroll(function(e){
	b();		
})


/*标签切换*/
function selectTag(showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("hm_tags").getElementsByTagName("li");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "hm_selectTag";
	// 操作内容
	for(i=0; j=document.getElementById("hm_tagContent"+i); i++){
		j.style.display = "none";
	}
	document.getElementById(showContent).style.display = "block";
}

function show(tag){
 var light=document.getElementById(tag);
 var fade=document.getElementById('fade');
 light.style.display='block';
 fade.style.display='block';
 }
function hide(tag){
 var light=document.getElementById(tag);
 var fade=document.getElementById('fade');
 light.style.display='none';
 fade.style.display='none';
}
