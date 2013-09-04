package com.supertool.dspui.vo;

import java.util.HashMap;
import java.util.Map;

import com.supertool.dspui.constant.Constant;


public class ResultVO {

	private int resultCode;
	
	private String message;
	
	private Map<String, Object> map;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public ResultVO(int resultCode, String message) {
		super();
		this.resultCode = resultCode;
		this.message = message;
		this.map = new HashMap<String, Object>();
	}

	public ResultVO() {

		resultCode = Constant.RESULT_FAIL;
		message = "操作失败";

		this.map = new HashMap<String, Object>();

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
}
