package com.supertool.dspui.service.zhongpai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.zhongpai.ActivityMapper;
import com.supertool.dspui.dao.zhongpai.CategoryMapper;
import com.supertool.dspui.dao.zhongpai.ProjectMapper;
import com.supertool.dspui.util.VideoUtil;

@Service
public class CategoryService {
	
	@Autowired
	CategoryMapper categoryMapper;
	
	public void add(Map<String, Object> map) {		
		map.put("userid", UserContext.getLoginUserId());
		categoryMapper.add(map);
	}

	public List<Map<String, Object>> getAll() {
		return categoryMapper.getAll();
	}

	
}
