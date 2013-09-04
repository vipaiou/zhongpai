package com.supertool.dspui.service.zhongpai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.zhongpai.ProjectMapper;
import com.supertool.dspui.util.VideoUtil;

@Service
public class ProjectService {
	
	@Autowired
	ProjectMapper projectMapper;
	
	public int add(){
		List<Map<String,Object>> projects = projectMapper.selectByStepAndCreateuser("0", UserContext.getLoginUserId());
		if(projects != null && projects.size() > 0){
			Map<String,Object> project = projects.get(0);
			long id= (Long)project.get("id");
			return (int)id;
		}else{
			int id = projectMapper.donew(UserContext.getLoginUserId());
			return id;
		}
	}

	public void editbasic(Map<String, Object> map) {
		map.put("content", map.get("editorValue"));
		String videocode = "" ;
		if(map.get("video") != null && !((String)map.get("video")).isEmpty()){
			videocode = VideoUtil.getVideoHtml((String)map.get("video"));
		}
		map.put("videocode", videocode);
		projectMapper.updateBasic(map);
	}

	public void updateImage(Object object, String fileMD5String) {
		projectMapper.updateImage(object, fileMD5String);
	}

	public List<Map<String, Object>> created() {
		return projectMapper.selectCreatedByStepAndCreateuser(UserContext.getLoginUserId());
	}

	public Map<?, ?> selectById(int id) {
		return projectMapper.selectById(id);
	}

	public List<Map<String, Object>> selectByStatus(String status) {
		return projectMapper.selectByStatus(status);
	}

	public void submitaudit(Map<String, Object> map) {
		projectMapper.submitaudit(map);
	}

	
}
