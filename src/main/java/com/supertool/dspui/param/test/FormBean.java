package com.supertool.dspui.param.test;

public class FormBean {
	private String name;
	private int age;
	private String[] associate;
	private ComBen[] bens; //另一个数组对像
	private ThirdBen[] thdben;//再一层数组对像
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getAssociate() {
		return associate;
	}
	public void setAssociate(String[] associate) {
		this.associate = associate;
	}
	public ComBen[] getBens() {
		return bens;
	}
	public void setBens(ComBen[] bens) {
		this.bens = bens;
	}
	public ThirdBen[] getThdben() {
		return thdben;
	}
	public void setThdben(ThirdBen[] thdben) {
		this.thdben = thdben;
	}
}
