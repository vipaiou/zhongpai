package com.supertool.dspui.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.mybatis.AlgorithmMapper;
import com.supertool.dspui.dao.mybatis.CampaignMapper;
import com.supertool.dspui.dao.mybatis.CreativeMapper;
import com.supertool.dspui.dao.mybatis.MaterialMapper;
import com.supertool.dspui.dao.mybatis.RtbAdplacementMaterialMapper;
import com.supertool.dspui.dao.mybatis.RtbMapper;
import com.supertool.dspui.model.Advertiser;
import com.supertool.dspui.model.Campaign;
import com.supertool.dspui.param.PageParam;
import com.supertool.dspui.param.SelectSQLParam;
import com.supertool.dspui.param.carboninterface.InsertCampaignParam;
import com.supertool.dspui.param.carboninterface.UpdateCampaignParam;
import com.supertool.dspui.param.form.CampaignForm;
import com.supertool.dspui.util.DateUtil;
import com.supertool.dspui.util.JSONUtils;
import com.supertool.dspui.util.ObjectValueUtil;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.TalkWithCarbon;
import com.supertool.dspui.util.Utils;
import com.supertool.dspui.vo.CampaignChartVO;
import com.supertool.dspui.vo.CampaignMaterialVO;
import com.supertool.dspui.vo.CampaignRow;
import com.supertool.dspui.vo.CarbonMaterialStatusVO;
import com.supertool.dspui.vo.CarbonResultVO;
import com.supertool.dspui.vo.OverBudget;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.ResultVO;

@Service
public class CampaignService {

	
	private Logger logger =Logger.getLogger(CampaignService.class);
	@Autowired
	private CampaignMapper campaignMapper;
	
	@Autowired
	
	private RtbRuleService rtbRuleService;
	
	@Autowired
	
	private AdvertiserService advertiserService;

	@Autowired
	private CreativeService creativeService;
	
	@Autowired 
	private AlgorithmMapper algorithmMapper;
	
	@Autowired
	private MaterialMapper materialMapper;
	
	@Autowired 
	private CreativeMapper creativeMapper;
	
	@Autowired
	private RtbAdplacementMaterialMapper rtbAdplacementMaterialMapper;
	
	@Autowired
	private RtbMapper rtbMapper;
	
	public Map<String,Object> getCampagnRealChart(int carbonId) {
		
		Map<String,Object> m = new HashMap<String,Object>();
    	List<Integer> carbonIds = new LinkedList<Integer>();
    	carbonIds.add(carbonId);
    	CarbonResultVO carbonVO =getCampaignRealChartFromCarbon(UserContext.getDspId(), carbonIds);
    	if(null == carbonVO){
    		m.put("resultCode", Constant.RESULT_FAIL);
    		m.put("message","本地调用出错!" );
    	}else if(carbonVO.getStatusCode() == Constant.CARBON_RESULT_SUCESS){
    		m.put("resultCode", Constant.RESULT_SUCCESS);
    		@SuppressWarnings("unchecked")
			List<CampaignChartVO>  charts = (List<CampaignChartVO>) carbonVO.getData();
    		if(null ==charts ||charts.size()==0){
    			m.put("data", null);
    		}else{
    			m.put("data", charts.get(0));
    		}  		
    	}else {
    		m.put("resultCode", carbonVO.getStatusCode());
    		m.put("message", carbonVO.getMessage());
    	}
    	return m;
	}
	

