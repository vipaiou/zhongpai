package com.supertool.dspui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.exception.CarbonBadResponseException;
import com.supertool.dspui.model.Datasource;
import com.supertool.dspui.param.form.DatasourceForm;
import com.supertool.dspui.param.form.DatasourcePageForm;
import com.supertool.dspui.service.DatasourceService;
import com.supertool.dspui.vo.Page;

@Controller
public class DatasourceController {

	@Autowired
	private DatasourceService datasourceService;

	@RequestMapping("/datasource/list")
	public @ResponseBody
	Page<Datasource> list(DatasourcePageForm form) {
		Page<Datasource> page = datasourceService.list(form);
		return page;
	}

	@RequestMapping("datasource/index")
	public String index() {
		return "datasource/index";
	}

	@RequestMapping("/datasource/save")
	public String save(DatasourceForm form, Model model) {
		Integer id = 0;
		try {
			id = datasourceService.add(form);
		} catch (CarbonBadResponseException e) {
			model.addAttribute("message", e.getMessage());
			return "forward:create";
		} catch (Exception e) {
			model.addAttribute("message", "操作失败");
			return "forward:create";
		}
		return "redirect:view?id=" + id;
	}

	@RequestMapping("/datasource/delete")
	public @ResponseBody
	boolean delete(Integer id) {
		try {
			datasourceService.delete(id);
		} catch (CarbonBadResponseException e) {
			return false;
		}
		return true;
	}

	@RequestMapping("/datasource/checkName")
	public @ResponseBody
	boolean checkName(String name, String oldName) {
		if (name.trim().equals(oldName)) {
			return true;
		}
		return datasourceService.checkName(name.trim());
	}

	@RequestMapping("datasource/edit")
	public String edit(Integer id, Model model) {
		Datasource datasource = datasourceService.getById(id);
		model.addAttribute("d", datasource);
		return "datasource/edit";
	}

	@RequestMapping("/datasource/update")
	public String update(DatasourceForm form, Model model) {
		try {
			datasourceService.update(form);
		} catch (CarbonBadResponseException e) {
			model.addAttribute("message", e.getMessage());
			model.addAttribute("id", form.getId());
			return "forward:edit";
		} catch (Exception e) {
			model.addAttribute("message", "操作失败");
			model.addAttribute("id", form.getId());
			return "forward:edit";
		}
		return "redirect:view?id=" + form.getId();
	}

	@RequestMapping("datasource/view")
	public String view(Integer id, Model model) {
		Datasource datasource = datasourceService.getById(id);
		model.addAttribute("d", datasource);
		return "datasource/view";
	}

	@RequestMapping("datasource/create")
	public String create() {
		return "datasource/create";
	}
}
