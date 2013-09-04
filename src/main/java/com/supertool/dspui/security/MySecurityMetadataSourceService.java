package com.supertool.dspui.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.supertool.dspui.dao.mybatis.AuthorityResourceDAO;
import com.supertool.dspui.dao.mybatis.ResourceDAO;
import com.supertool.dspui.model.Authority;
import com.supertool.dspui.model.Resource;

import org.springframework.security.web.util.AntPathRequestMatcher;


@Service
//1 加载资源与权限的对应关系  
public class MySecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {  
 
	@Autowired
    private AuthorityResourceDAO authorityResourceDAO;  
	@Autowired
    private ResourceDAO resourceDAO;  
	
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;  
    private AntPathRequestMatcher pathMatcher;  
 
    
    public MySecurityMetadataSourceService() {
		super();
	}

	//由spring调用  
    public MySecurityMetadataSourceService(AuthorityResourceDAO authorityResourceDAO,ResourceDAO resourceDAO) {  
        this.authorityResourceDAO = authorityResourceDAO;  
        this.resourceDAO=resourceDAO;
        loadResourceDefine();  
    }  
  
    public Collection<ConfigAttribute> getAllConfigAttributes() {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    public boolean supports(Class<?> clazz) {  
        // TODO Auto-generated method stub  
        return true;  
    }  
    //加载所有资源与权限的关系  
    private void loadResourceDefine() {  
       // if(resourceMap == null) {  
             
            List<Resource> resources = null;//this.resourceDAO.findResource();
            
            if(null==resources){
            	//System.out.println("暂无需要权限控制的资源！");
            	
            	
            }else{
            //System.out.println("resources.size="+resources.size());
	            resourceMap = new HashMap<String, Collection<ConfigAttribute>>(); 
	            for (Resource resource : resources) {  
	                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();  
	                                //以权限名封装为Spring的security Object  
	               // System.out.println("resource.getUrl()="+resource.getUrl());
	                List<Authority> authorities=this.authorityResourceDAO.getResourceAuthority(resource);
	               if(null==authorities||authorities.size()==0){
	            	   return;
	               }
	              
	                for(Authority auth : authorities){
	                	ConfigAttribute configAttribute = new SecurityConfig(auth.getName());  
	                	configAttributes.add(configAttribute);  
	                	//System.out.println(x)
	                }
	                resourceMap.put(resource.getUrl(), configAttributes);  
	            }  
            }
      //  }        
           
    }  
    //返回所请求资源所需要的权限  
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {  
	
    	HttpServletRequest requestUrl = ((FilterInvocation) object).getRequest();  
        System.out.println("requestUrl is " + requestUrl.getRequestURI());  
    
        loadResourceDefine();  
       
        Collection<ConfigAttribute> configAttributes =null;
        if(null!=resourceMap)
        {
	        Iterator<String> it = resourceMap.keySet().iterator();    
	        
	        while (it.hasNext()) {  
	            String resURL = it.next(); 
	            //System.out.println("资源: " + resURL);
	            pathMatcher = new AntPathRequestMatcher(resURL);  
	            if (pathMatcher.matches(requestUrl)) {  
	                configAttributes = resourceMap.get(resURL);                   
	                return configAttributes;  
	            }  
	        }  
        
	        if(null==configAttributes||configAttributes.size()==0)
	        {
	        	System.out.println("资源【 " + requestUrl.getRequestURI()+"】暂无权限限制！"); 
	        }
        }
        return configAttributes;  
    }  
  
}  