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
@Table(name = "st_authority_resource_relation")
public class AuthorityResource implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

//映射权限表
@Column(name = "AuthorityId")
private int authorityId;

@Column(name = "ResourceId")
private int resourceId;

@Column(name = "Enabled")
private int enabled;

public AuthorityResource() {
	super();
	this.authorityId=-1;
	this.resourceId=-1;
	this.enabled=1;
}

public int getId() {
	return id;
}



public int getEnabled() {
	return enabled;
}

public void setEnabled(int enabled) {
	this.enabled = enabled;
}

public int getAuthorityId() {
	return authorityId;
}

public void setAuthorityId(int authorityId) {
	this.authorityId = authorityId;
}

public int getResourceId() {
	return resourceId;
}

public void setResourceId(int resourceId) {
	this.resourceId = resourceId;
}
	
}
