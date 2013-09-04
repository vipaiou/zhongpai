package com.supertool.dspui.param.carboninterface;

import java.util.List;

public class SetDataSource extends AlgorithmTestDataSource{
	String type;
	List<String> data;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
}