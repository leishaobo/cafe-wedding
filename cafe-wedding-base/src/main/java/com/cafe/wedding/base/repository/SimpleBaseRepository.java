package com.cafe.wedding.base.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
import com.cafe.wedding.common.seach.utils.SeachableConvertUtil;
import com.cafe.wedding.common.seach.utils.SeachableSQLHelper;


public class SimpleBaseRepository<D,ID extends Serializable> extends SimpleJpaRepository<D,Serializable> implements BaseRepository<D, Serializable>{

	private final String findAllTemplate="select x from %s x %s";
	
	private final String findCountTemplate="select count(*) from %s %s";
	
	private  EntityManager em;
	
	JpaEntityInformation entityInformation;
	
	public SimpleBaseRepository(Class domainClass, EntityManager em) {
		super(domainClass, em);
		this.em=em;
	}

	public SimpleBaseRepository(JpaEntityInformation entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em=entityManager;
		this.entityInformation=entityInformation;
	}
	
	private String getQueryStringFrom(Seachable seachable){
		StringBuilder sb=new StringBuilder();
		sb.append(String.format(findAllTemplate, getDomainClass().getName(),SeachableSQLHelper.createQueryWhere(seachable)));
		return sb.toString();
	}
	private String getQueryCountStringFrom(Seachable seachable){
		StringBuilder sb=new StringBuilder();
		sb.append(String.format(findCountTemplate, getDomainClass().getName(),SeachableSQLHelper.createQueryWhere(seachable)));
		return sb.toString();
	}

	@Override
	public Page<D> findAll(Seachable seachable, Pageable pageable) {
		if(seachable==null){
			return super.findAll(pageable);
		}
		SeachableConvertUtil.convert(seachable, entityInformation.getJavaType());
		Query query=em.createQuery(getQueryStringFrom(seachable));
		Map<String,Object> paramAndValues=SeachableSQLHelper.getQueryParamMap(seachable);
		for(String pro:paramAndValues.keySet()){
			query.setParameter(pro, paramAndValues.get(pro));
		}
		if(pageable!=null){
			query.setFirstResult(pageable.getOffset());
			query.setMaxResults(pageable.getPageSize());
		}
		List<D> content=query.getResultList();
		
		Query countQuery=em.createQuery(getQueryCountStringFrom(seachable));
		for(String pro:paramAndValues.keySet()){
			countQuery.setParameter(pro, paramAndValues.get(pro));
		}
		Object count=countQuery.getSingleResult();
		Long total=count==null?0:(Long)count;
		return new PageImpl<D>(content, pageable, total);
	}
	
	
	
	

}
