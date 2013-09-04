package com.supertool.dspui.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import com.supertool.dspui.exception.CarbonBadResponseException;
import com.supertool.dspui.model.Algorithm;
import com.supertool.dspui.model.Campaign;
import com.supertool.dspui.model.Creative;
import com.supertool.dspui.model.Material;
import com.supertool.dspui.model.Rtb;
import com.supertool.dspui.model.RtbAdplacementMaterial;
import com.supertool.dspui.param.form.RtbForm;
import com.supertool.dspui.param.form.RtbPageForm;
import com.supertool.dspui.util.JSONUtils;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.TalkWithCarbon;
import com.supertool.dspui.util.Utils;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.RtbFilter;
import com.supertool.dspui.vo.RtbRealReportVO;
import com.supertool.dspui.vo.RtbResultVO;

@Service
public class RtbRuleService {

	private static Logger logger = Logger.getLogger(RtbRuleService.class);

	@Autowired
	private RtbMapper rtbMapper;

	@Autowired
	private RtbAdplacementMaterialMapper rtbAdplacementMaterialMapper;

	@Autowired
	private AlgorithmMapper algorithmMapper;

	@Autowired
	private CreativeMapper creativeMapper;

	@Autowired
	private CampaignMapper campaignMapper;

	@Autowired
	private MaterialMapper materialMapper;

	@Autowired
	private MaterialService materialService;

	@Autowired
	private RegionService regionService;

