package com.supertool.dspui.vo;

import java.io.Serializable;
import java.util.List;

public class CampaignMaterialVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int carbonId;
	
	private List<Integer> materialIds;

	public int getCarbonId() {
		return carbonId;
	}

	public void setCarbonId(int carbonId) {
		this.carbonId = carbonId;
	}

	public List<Integer> getMaterialIds() {
		return materialIds;
	}

	public void setMaterialIds(List<Integer> materialIds) {
		this.materialIds = materialIds;
	}
}
