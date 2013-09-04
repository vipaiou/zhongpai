package com.supertool.dspui.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.mail.handlers.message_rfc822;
import com.supertool.dspui.config.Config;
import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.mybatis.CreativeMapper;
import com.supertool.dspui.dao.mybatis.MaterialMapper;
import com.supertool.dspui.model.Creative;
import com.supertool.dspui.param.PageParam;
import com.supertool.dspui.param.SelectSQLParam;
import com.supertool.dspui.util.DateUtil;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.TalkWithCarbon;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.ResultVO;

@Service
public class CreativeService {
   
	@Autowired
	private CreativeMapper creativeMapper;
	
	@Autowired
	private MaterialMapper materialMapper;

	public Creative findById(Integer id) {
	
		return creativeMapper.getCreativeById(id);
	}

	@Transactional(rollbackFor=RuntimeException.class)
	public  ResultVO save(Creative creative) {
	
		ResultVO vo = new ResultVO();
	   String name = creative.getName();
       String description = StringUtil.trimSRN(creative.getDescription());
	   Date now = new Date();
	   Integer creativeId = creative.getId();
	   if (creativeId != 0) {
		   //编辑
	       creative = creativeMapper.getCreativeById(creativeId);
	       creative.setUpdateTime(DateUtil.formatDateTime(now));
	       creative.setName(name);
	       creative.setDescription(description);
	       TalkWithCarbon  talkWithCarbon = new TalkWithCarbon();	  
		   String url = Config.getCarbonHost() + "/creative/update";
		   Map<String,Object> m = new HashMap<String,Object>();
		   m.put("dsId", UserContext.getDspId());
		   m.put("campaignId", creative.getCampaignCarbonId());
		   m.put("id", creative.getCarbonId());
		   m.put("name", creative.getName());
		   m.put("desc", creative.getDescription());
		   JSONObject jsonObject = talkWithCarbon.getCarbonVOJson(m, url);
		   if(null == jsonObject){
			   throw new RuntimeException("调用carbon出错!");
		   }else{
			   int statusCode = jsonObject.getInt("statusCode");
			   //远程更新成功，
			   if(HttpStatus.SC_OK == statusCode){
					//本地更新
				   try{
					   creative.setCreateTime(DateUtil.formatDateTime(creative.getCreateTime()));
					   creative.setUpdateTime(DateUtil.formatDateTime(creative.getUpdateTime()));
					   creative.setDeleteTime(DateUtil.formatDateTime(creative.getDeleteTime()));
					   this.creativeMapper.saveCreative(creative);
					   vo.setMessage("成功修改创意_{"+creative.getCarbonId()+"_"+creative.getName()+"}");
					   vo.setResultCode(Constant.RESULT_SUCCESS);
					   Map<String,Object> map = new  HashMap<String,Object>();
					   map.put("campaignId", creative.getCampaignId());
					   map.put("id", creative.getId());
					   vo.setMap(map);
				   }catch(Exception e){
					   throw new RuntimeException(e.getMessage());
				   }
			   }else{
				   String message = jsonObject.getString("message");
				   throw new RuntimeException("carbon操作失败："+message);
			   }
		   }
	      
	   }else{
		   //新建
		   creative.setName(name);
	       creative.setDescription(description);
	       creative.setCreateTime(now);
		   TalkWithCarbon  talkWithCarbon = new TalkWithCarbon();	  
		   String url = Config.getCarbonHost() + "/creative/add";
		   Map<String,Object> m = new HashMap<String,Object>();
		   m.put("dsId", UserContext.getDspId());
		   m.put("campaignId", creative.getCampaign().getCarbonId());
		   m.put("name", creative.getName());
		   m.put("desc", creative.getDescription());
		   JSONObject jsonObject = talkWithCarbon.getCarbonVOJson(m, url);
		   if(null == jsonObject){
			   throw new RuntimeException("调用carbon出错!");
		   }else{
			   int statusCode = jsonObject.getInt("statusCode");
			   //远程新建成功，返回carbonId
			   if(HttpStatus.SC_OK == statusCode){
					int carbonId = jsonObject.getInt("id");
					creative.setCarbonId(carbonId);
					//本地新建
					try{
						this.creativeMapper.insertCreative(creative);  	
						  vo.setMessage("成功新建创意_{"+creative.getCarbonId()+"_"+creative.getName()+"}");
						  vo.setResultCode(Constant.RESULT_SUCCESS);
						  Map<String,Object> map = new  HashMap<String,Object>();
						  map.put("campaignId", creative.getCampaign().getId());
						  map.put("id", creative.getId());
						  vo.setMap(map);
					}catch(Exception e){
						throw new RuntimeException(e.getMessage());
					}	
			   }else{
				   String message = jsonObject.getString("message");
				   throw new RuntimeException("carbon操作失败："+message);
			   }
		   }
		   
	   }
	 return vo;
	}

