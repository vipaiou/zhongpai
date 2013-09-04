package com.supertool.dspui.security;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.framework.session.Session;



@SuppressWarnings("deprecation")
@Controller
public class SecurityValiCode {
   @RequestMapping("/validate")
	public @ResponseBody boolean validate(@RequestParam Map<String, Object> p,Model m){
	 String yanzhengm = p.get("code").toString();
	 String sessionyanz = (String) Session.get("yzkeyword"); 
	 if(yanzhengm.equals(sessionyanz)){
		 return true;
	 }
		return false;
	}
}