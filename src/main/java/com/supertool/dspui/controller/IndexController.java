package com.supertool.dspui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.mybatis.DspLogicMapper;
import com.supertool.dspui.model.Dsp;
import com.supertool.dspui.model.User;
import com.supertool.dspui.service.zhongpai.CategoryService;
import com.supertool.dspui.service.zhongpai.MessageService;
import com.supertool.dspui.service.zhongpai.ProjectService;
import com.supertool.dspui.service.zhongpai.UserService;

@Controller
public class IndexController {
	@Autowired
	private UserService userService;

	@Autowired
	ProjectService projectService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	MessageService messageService;
	
    @RequestMapping(value = {"/", "", "/index"})
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
    	List<Map<String,Object>> financiongProjects = projectService.selectByStatus("2");
    	List<Map<String,Object>> preparingProjects = projectService.selectByStatus("1");
    	model.addAttribute("financiongProjects", financiongProjects);
    	model.addAttribute("preparingProjects", preparingProjects);
		List<Map<String,Object>> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		model.addAttribute("imagehost", Config.getImageHost());
    	return "index";
    }
    @RequestMapping("/login")
	public  String login(@RequestParam Map<String,Object>p,Model m, HttpServletRequest request, HttpServletResponse response){

		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		String loginStatus = p.get("error")==null?null:p.get("error").toString();
		String note="";
		if("-1".equals(loginStatus)){
			note="连接断开，请重新登录！";
			//System.out.println("note="+loginStatus);
		}

		if("fail".equals(loginStatus)){
			note="密码错误，请重新输入";
			/*String message = p.get("message")==null?"!!!":p.get("message").toString();*/
			m.addAttribute("flag", 1);
		}
		m.addAttribute("msg", note);
		
		return "login";
	}
    @RequestMapping("/logout")
	public   ModelAndView loginout(@RequestParam Map<String,Object>p,HttpServletRequest res){

    	
		return new ModelAndView(new RedirectView(res.getContextPath()+"/j_spring_security_logout"));
	}
    @RequestMapping("/checkuser")
	public @ResponseBody
	Map<String,Object> checkUser(@RequestParam Map<String, Object> p) {
		String username = p.get("username") == null ? null : p.get("username")
				.toString().trim();
		Map<String,Object> m=new HashMap<String,Object>();
		User user= this.userService.findUserByUsername(username);
		/*if(null!=user){
			 Dsp dsp  =  dspLogicMapper.getDspByDspId(user.getDspId());
			 if(dsp.getActive()==0){
				 m.put("active", dsp.getActive());
			  }
			 else{
					m.put("active", null);
			}
		}*/
		m.put("user", user);
		return m;
	}
    @RequestMapping("/messages")
	public @ResponseBody
	Map<String,Object> messages(@RequestParam Map<String, Object> p) {
		Map<String,Object> m=new HashMap<String,Object>();
		messageService.add(p);
		m.put("result", 1);
		return m;
	}
    
}
