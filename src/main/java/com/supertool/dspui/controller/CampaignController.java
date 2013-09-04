package com.supertool.dspui.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.model.Advertiser;
import com.supertool.dspui.model.Campaign;
import com.supertool.dspui.param.PageParam;
import com.supertool.dspui.param.form.CampaignForm;
import com.supertool.dspui.service.CampaignService;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.vo.CampaignRow;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.ResultVO;




@Controller
public class CampaignController {
    private static Logger logger = LoggerFactory.getLogger(CampaignController.class);
	 
    @Autowired
    private CampaignService campaignService;
    
   
    @RequestMapping("/campaign/list")
    public @ResponseBody Page<CampaignRow> getCampaignList(@RequestParam Map<String,Object> p){
    	PageParam pageParam = new PageParam();

    	//获取前台参数
    	int currentPage = 1;
    	int pageSize = Constant.PAGE_SIZE;
    	try{
    		currentPage = Integer.parseInt(p.get("pageNo").toString());
    		pageSize = Integer.parseInt(p.get("pageSize").toString());
    	}catch(Exception e){
    		logger.error("页面参数错误:"+e.getMessage());
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
    	if(null != p.get("rtbProgress") || null != p.get("materialStatus")){
    		Map<String,Object> others = new HashMap<String,Object>();
    		if(null != p.get("rtbProgress")){
    			others.put("rtbProgress",p.get("rtbProgress"));   			
    		}
    		if(null != p.get("materialStatus")){
    			others.put("materialStatus",p.get("materialStatus"));   			
    		}
    		pageParam.setUserData(others);
    	}
    	pageParam.setCurrentPage(currentPage);
    	pageParam.setPageSize(pageSize);

    	return this.campaignService.getPageData(pageParam);
    }
    @RequestMapping("/campaign/edit")
    public String editCampaign(int id,int statu,Model m){
    	Campaign campaign = this.campaignService.getCampaignById(id);
    	if(null ==campaign){
    		m.addAttribute("resultCode", Constant.RESULT_FAIL);
    		m.addAttribute("message", "返回空结果！");
    	}else{
    		
    		m.addAttribute("resultCode", Constant.RESULT_SUCCESS);
    		m.addAttribute("campaign", campaign);
    		//Advertiser advertiser = this.campaignService.getAdvertiserById(campaign.getAdvertiserId());
    		Advertiser advertiser = this.campaignService.getAdvertiserIgnoreAllById(campaign.getAdvertiserId());
    		if(null == advertiser){
    			Advertiser ad =new Advertiser();
        		ad.setName("未找到");   		
        	}
    		m.addAttribute("advertiser",advertiser);
    	}
    	m.addAttribute("statu",statu);
    	return "/campaign/edit";
    }
    @RequestMapping("/campaign/save")
    public @ResponseBody ResultVO  addCampaign(@ModelAttribute CampaignForm campaignForm ){
    	
    	if(null == campaignForm){
    		return new ResultVO(0, "参数错误！");
    	}
    	//System.out.println("name="+campaignForm.getName());
    	//System.out.println("startTime="+campaignForm.getStartTime());
    	//System.out.println("endTime="+campaignForm.getEndTime());
    	//System.out.println("advertiserId="+campaignForm.getAdvertiserId());
    	//System.out.println("brand="+campaignForm.getBrand());
    	//System.out.println("landingPage="+campaignForm.getLandingPage());
    	//System.out.println("maxPrice="+campaignForm.getMaxPrice());
    	ResultVO vo = new ResultVO();
    	try{
    		vo = this.campaignService.save(campaignForm);
    	}catch(Exception e){
    		vo.setResultCode(Constant.RESULT_FAIL);
    		vo.setMessage(e.getMessage());
    	}
    	return vo;
 
    }
    @RequestMapping("/campaign/create")
    public String  toCreatePage(Model model){
    	int dspId = UserContext.getDspId();
    	model.addAttribute("dspId", dspId);
		return "/campaign/create";
    	
    }
    @RequestMapping("/campaign/update")
    public @ResponseBody ResultVO updateCampaign(@ModelAttribute CampaignForm campaignForm)
    {
    	ResultVO resultVO = new ResultVO();
    	if(null == campaignForm){
    		return new ResultVO(0, "参数错误！");
    	}
    	//System.out.println("name="+campaignForm.getName());
    	//System.out.println("startTime="+campaignForm.getStartTime());
    	//System.out.println("endTime="+campaignForm.getEndTime());
    	//System.out.println("carbonId="+campaignForm.getCarbonId());
    	//System.out.println("advertiserId="+campaignForm.getAdvertiserId());
    	//System.out.println("brand="+campaignForm.getBrand());
    	//System.out.println("landingPage="+campaignForm.getLandingPage());
    	//System.out.println("maxPrice="+campaignForm.getMaxPrice());
    	try{
    		resultVO =  this.campaignService.update(campaignForm);
    	}catch(Exception e){
    		resultVO.setResultCode(Constant.RESULT_FAIL);
    		resultVO.setMessage(e.getMessage());
    	}
    	return resultVO;
    }
    @RequestMapping("/campaign/view")
    public String  viewCampaign( int id,Model m){
    	Campaign campaign = this.campaignService.getCampaignById(id);
    	Advertiser advertiser = new Advertiser();
    	if(null != campaign){
    		advertiser = this.campaignService.getAdvertiserById(campaign.getAdvertiserId());
    	}
    	if(null != campaign){
    		m.addAttribute("campaign",campaign);
    	}
    	if(null != advertiser){
    		m.addAttribute("advertiser",advertiser);
    	}

    	
    	
    	return "/campaign/view";
    	
    }
    @RequestMapping("/campaign/checkname")
    public @ResponseBody boolean checkName(String name,Integer dspId){
    	return this.campaignService.chekName(StringUtil.trimSRN(name),dspId);
    	
    }
    @RequestMapping("/campaign/checkothername")
    public @ResponseBody boolean checkOtherName(String name,int carbonId,Integer dspId){
 
    	return this.campaignService.checkOtherName(StringUtil.trimSRN(name),carbonId,dspId);
    	
    }
    @RequestMapping("/campaign/delete")
    public @ResponseBody ResultVO deletedCampaign(int carbonId,int id ){
    	ResultVO vo = new ResultVO();
    	try{
    		vo = this.campaignService.removeCampaign(id,carbonId);
    	}catch(Exception e){
    		vo.setMessage(e.getMessage());
    		vo.setResultCode(Constant.RESULT_FAIL);
    	}
    	return vo;
    }
    @RequestMapping("/campaign/realchart") 
    public String  getCampaignRealChart(int carbonId,Model model){
    	
    	Map<String,Object> m = this.campaignService.getCampagnRealChart(carbonId);
    	model.addAttribute("result",m);
    	 
        return "campaign/report";
    }
    
 
    @RequestMapping("/campaign/report") 
    public @ResponseBody Map<String,Object>  getCampaignRealChart(int carbonId){
    	
    	Map<String,Object> m = this.campaignService.getCampagnRealChart(carbonId);

    	return m;
    }
    @RequestMapping("/campaign/rtbmaxendtime")
    public @ResponseBody String getRtbMaxEndtime(Integer id){
    	String endTime  = this.campaignService.getRtbMaxEndtime(id);
    	
    	return endTime;
    }
}
