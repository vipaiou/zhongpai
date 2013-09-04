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
@org.hibernate.annotations.Entity(dynamicInsert=true)
@Table(name = "st_authority")
/**
 * 
 * @author zzq
 *
 */
public class Authority implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Authority() {
		super();
		this.description="";
		this.enabled=1;
		this.module="";
		this.name="";
		this.parentId=-1;
	}

	
public Authority(String name, String description, int enabled,
			String module, int parentId) {
		super();
		this.name = name;
		this.description = description;
		this.enabled = enabled;
		this.module = module;
		this.parentId = parentId;
	}


//主键id
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private Integer authorityId;
 
 //权限名称
 @Column(name = "Name")
 
 private String name;
 
 //权限描述
 @Column(name = "Description")
 private String description;
 
 //权限是否有效
@Column(name = "Enabled")
private int enabled;

//权限优先级
@Column(name = "Priority")
private int priority;

//权限所在的模块
@Column(name = "Module")
private String module;

//父权限
@Column(name = "ParentId")
private int parentId;



public int getAuthorityId() {
	return authorityId;
}

public void setAuthorityId(int authorityId) {
	this.authorityId = authorityId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



public int getPriority() {
	return priority;
}


public void setPriority(int priority) {
	this.priority = priority;
}


public void setAuthorityId(Integer authorityId) {
	this.authorityId = authorityId;
}


public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public static long getSerialversionuid() {
	return serialVersionUID;
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

public int getParentId() {
	return parentId;
}

public void setParentId(int parentId) {
	this.parentId = parentId;
}

}
