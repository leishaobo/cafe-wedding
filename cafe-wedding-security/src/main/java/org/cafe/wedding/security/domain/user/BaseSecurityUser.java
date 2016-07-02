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
public class BaseSecurityUser implements UserDetails {
	
	private static final long serialVersionUID = 3903879535060608371L;
	private  String username;
	private  String password;
	private  Set<GrantedAuthority> authorities;
	private  boolean accountNonExpired;
	private  boolean accountNonLocked;
	private  boolean credentialsNonExpired;
	private  boolean enabled;
	
	private Set<BaseSecurityRole> roles=new HashSet<BaseSecurityRole>();//

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<BaseSecurityRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<BaseSecurityRole> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
