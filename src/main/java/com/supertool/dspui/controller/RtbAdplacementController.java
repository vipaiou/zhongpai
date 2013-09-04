package com.supertool.dspui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.model.Material;
import com.supertool.dspui.param.form.SelectMaterialPageForm;
import com.supertool.dspui.service.AdplacementService;
import com.supertool.dspui.service.MaterialService;
import com.supertool.dspui.service.RtbAdplacementService;
import com.supertool.dspui.util.JSONUtils;
import com.supertool.dspui.util.Utils;
import com.supertool.dspui.vo.AdplacementVO;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.RTBAdplacementVO;

@RequestMapping("/RTBAdplacement")
@Controller
public class RtbAdplacementController {

	@Autowired
	private RtbAdplacementService rtbAdplacementService;
	
	@Autowired
	private AdplacementService adplacementService;
	
	@Autowired
	private MaterialService materialService;
	
	@RequestMapping("/list")
	public @ResponseBody Page<RTBAdplacementVO> list(int pageNo,int pageSize,String materialType,String containedKeyword,
			String notContainedKeyword, @RequestParam(value="size[]",required=false) String[] size, String mediaIds, String idsNotIn) throws Exception {
		
		Page<RTBAdplacementVO> page = new Page<RTBAdplacementVO>();
		int page_param[] = {pageNo,pageSize};
		Object filter_param[] = {materialType,containedKeyword,notContainedKeyword,size};
		List<String> mediaIdList = JSONUtils.jsonToList(mediaIds, String.class);
		List<String> idsNotInList = JSONUtils.jsonToList(idsNotIn, String.class);
		
		List<AdplacementVO> list = adplacementService.getAllAdplacements();
		if(null != mediaIdList){
			list = adplacementService.findAdplacementByIds(mediaIdList, list, false);
		}
		if(null != idsNotInList){
			list = adplacementService.findAdplacementByIds(idsNotInList, list, true);
		}
		
		List<RTBAdplacementVO> result = rtbAdplacementService.list(list,filter_param);
		int totalRecords = result.size(); 
		result = adplacementService.getSubList(result, page_param);
		
		int totalPages = Utils.getTotalPage(totalRecords, pageSize);
		
		page.setPageNo(pageNo);
		page.setRows(result);
		page.setPageSize(pageSize);
		page.setTotalRecords(totalRecords);
		page.setTotalPages(totalPages);
		return page;
	}
	
	@RequestMapping("/show")
	public @ResponseBody
	Page<RTBAdplacementVO> show(int pageNo, int pageSize, String mediaIds)
			throws Exception {

		Page<RTBAdplacementVO> page = new Page<RTBAdplacementVO>();
		int page_param[] = { pageNo, pageSize };
		List<String> mediaIdList = JSONUtils.jsonToList(mediaIds, String.class);

		List<AdplacementVO> list = adplacementService.getAllAdplacements();
		if (null != mediaIdList) {
			list = adplacementService.findAdplacementByIds(mediaIdList, list,
					false);
		}

		List<RTBAdplacementVO> result = rtbAdplacementService.showList(list);
		int totalRecords = result.size();
		result = adplacementService.getSubList(result, page_param);

		int totalPages = Utils.getTotalPage(totalRecords, pageSize);

		page.setPageNo(pageNo);
		page.setRows(result);
		page.setPageSize(pageSize);
		page.setTotalRecords(totalRecords);
		page.setTotalPages(totalPages);
		return page;
	}
	
	@RequestMapping("/getmaterials")
	public @ResponseBody Page<Material> getMaterialList(SelectMaterialPageForm form){
		materialService.updateStatus(null);
		Page<Material> page = materialService.getPagedListForRtb(form);
		return page;
	}
	
	@RequestMapping("/getAMRelation")
	public @ResponseBody List<HashMap<String, Object>> getAMRelation(Integer rtbId){
		return rtbAdplacementService.getAMRelation(rtbId);
	}
	
	@RequestMapping("/selectAll/ids")
	public @ResponseBody List<Integer> selectAllIds(String materialType, String containedKeyword,
			String notContainedKeyword, @RequestParam(value="size[]",required=false) String[] size, String idsNotIn) throws Exception {

		Object filter_param[] = {materialType,containedKeyword,notContainedKeyword,size};
		List<String> idsNotInList = JSONUtils.jsonToList(idsNotIn, String.class);
		List<AdplacementVO> list = adplacementService.getAllAdplacements();
		if(null != idsNotInList){
			list = adplacementService.findAdplacementByIds(idsNotInList, list, true);
		}
		List<RTBAdplacementVO> result = rtbAdplacementService.list(list,filter_param);
		List<Integer> idList = new ArrayList<Integer>();
		for(RTBAdplacementVO rtbAdpoacementVO : result){
			idList.add(rtbAdpoacementVO.getId());
		}		
		return idList;
	}
	
	@RequestMapping("/flipAll/ids")
	public @ResponseBody List<Integer> flipAllIds(String materialType, String containedKeyword,
			String notContainedKeyword, @RequestParam(value="size[]",required=false) String[] size,
			String idsNotIn, @RequestBody List<Integer> ids) throws Exception {

		Object filter_param[] = {materialType,containedKeyword,notContainedKeyword,size};
		List<String> idsNotInList = JSONUtils.jsonToList(idsNotIn, String.class);
		List<AdplacementVO> list = adplacementService.getAllAdplacements();
		if(null != idsNotInList){
			list = adplacementService.findAdplacementByIds(idsNotInList, list, true);
		}
		List<RTBAdplacementVO> result = rtbAdplacementService.list(list,filter_param);
		List<Integer> idList = new ArrayList<Integer>();
		for(RTBAdplacementVO rtbAdpoacementVO : result){
			idList.add(rtbAdpoacementVO.getId());
		}
		idList.removeAll(ids);
		return idList;
	}
}
