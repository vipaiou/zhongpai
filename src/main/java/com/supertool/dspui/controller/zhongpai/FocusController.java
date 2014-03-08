package com.supertool.dspui.controller.zhongpai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.service.zhongpai.FocusService;

public class FocusController {

	@Autowired
	FocusService focusService;
	
	@RequestMapping(value={"focus/{id}","focus/{id}/"})
	public @ResponseBody int focus(@PathVariable int id, Model model){
		focusService.focus(id, UserContext.getLoginUserId());
		int focuses = focusService.getFocusnumByProjectId(id);
		return focuses;
	}
}
