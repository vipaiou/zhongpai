package com.supertool.dspui.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.supertool.dspui.model.Authority;


@Repository
public interface AuthorityDAO {

	/**
	 * 
	 * @return
	 */
	public  List<Authority> getAuthorityList();
//	public  List<Authority> getAuthorityList(){
//		String hsql="from Authority where enabled=1 and parentId<>0 ";
//		List<Authority> l=findBySql(hsql,null);
//		     return l.size()>0? l:null;
//	}
	
	public  Authority getAuthorityById(int authorityId);/*{
		String hsql="from Authority where enabled=1 and authorityId=?  and parentId<>0 ";
		List<Object>params=new LinkedList<Object>();
		params.add(authorityId);
		List<Authority> l=findBySql(hsql,params);
		     return l.size()>0? l.get(0):null;
	}*/
	public  Authority getAuthorityByName(String authorityName);/*{
		String hsql="from Authority where enabled=1 and name=?  and parentId<>0 ";
		List<Object>params=new LinkedList<Object>();
		params.add(authorityName);
		List<Authority> l=findBySql(hsql,params);
//		System.out.println(null==l);
//		System.out.println(l.size()>0);
//		System.out.println(l.size()>0? l.get(0):null);
		     return l.size()>0? l.get(0):null;
	}*/

	public List<Authority> getAuthoritysByNameList(List<String> permissionList); /*{
		List<Authority>authoritys=new LinkedList<Authority>();
		for(String s:permissionList){
			Authority authority=this.getAuthorityByName(s);
			if(null!=authority){
				authoritys.add(authority);
			}
		}
		
		return authoritys.size()>0? authoritys:null;
	}*/
	/**
	 * 根据权限名称，判断权限是否存在
	 * @param name
	 * @return 存在，返回true;否则返回false
	 */
	public boolean isAuthorityNameExist(String name);/* {
		Authority isExists=this.getAuthorityByName(name);
		if(null==isExists){
			return false;
		}
		return true;
			
	}*/
	public List<Authority> getAuthoritysByParentId(Integer id);/*{
		
		String select = "select auth from Authority auth ";
		String where="where auth.enabled=? and auth.parentId=? ";
		List<Object>params=new LinkedList<Object>();
		params.add(1);
		params.add(id);
		List<Authority> list =findBySql(select+where,Authority.class,params);
		return list.size()>0?list:null;
	}*/
	public void insert(Authority authority);
}
