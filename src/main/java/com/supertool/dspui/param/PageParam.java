package com.supertool.dspui.param;

import java.util.Map;

public class PageParam {

	/*
	 * 当前页
	 */
	private int currentPage;
	
	
	/*
	 * 排序列
	 */
	private String orderName;
	/*
	 *顺序 
	 */
	private String orderValue;
	
	/*
	 * 搜索关键字
	 */
	private String searchName;
	
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

	
	
	public PageParam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(String orderValue) {
		this.orderValue = orderValue;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
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
	
	
}
