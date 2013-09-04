package com.supertool.dspui.dao.zhongpai;

import java.util.List;
import java.util.Map;


public interface FocusMapper {

	int getFocusnumByProjectId(int id);

	List<Map<String, Object>> getFocusByProjectId(int id);
}
