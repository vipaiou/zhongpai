package com.supertool.dspui.model;

public class Setting {
	
	int id;
	int dspid;
	long flvsize;
	long swfsize;
	long imgsize;
	
	public Setting() {
		super();
		flvsize =  1500  ;
		swfsize =  500 ;
		imgsize =  150 ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDspid() {
		return dspid;
	}
	public void setDspid(int dspid) {
		this.dspid = dspid;
	}
	public long getFlvsize() {
		return flvsize;
	}
	public void setFlvsize(long flvsize) {
		this.flvsize = flvsize;
	}
	public long getSwfsize() {
		return swfsize;
	}
	public void setSwfsize(long swfsize) {
		this.swfsize = swfsize;
	}
	public long getImgsize() {
		return imgsize;
	}
	public void setImgsize(long imgsize) {
		this.imgsize = imgsize;
	}
	
	
}
