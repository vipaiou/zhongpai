package com.supertool.dspui.vo;

import java.util.List;
import java.util.Map;

public class DetailFormBasicVO {

	private int statusCode;
	private String message;
	private Map<String,List<DetailFormVO>> data;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, List<DetailFormVO>> getData() {
		return data;
	}
	public void setData(Map<String, List<DetailFormVO>> data) {
		this.data = data;
	}
}
