package com.srts.learning.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.learning.dao.ErrorSetDao;
import com.srts.learning.dao.ErrorSetFlagSumDao;
import com.srts.learning.domain.ErrorSetFlagSum;
import com.srts.learning.service.ErrorSetService;
import com.srts.system.domain.Sys_User;

public class ErrorSetFlagSumDaoTest {
		private ApplicationContext act;
		private ErrorSetFlagSumDao dao;
		//private StudyCourseService service;
		
		public void init(){
			act = new ClassPathXmlApplicationContext("applicationContext.xml");
			dao = (ErrorSetFlagSumDao) act.getBean("errorSetFlagSumDaoImpl");
			//service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
		}
		@SuppressWarnings("unchecked")
		@Test
		public void findErrorSetFlagSumByIdTest()
		{
			init();
			Sys_User usr=new Sys_User();
			usr.setId(1);
			List<ErrorSetFlagSum> list = null;
			
			list = dao.findErrorSetFlagSumById(usr);
			
			for(ErrorSetFlagSum sum:list){
				System.out.println(sum.getFlagSum());
			}
			
//			Iterator iterator = list.iterator();
//			while(iterator.hasNext()){
//				Object[] objs = (Object[]) iterator.next();
//				for(Object ojb:objs){
//					if(ojb!=null){
//						System.out.println(ojb.toString());
//					}
//				}
//			}
		}
		@Test
		public void insertErrorSetFlagSum()
		{
			init();
			int flagSum=23;
			String TimePoint="2014-05-21";
			Sys_User usr=new Sys_User();
			usr.setId(2);
			int res = dao.insertErrorSetFlagSum(flagSum,TimePoint,usr);
			System.out.println(res);
		}
		
		@Test
		public void getFindErrorSetFlagSumByIdTest(){
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			ErrorSetService service =  (ErrorSetService) ctx.getBean("errorSetServiceImpl");
			Sys_User usr = new Sys_User();
			usr.setId(1);
			String str =service.getFindErrorSetFlagSumById(usr) ;
			System.out.println(str);
		}
}
