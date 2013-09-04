package com.supertool.dspui.model;

import java.io.Serializable;
import java.util.Date;

import com.supertool.dspui.util.StringUtil;

/**
 * 
 * @author zhouziqiang
 *
 */
public class Material implements Serializable{
	  
	

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	  * 主键，自增
	 */   
	private int id;
	/*
	 * carbon里对应表主键
	 */
	private int carbonId;
	/*
	 * dsp对应id
	 */
	private int dspId;
	/*
	 * 名称
	 */
	private String name;
	/*
	 * 创意Id
	 */
	private int creativeId;
	
	private String creativeName;
	
	private String materialStatusInfo;
	
	
	
	public String getCreativeName() {
		return creativeName;
	}
	public void setCreativeName(String creativeName) {
		this.creativeName = StringUtil.trimSRN(creativeName);
	}
	public int getCreativeId() {
		return creativeId;
	}
	/*
	 * 广告活动Id
	 */
	private int campaignId;
	private String campaignName;

	/*
	 * 创意carbonId
	 */
	private int creativeCarbonId;
	
	/*
	 * 物料类型
	 */
	private String type;
	/*
	 * 物料宽
	 */
	private int width;
	/*
	 * 物料高
	 */
	private int height;
	/*
	 * 物料大小，单位byte
	 */
	private long fileSize;
	/*
	 * 时长
	 */
	private int duration;
	/*
	 * 审核不通过原因
	 */
	private String rejectReason;
	/*
	 * 0=审核中,1=审核拒绝,2=审核通过
	 */
	private String status;
	/*
	 * 物料地址
	 */
	private String previewUrl;

	/*
	 * 描述
	 */
	
	private String description;
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
	private Date deleteTime;
	
	private int isDeleted ;
	
	/*
	 * 宽*高
	 */
	private String materialSize;
	
	/*
	 * 大小
	 */
	private String fileSizeStr;
	private int rtbCount;
	/*
	 * 是否删除
	 */
	/*
	 *
	 * 上传方式
	 */
	private String mode;
	
	/*
	 * 是否可以删除
	 */
	private boolean cannotbeDeleted;
	
	/*
	 * 物料文件扩展名
	 */
	private String extension;
	
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
		return StringUtil.trimSRN(name);
	}
	public void setName(String name) {
		this.name = StringUtil.trimSRN(name);
	}
	public int get() {
		return creativeId;
	}
	public void setCreativeId(int creativeId) {
		this.creativeId = creativeId;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = StringUtil.trimSRN(description);
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getCarbonId() {
		return carbonId;
	}
	public void setCarbonId(int carbonId) {
		this.carbonId = carbonId;
	}

	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}



	public int getCreativeCarbonId() {
		return creativeCarbonId;
	}
	public void setCreativeCarbonId(int creativeCarbonId) {
		this.creativeCarbonId = creativeCarbonId;
	}
	public String getPreviewUrl() {
		return previewUrl;
	}
	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

	public String getMaterialSize() {
		return materialSize;
	}
	public void setMaterialSize(String materialSize) {
		this.materialSize = materialSize;
	}
	public int getRtbCount() {
		return rtbCount;
	}
	public void setRtbCount(int rtbCount) {
		this.rtbCount = rtbCount;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = StringUtil.trimSRN(campaignName);
	}
	public boolean isCannotbeDeleted() {
		return cannotbeDeleted;
	}
	public void setCannotbeDeleted(boolean cannotbeDeleted) {
		this.cannotbeDeleted = cannotbeDeleted;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getFileSizeStr() {
		return fileSizeStr;
	}
	public void setFileSizeStr(String fileSizeStr) {
		this.fileSizeStr = fileSizeStr;
	}
	public String getMaterialStatusInfo() {
		return materialStatusInfo;
	}
	public void setMaterialStatusInfo(String materialStatusInfo) {
		this.materialStatusInfo = materialStatusInfo;
	}
	
}
