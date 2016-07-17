package com.cafe.wedding.common.seach;

import java.util.Map;

import com.cafe.wedding.common.seach.support.Operation;

/**
 * seachable.name_eq=leishaobo&seachable.age_glt=24
 * 查询名字=leishaobo && 年龄大于 24岁的
 * @author leishaobo
 * @email  leishaobo_cafe@163.com
 * @createime 2016年7月16日
 */
public interface Seachable {
	public String getQueryWhereCondition();
	
	public Map<Integer,String> getQueryWhereConditionValues();
}
