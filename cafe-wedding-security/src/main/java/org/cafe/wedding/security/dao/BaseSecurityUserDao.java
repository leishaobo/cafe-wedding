package org.cafe.wedding.security.dao;

import org.cafe.wedding.security.domain.user.BaseSecurityUser;

/**
 * 
 * @author leishaobo
 * @email leishaobo_cafe@163.com
 * @createime 2016年7月1日
 *
 */
public interface BaseSecurityUserDao {
	public BaseSecurityUser getUserByusername(String username);
}
