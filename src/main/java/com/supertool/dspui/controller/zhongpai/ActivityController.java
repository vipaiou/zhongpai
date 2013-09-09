package com.supertool.dspui.controller.zhongpai;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.supertool.dspui.service.zhongpai.ActivityService;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	ActivityService activityService;
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(@RequestParam Map<String, Object> map, Model model){
		
		activityService.add(map);
		model.addAttribute("result", 1);
		return "redirect:/user/home";
	}
}
