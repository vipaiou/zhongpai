package com.supertool.dspui.service.security;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.supertool.dspui.dao.mybatis.AuthorityDAO;
import com.supertool.dspui.dao.mybatis.UserAuthorityDAO;
import com.supertool.dspui.exception.DBException;
import com.supertool.dspui.model.Authority;
import com.supertool.dspui.model.User;
import com.supertool.dspui.model.UserAuthority;
import com.supertool.dspui.util.StringUtil;

@Service
public class SecurityService {

	@Autowired
	private AuthorityDAO authorityDAO;
	@Autowired
	private UserAuthorityDAO userAuthorityDAO;
	
	/**
	 * 根据权限名称批量获取权限
	 * @param names
	 * @return List<Authority>
	 */
	@Transactional(readOnly = false,propagation=Propagation.NOT_SUPPORTED)
	public List<Authority> getAuthoritysByNameList(List<String>names){
		List<Authority> authoritys=null;
		if(null!=names&&names.size()>0){
			authoritys=new LinkedList<Authority>();
			for(String name:names){
				Authority authority=this.authorityDAO.getAuthorityByName(name);
				authoritys.add(authority);
			}
		}
		
		return authoritys;
	}
	@Transactional(rollbackFor=DBException.class)
	public void addAuthoritys(List<Authority>authoritys){
		for(Authority authority:authoritys){
			this.authorityDAO.insert(authority);
		}
	}
	
	
	@Transactional(readOnly=false,rollbackFor=DBException.class)
	public void add(List<UserAuthority> userAuthoritys)
	{
		for(UserAuthority userAuthority:userAuthoritys){
			this.userAuthorityDAO.insert(userAuthority);
		}
	}
	
	public List<Authority> getUserAuthoritys(User user){
		return this.userAuthorityDAO.getAuthoritysByUser(user);
	}
	public List<Authority> getUserAuthoritysForSecurity(User user){
		return this.userAuthorityDAO.getAuthoritysForSecurityByUser(user);
	}
	public List<Authority> getPageUserAuthoritys(int pageNo, int pageSize,
			String sidx, String sord, String searchColumn, String searchKey,
			String userIdStr) {
		if(pageSize==0){
			return null;
		}
	   int firstResult = (pageNo-1)*pageSize;
	   int maxResults = pageSize;
	   if(null==searchKey||StringUtil.isBlank(searchKey)){
		   searchColumn=null;
		   searchKey=null;
	   }
	   else{
		   searchKey=searchKey.toUpperCase();
	   }
		if(StringUtil.isNumber(userIdStr)){
			System.out.println("go!!!!");
			return this.userAuthorityDAO.getPageUserAuthority(firstResult, maxResults,sidx,sord,Integer.parseInt(userIdStr),searchColumn,searchKey  );
		}
		return null;
	}
	public int getUserTotalCount(String searchColumn, String searchKey,
			String userIdStr) {
		if(null==searchKey||StringUtil.isBlank(searchKey)){
			   searchColumn=null;
			   searchKey=null;
		   }
		   else{
			   searchKey=searchKey.toUpperCase();
		   }
		if(StringUtil.isNumber(userIdStr)){
			System.out.println("asd--------->");
			return this.userAuthorityDAO.getPageAuthorityCount(Integer.parseInt(userIdStr), searchColumn, searchKey);
		}
		return 0;
	}
}
