package com.supertool.dspui.service.zhongpai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.zhongpai.CommentMapper;
import com.supertool.dspui.dao.zhongpai.MessageMapper;
import com.supertool.dspui.dao.zhongpai.TopicMapper;

@Service
public class MessageService {

	@Autowired
	TopicMapper topicMapper;
	
	@Autowired
	CommentMapper commentMapper;
	
	@Autowired
	MessageMapper messageMapper;
	
	public Object add(Map<String, Object> map) {
		map.put("userid", UserContext.getLoginUserId());
		return messageMapper.add(map);
	}

	public Object getById(int messageid) {
		return messageMapper.getById(messageid);
	}

	public List<Map<String, Object>> getReceived() {
		return messageMapper.getReceived(UserContext.getLoginUserId());
	}

	public List<Map<String, Object>> getSent() {
		return messageMapper.getSent(UserContext.getLoginUserId());
	}

	public List<Map<String, Object>> getContactor() {
		return messageMapper.getContactor(UserContext.getLoginUserId());
	}

	public List<Map<String, Object>> getdialogue(int with) {
		return messageMapper.getDialogue(UserContext.getLoginUserId(), with);
	}

	
}
