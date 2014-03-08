package com.supertool.dspui.controller.zhongpai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.service.zhongpai.MessageService;
import com.supertool.dspui.service.zhongpai.TopicService;
import com.supertool.dspui.service.zhongpai.UserService;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;

	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/","index","index/","messages"})
	public String messages(Model model){
		/*List<Map<String,Object>> messages = messageService.getReceived();*/
		List<Map<String,Object>> messages = messageService.getContactor();
		model.addAttribute("messages", messages);
		model.addAttribute("imagehost", Config.getImageHost());
		return "message/messages";
	}

	@RequestMapping(value={"detail"})
	public String dialogue(@RequestParam int with, Model model){
		Object user = userService.getUserById(with);
		model.addAttribute("user", user);
		List<Map<String,Object>> o = messageService.getdialogue(with);
		model.addAttribute("messages", o);
		model.addAttribute("imagehost", Config.getImageHost());
		return "message/detail";
	}

	@RequestMapping(value={"received"})
	public String received(Model model){
		List<Map<String,Object>> messages = messageService.getReceived();
		model.addAttribute("messages", messages);
		model.addAttribute("imagehost", Config.getImageHost());
		return "message/received";
	}

	@RequestMapping(value={"sent"})
	public String sent(Model model){
		List<Map<String,Object>> messages = messageService.getSent();
		model.addAttribute("messages", messages);
		model.addAttribute("imagehost", Config.getImageHost());
		return "message/sent";
	}
}
