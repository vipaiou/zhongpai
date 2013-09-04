package com.supertool.dspui.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.exception.CarbonBadResponseException;
import com.supertool.dspui.model.Algorithm;
import com.supertool.dspui.model.Campaign;
import com.supertool.dspui.model.Creative;
import com.supertool.dspui.model.Region;
import com.supertool.dspui.model.Rtb;
import com.supertool.dspui.model.RtbAdplacementMaterial;
import com.supertool.dspui.param.form.RtbForm;
import com.supertool.dspui.param.form.RtbPageForm;
import com.supertool.dspui.service.AdplacementService;
import com.supertool.dspui.service.AlgorithmService;
import com.supertool.dspui.service.CampaignService;
import com.supertool.dspui.service.CreativeService;
import com.supertool.dspui.service.RegionService;
import com.supertool.dspui.service.RtbRuleService;
import com.supertool.dspui.util.DateUtil;
import com.supertool.dspui.util.JSONUtils;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.Utils;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.RtbRealReportVO;
import com.supertool.dspui.vo.RtbResultVO;

@Controller
public class RtbRuleController {

	@Autowired
	private RtbRuleService rtbRuleService;

	@Autowired
	private RegionService regionService;

	@Autowired
	private CampaignService campaignService;

	@Autowired
	private CreativeService creativeService;

	@Autowired
	private AlgorithmService algorithmService;

	@Autowired
	private AdplacementService adplacementService;

	@RequestMapping("/rtbRule/save")
	public String save(RtbForm form, Model model) {
		Integer id = 0;
		try {
			id = rtbRuleService.add(form);
		} catch (CarbonBadResponseException e) {
			model.addAttribute("message", e.getMessage());
			model.addAttribute("campaignId", form.getCampaignId());
			return "forward:create";
		}
		return "redirect:view?id=" + id;
	}

	@RequestMapping("/rtbRule/snippet/stats")
	public String snippetStats(@RequestParam("id") Integer id, Model model) {
		RtbRealReportVO realReport = rtbRuleService.getRealReportById(id);
		model.addAttribute("report", realReport);
		return "rtbRule/snippet/stats";
	}

	@RequestMapping("/rtbRule/delete")
	public @ResponseBody
	boolean delete(Integer id, Model model) {
		try {
			rtbRuleService.deleteByRtbId(id);
		} catch (CarbonBadResponseException e) {
			model.addAttribute("message", e.getMessage());
			return false;
		}
		return true;
	}

	@RequestMapping("/rtbRule/list")
	public @ResponseBody
	Page<RtbResultVO> list(RtbPageForm form) {
		Page<RtbResultVO> page = rtbRuleService.list(form);
		return page;
	}

	@RequestMapping("rtbRule/view")
	public String view(Integer id, Model model) {
		Rtb rtb = rtbRuleService.getById(id);
		Campaign campaign = campaignService
				.getCampaignById(rtb.getCampaignId());
		Creative creative = creativeService.findById(rtb.getCreativeId());
		Algorithm algorithm = algorithmService.getAlgorithmById(rtb
				.getAlgorithmId());
		List<RtbAdplacementMaterial> rtbRelationList = rtbRuleService
				.getRtbRelationByRtbId(id);
		List<Integer> mediaIdList = new ArrayList<Integer>();
		for (RtbAdplacementMaterial rtbAdplacementMaterial : rtbRelationList) {
			mediaIdList.add(rtbAdplacementMaterial.getAdPlacementId());
		}
		model.addAttribute("r", rtb);
		model.addAttribute("c", campaign);
		model.addAttribute("mediaIds", Utils.ListToStr(mediaIdList));
		model.addAttribute("regionNames", getRegionNames(rtb.getFilterGeo()));
		Date now = new Date();
		Date camEndTime = StringUtil.formatStringToDate(
				StringUtil.dateToFormatString("yyyy-MM-dd",
						campaign.getEndTime())
						+ " 23:59:59", "yyyy-MM-dd HH:mm:ss");
		model.addAttribute("isCampaignOver", camEndTime.before(now));
		model.addAttribute("isRtbOver", rtb.getEndTime().before(now));
		model.addAttribute("creative", creative);
		model.addAttribute("algorithm", algorithm);
		return "rtbRule/view";
	}

	private String getRegionNames(String regionIds) {
		String regionNames = "不限";
		if (null != regionIds && !"".equals(regionIds)) {
			String[] idArray = regionIds.split(",");
			List<Integer> ids = new ArrayList<Integer>();
			for (String idStr : idArray) {
				ids.add(Integer.parseInt(idStr));
			}
			List<Region> list = regionService.getByIds(ids);
			if (regionService.isSelectAll(list)) {
				regionNames = "中国大陆";
			} else {
				regionNames = regionService.toInfoString(list);
			}
		}
		return regionNames;
	}

