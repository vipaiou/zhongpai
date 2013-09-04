package com.supertool.dspui.param.form;

public  class BasicSearchParamForm {

	private String types;
	private String scope;
	private String selectedMediaIds;
	private String conditionStr;
	private String preResultIds;
	private int isHasAdvancedSetting;
	private int resultType;
	
	
	
	public String getPreResultIds() {
		return preResultIds;
	}
	public void setPreResultIds(String preResultIds) {
		this.preResultIds = preResultIds;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getConditionStr() {
		return conditionStr;
	}
	public void setConditionStr(String conditionStr) {
		this.conditionStr = conditionStr;
	}
	public String getSelectedMediaIds() {
		return selectedMediaIds;
	}
	public void setSelectedMediaIds(String selectedMediaIds) {
		this.selectedMediaIds = selectedMediaIds;
	}
	public int getIsHasAdvancedSetting() {
		return isHasAdvancedSetting;
	}
	public void setIsHasAdvancedSetting(int isHasAdvancedSetting) {
		this.isHasAdvancedSetting = isHasAdvancedSetting;
	}
	public int getResultType() {
		return resultType;
	}
	public void setResultType(int resultType) {
		this.resultType = resultType;
	}
	
	
}
