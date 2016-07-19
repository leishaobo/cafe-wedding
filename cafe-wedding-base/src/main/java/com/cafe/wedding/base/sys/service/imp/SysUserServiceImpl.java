package com.cafe.wedding.base.sys.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cafe.wedding.base.repository.BaseRepository;
import com.cafe.wedding.base.service.impl.BaseServiceImpl;
import com.cafe.wedding.base.sys.domain.SysUser;
import com.cafe.wedding.base.sys.repository.SysUserRepository;
import com.cafe.wedding.base.sys.service.SysUserService;
import com.cafe.wedding.common.seach.Seachable;

@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Long> implements SysUserService{
	
	
	@Autowired
	public void setSysUserRepository(SysUserRepository repository) {
		this.repository = repository;
	}
	
	//@Autowired
	protected SysUserRepository getSysUserRepository() {
		return (SysUserRepository)repository;
	}

	@Override
	public Page<SysUser> findByRealname(Pageable pageable, String realname) {
		return getSysUserRepository().findByRealname(pageable, realname);
	}
	 
}
