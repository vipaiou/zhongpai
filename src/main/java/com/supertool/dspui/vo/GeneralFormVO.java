package com.supertool.dspui.vo;

public class GeneralFormVO {
	
	private int dspId;
	private String name;
	private String startTime;
	private String endTime;
	private int bid;
	private int winBid;
	private int pv;
	private int click;
	private double cost;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getWinBid() {
		return winBid;
	}
	public void setWinBid(int winBid) {
		this.winBid = winBid;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
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
}
