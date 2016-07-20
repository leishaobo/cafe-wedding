package com.cafe.wedding.editor;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceEditor;

public class Editor {

	@Test
	public void testResouceEditor() {
		ResourceEditor resourceEditor=new ResourceEditor();
		resourceEditor.setAsText("classpath:test.properties");
		Object value=resourceEditor.getValue();
		if(value instanceof ClassPathResource){
			Resource classPathResource=(ClassPathResource)value;
		}
	}

}
