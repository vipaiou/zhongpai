package com.supertool.dspui.param.form;

public class BasePageForm {
	
	/**
	 * 当前页数
	 */
	private int pageNo; 
	/**
	 * 每页记录数
	 */
	private int pageSize;

	/**
	 * 排序列名
	 */
	private String orderBy;

	/**
	 * 排序方式（asc/desc）
	 */
	private String order;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

}
