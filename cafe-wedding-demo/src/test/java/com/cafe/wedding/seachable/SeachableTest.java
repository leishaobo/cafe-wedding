package com.cafe.wedding.seachable;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.vafe.wedding.demo.seachable.User;

public class SeachableTest {

	@Test
	public void test() {
		BeanWrapper userBeanWrapper=new BeanWrapperImpl(User.class);
		userBeanWrapper.setPropertyValue("age", "23");
		System.out.println(userBeanWrapper.getPropertyValue("age"));
		System.out.println(userBeanWrapper);
	}


}
