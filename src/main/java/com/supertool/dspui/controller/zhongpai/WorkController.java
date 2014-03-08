package com.supertool.dspui.controller.zhongpai;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.service.zhongpai.ActivityService;
import com.supertool.dspui.service.zhongpai.ProjectService;

@Controller
@RequestMapping("/work")
public class WorkController {
	
	@Autowired
	ProjectService projectService;
	@RequestMapping(value={"view/{id}", "view/{id}/"})
	public String add(@RequestParam Map<String, Object> map, @PathVariable int id, Model model){
		
		Object o = projectService.selectById(id);
		model.addAttribute("imagehost", Config.getImageHost());
		model.addAttribute("project", o);
		return "work/view";
	}
}
