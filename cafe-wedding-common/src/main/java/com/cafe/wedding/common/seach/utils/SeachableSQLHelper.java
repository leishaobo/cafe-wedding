package com.cafe.wedding.common.seach.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cafe.wedding.common.seach.SeachRequest;
import com.cafe.wedding.common.seach.Seachable;
import com.cafe.wedding.common.seach.support.Condition;
import com.cafe.wedding.common.seach.support.SeachFilter;

public class SeachableSQLHelper {
	
	public static String createQueryWhere(Seachable seachable){
		if(seachable instanceof SeachRequest){
			SeachRequest seachRequest=(SeachRequest)seachable;
			List<SeachFilter> filters=seachRequest.getSeachFilters();
			if(filters!=null){
				StringBuilder sb=new StringBuilder(" WHERE ");
				for(SeachFilter filter:filters){
					if(filter instanceof Condition){
						Condition c=(Condition)filter;
						sb.append(c.getDomainProperty());
						switch(c.getOperation()){
							case eq:
								sb.append(c.getOperation().getCode()).append(":"+c.getDomainProperty()).append(" AND ");
								break;
						}
					}
				}
				int andIndex=sb.lastIndexOf(" AND ");
				sb.delete(andIndex, sb.length());
				System.out.println(sb.toString());
				return sb.toString();
			}
		}
	
		return "";
	}
	public static Map<String,Object> getQueryParamMap(Seachable seachable){
		if(seachable instanceof SeachRequest){
			SeachRequest seachRequest=(SeachRequest)seachable;
			List<SeachFilter> filters=seachRequest.getSeachFilters();
			if(filters!=null){
				 Map<String,Object> result=new  HashMap<String,Object>();
				for(SeachFilter filter:filters){
					if(filter instanceof Condition){
						Condition c=(Condition)filter;
						if(!c.isUnitary()){
							result.put(c.getDomainProperty(), c.getValue());
						}
					}
				}
				
				return result;
			}
		}
		
		return null;
		
	}
}
