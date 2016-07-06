package org.cafe.wedding.security.service;

import org.cafe.wedding.security.dao.BaseSecurityUserDaoImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BaseSecurityUserService implements UserDetailsService{
	BaseSecurityUserDaoImpl dao=new BaseSecurityUserDaoImpl();
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return (UserDetails) dao.getUserByusername(username);
	}

}
