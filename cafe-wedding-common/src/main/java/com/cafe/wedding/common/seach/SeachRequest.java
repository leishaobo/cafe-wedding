package com.cafe.wedding.common.seach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.cafe.wedding.common.seach.support.Condition;
import com.cafe.wedding.common.seach.support.Operation;
import com.cafe.wedding.common.seach.support.SeachFilter;

public class SeachRequest extends Seachable {
	
	private List<SeachFilter> filters=new LinkedList<SeachFilter>();
	
	SeachRequest() {
		
	}
	SeachRequest(SeachFilter filter) {
		this.filters.add(filter);
	}
	
	SeachRequest(List<SeachFilter> filter) {
		this.filters.addAll(filter);
	}
	
	SeachRequest(String key,String value){
		try{
			Condition c=new Condition(key,value);
			this.filters.add(c);
		}catch(Exception e){
			
		}
	}
	
	SeachRequest(Map<String,String> params){
		for(String key:params.keySet()){
			try{
				Condition c=new Condition(key,params.get(key));
				this.filters.add(c);
			}catch(Exception e){
				
			}
		}
	}
	
	public List<SeachFilter> getSeachFilters(){
		if(this.filters.isEmpty()){
			return null;
		}
		return this.filters;
	}

}
