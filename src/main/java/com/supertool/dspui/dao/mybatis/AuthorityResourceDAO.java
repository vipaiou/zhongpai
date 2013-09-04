package com.supertool.dspui.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.supertool.dspui.model.Authority;
import com.supertool.dspui.model.Resource;



@Repository
public interface AuthorityResourceDAO {

	public List<Authority> getResourceAuthority(Resource resource);/*{
		String select = "select auth from Authority auth ";
		String where="where auth.enabled=1 and auth.authorityId in";
		String in="(select auth_res.authorityId from AuthorityResource auth_res where auth_res.enabled=1 and auth_res.resourceId="+resource.getResourceId()+")";
		
		//System.out.println("select + where + in="+select + where + in);
		List<Authority> list = findBySql(select + where + in,Authority.class,null);
		return list.size()>0?list:null;
	}*/
}
