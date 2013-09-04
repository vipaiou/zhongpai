package com.supertool.dspui.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.param.form.SettingForm;
import com.supertool.dspui.service.SettingService;
import com.supertool.dspui.vo.ResultVO;
import com.supertool.dspui.vo.SettingVO;

@Controller
@RequestMapping("/setting")
public class SettingController {
	
	@Autowired
	private SettingService settingService;
	
	@RequestMapping("/index")
	public String view(Model model) {
		SettingVO settingVO = settingService.getSettingVO();
		model.addAttribute("settingVO", settingVO);
		return "setting/index";
	}
	
	@RequestMapping("/edit")
	public String edit(Model model) {
		SettingVO settingVO = settingService.getSettingVO();
		model.addAttribute("settingVO", settingVO);
		return "setting/edit";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ResultVO update(SettingForm settingForm) {
		return settingService.updateSetting(settingForm);
	}
	
	@RequestMapping("/check")
	public @ResponseBody boolean check(@RequestParam Map<String, String> map){
		return settingService.check(map);
	}
}
 