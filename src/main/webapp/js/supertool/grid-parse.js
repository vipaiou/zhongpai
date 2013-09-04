(function() {
    /*
     * require('Escape.js')
     */var $, EmbeddedGetter, Eval, Getter, RowParser, echo, embeddedGetter, encodedEvalPat, evalPat, flatten, getter, getterPat, ieSplit, splitt;
    $ = jQuery;
    getterPat = /{([^}]*)}/g;
    evalPat = /@{((?:[^}]|}[^@])*)}@/g;
    encodedEvalPat = /@{((?:[^}]|}[^@])*)}@/g;
    ieSplit = function(s, pat) {
        var i, m, match, merge, notmatch, _ref;
        match = s.match(pat);
        notmatch = s.replace(pat, '[|]').split('[|]');
        merge = [];
        for (i = 0, _ref = notmatch.length - 1; 0 <= _ref ? i <= _ref : i >= _ref; 0 <= _ref ? i++ : i--) {
            merge.push(notmatch[i]);
            if (match !== null && (match[i] != null)) {
                m = match[i].replace(pat, "$1");
                merge.push(m);
            }
        }
        return merge;
    };
    splitt = function(s, pat, funIn, funOut) {
        var i, n, ret, ss, _len;
        if (S.isIE()) {
            ss = ieSplit(s, pat);
        } else {
            ss = s.split(pat);
        }
        ss = ieSplit(s, pat);
        ret = [];
        for (n = 0, _len = ss.length; n < _len; n++) {
            i = ss[n];
            if (n % 2 === 1) {
                ret.push(funIn.call(null, i));
            } else {
                ret.push(funOut.call(null, i));
            }
        }
        return ret;
    };
    echo = function(x) {
        return x;
    };
    getter = function(x) {
        return new Getter(x);
    };
    embeddedGetter = function(x) {
        return new EmbeddedGetter(x);
    };
    flatten = function(arr) {
        var ret, rjoin;
        ret = [];
        rjoin = function(a) {
            var i, _i, _len, _results;
            if ($.isArray(a)) {
                _results = [];
                for (_i = 0, _len = a.length; _i < _len; _i++) {
                    i = a[_i];
                    _results.push(rjoin(i));
                }
                return _results;
            } else {
                return ret.push(a);
            }
        };
        rjoin(arr);
        return ret;
    };
    RowParser = (function() {
        function RowParser(format) {
            this.init(format);
        }
        RowParser.prototype.makeEval = function(s) {
            var ev;
            ev = new Eval(s);
            return ev;
        };
        RowParser.prototype.makeGetter = function(s) {
            return splitt(s, getterPat, getter, echo);
        };
        RowParser.prototype.init = function(format) {
            var parts;
            parts = splitt(format, evalPat, this.makeEval, this.makeGetter);
            return this.parts = flatten(parts);
        };
        RowParser.prototype.parse = function(data) {
            var part, ret, _i, _len, _ref;
            ret = [];
            _ref = this.parts;
            for (_i = 0, _len = _ref.length; _i < _len; _i++) {
                part = _ref[_i];
                if (typeof part === 'string') {
                    ret.push(part);
                } else if (typeof part === 'object') {
                    if (part.constructor === Eval || part.constructor === Getter) {
                        ret.push(part.apply(data));
                    }
                }
            }
            return flatten(ret).join('');
        };
        return RowParser;
    })();
    Getter = (function() {
        function Getter(key) {
            var parts;
            parts = key.split(':');
            if (parts.length === 1) {
                this.key = key;
            } else if (parts.length > 1) {
                this.method = parts[0];
                this.key = parts[1];
            }
            if (this.method != null) {
                switch (this.method) {
                case "html":
                    this.method = Escape.html;
                    break;
                case "htmlAttr":
                    this.method = Escape.htmlAttr;
                    break;
                case "js":
                    this.method = Escape.js;
                    break;
                default:
                    delete this.method;
                }
            }
        }
        Getter.prototype.apply = function(data) {
            var d;
            if (this.key == 'row') {
                return 'row';
            }
            d = data[this.key];
            if (!(d != null)) {
                return '';
            } else if (this.method != null) {
                return this.method.call(this, d);
            } else if (typeof d !== 'string') {
                return d;
            } else {
                return Escape.html(d);
            }
        };
        return Getter;
    })();
    EmbeddedGetter = (function() {
        function EmbeddedGetter(key) {
            var parts;
            parts = key.split(':');
            if (parts.length === 1) {
                this.key = key;
            } else if (parts.length > 1) {
                this.method = parts[0];
                this.key = parts[1];
            }
            if (this.method != null) {
                switch (this.method) {
                case "html":
                    this.method = Escape.html;
                    break;
                case "htmlAttr":
                    this.method = Escape.htmlAttr;
                    break;
                case "js":
                    this.method = Escape.js;
                    break;
                default:
                    delete this.method;
                }
            }
        }
        EmbeddedGetter.prototype.apply = function(data) {
            var d;
            if (this.key == 'row') {
                return 'row';
            }
            d = data[this.key];
            if (typeof d == 'undefined' || d == null) {
                return "''";
            }
            else if (this.method != null) {
                var ret = this.method.call(this, d);
                return ret;
            } else if (typeof d === 'string') {
                return Escape.js(d);
            } else {
                return d;
            }
        };
        return EmbeddedGetter;
    })();
    Eval = (function() {
        function Eval(str) {
            this.str = str;
            this.parts = splitt(str, getterPat, embeddedGetter, echo);
        }
        Eval.prototype.apply = function(row) {
            var code, part, ret, _i, _len, _ref;
            ret = [];
            _ref = this.parts;
            for (_i = 0, _len = _ref.length; _i < _len; _i++) {
                part = _ref[_i];
                if (typeof part === 'string') {
                    ret.push(part);
                } else if (typeof part === 'object' && part.constructor === EmbeddedGetter) {
                    ret.push(part.apply(row));
                }
            }
            code = flatten(ret).join('');
            try {
                return eval(code);
            } catch (e) {
                Log.error("Error Evaluating code: {" + code + "}", e);
                return '';
            }
        };
        return Eval;
    })();
    (typeof exports !== "undefined" && exports !== null ? exports : this).RowParser = RowParser;
    (typeof exports !== "undefined" && exports !== null ? exports : this).flatten = flatten;
}).call(this);
