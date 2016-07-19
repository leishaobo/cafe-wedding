package com.cafe.wedding.common.seach.support;

public enum Operation {
	eq("=","等于"),
	lt("<","小于"),
	lte("<=","小于等于"),
	gt(">","大于"),
	gte(">=","大于等于"),
	l_like("like %%s","左like"),
	r_like("like %s%","右like"),
	like("like %s","like");
	
	String code;
	String desc;
	
	private Operation(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
