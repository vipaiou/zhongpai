package com.supertool.dspui.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author zhouziqiang
 * 
 */
public class Datasource implements Serializable {

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
	 * 创建数据源的DSP ID
	 */
	private int ownerDspId;

	/*
	 * 名称
	 */
	private String name;
	/*
	 * 数据源类型SET,MAP
	 */
	private String type;

	/*
	 * 数据源key分隔符
	 */
	private String keySeperator;

	/*
	 * 数据源value分隔符
	 */
	private String valueSeperator;
	
	/*
	 * 备注
	 */
	private String remark;

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
	/*
	 * 是否删除,0=否，1=是
	 */
	private Byte isDeleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarbonId() {
		return carbonId;
	}

	public void setCarbonId(int carbonId) {
		this.carbonId = carbonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getOwnerDspId() {
		return ownerDspId;
	}

	public void setOwnerDspId(int ownerDspId) {
		this.ownerDspId = ownerDspId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeySeperator() {
		return keySeperator;
	}

	public void setKeySeperator(String keySeperator) {
		this.keySeperator = keySeperator;
	}

	public String getValueSeperator() {
		return valueSeperator;
	}

	public void setValueSeperator(String valueSeperator) {
		this.valueSeperator = valueSeperator;
	}

	public Byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
