package com.supertool.dspui.vo;

import java.util.List;

public class RtbBasicVO {

	private int statusCode;
	
	private String message;
	private List<RtbVO>data;
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
	public List<RtbVO> getData() {
		return data;
	}
	public void setData(List<RtbVO> data) {
		this.data = data;
	}
	
	
	
}
