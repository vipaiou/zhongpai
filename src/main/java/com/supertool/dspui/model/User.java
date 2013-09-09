package com.supertool.dspui.model;

import java.io.Serializable;
import java.util.Date;

import com.supertool.dspui.util.Common;


public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Integer userId;
	
	private int parentUserId;
	
	private String isSuperAdmin;
	
	private String username;
	
	private String userFullName;

	private String password;
	
	private String description;
	
	private int loginCount;

	private String phoneNumber;
	
	private String address;
	
	private String email;
	
	private String isFreezed;
	
	private int updateUser;
	
	private Date updateDate;
	
	private int createUser;
	
	private Date createDate;
	
	private Integer dspId;
	
	/*
	 * char(1) NOT NULL default '0' COMMENT '删除状态：''0''是未删除；''1''是删除',
	 */
	private String isDeleted;
	
	private int deleteUser;
	
	private Date deleteDate;
	
	private String website;
	
	private String zipcode;
	
	private String avatar;
	private String qq;
	private String weibo;
	private String douban;
	private String renren;
	private String province;
	private String city;
	private String newsnotify;
	private String projectnotify;
	private String actionnotify;
	private String tags;
	
	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public String getQq() {
		return qq;
	}


	public void setQq(String qq) {
		this.qq = qq;
	}


	public String getWeibo() {
		return weibo;
	}


	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}


	public String getDouban() {
		return douban;
	}


	public void setDouban(String douban) {
		this.douban = douban;
	}


	public String getRenren() {
		return renren;
	}


	public void setRenren(String renren) {
		this.renren = renren;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getNewsnotify() {
		return newsnotify;
	}


	public void setNewsnotify(String newsnotify) {
		this.newsnotify = newsnotify;
	}


	public String getProjectnotify() {
		return projectnotify;
	}


	public void setProjectnotify(String projectnotify) {
		this.projectnotify = projectnotify;
	}


	public String getActionnotify() {
		return actionnotify;
	}


	public void setActionnotify(String actionnotify) {
		this.actionnotify = actionnotify;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public User() {
		super();
		this.address="";
		this.createUser=0;
		this.deleteUser=0;
		this.description="";
		this.email="";
		this.isDeleted="0";
		this.isFreezed="0";
		this.isSuperAdmin="0";
		this.loginCount=0;
		this.parentUserId=0;
		this.phoneNumber="";
		this.updateUser=0;
		this.userFullName="";
		Common common=Common.getInstance();
		this.createDate=common.stringToUtilDate("1970-01-01 08:00:00");
		this.deleteDate=common.stringToUtilDate("1970-01-01 08:00:00");
		this.updateDate=common.stringToUtilDate("1970-01-01 08:00:00");
		this.website = "";
		this.zipcode = "";
		this.avatar = "";
		this.qq = "";
		this.weibo = "";
		this.douban = "";
		this.renren = "";
		this.province = "";
		this.city = "";
		this.newsnotify = "";
		this.projectnotify = "";
		this.actionnotify = "";
	}
	
	
	public User(int parentUserId, String isSuperAdmin, String username,
			String userFullName, String password, String description,
			int loginCount, String phoneNumber, String address, String email,
			String isFreezed, int updateUser, Date updateDate, int createUser,
			Date createDate, String isDeleted, int deleteUser, Date deleteDate,
			String website, String zipcode) {
		super();
		this.parentUserId = parentUserId;
		this.isSuperAdmin = isSuperAdmin;
		this.username = username;
		this.userFullName = userFullName;
		this.password = password;
		this.description = description;
		this.loginCount = loginCount;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.isFreezed = isFreezed;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.createUser = createUser;
		this.createDate = createDate;
		this.isDeleted = isDeleted;
		this.deleteUser = deleteUser;
		this.deleteDate = deleteDate;
		this.website = website;
		this.zipcode = zipcode;
	}

	public int getUserId() {
		return userId;
	}

	public int getParentUserId() {
		return parentUserId;
	}

	public void setParentUserId(int parentUserId) {
		this.parentUserId = parentUserId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getCreateUser() {
		return createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getIsFreezed() {
		return isFreezed;
	}

	public void setIsFreezed(String isFreezed) {
		this.isFreezed = isFreezed;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(int deleteUser) {
		this.deleteUser = deleteUser;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIsSuperAdmin() {
		return isSuperAdmin;
	}

	public void setIsSuperAdmin(String isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}


	public Integer getDspId() {
		return dspId;
	}


	public void setDspId(Integer dspId) {
		this.dspId = dspId;
	}
	
	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


}
