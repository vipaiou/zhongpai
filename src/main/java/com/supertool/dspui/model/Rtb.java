package com.supertool.dspui.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @author zhouziqiang
 *
 */
public class Rtb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * RTB计划ID，主键，自增
	 */
	private int id;
	/*
	 * carbon里对应表主键
	 */
	private int carbonId;
	/*
	 * dsp id
	 */
	private int dspId;
	/*
	 * RTB名称
	 */
	private String name;
	/*
	 * 从属的广告活动ID
	 */
	private int campaignId;
	/*
	 * 创意id
	 */
	private int creativeId;
	/*
	 * 开始日期, 格式为：YYYY-MM-DD
	 */
	private Date startTime;
	/*
	 * 结束日期, 格式为：YYYY-MM-DD
	 */
	private Date endTime;
	/*
	 * 激活状态：0=暂停，1=激活
	 */
	private Byte active;
	/*
	 * 超预算：0=未超预算，1=总预算超预算，2=每日预算超预算，3=每日pv超预算
	 */
	private Byte overBudget;
	/*
	 * 总预算，如果未设为0.00
	 */
	private BigDecimal  budget;
	/*
	 * 每天预算限制，如果未设为0.00
	 */
	private BigDecimal  dailyBudget;
	/*
	 * 每天PV限制，如果未设为0
	 */
	private Long dailyPv;
	/*
	 * 默认价格，如果未设为0.00
	 */
	private BigDecimal  defaultPrice;
	
	/*
	 * 小时定向，取值0-23，多个小时之间用逗号分隔
	 */
	private String filterHour;
	/*
	 * 星期定向，取值0-6，多个星期之间用逗号分隔
	 */
	private String filterWeekDay;
	/*
	 * 地域定向，多个地域ID之间用逗号分隔
	 */
	private String filterGeo;
	
	/*
	 * 频次定向，共5个维度all, week, day, hour, min。
	 * 例如0,1,0,1,1表示all=0,week=1,day=0,hour=1,min=1
	 */
	private String filterFrequency;
	/*
	 * 竞价算法ID
	 */
	private Integer algorithmId;
	/*
	 * 新建时间
	 */
	private Date createTime;
	/*
	 * 更新时间
	 */
	private Date updateTime;
	/*
	 * 删除时间
	 */
	private Date deleteTime;
	/*
	 * 是否删除
	 */
	private Byte isDeleted;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDspId() {
		return dspId;
	}
	public void setDspId(int dspId) {
		this.dspId = dspId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public int getCreativeId() {
		return creativeId;
	}
	public void setCreativeId(int creativeId) {
		this.creativeId = creativeId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Byte getActive() {
		return active;
	}
	public void setActive(Byte active) {
		this.active = active;
	}
	public Byte getOverBudget() {
		return overBudget;
	}
	public void setOverBudget(Byte overBudget) {
		this.overBudget = overBudget;
	}
	public BigDecimal getBudget() {
		return budget;
	}
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	public BigDecimal getDailyBudget() {
		return dailyBudget;
	}
	public void setDailyBudget(BigDecimal dailyBudget) {
		this.dailyBudget = dailyBudget;
	}
	public Long getDailyPv() {
		return dailyPv;
	}
	public void setDailyPv(Long dailyPv) {
		this.dailyPv = dailyPv;
	}
	public BigDecimal getDefaultPrice() {
		return defaultPrice;
	}
	public void setDefaultPrice(BigDecimal defaultPrice) {
		this.defaultPrice = defaultPrice;
	}
	
	public String getFilterHour() {
		return filterHour;
	}
	public void setFilterHour(String filterHour) {
		this.filterHour = filterHour;
	}
	public String getFilterWeekDay() {
		return filterWeekDay;
	}
	public void setFilterWeekDay(String filterWeekDay) {
		this.filterWeekDay = filterWeekDay;
	}
	public String getFilterGeo() {
		return filterGeo;
	}
	public void setFilterGeo(String filterGeo) {
		this.filterGeo = filterGeo;
	}
	public String getFilterFrequency() {
		return filterFrequency;
	}
	public void setFilterFrequency(String filterFrequency) {
		this.filterFrequency = filterFrequency;
	}
	public Integer getAlgorithmId() {
		return algorithmId;
	}
	public void setAlgorithmId(Integer algorithmId) {
		this.algorithmId = algorithmId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getCarbonId() {
		return carbonId;
	}
	public void setCarbonId(int carbonId) {
		this.carbonId = carbonId;
	}
	
	
	
	
	
}
