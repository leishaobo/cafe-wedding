package com.cafe.wedding.base.repository;

import java.io.Serializable;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cafe.wedding.base.domain.BaseDomain;
import com.cafe.wedding.common.seach.Seachable;


@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends PagingAndSortingRepository<T, Serializable>{

	public Page<T> findAll(Seachable seachable,Pageable pageable);
}
