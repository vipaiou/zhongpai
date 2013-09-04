package com.supertool.dspui.security;

import java.util.Collection;
import java.util.Iterator;


import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.supertool.dspui.util.SpringMessageSource;


public class MyAccessDecisionManager implements AccessDecisionManager {  
	MessageSourceAccessor messages = SpringMessageSource.getAccessor(); 
	
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {  
    	if(configAttributes == null||configAttributes.size()==0) {  
    		//System.out.println("该资源暂无权限限制！放行");
            return;  
        }  
        //所请求的资源拥有的权限(一个资源可对多个权限)  
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();  
        while(iterator.hasNext()) {  
            ConfigAttribute configAttribute = iterator.next();  
            //访问所请求资源所需要的权限  
            String needPermission = configAttribute.getAttribute();  
            //用户所拥有的权限authentication  
            for(GrantedAuthority ga : authentication.getAuthorities()) {  
                if(needPermission.equals(ga.getAuthority())) {  
                	 System.out.println("有相应权限,放行");
                    return;  
                }  
            }  
        }  
        
        //没有权限  
        throw new AccessDeniedException(messages.getMessage("ACCESS_DENIED"));  
        //return ;
    }  
  
    public boolean supports(ConfigAttribute attribute) {  
        // TODO Auto-generated method stub  
        return true;  
    }  
  
    public boolean supports(Class<?> clazz) {  
        // TODO Auto-generated method stub  
        return true;  
    }  
      
}  