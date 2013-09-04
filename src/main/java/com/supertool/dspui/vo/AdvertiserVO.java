package com.supertool.dspui.vo;

public class AdvertiserVO {

	/*
	 * 广告主、代理id
	 */
	private int id;
	/*
	 * 是否广告代理
	 */
	private boolean agency;
	/*
	 * 广告主或广告代理名称
	 */
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAgency() {
		return agency;
	}
	public void setAgency(boolean agency) {
		this.agency = agency;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
