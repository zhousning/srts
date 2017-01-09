package com.srts.learning.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.dao.OnlineCourseManageDao;
import com.srts.learning.po.OnlineCourseInfoPo;
import com.srts.system.domain.Sys_User;


public class OnlineCourseServiceTest {
	private ApplicationContext act;
	private OnlineCourseService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (OnlineCourseService) act.getBean("onlineCourseServiceImpl");
	}
	
	@Test
	public void insertIntoMyStudyCourseTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		String res=service.insertIntoMyStudyCourse(30, usr, 1, 1);
		System.out.println(res);
	}
}
