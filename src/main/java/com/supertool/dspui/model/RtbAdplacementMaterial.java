package com.supertool.dspui.model;

import java.io.Serializable;

/**
 * 
 * @author zhouziqiang
 *
 */
public class RtbAdplacementMaterial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 主键，自增
	 */
	private int id;
	/*
	 * rtb规则ID
	 */
	private int rtbId;
	/*
	 * 物料ID
	 */
	private int materialId;
	/*
	 * 广告位ID
	 */
	private int adPlacementId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRtbId() {
		return rtbId;
	}
	public void setRtbId(int rtbId) {
		this.rtbId = rtbId;
	}
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getAdPlacementId() {
		return adPlacementId;
	}
	public void setAdPlacementId(int adPlacementId) {
		this.adPlacementId = adPlacementId;
	}
	

}
