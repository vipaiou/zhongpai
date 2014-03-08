package com.supertool.dspui.service.zhongpai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.zhongpai.CommentMapper;
import com.supertool.dspui.dao.zhongpai.TopicMapper;

@Service
public class CommentService {

	@Autowired
	TopicMapper topicMapper;
	
	@Autowired
	CommentMapper commentMapper;
	
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

	public List<Map<String, Object>> getFocusedTopicByUserId() {
		return topicMapper.getFocusedTopicByUserId(UserContext.getLoginUserId());
	}

	public List<Map<String, Object>> getCreatedTopicByUserId() {
		return topicMapper.getCreatedTopicByUserId(UserContext.getLoginUserId());
	}

	public Map<String, String> getTopicMetaByProjectId(int id) {
		return topicMapper.getTopicMetaByProjectId(id);
	}

	public Object getTopicById(int topicid) {
		return topicMapper.getTopicById(topicid);
	}

	public List<Map<String, String>> getCommentsByTopicid(int topicid) {
		return topicMapper.getCommentsByTopicid(topicid);
	}

	public Object addcomment(Map<String, Object> map) {
		map.put("userid", UserContext.getLoginUserId());
		return commentMapper.addcomment(map);
	}

	public List<Map<String, Object>> getReceived() {
		return commentMapper.getReceived(UserContext.getLoginUserId());
	}

	public List<Map<String, Object>> getSent() {
		return commentMapper.getSent(UserContext.getLoginUserId());
	}

	
}
