package com.supertool.dspui.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.supertool.dspui.model.Algorithm;
import com.supertool.dspui.param.SelectSQLParam;
import com.supertool.dspui.vo.AlgorithmVO;

public interface AlgorithmMapper {

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

	public List<Algorithm> getPagedAlgorithmList(@Param("ssp")SelectSQLParam m, @Param("dspId")Integer dspId, @Param("campaignId")Integer campaignId);

	public int create(Algorithm algorithm);

	public Algorithm getAlgorithmById(Integer id);

	public List<Algorithm> checkByNameAndId(@Param("name")String name, @Param("id")Integer id, @Param("dspId")Integer dspId, @Param("campaignId")Integer campaignId);
	
	public List<Algorithm> checkByName(@Param("name")String name, @Param("dspId")Integer dspId, @Param("campaignId")Integer campaignId);

	public int getTotalCount(@Param("ssp")SelectSQLParam m, @Param("dspId")Integer dspId, @Param("campaignId")Integer campaignId);

	public int edit(Algorithm algorithm);

	public int delete(Algorithm algorithm);
	
	public List<Algorithm> getByCampaignId(Integer campaignId);
	
	public int countBindAlgorithmRtb(int id);

	public int getTotalCountAll(@Param("ssp")SelectSQLParam m, @Param("dspId")Integer dspId);

	public List<AlgorithmVO> getPageAlgorithmVOList(@Param("ssp")SelectSQLParam m, @Param("dspId")Integer dspId);

	public void deleteAlgorithmsByIds(List<Integer> algorithmIds);

}
