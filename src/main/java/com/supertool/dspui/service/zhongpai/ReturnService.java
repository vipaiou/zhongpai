package com.supertool.dspui.service.zhongpai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.zhongpai.ReturnMapper;

@Service
public class ReturnService {
	
	@Autowired
	ReturnMapper returnMapper;

	public Object save(Map<String, Object> map) {
		map.put("createuser", UserContext.getLoginUserId());
		if("false".equals((String)map.get("limit"))){
			map.put("limitnum", 0);
			map.put("limit", 0);
		}else{
			map.put("limit", 1);
		}
		return returnMapper.save(map);
	}

	public List<Map<String, Object>> selectByProjectId(int id) {
		// TODO Auto-generated method stub
		return returnMapper.selectByProjectId(id);
	}

	
}
