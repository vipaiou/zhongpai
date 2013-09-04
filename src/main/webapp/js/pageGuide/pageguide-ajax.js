/**
 * pageguide-ajax tag for browser side (planner.miaozhen.com)
 * @author: zby
*/

/**
 * 接口：
 * 1、pga_initParams(currentPageNo, totalPage) 
 * 	  功能：初始化参数 (若无特殊需求，请不要调用此函数)
 * 2、pga_addJumpToPageBeforeEventHandler(func)
 *    功能：向pageguide-ajax添加一个用户点击事件(before)的回调函数
 *        func函数的原型：func(pageNo), pageNo为发生点击的页码
 * 3、pga_notifyChangePageNoEvent()
 *	  功能：当界面完成翻页之后，由界面通知pageguide-ajax更改页码导航
 * 4、pga_redrawPageGuide(pageNo, totalPage)
 *    功能：重画pageguide-ajax标签
 * 5、pga_clearJumpToPageBeforeEventHandlers()
 *	  功能：清空所有的用户点击事件(before)的事件回调函数
*/

var pga_events = new Array();
var pga_metux = 0;
var pga_currentPageNo, pga_totalPage, pga_tmpPageNo;

// public: 
// 功能：初始化参数
function pga_initParams(currentPageNo, totalPage) {
	if (typeof(currentPageNo) == "string")
		pga_currentPageNo = parseInt(currentPageNo);
	else
		pga_currentPageNo = currentPageNo;
		
	if (typeof(totalPage) == "string")
		pga_totalPage = parseInt(totalPage);
	else
		pga_totalPage = totalPage;
}

// public: 
// 功能：向pageguide-ajax添加一个用户点击事件(before)的回调函数
function pga_addJumpToPageBeforeEventHandler(func) {
	pga_events.push(func);
}

// public:
// 功能：当界面完成翻页之后，由界面通知pageguide-ajax更改页码导航
function pga_notifyChangePageNoEvent() {
	if (pga_metux == 0)
		return;
		
	pga_currentPageNo = pga_tmpPageNo;
	pga_updatePageGuide(pga_currentPageNo);
	pga_metux = 0;
}

// public:
// 功能：重画pageguide-ajax标签
function pga_redrawPageGuide(pageNo, totalPage) {
	pga_initParams(pageNo, totalPage);
	pga_updatePageGuide(pageNo);
}

// public:
// 功能：清空所有的用户点击事件(before)的事件回调函数
function pga_clearJumpToPageBeforeEventHandlers() {
	pga_events = new Array();
}

// private:
function pga_updatePageGuide(pageNo) {
	var pga = document.getElementById('pageFlip');
	
	var content = totalPages;
	if (pageNo == 1)
		content = content + "<span class = 'page' >"+homePage +"</span>" + "<span class = 'page'>"+upPage+"</span>";
	else
		content += pga_produceUrlTag(1, homePage) + " "
				+ pga_produceUrlTag(pageNo - 1, upPage) + " ";
	
	var lpn, rpn;
	if (pga_currentPageNo >= 10 && pga_currentPageNo <= pga_totalPage - 9) {
		//lpn = (pga_currentPageNo - 5 <= 1 ? 1 : pga_currentPageNo - 5);
		lpn = pga_currentPageNo - 5;
		rpn = (lpn + 9 > pga_totalPage ? pga_totalPage : lpn + 9);
	} else if (pga_currentPageNo <= 9) {
		lpn = 1;
		rpn = pga_totalPage > 10 ? 10 : pga_totalPage;
	} else {
		lpn = pga_totalPage - 9 > 0 ? pga_totalPage - 9 : 1;
		rpn = pga_totalPage;
	}
	
	if (lpn > 1) {
		content += "... ";
	}
	
	content += "<em>";
	for (var i = lpn; i <= rpn; ++i) {
		if (i == pga_currentPageNo) {
			content += (i + " ");
		} else {
			content += pga_produceUrlTag(i, i) + " ";
		}
	}
	content += "</em>";
	if (rpn < pga_totalPage) {
		content += "... ";
	}
	
	if (pga_currentPageNo >= pga_totalPage) {
		content = content + "<span class='page'>"+downPage+"</span>" + "<span class = 'page'>"+lastPage +"</span>";
	} else {
		content += pga_produceUrlTag(pga_currentPageNo + 1, downPage) + " " +
					pga_produceUrlTag(pga_totalPage, lastPage)
	}
	
	pga.innerHTML = content;
}

// private:
function pga_triggerJumpToPageEvent(pageNo) {
	if (pga_metux == 1) 
		return;
	pga_metux = 1;
	pga_tmpPageNo = pageNo;
	
	if (pga_events.length == 0) {
		pga_notifyChangePageNoEvent();
		return;
	}
	
	for (var i = 0; i < pga_events.length; ++i) {
		pga_events[i](pageNo);
	}
}

// private:
function pga_produceUrlTag(pageNo, urlText) {
	if (pageNo == pga_currentPageNo)
		return urlText;
	return "<a href=\"#\" onclick=\"pga_triggerJumpToPageEvent(" + 
		pageNo + ");\">" + urlText + "</a>";
}