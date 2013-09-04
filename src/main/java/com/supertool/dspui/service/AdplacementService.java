package com.supertool.dspui.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.exception.CarbonBadResponseException;
import com.supertool.dspui.util.TalkWithCarbon;
import com.supertool.dspui.vo.AdplacementBasicVO;
import com.supertool.dspui.vo.AdplacementVO;

@Service
@SuppressWarnings("unchecked")
public class AdplacementService {

	public List<AdplacementVO> listAdplacement(int param[]) {

		List<AdplacementVO> list = getAllAdplacements();
		if (param != null)
			return getSubList(list, param);
		return list;
	}

	public List<AdplacementVO> listAdplacementByType(String type, int param[]) {

		List<AdplacementVO> list = getAllAdplacements();
		list = findAdplacementByType(type, list);
		if (param != null)
			return getSubList(list, param);
		return list;
	}

	public List<AdplacementVO> listAdplacementByNameOrId(String nameorid,
			int param[]) {

		List<AdplacementVO> list = getAllAdplacements();
		list = findAdplacementByType(nameorid, list);
		if (param != null)
			return getSubList(list, param);
		return list;
	}

	public List<AdplacementVO> listAdplacementByAll(String type,
			String nameorid, int param[]) {

		List<AdplacementVO> list = getAllAdplacements();
		list = findAdplacementByAll(type, nameorid, list);
		if (param != null)
			return getSubList(list, param);
		return list;
	}

	public List<AdplacementVO> findAdplacementByType(String type,
			List<AdplacementVO> list) {
		List<AdplacementVO> result = new ArrayList<AdplacementVO>();

		if (!"all".equals(type)) {
			for (AdplacementVO a : list) {
				if (a.getAllowedTypes().contains(type)) {
					result.add(a);
				}
			}
			return result;
		}
		return list;
	}

	public List<AdplacementVO> findAdplacementByNameOrId(String nameorid,
			List<AdplacementVO> list) {

		List<AdplacementVO> result = new ArrayList<AdplacementVO>();

		for (AdplacementVO a : list) {
			if (a.getId().equals(nameorid) || a.getName().contains(nameorid)) {
				result.add(a);
			}
		}
		return result;
	}

	public List<AdplacementVO> findAdplacementByAll(String type,
			String nameorid, List<AdplacementVO> list) {

		List<AdplacementVO> result = new ArrayList<AdplacementVO>();
		result = findAdplacementByNameOrId(nameorid, list);
		result = findAdplacementByType(type, result);
		return result;
	}

	@SuppressWarnings("rawtypes")
	public List getSubList(List list,
			int param[]) {
		int listsize = list.size();
		int currentPage = param[0];
		int pageSize = param[1];
		if (currentPage <= 0) {
			currentPage = 1;
		}

		if (pageSize <= 0) {
			pageSize = Constant.PAGESIZE;
		}

		int offset = (currentPage - 1) * pageSize;
		if (listsize < pageSize)
			return list;
		else if ((offset + pageSize) <= listsize)
			return list.subList(offset, offset + pageSize);
		else
			return list.subList(offset, listsize);
	}

	public List<AdplacementVO> getAllAdplacements() {
		return getAdplacementBasicVO().getData();
	}

	
	public AdplacementBasicVO getAdplacementBasicVO() {
		String url = Config.getCarbonHost() + "/adplacement/list";
		TalkWithCarbon twc = new TalkWithCarbon();
		twc.setHasParams(false);
		twc.setRequestMethod(twc.getPOST_METHOD());
		twc.setUrl(url);
		String result;
		AdplacementBasicVO aj = null;
		try {
			result = twc.sendPostRequest();
			ObjectMapper mapper = new ObjectMapper();
			aj = mapper.readValue(result,
					AdplacementBasicVO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		if(aj.getStatusCode() != Constant.CARBON_STATUS_CODE_SUCCESS) {
			String adplacementMessage = aj.getMessage();
			throw new CarbonBadResponseException(adplacementMessage);
		}
		
		return aj;
	}
	
	public List<AdplacementVO> findAdplacementByIds(List<String> ids,
			List<AdplacementVO> list, boolean notin) {

		List<AdplacementVO> result = new ArrayList<AdplacementVO>();

		for (AdplacementVO a : list) {
			if(!notin){
				if(ids.contains(a.getId())){
					result.add(a);
				}
			}else{
				if(!ids.contains(a.getId())){
					result.add(a);
				}
			}
		}
		return result;
	}
	
	public List<String> getAllSizes() {
		List<String> list = new ArrayList<String>();
		List<AdplacementVO> adplacementVOList = getAllAdplacements();
		for (AdplacementVO adplacementVO : adplacementVOList) {
			String width = adplacementVO.getWidth();
			String height = adplacementVO.getHeight();
			String size = width + "*" + height;
			if (!list.contains(size)) {
				list.add(size);
			}
		}
		Collections.sort(list);
		Collections.reverse(list);
		return list;
	}

}
