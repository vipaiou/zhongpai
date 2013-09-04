package com.supertool.dspui.model;

import java.io.Serializable;

/**
 * 
 * @author zhouziqiang
 *
 */
public class Adplacement implements Serializable{
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
	 * 名称
	 */
	private String name;
	/*
	 * 广告位宽
	 */
	private int width;
	/*
	 * 广告位高
	 */
	private int height;
	/*
	 * 底价,单位：分/千次曝光
	 */
	private int didFloor;
	/*
	 * 分类ID黑名单，多个ID之间用逗号分隔
	 */
	private String blockCategory;
	/*
	 * 允许的物料类型，多个类型之间用逗号分隔，例如:jpg,gif,swf,png
	 */
	private String allowedMaterial;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getDidFloor() {
		return didFloor;
	}
	public void setDidFloor(int didFloor) {
		this.didFloor = didFloor;
	}
	public String getBlockCategory() {
		return blockCategory;
	}
	public void setBlockCategory(String blockCategory) {
		this.blockCategory = blockCategory;
	}
	public String getAllowedMaterial() {
		return allowedMaterial;
	}
	public void setAllowedMaterial(String allowedMaterial) {
		this.allowedMaterial = allowedMaterial;
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
	
	   
	   
}
