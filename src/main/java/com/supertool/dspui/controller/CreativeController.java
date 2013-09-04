package com.supertool.dspui.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.model.Campaign;
import com.supertool.dspui.model.Creative;
import com.supertool.dspui.param.PageParam;
import com.supertool.dspui.service.CampaignService;
import com.supertool.dspui.service.CreativeService;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.ResultVO;


@Controller
@RequestMapping("/creative")
public class CreativeController {

	@Autowired
	private CreativeService  creativeService;
	
	@Autowired
	private CampaignService  campaignService;
	
	 @RequestMapping("/create")
	 public String create(int campaignId , Model model) {
	    
	        Campaign campaign = campaignService.getCampaignById(campaignId);
	        model.addAttribute("campaign", campaign);
	        return edit(null, model);
	 }

	 @RequestMapping("/edit")
	 public String edit(@RequestParam("id") Integer id, Model model) {
	        if (null != id) {
	            Creative cr = creativeService.findById(id);
	            model.addAttribute("cr", cr);
	            Campaign campaign = this.campaignService.addCampaignStatus( cr.getCampaign());
	            model.addAttribute("campaign", campaign);
	        } 
	        return "creative/edit";
	 }

	
	 @RequestMapping("/save")
	 public @ResponseBody ResultVO save( @RequestParam(value = "id", required = false) Integer id , @RequestParam(value = "crCarbonId", required = false) Integer crCarbonId ,String name, String description ,int campaignId ,int carbonId, Model model) {
		 
	       Creative creative = new Creative();
	       creative.setName(StringUtil.trimSRN(name));
	       creative.setDescription(StringUtil.trimSRN(description));
	       Campaign campaign = new Campaign();
	       campaign.setId(campaignId);
	       campaign.setCarbonId(carbonId);
	       if(null != crCarbonId){
	    	   creative.setCarbonId(crCarbonId);
	       }
	       creative.setCampaign(campaign);
	       creative.setDspId(UserContext.getDspId());
	       if(null == id){
	    	   id = 0 ;
	       }
	       creative.setId(id);
	       ResultVO vo = new ResultVO();
	       try{
	    	   vo = creativeService.save(creative);       
	       }catch(Exception e){
	    	   vo.setMessage(e.getMessage());
			   vo.setResultCode(Constant.RESULT_FAIL);
	       }
	       //"redirect:index?campaignId=" + creative.getCampaign().getId() ;
	       return vo;
	    }
	    @RequestMapping("/checkName")
	    public @ResponseBody boolean checkName(@RequestParam(value = "id", required = false) Integer id,
	            @RequestParam("campaignId") Integer campaignId, @RequestParam("name") String name) {
	        return !creativeService.checkName(id,campaignId, StringUtil.trimSRN(name));
	    }
	    
	    @RequestMapping("/list")
	    public @ResponseBody Page<Creative> list(@RequestParam Map<String,Object> p){
	    	if(null == p.get("campaignId")){
	    		return null;
	    	}
	    	
	    	int campaignId = Integer.parseInt(p.get("campaignId").toString());
	    	PageParam pageParam = new PageParam();
	    	Map<String,Object> m = new HashMap<String,Object>();
	    	m.put("campaignId", campaignId);
	    	pageParam.setUserData(m);
	    	//获取前台参数
	    	int currentPage = 1;
	    	int pageSize = Constant.PAGE_SIZE;
	    	try{
	    		currentPage = Integer.parseInt(p.get("pageNo").toString());
	    		pageSize = Integer.parseInt(p.get("pageSize").toString());
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		System.out.println("页面参数错误！！");
	    	}
	    	if(null != p.get("orderBy") && null != p.get("order")){
	    		String  orderBy = StringUtil.trimSRN(p.get("orderBy").toString());
	    		String  order = StringUtil.trimSRN(p.get("order").toString());
	    		if(StringUtil.isNotBlank(orderBy) && StringUtil.isNotBlank(order)){
	    			pageParam.setOrderName(orderBy);
	    			pageParam.setOrderValue(order);
	    		}
	    	}
	    	if(null != p.get("searchValue")){
	    		String searchValue = StringUtil.trimSRN(p.get("searchValue").toString());
	    		if(!StringUtil.isBlank(searchValue)&& !"".equals(searchValue)){
	            	pageParam.setSearchValue(searchValue);            	
	    		}
	    	}
	    	pageParam.setCurrentPage(currentPage);
	    	pageParam.setPageSize(pageSize);
	    	
	    	pageParam.setUserData(m);
			Page<Creative> page = this.creativeService.getPagedList(pageParam);

	    	return page;
	    	
	    }
	    @RequestMapping("/view")
	    public String view(Integer id, Model m) {
	        Creative cr = creativeService.findById(id);
	        m.addAttribute("inUse", cr.isInUse());
	        m.addAttribute("cr", cr);
	        Campaign campaign = this.campaignService.addCampaignStatus( cr.getCampaign());
	        m.addAttribute("campaign", campaign);
	        return "creative/view";
	    }
	    @RequestMapping("/delete")
	    public @ResponseBody
	    ResultVO delete( Integer id,Integer carbonId) {
	    	ResultVO  vo  = new ResultVO();
	    	try{
	    		vo =  creativeService.delete(id,carbonId);
	    	}catch(Exception e){
	    		vo.setMessage(e.getMessage());
	    		vo.setResultCode(Constant.RESULT_FAIL);
	    	}
	    	return vo;
	    }

	@RequestMapping("/index")
	public String index(Integer campaignId, Model model) {

		Campaign campaign = this.campaignService.getCampaignById(campaignId);
		model.addAttribute("campaign", campaign);
	

		return "creative/index";
	}
}
