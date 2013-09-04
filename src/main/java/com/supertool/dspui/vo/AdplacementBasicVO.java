package com.supertool.dspui.vo;

import java.util.List;

public class AdplacementBasicVO {
	private int statusCode;
	private String message;
	private List<AdplacementVO> data;
	
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
	public List<AdplacementVO> getData() {
		return data;
	}
	public void setData(List<AdplacementVO> data) {
		this.data = data;
	}
	
}
