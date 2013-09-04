package com.supertool.dspui.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 广告主实体
 * @author zhouziqiang
 *
 */
public class Advertiser implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	  * 广告主id,主键自增 
	  */
	 private int id;
	 /*
	   * carbon里对应表主键
	   */
	  private int carbonId;
	 /*
	  * dsp id
	  */
	 private int dspId;
	 /*
	  * 名称
	  */
	 private String name;
	 
	 /*
	  * 所属广告代理ID，多个ID用逗号分隔，为空表明不属于任何代理
	  */
	 private String parent;
	 /*
	  * 是否为代理商,0=否，1=是
	  */
	 private Byte IsAgency;
	 /*
	  * 描述
	  */
	 private String Description;
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
	  * 是否有关联的广告活动
	  */
	 private boolean hasCampaign;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	
	public Byte getIsAgency() {
		return IsAgency;
	}
	public void setIsAgency(Byte isAgency) {
		IsAgency = isAgency;
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
	public int getCarbonId() {
		return carbonId;
	}
	public void setCarbonId(int carbonId) {
		this.carbonId = carbonId;
	}
	public boolean isHasCampaign() {
		return hasCampaign;
	}
	public void setHasCampaign(boolean hasCampaign) {
		this.hasCampaign = hasCampaign;
	}
	 
}
