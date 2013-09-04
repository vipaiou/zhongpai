package com.supertool.dspui.vo;

public class RtbResultVO {

	private int id;
	private int carbonId;
	private String name;
	private String startTime;
	private String endTime;
	private int progress;
	private String materialStatus;
	private long pv;
	private long click;
	private double ctr;
	private long dailyPv;
	private long dailyClick;
	private double dailyCtr;
	private double dailyCost;
	private double avgPrice;
	private double maxPrice;
	private double minPrice;
	private double totalCost;
	private boolean editable;
	private boolean deletable;

	public RtbResultVO() {
		super();
		this.pv = 0;
		this.click = 0;
		this.ctr = 0;
		this.dailyPv = 0;
		this.dailyClick = 0;
		this.dailyCtr = 0;
		this.dailyCost = 0;
		this.avgPrice = 0;
		this.maxPrice = 0;
		this.minPrice = 0;
		this.totalCost = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarbonId() {
		return carbonId;
	}

	public void setCarbonId(int carbonId) {
		this.carbonId = carbonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public String getMaterialStatus() {
		return materialStatus;
	}

	public void setMaterialStatus(String materialStatus) {
		this.materialStatus = materialStatus;
	}

	public long getPv() {
		return pv;
	}

	public void setPv(long pv) {
		this.pv = pv;
	}

	public long getClick() {
		return click;
	}

	public void setClick(long click) {
		this.click = click;
	}

	public double getCtr() {
		return ctr;
	}

	public void setCtr(double ctr) {
		this.ctr = ctr;
	}

	public long getDailyPv() {
		return dailyPv;
	}

	public void setDailyPv(long dailyPv) {
		this.dailyPv = dailyPv;
	}

	public long getDailyClick() {
		return dailyClick;
	}

	public void setDailyClick(long dailyClick) {
		this.dailyClick = dailyClick;
	}

	public double getDailyCtr() {
		return dailyCtr;
	}

	public void setDailyCtr(double dailyCtr) {
		this.dailyCtr = dailyCtr;
	}

	public double getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(double dailyCost) {
		this.dailyCost = dailyCost;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
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

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isDeletable() {
		return deletable;
	}

	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}

}
