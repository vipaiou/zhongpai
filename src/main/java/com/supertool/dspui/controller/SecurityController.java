package com.supertool.dspui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.model.Authority;
import com.supertool.dspui.service.security.SecurityService;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.Utils;

@Controller
public class SecurityController {
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping("/security/authority*")
	public Map<String,Object> addAuthority(@RequestParam Map<String,Object>p){
		String userIdStr=p.get("userId")==null?null:p.get("userId").toString();
		int pageNo = 1;
		String pageStr = p.get("page") == null ? null : p.get("page")
				.toString();
		String searchColumn = p.get("searchColumn") == null ? null : p.get(
				"searchColumn").toString();
		String searchKey = p.get("searchKey") == null ? null : p.get(
				"searchKey").toString();
		String rowsStr = p.get("rows") == null ? null : p.get("rows")
				.toString();
		String sidx = p.get("sidx") == null ? null : p.get("sidx").toString();
		String sord = p.get("sord") == null ? null : p.get("sord").toString();
		// System.out.println("controller--->searchKey="+searchKey);
		if (pageStr != null && StringUtil.isNumber(pageStr)) {
			pageNo = Integer.parseInt(pageStr);
		} else {
			pageNo = 1;
		}
		int pageSize = Constant.PAGESIZE;
		if (rowsStr != null && StringUtil.isNumber(rowsStr)) {
			pageSize = Integer.parseInt(rowsStr);
		} 
		
		if (sidx == null || sidx.equals("")) {
			sidx = "authorityId";
			sord = "asc";
		}
		System.out.println("pageSize="+pageSize);
		System.out.println("userIdStr="+userIdStr);
		List<Authority> authorityList = this.securityService.getPageUserAuthoritys(pageNo,
				pageSize, sidx, sord, searchColumn, searchKey,  userIdStr);
		int totalCount = this.securityService.getUserTotalCount(searchColumn,
				searchKey, userIdStr);
		System.out.println("totalCount="+totalCount);
		System.out.println("authorityList="+(null!=authorityList?authorityList.size():0));
		Integer totalPage = Utils.getTotalPage(totalCount, pageSize);
		/*
		 * System.out.println("totalPage="+totalPage);
		 * System.out.println("pageSize="+pageSize);
		 */
		
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("authorityList", authorityList);
		json.put("totalPage", totalPage);
		json.put("currentPage", pageNo);
		json.put("totalCount", totalCount);

		return json;
	}
}
