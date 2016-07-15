package com.cafe.wedding.common.seach.support;

import java.util.LinkedList;
import java.util.List;

public class OrCondition  implements SeachFilter{
	private  List<SeachFilter> orFilters=new LinkedList<SeachFilter>();
}
