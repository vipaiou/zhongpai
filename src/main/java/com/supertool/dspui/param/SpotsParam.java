package com.supertool.dspui.param;

public class SpotsParam {
	String key;
	String searchType;
	String searchScope;
	String hasSpots;
	String status;
	String hasClassIds;
	String useage;
	String searchColumn;
	String sord;
	String sidx;
	
	int pageNO;
	int pageSize;
	int parentId;
	int currentId;
	

	public int getPageNO() {
		return pageNO;
	}

	public String getSearchScope() {
		return searchScope;
	}

	public void setSearchScope(String searchScope) {
		this.searchScope = searchScope;
	}

	public String getHasSpots() {
		return hasSpots;
	}

	public void setHasSpots(String hasSpots) {
		this.hasSpots = hasSpots;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHasClassIds() {
		return hasClassIds;
	}

	public void setHasClassIds(String hasClassIds) {
		this.hasClassIds = hasClassIds;
	}

	public String getUseage() {
		return useage;
	}

	public void setUseage(String useage) {
		this.useage = useage;
	}

	public String getSearchColumn() {
		return searchColumn;
	}

	public void setSearchColumn(String searchColumn) {
		this.searchColumn = searchColumn;
	}

	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getCurrentId() {
		return currentId;
	}

	public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

}