	public boolean checkName(Integer id, Integer campaignId, String name) {
		Map<String,Object> m = new HashMap<String,Object>();
    	m.put("id", id);
    	m.put("campaignId", campaignId);
    	m.put("name", name.replace("'", "\'"));
		return this.creativeMapper.checkName(m);
	}

	public Page<Creative> getPagedList(PageParam pageParam) {
		SelectSQLParam selectParams =  new SelectSQLParam();
		selectParams = getSelectParams(pageParam);
		//获取一个页面的vo集合
		List<Creative> rows = this.creativeMapper.getPagedCreatives(selectParams);
		int totalCount = this.creativeMapper.getCreativesCount(selectParams);


		//排序
		
		
		//搜索
		
		int totalPage = 0;
		int currentPage = 0;
		Page<Creative> page = new Page<Creative>();
		if(totalCount-1 >-1){
			totalPage = (totalCount-1) / pageParam.getPageSize() +1;
			currentPage = pageParam.getCurrentPage();
			page.setPageNo(currentPage);
			page.setPageSize(pageParam.getPageSize());
			page.setTotalPages(totalPage);
			page.setTotalRecords(totalCount);
			page.setRows(rows);
		}
		
	
	
		return page;
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
		sqlParam.setUserData(pageParam.getUserData());
		sqlParam.setSearchName(pageParam.getSearchName());
		sqlParam.setSearchValue(pageParam.getSearchValue());
		sqlParam.setSqlStr(null);
		
		/*String searchValue = pageParam.getSearchValue();
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

	@Transactional(rollbackFor = RuntimeException.class)
	public ResultVO delete(Integer id,Integer carbonId) {
		ResultVO vo  = new ResultVO(); 
		try{
			/*List<Integer> ids = creativeMapper.getMaterialIdsByCreativeId(id);
			if(null != ids && ids.size() > 0){
				List<Integer> adIds = materialMapper.getAdIdsByMaterialIds(ids);
				if(null != adIds && adIds.size() > 0){
					//批量删除广告位和物料关联表的相应记录
					materialMapper.batchDeleteAdsRelationByIds(adIds);
				}
				//批量删除创意关联的物料
				materialMapper.deleteMaterialsByIds(ids);
			}*/
			//删除创意
			this.creativeMapper.deleteCreativeById(id);
			TalkWithCarbon talkWithCarbon = new TalkWithCarbon();
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("dspId", UserContext.getDspId());
			params.put("id", carbonId);
			String url = Config.getCarbonHost()+"/creative/delete";
			JSONObject jobject = talkWithCarbon.getCarbonVOJson(params, url);
			int statusCode = jobject.getInt("statusCode");
			if(HttpStatus.SC_OK == statusCode){
				vo.setResultCode(Constant.RESULT_SUCCESS);
				vo.setMessage("删除成功");
				return vo;
			}else{
				String message = jobject.getString("message");
				throw new RuntimeException(message);
			}
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public List<Creative> getByCampaignId(Integer campaignId){
		return creativeMapper.getByCampaignId(campaignId);
	}
	
	public Creative getByCarbonId(Integer id){
		return creativeMapper.getByCarbonId(id);
	}

	public Creative getCreativeById(int creativeId) {
		
		return this.creativeMapper.getCreativeById(creativeId);
	}

	public void deleteCreativesInLocal(List<Integer> creativeIds) {
		// TODO Auto-generated method stub
		
	}
	
	
}
