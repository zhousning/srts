package com.srts.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public  class CommonTest {
	protected static ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
}
