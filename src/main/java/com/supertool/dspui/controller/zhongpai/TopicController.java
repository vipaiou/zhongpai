package com.supertool.dspui.controller.zhongpai;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String index(){
		return "topic/focused";
	}

	@RequestMapping(value={"created"})
	public String created(){
		return "topic/created";
	}

	@RequestMapping(value={"commented"})
	public String commented(){
		return "topic/commented";
	}
}
