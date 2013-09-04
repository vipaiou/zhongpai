package com.supertool.dspui.param;

import java.util.Map;

public class GridParam {

	/*
	 * 当前页
	 */
	private int pageNo;
	
	
	/*
	 * 排序列
	 */
	private String orderBy;
	/*
	 *顺序 
	 */
	private String order;
	
	/*
	 * 搜索关键字
	 */
	private String searchBy;
	
	/*
	 * 搜索内容
	 */
	private String searchValue;
	
	/*
	 * 
	 */
	private int pageSize;
	
	/*
	 * 其他信息
	 */
	private Map<String,Object> userData;

	
	
	public GridParam() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getOrderBy() {
		return orderBy;
	}


	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


	public String getOrder() {
		return order;
	}


	public void setOrder(String order) {
		this.order = order;
	}


	public String getSearchBy() {
		return searchBy;
	}


	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}


	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public Map<String,Object> getUserData() {
		return userData;
	}

	public void setUserData(Map<String,Object> userData) {
		this.userData = userData;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
