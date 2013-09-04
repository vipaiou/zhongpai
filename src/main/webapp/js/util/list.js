  var List = function (arr) {
            /// <summary>
            /// 加载数组列表
            /// </summary>
            /// <returns type="List" />
            /// <param name="arr">数组</param>
            return List.fn.Load(arr);
        };
        List.fn = List.prototype = {
            /// <summary>
            /// 加载数组列表
            /// </summary>
            /// <returns type="List" />
            /// <param name="arr">数组</param>
            Load: function (arr) {
                this.length = 0;
                Array.prototype.push.apply(this, arr);
                return this;
            },
            First: function (key, value) {
                return this.Where(key, value)[0];
            },
            /*Where: function (key, value) {
            var arr = [];
            for (i = 0; i < this.length; i++) {
            if (this[i][key] == value)
            arr.push(this[i]);
            }
            return arr;
            },*/
            Where: function (callback) {
                var arr = [];
                for (i = 0; i < this.length; i++) {
                    if (callback.call(this[i],i,this[i])===true)
                        arr.push(this[i]);
                }
                return arr;
            },
            Select: function (key) {
                var arr = [];
                for (i = 0; i < this.length; i++) {
                    arr.push(this[i][key]);
                }
                return arr;
            }
        };