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
@RequestMapping("/comment")
public class CommentController {
	
	@RequestMapping(value={"/","index","index/","received",""})
	public String received(){
		return "comment/received";
	}

	@RequestMapping(value={"sent"})
	public String all(){
		return "comment/sent";
	}

}
