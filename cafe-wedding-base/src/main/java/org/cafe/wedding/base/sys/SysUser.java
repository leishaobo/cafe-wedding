package org.cafe.wedding.base.sys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import org.cafe.wedding.security.domain.privilege.BaseSecurityPrivilege;
import org.cafe.wedding.security.domain.role.BaseSecurityRole;
import org.cafe.wedding.security.domain.user.BaseSecurityUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SysUser extends BaseSecurityUser implements UserDetails{

	//private  Set<GrantedAuthority> authorities=Collections.EMPTY_SET;
	private  boolean is_account_expired;
	private  boolean is_account_locked;
	private  boolean is_credentials_expired;
	private  boolean is_enabled;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<BaseSecurityPrivilege> authorities=new HashSet<BaseSecurityPrivilege>();
		if(this.getRoles()==null || this.getRoles().size()==0){
			return null;
		}
		for(BaseSecurityRole role:this.getRoles()){
			for(BaseSecurityPrivilege authority:role.getPrivileges()){
				if(!authorities.contains(authority)){
					authorities.add(authority);
				}
			}
		}
		
		return authorities;
	}
	@Override
	public boolean isAccountNonExpired() {
		return is_account_expired;
	}
	@Override
	public boolean isAccountNonLocked() {
		return is_account_locked;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return is_credentials_expired;
	}
	@Override
	public boolean isEnabled() {
		return is_enabled;
	}
}
