package com.supertool.dspui.dao.zhongpai;

import java.util.List;
import java.util.Map;


public interface CommentMapper {

	int getTopicnumByProjectId(int id);

	List<Map<String, Object>> getTopicByProjectId(int id);

	Object add(Map<String, Object> map);

	List<Map<String, Object>> getFocusedTopicByUserId(int userid);

	List<Map<String, Object>> getCreatedTopicByUserId(int userid);

	Map<String, String> getTopicMetaByProjectId(int id);

	Object getTopicById(int topicid);

	List<Map<String, String>> getCommentsByTopicid(int topicid);

	Object addcomment(Map<String, Object> map);

	List<Map<String, Object>> getReceived(int userid);

	List<Map<String, Object>> getSent(int userid);

}
