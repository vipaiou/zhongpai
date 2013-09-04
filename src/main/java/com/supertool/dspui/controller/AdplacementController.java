package com.supertool.dspui.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.service.AdplacementService;
import com.supertool.dspui.util.Utils;
import com.supertool.dspui.vo.AdplacementVO;
import com.supertool.dspui.vo.Page;


@RequestMapping("/media")
@Controller
public class AdplacementController {
	
	@Resource
	private AdplacementService adplacementService;
	
	@RequestMapping("/index")
	public String index() throws Exception {

		return "media/index";
	}
	
	@RequestMapping("/list")
	public @ResponseBody Page<AdplacementVO> list(String type,String nameorid,int pageNo,int pageSize) {
		
		Page<AdplacementVO> page = new Page<AdplacementVO>();
		List<AdplacementVO> datas;
		int total;
		int param[] = {pageNo,pageSize};
		if(type != null && !"".equals(type) && nameorid != null && !"".equals(nameorid)) {
			total = adplacementService.listAdplacementByAll(type.trim(), nameorid.trim(), null).size();
			datas = adplacementService.listAdplacementByAll(type.trim(), nameorid.trim(), param);
		} else if(type != null && !"".equals(type)) {
			total = adplacementService.listAdplacementByType(type.trim(), null).size();
			datas = adplacementService.listAdplacementByType(type.trim(), param);
		} else if(nameorid != null && !"".equals(nameorid)) {
			total = adplacementService.listAdplacementByNameOrId(nameorid.trim(), param).size();
			datas = adplacementService.listAdplacementByNameOrId(nameorid.trim(), param);
		} else {
			total = adplacementService.listAdplacement(null).size();
			datas = adplacementService.listAdplacement(param);
		}
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setTotalRecords(total);
		page.setRows(datas);
		page.setTotalPages(Utils.getTotalPage(total, pageSize));
		return page;
	}
	
}
