package com.supertool.dspui.dao.mybatis;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.supertool.dspui.model.Advertiser;
import com.supertool.dspui.model.Campaign;
import com.supertool.dspui.param.SelectSQLParam;
import com.supertool.dspui.vo.CampaignRow;

public interface CampaignMapper {
	

	/**
	 * 根据dsp id,广告活动id,查询广告活动记录数
	 * @param Map<String,Object>m：
	 * 	 dspId ,Integer ,可为null
	 *   ids 广告活动id,List<Integer>,可为null
	 * @return
	 */
	public int getCampaignsCount(SelectSQLParam param) ;
	/**
	 * 插入广告活动 ,一次1000条，分段插入
	 * @param campaigns，广告活动列表，List<Campaign>
	 */
	//public void batchInsert(List<Campaign> campaigns);
	/**
	 * 更新广告活动
	 * @param campaigns，广告活动列表，List<Campaign>
	 */
	//public void batchUpdate(List<Campaign> campaigns);
	
	/**
	 * 删除广告活动
	 * @param Map<String,Object>m:
	 *   ids 广告活动id,List<Integer>,可为null
	 */
	//public void batchDelete(Map<String,Object>m);
	

	/**
	 * 插入广告活动
	 * @param Map: 
	 * 	  key:campaignParam
	 * @return
	 */
	public int insertCampaign(Map<String,Object>m);
	/**
	 *通过本地广告活动id 更新本地数据库的carbonId
	 * @param Map 
	 *    key:carbonId
	 *    key:campaignId
	 */
	public int updateCampaignCarbonId(Map<String,Object>m);
	/**
	 * 
	 * @param carbonId
	 * @return
	 */
	public Campaign getCampaignBycarbonId(int carbonId);
	/**
	 * 通过广告活动id查询广告活动
	 * @param id
	 * @return
	 */
	public Campaign getCampaignById(int id);
	/**
	 * 更新广告活动
	 * @param Map<String,Object>m:
	 *    key:campaign
	 * @return
	 */
	public int updateCampaign(Map<String,Object>m);
	/**
	 * 返回广告主信息
	 * @param advertiserId
	 * @return
	 */
	public Advertiser getAdvertiserById(Integer advertiserId);
	
	/**
	 * 根据CarbonId删除广告活动记录
	 * @param carbonId
	 * @return
	 */
	public int deleteCampaignByCarbonId(int carbonId);
	/**
	 * 新建时检查是否重名
	 * @param name
	 * @return
	 */
	public Campaign checkName(Map<String,Object>m);
	/**
	 * 更新时检查是否重名
	 * @param Map
	 *  String name, int carbonId
	 * @return
	 */
	public Campaign checkOtherName(Map<String,Object>m);
	/**
	 * 获取一批rtb交易进度未开始的rtb的id
	 * ①未开始:就是开始时间大于当前时间
	 */
	public List<Integer> getRtbProgressNoStarted(List<Integer> carbonIds);
	/**
	 * 获取一批rtb交易进度已结束的rtb的id
	 * 如果当前时间超过了结束时间，就是已结束
	 */
	public List<Integer> getRtbProgressFinished(List<Integer> carbonIds);
	/**
	 * 获取一批rtb交易进度暂停的rtb的id
	 * ②当前时间在开始时间和结束时间之间时：
        	* 
        	*  且active字段为false
        * ）
	 */
	public List<Integer> getRtbProgressPause(List<Integer> carbonIds);
	/**
	 * 获取一批rtb交易进度可能为
	 * 进行中或者有预算的rtb的id
	 * ②当前时间在开始时间和结束时间之间时：
     *  且active字段为1
	 */
	public List<Integer> getRtbProgressOverRun(List<Integer> carbonIds);
	/**
	 * 获取一个广告活动对应的所有rtb的id
	 */
	public List<Integer> getRtbsByCampaignId(int carbonId);
	
	public List<String> getPagedBrands(SelectSQLParam param);
	
	
	
	/**
	 * 从集合中获取dsp审核中的物料id集合
	 * @param carbonIds
	 * @return List<Integer>
	 */ 
	public List<Integer> getMaterialChecking(List<Integer> carbonIds);
	
	/**
	 * 从集合中获取dsp审核拒绝的物料id集合
	 * @param carbonIds
	 * @return List<Integer>
	 */
	public List<Integer> getMaterialReject(List<Integer> carbonIds);
	/**
	 * 从集合中获取dsp审核通过的物料id集合
	 * @param carbonIds
	 * @return List<Integer>
	 */
	public List<Integer> getMaterialPassed(List<Integer> carbonIds);
	
	/**
	 * 
	 * @param carbonIds
	 * @return
	 */

	public List<CampaignRow> getPagedRows(SelectSQLParam param);
	
	
    public String getAdvertiserNameById(int Id);
	
    public List<Integer> getRtbIdsByCampaignId(int id);
    
    public List<Integer> getMaterialIdsByCampaignId(int id);
    
    public int getRtbNotStarted(int id);
    
    public int getRtbFinished(int id);
    
    public int getRtbPause(int id);
	
   
    
    public int getDspRejected(int carbonId);
    
    public int getDspChecking(int carbonId);
	
    public List<Integer> getCampaignIdsByRtbNotStarted();
   
    public List<Integer> getCampaignIdsByRtbFinished();
    
    public List<Integer> getCampaignIdsByRtbPause();
    
/*    public List<Integer> getCampaignIdsByDspRejected();
    
    public List<Integer> getCampaignIdsByDspChecking();*/
    
    public List<Integer> getCampaignIdsNoRelatedMaterial();
    
    public List<Integer> getCampaignIdsNoRtb();
    /**
     * 根据rtb id 集合获取对应的广告活动id集合
     * @param rtbIds
     * @return
     */
    public List<Integer> getCampaignIdsByRtbIds(List<Integer>rtbIds);
    /**
     * 根据materialIds获取对应广告活动的id集合
     * @param materialIds
     * @return
     */
    public List<Integer> getCampaignIdsByMaterialIds(List<Integer>materialIds);
	public int deleteCampaignById(int id);
	
	/**
	 * 是否可修改广告活动：已结束的不可修改
	 */
	public boolean  getEditable(int id);
	
	/**
	 * 是否可删除广告活动:未开始的可以删除
	 */
	public boolean getDeletable(int id);
	
	/**
	 * 获取某个广告活动对应的rtb
	 */
	public List<Integer> getRtbsBycampaignId(int campaignId);

	public Date getRtbMaxEndtime(Integer id);

	public Advertiser getAdvertiserIgnoreAllById(Integer advertiserId);

	public List<Integer> getCampaignIdsByRtbStarted(List<Integer> campaignIds2);

	public List<Integer> getCreativeIdsByCampaignId(int id);

	public List<Integer> getAlgorithmIdsByCampaignId(int id);

}
