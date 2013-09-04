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
@RequestMapping("/transaction")
public class TransactionController {
	
	@RequestMapping(value={"/","index","index/","support"})
	public String support(){
		return "transaction/support";
	}

	@RequestMapping(value={"credit"})
	public String credit(){
		return "transaction/credit";
	}

	@RequestMapping(value={"recharge"})
	public String recharge(){
		return "transaction/recharge";
	}

}
