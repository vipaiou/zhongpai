package com.supertool.dspui.dao.mybatis;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.supertool.dspui.framework.dao.QueryResult;
import com.supertool.dspui.model.Resource;


@Repository
public interface ResourceDAO {

	/**
	 * 通过主键id查找资源名称
	 * @param id
	 * @return Resource
	 */
	public Resource findResourceNameById(int id);/*{
		String hsql="from Resource  where enabled=1 and resourceId =:id";
		Query q=em.createQuery(hsql);
		q.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Resource> l=q.getResultList();				
		     return l.size()>0? l.get(0):null;	
	}*/
	
	/**
	 * 通过资源名称查找资源
	 * @param name
	 * @return List<Resource>
	 */
	public List<Resource> findResourceByName(String name);/*{
		String hsql="from Resource  where enabled=1 and name =:name";
		Query q=em.createQuery(hsql);
		q.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<Resource> l=q.getResultList();				
		     return l.size()>0? l:null;	
	}*/
	/**
	 * 通过id查找资源
	 * @param id
	 * @return
	 */
	public Resource findResourceById(int id);/*{
		String hsql="from Resource  where enabled=1 and id =:id";
		Query q=em.createQuery(hsql);
		q.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Resource> l=q.getResultList();				
		     return l.size()>0? l.get(0):null;	
	}*/
	/**
	 * 通过资源url查找资源
	 * @param url
	 * @return Resource
	 */
	public Resource findResourceByUrl(String url);/*{
		String hsql="from Resource  where enabled=1 and url =:url";
		Query q=em.createQuery(hsql);
		q.setParameter("url", url);
		@SuppressWarnings("unchecked")
		List<Resource> l=q.getResultList();				
		     return l.size()>0? l.get(0):null;	
	}*/
	/***
	 * 返回有效资源记录数
	 * @return int
	 */
	public int getResourceCount();/*{
		 String select = "select count(*) from "+Constant.TABLE_RESOURCE;
	        String where = " where enabled = 1 ";
			List  l =findByNativateSql(select + where );
	        return l.size()>0? Integer.valueOf(l.get(0).toString()):0;
	}*/
	/**
	 * 返回所有有效资源列表
	 * @return List<Resource>
	 */
	public List<Resource> findResource();/*{
		String hsql="from Resource where enabled=1";
		List l=this.findBySql(hsql,null);
		     return l.size()>0? l:null;
	}*/
	/**
	 * 软删除资源
	 * @param resource
	 */
	public void deleteResource(Resource resource);/*{
		resource.setEnabled(0);
		update(resource);
	}*/
	/**
	 * 通过id软删除资源
	 * @param id
	 */
	public void deleteResourceById(int id );/*{
		Resource resource=this.findResourceById(id);
		resource.setEnabled(0);
		update(resource);
	}*/
	/**
	 * 通过url软删除资源
	 * @param url
	 */
	public void deleteResourceByUrl(String url );/*{
		Resource resource=this.findResourceByUrl(url);
		resource.setEnabled(0);
		update(resource);
	}*/
	/**
	 * 通过资源名称，软删除资源
	 * @param name
	 */
	public void deleteResourceByName(String name);/*{
		
		 List<Resource> resources=this.findResourceByName(name);
		for(Resource r:resources){
			r.setEnabled(0);
			update(r);
		}
		 
	}*/
	/**
	 * 分页查询
	 * @param firstindex
	 * @param maxresult
	 * @return 分页数据
	 */
	public QueryResult<Resource>  getPageResult(int firstindex,int maxresult);/*{
		String wherejpql="where o.enabled=1";
		return getScrollData(Resource.class, firstindex, maxresult, wherejpql, null, null);
	}*/
}
