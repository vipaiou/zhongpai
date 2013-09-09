!
function(t) {
    t.fn.slides = function(e) {
        return e = t.extend({}, t.fn.slides.option, e),
        this.each(function() {
            function i(i, n, s) {
                if (!a && o) {
                    switch (a = !0, e.animationStart(x + 1), i) {
                    case "next":
                        S = x,
                        b = x + 1,
                        b = f === b ? 0: b,
                        l = 2 * g,
                        i = 2 * -g,
                        x = b;
                        break;
                    case "prev":
                        S = x,
                        b = x - 1,
                        b = -1 === b ? f - 1: b,
                        l = 0,
                        i = 0,
                        x = b;
                        break;
                    case "pagination":
                        b = parseInt(s, 10),
                        S = t("." + e.paginationClass + " li." + e.currentClass + " a", d).attr("href").match("[^#/]+$"),
                        b > S ? (l = 2 * g, i = 2 * -g) : (l = 0, i = 0),
                        x = b
                    }
                    "fade" === n ? e.crossfade ? p.children(":eq(" + b + ")", d).css({
                        zIndex: 10
                    }).fadeIn(e.fadeSpeed, e.fadeEasing, 
                    function() {
                        e.autoHeight ? p.animate({
                            height: p.children(":eq(" + b + ")", d).outerHeight()
                        },
                        e.autoHeightSpeed, 
                        function() {
                            p.children(":eq(" + S + ")", d).css({
                                display: "none",
                                zIndex: 0
                            }),
                            p.children(":eq(" + b + ")", d).css({
                                zIndex: 0
                            }),
                            e.animationComplete(b + 1),
                            a = !1
                        }) : (p.children(":eq(" + S + ")", d).css({
                            display: "none",
                            zIndex: 0
                        }), p.children(":eq(" + b + ")", d).css({
                            zIndex: 0
                        }), e.animationComplete(b + 1), a = !1)
                    }) : p.children(":eq(" + S + ")", d).fadeOut(e.fadeSpeed, e.fadeEasing, 
                    function() {
                        e.autoHeight ? p.animate({
                            height: p.children(":eq(" + b + ")", d).outerHeight()
                        },
                        e.autoHeightSpeed, 
                        function() {
                            p.children(":eq(" + b + ")", d).fadeIn(e.fadeSpeed, e.fadeEasing)
                        }) : p.children(":eq(" + b + ")", d).fadeIn(e.fadeSpeed, e.fadeEasing, 
                        function() {
                            t.browser.msie && t(this).get(0).style.removeAttribute("filter")
                        }),
                        e.animationComplete(b + 1),
                        a = !1
                    }) : (p.children(":eq(" + b + ")").css({
                        left: l,
                        display: "block"
                    }), e.autoHeight ? p.animate({
                        left: i,
                        height: p.children(":eq(" + b + ")").outerHeight()
                    },
                    e.slideSpeed, e.slideEasing, 
                    function() {
                        p.css({
                            left: -g
                        }),
                        p.children(":eq(" + b + ")").css({
                            left: g,
                            zIndex: 5
                        }),
                        p.children(":eq(" + S + ")").css({
                            left: g,
                            display: "none",
                            zIndex: 0
                        }),
                        e.animationComplete(b + 1),
                        a = !1
                    }) : p.animate({
                        left: i
                    },
                    e.slideSpeed, e.slideEasing, 
                    function() {
                        p.css({
                            left: -g
                        }),
                        p.children(":eq(" + b + ")").css({
                            left: g,
                            zIndex: 5
                        }),
                        p.children(":eq(" + S + ")").css({
                            left: g,
                            display: "none",
                            zIndex: 0
                        }),
                        e.animationComplete(b + 1),
                        a = !1
                    })),
                    e.pagination && (t("." + e.paginationClass + " li." + e.currentClass, d).removeClass(e.currentClass), t("." + e.paginationClass + " li:eq(" + b + ")", d).addClass(e.currentClass))
                }
            }
            function n() {
                clearInterval(d.data("interval"))
            }
            function s() {
                e.pause ? (clearTimeout(d.data("pause")), clearInterval(d.data("interval")), h = setTimeout(function() {
                    clearTimeout(d.data("pause")),
                    c = setInterval(function() {
                        i("next", _)
                    },
                    e.play),
                    d.data("interval", c)
                },
                e.pause), d.data("pause", h)) : n()
            }
            t("." + e.container, t(this)).children().wrapAll('<div class="slides_control"/>');
            var o,
            a,
            r,
            l,
            u,
            h,
            c,
            d = t(this),
            p = t(".slides_control", d),
            f = p.children().size(),
            g = p.children().outerWidth(),
            m = p.children().outerHeight(),
            v = e.start - 1,
            _ = e.effect.indexOf(",") < 0 ? e.effect: e.effect.replace(" ", "").split(",")[0],
            y = e.effect.indexOf(",") < 0 ? _: e.effect.replace(" ", "").split(",")[1],
            b = 0,
            S = 0,
            w = 0,
            x = 0;
            if (2 > f) return t("." + e.container, t(this)).fadeIn(e.fadeSpeed, e.fadeEasing, 
            function() {
                o = !0,
                e.slidesLoaded()
            }),
            t("." + e.next + ", ." + e.prev).fadeOut(0),
            !1;
            if (! (2 > f)) {
                if (0 > v && (v = 0), v > f && (v = f - 1), e.start && (x = v), e.randomize && p.randomize(), t("." + e.container, d).css({
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
                    width: 3 * g,
                    height: m,
                    left: -g
                }), t("." + e.container, d).css({
                    display: "block"
                }), e.autoHeight && (p.children().css({
                    height: "auto"
                }), p.animate({
                    height: p.children(":eq(" + v + ")").outerHeight()
                },
                e.autoHeightSpeed)), e.preload && p.find("img:eq(" + v + ")").length) {
                    t("." + e.container, d).css({
                        background: "url(" + e.preloadImage + ") no-repeat 50% 50%"
                    });
                    var F = p.find("img:eq(" + v + ")").attr("src") + "?" + (new Date).getTime();
                    u = "slides_control" != t("img", d).parent().attr("class") ? p.children(":eq(0)")[0].tagName.toLowerCase() : p.find("img:eq(" + v + ")"),
                    p.find("img:eq(" + v + ")").attr("src", F).load(function() {
                        p.find(u + ":eq(" + v + ")").fadeIn(e.fadeSpeed, e.fadeEasing, 
                        function() {
                            t(this).css({
                                zIndex: 5
                            }),
                            t("." + e.container, d).css({
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
                    return i("next", _),
                    !1
                })),
                e.hoverPause && e.play && (p.bind("mouseover", 
                function() {
                    n()
                }), p.bind("mouseleave", 
                function() {
                    s()
                })),
                e.generateNextPrev && (t("." + e.container, d).after('<a href="#" class="' + e.prev + '">Prev</a>'), t("." + e.prev, d).after('<a href="#" class="' + e.next + '">Next</a>')),
                t("." + e.next, d).click(function(t) {
                    t.preventDefault(),
                    e.play && s(),
                    i("next", _)
                }),
                t("." + e.prev, d).click(function(t) {
                    t.preventDefault(),
                    e.play && s(),
                    i("prev", _)
                }),
                e.generatePagination ? (e.prependPagination ? d.prepend('<div class="slidebarpagination"><ul class=' + e.paginationClass + "></ul></div>") : d.append('<div class="slidebarpagination"><ul class=' + e.paginationClass + "></ul></div>"), p.children().each(function() {
                    t("." + e.paginationClass, d).append('<li><a href="#' + w + '">' + (w + 1) + "</a></li>"),
                    w++
                })) : t("." + e.paginationClass + " li a", d).each(function() {
                    t(this).attr("href", "#" + w),
                    w++
                }),
                t("." + e.paginationClass + " li:eq(" + v + ")", d).addClass(e.currentClass),
                t("." + e.paginationClass + " li a", d).click(function() {
                    return e.play && s(),
                    r = t(this).attr("href").match("[^#/]+$"),
                    x != r && i("pagination", y, r),
                    !1
                }),
                t("a.link", d).click(function() {
                    return e.play && s(),
                    r = t(this).attr("href").match("[^#/]+$") - 1,
                    x != r && i("pagination", y, r),
                    !1
                }),
                e.play && (c = setInterval(function() {
                    i("next", _)
                },
                e.play), d.data("interval", c))
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
function() {}.call(this);