package com.supertool.dspui.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.supertool.dspui.model.Advertiser;
import com.supertool.dspui.param.SelectSQLParam;

public interface AdvertiserMapper {

	/**
	 * 获取所有广告主/代理
	 * /**
	 * 根据广告主/代理id,查询广告主/代理集合
	 * @param Map<String,Object>m:
	 *   ids 广告主/代理在carbon中对应的id,List<Integer>,可为null
	 *   
	 *   startRow ,integer
	 *   limitRows,integer
	 *   orderName 排序列
	 *   orderValue 排序方式 ，升降序
	 *   
	 * @return List<Campaign>
	 */
	public List<Advertiser> getAllAdvertisers(SelectSQLParam m);

	public List<Advertiser> getPagedAdvertiserList(@Param("ssp")SelectSQLParam m, @Param("dspId")Integer dspId);

	public int create(Advertiser advertiser);

	public Advertiser getAdvertiserById(Integer id);
//传入多个参数时要加@Param注解
	public List<Advertiser> checkByNameAndId(@Param("name")String name, @Param("id")Integer id, @Param("dspId")Integer dspId);
	
	public List<Advertiser> checkByName(@Param("name")String name, @Param("dspId")Integer dspId);

	public int getTotalCount(@Param("ssp")SelectSQLParam m, @Param("dspId")Integer dspId);

	public int edit(Advertiser advertiser);

	public int updateCarbonId(Advertiser advertiser);

	public void deleteAdvertiserById(Integer id);
}
