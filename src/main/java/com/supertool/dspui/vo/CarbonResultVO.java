package com.supertool.dspui.vo;

import java.util.List;


public class CarbonResultVO{

	private int statusCode;
	
	private String message;
	
	private List<?> data;

			
	
	public CarbonResultVO() {
		super();
		statusCode = -1;
		message = "初始化";
		setData(null);
	}



	


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






	public List<?> getData() {
		return data;
	}






	public void setData(List<?> data) {
		this.data = data;
	}






	








	


	


}
