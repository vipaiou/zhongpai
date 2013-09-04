package com.supertool.dspui.vo;

import java.io.Serializable;

public class CampaignAdvertiserVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 广告活动id
	 */
	private int carbonId;
	/*
	 *广告主名称 
	 */
	private String advertiserName;
	
	
	public CampaignAdvertiserVO() {
		super();
		advertiserName = "";
	}
	public int getCarbonId() {
		return carbonId;
	}
	public void setCarbonId(int carbonId) {
		this.carbonId = carbonId;
	}
	public String getAdvertiserName() {
		return advertiserName;
	}
	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}
	
}
