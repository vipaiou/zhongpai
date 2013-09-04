package com.supertool.dspui.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.supertool.dspui.util.DateUtil;
/**
 * 广告活动实体
 * @author zhouziqiang
 *
 */
public class Campaign implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	/*
	 * 广告活动idId
	 */
	private Integer id;
	/*
	 * carbonId
	 */
	private Integer carbonId;
	/*
	 * dsp id
	 */
	private Integer dspId;
	/*
	 * 广告活动名称
	 */
	private String name;

	/*
	 * 广告活动开始时间
	 */
	private Date startTime;
	/*
	 * 广告活动结束时间
	 */
	private Date endTime;
	
	/*
	 * 广告主id
	 */
	private Integer advertiserId;
	

	
	/*
	 * 品牌名称
	 */
	private String brand;
	/*
	 * 最大价格，如果未设为0.00
	 */
	private BigDecimal  maxPrice;
	
	/*
	 * 落地页
	 */
	private String landingPage;
	/*
	 * 是否关联minisite 0:否；1是
	 */
	private char isMinisite;
	/*
	 * 新建时间
	 */
	private Date createTime;
	/*
	 * 更新时间
	 */
	private Date updateTime;
	/*
	 * 删除时间
	 */
	private Date deletedTime;
	/*
	 * 是否删除
	 */
	private char isDeleted;

	
	/*
	 * 活动状态:初始化；-1未开始0；进行中1；已结束2
	 */
	private int campaignStatus;
	
	
	public Campaign() {
		super();
		
		this.name = "";
		this.advertiserId= 0;
		this.brand = "";
		this.setCarbonId(0);
		this.createTime = DateUtil.getDefaultDateTime();
		this.deletedTime = DateUtil.getDefaultDateTime();
		this.dspId = 0;
		this.setEndTime(DateUtil.getDefalutDate());
		this.id = 0;
		this.isDeleted = '0' ;
		this.landingPage = "";
		this.maxPrice = new BigDecimal(0).setScale(2);
		this.isMinisite = '0';
		this.setStartTime(DateUtil.getDefalutDate());
		this.updateTime = DateUtil.getDefaultDateTime();
		campaignStatus = -1;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getCarbonId() {
		return carbonId;
	}



	public void setCarbonId(Integer carbonId) {
		this.carbonId = carbonId;
	}



	public Integer getDspId() {
		return dspId;
	}



	public void setDspId(Integer dspId) {
		this.dspId = dspId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getStartTime() {
		return startTime;
	}



	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}



	public Date getEndTime() {
		return endTime;
	}



	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}



	public Integer getAdvertiserId() {
		return advertiserId;
	}



	public void setAdvertiserId(Integer advertiserId) {
		this.advertiserId = advertiserId;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public BigDecimal getMaxPrice() {
		return maxPrice;
	}



	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}



	public String getLandingPage() {
		return landingPage;
	}



	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
	}





	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public Date getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}



	public Date getDeletedTime() {
		return deletedTime;
	}



	public void setDeletedTime(Date deletedTime) {
		this.deletedTime = deletedTime;
	}


	public char getIsMinisite() {
		return isMinisite;
	}



	public void setIsMinisite(char isMinisite) {
		this.isMinisite = isMinisite;
	}



	public char getIsDeleted() {
		return isDeleted;
	}



	public void setIsDeleted(char isDeleted) {
		this.isDeleted = isDeleted;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public int getCampaignStatus() {
		return campaignStatus;
	}



	public void setCampainStatus(int campaignStatus) {
		this.campaignStatus = campaignStatus;
	}

	

}
