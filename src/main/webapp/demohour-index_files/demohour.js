function cancel_queue(t) {
    t.stopUpload();
    var e;
    do e = t.getStats(),
    t.cancelUpload();
    while (0 !== e.files_queued)
}
function file_queue_error(t, e) {
    var i = "";
    e == SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED ? alert("超过允许上载的文件数量") : i = e == SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT ? $.ui_core.format(this.customSettings.error, t.id, t.name, "文件超过尺寸限制") : $.ui_core.format(this.customSettings.error, t.id, t.name, "文件上传错误"),
    this.settings.button_action == SWFUpload.BUTTON_ACTION.SELECT_FILE ? $(this.settings.button_placeholder_id.replace("button_", "#")).html($(i)) : $(this.settings.button_placeholder_id.replace("button_", "#")).append($(i)),
    $("#" + t.id).delay(3e3).fadeOut("slow")
}
function file_dialog_complete() {
    this.startUpload()
}
function upload_start(t) {
    var e = $.ui_core.format(this.customSettings.progress, t.id, t.name, t.id, t.id);
    this.settings.button_action == SWFUpload.BUTTON_ACTION.SELECT_FILE ? $(this.settings.button_placeholder_id.replace("button_", "#")).html($(e)) : $(this.settings.button_placeholder_id.replace("button_", "#")).append($(e))
}
function upload_progress(t, e, i) {
    var n = Math.ceil(99 * (e / i));
    $("#" + t.id + "_progressinner").css("width", n + "%"),
    $("#" + t.id + "_progressinner").html(n + "%")
}
function upload_error(t, e) {
    if (e == SWFUpload.UPLOAD_ERROR.FILE_CANCELLED) $("#" + t.id).remove();
    else {
        var i = $.ui_core.format(this.customSettings.error, t.id, t.name, "文件上传错误");
        $("#" + t.id).replaceWith($(i))
    }
}
function upload_success(t, e) {
    $("#" + t.id).replaceWith($(e))
}
function upload_complete() {
    this.startUpload()
}
function getListener(t, e, i) {
    var n;
    return e = e.toLowerCase(),
    (n = t.__allListeners || i && (t.__allListeners = {})) && (n[e] || i && (n[e] = []))
}
function getDomNode(t, e, i, n, s, o) {
    var a,
    r = n && t[e];
    for (!r && (r = t[i]); ! r && (a = (a || t).parentNode);) {
        if ("BODY" == a.tagName || o && !o(a)) return null;
        r = a[i]
    }
    return r && s && !s(r) ? getDomNode(r, e, i, !1, s) : r
} ! 
function(t) {
    t.fn.slides = function(e) {
        return e = t.extend({},
        t.fn.slides.option, e),
        this.each(function() {
            function i(i, n, s) {
                if (!a && o) {
                    switch (a = !0, e.animationStart(x + 1), i) {
                    case "next":
                        w = x,
                        _ = x + 1,
                        _ = f === _ ? 0: _,
                        l = 2 * m,
                        i = 2 * -m,
                        x = _;
                        break;
                    case "prev":
                        w = x,
                        _ = x - 1,
                        _ = -1 === _ ? f - 1: _,
                        l = 0,
                        i = 0,
                        x = _;
                        break;
                    case "pagination":
                        _ = parseInt(s, 10),
                        w = t("." + e.paginationClass + " li." + e.currentClass + " a", h).attr("href").match("[^#/]+$"),
                        _ > w ? (l = 2 * m, i = 2 * -m) : (l = 0, i = 0),
                        x = _
                    }
                    "fade" === n ? e.crossfade ? p.children(":eq(" + _ + ")", h).css({
                        zIndex: 10
                    }).fadeIn(e.fadeSpeed, e.fadeEasing, 
                    function() {
                        e.autoHeight ? p.animate({
                            height: p.children(":eq(" + _ + ")", h).outerHeight()
                        },
                        e.autoHeightSpeed, 
                        function() {
                            p.children(":eq(" + w + ")", h).css({
                                display: "none",
                                zIndex: 0
                            }),
                            p.children(":eq(" + _ + ")", h).css({
                                zIndex: 0
                            }),
                            e.animationComplete(_ + 1),
                            a = !1
                        }) : (p.children(":eq(" + w + ")", h).css({
                            display: "none",
                            zIndex: 0
                        }), p.children(":eq(" + _ + ")", h).css({
                            zIndex: 0
                        }), e.animationComplete(_ + 1), a = !1)
                    }) : p.children(":eq(" + w + ")", h).fadeOut(e.fadeSpeed, e.fadeEasing, 
                    function() {
                        e.autoHeight ? p.animate({
                            height: p.children(":eq(" + _ + ")", h).outerHeight()
                        },
                        e.autoHeightSpeed, 
                        function() {
                            p.children(":eq(" + _ + ")", h).fadeIn(e.fadeSpeed, e.fadeEasing)
                        }) : p.children(":eq(" + _ + ")", h).fadeIn(e.fadeSpeed, e.fadeEasing, 
                        function() {
                            t.browser.msie && t(this).get(0).style.removeAttribute("filter")
                        }),
                        e.animationComplete(_ + 1),
                        a = !1
                    }) : (p.children(":eq(" + _ + ")").css({
                        left: l,
                        display: "block"
                    }), e.autoHeight ? p.animate({
                        left: i,
                        height: p.children(":eq(" + _ + ")").outerHeight()
                    },
                    e.slideSpeed, e.slideEasing, 
                    function() {
                        p.css({
                            left: -m
                        }),
                        p.children(":eq(" + _ + ")").css({
                            left: m,
                            zIndex: 5
                        }),
                        p.children(":eq(" + w + ")").css({
                            left: m,
                            display: "none",
                            zIndex: 0
                        }),
                        e.animationComplete(_ + 1),
                        a = !1
                    }) : p.animate({
                        left: i
                    },
                    e.slideSpeed, e.slideEasing, 
                    function() {
                        p.css({
                            left: -m
                        }),
                        p.children(":eq(" + _ + ")").css({
                            left: m,
                            zIndex: 5
                        }),
                        p.children(":eq(" + w + ")").css({
                            left: m,
                            display: "none",
                            zIndex: 0
                        }),
                        e.animationComplete(_ + 1),
                        a = !1
                    })),
                    e.pagination && (t("." + e.paginationClass + " li." + e.currentClass, h).removeClass(e.currentClass), t("." + e.paginationClass + " li:eq(" + _ + ")", h).addClass(e.currentClass))
                }
            }
            function n() {
                clearInterval(h.data("interval"))
            }
            function s() {
                e.pause ? (clearTimeout(h.data("pause")), clearInterval(h.data("interval")), d = setTimeout(function() {
                    clearTimeout(h.data("pause")),
                    c = setInterval(function() {
                        i("next", b)
                    },
                    e.play),
                    h.data("interval", c)
                },
                e.pause), h.data("pause", d)) : n()
            }
            t("." + e.container, t(this)).children().wrapAll('<div class="slides_control"/>');
            var o,
            a,
            r,
            l,
            u,
            d,
            c,
            h = t(this),
            p = t(".slides_control", h),
            f = p.children().size(),
            m = p.children().outerWidth(),
            g = p.children().outerHeight(),
            v = e.start - 1,
            b = e.effect.indexOf(",") < 0 ? e.effect: e.effect.replace(" ", "").split(",")[0],
            y = e.effect.indexOf(",") < 0 ? b: e.effect.replace(" ", "").split(",")[1],
            _ = 0,
            w = 0,
            S = 0,
            x = 0;
            if (2 > f) return t("." + e.container, t(this)).fadeIn(e.fadeSpeed, e.fadeEasing, 
            function() {
                o = !0,
                e.slidesLoaded()
            }),
            t("." + e.next + ", ." + e.prev).fadeOut(0),
            !1;
            if (! (2 > f)) {
                if (0 > v && (v = 0), v > f && (v = f - 1), e.start && (x = v), e.randomize && p.randomize(), t("." + e.container, h).css({
                    overflow: "hidden",
                    position: "relative"
                }), p.children().css({
                    position: "absolute",
                    top: 0,
                    left: p.children().outerWidth(),
                    zIndex: 0,
                    display: "none"
                }), p.css({
                    position: "relative",
                    width: 3 * m,
                    height: g,
                    left: -m
                }), t("." + e.container, h).css({
                    display: "block"
                }), e.autoHeight && (p.children().css({
                    height: "auto"
                }), p.animate({
                    height: p.children(":eq(" + v + ")").outerHeight()
                },
                e.autoHeightSpeed)), e.preload && p.find("img:eq(" + v + ")").length) {
                    t("." + e.container, h).css({
                        background: "url(" + e.preloadImage + ") no-repeat 50% 50%"
                    });
                    var C = p.find("img:eq(" + v + ")").attr("src") + "?" + (new Date).getTime();
                    u = "slides_control" != t("img", h).parent().attr("class") ? p.children(":eq(0)")[0].tagName.toLowerCase() : p.find("img:eq(" + v + ")"),
                    p.find("img:eq(" + v + ")").attr("src", C).load(function() {
                        p.find(u + ":eq(" + v + ")").fadeIn(e.fadeSpeed, e.fadeEasing, 
                        function() {
                            t(this).css({
                                zIndex: 5
                            }),
                            t("." + e.container, h).css({
                                background: ""
                            }),
                            o = !0,
                            e.slidesLoaded()
                        })
                    })
                } else p.children(":eq(" + v + ")").fadeIn(e.fadeSpeed, e.fadeEasing, 
                function() {
                    o = !0,
                    e.slidesLoaded()
                });
                e.bigTarget && (p.children().css({
                    cursor: "pointer"
                }), p.children().click(function() {
                    return i("next", b),
                    !1
                })),
                e.hoverPause && e.play && (p.bind("mouseover", 
                function() {
                    n()
                }), p.bind("mouseleave", 
                function() {
                    s()
                })),
                e.generateNextPrev && (t("." + e.container, h).after('<a href="#" class="' + e.prev + '">Prev</a>'), t("." + e.prev, h).after('<a href="#" class="' + e.next + '">Next</a>')),
                t("." + e.next, h).click(function(t) {
                    t.preventDefault(),
                    e.play && s(),
                    i("next", b)
                }),
                t("." + e.prev, h).click(function(t) {
                    t.preventDefault(),
                    e.play && s(),
                    i("prev", b)
                }),
                e.generatePagination ? (e.prependPagination ? h.prepend('<div class="slidebarpagination"><ul class=' + e.paginationClass + "></ul></div>") : h.append('<div class="slidebarpagination"><ul class=' + e.paginationClass + "></ul></div>"), p.children().each(function() {
                    t("." + e.paginationClass, h).append('<li><a href="#' + S + '">' + (S + 1) + "</a></li>"),
                    S++
                })) : t("." + e.paginationClass + " li a", h).each(function() {
                    t(this).attr("href", "#" + S),
                    S++
                }),
                t("." + e.paginationClass + " li:eq(" + v + ")", h).addClass(e.currentClass),
                t("." + e.paginationClass + " li a", h).click(function() {
                    return e.play && s(),
                    r = t(this).attr("href").match("[^#/]+$"),
                    x != r && i("pagination", y, r),
                    !1
                }),
                t("a.link", h).click(function() {
                    return e.play && s(),
                    r = t(this).attr("href").match("[^#/]+$") - 1,
                    x != r && i("pagination", y, r),
                    !1
                }),
                e.play && (c = setInterval(function() {
                    i("next", b)
                },
                e.play), h.data("interval", c))
            }
        })
    },
    t.fn.slides.option = {
        preload: !1,
        preloadImage: "/images/indicator.gif",
        container: "slides_container",
        generateNextPrev: !1,
        next: "next",
        prev: "prev",
        pagination: !0,
        generatePagination: !0,
        prependPagination: !1,
        paginationClass: "pagination",
        currentClass: "current",
        fadeSpeed: 350,
        fadeEasing: "",
        slideSpeed: 350,
        slideEasing: "",
        start: 1,
        effect: "slide",
        crossfade: !1,
        randomize: !1,
        play: 0,
        pause: 0,
        hoverPause: !1,
        autoHeight: !1,
        autoHeightSpeed: 350,
        bigTarget: !1,
        animationStart: function() {},
        animationComplete: function() {},
        slidesLoaded: function() {}
    },
    t.fn.randomize = function(e) {
        function n() {
            return Math.round(Math.random()) - .5
        }
        return t(this).each(function() {
            var s = t(this),
            o = s.children(),
            a = o.length;
            if (a > 1) {
                o.hide();
                var r = [];
                for (i = 0; a > i; i++) r[r.length] = i;
                r = r.sort(n),
                t.each(r, 
                function(t, i) {
                    var n = o.eq(i),
                    a = n.clone(!0);
                    a.show().appendTo(s),
                    void 0 !== e && e(n, a),
                    n.remove()
                })
            }
        })
    }
} (jQuery),
function(t) {
    t.extend(t.fn, {
        cascade: function(e) {
            return new t.cascade(this, e)
        }
    }),
    t.cascade = function(t, e) {
        return this.elements = t,
        this.options = e || {},
        this.selectOption(this.options.defaults || []),
        this.ready(),
        this
    },
    t.extend(t.cascade, {
        options: {},
        prototype: {
            selectOption: function(e, n) {
                var s = (n || "0").split(".").length - 1;
                this.elements[s].length = 0,
                this.options.prompts && this.options.prompts[s] && this.elements[s].options.add(new Option(this.options.prompts[s], ""));
                for (i in t.cascade.options[n || "0"] || []) {
                    var o = t.cascade.options[n || "0"][i],
                    a = new Option(o, o);
                    e[s] && o == e[s] && (a.selected = !0),
                    this.elements[s].options.add(a)
                }
                s < this.elements.length - 1 && this.selectOption(e, (n || "0") + "." + (this.elements[s].selectedIndex - 1))
            },
            ready: function() {
                for (var e = this, i = [], n = 0; n < this.elements.length - 1; n++) t("body").on("change", t(this.elements[n]), 
                function(n) {
                    for (t("#" + n.target.id + "_error").html(""), j = 0; j < e.elements.length; j++) i[j] = t(e.elements[j]).val();
                    e.selectOption(i)
                })
            }
        }
    })
} (jQuery),
$.cascade.options = {.32: ["花地玛堂区", "圣安多尼堂区", "大堂区", "望德堂区", "风顺堂区", "氹仔", "路环", "其他"],
    .21: ["银川", "石嘴山", "吴忠", "固原", "中卫"],
    "0.10": ["贵阳", "六盘水", "遵义", "安顺", "铜仁", "黔西南", "毕节", "黔东南", "黔南"],
    .4: ["南京", "无锡", "徐州", "常州", "苏州", "南通", "连云港", "淮安", "宿迁", "盐城", "扬州", "镇江", "泰州"],
    .33: ["新北市", "台北市", "高雄市", "基隆市", "台中市", "台南市", "新竹市", "嘉义市", "台北县", "宜兰县", "桃园县", "新竹县", "苗栗县", "台中县", "彰化县", "南投县", "云林县", "嘉义县", "台南县", "高雄县", "屏东县", "澎湖县", "台东县", "花莲县", "其他"],
    .22: ["西宁", "海东", "海北", "黄南", "海南", "果洛", "玉树", "海西"],
    .11: ["海口", "三亚", "五指山", "琼海", "儋州", "文昌", "万宁", "东方", "定安", "屯昌", "澄迈", "临高", "白沙", "昌江", "乐东", "陵水", "保亭", "琼中", "西沙", "南沙", "中沙"],
    .5: ["合肥", "芜湖", "蚌埠", "淮南", "淮北", "马鞍山", "铜陵", "安庆", "黄山", "滁州", "阜阳", "宿州", "巢湖", "六安", "亳州", "池州", "宣城"],
    .34: ["美国", "英国", "法国", "俄罗斯", "加拿大", "巴西", "澳大利亚", "印尼", "泰国", "马来西亚", "新加坡", "菲律宾", "越南", "印度", "日本", "新西兰", "韩国", "德国", "意大利", "爱尔兰", "荷兰", "瑞士", "乌克兰", "南非", "芬兰", "瑞典", "奥地利", "西班牙", "比利时", "挪威", "丹麦", "波兰", "阿根廷", "白俄罗斯", "哥伦比亚", "古巴", "埃及", "希腊", "匈牙利", "伊朗", "蒙古", "墨西哥", "葡萄牙", "沙特阿拉伯", "土耳其", "其他"],
    .23: ["济南", "青岛", "淄博", "枣庄", "东营", "烟台", "潍坊", "济宁", "泰安", "威海", "日照", "莱芜", "临沂", "德州", "聊城", "滨州", "菏泽"],
    .12: ["石家庄", "唐山", "秦皇岛", "邯郸", "邢台", "保定", "张家口", "承德", "沧州", "廊坊", "衡水"],
    .6: ["万州区", "涪陵区", "渝中区", "大渡口区", "江北区", "沙坪坝区", "九龙坡区", "南岸区", "北碚区", "万盛区", "双桥区", "渝北区", "巴南区", "黔江区", "长寿区", "綦江县", "潼南县", "铜梁县", "大足县", "荣昌县", "璧山县", "梁平县", "城口县", "丰都县", "垫江县", "武隆县", "忠县", "开县", "云阳县", "奉节县", "巫山县", "巫溪县", "石柱土家族自治县", "秀山土家族苗族自治县", "酉阳土家族苗族自治县", "彭水苗族土家族自治县", "江津区", "合川区", "永川区", "南川区"],
    .7: ["福州", "厦门", "莆田", "三明", "泉州", "漳州", "南平", "龙岩", "宁德"],
    .24: ["太原", "大同", "阳泉", "长治", "晋城", "朔州", "晋中", "运城", "忻州", "临汾", "吕梁"],
    .13: ["郑州", "开封", "洛阳", "平顶山", "安阳", "鹤壁", "新乡", "焦作", "濮阳", "许昌", "漯河", "三门峡", "南阳", "商丘", "信阳", "周口", "驻马店", "济源"],
    .8: ["兰州", "嘉峪关", "金昌", "白银", "天水", "武威", "张掖", "平凉", "酒泉", "庆阳", "定西", "陇南", "临夏", "甘南"],
    .25: ["西安", "铜川", "宝鸡", "咸阳", "渭南", "延安", "汉中", "榆林", "安康", "商洛"],
    .14: ["哈尔滨", "齐齐哈尔", "鸡西", "鹤岗", "双鸭山", "大庆", "伊春", "佳木斯", "七台河", "牡丹江", "黑河", "绥化", "大兴安岭"],
    .9: ["南宁", "柳州", "桂林", "梧州", "北海", "防城港", "钦州", "贵港", "玉林", "百色", "贺州", "河池", "来宾", "崇左"],
    0: ["北京", "上海", "广东", "浙江", "江苏", "安徽", "重庆", "福建", "甘肃", "广西", "贵州", "海南", "河北", "河南", "黑龙江", "湖北", "湖南", "吉林", "江西", "辽宁", "内蒙古", "宁夏", "青海", "山东", "山西", "陕西", "四川", "天津", "西藏", "新疆", "云南", "香港", "澳门", "台湾", "海外"],
    .26: ["成都", "自贡", "攀枝花", "泸州", "德阳", "绵阳", "广元", "遂宁", "内江", "乐山", "南充", "眉山", "宜宾", "广安", "达州", "雅安", "巴中", "资阳", "阿坝", "甘孜", "凉山"],
    .15: ["武汉", "黄石", "十堰", "宜昌", "襄阳", "鄂州", "荆门", "孝感", "荆州", "黄冈", "咸宁", "随州", "恩施土家族自治州", "仙桃", "潜江", "天门", "神农架"],
    .27: ["和平区", "河东区", "河西区", "南开区", "河北区", "红桥区", "塘沽区", "汉沽区", "大港区", "东丽区", "西青区", "津南区", "北辰区", "武清区", "宝坻区", "宁河县", "静海县", "蓟县", "滨海新区", "保税区"],
    .16: ["长沙", "株洲", "湘潭", "衡阳", "邵阳", "岳阳", "常德", "张家界", "益阳", "郴州", "永州", "怀化", "娄底", "湘西土家族苗族自治区"],
    "0.0": ["东城区", "西城区", "朝阳区", "丰台区", "石景山区", "海淀区", "门头沟区", "房山区", "通州区", "顺义区", "昌平区", "大兴区", "怀柔区", "平谷区", "密云县", "延庆县"],
    .28: ["拉萨", "昌都", "山南", "日喀则", "那曲", "阿里", "林芝"],
    .17: ["长春", "吉林", "四平", "辽源", "通化", "白山", "松原", "白城", "延边朝鲜族自治州"],
    .1: ["黄浦区", "卢湾区", "徐汇区", "长宁区", "静安区", "普陀区", "闸北区", "虹口区", "杨浦区", "闵行区", "宝山区", "嘉定区", "浦东新区", "金山区", "松江区", "青浦区", "南汇区", "奉贤区", "崇明县"],
    "0.30": ["昆明", "曲靖", "玉溪", "保山", "昭通", "丽江", "思茅", "临沧", "楚雄", "红河", "文山", "西双版纳", "大理", "德宏", "怒江", "迪庆"],
    .29: ["乌鲁木齐", "克拉玛依", "吐鲁番", "哈密", "昌吉", "博尔塔拉", "巴音郭楞", "阿克苏", "克孜勒苏", "喀什", "和田", "伊犁", "塔城", "阿勒泰", "石河子", "阿拉尔", "图木舒克", "五家渠"],
    .18: ["南昌", "景德镇", "萍乡", "九江", "新余", "鹰潭", "赣州", "吉安", "宜春", "抚州", "上饶"],
    .2: ["广州", "韶关", "深圳", "珠海", "汕头", "佛山", "江门", "湛江", "茂名", "肇庆", "惠州", "梅州", "汕尾", "河源", "阳江", "清远", "东莞", "中山", "潮州", "揭阳", "云浮"],
    .31: ["中西区", "港仔区", "东区", "南区", "九龙城区", "油尖旺区", "深水埗区", "黄大仙区", "观塘区", "北区", "大埔区", "沙田区", "西贡区", "元朗区", "屯门区", "荃湾区", "葵青区", "离岛区"],
    "0.20": ["呼和浩特", "包头", "乌海", "赤峰", "通辽", "鄂尔多斯", "呼伦贝尔", "巴彦淖尔盟", "乌兰察布盟", "兴安盟", "锡林郭勒盟", "阿拉善盟"],
    .19: ["沈阳", "大连", "鞍山", "抚顺", "本溪", "丹东", "锦州", "营口", "阜新", "辽阳", "盘锦", "铁岭", "朝阳", "葫芦岛"],
    .3: ["杭州", "宁波", "温州", "嘉兴", "湖州", "绍兴", "金华", "衢州", "舟山", "台州", "丽水"]
};
var SWFUpload;
"function" == typeof SWFUpload && (
SWFUpload.queue = {},
SWFUpload.prototype.initSettings = function(t) {
    return function() {
        "function" == typeof t && t.call(this),
        this.queueSettings = {},
        this.queueSettings.queue_cancelled_flag = !1,
        this.queueSettings.queue_upload_count = 0,
        this.queueSettings.user_upload_complete_handler = this.settings.upload_complete_handler,
        this.queueSettings.user_upload_start_handler = this.settings.upload_start_handler,
        this.settings.upload_complete_handler = SWFUpload.queue.uploadCompleteHandler,
        this.settings.upload_start_handler = SWFUpload.queue.uploadStartHandler,
        this.settings.queue_complete_handler = this.settings.queue_complete_handler || null
    }
} (SWFUpload.prototype.initSettings), 
SWFUpload.prototype.startUpload = function(t) {
    this.queueSettings.queue_cancelled_flag = !1,
    this.callFlash("StartUpload", [t])
},
SWFUpload.prototype.cancelQueue = function() {
    this.queueSettings.queue_cancelled_flag = !0,
    this.stopUpload();
    for (var t = this.getStats(); t.files_queued > 0;) this.cancelUpload(),
    t = this.getStats()
},
SWFUpload.queue.uploadStartHandler = function(t) {
    var e;
    return "function" == typeof this.queueSettings.user_upload_start_handler && (e = this.queueSettings.user_upload_start_handler.call(this, t)),
    e = e === !1 ? !1: !0,
    this.queueSettings.queue_cancelled_flag = !e,
    e
},
SWFUpload.queue.uploadCompleteHandler = function(t) {
    var e,
    i = this.queueSettings.user_upload_complete_handler;
    if (t.filestatus === SWFUpload.FILE_STATUS.COMPLETE && this.queueSettings.queue_upload_count++, e = "function" == typeof i ? i.call(this, t) === !1 ? !1: !0: t.filestatus === SWFUpload.FILE_STATUS.QUEUED ? !1: !0) {
        var n = this.getStats();
        n.files_queued > 0 && this.queueSettings.queue_cancelled_flag === !1 ? this.startUpload() : this.queueSettings.queue_cancelled_flag === !1 ? (this.queueEvent("queue_complete_handler", [this.queueSettings.queue_upload_count]), this.queueSettings.queue_upload_count = 0) : (this.queueSettings.queue_cancelled_flag = !1, this.queueSettings.queue_upload_count = 0)
    }
}
);
/*swfupload.js*/
var SWFUpload;
void 0 == SWFUpload && (SWFUpload = function(t) {
    this.initSWFUpload(t)
}),
SWFUpload.prototype.initSWFUpload = function(t) {
    try {
        this.customSettings = {},
        this.settings = t,
        this.eventQueue = [],
        this.movieName = "SWFUpload_" + SWFUpload.movieCount++,
        this.movieElement = null,
        SWFUpload.instances[this.movieName] = this,
        this.initSettings(),
        this.loadFlash(),
        this.displayDebugInfo()
    } catch(e) {
        throw delete SWFUpload.instances[this.movieName],
        e
    }
},
SWFUpload.instances = {},
SWFUpload.movieCount = 0,
SWFUpload.version = "2.2.0 2009-03-25",
SWFUpload.QUEUE_ERROR = {
    QUEUE_LIMIT_EXCEEDED: -100,
    FILE_EXCEEDS_SIZE_LIMIT: -110,
    ZERO_BYTE_FILE: -120,
    INVALID_FILETYPE: -130
},
SWFUpload.UPLOAD_ERROR = {
    HTTP_ERROR: -200,
    MISSING_UPLOAD_URL: -210,
    IO_ERROR: -220,
    SECURITY_ERROR: -230,
    UPLOAD_LIMIT_EXCEEDED: -240,
    UPLOAD_FAILED: -250,
    SPECIFIED_FILE_ID_NOT_FOUND: -260,
    FILE_VALIDATION_FAILED: -270,
    FILE_CANCELLED: -280,
    UPLOAD_STOPPED: -290
},
SWFUpload.FILE_STATUS = {
    QUEUED: -1,
    IN_PROGRESS: -2,
    ERROR: -3,
    COMPLETE: -4,
    CANCELLED: -5
},
SWFUpload.BUTTON_ACTION = {
    SELECT_FILE: -100,
    SELECT_FILES: -110,
    START_UPLOAD: -120
},
SWFUpload.CURSOR = {
    ARROW: -1,
    HAND: -2
},
SWFUpload.WINDOW_MODE = {
    WINDOW: "window",
    TRANSPARENT: "transparent",
    OPAQUE: "opaque"
},
SWFUpload.completeURL = function(t) {
    if ("string" != typeof t || t.match(/^https?:\/\//i) || t.match(/^\//)) return t;
    window.location.protocol + "//" + window.location.hostname + (window.location.port ? ":" + window.location.port: "");
    var e = window.location.pathname.lastIndexOf("/");
    return path = 0 >= e ? "/": window.location.pathname.substr(0, e) + "/",
    path + t
},
SWFUpload.prototype.initSettings = function() {
    this.ensureDefault = function(t, e) {
        this.settings[t] = void 0 == this.settings[t] ? e: this.settings[t]
    },
    this.ensureDefault("upload_url", ""),
    this.ensureDefault("preserve_relative_urls", !1),
    this.ensureDefault("file_post_name", "Filedata"),
    this.ensureDefault("post_params", {}),
    this.ensureDefault("use_query_string", !1),
    this.ensureDefault("requeue_on_error", !1),
    this.ensureDefault("http_success", []),
    this.ensureDefault("assume_success_timeout", 0),
    this.ensureDefault("file_types", "*.*"),
    this.ensureDefault("file_types_description", "All Files"),
    this.ensureDefault("file_size_limit", 0),
    this.ensureDefault("file_upload_limit", 0),
    this.ensureDefault("file_queue_limit", 0),
    this.ensureDefault("flash_url", "swfupload.swf"),
    this.ensureDefault("prevent_swf_caching", !0),
    this.ensureDefault("button_image_url", ""),
    this.ensureDefault("button_width", 1),
    this.ensureDefault("button_height", 1),
    this.ensureDefault("button_text", ""),
    this.ensureDefault("button_text_style", "color: #000000; font-size: 16pt;"),
    this.ensureDefault("button_text_top_padding", 0),
    this.ensureDefault("button_text_left_padding", 0),
    this.ensureDefault("button_action", SWFUpload.BUTTON_ACTION.SELECT_FILES),
    this.ensureDefault("button_disabled", !1),
    this.ensureDefault("button_placeholder_id", ""),
    this.ensureDefault("button_placeholder", null),
    this.ensureDefault("button_cursor", SWFUpload.CURSOR.ARROW),
    this.ensureDefault("button_window_mode", SWFUpload.WINDOW_MODE.WINDOW),
    this.ensureDefault("debug", !1),
    this.settings.debug_enabled = this.settings.debug,
    this.settings.return_upload_start_handler = this.returnUploadStart,
    this.ensureDefault("swfupload_loaded_handler", null),
    this.ensureDefault("file_dialog_start_handler", null),
    this.ensureDefault("file_queued_handler", null),
    this.ensureDefault("file_queue_error_handler", null),
    this.ensureDefault("file_dialog_complete_handler", null),
    this.ensureDefault("upload_start_handler", null),
    this.ensureDefault("upload_progress_handler", null),
    this.ensureDefault("upload_error_handler", null),
    this.ensureDefault("upload_success_handler", null),
    this.ensureDefault("upload_complete_handler", null),
    this.ensureDefault("debug_handler", this.debugMessage),
    this.ensureDefault("custom_settings", {}),
    this.customSettings = this.settings.custom_settings,
    this.settings.prevent_swf_caching && (this.settings.flash_url = this.settings.flash_url + (this.settings.flash_url.indexOf("?") < 0 ? "?": "&") + "preventswfcaching=" + (new Date).getTime()),
    this.settings.preserve_relative_urls || (this.settings.upload_url = SWFUpload.completeURL(this.settings.upload_url), this.settings.button_image_url = SWFUpload.completeURL(this.settings.button_image_url)),
    delete this.ensureDefault
},
SWFUpload.prototype.loadFlash = function() {
    var t,
    e;
    if (null !== document.getElementById(this.movieName)) throw "ID " + this.movieName + " is already in use. The Flash Object could not be added";
    if (t = document.getElementById(this.settings.button_placeholder_id) || this.settings.button_placeholder, void 0 == t) throw "Could not find the placeholder element: " + this.settings.button_placeholder_id;
    e = document.createElement("div"),
    e.innerHTML = this.getFlashHTML(),
    t.parentNode.replaceChild(e.firstChild, t),
    void 0 == window[this.movieName] && (window[this.movieName] = this.getMovieElement())
},
SWFUpload.prototype.getFlashHTML = function() {
    return ['<object id="', this.movieName, '" type="application/x-shockwave-flash" data="', this.settings.flash_url, '" width="', this.settings.button_width, '" height="', this.settings.button_height, '" class="swfupload">', '<param name="wmode" value="', this.settings.button_window_mode, '" />', '<param name="movie" value="', this.settings.flash_url, '" />', '<param name="quality" value="high" />', '<param name="menu" value="false" />', '<param name="allowScriptAccess" value="always" />', '<param name="wmode" value="transparent" />', '<param name="flashvars" value="' + this.getFlashVars() + '" />', "</object>"].join("")
},
SWFUpload.prototype.getFlashVars = function() {
    var t = this.buildParamString(),
    e = this.settings.http_success.join(",");
    return ["movieName=", encodeURIComponent(this.movieName), "&amp;uploadURL=", encodeURIComponent(this.settings.upload_url), "&amp;useQueryString=", encodeURIComponent(this.settings.use_query_string), "&amp;requeueOnError=", encodeURIComponent(this.settings.requeue_on_error), "&amp;httpSuccess=", encodeURIComponent(e), "&amp;assumeSuccessTimeout=", encodeURIComponent(this.settings.assume_success_timeout), "&amp;params=", encodeURIComponent(t), "&amp;filePostName=", encodeURIComponent(this.settings.file_post_name), "&amp;fileTypes=", encodeURIComponent(this.settings.file_types), "&amp;fileTypesDescription=", encodeURIComponent(this.settings.file_types_description), "&amp;fileSizeLimit=", encodeURIComponent(this.settings.file_size_limit), "&amp;fileUploadLimit=", encodeURIComponent(this.settings.file_upload_limit), "&amp;fileQueueLimit=", encodeURIComponent(this.settings.file_queue_limit), "&amp;debugEnabled=", encodeURIComponent(this.settings.debug_enabled), "&amp;buttonImageURL=", encodeURIComponent(this.settings.button_image_url), "&amp;buttonWidth=", encodeURIComponent(this.settings.button_width), "&amp;buttonHeight=", encodeURIComponent(this.settings.button_height), "&amp;buttonText=", encodeURIComponent(this.settings.button_text), "&amp;buttonTextTopPadding=", encodeURIComponent(this.settings.button_text_top_padding), "&amp;buttonTextLeftPadding=", encodeURIComponent(this.settings.button_text_left_padding), "&amp;buttonTextStyle=", encodeURIComponent(this.settings.button_text_style), "&amp;buttonAction=", encodeURIComponent(this.settings.button_action), "&amp;buttonDisabled=", encodeURIComponent(this.settings.button_disabled), "&amp;buttonCursor=", encodeURIComponent(this.settings.button_cursor)].join("")
},
SWFUpload.prototype.getMovieElement = function() {
    if (void 0 == this.movieElement && (this.movieElement = document.getElementById(this.movieName)), null === this.movieElement) throw "Could not find Flash element";
    return this.movieElement
},
SWFUpload.prototype.buildParamString = function() {
    var t = this.settings.post_params,
    e = [];
    if ("object" == typeof t) for (var i in t) t.hasOwnProperty(i) && e.push(encodeURIComponent(i.toString()) + "=" + encodeURIComponent(t[i].toString()));
    return e.join("&amp;")
},
SWFUpload.prototype.destroy = function() {
    try {
        this.cancelUpload(null, !1);
        var t = null;
        if (t = this.getMovieElement(), t && "unknown" == typeof t.CallFunction) {
            for (var e in t) try {
                "function" == typeof t[e] && (t[e] = null)
            } catch(i) {}
            try {
                t.parentNode.removeChild(t)
            } catch(n) {}
        }
        return window[this.movieName] = null,
        SWFUpload.instances[this.movieName] = null,
        delete SWFUpload.instances[this.movieName],
        this.movieElement = null,
        this.settings = null,
        this.customSettings = null,
        this.eventQueue = null,
        this.movieName = null,
        !0
    } catch(s) {
        return ! 1
    }
},
SWFUpload.prototype.displayDebugInfo = function() {
    this.debug(["---SWFUpload Instance Info---\n", "Version: ", SWFUpload.version, "\n", "Movie Name: ", this.movieName, "\n", "Settings:\n", "	", "upload_url:               ", this.settings.upload_url, "\n", "	", "flash_url:                ", this.settings.flash_url, "\n", "	", "use_query_string:         ", this.settings.use_query_string.toString(), "\n", "	", "requeue_on_error:         ", this.settings.requeue_on_error.toString(), "\n", "	", "http_success:             ", this.settings.http_success.join(", "), "\n", "	", "assume_success_timeout:   ", this.settings.assume_success_timeout, "\n", "	", "file_post_name:           ", this.settings.file_post_name, "\n", "	", "post_params:              ", this.settings.post_params.toString(), "\n", "	", "file_types:               ", this.settings.file_types, "\n", "	", "file_types_description:   ", this.settings.file_types_description, "\n", "	", "file_size_limit:          ", this.settings.file_size_limit, "\n", "	", "file_upload_limit:        ", this.settings.file_upload_limit, "\n", "	", "file_queue_limit:         ", this.settings.file_queue_limit, "\n", "	", "debug:                    ", this.settings.debug.toString(), "\n", "	", "prevent_swf_caching:      ", this.settings.prevent_swf_caching.toString(), "\n", "	", "button_placeholder_id:    ", this.settings.button_placeholder_id.toString(), "\n", "	", "button_placeholder:       ", this.settings.button_placeholder ? "Set": "Not Set", "\n", "	", "button_image_url:         ", this.settings.button_image_url.toString(), "\n", "	", "button_width:             ", this.settings.button_width.toString(), "\n", "	", "button_height:            ", this.settings.button_height.toString(), "\n", "	", "button_text:              ", this.settings.button_text.toString(), "\n", "	", "button_text_style:        ", this.settings.button_text_style.toString(), "\n", "	", "button_text_top_padding:  ", this.settings.button_text_top_padding.toString(), "\n", "	", "button_text_left_padding: ", this.settings.button_text_left_padding.toString(), "\n", "	", "button_action:            ", this.settings.button_action.toString(), "\n", "	", "button_disabled:          ", this.settings.button_disabled.toString(), "\n", "	", "custom_settings:          ", this.settings.custom_settings.toString(), "\n", "Event Handlers:\n", "	", "swfupload_loaded_handler assigned:  ", ("function" == typeof this.settings.swfupload_loaded_handler).toString(), "\n", "	", "file_dialog_start_handler assigned: ", ("function" == typeof this.settings.file_dialog_start_handler).toString(), "\n", "	", "file_queued_handler assigned:       ", ("function" == typeof this.settings.file_queued_handler).toString(), "\n", "	", "file_queue_error_handler assigned:  ", ("function" == typeof this.settings.file_queue_error_handler).toString(), "\n", "	", "upload_start_handler assigned:      ", ("function" == typeof this.settings.upload_start_handler).toString(), "\n", "	", "upload_progress_handler assigned:   ", ("function" == typeof this.settings.upload_progress_handler).toString(), "\n", "	", "upload_error_handler assigned:      ", ("function" == typeof this.settings.upload_error_handler).toString(), "\n", "	", "upload_success_handler assigned:    ", ("function" == typeof this.settings.upload_success_handler).toString(), "\n", "	", "upload_complete_handler assigned:   ", ("function" == typeof this.settings.upload_complete_handler).toString(), "\n", "	", "debug_handler assigned:             ", ("function" == typeof this.settings.debug_handler).toString(), "\n"].join(""))
},
SWFUpload.prototype.addSetting = function(t, e, i) {
    return this.settings[t] = void 0 == e ? i: e
},
SWFUpload.prototype.getSetting = function(t) {
    return void 0 != this.settings[t] ? this.settings[t] : ""
},
SWFUpload.prototype.callFlash = function(functionName, argumentArray) {
    argumentArray = argumentArray || [];
    var movieElement = this.getMovieElement(),
    returnValue,
    returnString;
    try {
        returnString = movieElement.CallFunction('<invoke name="' + functionName + '" returntype="javascript">' + __flash__argumentsToXML(argumentArray, 0) + "</invoke>"),
        returnValue = eval(returnString)
    } catch(ex) {
        throw "Call to " + functionName + " failed"
    }
    return void 0 != returnValue && "object" == typeof returnValue.post && (returnValue = this.unescapeFilePostParams(returnValue)),
    returnValue
},
SWFUpload.prototype.selectFile = function() {
    this.callFlash("SelectFile")
},
SWFUpload.prototype.selectFiles = function() {
    this.callFlash("SelectFiles")
},
SWFUpload.prototype.startUpload = function(t) {
    this.callFlash("StartUpload", [t])
},
SWFUpload.prototype.cancelUpload = function(t, e) {
    e !== !1 && (e = !0),
    this.callFlash("CancelUpload", [t, e])
},
SWFUpload.prototype.stopUpload = function() {
    this.callFlash("StopUpload")
},
SWFUpload.prototype.getStats = function() {
    return this.callFlash("GetStats")
},
SWFUpload.prototype.setStats = function(t) {
    this.callFlash("SetStats", [t])
},
SWFUpload.prototype.getFile = function(t) {
    return "number" == typeof t ? this.callFlash("GetFileByIndex", [t]) : this.callFlash("GetFile", [t])
},
SWFUpload.prototype.addFileParam = function(t, e, i) {
    return this.callFlash("AddFileParam", [t, e, i])
},
SWFUpload.prototype.removeFileParam = function(t, e) {
    this.callFlash("RemoveFileParam", [t, e])
},
SWFUpload.prototype.setUploadURL = function(t) {
    this.settings.upload_url = t.toString(),
    this.callFlash("SetUploadURL", [t])
},
SWFUpload.prototype.setPostParams = function(t) {
    this.settings.post_params = t,
    this.callFlash("SetPostParams", [t])
},
SWFUpload.prototype.addPostParam = function(t, e) {
    this.settings.post_params[t] = e,
    this.callFlash("SetPostParams", [this.settings.post_params])
},
SWFUpload.prototype.removePostParam = function(t) {
    delete this.settings.post_params[t],
    this.callFlash("SetPostParams", [this.settings.post_params])
},
SWFUpload.prototype.setFileTypes = function(t, e) {
    this.settings.file_types = t,
    this.settings.file_types_description = e,
    this.callFlash("SetFileTypes", [t, e])
},
SWFUpload.prototype.setFileSizeLimit = function(t) {
    this.settings.file_size_limit = t,
    this.callFlash("SetFileSizeLimit", [t])
},
SWFUpload.prototype.setFileUploadLimit = function(t) {
    this.settings.file_upload_limit = t,
    this.callFlash("SetFileUploadLimit", [t])
},
SWFUpload.prototype.setFileQueueLimit = function(t) {
    this.settings.file_queue_limit = t,
    this.callFlash("SetFileQueueLimit", [t])
},
SWFUpload.prototype.setFilePostName = function(t) {
    this.settings.file_post_name = t,
    this.callFlash("SetFilePostName", [t])
},
SWFUpload.prototype.setUseQueryString = function(t) {
    this.settings.use_query_string = t,
    this.callFlash("SetUseQueryString", [t])
},
SWFUpload.prototype.setRequeueOnError = function(t) {
    this.settings.requeue_on_error = t,
    this.callFlash("SetRequeueOnError", [t])
},
SWFUpload.prototype.setHTTPSuccess = function(t) {
    "string" == typeof t && (t = t.replace(" ", "").split(",")),
    this.settings.http_success = t,
    this.callFlash("SetHTTPSuccess", [t])
},
SWFUpload.prototype.setAssumeSuccessTimeout = function(t) {
    this.settings.assume_success_timeout = t,
    this.callFlash("SetAssumeSuccessTimeout", [t])
},
SWFUpload.prototype.setDebugEnabled = function(t) {
    this.settings.debug_enabled = t,
    this.callFlash("SetDebugEnabled", [t])
},
SWFUpload.prototype.setButtonImageURL = function(t) {
    void 0 == t && (t = ""),
    this.settings.button_image_url = t,
    this.callFlash("SetButtonImageURL", [t])
},
SWFUpload.prototype.setButtonDimensions = function(t, e) {
    this.settings.button_width = t,
    this.settings.button_height = e;
    var i = this.getMovieElement();
    void 0 != i && (i.style.width = t + "px", i.style.height = e + "px"),
    this.callFlash("SetButtonDimensions", [t, e])
},
SWFUpload.prototype.setButtonText = function(t) {
    this.settings.button_text = t,
    this.callFlash("SetButtonText", [t])
},
SWFUpload.prototype.setButtonTextPadding = function(t, e) {
    this.settings.button_text_top_padding = e,
    this.settings.button_text_left_padding = t,
    this.callFlash("SetButtonTextPadding", [t, e])
},
SWFUpload.prototype.setButtonTextStyle = function(t) {
    this.settings.button_text_style = t,
    this.callFlash("SetButtonTextStyle", [t])
},
SWFUpload.prototype.setButtonDisabled = function(t) {
    this.settings.button_disabled = t,
    this.callFlash("SetButtonDisabled", [t])
},
SWFUpload.prototype.setButtonAction = function(t) {
    this.settings.button_action = t,
    this.callFlash("SetButtonAction", [t])
},
SWFUpload.prototype.setButtonCursor = function(t) {
    this.settings.button_cursor = t,
    this.callFlash("SetButtonCursor", [t])
},
SWFUpload.prototype.queueEvent = function(t, e) {
    void 0 == e ? e = [] : e instanceof Array || (e = [e]);
    var i = this;
    if ("function" == typeof this.settings[t]) this.eventQueue.push(function() {
        this.settings[t].apply(this, e)
    }),
    setTimeout(function() {
        i.executeNextEvent()
    },
    0);
    else if (null !== this.settings[t]) throw "Event handler " + t + " is unknown or is not a function"
},
SWFUpload.prototype.executeNextEvent = function() {
    var t = this.eventQueue ? this.eventQueue.shift() : null;
    "function" == typeof t && t.apply(this)
},
SWFUpload.prototype.unescapeFilePostParams = function(t) {
    var e,
    i = /[$]([0-9a-f]{4})/i,
    n = {};
    if (void 0 != t) {
        for (var s in t.post) if (t.post.hasOwnProperty(s)) {
            e = s;
            for (var o; null !== (o = i.exec(e));) e = e.replace(o[0], String.fromCharCode(parseInt("0x" + o[1], 16)));
            n[e] = t.post[s]
        }
        t.post = n
    }
    return t
},
SWFUpload.prototype.testExternalInterface = function() {
    try {
        return this.callFlash("TestExternalInterface")
    } catch(t) {
        return ! 1
    }
},
SWFUpload.prototype.flashReady = function() {
    var t = this.getMovieElement();
    return t ? (this.cleanUp(t), this.queueEvent("swfupload_loaded_handler"), void 0) : (this.debug("Flash called back ready but the flash movie can't be found."), void 0)
},
SWFUpload.prototype.cleanUp = function(t) {
    try {
        if (this.movieElement && "unknown" == typeof t.CallFunction) {
            this.debug("Removing Flash functions hooks (this should only run in IE and should prevent memory leaks)");
            for (var e in t) try {
                "function" == typeof t[e] && (t[e] = null)
            } catch(i) {}
        }
    } catch(n) {}
    window.__flash__removeCallback = function(t, e) {
        try {
            t && (t[e] = null)
        } catch(i) {}
    }
},
SWFUpload.prototype.fileDialogStart = function() {
    this.queueEvent("file_dialog_start_handler")
},
SWFUpload.prototype.fileQueued = function(t) {
    t = this.unescapeFilePostParams(t),
    this.queueEvent("file_queued_handler", t)
},
SWFUpload.prototype.fileQueueError = function(t, e, i) {
    t = this.unescapeFilePostParams(t),
    this.queueEvent("file_queue_error_handler", [t, e, i])
},
SWFUpload.prototype.fileDialogComplete = function(t, e, i) {
    this.queueEvent("file_dialog_complete_handler", [t, e, i])
},
SWFUpload.prototype.uploadStart = function(t) {
    t = this.unescapeFilePostParams(t),
    this.queueEvent("return_upload_start_handler", t)
},
SWFUpload.prototype.returnUploadStart = function(t) {
    var e;
    if ("function" == typeof this.settings.upload_start_handler) t = this.unescapeFilePostParams(t),
    e = this.settings.upload_start_handler.call(this, t);
    else if (void 0 != this.settings.upload_start_handler) throw "upload_start_handler must be a function";
    void 0 === e && (e = !0),
    e = !!e,
    this.callFlash("ReturnUploadStart", [e])

},
SWFUpload.prototype.uploadProgress = function(t, e, i) {
    t = this.unescapeFilePostParams(t),
    this.queueEvent("upload_progress_handler", [t, e, i])
},
SWFUpload.prototype.uploadError = function(t, e, i) {
    t = this.unescapeFilePostParams(t),
    this.queueEvent("upload_error_handler", [t, e, i])
},
SWFUpload.prototype.uploadSuccess = function(t, e, i) {
    t = this.unescapeFilePostParams(t),
    this.queueEvent("upload_success_handler", [t, e, i])
},
SWFUpload.prototype.uploadComplete = function(t) {
    t = this.unescapeFilePostParams(t),
    this.queueEvent("upload_complete_handler", t)
},
SWFUpload.prototype.debug = function(t) {
    this.queueEvent("debug_handler", t)
},
SWFUpload.prototype.debugMessage = function(t) {
    if (this.settings.debug) {
        var e,
        i = [];
        if ("object" == typeof t && "string" == typeof t.name && "string" == typeof t.message) {
            for (var n in t) t.hasOwnProperty(n) && i.push(n + ": " + t[n]);
            e = i.join("\n") || "",
            i = e.split("\n"),
            e = "EXCEPTION: " + i.join("\nEXCEPTION: "),
            SWFUpload.Console.writeLine(e)
        } else SWFUpload.Console.writeLine(t)
    }
},
SWFUpload.Console = {},
SWFUpload.Console.writeLine = function(t) {
    var e,
    i;
    try {
        e = document.getElementById("SWFUpload_Console"),
        e || (i = document.createElement("form"), document.getElementsByTagName("body")[0].appendChild(i), e = document.createElement("textarea"), e.id = "SWFUpload_Console", e.style.fontFamily = "monospace", e.setAttribute("wrap", "off"), e.wrap = "off", e.style.overflow = "auto", e.style.width = "700px", e.style.height = "350px", e.style.margin = "5px", i.appendChild(e)),
        e.value += t + "\n",
        e.scrollTop = e.scrollHeight - e.clientHeight
    } catch(n) {
        alert("Exception: " + n.name + " Message: " + n.message)
    }
},
/*end swfupload*/
/*swfupload ext*/
function(t) {
    t.swfupload = {
        settings: {},
        instances: {}
    },
    t.extend(t.swfupload, {
        load: function(t, e) {
            this.settings[t] = e,
            this.settings[t].button_placeholder_id = t,
            this.instances[t] = new SWFUpload(this.settings[t])
        },
        reload: function(t) {
            this.instances[t].destroy(),
            this.instances[t] = null,
            this.settings[t].button_action != SWFUpload.BUTTON_ACTION.SELECT_FILE ? this.multiple(t, this.settings[t]) : this.load(t, this.settings[t])
        },
        multiple: function(e, i) {
            var n = {
                flash_url: "/assets/swfupload/swfupload.swf",
                file_size_limit: "5120",
                file_types: "*.jpg;*.jpeg;*.gif;*.png",
                file_types_description: "图片文件",
                file_queue_error_handler: function(i, n) {
                    n == SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED ? alert("超过允许上传的文件数量，一次只能上传 " + this.settings.file_upload_limit + " 个文件") : n == SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT ? t("#" + e.replace("_button", "")).append(t('<div id="' + i.id + '" class="swfupload-error"><span>文件超过尺寸限制</span><a href="#ui_' + i.id + '" class="ui-action-close">取消</a></div>')) : t("#" + e.replace("_button", "")).append(t('<div id="' + i.id + '" class="swfupload-error"><span>文件上传错误</span><a href="#ui_' + i.id + '" class="ui-action-close">取消</a></div>')),
                    t("#" + i.id).delay(3e3).fadeOut("slow")
                },
                file_dialog_complete_handler: function() {
                    this.startUpload()
                },
                upload_start_handler: function(i) {
                    t("#" + e.replace("_button", "")).append(t('<div id="' + i.id + '" class="swfupload-progress timeline-add-pic-preview"></div>'))
                },
                upload_progress_handler: function(e, i, n) {
                    t("#" + e.id).html(t("<div><span>上传中...<br>" + Math.ceil(99 * (i / n)) + "%</span></div>"))
                },
                upload_error_handler: function(e) {
                    this.startUpload(),
                    t("#" + e.id).replaceWith(t('<div id="' + e.id + '" class="swfupload-error"><span>文件上传错误</span><a href="#ui_' + e.id + '" class="ui-action-close">取消</a></div>'))
                },
                upload_success_handler: function(e, i) {
                    t("#" + e.id).replaceWith(t(i))
                },
                upload_complete_handler: function() {
                    this.startUpload()
                },
                button_image_url: "/assets/upload.gif",
                button_width: 80,
                button_height: 32,
                button_placeholder_id: e
            };
            this.settings[e] = t.extend(!0, {},
            n, i),
            this.instances[e] = new SWFUpload(this.settings[e])
        }
    })
} (jQuery),
/*end swfupload ext*/

function($) {
    var escapeable = /["\\\x00-\x1f\x7f-\x9f]/g,
    meta = {
        "\b": "\\b",
        "	": "\\t",
        "\n": "\\n",
        "\f": "\\f",
        "\r": "\\r",
        '"': '\\"',
        "\\": "\\\\"
    };
    $.toJSON = "object" == typeof JSON && JSON.stringify ? JSON.stringify: function(t) {
        if (null === t) return "null";
        var e = typeof t;
        if ("undefined" === e) return void 0;
        if ("number" === e || "boolean" === e) return "" + t;
        if ("string" === e) return $.quoteString(t);
        if ("object" === e) {
            if ("function" == typeof t.toJSON) return $.toJSON(t.toJSON());
            if (t.constructor === Date) {
                var i = t.getUTCMonth() + 1,
                n = t.getUTCDate(),
                s = t.getUTCFullYear(),
                o = t.getUTCHours(),
                a = t.getUTCMinutes(),
                r = t.getUTCSeconds(),
                l = t.getUTCMilliseconds();
                return 10 > i && (i = "0" + i),
                10 > n && (n = "0" + n),
                10 > o && (o = "0" + o),
                10 > a && (a = "0" + a),
                10 > r && (r = "0" + r),
                100 > l && (l = "0" + l),
                10 > l && (l = "0" + l),
                '"' + s + "-" + i + "-" + n + "T" + o + ":" + a + ":" + r + "." + l + 'Z"'
            }
            if (t.constructor === Array) {
                for (var u = [], d = 0; d < t.length; d++) u.push($.toJSON(t[d]) || "null");
                return "[" + u.join(",") + "]"
            }
            var c,
            h,
            p = [];
            for (var f in t) {
                if (e = typeof f, "number" === e) c = '"' + f + '"';
                else {
                    if ("string" !== e) continue;
                    c = $.quoteString(f)
                }
                e = typeof t[f],
                "function" !== e && "undefined" !== e && (h = $.toJSON(t[f]), p.push(c + ":" + h))
            }
            return "{" + p.join(",") + "}"
        }
    },
    $.evalJSON = "object" == typeof JSON && JSON.parse ? JSON.parse: function(src) {
        return eval("(" + src + ")")
    },
    $.secureEvalJSON = "object" == typeof JSON && JSON.parse ? JSON.parse: function(src) {
        var filtered = src.replace(/\\["\\\/bfnrtu]/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:\s*\[)+/g, "");
        if (/^[\],:{}\s]*$/.test(filtered)) return eval("(" + src + ")");
        throw new SyntaxError("Error parsing JSON, source is not valid.")
    },
    $.quoteString = function(t) {
        return t.match(escapeable) ? '"' + t.replace(escapeable, 
        function(t) {
            var e = meta[t];
            return "string" == typeof e ? e: (e = t.charCodeAt(), "\\u00" + Math.floor(e / 16).toString(16) + (e % 16).toString(16))
        }) + '"': '"' + t + '"'
    }
} (jQuery),

/*function for ueditor*/
function(t) {
    function e(t, e, n, s) {
        if (!t.tag.isInline && n.length > 0) for (n.push("\n"), i = 0; s > i; i++) n.push("	")
    }
    function n(i, s) {
        var o,
        a = [],
        r = 0 == i.attributes.length;
        this.name.concat(void 0 == i.tag.rawAttributes ? "": i.tag.rawAttributes);
        var h = i.tag.render && (0 == s.allowedTags.length || t.inArray(i.tag.name, s.allowedTags) > -1) && (0 == s.removeTags.length || -1 == t.inArray(i.tag.name, s.removeTags));
        if (!i.isRoot && h && (a.push("<"), a.push(i.tag.name), t.each(i.attributes, 
        function() {
            if ( - 1 == t.inArray(this.name, s.removeAttrs)) {
                var e = RegExp(/^(['"]?)(.*?)['"]?$/).exec(this.value),
                n = e[2],
                o = e[1] || "'";
                "class" == this.name && (n = t.grep(n.split(" "), 
                function(e) {
                    return t.grep(s.allowedClasses, 
                    function(n) {
                        return n[0] == e && (1 == n.length || t.inArray(i.tag.name, n[1]) > -1)
                    }).length > 0
                }).join(" "), o = "'"),
                null != n && (n.length > 0 || t.inArray(this.name, i.tag.requiredAttributes) > -1) && (a.push(" "), a.push(this.name), a.push("="), a.push(o), a.push(n), a.push(o))
            }
        })), i.tag.isSelfClosing) h && a.push(" />"),
        r = !1;
        else if (i.tag.isNonClosing) r = !1;
        else { ! i.isRoot && h && a.push(">");
            var o = s.formatIndent++;
            if (i.tag.toProtect) {
                var f = t.htmlClean.trim(i.children.join("")).replace(/<br>/gi, "\n");
                a.push(f),
                r = 0 == f.length
            } else {
                for (var f = [], m = 0; m < i.children.length; m++) {
                    var g = i.children[m],
                    v = t.htmlClean.trim(p(d(g) ? g: g.childrenToString()));
                    c(g) && m > 0 && v.length > 0 && (l(g) || u(i.children[m - 1])) && f.push(" "),
                    d(g) ? v.length > 0 && f.push(v) : (m != i.children.length - 1 || "br" != g.tag.name) && (s.format && e(g, s, f, o), f = f.concat(n(g, s)))
                }
                s.formatIndent--,
                f.length > 0 && (s.format && "\n" != f[0] && e(i, s, a, o), a = a.concat(f), r = !1)
            } ! i.isRoot && h && (s.format && e(i, s, a, o - 1), a.push("</"), a.push(i.tag.name), a.push(">"))
        }
        return ! i.tag.allowEmpty && r ? [] : a
    }
    function s(e, i, n) {
        return n = n || 1,
        t.inArray(e[e.length - n].tag.name, i) > -1 ? !0: e.length - (n + 1) > 0 && s(e, i, n + 1) ? (e.pop(), !0) : !1
    }
    function o(t) {
        return t ? (this.tag = t, this.isRoot = !1) : (this.tag = new r("root"), this.isRoot = !0),
        this.attributes = [],
        this.children = [],
        this.hasAttribute = function(t) {
            for (var e = 0; e < this.attributes.length; e++) if (this.attributes[e].name == t) return ! 0;
            return ! 1
        },
        this.childrenToString = function() {
            return this.children.join("")
        },
        this
    }
    function a(t, e) {
        return this.name = t,
        this.value = e,
        this
    }
    function r(e, i, n, s) {
        return this.name = e.toLowerCase(),
        this.isSelfClosing = t.inArray(this.name, y) > -1,
        this.isNonClosing = t.inArray(this.name, _) > -1,
        this.isClosing = void 0 != i && i.length > 0,
        this.isInline = t.inArray(this.name, f) > -1,
        this.disallowNest = t.inArray(this.name, m) > -1,
        this.requiredParent = v[t.inArray(this.name, v) + 1],
        this.allowEmpty = t.inArray(this.name, g) > -1,
        this.toProtect = t.inArray(this.name, b) > -1,
        this.rawAttributes = n,
        this.allowedAttributes = w[t.inArray(this.name, w) + 1],
        this.requiredAttributes = S[t.inArray(this.name, S) + 1],
        this.render = s && -1 == t.inArray(this.name, s.notRenderedTags),
        this
    }
    function l(e) {
        for (; h(e) && e.children.length > 0;) e = e.children[0];
        return d(e) && e.length > 0 && t.htmlClean.isWhitespace(e.charAt(0))
    }
    function u(e) {
        for (; h(e) && e.children.length > 0;) e = e.children[e.children.length - 1];
        return d(e) && e.length > 0 && t.htmlClean.isWhitespace(e.charAt(e.length - 1))
    }
    function d(t) {
        return t.constructor == String
    }
    function c(t) {
        return d(t) || t.tag.isInline
    }
    function h(t) {
        return t.constructor == o
    }
    function p(t) {
        return t.replace(/&nbsp;|\n/g, " ").replace(/\s\s+/g, " ")
    }
    t.fn.htmlClean = function(e) {
        return this.each(function() {
            t(this),
            this.value ? this.value = t.htmlClean(this.value, e) : this.innerHTML = t.htmlClean(this.innerHTML, e)
        })
    },
    t.htmlClean = function(e, i) {
        i = t.extend({},
        t.htmlClean.defaults, i);
        var l,
        u = /<(\/)?(\w+:)?([\w]+)([^>]*)>/gi,
        c = /(\w+)=(".*?"|'.*?'|[^\s>]*)/gi,
        h = new o,
        p = [h],
        f = h;
        i.bodyOnly && (l = /<body[^>]*>((\n|.)*)<\/body>/i.exec(e)) && (e = l[1]),
        e = e.concat("<xxx>");
        for (var m; l = u.exec(e);) {
            var g = new r(l[3], l[1], l[4], i),
            v = e.substring(m, l.index);
            if (v.length > 0) {
                var b = f.children[f.children.length - 1];
                f.children.length > 0 && d(b = f.children[f.children.length - 1]) ? f.children[f.children.length - 1] = b.concat(v) : f.children.push(v)
            }
            if (m = u.lastIndex, g.isClosing) s(p, [g.name]) && (p.pop(), f = p[p.length - 1]);
            else {
                for (var y, _ = new o(g); y = c.exec(g.rawAttributes);) {
                    if ("style" == y[1].toLowerCase() && i.replaceStyles) for (var w = !g.isInline, S = 0; S < i.replaceStyles.length; S++) i.replaceStyles[S][0].test(y[2]) && (w || (g.render = !1, w = !0), f.children.push(_), p.push(_), f = _, g = new r(i.replaceStyles[S][1], "", "", i), _ = new o(g));
                    null != g.allowedAttributes && (0 == g.allowedAttributes.length || t.inArray(y[1], g.allowedAttributes) > -1) && _.attributes.push(new a(y[1], y[2]))
                }
                t.each(g.requiredAttributes, 
                function() {
                    var t = this.toString();
                    _.hasAttribute(t) || _.attributes.push(new a(t, ""))
                });
                for (var x = 0; x < i.replace.length; x++) for (var C = 0; C < i.replace[x][0].length; C++) {
                    var E = "string" == typeof i.replace[x][0][C];
                    if (E && i.replace[x][0][C] == g.name || !E && i.replace[x][0][C].test(l)) {
                        g.render = !1,
                        f.children.push(_),
                        p.push(_),
                        f = _,
                        g = new r(i.replace[x][1], l[1], l[4], i),
                        _ = new o(g),
                        _.attributes = f.attributes,
                        x = i.replace.length;
                        break
                    }
                }
                var T = !0;
                if (f.isRoot || (f.tag.isInline && !g.isInline ? T = !1: f.tag.disallowNest && g.disallowNest && !g.requiredParent ? T = !1: g.requiredParent && (T = s(p, g.requiredParent)) && (f = p[p.length - 1])), T) if (f.children.push(_), g.toProtect) for (; tagMatch2 = u.exec(e);) {
                    var k = new r(tagMatch2[3], tagMatch2[1], tagMatch2[4], i);
                    if (k.isClosing && k.name == g.name) {
                        _.children.push(RegExp.leftContext.substring(m)),
                        m = u.lastIndex;
                        break
                    }
                } else g.isSelfClosing || g.isNonClosing || (p.push(_), f = _)
            }
        }
        return n(h, i).join("")
    },
    t.htmlClean.defaults = {
        Only: !0,
        allowedTags: [],
        removeTags: ["basefont", "center", "dir", "font", "frame", "frameset", "iframe", "isindex", "menu", "noframes", "s", "strike", "u"],
        removeAttrs: [],
        allowedClasses: [],
        notRenderedTags: [],
        format: !1,
        formatIndent: 0,
        replace: [[["b", "big"], "strong"], [["i"], "em"]],
        replaceStyles: [[/font-weight:\s*bold/i, "strong"], [/font-style:\s*italic/i, "em"], [/vertical-align:\s*super/i, "sup"], [/vertical-align:\s*sub/i, "sub"]]
    },
    t.htmlClean.trim = function(e) {
        return t.htmlClean.trimStart(t.htmlClean.trimEnd(e))
    },
    t.htmlClean.trimStart = function(e) {
        return e.substring(t.htmlClean.trimStartIndex(e))
    },
    t.htmlClean.trimStartIndex = function(e) {
        for (var i = 0; i < e.length - 1 && t.htmlClean.isWhitespace(e.charAt(i)); i++);
        return i
    },
    t.htmlClean.trimEnd = function(e) {
        return e.substring(0, t.htmlClean.trimEndIndex(e))
    },
    t.htmlClean.trimEndIndex = function(e) {
        for (var i = e.length - 1; i >= 0 && t.htmlClean.isWhitespace(e.charAt(i)); i--);
        return i + 1
    },
    t.htmlClean.isWhitespace = function(e) {
        return - 1 != t.inArray(e, x)
    };
    var f = ["a", "abbr", "acronym", "address", "b", "big", "br", "button", "caption", "cite", "code", "del", "em", "font", "hr", "i", "input", "img", "ins", "label", "legend", "map", "q", "samp", "select", "small", "span", "strong", "sub", "sup", "tt", "var"],
    m = ["h1", "h2", "h3", "h4", "h5", "h6", "p", "th", "td"],
    g = ["th", "td"],
    v = [null, "li", ["ul", "ol"], "dt", ["dl"], "dd", ["dl"], "td", ["tr"], "th", ["tr"], "tr", ["table", "thead", "tbody", "tfoot"], "thead", ["table"], "tbody", ["table"], "tfoot", ["table"]],
    b = ["script", "style", "pre", "code"],
    y = ["br", "hr", "img", "link", "meta"],
    _ = ["!doctype", "?xml"],
    w = [["class"], "?xml", [], "!doctype", [], "a", ["accesskey", "class", "href", "name", "title", "rel", "rev", "type", "tabindex"], "abbr", ["class", "title"], "acronym", ["class", "title"], "blockquote", ["cite", "class"], "button", ["class", "disabled", "name", "type", "value"], "del", ["cite", "class", "datetime"], "form", ["accept", "action", "class", "enctype", "method", "name"], "input", ["accept", "accesskey", "alt", "checked", "class", "disabled", "ismap", "maxlength", "name", "size", "readonly", "src", "tabindex", "type", "usemap", "value"], "img", ["alt", "class", "height", "src", "width"], "ins", ["cite", "class", "datetime"], "label", ["accesskey", "class", "for"], "legend", ["accesskey", "class"], "link", ["href", "rel", "type"], "meta", ["content", "http-equiv", "name", "scheme"], "map", ["name"], "optgroup", ["class", "disabled", "label"], "option", ["class", "disabled", "label", "selected", "value"], "q", ["class", "cite"], "script", ["src", "type"], "select", ["class", "disabled", "multiple", "name", "size", "tabindex"], "style", ["type"], "table", ["class", "summary"], "textarea", ["accesskey", "class", "cols", "disabled", "name", "readonly", "rows", "tabindex"]],
    S = [[], "img", ["alt"]],
    x = [" ", " ", "	", "\n", "\r", "\f"]
} (jQuery),

/*end function for ueditor*/

/*ueditor app*/
function() {
    var t = "http://" + window.location.host + "/ueditor2/";
    UEDITOR_CONFIG = {
        imagePath: "http://" + window.location.host,
        compressSide: 0,
        maxImageSideLength: 900,
        relativePath: !0,
        UEDITOR_HOME_URL: t,
        toolbars: [["Bold", "Indent", "|", "Print", "InsertVideo", "Link"]],
        labelMap: {
            anchor: "锚点",
            undo: "撤销",
            redo: "重做",
            bold: "插入标题",
            indent: "自动排版",
            italic: "斜体",
            underline: "下划线",
            strikethrough: "删除线",
            subscript: "下标",
            superscript: "上标",
            formatmatch: "格式刷",
            source: "源代码",
            blockquote: "引用",
            pasteplain: "纯文本粘贴模式",
            selectall: "全选",
            print: "插入图片",
            preview: "预览",
            horizontal: "分隔线",
            removeformat: "清除格式",
            time: "时间",
            date: "日期",
            unlink: "取消链接",
            insertrow: "前插入行",
            insertcol: "前插入列",
            mergeright: "右合并单元格",
            mergedown: "下合并单元格",
            deleterow: "删除行",
            deletecol: "删除列",
            splittorows: "拆分成行",
            splittocols: "拆分成列",
            splittocells: "完全拆分单元格",
            mergecells: "合并多个单元格",
            deletetable: "删除表格",
            insertparagraphbeforetable: "表格前插行",
            cleardoc: "清空文档",
            fontfamily: "字体",
            fontsize: "字号",
            paragraph: "段落格式",
            insertimage: "图片",
            inserttable: "表格",
            link: "插入链接",
            emotion: "表情",
            spechars: "特殊字符",
            searchreplace: "查询替换",
            map: "Baidu地图",
            gmap: "Google地图",
            insertvideo: "插入视频",
            help: "帮助",
            justifyleft: "居左对齐",
            justifyright: "居右对齐",
            justifycenter: "居中对齐",
            justifyjustify: "两端对齐",
            forecolor: "字体颜色",
            backcolor: "背景色",
            insertorderedlist: "有序列表",
            insertunorderedlist: "无序列表",
            fullscreen: "全屏",
            directionalityltr: "从左向右输入",
            directionalityrtl: "从右向左输入",
            rowspacing: "段间距",
            highlightcode: "插入代码",
            pagebreak: "分页",
            insertframe: "插入Iframe",
            imagenone: "默认",
            imageleft: "居左",
            imageright: "居右",
            imagecenter: "居中",
            checkimage: "图片转存",
            lineheight: "行间距",
            customstyle: "自定义标题"
        },
        iframeUrlMap: {
            anchor: "~/dialogs/anchor/anchor.html",
            insertimage: "~/dialogs/image/image.html",
            inserttable: "~/dialogs/table/table.html",
            link: "~/dialogs/link/link.html",
            spechars: "~/dialogs/spechars/spechars.html",
            searchreplace: "~/dialogs/searchreplace/searchreplace.html",
            map: "~/dialogs/map/map.html",
            gmap: "~/dialogs/gmap/gmap.html",
            insertvideo: "~/dialogs/video/video.html",
            help: "~/dialogs/help/help.html",
            highlightcode: "~/dialogs/code/code.html",
            emotion: "~/dialogs/emotion/emotion.html",
            wordimage: "~/dialogs/wordimage/wordimage.html",
            attachment: "~/dialogs/attachment/attachment.html",
            insertframe: "~/dialogs/insertframe/insertframe.html",
            edittd: "~/dialogs/table/edittd.html",
            snapscreen: "~/dialogs/snapscreen/snapscreen.html"
        },
        listMap: {
            fontfamily: ["宋体", "楷体", "隶书", "黑体", "andale mono", "arial", "arial black", "comic sans ms", "impact", "times new roman"],
            fontsize: [10, 11, 12, 14, 16, 18, 20, 24, 36],
            paragraph: ["p:段落", "h1:标题 1", "h2:标题 2", "h3:标题 3", "h4:标题 4", "h5:标题 5", "h6:标题 6"],
            rowspacing: ["5", "10", "15", "20", "25"],
            lineheight: ["100", "125", "150", "200", "300", "400", "500"],
            customstyle: [{
                tag: "h1",
                label: "居中标题",
                style: "border-bottom:#ccc 2px solid;padding:0 4px 0 0;text-align:center;margin:0 0 20px 0;"
            },
            {
                tag: "h1",
                label: "居左标题",
                style: "border-bottom:#ccc 2px solid;padding:0 4px 0 0;margin:0 0 10px 0;"
            },
            {
                tag: "span",
                label: "强调",
                style: "font-style:italic;font-weight:bold"
            },
            {
                tag: "span",
                label: "明显强调",
                style: "font-style:italic;font-weight:bold;color:rgb(51, 153, 204)"
            }]
        },
        fontMap: {
            "宋体": ["宋体", "SimSun"],
            "楷体": ["楷体", "楷体_GB2312", "SimKai"],
            "黑体": ["黑体", "SimHei"],
            "隶书": ["隶书", "SimLi"],
            "andale mono": ["andale mono"],
            arial: ["arial", "helvetica", "sans-serif"],
            "arial black": ["arial black", "avant garde"],
            "comic sans ms": ["comic sans ms"],
            impact: ["impact", "chicago"],
            "times new roman": ["times new roman"]
        },
        contextMenu: [],
        initialStyle: '.selectTdClass{background-color:#3399FF !important}table{clear:both;margin-bottom:10px;border-collapse:collapse;word-break:break-all;}.pagebreak{border-bottom:1px dotted #999999 !important;border-top:1px dotted #999999 !important;clear:both !important;cursor:default !important;height: 5px !important;padding: 0 !important;width: 100% !important;margin-bottom:10px;height:5px !important;overflow: hidden;}.anchorclass{background: url("' + t + 'themes/default/images/anchor.gif") no-repeat scroll left center transparent;border: 1px dotted #0000FF;cursor: auto;display: inline-block;height: 16px;width: 15px;}' + ".view{padding:0;word-wrap:break-word;word-break:break-all;cursor:text;height:100%;}\n" + 'body{padding:0px;font-family:"宋体";font-size:14px;overflow:hidden;margin:8px 8px 0px 8px;line-height:1.4}' + "li{clear:both}" + 'p{margin:0px 0px 0px 0px;overflow:hidden;font-size:14px;font-family:helvetica,"Helvetica Neue",arial,"liberation sans",freesans,sans-serif;line-height:21px;}' + 'body img,body h3 img,body p img{overflow:hidden;max-width:570px;*max-width:566px;_width:expression(document.body.clientWidth > 566 ? "566px" : "auto");}' + "body h3{overflow:hidden;clear:both;display:block;font-size:18px;padding:0px 0px 5px 0px;margin:10px 0px 10px 0px}" + ".tableclear{clear:both;margin:0;padding:0;}",
        initialContent: "",
        autoClearinitialContent: !1,
        removeFormatTags: "b,big,code,del,dfn,em,font,i,ins,kbd,q,samp,small,span,strike,strong,sub,sup,tt,u,var",
        removeFormatAttributes: "class,style,lang,width,height,align,hspace,valign",
        enterTag: "p",
        maxUndoCount: 20,
        maxInputCount: 20,
        selectedTdClass: "selectTdClass",
        pasteplain: !1,
        textarea: "editorValue",
        focus: !1,
        indentValue: "0em",
        pageBreakTag: "_baidu_page_break_tag_",
        autoHeightEnabled: !0,
        autoFloatEnabled: !0,
        elementPathEnabled: !1,
        wordCount: !1,
        maximumWords: 1e4,
        tabSize: 4,
        tabNode: "&nbsp;",
        imagePopup: !0,
        emotionLocalization: !0,
        sourceEditor: "codemirror",
        tdHeight: "20",
        highlightJsUrl: t + "third-party/SyntaxHighlighter/shCore.js",
        highlightCssUrl: t + "third-party/SyntaxHighlighter/shCoreDefault.css",
        zIndex: 999,
        fullscrren: !1,
        snapscreenHost: "localhost",
        snapscreenServerFile: t + "server/upload/php/snapImgUp.php",
        snapscreenServerPort: 80,
        snapscreenImgAlign: "center",
        snapscreenImgIsUseImagePath: 1,
        messages: {
            pasteMsg: "编辑器将过滤掉您粘贴内容中的不支持格式！",
            wordCountMsg: "当前已输入 {#count} 个字符，您还可以输入{#leave} 个字符 ",
            wordOverFlowMsg: "你输入的字符个数已经超出最大允许值，服务器可能会拒绝保存！",
            pasteWordImgMsg: "您粘贴的内容中包含本地图片，需要转存后才能正确显示！",
            snapScreenNotIETip: "截图功能需要在ie浏览器下使用",
            snapScreenMsg: "截图上传失败，请检查你的PHP环境。 "
        },
        serialize: function() {
            return {
                blackList: {
                    style: 1,
                    font: 1,
                    span: 1,
                    script: 1,
                    link: 1,
                    object: 1,
                    applet: 1,
                    input: 1,
                    meta: 1,
                    base: 1,
                    button: 1,
                    select: 1,
                    textarea: 1,
                    "#comment": 1,
                    map: 1,
                    area: 1
                }
            }
        } (),
        ComboxInitial: {
            FONT_FAMILY: "字体",
            FONT_SIZE: "字号",
            ROW_SPACING: "段间距",
            PARAGRAPH: "段落格式",
            LINE_HEIGHT: "行间距",
            CUSTOMSTYLE: "自定义样式"
        },
        autotypeset: {
            mergeEmptyline: !1,
            removeClass: !0,
            removeEmptyline: !1,
            textAlign: "left",
            lineHeight: "100",
            rowSpacing: "10",
            imageBlockLine: "center",
            pasteFilter: !0,
            clearFontSize: !1,
            clearFontFamily: !1,
            removeEmptyNode: !1,
            removeTagNames: {
                div: 1,
                a: 1,
                abbr: 1,
                acronym: 1,
                address: 1,
                b: 1,
                bdo: 1,
                big: 1,
                cite: 1,
                code: 1,
                del: 1,
                dfn: 1,
                em: 1,
                font: 1,
                i: 1,
                ins: 1,
                label: 1,
                kbd: 1,
                q: 1,
                s: 1,
                samp: 1,
                small: 1,
                span: 1,
                strike: 1,
                strong: 1,
                sub: 1,
                sup: 1,
                tt: 1,
                u: 1,
                "var": 1
            },
            indent: !1,
            indentValue: "2em"
        }
    }
} (),
/*end ueditor app*/
/*ueditor.js*/
UEDITOR_CONFIG = window.UEDITOR_CONFIG || {};
var baidu = window.baidu || {};
window.baidu = baidu,
window.UE = baidu.editor = {},
UE.plugins = {},
UE.commands = {},
UE.version = "1.2.0.0";
var dom = UE.dom = {},
browser = UE.browser = function() {
    var t = navigator.userAgent.toLowerCase(),
    e = window.opera,
    i = {
        ie: !!window.ActiveXObject,
        opera: !!e && e.version,
        webkit: t.indexOf(" applewebkit/") > -1,
        mac: t.indexOf("macintosh") > -1,
        quirks: "BackCompat" == document.compatMode
    };
    i.gecko = "Gecko" == navigator.product && !i.webkit && !i.opera;
    var n = 0;
    if (i.ie && (n = parseFloat(t.match(/msie (\d+)/)[1]), i.ie8 = !!document.documentMode, i.ie8Compat = 8 == document.documentMode, i.ie7Compat = 7 == n && !document.documentMode || 7 == document.documentMode, i.ie6Compat = 7 > n || i.quirks), i.gecko) {
        var s = t.match(/rv:([\d\.]+)/);
        s && (s = s[1].split("."), n = 1e4 * s[0] + 100 * (s[1] || 0) + 1 * (s[2] || 0))
    }
    return /chrome\/(\d+\.\d)/i.test(t) && (i.chrome = +RegExp.$1),
    /(\d+\.\d)?(?:\.\d)?\s+safari\/?(\d+\.\d+)?/i.test(t) && !/chrome/i.test(t) && (i.safari = +(RegExp.$1 || RegExp.$2)),
    i.opera && (n = parseFloat(e.version())),
    i.webkit && (n = parseFloat(t.match(/ applewebkit\/(\d+)/)[1])),
    i.version = n,
    i.isCompatible = !i.mobile && (i.ie && n >= 6 || i.gecko && n >= 10801 || i.opera && n >= 9.5 || i.air && n >= 1 || i.webkit && n >= 522 || !1),
    i
} (),
ie = browser.ie,
webkit = browser.webkit,
gecko = browser.gecko,
utils = UE.utils = {
    makeInstance: function(t) {
        var e = new Function;
        return e.prototype = t,
        t = new e,
        e.prototype = null,
        t
    },
    extend: function(t, e, i) {
        if (e) for (var n in e) i && t.hasOwnProperty(n) || (t[n] = e[n]);
        return t
    },
    isArray: function(t) {
        return "[object Array]" === Object.prototype.toString.apply(t)
    },
    isString: function(t) {
        return "string" == typeof t || t.constructor == String
    },
    inherits: function(t, e) {
        var i = t.prototype,
        n = utils.makeInstance(e.prototype);
        return utils.extend(n, i, !0),
        t.prototype = n,
        n.constructor = t
    },
    bind: function(t, e) {
        return function() {
            return t.apply(e, arguments)
        }
    },
    defer: function(t, e, i) {
        var n;
        return function() {
            i && clearTimeout(n),
            n = setTimeout(t, e)
        }
    },
    indexOf: function(t, e, i) {
        for (var n = i || 0, s = t.length; s > n; n++) if (t[n] === e) return n;
        return - 1
    },
    findNode: function(t, e, i) {
        for (var n, s = 0; n = t[s++];) if (i ? i(n) : -1 != this.indexOf(e, n.tagName.toLowerCase())) return n
    },
    removeItem: function(t, e) {
        for (var i = 0, n = t.length; n > i; i++) t[i] === e && (t.splice(i, 1), i--)
    },
    trim: function(t) {
        return t.replace(/(^[ \t\n\r]+)|([ \t\n\r]+$)/g, "")
    },
    listToMap: function(t) {
        if (!t) return {};
        t = utils.isArray(t) ? t: t.split(",");
        for (var e, i = 0, n = {}; e = t[i++];) n[e.toUpperCase()] = n[e] = 1;
        return n
    },
    unhtml: function(t) {
        return t ? t.replace(/[&<">]/g, 
        function(t) {
            return {
                "<": "&lt;",
                "&": "&amp",
                '"': "&quot;",
                ">": "&gt;"
            } [t]
        }) : ""
    },
    cssStyleToDomStyle: function() {
        var t = document.createElement("div").style,
        e = {
            "float": void 0 != t.cssFloat ? "cssFloat": void 0 != t.styleFloat ? "styleFloat": "float"
        };
        return function(t) {
            return e[t] || (e[t] = t.toLowerCase().replace(/-./g, 
            function(t) {
                return t.charAt(1).toUpperCase()
            }))
        }
    } (),
    loadFile: function(t, e, i) {
        if (!e.id || !t.getElementById(e.id)) {
            var n = t.createElement(e.tag);
            delete e.tag;
            for (var s in e) n.setAttribute(s, e[s]);
            n.onload = n.onreadystatechange = function() { (!this.readyState || /loaded|complete/.test(this.readyState)) && (i && i(), n.onload = n.onreadystatechange = null)
            },
            t.getElementsByTagName("head")[0].appendChild(n)
        }
    },
    isEmptyObject: function(t) {
        for (var e in t) return ! 1;
        return ! 0
    },
    fixColor: function(t, e) {
        if (/color/i.test(t) && /rgba?/.test(e)) {
            var i = e.split(",");
            if (i.length > 3) return "";
            e = "#";
            for (var n, s = 0; n = i[s++];) n = parseInt(n.replace(/[^\d]/gi, ""), 10).toString(16),
            e += 1 == n.length ? "0" + n: n;
            e = e.toUpperCase()
        }
        return e
    },
    optCss: function(t) {
        function e(t, e) {
            if (!t) return "";
            var i = t.top,
            n = t.bottom,
            s = t.left,
            o = t.right,
            a = "";
            if (i && s && n && o) a += ";" + e + ":" + (i == n && n == s && s == o ? i: i == n && s == o ? i + " " + s: s == o ? i + " " + s + " " + n: i + " " + o + " " + n + " " + s) + ";";
            else for (var r in t) a += ";" + e + "-" + r + ":" + t[r] + ";";
            return a
        }
        var i,
        n;
        return t = t.replace(/(padding|margin|border)\-([^:]+):([^;]+);?/gi, 
        function(t, e, s, o) {
            if (1 == o.split(" ").length) switch (e) {
            case "padding":
                return ! i && (i = {}),
                i[s] = o,
                "";
            case "margin":
                return ! n && (n = {}),
                n[s] = o,
                "";
            case "border":
                return "initial" == o ? "": t
            }
            return t
        }),
        t += e(i, "padding") + e(n, "margin"),
        t.replace(/^[ \n\r\t;]*|[ \n\r\t]*$/, "").replace(/;([ \n\r\t]+)|\1;/g, ";").replace(/;{2,}/g, ";")
    }
},
EventBase = UE.EventBase = function() {};
EventBase.prototype = {
    addListener: function(t, e) {
        getListener(this, t, !0).push(e)
    },
    removeListener: function(t, e) {
        var i = getListener(this, t);
        i && utils.removeItem(i, e)
    },
    fireEvent: function(t) {
        var e,
        i,
        n,
        s = getListener(this, t);
        if (s) for (n = s.length; n--;) i = s[n].apply(this, arguments),
        void 0 !== i && (e = i);
        return (i = this["on" + t.toLowerCase()]) && (e = i.apply(this, arguments)),
        e
    }
};
var dtd = dom.dtd = function() {
    function t(t) {
        for (var e in t) t[e.toUpperCase()] = t[e];
        return t
    }
    function e(t) {
        for (var e = arguments, i = 1; i < e.length; i++) {
            var n = e[i];
            for (var s in n) t.hasOwnProperty(s) || (t[s] = n[s])
        }
        return t
    }
    var i = t({
        isindex: 1,
        fieldset: 1
    }),
    n = t({
        input: 1,
        button: 1,
        select: 1,
        textarea: 1,
        label: 1
    }),
    s = e(t({
        a: 1
    }), n),
    o = e({
        iframe: 1
    },
    s),
    a = t({
        hr: 1,
        ul: 1,
        menu: 1,
        div: 1,
        blockquote: 1,
        noscript: 1,
        table: 1,
        center: 1,
        address: 1,
        dir: 1,
        pre: 1,
        h5: 1,
        dl: 1,
        h4: 1,
        noframes: 1,
        h6: 1,
        ol: 1,
        h1: 1,
        h3: 1,
        h2: 1
    }),
    r = t({
        ins: 1,
        del: 1,
        script: 1,
        style: 1
    }),
    l = e(t({
        b: 1,
        acronym: 1,
        bdo: 1,
        "var": 1,
        "#": 1,
        abbr: 1,
        code: 1,
        br: 1,
        i: 1,
        cite: 1,
        kbd: 1,
        u: 1,
        strike: 1,
        s: 1,
        tt: 1,
        strong: 1,
        q: 1,
        samp: 1,
        em: 1,
        dfn: 1,
        span: 1
    }), r),
    u = e(t({
        sub: 1,
        img: 1,
        embed: 1,
        object: 1,
        sup: 1,
        basefont: 1,
        map: 1,
        applet: 1,
        font: 1,
        big: 1,
        small: 1
    }), l),
    d = e(t({
        p: 1
    }), u),
    c = e(t({
        iframe: 1
    }), u, n),
    h = t({
        img: 1,
        embed: 1,
        noscript: 1,
        br: 1,
        kbd: 1,
        center: 1,
        button: 1,
        basefont: 1,
        h5: 1,
        h4: 1,
        samp: 1,
        h6: 1,
        ol: 1,
        h1: 1,
        h3: 1,
        h2: 1,
        form: 1,
        font: 1,
        "#": 1,
        select: 1,
        menu: 1,
        ins: 1,
        abbr: 1,
        label: 1,
        code: 1,
        table: 1,
        script: 1,
        cite: 1,
        input: 1,
        iframe: 1,
        strong: 1,
        textarea: 1,
        noframes: 1,
        big: 1,
        small: 1,
        span: 1,
        hr: 1,
        sub: 1,
        bdo: 1,
        "var": 1,
        div: 1,
        object: 1,
        sup: 1,
        strike: 1,
        dir: 1,
        map: 1,
        dl: 1,
        applet: 1,
        del: 1,
        isindex: 1,
        fieldset: 1,
        ul: 1,
        b: 1,
        acronym: 1,
        a: 1,
        blockquote: 1,
        i: 1,
        u: 1,
        s: 1,
        tt: 1,
        address: 1,
        q: 1,
        pre: 1,
        p: 1,
        em: 1,
        dfn: 1
    }),
    p = e(t({
        a: 0
    }), c),
    f = t({
        tr: 1
    }),
    m = t({
        "#": 1
    }),
    g = e(t({
        param: 1
    }), h),
    v = e(t({
        form: 1
    }), i, o, a, d),
    b = t({
        li: 1
    }),
    y = t({
        style: 1,
        script: 1
    }),
    _ = t({
        base: 1,
        link: 1,
        meta: 1,
        title: 1
    }),
    w = e(_, y),
    S = t({
        head: 1,
        body: 1
    }),
    x = t({
        html: 1
    }),
    C = t({
        address: 1,
        blockquote: 1,
        center: 1,
        dir: 1,
        div: 1,
        dl: 1,
        fieldset: 1,
        form: 1,
        h1: 1,
        h2: 1,
        h3: 1,
        h4: 1,
        h5: 1,
        h6: 1,
        hr: 1,
        isindex: 1,
        menu: 1,
        noframes: 1,
        ol: 1,
        p: 1,
        pre: 1,
        table: 1,
        ul: 1
    }),
    E = t({
        area: 1,
        base: 1,
        br: 1,
        col: 1,
        hr: 1,
        img: 1,
        input: 1,
        link: 1,
        meta: 1,
        param: 1,
        embed: 1
    });
    return t({
        $nonBodyContent: e(x, S, _),
        $block: C,
        $inline: p,
        $body: e(t({
            script: 1,
            style: 1
        }), C),
        $cdata: t({
            script: 1,
            style: 1
        }),
        $empty: E,
        $nonChild: t({
            iframe: 1
        }),
        $listItem: t({
            dd: 1,
            dt: 1,
            li: 1
        }),
        $list: t({
            ul: 1,
            ol: 1,
            dl: 1
        }),
        $isNotEmpty: t({
            table: 1,
            ul: 1,
            ol: 1,
            dl: 1,
            iframe: 1,
            area: 1,
            base: 1,
            col: 1,
            hr: 1,
            img: 1,
            embed: 1,
            input: 1,
            link: 1,
            meta: 1,
            param: 1
        }),
        $removeEmpty: t({
            a: 1,
            abbr: 1,
            acronym: 1,
            address: 1,
            b: 1,
            bdo: 1,
            big: 1,
            cite: 1,
            code: 1,
            del: 1,
            dfn: 1,
            em: 1,
            font: 1,
            i: 1,
            ins: 1,
            label: 1,
            kbd: 1,
            q: 1,
            s: 1,
            samp: 1,
            small: 1,
            span: 1,
            strike: 1,
            strong: 1,
            sub: 1,
            sup: 1,
            tt: 1,
            u: 1,
            "var": 1
        }),
        $removeEmptyBlock: t({
            p: 1,
            div: 1
        }),
        $tableContent: t({
            caption: 1,
            col: 1,
            colgroup: 1,
            tbody: 1,
            td: 1,
            tfoot: 1,
            th: 1,
            thead: 1,
            tr: 1,
            table: 1
        }),
        $notTransContent: t({
            pre: 1,
            script: 1,
            style: 1,
            textarea: 1
        }),
        html: S,
        head: w,
        style: m,
        script: m,
        body: v,
        base: {},
        link: {},
        meta: {},
        title: m,
        col: {},
        tr: t({
            td: 1,
            th: 1
        }),
        img: {},
        embed: {},
        colgroup: t({
            thead: 1,
            col: 1,
            tbody: 1,
            tr: 1,
            tfoot: 1
        }),
        noscript: v,
        td: v,
        br: {},
        th: v,
        center: v,
        kbd: p,
        button: e(d, a),
        basefont: {},
        h5: p,
        h4: p,
        samp: p,
        h6: p,
        ol: b,
        h1: p,
        h3: p,
        option: m,
        h2: p,
        form: e(i, o, a, d),
        select: t({
            optgroup: 1,
            option: 1
        }),
        font: p,
        ins: p,
        menu: b,
        abbr: p,
        label: p,
        table: t({
            thead: 1,
            col: 1,
            tbody: 1,
            tr: 1,
            colgroup: 1,
            caption: 1,
            tfoot: 1
        }),
        code: p,
        tfoot: f,
        cite: p,
        li: v,
        input: {},
        iframe: v,
        strong: p,
        textarea: m,
        noframes: v,
        big: p,
        small: p,
        span: {
            "#": 1
        },
        hr: p,
        dt: p,
        sub: p,
        optgroup: t({
            option: 1
        }),
        param: {},
        bdo: p,
        "var": p,
        div: v,
        object: g,
        sup: p,
        dd: v,
        strike: p,
        area: {},
        dir: b,
        map: e(t({
            area: 1,
            form: 1,
            p: 1
        }), i, r, a),
        applet: g,
        dl: t({
            dt: 1,
            dd: 1
        }),
        del: p,
        isindex: {},
        fieldset: e(t({
            legend: 1
        }), h),
        thead: f,
        ul: b,
        acronym: p,
        b: p,
        a: e(t({
            a: 1
        }), c),
        blockquote: e(t({
            td: 1,
            tr: 1,
            tbody: 1,
            li: 1
        }), v),
        caption: p,
        i: p,
        u: p,
        tbody: f,
        s: p,
        address: e(o, d),
        tt: p,
        legend: p,
        q: p,
        pre: e(l, s),
        p: e(t({
            a: 1
        }), p),
        em: p,
        dfn: p
    })
} (),
attrFix = ie && browser.version < 9 ? {
    tabindex: "tabIndex",
    readonly: "readOnly",
    "for": "htmlFor",
    "class": "className",
    maxlength: "maxLength",
    cellspacing: "cellSpacing",
    cellpadding: "cellPadding",
    rowspan: "rowSpan",
    colspan: "colSpan",
    usemap: "useMap",
    frameborder: "frameBorder"
}: {
    tabindex: "tabIndex",
    readonly: "readOnly"
},
styleBlock = utils.listToMap(["-webkit-box", "-moz-box", "block", "list-item", "table", "table-row-group", "table-header-group", "table-footer-group", "table-row", "table-column-group", "table-column", "table-cell", "table-caption"]),
domUtils = dom.domUtils = {
    NODE_ELEMENT: 1,
    NODE_DOCUMENT: 9,
    NODE_TEXT: 3,
    NODE_COMMENT: 8,
    NODE_DOCUMENT_FRAGMENT: 11,
    POSITION_IDENTICAL: 0,
    POSITION_DISCONNECTED: 1,
    POSITION_FOLLOWING: 2,
    POSITION_PRECEDING: 4,
    POSITION_IS_CONTAINED: 8,
    POSITION_CONTAINS: 16,
    fillChar: ie && "6" == browser.version ? "﻿": "​",
    keys: {
        8: 1,
        46: 1,
        16: 1,
        17: 1,
        18: 1,
        37: 1,
        38: 1,
        39: 1,
        40: 1,
        13: 1
    },
    getPosition: function(t, e) {
        if (t === e) return 0;
        var i,
        n = [t],
        s = [e];
        for (i = t; i = i.parentNode;) {
            if (i === e) return 10;
            n.push(i)
        }
        for (i = e; i = i.parentNode;) {
            if (i === t) return 20;
            s.push(i)
        }
        if (n.reverse(), s.reverse(), n[0] !== s[0]) return 1;
        for (var o = -1; o++, n[o] === s[o];);
        for (t = n[o], e = s[o]; t = t.nextSibling;) if (t === e) return 4;
        return 2
    },
    getNodeIndex: function(t) {
        for (var e = t.parentNode.firstChild, i = 0; t !== e;) i++,
        e = e.nextSibling;
        return i
    },
    inDoc: function(t, e) {
        for (; t = t.parentNode;) if (t === e) return ! 0;
        return ! 1
    },
    findParent: function(t, e, i) {
        if (!domUtils.isBody(t)) for (t = i ? t: t.parentNode; t;) {
            if (!e || e(t) || this.isBody(t)) return e && !e(t) && this.isBody(t) ? null: t;
            t = t.parentNode
        }
        return null
    },
    findParentByTagName: function(t, e, i, n) {
        if (t && t.nodeType && !this.isBody(t) && (1 == t.nodeType || t.nodeType)) for (e = utils.listToMap(utils.isArray(e) ? e: [e]), t = 3 != t.nodeType && i ? t: t.parentNode; t && t.tagName && 9 != t.nodeType && (!n || !n(t));) {
            if (e[t.tagName]) return t;
            t = t.parentNode
        }
        return null
    },
    findParents: function(t, e, i, n) {
        for (var s = e && (i && i(t) || !i) ? [t] : []; t = domUtils.findParent(t, i);) s.push(t);
        return n ? s: s.reverse()
    },
    insertAfter: function(t, e) {
        return t.parentNode.insertBefore(e, t.nextSibling)
    },
    remove: function(t, e) {
        var i,
        n = t.parentNode;
        if (n) {
            if (e && t.hasChildNodes()) for (; i = t.firstChild;) n.insertBefore(i, t);
            n.removeChild(t)
        }
        return t
    },
    getNextDomNode: function(t, e, i, n) {
        return getDomNode(t, "firstChild", "nextSibling", e, i, n)
    },
    isBookmarkNode: function(t) {
        return 1 == t.nodeType && t.id && /^_baidu_bookmark_/i.test(t.id)
    },
    getWindow: function(t) {
        var e = t.ownerDocument || t;
        return e.defaultView || e.parentWindow
    },
    getCommonAncestor: function(t, e) {
        if (t === e) return t;
        for (var i = [t], n = [e], s = t, o = -1; s = s.parentNode;) {
            if (s === e) return s;
            i.push(s)
        }
        for (s = e; s = s.parentNode;) {
            if (s === t) return s;
            n.push(s)
        }
        for (i.reverse(), n.reverse(); o++, i[o] === n[o];);
        return 0 == o ? null: i[o - 1]
    },
    clearEmptySibling: function(t, e, i) {
        function n(t, e) {
            for (var i; t && !domUtils.isBookmarkNode(t) && (domUtils.isEmptyInlineElement(t) || domUtils.isWhitespace(t));) i = t[e],
            domUtils.remove(t),
            t = i
        } ! e && n(t.nextSibling, "nextSibling"),
        !i && n(t.previousSibling, "previousSibling")
    },
    split: function(t, e) {
        var i = t.ownerDocument;
        if (browser.ie && e == t.nodeValue.length) {
            var n = i.createTextNode("");
            return domUtils.insertAfter(t, n)
        }
        var s = t.splitText(e);
        if (browser.ie8) {
            var o = i.createTextNode("");
            domUtils.insertAfter(s, o),
            domUtils.remove(o)
        }
        return s
    },
    isWhitespace: function(t) {
        return ! new RegExp("[^ 	\n\r" + domUtils.fillChar + "]").test(t.nodeValue)
    },
    getXY: function(t) {
        for (var e = 0, i = 0; t.offsetParent;) i += t.offsetTop,
        e += t.offsetLeft,
        t = t.offsetParent;
        return {
            x: e,
            y: i
        }
    },
    on: function(t, e, i) {
        var n = e instanceof Array ? e: [e],
        s = n.length;
        if (s) for (; s--;) if (e = n[s], t.addEventListener) t.addEventListener(e, i, !1);
        else {
            i._d || (i._d = {});
            var o = e + i.toString();
            i._d[o] || (i._d[o] = function(t) {
                return i.call(t.srcElement, t || window.event)
            },
            t.attachEvent("on" + e, i._d[o]))
        }
        t = null
    },
    un: function(t, e, i) {
        var n = e instanceof Array ? e: [e],
        s = n.length;
        if (s) for (; s--;) if (e = n[s], t.removeEventListener) t.removeEventListener(e, i, !1);
        else {
            var o = e + i.toString();
            t.detachEvent("on" + e, i._d ? i._d[o] : i),
            i._d && i._d[o] && delete i._d[o]
        }
    },
    isSameElement: function(t, e) {
        if (t.tagName != e.tagName) return 0;
        var i = t.attributes,
        n = e.attributes;
        if (!ie && i.length != n.length) return 0;
        for (var s, o, a = 0, r = 0, l = 0; s = i[l++];) {
            if ("style" == s.nodeName) {
                if (s.specified && a++, domUtils.isSameStyle(t, e)) continue;
                return 0
            }
            if (ie) {
                if (!s.specified) continue;
                a++,
                o = n.getNamedItem(s.nodeName)
            } else o = e.attributes[s.nodeName];
            if (!o.specified) return 0;
            if (s.nodeValue != o.nodeValue) return 0
        }
        if (ie) {
            for (l = 0; o = n[l++];) o.specified && r++;
            if (a != r) return 0
        }
        return 1
    },
    isSameStyle: function(t, e) {
        var i = t.style.cssText.replace(/( ?; ?)/g, ";").replace(/( ?: ?)/g, ":"),
        n = e.style.cssText.replace(/( ?; ?)/g, ";").replace(/( ?: ?)/g, ":");
        if (!i || !n) return i == n ? 1: 0;
        if (i = i.split(";"), n = n.split(";"), i.length != n.length) return 0;
        for (var s, o = 0; s = i[o++];) if ( - 1 == utils.indexOf(n, s)) return 0;
        return 1
    },
    isBlockElm: function(t) {
        return 1 == t.nodeType && (dtd.$block[t.tagName] || styleBlock[domUtils.getComputedStyle(t, "display")]) && !dtd.$nonChild[t.tagName]
    },
    isBody: function(t) {
        return t && 1 == t.nodeType && "body" == t.tagName.toLowerCase()
    },
    breakParent: function(t, e) {
        var i,
        n,
        s,
        o = t,
        a = t;
        do {
            for (o = o.parentNode, n ? (i = o.cloneNode(!1), i.appendChild(n), n = i, i = o.cloneNode(!1), i.appendChild(s), s = i) : (n = o.cloneNode(!1), s = n.cloneNode(!1)); i = a.previousSibling;) n.insertBefore(i, n.firstChild);
            for (; i = a.nextSibling;) s.appendChild(i);
            a = o
        }
        while (e !== o);
        return i = e.parentNode,
        i.insertBefore(n, e),
        i.insertBefore(s, e),
        i.insertBefore(t, s),
        domUtils.remove(e),
        t
    },
    isEmptyInlineElement: function(t) {
        if (1 != t.nodeType || !dtd.$removeEmpty[t.tagName]) return 0;
        for (t = t.firstChild; t;) {
            if (domUtils.isBookmarkNode(t)) return 0;
            if (1 == t.nodeType && !domUtils.isEmptyInlineElement(t) || 3 == t.nodeType && !domUtils.isWhitespace(t)) return 0;
            t = t.nextSibling
        }
        return 1
    },
    trimWhiteTextNode: function(t) {
        function e(e) {
            for (var i; (i = t[e]) && 3 == i.nodeType && domUtils.isWhitespace(i);) t.removeChild(i)
        }
        e("firstChild"),
        e("lastChild")
    },
    mergChild: function(t, e, i) {
        for (var n, s = domUtils.getElementsByTagName(t, t.tagName.toLowerCase()), o = 0; n = s[o++];) if (n.parentNode && !domUtils.isBookmarkNode(n)) if ("span" != n.tagName.toLowerCase()) domUtils.isSameElement(t, n) && domUtils.remove(n, !0);
        else {
            if (t === n.parentNode && (domUtils.trimWhiteTextNode(t), 1 == t.childNodes.length)) {
                t.style.cssText = n.style.cssText + ";" + t.style.cssText,
                domUtils.remove(n, !0);
                continue
            }
            if (n.style.cssText = t.style.cssText + ";" + n.style.cssText, i) {
                var a = i.style;
                if (a) {
                    a = a.split(";");
                    for (var r, l = 0; r = a[l++];) n.style[utils.cssStyleToDomStyle(r.split(":")[0])] = r.split(":")[1]
                }
            }
            domUtils.isSameStyle(n, t) && domUtils.remove(n, !0)
        }
        if ("span" == e) for (var u, d = domUtils.getElementsByTagName(t, "a"), o = 0; u = d[o++];) u.style.cssText = ";" + t.style.cssText,
        u.style.textDecoration = "underline"
    },
    getElementsByTagName: function(t, e) {
        for (var i, n = t.getElementsByTagName(e), s = [], o = 0; i = n[o++];) s.push(i);
        return s
    },
    mergToParent: function(t) {
        for (var e = t.parentNode; e && dtd.$removeEmpty[e.tagName];) {
            if (e.tagName == t.tagName || "A" == e.tagName) {
                if (domUtils.trimWhiteTextNode(e), "SPAN" == e.tagName && !domUtils.isSameStyle(e, t) || "A" == e.tagName && "SPAN" == t.tagName) {
                    if (e.childNodes.length > 1 || e !== t.parentNode) {
                        t.style.cssText = e.style.cssText + ";" + t.style.cssText,
                        e = e.parentNode;
                        continue
                    }
                    e.style.cssText += ";" + t.style.cssText,
                    "A" == e.tagName && (e.style.textDecoration = "underline")
                }
                if ("A" != e.tagName) {
                    e === t.parentNode && domUtils.remove(t, !0);
                    break
                }
            }
            e = e.parentNode
        }
    },
    mergSibling: function(t, e, i) {
        function n(t, e, i) {
            var n;
            if ((n = i[t]) && !domUtils.isBookmarkNode(n) && 1 == n.nodeType && domUtils.isSameElement(i, n)) {
                for (; n.firstChild;)"firstChild" == e ? i.insertBefore(n.lastChild, i.firstChild) : i.appendChild(n.firstChild);
                domUtils.remove(n)
            }
        } ! e && n("previousSibling", "firstChild", t),
        !i && n("nextSibling", "lastChild", t)
    },
    unselectable: gecko ? 
    function(t) {
        t.style.MozUserSelect = "none"
    }: webkit ? 
    function(t) {
        t.style.KhtmlUserSelect = "none"
    }: function(t) {
        t.onselectstart = function() {
            return ! 1
        },
        t.onclick = t.onkeyup = t.onkeydown = function() {
            return ! 1
        },
        t.unselectable = "on",
        t.setAttribute("unselectable", "on");
        for (var e, i = 0; e = t.all[i++];) switch (e.tagName.toLowerCase()) {
        case "iframe":
        case "textarea":
        case "input":
        case "select":
            break;
        default:
            e.unselectable = "on",
            t.setAttribute("unselectable", "on")
        }
    },
    removeAttributes: function(t, e) {
        for (var i, n = 0; i = e[n++];) {
            switch (i = attrFix[i] || i) {
            case "className":
                t[i] = "";
                break;
            case "style":
                t.style.cssText = "",
                !browser.ie && t.removeAttributeNode(t.getAttributeNode("style"))
            }
            t.removeAttribute(i)
        }
    },
    setAttributes: function(t, e) {
        for (var i in e) {
            var n = e[i];
            switch (i) {
            case "class":
                t.className = n;
                break;
            case "style":
                t.style.cssText = t.style.cssText + ";" + n;
                break;
            case "innerHTML":
                t[i] = n;
                break;
            case "value":
                t.value = n;
                break;
            default:
                t.setAttribute(attrFix[i] || i, n)
            }
        }
        return t
    },
    getComputedStyle: function(t, e) {
        function i(t, e) {
            return "font-size" == t && /pt$/.test(e) && (e = Math.round(parseFloat(e) / .75) + "px"),
            e
        }
        if (3 == t.nodeType && (t = t.parentNode), browser.ie && browser.version < 9 && "font-size" == e && !t.style.fontSize && !dtd.$empty[t.tagName] && !dtd.$nonChild[t.tagName]) {
            var n = t.ownerDocument.createElement("span");
            n.style.cssText = "padding:0;border:0;font-family:simsun;",
            n.innerHTML = ".",
            t.appendChild(n);
            var s = n.offsetHeight;
            return t.removeChild(n),
            n = null,
            s + "px"
        }
        try {
            var o = domUtils.getStyle(t, e) || (window.getComputedStyle ? domUtils.getWindow(t).getComputedStyle(t, "").getPropertyValue(e) : (t.currentStyle || t.style)[utils.cssStyleToDomStyle(e)])
        } catch(a) {
            return null
        }
        return i(e, utils.fixColor(e, o))
    },
    removeClasses: function(t, e) {
        t.className = (" " + t.className + " ").replace(new RegExp("(?:\\s+(?:" + e.join("|") + "))+\\s+", "g"), " ")
    },
    removeStyle: function(t, e) {
        t.style[utils.cssStyleToDomStyle(e)] = "",
        t.style.cssText || domUtils.removeAttributes(t, ["style"])
    },
    hasClass: function(t, e) {
        return (" " + t.className + " ").indexOf(" " + e + " ") > -1
    },
    preventDefault: function(t) {
        t.preventDefault ? t.preventDefault() : t.returnValue = !1
    },
    getStyle: function(t, e) {
        var i = t.style[utils.cssStyleToDomStyle(e)];
        return utils.fixColor(e, i)
    },
    setStyle: function(t, e, i) {
        t.style[utils.cssStyleToDomStyle(e)] = i
    },
    setStyles: function(t, e) {
        for (var i in e) e.hasOwnProperty(i) && domUtils.setStyle(t, i, e[i])
    },
    removeDirtyAttr: function(t) {
        for (var e, i = 0, n = t.getElementsByTagName("*"); e = n[i++];) e.removeAttribute("_moz_dirty");
        t.removeAttribute("_moz_dirty")
    },
    getChildCount: function(t, e) {
        var i = 0,
        n = t.firstChild;
        for (e = e || 
        function() {
            return 1
        }; n;) e(n) && i++,
        n = n.nextSibling;
        return i
    },
    isEmptyNode: function(t) {
        return ! t.firstChild || 0 == domUtils.getChildCount(t, 
        function(t) {
            return ! domUtils.isBr(t) && !domUtils.isBookmarkNode(t) && !domUtils.isWhitespace(t)
        })
    },
    clearSelectedArr: function(t) {
        for (var e; e = t.pop();) domUtils.removeAttributes(e, ["class"])
    },
    scrollToView: function(t, e, i) {
        var n = function() {
            var t = e.document,
            i = "CSS1Compat" == t.compatMode;
            return {
                width: (i ? t.documentElement.clientWidth: t.body.clientWidth) || 0,
                height: (i ? t.documentElement.clientHeight: t.body.clientHeight) || 0
            }
        },
        s = function(t) {
            if ("pageXOffset" in t) return {
                x: t.pageXOffset || 0,
                y: t.pageYOffset || 0
            };
            var e = t.document;
            return {
                x: e.documentElement.scrollLeft || e.body.scrollLeft || 0,
                y: e.documentElement.scrollTop || e.body.scrollTop || 0
            }
        },
        o = n().height,
        a = -1 * o + i;
        a += t.offsetHeight || 0;
        var r = domUtils.getXY(t);
        a += r.y;
        var l = s(e).y; (a > l || l - o > a) && e.scrollTo(0, a + (0 > a ? -20: 20))
    },
    isBr: function(t) {
        return 1 == t.nodeType && "BR" == t.tagName
    },
    isFillChar: function(t) {
        return 3 == t.nodeType && !t.nodeValue.replace(new RegExp(domUtils.fillChar), "").length
    },
    isStartInblock: function(t) {
        for (var e, i = t.cloneRange(), n = 0, s = i.startContainer; s && domUtils.isFillChar(s);) e = s,
        s = s.previousSibling;
        for (e && (i.setStartBefore(e), s = i.startContainer), 1 == s.nodeType && domUtils.isEmptyNode(s) && 1 == i.startOffset && i.setStart(s, 0).collapse(!0); ! i.startOffset;) {
            if (s = i.startContainer, domUtils.isBlockElm(s) || domUtils.isBody(s)) {
                n = 1;
                break
            }
            var o,
            a = i.startContainer.previousSibling;
            if (a) {
                for (; a && domUtils.isFillChar(a);) o = a,
                a = a.previousSibling;
                o ? i.setStartBefore(o) : i.setStartBefore(i.startContainer)
            } else i.setStartBefore(i.startContainer)
        }
        return n && !domUtils.isBody(i.startContainer) ? 1: 0
    },
    isEmptyBlock: function(t) {
        var e = new RegExp("[ 	\r\n" + domUtils.fillChar + "]", "g");
        if (t[browser.ie ? "innerText": "textContent"].replace(e, "").length > 0) return 0;
        for (var i in dtd.$isNotEmpty) if (t.getElementsByTagName(i).length) return 0;
        return 1
    },
    setViewportOffset: function(t, e) {
        var i = 0 | parseInt(t.style.left),
        n = 0 | parseInt(t.style.top),
        s = t.getBoundingClientRect(),
        o = e.left - s.left,
        a = e.top - s.top;
        o && (t.style.left = i + o + "px"),
        a && (t.style.top = n + a + "px")
    },
    fillNode: function(t, e) {
        e.appendChild(browser.ie ? t.createTextNode(domUtils.fillChar) : t.createElement("br"))
    },
    moveChild: function(t, e, i) {
        for (; t.firstChild;) i && e.firstChild ? e.insertBefore(t.lastChild, e.firstChild) : e.appendChild(t.firstChild)
    },
    hasNoAttributes: function(t) {
        return browser.ie ? /^<\w+\s*?>/.test(t.outerHTML) : 0 == t.attributes.length
    }
},
fillCharReg = new RegExp(domUtils.fillChar, "g"); ! 
function() {
    function t(t) {
        t.collapsed = t.startContainer && t.endContainer && t.startContainer === t.endContainer && t.startOffset == t.endOffset
    }
    function e(e, i, n, s) {
        return 1 == i.nodeType && (dtd.$empty[i.tagName] || dtd.$nonChild[i.tagName]) && (n = domUtils.getNodeIndex(i) + (e ? 0: 1), i = i.parentNode),
        e ? (s.startContainer = i, s.startOffset = n, s.endContainer || s.collapse(!0)) : (s.endContainer = i, s.endOffset = n, s.startContainer || s.collapse(!1)),
        t(s),
        s
    }
    function i(t, e) {
        var i,
        n,
        s = t.startContainer,
        o = t.endContainer,
        a = t.startOffset,
        r = t.endOffset,
        l = t.document,
        u = l.createDocumentFragment();
        if (1 == s.nodeType && (s = s.childNodes[a] || (i = s.appendChild(l.createTextNode("")))), 1 == o.nodeType && (o = o.childNodes[r] || (n = o.appendChild(l.createTextNode("")))), s === o && 3 == s.nodeType) return u.appendChild(l.createTextNode(s.substringData(a, r - a))),
        e && (s.deleteData(a, r - a), t.collapse(!0)),
        u;
        for (var d, c, h = u, p = domUtils.findParents(s, !0), f = domUtils.findParents(o, !0), m = 0; p[m] == f[m]; m++);
        for (var g, v = m; g = p[v]; v++) {
            for (d = g.nextSibling, g == s ? i || (3 == t.startContainer.nodeType ? (h.appendChild(l.createTextNode(s.nodeValue.slice(a))), e && s.deleteData(a, s.nodeValue.length - a)) : h.appendChild(e ? s: s.cloneNode(!0))) : (c = g.cloneNode(!1), h.appendChild(c)); d && d !== o && d !== f[v];) g = d.nextSibling,
            h.appendChild(e ? d: d.cloneNode(!0)),
            d = g;
            h = c
        }
        h = u,
        p[m] || (h.appendChild(p[m - 1].cloneNode(!1)), h = h.firstChild);
        for (var b, v = m; b = f[v]; v++) {
            if (d = b.previousSibling, b == o ? n || 3 != t.endContainer.nodeType || (h.appendChild(l.createTextNode(o.substringData(0, r))), e && o.deleteData(0, r)) : (c = b.cloneNode(!1), h.appendChild(c)), v != m || !p[m]) for (; d && d !== s;) b = d.previousSibling,
            h.insertBefore(e ? d: d.cloneNode(!0), h.firstChild),
            d = b;
            h = c
        }
        return e && t.setStartBefore(f[m] ? p[m] ? f[m] : p[m - 1] : f[m - 1]).collapse(!0),
        i && domUtils.remove(i),
        n && domUtils.remove(n),
        u
    }
    function n(t) {
        try {
            if (o && domUtils.inDoc(o, t)) if (o.nodeValue.replace(fillCharReg, "").length) o.nodeValue = o.nodeValue.replace(fillCharReg, "");
            else {
                var e = o.parentNode;
                for (domUtils.remove(o); e && domUtils.isEmptyInlineElement(e);) o = e.parentNode,
                domUtils.remove(e),
                e = o
            }
        } catch(i) {}
    }
    function s(t, e) {
        var i;
        for (t = t[e]; t && domUtils.isFillChar(t);) i = t[e],
        domUtils.remove(t),
        t = i
    }
    var o,
    a = 0,
    r = domUtils.fillChar,
    l = dom.Range = function(t) {
        var e = this;
        e.startContainer = e.startOffset = e.endContainer = e.endOffset = null,
        e.document = t,
        e.collapsed = !0
    };
    l.prototype = {
        cloneContents: function() {
            return this.collapsed ? null: i(this, 0)
        },
        deleteContents: function() {
            if (this.collapsed || i(this, 1), browser.webkit) {
                var t = this.startContainer;
                3 != t.nodeType || t.nodeValue.length || (this.setStartBefore(t).collapse(!0), domUtils.remove(t))
            }
            return this
        },
        extractContents: function() {
            return this.collapsed ? null: i(this, 2)
        },
        setStart: function(t, i) {
            return e(!0, t, i, this)
        },
        setEnd: function(t, i) {
            return e(!1, t, i, this)
        },
        setStartAfter: function(t) {
            return this.setStart(t.parentNode, domUtils.getNodeIndex(t) + 1)
        },
        setStartBefore: function(t) {
            return this.setStart(t.parentNode, domUtils.getNodeIndex(t))
        },
        setEndAfter: function(t) {
            return this.setEnd(t.parentNode, domUtils.getNodeIndex(t) + 1)
        },
        setEndBefore: function(t) {
            return this.setEnd(t.parentNode, domUtils.getNodeIndex(t))
        },
        selectNode: function(t) {
            return this.setStartBefore(t).setEndAfter(t)
        },
        selectNodeContents: function(t) {
            return this.setStart(t, 0).setEnd(t, 3 == t.nodeType ? t.nodeValue.length: t.childNodes.length)
        },
        cloneRange: function() {
            var t = this,
            e = new l(t.document);
            return e.setStart(t.startContainer, t.startOffset).setEnd(t.endContainer, t.endOffset)
        },
        collapse: function(t) {
            var e = this;
            return t ? (e.endContainer = e.startContainer, e.endOffset = e.startOffset) : (e.startContainer = e.endContainer, e.startOffset = e.endOffset),
            e.collapsed = !0,
            e
        },
        shrinkBoundary: function(t) {
            for (var e, i = this, n = i.collapsed; 1 == i.startContainer.nodeType && (e = i.startContainer.childNodes[i.startOffset]) && 1 == e.nodeType && !domUtils.isBookmarkNode(e) && !dtd.$empty[e.tagName] && !dtd.$nonChild[e.tagName];) i.setStart(e, 0);
            if (n) return i.collapse(!0);
            if (!t) for (; 1 == i.endContainer.nodeType && i.endOffset > 0 && (e = i.endContainer.childNodes[i.endOffset - 1]) && 1 == e.nodeType && !domUtils.isBookmarkNode(e) && !dtd.$empty[e.tagName] && !dtd.$nonChild[e.tagName];) i.setEnd(e, e.childNodes.length);
            return i
        },
        getCommonAncestor: function(t, e) {
            var i = this.startContainer,
            n = this.endContainer;
            return i === n ? t && 1 == i.nodeType && this.startOffset == this.endOffset - 1 ? i.childNodes[this.startOffset] : e && 3 == i.nodeType ? i.parentNode: i: domUtils.getCommonAncestor(i, n)
        },
        trimBoundary: function(t) {
            this.txtToElmBoundary();
            var e = this.startContainer,
            i = this.startOffset,
            n = this.collapsed,
            s = this.endContainer;
            if (3 == e.nodeType) {
                if (0 == i) this.setStartBefore(e);
                else if (i >= e.nodeValue.length) this.setStartAfter(e);
                else {
                    var o = domUtils.split(e, i);
                    e === s ? this.setEnd(o, this.endOffset - i) : e.parentNode === s && (this.endOffset += 1),
                    this.setStartBefore(o)
                }
                if (n) return this.collapse(!0)
            }
            return t || (i = this.endOffset, s = this.endContainer, 3 == s.nodeType && (0 == i ? this.setEndBefore(s) : i >= s.nodeValue.length ? this.setEndAfter(s) : (domUtils.split(s, i), this.setEndAfter(s)))),
            this
        },
        txtToElmBoundary: function() {
            function t(t, e) {
                var i = t[e + "Container"],
                n = t[e + "Offset"];
                3 == i.nodeType && (n ? n >= i.nodeValue.length && t["set" + e.replace(/(\w)/, 
                function(t) {
                    return t.toUpperCase()
                }) + "After"](i) : t["set" + e.replace(/(\w)/, 
                function(t) {
                    return t.toUpperCase()
                }) + "Before"](i))
            }
            return this.collapsed || (t(this, "start"), t(this, "end")),
            this
        },
        insertNode: function(t) {
            var e = t,
            i = 1;
            11 == t.nodeType && (e = t.firstChild, i = t.childNodes.length),
            this.trimBoundary(!0);
            var n = this.startContainer,
            s = this.startOffset,
            o = n.childNodes[s];
            return o ? n.insertBefore(t, o) : n.appendChild(t),
            e.parentNode === this.endContainer && (this.endOffset = this.endOffset + i),
            this.setStartBefore(e)
        },
        setCursor: function(t, e) {
            return this.collapse(t ? !1: !0).select(e)
        },
        createBookmark: function(t, e) {
            var i,
            n = this.document.createElement("span");
            return n.style.cssText = "display:none;line-height:0px;",
            n.appendChild(this.document.createTextNode("﻿")),
            n.id = "_baidu_bookmark_start_" + (e ? "": a++),
            this.collapsed || (i = n.cloneNode(!0), i.id = "_baidu_bookmark_end_" + (e ? "": a++)),
            this.insertNode(n),
            i && (this.collapse(!1).insertNode(i), this.setEndBefore(i)),
            this.setStartAfter(n),
            {
                start: t ? n.id: n,
                end: i ? t ? i.id: i: null,
                id: t
            }
        },
        moveToBookmark: function(t) {
            var e = t.id ? this.document.getElementById(t.start) : t.start,
            i = t.end && t.id ? this.document.getElementById(t.end) : t.end;
            return this.setStartBefore(e),
            domUtils.remove(e),
            i ? (this.setEndBefore(i), domUtils.remove(i)) : this.collapse(!0),
            this
        },
        enlarge: function(t, e) {
            var i,
            n,
            s = domUtils.isBody,
            o = this.document.createTextNode("");
            if (t) {
                for (n = this.startContainer, 1 == n.nodeType ? n.childNodes[this.startOffset] ? i = n = n.childNodes[this.startOffset] : (n.appendChild(o), i = n = o) : i = n;;) {
                    if (domUtils.isBlockElm(n)) {
                        for (n = i; (i = n.previousSibling) && !domUtils.isBlockElm(i);) n = i;
                        this.setStartBefore(n);
                        break
                    }
                    i = n,
                    n = n.parentNode
                }
                for (n = this.endContainer, 1 == n.nodeType ? ((i = n.childNodes[this.endOffset]) ? n.insertBefore(o, i) : n.appendChild(o), i = n = o) : i = n;;) {
                    if (domUtils.isBlockElm(n)) {
                        for (n = i; (i = n.nextSibling) && !domUtils.isBlockElm(i);) n = i;
                        this.setEndAfter(n);
                        break
                    }
                    i = n,
                    n = n.parentNode
                }
                o.parentNode === this.endContainer && this.endOffset--,
                domUtils.remove(o)
            }
            if (!this.collapsed) {
                for (; ! (0 != this.startOffset || e && e(this.startContainer) || s(this.startContainer));) this.setStartBefore(this.startContainer);
                for (; ! (this.endOffset != (1 == this.endContainer.nodeType ? this.endContainer.childNodes.length: this.endContainer.nodeValue.length) || e && e(this.endContainer) || s(this.endContainer));) this.setEndAfter(this.endContainer)
            }
            return this
        },
        adjustmentBoundary: function() {
            if (!this.collapsed) {
                for (; ! domUtils.isBody(this.startContainer) && this.startOffset == this.startContainer[3 == this.startContainer.nodeType ? "nodeValue": "childNodes"].length;) this.setStartAfter(this.startContainer);
                for (; ! domUtils.isBody(this.endContainer) && !this.endOffset;) this.setEndBefore(this.endContainer)
            }
            return this
        },
        applyInlineStyle: function(t, e, i) {
            if (this.collapsed) return this;
            this.trimBoundary().enlarge(!1, 
            function(t) {
                return 1 == t.nodeType && domUtils.isBlockElm(t)
            }).adjustmentBoundary();
            for (var n, s, o = this.createBookmark(), a = o.end, r = function(t) {
                return 1 == t.nodeType ? "br" != t.tagName.toLowerCase() : !domUtils.isWhitespace(t)
            },
            l = domUtils.getNextDomNode(o.start, !1, r), u = this.cloneRange(); l && domUtils.getPosition(l, a) & domUtils.POSITION_PRECEDING;) if (3 == l.nodeType || dtd[t][l.tagName]) {
                for (u.setStartBefore(l), n = l; n && (3 == n.nodeType || dtd[t][n.tagName]) && n !== a;) s = n,
                n = domUtils.getNextDomNode(n, 1 == n.nodeType, null, 
                function(e) {
                    return dtd[t][e.tagName]
                });
                var d,
                c = u.setEndAfter(s).extractContents();
                if (i && i.length > 0) {
                    var h,
                    p;
                    p = h = i[0].cloneNode(!1);
                    for (var f, m = 1; f = i[m++];) h.appendChild(f.cloneNode(!1)),
                    h = h.firstChild;
                    d = h
                } else d = u.document.createElement(t);
                e && domUtils.setAttributes(d, e),
                d.appendChild(c),
                u.insertNode(i ? p: d);
                var g;
                if ("span" == t && e.style && /text\-decoration/.test(e.style) && (g = domUtils.findParentByTagName(d, "a", !0)) ? (domUtils.setAttributes(g, e), domUtils.remove(d, !0), d = g) : (domUtils.mergSibling(d), domUtils.clearEmptySibling(d)), domUtils.mergChild(d, t, e), l = domUtils.getNextDomNode(d, !1, r), domUtils.mergToParent(d), n === a) break
            } else l = domUtils.getNextDomNode(l, !0, r);
            return this.moveToBookmark(o)
        },
        removeInlineStyle: function(t) {
            if (this.collapsed) return this;
            t = utils.isArray(t) ? t: [t],
            this.shrinkBoundary().adjustmentBoundary();
            for (var e = this.startContainer, i = this.endContainer;;) {
                if (1 == e.nodeType) {
                    if (utils.indexOf(t, e.tagName.toLowerCase()) > -1) break;
                    if ("body" == e.tagName.toLowerCase()) {
                        e = null;
                        break
                    }
                }
                e = e.parentNode
            }
            for (;;) {
                if (1 == i.nodeType) {
                    if (utils.indexOf(t, i.tagName.toLowerCase()) > -1) break;
                    if ("body" == i.tagName.toLowerCase()) {
                        i = null;
                        break
                    }
                }
                i = i.parentNode
            }
            var n,
            s,
            o = this.createBookmark();
            e && (s = this.cloneRange().setEndBefore(o.start).setStartBefore(e), n = s.extractContents(), s.insertNode(n), domUtils.clearEmptySibling(e, !0), e.parentNode.insertBefore(o.start, e)),
            i && (s = this.cloneRange().setStartAfter(o.end).setEndAfter(i), n = s.extractContents(), s.insertNode(n), domUtils.clearEmptySibling(i, !1, !0), i.parentNode.insertBefore(o.end, i.nextSibling));
            for (var a, r = domUtils.getNextDomNode(o.start, !1, 
            function(t) {
                return 1 == t.nodeType
            }); r && r !== o.end;) a = domUtils.getNextDomNode(r, !0, 
            function(t) {
                return 1 == t.nodeType
            }),
            utils.indexOf(t, r.tagName.toLowerCase()) > -1 && domUtils.remove(r, !0),
            r = a;
            return this.moveToBookmark(o)
        },
        getClosedNode: function() {
            var t;
            if (!this.collapsed) {
                var e = this.cloneRange().adjustmentBoundary().shrinkBoundary();
                if (1 == e.startContainer.nodeType && e.startContainer === e.endContainer && 1 == e.endOffset - e.startOffset) {
                    var i = e.startContainer.childNodes[e.startOffset];
                    i && 1 == i.nodeType && (dtd.$empty[i.tagName] || dtd.$nonChild[i.tagName]) && (t = i)
                }
            }
            return t
        },
        select: browser.ie ? 
        function(t, e) {
            var i;
            this.collapsed || this.shrinkBoundary();
            var a = this.getClosedNode();
            if (a && !e) {
                try {
                    i = this.document.body.createControlRange(),
                    i.addElement(a),
                    i.select()
                } catch(l) {}
                return this
            }
            var u,
            d = this.createBookmark(),
            c = d.start;
            if (i = this.document.body.createTextRange(), i.moveToElementText(c), i.moveStart("character", 1), this.collapsed) {
                if (!t && 3 != this.startContainer.nodeType) {
                    var h,
                    p = this.document.createElement("span");
                    n(this.document),
                    h = o = this.document.createTextNode(r),
                    p.appendChild(this.document.createTextNode(r)),
                    c.parentNode.insertBefore(p, c),
                    c.parentNode.insertBefore(h, c),
                    s(p, "previousSibling"),
                    s(c, "nextSibling"),
                    i.moveStart("character", -1),
                    i.collapse(!0)
                }
            } else {
                var f = this.document.body.createTextRange();
                u = d.end,
                f.moveToElementText(u),
                i.setEndPoint("EndToEnd", f)
            }
            return this.moveToBookmark(d),
            p && domUtils.remove(p),
            i.select(),
            this
        }: function(t) {
            var e,
            i = domUtils.getWindow(this.document),
            a = i.getSelection();
            if (browser.gecko ? this.document.body.focus() : i.focus(), a) {
                a.removeAllRanges(),
                this.collapsed && !t && (e = this.document.createTextNode(r), this.insertNode(e), n(this.document), s(e, "previousSibling"), s(e, "nextSibling"), o = e, this.setStart(e, browser.webkit ? 1: 0).collapse(!0));
                var l = this.document.createRange();
                l.setStart(this.startContainer, this.startOffset),
                l.setEnd(this.endContainer, this.endOffset),
                a.addRange(l)
            }
            return this
        },
        scrollToView: function(t, e) {
            t = t ? window: domUtils.getWindow(this.document);
            var i = this.document.createElement("span");
            i.innerHTML = "&nbsp;";
            var n = this.cloneRange();
            return n.insertNode(i),
            domUtils.scrollToView(i, t, e),
            domUtils.remove(i),
            this
        }
    }
} (),
function() {
    function t(t, e) {
        var i = domUtils.getNodeIndex;
        t = t.duplicate(),
        t.collapse(e);
        var n = t.parentElement();
        if (!n.hasChildNodes()) return {
            container: n,
            offset: 0
        };
        for (var s, o, a = n.children, r = t.duplicate(), l = 0, u = a.length - 1, d = -1; u >= l;) {
            d = Math.floor((l + u) / 2),
            s = a[d],
            r.moveToElementText(s);
            var c = r.compareEndPoints("StartToStart", t);
            if (c > 0) u = d - 1;
            else {
                if (! (0 > c)) return {
                    container: n,
                    offset: i(s)
                };
                l = d + 1
            }
        }
        if ( - 1 == d) {
            if (r.moveToElementText(n), r.setEndPoint("StartToStart", t), o = r.text.replace(/(\r\n|\r)/g, "\n").length, a = n.childNodes, !o) return s = a[a.length - 1],
            {
                container: s,
                offset: s.nodeValue.length
            };
            for (var h = a.length; o > 0;) o -= a[--h].nodeValue.length;
            return {
                container: a[h],
                offset: -o
            }
        }
        if (r.collapse(c > 0), r.setEndPoint(c > 0 ? "StartToStart": "EndToStart", t), o = r.text.replace(/(\r\n|\r)/g, "\n").length, !o) return dtd.$empty[s.tagName] || dtd.$nonChild[s.tagName] ? {
            container: n,
            offset: i(s) + (c > 0 ? 0: 1)
        }: {
            container: s,
            offset: c > 0 ? 0: s.childNodes.length
        };
        for (; o > 0;) try {
            var p = s;
            s = s[c > 0 ? "previousSibling": "nextSibling"],
            o -= s.nodeValue.length
        } catch(f) {
            return {
                container: n,
                offset: i(p)
            }
        }
        return {
            container: s,
            offset: c > 0 ? -o: s.nodeValue.length + o
        }
    }
    function e(e, i) {
        if (e.item) i.selectNode(e.item(0));
        else {
            var n = t(e, !0);
            i.setStart(n.container, n.offset),
            0 != e.compareEndPoints("StartToEnd", e) && (n = t(e, !1), i.setEnd(n.container, n.offset))
        }
        return i
    }
    function i(t) {
        var e;
        try {
            e = t.getNative().createRange()
        } catch(i) {
            return null
        }
        var n = e.item ? e.item(0) : e.parentElement();
        return (n.ownerDocument || n) === t.document ? e: null
    }
    var n = dom.Selection = function(t) {
        var e,
        n = this;
        n.document = t,
        ie && (e = domUtils.getWindow(t).frameElement, domUtils.on(e, "beforedeactivate", 
        function() {
            n._bakIERange = n.getIERange()
        }), domUtils.on(e, "activate", 
        function() {
            try { ! i(n) && n._bakIERange && n._bakIERange.select()
            } catch(t) {}
            n._bakIERange = null
        })),
        e = t = null
    };
    n.prototype = {
        getNative: function() {
            var t = this.document;
            return t ? ie ? t.selection: domUtils.getWindow(t).getSelection() : null
        },
        getIERange: function() {
            var t = i(this);
            return ! t && this._bakIERange ? this._bakIERange: t
        },
        cache: function() {
            this.clear(),
            this._cachedRange = this.getRange(),
            this._cachedStartElement = this.getStart(),
            this._cachedStartElementPath = this.getStartElementPath()
        },
        getStartElementPath: function() {
            if (this._cachedStartElementPath) return this._cachedStartElementPath;
            var t = this.getStart();
            return t ? domUtils.findParents(t, !0, null, !0) : []
        },
        clear: function() {
            this._cachedStartElementPath = this._cachedRange = this._cachedStartElement = null
        },
        isFocus: function() {
            return browser.ie && i(this) || !browser.ie && this.getNative().rangeCount ? !0: !1
        },
        getRange: function() {
            function t(t) {
                for (var e = i.document.body.firstChild, n = t.collapsed; e && e.firstChild;) t.setStart(e, 0),
                e = e.firstChild;
                t.startContainer || t.setStart(i.document.body, 0),
                n && t.collapse(!0)
            }
            var i = this;
            if (null != i._cachedRange) return this._cachedRange;
            var n = new baidu.editor.dom.Range(i.document);
            if (ie) {
                var s = i.getIERange();
                s ? e(s, n) : t(n)
            } else {
                var o = i.getNative();
                if (o && o.rangeCount) {
                    var a = o.getRangeAt(0),
                    r = o.getRangeAt(o.rangeCount - 1);
                    n.setStart(a.startContainer, a.startOffset).setEnd(r.endContainer, r.endOffset),
                    n.collapsed && domUtils.isBody(n.startContainer) && !n.startOffset && t(n)
                } else {
                    if (this._bakRange && domUtils.inDoc(this._bakRange.startContainer, this.document)) return this._bakRange;
                    t(n)
                }
            }
            return this._bakRange = n
        },
        getStart: function() {
            if (this._cachedStartElement) return this._cachedStartElement;
            var t,
            e,
            i,
            n,
            s = ie ? this.getIERange() : this.getRange();
            if (ie) {
                if (!s) return this.document.body.firstChild;
                if (s.item) return s.item(0);
                for (t = s.duplicate(), t.text.length > 0 && t.moveStart("character", 1), t.collapse(1), e = t.parentElement(), n = i = s.parentElement(); i = i.parentNode;) if (i == e) {
                    e = n;
                    break
                }
            } else if (s.shrinkBoundary(), e = s.startContainer, 1 == e.nodeType && e.hasChildNodes() && (e = e.childNodes[Math.min(e.childNodes.length - 1, s.startOffset)]), 3 == e.nodeType) return e.parentNode;
            return e
        },
        getText: function() {
            if (this.isFocus()) {
                var t = this.getNative(),
                e = browser.ie ? t.createRange() : t.getRangeAt(0);
                return e.text || e.toString()
            }
            return ""
        }
    }
} (),
function() {
    function t(t) {
        for (var e, i, n = t.getElementsByTagName("img"), s = 0; i = n[s++];)(e = i.getAttribute("orgSrc")) && (i.src = e, i.removeAttribute("orgSrc"));
        for (var o, a = t.getElementsByTagName("a"), s = 0; o = a[s++]; s++) o.getAttribute("data_ue_src") && o.setAttribute("href", o.getAttribute("data_ue_src"))
    }
    var e,
    i = 0,
    n = UE.Editor = function(t) {
        var e = this;
        e.uid = i++,
        EventBase.call(e),
        e.commands = {},
        e.options = utils.extend(t || {},
        UEDITOR_CONFIG, !0);
        for (var n in UE.plugins) UE.plugins[n].call(e)
    };
    n.prototype = {
        destroy: function() {
            this.fireEvent("destroy"),
            this.container.innerHTML = "",
            domUtils.remove(this.container)
        },
        render: function(t) {
            t.constructor === String && (t = document.getElementById(t)),
            t && (t.innerHTML = '<iframe id="baidu_editor_' + this.uid + '"' + 'width="100%" height="100%"  frameborder="0"></iframe>', t.style.overflow = "hidden", this._setup(t.firstChild.contentWindow.document))
        },
        _setup: function(t) {
            var e = this.options,
            i = this; ! browser.webkit && t.open();
            var n = ie && browser.version < 9;
            if (t.write((ie && browser.version < 9 ? "": "<!DOCTYPE html>") + '<html xmlns="http://www.w3.org/1999/xhtml"' + (n ? "": ' class="view"') + "><head>" + (e.iframeCssUrl ? '<link rel="stylesheet" type="text/css" href="' + utils.unhtml(/^http/.test(e.iframeCssUrl) ? e.iframeCssUrl: e.UEDITOR_HOME_URL + e.iframeCssUrl) + '"/>': "") + '<style type="text/css">' + (e.initialStyle || " ") + "</style></head><body" + (n ? ' class="view"': "") + "></body></html>"), !browser.webkit && t.close(), ie ? (t.body.disabled = !0, t.body.contentEditable = !0, t.body.disabled = !1) : (t.body.contentEditable = !0, t.body.spellcheck = !1), this.document = t, this.window = t.defaultView || t.parentWindow, this.iframe = this.window.frameElement, this.body = t.body, this.options.minFrameHeight && (this.setHeight(this.options.minFrameHeight), this.body.style.height = this.options.minFrameHeight), this.selection = new dom.Selection(t), browser.gecko && this.selection.getNative().removeAllRanges(), this._initEvents(), i.options.initialContent) if (i.options.autoClearinitialContent) {
                var s = i.execCommand;
                i.execCommand = function() {
                    i.fireEvent("firstBeforeExecCommand"),
                    s.apply(i, arguments)
                },
                this.setDefaultContent(this.options.initialContent)
            } else this.setContent(this.options.initialContent, !0);
            for (var o = this.iframe.parentNode; ! domUtils.isBody(o); o = o.parentNode) if ("FORM" == o.tagName) {
                domUtils.on(o, "submit", 
                function() {
                    var t = document.getElementById("ueditor_textarea_" + i.options.textarea);
                    t || (t = document.createElement("textarea"), t.setAttribute("name", i.options.textarea), t.id = "ueditor_textarea_" + i.options.textarea, t.style.display = "none", this.appendChild(t)),
                    t.value = i.getContent()
                });
                break
            }
            domUtils.isEmptyNode(i.body) && (this.body.innerHTML = "<p>" + (browser.ie ? "": "<br/>") + "</p>"),
            i.options.focus && setTimeout(function() {
                i.focus(),
                !i.options.autoClearinitialContent && i._selectionChange()
            }),
            this.container || (this.container = this.iframe.parentNode),
            i.options.fullscrren && i.ui && i.ui.setFullScreen(!0),
            this.fireEvent("ready"),
            browser.ie || domUtils.on(i.window, "blur", 
            function() {
                i._bakRange = i.selection.getRange(),
                i.selection.getNative().removeAllRanges()
            }),
            browser.gecko && browser.version <= 10902 && (i.body.contentEditable = !1, setTimeout(function() {
                i.body.contentEditable = !0
            },
            100), setInterval(function() {
                i.body.style.height = i.iframe.offsetHeight - 20 + "px"
            },
            100))
        },
        sync: function(t) {
            function e(t) {
                var e = document.getElementById("ueditor_textarea_" + n.options.textarea);
                e || (e = document.createElement("textarea"), e.setAttribute("name", n.options.textarea), e.id = "ueditor_textarea_" + n.options.textarea, e.style.display = "none", t.appendChild(e)),
                e.value = n.getContent()
            }
            var i,
            n = this;
            if (t) i = document.getElementById(t),
            i && e(i);
            else for (i = n.iframe.parentNode; ! domUtils.isBody(i); i = i.parentNode) if ("FORM" == i.tagName) {
                e(i);
                break
            }
        },
        setHeight: function(t) {
            t !== parseInt(this.iframe.parentNode.style.height) && (this.iframe.parentNode.style.height = t + "px"),
            browser.ie && 9 == browser.version && (this.document.body.style.height = t - 20 + "px")
        },
        getContent: function(t) {
            this.fireEvent("beforegetcontent", t);
            var e = new RegExp(domUtils.fillChar, "g"),
            i = this.document.body.innerHTML.replace(e, "");
            if (this.fireEvent("aftergetcontent", t), this.serialize) {
                var n = this.serialize.parseHTML(i);
                n = this.serialize.transformOutput(n),
                i = this.serialize.toHTML(n)
            }
            return i
        },
        getContentTxt: function() {
            var t = new RegExp(domUtils.fillChar, "g");
            return this.body[browser.ie ? "innerText": "textContent"].replace(t, "")
        },
        setContent: function(e, i) {
            var n = this;
            n.fireEvent("beforesetcontent");
            var s = this.serialize;
            if (s) {
                var o = s.parseHTML(e);
                o = s.transformInput(o),
                o = s.filter(o),
                e = s.toHTML(o)
            }
            if (this.document.body.innerHTML = e.replace(new RegExp("[\r" + domUtils.fillChar + "]*", "g"), ""), browser.ie && browser.version < 7 && n.options.relativePath && t(this.document.body), "p" == n.options.enterTag) {
                var a,
                r = this.body.firstChild,
                l = n.document.createElement("p");
                if (!r || 1 == r.nodeType && dtd.$cdata[r.tagName]) this.body.innerHTML = "<p>" + (browser.ie ? "": "<br/>") + "</p>" + this.body.innerHTML;
                else for (; r;) 3 == r.nodeType || 1 == r.nodeType && dtd.p[r.tagName] ? (a = r.nextSibling, l.appendChild(r), r = a, r || n.body.appendChild(l)) : (l.firstChild && (n.body.insertBefore(l, r), l = n.document.createElement("p")), r = r.nextSibling)
            }
            n.adjustTable && n.adjustTable(n.body),
            n.fireEvent("aftersetcontent"),
            n.fireEvent("contentchange"),
            !i && n._selectionChange(),
            n._bakRange = n._bakIERange = null,
            browser.gecko && n.selection.getNative().removeAllRanges()
        },
        focus: function() {
            this.selection.getRange().select()
        },
        _initEvents: function() {
            var t = this,
            e = t.document,
            i = t.window;
            t._proxyDomEvent = utils.bind(t._proxyDomEvent, t),
            browser.ie && domUtils.on(e, "mousedown", 
            function(t) {
                2 == t.button && alert("请使用ctrl+v进行粘贴！")
            }),
            domUtils.on(e, ["click", "contextmenu", "mousedown", "keydown", "keyup", "keypress", "mouseup", "mouseover", "mouseout", "selectstart"], t._proxyDomEvent),
            domUtils.on(i, ["focus", "blur"], t._proxyDomEvent),
            domUtils.on(e, ["mouseup", "keydown"], 
            function(e) {
                "keydown" == e.type && (e.ctrlKey || e.metaKey || e.shiftKey || e.altKey) || 2 != e.button && t._selectionChange(250, e)
            });
            var n,
            s = 0,
            o = browser.ie ? t.body: t.document;
            domUtils.on(o, "dragstart", 
            function() {
                s = 1
            }),
            domUtils.on(o, browser.webkit ? "dragover": "drop", 
            function() {
                return browser.webkit ? 
                function() {
                    clearTimeout(n),
                    n = setTimeout(function() {
                        if (!s) {
                            var e = t.selection,
                            i = e.getRange();
                            if (i) {
                                var n = i.getCommonAncestor();
                                if (n && t.serialize) {
                                    var o = t.serialize,
                                    a = o.filter(o.transformInput(o.parseHTML(o.word(n.innerHTML))));
                                    n.innerHTML = o.toHTML(a)
                                }
                            }
                        }
                        s = 0
                    },
                    200)
                }: function(t) {
                    s || (t.preventDefault ? t.preventDefault() : t.returnValue = !1),
                    s = 0
                }
            } ())
        },
        _proxyDomEvent: function(t) {
            return this.fireEvent(t.type.replace(/^on/, ""), t)
        },
        _selectionChange: function(t, i) {
            var n = this;
            if (n.selection.isFocus()) {
                var s,
                o,
                a = !1;
                if (browser.ie && browser.version < 9 && i && "mouseup" == i.type) {
                    var r = this.selection.getRange();
                    r.collapsed || (a = !0, s = i.clientX, o = i.clientY)
                }
                clearTimeout(e),
                e = setTimeout(function() {
                    if (n.selection.getNative()) {
                        var t;
                        if (a && "None" == n.selection.getNative().type) {
                            t = n.document.body.createTextRange();
                            try {
                                t.moveToPoint(s, o)
                            } catch(e) {
                                t = null
                            }
                        }
                        var r;
                        t && (r = n.selection.getIERange, n.selection.getIERange = function() {
                            return t
                        }),
                        n.selection.cache(),
                        r && (n.selection.getIERange = r),
                        n.selection._cachedRange && n.selection._cachedStartElement && (n.fireEvent("beforeselectionchange"), n.fireEvent("selectionchange", !!i), n.fireEvent("afterselectionchange"), n.selection.clear())
                    }
                },
                t || 50)
            }
        },
        _callCmdFn: function(t, e) {
            var i,
            n,
            s = e[0].toLowerCase();
            return n = (i = this.commands[s]) && i[t] || (i = UE.commands[s]) && i[t],
            i && !n && "queryCommandState" == t ? !1: n ? n.apply(this, e) : void 0
        },
        execCommand: function(t) {
            t = t.toLowerCase();
            var e,
            i = this,
            n = i.commands[t] || UE.commands[t];
            if (n && n.execCommand) return n.notNeedUndo || i.__hasEnterExecCommand ? e = this._callCmdFn("execCommand", arguments) : (i.__hasEnterExecCommand = !0, -1 != i.queryCommandState(t) && (i.fireEvent("beforeexeccommand", t), e = this._callCmdFn("execCommand", arguments), i.fireEvent("afterexeccommand", t)), i.__hasEnterExecCommand = !1),
            i._selectionChange(),
            e
        },
        queryCommandState: function() {
            return this._callCmdFn("queryCommandState", arguments)
        },
        queryCommandValue: function() {
            return this._callCmdFn("queryCommandValue", arguments)
        },
        hasContents: function(t) {
            if (t) for (var e, i = 0; e = t[i++];) if (this.document.getElementsByTagName(e).length > 0) return ! 0;
            return domUtils.isEmptyBlock(this.body) ? !1: !0
        },
        reset: function() {
            this.fireEvent("reset")
        },
        setDefaultContent: function() {
            function e() {
                var t = this;
                if (t.document.getElementById("initContent")) {
                    t.document.body.innerHTML = "<p>" + (ie ? "": "<br/>") + "</p>";
                    var i = t.selection.getRange();
                    t.removeListener("firstBeforeExecCommand", e),
                    t.removeListener("focus", e),
                    setTimeout(function() {
                        i.setStart(t.document.body.firstChild, 0).collapse(!0).select(!0),
                        t._selectionChange()
                    })
                }
            }
            return function(i) {
                var n = this;
                n.document.body.innerHTML = '<p id="initContent">' + i + "</p>",
                browser.ie && browser.version < 7 && n.options.relativePath && t(n.document.body),
                n.addListener("firstBeforeExecCommand", e),
                n.addListener("focus", e)
            }
        } ()
    },
    utils.inherits(n, EventBase)
} (),
/*end ueditor.js*/
/*ueditor plugin*/
UE.commands.inserthtml = {
    execCommand: function(t, e) {
        var i,
        n,
        s,
        o = this,
        a = o.currentSelectedArr;
        i = o.selection.getRange(),
        s = i.document.createElement("div"),
        s.style.display = "inline",
        s.innerHTML = utils.trim(e);
        try {
            o.adjustTable && o.adjustTable(s)
        } catch(r) {}
        if (a && a.length) {
            for (var l, n = 0; l = a[n++];) l.className = "";
            a[0].innerHTML = "",
            i.setStart(a[0], 0).collapse(!0),
            o.currentSelectedArr = []
        }
        if (!i.collapsed && (i.deleteContents(), 1 == i.startContainer.nodeType)) {
            var u,
            d = i.startContainer.childNodes[i.startOffset];
            if (d && domUtils.isBlockElm(d) && (u = d.previousSibling) && domUtils.isBlockElm(u)) {
                for (i.setEnd(u, u.childNodes.length).collapse(); d.firstChild;) u.appendChild(d.firstChild);
                domUtils.remove(d)
            }
        }
        for (var d, c, u, h, p = 0; d = s.firstChild;) {
            if (i.insertNode(d), !p && d.nodeType == domUtils.NODE_ELEMENT && domUtils.isBlockElm(d) && (c = domUtils.findParent(d, 
            function(t) {
                return domUtils.isBlockElm(t)

            }), c && "body" != c.tagName.toLowerCase() && (!dtd[c.tagName][d.nodeName] || d.parentNode !== c))) {
                if (dtd[c.tagName][d.nodeName]) for (h = d.parentNode; h !== c;) u = h,
                h = h.parentNode;
                else u = c;
                domUtils.breakParent(d, u || h);
                var u = d.previousSibling;
                domUtils.trimWhiteTextNode(u),
                u.childNodes.length || domUtils.remove(u),
                p = 1
            }
            var f = d.nextSibling;
            if (!s.firstChild && f && domUtils.isBlockElm(f)) {
                i.setStart(f, 0).collapse(!0);
                break
            }
            i.setEndAfter(d).collapse()
        }
        d = i.startContainer,
        domUtils.isBlockElm(d) && domUtils.isEmptyNode(d) && (d.innerHTML = browser.ie ? "": "<br/>"),
        i.select(!0),
        setTimeout(function() {
            i = o.selection.getRange(),
            i.scrollToView(o.autoHeightEnabled, o.autoHeightEnabled ? domUtils.getXY(o.iframe).y: 0)
        },
        200),
        o.enableAutoHeight()
    }
},
UE.commands.insertimage = {
    execCommand: function(t, e) {
        if (e = utils.isArray(e) ? e: [e], e.length) {
            var i = this,
            n = i.selection.getRange(),
            s = n.getClosedNode();
            if (s && /img/i.test(s.tagName) && "edui-faked-video" != s.className && !s.getAttribute("word_img")) {
                var o = e.shift(),
                a = o.floatStyle;
                delete o.floatStyle,
                domUtils.setAttributes(s, o),
                i.execCommand("imagefloat", a),
                e.length > 0 && (n.setStartAfter(s).setCursor(!1, !0), i.execCommand("insertimage", e))
            } else {
                var r,
                l = [],
                u = "";
                if (r = e[0], 1 == e.length) u = '<p><img src="' + r.src + '" ' + (r.data_ue_src ? ' data_ue_src="' + r.data_ue_src + '" ': "") + (r.width ? 'width="' + r.width + '" ': "") + (r.height ? ' height="' + r.height + '" ': "") + (r.floatStyle && "center" != r.floatStyle ? ' style="float:' + r.floatStyle + ';"': "") + (r.title ? ' title="' + r.title + '"': "") + ' border="' + (r.border || 0) + '" hspace = "' + (r.hspace || 0) + '" vspace = "' + (r.vspace || 0) + '" /></p>',
                "center" == r.floatStyle && (u = '<p style="text-align: center">' + u + "</p>"),
                l.push(u);
                else for (var d = 0; r = e[d++];) u = "<p " + ("center" == r.floatStyle ? 'style="text-align: center" ': "") + '><img src="' + r.src + '" ' + (r.width ? 'width="' + r.width + '" ': "") + (r.data_ue_src ? ' data_ue_src="' + r.data_ue_src + '" ': "") + (r.height ? ' height="' + r.height + '" ': "") + ' style="' + (r.floatStyle && "center" != r.floatStyle ? "float:" + r.floatStyle + ";": "") + (r.border || "") + '" ' + (r.title ? ' title="' + r.title + '"': "") + " /></p>",
                l.push(u);
                i.execCommand("insertHtml", l.join("")),
                setTimeout(function() {
                    i.enableAutoHeight()
                },
                300)
            }
        }
    },
    queryCommandState: function() {
        return this.highlight ? -1: 0
    }
},
function() {
    function t(t) {
        var e = t.startContainer,
        i = t.endContainer; (e = domUtils.findParentByTagName(e, "a", !0)) && t.setStartBefore(e),
        (i = domUtils.findParentByTagName(i, "a", !0)) && t.setEndAfter(i)
    }
    function e(e, i) {
        t(e = e.adjustmentBoundary());
        var n = e.startContainer;
        if (1 == n.nodeType && (n = n.childNodes[e.startOffset], n && 1 == n.nodeType && "A" == n.tagName && /^(?:https?|ftp|file)\s*:\s*\/\//.test(n[browser.ie ? "innerText": "textContent"]) && (n.innerHTML = i.href)), e.removeInlineStyle("a"), e.collapsed) {
            var s = e.document.createElement("a");
            domUtils.setAttributes(s, i),
            s.innerHTML = i.href,
            e.insertNode(s).selectNode(s)
        } else e.applyInlineStyle("a", i)
    }
    UE.commands.unlink = {
        execCommand: function() {
            var e,
            i,
            n = new dom.Range(this.document),
            s = this.currentSelectedArr;
            if (s && s.length > 0) {
                for (var o, a = 0; o = s[a++];) {
                    e = domUtils.getElementsByTagName(o, "a");
                    for (var r, l = 0; r = e[l++];) domUtils.remove(r, !0)
                }
                domUtils.isEmptyNode(s[0]) ? n.setStart(s[0], 0).setCursor() : n.selectNodeContents(s[0]).select()
            } else {
                if (n = this.selection.getRange(), n.collapsed && !domUtils.findParentByTagName(n.startContainer, "a", !0)) return;
                i = n.createBookmark(),
                t(n),
                n.removeInlineStyle("a").moveToBookmark(i).select()
            }
        },
        queryCommandState: function() {
            return ! this.highlight && this.queryCommandValue("link") ? 0: -1
        }
    },
    UE.commands.link = {
        queryCommandState: function() {
            return this.highlight ? -1: 0
        },
        execCommand: function(t, i) {
            var n = new dom.Range(this.document),
            s = this.currentSelectedArr;
            if (s && s.length) {
                for (var o, a = 0; o = s[a++];) domUtils.isEmptyNode(o) && (o.innerHTML = i.href),
                e(n.selectNodeContents(o), i);
                n.selectNodeContents(s[0]).select()
            } else e(n = this.selection.getRange(), i),
            n.collapse().select(browser.gecko ? !0: !1)
        },
        queryCommandValue: function() {
            var t,
            e,
            i = new dom.Range(this.document),
            n = this.currentSelectedArr;
            if (n && n.length) {
                for (var s, o = 0; s = n[o++];) if (t = s.getElementsByTagName("a"), t[0]) return t[0]
            } else {
                if (i = this.selection.getRange(), !i.collapsed) {
                    i.shrinkBoundary();
                    var a = 3 != i.startContainer.nodeType && i.startContainer.childNodes[i.startOffset] ? i.startContainer.childNodes[i.startOffset] : i.startContainer,
                    r = 3 == i.endContainer.nodeType || 0 == i.endOffset ? i.endContainer: i.endContainer.childNodes[i.endOffset - 1],
                    l = i.getCommonAncestor();
                    if (e = domUtils.findParentByTagName(l, "a", !0), !e && 1 == l.nodeType) for (var u, d, c, t = l.getElementsByTagName("a"), o = 0; c = t[o++];) if (u = domUtils.getPosition(c, a), d = domUtils.getPosition(c, r), (u & domUtils.POSITION_FOLLOWING || u & domUtils.POSITION_CONTAINS) && (d & domUtils.POSITION_PRECEDING || d & domUtils.POSITION_CONTAINS)) {
                        e = c;
                        break
                    }
                    return e
                }
                if (e = this.selection.getStart(), e && (e = domUtils.findParentByTagName(e, "a", !0))) return e
            }
        }
    }
} (),
function() {
    var t = domUtils.isBlockElm,
    e = ["TD", "LI", "PRE"],
    i = function(i, n, s, o) {
        var a,
        r = i.createBookmark(),
        l = function(t) {
            return 1 == t.nodeType ? "br" != t.tagName.toLowerCase() && !domUtils.isBookmarkNode(t) : !domUtils.isWhitespace(t)
        };
        i.enlarge(!0);
        for (var u, d = i.createBookmark(), c = domUtils.getNextDomNode(d.start, !1, l), h = i.cloneRange(); c && !(domUtils.getPosition(c, d.end) & domUtils.POSITION_FOLLOWING);) if (3 != c.nodeType && t(c)) c = domUtils.getNextDomNode(c, !0, l);
        else {
            for (h.setStartBefore(c); c && c !== d.end && !t(c);) u = c,
            c = domUtils.getNextDomNode(c, !1, null, 
            function(e) {
                return ! t(e)
            });
            if (h.setEndAfter(u), a = i.document.createElement(n), s && (domUtils.setAttributes(a, s), o && "customstyle" == o && s.style && (a.style.cssText = s.style)), a.appendChild(h.extractContents()), domUtils.isEmptyNode(a) && domUtils.fillChar(i.document, a), a.hasChildNodes()) for (var p = 0; p < a.childNodes.length; p++)"BR" == a.childNodes[p].tagName && a.removeChild(a.childNodes[p]);
            h.insertNode(a);
            var f = a.parentNode;
            t(f) && !domUtils.isBody(a.parentNode) && -1 == utils.indexOf(e, f.tagName) && (o && "customstyle" == o || (f.getAttribute("dir") && a.setAttribute("dir", f.getAttribute("dir")), f.style.cssText && (a.style.cssText = f.style.cssText + ";" + a.style.cssText), f.style.textAlign && !a.style.textAlign && (a.style.textAlign = f.style.textAlign), f.style.textIndent && !a.style.textIndent && (a.style.textIndent = f.style.textIndent), f.style.padding && !a.style.padding && (a.style.padding = f.style.padding)), s && /h\d/i.test(f.tagName) && !/h\d/i.test(a.tagName) ? (domUtils.setAttributes(f, s), o && "customstyle" == o && s.style && (f.style.cssText = s.style), domUtils.remove(a, !0), a = f) : domUtils.remove(a.parentNode, !0)),
            c = -1 != utils.indexOf(e, f.tagName) ? f: a,
            c = domUtils.getNextDomNode(c, !1, l)
        }
        return i.moveToBookmark(d).moveToBookmark(r)
    };
    UE.commands.paragraph = {
        execCommand: function(t, e, n, s) {
            var o = new dom.Range(this.document);
            if (this.currentSelectedArr && this.currentSelectedArr.length > 0) {
                for (var a, r = 0; a = this.currentSelectedArr[r++];) if ("none" != a.style.display) {
                    if (domUtils.isEmptyNode(a)) {
                        var l = this.document.createTextNode("paragraph");
                        a.innerHTML = "",
                        a.appendChild(l)
                    }
                    if (i(o.selectNodeContents(a), e, n, s), l) {
                        var u = l.parentNode;
                        domUtils.remove(l),
                        domUtils.isEmptyNode(u) && domUtils.fillNode(this.document, u)
                    }
                }
                var d = this.currentSelectedArr[0];
                domUtils.isEmptyBlock(d) ? o.setStart(d, 0).setCursor(!1, !0) : o.selectNode(d).select()
            } else {
                if (o = this.selection.getRange(), o.collapsed) {
                    var c = this.document.createTextNode("p");
                    if (o.insertNode(c), browser.ie) {
                        var h = c.previousSibling;
                        h && domUtils.isWhitespace(h) && domUtils.remove(h),
                        h = c.nextSibling,
                        h && domUtils.isWhitespace(h) && domUtils.remove(h)
                    }
                }
                if (o = i(o, e, n, s), c && (o.setStartBefore(c).collapse(!0), u = c.parentNode, domUtils.remove(c), domUtils.isBlockElm(u) && domUtils.isEmptyNode(u) && domUtils.fillNode(this.document, u)), browser.gecko && o.collapsed && 1 == o.startContainer.nodeType) {
                    var p = o.startContainer.childNodes[o.startOffset];
                    p && 1 == p.nodeType && p.tagName.toLowerCase() == e && o.setStart(p, 0).collapse(!0)
                }
                o.select()
            }
            return ! 0
        },
        queryCommandValue: function() {
            var t = utils.findNode(this.selection.getStartElementPath(), ["p", "h1", "h2", "h3", "h4", "h5", "h6"]);
            return t ? t.tagName.toLowerCase() : ""
        },
        queryCommandState: function() {
            return this.highlight ? -1: 0
        }
    }
} (),
UE.commands.indent = {
    execCommand: function() {
        var t = this;
        1 != t.body.childNodes.length && $(t.body.childNodes).each(function() {
            null != $(this).html() && $(this).html($(this).html().replace(/&nbsp;/gi, "")),
            $(this).find("br").remove(),
            ("<br>" == $(this).html() || "" == $(this).html()) && $(this).remove(),
            this.tagName && "h3" != this.tagName.toLowerCase() && $(this).append("<br /><br />");
            var e = t.selection.getRange();
            e.setCursor(),
            t.enableAutoHeight()
        })
    },
    queryCommandState: function() {
        if (this.highlight) return - 1;
        var t = utils.findNode(this.selection.getStartElementPath(), ["p", "h1", "h2", "h3", "h4", "h5", "h6"]),
        e = t && t.style.textIndent ? parseInt(t.style.textIndent) : "";
        return e ? 1: 0
    }
},
UE.plugins.selectall = function() {
    var t = this;
    t.commands.selectall = {
        execCommand: function() {
            var t = this.selection.getRange();
            t.selectNodeContents(this.body),
            domUtils.isEmptyBlock(this.body) && t.collapse(!0),
            t.select(!0),
            this.selectAll = !0
        },
        notNeedUndo: 1
    },
    t.addListener("ready", 
    function() {
        domUtils.on(t.document, "click", 
        function() {
            t.selectAll = !1
        })
    })
},
UE.commands.cleardoc = {
    execCommand: function() {
        var t = this,
        e = t.options.enterTag,
        i = t.selection.getRange();
        "br" == e ? (t.body.innerHTML = "<br/>", i.setStart(t.body, 0).setCursor()) : (t.body.innerHTML = "<p>" + (ie ? "&nbsp;": "<br/>") + "</p>", t.focus(), i.setStart(t.body.firstChild, 0).setCursor(!1, !0))
    }
},
UE.commands["delete"] = {
    execCommand: function() {
        var t = this.selection.getRange(),
        e = 0,
        i = 0,
        n = this;
        if (this.selectAll) return n.body.innerHTML = "<p>" + (browser.ie ? "&nbsp;": "<br/>") + "</p>",
        t.setStart(n.body.firstChild, 0).setCursor(!1, !0),
        n.selectAll = !1,
        void 0;
        if (n.currentSelectedArr && n.currentSelectedArr.length > 0) {
            for (var s, o = 0; s = n.currentSelectedArr[o++];)"none" != s.style.display && (s.innerHTML = browser.ie ? domUtils.fillChar: "<br/>");
            return t.setStart(n.currentSelectedArr[0], 0).setCursor(),
            void 0
        }
        if (!t.collapsed) {
            for (t.txtToElmBoundary(); ! t.startOffset && !domUtils.isBody(t.startContainer) && !dtd.$tableContent[t.startContainer.tagName];) e = 1,
            t.setStartBefore(t.startContainer);
            for (; ! domUtils.isBody(t.endContainer) && !dtd.$tableContent[t.endContainer.tagName];) {
                var a,
                r = t.endContainer,
                l = t.endOffset;
                a = r.childNodes[l]; {
                    if (a && (!domUtils.isBr(a) || r.lastChild !== a)) break;
                    t.setEndAfter(r)
                }
            }
            if (e) {
                var u = n.document.createElement("span");
                u.innerHTML = "start",
                u.id = "_baidu_cut_start",
                t.insertNode(u).setStartBefore(u)
            }
            if (i) {
                var d = n.document.createElement("span");
                d.innerHTML = "end",
                d.id = "_baidu_cut_end",
                t.cloneRange().collapse(!1).insertNode(d),
                t.setEndAfter(d)
            }
            t.deleteContents(),
            domUtils.isBody(t.startContainer) && domUtils.isEmptyBlock(n.body) ? (n.body.innerHTML = "<p>" + (browser.ie ? "": "<br/>") + "</p>", t.setStart(n.body.firstChild, 0).collapse(!0)) : !browser.ie && domUtils.isEmptyBlock(t.startContainer) && (t.startContainer.innerHTML = "<br/>"),
            t.select(!0)
        }
    },
    queryCommandState: function() {
        return this.currentSelectedArr && this.currentSelectedArr.length > 0 ? 0: this.selection.getRange().collapsed ? -1: 0
    }
},
/*function() {
    function t(t) {
        var e = this.document;
        if (!e.getElementById("baidu_pastebin")) {
            var i = this.selection.getRange(),
            n = i.createBookmark(),
            s = e.createElement("div");
            s.id = "baidu_pastebin",
            browser.webkit && s.appendChild(e.createTextNode(domUtils.fillChar + domUtils.fillChar)),
            e.body.appendChild(s),
            n.start.style.display = "",
            s.style.cssText = "position:absolute;width:1px;height:1px;overflow:hidden;left:-1000px;white-space:nowrap;top:" + domUtils.getXY(n.start).y + "px",
            i.selectNodeContents(s).select(!0),
            setTimeout(function() {
                if (browser.webkit) for (var o, a = 0, r = e.querySelectorAll("#baidu_pastebin"); o = r[a++];) {
                    if (!domUtils.isEmptyNode(o)) {
                        s = o;
                        break
                    }
                    domUtils.remove(o)
                }
                try {
                    s.parentNode.removeChild(s)
                } catch(l) {}
                i.moveToBookmark(n).select(!0),
                t(s)
            },
            0)
        }
    }
    UE.plugins.paste = function() {
        function e(t) {
            var e;
            if (t.firstChild) {
                for (var a, r = domUtils.getElementsByTagName(t, "span"), l = 0; a = r[l++];)("_baidu_cut_start" == a.id || "_baidu_cut_end" == a.id) && domUtils.remove(a);
                if (browser.webkit) {
                    for (var u, d = t.querySelectorAll("div br"), l = 0; u = d[l++];) {
                        var c = u.parentNode;
                        "DIV" == c.tagName && 1 == c.childNodes.length && (c.innerHTML = "<p><br/></p>", domUtils.remove(c))
                    }
                    for (var h, p = t.querySelectorAll("#baidu_pastebin"), l = 0; h = p[l++];) {
                        var f = i.document.createElement("p");
                        for (h.parentNode.insertBefore(f, h); h.firstChild;) f.appendChild(h.firstChild);
                        domUtils.remove(h)
                    }
                    for (var m, g = t.querySelectorAll("meta"), l = 0; m = g[l++];) domUtils.remove(m);
                    var d = t.querySelectorAll("br");
                    for (l = 0; m = d[l++];) / ^apple - /.test(m)&&domUtils.remove(m)
                }
                if(browser.gecko){
                	var v=t.querySelectorAll("[_moz_dirty]");
                	for(l=0;m=v[l++];)m.removeAttribute("_moz_dirty")
                }
                if(!browser.ie)
                	for(var m,b=t.querySelectorAll("span.apple-style-span"),l=0;m=b[l++];)
                	domUtils.remove(m,!0);
                    e=$.htmlClean(t.innerHTML,{allowedTags:["p","a"]});
                    var y=i.serialize;
                    if(y)
                    	try{
                    		var _=y.transformInput(y.parseHTML(y.word(e)),n);
                    		if(_=y.filter(_,s?{whiteList:{p:{br:1,BR:1},br:{$:{}}},blackList:{style:1,script:1,object:1}}:null,s?null:o),browser.webkit)
                    			for(var w,S=_.children.length;(w=_.children[S-1])&&"br"==w.tag;)
                    				_.children.splice(S-1,1),S=_.children.length;
                    		e=y.toHTML(_,s)
                    		}catch(x){}
                    		e={html:e},
                    		i.fireEvent("beforepaste",e),
                    		i.execCommand("insertHtml",e.html),
                    		i.fireEvent("afterpaste")
                    		}
            }
        var i=this,n={flag:""},s=i.options.pasteplain,o={flag:""};
        i.commands.pasteplain={
        		queryCommandState:function(){return s},
        		execCommand:function(){s=0|!s},notNeedUndo:1},
        		i.addListener("ready",function(){
        			domUtils.on(i.body,"cut",function(){var t=i.selection.getRange();!t.collapsed&&i.undoManger&&i.undoManger.save()}),
        			browser.opera&&(baidu.editor.browser.mac?domUtils.on(i.body,"keydown",function(t){17==t.keyCode&&alert("暂不支持此浏览器！")}):domUtils.on(i.body,"keydown",function(n){n.ctrlKey&&"86"==n.keyCode&&t.call(i,function(t){e(t)})})
        					),
        					domUtils.on(i.body,browser.ie?"keydown":"paste",function(s){(!browser.ie||s.ctrlKey&&"86"==s.keyCode)&&t.call(i,function(t){function s(){i.ui.hideToolbarMsg(),i.removeListener("selectionchange",s)}e(t),o.flag&&i.ui&&(o.flag="",setTimeout(function(){i.addListener("selectionchange",s)},100)),n.flag&&!i.queryCommandState("pasteplain")&&i.ui&&(n.flag="",setTimeout(function(){i.addListener("selectionchange",s)},100))})})})}}(),UE.plugins.enterkey=function(){var t,e=this,i=e.options.enterTag;e.addListener("keyup",function(i,n){var s=n.keyCode||n.which;if(13==s){var o,a=e.selection.getRange(),r=a.startContainer;if(!browser.ie&&/h\d / i.test(t)) {
                        if (browser.gecko) {
                            var l = domUtils.findParentByTagName(r, ["h1", "h2", "h3", "h4", "h5", "h6", "blockquote"], !0);
                            l || (e.document.execCommand("formatBlock", !1, "<p>"), o = 1)
                        } else if (1 == r.nodeType) {
                            var u,
                            d = e.document.createTextNode("");
                            if (a.insertNode(d), u = domUtils.findParentByTagName(d, "div", !0)) {
                                for (var c = e.document.createElement("p"); u.firstChild;) c.appendChild(u.firstChild);
                                u.parentNode.insertBefore(c, u),
                                domUtils.remove(u),
                                a.setStartBefore(d).setCursor(),
                                o = 1
                            }
                            domUtils.remove(d)
                        }
                        e.undoManger && o && e.undoManger.save()
                    }
                    a = e.selection.getRange(),
                    setTimeout(function() {
                        a.scrollToView(e.autoHeightEnabled, e.autoHeightEnabled ? domUtils.getXY(e.iframe).y: 0)
                    },
                    50)
                }
            }),
            e.addListener("keydown", 
            function(n, s) {
                var o = s.keyCode || s.which;
                if (13 == o) {
                    e.undoManger && e.undoManger.save(),
                    t = "";
                    var a = e.selection.getRange();
                    if (!a.collapsed) {
                        var r = a.startContainer,
                        l = a.endContainer,
                        u = domUtils.findParentByTagName(r, "td", !0),
                        d = domUtils.findParentByTagName(l, "td", !0);
                        if (u && d && u !== d || !u && d || u && !d) return s.preventDefault ? s.preventDefault() : s.returnValue = !1,
                        void 0
                    }
                    if (e.currentSelectedArr && domUtils.clearSelectedArr(e.currentSelectedArr), "p" == i) browser.ie || (r = domUtils.findParentByTagName(a.startContainer, ["ol", "ul", "p", "h1", "h2", "h3", "h4", "h5", "h6", "blockquote"], !0), r ? (t = r.tagName, "p" == r.tagName.toLowerCase() && browser.gecko && domUtils.removeDirtyAttr(r)) : (e.document.execCommand("formatBlock", !1, "<p>"), browser.gecko && (a = e.selection.getRange(), r = domUtils.findParentByTagName(a.startContainer, "p", !0), r && domUtils.removeDirtyAttr(r))));
                    else if (s.preventDefault ? s.preventDefault() : s.returnValue = !1, a.collapsed) {
                        h = a.document.createElement("br"),
                        a.insertNode(h);
                        var c = h.parentNode;
                        c.lastChild === h ? (h.parentNode.insertBefore(h.cloneNode(!0), h), a.setStartBefore(h)) : a.setStartAfter(h),
                        a.setCursor()
                    } else if (a.deleteContents(), r = a.startContainer, 1 == r.nodeType && (r = r.childNodes[a.startOffset])) {
                        for (; 1 == r.nodeType;) {
                            if (dtd.$empty[r.tagName]) return a.setStartBefore(r).setCursor(),
                            e.undoManger && e.undoManger.save(),
                            !1;
                            if (!r.firstChild) {
                                var h = a.document.createElement("br");
                                return r.appendChild(h),
                                a.setStart(r, 0).setCursor(),
                                e.undoManger && e.undoManger.save(),
                                !1
                            }
                            r = r.firstChild
                        }
                        r === a.startContainer.childNodes[a.startOffset] ? (h = a.document.createElement("br"), a.insertNode(h).setCursor()) : a.setStart(r, 0).setCursor()
                    } else h = a.document.createElement("br"),
                    a.insertNode(h).setStartAfter(h).setCursor()
                }
            })
        },*/
        UE.plugins.keystrokes = function() {
            var t = this,
            e = 0,
            i = domUtils.keys,
            n = {
                B: "strong",
                I: "em",
                FONT: "span"
            },
            s = [0, 10, 12, 16, 18, 24, 32, 48],
            o = {
                OL: ["decimal", "lower-alpha", "lower-roman", "upper-alpha", "upper-roman"],
                UL: ["circle", "disc", "square"]
            };
            t.addListener("keydown", 
            function(i, n) {
                var s = n.keyCode || n.which;
                if (this.selectAll && (this.selectAll = !1, 8 == s || 46 == s)) return t.undoManger && t.undoManger.save(),
                t.body.innerHTML = "<p>" + (browser.ie ? "": "<br/>") + "</p>",
                new dom.Range(t.document).setStart(t.body.firstChild, 0).setCursor(!1, !0),
                t.undoManger && t.undoManger.save(),
                browser.ie && t._selectionChange(),
                domUtils.preventDefault(n),
                void 0;
                if (8 == s) {
                    var a,
                    r,
                    l,
                    u = t.selection.getRange();
                    if (u.collapsed && (r = u.startContainer, domUtils.isWhitespace(r) && (r = r.parentNode), domUtils.isEmptyNode(r) && r === t.body.firstChild)) return "P" != r.tagName && (p = t.document.createElement("p"), t.body.insertBefore(p, r), domUtils.fillNode(t.document, p), u.setStart(p, 0).setCursor(!1, !0), domUtils.remove(r)),
                    domUtils.preventDefault(n),
                    void 0;
                    if (u.collapsed && 3 == u.startContainer.nodeType && 0 == u.startContainer.nodeValue.replace(new RegExp(domUtils.fillChar, "g"), "").length && u.setStartBefore(u.startContainer).collapse(!0), r = u.getClosedNode()) return t.undoManger && t.undoManger.save(),
                    u.setStartBefore(r),
                    domUtils.remove(r),
                    u.setCursor(),
                    t.undoManger && t.undoManger.save(),
                    domUtils.preventDefault(n),
                    void 0;
                    if (!browser.ie) {
                        if (r = domUtils.findParentByTagName(u.startContainer, "table", !0), l = domUtils.findParentByTagName(u.endContainer, "table", !0), r && !l || !r && l || r !== l) return n.preventDefault(),
                        void 0;
                        if (browser.webkit && u.collapsed && r && (a = u.cloneRange().txtToElmBoundary(), r = a.startContainer, domUtils.isBlockElm(r) && 1 == r.nodeType && !dtd.$tableContent[r.tagName] && !domUtils.getChildCount(r, 
                        function(t) {
                            return 1 == t.nodeType ? "BR" !== t.tagName: 1
                        }))) return a.setStartBefore(r).setCursor(),
                        domUtils.remove(r, !0),
                        n.preventDefault(),
                        void 0
                    }
                    t.undoManger && (u.collapsed || (t.undoManger.save(), e = 1))
                }
                if (9 == s) {
                    u = t.selection.getRange(),
                    t.undoManger && t.undoManger.save();
                    for (var d = 0, c = ""; d < t.options.tabSize; d++) c += t.options.tabNode;
                    var h = t.document.createElement("span");
                    if (h.innerHTML = c, u.collapsed) {
                        var f = domUtils.findParentByTagName(u.startContainer, "li", !0);
                        if (f && domUtils.isStartInblock(u)) {
                            b = u.createBookmark();
                            var m = f.parentNode,
                            g = t.document.createElement(m.tagName),
                            v = utils.indexOf(o[g.tagName], domUtils.getComputedStyle(m, "list-style-type"));
                            v = v + 1 == o[g.tagName].length ? 0: v + 1,
                            domUtils.setStyle(g, "list-style-type", o[g.tagName][v]),
                            m.insertBefore(g, f),
                            g.appendChild(f),
                            u.moveToBookmark(b).select()
                        } else u.insertNode(h.cloneNode(!0).firstChild).setCursor(!0)
                    } else {
                        if (r = domUtils.findParentByTagName(u.startContainer, "table", !0), l = domUtils.findParentByTagName(u.endContainer, "table", !0), r || l) return n.preventDefault ? n.preventDefault() : n.returnValue = !1,
                        void 0;
                        if (r = domUtils.findParentByTagName(u.startContainer, ["ol", "ul"], !0), l = domUtils.findParentByTagName(u.endContainer, ["ol", "ul"], !0), r && l && r === l) {
                            var b = u.createBookmark();
                            if (r = domUtils.findParentByTagName(u.startContainer, "li", !0), l = domUtils.findParentByTagName(u.endContainer, "li", !0), r === r.parentNode.firstChild) {
                                var y = t.document.createElement(r.parentNode.tagName);
                                r.parentNode.parentNode.insertBefore(y, r.parentNode),
                                y.appendChild(r.parentNode)
                            } else {
                                m = r.parentNode,
                                g = t.document.createElement(m.tagName),
                                v = utils.indexOf(o[g.tagName], domUtils.getComputedStyle(m, "list-style-type")),
                                v = v + 1 == o[g.tagName].length ? 0: v + 1,
                                domUtils.setStyle(g, "list-style-type", o[g.tagName][v]),
                                r.parentNode.insertBefore(g, r);
                                for (var _; r !== l;) _ = r.nextSibling,
                                g.appendChild(r),
                                r = _;
                                g.appendChild(l)
                            }
                            u.moveToBookmark(b).select()
                        } else {
                            if (r || l) return n.preventDefault ? n.preventDefault() : n.returnValue = !1,
                            void 0;
                            if (r = domUtils.findParent(u.startContainer, S), l = domUtils.findParent(u.endContainer, S), r && l && r === l) u.deleteContents(),
                            u.insertNode(h.cloneNode(!0).firstChild).setCursor(!0);
                            else {
                                var w = u.createBookmark(),
                                S = function(t) {
                                    return domUtils.isBlockElm(t)
                                };
                                u.enlarge(!0);
                                for (var x = u.createBookmark(), C = domUtils.getNextDomNode(x.start, !1, S); C && !(domUtils.getPosition(C, x.end) & domUtils.POSITION_FOLLOWING);) C.insertBefore(h.cloneNode(!0).firstChild, C.firstChild),
                                C = domUtils.getNextDomNode(C, !1, S);
                                u.moveToBookmark(x).moveToBookmark(w).select()
                            }
                        }
                    }
                    t.undoManger && t.undoManger.save(),
                    n.preventDefault ? n.preventDefault() : n.returnValue = !1
                }
                if (browser.gecko && 46 == s && (u = t.selection.getRange(), u.collapsed && (r = u.startContainer, domUtils.isEmptyBlock(r)))) {
                    for (var E = r.parentNode; 1 == domUtils.getChildCount(E) && !domUtils.isBody(E);) r = E,
                    E = E.parentNode;
                    return r === E.lastChild && n.preventDefault(),
                    void 0
                }
            }),
            t.addListener("keyup", 
            function(o, a) {
                var r = a.keyCode || a.which;
                if (! (browser.gecko || i[r] || a.ctrlKey || a.metaKey || a.shiftKey || a.altKey) && (m = t.selection.getRange(), m.collapsed)) {
                    for (var l = m.startContainer, u = 0; ! domUtils.isBlockElm(l);) {
                        if (1 == l.nodeType && -1 != utils.indexOf(["FONT", "B", "I"], l.tagName)) {
                            var d = t.document.createElement(n[l.tagName]);
                            for ("FONT" == l.tagName && (d.style.cssText = (l.getAttribute("size") ? "font-size:" + (s[l.getAttribute("size")] || 12) + "px": "") + ";" + (l.getAttribute("color") ? "color:" + l.getAttribute("color") : "") + ";" + (l.getAttribute("face") ? "font-family:" + l.getAttribute("face") : "") + ";" + l.style.cssText); l.firstChild;) d.appendChild(l.firstChild);
                            l.parentNode.insertBefore(d, l),
                            domUtils.remove(l),
                            u || m.setEnd(d, d.childNodes.length).collapse(!0),
                            l = d,
                            u = 1
                        }
                        l = l.parentNode
                    }
                    u && m.select()
                }
                if (8 == r) {
                    if (browser.gecko) for (var c, h = 0, p = domUtils.getElementsByTagName(this.body, "li"); c = p[h++];) if (domUtils.isEmptyNode(c) && !c.previousSibling) {
                        var f = c.parentNode;
                        domUtils.remove(c),
                        domUtils.isEmptyNode(f) && domUtils.remove(f)
                    }
                    var m,
                    l,
                    g,
                    v = this.currentSelectedArr;
                    if (v && v.length > 0) {
                        for (var b, h = 0; b = v[h++];) b.innerHTML = browser.ie ? browser.version < 9 ? "&#65279": "": "<br/>";
                        return m = new dom.Range(this.document),
                        m.setStart(v[0], 0).setCursor(),
                        e && (t.undoManger.save(), e = 0),
                        browser.webkit && a.preventDefault(),
                        void 0
                    }
                    m = t.selection.getRange(),
                    l = m.startContainer,
                    domUtils.isWhitespace(l) && (l = l.parentNode);
                    for (var y = 0; 1 == l.nodeType && domUtils.isEmptyNode(l) && dtd.$removeEmpty[l.tagName];) y = 1,
                    g = l.parentNode,
                    domUtils.remove(l),
                    l = g;
                    if (y && 1 == l.nodeType && domUtils.isEmptyNode(l)) {
                        if (browser.ie) {
                            var _ = m.document.createElement("span");
                            if (l.appendChild(_), m.setStart(l, 0).setCursor(), c = domUtils.findParentByTagName(l, "li", !0)) for (var w = c.nextSibling; w && domUtils.isEmptyBlock(w);) c = w,
                            w = w.nextSibling,
                            domUtils.remove(c)
                        } else l.innerHTML = "<br/>",
                        m.setStart(l, 0).setCursor(!1, !0);
                        setTimeout(function() {
                            browser.ie && domUtils.remove(_),
                            e && (t.undoManger.save(), e = 0)
                        },
                        0)
                    } else e && (t.undoManger.save(), e = 0)
                }
            })
        },
        UE.plugins.fiximgclick = function() {
            var t = this;
            browser.webkit && t.addListener("click", 
            function(e, i) {
                if ("IMG" == i.target.tagName) {
                    var n = new dom.Range(t.document);
                    n.selectNode(i.target).select()
                }
            })
        },
        UE.plugins.autolink = function() {
            var t = 0;
            if (!browser.ie) {
                var e = this;
                e.addListener("reset", 
                function() {
                    t = 0
                }),
                e.addListener("keydown", 
                function(t, i) {
                    var n = i.keyCode || i.which;
                    if (32 == n || 13 == n) {
                        for (var s, o, a = e.selection.getNative(), r = a.getRangeAt(0).cloneRange(), l = r.startContainer; 1 == l.nodeType && r.startOffset > 0 && (l = r.startContainer.childNodes[r.startOffset - 1]);) r.setStart(l, 1 == l.nodeType ? l.childNodes.length: l.nodeValue.length),
                        r.collapse(!0),
                        l = r.startContainer;
                        do {
                            if (0 == r.startOffset) {
                                for (l = r.startContainer.previousSibling; l && 1 == l.nodeType;) l = l.lastChild;
                                if (!l || domUtils.isFillChar(l)) break;
                                s = l.nodeValue.length
                            } else l = r.startContainer,
                            s = r.startOffset;
                            r.setStart(l, s - 1),
                            o = r.toString().charCodeAt(0)
                        }
                        while (160 != o && 32 != o);
                        if (r.toString().replace(new RegExp(domUtils.fillChar, "g"), "").match(/(?:https?:\/\/|ssh:\/\/|ftp:\/\/|file:\/|www\.)/i)) {
                            for (; r.toString().length && !/^(?:https?:\/\/|ssh:\/\/|ftp:\/\/|file:\/|www\.)/i.test(r.toString());) r.setStart(r.startContainer, r.startOffset + 1);
                            var u,
                            d = e.document.createElement("a"),
                            c = e.document.createTextNode(" ");
                            e.undoManger && e.undoManger.save(),
                            d.appendChild(r.extractContents()),
                            d.href = d.innerHTML = d.innerHTML.replace(/<[^>]+>/g, ""),
                            u = d.getAttribute("href").replace(new RegExp(domUtils.fillChar, "g"), ""),
                            d.href = /^(?:https?:\/\/)/gi.test(u) ? u: "http://" + u,
                            r.insertNode(d),
                            d.parentNode.insertBefore(c, d.nextSibling),
                            r.setStart(c, 0),
                            r.collapse(!0),
                            a.removeAllRanges(),
                            a.addRange(r),
                            e.undoManger && e.undoManger.save()
                        }
                    }
                })
            }
        },
        UE.plugins.autoheight = function() {
            function t() {
                clearTimeout(a),
                a = setTimeout(function() {
                    1 != e.queryCommandState("source") && (n || (n = e.document.createElement("span"), n.style.cssText = "display:block;width:0;margin:0;padding:0;border:0;clear:both;", n.innerHTML = "."), s = n.cloneNode(!0), e.body.appendChild(s), o = Math.max(domUtils.getXY(s).y + s.offsetHeight, e.options.minFrameHeight), o != r && (e.setHeight(o), r = o), domUtils.remove(s))
                },
                50)
            }
            var e = this;
            if (e.autoHeightEnabled = e.options.autoHeightEnabled, e.autoHeightEnabled) {
                var i,
                n,
                s,
                o,
                a,
                r = 0;
                e.addListener("destroy", 
                function() {
                    e.removeListener("contentchange", t),
                    e.removeListener("keyup", t),
                    e.removeListener("mouseup", t)
                }),
                e.enableAutoHeight = function() {
                    if (e.autoHeightEnabled) {
                        var n = e.document;
                        e.autoHeightEnabled = !0,
                        i = n.body.style.overflowY,
                        n.body.style.overflowY = "hidden",
                        e.addListener("contentchange", t),
                        e.addListener("keyup", t),
                        e.addListener("mouseup", t),
                        setTimeout(function() {
                            t()
                        },
                        browser.gecko ? 100: 0),
                        e.fireEvent("autoheightchanged", e.autoHeightEnabled)
                    }
                },
                e.disableAutoHeight = function() {
                    e.body.style.overflowY = i || "",
                    e.removeListener("contentchange", t),
                    e.removeListener("keyup", t),
                    e.removeListener("mouseup", t),
                    e.autoHeightEnabled = !1,
                    e.fireEvent("autoheightchanged", e.autoHeightEnabled)
                },
                e.addListener("ready", 
                function() {
                    e.enableAutoHeight()
                })
            }
        },
        UE.plugins.autofloat = function() {
            function t(t) {
                if (!t.ui) throw alert("autofloat插件功能依赖于UEditor UI\nautofloat定义位置: _src/plugins/autofloat/autofloat.js"),
                {
                    name: "未包含UI文件",
                    message: "autofloat功能依赖于UEditor UI。autofloat定义位置: _src/plugins/autofloat/autofloat.js"
                };
                return o = UE.ui.uiUtils,
                1
            }
            function e() {
                var t = document.body.style;
                t.backgroundImage = 'url("about:blank")',
                t.backgroundAttachment = "fixed"
            }
            function i() {
                var t = domUtils.getXY(d),
                e = domUtils.getComputedStyle(d, "position"),
                i = domUtils.getComputedStyle(d, "left");
                d.style.width = d.offsetWidth + "px",
                d.style.zIndex = 1 * p.options.zIndex + 1,
                d.parentNode.insertBefore(f, d),
                a || r ? ("absolute" != d.style.position && (d.style.position = "absolute"), d.style.top = (document.body.scrollTop || document.documentElement.scrollTop) - c + "px") : (browser.ie7Compat && (d.style.left = h(d).left - document.documentElement.getBoundingClientRect().left + "px"), "fixed" != d.style.position && (d.style.position = "fixed", d.style.top = "0", ("absolute" == e || "relative" == e) && parseFloat(i) && (d.style.left = t.x + "px")))
            }
            function n() {
                f.parentNode && f.parentNode.removeChild(f),
                d.style.cssText = u
            }
            function s() {
                var t = h(p.container);
                t.top < 0 && t.bottom - d.offsetHeight > 0 ? i() : n()
            }
            var o,
            a = browser.ie && browser.version <= 6,
            r = browser.quirks,
            l = this.options.autoFloatEnabled;
            if (l) {
                var u,
                d,
                c,
                h,
                p = this,
                f = document.createElement("div"),
                m = utils.defer(function() {
                    s()
                },
                browser.ie ? 200: 100, !0);
                p.addListener("destroy", 
                function() {
                    domUtils.un(window, ["scroll", "resize"], s),
                    p.removeListener("keydown", m)
                }),
                p.addListener("ready", 
                function() {
                    t(p) && (h = o.getClientRect, d = p.ui.getDom("toolbarbox"), c = h(d).top, u = d.style.cssText, f.style.height = d.offsetHeight + "px", a && e(), p.addListener("autoheightchanged", 
                    function(t, e) {
                        e ? (domUtils.on(window, ["scroll", "resize"], s), p.addListener("keydown", m)) : (domUtils.un(window, ["scroll", "resize"], s), p.removeListener("keydown", m))
                    }), p.addListener("beforefullscreenchange", 
                    function(t, e) {
                        e && n()
                    }), p.addListener("fullscreenchanged", 
                    function(t, e) {
                        e || s()
                    }), p.addListener("sourcemodechanged", 
                    function() {
                        setTimeout(function() {
                            s()
                        })
                    }))
                })
            }
        },
        UE.plugins.serialize = function() {
            function t(t) {
                return /pt/.test(t) ? t.replace(/([\d.]+)pt/g, 
                function(t) {
                    return Math.round(96 * parseFloat(t) / 72) + "px"
                }) : t
            }
            function e(t) {
                var e;
                if (t && "p" == t.tag) if ("MsoListParagraph" == t.attributes["class"] || /mso-list/.test(t.attributes.style)) e = 1;
                else {
                    var i = t.children[0];
                    i && "span" == i.tag && /Wingdings/i.test(i.attributes.style) && (e = 1)
                }
                return e
            }
            function i(t, i) {
                if ("element" == t.type && !t.children.length && dtd.$removeEmpty[t.tag] && "a" != t.tag) return {
                    type: "fragment",
                    children: []
                };
                var s,
                o = [0, 10, 12, 16, 18, 24, 32, 48],
                a = utils.indexOf;
                switch (t.tag) {
                case "img":
                    if (t.attributes.src && /^data:/.test(t.attributes.src)) return {
                        type: "fragment",
                        children: []
                    };
                    if (t.attributes.src && /^(?:file)/.test(t.attributes.src)) {
                        if (!/(gif|bmp|png|jpg|jpeg)$/.test(t.attributes.src)) return {
                            type: "fragment",
                            children: []
                        };
                        t.attributes.word_img = t.attributes.src,
                        t.attributes.src = c.options.UEDITOR_HOME_URL + "themes/default/images/localimage.jpg",
                        i && (i.flag = 1)
                    }
                    browser.ie && browser.version < 7 && c.options.relativePath && (t.attributes.orgSrc = t.attributes.src),
                    t.attributes.data_ue_src = t.attributes.data_ue_src || t.attributes.src;
                    break;
                case "li":
                    var u = t.children[0];
                    if (!u || "element" != u.type || "p" != u.tag && dtd.p[u.tag]) {
                        var d = {
                            type: "element",
                            tag: "p",
                            attributes: {},
                            parent: t
                        };
                        d.children = u ? t.children: [browser.ie ? {
                            type: "text",
                            data: domUtils.fillChar,
                            parent: d
                        }: {
                            type: "element",
                            tag: "br",
                            attributes: {},
                            closed: !0,
                            children: [],
                            parent: d
                        }],
                        t.children = [d]
                    }
                    break;
                case "table":
                case "td":
                    n(t);
                    break;
                case "a":
                    t.attributes.anchorname && (t.tag = "img", t.attributes = {
                        "class": "anchorclass",
                        anchorname: t.attributes.name
                    },
                    t.closed = 1),
                    t.attributes.href && (t.attributes.data_ue_src = t.attributes.href);
                    break;
                case "b":
                    t.tag = t.name = "strong";
                    break;
                case "i":
                    t.tag = t.name = "em";
                    break;
                case "u":
                    t.tag = t.name = "span",
                    t.attributes.style = (t.attributes.style || "") + ";text-decoration:underline;";
                    break;
                case "s":
                case "del":
                    t.tag = t.name = "span",
                    t.attributes.style = (t.attributes.style || "") + ";text-decoration:line-through;",
                    1 == t.children.length && (u = t.children[0], u.tag == t.tag && (t.attributes.style += ";" + u.attributes.style, t.children = u.children));
                    break;
                case "span":
                    if (/mso-list/.test(t.attributes.style)) {
                        if ("end" != l) {
                            for (var h, p = t.children[0];
                            "element" == p.type;) p = p.children[0];
                            for (h in y) if (y[h].test(p.data)) {
                                _ = "ul",
                                w = h;
                                break
                            }
                            if (!_) for (h in b) if (b[h].test(p.data.replace(/\.$/, ""))) {
                                _ = "ol",
                                w = h;
                                break
                            }
                            if (l ? (p.data == l ? ("ul" != _ && (w = ""), _ = "ul") : ("ol" != _ && (w = ""), _ = "ol"), l = "end") : l = p.data, _) {
                                for (var f = t; f && "ul" != f.tag && "ol" != f.tag;) f = f.parent;
                                f && (f.tag = _, f.attributes.style = "list-style-type:" + w)
                            }
                        }
                        t = {
                            type: "fragment",
                            children: []
                        };
                        break
                    }
                    var m = t.attributes.style;
                    if (m && (m = m.match(/(?:\b(?:color|font-size|background(-color)?|font-family|text-decoration)\b\s*:\s*(&[^;]+;|[^;])+(?=;)?)/gi), m && (t.attributes.style = m.join(";"), t.attributes.style || delete t.attributes.style)), browser.gecko && browser.version <= 10902 && t.parent) {
                        var g = t.parent;
                        "span" == g.tag && g.attributes && g.attributes.style && (t.attributes.style = g.attributes.style + ";" + t.attributes.style)
                    }
                    utils.isEmptyObject(t.attributes) && (t.type = "fragment");
                    break;
                case "font":
                    for (t.tag = t.name = "span", s = t.attributes, t.attributes = {
                        style: (s.size ? "font-size:" + (o[s.size] || 12) + "px": "") + ";" + (s.color ? "color:" + s.color: "") + ";" + (s.face ? "font-family:" + s.face: "") + ";" + (s.style || "")
                    }; t.parent.tag == t.tag && 1 == t.parent.children.length;) t.attributes.style && (t.parent.attributes.style ? t.parent.attributes.style += ";" + t.attributes.style: t.parent.attributes.style = t.attributes.style),
                    t.parent.children = t.children,
                    t = t.parent;
                    break;
                case "p":
                    if (t.attributes.align && (t.attributes.style = (t.attributes.style || "") + ";text-align:" + t.attributes.align + ";", delete t.attributes.align), e(t)) {
                        if (!r) {
                            var v = {
                                type: "element",
                                tag: "ul",
                                attributes: {},
                                children: []
                            },
                            S = a(t.parent.children, t);
                            for (t.parent.children[S] = v, v.parent = t.parent, v.children[0] = t, t.parent = v;;) {
                                if (t = v.parent.children[S + 1], !e(t)) break;
                                v.children[v.children.length] = t,
                                t.parent = v,
                                v.parent.children.splice(S + 1, 1)
                            }
                            return v
                        }
                        if (t.tag = t.name = "li", browser.webkit) {
                            for (var x = t.children[0]; x && "element" == x.type;) x = x.children[0];
                            x && (x.parent.attributes.style = (x.parent.attributes.style || "") + ";mso-list:10")
                        }
                        delete t.attributes["class"],
                        delete t.attributes.style
                    }
                }
                return t
            }
            function n(t) {
                if (u && t.attributes.style) {
                    var e = t.attributes.style;
                    t.attributes.style = e.replace(/;\s*/g, ";"),
                    t.attributes.style = t.attributes.style.replace(/^\s*|\s*$/, "")
                }
            }
            function s(t) {
                switch ("text" == t.type, t.tag) {
                case "table":
                    !t.attributes.style && delete t.attributes.style,
                    u && t.attributes.style && n(t);
                    break;
                case "td":
                case "th":
                    if (/display\s*:\s*none/i.test(t.attributes.style)) return {
                        type:
                        "fragment",
                        children: []
                    };
                    if (u && !t.children.length) {
                        var e = {
                            type: "text",
                            data: domUtils.fillChar,
                            parent: t
                        };
                        t.children[0] = e
                    }
                    u && t.attributes.style && n(t);
                    break;
                case "img":
                    t.attributes.anchorname ? (t.tag = "a", t.attributes = {
                        name: t.attributes.anchorname,
                        anchorname: 1
                    },
                    t.closed = null) : t.attributes.data_ue_src && (t.attributes.src = t.attributes.data_ue_src, delete t.attributes.data_ue_src);
                    break;
                case "a":
                    t.attributes.data_ue_src && (t.attributes.href = t.attributes.data_ue_src, delete t.attributes.data_ue_src)
                }
                return t
            }
            function o(t, e, i) {
                if (!t.children || !t.children.length) return t;
                for (var n = t.children, s = 0; s < n.length; s++) {
                    var o = e(n[s], i);
                    if ("fragment" == o.type) {
                        var a = [s, 1];
                        a.push.apply(a, o.children),
                        n.splice.apply(n, a),
                        n.length || (t = {
                            type: "fragment",
                            children: []
                        }),
                        s--
                    } else n[s] = o
                }
                return t
            }
            function a(t) {
                this.rules = t
            }
            var r,
            l,
            u = browser.ie,
            d = browser.version,
            c = this,
            h = dtd.$empty,
            p = function() {
                function t(t, o) {
                    var a,
                    r,
                    l,
                    c = 0;
                    for (e.exec(""); a = e.exec(t);) {
                        var h = a.index;
                        if (h > c) {
                            var p = t.slice(c, h);
                            l ? l.push(p) : o.onText(p)
                        }
                        if (c = e.lastIndex, !(r = a[1]) || (r = r.toLowerCase(), l && r == l._tag_name && (o.onCDATA(l.join("")), l = null), l)) if (l) l.push(a[0]);
                        else if (r = a[3]) {
                            if (/="/.test(r)) continue;
                            r = r.toLowerCase();
                            var f,
                            m = a[4],
                            g = {},
                            v = m && "/" == m.slice( - 1);
                            if (m) for (i.exec(""); f = i.exec(m);) {
                                var b = f[1].toLowerCase(),
                                y = f[2] || f[3] || f[4] || ""; ! y && n[b] && (y = b),
                                "style" == b && u && 6 >= d && (y = y.replace(/(?!;)\s*([\w-]+):/g, 
                                function(t, e) {
                                    return e.toLowerCase() + ":"
                                })),
                                y && (g[b] = y.replace(/:\s*/g, ":"))
                            }
                            o.onTagOpen(r, g, v),
                            !l && s[r] && (l = [], l._tag_name = r)
                        } else(r = a[2]) && o.onComment(r);
                        else o.onTagClose(r)
                    }
                    t.length > c && o.onText(t.slice(c, t.length))
                }
                var e = /<(?:(?:\/([^>]+)>[\t\r\n]*)|(?:!--([\S|\s]*?)-->)|(?:([^\s\/>]+)\s*((?:(?:"[^"]*")|(?:'[^']*')|[^"'<>])*)\/?>[ \t\r\n]*))/g,
                i = /([\w\-:.]+)(?:(?:\s*=\s*(?:(?:"([^"]*)")|(?:'([^']*)')|([^\s>]+)))|(?=\s|$))/g,
                n = {
                    checked: 1,
                    compact: 1,
                    declare: 1,
                    defer: 1,
                    disabled: 1,
                    ismap: 1,
                    multiple: 1,
                    nohref: 1,
                    noresize: 1,
                    noshade: 1,
                    nowrap: 1,
                    readonly: 1,
                    selected: 1
                },
                s = {
                    script: 1,
                    style: 1
                },
                o = {
                    li: {
                        $: "ul",
                        ul: 1,
                        ol: 1
                    },
                    dd: {
                        $: "dl",
                        dl: 1
                    },
                    dt: {
                        $: "dl",
                        dl: 1
                    },
                    option: {
                        $: "select",
                        select: 1
                    },
                    td: {
                        $: "tr",
                        tr: 1
                    },
                    th: {
                        $: "tr",
                        tr: 1
                    },
                    tr: {
                        $: "tbody",
                        tbody: 1,
                        thead: 1,
                        tfoot: 1,
                        table: 1
                    },
                    tbody: {
                        $: "table",
                        table: 1,
                        colgroup: 1
                    },
                    thead: {
                        $: "table",
                        table: 1
                    },
                    tfoot: {
                        $: "table",
                        table: 1
                    },
                    col: {
                        $: "colgroup",
                        colgroup: 1
                    }
                },
                a = {
                    table: "td",
                    tbody: "td",
                    thead: "td",
                    tfoot: "td",
                    tr: "td",
                    colgroup: "col",
                    ul: "li",
                    ol: "li",
                    dl: "dd",
                    select: "option"
                };
                return function(e, i) {
                    function n(t) {
                        t.parent = u,
                        u.children.push(t)
                    }
                    function s(t, e) {
                        var n = t;
                        if (o[n.tag]) {
                            for (; o[u.tag] && o[u.tag][n.tag];) u = u.parent;
                            for (u.tag == n.tag && (u = u.parent); o[n.tag] && !o[n.tag][u.tag];) n = n.parent = {
                                type: "element",
                                tag: o[n.tag].$,
                                attributes: {},
                                children: [n]
                            }
                        }
                        if (i) for (; dtd[n.tag] && !("span" == u.tag ? utils.extend(dtd.strong, {
                            a: 1,
                            A: 1
                        }) : dtd[u.tag] || dtd.div)[n.tag];) if (!r(u)) {
                            if (!u.parent) break;
                            u = u.parent
                        }
                        return n.parent = u,
                        u.children.push(n),
                        e && (u = t),
                        t.attributes.style && (t.attributes.style = t.attributes.style.toLowerCase()),
                        t
                    }
                    function r(t) {
                        var e;
                        return ! t.children.length && (e = a[t.tag]) ? (s({
                            type: "element",
                            tag: e,
                            attributes: {},
                            children: []
                        },
                        !0), !0) : !1
                    }
                    var l = {
                        type: "fragment",
                        parent: null,
                        children: []
                    },
                    u = l;
                    for (t(e, {
                        onText: function(t) {
                            for (; ! (dtd[u.tag] || dtd.div)["#"];) {
                                if (/^[ \t\r\n]+$/.test(t)) return;
                                r(u) || (u = u.parent)
                            }
                            n({
                                type: "text",
                                data: t
                            })
                        },
                        onComment: function(t) {
                            n({
                                type: "comment",
                                data: t
                            })
                        },
                        onCDATA: function(t) {
                            for (; ! (dtd[u.tag] || dtd.div)["#"];) r(u) || (u = u.parent);
                            n({
                                type: "cdata",
                                data: t
                            })
                        },
                        onTagOpen: function(t, e, i) {
                            i = i || h[t],
                            s({
                                type: "element",
                                tag: t,
                                attributes: e,
                                closed: i,
                                children: []
                            },
                            !i)
                        },
                        onTagClose: function(t) {
                            for (var e = u; e && t != e.tag;) e = e.parent;
                            if (e) {
                                for (var i = u; i !== e.parent; i = i.parent) r(i);
                                e.children.length || !dtd.$removeEmpty[e.tag] || e.attributes.anchorname || "pagebreak" == e.attributes["class"] || "a" == e.tag || e.parent.children.pop(),
                                u = e.parent
                            } else dtd.$removeEmpty[t] || dtd.$removeEmptyBlock[t] || "embed" == t || (e = {
                                type: "element",
                                tag: t,
                                attributes: {},
                                children: []
                            },
                            s(e, !0), r(e), u = e.parent)
                        }
                    }); u !== l;) r(u),
                    u = u.parent;
                    return l
                }
            } (),
            f = function() {
                function t(t) {
                    return e[t]
                }
                var e = {
                    "<": "&lt;",
                    ">": "&gt;",
                    '"': "&quot;",
                    "'": "&#39;"
                };
                return function(e) {
                    return e += "",
                    e ? e.replace(/[<>"']/g, t) : ""
                }
            } (),
            m = function() {
                function e(t, e) {
                    for (var i, n = t.children, s = [], o = 0; i = n[o]; o++) s.push(m(i, e));
                    return s.join("")
                }
                function i(e) {
                    var i = [];
                    for (var n in e) {
                        var s = e[n];
                        "style" == n && (s = t(s), /rgba?\s*\([^)]*\)/.test(s) && (s = s.replace(/rgba?\s*\(([^)]*)\)/g, 
                        function(t) {
                            return utils.fixColor("color", t)
                        })), e[n] = utils.optCss(s.replace(/windowtext/g, "#000"))),
                        i.push(n + '="' + f(e[n]) + '"')
                    }
                    return i.join(" ").replace(/\;+/g, ";")
                }
                function n(t, e) {
                    return e ? t.data.replace(/&nbsp;/g, " ") : f(t.data).replace(/ /g, "&nbsp;")
                }
                function s(t, n) {
                    var s = t.tag;
                    if (n && "td" == s) r || (r = ""),
                    r += e(t, n) + "&nbsp;&nbsp;&nbsp;";
                    else {
                        var a = i(t.attributes),
                        r = "<" + (n && o[s] ? o[s] : s) + (a ? " " + a: "") + (h[s] ? " />": ">");
                        h[s] || (browser.ie && "p" == s && !t.children.length && (r += "&nbsp;"), r += e(t, n), r += "</" + (n && o[s] ? o[s] : s) + ">")
                    }
                    return r
                }
                var o = {
                    div: "p",
                    li: "p",
                    tr: "p",
                    br: "br",
                    p: "p"
                };
                return function(t, i) {
                    return "fragment" == t.type ? e(t, i) : "element" == t.type ? s(t, i) : "text" == t.type || "cdata" == t.type ? n(t, dtd.$notTransContent[t.parent.tag]) : "comment" == t.type ? "<!--" + t.data + "-->": ""
                }
            } (),
            g = function() {
                function e(t) {
                    var e = new RegExp(/(class="?Mso|style="[^"]*\bmso\-|w:WordDocument|<v:)/gi);
                    return e.test(t)
                }
                function i(t) {
                    return t = t.replace(/([\d.]+)([\w]+)?/g, 
                    function(t, e, i) {
                        return (Math.round(parseFloat(e)) || 1) + (i || "px")
                    })
                }
                function n(e) {
                    return e = e.replace(/<!--\s*EndFragment\s*-->[\s\S]*$/, "").replace(/^(\r\n|\n|\r)|(\r\n|\n|\r)$/gi, "").replace(/^\s*(&nbsp;)+/gi, "").replace(/(&nbsp;|<br[^>]*>)+\s*$/gi, "").replace(/<!--[\s\S]*?-->/gi, "").replace(/<v:shape [^>]*>[\s\S]*?.<\/v:shape>/gi, 
                    function(e) {
                        var i = e.match(/width:([ \d.]*p[tx])/i)[1],
                        n = e.match(/height:([ \d.]*p[tx])/i)[1],
                        s = e.match(/src=\s*"([^"]*)"/i)[1];
                        return '<img width="' + t(i) + '" height="' + t(n) + '" src="' + s + '" />'
                    }).replace(/v:\w+=["']?[^'"]+["']?/g, "").replace(/<(!|script[^>]*>.*?<\/script(?=[>\s])|\/?(\?xml(:\w+)?|xml|meta|link|style|\w+:\w+)(?=[\s\/>]))[^>]*>/gi, "").replace(/<p [^>]*class="?MsoHeading"?[^>]*>(.*?)<\/p>/gi, "<p><strong>$1</strong></p>").replace(/(lang)\s*=\s*([\'\"]?)[\w-]+\2/gi, "").replace(/<font[^>]*>\s*<\/font>/gi, "").replace(/class\s*=\s*["']?(?:(?:MsoTableGrid)|(?:MsoNormal(Table)?))\s*["']?/gi, ""),
                    e = e.replace(/(<[a-z][^>]*)\sstyle=(["'])([^\2]*?)\2/gi, 
                    function(t, e, n, s) {
                        for (var o = [], a = 0, r = s.replace(/^\s+|\s+$/, "").replace(/&quot;/gi, "'").split(/;\s*/g), a = 0; a < r.length; a++) {
                            var l,
                            u,
                            d = r[a],
                            c = d.split(":");
                            if (2 == c.length) {
                                switch (l = c[0].toLowerCase(), u = c[1].toLowerCase(), l) {
                                case "mso-padding-alt":
                                case "mso-padding-top-alt":
                                case "mso-padding-right-alt":
                                case "mso-padding-bottom-alt":
                                case "mso-padding-left-alt":
                                case "mso-margin-alt":
                                case "mso-margin-top-alt":
                                case "mso-margin-right-alt":
                                case "mso-margin-bottom-alt":
                                case "mso-margin-left-alt":
                                case "mso-table-layout-alt":
                                case "mso-height":
                                case "mso-width":
                                case "mso-border-alt":
                                case "mso-vertical-align-alt":
                                    o[a++] = l.replace(/^mso-|-alt$/g, "") + ":" + i(u);
                                    continue;
                                case "horiz-align":
                                    o[a++] = "text-align:" + u;
                                    continue;
                                case "vert-align":
                                    o[a++] = "vertical-align:" + u;
                                    continue;
                                case "font-color":
                                case "mso-foreground":
                                    o[a++] = "color:" + u;
                                    continue;
                                case "mso-background":
                                case "mso-highlight":
                                    o[a++] = "background:" + u;
                                    continue;
                                case "mso-default-height":
                                    o[a++] = "min-height:" + i(u);
                                    continue;
                                case "mso-default-width":
                                    o[a++] = "min-width:" + i(u);
                                    continue;
                                case "mso-padding-between-alt":
                                    o[a++] = "border-collapse:separate;border-spacing:" + i(u);
                                    continue;
                                case "text-line-through":
                                    ("single" == u || "double" == u) && (o[a++] = "text-decoration:line-through");
                                    continue;
                                case "font-family":
                                    continue;
                                case "mso-zero-height":
                                    "yes" == u && (o[a++] = "display:none");
                                    continue;
                                case "margin":
                                    if (!/[1-9]/.test(c[1])) continue
                                }
                                if (/^(mso|column|font-emph|lang|layout|line-break|list-image|nav|panose|punct|row|ruby|sep|size|src|tab-|table-border|text-(?:decor|trans)|top-bar|version|vnd|word-break)/.test(l) && !/mso\-list/.test(l)) continue;
                                o[a] = l + ":" + c[1]
                            }
                        }
                        return a > 0 ? e + ' style="' + o.join(";") + '"': e
                    }),
                    e = e.replace(/([ ]+)<\/span>/gi, 
                    function(t, e) {
                        return new Array(e.length + 1).join("&nbsp;") + "</span>"
                    })
                }
                return function(t) {
                    return r = null,
                    _ = "",
                    w = "",
                    l = "",
                    e(t) && (t = n(t)),
                    t.replace(/>[ \t\r\n]*</g, "><")
                }
            } (),
            v = {
                text: "#text",
                comment: "#comment",
                cdata: "#cdata-section",
                fragment: "#document-fragment"
            },
            b = {
                decimal: /\d+/,
                "lower-roman": /^m{0,4}(cm|cd|d?c{0,3})(xc|xl|l?x{0,3})(ix|iv|v?i{0,3})$/,
                "upper-roman": /^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$/,
                "lower-alpha": /^\(?[a-z]+\)?$/,
                "upper-alpha": /^\(?[A-Z]+\)?$/
            },
            y = {
                disc: /^[l\u00B7\u2002]/,
                circle: /^[\u006F\u00D8]/,
                square: /^[\u006E\u25C6]/
            },
            _ = "",
            w = "";
            a.prototype = {
                rules: null,
                filter: function(t, e, i) {
                    function n(t, e) {
                        if (t.name = "element" == t.type ? t.tag: v[t.type], null == e) return o(t, n, t);
                        if (a && a[t.name]) return i && (i.flag = 1),
                        {
                            type: "fragment",
                            children: []
                        };
                        if (s && "element" == t.type) if ("fragment" == e.type ? s[t.name] : s[t.name] && s[e.name][t.name]) {
                            var r;
                            if (r = s[t.name].$) {
                                var l = t.attributes,
                                u = {};
                                for (var d in r) l[d] && (u[d] = l[d]);
                                t.attributes = u
                            }
                        } else i && (i.flag = 1),
                        t.type = "fragment",
                        t.name = e.name;
                        return (a || s) && o(t, n, t),
                        t
                    }
                    e = e || this.rules;
                    var s = e && e.whiteList,
                    a = e && e.blackList;
                    return n(t, null)
                },
                transformInput: function(t, e) {
                    function n(t) {
                        return t = i(t, e),
                        ("ol" == t.tag || "ul" == t.tag) && (r = 1),
                        t = o(t, n, t),
                        ("ol" == t.tag || "ul" == t.tag) && (r = 0, _ = "", w = "", l = ""),
                        "text" == t.type && t.data.replace(/\s/g, "") == c.options.pageBreakTag && (t.type = "element", t.name = t.tag = "div", delete t.data, t.attributes = {
                            "class": "pagebreak",
                            unselectable: "on",
                            style: "moz-user-select:none;-khtml-user-select: none;"
                        },
                        t.children = []),
                        "text" != t.type || dtd.$notTransContent[t.parent.tag] || (t.data = t.data.replace(/[\r\t\n]*/g, "").replace(/[ ]*$/g, "")),
                        t
                    }
                    return n(t)
                },
                transformOutput: function(t) {
                    function e(t) {
                        return "div" == t.tag && "pagebreak" == t.attributes["class"] && (delete t.tag, t.type = "text", t.data = c.options.pageBreakTag, delete t.children),
                        t = s(t),
                        ("ol" == t.tag || "ul" == t.tag) && (r = 1),
                        t = o(t, e, t),
                        ("ol" == t.tag || "ul" == t.tag) && (r = 0),
                        t
                    }
                    return e(t)
                },
                toHTML: m,
                parseHTML: p,
                word: g
            },
            c.serialize = new a(c.options.serialize),
            UE.serialize = new a({})
        },
        UE.plugins.contextmenu = function() {
            var t,
            e = this,
            i = e.options.contextMenu;
            if (i && 0 != i.length) {
                var n = UE.ui.uiUtils;
                e.addListener("contextmenu", 
                function(s, o) {
                    var a = n.getViewportOffsetByEvent(o);
                    t && t.destroy();
                    for (var r, l = 0, u = []; r = i[l]; l++) {
                        var d; ! 
                        function(t) {
                            if ("-" == t)(d = u[u.length - 1]) && "-" !== d && u.push("-");
                            else if (t.group) {
                                for (var i, n = 0, s = []; i = t.subMenu[n]; n++) ! 
                                function(t) {
                                    "-" == t ? (d = s[s.length - 1]) && "-" !== d && s.push("-") : -1 != e.queryCommandState(t.cmdName) && s.push({
                                        label: t.label,
                                        className: "edui-for-" + t.cmdName + (t.value || ""),
                                        onclick: t.exec ? 
                                        function() {
                                            t.exec.call(e)
                                        }: function() {
                                            e.execCommand(t.cmdName, t.value)
                                        }
                                    })
                                } (i);
                                s.length && u.push({
                                    label: t.group,
                                    className: "edui-for-" + t.icon,
                                    subMenu: {
                                        items: s,
                                        editor: e
                                    }
                                })
                            } else if ( - 1 != e.queryCommandState(t.cmdName)) {
                                if ("highlightcode" == t.cmdName && 0 == e.queryCommandState(t.cmdName)) return;
                                u.push({
                                    label: t.label,
                                    className: "edui-for-" + (t.icon ? t.icon: t.cmdName + (t.value || "")),
                                    onclick: t.exec ? 
                                    function() {
                                        t.exec.call(e)
                                    }: function() {
                                        e.execCommand(t.cmdName, t.value)
                                    }
                                })
                            }
                        } (r)
                    }
                    if ("-" == u[u.length - 1] && u.pop(), t = new UE.ui.Menu({
                        items: u,
                        editor: e
                    }), t.render(), t.showAt(a), domUtils.preventDefault(o), browser.ie) {
                        var c;
                        try {
                            c = e.selection.getNative().createRange()
                        } catch(h) {
                            return
                        }
                        if (c.item) {
                            var p = new dom.Range(e.document);
                            p.selectNode(c.item(0)).select(!0, !0)
                        }
                    }
                })
            }
        },
        UE.plugins.basestyle = function() {
            var t = {
                bold: ["strong", "b"],
                italic: ["em", "i"],
                subscript: ["sub"],
                superscript: ["sup"]
            },
            e = function(t, e) {
                var i = t.selection.getStartElementPath();
                return utils.findNode(i, e)
            },
            i = this;
            for (var n in t) ! 
            function(t, n) {
                i.commands[t] = {
                    execCommand: function(t) {
                        var s = new dom.Range(i.document),
                        o = "";
                        if (i.currentSelectedArr && i.currentSelectedArr.length > 0) {
                            for (var a, r = 0; a = i.currentSelectedArr[r++];)"none" != a.style.display && (s.selectNodeContents(a).select(), !o && (o = e(this, n)), ("superscript" == t || "subscript" == t) && (o && o.tagName.toLowerCase() == t || s.removeInlineStyle(["sub", "sup"])), o ? s.removeInlineStyle(n) : s.applyInlineStyle(n[0]));
                            s.selectNodeContents(i.currentSelectedArr[0]).select()
                        } else {
                            if (s = i.selection.getRange(), o = e(this, n), s.collapsed) {
                                if (o) {
                                    var l = i.document.createTextNode("");
                                    s.insertNode(l).removeInlineStyle(n),
                                    s.setStartBefore(l),
                                    domUtils.remove(l)
                                } else {
                                    var u = s.document.createElement(n[0]); ("superscript" == t || "subscript" == t) && (l = i.document.createTextNode(""), s.insertNode(l).removeInlineStyle(["sub", "sup"]).setStartBefore(l).collapse(!0)),
                                    s.insertNode(u).setStart(u, 0)
                                }
                                s.collapse(!0)
                            } else("superscript" == t || "subscript" == t) && (o && o.tagName.toLowerCase() == t || s.removeInlineStyle(["sub", "sup"])),
                            o ? s.removeInlineStyle(n) : s.applyInlineStyle(n[0]);
                            s.select()
                        }
                        return ! 0
                    },
                    queryCommandState: function() {
                        return this.highlight ? -1: e(this, n) ? 1: 0
                    }
                }
            } (n, t[n])
        };
        var baidu = baidu || {};
        baidu.editor = baidu.editor || {},
        baidu.editor.ui = {},
        function() {
            function t() {
                var t = document.getElementById("edui_fixedlayer");
                l.setViewportOffset(t, {
                    left: 0,
                    top: 0
                })
            }
            function e() {
                n.on(window, "scroll", t),
                n.on(window, "resize", baidu.editor.utils.defer(t, 0, !0))
            }
            var i = baidu.editor.browser,
            n = baidu.editor.dom.domUtils,
            s = "$EDITORUI",
            o = window[s] = {},
            a = "ID" + s,
            r = 0,
            l = baidu.editor.ui.uiUtils = {
                uid: function(t) {
                    return t ? t[a] || (t[a] = ++r) : ++r
                },
                hook: function(t, e) {
                    var i;
                    return t && t._callbacks ? i = t: (i = function() {
                        var e;
                        t && (e = t.apply(this, arguments));
                        for (var n = i._callbacks, s = n.length; s--;) {
                            var o = n[s].apply(this, arguments);
                            void 0 === e && (e = o)
                        }
                        return e
                    },
                    i._callbacks = []),
                    i._callbacks.push(e),
                    i
                },
                createElementByHtml: function(t) {
                    var e = document.createElement("div");
                    return e.innerHTML = t,
                    e = e.firstChild,
                    e.parentNode.removeChild(e),
                    e
                },
                getViewportElement: function() {
                    return i.ie && i.quirks ? document.body: document.documentElement
                },
                getClientRect: function(t) {
                    for (var e, i = t.getBoundingClientRect(), s = {
                        left: Math.round(i.left),
                        top: Math.round(i.top),
                        height: Math.round(i.bottom - i.top),
                        width: Math.round(i.right - i.left)
                    }; (e = t.ownerDocument) !== document && (t = n.getWindow(e).frameElement);) i = t.getBoundingClientRect(),
                    s.left += i.left,
                    s.top += i.top;
                    return s.bottom = s.top + s.height,
                    s.right = s.left + s.width,
                    s
                },
                getViewportRect: function() {
                    var t = l.getViewportElement(),
                    e = 0 | (window.innerWidth || t.clientWidth),
                    i = 0 | (window.innerHeight || t.clientHeight);
                    return {
                        left: 0,
                        top: 0,
                        height: i,
                        width: e,
                        bottom: i,
                        right: e
                    }
                },
                setViewportOffset: function(t, e) {
                    var i = l.getFixedLayer();
                    t.parentNode === i ? (t.style.left = e.left + "px", t.style.top = e.top + "px") : n.setViewportOffset(t, e)
                },
                getEventOffset: function(t) {
                    var e = t.target || t.srcElement,
                    i = l.getClientRect(e),
                    n = l.getViewportOffsetByEvent(t);
                    return {
                        left: n.left - i.left,
                        top: n.top - i.top
                    }
                },
                getViewportOffsetByEvent: function(t) {
                    var e = t.target || t.srcElement,
                    i = n.getWindow(e).frameElement,
                    s = {
                        left: t.clientX,
                        top: t.clientY
                    };
                    if (i && e.ownerDocument !== document) {
                        var o = l.getClientRect(i);
                        s.left += o.left,
                        s.top += o.top
                    }
                    return s
                },
                setGlobal: function(t, e) {
                    return o[t] = e,
                    s + '["' + t + '"]'
                },
                unsetGlobal: function(t) {
                    delete o[t]
                },
                copyAttributes: function(t, e) {
                    for (var n = e.attributes, s = n.length; s--;) {
                        var o = n[s];
                        "style" == o.nodeName || "class" == o.nodeName || i.ie && !o.specified || t.setAttribute(o.nodeName, o.nodeValue)
                    }
                    e.className && (t.className += " " + e.className),
                    e.style.cssText && (t.style.cssText += ";" + e.style.cssText)
                },
                removeStyle: function(t, e) {
                    if (t.style.removeProperty) t.style.removeProperty(e);
                    else {
                        if (!t.style.removeAttribute) throw "";
                        t.style.removeAttribute(e)
                    }
                },
                contains: function(t, e) {
                    return t && e && (t === e ? !1: t.contains ? t.contains(e) : 16 & t.compareDocumentPosition(e))
                },
                startDrag: function(t, e, i) {
                    function n(t) {
                        var i = t.clientX - a,
                        n = t.clientY - r;
                        e.ondragmove(i, n),
                        t.stopPropagation ? t.stopPropagation() : t.cancelBubble = !0
                    }
                    function s() {
                        i.removeEventListener("mousemove", n, !0),
                        i.removeEventListener("mouseup", n, !0),
                        e.ondragstop()
                    }
                    function o() {
                        l.releaseCapture(),
                        l.detachEvent("onmousemove", n),
                        l.detachEvent("onmouseup", o),
                        l.detachEvent("onlosecaptrue", o),
                        e.ondragstop()
                    }
                    var i = i || document,
                    a = t.clientX,
                    r = t.clientY;
                    if (i.addEventListener) i.addEventListener("mousemove", n, !0),
                    i.addEventListener("mouseup", s, !0),
                    t.preventDefault();
                    else {
                        var l = t.srcElement;
                        l.setCapture(),
                        l.attachEvent("onmousemove", n),
                        l.attachEvent("onmouseup", o),
                        l.attachEvent("onlosecaptrue", o),
                        t.returnValue = !1
                    }
                    e.ondragstart()
                },
                getFixedLayer: function() {
                    var n = document.getElementById("edui_fixedlayer");
                    return null == n && (n = document.createElement("div"), n.id = "edui_fixedlayer", document.body.appendChild(n), i.ie && i.version <= 8 ? (n.style.position = "absolute", e(), setTimeout(t)) : n.style.position = "fixed", n.style.left = "0", n.style.top = "0", n.style.width = "0", n.style.height = "0"),
                    n
                },
                makeUnselectable: function(t) {
                    if (i.opera || i.ie && i.version < 9) {
                        if (t.unselectable = "on", t.hasChildNodes()) for (var e = 0; e < t.childNodes.length; e++) 1 == t.childNodes[e].nodeType && l.makeUnselectable(t.childNodes[e])
                    } else void 0 !== t.style.MozUserSelect ? t.style.MozUserSelect = "none": void 0 !== t.style.WebkitUserSelect ? t.style.WebkitUserSelect = "none": void 0 !== t.style.KhtmlUserSelect && (t.style.KhtmlUserSelect = "none")
                }
            }
        } (),
        function() {
            var t = baidu.editor.utils,
            e = baidu.editor.ui.uiUtils,
            i = baidu.editor.EventBase,
            n = baidu.editor.ui.UIBase = function() {};
            n.prototype = {
                className: "",
                uiName: "",
                initOptions: function(t) {
                    var i = this;
                    for (var n in t) i[n] = t[n];
                    this.id = this.id || "edui" + e.uid()
                },
                initUIBase: function() {
                    this._globalKey = t.unhtml(e.setGlobal(this.id, this))
                },
                render: function(t) {
                    var i = this.renderHtml(),
                    n = e.createElementByHtml(i),
                    s = this.getDom();
                    null != s ? (s.parentNode.replaceChild(n, s), e.copyAttributes(n, s)) : ("string" == typeof t && (t = document.getElementById(t)), t = t || e.getFixedLayer(), t.appendChild(n)),
                    this.postRender()
                },
                getDom: function(t) {
                    return t ? document.getElementById(this.id + "_" + t) : document.getElementById(this.id)
                },
                postRender: function() {
                    this.fireEvent("postrender")
                },
                getHtmlTpl: function() {
                    return ""
                },
                formatHtml: function(t) {
                    var e = "edui-" + this.uiName;
                    return t.replace(/##/g, this.id).replace(/%%-/g, this.uiName ? e + "-": "").replace(/%%/g, (this.uiName ? e: "") + " " + this.className).replace(/\$\$/g, this._globalKey)
                },
                renderHtml: function() {
                    return this.formatHtml(this.getHtmlTpl())
                },
                dispose: function() {
                    var t = this.getDom();
                    t && baidu.editor.dom.domUtils.remove(t),
                    e.unsetGlobal(this.id)
                }
            },
            t.inherits(n, i)
        } (),
        function() {
            var t = baidu.editor.utils,
            e = baidu.editor.ui.UIBase,
            i = baidu.editor.ui.Separator = function(t) {
                this.initOptions(t),
                this.initSeparator()
            };
            i.prototype = {
                uiName: "separator",
                initSeparator: function() {
                    this.initUIBase()
                },
                getHtmlTpl: function() {
                    return '<div id="##" class="edui-box %%"></div>'
                }
            },
            t.inherits(i, e)
        } (),
        function() {
            var t = baidu.editor.utils,
            e = baidu.editor.dom.domUtils,
            i = baidu.editor.ui.UIBase,
            n = baidu.editor.ui.uiUtils,
            s = baidu.editor.ui.Mask = function(t) {
                this.initOptions(t),
                this.initUIBase()
            };
            s.prototype = {
                getHtmlTpl: function() {
                    return '<div id="##" class="edui-mask %%" onmousedown="return $$._onMouseDown(event, this);"></div>'
                },
                postRender: function() {
                    var t = this;
                    e.on(window, "resize", 
                    function() {
                        setTimeout(function() {
                            t.isHidden() || t._fill()
                        })
                    })
                },
                show: function(t) {
                    this._fill(),
                    this.getDom().style.display = "",
                    this.getDom().style.zIndex = t
                },
                hide: function() {
                    this.getDom().style.display = "none",
                    this.getDom().style.zIndex = ""
                },
                isHidden: function() {
                    return "none" == this.getDom().style.display
                },
                _onMouseDown: function() {
                    return ! 1
                },
                _fill: function() {
                    var t = this.getDom(),
                    e = n.getViewportRect();
                    t.style.width = e.width + "px",
                    t.style.height = e.height + "px"
                }
            },
            t.inherits(s, i)
        } (),
        function() {
            function t(t) {
                for (var e = 0; e < a.length; e++) {
                    var i = a[e];
                    i.isHidden() || i.queryAutoHide(t) !== !1 && i.hide()
                }
            }
            var e = baidu.editor.utils,
            i = baidu.editor.ui.uiUtils,
            n = baidu.editor.dom.domUtils,
            s = baidu.editor.ui.UIBase,
            o = baidu.editor.ui.Popup = function(t) {
                this.initOptions(t),
                this.initPopup()
            },
            a = [];
            o.postHide = t;
            var r = ["edui-anchor-topleft", "edui-anchor-topright", "edui-anchor-bottomleft", "edui-anchor-bottomright"];
            o.prototype = {
                SHADOW_RADIUS: 5,
                content: null,
                _hidden: !1,
                autoRender: !0,
                canSideLeft: !0,
                canSideUp: !0,
                initPopup: function() {
                    this.initUIBase(),
                    a.push(this)
                },
                getHtmlTpl: function() {
                    return '<div id="##" class="edui-popup %%"> <div id="##_body" class="edui-popup-body"> <iframe style="position:absolute;z-index:-1;left:0;top:0;background-color: white;" frameborder="0" width="100%" height="100%" src="javascript:"></iframe> <div class="edui-shadow"></div> <div id="##_content" class="edui-popup-content">' + this.getContentHtmlTpl() + "  </div>" + " </div>" + "</div>"
                },
                getContentHtmlTpl: function() {
                    return "string" == typeof this.content ? this.content: this.content.renderHtml()
                },
                _UIBase_postRender: s.prototype.postRender,
                postRender: function() {
                    this.content instanceof s && this.content.postRender(),
                    this.fireEvent("postRenderAfter"),
                    this.hide(!0),
                    this._UIBase_postRender()
                },
                _doAutoRender: function() { ! this.getDom() && this.autoRender && this.render()
                },
                mesureSize: function() {
                    var t = this.getDom("content");
                    return i.getClientRect(t)
                },
                fitSize: function() {
                    var t = this.getDom("body");
                    t.style.width = "",
                    t.style.height = "";
                    var e = this.mesureSize();
                    return t.style.width = e.width + "px",
                    t.style.height = e.height + "px",
                    e
                },
                showAnchor: function(t, e) {
                    this.showAnchorRect(i.getClientRect(t), e)
                },
                showAnchorRect: function(t, e) {
                    this._doAutoRender();
                    var s = i.getViewportRect();
                    this._show();
                    var o,
                    a,
                    l,
                    u,
                    d = this.fitSize();
                    e ? (o = this.canSideLeft && t.right + d.width > s.right && t.left > d.width, a = this.canSideUp && t.top + d.height > s.bottom && t.bottom > d.height, l = o ? t.left - d.width: t.right, u = a ? t.bottom - d.height: t.top) : (o = this.canSideLeft && t.right + d.width > s.right && t.left > d.width, a = this.canSideUp && t.top + d.height > s.bottom && t.bottom > d.height, l = o ? t.right - d.width: t.left, u = a ? t.top - d.height: t.bottom);
                    var c = this.getDom();
                    i.setViewportOffset(c, {
                        left: l,
                        top: u
                    }),
                    n.removeClasses(c, r),
                    c.className += " " + r[2 * (a ? 1: 0) + (o ? 1: 0)],
                    this.editor && (c.style.zIndex = 1 * this.editor.container.style.zIndex + 10, baidu.editor.ui.uiUtils.getFixedLayer().style.zIndex = c.style.zIndex - 1)
                },
                showAt: function(t) {
                    var e = t.left,
                    i = t.top,
                    n = {
                        left: e,
                        top: i,
                        right: e,
                        bottom: i,
                        height: 0,
                        width: 0
                    };
                    this.showAnchorRect(n, !1, !0)
                },
                _show: function() {
                    if (this._hidden) {
                        var t = this.getDom();
                        t.style.display = "",
                        this._hidden = !1,
                        this.fireEvent("show")
                    }
                },
                isHidden: function() {
                    return this._hidden
                },
                show: function() {
                    this._doAutoRender(),
                    this._show()
                },
                hide: function(t) { ! this._hidden && this.getDom() && (this.getDom().style.display = "none", this._hidden = !0, t || this.fireEvent("hide"))
                },
                queryAutoHide: function(t) {
                    return ! t || !i.contains(this.getDom(), t)
                }
            },
            e.inherits(o, s),
            n.on(document, "mousedown", 
            function(e) {
                var i = e.target || e.srcElement;
                t(i)
            }),
            n.on(window, "scroll", 
            function() {
                t()
            })
        } (),
        function() {
            var t = baidu.editor.browser,
            e = baidu.editor.dom.domUtils,
            i = baidu.editor.ui.uiUtils,
            n = 'onmousedown="$$.Stateful_onMouseDown(event, this);" onmouseup="$$.Stateful_onMouseUp(event, this);"' + (t.ie ? ' onmouseenter="$$.Stateful_onMouseEnter(event, this);" onmouseleave="$$.Stateful_onMouseLeave(event, this);"': ' onmouseover="$$.Stateful_onMouseOver(event, this);" onmouseout="$$.Stateful_onMouseOut(event, this);"');
            baidu.editor.ui.Stateful = {
                alwalysHoverable: !1,
                Stateful_init: function() {
                    this._Stateful_dGetHtmlTpl = this.getHtmlTpl,
                    this.getHtmlTpl = this.Stateful_getHtmlTpl
                },
                Stateful_getHtmlTpl: function() {
                    var t = this._Stateful_dGetHtmlTpl();
                    return t.replace(/stateful/g, 
                    function() {
                        return n
                    })
                },
                Stateful_onMouseEnter: function() { (!this.isDisabled() || this.alwalysHoverable) && (this.addState("hover"), this.fireEvent("over"))
                },
                Stateful_onMouseLeave: function() { (!this.isDisabled() || this.alwalysHoverable) && (this.removeState("hover"), this.removeState("active"), this.fireEvent("out"))
                },
                Stateful_onMouseOver: function(t, e) {
                    var n = t.relatedTarget;
                    i.contains(e, n) || e === n || this.Stateful_onMouseEnter(t, e)
                },
                Stateful_onMouseOut: function(t, e) {
                    var n = t.relatedTarget;
                    i.contains(e, n) || e === n || this.Stateful_onMouseLeave(t, e)
                },
                Stateful_onMouseDown: function() {
                    this.isDisabled() || this.addState("active")
                },
                Stateful_onMouseUp: function() {
                    this.isDisabled() || this.removeState("active")
                },
                Stateful_postRender: function() {
                    this.disabled && !this.hasState("disabled") && this.addState("disabled")
                },
                hasState: function(t) {
                    return e.hasClass(this.getStateDom(), "edui-state-" + t)
                },
                addState: function(t) {
                    this.hasState(t) || (this.getStateDom().className += " edui-state-" + t)
                },
                removeState: function(t) {
                    this.hasState(t) && e.removeClasses(this.getStateDom(), ["edui-state-" + t])
                },
                getStateDom: function() {
                    return this.getDom("state")
                },
                isChecked: function() {
                    return this.hasState("checked")
                },
                setChecked: function(t) { ! this.isDisabled() && t ? this.addState("checked") : this.removeState("checked")
                },
                isDisabled: function() {
                    return this.hasState("disabled")
                },
                setDisabled: function(t) {
                    t ? (this.removeState("hover"), this.removeState("checked"), this.removeState("active"), this.addState("disabled")) : this.removeState("disabled")
                }
            }
        } (),
        function() {
            var t = baidu.editor.utils,
            e = baidu.editor.ui.UIBase,
            i = baidu.editor.ui.Stateful,
            n = baidu.editor.ui.Button = function(t) {
                this.initOptions(t),
                this.initButton()
            };
            n.prototype = {
                uiName: "button",
                label: "",
                title: "",
                showIcon: !0,
                showText: !0,
                initButton: function() {
                    this.initUIBase(),
                    this.Stateful_init()
                },
                getHtmlTpl: function() {
                    return '<div id="##" class="edui-box %%"><div id="##_state" stateful><div class="%%-wrap"><div id="##_body" unselectable="on" ' + (this.title ? 'title="' + this.title + '"': "") + ' class="%%-body" onmousedown="return false;" onclick="return $$._onClick();">' + (this.showIcon ? '<div class="edui-box edui-icon"></div>': "") + (this.showText ? '<div class="edui-box edui-label">' + this.label + "</div>": "") + "</div>" + "</div>" + "</div></div>"
                },
                postRender: function() {
                    this.Stateful_postRender()
                },
                _onClick: function() {
                    this.isDisabled() || this.fireEvent("click")
                }
            },
            t.inherits(n, e),
            t.extend(n.prototype, i)
        } (),
        function() {
            var t = baidu.editor.utils,
            e = baidu.editor.ui.uiUtils,
            i = (baidu.editor.dom.domUtils, baidu.editor.ui.UIBase),
            n = baidu.editor.ui.Stateful,
            s = baidu.editor.ui.SplitButton = function(t) {
                this.initOptions(t),
                this.initSplitButton()
            };
            s.prototype = {
                popup: null,
                uiName: "splitbutton",
                title: "",
                initSplitButton: function() {
                    if (this.initUIBase(), this.Stateful_init(), null != this.popup) {
                        var t = this.popup;
                        this.popup = null,
                        this.setPopup(t)
                    }
                },
                _UIBase_postRender: i.prototype.postRender,
                postRender: function() {
                    this.Stateful_postRender(),
                    this._UIBase_postRender()
                },
                setPopup: function(i) {
                    this.popup !== i && (null != this.popup && this.popup.dispose(), i.addListener("show", t.bind(this._onPopupShow, this)), i.addListener("hide", t.bind(this._onPopupHide, this)), i.addListener("postrender", t.bind(function() {
                        i.getDom("body").appendChild(e.createElementByHtml('<div id="' + this.popup.id + '_bordereraser" class="edui-bordereraser edui-background" style="width:' + (e.getClientRect(this.getDom()).width - 2) + 'px"></div>')),
                        i.getDom().className += " " + this.className
                    },
                    this)), this.popup = i)
                },
                _onPopupShow: function() {
                    this.addState("opened")
                },
                _onPopupHide: function() {
                    this.removeState("opened")
                },
                getHtmlTpl: function() {
                    return '<div id="##" class="edui-box %%"><div ' + (this.title ? 'title="' + this.title + '"': "") + ' id="##_state" stateful><div class="%%-body">' + '<div id="##_button_body" class="edui-box edui-button-body" onclick="$$._onButtonClick(event, this);">' + '<div class="edui-box edui-icon"></div>' + "</div>" + '<div class="edui-box edui-splitborder"></div>' + '<div class="edui-box edui-arrow" onclick="$$._onArrowClick();"></div>' + "</div></div></div>"
                },
                showPopup: function() {
                    var t = e.getClientRect(this.getDom());
                    t.top -= this.popup.SHADOW_RADIUS,
                    t.height += this.popup.SHADOW_RADIUS,
                    this.popup.showAnchorRect(t)
                },
                _onArrowClick: function() {
                    this.isDisabled() || this.showPopup()
                },
                _onButtonClick: function() {
                    this.isDisabled() || this.fireEvent("buttonclick")
                }
            },
            t.inherits(s, i),
            t.extend(s.prototype, n, !0)
        } (),
        function() {
            function t(t) {
                for (var e, i = t.editor.options.autotypeset, n = t.getDom(), s = domUtils.getElementsByTagName(n, "input"), o = s.length - 1; e = s[o--];) if ("checkbox" == e.getAttribute("type")) {
                    var a = e.getAttribute("name");
                    if (i[a] && delete i[a], e.checked) {
                        var r = document.getElementById(a + "Value");
                        if (r) {
                            if (/input/gi.test(r.tagName)) i[a] = r.value;
                            else for (var l, u = r.getElementsByTagName("input"), d = u.length - 1; l = u[d--];) if (l.checked) {
                                i[a] = l.value;
                                break
                            }
                        } else i[a] = !0
                    }
                }
                for (var c, h = domUtils.getElementsByTagName(n, "select"), o = 0; c = h[o++];) {
                    var p = c.getAttribute("name");
                    i[p] = i[p] ? c.value: ""
                }
                t.editor.options.autotypeset = i
            }
            var e = baidu.editor.utils,
            i = baidu.editor.ui.Popup,
            n = baidu.editor.ui.AutoTypeSetPicker,
            s = baidu.editor.ui.SplitButton,
            o = baidu.editor.ui.AutoTypeSetButton = function(t) {
                this.initOptions(t),
                this.initAutoTypeSetButton()
            };
            o.prototype = {
                initAutoTypeSetButton: function() {
                    var e = this;
                    this.popup = new i({
                        content: new n({
                            editor: e.editor
                        }),
                        editor: e.editor,
                        hide: function() { ! this._hidden && this.getDom() && (t(this), this.getDom().style.display = "none", this._hidden = !0, this.fireEvent("hide"))
                        }
                    });
                    var s = 0;
                    this.popup.addListener("postRenderAfter", 
                    function() {
                        var i = this;
                        if (!s) {
                            var n = this.getDom(),
                            o = n.getElementsByTagName("button")[0];
                            o.onclick = function() {
                                t(i),
                                e.editor.execCommand("autotypeset")
                            },
                            s = 1
                        }
                    }),
                    this.initSplitButton()
                }
            },
            e.inherits(o, s)
        } (),
        function() {
            var t = baidu.editor.utils,
            e = baidu.editor.ui.uiUtils,
            i = baidu.editor.ui.UIBase,
            n = baidu.editor.ui.Toolbar = function(t) {
                this.initOptions(t),
                this.initToolbar()
            };
            n.prototype = {
                items: null,
                initToolbar: function() {
                    this.items = this.items || [],
                    this.initUIBase()
                },
                add: function(t) {
                    this.items.push(t)
                },
                getHtmlTpl: function() {
                    for (var t = [], e = 0; e < this.items.length; e++) t[e] = this.items[e].renderHtml();
                    return '<div id="##" class="edui-toolbar %%" onselectstart="return false;" onmousedown="return $$._onMouseDown(event, this);">' + t.join("") + "</div>"
                },
                postRender: function() {
                    for (var t = this.getDom(), i = 0; i < this.items.length; i++) this.items[i].postRender();
                    e.makeUnselectable(t)
                },
                _onMouseDown: function() {
                    return ! 1
                }
            },
            t.inherits(n, i)
        } (),
        function() {
            var t = baidu.editor.utils,
            e = baidu.editor.dom.domUtils,
            i = baidu.editor.ui.uiUtils,
            n = baidu.editor.ui.UIBase,
            s = baidu.editor.ui.Popup,
            o = baidu.editor.ui.Stateful,
            a = baidu.editor.ui.Menu = function(t) {
                this.initOptions(t),
                this.initMenu()
            },
            r = {
                renderHtml: function() {
                    return '<div class="edui-menuitem edui-menuseparator"><div class="edui-menuseparator-inner"></div></div>'
                },
                postRender: function() {},
                queryAutoHide: function() {
                    return ! 0
                }
            };
            a.prototype = {
                items: null,
                uiName: "menu",
                initMenu: function() {
                    this.items = this.items || [],
                    this.initPopup(),
                    this.initItems()
                },
                initItems: function() {
                    for (var t = 0; t < this.items.length; t++) {
                        var e = this.items[t];
                        "-" == e ? this.items[t] = this.getSeparator() : e instanceof l || (this.items[t] = this.createItem(e))
                    }
                },
                getSeparator: function() {
                    return r
                },
                createItem: function(t) {
                    return new l(t)
                },
                _Popup_getContentHtmlTpl: s.prototype.getContentHtmlTpl,
                getContentHtmlTpl: function() {
                    if (0 == this.items.length) return this._Popup_getContentHtmlTpl();
                    for (var t = [], e = 0; e < this.items.length; e++) {
                        var i = this.items[e];
                        t[e] = i.renderHtml()
                    }
                    return '<div class="%%-body">' + t.join("") + "</div>"
                },
                _Popup_postRender: s.prototype.postRender,
                postRender: function() {
                    for (var t = this, n = 0; n < this.items.length; n++) {
                        var s = this.items[n];
                        s.ownerMenu = this,
                        s.postRender()
                    }
                    e.on(this.getDom(), "mouseover", 
                    function(e) {
                        e = e || event;
                        var n = e.relatedTarget || e.fromElement,
                        s = t.getDom();
                        i.contains(s, n) || s === n || t.fireEvent("over")
                    }),
                    this._Popup_postRender()
                },
                queryAutoHide: function(t) {
                    if (t) {
                        if (i.contains(this.getDom(), t)) return ! 1;
                        for (var e = 0; e < this.items.length; e++) {
                            var n = this.items[e];
                            if (n.queryAutoHide(t) === !1) return ! 1
                        }
                    }
                },
                clearItems: function() {
                    for (var t = 0; t < this.items.length; t++) {
                        var e = this.items[t];
                        clearTimeout(e._showingTimer),
                        clearTimeout(e._closingTimer),
                        e.subMenu && e.subMenu.destroy()
                    }
                    this.items = []
                },
                destroy: function() {
                    this.getDom() && e.remove(this.getDom()),
                    this.clearItems()
                },
                dispose: function() {
                    this.destroy()
                }
            },
            t.inherits(a, s);
            var l = baidu.editor.ui.MenuItem = function(t) {
                this.initOptions(t),
                this.initUIBase(),
                this.Stateful_init(),
                !this.subMenu || this.subMenu instanceof a || (this.subMenu = new a(this.subMenu))
            };
            l.prototype = {
                label: "",
                subMenu: null,
                ownerMenu: null,
                uiName: "menuitem",
                alwalysHoverable: !0,
                getHtmlTpl: function() {
                    return '<div id="##" class="%%" stateful onclick="$$._onClick(event, this);"><div class="%%-body">' + this.renderLabelHtml() + "</div>" + "</div>"
                },
                postRender: function() {
                    var t = this;
                    this.addListener("over", 
                    function() {
                        t.ownerMenu.fireEvent("submenuover", t),
                        t.subMenu && t.delayShowSubMenu()
                    }),
                    this.subMenu && (this.getDom().className += " edui-hassubmenu", this.subMenu.render(), this.addListener("out", 
                    function() {
                        t.delayHideSubMenu()
                    }), this.subMenu.addListener("over", 
                    function() {
                        clearTimeout(t._closingTimer),
                        t._closingTimer = null,
                        t.addState("opened")
                    }), this.ownerMenu.addListener("hide", 
                    function() {
                        t.hideSubMenu()
                    }), this.ownerMenu.addListener("submenuover", 
                    function(e, i) {
                        i !== t && t.delayHideSubMenu()
                    }), this.subMenu._bakQueryAutoHide = this.subMenu.queryAutoHide, this.subMenu.queryAutoHide = function(e) {
                        return e && i.contains(t.getDom(), e) ? !1: this._bakQueryAutoHide(e)
                    }),
                    this.getDom().style.tabIndex = "-1",
                    i.makeUnselectable(this.getDom()),
                    this.Stateful_postRender()
                },
                delayShowSubMenu: function() {
                    var t = this;
                    t.isDisabled() || (t.addState("opened"), clearTimeout(t._showingTimer), clearTimeout(t._closingTimer), t._closingTimer = null, t._showingTimer = setTimeout(function() {
                        t.showSubMenu()
                    },
                    250))
                },
                delayHideSubMenu: function() {
                    var t = this;
                    t.isDisabled() || (t.removeState("opened"), clearTimeout(t._showingTimer), t._closingTimer || (t._closingTimer = setTimeout(function() {
                        t.hasState("opened") || t.hideSubMenu(),
                        t._closingTimer = null
                    },
                    400)))
                },
                renderLabelHtml: function() {
                    return '<div class="edui-arrow"></div><div class="edui-box edui-icon"></div><div class="edui-box edui-label %%-label">' + (this.label || "") + "</div>"
                },
                getStateDom: function() {
                    return this.getDom()
                },
                queryAutoHide: function(t) {
                    return this.subMenu && this.hasState("opened") ? this.subMenu.queryAutoHide(t) : void 0
                },
                _onClick: function(t, e) {
                    this.hasState("disabled") || this.fireEvent("click", t, e) !== !1 && (this.subMenu ? this.showSubMenu() : s.postHide())
                },
                showSubMenu: function() {
                    var t = i.getClientRect(this.getDom());
                    t.right -= 5,
                    t.left += 2,
                    t.width -= 7,
                    t.top -= 4,
                    t.bottom += 4,
                    t.height += 8,
                    this.subMenu.showAnchorRect(t, !0, !0)

                },
                hideSubMenu: function() {
                    this.subMenu.hide()
                }
            },
            t.inherits(l, n),
            t.extend(l.prototype, o, !0)
        } (),
        function() {
            var t = baidu.editor.utils,
            e = baidu.editor.ui.uiUtils,
            i = baidu.editor.ui.Menu,
            n = baidu.editor.ui.SplitButton,
            s = baidu.editor.ui.Combox = function(t) {
                this.initOptions(t),
                this.initCombox()
            };
            s.prototype = {
                uiName: "combox",
                initCombox: function() {
                    var t = this;
                    this.items = this.items || [];
                    for (var e = 0; e < this.items.length; e++) {
                        var n = this.items[e];
                        n.uiName = "listitem",
                        n.index = e,
                        n.onclick = function() {
                            t.selectByIndex(this.index)
                        }
                    }
                    this.popup = new i({
                        items: this.items,
                        uiName: "list",
                        editor: this.editor
                    }),
                    this.initSplitButton()
                },
                _SplitButton_postRender: n.prototype.postRender,
                postRender: function() {
                    this._SplitButton_postRender(),
                    this.setLabel(this.label || ""),
                    this.setValue(this.initValue || "")
                },
                showPopup: function() {
                    var t = e.getClientRect(this.getDom());
                    t.top += 1,
                    t.bottom -= 1,
                    t.height -= 2,
                    this.popup.showAnchorRect(t)
                },
                getValue: function() {
                    return this.value
                },
                setValue: function(t) {
                    var e = this.indexByValue(t); - 1 != e ? (this.selectedIndex = e, this.setLabel(this.items[e].label), this.value = this.items[e].value) : (this.selectedIndex = -1, this.setLabel(this.getLabelForUnknowValue(t)), this.value = t)
                },
                setLabel: function(t) {
                    this.getDom("button_body").innerHTML = t,
                    this.label = t
                },
                getLabelForUnknowValue: function(t) {
                    return t
                },
                indexByValue: function(t) {
                    for (var e = 0; e < this.items.length; e++) if (t == this.items[e].value) return e;
                    return - 1
                },
                getItem: function(t) {
                    return this.items[t]
                },
                selectByIndex: function(t) {
                    t < this.items.length && this.fireEvent("select", t) !== !1 && (this.selectedIndex = t, this.value = this.items[t].value, this.setLabel(this.items[t].label))
                }
            },
            t.inherits(s, n)
        } (),
        function() {
            var t,
            e,
            i = baidu.editor.utils,
            n = baidu.editor.dom.domUtils,
            s = baidu.editor.ui.uiUtils,
            o = baidu.editor.ui.Mask,
            a = baidu.editor.ui.UIBase,
            r = baidu.editor.ui.Button,
            l = baidu.editor.ui.Dialog = function(t) {
                this.initOptions(t),
                this.initDialog()
            };
            l.prototype = {
                draggable: !1,
                uiName: "dialog",
                initDialog: function() {
                    var i = this;
                    if (this.initUIBase(), this.modalMask = t || (t = new o({
                        className: "edui-dialog-modalmask"
                    })), this.dragMask = e || (e = new o({
                        className: "edui-dialog-dragmask"
                    })), this.closeButton = new r({
                        className: "edui-dialog-closebutton",
                        title: "关闭对话框",
                        onclick: function() {
                            i.close(!1)
                        }
                    }), this.buttons) for (var n = 0; n < this.buttons.length; n++) this.buttons[n] instanceof r || (this.buttons[n] = new r(this.buttons[n]))
                },
                fitSize: function() {
                    var t = this.getDom("body"),
                    e = this.mesureSize();
                    return t.style.width = e.width + "px",
                    t.style.height = e.height + "px",
                    e
                },
                safeSetOffset: function(t) {
                    var e = this,
                    i = e.getDom(),
                    n = s.getViewportRect(),
                    o = s.getClientRect(i),
                    a = t.left;
                    a + o.width > n.right && (a = n.right - o.width);
                    var r = t.top;
                    r + o.height > n.bottom && (r = n.bottom - o.height),
                    i.style.left = Math.max(a, 0) + "px",
                    i.style.top = Math.max(r, 0) + "px"
                },
                showAtCenter: function() {
                    this.getDom().style.display = "";
                    var t = s.getViewportRect(),
                    e = this.fitSize(),
                    i = 0 | this.getDom("titlebar").offsetHeight,
                    o = t.width / 2 - e.width / 2,
                    a = t.height / 2 - (e.height - i) / 2 - i,
                    r = this.getDom();
                    this.safeSetOffset({
                        left: Math.max(0 | o, 0),
                        top: Math.max(0 | a, 0)
                    }),
                    n.hasClass(r, "edui-state-centered") || (r.className += " edui-state-centered"),
                    this._show()
                },
                getContentHtml: function() {
                    var t = "";
                    return "string" == typeof this.content ? t = this.content: this.iframeUrl && (t = '<iframe id="' + this.id + '_iframe" class="%%-iframe" height="100%" width="100%" frameborder="0" src="' + this.iframeUrl + '"></iframe>'),
                    t
                },
                getHtmlTpl: function() {
                    var t = "";
                    if (this.buttons) {
                        for (var e = [], i = 0; i < this.buttons.length; i++) e[i] = this.buttons[i].renderHtml();
                        t = '<div class="%%-foot"><div id="##_buttons" class="%%-buttons">' + e.join("") + "</div>" + "</div>"
                    }
                    return '<div id="##" class="%%"><div class="%%-wrap"><div id="##_body" class="%%-body"><div class="%%-shadow"></div><div id="##_titlebar" class="%%-titlebar"><div class="%%-draghandle" onmousedown="$$._onTitlebarMouseDown(event, this);"><span class="%%-caption">' + (this.title || "") + "</span>" + "</div>" + this.closeButton.renderHtml() + "</div>" + '<div id="##_content" class="%%-content">' + (this.autoReset ? "": this.getContentHtml()) + "</div>" + t + "</div></div></div>"
                },
                postRender: function() {
                    this.modalMask.getDom() || (this.modalMask.render(), this.modalMask.hide()),
                    this.dragMask.getDom() || (this.dragMask.render(), this.dragMask.hide());
                    var t = this;
                    if (this.addListener("show", 
                    function() {
                        t.modalMask.show(this.getDom().style.zIndex - 2)
                    }), this.addListener("hide", 
                    function() {
                        t.modalMask.hide()
                    }), this.buttons) for (var e = 0; e < this.buttons.length; e++) this.buttons[e].postRender();
                    n.on(window, "resize", 
                    function() {
                        setTimeout(function() {
                            t.isHidden() || t.safeSetOffset(s.getClientRect(t.getDom()))
                        })
                    }),
                    this._hide()
                },
                mesureSize: function() {
                    var t = this.getDom("body"),
                    e = s.getClientRect(this.getDom("content")).width,
                    i = t.style;
                    return i.width = e,
                    s.getClientRect(t)
                },
                _onTitlebarMouseDown: function(t) {
                    if (this.draggable) {
                        var e;
                        s.getViewportRect();
                        var i = this;
                        s.startDrag(t, {
                            ondragstart: function() {
                                e = s.getClientRect(i.getDom()),
                                i.dragMask.show(i.getDom().style.zIndex - 1)
                            },
                            ondragmove: function(t, n) {
                                var s = e.left + t,
                                o = e.top + n;
                                i.safeSetOffset({
                                    left: s,
                                    top: o
                                })
                            },
                            ondragstop: function() {
                                n.removeClasses(i.getDom(), ["edui-state-centered"]),
                                i.dragMask.hide()
                            }
                        })
                    }
                },
                reset: function() {
                    this.getDom("content").innerHTML = this.getContentHtml()
                },
                _show: function() {
                    this._hidden && (this.getDom().style.display = "", this.editor.container.style.zIndex && (this.getDom().style.zIndex = 1 * this.editor.container.style.zIndex + 10), this._hidden = !1, this.fireEvent("show"), baidu.editor.ui.uiUtils.getFixedLayer().style.zIndex = this.getDom().style.zIndex - 4)
                },
                isHidden: function() {
                    return this._hidden
                },
                _hide: function() {
                    this._hidden || (this.getDom().style.display = "none", this.getDom().style.zIndex = "", this._hidden = !0, this.fireEvent("hide"))
                },
                open: function() {
                    if (this.autoReset && this.reset(), this.showAtCenter(), this.iframeUrl) try {
                        this.getDom("iframe").focus()
                    } catch(t) {}
                },
                _onCloseButtonClick: function() {
                    this.close(!1)
                },
                close: function(t) {
                    this.fireEvent("close", t) !== !1 && this._hide()
                }
            },
            i.inherits(l, a)
        } (),
        function() {
            var t = baidu.editor.utils,
            e = baidu.editor.ui.Menu,
            i = baidu.editor.ui.SplitButton,
            n = baidu.editor.ui.MenuButton = function(t) {
                this.initOptions(t),
                this.initMenuButton()
            };
            n.prototype = {
                initMenuButton: function() {
                    var t = this;
                    this.uiName = "menubutton",
                    this.popup = new e({
                        items: t.items,
                        className: t.className,
                        editor: t.editor
                    }),
                    this.popup.addListener("show", 
                    function() {
                        for (var e = this, i = 0; i < e.items.length; i++) e.items[i].removeState("checked"),
                        e.items[i].value == t._value && (e.items[i].addState("checked"), this.value = t._value)
                    }),
                    this.initSplitButton()
                },
                setValue: function(t) {
                    this._value = t
                }
            },
            t.inherits(n, i)
        } (),
        function() {
            baidu.editor.browser.ie,
            baidu.editor.utils;
            var t = baidu.editor.ui,
            e = t.Dialog;
            t.Dialog = function(t) {
                var i = new e(t);
                return i.addListener("hide", 
                function() {
                    if (i.editor) {
                        var t = i.editor;
                        try {
                            t.focus()
                        } catch(e) {}
                    }
                }),
                i
            };
            var i,
            n,
            s = ["Bold", "Italic", "Indent", "Outdent", "SelectAll", "Print", "Link", "InsertVideo"];
            for (i = s.length; i--;) n = s[i],
            t[n] = function(e) {
                return function(i, n) {
                    n = n || i.options.labelMap[e.toLowerCase()] || "";
                    var s = new t.Button({
                        className: "edui-for-" + e.toLowerCase(),
                        title: n,
                        onclick: function() {
                            var t = i.uid;
                            if ("Print" == e) $("#ueditor_image_popup" + t).show(),
                            $("#ueditor_image_popup" + t + " div.edui-popup-all-content").draggable({
                                handle: "#ueditor_image_popup_top" + t,
                                scroll: !1
                            });
                            else if ("InsertVideo" == e) $("#ueditor_video_popup" + t).show(),
                            $("#ueditor_video_popup" + t + " input#ueditor_video_url" + t).focus(),
                            $("#ueditor_video_popup" + t + " div.edui-popup-all-content").draggable({
                                handle: "#ueditor_video_popup_top" + t,
                                scroll: !1
                            });
                            else if ("Link" == e) $("#ueditor_link_popup" + t).show(),
                            $("#ueditor_link_popup" + t + " input#ueditor_link_href" + t).focus(),
                            $("#ueditor_link_popup" + t + " div.edui-popup-all-content").draggable({
                                handle: "#ueditor_link_popup_top" + t,
                                scroll: !1
                            });
                            else if ("Bold" == e) {
                                var n,
                                s,
                                o = i,
                                a = "h3",
                                r = domUtils.findParent(o.selection.getStart(), 
                                function(t) {
                                    return t.tagName.toLowerCase()
                                },
                                !0),
                                l = {};
                                if (r && "h3" == r.tagName.toLowerCase()) {
                                    if (n = o.selection.getRange(), s = n.createBookmark(), n.collapsed) if (dtd.$block[r.tagName]) {
                                        var u = o.document.createElement("p");
                                        domUtils.moveChild(r, u),
                                        r.parentNode.insertBefore(u, r),
                                        domUtils.remove(r)
                                    } else domUtils.remove(r, !0);
                                    else {
                                        var d = domUtils.getCommonAncestor(s.start, s.end),
                                        c = domUtils.getElementsByTagName(d, a);
                                        new RegExp(a, "i").test(d.tagName) && c.push(d);
                                        for (var h, p = 0; h = c[p++];) if ("h3" == h.tagName.toLowerCase()) {
                                            var f = domUtils.getPosition(h, s.start),
                                            m = domUtils.getPosition(h, s.end);
                                            if ((f & domUtils.POSITION_FOLLOWING || f & domUtils.POSITION_CONTAINS) && (m & domUtils.POSITION_PRECEDING || m & domUtils.POSITION_CONTAINS) && dtd.$block[a]) {
                                                var u = o.document.createElement("p");
                                                domUtils.moveChild(h, u),
                                                h.parentNode.insertBefore(u, h)
                                            }
                                            domUtils.remove(h, !0)
                                        }
                                        r = domUtils.findParent(d, 
                                        function(t) {
                                            return "h3" == t.tagName.toLowerCase()
                                        },
                                        !0),
                                        r && domUtils.remove(r, !0)
                                    }
                                    n.moveToBookmark(s).select()
                                } else if (dtd.$block[a]) {
                                    if (o.execCommand("paragraph", a, l, "customstyle"), $("#" + i.ui.toolbars[0].items[0].id).addClass("edui-toolbar-menu-checked"), n = o.selection.getRange(), !n.collapsed) {
                                        n.collapse(),
                                        r = domUtils.findParent(o.selection.getStart(), 
                                        function(t) {
                                            return "h3" == t.tagName.toLowerCase()
                                        },
                                        !0);
                                        var g = o.document.createElement("p");
                                        domUtils.insertAfter(r, g),
                                        domUtils.fillNode(o.document, g),
                                        n.setStart(g, 0).setCursor()
                                    }
                                } else {
                                    if (n = o.selection.getRange(), n.collapsed) return r = o.document.createElement(a),
                                    domUtils.setAttributes(r, l),
                                    n.insertNode(r).setStart(r, 0).setCursor(),
                                    void 0;
                                    s = n.createBookmark(),
                                    n.applyInlineStyle(a, l).moveToBookmark(s).select()
                                }
                                o.addListener("keyup", 
                                function(t, e) {
                                    var i = e.keyCode || e.which;
                                    if (32 == i || 13 == i) {
                                        var n = o.selection.getRange();
                                        if (n.collapsed) {
                                            var s = domUtils.findParent(o.selection.getStart(), 
                                            function(t) {
                                                return t.tagName
                                            },
                                            !0);
                                            if (s && "br" == s.tagName.toLowerCase() && domUtils.isEmptyNode(s)) {
                                                var a = o.document.createElement("p");
                                                domUtils.insertAfter(s.parentNode, a),
                                                domUtils.fillNode(o.document, a),
                                                domUtils.remove(s.parentNode),
                                                n.setStart(a, 0).setCursor()
                                            }
                                        }
                                    }
                                }),
                                o.enableAutoHeight()
                            } else i.execCommand(e)
                        },
                        showText: !1
                    });
                    return i.addListener("selectionchange", 
                    function(t, n, o) {
                        var a = i.queryCommandState(e.toLowerCase()); - 1 == a ? (s.setDisabled(!0), s.setChecked(!1)) : o || (s.setDisabled(!1), s.setChecked(a))
                    }),
                    s
                }
            } (n);
            var o = [];
            for (i = o.length; i--;) n = o[i],
            t[n] = function(e) {
                return e = e.toLowerCase(),
                function(i, n, s) {
                    n = n || i.options.iframeUrlMap[e.toLowerCase()] || "about:blank",
                    n = i.ui.mapUrl(n),
                    s = s || i.options.labelMap[e.toLowerCase()] || "";
                    var o = new t.Dialog({
                        iframeUrl: n,
                        autoReset: !0,
                        draggable: !0,
                        editor: i,
                        className: "edui-for-" + e,
                        title: s,
                        buttons: [{
                            className: "edui-okbutton",
                            label: "确认",
                            onclick: function() {
                                o.close(!0)
                            }
                        },
                        {
                            className: "edui-cancelbutton",
                            label: "取消",
                            onclick: function() {
                                o.close(!1)
                            }
                        }],
                        onok: function() {},
                        oncancel: function() {},
                        onclose: function(t, e) {
                            return e ? this.onok() : this.oncancel()
                        }
                    });
                    o.render();
                    var a = new t.Button({
                        className: "edui-for-" + e,
                        title: s,
                        onclick: function() {
                            o.open()
                        }
                    });
                    return i.addListener("selectionchange", 
                    function() {
                        var t = i.queryCommandState(e); - 1 == t ? a.setDisabled(!0) : (a.setChecked(t), a.setDisabled(!1))
                    }),
                    a
                }
            } (n)
        } (),
        function() {
            function t(t) {
                this.initOptions(t),
                this.initEditorUI()
            }
            var e = baidu.editor.utils,
            i = baidu.editor.ui.uiUtils,
            n = baidu.editor.ui.UIBase;
            t.prototype = {
                uiName: "editor",
                initEditorUI: function() {
                    this.editor.ui = this,
                    this._dialogs = {},
                    this.initUIBase(),
                    this._initToolbars();
                    var t = this.editor;
                    t.addListener("ready", 
                    function() {
                        baidu.editor.dom.domUtils.on(t.window, "scroll", 
                        function() {
                            baidu.editor.ui.Popup.postHide()
                        }),
                        t.options.elementPathEnabled && (t.ui.getDom("elementpath").innerHTML = '<div class="edui-editor-breadcrumb">path:</div>'),
                        t.options.wordCount && (t.ui.getDom("wordcount").innerHTML = "字数统计"),
                        t.selection.isFocus() && t.fireEvent("selectionchange", !1, !0)
                    }),
                    t.addListener("mousedown", 
                    function(t, e) {
                        var i = e.target || e.srcElement;
                        baidu.editor.ui.Popup.postHide(i)
                    }),
                    t.addListener("contextmenu", 
                    function() {
                        baidu.editor.ui.Popup.postHide()
                    });
                    var e = this;
                    t.addListener("selectionchange", 
                    function() {
                        t.selection.isFocus() && (e._updateElementPath(), e._wordCount())
                    }),
                    t.addListener("sourcemodechanged", 
                    function(i, n) {
                        t.options.elementPathEnabled && (n ? e.disableElementPath() : e.enableElementPath()),
                        t.options.wordCount && (n ? e.disableWordCount() : e.enableWordCount())
                    });
                    var i = new baidu.editor.ui.Dialog({
                        iframeUrl: t.ui.mapUrl(e.editor.options.iframeUrlMap.link),
                        autoReset: !0,
                        draggable: !0,
                        editor: t,
                        className: "edui-for-link",
                        title: "超链接",
                        buttons: [{
                            className: "edui-okbutton",
                            label: "确认",
                            onclick: function() {
                                i.close(!0)
                            }
                        },
                        {
                            className: "edui-cancelbutton",
                            label: "取消",
                            onclick: function() {
                                i.close(!1)
                            }
                        }],
                        onok: function() {},
                        oncancel: function() {},
                        onclose: function(t, e) {
                            return e ? this.onok() : this.oncancel()
                        }
                    });
                    i.render();
                    var n = new baidu.editor.ui.Dialog({
                        iframeUrl: t.ui.mapUrl(e.editor.options.iframeUrlMap.insertvideo),
                        autoReset: !0,
                        draggable: !0,
                        editor: t,
                        className: "edui-for-insertvideo",
                        title: "视频",
                        buttons: [{
                            className: "edui-okbutton",
                            label: "确认",
                            onclick: function() {
                                n.close(!0)
                            }
                        },
                        {
                            className: "edui-cancelbutton",
                            label: "取消",
                            onclick: function() {
                                n.close(!1)
                            }
                        }],
                        onok: function() {},
                        oncancel: function() {},
                        onclose: function(t, e) {
                            return e ? this.onok() : this.oncancel()
                        }
                    });
                    n.render();
                    var s = new baidu.editor.ui.Popup({
                        editor: t,
                        content: "",
                        className: "edui-bubble",
                        _onEditButtonClick: function() {
                            this.hide(),
                            i.open()
                        },
                        _onImgEditButtonClick: function() {
                            this.hide();
                            var e = t.selection.getRange().getClosedNode(),
                            i = baidu.editor.dom.domUtils.findParentByTagName(e, "img", !0);
                            i && -1 != i.className.indexOf("edui-faked-video") ? n.open() : i && -1 != i.src.indexOf("http://api.map.baidu.com") ? mapDialog.open() : i && -1 != i.src.indexOf("http://maps.google.com/maps/api/staticmap") ? gmapDialog.open() : i && i.getAttribute("anchorname") ? anchorDialog.open() : imgDialog.open()
                        },
                        _getImg: function() {
                            var e = t.selection.getRange().getClosedNode();
                            return ! e || "img" != e.nodeName && "IMG" != e.nodeName ? null: e
                        },
                        _onImgSetFloat: function(e) {
                            if (this._getImg()) {
                                t.execCommand("imagefloat", e);
                                var i = this._getImg();
                                i && this.showAnchor(i)
                            }
                        },
                        _setIframeAlign: function(t) {
                            var e = s.anchorEl,
                            i = e.cloneNode(!0);
                            switch (t) {
                            case - 2: i.setAttribute("align", "");
                                break;
                            case - 1: i.setAttribute("align", "left");
                                break;
                            case 1:
                                i.setAttribute("align", "right");
                                break;
                            case 2:
                                i.setAttribute("align", "middle")
                            }
                            e.parentNode.insertBefore(i, e),
                            baidu.editor.dom.domUtils.remove(e),
                            s.anchorEl = i,
                            s.showAnchor(s.anchorEl)
                        },
                        _updateIframe: function() {
                            t._iframe = s.anchorEl,
                            insertframe.open(),
                            s.hide()
                        },
                        _onRemoveButtonClick: function() {
                            var e = t.selection.getRange().getClosedNode(),
                            i = baidu.editor.dom.domUtils.findParentByTagName(e, "img", !0);
                            i && i.getAttribute("anchorname") ? t.execCommand("anchor") : t.execCommand("unlink"),
                            this.hide()
                        },
                        queryAutoHide: function(e) {
                            return e && e.ownerDocument == t.document && ("img" == e.tagName.toLowerCase() || baidu.editor.dom.domUtils.findParentByTagName(e, "a", !0)) ? e !== s.anchorEl: baidu.editor.ui.Popup.prototype.queryAutoHide.call(this, e)
                        }
                    });
                    s.render(),
                    t.addListener("mouseover", 
                    function(e, i) {
                        i = i || window.event;
                        var n = i.target || i.srcElement;
                        if (/iframe/gi.test(n.tagName) && t.options.imagePopup) {
                            var o = s.formatHtml('<nobr>属性: <span onclick=$$._setIframeAlign(-2) class="edui-clickable">默认</span>&nbsp;&nbsp;<span onclick=$$._setIframeAlign(-1) class="edui-clickable">左对齐</span>&nbsp;&nbsp;<span onclick=$$._setIframeAlign(1) class="edui-clickable">右对齐</span>&nbsp;&nbsp;<span onclick=$$._setIframeAlign(2) class="edui-clickable">居中</span> <span onclick="$$._updateIframe( this);" class="edui-clickable">修改</span></nobr>');
                            o ? (s.getDom("content").innerHTML = o, s.anchorEl = n, s.showAnchor(s.anchorEl)) : s.hide()
                        }
                    }),
                    t.addListener("selectionchange", 
                    function(e, i) {
                        if (i) {
                            var n = "",
                            o = t.selection.getRange().getClosedNode();
                            null != o && "img" == o.tagName.toLowerCase() && "edui-faked-video" == o.getAttribute("class") && (n += s.formatHtml('<nobr>视频: <a target="_blank" href="' + o.getAttribute("data-video-url") + '" >' + o.getAttribute("data-video-title")) + "</a>");
                            var a;
                            if (t.selection.getRange().collapsed) {
                                var r = domUtils.findParent(t.selection.getStart(), 
                                function(t) {
                                    return "h3" == t.tagName.toLowerCase()
                                },
                                !0);
                                r ? $("#" + t.ui.toolbars[0].items[0].id).addClass("edui-toolbar-menu-checked") : $("#" + t.ui.toolbars[0].items[0].id).removeClass("edui-toolbar-menu-checked"),
                                a = t.queryCommandValue("link")
                            } else a = t.selection.getStart();
                            a = baidu.editor.dom.domUtils.findParentByTagName(a, "a", !0);
                            var l;
                            if (null != a && null != (l = a.getAttribute("data_ue_src") || a.getAttribute("href", 2))) {
                                var u = l;
                                l.length > 30 && (u = l.substring(0, 20) + "..."),
                                n && (n += '<div style="height:5px;"></div>'),
                                n += s.formatHtml('<nobr>链接: <a target="_blank" href="' + l + '" title="' + l + '" >' + u + "</a>" + ' <span class="edui-clickable" onclick="$$._onRemoveButtonClick(event, this);"> 清除</span></nobr>'),
                                s.showAnchor(a)
                            }
                            n ? (s.getDom("content").innerHTML = n, s.anchorEl = o || a, s.showAnchor(s.anchorEl)) : s.hide()
                        }
                    })
                },
                _initToolbars: function() {
                    for (var t = this.editor, e = this.toolbars || [], i = [], n = 0; n < e.length; n++) {
                        for (var s = e[n], o = new baidu.editor.ui.Toolbar, a = 0; a < s.length; a++) {
                            var r = s[a],
                            l = null;
                            if ("string" == typeof r) {
                                if ("|" == r && (r = "Separator"), baidu.editor.ui[r] && (l = new baidu.editor.ui[r](t)), "FullScreen" == r) {
                                    i && i[0] ? i[0].items.splice(0, 0, l) : o.items.splice(0, 0, l);
                                    continue
                                }
                            } else l = r;
                            l && o.add(l)
                        }
                        i[n] = o
                    }
                    this.toolbars = i
                },
                getHtmlTpl: function() {
                    return '<div id="##" class="%%"><div id="##_toolbarbox" class="%%-toolbarbox"><div id="##_toolbarboxouter" class="%%-toolbarboxouter"><div class="%%-toolbarboxinner">' + this.renderToolbarBoxHtml() + "</div></div>" + '<div id="##_toolbarmsg" class="%%-toolbarmsg" style="display:none;">' + '<div id = "##_upload_dialog" class="%%-toolbarmsg-upload" onclick="$$.showWordImageDialog();">点此上传</div>' + '<div class="%%-toolbarmsg-close" onclick="$$.hideToolbarMsg();">x</div>' + '<div id="##_toolbarmsg_label" class="%%-toolbarmsg-label"></div>' + '<div style="height:0;overflow:hidden;clear:both;"></div>' + "</div>" + "</div>" + '<div id="##_iframeholder" class="%%-iframeholder"></div>' + '<div id="##_bottombar" class="%%-bottomContainer"><table><tr>' + '<td id="##_elementpath" class="%%-bottombar"></td>' + '<td id="##_wordcount" class="%%-wordcount"></td>' + "</tr></table></div>" + "</div>"
                },
                showWordImageDialog: function() {
                    this.editor.execCommand("wordimage", "word_img"),
                    this._dialogs.wordImageDialog.open()
                },
                renderToolbarBoxHtml: function() {
                    for (var t = [], e = 0; e < this.toolbars.length; e++) t.push(this.toolbars[e].renderHtml());
                    return t.join("")
                },
                setFullScreen: function(t) {
                    if (this._fullscreen != t) {
                        this._fullscreen = t,
                        this.editor.fireEvent("beforefullscreenchange", t);
                        var e = this.editor;
                        if (baidu.editor.browser.gecko) var i = e.selection.getRange().createBookmark();
                        if (t ? (this._bakHtmlOverflow = document.documentElement.style.overflow, this._bakBodyOverflow = document.body.style.overflow, this._bakAutoHeight = this.editor.autoHeightEnabled, this._bakScrollTop = Math.max(document.documentElement.scrollTop, document.body.scrollTop), this._bakAutoHeight && (e.autoHeightEnabled = !1, this.editor.disableAutoHeight()), document.documentElement.style.overflow = "hidden", document.body.style.overflow = "hidden", this._bakCssText = this.getDom().style.cssText, this._bakCssText1 = this.getDom("iframeholder").style.cssText, this._updateFullScreen()) : (this.getDom().style.cssText = this._bakCssText, this.getDom("iframeholder").style.cssText = this._bakCssText1, this._bakAutoHeight && (e.autoHeightEnabled = !0, this.editor.enableAutoHeight()), document.documentElement.style.overflow = this._bakHtmlOverflow, document.body.style.overflow = this._bakBodyOverflow, window.scrollTo(0, this._bakScrollTop)), baidu.editor.browser.gecko) {
                            var n = document.createElement("input");
                            document.body.appendChild(n),
                            e.body.contentEditable = !1,
                            setTimeout(function() {
                                n.focus(),
                                setTimeout(function() {
                                    e.body.contentEditable = !0,
                                    e.selection.getRange().moveToBookmark(i).select(!0),
                                    baidu.editor.dom.domUtils.remove(n),
                                    t && window.scroll(0, 0)
                                })
                            })
                        }
                        this.editor.fireEvent("fullscreenchanged", t),
                        this.triggerLayout()
                    }
                },
                _wordCount: function() {
                    var t = this.getDom("wordcount");
                    return this.editor.options.wordCount ? (t.innerHTML = this.editor.queryCommandValue("wordcount"), void 0) : (t.style.display = "none", void 0)
                },
                disableWordCount: function() {
                    var t = this.getDom("wordcount");
                    t.innerHTML = "",
                    t.style.display = "none",
                    this.wordcount = !1
                },
                enableWordCount: function() {
                    var t = this.getDom("wordcount");
                    t.style.display = "",
                    this.wordcount = !0,
                    this._wordCount()
                },
                _updateFullScreen: function() {
                    if (this._fullscreen) {
                        var t = i.getViewportRect();
                        this.getDom().style.cssText = "border:0;position:absolute;left:0;top:0;width:" + t.width + "px;height:" + t.height + "px;z-index:" + (1 * this.getDom().style.zIndex + 100),
                        i.setViewportOffset(this.getDom(), {
                            left: 0,
                            top: 0
                        }),
                        this.editor.setHeight(t.height - this.getDom("toolbarbox").offsetHeight - this.getDom("bottombar").offsetHeight)
                    }
                },
                _updateElementPath: function() {
                    var t,
                    e = this.getDom("elementpath");
                    if (this.elementPathEnabled && (t = this.editor.queryCommandValue("elementpath"))) {
                        for (var i, n = [], s = 0; i = t[s]; s++) n[s] = this.formatHtml('<span unselectable="on" onclick="$$.editor.execCommand(&quot;elementpath&quot;, &quot;' + s + '&quot;);">' + i + "</span>");
                        e.innerHTML = '<div class="edui-editor-breadcrumb" onmousedown="return false;">path: ' + n.join(" &gt; ") + "</div>"
                    } else e.style.display = "none"
                },
                disableElementPath: function() {
                    var t = this.getDom("elementpath");
                    t.innerHTML = "",
                    t.style.display = "none",
                    this.elementPathEnabled = !1
                },
                enableElementPath: function() {
                    var t = this.getDom("elementpath");
                    t.style.display = "",
                    this.elementPathEnabled = !0,
                    this._updateElementPath()
                },
                isFullScreen: function() {
                    return this._fullscreen
                },
                postRender: function() {
                    n.prototype.postRender.call(this);
                    for (var t = 0; t < this.toolbars.length; t++) this.toolbars[t].postRender();
                    var e,
                    i = this,
                    s = baidu.editor.dom.domUtils,
                    o = function() {
                        clearTimeout(e),
                        e = setTimeout(function() {
                            i._updateFullScreen()
                        })
                    };
                    s.on(window, "resize", o),
                    i.addListener("destroy", 
                    function() {
                        s.un(window, "resize", o),
                        clearTimeout(e)
                    })
                },
                showToolbarMsg: function(t, e) {
                    if (this.getDom("toolbarmsg_label").innerHTML = t, this.getDom("toolbarmsg").style.display = "", !e) {
                        var i = this.getDom("upload_dialog");
                        i.style.display = "none"
                    }
                },
                hideToolbarMsg: function() {
                    this.getDom("toolbarmsg").style.display = "none"
                },
                mapUrl: function(t) {
                    return t.replace("~/", this.editor.options.UEDITOR_HOME_URL || "")
                },
                triggerLayout: function() {
                    var t = this.getDom();
                    t.style.zoom = "1" == t.style.zoom ? "100%": "1"
                }
            },
            e.inherits(t, baidu.editor.ui.UIBase),
            baidu.editor.ui.Editor = function(e) {
                var i = new baidu.editor.Editor(e);
                i.options.editor = i,
                new t(i.options);
                var n = i.render;
                return i.render = function(t) {
                    if (t && (t.constructor === String && (t = document.getElementById(t)), t && t.getAttribute("name") && (i.options.textarea = t.getAttribute("name")), t && /script|textarea/gi.test(t.tagName))) {
                        var e = document.createElement("div");
                        t.parentNode.insertBefore(e, t),
                        i.options.initialContent = t.value || t.innerHTML,
                        t.id && (e.id = t.id),
                        t.className && (e.className = t.className),
                        t.style.cssText && (e.style.cssText = t.style.cssText),
                        t.parentNode.removeChild(t),
                        t = e,
                        t.innerHTML = ""
                    }
                    i.ui.render(t);
                    var s = i.ui.getDom("iframeholder");
                    i.container = i.ui.getDom(),
                    i.container.style.zIndex = i.options.zIndex,
                    n.call(i, s)
                },
                i
            }
        } (),
        function(t) {
            t.fn.extend({
                ueditor: function(e) {
                    var i = [];
                    return this.each(function() {
                        function n(e) {
                            var i = "demohour-editor-" + m.autosave.prefix_name;
                            null != t.jStorage.get(i) && e.setContent(t.jStorage.get(i))
                        }
                        function s(e) {
                            t(document).everyTime(m.autosave.interval, 
                            function() {
                                var i = "demohour-editor-" + m.autosave.prefix_name;
                                "" != e.getContent && t.jStorage.set(i, e.getContent())
                            })
                        }
                        function o() {
                            var e = t("#ueditor_link_href" + b).val(),
                            i = {};
                            "" != e && (e = "http://" + e.replace(/^(?:https?:\/\/)|(?:\/)$/gi, "")),
                            i.href = e.replace(/^\s+|\s+$/g, ""),
                            i.href ? (i.target = "_blank", i.title = "", v.execCommand("link", i), a()) : (t("#ueditor_link_error_msg" + b).html("请输入链接地址！"), t("#ueditor_link_popup" + b + " input#ueditor_link_href" + b).focus())
                        }
                        function a() {
                            t("#ueditor_link_href" + b).val(""),
                            t("#ueditor_link_error_msg" + b).html(""),
                            t("#ueditor_link_popup" + b).hide()
                        }
                        function r() {
                            t("#ueditor_video_url" + b).val(""),
                            t("#ueditor_video_error_msg" + b).html(""),
                            t("#ueditor_video_popup" + b).hide(),
                            l()
                        }
                        function l() {
                            t("#ueditor_video_submit" + b).removeClass("edui-upload-button-loader"),
                            t("#ueditor_video_submit" + b).remove("span")
                        }
                        function u() {
                            var e = t("#ueditor_video_url" + b).val();
                            return "" == e ? (l(), t("#ueditor_video_error_msg" + b).html("请输入视频地址！"), t("#ueditor_video_popup" + b + " input#ueditor_video_url" + b).focus(), !1) : (t.ajax({
                                type: "POST",
                                async: !1,
                                url: t("#ueditor_video_convert_url" + b).val(),
                                data: {
                                    url: e
                                }
                            }).done(function(e) {
                                var i = jQuery.parseJSON(e);
                                if (void 0 == i.errormsg) {
                                    var n = '<p><img data-video-id="' + i.attachment_id + '" data-video-url="' + i.url + '" class="edui-faked-video"' + 'data-video-title="' + i.title + '" src="' + m.video.default_image + '"/></p>';
                                    v.execCommand("inserthtml", n),
                                    r(),
                                    v.focus()
                                } else l(),
                                t("#ueditor_video_error_msg" + b).html(i.errormsg),
                                t("#ueditor_video_popup" + b + " input#ueditor_video_url" + b).focus()
                            }), void 0)
                        }
                        function d(e, i) {
                            var n = '<img src="' + e.large + '" data-image-original="' + e.original + '" data-image-large="' + e.large + '" data-image-id="' + e.attachment_id + '"/>';
                            t("#" + i).append(n)
                        }
                        function c(t, e) {
                            if (this.fileProgressID = t.id, this.opacity = 100, this.height = 0, this.fileProgressWrapper = document.getElementById(this.fileProgressID), this.fileProgressWrapper) this.fileProgressElement = this.fileProgressWrapper.firstChild,
                            this.reset();
                            else {
                                this.fileProgressWrapper = document.createElement("div"),
                                this.fileProgressWrapper.className = "progressWrapper",
                                this.fileProgressWrapper.id = this.fileProgressID,
                                this.fileProgressElement = document.createElement("div"),
                                this.fileProgressElement.className = "progressContainer";
                                var i = document.createElement("a");
                                i.className = "edui-upload-img-delete",
                                i.href = "#",
                                i.style.visibility = "hidden",
                                i.appendChild(document.createTextNode(" "));
                                var n = document.createElement("span");
                                n.style.display = "none";
                                var s = document.createElement("span");
                                s.className = "progressBarInProgress";
                                var o = document.createElement("span");
                                o.className = "progressBarStatus",
                                o.innerHTML = "&nbsp;",
                                this.fileProgressElement.appendChild(i),
                                this.fileProgressElement.appendChild(n),
                                this.fileProgressElement.appendChild(o),
                                this.fileProgressElement.appendChild(s),
                                this.fileProgressWrapper.appendChild(this.fileProgressElement),
                                document.getElementById(e).appendChild(this.fileProgressWrapper)
                            }
                            this.height = this.fileProgressWrapper.offsetHeight,
                            this.setTimer(null)
                        }
                        function h() {
                            t("#ueditor_upload_image_thumbnails" + b).html(""),
                            t("#ueditor_upload_image_progress" + b).html(""),
                            t("#ueditor_image_popup" + b).hide()
                        }
                        function p() {
                            if (0 == t("#ueditor_upload_image_thumbnails" + b + " img").length) return ! 1;
                            var e = t("#ueditor_upload_image_thumbnails" + b + " img").map(function() {
                                return this.className = "upload_img",
                                this.outerHTML
                            }).get().join("<br /><br />") + "<br />";
                            v.execCommand("inserthtml", e),
                            h()
                        }
                        var f = {
                            autosave: {
                                interval: 3e3,
                                prefix_name: t(this).attr("id")
                            },
                            image: {
                                url: "/swfupload.json",
                                file_size_limit: "5 MB",
                                file_types: "*.jpg;*.gif;*.png;*.jpeg",
                                file_queue_limit: "6",
                                file_upload_limit: "6",
                                total_file_upload_limit: "100",
                                flash_url: "/swfupload/swfupload.swf",
                                button_image_url: "/ueditor2/themes/default/images/upload.gif",
                                button_width: "78",
                                button_height: "32",
                                file_types_description: "JPG Images"
                            },
                            video: {
                                url: "/video_convert",
                                default_image: "/ueditor2/themes/default/images/video.png"
                            },
                            editor_config_options: {
                                minFrameHeight: 480
                            }
                        },
                        m = t.extend(!0, {},
                        f, e),
                        g = t(this).attr("id"),
                        v = new baidu.editor.ui.Editor(m.editor_config_options);
                        v.render(g),
                        t("#" + g).removeClass(),
                        t(".edui-button-body").tooltip({
                            placement: "bottom"
                        });
                        var b = v.uid;
                        i.push(v),
                        0 != m.autosave && (n(v), s(v));
                        var y = '<div id="ueditor_link_popup' + b + '" class="edui-popup-all edui-popup-img" style="display:none;">' + '<div class="edui-popup-background">' + '<div class="edui-popup-all-content">' + '<div class="edui-popup-table">' + '<div class="edui-popup-top" id="ueditor_link_popup_top' + b + '">' + '<span class="edui-dialog-caption">添加链接</span>' + '<a href="#" title="关闭" onfocus="this.blur();" class="ueditor_link_close' + b + '">关闭</a>' + "</div>" + '<div class="edui-popup-table-content">' + '<input id="ueditor_link_href' + b + '" type="text" placeholder="输入链接地址" />' + '<span id="ueditor_link_error_msg' + b + '"></span>' + '<div class="upload-img-list-b">' + '<div class="upload-img-list-b-r">' + '<a href="#" class="ueditor_link_close' + b + '" title="取消" onfocus="this.blur();">取消</a>' + '<a href="#" id="ueditor_link_submit' + b + '" title="确定" class="edui-upload-button" onfocus="this.blur();">确定</a>' + "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>";
                        t("#" + g).before(y),
                        t("#ueditor_link_submit" + b).bind("click", 
                        function() {
                            return v.focus(),
                            o(),
                            !1
                        }),
                        t(".ueditor_link_close" + b).bind("click", 
                        function() {
                            return v.focus(),
                            a(),
                            !1
                        });
                        var _ = '<div id="ueditor_video_popup' + b + '" class="edui-popup-all edui-popup-img" style="display:none;">' + '<div class="edui-popup-background">' + '<div class="edui-popup-all-content">' + '<div class="edui-popup-table">' + '<div class="edui-popup-top" id="ueditor_video_popup_top' + b + '">' + '<span class="edui-dialog-caption">添加视频</span>' + '<a href="#" title="关闭" onfocus="this.blur();" class="ueditor_video_close' + b + '">关闭</a>' + "</div>" + '<div class="edui-popup-table-content">' + '<input id="ueditor_video_convert_url' + b + '" + value="' + m.video.url + '" style="display:none"/>' + '<input id="ueditor_video_url' + b + '" type="text" placeholder="输入视频地址（支持优酷、土豆、酷6、新浪视频）"/>' + '<span id="ueditor_video_error_msg' + b + '"></span>' + '<div class="upload-img-list-b">' + '<div class="upload-img-list-b-r">' + '<a href="#" class="ueditor_video_close' + b + '" title="取消" onfocus="this.blur();">取消</a>' + '<a href="#" id="ueditor_video_submit' + b + '" title="确定" class="edui-upload-button" onfocus="this.blur();">确定</a>' + "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>";
                        t("#" + g).before(_),
                        t("#ueditor_video_submit" + b).click(function() {
                            return t(this).addClass("edui-upload-button-loader"),
                            t(this).html(""),
                            t(this).append("<span>确定</span>"),
                            u(),
                            !1
                        }),
                        t(".ueditor_video_close" + b).click(function() {
                            return v.focus(),
                            r(),
                            !1
                        });
                        var w = "";
                        parseInt(m.image.file_upload_limit) < parseInt(m.image.total_file_upload_limit) && (w += "每次最多传" + m.image.file_queue_limit + "张，");
                        var S = '<div id="ueditor_image_popup' + b + '" class="edui-popup-all edui-popup-img" style="display:none;">' + '<div class="edui-popup-background">' + '<div class="edui-popup-all-content">' + '<div class="edui-popup-table">' + '<div class="edui-popup-top" id="ueditor_image_popup_top' + b + '">' + '<span class="edui-dialog-caption">添加图片</span>' + '<a href="#" title="关闭" onfocus="this.blur();" class="ueditor_image_upload_close' + b + '">关闭</a>' + "</div>" + '<div class="edui-popup-table-content">' + '<div class="edui-popup-table-upload">' + '<span id="ueditor_image_upload_btn' + b + '"></span>' + "<span>单张最大" + m.image.file_size_limit + "，" + w + "总共允许上传" + m.image.total_file_upload_limit + "张。</span>" + "</div>" + '<div class="edui-upload-img-list" id="ueditor_upload_image_progress' + b + '"></div>' + '<div id="ueditor_upload_image_thumbnails' + b + '" style="display:none"></div>' + '<div class="upload-img-list-b">' + '<div class="upload-img-list-b-l">' + '<input id="ueditor_image_upload_cancel_all' + b + '" type="button" value="取消上传" onclick="cancelQueue(swfu);" disabled="disabled" style="display:none" />' + "</div>" + '<div class="upload-img-list-b-r">' + '<a href="#" class="ueditor_image_upload_close' + b + '" title="取消" onfocus="this.blur();">取消</a>' + '<a href="#" id="ueditor_image_upload_submit' + b + '" title="确定" class="edui-upload-button" onfocus="this.blur();">确定</a>' + "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>";
                        t("#" + g).before(S);
                        var x,
                        C = [];
                        x = new SWFUpload({
                            upload_url: m.image.url,
                            flash_url: m.image.flash_url,
                            button_image_url: m.image.button_image_url,
                            button_placeholder_id: "ueditor_image_upload_btn" + b,
                            button_width: m.image.button_width,
                            button_height: m.image.button_height,
                            button_action: SWFUpload.BUTTON_ACTION.SELECT_FILES,
                            button_cursor: SWFUpload.CURSOR.HAND,
                            file_size_limit: m.image.file_size_limit,
                            file_types: m.image.file_types,
                            file_types_description: m.image.file_types_description,
                            file_upload_limit: m.image.file_upload_limit,
                            file_queue_limit: m.image.file_queue_limit,
                            custom_settings: {
                                progressTarget: "ueditor_upload_image_progress" + b,
                                cancelButtonId: "ueditor_image_upload_cancel_all" + b,
                                thumbnailsId: "ueditor_upload_image_thumbnails" + b
                            },
                            upload_start_handler: function(t) {
                                try {
                                    var e = new c(t, this.customSettings.progressTarget);
                                    e.setStatus("上传中..."),
                                    e.toggleCancel(!0, this)
                                } catch(i) {}
                                return ! 0
                            },
                            upload_progress_handler: function(t, e, i) {
                                try {
                                    var n = Math.ceil(99 * (e / i)),
                                    s = new c(t, this.customSettings.progressTarget);
                                    s.setProgress(n),
                                    s.setStatus("上传中...")
                                } catch(o) {
                                    this.debug(o)
                                }
                            },
                            file_queue_error_handler: function(t, e, i) {
                                try {
                                    if (e === SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED) return alert("选取文件个数超出范围.\n一次只能上传" + m.image.file_queue_limit + "张图片！"),
                                    void 0;
                                    var n = new c(t, this.customSettings.progressTarget);
                                    switch (n.setError(), n.toggleCancel(!1), e) {
                                    case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
                                        n.setErrorStatus("文件过大.");
                                        break;
                                    case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
                                        n.setErrorStatus("空文件.");
                                        break;
                                    case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
                                        n.setErrorStatus("格式错误");
                                        break;
                                    case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:
                                        alert("选取文件个数超出范围.\n一次只能上传" + m.image.file_upload_limit + "张图片！");
                                        break;
                                    default:
                                        null !== t && n.setStatus("Unhandled Error"),
                                        this.debug("Error Code: " + e + ", File name: " + t.name + ", File size: " + t.size + ", Message: " + i)
                                    }
                                } catch(s) {
                                    this.debug(s)
                                }
                            },
                            file_queued_handler: function(t) {
                                C.push(t.id)
                            },
                            file_dialog_complete_handler: function() {
                                try {
                                    var e = this.customSettings.thumbnailsId;
                                    this.setStats({
                                        successful_uploads: t("#" + e).find("img").size()
                                    });
                                    var i = t("#" + g + " iframe").contents().find(".upload_img").size(),
                                    n = m.image.total_file_upload_limit,
                                    s = this.getStats().successful_uploads,
                                    o = this.getStats().files_queued;
                                    if (n - i - s >= o) o > 0 && (document.getElementById(this.customSettings.cancelButtonId).disabled = !1),
                                    this.startUpload(),
                                    C = [];
                                    else {
                                        var a = "";
                                        n - i - s > 0 && (a = "还能上传" + (n - i - s) + "张图片。"),
                                        this.customSettings.queue = this.customSettings.queue || new Array;
                                        for (var r = 0; r < C.length; r++) this.cancelUpload(C[r]);
                                        alert("总共只能上传" + m.image.total_file_upload_limit + "张图片！" + a)
                                    }
                                } catch(l) {
                                    this.debug(l)
                                }
                            },
                            upload_error_handler: function(t, e, i) {
                                try {
                                    var n = new c(t, this.customSettings.progressTarget);
                                    switch (n.setError(), n.toggleCancel(!1), e) {
                                    case SWFUpload.UPLOAD_ERROR.HTTP_ERROR:
                                        n.setErrorStatus("上传错误: " + i),
                                        this.debug("Error Code: HTTP Error, File name: " + t.name + ", Message: " + i);
                                        break;
                                    case SWFUpload.UPLOAD_ERROR.MISSING_UPLOAD_URL:
                                        n.setErrorStatus("配置错误"),
                                        this.debug("Error Code: No backend file, File name: " + t.name + ", Message: " + i);
                                        break;
                                    case SWFUpload.UPLOAD_ERROR.UPLOAD_FAILED:
                                        n.setErrorStatus("上传失败"),
                                        this.debug("Error Code: Upload Failed, File name: " + t.name + ", File size: " + t.size + ", Message: " + i);
                                        break;
                                    case SWFUpload.UPLOAD_ERROR.IO_ERROR:
                                        n.setErrorStatus("服务器错误"),
                                        this.debug("Error Code: IO Error, File name: " + t.name + ", Message: " + i);
                                        break;
                                    case SWFUpload.UPLOAD_ERROR.SECURITY_ERROR:
                                        n.setErrorStatus("安全性错误"),
                                        this.debug("Error Code: Security Error, File name: " + t.name + ", Message: " + i);
                                        break;
                                    case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
                                        n.setErrorStatus("超出限制"),
                                        this.debug("Error Code: Upload Limit Exceeded, File name: " + t.name + ", File size: " + t.size + ", Message: " + i);
                                        break;
                                    case SWFUpload.UPLOAD_ERROR.SPECIFIED_FILE_ID_NOT_FOUND:
                                        n.setErrorStatus("文件不存在"),
                                        this.debug("Error Code: The file was not found, File name: " + t.name + ", File size: " + t.size + ", Message: " + i);
                                        break;
                                    case SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED:
                                        n.setErrorStatus("文件不合法"),
                                        this.debug("Error Code: File Validation Failed, File name: " + t.name + ", File size: " + t.size + ", Message: " + i);
                                        break;
                                    case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
                                        0 === this.getStats().files_queued && (document.getElementById(this.customSettings.cancelButtonId).disabled = !0),
                                        n.setErrorStatus("已取消..."),
                                        n.setCancelled();
                                        break;
                                    case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
                                        n.setErrorStatus("停止...");
                                        break;
                                    default:
                                        n.setErrorStatus("发生错误: " + error_code),
                                        this.debug("Error Code: " + e + ", File name: " + t.name + ", File size: " + t.size + ", Message: " + i)
                                    }
                                } catch(s) {
                                    this.debug(s)
                                }
                            },
                            upload_success_handler: function(t, e) {
                                try {
                                    var i = new c(t, this.customSettings.progressTarget),
                                    n = jQuery.parseJSON(e);
                                    if (void 0 != n.errormsg) i.setError(),
                                    i.setErrorStatus(n.errormsg),
                                    i.toggleCancel(!1);
                                    else {
                                        var s = this.customSettings.thumbnailsId;
                                        i.setComplete(n),
                                        d(n, s),
                                        i.setStatus("上传完成"),
                                        i.toggleCancel(!1)
                                    }
                                } catch(o) {
                                    this.debug(o)
                                }
                            },
                            upload_complete_handler: function() {
                                try {
                                    if (0 === this.getStats().files_queued) {
                                        document.getElementById(this.customSettings.cancelButtonId).disabled = !0;
                                        var e = this;
                                        t(".edui-imgage-delete").click(function() {
                                            var i = t(this).next(),
                                            n = e.customSettings.thumbnailsId;
                                            return i.parent().prev().remove(),
                                            i.parent().remove(),
                                            t("#" + n).find("img[data-image-id=" + i.attr("data-image-id") + "]").remove(),
                                            e.setStats({
                                                successful_uploads: t("#" + n).find("img").size()
                                            }),
                                            !1
                                        })
                                    } else this.startUpload()
                                } catch(i) {
                                    this.debug(i)
                                }
                            },
                            debug: !1
                        }),
                        c.prototype.setTimer = function(t) {
                            this.fileProgressElement.FP_TIMER = t
                        },
                        c.prototype.getTimer = function() {
                            return this.fileProgressElement.FP_TIMER || null
                        },
                        c.prototype.reset = function() {
                            this.fileProgressElement.className = "progressContainer",
                            this.fileProgressElement.childNodes[2].innerHTML = "&nbsp;",
                            this.fileProgressElement.childNodes[2].className = "progressBarStatus",
                            this.fileProgressElement.childNodes[3].className = "progressBarInProgress",
                            this.fileProgressElement.childNodes[3].innerHTML = "",
                            this.appear()
                        },
                        c.prototype.setProgress = function(t) {
                            this.fileProgressElement.className = "progressContainer green",
                            this.fileProgressElement.childNodes[3].className = "progressBarInProgress",
                            this.fileProgressElement.childNodes[3].innerHTML = t + "%",
                            this.appear()
                        },
                        c.prototype.setComplete = function(e) {
                            this.fileProgressElement.className = "progressContainer blue",
                            this.fileProgressElement.childNodes[3].className = "progressBarComplete",
                            this.fileProgressElement.childNodes[3].style.width = "";
                            var i = this;
                            i.disappear();
                            var n = '<div><a href="#" class="edui-imgage-delete">取消</a><img src="' + e.small + '" data-image-original="' + e.original + '" data-image-large="' + e.large + '" data-image-id="' + e.attachment_id + '"/>';
                            t(i.fileProgressWrapper).after(n)
                        },
                        c.prototype.setError = function() {
                            this.fileProgressElement.className = "progressContainer red",
                            this.fileProgressElement.childNodes[3].className = "progressBarError",
                            this.fileProgressElement.childNodes[3].style.width = "";
                            var t = this;
                            this.setTimer(setTimeout(function() {
                                t.disappear()
                            },
                            5e3))
                        },
                        c.prototype.setCancelled = function() {
                            this.fileProgressElement.className = "progressContainer",
                            this.fileProgressElement.childNodes[3].className = "progressBarError",
                            this.fileProgressElement.childNodes[3].style.width = "";
                            var t = this;
                            this.setTimer(setTimeout(function() {
                                t.disappear()
                            },
                            2e3))
                        },
                        c.prototype.setStatus = function(t) {
                            this.fileProgressElement.childNodes[2].innerHTML = t
                        },
                        c.prototype.setErrorStatus = function(t) {
                            this.fileProgressElement.childNodes[2].className = "edui-upload-img-error",
                            this.fileProgressElement.childNodes[2].innerHTML = t + "<em></em>"
                        },
                        c.prototype.toggleCancel = function(t, e) {
                            if (this.fileProgressElement.childNodes[0].style.visibility = t ? "visible": "hidden", e) {
                                var i = this.fileProgressID;
                                this.fileProgressElement.childNodes[0].onclick = function() {
                                    return e.cancelUpload(i),
                                    !1
                                }
                            }
                        },
                        c.prototype.appear = function() {
                            if (null !== this.getTimer() && (clearTimeout(this.getTimer()), this.setTimer(null)), this.fileProgressWrapper.filters) try {
                                this.fileProgressWrapper.filters.item("DXImageTransform.Microsoft.Alpha").opacity = 100
                            } catch(t) {
                                this.fileProgressWrapper.style.filter = "progid:DXImageTransform.Microsoft.Alpha(opacity=100)"
                            } else this.fileProgressWrapper.style.opacity = 1;
                            this.fileProgressWrapper.style.height = "",
                            this.height = this.fileProgressWrapper.offsetHeight,
                            this.opacity = 100,
                            this.fileProgressWrapper.style.display = ""
                        },
                        c.prototype.disappear = function() {
                            this.fileProgressWrapper.style.display = "none"
                        },
                        t("#ueditor_image_upload_submit" + b).click(function() {
                            return v.focus(),
                            p(),
                            !1
                        }),
                        t(".ueditor_image_upload_close" + b).click(function() {
                            return v.focus(),
                            h(),
                            !1
                        }),
                        t("div.edui-popup-all-content").css("top", t(window).height() / 2 - 150)
                    }),
                    i
                }
            })
        } (jQuery),
        !
        function(t) {
            "use strict";
            var e = function(t, e) {
                this.init("tooltip", t, e)
            };
            e.prototype = {
                constructor: e,
                init: function(e, i, n) {
                    var s,
                    o;
                    this.type = e,
                    this.$element = t(i),
                    this.options = this.getOptions(n),
                    this.enabled = !0,
                    "manual" != this.options.trigger && (s = "hover" == this.options.trigger ? "mouseenter": "focus", o = "hover" == this.options.trigger ? "mouseleave": "blur", this.$element.on(s, this.options.selector, t.proxy(this.enter, this)), this.$element.on(o, this.options.selector, t.proxy(this.leave, this))),
                    this.options.selector ? this._options = t.extend({},
                    this.options, {
                        trigger: "manual",
                        selector: ""
                    }) : this.fixTitle()
                },
                getOptions: function(e) {
                    return e = t.extend({},
                    t.fn[this.type].defaults, e, this.$element.data()),
                    e.delay && "number" == typeof e.delay && (e.delay = {
                        show: e.delay,
                        hide: e.delay
                    }),
                    e
                },
                enter: function(e) {
                    var i = t(e.currentTarget)[this.type](this._options).data(this.type);
                    return i.options.delay && i.options.delay.show ? (clearTimeout(this.timeout), i.hoverState = "in", this.timeout = setTimeout(function() {
                        "in" == i.hoverState && i.show()
                    },
                    i.options.delay.show), void 0) : i.show()
                },
                leave: function(e) {
                    var i = t(e.currentTarget)[this.type](this._options).data(this.type);
                    return i.options.delay && i.options.delay.hide ? (clearTimeout(this.timeout), i.hoverState = "out", this.timeout = setTimeout(function() {
                        "out" == i.hoverState && i.hide()
                    },
                    i.options.delay.hide), void 0) : i.hide()
                },
                show: function() {
                    var t,
                    e,
                    i,
                    n,
                    s,
                    o,
                    a;
                    if (this.hasContent() && this.enabled) {
                        switch (t = this.tip(), this.setContent(), this.options.animation && t.addClass("fade"), o = "function" == typeof this.options.placement ? this.options.placement.call(this, t[0], this.$element[0]) : this.options.placement, e = /in/.test(o), t.remove().css({
                            top: 0,
                            left: 0,
                            display: "block"
                        }).appendTo(e ? this.$element: document.body), i = this.getPosition(e), n = t[0].offsetWidth, s = t[0].offsetHeight, e ? o.split(" ")[1] : o) {
                        case "bottom":
                            a = {
                                top: i.top + i.height,
                                left: i.left + i.width / 2 - n / 2
                            };
                            break;
                        case "top":
                            a = {
                                top: i.top - s,
                                left: i.left + i.width / 2 - n / 2
                            };
                            break;
                        case "left":
                            a = {
                                top: i.top + i.height / 2 - s / 2,
                                left: i.left - n
                            };
                            break;
                        case "right":
                            a = {
                                top: i.top + i.height / 2 - s / 2,
                                left: i.left + i.width
                            }
                        }
                        t.css(a).addClass(o).addClass("in")
                    }
                },
                isHTML: function(t) {
                    return "string" != typeof t || "<" === t.charAt(0) && ">" === t.charAt(t.length - 1) && t.length >= 3 || /^(?:[^<]*<[\w\W]+>[^>]*$)/.exec(t)
                },
                setContent: function() {
                    var t = this.tip(),
                    e = this.getTitle();
                    t.find(".tooltip-inner")[this.isHTML(e) ? "html": "text"](e),
                    t.removeClass("fade in top bottom left right")
                },
                hide: function() {
                    function e() {
                        var e = setTimeout(function() {
                            i.off(t.support.transition.end).remove()
                        },
                        500);
                        i.one(t.support.transition.end, 
                        function() {
                            clearTimeout(e),
                            i.remove()
                        })
                    }
                    var i = this.tip();
                    i.removeClass("in"),
                    t.support.transition && this.$tip.hasClass("fade") ? e() : i.remove()
                },
                fixTitle: function() {
                    var t = this.$element; (t.attr("title") || "string" != typeof t.attr("data-original-title")) && t.attr("data-original-title", t.attr("title") || "").removeAttr("title")
                },
                hasContent: function() {
                    return this.getTitle()
                },
                getPosition: function(e) {
                    return t.extend({},
                    e ? {
                        top: 0,
                        left: 0
                    }: this.$element.offset(), {
                        width: this.$element[0].offsetWidth,
                        height: this.$element[0].offsetHeight
                    })
                },
                getTitle: function() {
                    var t,
                    e = this.$element,
                    i = this.options;
                    return t = e.attr("data-original-title") || ("function" == typeof i.title ? i.title.call(e[0]) : i.title)
                },
                tip: function() {
                    return this.$tip = this.$tip || t(this.options.template)
                },
                validate: function() {
                    this.$element[0].parentNode || (this.hide(), this.$element = null, this.options = null)
                },
                enable: function() {
                    this.enabled = !0
                },
                disable: function() {
                    this.enabled = !1
                },
                toggleEnabled: function() {
                    this.enabled = !this.enabled
                },
                toggle: function() {
                    this[this.tip().hasClass("in") ? "hide": "show"]()
                }
            },
            t.fn.tooltip = function(i) {
                return this.each(function() {
                    var n = t(this),
                    s = n.data("tooltip"),
                    o = "object" == typeof i && i;
                    s || n.data("tooltip", s = new e(this, o)),
                    "string" == typeof i && s[i]()
                })
            },
            t.fn.tooltip.Constructor = e,
            t.fn.tooltip.defaults = {
                animation: !0,
                placement: "top",
                selector: !1,
                template: '<div class="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-inner"></div></div>',
                trigger: "hover",
                title: "",
                delay: 0
            }
        } (window.jQuery),
        function() {}.call(this);