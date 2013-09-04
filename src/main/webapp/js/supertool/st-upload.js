var uploader = (function(){
    var _uploader = function(option){
        this.url = option.url;
        this.name = option.name || 'upload';
        this.holder = option.holder;
        this.param = option.param || {};
        this.fun = option.fun || function(){};
        this.fileBlurEvent = option.blurEvent || function(){};
        this.dataType = option.dataType || 'text';
        option.beforeUpload && (this.beforeUpload = option.beforeUpload);
    };
    _uploader.prototype.init = function(){
        var form = '<form action="' + this.url + '" method="post" enctype="multipart/form-data">'
                            + '<div class="file-upload">'
                            +   '<input type="text" name="filePath" readonly="readonly"/>'
                            +   '<span class="upload-span">'
                            +   '<input hideFocus="true" class="upload-file" type="file" name="' + this.name + '" size="1"/>'
                            +   '<div class="upload-div">' + uploader.browse + '</div>'
                            +   '</span>'
                            +   '<span style="margin-left:75px;"></span>'
                            +   '<span hideFocus="true" class="upload-button"><div style="width:50px;">' + uploader.upload + '</div></span>'
                            +   '</div>'
                            +   '</form>';
        this.holder.html(form);
        this.holder.addClass('upload-holder');
        this.addEvent();
    };
    _uploader.prototype.blurEvent = function(){
        this.fileBlurEvent();
    };
    _uploader.prototype.addEvent = function(){
        var that = this,
        form = this.form = this.holder.find('form').first(),
        file = this.file = form.find('.upload-file'),
        filePath = this.filePath = form.find('input[name="filePath"]'),
        button = form.find('.upload-button');
        file.change(function(){
            filePath.val(this.value);
        });
        filePath.blur(this.fileBlurEvent);
        button.click(function(){
            if(filePath.val() == '') return false;
            if(that.beforeUpload()){
                that.uploadFile();
            }
        });
    };
    _uploader.prototype.uploadFile = function(){
        var that = this;
        this.form.ajaxSubmit({
            dataType : this.dataType,
            data : this.param,
            context : this,
            success : that.fun
            });
    };
    _uploader.prototype.beforeUpload = function(){
        return true;
    };
    _uploader.prototype.getVal = function(){
        return this.file.val();
    };
    var __uploader = function(option){
        var _this = new _uploader(option);
        this.init = function(){
            _this.init();
        };
        this.getVal = function(){
            return _this.getVal();
        };
    };
    return __uploader;
})();
