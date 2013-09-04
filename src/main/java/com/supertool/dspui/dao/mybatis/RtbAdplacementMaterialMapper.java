package com.supertool.dspui.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.supertool.dspui.model.RtbAdplacementMaterial;

public interface RtbAdplacementMaterialMapper {

	public void add(RtbAdplacementMaterial rtbRelation);

	public void deleteByRtbId(Integer rtbId);

	public List<RtbAdplacementMaterial> getByAppointedIds(
			Map<String, Object> map);

	public List<RtbAdplacementMaterial> getByRtbId(Integer rtbId);
	
	public List<HashMap<String, Object>> getAMInfoByRtbId(Integer rtbId);
}
