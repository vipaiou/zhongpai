package com.supertool.dspui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supertool.dspui.service.RegionService;
import com.supertool.dspui.util.tree.Trees.TreeNode;

@Controller
public class RegionController {

	@Autowired
	private RegionService regionService;

	@RequestMapping("/region/list")
	public @ResponseBody
	List<TreeNode> list() {
		return regionService.listTree();
	}
}
