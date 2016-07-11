package com.cafe.wedding.base.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cafe.wedding.base.repository.BaseRepository;
import com.cafe.wedding.base.service.BaseService;

public abstract class BaseServiceImpl<T,ID extends Serializable> implements BaseService<T, ID>{
	

	
	protected BaseRepository<T, ID> repository;
	
	

	@Autowired
	public void setRepository(BaseRepository<T, ID> repository) {
		this.repository = repository;
	}



	@Override
	public Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	
}
