package com.cafe.wedding.base.sys.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.cafe.wedding.base.repository.BaseRepository;
import com.cafe.wedding.base.sys.domain.SysUser;
import com.cafe.wedding.common.seach.Seachable;


public interface SysUserRepository extends BaseRepository<SysUser, Long> {
	
	@QueryHints
	public Page<SysUser> findByRealname(Pageable pageable,String realname);

}
