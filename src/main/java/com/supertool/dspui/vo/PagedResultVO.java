package com.supertool.dspui.vo;

import java.util.List;
import java.util.Map;

public class PagedResultVO {
	// 总记记录数
	private int totalCount;
	// 总页数
	private int totalPage;

	private int currentPage;



	// 页面大小
	private int pageSize;
	// table 数据
	private List<?> datas;
	// 其他额外的数据获取
	private Map<String, Object> otherData;

	public PagedResultVO() {
		super();
		totalCount = 0;
		totalPage = 0;
		setPageSize(5);
		datas = null;
		otherData = null;

	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<?> getDatas() {
		return datas;
	}

	public void setDatas(List<?> datas) {
		this.datas = datas;
	}

	public Map<String, Object> getOtherData() {
		return otherData;
	}

	public void setOtherData(Map<String, Object> otherData) {
		this.otherData = otherData;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
