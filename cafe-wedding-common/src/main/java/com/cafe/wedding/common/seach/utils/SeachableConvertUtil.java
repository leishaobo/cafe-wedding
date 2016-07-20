package com.cafe.wedding.common.seach.utils;

import java.util.List;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.cafe.wedding.common.seach.SeachRequest;
import com.cafe.wedding.common.seach.Seachable;
import com.cafe.wedding.common.seach.support.Condition;
import com.cafe.wedding.common.seach.support.SeachFilter;

public class SeachableConvertUtil {
	
	public static  <T> void  convert(Seachable seachable,Class<T> clazz){
		if(seachable instanceof SeachRequest){
			SeachRequest seachRequest=(SeachRequest)seachable;
			List<SeachFilter> filters=seachRequest.getSeachFilters();
			if(filters!=null){
				BeanWrapper beanWrapper=new BeanWrapperImpl(clazz);
				beanWrapper.setAutoGrowNestedPaths(true);
				for(SeachFilter filter:filters){
					if(filter instanceof Condition){
						doConvert(beanWrapper,(Condition)filter);
					}
				}
			}
		}
	}
	private static void doConvert(BeanWrapper beanWrapper,Condition condition){
		if(condition.isUnitary()){
			return;
		}
		beanWrapper.setPropertyValue(condition.getDomainProperty(), condition.getValue());
		Object value=beanWrapper.getPropertyValue(condition.getDomainProperty());
		condition.setValue(value);
	}
}
