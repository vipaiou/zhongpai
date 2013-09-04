package com.supertool.dspui.param;

import java.util.List;
import java.util.Map;

public class SelectSQLParam {
	/**
	 * 公共属性
	 */
	 /*
	  * 起始记录位置
	  */
	 private Integer startRow;
	 /*
	  * 页面大小
	  */
	 private Integer limitRows;
	 /*
	  * 排序列
	  */
	 private String orderName;
	 /*
	  * 排序方式 ，升降序
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
	 * dsp id
	 */
	private Integer dspId;

	public Integer getDspId() {
		return dspId;
	}



	public void setDspId(Integer dspId) {
		this.dspId = dspId;
	}



	/*
	 *在java中定义的部分sql代码 
	 */
	private String sqlStr;
	 /**
	  * 特定查询，特定类型
	  */
	/*
	 * Id集合
	 */
	 private List<Integer> ids;
	 
	 private boolean isNumber;
	
	 private boolean isNeedInIds; 
	 
	 private Map<String,Object> userData;
	 
	public SelectSQLParam() {
		super();
		this.ids = null ;
		this.setSqlStr(null);
		this.startRow = null;
		this.limitRows = null;
		this.orderName = null;
		this.orderValue =null;
		this.setSearchName(null);
		this.setSearchValue(null);
		this.isNumber = false;
		this.setNeedInIds(true);
	}
	
	
	
	public SelectSQLParam(List<Integer> ids, Integer startRow,
			Integer limitRows, String orderName, String orderValue ,String searchName, String searchValue, boolean isNumber) {
		super();
		this.ids = ids;
		this.startRow = startRow;
		this.limitRows = limitRows;
		this.orderName = orderName;
		this.orderValue = orderValue;
		this.setSearchName(searchName);
		this.setSearchValue(searchValue);
		this.isNumber = isNumber;
	}



	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getLimitRows() {
		return limitRows;
	}
	public void setLimitRows(Integer limitRows) {
		this.limitRows = limitRows;
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



	public boolean isNumber() {
		return isNumber;
	}



	public void setNumber(boolean isNumber) {
		this.isNumber = isNumber;
	}



	public String getSqlStr() {
		return sqlStr;
	}



	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}



	public boolean isNeedInIds() {
		return isNeedInIds;
	}



	public void setNeedInIds(boolean isNeedInIds) {
		this.isNeedInIds = isNeedInIds;
	}



	public Map<String,Object> getUserData() {
		return userData;
	}



	public void setUserData(Map<String,Object> userData) {
		this.userData = userData;
	}


	 
}
