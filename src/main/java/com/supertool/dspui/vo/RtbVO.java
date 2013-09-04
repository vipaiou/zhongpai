package com.supertool.dspui.vo;

import java.util.List;

import com.supertool.dspui.model.Adplacement;





public class RtbVO {

	/*
	 * RTB计划ID
	 */
	private int id;
	/*
	 * 从属的广告活动ID
	 */
	private int campaignId;
	/*
	 * RTB计划名称
	 */
	private String name;
	
	/*
	 * 开始日期, 格式为：YYYY-MM-DD
	 */
	private String start;
	/*
	 * 结束日期, 格式为：YYYY-MM-DD
	 */
	private String end;
	/*
	 * 总预算，如果未设为0.00
	 */
	private double totalBudget;
	/*
	 * 每天预算限制，如果未设为0.00
	 */
	private double dailyBudget;
	/*
	 * 每天PV限制，如果未设为0
	 */
	private int dailyPv;
	/*
	 * 默认价格，如果未设为0.00
	 */
	private double defaultPrice;
	/*
	 * 最大价格，如果未设为0.00
	 */
	private double maxPrice;
	/*
	 * RTB计划状态：0表示过期；1表示未开始；2:表示进行中; 3表示暂停; 4:表示总预算已满；5表示每日预算已满；6表示每日PV已满
	 */
	private int status;
	/*
	 * 竞价过滤规则对象
	 */
	private RtbFilter filters;
	/*
	 * 竞价过滤规则对象
	 */
	private String script;
	/*
	 * 广告位信息数组
	 */
	private List<Adplacement> adPlacemnets;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public double getTotalBudget() {
		return totalBudget;
	}
	public void setTotalBudget(double totalBudget) {
		this.totalBudget = totalBudget;
	}
	public double getDailyBudget() {
		return dailyBudget;
	}
	public void setDailyBudget(double dailyBudget) {
		this.dailyBudget = dailyBudget;
	}
	public int getDailyPv() {
		return dailyPv;
	}
	public void setDailyPv(int dailyPv) {
		this.dailyPv = dailyPv;
	}
	public double getDefaultPrice() {
		return defaultPrice;
	}
	public void setDefaultPrice(double defaultPrice) {
		this.defaultPrice = defaultPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public RtbFilter getFilters() {
		return filters;
	}
	public void setFilters(RtbFilter filters) {
		this.filters = filters;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public List<Adplacement> getAdPlacemnets() {
		return adPlacemnets;
	}
	public void setAdPlacemnets(List<Adplacement> adPlacemnets) {
		this.adPlacemnets = adPlacemnets;
	}

	
	
	
}
