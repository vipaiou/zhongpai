package com.supertool.dspui.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.mybatis.SettingMapper;
import com.supertool.dspui.model.Setting;
import com.supertool.dspui.param.form.SettingForm;
import com.supertool.dspui.vo.ResultVO;
import com.supertool.dspui.vo.SettingVO;

@Service
public class SettingService {

	@Autowired
	private SettingMapper settingMapper;
	
	public SettingVO getSettingVO() {
		int dspid = UserContext.getDspId();
		Setting setting = settingMapper.getSetting(dspid);
		SettingVO settingVO = new SettingVO();
		if(null == setting){
			setting = new Setting();
		}
		settingVO.setFlvsize(setting.getFlvsize());
		settingVO.setSwfsize(setting.getSwfsize());
		settingVO.setImgsize(setting.getImgsize());
	
		return settingVO;
	}
	
	public ResultVO updateSetting(SettingForm settingForm) {
		
		if(settingForm.getFlv_size() <= 0)
			settingForm.setFlv_size(1500);
		if(settingForm.getSwf_size() <= 0)
			settingForm.setSwf_size(500);
		if(settingForm.getImg_size() <= 0)
			settingForm.setImg_size(150);
		
		int dspid = UserContext.getDspId();
		ResultVO resultVO = new ResultVO();
		Setting setting = settingMapper.getSetting(dspid);
		if(null == setting){
			setting = new Setting();
			setting.setDspid(dspid);
			setting.setFlvsize(settingForm.getFlv_size());
			setting.setSwfsize(settingForm.getSwf_size());
			setting.setImgsize(settingForm.getImg_size());
			int result  = settingMapper.insert(setting);
			if(result>0){
				resultVO.setMessage("操作成功!");
				resultVO.setResultCode(1);
			}else{
				throw new RuntimeException("本地更新系统设置失败！");		
			}
			return resultVO;
			
		}
		setting.setFlvsize(settingForm.getFlv_size());
		setting.setSwfsize(settingForm.getSwf_size());
		setting.setImgsize(settingForm.getImg_size());
		int result = settingMapper.updateSetting(setting);
		
		if(result>0){
			resultVO.setMessage("操作成功!");
			resultVO.setResultCode(1);
		}else{
			throw new RuntimeException("本地更新系统设置失败！");		
		}
		return resultVO;
	}

	public boolean check(Map<String, String> map) {
		if(map != null && map.size() > 0) {
			
			if(map.containsKey("flv")) {
				String flv = map.get("flv").trim();
				if(flv == null || "".equals(flv))
					return true;
				return flv.matches("^\\+?[1-9][0-9]*$");
			} else if(map.containsKey("swf")) {
				String swf = map.get("swf").trim();
				if(swf == null || "".equals(swf))
					return true;
				return swf.matches("^\\+?[1-9][0-9]*$");
			} else if(map.containsKey("img")) {
				String img = map.get("img").trim();
				if(img == null || "".equals(img))
					return true;
				return img.matches("^\\+?[1-9][0-9]*$");
			} else {
				return false;
			}
		}
		return false;
	}
}
