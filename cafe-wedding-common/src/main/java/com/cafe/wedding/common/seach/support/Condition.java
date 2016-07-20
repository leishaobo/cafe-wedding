package com.cafe.wedding.common.seach.support;

import org.apache.commons.lang3.StringUtils;

import com.cafe.wedding.common.seach.exception.SeachableException;



/**
 * 比如：name_eq=leishaobo
 * @author leishaobo
 * @email leishaobo_cafe@163.com
 * @createime 2016年7月20日
 */
public class Condition implements SeachFilter{
	
	public static final String DEFULT_SEPARATION="_";
	
	public static String  separation=DEFULT_SEPARATION;
	
	private String key;	//name_eq
	private String  seachProperty;//搜索属性
	private  Operation operation;//操作符号
	private String  domainProperty;//对象属性
	private Object value;//值
	
	public Condition() {}
	
	

	public Condition(String key, Object value) throws SeachableException {
		if(StringUtils.isBlank(key)){
			throw new SeachableException("key 为空");
		}
		this.key = key;
		this.value = value;
		parseKey(key);
	}
	
	private void parseKey(String key) throws SeachableException{
		String[] proAndOp=key.split(separation);
		if(proAndOp.length==2){
			this.seachProperty=proAndOp[0];
			this.domainProperty=proAndOp[0];
			this.operation=Operation.valueOf(proAndOp[1]);
		}else{
			throw new SeachableException("参数解析异常！");
		}
	}
	
	public Boolean isUnitary(){
		return this.operation.getCode().startsWith("is");
	}

	//***************getting and setting*****************


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSeachProperty() {
		return seachProperty;
	}

	public void setSeachProperty(String seachProperty) {
		this.seachProperty = seachProperty;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public String getDomainProperty() {
		return seachProperty;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public static String getSeparation() {
		return separation;
	}
	
}
