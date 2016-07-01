package org.cafe.wedding.security;


import org.cafe.wedding.security.domain.user.BaseSecurityUser;
import org.cafe.wedding.security.service.BaseSecurityUserService;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

public class UserRoleTest {

	@Test
	public void test() {
		BaseSecurityUserService userService=new BaseSecurityUserService();
		UserDetails user= userService.loadUserByUsername("admin1");
		if(user instanceof BaseSecurityUser){
			BaseSecurityUser bsu=(BaseSecurityUser)user;
			System.out.println(bsu);
		}
	}

}
