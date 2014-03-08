package com.supertool.dspui.dao.zhongpai;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface MessageMapper {

	Object add(Map<String, Object> map);

	List<Map<String, Object>> getReceived(int userid);

	List<Map<String, Object>> getSent(int userid);

	Object getById(int messageid);

	List<Map<String, Object>> getContactor(int userid);

	List<Map<String, Object>> getDialogue(@Param("userid") int userid,@Param("with") int with);

}
