/*
 * Copyright 2008-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cafe.wedding.base.repository.factory;

import static org.springframework.data.querydsl.QueryDslUtils.*;

import java.io.Serializable;

import javax.persistence.EntityManager;






import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.core.RepositoryMetadata;

import com.cafe.wedding.base.domain.BaseDomain;
import com.cafe.wedding.base.repository.SimpleBaseRepository;

/**
 * 
 * @author leishaobo
 * @email  leishaobo_cafe@163.com
 * @createime 2016年7月16日
 */
public class CafeJpaRepositoryFactory extends JpaRepositoryFactory {

	private EntityManager entityManager;
	
	public CafeJpaRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
		this.entityManager=entityManager;
	}

	@Override
	protected Object getTargetRepository(RepositoryMetadata metadata) {
		 return getTargetRepository(metadata,entityManager);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryMetadata metadata,EntityManager entityManager) {
		//super.getTargetRepository(metadata, entityManager);
		//Class<?> repositoryInterface = metadata.getRepositoryInterface();
		JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());
		
		//SimpleJpaRepository<?, ?> repo = isQueryDslExecutor(repositoryInterface) ? new QueryDslJpaRepository(
		//		entityInformation, entityManager) : new SimpleJpaRepository(entityInformation, entityManager);

		//repo=SimpleBaseRepository.class.isAssignableFrom(repositoryInterface)?new SimpleBaseRepository<T,ID>(entityInformation, entityManager):repo;
		
		return new SimpleBaseRepository<T,ID>(entityInformation, entityManager);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.support.RepositoryFactorySupport#
	 * getRepositoryBaseClass()
	 */
	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		return SimpleBaseRepository.class;
	}
	
	/**
	 * Returns whether the given repository interface requires a QueryDsl specific implementation to be chosen.
	 * 
	 * @param repositoryInterface
	 * @return
	 */
	private boolean isQueryDslExecutor(Class<?> repositoryInterface) {

		return QUERY_DSL_PRESENT && QueryDslPredicateExecutor.class.isAssignableFrom(repositoryInterface);
	}


}
