var dialog = $('<div style="display:none"></div>').appendTo('body');
function showDialog(url, title, width, height) {
  // load remote content
  dialog.load(
    url,
    function () {
      var params = {width: 800, height: 500};
      if (title !== undefined) {
        params.title = title;
      }
	  if (width !== undefined) {
		  params.width = width;
	  }
	  if (height !== undefined) {
		  params.height = height;
	  }
      dialog.dialog(params);
      dialog.parents('div.ui-dialog').show();
      dialog.find('input.btDefault,input.btOk').unbind().click(function() {
        dialog.parents('div.ui-dialog').hide();
      });
    }
  );
}

function closeDialog() {
  $('div.ui-dialog', parent.document).empty().hide();
}

