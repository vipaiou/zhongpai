package com.supertool.dspui.dao.mybatis;

import java.util.List;

import com.supertool.dspui.model.Region;

public interface RegionMapper {

	public List<Region> getAllRegions();

	public Region getById(Integer id);

	public List<Region> getByIds(List<Integer> ids);

	public Integer getFirstLevelCount();

}
