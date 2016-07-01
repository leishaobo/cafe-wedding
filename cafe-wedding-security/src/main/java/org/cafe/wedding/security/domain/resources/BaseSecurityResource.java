package org.cafe.wedding.security.domain.resources;
/**
 * 
 * @author leishaobo
 * @email leishaobo_cafe@163.com
 * @createime 2016年7月1日
 *
 */
public class BaseSecurityResource {
	
	private String code;
	private String name;
	private String desc;
	
	
	
	public BaseSecurityResource() {
		super();
	}
	public BaseSecurityResource(String code, String name, String desc) {
		super();
		this.code = code;
		this.name = name;
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
