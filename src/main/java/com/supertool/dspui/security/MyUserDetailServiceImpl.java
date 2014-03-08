package com.supertool.dspui.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.supertool.dspui.dao.mybatis.DspLogicMapper;
import com.supertool.dspui.model.Authority;
import com.supertool.dspui.model.Dsp;
import com.supertool.dspui.model.User;
import com.supertool.dspui.service.zhongpai.UserService;
import com.supertool.dspui.util.SpringMessageSource;


@SuppressWarnings("deprecation")
@Service
public class MyUserDetailServiceImpl implements UserDetailsService {  
 	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DspLogicMapper dspLogicMapper;

	 MessageSourceAccessor messages = SpringMessageSource.getAccessor(); 
	 private static Logger logger = LoggerFactory
				.getLogger(MyUserDetailServiceImpl.class);

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  
		 UserDetails userdetail=null;
		 if(null==username||"".equals(username)){
				throw new UsernameNotFoundException(  
	                    messages.getMessage("USER_NAME_NOT_NULL"),username);
			}
		logger.debug("Try logging to dspui with User[" + username + "]");
		 User user = this.userService.findUserByUsername(username);
		 if(null==user){  
			 logger.debug("No User [" + username + "] found"); 
	        	throw new UsernameNotFoundException(  
	                    messages.getMessage("USER_NAME_NOT_FOUND"),username);
	        	            
	      } 
		

        if("1".equals(user.getIsFreezed())){
        	 logger.debug("User account is freezed [" + username + "] found"); 
        	throw new UsernameNotFoundException(  
                    messages.getMessage("USER_NAME_ISFREEZED"),username);
        }
	  /*  Dsp dsp  =  dspLogicMapper.getDspByDspId(user.getDspId());
	    if(dsp.getActive()==0){
	    	throw new UsernameNotFoundException(  
                    messages.getMessage("HAS_NO_AUTHORITY"),username);
	    }*/
        Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);  
          
        boolean enables = true;  
        boolean accountNonExpired = true;  
        boolean credentialsNonExpired = true;  
        boolean accountNonLocked = true;  
        List<List<Authority>> userAuthoritys= null;//this.userService.getGroupedAuthoritysByUser(user);
        //System.out.println("loadUserByUsername="+userAuthoritys.size());
        userdetail = new UserDetailsImpl(user.getUsername(), user.getPassword(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths,userAuthoritys,user);
        user.setLoginCount(user.getLoginCount() + 1);
        userService.updateLoginInfo(user);
        logger.info("User [" + username
				+ "] is successfully authenticated");
		return userdetail; 
    }  
      
    //取得用户的权限  
    private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {  
        Set<GrantedAuthority> authSet = null;  
       
        List<Authority> authorities=this.userService.getUserAuthoritysForSecurity(user);
        if(null!=authorities&&authorities.size()>0){
          	authSet = new HashSet<GrantedAuthority>();
          	for(Authority auth : authorities) {  
                 authSet.add(new GrantedAuthorityImpl(auth.getName()));  
          	}
        }  
       return authSet;  
   
    }  
}  