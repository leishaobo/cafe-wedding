package com.cafe.wedding.base.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.cafe.wedding.base.sys.domain.SysUser;
import com.cafe.wedding.common.seach.Seachable;


public class SimpleBaseRepository<D,ID extends Serializable> extends SimpleJpaRepository<D,Serializable> implements BaseRepository<D, Serializable>{

	private final String findAllTemplate="select x from %s x %s";
	
	private final String findCountTemplate="select count(*) from %s %s";
	
	private  EntityManager em;
	
	public SimpleBaseRepository(Class domainClass, EntityManager em) {
		super(domainClass, em);
		this.em=em;
	}

	public SimpleBaseRepository(JpaEntityInformation entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em=entityManager;
	}
	
	private String getQueryStringFrom(Seachable seachable){
		StringBuilder sb=new StringBuilder();
		sb.append(String.format(findAllTemplate, getDomainClass().getName(),seachable.getQueryWhereCondition()));
		return sb.toString();
	}
	private String getQueryCountStringFrom(Seachable seachable){
		StringBuilder sb=new StringBuilder();
		sb.append(String.format(findCountTemplate, getDomainClass().getName(),seachable.getQueryWhereCondition()));
		return sb.toString();
	}

	@Override
	public Page<D> findAll(Seachable seachable, Pageable pageable) {
		if(seachable==null){
			return super.findAll(pageable);
		}
		
		Query query=em.createQuery(getQueryStringFrom(seachable));
		if(seachable.getQueryWhereConditionValues()!=null){
			for(Integer index:seachable.getQueryWhereConditionValues().keySet()){
				query.setParameter(index, seachable.getQueryWhereConditionValues().get(index));
			}
		}
		if(pageable!=null){
			query.setFirstResult(pageable.getOffset());
			query.setMaxResults(pageable.getPageSize());
		}
		List<D> content=query.getResultList();
		Query countQuery=em.createQuery(getQueryCountStringFrom(seachable));
		if(seachable.getQueryWhereConditionValues()!=null){
			for(Integer index:seachable.getQueryWhereConditionValues().keySet()){
				countQuery.setParameter(index, seachable.getQueryWhereConditionValues().get(index));
			}
		}
		Object count=countQuery.getSingleResult();
		Long total=count==null?0:(Long)count;
		return new PageImpl<D>(content, pageable, total);
	}
	
	
	
	

}
