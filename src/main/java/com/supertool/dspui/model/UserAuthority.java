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
@Table(name = "st_user_authority_relation")
public class UserAuthority implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "UserId")
	private int userId;
	
	@Column( name = "AuthorityId")
	private int authorityId;
	
	@Column(name = "Enabled")
	private int enabled ;

	public UserAuthority() {
		super();
		this.authorityId=-1;
		this.userId=-1;
		this.enabled=1;
	}

	
	public UserAuthority(int userId, int authorityId, int enabled) {
		super();
		this.userId = userId;
		this.authorityId = authorityId;
		this.enabled = enabled;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public int getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
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
	
	
}
