package com.supertool.dspui.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.supertool.dspui.model.Rtb;

public interface RtbMapper {

	/**
	 * 根据广告活动id,创意id,rtb id获取对应rtb表 记录
	 * Map<String,Object>m:
	 * 		dspId ,Integer 可为null
	 * 		campaignIds,List<Integer> 可为null
	 * 		creativeIds,List<Integer> 可为null
	 * 		rtbIds,List<Integer> 不能为null
	 * 		startRow ,integer
	 *  	limitRows,integer
	 *   	orderName 排序列
	 *  	orderValue 排序方式 ，升降序
	 * @return
	 */
	public List<Rtb> getPagedRtbsByIds(Map<String,Object> m);
	/**
	 * 根据广告活动id,创意id,rtb id获取对应rtb表 记录
	 * Map<String,Object>m:
	 * 		dspId ,Integer
	 * 		campaignIds,List<Integer> 
	 * 		creativeIds,List<Integer> 
	 * 		rtbIds,List<Integer> 
	 * @return
	 */
	public int getRtbsCount(Map<String,Object> m);
	/**
	 * 更新rtb 
	 * @param rtbs List<Rtb>
	 */
	public void batchUpdate(List<Rtb>rtbs);
	/**
	 * 批量插入rtb
	 * @param rtbs List<Rtb>
	 */
	public void batchInsert(List<Rtb>rtbs);
	/**
	 * 根据广告活动id,创意id,rtb id删除对应rtb表 记录
	 * Map<String,Object>m:
	 * 		campaignIds,List<Integer> 可为null
	 * 		creativeIds,List<Integer> 可为null
	 * 		rtbIds,List<Integer> 可为null
	 * 
	 */
	public void batchDelete(Map<String,Object> m);
	
	public void add(Rtb rtb);
	
	public void deleteByRtbId(Integer rtbId);
	
	public Rtb getById(Integer id);
	
	public void update(Rtb rtb);
	
	public Rtb checkName(Map<String, Object> map);
	
	public void updateActive(Map<String, Object> map);
	
	public List<Rtb> getByAlgorithmId(int id);
	
	public Integer getCountByAlgorithmId(int algorithmId);
}
