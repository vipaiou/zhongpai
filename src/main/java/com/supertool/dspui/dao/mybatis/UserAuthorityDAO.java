package com.supertool.dspui.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.supertool.dspui.model.Authority;
import com.supertool.dspui.model.User;
import com.supertool.dspui.model.UserAuthority;




@Repository
public interface UserAuthorityDAO {
/**
 * 返回用户拥有的权限
 * @param user
 * @return
 */
	public List<Authority> getAuthoritysByUser(User user);/*{
		String select = "select auth from Authority auth ";
		String where="where auth.enabled=1  and parentId<>0 and auth.authorityId in";
		String in="(select userAuth.authorityId from UserAuthority userAuth where userAuth.enabled=1 and userAuth.userId="+user.getUserId()+")";
		
		List<Authority> list =findBySql(select + where + in,Authority.class,null);
		return list.size()>0?list:null;
	}*/
	public List<Authority> getAuthoritysForSecurityByUser(User user);/*{
		String select = "select auth from Authority auth ";
		String where="where auth.enabled=1  and auth.authorityId in";
		String in="(select userAuth.authorityId from UserAuthority userAuth where userAuth.enabled=1 and userAuth.userId="+user.getUserId()+")";
		
		List<Authority> list =findBySql(select + where + in,Authority.class,null);
		return list.size()>0?list:null;
	}*/
	public void addUserAuthoritys(List<UserAuthority> userAuthoritys);/* {
		for(UserAuthority userAuthority:userAuthoritys){
			this.insert(userAuthority);
		}
		
	}*/
	
	public List<Authority> getParentAuthoritysByUser(User user);/*{
		String select = "select auth from Authority auth ";
		String where="where auth.enabled=? and auth.parentId=? ";
		String in=" and auth.authorityId in (select userAuth.authorityId from UserAuthority userAuth where userAuth.enabled=1 and userAuth.userId="+user.getUserId()+")";
		
		List<Object>params=new LinkedList<Object>();
		params.add(1);
		params.add(-1);
		List<Authority> list =findBySql(select+where+in,Authority.class,params);
		return list.size()>0?list:null;
	}
*/
	public List<UserAuthority> getUserAuthoritys(User user);/* {
		String select = "select userAuth from UserAuthority userAuth ";
		String where="where userAuth.enabled=? and userAuth.userId =?";
		List<Object>params=new LinkedList<Object>();
		params.add(1);
		params.add(user.getUserId());
		List<UserAuthority> list =findBySql(select + where,UserAuthority.class,params);
		return list.size()>0?list:null;
	}*/

	public List<Authority> getPageUserAuthority(int firstResult,
			int maxResults, String sidx, String sord, int userId,
			String searchColumn, String searchKey); /*{
		String where="where enabled=?  ";
		String in=" and parentId<>0  and authorityId in (select userAuth.authorityId from UserAuthority userAuth where userAuth.enabled=1 and userAuth.userId="+userId+")";
		
		List<Object>params=new LinkedList<Object>();
		params.add(1);

			
			LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();
			orderby.put(sidx, sord);

			if(null!=searchKey){
				if("name".equals(searchColumn)){
					where+=" and upper(name) like ?";
					params.add(searchKey+"%");
					//System.out.println("searchColumn1="+searchColumn);
					//System.out.println("searchKey1="+searchKey);
				}
				else if(StringUtil.isNumber(searchKey)){
					int userId=Integer.parseInt(searchKey);
					where+=" and userId=?";
					params.add(userId);
					//System.out.println("searchColumn2="+searchColumn);
					//System.out.println("searchKey2="+searchKey);
				}
				else{
					System.out.println("searchColumn="+searchColumn);
					System.out.println("searchKey="+searchKey);
					System.out.println("print null directly");
					return null;
				}
			//System.out.println("go!!!!");
			List<Authority> authoritylist=this.getScrollData(Authority.class, firstResult, maxResults, where+in, params, orderby).getResultlist();
			return authoritylist;
	
	}
*/
	public int getPageAuthorityCount(int userId, String searchColumn,
			String searchKey);/* {
		String where="select count(auth) from Authority auth where auth.enabled=1 and parentId<>0 ";
		String in=" and auth.authorityId in (select userAuth.authorityId from UserAuthority userAuth where userAuth.enabled=1 and userAuth.userId="+userId+")";
      
 
		
	        
	    if(null!=searchKey&&!StringUtil.isBlank(searchKey)){
	    	if("username".equals(searchColumn)){
				where+=" and upper(username) like ?";
				params.add(searchKey+"%");
			}
			else if("userId".equals(searchColumn)&&StringUtil.isNumber(searchKey)){
				int userId=Integer.parseInt(searchKey);
				where+=" and userId=?";
				params.add(userId);
			}else{
				return 0;
			}
	    	System.out.println("--searchKey--"+searchKey);
	    	System.out.println("----");
		}
	    int count=Integer.valueOf(this.findBySql(where+in, null).get(0).toString());
	   return count;
	}*/
	public void insert(UserAuthority authority);
	public void delete(UserAuthority authority);
}
