package com.supertool.dspui.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.supertool.dspui.model.Creative;
import com.supertool.dspui.param.SelectSQLParam;

public interface CreativeMapper {

	public int insertCreative(Creative creative);
	
	public Creative getCreativeById(int id);
	
	public int saveCreative(Creative creative);

	public boolean checkName(Map<String, Object> m);
	
	public int  getMaterialCountByCreativeId(int id);
	
	public List<Creative> getPagedCreatives(SelectSQLParam param);
	public int getCreativesCount(SelectSQLParam param);
	
	public boolean isUsedByRtb(int id);

	public void deleteCreativeById(Integer id);

	public List<Integer> getMaterialIdsByCreativeId(Integer id);

	public void batchDeleteMaterials(List<Integer> ids);




	public void batchDeleteAdsByIds(List<Integer> adIds);
	
	public List<Creative> getByCampaignId(Integer campaignId);
	
	public Creative getByCarbonId(Integer id);

	public void deleteCreativesInLocal(List<Integer> creativeIds);
}
