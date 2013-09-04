package com.supertool.dspui.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.mybatis.AlgorithmMapper;
import com.supertool.dspui.framework.carboninterface.CarbonInterface;
import com.supertool.dspui.model.Algorithm;
import com.supertool.dspui.model.Rtb;
import com.supertool.dspui.param.GridParam;
import com.supertool.dspui.param.SelectSQLParam;
import com.supertool.dspui.param.carboninterface.AlgorithmTestBid;
import com.supertool.dspui.param.carboninterface.AlgorithmTestData;
import com.supertool.dspui.param.carboninterface.AlgorithmTestDataSource;
import com.supertool.dspui.param.carboninterface.AlgorithmTestParam;
import com.supertool.dspui.param.carboninterface.AlgorithmTestRady;
import com.supertool.dspui.param.carboninterface.AlgorithmTestRtb;
import com.supertool.dspui.param.carboninterface.MapDataSource;
import com.supertool.dspui.param.carboninterface.SetDataSource;
import com.supertool.dspui.util.JSONUtils;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.vo.AlgorithmVO;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.ResultVO;

@Service
public class AlgorithmService {

	@Autowired
	private AlgorithmMapper algorithmMapper;
	@Autowired
	private RtbRuleService rtbRuleService;

	private static Logger logger = Logger.getLogger(AlgorithmService.class);
	
	public Page<AlgorithmVO> getPagedAlgorithmList(GridParam pageParam, Integer campaignId) {
		int pgsize = pageParam.getPageSize() < 1 ? 20 : pageParam.getPageSize();
		int start = (pageParam.getPageNo() -1 )*pageParam.getPageSize(); 
		String key = "";
		boolean isNumber = false;
		if(pageParam.getSearchValue() != null ){
			key = pageParam.getSearchValue().trim();
			if(!key.isEmpty()){
				if(StringUtils.isNumeric(key)){
					isNumber = true;
				}else{
					key = key.replace("_", "\\_").replace("%", "\\%");
				}
			}
		}
		SelectSQLParam sqlParam = new SelectSQLParam(null, start, pageParam.getPageSize(), pageParam.getOrderBy(), pageParam.getOrder(), pageParam.getSearchBy(), key, isNumber);
		List<Algorithm> list = this.algorithmMapper.getPagedAlgorithmList(sqlParam, UserContext.getDspId(),campaignId);
		int totalCount = algorithmMapper.getTotalCount(sqlParam, UserContext.getDspId(),campaignId);
		int totalPage = totalCount % pgsize == 0 ? totalCount / pgsize : totalCount / pgsize + 1;
		List<AlgorithmVO> resultList = new ArrayList<AlgorithmVO>();
		for (Algorithm algorithm : list) {
			AlgorithmVO algorithmVO = new AlgorithmVO();
			algorithmVO.setId(algorithm.getId());
			algorithmVO.setDspId(algorithm.getDspId());
			algorithmVO.setName(algorithm.getName());
			algorithmVO.setScript(algorithm.getScript());
			algorithmVO.setDescription(algorithm.getDescription());
			algorithmVO.setCampaignId(algorithm.getCampaignId());
			int rtbCount = rtbRuleService.getCountByAlgorithmId(algorithm
					.getId());
			algorithmVO.setRtbCount(rtbCount);
			resultList.add(algorithmVO);
		}
		Page<AlgorithmVO> pagedResultVO = new Page<AlgorithmVO>();
		pagedResultVO.setRows(resultList);
		pagedResultVO.setPageNo(pageParam.getPageNo());
		pagedResultVO.setPageSize(pgsize);
		pagedResultVO.setTotalRecords(totalCount);
		pagedResultVO.setTotalPages(totalPage);
		logger.info("查询算法成功");
		return pagedResultVO;
	}
	
