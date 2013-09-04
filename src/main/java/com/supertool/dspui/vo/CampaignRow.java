package com.supertool.dspui.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CampaignRow implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 广告活动id
	 */
	private Integer id;
	
	/*
	 *carbonId 
	 */
	private Integer carbonId;
	/*
	 * dspid
	 */
	private Integer dspId;
	
	
	/*
	 * 广告活动名称
	 */
	private String campaignName;
	
	/*
	 * 广告主id
	 */
	private Integer advertiserId;
	/*
	 * 广告主名称
	 */
	private String advertiserName;
	
	
	/*
	 * 品牌名称
	 */
	private String brand;
	
	/*
	 * RTB交易进度 
	 */
	private String rtbProgress;
	
	/*
	 * RTB物料状态　　
	 */
	private String rtbMaterialStatus;
	
	private String landingPage;
	/*
	 * 广告活动开始时间
	 */
	private String startTime;
	/*
	 * 广告活动结束时间
	 */
	private String endTime;
	
	/*最高出价
	 * 
	 */
	private BigDecimal maxPrice;
	
	
	/*
	 * 总曝光
	 */
	private long pv;
	
	/*
	 * 总点击
	 */
	private long click;
	
	private long uv;
	
	/*
	 * ctr = click / pv
	 * 百分比形式
	 */
	private double ctr;
	
	/*
	 * 每日曝光 todayPv
	 */
	private long dailyPv;
	
	
	/*
	 * 每日点击 today点击
	 */
	private long dailyClick;
	
	/*
	 * 每日uv
	 */
	private long dailyUv;
	
	
	/*
	 * 最高出价Highest Cost
	 */
	private double highestCost;
	
	/*
	 * 最低出价 Lowest Cost
	 */
	private double lowestCost;
	/*
	 * 平均出价 Avg.Price
	 */
	private double avgCost;
	
	/*
	 * 每日花费 Avg.Cost
	 */
	private double dailyCost;
	
	/*
	 * 总花费Total Cost
	 */
	private double totalCost;
	
	/*
	 * 辅助
	 */
	private List<Integer> materailIds;
	
	private List<Integer>  rtbProgressIds;
	
	/*交易进度
	 * 
	 * 
	 */
	private int isHaveRtb;
	private int rtbNotStarted = 0;
	private int rtbFinished = 0;
	private int rtbPause = 0;
	private int rtbRunning = 0;
	private int rtbAllOverBudget = 0;
	private int rtbDailyOverBudget = 0;
	private int rtbDailyPv = 0;
	private int rtbNoOverBudget = 0;
	
	public int getRtbNoOverBudget() {
		return rtbNoOverBudget;
	}

	public void setRtbNoOverBudget(int rtbNoOverBudget) {
		this.rtbNoOverBudget = rtbNoOverBudget;
	}

	/*
	 *
	 * 物料
	 */
	private int isHaveMaterail;
	private int dspRejected = 0;
	private int dspChecking = 0;
	private int adxChecking = 0;
	private int adxRejected = 0;
	private int adxPassed = 0;
	private int dspHasNone = 0;
	
	/*
	 * 是否可删除
	 */
	private boolean deletable;
	/*
	 * 是否可修改
	 */
	private boolean editable;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getAdvertiserName() {
		return advertiserName;
	}

	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRtbProgress() {
		return rtbProgress;
	}

	public void setRtbProgress(String rtbProgress) {
		this.rtbProgress = rtbProgress;
	}

	public String getRtbMaterialStatus() {
		return rtbMaterialStatus;
	}

	public void setRtbMaterialStatus(String rtbMaterialStatus) {
		this.rtbMaterialStatus = rtbMaterialStatus;
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

	public long getUv() {
		return uv;
	}

	public void setUv(long uv) {
		this.uv = uv;
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

	public long getDailyUv() {
		return dailyUv;
	}

	public void setDailyUv(long dailyUv) {
		this.dailyUv = dailyUv;
	}

	public double getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(double dailyCost) {
		this.dailyCost = dailyCost;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getHighestCost() {
		return highestCost;
	}

	public void setHighestCost(double highestCost) {
		this.highestCost = highestCost;
	}

	public double getLowestCost() {
		return lowestCost;
	}

	public void setLowestCost(double lowestCost) {
		this.lowestCost = lowestCost;
	}

	public double getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(double avgCost) {
		this.avgCost = avgCost;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}



	public Integer getDspId() {
		return dspId;
	}

	public void setDspId(Integer dspId) {
		this.dspId = dspId;
	}


	public Integer getCarbonId() {
		return carbonId;
	}

	public void setCarbonId(Integer carbonId) {
		this.carbonId = carbonId;
	}

	public Integer getAdvertiserId() {
		return advertiserId;
	}

	public void setAdvertiserId(Integer advertiserId) {
		this.advertiserId = advertiserId;
	}

	public List<Integer> getMaterailIds() {
		return materailIds;
	}

	public void setMaterailIds(List<Integer> materailIds) {
		this.materailIds = materailIds;
	}

	public List<Integer> getRtbProgressIds() {
		return rtbProgressIds;
	}

	public void setRtbProgressIds(List<Integer> rtbProgressIds) {
		this.rtbProgressIds = rtbProgressIds;
	}

	public int getDspRejected() {
		return dspRejected;
	}

	public void setDspRejected(int dspRejected) {
		this.dspRejected = dspRejected;
	}

	public int getDspChecking() {
		return dspChecking;
	}

	public void setDspChecking(int dspChecking) {
		this.dspChecking = dspChecking;
	}

	public int getAdxChecking() {
		return adxChecking;
	}

	public void setAdxChecking(int adxChecking) {
		this.adxChecking = adxChecking;
	}

	public int getAdxRejected() {
		return adxRejected;
	}

	public void setAdxRejected(int adxRejected) {
		this.adxRejected = adxRejected;
	}

	public int getAdxPassed() {
		return adxPassed;
	}

	public void setAdxPassed(int adxPassed) {
		this.adxPassed = adxPassed;
	}

	public int getDspHasNone() {
		return dspHasNone;
	}

	public void setDspHasNone(int dspHasNone) {
		this.dspHasNone = dspHasNone;
	}

	public int getRtbNotStarted() {
		return rtbNotStarted;
	}

	public void setRtbNotStarted(int rtbNotStarted) {
		this.rtbNotStarted = rtbNotStarted;
	}

	public int getRtbFinished() {
		return rtbFinished;
	}

	public void setRtbFinished(int rtbFinished) {
		this.rtbFinished = rtbFinished;
	}

	public int getRtbPause() {
		return rtbPause;
	}

	public void setRtbPause(int rtbPause) {
		this.rtbPause = rtbPause;
	}

	public int getRtbRunning() {
		return rtbRunning;
	}

	public void setRtbRunning(int rtbRunning) {
		this.rtbRunning = rtbRunning;
	}

	public int getRtbAllOverBudget() {
		return rtbAllOverBudget;
	}

	public void setRtbAllOverBudget(int rtbAllOverBudget) {
		this.rtbAllOverBudget = rtbAllOverBudget;
	}

	public int getRtbDailyOverBudget() {
		return rtbDailyOverBudget;
	}

	public void setRtbDailyOverBudget(int rtbDailyOverBudget) {
		this.rtbDailyOverBudget = rtbDailyOverBudget;
	}

	public int getRtbDailyPv() {
		return rtbDailyPv;
	}

	public void setRtbDailyPv(int rtbDailyPv) {
		this.rtbDailyPv = rtbDailyPv;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLandingPage() {
		return landingPage;
	}

	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
	}

	public int getIsHaveMaterail() {
		return isHaveMaterail;
	}

	public void setIsHaveMaterail(int isHaveMaterail) {
		this.isHaveMaterail = isHaveMaterail;
	}

	public int getIsHaveRtb() {
		return isHaveRtb;
	}

	public void setIsHaveRtb(int isHaveRtb) {
		this.isHaveRtb = isHaveRtb;
	}

	public boolean isDeletable() {
		return deletable;
	}

	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public double getCtr() {
		return ctr;
	}

	public void setCtr(double ctr) {
		this.ctr = ctr;
	}

	

	

	
	
	
}
