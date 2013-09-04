package com.supertool.dspui.dao.mybatis;

public interface CampaignAroundMapper {

	/**
	 * 删除广告活动对应的rtb
	 * @param campaign
	 * @return
	 */
	public int deleteCampaignRelatedRtb(int campaign);
	
}
