package org.cafe.wedding.security.domain.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.cafe.wedding.security.domain.privilege.BaseSecurityPrivilege;
import org.cafe.wedding.security.domain.role.BaseSecurityRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author leishaobo
 * @email leishaobo_cafe@163.com
 * @createime 2016年7月1日
 *
 */
public class BaseSecurityUser {
	private static final long serialVersionUID = 3903879535060608371L;
	
	private  String username;
	private  String password;

	
	private Set<BaseSecurityRole> roles=new HashSet<BaseSecurityRole>();//

	
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}




	


	public Set<BaseSecurityRole> getRoles() {
		return roles;
	}



	public void setRoles(Set<BaseSecurityRole> roles) {
		this.roles = roles;
	}



	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("{");
		for(BaseSecurityRole role:roles){
				sb.append("roleCode:"+role.getCode());
				sb.append(",privileges:[");
				for(BaseSecurityPrivilege privilege:role.getPrivileges()){
					sb.append("{privilege:"+privilege+"},");
				}
				sb.deleteCharAt(sb.length()-1);
				sb.append("]");
		}
		sb.append("}");
		return sb.toString();
	}
	
}
