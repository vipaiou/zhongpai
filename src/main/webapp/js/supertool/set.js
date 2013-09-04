(function() {
  var Set;
  Set = (function() {
    function Set() {
      this.data = {};
    }
    Set.prototype.add = function(k) {
      return this.data[k] = true;
    };
    Set.prototype.remove = function(k) {
      return delete this.data[k];
    };
    Set.prototype.toNumberList = function() {
      var k, v, _ref, _results;
      _ref = this.data;
      _results = [];
      for (k in _ref) {
        v = _ref[k];
        _results.push(Number(k));
      }
      return _results;
    };
    Set.prototype.toList = function() {
      var k, v, _ref, _results;
      _ref = this.data;
      _results = [];
      for (k in _ref) {
        v = _ref[k];
        _results.push(k);
      }
      return _results;
    };
    Set.prototype.fill = function(list) {
      var k, _i, _len, _results;
      _results = [];
      for (_i = 0, _len = list.length; _i < _len; _i++) {
        k = list[_i];
        _results.push(this.add(k));
      }
      return _results;
    };
    Set.prototype.removeAll = function() {
      this.data = null;
      return this.data = {};
    };
    Set.prototype.getAll = function() {
      return this.toList();
    };
    Set.prototype.isEmpty = function() {
      var k, v, _ref;
      _ref = this.data;
      for (k in _ref) {
        v = _ref[k];
        return false;
      }
      return true;
    };
    Set.prototype.size = function() {
      var k, n, v, _ref;
      n = 0;
      _ref = this.data;
      for (k in _ref) {
        v = _ref[k];
        n++;
      }
      return n;
    };
    Set.prototype.contains = function(k) {
      if (k in this.data) {
        return true;
      } else {
        return false;
      }
    };
    return Set;
  })();
  (typeof exports !== "undefined" && exports !== null ? exports : this).Set = Set;
}).call(this);
