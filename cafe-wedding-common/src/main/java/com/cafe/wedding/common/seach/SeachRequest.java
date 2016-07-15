package com.cafe.wedding.common.seach;

import java.util.LinkedList;
import java.util.List;

import com.cafe.wedding.common.seach.support.SeachFilter;

public class SeachRequest implements Seachable {
	private List<SeachFilter> filters=new LinkedList<SeachFilter>();
}
