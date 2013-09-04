package com.supertool.dspui.param.form;

import java.util.List;

public class AccessUserForm {

    public static final String OK = "0";
    public static final String USER_NOT_FOUND = "-1";
    public static final String WRONG_PASSWORD = "-2";
    public static final String WRONG_USER_KEY = "-3";
    public static final String FREEZED = "-4";
    public static final String OUT_DATE = "-5";
    public static final String WRONG_PRODUCT = "-6";
    public static final String NO_PERMISSION = "-7";
    public static final String NOT_OPEN = "-8";

    private Integer userId;
    private String userName;
    private Boolean superAdmin = false;
    private String errorCode;
    private List<String> productPermission;
    private Integer roleId;
    private Integer organizationId;
    private String organizationCategory = "";//Access1.9新增字段

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(Boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public List<String> getProductPermission() {
        return productPermission;
    }

    public void setProductPermission(List<String> productPermission) {
        this.productPermission = productPermission;
    }

	public String getOrganizationCategory() {
		return organizationCategory;
	}

	public void setOrganizationCategory(String organizationCategory) {
		this.organizationCategory = organizationCategory;
	}
}
