package com.supertool.dspui.config;

import com.supertool.dspui.context.ConfigContext;


public class DebugConfig {
	 	private Boolean trace = false;
	    private Boolean useDefaultUser = false;
	    private boolean validateTime = true;
	    private Boolean isShowPost = false;
	    private Boolean isShowResponse = false;

	    public Boolean getUseDefaultUser() {
	        return useDefaultUser;
	    }

	    public void setUseDefaultUser(Boolean useDefaultUser) {
	        this.useDefaultUser = useDefaultUser;
	    }

	    public Boolean getTrace() {
	        return trace;
	    }

	    public void setTrace(Boolean trace) {
	        this.trace = trace;
	    }

	    public boolean isValidateTime() {
	        return validateTime;
	    }

	    public void setValidateTime(boolean validateTime) {
	        this.validateTime = validateTime;
	    }

	    public Boolean getIsShowPost() {
	        return isShowPost;
	    }

	    public void setIsShowPost(Boolean isShowPost) {
	        this.isShowPost = isShowPost;
	    }

	    public Boolean getIsShowResponse() {
	        return isShowResponse;
	    }

	    public void setIsShowResponse(Boolean isShowResponse) {
	        this.isShowResponse = isShowResponse;
	    }

	}
