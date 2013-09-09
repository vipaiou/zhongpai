package com.supertool.dspui.dao.zhongpai;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface CategoryMapper {

	void add(Map<String, Object> map);

	List<Map<String, Object>> getAll();

}
