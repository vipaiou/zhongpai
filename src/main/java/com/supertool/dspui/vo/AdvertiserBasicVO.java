package com.supertool.dspui.vo;

import java.util.List;

public class AdvertiserBasicVO {

	private int statusCode;
	
	private String message ;
	
	private List<AdvertiserVO> data;

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

	public List<AdvertiserVO> getData() {
		return data;
	}

	public void setData(List<AdvertiserVO> data) {
		this.data = data;
	}
	
	
	
}
