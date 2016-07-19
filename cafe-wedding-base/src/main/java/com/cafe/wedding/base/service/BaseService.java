package com.cafe.wedding.base.service;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cafe.wedding.base.domain.BaseDomain;
import com.cafe.wedding.common.seach.Seachable;
/**
 * 
 * @author leishaobo
 * @email  leishaobo_cafe@163.com
 * @createime 2016年7月16日
 */
public interface  BaseService<T extends BaseDomain,ID extends Serializable> {
	
	public Page<T> findAll(Pageable pageable);
	
	public T findOne(ID id);
	
	public Page<T> findAll(Seachable seachable,Pageable pageable);

}
