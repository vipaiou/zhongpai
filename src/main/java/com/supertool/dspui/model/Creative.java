package com.supertool.dspui.model;

import java.io.Serializable;
import java.util.Date;

import com.supertool.dspui.util.DateUtil;

/**
 * 
 * @author zhouziqiang
 *
 */
public class Creative implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 主键，自增
	 */
	private Integer id;
	 /*
	  * carbon里对应表主键
	  */
	private Integer carbonId;
	 /*
	  * dsp对应id
	  */
	 private int dspId;
	 private int campaignId;
	 private int campaignCarbonId;

	/*广告活动
	 * 
	 */
	 private Campaign campaign;
	 public Integer getCarbonId() {
		return carbonId;
	}
	/*
	  * 名称
	  */
	 private String name;
	 /*
	  * 描述
	  */
	 private String description;
	 /*
	  * 创建时间，默认值1970-01-01 08:00:00
	  */
	 private Date createTime;
	 /*
	  * 更新时间，1970-01-01 08:00:00
	  */
	 private Date updateTime;
	 /*
	  * 删除时间，1970-01-01 08:00:00
	  */
	 private Date deleteTime;
	 /*
	  * 是否删除，是否删除,0=否，1=是
	  */
	 private Byte isDeleted;
	 /*
	  *物料个数 
	  */
	 private int materialCount;
	 
	 /*
	  * 是否为rtb引用
	  */
	 private boolean isInUse;
	 
	 
	 
	 
	public Creative() {
		super();
		this.createTime = DateUtil.getDefaultDateTime();
		this.updateTime = DateUtil.getDefaultDateTime();
		this.deleteTime = DateUtil.getDefaultDateTime();
	}
	public boolean isInUse() {
		return isInUse;
	}
	public void setInUse(boolean isInUse) {
		this.isInUse = isInUse;
	}
	public void setCarbonId(Integer carbonId) {
		this.carbonId = carbonId;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

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
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return DateUtil.formatDateTime(createTime);
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return DateUtil.formatDateTime(updateTime);
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getDeleteTime() {
		return DateUtil.formatDateTime(deleteTime);
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Campaign getCampaign() {
		return campaign;
	}
	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}
	public int getMaterialCount() {
		return materialCount;
	}
	public void setMaterialCount(int materialCount) {
		this.materialCount = materialCount;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public int getCampaignCarbonId() {
		return campaignCarbonId;
	}
	public void setCampaignCarbonId(int campaignCarbonId) {
		this.campaignCarbonId = campaignCarbonId;
	}
	 
	 
	 
	 

}