	public Page<AlgorithmVO> getPagedAlgorithmListAll(GridParam param) {
		int pgsize = param.getPageSize() < 1 ? 15 : param.getPageSize();
		int start = (param.getPageNo() -1 )*param.getPageSize(); 
		String key = "";
		boolean isNumber = false;
		if(param.getSearchValue() != null ){
			key = param.getSearchValue().trim();
			if(!key.isEmpty()){
				if(StringUtils.isNumeric(key)){
					isNumber = true;
				}else{
					key = key.replace("_", "\\_").replace("%", "\\%");
				}
			}
		}
		SelectSQLParam sqlParam = new SelectSQLParam(null, start, param.getPageSize(), param.getOrderBy(), param.getOrder(), param.getSearchBy(), key, isNumber);
		List<AlgorithmVO> list = this.algorithmMapper.getPageAlgorithmVOList(sqlParam, UserContext.getDspId());//getPagedAlgorithmListAll(sqlParam, UserContext.getDspId());
		int totalCount = algorithmMapper.getTotalCountAll(sqlParam, UserContext.getDspId());
		int totalPage = totalCount % pgsize == 0 ? totalCount / pgsize : totalCount / pgsize + 1;
		Page<AlgorithmVO> pagedResultVO = new Page<AlgorithmVO>();
		pagedResultVO.setRows(list);
		pagedResultVO.setPageNo(param.getPageNo());
		pagedResultVO.setPageSize(pgsize);
		pagedResultVO.setTotalRecords(totalCount);
		pagedResultVO.setTotalPages(totalPage);
		logger.info("查询算法成功");
		return pagedResultVO;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public ResultVO create(Algorithm algorithm) {
		algorithm.setCreateTime(new Date());
		algorithm.setDeleteTime(new Date());
		algorithm.setIsDeleted((byte)0);
		algorithm.setUpdateTime(new Date());
		algorithm.setDspId(UserContext.getDspId());
		algorithm.setDescription(algorithm.getDescription() == null ? "" : algorithm.getDescription().trim());
		algorithm.setName(algorithm.getName() == null ? "" : algorithm.getName().trim());
		algorithm.setCampaignId(algorithm.getCampaignId());
		algorithm.setScript(algorithm.getScript());
		int nums = algorithmMapper.create(algorithm);
		ResultVO resultVO = new ResultVO();
		if(nums > 0 && algorithm.getId() > 0){
			resultVO.setResultCode(0);
			resultVO.setMessage("成功");
			resultVO.getMap().put("id", algorithm.getId());
		}else{
			resultVO.setResultCode(1);
			resultVO.setMessage("失败");
		}
		return resultVO;
	}

	public Algorithm view(Integer id) {
		return algorithmMapper.getAlgorithmById(id);
	}
	

	public Algorithm getCampaignId(Integer id) {
		return algorithmMapper.getAlgorithmById(id);
	}

	public boolean check(Algorithm algorithm) {
		List<Algorithm> list;
		String name = algorithm.getName() == null ? "":algorithm.getName().trim();
		Integer id = algorithm.getId();
		if(algorithm.getId() > 0){
			list = algorithmMapper.checkByNameAndId(name, id, UserContext.getDspId(), algorithm.getCampaignId());
		}else{
			list = algorithmMapper.checkByName(name, UserContext.getDspId(), algorithm.getCampaignId());
		}
		if(list != null && list.size() > 0){
			return false;
		}
		return true;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public ResultVO edit(Algorithm algorithm) {
		algorithm.setUpdateTime(new Date());
		algorithm.setDescription(algorithm.getDescription() == null ? "" : algorithm.getDescription().trim());
		algorithm.setName(algorithm.getName() == null ? "" : algorithm.getName().trim());
		algorithm.setScript(algorithm.getScript());
		ResultVO resultVO = new ResultVO();
		int nums = algorithmMapper.edit(algorithm);
		
		if(nums > 0){
			List<Rtb> rtbs = rtbRuleService.getByAlgorithmId(algorithm.getId());
			if(rtbs != null){
				for(int i = 0; i < rtbs.size(); i++){
					Rtb rtb = rtbs.get(i);
					JSONObject requestResult = CarbonInterface.updateRtbAlorithm(rtb,algorithm.getScript());
					try {
						if(requestResult != null){
							String resultCode = requestResult.getString("resultCode");
							if("1".equals(resultCode)){
								JSONObject json = requestResult.getJSONObject("result");
								if(200 == json.getInt("statusCode")){
									//do nothing until circle stop
									continue;
								}else{
									throw new RuntimeException("carbon更新rtb:"+rtb.getCarbonId()+"的算法失败，异常:" +json.getString("statusCode") + json.getString("message"));
								}
							}else{
								throw new RuntimeException("carbon更新rtb:"+rtb.getCarbonId()+"的算法失败，" + requestResult.getString("message"));
							}
						}else{
							throw new RuntimeException("carbon更新rtb:"+rtb.getCarbonId()+"的算法失败，未知异常");
						}
					} catch (Exception e) {
						throw new RuntimeException("carbon更新rtb:"+rtb.getCarbonId()+"的算法失败，未知异常");
					}
				}
			}
			resultVO.getMap().put("id", algorithm.getId());
			resultVO.setResultCode(0);
			resultVO.setMessage("成功");
		}
		return resultVO;
	}

	
	@Transactional(rollbackFor = Exception.class)
	public ResultVO delete(Algorithm algorithm) {
		ResultVO resultVO = new ResultVO();
		boolean b = checkUsage(algorithm.getId());
		if(!b){
			resultVO.setResultCode(0);
			resultVO.setMessage("算法已经被绑定，不能删除");
			return resultVO;
		}
		int nums = algorithmMapper.delete(algorithm);
		if(nums > 0){
			resultVO.getMap().put("id", algorithm.getId());
			resultVO.setResultCode(1);
			resultVO.setMessage("成功");
		}
		return resultVO;
	}

	public List<Algorithm> getByCampaignId(Integer campaignId){
		return algorithmMapper.getByCampaignId(campaignId);
	}
	
	public Algorithm getAlgorithmById(Integer id){
		return algorithmMapper.getAlgorithmById(id);
	}
	
	/**
	 * 检查算法是否已被使用
	 * @param id
	 * @return
	 */
	private Boolean checkUsage(int id) {
		int num = algorithmMapper.countBindAlgorithmRtb(id);
		if(num > 0){
			return false;
		}
		return true;
	}

	public ResultVO test(Map<String, String> map) {
		ResultVO resultVO = new ResultVO();
		try{
			AlgorithmTestParam algorithmTestParam = new AlgorithmTestParam();//(map, AlgorithmTestParam.class);
			AlgorithmTestData data = new AlgorithmTestData();
			
			AlgorithmTestBid bid = new AlgorithmTestBid();
			AlgorithmTestRtb rtb= new AlgorithmTestRtb();
			AlgorithmTestRady rady = new AlgorithmTestRady();
			List<Integer> frequency = new ArrayList<Integer>();
			Map<String, AlgorithmTestDataSource> dataSources = new HashMap<String, AlgorithmTestDataSource>();
			
			
			//bid
			int adplacement_height = map.get("data.bid.adplacement_height") == null ? 0 : "".equals(map.get("data.bid.adplacement_height").trim()) ? 0 : Integer.parseInt(map.get("data.bid.adplacement_height").trim());
			int adplacement_id = map.get("data.bid.adplacement_id") == null ? 0 : "".equals(map.get("data.bid.adplacement_id").trim()) ? 0 : Integer.parseInt(map.get("data.bid.adplacement_id").trim());
			String adplacement_type = map.get("data.bid.adplacement_type") == null ? "" : map.get("data.bid.adplacement_type").trim();
			int adplacement_width = map.get("data.bid.adplacement_width") == null ? 0 : "".equals(map.get("data.bid.adplacement_width").trim()) ? 0 : Integer.parseInt(map.get("data.bid.adplacement_width").trim());
			String bidfloor = map.get("data.bid.bidfloor") == null ? "0" : "".equals(map.get("data.bid.bidfloor").trim()) ? "0" : map.get("data.bid.bidfloor").trim();
			String ip = map.get("data.bid.ip") == null ? "" : map.get("data.bid.ip").trim();
			String site_name = map.get("data.bid.site_name") == null ? "" : map.get("data.bid.site_name").trim();
			String site_url = map.get("data.bid.site_url") == null ? "" : map.get("data.bid.site_url").trim();
			String site_ref = map.get("data.bid.site_ref") == null ? "" : map.get("data.bid.site_ref").trim();
			String user_agent = map.get("data.bid.user_agent") == null ? "" : map.get("data.bid.user_agent").trim();
			String user_id = map.get("data.bid.user_id") == null ? "" : map.get("data.bid.user_id").trim();
			List<String> video_linearity = new ArrayList<String>();
			if(map.get("data.bid.video_linearity1") != null || map.get("data.bid.video_linearity2") != null){
				if(map.get("data.bid.video_linearity1") != null){
					video_linearity.add("1");
				}
				if(map.get("data.bid.video_linearity2") != null){
					video_linearity.add("2");
				}
			}
			int video_maxduration = map.get("data.bid.video_maxduration") == null ? 0 : "".equals(map.get("data.bid.video_maxduration").trim()) ? 0 : Integer.parseInt(map.get("data.bid.video_maxduration").trim());
			List<String> video_mimes = new ArrayList<String>();//map.get("").split(";");
			if(map.get("data.bid.video_mimes1") != null || map.get("data.bid.video_mimes2") != null){
				if(map.get("data.bid.video_mimes1") != null){
					video_mimes.add(map.get("data.bid.video_mimes1").trim());
				}
				if(map.get("data.bid.video_mimes2") != null){
					video_mimes.add(map.get("data.bid.video_mimes2").trim());
				}
			}
			int video_minduration = map.get("data.bid.video_minduration") == null ? 0 : "".equals(map.get("data.bid.video_minduration").trim()) ? 0 : Integer.parseInt(map.get("data.bid.video_minduration").trim());
			bid.setAdplacement_height(adplacement_height);
			bid.setAdplacement_id(adplacement_id);
			bid.setAdplacement_type(adplacement_type);
			bid.setAdplacement_width(adplacement_width);
			BigDecimal floor = new BigDecimal(bidfloor);
			bid.setBidfloor((int)(floor.floatValue() * 100));
			bid.setIp(ip);
			bid.setSite_name(site_name);
			bid.setSite_url(site_url);
			bid.setSite_ref(site_ref);
			bid.setUser_agent(user_agent);
			bid.setUser_id(user_id);
			bid.setVideo_linearity(video_linearity);
			bid.setVideo_maxduration(video_maxduration);
			bid.setVideo_mimes(video_mimes);
			bid.setVideo_minduration(video_minduration );
			
			//rtb
			int advertiser = map.get("data.rtb.advertiser") == null ? 0 : "".equals(map.get("data.rtb.advertiser").trim()) ? 0 : Integer.parseInt(map.get("data.rtb.advertiser").trim());
			int agency = map.get("data.rtb.agency") == null ? 0 : "".equals(map.get("data.rtb.agency").trim()) ? 0 : Integer.parseInt(map.get("data.rtb.agency").trim());
			int creative = map.get("data.rtb.creative") == null ? 0 : "".equals(map.get("data.rtb.creative").trim()) ? 0 : Integer.parseInt(map.get("data.rtb.creative").trim());
			String default_price = map.get("data.rtb.default_price") == null ? "0" : "".equals(map.get("data.rtb.default_price").trim()) ? "0" : map.get("data.rtb.default_price").trim();
			String end = map.get("data.rtb.end") == null ? "" : "".equals(map.get("data.rtb.end").trim()) ? "0" : map.get("data.rtb.end").trim();
			String landingpage = map.get("data.rtb.landingpage") == null ? "" : map.get("data.rtb.landingpage").trim();
			int material_bytes = map.get("data.rtb.material_bytes") == null ? 0 : "".equals(map.get("data.rtb.material_bytes").trim()) ? 0 : Integer.parseInt(map.get("data.rtb.material_bytes").trim());
			int material_height = map.get("data.rtb.material_height") == null ? 0 : "".equals(map.get("data.rtb.material_height").trim()) ? 0 : Integer.parseInt(map.get("data.rtb.material_height").trim());
			int material_id = map.get("data.rtb.material_id") == null ? 0 : "".equals(map.get("data.rtb.material_id").trim()) ? 0 : Integer.parseInt(map.get("data.rtb.material_id").trim());
			int material_time = map.get("data.rtb.material_time") == null ? 0 : "".equals(map.get("data.rtb.material_time").trim()) ? 0 : Integer.parseInt(map.get("data.rtb.material_time").trim());
			String material_type = map.get("data.rtb.material_type") == null ? "" : map.get("data.rtb.material_type").trim();
			String material_url = map.get("data.rtb.material_url") == null ? "" : map.get("data.rtb.material_url").trim();
			int material_width = map.get("data.rtb.material_width") == null ? 0 : "".equals(map.get("data.rtb.material_width").trim()) ? 0 : Integer.parseInt(map.get("data.rtb.material_width").trim());
			String max_price = map.get("data.rtb.max_price") == null ? "0" : "".equals(map.get("data.rtb.max_price").trim()) ? "0" : map.get("data.rtb.max_price").trim();
			String start = map.get("data.rtb.start") == null ? "0" : "".equals(map.get("data.rtb.start").trim()) ? "0" : map.get("data.rtb.start").trim();
			rtb.setAdvertiser(advertiser);
			rtb.setAgency(agency);
			rtb.setCreative(creative);
			BigDecimal dftprc = new BigDecimal(default_price);
			rtb.setDefault_price((int)(dftprc.floatValue() * 100));
			rtb.setEnd(Integer.parseInt(end.replace("-", "")));
			rtb.setLandingpage(landingpage);
			rtb.setMaterial_bytes(material_bytes);
			rtb.setMaterial_height(material_height);
			rtb.setMaterial_id(material_id);
			rtb.setMaterial_time(material_time);
			rtb.setMaterial_type(material_type);
			rtb.setMaterial_url(material_url);
			rtb.setMaterial_width(material_width);
			BigDecimal mxprc = new BigDecimal(max_price);
			rtb.setMax_price((int)(mxprc.floatValue() * 100));
			rtb.setStart(Integer.parseInt(start.replace("-", "")));
			
			//rady
			int today_campaign_click = map.get("data.rady.today_campaign_click") == null ? 0 : "".equals(map.get("data.rady.today_campaign_click").trim()) ? 0 : Integer.parseInt(map.get("data.rady.today_campaign_click").trim());
			int total_rtb_pv = map.get("data.rady.total_rtb_pv") == null ? 0 : "".equals(map.get("data.rady.total_rtb_pv").trim()) ? 0 : Integer.parseInt(map.get("data.rady.total_rtb_pv").trim());
			String today_campaign_cost = map.get("data.rady.today_campaign_cost") == null ? "0" : "".equals(map.get("data.rady.today_campaign_cost").trim()) ? "0" : map.get("data.rady.today_campaign_cost").trim();
			int today_campaign_pv = map.get("data.rady.today_campaign_pv") == null ? 0 : "".equals(map.get("data.rady.today_campaign_pv").trim()) ? 0 : Integer.parseInt(map.get("data.rady.today_campaign_pv").trim());
			int today_campaign_uv = map.get("data.rady.today_campaign_click") == null ? 0 : "".equals(map.get("data.rady.today_campaign_click").trim()) ? 0 : Integer.parseInt(map.get("data.rady.today_campaign_uv").trim());
			int today_rtb_click = map.get("data.rady.today_rtb_click") == null ? 0 : "".equals(map.get("data.rady.today_rtb_click").trim()) ? 0 : Integer.parseInt(map.get("data.rady.today_rtb_click").trim());
			String today_rtb_cost = map.get("data.rady.today_rtb_cost") == null ? "0" : "".equals(map.get("data.rady.today_rtb_cost").trim()) ? "0" : map.get("data.rady.today_rtb_cost").trim();
			int today_rtb_pv = map.get("data.rady.today_rtb_pv") == null ? 0 : "".equals(map.get("data.rady.today_rtb_pv").trim()) ? 0 : Integer.parseInt(map.get("data.rady.today_rtb_pv").trim());
			int total_campaign_click = map.get("data.rady.total_campaign_click") == null ? 0 : "".equals(map.get("data.rady.total_campaign_click").trim()) ? 0 : Integer.parseInt(map.get("data.rady.total_campaign_click").trim());
			String total_campaign_cost = map.get("data.rady.total_campaign_cost") == null ? "0" : "".equals(map.get("data.rady.total_campaign_cost").trim()) ? "0" : map.get("data.rady.total_campaign_cost").trim();
			int total_campaign_pv = map.get("data.rady.total_campaign_pv") == null ? 0 : "".equals(map.get("data.rady.total_campaign_pv").trim()) ? 0 : Integer.parseInt(map.get("data.rady.total_campaign_pv").trim());
			int total_campaign_uv = map.get("data.rady.total_campaign_uv") == null ? 0 : "".equals(map.get("data.rady.total_campaign_uv").trim()) ? 0 : Integer.parseInt(map.get("data.rady.total_campaign_uv").trim());
			int total_rtb_click = map.get("data.rady.total_rtb_click") == null ? 0 : "".equals(map.get("data.rady.total_rtb_click").trim()) ? 0 : Integer.parseInt(map.get("data.rady.total_rtb_click").trim());
			String total_rtb_cost = map.get("data.rady.total_rtb_cost") == null ? "0" : "".equals(map.get("data.rady.total_rtb_cost").trim()) ? "0" : map.get("data.rady.total_rtb_cost").trim();
			
			rady.setToday_campaign_click(today_campaign_click);
			BigDecimal tdcc = new BigDecimal(today_campaign_cost);
			rady.setToday_campaign_cost(tdcc.doubleValue() * 100);
			rady.setToday_campaign_pv(today_campaign_pv);
			rady.setToday_campaign_uv(today_campaign_uv);
			rady.setToday_rtb_click(today_rtb_click);
			BigDecimal trc = new BigDecimal(today_rtb_cost);
			rady.setToday_rtb_cost(trc.doubleValue()*100);
			rady.setToday_rtb_pv(today_rtb_pv);
			rady.setTotal_campaign_click(total_campaign_click);
			BigDecimal tcc = new BigDecimal(total_campaign_cost);
			rady.setTotal_campaign_cost(tcc.doubleValue()*100);
			rady.setTotal_campaign_pv(total_campaign_pv);
			rady.setTotal_campaign_uv(total_campaign_uv);
			rady.setTotal_rtb_click(total_rtb_click);
			BigDecimal ttrc = new BigDecimal(total_rtb_cost);
			rady.setTotal_rtb_cost(ttrc.doubleValue() * 100);
			rady.setTotal_rtb_pv(total_rtb_pv);
			
			//frequency
			frequency.add(0, map.get("data.frequency[0]") == null ? 0 : "".equals(map.get("data.frequency[0]").trim()) ? 0 : Integer.parseInt(map.get("data.frequency[0]").trim()));
			frequency.add(1, map.get("data.frequency[1]") == null ? 0 : "".equals(map.get("data.frequency[1]").trim()) ? 0 : Integer.parseInt(map.get("data.frequency[1]").trim()));
			frequency.add(2, map.get("data.frequency[2]") == null ? 0 : "".equals(map.get("data.frequency[2]").trim()) ? 0 : Integer.parseInt(map.get("data.frequency[2]").trim()));
			frequency.add(3, map.get("data.frequency[3]") == null ? 0 : "".equals(map.get("data.frequency[3]").trim()) ? 0 : Integer.parseInt(map.get("data.frequency[3]").trim()));
			frequency.add(4, map.get("data.frequency[4]") == null ? 0 : "".equals(map.get("data.frequency[4]").trim()) ? 0 : Integer.parseInt(map.get("data.frequency[4]").trim()));
			
			Iterator<String> keyIterator = map.keySet().iterator();
			Map<String,MapDataSource> maptableMap = new HashMap<String, MapDataSource>();
			Map<String, SetDataSource> settableMap = new HashMap<String, SetDataSource>();
			while(keyIterator.hasNext()){
				String key = keyIterator.next();
				if(key.startsWith("data.datasource")){
					
					String tableId = key.substring(0,key.indexOf('.', 6));//data.datasource[1]
					String name = map.get(tableId + ".name");
					String type = map.get(tableId + ".type");
					if("MAP".equalsIgnoreCase(type)){
						MapDataSource datasource = maptableMap.get(name);
						if(null == datasource){
							datasource = new MapDataSource();
						}
						datasource.setType(type);
						maptableMap.put(name, datasource);
						
						if(key.endsWith(".type")){
							//do nothing,因为已经在创建时setType了
						}
						if(key.contains("key")){
							String keyvalue = map.get(key);
							String valuekey = key.replace("key", "value");
							String valuevalue = map.get(valuekey);
							
							Map<String,String> dt = datasource.getData();
							if(dt == null ){
								dt = new HashMap<String, String>();
							}
							dt.put(keyvalue, valuevalue);
							datasource.setData(dt);
						}
						if(key.contains("value")){
							//do nothing,因为在获取key时已经做了
						}
						if(key.contains("name")){
							//do nothing,因为在第一步时已经做了
						}
						
					}else{
						SetDataSource datasource = settableMap.get(name);
						if(null == datasource){
							datasource = new SetDataSource();
						}else{
							
						}
						datasource.setType(type);
						settableMap.put(name, datasource);
						
						if(key.endsWith(".type")){
							//do nothing,因为已经在创建时setType了
						}
						if(key.contains("key")){
							//do nothing,SetDatasource没有key
						}
						if(key.contains("value")){
							String value = map.get(key);
							List<String> dt = datasource.getData();
							if(dt == null){
								dt = new ArrayList<String>();
							}
							dt.add(value);
							datasource.setData(dt);
						}
					}
					
				}
			}
			
			dataSources.putAll(maptableMap);
			dataSources.putAll(settableMap);
			
			data.bid = bid;
			data.rady = rady;
			data.frequency = frequency;
			data.datasource = dataSources;
			data.rtb = rtb;
			String script = map.get("script") == null ? "" : map.get("script").trim();
			script = StringUtil.encodeToBase64(script);
			
			algorithmTestParam.setScript(script);
			algorithmTestParam.setData(data);
			
			JSONObject jsonObject = JSONUtils.toJSONObject(algorithmTestParam);
			String body = JSONUtils.toJSONString(jsonObject);
			JSONObject requestResult = CarbonInterface.requestCarbon(Config.getCarbonHost()+"/script/test", body);
			String resultCode = requestResult.getString("resultCode");
			if("1".equals(resultCode)){
				resultVO.setMessage("测试请求成功");
				resultVO.setResultCode(1);
				JSONObject result = requestResult.getJSONObject("result");
				String msg = result.getString("msg");
				String log = result.getString("log");
				msg = StringUtil.decodeBase64ToString(msg);
				log = StringUtil.decodeBase64ToString(log);
				result.put("msg", msg);//消息base64解码
				result.put("log", log);
				resultVO.getMap().put("result", result);
			}else{
				resultVO.setMessage(requestResult.getString("message"));
				resultVO.setResultCode(0);
			}
			return resultVO;
		}catch (Exception e) {
			e.printStackTrace();
			resultVO.setResultCode(0);
			resultVO.setMessage(e.getMessage());
			return resultVO;
		}
	}

	private AlgorithmTestParam mapToParam(Map<String, String> map,Class<?> cls) {
		Set<Object> classPool = new HashSet<Object>();
		classPool.add(cls.getClass());
		Set<String> keys = map.keySet();
		System.out.println(cls.getDeclaredFields());
		Iterator it = keys.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			String[] k = key.split("\\\\.");
			for(int i = 0; i< k.length; i++){
				String field = k[i];
			}
			System.out.println(key);
		}
		return null;
	}
	public static void main(String[] args) {
//		Class cls = AlgorithmTestParam.class;
//		Field[] f = cls.getDeclaredFields();
//		System.out.println(f[0].getType().getName());
//		System.out.println(f[0].getName());
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("script", "return 1;");
		String d = "data.datasource[11].value[122323]";
		d.indexOf('.', 6);
		System.out.println(d.substring(0, d.indexOf('.', 6)));
	}

	public static boolean compile(Map<String, String> map) {
	    map.put("script", StringUtil.encodeToBase64(map.get("script")));
		String body = JSONUtils.mapToJsonString(map);
		JSONObject result = CarbonInterface.requestCarbon(Config.getCarbonHost()+"/script/test", body);
		try{
			if(result != null && "1".equals(result.getString("resultCode"))){
				JSONObject json = result.getJSONObject("result");
				if(json.getInt("statusCode") == 200){
					if(json.getInt("code") != 1){
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		return false;
	}
}
