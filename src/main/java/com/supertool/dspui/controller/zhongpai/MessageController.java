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
@RequestMapping("/message")
public class MessageController {
	
	@RequestMapping(value={"/","index","index/","messages"})
	public String messages(){
		return "message/messages";
	}

	@RequestMapping(value={"detail"})
	public String detail(){
		return "message/detail";
	}

}
