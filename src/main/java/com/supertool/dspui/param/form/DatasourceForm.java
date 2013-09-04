package com.supertool.dspui.param.form;

import org.springframework.web.multipart.MultipartFile;

public class DatasourceForm {

	private Integer id;

	private Integer carbonId;

	private String name;

	private String type;

	private String keySeperator;

	private String valueSeperator;

	private String remark;

	private MultipartFile file;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCarbonId() {
		return carbonId;
	}

	public void setCarbonId(Integer carbonId) {
		this.carbonId = carbonId;
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

	public String getKeySeperator() {
		return keySeperator;
	}

	public void setKeySeperator(String keySeperator) {
		this.keySeperator = keySeperator;
	}

	public String getValueSeperator() {
		return valueSeperator;
	}

	public void setValueSeperator(String valueSeperator) {
		this.valueSeperator = valueSeperator;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
