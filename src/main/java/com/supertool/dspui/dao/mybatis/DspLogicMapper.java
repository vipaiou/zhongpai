package com.supertool.dspui.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.supertool.dspui.model.Dsp;
import com.supertool.dspui.model.DspLogic;

public interface DspLogicMapper {
	
	public int insertDspLogic(DspLogic dspLogic);
	
	public int deleteDspLogic(int id);
	
	public int updateDspLogic(DspLogic dspLogic);
	
	public Dsp getDspByDspId(int dspId);
	
	public List<DspLogic> getDspLogicAll(@Param("offset") int offset,@Param("pageSize") int pageSize);
	
	public List<DspLogic> getDspLogicByNameorid(@Param("nameorid") String nameorid,@Param("offset") int offset,@Param("pageSize") int pageSize);
	
}
