package com.supertool.dspui.service.zhongpai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.zhongpai.TopicMapper;

@Service
public class TopicService {

	@Autowired
	TopicMapper topicMapper;
	
	public int getTopicnumByProjectId(int id) {
		return topicMapper.getTopicnumByProjectId(id);
	}

	public List<Map<String, Object>> getTopicByProjectId(int id) {
		return topicMapper.getTopicByProjectId(id);
	}

	public Object add(Map<String, Object> map) {
		map.put("userid", UserContext.getLoginUserId());
		if(map.get("pid") == null){
			map.put("pid", "0");
		}
		return topicMapper.add(map);
	}

	
}
