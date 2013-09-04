package com.supertool.dspui.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.mybatis.CreativeMapper;
import com.supertool.dspui.dao.mybatis.MaterialMapper;
import com.supertool.dspui.model.Material;
import com.supertool.dspui.model.Rtb;
import com.supertool.dspui.param.PageParam;
import com.supertool.dspui.param.SelectSQLParam;
import com.supertool.dspui.param.form.MaterialAuditPageForm;
import com.supertool.dspui.param.form.SelectMaterialPageForm;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.TalkWithCarbon;
import com.supertool.dspui.util.Utils;
import com.supertool.dspui.vo.MaterialAuditResultVO;
import com.supertool.dspui.vo.MaterialAuditVO;
import com.supertool.dspui.vo.MaterialStatusInfo;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.ResultVO;

@Service
public class MaterialService {

	@Autowired
	private MaterialMapper materialMapper;
	@Autowired
	private CreativeMapper creativeMapper;
	public boolean checkName(String name ,int creativeId,Integer id) {
		
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("name",name);
		map.put("creativeId",creativeId);
		map.put("id",id);
		return this.materialMapper.checkName(map);
	}
	@Transactional(rollbackFor = RuntimeException.class)
	public ResultVO insertMaterial(Material material) {

		 ResultVO vo = new ResultVO();
		  JSONObject jobject = null;
		  try{
			  material.setDspId(UserContext.getDspId());
			  this.materialMapper.insertIntoMaterial(material);
			  TalkWithCarbon talkWithCarbon = new TalkWithCarbon();
			  Map<String,Object> m = new HashMap<String,Object>();
			  m.put("dspId", UserContext.getDspId());
			  m.put("creativeId", material.getCreativeCarbonId());
			  m.put("name", material.getName());
			  m.put("type", material.getType());
			  m.put("width", material.getWidth());
			  m.put("height", material.getHeight());
			  m.put("fileSize", material.getFileSize());
			  m.put("duration", material.getDuration());
			  m.put("url", material.getPreviewUrl());
			  String url = Config.getCarbonHost() + "/material/add";
			  jobject = talkWithCarbon.getCarbonVOJson(m, url);
			  if(null == jobject){
				  vo.setResultCode(Constant.RESULT_FAIL);
				  vo.setMessage("调用carbon失败");
				  throw new RuntimeException("调用carbon失败");
			  }else {
				  int statusCode  = jobject.getInt("statusCode");
				  String message = jobject.getString("message");				  
				  if(HttpStatus.SC_OK == statusCode){
					  int carbonId = jobject.getInt("id");
					  material.setCarbonId(carbonId);
					  String ext = material.getPreviewUrl().substring(material.getPreviewUrl().lastIndexOf(".") + 1);
					  if("jpg".equalsIgnoreCase(ext) || "jpeg".equalsIgnoreCase(ext) || "png".equalsIgnoreCase(ext) || "gif".equalsIgnoreCase(ext)){
						  material.setType("P");
					  }else if("swf".equalsIgnoreCase(ext)){
						  material.setType("S");
					  }else if("flv".equalsIgnoreCase(ext)){
						  material.setType("F");
					  }else{
						  throw new RuntimeException("保存物料失败：物料类型不符合");
					  }
					  material.setExtension(ext);
					  material.setUpdateTime(new Date());
					  this.materialMapper.updateMaterial(material);
					  vo.setResultCode(Constant.RESULT_SUCCESS);
					  vo.setMessage("新建物料成功！");
					  Map<String,Object> map = new HashMap<String,Object>();
					  map.put("id", material.getId());
					  vo.setMap(map);
					  //model.addAttribute("result", vo);
				  }else{
					  /*vo.setResultCode(statusCode);
					  vo.setMessage("carbon新建物料失败："+message);*/
					
					  throw new RuntimeException("carbon新建物料失败："+message);

				  }
			  }
		  }catch(Exception e){
			  throw new RuntimeException(e.getMessage());
		  }
		return vo;
	}
	@Transactional(rollbackFor = RuntimeException.class)
	public int updateMaterial(Material material) {
		return this.materialMapper.updateMaterial(material);
		
		
	}
	public Page<Material> getPagedList(PageParam pageParam) {
		SelectSQLParam selectParams =  new SelectSQLParam();
		selectParams = getSelectParams(pageParam);
		//获取一个页面的vo集合
		List<Material> rows = this.materialMapper.getPagedMaterials(selectParams);
		rows = addMaterialStatus(rows);
		rows = showFileSizeStr(rows);
		int totalCount = this.materialMapper.getMaterialsCount(selectParams);


		//排序
		
		
		//搜索
		
		int totalPage = (totalCount-1) / pageParam.getPageSize() +1;
		int currentPage = pageParam.getCurrentPage();
		
		
		Page<Material> page = new Page<Material>();
		if(totalCount-1 >-1){
			page.setPageNo(currentPage);
			page.setPageSize(pageParam.getPageSize());
			page.setTotalPages(totalPage);
			page.setTotalRecords(totalCount);
			page.setRows(rows);
		}
		return page;
	}
	private List<Material> showFileSizeStr(List<Material> rows) {
		if(null == rows || rows.size() == 0){
			return rows;
		}
		for(Material material : rows){
			long size = material.getFileSize();
			if(size <1024){
				material.setFileSizeStr(size+"B");
			}else if(size <1024*1024){
				double k = size*1.0 /(1024);
				material.setFileSizeStr(String.format("%.1f", k)+"K");
			}else{
				double m = size*1.0 /(1024*1024);
				material.setFileSizeStr(String.format("%.1f", m)+"M");
			}
		}
		
		return rows;
	}
	private List<Material> addMaterialStatus(List<Material> rows) {
		if(null == rows || rows.size() == 0){
			return null;
		}
		List<Integer> ids = new LinkedList<Integer>();
			for(Material m :rows){
				ids.add(m.getCarbonId());
		}
		JSONObject jobject = null;
		Map<String,Object> params = new HashMap<String,Object>();
		String idStr = Utils.ListToStr(ids);
		params.put("ids", idStr);
		params.put("dspId", UserContext.getDspId());
		String url = Config.getCarbonHost()+"/material/status";
		try{
			jobject = new TalkWithCarbon().getCarbonVOJson(params, url);
			if(null ==jobject){
				for(Material m :rows){
					m.setStatus("调用carbon失败");
				}
			}else{
				int statusCode = jobject.getInt("statusCode");
				String message = jobject.getString("message");
				if(HttpStatus.SC_OK == statusCode){
					@SuppressWarnings("unchecked")
					List<JSONObject> datas = (List<JSONObject>) jobject.get("data");
					List<MaterialStatusInfo> statuvos = new LinkedList<MaterialStatusInfo>();
					
					if(null !=datas && datas.size()>0){
						for(int i=0;i<datas.size();i++){
							JSONObject o = datas.get(i);
							if(null != o){
								MaterialStatusInfo s = new MaterialStatusInfo();
								int status = o.getInt("status");
								int id = o.getInt("id");
								s.setId(id);
								s.setStatus(status);
								if(null != o.get("reason")&& !StringUtil.isBlank(o.get("reason").toString())){
									String reason = o.getString("reason");
									s.setReason(reason);
								}
								statuvos.add(s);
							}
						
						}
					}
					if(null !=statuvos && statuvos.size()>0){
						Map <Integer,Integer> statusInfoMap = new HashMap<Integer,Integer>();
						Map<Integer,String> reason = new HashMap<Integer,String>();
						for(MaterialStatusInfo statusInfo : statuvos){
							statusInfoMap.put(statusInfo.getId(), statusInfo.getStatus());
							if(1 == statusInfo.getStatus()){
								reason.put(statusInfo.getId(), statusInfo.getReason());
							}

						}
						for(Material mt : rows){
							if(0 == statusInfoMap.get(mt.getCarbonId())){
								mt.setStatus("ADX审核中");
							}else if(1 == statusInfoMap.get(mt.getCarbonId())){
								mt.setStatus("ADX审核拒绝");
								mt.setRejectReason(reason.get(mt.getCarbonId()));
							}else{
								mt.setStatus("ADX审核通过");
							}
							
						}
					}
				}else{
					for(Material m :rows){
						m.setStatus(message);
					}
				}
			}
		}catch(Exception e){
			for(Material m :rows){
				m.setStatus("调用carbon失败:"+e.getMessage());
			}
			return rows;
		}
		
		
	
		return rows;
	}
	private SelectSQLParam getSelectParams(PageParam pageParam) {
		SelectSQLParam sqlParam = new SelectSQLParam(); 
		sqlParam.setStartRow((pageParam.getCurrentPage()-1)*pageParam.getPageSize());
		sqlParam.setLimitRows(pageParam.getPageSize());
		String orderName = pageParam.getOrderName();
		if("name".equalsIgnoreCase(orderName)){
			orderName = "convert(name using gbk)";
		}
		sqlParam.setOrderName(orderName);
		sqlParam.setOrderValue(pageParam.getOrderValue());
		sqlParam.setUserData(pageParam.getUserData());
		sqlParam.setNeedInIds(false);
		sqlParam.setDspId(UserContext.getDspId());
		sqlParam.setSearchName(pageParam.getSearchName());
		sqlParam.setSearchValue(pageParam.getSearchValue());
		sqlParam.setSqlStr(null);
		/*
		String searchValue = pageParam.getSearchValue();
		if(null != searchValue && !"".equals(searchValue.trim())){
			StringBuffer mySql = new StringBuffer("");
			if(StringUtil.isNumber(searchValue.trim())){
				
				mySql.append("  and (carbonId ="+Integer.parseInt(searchValue.trim()));
				mySql.append(" or name like '%"); 
				mySql.append(searchValue.trim());
				mySql.append("%') ");
				
			}else{
				mySql.append("  and name like '%"); 
				mySql.append(searchValue.trim());
				mySql.append("%' ");
			}
			sqlParam.setSqlStr(mySql.toString());
		}
		*/
		return sqlParam;
	}
	
