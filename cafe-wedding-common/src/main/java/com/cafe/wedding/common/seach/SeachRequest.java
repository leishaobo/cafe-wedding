package com.cafe.wedding.common.seach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.cafe.wedding.common.seach.support.Condition;
import com.cafe.wedding.common.seach.support.Operation;
import com.cafe.wedding.common.seach.support.SeachFilter;

public class SeachRequest implements Seachable {
	private List<SeachFilter> filters=new LinkedList<SeachFilter>();
	
	private  SeachRequest() {
		
	}
	private SeachRequest(SeachFilter filter) {
		this.filters.add(filter);
	}
	
	private  SeachRequest(List<SeachFilter> filter) {
		this.filters.addAll(filter);
	}

	public static Seachable newSeachable() {
		return new SeachRequest();
	}
	
	public static Seachable newSeachable(String seachstr) {
		return new SeachRequest(parseSeachFiler(seachstr));
	}

	public static Seachable newSeachable(List<String> seachstrs) {
		List<SeachFilter> list=new ArrayList<SeachFilter>();
		for(String seachstr:seachstrs){
			list.add(parseSeachFiler(seachstr));
		}
		return new SeachRequest(list);
	}



	public static Seachable newSeachable(String property, String value,
			Operation operation) {

		return new SeachRequest(new Condition(operation, property, value));
	}
	
	private static SeachFilter parseSeachFiler(String seachstr){
		String[] temp=seachstr.split("=");
		if(temp.length==2){
			String propertyAndOp=temp[0];
			String value=temp[1];
			String[] s=propertyAndOp.split("_");
			if(s.length==2){
				SeachFilter seachFilter=new Condition(Operation.valueOf(s[1]), s[0], value);
				return seachFilter;
			}
		}
		return null;
	}
	@Override
	public String getQueryWhereCondition() {
		if(this.filters.size()==0) {
			return null;
		}
		StringBuilder sb=new StringBuilder(" where ");
		int index=1;
		for(SeachFilter seachFilter:this.filters){
			if(seachFilter instanceof Condition){
				Condition c=(Condition) seachFilter;
				sb.append(" ");
				sb.append(c.getProperty());
				sb.append(c.getOperation().getCode());
				sb.append("?"+(index++));
				sb.append(" and ");
			}
		}
		int lastAndIndex=sb.lastIndexOf("and ");
		sb.delete(lastAndIndex, sb.length());
		System.out.println(sb.toString());
		return sb.toString();
	}
	@Override
	public Map<Integer, String> getQueryWhereConditionValues() {
		if(this.filters.size()==0) {
			return null;
		}
		Map<Integer, String> map=new  HashMap<Integer, String>();
		int index=1;
		for(SeachFilter seachFilter:this.filters){
			if(seachFilter instanceof Condition){
				Condition c=(Condition) seachFilter;
				map.put(index++, c.getValue());
			}
		}
		
		return map;
	}
	
}
