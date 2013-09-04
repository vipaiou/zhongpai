package com.supertool.dspui.service.zhongpai;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.dao.mybatis.AuthorityDAO;
import com.supertool.dspui.dao.mybatis.UserAuthorityDAO;
import com.supertool.dspui.dao.zhongpai.UserMapper;
import com.supertool.dspui.exception.DBException;
import com.supertool.dspui.model.Authority;
import com.supertool.dspui.model.Media;
import com.supertool.dspui.model.User;
import com.supertool.dspui.model.UserAuthority;
import com.supertool.dspui.model.UserMedia;
import com.supertool.dspui.security.UserDetailsImpl;
import com.supertool.dspui.util.SHAEncrypter;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.Utils;



@Service
public class UserService {

	@Autowired
	private UserMapper userDAO;
	
	@Autowired
	private UserAuthorityDAO  userAuthorityDAO;
	
	@Autowired
	private AuthorityDAO authorityDAO;
	
	static Logger logger=Logger.getLogger(UserService.class.getName());
	/**
	 * 根据用户名查找 未删除用户,不论账户是否禁用
	 * @param username
	 * @return
	 */
	public User findUserByUsername(String username){
		
		return this.userDAO.findByUserName(username);
	}
	/**
	 * 根据用户名查找账户，不论账户是否禁用，是否删除。
	 * @param username
	 * @return
	 */
	public User findUserIngoreIsFeezedByUsername(String username){
		
		return this.userDAO.getUserByName(username);
	}
	/**
	 *  创建新用户
	 * @param user
	 * @return
	 */
	@Transactional(readOnly = false,rollbackFor=DBException.class)
	public boolean createUser(User user,List<String>permissionList,List<Integer>mediaIds,Integer selectAll){
		User result = findUserByUsername(user.getUsername());
		//如果不存在，就新建权限
		
			
		
		// 如果该用户不存在存在，或者已删除，就可新建

		if(null == result || Constant.USER_DELETED.equals(result.getIsDeleted()))	{

			
			try {
				//如果不存在就插入
				if(null == result) {
					userDAO.insert(user);					
					//System.out.println("insert");
				} else {
					//**用户帐号处于被删除状态时，通过更新变为可用账户
					userDAO.update(user);
				}
				List<Authority>authoritys=null;
				List<UserAuthority>userAuthoritys=null;
				//如果有权限需要添加
				if(null!=permissionList&&permissionList.size()>0){
					//根据权限名获取权限，目的是为了获得id
					authoritys=new LinkedList<Authority>();
						for(String authorityName:permissionList){
							Authority authority=this.authorityDAO.getAuthorityByName(authorityName);
							if(null!=authority){
								authoritys.add(authority);
							}
						}
				}
				if(null!=authoritys&&authoritys.size()>0){
					userAuthoritys=new LinkedList<UserAuthority>();
					for(Authority authority:authoritys){
						if(null!=authority){
							UserAuthority userAuthority=new UserAuthority();
							userAuthority.setAuthorityId(authority.getAuthorityId());
							userAuthority.setUserId(user.getUserId());
							userAuthoritys.add(userAuthority);
						}
					}
					this.userAuthorityDAO.addUserAuthoritys(userAuthoritys);
				}
				
				return true;
			} catch(DBException e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			return false;
		}
	}
	/**
	 * 检验用户名是否存在：true:存在;
	 * @param username
	 * @return
	 */
	public boolean isUsernameExists(String username){
		//status 0:不存在；1：存在，但标志为删除；2：存在，但标志为停用
		String status=this.userDAO.checkName(username);
		if(Constant.USER_DELETED.equals(status)||Constant.USER_UNEXISTS.equals(status)){
			 //System.out.println("false");
			return false;			
		}
		 //System.out.println("true");
		return true;
	}
	public List<User> getUserList(){
		
		return this.userDAO.getUserList();
	}
	/**
	 * 获取分页数据，返回xml，共jqgrid使用
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @return
	 */
	public String getXmlPagedUserList(int pageNo, int pageSize, String sidx,
			String sord,String searchColumn,String searchKey) {
		if(pageSize==0){
			return StringUtil.buildTableXMLData(null,User.class, pageNo, 0, 0, null, null);
		}
	   int firstResult = (pageNo-1)*pageSize;
	   int maxResults = pageSize;
	   boolean commonUserOnly=true;
	   if(null==searchKey||StringUtil.isBlank(searchKey)){
		   searchColumn=null;
		   searchKey=null;
	   }
	   else{
		   searchKey=searchKey.toUpperCase();
	   }
//	   System.out.println("searchColumn="+searchColumn);
//	   System.out.println("searchKey="+searchKey);
	
	   List<User> userlist=this.userDAO.getUserByPage(firstResult, maxResults,sidx,sord,commonUserOnly,searchColumn,searchKey);
	   //总记录数
	   Integer records= this.userDAO.getUserCount(commonUserOnly,searchColumn,searchKey);
	   //总页数
	   Integer total = Utils.getTotalPage(records,pageSize);
	   
	 //数据表固有属性------区别拼凑属性
	   List<String> attributes=new LinkedList<String>();
	   attributes.add("userId");
	   attributes.add("username");
	 //添加拼凑属性
	   List<List<Object>> extras=new LinkedList<List<Object>>();
	   if(null!=userlist){
	   List<Object> extra1=new LinkedList<Object>();
	   List<Object> extra2=new LinkedList<Object>();
	   List<Object> extra3=new LinkedList<Object>();
	   
	    for(User user : userlist){
	        Integer userId = user.getUserId();
	        String management1="";
	        if("1".equals(user.getIsFreezed())){
	            management1 = "停用"; 
	        }else{
	            management1= "启用"; 
	        }	
		    extra1.add(management1);
		    
	        String management2="<a href='#' onclick='resetPassword("+userId+");return false;'>重置密码</a>";
	        extra2.add(management2);
	        String management3="<a href='#' onclick='view("+userId+");return false;'>查看</a> ｜　"+
            "<a href='#' onclick='modify("+userId+");return false;'>编辑</a>";
	        
	        extra3.add(management3);
	    }
	    extras.add(extra1);
	    extras.add(extra2);
	    extras.add(extra3);
	   
	   }
	   
	    return StringUtil.buildTableXMLData(userlist,User.class, pageNo, total, records, attributes, null);

	}
	@Transactional(readOnly = false,rollbackFor=DBException.class)
	public String changePassword(int userId, String oldPass, String newPass,
			String repeatPass) {
		User user = this.userDAO.getUserById(userId);
		String shaOldPass = SHAEncrypter.getInstance().encrypt(oldPass);
		if(user.getPassword().equals(shaOldPass)){
			user.setPassword(SHAEncrypter.getInstance().encrypt(newPass));
			SecurityContext ctx = SecurityContextHolder.getContext();
			Authentication auth = ctx.getAuthentication();
			User loginUser = null;
			if (auth.getPrincipal() instanceof UserDetails) {
				UserDetailsImpl ud=(UserDetailsImpl)auth.getPrincipal();
				loginUser=ud.getUser();
				user.setUpdateDate(new Date());
				user.setUpdateUser(loginUser.getUserId());
				user.setPassword(SHAEncrypter.getInstance().encrypt(newPass));
				if(userDAO.update(user) > 0){
					//System.out.println("^^^^^"+ud.getUser().getPassword()==SHAEncrypter.getInstance().encrypt(newPass));
					return "修改密码成功";
				}else{
					return "服务器忙,请稍后再试";
				}
			}else{
				return "系统错误!";
			}
		}
		return "原密码不正确";
	}
	@Transactional(readOnly = false,rollbackFor=DBException.class)
	public  int update(User user) {
		return this.userDAO.update(user);
		
	}
	public User findUserById(Integer userId) {
		
		return this.userDAO.findByUserId(userId);
	}
	public List<Authority> getAuthoritysByUser(User user) {
		
		return this.userAuthorityDAO.getAuthoritysByUser(user);
	}
	
	public List<List<Authority>> getGroupedAuthoritysByUser(User user){
		List<List<Authority>>groupedAuthoritys=null;
		if(null==user){
			return null;
		}
		List<Authority>parentAuthoritys=this.userAuthorityDAO.getParentAuthoritysByUser(user);
		if(null==parentAuthoritys||parentAuthoritys.size()==0){
			return null;
		}
		groupedAuthoritys=new LinkedList<List<Authority>>();
		for(Authority a:parentAuthoritys){
			List<Authority>authoritys=new LinkedList<Authority>();
			authoritys.add(a);
			List<Authority>childAuthoritys=this.authorityDAO.getAuthoritysByParentId(a.getAuthorityId());
			if(null!=childAuthoritys&&childAuthoritys.size()>0){
				authoritys.addAll(1, childAuthoritys);
			}
			groupedAuthoritys.add(authoritys);
		}
		return groupedAuthoritys;
	}
	public List<List<Authority>> getGroupedAuthoritys(){
		List<List<Authority>>groupedAuthoritys=null;
		List<Authority>parentAuthoritys=this.authorityDAO.getAuthoritysByParentId(-1);
		if(null==parentAuthoritys||parentAuthoritys.size()==0){
			return null;
		}
		groupedAuthoritys=new LinkedList<List<Authority>>();
		for(Authority a:parentAuthoritys){
			List<Authority>authoritys=new LinkedList<Authority>();
			authoritys.add(a);
			List<Authority>childAuthoritys=this.authorityDAO.getAuthoritysByParentId(a.getAuthorityId());
			if(null!=childAuthoritys&&childAuthoritys.size()>0){
				authoritys.addAll(1, childAuthoritys);
			}
			groupedAuthoritys.add(authoritys);
		}
		return groupedAuthoritys;
	}
	
	/**
	/**
	 * 用户列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param searchKey
	 * @param searchColumn
	 * @return
	 */
	public List<User> getPageUserList(int pageNo, int pageSize, String sidx,
			String sord, String searchColumn,String searchKey,boolean commonUserOnly) {
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
//	   System.out.println("searchColumn="+searchColumn);
//	   System.out.println("searchKey="+searchKey);
	
	   return this.userDAO.getUserByPage(firstResult, maxResults,sidx,sord,commonUserOnly,searchColumn,searchKey);
	  
	}
	public int getUserTotalCount(String searchColumn, String searchKey,
			boolean commonUserOnly) {
		if(null==searchKey||StringUtil.isBlank(searchKey)){
			   searchColumn=null;
			   searchKey=null;
		   }
		   else{
			   searchKey=searchKey.toUpperCase();
		   }
		return this.userDAO.getUserCount(commonUserOnly, searchColumn, searchKey);
	}
	@Transactional(readOnly=false,rollbackFor=DBException.class)
	public boolean modifyUser(User user, List<String> updatAuthNames,
			List<String> updateMediaIds, Integer selectAll) {
		try{
			this.update(user);
			List<UserAuthority>oldUserAuthoritys=this.userAuthorityDAO.getUserAuthoritys(user);
			if(null!=oldUserAuthoritys&&oldUserAuthoritys.size()>0){
				for(UserAuthority ua:oldUserAuthoritys){
					this.userAuthorityDAO.delete(ua);
				}
			}
			if(null!=updatAuthNames&&updatAuthNames.size()>0){
				List<Authority> newAuthoritys=this.authorityDAO.getAuthoritysByNameList(updatAuthNames);
				if(null!=newAuthoritys&&newAuthoritys.size()>0){
					for(Authority newAuth:newAuthoritys){
						UserAuthority newUa=new UserAuthority();
						newUa.setAuthorityId(newAuth.getAuthorityId());
						newUa.setUserId(user.getUserId());
						this.userAuthorityDAO.insert(newUa);
					}
				}
			}
			if(null!=updateMediaIds&&updateMediaIds.size()>0){
				//System.out.println("asdasdasd");
				for(String s:updateMediaIds){
					if(StringUtil.isNumber(s)){
						UserMedia newUm=new UserMedia();
						newUm.setMediaId(Integer.parseInt(s));
						newUm.setUserId(user.getUserId());
					}
				}
			}
		}catch(DBException e){
			logger.info(e.getMessage());
			return false;
		}
		return true;
	
	}
	public List<Authority> getUserAuthoritysForSecurity(User user) {
		return null;//this.userAuthorityDAO.getAuthoritysForSecurityByUser(user);
	}
	public Map<?, ?> getUserById(Object object) {
		return userDAO.getUserById(object);
	}
}
