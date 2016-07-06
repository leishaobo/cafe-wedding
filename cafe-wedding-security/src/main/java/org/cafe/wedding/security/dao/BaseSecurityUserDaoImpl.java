package org.cafe.wedding.security.dao;

import java.util.ArrayList;
import java.util.List;

import org.cafe.wedding.security.domain.privilege.BaseSecurityPrivilege;
import org.cafe.wedding.security.domain.resources.BaseSecurityResource;
import org.cafe.wedding.security.domain.role.BaseSecurityRole;
import org.cafe.wedding.security.domain.user.BaseSecurityUser;

/**
 * 
 * @author leishaobo
 * @email leishaobo_cafe@163.com
 * @createime 2016年7月1日
 *
 */
public class BaseSecurityUserDaoImpl implements BaseSecurityUserDao{

	private static List<BaseSecurityUser> testUsers=new ArrayList<BaseSecurityUser>();
	
	static{
		//定义资源
		BaseSecurityResource resouce1=new BaseSecurityResource("login","login.jsp","登入界面");
		BaseSecurityResource resouce2=new BaseSecurityResource("admin","admin.jsp","管理员界面");
		
		BaseSecurityRole admin=new BaseSecurityRole("admin","管理");
		
		admin.getPrivileges().addAll(BaseSecurityPrivilege.generateAllPrivileges(resouce1));
		admin.getPrivileges().addAll(BaseSecurityPrivilege.generateAllPrivileges(resouce2));
		
		BaseSecurityRole common=new BaseSecurityRole("common","普通");
		common.getPrivileges().addAll(BaseSecurityPrivilege.generateAllPrivileges(resouce1));
		
		for(int i=0;i<10;i++){
			BaseSecurityUser user=new BaseSecurityUser();
			user.setUsername("admin"+i);
			user.setPassword("admin"+i);
			//user.setAccountNonExpired(true);
			//user.setAccountNonLocked(true);
			//user.setCredentialsNonExpired(true);
			if(i%2==0){
				user.getRoles().add(admin);	
			}else{
				user.getRoles().add(common);
			}
			testUsers.add(user);
		}
	}
	
	@Override
	public BaseSecurityUser getUserByusername(String username) {
		for(BaseSecurityUser user:testUsers){
			//System.out.println(user.getUsername());
			if(user.getUsername().equals(username)){
				return user;
			}
		}
		return null;
	}

}
