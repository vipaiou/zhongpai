package com.supertool.dspui.vo;

import java.io.Serializable;

public class MaterialStatusInfo implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private int id;
  
  private int status;
  
  private String reason;



public String getReason() {
	return reason;
}

public void setReason(String reason) {
	this.reason = reason;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}


  
  
  
}
