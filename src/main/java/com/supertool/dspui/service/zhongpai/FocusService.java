package com.supertool.dspui.service.zhongpai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.dao.zhongpai.FocusMapper;

@Service
public class FocusService {
	
	@Autowired
	FocusMapper focusMapper;

	public List<Map<String, Object>> getFocusByProjectId(int id) {
		return focusMapper.getFocusByProjectId(id);
	}

	public int getFocusnumByProjectId(int id) {
		return focusMapper.getFocusnumByProjectId(id);
	}

	
}
