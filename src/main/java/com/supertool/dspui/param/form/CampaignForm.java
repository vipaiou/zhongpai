package com.supertool.dspui.param.form;

import com.supertool.dspui.util.StringUtil;


public class CampaignForm {

	public void setMinisite(boolean isMinisite) {
		this.isMinisite = isMinisite;
	}
	/*
	 * 本地数据表Id
	 */
	private int id;

	/*
	 * carbon数据表Id
	 */
	private int carbonId;
	/*
	 * dspId
	 */
	private int dspId;
	
	
	/*
	 * 广告活动名称
	 */
	private String name;

	/*
	 * 广告活动开始时间
	 */
	private String startTime;
	/*
	 * 广告活动结束时间
	 */
	private String endTime;
	
	
	/*
	 * 广告主id
	 */
	private String advertiserId;
	
	/*
	 * 品牌名称
	 */
	private String brand;
	
	/*
	 * 落地页
	 */
	private String landingPage;
	
	private String maxPrice;
	
	private String createTime;
	
	private String updateTime;
	
	private String deletedTime;
	
	private boolean isDeleted;
	
	private boolean isMinisite;
	
	
	public CampaignForm() {
		super();
		
	}
	/**
	 * 
	 * setters and getters
	 */
	public int getDspId() {
		return dspId;
	}
	public void setDspId(int dspId) {
		this.dspId = dspId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = StringUtil.trimSRN(name);
	}

	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = StringUtil.trimSRN(brand);
	}
	public String getLandingPage() {
		return landingPage;
	}
	public void setLandingPage(String landingPage) {
		this.landingPage = StringUtil.trimSRN(landingPage);
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdvertiserId() {
		return advertiserId;
	}
	public void setAdvertiserId(String advertiserId) {
		this.advertiserId = advertiserId;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getCarbonId() {
		return carbonId;
	}
	public void setCarbonId(int carbonId) {
		this.carbonId = carbonId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getDeletedTime() {
		return deletedTime;
	}
	public void setDeletedTime(String deletedTime) {
		this.deletedTime = deletedTime;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = StringUtil.trimSRN(maxPrice);
	}
	public boolean getIsMinisite() {
		return isMinisite;
	}
	public void setIsMinisite(boolean isMinisite) {
		this.isMinisite = isMinisite;
	}
	
	
}
