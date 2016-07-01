package org.cafe.wedding.security.domain.role;

import java.util.HashSet;
import java.util.Set;

import org.cafe.wedding.security.domain.privilege.BaseSecurityPrivilege;

/**
 * 角色
 * @author leishaobo
 * @email leishaobo_cafe@163.com
 * @createime 2016年7月1日
 *
 */
public class BaseSecurityRole {
	private String code;
	private String name;
	private String desc;
	private int weight;//权重，0<1<2
	
	private Set<BaseSecurityPrivilege> privileges=new HashSet<BaseSecurityPrivilege>();
	
	

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
	
	

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Set<BaseSecurityPrivilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<BaseSecurityPrivilege> privileges) {
		this.privileges = privileges;
	}
	
	
}