	/*
	 * 获取实时报表
	 */
	public CarbonResultVO getCampaignRealChartFromCarbon(int dspId,List<Integer> carbonIds){
		CarbonResultVO vo = new CarbonResultVO();
		if(null == carbonIds || carbonIds.size()==0){
			vo.setStatusCode(Constant.RESULT_FAIL);
			vo.setMessage("ids为null");
			vo.setData(null);
			return vo;
		}
		//获取实时报表信息
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("dspId", String.valueOf(dspId));
		params.put("ids", Utils.ListToStr(carbonIds));
		String url = Config.getCarbonHost()+"/report/real/campaign/list";
		JSONObject json =null;
		TalkWithCarbon  talkWithCarbon = new TalkWithCarbon();
		try{
			json = talkWithCarbon.getCarbonVOJson(params, url);
			json.toString();//用于判断是否为null
		}catch(Exception e){
			vo.setStatusCode(Constant.CALL_CARBON__FAIL);
			vo.setMessage("调用carbon失败！");
			vo.setData(null);
			return vo;
		}
		int status = json.getInt("statusCode");
		if(status == HttpStatus.SC_OK){
			@SuppressWarnings("unchecked")
			List<CampaignChartVO>  campaignChartVOs = (List<CampaignChartVO>) json.get("data");
			if(null == campaignChartVOs || campaignChartVOs.size() == 0){
				vo.setStatusCode(Constant.CALL_CARBON__FAIL);
				vo.setMessage("从carbon中未获取到相关信息！");
				vo.setData(null);
			}else{
				vo.setStatusCode(Constant.CARBON_RESULT_SUCESS);
				vo.setData(campaignChartVOs);
				vo.setMessage("获取成功!");
			}
		}else{
			String message = json.getString("message");
			vo.setStatusCode(status);
			vo.setMessage(message);
			vo.setData(null);
		}
		
		return vo;
	}
	public List<CampaignRow> addCampaignChartToResultVO(int dspId,List<CampaignRow> rows)
	{
		List<Integer> ids = new LinkedList<Integer>();
		if(null == rows || rows.size()==0){
			return rows;
		}
		Map <Integer,CampaignRow> m =new HashMap<Integer,CampaignRow>();
		for(int i= 0; i< rows.size();i++){
			ids.add(rows.get(i).getCarbonId());
			m.put(rows.get(i).getCarbonId(), rows.get(i));
		}
		//获取实时报表信息
	    CarbonResultVO vo = getCampaignRealChartFromCarbon(dspId, ids);
	    if(null != vo && vo.getStatusCode() == Constant.CARBON_RESULT_SUCESS){
	    	@SuppressWarnings("unchecked")
			List<JSONObject>  jObjects = JSONUtils.toJSONArray(vo.getData());
	    /*	Map <Integer,JSONObject> m =new HashMap<Integer,JSONObject>();
	    	for(int k=0;k<jObjects.size();k++){	    	
	    		m.put(rows.get(k).getCarbonId(), jObjects.get(k));
	    	}
	    	*/
	    	for(int i=0;i<jObjects.size();i++){
	    		boolean isError = false;
				if(null != jObjects.get(i)){
					CampaignChartVO chartVo =null;
					JSONObject json = jObjects.get(i);
					
					try{
						chartVo= (CampaignChartVO) JSONObject.toBean(json, CampaignChartVO.class) ;
					}catch(Exception e){
						e.printStackTrace();
						isError = true;
						logger.error(e.getMessage());
					}

					m.get(json.getInt("id")).setPv(chartVo.getPv());
					m.get(json.getInt("id")).setClick(chartVo.getClick());
					m.get(json.getInt("id")).setUv(chartVo.getUv());
					double ctr = 0;
					if(m.get(json.getInt("id")).getPv() != 0){
						ctr = chartVo.getClick()*1.0 / chartVo.getPv();
					}
					
					m.get(json.getInt("id")).setCtr( ctr);
					m.get(json.getInt("id")).setDailyPv(chartVo.getDailyPv());
					m.get(json.getInt("id")).setDailyClick(chartVo.getDailyClick());
					m.get(json.getInt("id")).setDailyUv(chartVo.getDailyUv());
					m.get(json.getInt("id")).setDailyCost(chartVo.getDailyCost());
					m.get(json.getInt("id")).setAvgCost(chartVo.getAvgPrice());
					m.get(json.getInt("id")).setHighestCost(chartVo.getMaxPrice());
					m.get(json.getInt("id")).setLowestCost(chartVo.getMinPrice());
					m.get(json.getInt("id")).setTotalCost(chartVo.getTotalCost());
				}else{					
					isError = true;
				}
				if(isError){
					rows.get(i).setPv(0);
					rows.get(i).setClick(0);
					rows.get(i).setUv(0);				
					rows.get(i).setCtr(0);
					rows.get(i).setDailyPv(0);
					rows.get(i).setDailyClick(0);
					rows.get(i).setDailyUv(0);
					rows.get(i).setDailyCost(0);
					rows.get(i).setAvgCost(0);
					rows.get(i).setHighestCost(0);
					rows.get(i).setLowestCost(0);
					rows.get(i).setTotalCost(0);
				}
			}
		
		}
	  
		return rows;
	}
	
	
	
	
	/**
	 * 获取所有广告活动记录数
	 * @return
	 */
	public int getCampaignCounts(SelectSQLParam sqlParam){
		//获取广告活动记录数
		int totalCount =  this.campaignMapper.getCampaignsCount(sqlParam);
		return totalCount;
	}
	public SelectSQLParam getSelectParams(PageParam pageParam){
		//获取所有广告活动列表
		SelectSQLParam sqlParam = new SelectSQLParam(); 
		sqlParam.setStartRow((pageParam.getCurrentPage()-1)*pageParam.getPageSize());
		sqlParam.setLimitRows(pageParam.getPageSize());
		String orderName = pageParam.getOrderName();
		if("name".equalsIgnoreCase(orderName)){
			orderName = "convert(name using gbk)";
		}
		sqlParam.setOrderName(orderName);
		sqlParam.setOrderValue(pageParam.getOrderValue());
		sqlParam.setDspId(UserContext.getDspId());
		sqlParam = getCampaignIdsByRtbAndMaterInfo(sqlParam,pageParam);
		sqlParam.setSearchName(pageParam.getSearchName());
		sqlParam.setSearchValue(pageParam.getSearchValue());
		sqlParam.setSqlStr(null);
	/*	System.out.println(param.getStartRow());
		System.out.println(param.getLimitRows());*/
		
	/*	String searchValue = pageParam.getSearchValue();
		if(null != searchValue && !"".equals(searchValue.trim())){
			StringBuffer mySql = new StringBuffer("");
			if(StringUtil.isNumber(searchValue.trim())){
				
				mySql.append("  and (carbonId ="+Integer.parseInt(searchValue.trim()));
				mySql.append(" or name like \"%"); 
				mySql.append(searchValue.trim());
				mySql.append("%\") ");
				
			}else{
				if(searchValue.trim().equals("\"")){
					mySql.append("  and name like '%"); 
					mySql.append(searchValue.trim());
					mySql.append("%' ");
				}else{
					mySql.append("  and name like \"%"); 
					mySql.append(searchValue.trim());
					mySql.append("%\" ");
				}
				
			}
			sqlParam.setSqlStr(mySql.toString());
		}*/
		
		return sqlParam;
	}
	@SuppressWarnings("unchecked")
	public SelectSQLParam getCampaignIdsByRtbAndMaterInfo(SelectSQLParam sqlParam,PageParam pageParam){
		Map<String,Object> m = pageParam.getUserData();
		String materialStatus = null;
		String rtbStatus = null;
		List<Integer> campaignIds1 = null;
		List<Integer> campaignIds2 = null;
		if(null != m && !m.isEmpty()){
			if(null != m.get("materialStatus")){
				materialStatus = m.get("materialStatus").toString();
			}
			if(null != m.get("rtbProgress")){
				rtbStatus = m.get("rtbProgress").toString();
			}
		}else{
			sqlParam.setNeedInIds(false);
			sqlParam.setIds(null);
			return sqlParam;
		}
		boolean isNeedInIds1 = true;
		boolean isNeedInIds2 = true;
		if(null != materialStatus && !StringUtil.isBlank(materialStatus.trim())){
			if("all".equalsIgnoreCase(materialStatus)){
				isNeedInIds1 =false;
				campaignIds1= null;
			}else if("noCorrelated".equalsIgnoreCase(materialStatus)){
				isNeedInIds1 = true;
				campaignIds1 = this.campaignMapper.getCampaignIdsNoRelatedMaterial();
			}/*else if("dspChecking".equalsIgnoreCase(materialStatus)){
				isNeedInIds1 = true;
				campaignIds1 = this.campaignMapper.getCampaignIdsByDspChecking();
			}else if("dspDeny".equalsIgnoreCase(materialStatus)){
				isNeedInIds1 = true;
				campaignIds1 = this.campaignMapper.getCampaignIdsByDspRejected();
			}*/else {
				isNeedInIds1 = true;
				CarbonResultVO vo = getCampaignIdsByRtbMaterialStatus(UserContext.getDspId(), materialStatus);
				List<Integer> materialIds = null;
				if(null != vo && Constant.CARBON_RESULT_SUCESS == vo.getStatusCode()){
					materialIds = (List<Integer>) vo .getData();
					if(null == materialIds || materialIds.size() ==0){
						materialIds = null;
					}
					campaignIds1 = this.campaignMapper.getCampaignIdsByMaterialIds(materialIds);
				}
				
			}
		}
		if(null != rtbStatus && !StringUtil.isBlank(rtbStatus.trim())){
			if("all".equalsIgnoreCase(rtbStatus)){
				isNeedInIds2 =false;
				campaignIds2 = null;
			}else if("notStarted".equalsIgnoreCase(rtbStatus)){
				isNeedInIds2 = true;
				campaignIds2 = this.campaignMapper.getCampaignIdsByRtbNotStarted();
			}else if("pause".equalsIgnoreCase(rtbStatus)){
				isNeedInIds2 = true;
				campaignIds2 = this.campaignMapper.getCampaignIdsByRtbPause();
			}else if("finished".equalsIgnoreCase(rtbStatus)){
				isNeedInIds2 = true;
				campaignIds2 = this.campaignMapper.getCampaignIdsByRtbFinished();
			}else {
				//carbon处理
				isNeedInIds2 = true;
				CarbonResultVO vo = getCampaignIdsByRtbProgressStatus(UserContext.getDspId(), rtbStatus);
				List<Integer> rtbIds = null;
				if(null != vo && Constant.CARBON_RESULT_SUCESS == vo.getStatusCode()){
					rtbIds = (List<Integer>) vo .getData();
					if(null == rtbIds || rtbIds.size() ==0){
						rtbIds = null;
					}
					campaignIds2 = this.campaignMapper.getCampaignIdsByRtbIds(rtbIds);
					if(null == campaignIds2 || campaignIds2.size()==0){
						campaignIds2 =null;
					}
					if("started".equalsIgnoreCase(rtbStatus)){
						List<Integer> campaignIds3 = this.campaignMapper.getCampaignIdsByRtbStarted(campaignIds2);
						campaignIds2 = campaignIds3;
					}
				}
			}
		}
		if(null == campaignIds1 || campaignIds1.size()==0){
			campaignIds1 =null;
		}
		if(null == campaignIds2 || campaignIds2.size()==0){
			campaignIds2 =null;
		}
		if(isNeedInIds1 && !isNeedInIds2){
			
			sqlParam.setIds(campaignIds1);
			sqlParam.setNeedInIds(isNeedInIds1);
		}else if(!isNeedInIds1 && isNeedInIds2){
			sqlParam.setIds(campaignIds2);
			sqlParam.setNeedInIds(isNeedInIds2);
		}else if(!isNeedInIds1 && !isNeedInIds2){
			sqlParam.setIds(null);
			sqlParam.setNeedInIds(false);
		}else{
			List<Integer> ids = new LinkedList<Integer>();
			sqlParam.setNeedInIds(true);
			if(null!=campaignIds1 && campaignIds1.size()>0 && null!=campaignIds2 && campaignIds2.size()>0){
				ids.addAll(campaignIds1);
				ids.addAll(campaignIds2);
				List<Integer> idList = new LinkedList<Integer>();
				for(Integer i1 : campaignIds1){
					for( Integer i2 : campaignIds2){
						if(i1 == i2){
							idList.add(i1);
						}
					}
				}
				if(null == idList || idList.size()==0){
					idList =null;
				}
				sqlParam.setIds(idList);				
			}else{
				sqlParam.setIds(null);
			}
		}
		
		return sqlParam;
	}
	public CarbonResultVO getCampaignIdsByRtbProgressStatus(int dspId,String rtbStatus){
		int status = -1;
		if(null == rtbStatus || "".equalsIgnoreCase(rtbStatus.trim()) ){
			return null;
		}

		CarbonResultVO vo = new CarbonResultVO();
		if("state1".equalsIgnoreCase(rtbStatus)){
			status = 1;
		}else if("state2".equalsIgnoreCase(rtbStatus)){
			status =2 ;
		}else if("state3".equalsIgnoreCase(rtbStatus)){
			status = 3;
		}else if("started".equals(rtbStatus)){
			status = 0;
		}
		TalkWithCarbon  talkWithCarbon = new TalkWithCarbon();
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("dspId", UserContext.getDspId());
		map.put("status", status);
		String url = Config.getCarbonHost() +"/rtb/budget/status/inverse";
		JSONObject json = null;
		try{
			json = talkWithCarbon.getCarbonVOJson(map, url);
			int statusCode = json.getInt("statusCode");
			if(HttpStatus.SC_OK == statusCode){
				@SuppressWarnings("unchecked")
				List<Integer> ids = (List<Integer>) json.get("data");
				vo.setStatusCode(Constant.CARBON_RESULT_SUCESS);
				vo.setData(ids);
			}else{
				String msg = json.getString("message");
				vo.setStatusCode(statusCode);
				vo.setMessage(msg);
			}
		}catch(Exception e){
			vo.setStatusCode(Constant.CALL_CARBON__FAIL);
			vo.setMessage("调用carbon失败!");
			vo.setData(null);
		}
		
		return vo;
	}
	public CarbonResultVO getCarbonResultVOByRtbProgressStatus(int status){
		TalkWithCarbon  talkWithCarbon = new TalkWithCarbon();
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("dspId", UserContext.getDspId());
		map.put("status", status);
		String url = Config.getCarbonHost() +"/rtb/budget/status/inverse";
		JSONObject json = null;
		CarbonResultVO vo = new CarbonResultVO();
		try{
			json = talkWithCarbon.getCarbonVOJson(map, url);
			int statusCode = json.getInt("statusCode");
			if(HttpStatus.SC_OK == statusCode){
				@SuppressWarnings("unchecked")
				List<Integer> ids = (List<Integer>) json.get("data");
				vo.setStatusCode(Constant.CARBON_RESULT_SUCESS);
				vo.setData(ids);
			}else{
				String msg = json.getString("message");
				vo.setStatusCode(statusCode);
				vo.setMessage(msg);
			}
		}catch(Exception e){
			vo.setStatusCode(Constant.CALL_CARBON__FAIL);
			vo.setMessage("调用carbon失败!");
			vo.setData(null);
		}
		
		return vo;
	}
	/**
	 * 
	 * @param dspId
	 * @param rtbStatus
	 * @return
	 */
	public CarbonResultVO getCampaignIdsByRtbMaterialStatus(int dspId,String materialStatus){
		int status = -1;
		if(null == materialStatus || "".equalsIgnoreCase(materialStatus.trim()) ){
			return null;
		}
		if("exchangChecking".equalsIgnoreCase(materialStatus)){
			status = 0;
		}else if("exchangeDeny".equalsIgnoreCase(materialStatus)){
			status =1 ;
		}else if("passed".equalsIgnoreCase(materialStatus)){
			status = 2;
		}
		TalkWithCarbon  talkWithCarbon = new TalkWithCarbon();
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("dspId", dspId);
		map.put("status", status);
		String url = Config.getCarbonHost() +"/material/status/inverse";
		JSONObject json = null;
		CarbonResultVO vo = new CarbonResultVO();
		try{
			json = talkWithCarbon.getCarbonVOJson(map, url);
			int statusCode = json.getInt("statusCode");
			if(HttpStatus.SC_OK == statusCode){
				@SuppressWarnings("unchecked")
				List<Integer> ids = (List<Integer>) json.get("data");
				vo.setStatusCode(Constant.CARBON_RESULT_SUCESS);
				vo.setData(ids);
			}else{
				String msg = json.getString("message");
				vo.setStatusCode(statusCode);
				vo.setMessage(msg);
			}
		}catch(Exception e){
			vo.setStatusCode(Constant.CALL_CARBON__FAIL);
			vo.setMessage("调用carbon失败!");
			vo.setData(null);
		}
		
		return vo;
	}
	/**
	 * 新建广告活动
	 */
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor=RuntimeException.class,propagation=Propagation.REQUIRES_NEW)
	public ResultVO save(CampaignForm campaignForm) {
		
		Integer advertiserCarbonId = advertiserService.view(Integer.parseInt(campaignForm.getAdvertiserId())).getCarbonId();
		ResultVO vo =new ResultVO();
		/**
		 * 创建时间
		 */
		campaignForm.setCreateTime(DateUtil.getNowDateTimeStr());
		campaignForm.setDspId(UserContext.getDspId());
		Campaign campaign = new Campaign();
		campaign.setName(campaignForm.getName());
		campaign.setStartTime(DateUtil.getDate(DateUtil.getDateFormatString(), campaignForm.getStartTime()));
		campaign.setEndTime(DateUtil.getDate(DateUtil.getDateFormatString(), campaignForm.getEndTime()));
		campaign.setAdvertiserId(Integer.parseInt(campaignForm.getAdvertiserId()));
		campaign.setBrand(campaignForm.getBrand());
		campaign.setLandingPage(campaignForm.getLandingPage());
		double maxPrice = Double.valueOf(campaignForm.getMaxPrice());
		maxPrice = maxPrice *100;
		
		campaign.setMaxPrice(new BigDecimal(String.valueOf(maxPrice)).setScale(2,BigDecimal.ROUND_CEILING));
		vo = ObjectValueUtil.isHasNullValue(campaign.getClass());
		if(vo.getResultCode() == 0){
			return vo;
		}
		//传递给carbon接口的参数
		InsertCampaignParam insertCampaignParam = new InsertCampaignParam();
		insertCampaignParam.setAdvertiserId(advertiserCarbonId);
		insertCampaignParam.setBrand(campaignForm.getBrand());
		insertCampaignParam.setDspId(UserContext.getDspId());
		insertCampaignParam.setEnd(campaignForm.getEndTime());
		insertCampaignParam.setLandingPage(campaignForm.getLandingPage());
		insertCampaignParam.setMinisite(campaignForm.getIsMinisite());
		insertCampaignParam.setName(campaignForm.getName());
		insertCampaignParam.setStart(campaignForm.getStartTime());
		insertCampaignParam.setMaxPrice(Double.valueOf(campaignForm.getMaxPrice())*100);
		Map<String,Object> params = new HashMap<String,Object>();
		try{
			params = JSONUtils.toHashMap(insertCampaignParam);
		}catch(Exception e){			
			String message = "json参数化失败!";
			throw new RuntimeException(message);
		}
		TalkWithCarbon talkWithCarbon =new TalkWithCarbon();
		String url = Config.getCarbonHost()+"/campaign/add";
		JSONObject jsonObject = talkWithCarbon.getCarbonVOJson(params, url);
		if(null == jsonObject){
			throw new RuntimeException("调用carbon失败!");	
		}
		int statusCode = jsonObject.getInt("statusCode");
		if(statusCode == HttpStatus.SC_OK){
			//获取carbon的主键ID
			int carbonId = jsonObject.getInt("id");
			campaign.setCarbonId(carbonId);
			int campaignId = insertCampaign(campaign);
			if(campaignId>0){
				vo.setMessage("操作成功!");
				vo.setResultCode(1);
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("id", campaignId);
				vo.setMap(map);
			}else{
				throw new RuntimeException("本地插入carbonId失败！");		
			}
		}else{
			logger.error("carbon插入失败,statusCode"+statusCode);
			String message = jsonObject.getString("message");
			throw new RuntimeException("carbon插入失败:"+message);									
		}		
		return vo ;
		
	}
	/**
	 * 更新广告活动
	 * @param campaignForm
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = RuntimeException.class)
	public ResultVO update(CampaignForm campaignForm) {
		ResultVO vo =new ResultVO();
		//先本地更新
		/**
		 * 更新时间
		 */
		campaignForm.setUpdateTime(DateUtil.getNowDateTimeStr());
		Campaign campaign = new Campaign();
		campaign.setId(campaignForm.getId());
		campaign.setCarbonId(campaignForm.getCarbonId());
		String advertiserIdStr = campaignForm.getAdvertiserId();
		campaign.setBrand(campaignForm.getBrand());
		int advertiserId = 0;
		if(null== advertiserIdStr || !StringUtil.isNumber(advertiserIdStr)){
			vo.setMessage("没有广告主!");
			vo.setResultCode(0);
			return vo;
		}else{
			advertiserId = Integer.parseInt(advertiserIdStr);
		}
		campaign.setAdvertiserId(advertiserId);
		campaign.setName(campaignForm.getName());
		campaign.setStartTime(DateUtil.getDate(DateUtil.getDateFormatString(), campaignForm.getStartTime()));
		campaign.setEndTime(DateUtil.getDate(DateUtil.getDateFormatString(), campaignForm.getEndTime()));
		campaign.setLandingPage(campaignForm.getLandingPage());
		double maxPrice = Double.valueOf(campaignForm.getMaxPrice());
		maxPrice = maxPrice *100;
		campaign.setMaxPrice(new BigDecimal(String.valueOf(maxPrice)).setScale(2,BigDecimal.ROUND_CEILING));
		
		//本地更新
		int effectedRows =0;
		try{
			effectedRows = updateCampaign(campaign);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
		if(effectedRows > 0){
			//本地更新成功
			//更新carbon对应数据
			TalkWithCarbon  talkWithCarbon = new TalkWithCarbon();
			UpdateCampaignParam updateCampaignParam =new UpdateCampaignParam();
			updateCampaignParam.setId(campaignForm.getCarbonId());
			Integer advertiserCarbonId = advertiserService.view(advertiserId).getCarbonId();
			updateCampaignParam.setAdvertiserId(advertiserCarbonId);
			updateCampaignParam.setBrand(campaignForm.getBrand());
			updateCampaignParam.setDspId(UserContext.getDspId());
			updateCampaignParam.setEnd(campaignForm.getEndTime());
			updateCampaignParam.setLandingPage(campaignForm.getLandingPage());
			updateCampaignParam.setName(campaignForm.getName());
			updateCampaignParam.setStart(campaignForm.getStartTime());
			updateCampaignParam.setMaxPrice(Double.valueOf(campaignForm.getMaxPrice())*100);
			Map<String,Object> params = new HashMap<String,Object>();
			try{
			params = JSONUtils.toHashMap(updateCampaignParam);
			}catch(Exception e){
				logger.error("json参数化失败!");
				throw new RuntimeException("json参数化失败!");
			}
			String url = Config.getCarbonHost()+"/campaign/update";
			JSONObject jsonObject = talkWithCarbon.getCarbonVOJson(params, url);
			if(null == jsonObject){
				logger.error("调用carbon失败!");
				throw new RuntimeException("调用carbon失败!");					
			}
			int statusCode = jsonObject.getInt("statusCode");
			if(statusCode == HttpStatus.SC_OK){
				//carbon更新成功!
				vo.setResultCode(1);
				vo.setMessage("操作成功!");
			}else{
				logger.error("调用carbon失败,statusCode:"+statusCode);
				String message = jsonObject.getString("message");
				throw new RuntimeException("carbon更新失败:"+message);
			}
		}else{
			vo.setMessage("本地更新失败!");
			vo.setResultCode(0);
		}
		return vo;
	}
	/**
	 * 注意需要campaign 中每个属性都不为null，可用默认值填充
	 * @param campaign
	 * @return 自增主键
	 */
	@Transactional(rollbackFor = RuntimeException.class)
	public int insertCampaign(Campaign campaign){
		int dspId = UserContext.getDspId();
		
		if(null == campaign){
			return -1;
		}
		campaign.setDspId(dspId);
		Map<String,Object> m =new HashMap<String,Object>();
		m.put("campaign", campaign);
		this.campaignMapper.insertCampaign(m);
		
		int campaignId = (Integer) m.get("id");
		return campaignId;
		
	}
	@Transactional(rollbackFor = RuntimeException.class)
	public int updateCampaign(Campaign campaign){
		if(null == campaign){
			return -1;
		}
		System.out.println("！！！！！！！carbonId="+campaign.getCarbonId());
		Map<String,Object> m =new HashMap<String,Object>();
		m.put("campaign", campaign);
		int row = this.campaignMapper.updateCampaign(m);
		
		
		return row;
	}
	/**
	 * 通过carbonId获取campaign
	 * @param carbonId
	 * @return
	 */
	public Campaign getCampaignByCarbonId(int carbonId) {
		return this.campaignMapper.getCampaignBycarbonId(carbonId);
	}
	/**
	 * 通过广告主id获取广告主信息
	 * @param advertiserId
	 * @return
	 */
	public Advertiser getAdvertiserById(Integer advertiserId) {
		
		return this.campaignMapper.getAdvertiserById(advertiserId);
	}
	/**
	 * 新建时检查是否有重复名称
	 * @param name
	 * @return
	 */
	public boolean chekName(String name,Integer dspId) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", name);
		params.put("dspId", dspId);
		Campaign campaign =  this.campaignMapper.checkName(params);
		if(null == campaign){
			
			return true;
		}else{
			return false;
		}
	}

	
	@Transactional(rollbackFor = RuntimeException.class)
	public ResultVO removeCampaign(int id ,int carbonId){
		ResultVO vo = new ResultVO();
		try{
			List<Integer> rtbIds = this.campaignMapper.getRtbsBycampaignId(id);
			if(null !=rtbIds && rtbIds.size() > 0){
				
				for(int rtbId :rtbIds){
					//删除rtb关联
					rtbAdplacementMaterialMapper.deleteByRtbId(rtbId);
					//删除rtb
					rtbMapper.deleteByRtbId(rtbId);
					
				}
			}
			
			List<Integer> creativeIds = this.campaignMapper.getCreativeIdsByCampaignId(id);
			if(null != creativeIds && creativeIds.size()>0){
				List<Integer> materialIds = this.materialMapper.getMaterialIdsByCreativeIds(creativeIds);
				if(null != materialIds && materialIds.size() > 0){
					List<Integer> adIds = materialMapper.getAdIdsByMaterialIds(materialIds);
					if(null != adIds && adIds.size() > 0){
						//批量删除rtb,广告位和物料关联表的相应记录
						materialMapper.batchDeleteAdsRelationByIds(adIds);
					}
					//删除物料
					this.materialMapper.deleteMaterialsByIds(materialIds);
				}
				//删除创意
				
				creativeMapper.deleteCreativesInLocal(creativeIds);
				
			}
			List<Integer>algorithmIds = this.campaignMapper.getAlgorithmIdsByCampaignId(id);
			if(null != algorithmIds && algorithmIds.size() > 0){
				//删除竞价算法
				algorithmMapper.deleteAlgorithmsByIds(algorithmIds);
			}
			//删除广告活动
			this.campaignMapper.deleteCampaignById(id);
			TalkWithCarbon talkWithCarbon = new TalkWithCarbon();
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("dspId", UserContext.getDspId());
			params.put("id", carbonId);
			String url = Config.getCarbonHost() +"/campaign/delete";
			JSONObject jsonObject = talkWithCarbon.getCarbonVOJson(params, url);
			int statusCode = jsonObject.getInt("statusCode");
			if(HttpStatus.SC_OK == statusCode){
				vo.setResultCode(Constant.RESULT_SUCCESS);
				vo.setMessage("删除成功");
			}else{
				String message = jsonObject.getString("message");
				throw new RuntimeException(message);
			}
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
		
		return vo;
	}
	@Transactional(rollbackFor = RuntimeException.class)
	public  ResultVO deleteCampaignByIdInLocal(int id) {
		ResultVO vo = new ResultVO();
		try{
			List<Integer> rtbIds = this.campaignMapper.getRtbsBycampaignId(id);
			if(null !=rtbIds && rtbIds.size() > 0){
				//删除rtb
				for(int rtbId :rtbIds){
					//删除rtb关联
					rtbAdplacementMaterialMapper.deleteByRtbId(rtbId);
					//删除rtb
					rtbMapper.deleteByRtbId(rtbId);
				}
			}
			
			List<Integer> creativeIds = this.campaignMapper.getCreativeIdsByCampaignId(id);
			if(null != creativeIds && creativeIds.size()>0){
				List<Integer> materialIds = this.materialMapper.getMaterialIdsByCreativeIds(creativeIds);
				if(null != materialIds && materialIds.size() > 0){
					List<Integer> adIds = materialMapper.getAdIdsByMaterialIds(materialIds);
					if(null != adIds && adIds.size() > 0){
						//批量删除广告位和物料关联表的相应记录
						materialMapper.batchDeleteAdsRelationByIds(adIds);
					}
					//删除物料
					this.materialMapper.deleteMaterialsByIds(materialIds);
				}
				//删除创意
				
				creativeService.deleteCreativesInLocal(creativeIds);
				
			}
			List<Integer>algorithmIds = this.campaignMapper.getAlgorithmIdsByCampaignId(id);
			if(null != algorithmIds && algorithmIds.size() > 0){
				//删除竞价算法
				algorithmMapper.deleteAlgorithmsByIds(algorithmIds);
			}
			//删除广告活动
			this.campaignMapper.deleteCampaignById(id);
		}catch(Exception e){
			vo.setResultCode(Constant.RESULT_FAIL);
			vo.setMessage(e.getMessage());
		}
		
		return vo;
	}



	/**
	 * 更新时查看是否有重复名称
	 * @param name
	 * @return
	 */

	public boolean checkOtherName(String name,int carbonId,Integer dspId) {
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("name", name);
		m.put("carbonId", carbonId);
		m.put("dspId", dspId);
		Campaign campaign =  this.campaignMapper.checkOtherName(m);
		if(null == campaign){
			
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 获取一批rtb交易进度未开始的rtb
	 * ①未开始:就是开始时间大于当前时间
	 */
	public List<Integer> getRtbProgressNoStarted(List<Integer> carbonIds){
		
		return this.campaignMapper.getRtbProgressNoStarted(carbonIds);
	}
	/**
	 * 获取一批rtb交易进度暂停的rtb
	 * ②当前时间在开始时间和结束时间之间时：
     *  且active字段为0
     * 
        * ）
	 */
	public List<Integer> getRtbProgressPause(List<Integer> carbonIds){
		return this.campaignMapper.getRtbProgressPause(carbonIds);
	}
	/**
	 * 获取一批rtb交易进度已结束的rtb
	 * 如果当前时间超过了结束时间，就是已结束
	 */
	public List<Integer> getRtbProgressFinished(List<Integer> carbonIds){
		return this.campaignMapper.getRtbProgressFinished(carbonIds);
	}
	/**
	 * 获取一批rtb交易进度可能为
	 * 进行中或者有预算的rtb
	 * ②当前时间在开始时间和结束时间之间时：
     *  且active字段为1
	 */
	public List<Integer> getRtbProgressOverRun(List<Integer> carbonIds){
		return this.campaignMapper.getRtbProgressOverRun(carbonIds);
	}
	
	/**
	 * 通过carbon获取rtb超预算
	 */
	@SuppressWarnings("unchecked")
	public CarbonResultVO getRtbBudgetFromCarbon(int dspId, List<Integer>carbonIds){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("dspId", dspId);
		String idsStr =Utils.ListToStr(carbonIds);
		params.put("ids", idsStr);
		TalkWithCarbon talkWithCarbon = new TalkWithCarbon();
		String url = Config.getCarbonHost() + "/rtb/budget/status";
		JSONObject jsonObject = null;
		CarbonResultVO vo = new CarbonResultVO();
		try{
			jsonObject = talkWithCarbon.getCarbonVOJson(params, url);
		}catch(Exception e){
			vo.setMessage("调用carbon方法失败!");
			vo.setStatusCode(Constant.CALL_CARBON__FAIL);
			vo.setData(null);
			return vo;
		}
		 
		
		int statusCode = jsonObject.getInt("statusCode");
		String message = jsonObject.getString("message");
		if(HttpStatus.SC_OK == statusCode){
			List<OverBudget> overBudgets = new LinkedList<OverBudget>();
			overBudgets = (List<OverBudget>) jsonObject.get("data");
			List<OverBudget> overBudgetList = new  LinkedList<OverBudget>();
			for(int i = 0; i<overBudgets.size(); i++){
				JSONObject json = JSONObject.fromObject(overBudgets.get(i));
				OverBudget o = (OverBudget) JSONObject.toBean(json, OverBudget.class);
				overBudgetList.add(o);
			}
			
			vo.setMessage("操作成功!");
			vo.setStatusCode(Constant.CARBON_RESULT_SUCESS);
			vo.setData(overBudgetList);
			return vo;
		}
		vo.setMessage(message);
		vo.setStatusCode(statusCode);
		vo.setData(null);
		return vo;
	}
	/**
	 * 统计rtb交易进度信息
	 * @param campaignResultVOs
	 * @return
	 */
	
	/**
	 * 获取一个广告活动对应的所有rtb的carbonId
	 */
	public List<Integer> getRtbsByCampaignId(int carbonId){
		return this.campaignMapper.getRtbsByCampaignId(carbonId);
	}
	/**
	 * 批量获取广告活动的rtb交易进度信息
	 * @param dspId
	 * @param  List<CampaignRow> rows
	 * @return List<CampaignRow>
	 */
	public  List<CampaignRow> addRtbProgress(Integer dspId,
			List<CampaignRow> rows) {
		
		if(null == rows || rows.size() == 0){
			return rows;
		}
		/*
		 *取得一个页面上所有的rtb id 
		 */
		List<Integer> rtbIds = new LinkedList<Integer>();
		for(int i=0;i<rows.size();i++){
			List<Integer> ids = rows.get(i).getRtbProgressIds();
			if(null != ids && ids.size()>0){
				for(int ii=0;ii<ids.size();ii++){
					rtbIds.add(ids.get(ii));
				}
			}
			
		}
		if(null ==rtbIds || rtbIds.size() ==0){
			for(int ii=0;ii<rows.size();ii++){
				CampaignRow row = rows.get(ii);
				row.setRtbProgress("未绑定rtb规则");
			}
			return rows;
		}
		for(int k=0;k<rows.size();k++){
			CampaignRow row = rows.get(k);
			
			String rtbProgress = "";
			if(row.getRtbNotStarted() > 0){
				rtbProgress +="未开始("+row.getRtbNotStarted()+"),";
			}
			if(row.getRtbPause() > 0){
				rtbProgress +="暂停("+row.getRtbPause()+"),";
			}
			if(row.getRtbFinished()>0){
				rtbProgress +="已结束("+row.getRtbFinished()+"),";
			}
			if(!"".equals(rtbProgress)){
				rtbProgress = rtbProgress.substring(0,rtbProgress.length()-1);
			}
			row.setRtbProgress(rtbProgress);
		}
		String msg = "";
		boolean isError = false;
		CarbonResultVO carbonResultVO = null;
		try{
			carbonResultVO= getRtbBudgetFromCarbon(dspId, rtbIds);
		}catch(Exception e){
			msg = e.getMessage();
			isError = true;
		}
		if(null == carbonResultVO){
			isError = true;
			msg = "调用carbon失败!";
		}else{
			if(Constant.CARBON_RESULT_SUCESS == carbonResultVO.getStatusCode()){
				@SuppressWarnings("unchecked")
				List<OverBudget> overBudgets = (List<OverBudget>) carbonResultVO.getData();
				Map <Integer,Integer> m =new HashMap<Integer,Integer>();
				for(int i=0;i<overBudgets.size();i++){
					m.put(overBudgets.get(i).getId(), overBudgets.get(i).getStatus());
				}
				for(int ii=0;ii<rows.size();ii++){
					int rtbRunning = 0;
					int rtbAllOverBudget = 0;
					int rtbDailyOverBudget = 0;
					int rtbDailyPv = 0;			
					int rtbNoOverBudget = 0;
					String rtbProgress = "";
					CampaignRow row = rows.get(ii);
					List<Integer> rtbidlist = row.getRtbProgressIds();
					if(null!=rtbidlist && rtbidlist.size() >0){
						for(int j=0;j<rtbidlist.size();j++){
							int status = m.get(rtbidlist.get(j));
							if(0 == status){
								rtbNoOverBudget++;
							}else if(1 == status){
								rtbAllOverBudget ++;
							}else if(2 ==status){
								rtbDailyOverBudget ++;
							}else{
								rtbDailyPv ++;
							}
						}
						rtbRunning = rtbNoOverBudget - row.getRtbFinished() - row.getRtbNotStarted()- row.getRtbPause();
						if(rtbRunning > 0){
							rtbProgress +="进行中("+rtbRunning+"),";
						}
						
						if(rtbAllOverBudget > 0){
							rtbProgress +="总预算已满("+rtbAllOverBudget+"),";
						}
						if(rtbDailyOverBudget >0){
							rtbProgress +="单日预算已满("+rtbDailyOverBudget+"),";
						}
						if(rtbDailyPv >0){
							rtbProgress +="当日曝光已满("+rtbDailyPv+"),";
						}
						if(!"".equals(rtbProgress)){
							rtbProgress = rtbProgress.substring(0,rtbProgress.length()-1);
						}
						isError = false;
						row.setRtbProgress(row.getRtbProgress()+rtbProgress);
						
					}else{
						row.setRtbProgress("未绑定rtb规则");
					}
					
				}
			
			}else{
				 msg = carbonResultVO.getMessage();
				 isError = true; 
			}
		}
		
		if(isError){
			for(int ii=0;ii<rows.size();ii++){
				CampaignRow row = rows.get(ii);
				if(!"".equals(row.getRtbProgress())){
					row.setRtbProgress(row.getRtbProgress()+","+msg);
				}else{
					row.setRtbProgress(msg);
				}
				
			}
		}
		return rows;
	}
    /**
     * 批量计算广告活动的rtb物料状态
     * @param dspId
     * @param List<CampaignRow> rows
     * @return List<CampaignRow>
     */
	public List<CampaignRow> addRtbMaterials(int dspId,List<CampaignRow> rows ){
		
		if(null == rows || rows.size() == 0){
			return rows;
		}
		/*
		 * 取得一个页面上所有物料 Id
		 */
		
		List<Integer> materialIds = new LinkedList<Integer>();
		for(int i=0;i<rows.size();i++){
			List<Integer> ids = rows.get(i).getMaterailIds();
			if(null != ids && ids.size()>0){
				for(int ii=0;ii<ids.size();ii++){
					materialIds.add(ids.get(ii));
				}
			}
			
		}
		if(null ==materialIds || materialIds.size() ==0){
			for(int ii=0;ii<rows.size();ii++){
				CampaignRow row = rows.get(ii);
				row.setRtbMaterialStatus("未添加物料");
			}
		}
		String msg = "";
		if(null == materialIds || materialIds.size() == 0){
			return rows;
		}

		for(int k=0;k<rows.size();k++){
			CampaignRow row = rows.get(k);
			
			String rtbMaterialStatus = "";
			if(row.getDspChecking() > 0){
				rtbMaterialStatus +="DSP审核中("+row.getDspChecking()+"),";
			}
			if(row.getDspRejected() > 0){
				rtbMaterialStatus +="DSP拒绝("+row.getDspRejected()+"),";
			}
			if(!"".equals(rtbMaterialStatus)){
				rtbMaterialStatus = rtbMaterialStatus.substring(0,rtbMaterialStatus.length()-1);
			}
			row.setRtbMaterialStatus(rtbMaterialStatus);
		}
		/*从carbon获取对应id的状态
		 * 
		 */
		boolean isError = false;
	
		CarbonResultVO carbonResultVO = null;
		try{
			carbonResultVO = getMaterialStatusFromCarbon(dspId, materialIds);
		}catch(Exception e){
			isError = true;
			msg = e.getMessage();
		}
		if(null == carbonResultVO){
			isError = true;
			msg = "调用carbon失败!";
		}else{
			if(Constant.CARBON_RESULT_SUCESS == carbonResultVO.getStatusCode()){
				@SuppressWarnings("unchecked")
				List<CarbonMaterialStatusVO> vos = (List<CarbonMaterialStatusVO>) carbonResultVO.getData();
				Map <Integer,Integer> m =new HashMap<Integer,Integer>();
				for(int i=0;i<vos.size();i++){
					m.put(vos.get(i).getId(), vos.get(i).getStatus());
				}
				
				for(int ii =0 ;ii<rows.size();ii++){
					
					int adxChecking = 0;
					int adxRejected = 0;
					int adxPassed = 0;
					String rtbMaterialStatus = "";

					
					CampaignRow row = rows.get(ii);
					List<Integer> mridlist = row.getMaterailIds();
					if(null!=mridlist && mridlist.size() >0){
						for(int j=0;j<mridlist.size();j++){
							int status = m.get(mridlist.get(j));
							if(0 == status){
								adxChecking ++;
							}else if(1 == status){
								adxRejected ++;
							}else{
								adxPassed ++;
							}
						}
						
						if(adxChecking > 0){
							rtbMaterialStatus += "ADX审核中("+adxChecking+"),";
						}
						if(adxRejected > 0){
							rtbMaterialStatus +="ADX拒绝("+adxRejected+"),";
						}
						if(adxPassed >0 ){
							rtbMaterialStatus +="ADX 通过("+adxPassed+"),";
						}
						if(!"".equals(rtbMaterialStatus)){
							rtbMaterialStatus = rtbMaterialStatus.substring(0,rtbMaterialStatus.length()-1);
						}
						isError = false;
						row.setRtbMaterialStatus(rtbMaterialStatus);
						
					}else{
						row.setRtbMaterialStatus("未添加物料");
					}
				}
			}else{
				isError = true;
				msg = carbonResultVO.getMessage();
			}
		}
		
		if(isError){
			for(int i=0;i<rows.size();i++){
				if(!"".equals(rows.get(i).getRtbMaterialStatus())){
					rows.get(i).setRtbMaterialStatus(rows.get(i).getRtbMaterialStatus()+","+msg);
				}else{
					rows.get(i).setRtbMaterialStatus(msg);
				}
			}
		}
		return rows;
	}



	/**
	 * 批量获取 一批广告活动对应的rtb
	 * @param carbonIds
	 * @return
	 */
	public List<CampaignMaterialVO> getCampaignMaterialVOsByCampaignIds(List<Integer> carbonIds) {
		
		//return this.campaignMapper.getCampaignMaterialVOsByCampaignIds(carbonIds);
		return null;
	}


	/**
	 * 从集合中获取dsp审核中的物料id集合
	 * @param carbonIds
	 * @return
	 */
	public List<Integer> getMaterialChecking(List<Integer> carbonIds){
		
		return this.campaignMapper.getMaterialChecking(carbonIds);
	}
	/**
	 * 从集合中获取dsp审核拒绝的物料id集合
	 * @param carbonIds
	 * @return 
	 */
	public List<Integer> getMaterialReject(List<Integer> carbonIds){
		
		return this.campaignMapper.getMaterialReject(carbonIds);
	}
	/**
	 * 从集合中获取dsp审核通过的物料id集合
	 * @param carbonIds
	 * @return List<Integer>
	 */
	public List<Integer> getMaterialPassed(List<Integer> carbonIds){
		
		return this.campaignMapper.getMaterialPassed(carbonIds);
	}
	/**
	 * 从carbon中批量获rtb取物料状态
	 * @param carbonIds
	 * @return
	 */
	public CarbonResultVO getMaterialStatusFromCarbon(int dspId,List<Integer> carbonIds){
		CarbonResultVO carbonResultVO = new CarbonResultVO();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("dapId", dspId);
		params.put("ids", Utils.ListToStr(carbonIds));
		String url = Config.getCarbonHost() + "/material/status";
		TalkWithCarbon talkWithCarbon = new TalkWithCarbon();
		JSONObject jsonObject = null;
		
		try{
		 jsonObject = talkWithCarbon.getCarbonVOJson(params, url);
		 if(jsonObject == null){
			 carbonResultVO.setStatusCode(Constant.CALL_CARBON__FAIL);
			 carbonResultVO.setMessage("调用carbon失败");
			 carbonResultVO.setData(null);
		 }else{
			 int statusCode = jsonObject.getInt("statusCode");
			 String message = jsonObject.getString("message");
			 if(HttpStatus.SC_OK == statusCode){
				 @SuppressWarnings("unchecked")
				JSONArray jArray =  jsonObject.getJSONArray("data");
				
				List<CarbonMaterialStatusVO> datas = JSONArray.toList(jArray, CarbonMaterialStatusVO.class);
				 carbonResultVO.setData(datas);
				 carbonResultVO.setMessage("操作成功！");
				 carbonResultVO.setStatusCode(Constant.CARBON_RESULT_SUCESS);
			 }else{
				 carbonResultVO.setStatusCode(Constant.CALL_CARBON__FAIL);
				 carbonResultVO.setData(null);
				 carbonResultVO.setMessage(message);
			 }
		 }
		}catch(Exception e){
			carbonResultVO.setStatusCode(Constant.CALL_CARBON__FAIL);
			carbonResultVO.setMessage(e.getMessage());
			carbonResultVO.setData(null);
		}
		
		return carbonResultVO;
	}
	//------------------------------------
	public Page<CampaignRow> getPageData(PageParam pageParam) {
		SelectSQLParam selectParams  = getSelectParams(pageParam);
		//获取一个页面的vo集合
		List<CampaignRow> rows = this.campaignMapper.getPagedRows(selectParams);
		int totalCount = getCampaignCounts(selectParams);
		
		// * 增加实时报表信息
		 
		rows = addCampaignChartToResultVO(UserContext.getDspId(), rows);
		
		// * 增加rtb信息；
		 
		rows = addRtbProgress(UserContext.getDspId(), rows);
		
		 //* 增加物料信息
		 
		rows = addRtbMaterials(UserContext.getDspId(), rows);

		//内存排序
		
		

		int totalPage = (totalCount-1) / pageParam.getPageSize() +1;
		int currentPage = pageParam.getCurrentPage();
		Page<CampaignRow> page = new Page<CampaignRow>();
		if(totalCount-1 >-1){
			page.setPageNo(currentPage);
			page.setPageSize(pageParam.getPageSize());
			page.setTotalPages(totalPage);
			page.setTotalRecords(totalCount);
			page.setRows(rows);
		}
		return page;
	}


	/**
	 * 根据id获取广告活动
	 * @param id
	 * @return Campaign
	 */
	public Campaign getCampaignById(int id) {
		
		Campaign campaign =  this.campaignMapper.getCampaignById(id);
		String maxPriceStr = campaign.getMaxPrice().toString();
		double maxPrice = Double.valueOf(maxPriceStr);
		maxPrice /= 100; 
		campaign.setMaxPrice(new BigDecimal(String.valueOf(maxPrice)).setScale(2,BigDecimal.ROUND_CEILING));
		campaign = addCampaignStatus(campaign);
		return  campaign;
	}

 /**
  * 计算广告活动的当前状态：
  * 0：未开始；1:"进行中";2:"已结束"
  * @param campaign
  * @return Campaign
  */
  public Campaign addCampaignStatus(Campaign campaign){
	  if(null != campaign){
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date startTime;
			Date endTime;
			try {
				startTime = sdf2.parse(sdf1.format(campaign.getStartTime())+" 00:00:00");
				endTime = sdf2.parse(sdf1.format(campaign.getEndTime()) +" 23:59:59");
				Date now = sdf2.parse(sdf2.format(new Date()));
				if(null != now){
					if(now.before(startTime)){
						campaign.setCampainStatus(0);//未开始
					}else if(now.after(endTime)){
						campaign.setCampainStatus(2);//已结束
					}else{
						campaign.setCampainStatus(1);//进行中
					}
				}
			} catch (ParseException e) {
				logger.error("增加广告活动状态异常:"+e.getMessage());
				
			}
			
			
			
		}
	  return campaign;
  }


   /**
    * 获取一个广告活动对应的所有rtb中的最晚结束时间
    * @param id 广告活动id
    * @return String 
    */
	public String getRtbMaxEndtime(Integer id) {
		
		Date d = this.campaignMapper.getRtbMaxEndtime(id);
		String maxEndTime ="";
		if(null !=d){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
				maxEndTime =sdf.format(d);
		
		}
		return maxEndTime ;
	}





	/**
	 * 根据id获取一个广告主，无论其是否删除
	 */
	public Advertiser getAdvertiserIgnoreAllById(Integer advertiserId) {
		
		return this.campaignMapper.getAdvertiserIgnoreAllById(advertiserId);
	}
}
