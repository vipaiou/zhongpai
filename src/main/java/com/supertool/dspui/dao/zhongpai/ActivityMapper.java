package com.supertool.dspui.dao.zhongpai;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface ActivityMapper {

	void add(Map<String, Object> map);

	List<Map<String, Object>> getActivityByUserid(@Param("userid") int userid);

}
