package com.supertool.dspui.controller.zhongpai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.service.zhongpai.TopicService;

@Controller
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@RequestMapping(value="add")
	public @ResponseBody Object add(@RequestParam Map<String,Object> map){
		Object id = topicService.add(map);
		return map;
	}
	
	@RequestMapping(value={"/","index","index/","focused"})
	public String index(Model model){
		List<Map<String,Object>> topices = topicService.getFocusedTopicByUserId();
		model.addAttribute("topices", topices);
		return "topic/focused";
	}

	@RequestMapping(value={"created"})
	public String created(Model model){
		List<Map<String,Object>> topices = topicService.getCreatedTopicByUserId();
		model.addAttribute("topices", topices);
		return "topic/created";
	}

	@RequestMapping(value={"commented"})
	public String commented(Model model){
		List<Map<String,Object>> topices = topicService.getCommentedTopicByUserId();
		model.addAttribute("topices", topices);
		return "topic/commented";
	}
	

	@RequestMapping(value="addcomment")
	public @ResponseBody Object addcomment(@RequestParam Map<String,Object> map){
		Object id = topicService.addcomment(map);
		return map;
	}
}
