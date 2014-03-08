package com.supertool.dspui.controller.zhongpai;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.model.zhongpai.Project;
import com.supertool.dspui.service.zhongpai.CategoryService;
import com.supertool.dspui.service.zhongpai.FocusService;
import com.supertool.dspui.service.zhongpai.ProjectService;
import com.supertool.dspui.service.zhongpai.ReturnService;
import com.supertool.dspui.service.zhongpai.TopicService;
import com.supertool.dspui.service.zhongpai.UserService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	@Autowired
	ReturnService returnService;
	@Autowired
	TopicService topicService;
	@Autowired
	FocusService focusService;
	@Autowired
	UserService userService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value={"","/"})
	public String list(Model model){
		List<Map<String,Object>> projects = projectService.created();
		model.addAttribute("projects", projects);
		model.addAttribute("imagehost", Config.getImageHost());
		List<Map<String,Object>> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		model.addAttribute("c1", "0");
		model.addAttribute("c2", "0");
		model.addAttribute("c3", "0");
		model.addAttribute("c4", "0");
		return "projects/index";
	}

	@RequestMapping(value={"discover/{c}","discover/{c}/"} )
	public String search(@PathVariable String c, Model model, HttpServletRequest request) throws UnsupportedEncodingException{
		c = new String(c.getBytes("ISO-8859-1"),"UTF-8") ;
		String[] cs = c.split("_");
		List<Map<String,Object>> projects = projectService.search(c);
		model.addAttribute("projects", projects);
		model.addAttribute("imagehost", Config.getImageHost());
		List<Map<String,Object>> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		model.addAttribute("c1", cs[0]);
		model.addAttribute("c2", cs[1]);
		model.addAttribute("c3", cs[2]);
		model.addAttribute("c4", cs[3]);
		return "projects/index";
	}

	@RequestMapping(value={"view/{id}","view/{id}/"})
	public String view(@PathVariable int id, Model model){
		Map<?, ?> project = projectService.selectById(id);
		model.addAttribute("project", project);
		List<Map<String,Object>> returns = returnService.selectByProjectId(id);
		model.addAttribute("returns", returns);
		int topicnum = topicService.getTopicnumByProjectId(id);
		model.addAttribute("topicnum", topicnum);
		
		List<Map<String, Object>> topics = topicService.getTopicByProjectId(id);
		model.addAttribute("topics", topics);
		
		int focusnum = focusService.getFocusnumByProjectId(id);
		model.addAttribute("focusnum", focusnum);
		List<Map<String, Object>> focus = focusService.getFocusByProjectId(id);
		model.addAttribute("focus", focus);
		model.addAttribute("imagehost", Config.getImageHost());
		Map<?,?> createuser = userService.getUserDetailById(project.get("createuser"));
		model.addAttribute("createuser", createuser);
		
		int focused = focusService.checkFocusByUserid(id, UserContext.getLoginUserId());
		model.addAttribute("focused", focused);

		Map<String,String> topicmeta = topicService.getTopicMetaByProjectId(id); 
		model.addAttribute("topicmeta", topicmeta);
		int ratio = 100*focusnum/Integer.parseInt(project.get("targetfocusnum").toString());
		model.addAttribute("focusratio", ratio);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			int preparedays = (int)((new Date().getTime() - df.parse(project.get("begintime").toString().substring(0, 19)).getTime())/1000/60/60/24);
			model.addAttribute("preparedays", preparedays);
		} catch (ParseException e) {
			int preparedays = 0;
			model.addAttribute("preparedays", preparedays);
		}
		projectService.updateViewtime(id);
		return "projects/view";
	}
	
	public static void main(String[] args) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.03");
		System.out.println("yyyy-MM-dd hh:mm:ss.03".substring(0, 19));
		int preparedays = (int)((new Date().getTime() - df.parse("2013-10-01 23:00:00.03").getTime())/1000/60/60/24);
		System.out.println(preparedays);
	}
	/**
	 * 首次编辑基本信息页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"add"})
	public String add(Model model){
		int pid = projectService.add();
		model.addAttribute("projectId", pid);
		List<Map<String,Object>> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		System.out.println(pid);
		return "projects/add";
	}	

	/**
	 * 非首次编辑基本信息页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"edit/{id}","edit/{id}/"})
	public String edit(@PathVariable int id, Model model){
		Map<?, ?> porject = projectService.selectById(id);
		model.addAttribute("project", porject);
		model.addAttribute("projectId", id);
		model.addAttribute("imagehost", Config.getImageHost());
		List<Map<String,Object>> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		return "projects/edit";
	}
	
	/**
	 * 基本信息写入数据库，跳转到编辑回报页面
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"editbasic"}, method=RequestMethod.POST)
	public String editbasic(@RequestParam Map<String, Object> map, Model model){
		projectService.editbasic(map);
		return "projects/editreturn";
	}

	/**
	 * 编辑回报页面
	 * @param map
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"editreturn/{id}","editreturn/{id}/"})
	public String editreturn(@RequestParam Map<String, Object> map, @PathVariable int id, Model model){
		//projectService.create(map);
		Object project = projectService.selectById(id);
		List<Map<String,Object>> returns = returnService.selectByProjectId(id);
		model.addAttribute("project", project);
		model.addAttribute("returns", returns);
		return "projects/editreturn";
	}

	/**
	 * 保存一条回报，ajax请求
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"savereturn"}, method=RequestMethod.POST)
	public String savereturn(@RequestParam Map<String, Object> map, Model model){
		//projectService.create(map);
		Object returnid = returnService.save(map);
		model.addAttribute("returnid", returnid);
		return "projects/editreturn";
	}
	
	/**
	 * 提交审核页面
	 * @param map
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"editstatus/{id}","editstatus/{id}/"})
	public String editstauts(@RequestParam Map<String, Object> map, @PathVariable int id, Model model){
		Object project = projectService.selectById(id);
		model.addAttribute("project", project);
		return "projects/editstatus";
	}

	/**
	 * 提交审核
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"submitaudit"})
	public String submitaudit(@RequestParam Map<String, Object> map, @RequestParam int id, Model model){
		projectService.submitaudit(map);
		model.addAttribute("result", "1");
		Object project = projectService.selectById(id);
		model.addAttribute("project", project);
		return "redirect:editstatus/"+id;//eturn "1";
	}
		
	@RequestMapping(value={"created"})
	public void created(Model model){
		List<Map<String,Object>> projects = projectService.created();
		model.addAttribute("projects", projects);
		model.addAttribute("imagehost", Config.getImageHost());
	}
	
	@RequestMapping(value={"backed"})
	public void backed(Model model){
		List<Map<String,Object>> projects = projectService.supported();
		model.addAttribute("projects", projects);
		model.addAttribute("imagehost", Config.getImageHost());
	}

	@RequestMapping(value={"favorite"})
	public void favorite(Model model){
		List<Map<String,Object>> projects = projectService.favorite();
		model.addAttribute("projects", projects);
		model.addAttribute("imagehost", Config.getImageHost());
	}

	@RequestMapping(value={"{id}/topic/{topicid}","{id}/topic/{topicid}/"})
	public String topic(@PathVariable int id, @PathVariable int topicid, Model model){
		Map<?, ?> project = projectService.selectById(id);
		model.addAttribute("project", project);
		Object topic = topicService.getTopicById(topicid);
		List<Map<String, String>> comments = topicService.getCommentsByTopicid(topicid);
		List<Map<String, Object>> topics = topicService.getTopicByProjectId(id);
		model.addAttribute("topic", topic);
		model.addAttribute("comments", comments);
		model.addAttribute("topics", topics);
		model.addAttribute("imagehost", Config.getImageHost());
		int topicnum = topicService.getTopicnumByProjectId(id);
		model.addAttribute("topicnum", topicnum);
		int focusnum = focusService.getFocusnumByProjectId(id);
		model.addAttribute("focusnum", focusnum);
		return "projects/topic";
	}
	@RequestMapping(value={"{id}/topics/","{id}/topics"})
	public String topics(@PathVariable int id, Model model){
		List<Map<String, Object>> topics = topicService.getTopicByProjectId(id);
		model.addAttribute("topics", topics);
		Map<?, ?> project = projectService.selectById(id);
		model.addAttribute("project", project);
		List<Map<String,Object>> returns = returnService.selectByProjectId(id);
		model.addAttribute("returns", returns);
		int topicnum = topicService.getTopicnumByProjectId(id);
		model.addAttribute("topicnum", topicnum);
		int focusnum = focusService.getFocusnumByProjectId(id);
		model.addAttribute("focusnum", focusnum);
		model.addAttribute("imagehost", Config.getImageHost());
		Map<?,?> createuser = userService.getUserDetailById(project.get("createuser"));
		model.addAttribute("createuser", createuser);

		int focused = focusService.checkFocusByUserid(id, UserContext.getLoginUserId());
		model.addAttribute("focused", focused);
		Map<String,String> topicmeta = topicService.getTopicMetaByProjectId(id); 
		model.addAttribute("topicmeta", topicmeta);
		int ratio = 100*focusnum/Integer.parseInt(project.get("targetfocusnum").toString());
		model.addAttribute("focusratio", ratio);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			int preparedays = (int)((new Date().getTime() - df.parse(project.get("begintime").toString().substring(0, 19)).getTime())/1000/60/60/24);
			model.addAttribute("preparedays", preparedays);
		} catch (ParseException e) {
			int preparedays = 0;
			model.addAttribute("preparedays", preparedays);
		}
		
		return "projects/topics";
	}

	@RequestMapping(value={"focuses/{id}"})
	public String focuses(@PathVariable int id, Model model){
		List<Map<String, Object>> focuses = focusService.getFocusByProjectId(id);
		model.addAttribute("focuses", focuses);		
		Map<?, ?> project = projectService.selectById(id);
		model.addAttribute("project", project);
		List<Map<String,Object>> returns = returnService.selectByProjectId(id);
		model.addAttribute("returns", returns);
		int topicnum = topicService.getTopicnumByProjectId(id);
		model.addAttribute("topicnum", topicnum);
		int focusnum = focusService.getFocusnumByProjectId(id);
		model.addAttribute("focusnum", focusnum);
		List<Map<String, Object>> focus = focusService.getFocusByProjectId(id);
		model.addAttribute("focus", focus);
		model.addAttribute("imagehost", Config.getImageHost());
		Map<?,?> createuser = userService.getUserDetailById(project.get("createuser"));
		model.addAttribute("createuser", createuser);

		int focused = focusService.checkFocusByUserid(id, UserContext.getLoginUserId());
		model.addAttribute("focused", focused);
		Map<String,String> topicmeta = topicService.getTopicMetaByProjectId(id); 
		model.addAttribute("topicmeta", topicmeta);
		int ratio = 100*focusnum/Integer.parseInt(project.get("targetfocusnum").toString());
		model.addAttribute("focusratio", ratio);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			int preparedays = (int)((new Date().getTime() - df.parse(project.get("begintime").toString().substring(0, 19)).getTime())/1000/60/60/24);
			model.addAttribute("preparedays", preparedays);
		} catch (ParseException e) {
			int preparedays = 0;
			model.addAttribute("preparedays", preparedays);
		}
		return "projects/focuses";
	}
	
	@RequestMapping(value={"focus/{id}","focus/{id}/"})
	public String focus(@PathVariable int id, Model model){
		focusService.focus(id, UserContext.getLoginUserId());
		int focuses = focusService.getFocusnumByProjectId(id);
		model.addAttribute("focuses", focuses);
		return "projects/focus";
	}

}
