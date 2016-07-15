package com.cafe.wedding.base.service;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cafe.wedding.base.domain.BaseDomain;

public interface  BaseService<T extends BaseDomain,ID extends Serializable> {
	
	public Page<T> findAll(Pageable pageable);

}
