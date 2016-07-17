package com.cafe.wedding.base.sys.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cafe.wedding.base.service.BaseService;
import com.cafe.wedding.base.sys.domain.SysUser;
import com.cafe.wedding.common.seach.Seachable;

public interface SysUserService extends BaseService<SysUser,Long>{
	
	public Page<SysUser> findByRealname(Pageable pageable,String realname);
	
	
	

}
