package com.supertool.dspui.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@Table(name = "st_resource")
public class Resource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Resource() {
		super();
		this.desc="";
		this.enabled=1;
		this.module="";
		this.name="";
		this.priority=0;
		this.type="url";
		this.url="";
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int resourceId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Descrition")
	private String desc;
	
	@Column(name = "Enabled")
	private int enabled;
	
	@Column(name = "Module")
	private String module;
	
	@Column(name = "Type")
	private String type;
	
	@Column(name = "Url")
	private String url;
	
	
	@Column(name = "Priority")
	private int priority;



	public int getResourceId() {
		return resourceId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}
