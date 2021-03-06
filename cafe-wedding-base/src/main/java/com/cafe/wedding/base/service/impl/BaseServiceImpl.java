package com.cafe.wedding.base.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cafe.wedding.base.domain.BaseDomain;
import com.cafe.wedding.base.repository.BaseRepository;
import com.cafe.wedding.base.service.BaseService;
import com.cafe.wedding.common.seach.Seachable;

public  class BaseServiceImpl<T extends BaseDomain,ID extends Serializable> implements BaseService<T, ID>{
	

	
	public BaseRepository<T, ID> repository;




	@Override
	public Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}




	@Override
	public T findOne(ID id) {
		return repository.findOne(id);
	}




	@Override
	public Page<T> findAll(Seachable seachable, Pageable pageable) {
		return repository.findAll(seachable, pageable);
	}
	
}
