package com.supertool.dspui.model;

import java.io.Serializable;
/**
 * dsp实体
 * @author zhouziqiang
 *
 */
public class Dsp implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	   * 主键，自增
	   */
	  private int dspId;
	  private int id;
	  private String name;
	  /*
	   * carbon里对应表主键
	   */
	  private int carbonId;
	  /*
	   * 与dsp对应的token值，由adx分配，用来进行权限验证
	   */
	  private String token;
	  /*
	   * 描述
	   */
	  private String Description;
	  /*
	   * 是否激活,0=否，1=是
	   */
	  private int active;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
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
	public int getDspId() {
		return dspId;
	}
	public void setDspId(int dspId) {
		this.dspId = dspId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	  
	  
	  
	  
}
