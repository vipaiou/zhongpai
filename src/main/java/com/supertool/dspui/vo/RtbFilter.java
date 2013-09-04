package com.supertool.dspui.vo;

/**
 * 竞价过滤规则对象
 * @author zhouziqiang
 *
 */
public class RtbFilter {

	/*
	 * 星期定向。取值为0-6代表星期天到星期6。多个星期之间用逗号分隔
	 */
	private String timeWeekday;
	
	/*
	 * 小时定向。取值为0-23代表0点到23点。多个小时之间用逗号分隔
	 */
	private String timeHour;
	/*
	 * 地域定向。多个地域ID之间用逗号分隔
	 */
	private String geography;
	/*
	 * 频次定向。必须包括5个维度（整个活动周期内，每周，每天，每小时，每分）。
	 * 例如1,0,1,0,1表示整个活动周期内频次为1，每周频次不控制，每天频次为1，每小时频次不控制，每分频次为1
	 */
	private String maxFrequency;
	
	
	
	
	/**
	 * setters and getters
	 * 
	 */
	public String getTimeWeekday() {
		return timeWeekday;
	}
	public void setTimeWeekday(String timeWeekday) {
		this.timeWeekday = timeWeekday;
	}
	public String getTimeHour() {
		return timeHour;
	}
	public void setTimeHour(String timeHour) {
		this.timeHour = timeHour;
	}
	public String getGeography() {
		return geography;
	}
	public void setGeography(String geography) {
		this.geography = geography;
	}
	public String getMaxFrequency() {
		return maxFrequency;
	}
	public void setMaxFrequency(String maxFrequency) {
		this.maxFrequency = maxFrequency;
	}
	
	
}
