package com.supertool.dspui.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.dao.mybatis.RtbAdplacementMaterialMapper;
import com.supertool.dspui.model.RtbAdplacementMaterial;
import com.supertool.dspui.vo.AdplacementVO;
import com.supertool.dspui.vo.RTBAdplacementVO;

@Service
public class RtbAdplacementService {
	
	@Autowired
	private RtbAdplacementMaterialMapper rtbAdplacementMaterialMapper;
	
	@Autowired
	private MaterialService materialService;

	public List<RTBAdplacementVO> list(List<AdplacementVO> list,Object filter_param[]) {
		List<RTBAdplacementVO> result = new ArrayList<RTBAdplacementVO>();
		
		for(AdplacementVO adplacementVO:list) {
			
			if(filter(adplacementVO,filter_param)) {
				RTBAdplacementVO rtpAdplacementVO = new RTBAdplacementVO();
				rtpAdplacementVO.setId(Integer.parseInt(adplacementVO.getId()));
				rtpAdplacementVO.setName(adplacementVO.getName());
				rtpAdplacementVO.setFileType(adplacementVO.getAllowedTypes());
				rtpAdplacementVO.setWidth(adplacementVO.getWidth());
				rtpAdplacementVO.setHeight(adplacementVO.getHeight());
				
				if(adplacementVO.getName() != null && !"".equals(adplacementVO.getName())) {
					String name[] = adplacementVO.getName().split("-");
					
					if(name.length > 1) {
						rtpAdplacementVO.setPublisher(name[0]);
						rtpAdplacementVO.setChannels(name[1]);
					} else {
						rtpAdplacementVO.setPublisher(name[0]);
						rtpAdplacementVO.setChannels(name[0]);
					}
				}
				result.add(rtpAdplacementVO);
			}
			
		}
		
		return result;
	}
	
	public boolean filter(AdplacementVO adplacementVO,Object filter_param[]) {
		
		String materialType = (String)filter_param[0];
		String containedKeyword = (String)filter_param[1];
		String notContainedKeyword = (String)filter_param[2];
		String[] sizeArray = (String[])filter_param[3];
		
		if(materialType != null && !"".equals(materialType)) {
			boolean flag = false;
			String type[] =  materialType.split(",");
			for(String t:type) {
				if(adplacementVO.getAllowedTypes().contains(t)) {
					flag = true;
					break;
				}
			}
			
			if(!flag)
				return flag;
		}
		
		if (containedKeyword != null && !"".equals(containedKeyword)) {
			boolean flag = false;
			String[] keywords = containedKeyword.split(" ");
			for (String keyword : keywords) {
				if (adplacementVO.getName().contains(keyword)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return flag;
			}
		}
		
		if (notContainedKeyword != null && !"".equals(notContainedKeyword)) {
			String[] keywords = notContainedKeyword.split(" ");
			for (String keyword : keywords) {
				if (adplacementVO.getName().contains(keyword)) {
					return false;
				}
			}
		}
		
		if(sizeArray != null && sizeArray.length > 0){
			for(String size : sizeArray){
				if(size.equals(adplacementVO.getWidth() + "*" + adplacementVO.getHeight())) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	public List<RTBAdplacementVO> showList(List<AdplacementVO> list) {
		List<RTBAdplacementVO> result = new ArrayList<RTBAdplacementVO>();
		if (null == list || list.size() == 0) {
			return result;
		}
		for (AdplacementVO adplacementVO : list) {

			RTBAdplacementVO rtpAdplacementVO = new RTBAdplacementVO();
			rtpAdplacementVO.setId(Integer.parseInt(adplacementVO.getId()));
			rtpAdplacementVO.setName(adplacementVO.getName());
			rtpAdplacementVO.setFileType(adplacementVO.getAllowedTypes());
			rtpAdplacementVO.setWidth(adplacementVO.getWidth());
			rtpAdplacementVO.setHeight(adplacementVO.getHeight());
			
			if (adplacementVO.getName() != null
					&& !"".equals(adplacementVO.getName())) {
				String name[] = adplacementVO.getName().split("-");

				if (name.length > 1) {
					rtpAdplacementVO.setPublisher(name[0]);
					rtpAdplacementVO.setChannels(name[1]);
				} else {
					rtpAdplacementVO.setPublisher(name[0]);
					rtpAdplacementVO.setChannels(name[0]);
				}
			}
			result.add(rtpAdplacementVO);
		}
		return result;
	}
	
	public List<HashMap<String, Object>> getAMRelation(Integer rtbId) {
		List<Integer> materialIds = new ArrayList<Integer>();
		Map<Integer, Integer> materialStatusMap = new HashMap<Integer, Integer>();
		List<HashMap<String, Object>> amInfoLIst = rtbAdplacementMaterialMapper
				.getAMInfoByRtbId(rtbId);
		for (HashMap<String, Object> amInfo : amInfoLIst) {
			materialIds.add((Integer) amInfo.get("materialCarbonId"));
		}
		materialStatusMap = materialService.getMaterialStatusMap(materialIds);
		for (HashMap<String, Object> amInfo : amInfoLIst) {
			Integer materialStatus = materialStatusMap.get(amInfo
					.get("materialCarbonId"));
			if (null == materialStatus) {
				amInfo.put("materialStatus", -1);
			} else {
				amInfo.put("materialStatus", materialStatus);
			}
		}
		return amInfoLIst;
	}
}
