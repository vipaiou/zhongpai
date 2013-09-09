package com.supertool.dspui.dao.zhongpai;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface ProjectMapper {

	int donew(@Param("userId")int userId);

	List<Map<String, Object>> selectByStepAndCreateuser(@Param("step")String step, @Param("userId")int userId);

	void updateBasic(Map<String, Object> map);

	void updateImage(@Param("projectId")Object object, @Param("picture")String picture);

	List<Map<String, Object>> selectCreatedByStepAndCreateuser(@Param("userId")int userId);

	Map<String, Object> selectById(@Param("projectId")int id);

	List<Map<String, Object>> selectByStatus(@Param("status")String status);

	void submitaudit(Map<String, Object> map);

	List<Map<String, Object>> search(Map<String, String> map);

}
