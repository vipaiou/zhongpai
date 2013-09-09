package com.supertool.dspui.service.zhongpai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.zhongpai.ActivityMapper;
import com.supertool.dspui.dao.zhongpai.ProjectMapper;
import com.supertool.dspui.util.VideoUtil;

@Service
public class ActivityService {
	
	@Autowired
	ActivityMapper activityMapper;
	
	public void add(Map<String, Object> map) {
		map.put("userid", UserContext.getLoginUserId());
		activityMapper.add(map);
	}

	public List<Map<String, Object>> getActivityByUserid(int userid) {
		return activityMapper.getActivityByUserid(userid);
	}

	
}
