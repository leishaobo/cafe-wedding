package com.cafe.wedding.base.repository.factory;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
/**
 * 
 * @author leishaobo
 * @email  leishaobo_cafe@163.com
 * @createime 2016年7月16日
 */
public class CafeJpaRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID> {


	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new CafeJpaRepositoryFactory(entityManager);
	}

}
