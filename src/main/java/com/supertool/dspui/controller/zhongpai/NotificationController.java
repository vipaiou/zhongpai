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
@RequestMapping("/notification")
public class NotificationController {
	
	@RequestMapping(value={"/","index","index/","notread"})
	public String index(){
		return "notification/notread";
	}

	@RequestMapping(value={"read"})
	public String all(){
		return "notification/read";
	}

}
