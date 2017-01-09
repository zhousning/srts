package com.srts.learning.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.learning.po.OnlineCourseTracePo;

public class OnlineCourseTraceManageServiceTest {
	private ApplicationContext act;
	private OnlineCourseTraceManageService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (OnlineCourseTraceManageService) act.getBean("onlineCourseTraceManageServiceImpl");
	}
	
	@Test
	public void test1(){
		String usrName = "0";
		String majorName = null;
		String companyName = "2";
		String noticeTitle = "3";
		List<String> options = new ArrayList<String>();
		String optionMatch="";
		if(usrName!=null){
			options.add(options.size(), usrName);
			optionMatch+="w ";
		}
		if(majorName!=null){
			options.add(options.size(),majorName);
			optionMatch+="a ";
		}
		if(companyName!=null){
			options.add(options.size(),companyName);
			optionMatch+="n ";
		}
		if(noticeTitle!=null){
			options.add(options.size(),noticeTitle);
			optionMatch+="g ";
		}
		System.out.println(optionMatch);
	}
	@Test
	public void test2(){
		String match="w a ";
		String[]matchs = match.split(" ");
		System.out.println(matchs.length);
		for(String m:matchs){
			System.out.println(m+"--");
		}
	}
	
	@Test
	public void test3(){
		init();
		int pageNum = 1;
		int noticeYear = 2014;
		int noticeMonth = 7;
		String usrName = "宋晨";
		String majorName = null;
		String companyName = "检修试验工区";
		String noticeTitle = "2014年7月份安全规程学习";
		List<OnlineCourseTracePo> poList = service.getCourseTraceQueryByOptions(pageNum, noticeYear, noticeMonth, usrName, majorName, companyName, noticeTitle);
		System.out.println(poList.toString());
	}
	
	@Test
	public void test4(){
		init();
		String m = service.getMonthStudyTimeCount(2014);
		System.out.println(m);
	}
}