	@Transactional
	public Integer add(RtbForm rtbForm) {

		Campaign campaign = campaignMapper.getCampaignById(rtbForm
				.getCampaignId());
		Creative creative = creativeMapper.getCreativeById(rtbForm
				.getCreativeId());
		Map<String, Object> rtbParams = new HashMap<String, Object>();
		rtbParams.put("dspId", UserContext.getLoginUser().getDspId());
		rtbParams.put("campaignId", campaign.getCarbonId());
		rtbParams.put("creativeId", creative.getCarbonId());
		rtbParams.put("name", rtbForm.getName().trim());
		rtbParams.put("start", rtbForm.getStartTime());
		rtbParams.put("end", rtbForm.getEndTime());
		// 前台向后台传送价格，需要将单位从元变成分，即乘以100
		BigDecimal times100 = new BigDecimal(100);
		rtbParams.put("totalBudget", rtbForm.getBudget().multiply(times100));
		rtbParams.put("dailyBudget", rtbForm.getDailyBudget()
				.multiply(times100));
		rtbParams.put("dailyPv", rtbForm.getDailyPvCapping() * 1000);
		rtbParams.put("defaultPrice",
				rtbForm.getDefaultPrice().multiply(times100));
		RtbFilter rtbFilter = new RtbFilter();
		rtbFilter.setTimeWeekday(rtbForm.getWeekdays().replaceAll("-", ","));
		rtbFilter.setTimeHour(rtbForm.getTimes().replaceAll("-", ","));
		String dicIdStr = regionService.getDicIdStr(rtbForm.getRegionIds());
		rtbFilter.setGeography(dicIdStr);
		String freAll = rtbForm.getFreAll().equals("-1") ? "0" : rtbForm
				.getFreAll();
		String freWeek = rtbForm.getFreWeek().equals("-1") ? "0" : rtbForm
				.getFreWeek();
		String freDay = rtbForm.getFreDay().equals("-1") ? "0" : rtbForm
				.getFreDay();
		String freHour = rtbForm.getFreHour().equals("-1") ? "0" : rtbForm
				.getFreHour();
		String freMin = rtbForm.getFreMin().equals("-1") ? "0" : rtbForm
				.getFreMin();

		String frequency = freAll + "," + freWeek + "," + freDay + ","
				+ freHour + "," + freMin;

		rtbFilter.setMaxFrequency(frequency);
		rtbParams.put("filters", rtbFilter);
		Integer algorithmId = rtbForm.getAlgorithmId();
		String script = "";
		if (null != algorithmId) {
			Algorithm algorithm = algorithmMapper.getAlgorithmById(rtbForm
					.getAlgorithmId());
			if (null != algorithm) {
				script = StringUtil.encodeToBase64(algorithm.getScript());
			}
		}
		rtbParams.put("script", script);
		String rtbAddUrl = Config.getCarbonHost() + Constant.RTB_ADD_URL;
		JSONObject rtbAddResponse = new TalkWithCarbon().getCarbonVOJson(
				rtbParams, rtbAddUrl);
		if (null == rtbAddResponse) {
			logger.error("[Carbon] Carbon连接失败 \nurl: " + rtbAddUrl
					+ "\nparam: " + JSONUtils.mapToJsonString(rtbParams));
			throw new CarbonBadResponseException("Carbon连接失败");
		}
		int rtbStatusCode = (Integer) rtbAddResponse.get("statusCode");
		String rtbMessage = (String) rtbAddResponse.get("message");

		if (Constant.CARBON_STATUS_CODE_SUCCESS != rtbStatusCode) {
			logger.error("[Carbon] " + rtbStatusCode + " " + rtbMessage
					+ "\nurl: " + rtbAddUrl + "\nparam: "
					+ JSONUtils.mapToJsonString(rtbParams));
			throw new CarbonBadResponseException(rtbMessage);
		}
		int rtbCarbonId = (Integer) rtbAddResponse.get("id");

		Rtb rtb = new Rtb();
		rtb.setCarbonId(rtbCarbonId);
		rtb.setDspId(UserContext.getLoginUser().getDspId());
		rtb.setName(rtbForm.getName().trim());
		rtb.setCampaignId(rtbForm.getCampaignId());
		rtb.setCreativeId(rtbForm.getCreativeId());
		rtb.setStartTime(StringUtil.formatStringToDate(rtbForm.getStartTime(),
				"yyyy-MM-dd"));
		rtb.setEndTime(StringUtil.formatStringToDate(rtbForm.getEndTime()
				+ " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
		rtb.setBudget(rtbForm.getBudget());
		rtb.setDailyBudget(rtbForm.getDailyBudget());
		rtb.setDailyPv(rtbForm.getDailyPvCapping() * 1000);
		rtb.setDefaultPrice(rtbForm.getDefaultPrice());
		rtb.setFilterHour(rtbForm.getTimes().replaceAll("-", ","));
		rtb.setFilterWeekDay(rtbForm.getWeekdays().replaceAll("-", ","));
		rtb.setFilterGeo(rtbForm.getRegionIds());
		rtb.setFilterFrequency(frequency);
		rtb.setAlgorithmId(null == algorithmId ? 0 : algorithmId);
		rtb.setCreateTime(new Date());
		rtbMapper.add(rtb);

		String mediaIds[] = rtbForm.getMediaIds().equals("") ? new String[0]
				: rtbForm.getMediaIds().split(",");
		String[] amRelationArray = rtbForm.getAmRelation().equals("") ? new String[0]
				: rtbForm.getAmRelation().split(",");
		Map<Integer, Integer> amRelationMap = new HashMap<Integer, Integer>();
		for (String amRelation : amRelationArray) {
			String[] item = amRelation.split("-");
			amRelationMap.put(Integer.parseInt(item[0]),
					Integer.parseInt(item[1]));
		}
		for (String mediaId : mediaIds) {
			Integer adplacementId = Integer.parseInt(mediaId);
			if (adplacementId.equals(0)) {
				continue;
			}
			Integer materialId = amRelationMap.get(adplacementId);
			if (null != materialId && !materialId.equals(0)) {
				Map<String, Object> rtbRelationParams = new HashMap<String, Object>();
				rtbRelationParams.put("dspId", UserContext.getLoginUser()
						.getDspId());
				rtbRelationParams.put("rtbId", rtbCarbonId);
				rtbRelationParams.put("adplacementId", adplacementId);
				Material material = materialMapper.getMaterial(materialId);
				rtbRelationParams.put("materialId", material.getCarbonId());
				String rtbRelationAddUrl = Config.getCarbonHost()
						+ Constant.RTB_RELATION_ADD_URL;
				JSONObject rtbRelationAddResponse = new TalkWithCarbon()
						.getCarbonVOJson(rtbRelationParams, rtbRelationAddUrl);
				if (null == rtbRelationAddResponse) {
					logger.error("[Carbon] Carbon连接失败 \nurl: "
							+ rtbRelationAddUrl + "\nparam: "
							+ JSONUtils.mapToJsonString(rtbRelationParams));
					throw new CarbonBadResponseException("Carbon连接失败");
				}
				int rtbRelationStatusCode = (Integer) rtbRelationAddResponse
						.get("statusCode");
				String rtbRelationMessage = (String) rtbRelationAddResponse
						.get("message");

				if (Constant.CARBON_STATUS_CODE_SUCCESS != rtbRelationStatusCode) {
					logger.error("[Carbon] " + rtbRelationStatusCode + " "
							+ rtbRelationMessage + "\nurl: "
							+ rtbRelationAddUrl + "\nparam: "
							+ JSONUtils.mapToJsonString(rtbRelationParams));
					throw new CarbonBadResponseException(rtbRelationMessage);
				}
			}

			RtbAdplacementMaterial rtbRelation = new RtbAdplacementMaterial();
			rtbRelation.setMaterialId(null == materialId ? 0 : materialId);
			rtbRelation.setRtbId(rtb.getId());
			rtbRelation.setAdPlacementId(adplacementId);
			rtbAdplacementMaterialMapper.add(rtbRelation);
		}
		return rtb.getId();
	}

	public RtbRealReportVO getRealReportById(Integer id) {
		Rtb rtb = rtbMapper.getById(id);
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(rtb.getCarbonId());
		Map<Integer, RtbRealReportVO> realReportMap = getRealReportMap(ids);
		RtbRealReportVO realReport = realReportMap.get(rtb.getCarbonId());
		if (null == realReport) {
			realReport = new RtbRealReportVO();
		}
		return realReport;
	}

	@Transactional
	public String deleteByRtbId(Integer rtbId) {
		deleteRtbRelationByRtbId(rtbId);
		Rtb rtb = rtbMapper.getById(rtbId);
		Map<String, Object> rtbParams = new HashMap<String, Object>();
		rtbParams.put("dspId", UserContext.getLoginUser().getDspId());
		rtbParams.put("id", rtb.getCarbonId());
		String rtbDeleteUrl = Config.getCarbonHost() + Constant.RTB_DELETE_URL;
		JSONObject rtbDeleteResponse = new TalkWithCarbon().getCarbonVOJson(
				rtbParams, rtbDeleteUrl);
		if (null == rtbDeleteResponse) {
			logger.error("[Carbon] Carbon连接失败 \nurl: " + rtbDeleteUrl
					+ "\nparam: " + JSONUtils.mapToJsonString(rtbParams));
			throw new CarbonBadResponseException("Carbon连接失败");
		}
		int statusCode = (Integer) rtbDeleteResponse.get("statusCode");
		String message = (String) rtbDeleteResponse.get("message");

		if (Constant.CARBON_STATUS_CODE_SUCCESS != statusCode) {
			logger.error("[Carbon] " + statusCode + " " + message + "\nurl: "
					+ rtbDeleteUrl + "\nparam: "
					+ JSONUtils.mapToJsonString(rtbParams));
			throw new CarbonBadResponseException(message);
		}
		rtbMapper.deleteByRtbId(rtbId);
		return null;
	}

	public String deleteRtbRelationByRtbId(Integer rtbId) {
		Rtb rtb = rtbMapper.getById(rtbId);
		Map<String, Object> rtbRelationParams = new HashMap<String, Object>();
		rtbRelationParams.put("dspId", UserContext.getLoginUser().getDspId());
		rtbRelationParams.put("rtbId", rtb.getCarbonId());
		String rtbRelationDeleteUrl = Config.getCarbonHost()
				+ Constant.RTB_RELATION_DELETE_URL;
		JSONObject rtbRelationDeleteResponse = new TalkWithCarbon()
				.getCarbonVOJson(rtbRelationParams, rtbRelationDeleteUrl);
		if (null == rtbRelationDeleteResponse) {
			logger.error("[Carbon] Carbon连接失败 \nurl: " + rtbRelationDeleteUrl
					+ "\nparam: "
					+ JSONUtils.mapToJsonString(rtbRelationParams));
			throw new CarbonBadResponseException("Carbon连接失败");
		}
		int statusCode = (Integer) rtbRelationDeleteResponse.get("statusCode");
		String message = (String) rtbRelationDeleteResponse.get("message");

		if (Constant.CARBON_STATUS_CODE_SUCCESS != statusCode) {
			logger.error("[Carbon] " + statusCode + " " + message + "\nurl: "
					+ rtbRelationDeleteUrl + "\nparam: "
					+ JSONUtils.mapToJsonString(rtbRelationParams));
			throw new CarbonBadResponseException(message);
		}
		rtbAdplacementMaterialMapper.deleteByRtbId(rtbId);
		return null;
	}

	public Page<RtbResultVO> list(RtbPageForm form) {

		int pageSize = form.getPageSize();
		int pageNo = form.getPageNo();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderName", form.getOrderBy());
		params.put("orderValue", form.getOrder());
		params.put("startRow", pageSize * (pageNo - 1));
		params.put("limitRows", pageSize);
		List<Integer> campaignIdList = new ArrayList<Integer>();
		campaignIdList.add(form.getCampaignId());
		params.put("campaignIds", campaignIdList);
		List<Rtb> rtbList = rtbMapper.getPagedRtbsByIds(params);
		int totalRecords = rtbMapper.getRtbsCount(params);

		List<Integer> rtbIds = new ArrayList<Integer>();
		for (Rtb rtb : rtbList) {
			rtbIds.add(rtb.getCarbonId());
		}

		Map<Integer, Integer> budgetStatusMap = getBudgetStatusMap(rtbIds);
		Map<Integer, RtbRealReportVO> realReportMap = getRealReportMap(rtbIds);
		List<RtbResultVO> resultList = new ArrayList<RtbResultVO>();
		Date now = new Date();
		for (Rtb rtb : rtbList) {
			RtbResultVO rtbResult = new RtbResultVO();
			rtbResult.setId(rtb.getId());
			rtbResult.setCarbonId(rtb.getCarbonId());
			rtbResult.setName(rtb.getName());
			rtbResult.setStartTime(StringUtil.dateToFormatString("yyyy-MM-dd",
					rtb.getStartTime()));
			rtbResult.setEndTime(StringUtil.dateToFormatString("yyyy-MM-dd",
					rtb.getEndTime()));
			rtbResult.setProgress(buildProgress(rtb,
					budgetStatusMap.get(rtb.getCarbonId())));
			rtbResult.setMaterialStatus(buildMaterialStatus(rtb.getId()));

			RtbRealReportVO realReport = realReportMap.get(rtb.getCarbonId());
			if (null != realReport) {
				rtbResult.setPv(realReport.getPv());
				rtbResult.setClick(realReport.getClick());
				rtbResult.setCtr(realReport.getCtr());
				rtbResult.setDailyPv(realReport.getDailyPv());
				rtbResult.setDailyClick(realReport.getDailyClick());
				rtbResult.setDailyCtr(realReport.getDailyCtr());
				rtbResult.setDailyCost(realReport.getDailyCost());
				rtbResult.setAvgPrice(realReport.getAvgPrice());
				rtbResult.setMaxPrice(realReport.getMaxPrice());
				rtbResult.setMinPrice(realReport.getMinPrice());
				rtbResult.setTotalCost(realReport.getTotalCost());
			}
			rtbResult.setDeletable(rtb.getStartTime().after(now));
			rtbResult.setEditable(rtb.getEndTime().after(now));
			resultList.add(rtbResult);
		}

		Page<RtbResultVO> page = new Page<RtbResultVO>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setTotalRecords(totalRecords);
		page.setTotalPages(Utils.getTotalPage(totalRecords, pageSize));
		page.setRows(resultList);
		return page;
	}

	public Map<Integer, RtbRealReportVO> getRealReportMap(List<Integer> ids) {
		Map<Integer, RtbRealReportVO> map = new HashMap<Integer, RtbRealReportVO>();
		if (null == ids || ids.size() == 0) {
			return map;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dspId", UserContext.getLoginUser().getDspId());
		params.put("ids", Utils.ListToStr(ids));
		String url = Config.getCarbonHost() + Constant.RTB_REAL_REPORT_URL;
		JSONObject jsonObject = new TalkWithCarbon().getCarbonVOJson(params,
				url);
		if (null == jsonObject) {
			logger.error("[Carbon] Carbon连接失败 \nurl: " + url + "\nparam: "
					+ JSONUtils.mapToJsonString(params));
			return map;
		}
		int statusCode = jsonObject.getInt("statusCode");
		String message = jsonObject.getString("message");
		if (Constant.CARBON_STATUS_CODE_SUCCESS != statusCode) {
			logger.error("[Carbon] " + statusCode + " " + message + "\nurl: "
					+ url + "\nparam: " + JSONUtils.mapToJsonString(params));
			return map;
		}
		JSONArray data = jsonObject.getJSONArray("data");
		if (null == data) {
			logger.error("[Carbon] RTB实时报表数据为null \nurl: " + url + "\nparam: "
					+ JSONUtils.mapToJsonString(params));
			return map;
		}
		for (int i = 0; i < data.size(); i++) {
			JSONObject stat = data.getJSONObject(i);
			int id = stat.getInt("id");
			long pv = stat.getLong("pv");
			long click = stat.getLong("click");
			long dailyPv = stat.getLong("dailyPv");
			long dailyClick = stat.getLong("dailyClick");
			double dailyCost = stat.getDouble("dailyCost");
			double avgPrice = stat.getDouble("avgPrice");
			double maxPrice = stat.getDouble("maxPrice");
			double minPrice = stat.getDouble("minPrice");
			double totalCost = stat.getDouble("totalCost");
			double ctr = pv == 0 ? 0 : new BigDecimal(click).divide(
					new BigDecimal(pv), 10, BigDecimal.ROUND_HALF_UP)
					.doubleValue();
			double dailyCtr = dailyPv == 0 ? 0 : new BigDecimal(dailyClick)
					.divide(new BigDecimal(dailyPv), 10,
							BigDecimal.ROUND_HALF_UP).doubleValue();
			RtbRealReportVO rtbRealReport = new RtbRealReportVO();
			rtbRealReport.setPv(pv);
			rtbRealReport.setClick(click);
			rtbRealReport.setCtr(ctr);
			rtbRealReport.setDailyPv(dailyPv);
			rtbRealReport.setDailyClick(dailyClick);
			rtbRealReport.setDailyCtr(dailyCtr);
			rtbRealReport.setDailyCost(dailyCost);
			rtbRealReport.setAvgPrice(avgPrice);
			rtbRealReport.setMaxPrice(maxPrice);
			rtbRealReport.setMinPrice(minPrice);
			rtbRealReport.setTotalCost(totalCost);
			map.put(id, rtbRealReport);
		}
		return map;
	}

	public Rtb getById(Integer id) {
		return rtbMapper.getById(id);
	}

	@Transactional
	public String update(RtbForm rtbForm) {
		Rtb oldRtb = rtbMapper.getById(rtbForm.getId());
		Creative creative = creativeMapper.getCreativeById(rtbForm
				.getCreativeId());
		Map<String, Object> rtbParams = new HashMap<String, Object>();
		rtbParams.put("dspId", UserContext.getLoginUser().getDspId());
		rtbParams.put("id", oldRtb.getCarbonId());
		rtbParams.put("creativeId", creative.getCarbonId());
		rtbParams.put("name", rtbForm.getName().trim());
		rtbParams.put("start", rtbForm.getStartTime());
		rtbParams.put("end", rtbForm.getEndTime());
		// 前台向后台传送价格，需要将单位从元变成分，即乘以100
		BigDecimal times100 = new BigDecimal(100);
		rtbParams.put("totalBudget", rtbForm.getBudget().multiply(times100));
		rtbParams.put("dailyBudget", rtbForm.getDailyBudget()
				.multiply(times100));
		rtbParams.put("dailyPv", rtbForm.getDailyPvCapping() * 1000);
		rtbParams.put("defaultPrice",
				rtbForm.getDefaultPrice().multiply(times100));
		RtbFilter rtbFilter = new RtbFilter();
		rtbFilter.setTimeWeekday(rtbForm.getWeekdays().replaceAll("-", ","));
		rtbFilter.setTimeHour(rtbForm.getTimes().replaceAll("-", ","));
		String dicIdStr = regionService.getDicIdStr(rtbForm.getRegionIds());
		rtbFilter.setGeography(dicIdStr);
		String freAll = rtbForm.getFreAll().equals("-1") ? "0" : rtbForm
				.getFreAll();
		String freWeek = rtbForm.getFreWeek().equals("-1") ? "0" : rtbForm
				.getFreWeek();
		String freDay = rtbForm.getFreDay().equals("-1") ? "0" : rtbForm
				.getFreDay();
		String freHour = rtbForm.getFreHour().equals("-1") ? "0" : rtbForm
				.getFreHour();
		String freMin = rtbForm.getFreMin().equals("-1") ? "0" : rtbForm
				.getFreMin();

		String frequency = freAll + "," + freWeek + "," + freDay + ","
				+ freHour + "," + freMin;

		rtbFilter.setMaxFrequency(frequency);
		rtbParams.put("filters", rtbFilter);
		Integer algorithmId = rtbForm.getAlgorithmId();
		String script = "";
		if (null != algorithmId) {
			Algorithm algorithm = algorithmMapper.getAlgorithmById(rtbForm
					.getAlgorithmId());
			if (null != algorithm) {
				script = StringUtil.encodeToBase64(algorithm.getScript());
			}
		}
		rtbParams.put("script", script);

		String rtbUpdateUrl = Config.getCarbonHost() + Constant.RTB_UPDATE_URL;
		JSONObject rtbUpdateResponse = new TalkWithCarbon().getCarbonVOJson(
				rtbParams, rtbUpdateUrl);
		if (null == rtbUpdateResponse) {
			logger.error("[Carbon] Carbon连接失败 \nurl: " + rtbUpdateUrl
					+ "\nparam: " + JSONUtils.mapToJsonString(rtbParams));
			throw new CarbonBadResponseException("Carbon连接失败");
		}
		int rtbStatusCode = (Integer) rtbUpdateResponse.get("statusCode");
		String rtbMessage = (String) rtbUpdateResponse.get("message");

		if (Constant.CARBON_STATUS_CODE_SUCCESS != rtbStatusCode) {
			logger.error("[Carbon] " + rtbStatusCode + " " + rtbMessage
					+ "\nurl: " + rtbUpdateUrl + "\nparam: "
					+ JSONUtils.mapToJsonString(rtbParams));
			throw new CarbonBadResponseException(rtbMessage);
		}

		Rtb rtb = new Rtb();
		rtb.setId(rtbForm.getId());
		rtb.setName(rtbForm.getName().trim());
		rtb.setCreativeId(rtbForm.getCreativeId());
		rtb.setStartTime(StringUtil.formatStringToDate(rtbForm.getStartTime(),
				"yyyy-MM-dd"));
		rtb.setEndTime(StringUtil.formatStringToDate(rtbForm.getEndTime()
				+ " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
		rtb.setBudget(rtbForm.getBudget());
		rtb.setDailyBudget(rtbForm.getDailyBudget());
		rtb.setDailyPv(rtbForm.getDailyPvCapping() * 1000);
		rtb.setDefaultPrice(rtbForm.getDefaultPrice());
		rtb.setFilterHour(rtbForm.getTimes().replaceAll("-", ","));
		rtb.setFilterWeekDay(rtbForm.getWeekdays().replaceAll("-", ","));
		rtb.setFilterGeo(rtbForm.getRegionIds());
		rtb.setFilterFrequency(frequency);
		rtb.setAlgorithmId(null == algorithmId ? 0 : algorithmId);
		rtbMapper.update(rtb);

		deleteRtbRelationByRtbId(rtbForm.getId());
		String mediaIds[] = rtbForm.getMediaIds().equals("") ? new String[0]
				: rtbForm.getMediaIds().split(",");
		String[] amRelationArray = rtbForm.getAmRelation().equals("") ? new String[0]
				: rtbForm.getAmRelation().split(",");
		Map<Integer, Integer> amRelationMap = new HashMap<Integer, Integer>();
		for (String amRelation : amRelationArray) {
			String[] item = amRelation.split("-");
			amRelationMap.put(Integer.parseInt(item[0]),
					Integer.parseInt(item[1]));
		}
		for (String mediaId : mediaIds) {
			Integer adplacementId = Integer.parseInt(mediaId);
			if (adplacementId.equals(0)) {
				continue;
			}
			Integer materialId = amRelationMap.get(adplacementId);
			if (null != materialId && !materialId.equals(0)) {
				Map<String, Object> rtbRelationParams = new HashMap<String, Object>();
				rtbRelationParams.put("dspId", UserContext.getLoginUser()
						.getDspId());
				rtbRelationParams.put("rtbId", oldRtb.getCarbonId());
				rtbRelationParams.put("adplacementId", adplacementId);
				Material material = materialMapper.getMaterial(materialId);
				rtbRelationParams.put("materialId", material.getCarbonId());
				String rtbRelationAddUrl = Config.getCarbonHost()
						+ Constant.RTB_RELATION_ADD_URL;
				JSONObject rtbRelationAddResponse = new TalkWithCarbon()
						.getCarbonVOJson(rtbRelationParams, rtbRelationAddUrl);
				if (null == rtbRelationAddResponse) {
					logger.error("[Carbon] Carbon连接失败 \nurl: "
							+ rtbRelationAddUrl + "\nparam: "
							+ JSONUtils.mapToJsonString(rtbRelationParams));
					throw new CarbonBadResponseException("Carbon连接失败");
				}
				int rtbRelationStatusCode = (Integer) rtbRelationAddResponse
						.get("statusCode");
				String rtbRelationMessage = (String) rtbRelationAddResponse
						.get("message");
				if (Constant.CARBON_STATUS_CODE_SUCCESS != rtbRelationStatusCode) {
					logger.error("[Carbon] " + rtbRelationStatusCode + " "
							+ rtbRelationMessage + "\nurl: "
							+ rtbRelationAddUrl + "\nparam: "
							+ JSONUtils.mapToJsonString(rtbRelationParams));
					if (Constant.CARBON_ADPLACEMENT_NOT_EXIST == rtbRelationStatusCode) {
						continue;
					} else {
						throw new CarbonBadResponseException(rtbRelationMessage);
					}
				}
			}

			RtbAdplacementMaterial rtbRelation = new RtbAdplacementMaterial();
			rtbRelation.setMaterialId(null == materialId ? 0 : materialId);
			rtbRelation.setRtbId(rtb.getId());
			rtbRelation.setAdPlacementId(adplacementId);
			rtbAdplacementMaterialMapper.add(rtbRelation);
		}
		return null;
	}

	public Map<Integer, Integer> getBudgetStatusMap(List<Integer> ids) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (null == ids || ids.size() == 0) {
			return map;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dspId", UserContext.getLoginUser().getDspId());
		params.put("ids", Utils.ListToStr(ids));
		String url = Config.getCarbonHost() + Constant.RTB_BUDGET_STATUS;
		JSONObject jsonObject = new TalkWithCarbon().getCarbonVOJson(params,
				url);
		if (null == jsonObject) {
			logger.error("[Carbon] Carbon连接失败 \nurl: " + url + "\nparam: "
					+ JSONUtils.mapToJsonString(params));
			return map;
		}
		int statusCode = (Integer) jsonObject.get("statusCode");
		String message = (String) jsonObject.get("message");
		if (Constant.CARBON_STATUS_CODE_SUCCESS != statusCode) {
			logger.error("[Carbon] " + statusCode + " " + message + "\nurl: "
					+ url + "\nparam: " + JSONUtils.mapToJsonString(params));
			return map;
		}
		JSONArray data = jsonObject.getJSONArray("data");
		if (null == data) {
			logger.error("[Carbon] RTB计划超预算状态数据为null \nurl: " + url
					+ "\nparam: " + JSONUtils.mapToJsonString(params));
			return map;
		}
		for (int i = 0; i < data.size(); i++) {
			JSONObject result = data.getJSONObject(i);
			int id = result.getInt("id");
			int status = result.getInt("status");
			map.put(id, status);
		}
		return map;
	}

	public boolean checkName(String name, Integer campaignId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("campaignId", campaignId);
		Rtb rtb = rtbMapper.checkName(params);
		return null == rtb;
	}

	private Integer buildProgress(Rtb rtb, Integer status) {
		Date startTime = rtb.getStartTime();
		Date endTime = rtb.getEndTime();
		Date now = new Date();
		if (startTime.after(now)) {
			return Constant.RTB_PROGRESS_NOT_STARTED;
		}
		if (endTime.before(now)) {
			return Constant.RTB_PROGRESS_ENDED;
		}
		if (rtb.getActive().equals((byte) 0)) {
			return Constant.RTB_PROGRESS_SUSPENDED;
		}
		if (Constant.RTB_BUDGET_STATUS_OVER_BUDGET.equals(status)) {
			return Constant.RTB_PROGRESS_OVER_BUDGET;
		}
		if (Constant.RTB_BUDGET_STATUS_OVER_DAILY_BUDGET.equals(status)) {
			return Constant.RTB_PROGRESS_OVER_DAILY_BUDGET;
		}
		if (Constant.RTB_BUDGET_STATUS_OVER_DAILY_PV.equals(status)) {
			return Constant.RTB_PROGRESS_OVER_DAILY_PV;
		}
		return Constant.RTB_PROGRESS_RUNNING;
	}

	@Transactional
	public void updateActive(Integer id, boolean active) {
		Rtb rtb = rtbMapper.getById(id);
		Map<String, Object> rtbParams = new HashMap<String, Object>();
		rtbParams.put("dspId", UserContext.getDspId());
		rtbParams.put("id", rtb.getCarbonId());
		rtbParams.put("active", active);
		String rtbUpdateUrl = Config.getCarbonHost() + Constant.RTB_UPDATE_URL;
		JSONObject rtbUpdateResponse = new TalkWithCarbon().getCarbonVOJson(
				rtbParams, rtbUpdateUrl);
		if (null == rtbUpdateResponse) {
			logger.error("[Carbon] Carbon连接失败 \nurl: " + rtbUpdateUrl
					+ "\nparam: " + JSONUtils.mapToJsonString(rtbParams));
			throw new CarbonBadResponseException("Carbon连接失败");
		}
		int rtbStatusCode = (Integer) rtbUpdateResponse.get("statusCode");
		String rtbMessage = (String) rtbUpdateResponse.get("message");
		if (Constant.CARBON_STATUS_CODE_SUCCESS != rtbStatusCode) {
			logger.error("[Carbon] " + rtbStatusCode + " " + rtbMessage
					+ "\nurl: " + rtbUpdateUrl + "\nparam: "
					+ JSONUtils.mapToJsonString(rtbParams));
			throw new CarbonBadResponseException(rtbMessage);
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("active", active ? 1 : 0);
		rtbMapper.updateActive(params);
	}

	public List<RtbAdplacementMaterial> getRtbRelationByRtbId(Integer rtbId) {
		return rtbAdplacementMaterialMapper.getByRtbId(rtbId);
	}

	public String getAMRelationStr(List<RtbAdplacementMaterial> rtbRelationList) {
		String str = "";
		for (RtbAdplacementMaterial rtbAdplacementMaterial : rtbRelationList) {
			Integer adId = rtbAdplacementMaterial.getAdPlacementId();
			Integer materialId = rtbAdplacementMaterial.getMaterialId();
			if (!materialId.equals(0)) {
				str += adId + "-" + materialId + ",";
			}
		}
		str = "".equals(str) ? "" : str.substring(0, str.length() - 1);
		return str;
	}

	private String buildMaterialStatus(Integer rtbId) {
		String result = " ";
		int noMaterial = 0; // rtb关联了广告位，但是没有关联物料
		int auditing = 0; // 审核中
		int passed = 0; // 通过
		int refused = 0; // 拒绝
		List<Integer> materialIdList = new ArrayList<Integer>();
		List<RtbAdplacementMaterial> rtbRelationList = rtbAdplacementMaterialMapper
				.getByRtbId(rtbId);
		if (rtbRelationList.size() == 0) {
			return "无"; // rtb没有关联广告位
		}
		for (RtbAdplacementMaterial rtbRelation : rtbRelationList) {
			Integer materialId = rtbRelation.getMaterialId();
			if (materialId.equals(0)) {
				noMaterial++;
			} else {
				// TODO 应该一次查出来
				Material material = materialMapper.getMaterial(materialId);
				materialIdList.add(material.getCarbonId());
			}
		}
		Map<Integer, Integer> materialStatusMap = materialService
				.getMaterialStatusMap(materialIdList);
		Set<Integer> keySet = materialStatusMap.keySet();
		for (Integer materialId : keySet) {
			int status = materialStatusMap.get(materialId);
			if (status == 0) {
				auditing++;
			}
			if (status == 1) {
				refused++;
			}
			if (status == 2) {
				passed++;
			}
		}
		if (noMaterial > 0) {
			result += "未关联(" + noMaterial + ")，";
		}
		if (auditing > 0) {
			result += "审核中(" + auditing + ")，";
		}
		if (passed > 0) {
			result += "通过(" + passed + ")，";
		}
		if (refused > 0) {
			result += "拒绝(" + refused + ")，";
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}

	public List<Rtb> getByAlgorithmId(int id) {
		List<Rtb> rtbs = rtbMapper.getByAlgorithmId(id);
		return rtbs;
	}

	public Integer getCountByAlgorithmId(Integer algorithmId) {
		return rtbMapper.getCountByAlgorithmId(algorithmId);
	}
}
