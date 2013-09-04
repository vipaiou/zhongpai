package com.supertool.dspui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.hibernate.loader.custom.Return;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.model.Advertiser;
import com.supertool.dspui.param.PageParam;
import com.supertool.dspui.param.SelectSQLParam;
import com.supertool.dspui.service.AdvertiserService;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.PagedResultVO;
import com.supertool.dspui.vo.ResultVO;

@Controller
public class AdvertiserController {

	@Autowired
	private AdvertiserService  advertiserService;
	
	@RequestMapping("/advertiser/selectadvertiser")
	public @ResponseBody List<Advertiser> getAllAdveryisers(){
		SelectSQLParam param = new SelectSQLParam(); 
		param.setDspId(UserContext.getDspId());
		param.setOrderName("name");
		param.setOrderValue("asc");
		return this.advertiserService.getPagedAdvertisers(param);
	}
	
	@RequestMapping(value={"/advertiser/index","/advertiser/","/advertiser"})
	public String index(){
		return "/advertiser/index";
	}
	
	@RequestMapping(value={"/advertiser/list"})
	public @ResponseBody Page<Advertiser> list(@RequestParam Map<String, String> map){
		PageParam pageParam = new PageParam();

    	//获取前台参数
    	int currentPage = 1;
    	try{
    		currentPage = Integer.parseInt(map.get("pageNo").toString());
    	}catch(Exception e){
    		e.printStackTrace();
    		System.out.println("页面参数错误！！");
    	}
    	if(null != map.get("orderBy") && null != map.get("order")){
    		String  orderBy = map.get("orderBy").toString().trim();
    		String  order = map.get("order").toString().trim();
    		if(StringUtil.isNotBlank(orderBy) && StringUtil.isNotBlank(order)){
    			pageParam.setOrderName(orderBy);
    			pageParam.setOrderValue(order);
    		}
    	}
    	if(null != map.get("searchValue")){
    		String searchValue = StringUtil.trimSRN(map.get("searchValue").toString());
    		if(!StringUtil.isBlank(searchValue)&& !"".equals(searchValue)){
            	pageParam.setSearchValue(searchValue);            	
    		}
    	}
    	pageParam.setCurrentPage(currentPage);
    	Integer pageSize = Integer.parseInt(map.get("pageSize").toString().trim());
    	pageParam.setPageSize(pageSize);
		 
    	Page<Advertiser> pagedResultVO = this.advertiserService.getPagedAdvertiserList(pageParam);
		
		return pagedResultVO;
	}

	@RequestMapping(value={"/advertiser/view"})
	public String view(@RequestParam("id") Integer id, Model model){
		Advertiser advertiser = advertiserService.view(id);
		model.addAttribute(advertiser);
		return "/advertiser/view";
	}
	
	@RequestMapping(value={"/advertiser/edit"})
	public String edit(@RequestParam("id") Integer id, Model model){
		Advertiser advertiser = advertiserService.view(id);
		model.addAttribute(advertiser);
		return "/advertiser/edit";
	}

	@RequestMapping(value={"/advertiser/docreate"})
	public @ResponseBody ResultVO create(@ModelAttribute("advertiser") Advertiser advsetiser, @RequestParam Map<String, String> map){
		System.out.println(AopUtils.isAopProxy(advertiserService));
		System.out.println(AopUtils.isCglibProxy(advertiserService));
		System.out.println(AopUtils.isJdkDynamicProxy(advertiserService));
		return advertiserService.create(advsetiser);
	}

	@RequestMapping(value={"/advertiser/doedit"})
	public @ResponseBody ResultVO edit(@ModelAttribute("advertiser") Advertiser advsetiser, @RequestParam Map<String, String> map){
		return advertiserService.edit(advsetiser);
	}

	@RequestMapping(value={"/advertiser/check"})
	public @ResponseBody boolean check(@ModelAttribute("advertiser") Advertiser advsetiser, @RequestParam Map<String, String> map){
		return advertiserService.check(advsetiser);
	}
	@RequestMapping(value={"/advertiser/delete"})
	public @ResponseBody ResultVO delete(Integer id, Integer carbonId){
		ResultVO vo = new ResultVO();
		try{
			vo = advertiserService.delete(id,carbonId);
		}catch(Exception e){
			vo.setResultCode(Constant.RESULT_FAIL);
			vo.setMessage(e.getMessage());
		}
		return vo;
	}
}
