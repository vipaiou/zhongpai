function cancel_queue(t){t.stopUpload();var e;do e=t.getStats(),t.cancelUpload();while(0!==e.files_queued)}function file_queue_error(t,e){var i="";e==SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED?alert("超过允许上载的文件数量"):i=e==SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT?$.ui_core.format(this.customSettings.error,t.id,t.name,"文件超过尺寸限制"):$.ui_core.format(this.customSettings.error,t.id,t.name,"文件上传错误"),this.settings.button_action==SWFUpload.BUTTON_ACTION.SELECT_FILE?$(this.settings.button_placeholder_id.replace("button_","#")).html($(i)):$(this.settings.button_placeholder_id.replace("button_","#")).append($(i)),$("#"+t.id).delay(3e3).fadeOut("slow")}function file_dialog_complete(){this.startUpload()}function upload_start(t){var e=$.ui_core.format(this.customSettings.progress,t.id,t.name,t.id,t.id);this.settings.button_action==SWFUpload.BUTTON_ACTION.SELECT_FILE?$(this.settings.button_placeholder_id.replace("button_","#")).html($(e)):$(this.settings.button_placeholder_id.replace("button_","#")).append($(e))}function upload_progress(t,e,i){var n=Math.ceil(99*(e/i));$("#"+t.id+"_progressinner").css("width",n+"%"),$("#"+t.id+"_progressinner").html(n+"%")}function upload_error(t,e){if(e==SWFUpload.UPLOAD_ERROR.FILE_CANCELLED)$("#"+t.id).remove();else{var i=$.ui_core.format(this.customSettings.error,t.id,t.name,"文件上传错误");$("#"+t.id).replaceWith($(i))}}function upload_success(t,e){$("#"+t.id).replaceWith($(e))}function upload_complete(){this.startUpload()}!function(t){t.extend(t.fn,{cascade:function(e){return new t.cascade(this,e)}}),t.cascade=function(t,e){return this.elements=t,this.options=e||{},this.selectOption(this.options.defaults||[]),this.ready(),this},t.extend(t.cascade,{options:{},prototype:{selectOption:function(e,n){var s=(n||"0").split(".").length-1;this.elements[s].length=0,this.options.prompts&&this.options.prompts[s]&&this.elements[s].options.add(new Option(this.options.prompts[s],""));for(i in t.cascade.options[n||"0"]||[]){var o=t.cascade.options[n||"0"][i],r=new Option(o,o);e[s]&&o==e[s]&&(r.selected=!0),this.elements[s].options.add(r)}s<this.elements.length-1&&this.selectOption(e,(n||"0")+"."+(this.elements[s].selectedIndex-1))},ready:function(){for(var e=this,i=[],n=0;n<this.elements.length-1;n++)t("body").on("change",t(this.elements[n]),function(n){for(t("#"+n.target.id+"_error").html(""),j=0;j<e.elements.length;j++)i[j]=t(e.elements[j]).val();e.selectOption(i)})}}})}(jQuery),$.cascade.options={.32:["花地玛堂区","圣安多尼堂区","大堂区","望德堂区","风顺堂区","氹仔","路环","其他"],.21:["银川","石嘴山","吴忠","固原","中卫"],"0.10":["贵阳","六盘水","遵义","安顺","铜仁","黔西南","毕节","黔东南","黔南"],.4:["南京","无锡","徐州","常州","苏州","南通","连云港","淮安","宿迁","盐城","扬州","镇江","泰州"],.33:["新北市","台北市","高雄市","基隆市","台中市","台南市","新竹市","嘉义市","台北县","宜兰县","桃园县","新竹县","苗栗县","台中县","彰化县","南投县","云林县","嘉义县","台南县","高雄县","屏东县","澎湖县","台东县","花莲县","其他"],.22:["西宁","海东","海北","黄南","海南","果洛","玉树","海西"],.11:["海口","三亚","五指山","琼海","儋州","文昌","万宁","东方","定安","屯昌","澄迈","临高","白沙","昌江","乐东","陵水","保亭","琼中","西沙","南沙","中沙"],.5:["合肥","芜湖","蚌埠","淮南","淮北","马鞍山","铜陵","安庆","黄山","滁州","阜阳","宿州","巢湖","六安","亳州","池州","宣城"],.34:["美国","英国","法国","俄罗斯","加拿大","巴西","澳大利亚","印尼","泰国","马来西亚","新加坡","菲律宾","越南","印度","日本","新西兰","韩国","德国","意大利","爱尔兰","荷兰","瑞士","乌克兰","南非","芬兰","瑞典","奥地利","西班牙","比利时","挪威","丹麦","波兰","阿根廷","白俄罗斯","哥伦比亚","古巴","埃及","希腊","匈牙利","伊朗","蒙古","墨西哥","葡萄牙","沙特阿拉伯","土耳其","其他"],.23:["济南","青岛","淄博","枣庄","东营","烟台","潍坊","济宁","泰安","威海","日照","莱芜","临沂","德州","聊城","滨州","菏泽"],.12:["石家庄","唐山","秦皇岛","邯郸","邢台","保定","张家口","承德","沧州","廊坊","衡水"],.6:["万州区","涪陵区","渝中区","大渡口区","江北区","沙坪坝区","九龙坡区","南岸区","北碚区","万盛区","双桥区","渝北区","巴南区","黔江区","长寿区","綦江县","潼南县","铜梁县","大足县","荣昌县","璧山县","梁平县","城口县","丰都县","垫江县","武隆县","忠县","开县","云阳县","奉节县","巫山县","巫溪县","石柱土家族自治县","秀山土家族苗族自治县","酉阳土家族苗族自治县","彭水苗族土家族自治县","江津区","合川区","永川区","南川区"],.7:["福州","厦门","莆田","三明","泉州","漳州","南平","龙岩","宁德"],.24:["太原","大同","阳泉","长治","晋城","朔州","晋中","运城","忻州","临汾","吕梁"],.13:["郑州","开封","洛阳","平顶山","安阳","鹤壁","新乡","焦作","濮阳","许昌","漯河","三门峡","南阳","商丘","信阳","周口","驻马店","济源"],.8:["兰州","嘉峪关","金昌","白银","天水","武威","张掖","平凉","酒泉","庆阳","定西","陇南","临夏","甘南"],.25:["西安","铜川","宝鸡","咸阳","渭南","延安","汉中","榆林","安康","商洛"],.14:["哈尔滨","齐齐哈尔","鸡西","鹤岗","双鸭山","大庆","伊春","佳木斯","七台河","牡丹江","黑河","绥化","大兴安岭"],.9:["南宁","柳州","桂林","梧州","北海","防城港","钦州","贵港","玉林","百色","贺州","河池","来宾","崇左"],0:["北京","上海","广东","浙江","江苏","安徽","重庆","福建","甘肃","广西","贵州","海南","河北","河南","黑龙江","湖北","湖南","吉林","江西","辽宁","内蒙古","宁夏","青海","山东","山西","陕西","四川","天津","西藏","新疆","云南","香港","澳门","台湾","海外"],.26:["成都","自贡","攀枝花","泸州","德阳","绵阳","广元","遂宁","内江","乐山","南充","眉山","宜宾","广安","达州","雅安","巴中","资阳","阿坝","甘孜","凉山"],.15:["武汉","黄石","十堰","宜昌","襄阳","鄂州","荆门","孝感","荆州","黄冈","咸宁","随州","恩施土家族自治州","仙桃","潜江","天门","神农架"],.27:["和平区","河东区","河西区","南开区","河北区","红桥区","塘沽区","汉沽区","大港区","东丽区","西青区","津南区","北辰区","武清区","宝坻区","宁河县","静海县","蓟县","滨海新区","保税区"],.16:["长沙","株洲","湘潭","衡阳","邵阳","岳阳","常德","张家界","益阳","郴州","永州","怀化","娄底","湘西土家族苗族自治区"],"0.0":["东城区","西城区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区","通州区","顺义区","昌平区","大兴区","怀柔区","平谷区","密云县","延庆县"],.28:["拉萨","昌都","山南","日喀则","那曲","阿里","林芝"],.17:["长春","吉林","四平","辽源","通化","白山","松原","白城","延边朝鲜族自治州"],.1:["黄浦区","卢湾区","徐汇区","长宁区","静安区","普陀区","闸北区","虹口区","杨浦区","闵行区","宝山区","嘉定区","浦东新区","金山区","松江区","青浦区","南汇区","奉贤区","崇明县"],"0.30":["昆明","曲靖","玉溪","保山","昭通","丽江","思茅","临沧","楚雄","红河","文山","西双版纳","大理","德宏","怒江","迪庆"],.29:["乌鲁木齐","克拉玛依","吐鲁番","哈密","昌吉","博尔塔拉","巴音郭楞","阿克苏","克孜勒苏","喀什","和田","伊犁","塔城","阿勒泰","石河子","阿拉尔","图木舒克","五家渠"],.18:["南昌","景德镇","萍乡","九江","新余","鹰潭","赣州","吉安","宜春","抚州","上饶"],.2:["广州","韶关","深圳","珠海","汕头","佛山","江门","湛江","茂名","肇庆","惠州","梅州","汕尾","河源","阳江","清远","东莞","中山","潮州","揭阳","云浮"],.31:["中西区","港仔区","东区","南区","九龙城区","油尖旺区","深水埗区","黄大仙区","观塘区","北区","大埔区","沙田区","西贡区","元朗区","屯门区","荃湾区","葵青区","离岛区"],"0.20":["呼和浩特","包头","乌海","赤峰","通辽","鄂尔多斯","呼伦贝尔","巴彦淖尔盟","乌兰察布盟","兴安盟","锡林郭勒盟","阿拉善盟"],.19:["沈阳","大连","鞍山","抚顺","本溪","丹东","锦州","营口","阜新","辽阳","盘锦","铁岭","朝阳","葫芦岛"],.3:["杭州","宁波","温州","嘉兴","湖州","绍兴","金华","衢州","舟山","台州","丽水"]};var SWFUpload;"function"==typeof SWFUpload&&(SWFUpload.queue={},SWFUpload.prototype.initSettings=function(t){return function(){"function"==typeof t&&t.call(this),this.queueSettings={},this.queueSettings.queue_cancelled_flag=!1,this.queueSettings.queue_upload_count=0,this.queueSettings.user_upload_complete_handler=this.settings.upload_complete_handler,this.queueSettings.user_upload_start_handler=this.settings.upload_start_handler,this.settings.upload_complete_handler=SWFUpload.queue.uploadCompleteHandler,this.settings.upload_start_handler=SWFUpload.queue.uploadStartHandler,this.settings.queue_complete_handler=this.settings.queue_complete_handler||null}}(SWFUpload.prototype.initSettings),SWFUpload.prototype.startUpload=function(t){this.queueSettings.queue_cancelled_flag=!1,this.callFlash("StartUpload",[t])},SWFUpload.prototype.cancelQueue=function(){this.queueSettings.queue_cancelled_flag=!0,this.stopUpload();for(var t=this.getStats();t.files_queued>0;)this.cancelUpload(),t=this.getStats()},SWFUpload.queue.uploadStartHandler=function(t){var e;return"function"==typeof this.queueSettings.user_upload_start_handler&&(e=this.queueSettings.user_upload_start_handler.call(this,t)),e=e===!1?!1:!0,this.queueSettings.queue_cancelled_flag=!e,e},SWFUpload.queue.uploadCompleteHandler=function(t){var e,i=this.queueSettings.user_upload_complete_handler;if(t.filestatus===SWFUpload.FILE_STATUS.COMPLETE&&this.queueSettings.queue_upload_count++,e="function"==typeof i?i.call(this,t)===!1?!1:!0:t.filestatus===SWFUpload.FILE_STATUS.QUEUED?!1:!0){var n=this.getStats();n.files_queued>0&&this.queueSettings.queue_cancelled_flag===!1?this.startUpload():this.queueSettings.queue_cancelled_flag===!1?(this.queueEvent("queue_complete_handler",[this.queueSettings.queue_upload_count]),this.queueSettings.queue_upload_count=0):(this.queueSettings.queue_cancelled_flag=!1,this.queueSettings.queue_upload_count=0)}});var SWFUpload;void 0==SWFUpload&&(SWFUpload=function(t){this.initSWFUpload(t)}),SWFUpload.prototype.initSWFUpload=function(t){try{this.customSettings={},this.settings=t,this.eventQueue=[],this.movieName="SWFUpload_"+SWFUpload.movieCount++,this.movieElement=null,SWFUpload.instances[this.movieName]=this,this.initSettings(),this.loadFlash(),this.displayDebugInfo()}catch(e){throw delete SWFUpload.instances[this.movieName],e}},SWFUpload.instances={},SWFUpload.movieCount=0,SWFUpload.version="2.2.0 2009-03-25",SWFUpload.QUEUE_ERROR={QUEUE_LIMIT_EXCEEDED:-100,FILE_EXCEEDS_SIZE_LIMIT:-110,ZERO_BYTE_FILE:-120,INVALID_FILETYPE:-130},SWFUpload.UPLOAD_ERROR={HTTP_ERROR:-200,MISSING_UPLOAD_URL:-210,IO_ERROR:-220,SECURITY_ERROR:-230,UPLOAD_LIMIT_EXCEEDED:-240,UPLOAD_FAILED:-250,SPECIFIED_FILE_ID_NOT_FOUND:-260,FILE_VALIDATION_FAILED:-270,FILE_CANCELLED:-280,UPLOAD_STOPPED:-290},SWFUpload.FILE_STATUS={QUEUED:-1,IN_PROGRESS:-2,ERROR:-3,COMPLETE:-4,CANCELLED:-5},SWFUpload.BUTTON_ACTION={SELECT_FILE:-100,SELECT_FILES:-110,START_UPLOAD:-120},SWFUpload.CURSOR={ARROW:-1,HAND:-2},SWFUpload.WINDOW_MODE={WINDOW:"window",TRANSPARENT:"transparent",OPAQUE:"opaque"},SWFUpload.completeURL=function(t){if("string"!=typeof t||t.match(/^https?:\/\//i)||t.match(/^\//))return t;window.location.protocol+"//"+window.location.hostname+(window.location.port?":"+window.location.port:"");var e=window.location.pathname.lastIndexOf("/");return path=0>=e?"/":window.location.pathname.substr(0,e)+"/",path+t},SWFUpload.prototype.initSettings=function(){this.ensureDefault=function(t,e){this.settings[t]=void 0==this.settings[t]?e:this.settings[t]},this.ensureDefault("upload_url",""),this.ensureDefault("preserve_relative_urls",!1),this.ensureDefault("file_post_name","Filedata"),this.ensureDefault("post_params",{}),this.ensureDefault("use_query_string",!1),this.ensureDefault("requeue_on_error",!1),this.ensureDefault("http_success",[]),this.ensureDefault("assume_success_timeout",0),this.ensureDefault("file_types","*.*"),this.ensureDefault("file_types_description","All Files"),this.ensureDefault("file_size_limit",0),this.ensureDefault("file_upload_limit",0),this.ensureDefault("file_queue_limit",0),this.ensureDefault("flash_url","swfupload.swf"),this.ensureDefault("prevent_swf_caching",!0),this.ensureDefault("button_image_url",""),this.ensureDefault("button_width",1),this.ensureDefault("button_height",1),this.ensureDefault("button_text",""),this.ensureDefault("button_text_style","color: #000000; font-size: 16pt;"),this.ensureDefault("button_text_top_padding",0),this.ensureDefault("button_text_left_padding",0),this.ensureDefault("button_action",SWFUpload.BUTTON_ACTION.SELECT_FILES),this.ensureDefault("button_disabled",!1),this.ensureDefault("button_placeholder_id",""),this.ensureDefault("button_placeholder",null),this.ensureDefault("button_cursor",SWFUpload.CURSOR.ARROW),this.ensureDefault("button_window_mode",SWFUpload.WINDOW_MODE.WINDOW),this.ensureDefault("debug",!1),this.settings.debug_enabled=this.settings.debug,this.settings.return_upload_start_handler=this.returnUploadStart,this.ensureDefault("swfupload_loaded_handler",null),this.ensureDefault("file_dialog_start_handler",null),this.ensureDefault("file_queued_handler",null),this.ensureDefault("file_queue_error_handler",null),this.ensureDefault("file_dialog_complete_handler",null),this.ensureDefault("upload_start_handler",null),this.ensureDefault("upload_progress_handler",null),this.ensureDefault("upload_error_handler",null),this.ensureDefault("upload_success_handler",null),this.ensureDefault("upload_complete_handler",null),this.ensureDefault("debug_handler",this.debugMessage),this.ensureDefault("custom_settings",{}),this.customSettings=this.settings.custom_settings,this.settings.prevent_swf_caching&&(this.settings.flash_url=this.settings.flash_url+(this.settings.flash_url.indexOf("?")<0?"?":"&")+"preventswfcaching="+(new Date).getTime()),this.settings.preserve_relative_urls||(this.settings.upload_url=SWFUpload.completeURL(this.settings.upload_url),this.settings.button_image_url=SWFUpload.completeURL(this.settings.button_image_url)),delete this.ensureDefault},SWFUpload.prototype.loadFlash=function(){var t,e;if(null!==document.getElementById(this.movieName))throw"ID "+this.movieName+" is already in use. The Flash Object could not be added";if(t=document.getElementById(this.settings.button_placeholder_id)||this.settings.button_placeholder,void 0==t)throw"Could not find the placeholder element: "+this.settings.button_placeholder_id;e=document.createElement("div"),e.innerHTML=this.getFlashHTML(),t.parentNode.replaceChild(e.firstChild,t),void 0==window[this.movieName]&&(window[this.movieName]=this.getMovieElement())},SWFUpload.prototype.getFlashHTML=function(){return['<object id="',this.movieName,'" type="application/x-shockwave-flash" data="',this.settings.flash_url,'" width="',this.settings.button_width,'" height="',this.settings.button_height,'" class="swfupload">','<param name="wmode" value="',this.settings.button_window_mode,'" />','<param name="movie" value="',this.settings.flash_url,'" />','<param name="quality" value="high" />','<param name="menu" value="false" />','<param name="allowScriptAccess" value="always" />','<param name="wmode" value="transparent" />','<param name="flashvars" value="'+this.getFlashVars()+'" />',"</object>"].join("")},SWFUpload.prototype.getFlashVars=function(){var t=this.buildParamString(),e=this.settings.http_success.join(",");return["movieName=",encodeURIComponent(this.movieName),"&amp;uploadURL=",encodeURIComponent(this.settings.upload_url),"&amp;useQueryString=",encodeURIComponent(this.settings.use_query_string),"&amp;requeueOnError=",encodeURIComponent(this.settings.requeue_on_error),"&amp;httpSuccess=",encodeURIComponent(e),"&amp;assumeSuccessTimeout=",encodeURIComponent(this.settings.assume_success_timeout),"&amp;params=",encodeURIComponent(t),"&amp;filePostName=",encodeURIComponent(this.settings.file_post_name),"&amp;fileTypes=",encodeURIComponent(this.settings.file_types),"&amp;fileTypesDescription=",encodeURIComponent(this.settings.file_types_description),"&amp;fileSizeLimit=",encodeURIComponent(this.settings.file_size_limit),"&amp;fileUploadLimit=",encodeURIComponent(this.settings.file_upload_limit),"&amp;fileQueueLimit=",encodeURIComponent(this.settings.file_queue_limit),"&amp;debugEnabled=",encodeURIComponent(this.settings.debug_enabled),"&amp;buttonImageURL=",encodeURIComponent(this.settings.button_image_url),"&amp;buttonWidth=",encodeURIComponent(this.settings.button_width),"&amp;buttonHeight=",encodeURIComponent(this.settings.button_height),"&amp;buttonText=",encodeURIComponent(this.settings.button_text),"&amp;buttonTextTopPadding=",encodeURIComponent(this.settings.button_text_top_padding),"&amp;buttonTextLeftPadding=",encodeURIComponent(this.settings.button_text_left_padding),"&amp;buttonTextStyle=",encodeURIComponent(this.settings.button_text_style),"&amp;buttonAction=",encodeURIComponent(this.settings.button_action),"&amp;buttonDisabled=",encodeURIComponent(this.settings.button_disabled),"&amp;buttonCursor=",encodeURIComponent(this.settings.button_cursor)].join("")},SWFUpload.prototype.getMovieElement=function(){if(void 0==this.movieElement&&(this.movieElement=document.getElementById(this.movieName)),null===this.movieElement)throw"Could not find Flash element";return this.movieElement},SWFUpload.prototype.buildParamString=function(){var t=this.settings.post_params,e=[];if("object"==typeof t)for(var i in t)t.hasOwnProperty(i)&&e.push(encodeURIComponent(i.toString())+"="+encodeURIComponent(t[i].toString()));return e.join("&amp;")},SWFUpload.prototype.destroy=function(){try{this.cancelUpload(null,!1);var t=null;if(t=this.getMovieElement(),t&&"unknown"==typeof t.CallFunction){for(var e in t)try{"function"==typeof t[e]&&(t[e]=null)}catch(i){}try{t.parentNode.removeChild(t)}catch(n){}}return window[this.movieName]=null,SWFUpload.instances[this.movieName]=null,delete SWFUpload.instances[this.movieName],this.movieElement=null,this.settings=null,this.customSettings=null,this.eventQueue=null,this.movieName=null,!0}catch(s){return!1}},SWFUpload.prototype.displayDebugInfo=function(){this.debug(["---SWFUpload Instance Info---\n","Version: ",SWFUpload.version,"\n","Movie Name: ",this.movieName,"\n","Settings:\n","	","upload_url:               ",this.settings.upload_url,"\n","	","flash_url:                ",this.settings.flash_url,"\n","	","use_query_string:         ",this.settings.use_query_string.toString(),"\n","	","requeue_on_error:         ",this.settings.requeue_on_error.toString(),"\n","	","http_success:             ",this.settings.http_success.join(", "),"\n","	","assume_success_timeout:   ",this.settings.assume_success_timeout,"\n","	","file_post_name:           ",this.settings.file_post_name,"\n","	","post_params:              ",this.settings.post_params.toString(),"\n","	","file_types:               ",this.settings.file_types,"\n","	","file_types_description:   ",this.settings.file_types_description,"\n","	","file_size_limit:          ",this.settings.file_size_limit,"\n","	","file_upload_limit:        ",this.settings.file_upload_limit,"\n","	","file_queue_limit:         ",this.settings.file_queue_limit,"\n","	","debug:                    ",this.settings.debug.toString(),"\n","	","prevent_swf_caching:      ",this.settings.prevent_swf_caching.toString(),"\n","	","button_placeholder_id:    ",this.settings.button_placeholder_id.toString(),"\n","	","button_placeholder:       ",this.settings.button_placeholder?"Set":"Not Set","\n","	","button_image_url:         ",this.settings.button_image_url.toString(),"\n","	","button_width:             ",this.settings.button_width.toString(),"\n","	","button_height:            ",this.settings.button_height.toString(),"\n","	","button_text:              ",this.settings.button_text.toString(),"\n","	","button_text_style:        ",this.settings.button_text_style.toString(),"\n","	","button_text_top_padding:  ",this.settings.button_text_top_padding.toString(),"\n","	","button_text_left_padding: ",this.settings.button_text_left_padding.toString(),"\n","	","button_action:            ",this.settings.button_action.toString(),"\n","	","button_disabled:          ",this.settings.button_disabled.toString(),"\n","	","custom_settings:          ",this.settings.custom_settings.toString(),"\n","Event Handlers:\n","	","swfupload_loaded_handler assigned:  ",("function"==typeof this.settings.swfupload_loaded_handler).toString(),"\n","	","file_dialog_start_handler assigned: ",("function"==typeof this.settings.file_dialog_start_handler).toString(),"\n","	","file_queued_handler assigned:       ",("function"==typeof this.settings.file_queued_handler).toString(),"\n","	","file_queue_error_handler assigned:  ",("function"==typeof this.settings.file_queue_error_handler).toString(),"\n","	","upload_start_handler assigned:      ",("function"==typeof this.settings.upload_start_handler).toString(),"\n","	","upload_progress_handler assigned:   ",("function"==typeof this.settings.upload_progress_handler).toString(),"\n","	","upload_error_handler assigned:      ",("function"==typeof this.settings.upload_error_handler).toString(),"\n","	","upload_success_handler assigned:    ",("function"==typeof this.settings.upload_success_handler).toString(),"\n","	","upload_complete_handler assigned:   ",("function"==typeof this.settings.upload_complete_handler).toString(),"\n","	","debug_handler assigned:             ",("function"==typeof this.settings.debug_handler).toString(),"\n"].join(""))},SWFUpload.prototype.addSetting=function(t,e,i){return this.settings[t]=void 0==e?i:e},SWFUpload.prototype.getSetting=function(t){return void 0!=this.settings[t]?this.settings[t]:""},SWFUpload.prototype.callFlash=function(functionName,argumentArray){argumentArray=argumentArray||[];var movieElement=this.getMovieElement(),returnValue,returnString;try{returnString=movieElement.CallFunction('<invoke name="'+functionName+'" returntype="javascript">'+__flash__argumentsToXML(argumentArray,0)+"</invoke>"),returnValue=eval(returnString)}catch(ex){throw"Call to "+functionName+" failed"}return void 0!=returnValue&&"object"==typeof returnValue.post&&(returnValue=this.unescapeFilePostParams(returnValue)),returnValue},SWFUpload.prototype.selectFile=function(){this.callFlash("SelectFile")},SWFUpload.prototype.selectFiles=function(){this.callFlash("SelectFiles")},SWFUpload.prototype.startUpload=function(t){this.callFlash("StartUpload",[t])},SWFUpload.prototype.cancelUpload=function(t,e){e!==!1&&(e=!0),this.callFlash("CancelUpload",[t,e])},SWFUpload.prototype.stopUpload=function(){this.callFlash("StopUpload")},SWFUpload.prototype.getStats=function(){return this.callFlash("GetStats")},SWFUpload.prototype.setStats=function(t){this.callFlash("SetStats",[t])},SWFUpload.prototype.getFile=function(t){return"number"==typeof t?this.callFlash("GetFileByIndex",[t]):this.callFlash("GetFile",[t])},SWFUpload.prototype.addFileParam=function(t,e,i){return this.callFlash("AddFileParam",[t,e,i])},SWFUpload.prototype.removeFileParam=function(t,e){this.callFlash("RemoveFileParam",[t,e])},SWFUpload.prototype.setUploadURL=function(t){this.settings.upload_url=t.toString(),this.callFlash("SetUploadURL",[t])},SWFUpload.prototype.setPostParams=function(t){this.settings.post_params=t,this.callFlash("SetPostParams",[t])},SWFUpload.prototype.addPostParam=function(t,e){this.settings.post_params[t]=e,this.callFlash("SetPostParams",[this.settings.post_params])},SWFUpload.prototype.removePostParam=function(t){delete this.settings.post_params[t],this.callFlash("SetPostParams",[this.settings.post_params])},SWFUpload.prototype.setFileTypes=function(t,e){this.settings.file_types=t,this.settings.file_types_description=e,this.callFlash("SetFileTypes",[t,e])},SWFUpload.prototype.setFileSizeLimit=function(t){this.settings.file_size_limit=t,this.callFlash("SetFileSizeLimit",[t])},SWFUpload.prototype.setFileUploadLimit=function(t){this.settings.file_upload_limit=t,this.callFlash("SetFileUploadLimit",[t])},SWFUpload.prototype.setFileQueueLimit=function(t){this.settings.file_queue_limit=t,this.callFlash("SetFileQueueLimit",[t])},SWFUpload.prototype.setFilePostName=function(t){this.settings.file_post_name=t,this.callFlash("SetFilePostName",[t])},SWFUpload.prototype.setUseQueryString=function(t){this.settings.use_query_string=t,this.callFlash("SetUseQueryString",[t])},SWFUpload.prototype.setRequeueOnError=function(t){this.settings.requeue_on_error=t,this.callFlash("SetRequeueOnError",[t])},SWFUpload.prototype.setHTTPSuccess=function(t){"string"==typeof t&&(t=t.replace(" ","").split(",")),this.settings.http_success=t,this.callFlash("SetHTTPSuccess",[t])},SWFUpload.prototype.setAssumeSuccessTimeout=function(t){this.settings.assume_success_timeout=t,this.callFlash("SetAssumeSuccessTimeout",[t])},SWFUpload.prototype.setDebugEnabled=function(t){this.settings.debug_enabled=t,this.callFlash("SetDebugEnabled",[t])},SWFUpload.prototype.setButtonImageURL=function(t){void 0==t&&(t=""),this.settings.button_image_url=t,this.callFlash("SetButtonImageURL",[t])},SWFUpload.prototype.setButtonDimensions=function(t,e){this.settings.button_width=t,this.settings.button_height=e;var i=this.getMovieElement();void 0!=i&&(i.style.width=t+"px",i.style.height=e+"px"),this.callFlash("SetButtonDimensions",[t,e])},SWFUpload.prototype.setButtonText=function(t){this.settings.button_text=t,this.callFlash("SetButtonText",[t])},SWFUpload.prototype.setButtonTextPadding=function(t,e){this.settings.button_text_top_padding=e,this.settings.button_text_left_padding=t,this.callFlash("SetButtonTextPadding",[t,e])},SWFUpload.prototype.setButtonTextStyle=function(t){this.settings.button_text_style=t,this.callFlash("SetButtonTextStyle",[t])},SWFUpload.prototype.setButtonDisabled=function(t){this.settings.button_disabled=t,this.callFlash("SetButtonDisabled",[t])},SWFUpload.prototype.setButtonAction=function(t){this.settings.button_action=t,this.callFlash("SetButtonAction",[t])},SWFUpload.prototype.setButtonCursor=function(t){this.settings.button_cursor=t,this.callFlash("SetButtonCursor",[t])},SWFUpload.prototype.queueEvent=function(t,e){void 0==e?e=[]:e instanceof Array||(e=[e]);var i=this;if("function"==typeof this.settings[t])this.eventQueue.push(function(){this.settings[t].apply(this,e)}),setTimeout(function(){i.executeNextEvent()},0);else if(null!==this.settings[t])throw"Event handler "+t+" is unknown or is not a function"},SWFUpload.prototype.executeNextEvent=function(){var t=this.eventQueue?this.eventQueue.shift():null;"function"==typeof t&&t.apply(this)},SWFUpload.prototype.unescapeFilePostParams=function(t){var e,i=/[$]([0-9a-f]{4})/i,n={};if(void 0!=t){for(var s in t.post)if(t.post.hasOwnProperty(s)){e=s;for(var o;null!==(o=i.exec(e));)e=e.replace(o[0],String.fromCharCode(parseInt("0x"+o[1],16)));n[e]=t.post[s]}t.post=n}return t},SWFUpload.prototype.testExternalInterface=function(){try{return this.callFlash("TestExternalInterface")}catch(t){return!1}},SWFUpload.prototype.flashReady=function(){var t=this.getMovieElement();return t?(this.cleanUp(t),this.queueEvent("swfupload_loaded_handler"),void 0):(this.debug("Flash called back ready but the flash movie can't be found."),void 0)},SWFUpload.prototype.cleanUp=function(t){try{if(this.movieElement&&"unknown"==typeof t.CallFunction){this.debug("Removing Flash functions hooks (this should only run in IE and should prevent memory leaks)");for(var e in t)try{"function"==typeof t[e]&&(t[e]=null)}catch(i){}}}catch(n){}window.__flash__removeCallback=function(t,e){try{t&&(t[e]=null)}catch(i){}}},SWFUpload.prototype.fileDialogStart=function(){this.queueEvent("file_dialog_start_handler")},SWFUpload.prototype.fileQueued=function(t){t=this.unescapeFilePostParams(t),this.queueEvent("file_queued_handler",t)},SWFUpload.prototype.fileQueueError=function(t,e,i){t=this.unescapeFilePostParams(t),this.queueEvent("file_queue_error_handler",[t,e,i])},SWFUpload.prototype.fileDialogComplete=function(t,e,i){this.queueEvent("file_dialog_complete_handler",[t,e,i])},SWFUpload.prototype.uploadStart=function(t){t=this.unescapeFilePostParams(t),this.queueEvent("return_upload_start_handler",t)},SWFUpload.prototype.returnUploadStart=function(t){var e;if("function"==typeof this.settings.upload_start_handler)t=this.unescapeFilePostParams(t),e=this.settings.upload_start_handler.call(this,t);else if(void 0!=this.settings.upload_start_handler)throw"upload_start_handler must be a function";void 0===e&&(e=!0),e=!!e,this.callFlash("ReturnUploadStart",[e])},SWFUpload.prototype.uploadProgress=function(t,e,i){t=this.unescapeFilePostParams(t),this.queueEvent("upload_progress_handler",[t,e,i])},SWFUpload.prototype.uploadError=function(t,e,i){t=this.unescapeFilePostParams(t),this.queueEvent("upload_error_handler",[t,e,i])},SWFUpload.prototype.uploadSuccess=function(t,e,i){t=this.unescapeFilePostParams(t),this.queueEvent("upload_success_handler",[t,e,i])},SWFUpload.prototype.uploadComplete=function(t){t=this.unescapeFilePostParams(t),this.queueEvent("upload_complete_handler",t)},SWFUpload.prototype.debug=function(t){this.queueEvent("debug_handler",t)},SWFUpload.prototype.debugMessage=function(t){if(this.settings.debug){var e,i=[];if("object"==typeof t&&"string"==typeof t.name&&"string"==typeof t.message){for(var n in t)t.hasOwnProperty(n)&&i.push(n+": "+t[n]);e=i.join("\n")||"",i=e.split("\n"),e="EXCEPTION: "+i.join("\nEXCEPTION: "),SWFUpload.Console.writeLine(e)}else SWFUpload.Console.writeLine(t)}},SWFUpload.Console={},SWFUpload.Console.writeLine=function(t){var e,i;try{e=document.getElementById("SWFUpload_Console"),e||(i=document.createElement("form"),document.getElementsByTagName("body")[0].appendChild(i),e=document.createElement("textarea"),e.id="SWFUpload_Console",e.style.fontFamily="monospace",e.setAttribute("wrap","off"),e.wrap="off",e.style.overflow="auto",e.style.width="700px",e.style.height="350px",e.style.margin="5px",i.appendChild(e)),e.value+=t+"\n",e.scrollTop=e.scrollHeight-e.clientHeight}catch(n){alert("Exception: "+n.name+" Message: "+n.message)}},function(t){t.swfupload={settings:{},instances:{}},t.extend(t.swfupload,{load:function(t,e){this.settings[t]=e,this.settings[t].button_placeholder_id=t,this.instances[t]=new SWFUpload(this.settings[t])},reload:function(t){this.instances[t].destroy(),this.instances[t]=null,this.settings[t].button_action!=SWFUpload.BUTTON_ACTION.SELECT_FILE?this.multiple(t,this.settings[t]):this.load(t,this.settings[t])},multiple:function(e,i){var n={flash_url:"/assets/swfupload/swfupload.swf",file_size_limit:"5120",file_types:"*.jpg;*.jpeg;*.gif;*.png",file_types_description:"图片文件",file_queue_error_handler:function(i,n){n==SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED?alert("超过允许上传的文件数量，一次只能上传 "+this.settings.file_upload_limit+" 个文件"):n==SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT?t("#"+e.replace("_button","")).append(t('<div id="'+i.id+'" class="swfupload-error"><span>文件超过尺寸限制</span><a href="#ui_'+i.id+'" class="ui-action-close">取消</a></div>')):t("#"+e.replace("_button","")).append(t('<div id="'+i.id+'" class="swfupload-error"><span>文件上传错误</span><a href="#ui_'+i.id+'" class="ui-action-close">取消</a></div>')),t("#"+i.id).delay(3e3).fadeOut("slow")},file_dialog_complete_handler:function(){this.startUpload()},upload_start_handler:function(i){t("#"+e.replace("_button","")).append(t('<div id="'+i.id+'" class="swfupload-progress timeline-add-pic-preview"></div>'))},upload_progress_handler:function(e,i,n){t("#"+e.id).html(t("<div><span>上传中...<br>"+Math.ceil(99*(i/n))+"%</span></div>"))},upload_error_handler:function(e){this.startUpload(),t("#"+e.id).replaceWith(t('<div id="'+e.id+'" class="swfupload-error"><span>文件上传错误</span><a href="#ui_'+e.id+'" class="ui-action-close">取消</a></div>'))},upload_success_handler:function(e,i){t("#"+e.id).replaceWith(t(i))},upload_complete_handler:function(){this.startUpload()},button_image_url:"/assets/upload.gif",button_width:80,button_height:32,button_placeholder_id:e};this.settings[e]=t.extend(!0,{},n,i),this.instances[e]=new SWFUpload(this.settings[e])}})}(jQuery),function(){}.call(this);