package com.supertool.dspui.param.carboninterface;

public class UpdateCampaignParam {

	private Integer id;
	private Integer dspId;
	private String name;
	private String start;
	private String end;
	private Integer advertiserId;
	private String brand;
	private String landingPage;
	private boolean minisite;
	private double maxPrice;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDspId() {
		return dspId;
	}
	public void setDspId(Integer dspId) {
		this.dspId = dspId;
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
	public Integer getAdvertiserId() {
		return advertiserId;
	}
	public void setAdvertiserId(Integer advertiserId) {
		this.advertiserId = advertiserId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLandingPage() {
		return landingPage;
	}
	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
	}
	public boolean isMinisite() {
		return minisite;
	}
	public void setMinisite(boolean minisite) {
		this.minisite = minisite;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	
}
