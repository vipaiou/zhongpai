package com.supertool.dspui.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supertool.dspui.dao.mybatis.RegionMapper;
import com.supertool.dspui.model.Region;
import com.supertool.dspui.util.tree.Trees;
import com.supertool.dspui.util.tree.Trees.TreeNode;

@Service
public class RegionService {

	@Autowired
	private RegionMapper regionMapper;

	public List<TreeNode> listTree() {
		List<Region> regions = regionMapper.getAllRegions();
		return Trees.buildTree(regions);
	}

	public List<Region> getByIds(List<Integer> ids) {
		return regionMapper.getByIds(ids);
	}

	public Region getById(Integer id) {
		return regionMapper.getById(id);
	}

	public String toInfoString(List<Region> regions) {
		List<String> strs = new ArrayList<String>();
		Map<String, List<String>> parentMap = new HashMap<String, List<String>>();
		for (Region r : regions) {
			if (r.getParentId().equals(-1)) {
				strs.add(r.getName() + "：全部");
			} else {
				Region p = getById(r.getParentId());
				List<String> subRegion = parentMap.get(p.getName());
				if (subRegion != null) {
					subRegion.add(r.getName());
				} else {
					subRegion = new ArrayList<String>();
					subRegion.add(r.getName());
				}
				parentMap.put(p.getName(), subRegion);
			}
		}
		for (String rname : parentMap.keySet()) {
			strs.add(rname + "：" + join(parentMap.get(rname), "，"));
		}
		Collections.sort(strs);
		return join(strs, "；");
	}

	private String join(List<String> strs, String separator) {
		String joinedStr = "";
		for (String str : strs) {
			joinedStr += str + separator;
		}
		joinedStr = joinedStr.substring(0, joinedStr.length() - 1);
		return joinedStr;
	}

	public boolean isSelectAll(List<Region> regionList) {
		if (null == regionList) {
			return false;
		}
		Integer count = regionMapper.getFirstLevelCount();
		if (!count.equals(regionList.size())) {
			return false;
		}
		for (Region region : regionList) {
			if (!region.getParentId().equals(-1)) {
				return false;
			}
		}
		return true;
	}

	public String getDicIdStr(String idsStr) {
		String dicIdStr = "";
		if (null == idsStr || "".equals(idsStr)) {
			return dicIdStr;
		}
		String[] ids = idsStr.split(",");
		List<Integer> idList = new ArrayList<Integer>();
		for (String id : ids) {
			idList.add(Integer.parseInt(id));
		}
		List<Region> regionList = regionMapper.getByIds(idList);
		for (Region region : regionList) {
			dicIdStr += Integer.parseInt(region.getDicId()) + ",";
		}
		dicIdStr = dicIdStr.substring(0, dicIdStr.length() - 1);
		return dicIdStr;
	}
}
