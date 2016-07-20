package com.cafe.wedding.common.seach.support;

public enum Operation {
	eq("=","等于"),
	lt("<","小于"),
	lte("<=","小于等于"),
	gt(">","大于"),
	gte(">=","大于等于"),
	prefixLike("like","前模糊匹配"),
	prefixNotLike("not like","前模糊不匹配"),
	suffixLike("like","后缀模糊匹配"),
	suffixNotLike("not like","后缀模糊不匹配"),
	like("like","模糊匹配"),
	in("in","包含"),
	notIn("not in","不包含"),
    isNull("is null", "空"),
    isNotNull("is not null", "非空"),
	custom(null,"自定义");
	
	
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
