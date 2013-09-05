package com.supertool.dspui.dao.zhongpai;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.supertool.dspui.framework.dao.QueryResult;
import com.supertool.dspui.model.User;




public interface UserMapper {
/**
 * find user by username
 * @param username
 * @return
 */

   
   /**
    * 通过用户名，从User表中取出一条记录（有效记录）
    * @param username
    * @return User
    */
	public User findByUserName(@Param("username")String username);/*{
		String hsql="from "+entityName+" where username=:username and isDeleted=:isDeleted";
		Query q=em.createQuery(hsql);
		q.setParameter("username", username);
		q.setParameter("isDeleted", "0");
		@SuppressWarnings("unchecked")
		List<User> l=q.getResultList();
		return l.size()>0? l.get(0):null;
	}*/
	/**
	 * 通过用户名，从User表中取出一条记录（无论是否有效）
	 * @param username
	 * @return User
	 */
	public User getUserByName(String username);/*{
		String hsql="from "+entityName+" where username=:username";
		Query q=em.createQuery(hsql);
		q.setParameter("username", username);
		q.setParameter("isDeleted", "0");
		@SuppressWarnings("unchecked")
		List<User> l=q.getResultList();
		return l.size()>0? l.get(0):null;
	}*/
	 /**
	    * 通过用户名，从User表中取出一条记录（有效记录）
	    * @param username
	    * @return User
	    */
		public User findByUserId(int userId);/*{
			String hsql="from "+entityName+" where userId=:userId and isDeleted=:isDeleted";
			Query q=em.createQuery(hsql);
			q.setParameter("userId", userId);
			q.setParameter("isDeleted", "0");
			@SuppressWarnings("unchecked")
			List<User> l=q.getResultList();
			return l.size()>0? l.get(0):null;
		}*/
		/**
		 * 通过用户名，从User表中取出一条记录（无论是否有效）
		 * @param username
		 * @return User
		 */
		public User getUserById(int userId);/*{
			String hsql="from "+entityName+" where userId=:userId and isDeleted=:isDeleted";
			Query q=em.createQuery(hsql);
			q.setParameter("userId", userId);
			q.setParameter("isDeleted", "0");
			@SuppressWarnings("unchecked")
			List<User> l=q.getResultList();
			return l.size()>0? l.get(0):null;
		}*/
    /**
     * 判断某用户名是否已存在,是否被标记为已删除,是否被冻结
     * 
     * @param userName
     * @return 0:不存在；1：存在，但标志为删除；2：存在，但标志为停用
     */
    public String checkName(String username);/* {
        User user = findByUserName(username);
        if(null == user) {
            return Constant.USER_UNEXISTS;
        } else if(Constant.USER_DELETED .equals( user.getIsDeleted())) {
            return Constant.USER_DELETED;
        } else if(Constant.USER_FREEZED.equals(user.getIsFreezed())){
        	return Constant.USER_FREEZED;
        }else {
            return Constant.USER_EXISTS;
        }
    }*/

	
    /**
     * 删除用户(实际为软删除)，标志为删除
     * @param user
     */
    public void delete(User user);/* {
        user.setIsDeleted(Constant.USER_DELETED);
        update(user);
    }*/
    /**
     * 停启用账户
     * @param username
     * @param freezedstatus
     */
    public void changeFreezedStatus(String username,String freezedstatus);/*{
    	User user=this.findByUserName(username);
    	user.setIsFreezed(freezedstatus);
    	update(user);
    	
    }*/
    /**
     *修改密码
     * @param username
     * @param password
     * @return
     */
	public int updateUserPasswordByName(@Param("username")String username,@Param("password")String password);/*{
		
	 	boolean flag = false;

       	try {
       		Query q = em.createNativeQuery("update "+Constant.TABLE_USER+" set Password=:password where Usename = :username");
   	    	q.setParameter("Username", username);
   	    	q.setParameter("Password", password);
   	    	q.executeUpdate();
   	    	flag = true;
       	} catch(Exception e) {
       		throw new DBException("密码重置错误", e.getCause());
       	} finally {
       		return flag;
       	}
	}*/
	
	/**
	 *  查询用户列表，支持分页。
	 * @param startRow
	 * @param num
	 * @return List<User>
	 */
	public List<User> getUserByPage(int startRow,int num);/*{
		 String select = "select u from User u";
	        String where = " where u.isDeleted =0 ";
	        String limit = " limit ?,?";
	        List<Object>params=new LinkedList<Object>();
	        params.add(startRow);
	        params.add(num);
	        @SuppressWarnings("rawtypes")
			List l = findBySql(select + where + limit,User.class,params);
	        return l.size()>0? l:null;
	}*/

	/**
	 * 分页
	 * @param firstindex
	 * @param maxresult
	 * @return 分页数据
	 */
	public QueryResult<User> getPageResult(int firstindex,int maxresult);/*{
		String wherejpql="where o.isDeleted =0";
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		orderby.put("username", "asc");
		return this.getScrollData(User.class, firstindex, maxresult, wherejpql, null, orderby);
	}*/
	/**
	 * 获取数据表中有效记录数
	 * @return long
	 */
	public int getUserCount(@Param("column")String column, @Param("value") String value);/*{
		
		String select="select count(u)  from User u";
		String where = " where IsDeleted = '0' ";
        if(true==commonUserOnly){
        	where+="and IsSupremeAdmin='0'";
        }
        List<Object>params=new LinkedList<Object>();
		
	        
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
	    int count=Integer.valueOf(this.findBySql(select+where, params).get(0).toString());
	   return count;
	}*/
	/**
	 *  获取所有有效的帐户
	 * @return List<User>
	 */
	public List<User> getUserList();/*{
		String wherejpql="where isDeleted = ?";
		List<Object> queryParams=new LinkedList<Object>();
		queryParams.add("0");
		return this.getScrollData(User.class, -1, -1, wherejpql, queryParams, null).getResultlist();
	}*/
	public List<User> getUserByPage(int firstResult, int maxResults,
			String sidx, String sord, boolean commonUserOnly,String searchColumn,String searchKey); /*{

		
		String where="where isDeleted=? ";
		if(true==commonUserOnly){
			where+=" and isSupremeAdmin='0' ";
		}
		
		LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();
		orderby.put(sidx, sord);
		List<Object>params=new LinkedList<Object>();
		params.add("0");
		if(null!=searchKey){
			if("username".equals(searchColumn)){
				where+=" and upper(username) like ?";
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
				System.out.println("param error:print null directly");
				return null;
			}
		}
		List<User> userlist=this.getScrollData(User.class, firstResult, maxResults, where, params, orderby).getResultlist();
		return userlist;
	}*/
	public int update(User user);
	public void insert(User user);
	public Map<?, ?> getUserById(Object object);
}
