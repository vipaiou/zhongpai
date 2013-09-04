package com.supertool.dspui.param.form;

import java.util.Date;

/**
 * 接受类型P,N,C的高级搜索参数
 * @author Administrator
 *
 */
public class SearchParamsForm1 extends BasicSearchParamForm{

	private String source;
	private String usage;
	private int statu;
	private int isHasSpots;
	private int isHasAdposition;
	private int isHasClass;
	private int isLeafNode;
	private int isHasRule;
	private int isHasMediaGroupID;
	private String operateStartTime;
	private String operateEndTime;
	private String operateUser;
	
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public int getIsHasSpots() {
		return isHasSpots;
	}
	public void setIsHasSpots(int isHasSpots) {
		this.isHasSpots = isHasSpots;
	}
	public int getIsHasAdposition() {
		return isHasAdposition;
	}
	public void setIsHasAdposition(int isHasAdposition) {
		this.isHasAdposition = isHasAdposition;
	}
	public int getIsHasClass() {
		return isHasClass;
	}
	public void setIsHasClass(int isHasClass) {
		this.isHasClass = isHasClass;
	}
	public int getIsLeafNode() {
		return isLeafNode;
	}
	public void setIsLeafNode(int isLeafNode) {
		this.isLeafNode = isLeafNode;
	}
	public int getIsHasRule() {
		return isHasRule;
	}
	public void setIsHasRule(int isHasRule) {
		this.isHasRule = isHasRule;
	}
	public int getIsHasMediaGroupID() {
		return isHasMediaGroupID;
	}
	public void setIsHasMediaGroupID(int isHasMediaGroupID) {
		this.isHasMediaGroupID = isHasMediaGroupID;
	}
	
	
	public String getOperateStartTime() {
		return operateStartTime;
	}
	public void setOperateStartTime(String operateStartTime) {
		this.operateStartTime = operateStartTime;
	}
	public String getOperateEndTime() {
		return operateEndTime;
	}
	public void setOperateEndTime(String operateEndTime) {
		this.operateEndTime = operateEndTime;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	


	
	
}
