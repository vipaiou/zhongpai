package com.supertool.dspui.dao.zhongpai;

import java.util.List;
import java.util.Map;


public interface TopicMapper {

	int getTopicnumByProjectId(int id);

	List<Map<String, Object>> getTopicByProjectId(int id);

	Object add(Map<String, Object> map);

}
