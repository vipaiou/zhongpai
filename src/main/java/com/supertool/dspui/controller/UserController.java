package com.supertool.dspui.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.model.Authority;
import com.supertool.dspui.model.Media;
import com.supertool.dspui.model.User;
import com.supertool.dspui.security.UserDetailsImpl;
import com.supertool.dspui.service.zhongpai.UserService;
import com.supertool.dspui.util.ParamValidateUtils;
import com.supertool.dspui.util.SHAEncrypter;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.Utils;
import com.supertool.dspui.vo.PagedResultVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/userlist*")
	public @ResponseBody
	PagedResultVO getUserList(@RequestParam Map<String, Object> p) {
		int pageNo = 1;
		String pageStr = p.get("page") == null ? null : p.get("page")
				.toString();
		String searchColumn = p.get("searchColumn") == null ? null : p.get(
				"searchColumn").toString();
		String searchKey = p.get("searchKey") == null ? null : p.get(
				"searchKey").toString();
		String rowsStr = p.get("rows") == null ? null : p.get("rows")
				.toString();
		String sidx = p.get("sidx") == null ? null : p.get("sidx").toString();
		String sord = p.get("sord") == null ? null : p.get("sord").toString();
		// System.out.println("controller--->searchKey="+searchKey);
		if (pageStr != null && StringUtil.isNumber(pageStr)) {
			pageNo = Integer.parseInt(pageStr);
		} else {
			pageNo = 1;
		}
		int pageSize = Constant.PAGESIZE;
		if (rowsStr != null && StringUtil.isNumber(rowsStr)) {
			pageSize = Integer.parseInt(rowsStr);
		}
		
		if (sidx == null || sidx.equals("")) {
			sidx = "userId";
			sord = "asc";
		}

		List<User> userList = this.userService.getPageUserList(pageNo,
				pageSize, sidx, sord, searchColumn, searchKey, false);
		int totalCount = this.userService.getUserTotalCount(searchColumn,
				searchKey, false);

		Integer totalPage = Utils.getTotalPage(totalCount, pageSize);
		/*
		 * System.out.println("totalPage="+totalPage);
		 * System.out.println("pageSize="+pageSize);
		 */
		/*Map<String, Object> json = new HashMap<String, Object>();
		json.put("userlist", userList);
		json.put("totalPage", totalPage);
		json.put("currentPage", pageNo);
		json.put("totalCount", totalCount);*/
		PagedResultVO vo=new PagedResultVO();
		vo.setDatas(userList);
		vo.setCurrentPage(pageNo);
		vo.setTotalPage(totalPage);
		vo.setTotalCount(totalCount);
		return vo;

	}
	@RequestMapping("/user/register")//
	public String register(@RequestParam Map<String, Object> p,Model model) {
		String username = p.get("username") == null ? null : p.get("username")
				.toString();
		String password = p.get("password") == null ? null : p.get("password")
				.toString();
		String email = p.get("email") == null ? null : p.get(
				"email").toString();
		Integer selectAll = -1;
		System.out.println("email="+email);
		System.out.println("selectAll=" + selectAll);
		System.out.println("password=" + password);
		User user = null;
		if (null == username || null == password || null == email) {
			model.addAttribute("result", -1);
		} else {	
			user = new User();
			user.setUsername(username);
			user.setPassword(SHAEncrypter.getInstance().encrypt(password));
			user.setEmail(email);
			user.setCreateDate(new Date());
			int result = userService.register(user);
			if(result == 1){
				return "redirect:/login";
			}else{
				model.addAttribute("result", result);
			}
		}
		return "redirect:/register";
	}


	@RequestMapping("/user/adduser")//
	public @ResponseBody boolean addUser(@RequestParam(value = "permissionList", required = true) List<String> permissionList,@RequestParam(value = "mediaIds", required = true) List<String> mediaIdsStr,@RequestParam Map<String, Object> p) {
		String username = p.get("username") == null ? null : p.get("username")
				.toString();
		String password = p.get("password") == null ? null : p.get("password")
				.toString();
		String isFreezed = p.get("isFreezed") == null ? null : p.get(
				"isFreezed").toString();
		String isAllSelect = p.get("isAllSelect") == null ? null : p.get(
				"isAllSelect").toString();
		Integer selectAll = -1;
		if (!StringUtil.isBlank(isAllSelect)
				&& StringUtil.isNumber(isAllSelect)) {
			selectAll = Integer.parseInt(isAllSelect);
		}
		System.out.println("isFreezed="+isFreezed);
		System.out.println("selectAll=" + selectAll);
		System.out.println("password=" + password);
		User user = null;
		if (null == username || null == password || null == isFreezed) {
			return false;
		} else {	
			SecurityContext ctx = SecurityContextHolder.getContext();
			Authentication auth = ctx.getAuthentication();
			User loginUser = null;
			if (auth!=null&&auth.getPrincipal() instanceof UserDetails) {
				
				UserDetailsImpl ud=(UserDetailsImpl)auth.getPrincipal();
				loginUser=ud.getUser();
				if(null!=loginUser){
					user = new User();
					user.setUsername(username);
					user.setPassword(SHAEncrypter.getInstance().encrypt(password));
					user.setIsFreezed(isFreezed);
					user.setCreateDate(new Date());
					user.setCreateUser(loginUser.getUserId());
					List<Integer> mediaIds = null;
					if (null != mediaIdsStr && mediaIdsStr.size() > 0) {
						mediaIds = new LinkedList<Integer>();
						for (String mediaIdStr : mediaIdsStr) {
							if (StringUtil.isNumber(mediaIdStr)) {
								mediaIds.add(Integer.parseInt(mediaIdStr));
							}
						}
					}
					//System.out.println("addduser");
					return userService.createUser(user, permissionList, mediaIds,selectAll);
					//return true ;
				}
			}
			return false;
		}

	}

	@RequestMapping("/user/viewuser")
	public String viewUser(@RequestParam Map<String, Object> p, Model m) {
		String userIdStr = p.get("userId") == null ? null : p.get("userId")
				.toString();
		String usernameStr = p.get("username") == null ? null : p.get(
				"username").toString();
		User user = null;
		List<List<Authority>> userAuthoritys = null;
		// 当userId有效时，表名是从用户列表点击的查看
		if (StringUtil.isNumber(userIdStr)) {
			Integer userId = Integer.parseInt(userIdStr);
			user = this.userService.findUserById(userId);
			if (null != user) {
				userAuthoritys = this.userService
						.getGroupedAuthoritysByUser(user);
			}
		}
		// 当username有效时，表名是新建用户的查看
		if (null == user && !StringUtil.isBlank(usernameStr)) {
			user = this.userService.findUserByUsername(usernameStr);
			if (null != user) {

					userAuthoritys = this.userService
							.getGroupedAuthoritysByUser(user);						
			}
		}
		
		m.addAttribute("user", user);
		m.addAttribute("userAuthoritys", userAuthoritys);
		return "/user/viewUser";
	}

	@RequestMapping("/user/edituser")
	public String editUser(@RequestParam Map<String, Object> p, Model m) {
		String userIdStr = p.get("userId") == null ? null : p.get("userId")
				.toString();
		User user = null;
		List<List<Authority>> userAuthoritys = null;
		List<Media> userMedias = null;
		List<Media> medias = null;
		List<List<Authority>> authoritys = null;
		if (StringUtil.isNumber(userIdStr)) {
			Integer userId = Integer.parseInt(userIdStr);
			user = this.userService.findUserById(userId);
			if (null != user) {

				authoritys = this.userService.getGroupedAuthoritys();

				userAuthoritys = this.userService
						.getGroupedAuthoritysByUser(user);

			}
		}
		Set<Authority> set1=null,set2=null;
		if(null!=authoritys&&authoritys.size()>0){
			set1=new HashSet<Authority>();
			for(List<Authority> auths:authoritys){
				for(Authority a:auths){
					set1.add(a);
				}
			}
		}
		if(null!=userAuthoritys&&userAuthoritys.size()>0){
			 set2=new HashSet<Authority>();
			for(List<Authority> auths:userAuthoritys){
				for(Authority a:auths){
					set2.add(a);
				}
			}
		}
		String all="0";
		if(null!=set1&&null!=set2){
			all=set1.size()==set2.size()?"1":"0";
		}else{
			all="0";
		}
		m.addAttribute("user", user);
		m.addAttribute("userAuthoritys", userAuthoritys);
		m.addAttribute("authoritys", authoritys);
		m.addAttribute("medias", medias);
		m.addAttribute("userMedias", userMedias);
		m.addAttribute("all", all);
		return "/user/modifyUser";
	}

	@RequestMapping("/user/modifyuser")
	public @ResponseBody
	boolean modifyUser(
			@RequestParam(value = "updateAuths", required = true) List<String> authsUpdate,
			@RequestParam(value = "updateMediaIds", required = true) List<String> updateMediaIdsStr,
			@RequestParam Map<String, Object> p) {
		String userIdStr=p.get("userId") == null ? null : p.get("userId")
				.toString();
		String username=p.get("username") == null ? null : p.get("username")
				.toString();
		String isFreezed = p.get("isFreezed") == null ? null : p.get(
				"isFreezed").toString();
		String isAllSelect = p.get("isAllSelect") == null ? null : p.get(
				"isAllSelect").toString();
		Integer selectAll = -1;
		
		/*System.out.println("....................");
		System.out.println("userIdStr=" + userIdStr);
		System.out.println("isFreezed=" + isFreezed);
		System.out.println("isAllSelect=" + selectAll);*/
//		if (null != authsUpdate) {
//			for (int j = 0; j < authsUpdate.size(); j++) {
//				System.out.println("authsBeforeUpdate[" + j + "]="
//						+ authsUpdate.get(j));
//			}
//		} else {
//			System.out.println("authsUpdate==null");
//		}
//		if (null != updateMediaIdsStr) {
//			for (int i = 0; i < updateMediaIdsStr.size(); i++) {
//				System.out.println("updateMediaIdsStr[" + i + "]="
//						+ updateMediaIdsStr.get(i));
//			}
//		} else {
//			System.out.println("authsBeforeUpdate==null");
//		}

		if (StringUtil.isNumber(userIdStr)&&!StringUtil.isBlank(isFreezed)&&!StringUtil.isBlank(isAllSelect)
				&& StringUtil.isNumber(isAllSelect)){			
			selectAll = Integer.parseInt(isAllSelect);
			Integer userId=null;
			userId=Integer.parseInt(userIdStr);
			User findUser= this.userService.findUserById(userId);
			findUser.setUsername(username);
			findUser.setIsFreezed(isFreezed);
			SecurityContext ctx = SecurityContextHolder.getContext();
			Authentication auth = ctx.getAuthentication();
			User loginUser = null;
			if (auth.getPrincipal() instanceof UserDetails) {
				UserDetailsImpl ud=(UserDetailsImpl)auth.getPrincipal();
				loginUser=ud.getUser();
				if(null!=loginUser){
					findUser.setUpdateDate(new Date());
					findUser.setUpdateUser(loginUser.getUserId());
					return userService.modifyUser(findUser,authsUpdate,updateMediaIdsStr,selectAll);
				}
			}
		}
		return false;
	}

	
	@RequestMapping("/user/uniqueuser")
	public @ResponseBody
	boolean uniqueUser(@RequestParam Map<String, Object> p) {
		String username = p.get("username") == null ? null : p.get("username")
				.toString().trim();
		String modifyUsername = p.get("modifyUsername") == null ? null : p.get("modifyUsername")
				.toString().trim();
		System.out.println("modifyUsername="+modifyUsername);
		System.out.println("username="+username);
		if(username.equals(modifyUsername)){
			return true;
		}
		return !this.userService.isUsernameExists(username);
	}
	@RequestMapping("/user/test")
	public @ResponseBody
	int validate(@RequestParam Map<String, Object> p) {
		String username = p.get("username") == null ? null : p.get("username")
				.toString().trim();
		String modifyUsername = p.get("modifyUsername") == null ? null : p.get("modifyUsername")
				.toString().trim();
		System.out.println("modifyUsername="+modifyUsername);
		System.out.println("username="+username);
		User u=this.userService.findUserByUsername(username);
		int r=2;
		if(null==u){
			r= 0;
		}else if("1".equals(u.getIsFreezed())){
			r= 1;
		}
		System.out.println("r="+r);
		return r;
	}
	@RequestMapping("/user/resetpassword")
	public @ResponseBody
	Map<String,Object> resetPassword(@RequestParam Map<String, Object> p) {

		String username = p.get("username") == null ? null : p.get("username")
				.toString();
		String newPassword = p.get("newPassword") == null ? null : p.get("newPassword")
				.toString();
		String repeatNewPassword = p.get("repeatPassword") == null ? null : p.get("repeatPassword")
				.toString();
		String msg = "";
		Map<String, Object> m = new HashMap<String, Object>();
		if(!StringUtil.isBlank(username)){
			if (ParamValidateUtils.checkPassword(newPassword)
					&& ParamValidateUtils.checkPassword(repeatNewPassword)){				
				if (ParamValidateUtils.checkRepeatPassword(newPassword, repeatNewPassword)) {
		
					 User user =null;
					 user=this.userService.findUserByUsername(username);
					 
					if (null!=user) {
							SecurityContext ctx = SecurityContextHolder.getContext();
							Authentication auth = ctx.getAuthentication();
							
							User loginUser = null;
							if (auth.getPrincipal() instanceof UserDetails) {
								UserDetailsImpl ud=(UserDetailsImpl)auth.getPrincipal();
								//System.out.println("---->loginUser="+ud.getUser().getUsername());						
								loginUser = ud.getUser();	
								if (null != loginUser) {
									user.setUpdateUser(loginUser.getUserId());
									user.setPassword(SHAEncrypter.getInstance().encrypt(newPassword));
									user.setUpdateDate(new Date());
									if (this.userService.update(user) > 0) {
										msg="密码重置成功!";
										//return true;
									}
										
									}
								}else{
									msg="系统错误!";
							}
						}else{
							msg="该用户不存在!";
						}
					}else{
						msg="两次输入的密码不一致！";
					}
			}else{
				msg="密码格式有误！";
			}
		}else{
			msg="参数传递错误!";
		}
		m.put("msg",msg);
		return m;
	}
	@RequestMapping(value = "/user/checkoldpassword")
	public @ResponseBody Map<String,Object> checkOldPassword(@RequestParam Map<String,Object>p){
		String userIdStr = p.get("userId") == null ? null : p.get("userId")
				.toString();
		String oldPass = p.get("oldPassword")==null?null:p.get("oldPassword").toString();
		String msg="";
		Map<String, Object> m = new HashMap<String, Object>();
		if(StringUtil.isNumber(userIdStr)){
			if(ParamValidateUtils.checkPassword(oldPass)){
				User user=this.userService.findUserById(Integer.parseInt(userIdStr));
				if(null!=user){
					if(!SHAEncrypter.getInstance().encrypt(oldPass).equals(user.getPassword())){
						msg="原密码错误!";					
					}
				}else{
					msg="系统错误!";
				}
			}else{
				msg="密码格式不正确!";
			}
				
		}
		m.put("msg", msg);
		return m;
	}
	@RequestMapping("/user/changepassword")
	public @ResponseBody
	Map<String,Object> changePassword(@RequestParam Map<String, Object> p) {

		String oldPass = p.get("oldPassword")==null?null:p.get("oldPassword").toString(),
				newPass = p.get("newPassword")==null?null:p.get("newPassword").toString(), 
				repeatPass = p.get("repeatPassword")==null?null: p.get("repeatPassword").toString();
		String userIdStr = p.get("userId")==null?null:p.get("userId").toString();
		System.out.println("userIdStr="+userIdStr);
		String msg = "";
		Map<String, Object> m = new HashMap<String, Object>();
		if (ParamValidateUtils.checkPassword(newPass)
				&& ParamValidateUtils.checkPassword(oldPass)
				&& ParamValidateUtils.checkPassword(repeatPass)) {
			
			if (ParamValidateUtils.checkRepeatPassword(newPass, repeatPass)) {
				//System.out.println("------");
				if(StringUtil.isNumber(userIdStr)){
					User user=this.userService.findUserById(Integer.parseInt(userIdStr));
					if(null!=user){
						msg = userService.changePassword(user.getUserId(), oldPass, newPass,
						repeatPass);
					}else{
						msg="未查寻到此用户!";
					}
				}
			} else {
				msg = "两次输入的密码不一致";
			}
		}else{
			msg = "您输入的密码格式不正确";
		}
		m.put("msg", msg);
		return m;
	}

}
