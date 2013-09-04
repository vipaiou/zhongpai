package com.supertool.dspui.controller.zhongpai.manage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.model.zhongpai.Project;
import com.supertool.dspui.service.zhongpai.ProjectService;
import com.supertool.dspui.service.zhongpai.ReturnService;

@Controller
@RequestMapping("/mamage/projects")
public class ManageProjectController {

	@Autowired
	ProjectService projectService;
	@Autowired
	ReturnService returnService;
	
	@RequestMapping(value={"","/"})
	public String list(Model model){
		List<Map<String,Object>> projects = projectService.created();
		model.addAttribute("projects", projects);
		model.addAttribute("imagehost", Config.getImageHost());
		return "manage/project";
	}
}
