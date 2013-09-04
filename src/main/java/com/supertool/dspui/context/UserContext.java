package com.supertool.dspui.context;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.supertool.dspui.model.User;
import com.supertool.dspui.security.UserDetailsImpl;

public class UserContext {
	
	/**
	 * 获取登陆用户
	 * @return
	 */
	public static User getLoginUser(){
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		if (auth!=null&&auth.getPrincipal() instanceof UserDetails) {
			UserDetailsImpl ud=(UserDetailsImpl)auth.getPrincipal();
			User user = ud.getUser();
			if(user != null && user instanceof User){
				return user;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	/**
	 * 获取登陆用户ID
	 * @return
	 */
	public static int getLoginUserId(){
		User user = getLoginUser();
		if(user != null){
			return user.getUserId();
		}else{
			return 0;
		}
	}
	/**
	 * 获取登陆用户DspID
	 * @return
	 */
	public static Integer getDspId(){
		User user = getLoginUser();
		if(user != null){
			return user.getDspId();
		}else{
			return 0;
		}
	}
}
