package com.supertool.dspui.service.zhongpai;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

	public List<Map<String, Object>> search(String c) {
		String[] cs = c.split("_");
		Map<String,String> map = new HashMap<String, String>();
		map.put("status", cs[0]);
		map.put("category", cs[1]);
		map.put("province", cs[2]);
		map.put("order", cs[3]);
		List<Map<String, Object>> results = projectMapper.search(map);
		for(int i = 0 ; i < results.size(); i++){
			Map<String, Object> project = results.get(i);
			int focusnum = Integer.parseInt(project.get("focusnum").toString());
			int money = Integer.parseInt(project.get("money").toString());
			int totalmoney = Integer.parseInt(project.get("totalmoney").toString());
			try{
				int hotratio = 100*focusnum/Integer.parseInt(project.get("targetfocusnum").toString());
				project.put("hotradio", hotratio);
			}catch (Exception e) {
				project.put("hotradio", "-");
			}
			try{
				int supportratio = 100*totalmoney/money;
				project.put("supportratio", supportratio);
			}catch (Exception e) {
				project.put("supportratio", "-");
			}
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				int preparedays = (int)((new Date().getTime() - df.parse(project.get("begintime").toString().substring(0, 19)).getTime())/1000/60/60/24);
				project.put("preparedays", preparedays);
			} catch (ParseException e) {
				int preparedays = 0;
				project.put("preparedays", preparedays);
			}
			try {
				int pastdays = (int)((new Date().getTime() - df.parse(project.get("starttime").toString().substring(0, 19)).getTime())/1000/60/60/24);
				int remaindays = Integer.parseInt(project.get("day").toString()) - pastdays;
				project.put("remaindays", remaindays);
			} catch (ParseException e) {
				int remaindays = 0;
				project.put("remaindays", remaindays);
			}
		}
		return results;
	}

	public List<Map<String, Object>> favorite() {
		return projectMapper.selectByFavoriteUserid(UserContext.getLoginUserId());
	}

	public List<Map<String, Object>> supported() {
		return projectMapper.selectBySupportUserid(UserContext.getLoginUserId());
	}

	public void updateViewtime(int id) {
		projectMapper.updateViewtime(id);
		
	}

	
}
