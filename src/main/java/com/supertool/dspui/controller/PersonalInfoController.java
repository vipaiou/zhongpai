package com.supertool.dspui.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.param.form.PasswordForm;
import com.supertool.dspui.param.form.PersonalInfoForm;
import com.supertool.dspui.service.PersonalInfoService;
import com.supertool.dspui.vo.PersonalInfoVO;
import com.supertool.dspui.vo.ResultVO;

@Controller
@RequestMapping("/personalinfo")
public class PersonalInfoController {

	@Autowired
	private PersonalInfoService personalInfoService;
	
	@RequestMapping("/index")
	public String view(Model model) {
		PersonalInfoVO personalInfoVO = personalInfoService.getPersonalInfoVO();
		model.addAttribute("personalInfoVO", personalInfoVO);
		return "personalInfo/index";
	}
	
	@RequestMapping("/edit")
	public String edit(Model model) {
		PersonalInfoVO personalInfoVO = personalInfoService.getPersonalInfoVO();
		model.addAttribute("personalInfoVO", personalInfoVO);
		return "personalInfo/edit";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ResultVO update(PersonalInfoForm personalInfoForm) {
		return personalInfoService.updatePersonalInfo(personalInfoForm);
	}
	
	@RequestMapping("/editpwd")
	public String editpwd(Model model) {
		String username = UserContext.getLoginUser().getUsername();
		model.addAttribute("username", username);
		return "personalInfo/editpwd";
	}
	@RequestMapping("/viewuserlogin")
	public String viewpwd(Model model) {
		String username = UserContext.getLoginUser().getUsername();
		model.addAttribute("username", username);
		return "personalInfo/viewlogininfo";
	}
	
	@RequestMapping("/updatepwd")
	@ResponseBody
	public ResultVO updatepwd(PasswordForm passwordForm) {
		return personalInfoService.updatePassword(passwordForm);
	}
	
	@RequestMapping("/check")
	public @ResponseBody boolean check(@RequestParam Map<String, String> map){
		return personalInfoService.check(map);
	}
}
