package com.cafe.wedding.common.seach.support;

public class Condition implements SeachFilter{
	
	public static final String  separation="_";
	
	private  Operation operation;
	private String  property;
	private String value;
	
	public Condition() {
		
	}
	
	public Condition(Operation operation, String property, String value) {
		this.operation = operation;
		this.property = property;
		this.value = value;
	}

	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
