package com.supertool.dspui.vo;

import java.io.Serializable;

public class CampaignChartVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 活动ID或者RTB计划ID。
	 */
	private int id;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * 总曝光
	 */
	private long pv;
	
	/*
	 * 每日曝光
	 */
	private long dailyPv;
	
	/*
	 * uv
	 */
	private long uv;
	
	/*
	 * 每日UV
	 */
	private long dailyUv;
	/*
	 * 总点击
	 */
	private long click;
	/*
	 * 每日点击
	 */
	private long dailyClick;
	/*
	 * 最高出价
	 */
	private double maxPrice;
	/*
	 * 最低出价
	 */
	private double minPrice;
	/*
	 * 平均出价
	 */
	private double avgPrice;
	
	/*
	 * 总花费
	 */
	private double totalCost;
	/*
	 * 每日花费
	 */
	private double dailyCost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPv() {
		return pv;
	}

	public void setPv(long pv) {
		this.pv = pv;
	}

	public long getDailyPv() {
		return dailyPv;
	}

	public void setDailyPv(long dailyPv) {
		this.dailyPv = dailyPv;
	}

	public long getUv() {
		return uv;
	}

	public void setUv(long uv) {
		this.uv = uv;
	}

	public long getDailyUv() {
		return dailyUv;
	}

	public void setDailyUv(long dailyUv) {
		this.dailyUv = dailyUv;
	}

	public long getClick() {
		return click;
	}

	public void setClick(long click) {
		this.click = click;
	}

	public long getDailyClick() {
		return dailyClick;
	}

	public void setDailyClick(long dailyClick) {
		this.dailyClick = dailyClick;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(double dailyCost) {
		this.dailyCost = dailyCost;
	}

	

	

	

	
}
