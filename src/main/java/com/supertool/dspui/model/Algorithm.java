package com.supertool.dspui.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 广告主实体
 * @author zhouziqiang
 *
 */
public class Algorithm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 private int id;
	 private int dspId;
	 private int CampaignId;
	 private String name;
	 private String script;
	 private String Description;
	 private Date createTime;
	 private Date updateTime;
	 private Date deleteTime;
	 private Byte isDeleted;
	 
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
	
	public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public int getCampaignId() {
		return CampaignId;
	}
	public void setCampaignId(int campaignId) {
		CampaignId = campaignId;
	}
	 
}
