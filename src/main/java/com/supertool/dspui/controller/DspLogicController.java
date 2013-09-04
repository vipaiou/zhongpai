package com.supertool.dspui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.model.DspLogic;
import com.supertool.dspui.param.form.DspLogicForm;
import com.supertool.dspui.service.DspLogicService;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.ResultVO;

@Controller
@RequestMapping("/dsplogic")
public class DspLogicController {

	@Autowired
	private DspLogicService dspLogicService;
	
	@RequestMapping("/index")
	public String index() {
		return "dspLogic/index";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public Page<DspLogic> list(String searchStr,int pageNo,int pageSize) {
		
		Page<DspLogic> page = new Page<DspLogic>();
		int total;
		List<DspLogic> data;
		int param[] = {(pageNo-1)*pageSize,pageSize};
		if(searchStr == null || "".equals(searchStr)) {
			data = dspLogicService.listDspLogic(param);
			total = dspLogicService.listDspLogic(new int[]{0,0}).size();
		} else {
			String nameorid = searchStr.trim();
			data = dspLogicService.listDspLogicByNameorid(nameorid,param);
			total = dspLogicService.listDspLogicByNameorid(nameorid,new int[]{0,0}).size();
		}
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setRows(data);
		page.setTotalPages(total/pageSize+1);
		page.setTotalRecords(total);
		return page;
	}
	
	@RequestMapping("/save")
	public String save(DspLogicForm dspLogicForm,Model model) {
		String result = dspLogicService.addDspLogic(dspLogicForm);
		if(result != null) {
			model.addAttribute("operate", "添加dsp");
			model.addAttribute("name", result);
		}
		return "dspLogic/index";
	}
	

	
	@RequestMapping("/update")
	public String update(DspLogicForm dspLogicForm,Model model) {
		String result = dspLogicService.updateDspLogic(dspLogicForm);
		if(result != null) {
			model.addAttribute("operate", "更新dsp");
			model.addAttribute("name", result);
		}
		return "dspLogic/index";
	}
	
	@RequestMapping("/create")
	public String create() {
		return "dspLogic/create";
	}
	

}
