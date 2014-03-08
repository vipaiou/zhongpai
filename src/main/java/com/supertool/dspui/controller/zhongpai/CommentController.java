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

import com.supertool.dspui.config.Config;
import com.supertool.dspui.service.zhongpai.CommentService;
import com.supertool.dspui.service.zhongpai.TopicService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value={"/","index","index/","received",""})
	public String received(Model model){
		List<Map<String, Object>> comments = commentService.getReceived();
		model.addAttribute("comments", comments);
		model.addAttribute("imagehost", Config.getImageHost());
		return "comment/received";
	}

	@RequestMapping(value={"sent"})
	public String sent(Model model){
		List<Map<String, Object>> comments = commentService.getSent();
		model.addAttribute("comments", comments);
		model.addAttribute("imagehost", Config.getImageHost());
		return "comment/sent";
	}
	
	@RequestMapping(value="addcomment")
	public @ResponseBody Object addcomment(@RequestParam Map<String,Object> map){
		Object id = commentService.addcomment(map);
		return map;
	}
}
