package com.supertool.dspui.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.supertool.dspui.model.Datasource;

public interface DatasourceMapper {

	public List<Datasource> getPagedDatasources(Map<String, Object> params);

	public Integer getDatasourcesCount(Map<String, Object> params);

	public void add(Datasource datasource);

	public void deleteByCarbonId(Integer id);

	public Datasource getByName(String name);
	
	public Datasource getByCarbonId(Integer id);
	
	public void update(Datasource datasource);
	
	public Datasource getById(Integer id);
	
	public void deleteById(Integer id);
}
