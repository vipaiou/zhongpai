package com.supertool.dspui.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.supertool.dspui.model.Creative;
import com.supertool.dspui.model.Material;
import com.supertool.dspui.model.Rtb;
import com.supertool.dspui.param.SelectSQLParam;
import com.supertool.dspui.vo.MaterialAuditVO;

public interface MaterialMapper {

	public int insertIntoMaterial(Material material);

	public boolean checkName(Map<String,Object> m);
	public int updateMaterial(Material material);

	public List<Material> getPagedMaterials(SelectSQLParam selectParams);

	public int getMaterialsCount(SelectSQLParam selectParams);
	
	public int getMaterialRtbCount(int creativeId);

	public void batchDeleteAdsRelationByIds(List<Integer> adIds);
	public List<Integer> getAdIdsByMaterialIds(List<Integer> ids);

	public Material getMaterial(Integer id);
	
	public List<Material> getPagedListForRtb(Map<String, Object> map);
	
	public Integer getCountForRtb(Map<String, Object> map);
	
	public void updateStatus(Map<String, Object> map);

	public List<Rtb> getPagedMaterialRtbs(SelectSQLParam selectParams);

	public int getMaterialRtbCount(SelectSQLParam selectParams);

	public int getMaterialRtbListCount(SelectSQLParam selectParams);
	public boolean getCannotbeDeleted(int id);

	public void deleteMaterialAround(Integer id);

	public void deleteMaterial(Integer id);
	
	public List<MaterialAuditVO> getPagedMaterialAuditList(Map<String, Object> map);
	
	public Integer getMaterialAuditCount(Map<String, Object> params);

	public List<Integer> getMaterialIdsByCreativeIds(List<Integer> creativeIds);

	public void deleteMaterialsByIds(List<Integer> materialIds);

}
