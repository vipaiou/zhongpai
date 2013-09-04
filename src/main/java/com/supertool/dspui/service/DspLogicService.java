package com.supertool.dspui.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.dao.mybatis.DspLogicMapper;
import com.supertool.dspui.exception.CarbonBadResponseException;
import com.supertool.dspui.model.Dsp;
import com.supertool.dspui.model.DspLogic;
import com.supertool.dspui.param.form.DspLogicForm;
import com.supertool.dspui.util.TalkWithCarbon;
import com.supertool.dspui.vo.CarbonResultVO;
import com.supertool.dspui.vo.ResultVO;

@Service
public class DspLogicService {
	
	@Autowired
	private DspLogicMapper dspLogicMapper;
	
	public List<DspLogic> listDspLogic(int param[]) {
		return dspLogicMapper.getDspLogicAll(param[0], param[1]);
	}
	
	public List<DspLogic> listDspLogicByNameorid(String nameorid,int param[]) {
		return dspLogicMapper.getDspLogicByNameorid(nameorid,param[0], param[1]);
	}
	
	public String addDspLogic(DspLogicForm dspLogicForm) {
		DspLogic dspLogic = new DspLogic();
		
		CarbonResultVO carbonResultVO = addDspLogicToCarbon(dspLogicForm.getDspid(),dspLogicForm.getToken().trim());
		if(carbonResultVO.getStatusCode() != 200) {
			throw new CarbonBadResponseException(carbonResultVO.getMessage());
		}
		dspLogic.setId(dspLogicForm.getId());
		dspLogic.setDspId(dspLogicForm.getDspid());
		dspLogic.setToken(dspLogicForm.getToken().trim());
		dspLogic.setName(dspLogicForm.getName().trim());
		dspLogic.setContacts(dspLogicForm.getContacts().trim());
		dspLogic.setEmail(dspLogicForm.getEmail().trim());
		dspLogic.setPhone(dspLogicForm.getPhone().trim());
		int result = dspLogicMapper.insertDspLogic(dspLogic);
		
		if(result > 0) {
			return dspLogic.getName();
		} 
		return null;
	}
	
	public String updateDspLogic(DspLogicForm dspLogicForm) {
		DspLogic dspLogic = new DspLogic();
		CarbonResultVO carbonResultVO = updateDspLogicToCarbon(dspLogicForm.getDspid(),dspLogicForm.getToken().trim());
		if(carbonResultVO.getStatusCode() != 200) {
			throw new CarbonBadResponseException(carbonResultVO.getMessage());
		}
		dspLogic.setId(dspLogicForm.getId());
		dspLogic.setDspId(dspLogicForm.getDspid());
		dspLogic.setToken(dspLogicForm.getToken().trim());
		dspLogic.setName(dspLogicForm.getName().trim());
		dspLogic.setContacts(dspLogicForm.getContacts().trim());
		dspLogic.setEmail(dspLogicForm.getEmail().trim());
		dspLogic.setPhone(dspLogicForm.getPhone().trim());
		
		int result = dspLogicMapper.updateDspLogic(dspLogic);
		if(result > 0) {
			return dspLogic.getName();
		}
		return null;
	}
	
	public Dsp getDspLogicByDspId(int dspId) {
		Dsp dsp = dspLogicMapper.getDspByDspId(dspId);
		return dsp;
	}
	


	
	private CarbonResultVO addDspLogicToCarbon(int dspid, String token) {
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", dspid);
		params.put("token", token);
		params.put("desc", "");
		
		TalkWithCarbon talkWithCarbon = new TalkWithCarbon();
		JSONObject object = talkWithCarbon.getCarbonVOJson(params, Config.getCarbonHost() +"/dsp/add");
		ObjectMapper mapper = new ObjectMapper();
		CarbonResultVO carbonResultVO = null;
		try {
			carbonResultVO = mapper.readValue(object.toString(),CarbonResultVO.class);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return carbonResultVO;
	}
	
	private CarbonResultVO updateDspLogicToCarbon(int dspid, String token) {
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", dspid);
		params.put("token", token);
		params.put("desc", "");
		
		TalkWithCarbon talkWithCarbon = new TalkWithCarbon();
		JSONObject object = talkWithCarbon.getCarbonVOJson(params, Config.getCarbonHost() +"/dsp/update");
		ObjectMapper mapper = new ObjectMapper();
		CarbonResultVO carbonResultVO = null;
		try {
			carbonResultVO = mapper.readValue(object.toString(),CarbonResultVO.class);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return carbonResultVO;
	}
	
}
