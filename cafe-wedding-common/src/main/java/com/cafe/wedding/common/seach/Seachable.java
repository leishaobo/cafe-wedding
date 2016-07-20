package com.cafe.wedding.common.seach;

import java.util.List;
import java.util.Map;

import com.cafe.wedding.common.seach.support.Operation;
import com.cafe.wedding.common.seach.support.SeachFilter;

/**
 * seachable.name_eq=leishaobo&seachable.age_glt=24
 * 查询名字=leishaobo && 年龄大于 24岁的
 * @author leishaobo
 * @email  leishaobo_cafe@163.com
 * @createime 2016年7月16日
 */
public class Seachable {
	
	public static Seachable newSeachable() {
		return new SeachRequest();
	}
	
	public static Seachable newSeachable(String key,String value) {
		return new SeachRequest(key,value);
	}
	
	public static Seachable newSeachable(Map<String,String> params) {
		return new SeachRequest(params);
	}

	
	
	
}