	@RequestMapping("rtbRule/index")
	public String index(Integer campaignId, Model model) {
		Campaign campaign = campaignService.getCampaignById(campaignId);
		model.addAttribute("c", campaign);
		Date endTime = StringUtil.formatStringToDate(
				StringUtil.dateToFormatString("yyyy-MM-dd",
						campaign.getEndTime())
						+ " 23:59:59", "yyyy-MM-dd HH:mm:ss");
		model.addAttribute("isCampaignOver", endTime.before(new Date()));
		return "rtbRule/index";
	}

	@RequestMapping("rtbRule/create")
	public String create(Integer campaignId, Model model) {
		Campaign campaign = campaignService.getCampaignById(campaignId);
		Date minDate = DateUtil.getMax(new Date(), campaign.getStartTime());
		List<Creative> creatives = creativeService.getByCampaignId(campaignId);
		List<Algorithm> algorithms = algorithmService
				.getByCampaignId(campaignId);
		List<String> sizes = adplacementService.getAllSizes();
		model.addAttribute("c", campaign);
		model.addAttribute("minTime", minDate);
		model.addAttribute("creatives", creatives);
		model.addAttribute("algorithms", algorithms);
		model.addAttribute("sizes", JSONUtils.toJSONString(sizes));
		return "rtbRule/create";
	}

	@RequestMapping("rtbRule/edit")
	public String edit(Integer id, Model model) {
		Rtb rtb = rtbRuleService.getById(id);
		Campaign campaign = campaignService
				.getCampaignById(rtb.getCampaignId());
		Date now = new Date();
		Date minDate = DateUtil.getMax(now, campaign.getStartTime());
		List<Creative> creatives = creativeService.getByCampaignId(rtb
				.getCampaignId());
		List<Algorithm> algorithms = algorithmService.getByCampaignId(campaign
				.getId());
		List<RtbAdplacementMaterial> rtbRelationList = rtbRuleService
				.getRtbRelationByRtbId(id);
		List<Integer> mediaIdList = new ArrayList<Integer>();
		for (RtbAdplacementMaterial rtbAdplacementMaterial : rtbRelationList) {
			mediaIdList.add(rtbAdplacementMaterial.getAdPlacementId());
		}
		String amRelationStr = rtbRuleService.getAMRelationStr(rtbRelationList);
		List<String> sizes = adplacementService.getAllSizes();
		model.addAttribute("r", rtb);
		model.addAttribute("c", campaign);
		model.addAttribute("mediaIds", Utils.ListToStr(mediaIdList));
		model.addAttribute("amRelation", amRelationStr);
		model.addAttribute("regionIds", rtb.getFilterGeo());
		model.addAttribute("regionNames", getRegionNames(rtb.getFilterGeo()));
		model.addAttribute("minDate",
				StringUtil.dateToFormatString("yyyy-MM-dd", minDate));
		model.addAttribute("isRtbStart", rtb.getStartTime().before(now));
		model.addAttribute("creatives", creatives);
		model.addAttribute("algorithms", algorithms);
		model.addAttribute("sizes", JSONUtils.toJSONString(sizes));
		return "rtbRule/edit";
	}

	@RequestMapping("/rtbRule/update")
	public String update(RtbForm form, Model model) {
		try {
			rtbRuleService.update(form);
		} catch (CarbonBadResponseException e) {
			model.addAttribute("message", e.getMessage());
			model.addAttribute("id", form.getId());
			return "forward:edit";
		}
		return "redirect:view?id=" + form.getId();
	}

	@RequestMapping("/rtbRule/checkName")
	public @ResponseBody
	boolean checkName(String name, String oldName, Integer campaignId) {
		if (name.equals(oldName)) {
			return true;
		}
		return rtbRuleService.checkName(name, campaignId);
	}

	@RequestMapping("/rtbRule/suspend")
	public @ResponseBody
	boolean suspend(Integer id) {
		try {
			rtbRuleService.updateActive(id, false);
		} catch (CarbonBadResponseException e) {
			return false;
		}
		return true;
	}

	@RequestMapping("/rtbRule/resume")
	public @ResponseBody
	boolean resume(Integer id) {
		try {
			rtbRuleService.updateActive(id, true);
		} catch (CarbonBadResponseException e) {
			return false;
		}
		return true;
	}
}
