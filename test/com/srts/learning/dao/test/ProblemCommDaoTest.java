package com.srts.learning.dao.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.communication.dao.ProblemCommDao;
import com.srts.communication.po.CommonUser;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.dao.StudyCourseDao;
import com.srts.learning.service.StudyCourseService;


public class ProblemCommDaoTest {
	private ApplicationContext act;
	private ProblemCommDao dao;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (ProblemCommDao) act.getBean("problemCommDaoImpl");
	}
	@Test
	public void findAllBooks(){
		init();
		List list = dao.getProblemCountTop5();
		Iterator iterator = list.iterator();
		List<CommonUser> userList = new ArrayList<CommonUser>();
		while(iterator.hasNext()){
			Object[]objects = (Object[]) iterator.next();
			String count = objects[0].toString();
			String id = objects[1].toString();
			String name = objects[2].toString();
			CommonUser usr = new CommonUser(name,count);
			userList.add(usr);
		}
		
	}
}
