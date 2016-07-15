package com.cafe.wedding.base.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cafe.wedding.base.domain.BaseDomain;


@NoRepositoryBean
public interface BaseRepository<T extends BaseDomain,ID extends Serializable> extends PagingAndSortingRepository<T, Serializable>{

}
