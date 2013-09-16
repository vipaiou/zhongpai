package com.supertool.dspui.dao.zhongpai;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface FocusMapper {

	int getFocusnumByProjectId(int id);

	List<Map<String, Object>> getFocusByProjectId(int id);

	void focus(@Param("id")int id, @Param("userid") int loginUserId);

	int checkFocusByUserid(@Param("id")int id, @Param("userid") int loginUserId);
}
