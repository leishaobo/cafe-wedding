package com.cafe.wedding.base.argumentResolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.cafe.wedding.common.seach.SeachRequest;
import com.cafe.wedding.common.seach.Seachable;

public class SeachableMethodArgumentResover implements HandlerMethodArgumentResolver{

	private static final String seachable_prefix="seachable";
	
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return Seachable.class.equals(parameter.getParameterType());
	}

	/**
	 * seachable.name_eq=lsb
	 */
	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		
		if(Seachable.class.isAssignableFrom(parameter.getParameterType())){
			Seachable seachable=null;
			Map<String,String> params=new LinkedHashMap<String,String>();
			Iterator<String> it=webRequest.getParameterNames();
			while(it.hasNext()){
				String parameterName=it.next();
				if(parameterName.startsWith(seachable_prefix)){
					String value=webRequest.getParameter(parameterName);
					String proAndOp=parameterName.substring(seachable_prefix.length()+1);
					params.put(proAndOp, value);
				}
			}
			if(params.size()!=0){
				seachable=SeachRequest.newSeachable(params);
				return seachable;
			}
		}
		return null;
	}

}