	public String getMaterialStatus(Integer materialId) {
		String materialStatus = "";
		JSONObject jobject = null;
		Map<String, Object> params = new HashMap<String, Object>();
		String idStr = ""+materialId;
		params.put("ids", idStr);
		params.put("dspId", UserContext.getDspId());
		String url = Config.getCarbonHost() + "/material/status";
		try{
			jobject = new TalkWithCarbon().getCarbonVOJson(params, url);
		}catch(Exception e){
			materialStatus = "调用carbon出错";
			return materialStatus;
		}
		
		if (null == jobject) {
			materialStatus = "调用carbon出错";
		} else {
			int statusCode = jobject.getInt("statusCode");
			String message = jobject.getString("message");
			
			if (HttpStatus.SC_OK == statusCode) {
				@SuppressWarnings("unchecked")
				List<JSONObject> datas = (List<JSONObject>) jobject.get("data");
				if (null != datas && datas.size() > 0) {
						int status = datas.get(0).getInt("status");
						int id = datas.get(0).getInt("id");
						 
						if( 0 ==status){
							  materialStatus = "ADX审核中";
						  }else if(1== status){
							  materialStatus = "ADX审核拒绝";
						  }else if(2 ==status){
							  materialStatus ="ADX审核通过";
						  }else {
							  materialStatus ="系统错误";
						  }
						
				}
			}else{
				materialStatus = message;
			}
		}

		return materialStatus;
	}
	public Map<Integer, Integer> getMaterialStatusMap(List<Integer> materialIds) {
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		if(null != materialIds && materialIds.size() == 0){
			return resultMap;
		}
		JSONObject jobject = null;
		Map<String, Object> params = new HashMap<String, Object>();
		String idStr = Utils.ListToStr(materialIds);
		if (null != materialIds) {
			params.put("ids", idStr);
		}
		params.put("dspId", UserContext.getDspId());
		String url = Config.getCarbonHost() + "/material/status";
		jobject = new TalkWithCarbon().getCarbonVOJson(params, url);
		if (null == jobject) {
			return resultMap;
		} else {
			int statusCode = jobject.getInt("statusCode");
			String message = jobject.getString("message");
			if (HttpStatus.SC_OK == statusCode) {
				@SuppressWarnings("unchecked")
				List<JSONObject> datas = (List<JSONObject>) jobject.get("data");
				if (null != datas && datas.size() > 0) {
					for (int i = 0; i < datas.size(); i++) {
						JSONObject o = datas.get(i);
						if (null != o) {
							int status = o.getInt("status");
							int id = o.getInt("id");
							resultMap.put(id, status);
						}

					}
				}
			}
		}

		return resultMap;
	}

