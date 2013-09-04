package com.supertool.dspui.dao.zhongpai;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface ReturnMapper {

	List<Map<String, Object>> selectByProjectId(@Param("projectId")int id);

	Object save(Map<String, Object> map);

}