	public void updateStatus(List<Integer> materialIds) {
		Map<Integer, Integer> materialStatusMap = getMaterialStatusMap(materialIds);
		Set<Integer> idSet = materialStatusMap.keySet();
		for (Integer id : idSet) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", id);
			params.put("status", materialStatusMap.get(id));
			materialMapper.updateStatus(params);
		}
	}

	public Page<Material> getPagedListForRtb(SelectMaterialPageForm form) {
		int pageSize = form.getPageSize();
		int pageNo = form.getPageNo();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startRow", pageSize * (pageNo - 1));
		params.put("limitRows", pageSize);
		params.put("creativeId", form.getCreativeId());
		params.put("width", form.getWidth());
		params.put("height", form.getHeight());
		params.put("extension", form.getFileType());

		// 获取一个页面的vo集合
		List<Material> rows = materialMapper.getPagedListForRtb(params);
		int totalRecords = materialMapper.getCountForRtb(params);

		Page<Material> page = new Page<Material>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setTotalPages(Utils.getTotalPage(totalRecords, pageSize));
		page.setTotalRecords(totalRecords);
		page.setRows(rows);
		return page;
	}
	public Page<Rtb> getPagedRtbList(PageParam pageParam) {
		SelectSQLParam selectParams =  new SelectSQLParam();
		selectParams = getSelectParams(pageParam);
		//获取一个页面的vo集合
		List<Rtb> rows = this.materialMapper.getPagedMaterialRtbs(selectParams);
		int totalCount = this.materialMapper.getMaterialRtbListCount(selectParams);


		//排序
		
		
		//搜索
		
		int totalPage = (totalCount-1) / pageParam.getPageSize() +1;
		int currentPage = pageParam.getCurrentPage();
		Page<Rtb> page = new Page<Rtb>();
		if(totalCount - 1>-1){		
			page.setPageNo(currentPage);
			page.setPageSize(pageParam.getPageSize());
			page.setTotalPages(totalPage);
			page.setTotalRecords(totalCount);
			page.setRows(rows);
		}
		return page;
	}
	@Transactional(rollbackFor = RuntimeException.class)
	public boolean deleteMaterialById(Integer id,Integer carbonId) {
		try{
			List<Integer> ids = new LinkedList<Integer>();
			ids.add(id);
			List<Integer> adIds = materialMapper.getAdIdsByMaterialIds(ids);
			if(null != adIds && adIds.size() > 0){
				//批量删除广告位和物料关联表的相应记录
				materialMapper.batchDeleteAdsRelationByIds(adIds);
			}
			this.materialMapper.deleteMaterial(id);
			TalkWithCarbon talkWithCarbon = new TalkWithCarbon();
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("dspId", UserContext.getDspId());
			params.put("id", carbonId);
			String url = Config.getCarbonHost()+"/material/delete";
			JSONObject jobject = talkWithCarbon.getCarbonVOJson(params, url);
			int statusCode = jobject.getInt("statusCode");
			if(HttpStatus.SC_OK == statusCode){
				return true;
			}
		}catch(Exception e){
			throw new RuntimeException("删除失败");
		}
		return false;
	}
	public Material getMaterial(Integer id) {
		
		
		Material material =  this.materialMapper.getMaterial(id);
		long size = material.getFileSize();
		if(size <1024){
			material.setFileSizeStr(size+"B");
		}else if(size <1024*1024){
			double k = size*1.0 /(1024);
			material.setFileSizeStr(String.format("%.1f", k)+"K");
		}else{
			double m = size*1.0 /(1024*1024);
			material.setFileSizeStr(String.format("%.1f", m)+"M");
		}
		
		material.setMaterialStatusInfo(getMaterialStatus(material.getCarbonId()));
		return material;
	}
	
	public Page<MaterialAuditResultVO> getAuditList(MaterialAuditPageForm form) {
		int pageSize = form.getPageSize();
		int pageNo = form.getPageNo();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dspId", UserContext.getDspId());
		params.put("orderName", form.getOrderBy());
		params.put("orderValue", form.getOrder());
		params.put("startRow", pageSize * (pageNo - 1));
		params.put("limitRows", pageSize);
		String extension = form.getExtension();
		if (null != extension && !"all".equals(extension)) {
			params.put("extension", extension);
		}
		String searchStr = form.getSearchStr();
		if (null != searchStr && !"".equals(searchStr)) {
			if (StringUtil.isNumber(searchStr)) {
				params.put("isNumber", true);
			} else {
				params.put("isNumber", false);
			}
			params.put("searchStr", searchStr);
		}
		Integer status = form.getStatus();
		if (null != status && !status.equals(-1)) {
			// 当需要按物料审核状态筛选物料时，更新状态，从数据库查询
			updateStatus(null);
			params.put("status", status);
		}
		List<MaterialAuditVO> materialAuditList = materialMapper
				.getPagedMaterialAuditList(params);
		int totalRecords = materialMapper.getMaterialAuditCount(params);

		Map<Integer, Integer> materialStatusMap = null;
		if (null == status || status.equals(-1)) {
			// 当不需要按物料审核状态筛选物料时，直接从carbon获取指定物料的状态
			List<Integer> materialIds = new ArrayList<Integer>();
			for (MaterialAuditVO materialAuditVO : materialAuditList) {
				materialIds.add(materialAuditVO.getCarbonId());
			}
			materialStatusMap = getMaterialStatusMap(materialIds);
		}

		List<MaterialAuditResultVO> resultList = new ArrayList<MaterialAuditResultVO>();
		for (MaterialAuditVO materialAuditVO : materialAuditList) {
			MaterialAuditResultVO resultVO = new MaterialAuditResultVO();
			resultVO.setId(materialAuditVO.getId());
			resultVO.setCarbonId(materialAuditVO.getCarbonId());
			resultVO.setName(materialAuditVO.getName());
			resultVO.setExtension(materialAuditVO.getExtension());
			resultVO.setWidth(materialAuditVO.getWidth());
			resultVO.setHeight(materialAuditVO.getHeight());
			resultVO.setFileSize(materialAuditVO.getFileSize());
			resultVO.setCreateTime(StringUtil.dateToFormatString("yyyy-MM-dd",
					materialAuditVO.getCreateTime()));
			if (null != status && !status.equals(-1)) {
				resultVO.setStatus(materialAuditVO.getStatus());
			} else {
				Integer materialStatus = materialStatusMap.get(materialAuditVO
						.getCarbonId());
				resultVO.setStatus(null == materialStatus ? -1 : materialStatus);
			}
			resultVO.setCreativeName(materialAuditVO.getCreativeName());
			resultVO.setAdvertiserName(materialAuditVO.getAdvertiserName());
			resultList.add(resultVO);
		}
		Page<MaterialAuditResultVO> page = new Page<MaterialAuditResultVO>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setTotalRecords(totalRecords);
		page.setTotalPages(Utils.getTotalPage(totalRecords, pageSize));
		page.setRows(resultList);
		return page;
	}
}
 