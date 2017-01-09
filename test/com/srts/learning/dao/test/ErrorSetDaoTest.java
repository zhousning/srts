package com.srts.learning.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.dao.ErrorSetDao;
import com.srts.learning.dao.StudyCourseDao;
import com.srts.learning.po.ErrorSetAnswerPo;
import com.srts.learning.service.ErrorSetService;
import com.srts.learning.service.StudyCourseService;
import com.srts.system.domain.Sys_User;

public class ErrorSetDaoTest {
	private ApplicationContext act;
	private ErrorSetDao dao;
	//private StudyCourseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (ErrorSetDao) act.getBean("errorSetDaoImpl");
		//service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
	}
	@Test
	public void findAllErrorSetByIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List list = dao.findAllErrorSetById(usr);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
					System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findTopFlagFiveErrorSetById(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List list = dao.findTopFlagFiveErrorSetById(usr);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
					System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findByErrorSetFlagUsrIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List list = dao.findByErrorSetFlagUsrId(usr,2);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
					System.out.println(ojb.toString());

				}
			}
		}
	}
	@Test
	public void findByLastTestTimeUsrIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List list = dao.findByLastTestTimeUsrId(usr,"2014-04-30");
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
					System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findByTestTimeUsrIdTest(){
		/*chapterId,status,myStudyCourseId,bookId, bookName,startTime,endTime,sumTime,lastStudyTime*/
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List list = dao.findByTestTimeUsrId(usr,"2014-04");
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findByErrorSetTypeUsrIdTest(){
		/*chapterId,status,myStudyCourseId,bookId, bookName,startTime,endTime,sumTime,lastStudyTime*/
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List list = dao.findByErrorSetTypeUsrId(usr,"单选题");
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void countAllErrorSetByUsrIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res = dao.countAllErrorSetByUsrId(usr);
		System.out.println(res);
	}
	@Test
	public void countByErrorSetFlagUsrIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res = dao.countByErrorSetFlagUsrId(2,usr);
		System.out.println(res);
	}
	@Test
	public void countByErrorSetTypeUsrIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res = dao.countByErrorSetTypeUsrId("单选题",usr);
		System.out.println(res);
	}
	@Test
	public void countByTestTimeUsrIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res = dao.countByTestTimeUsrId(usr,"2014-04");
		System.out.println(res);
	}
	
	@Test
	public void sumErrorSetFlagByUsrIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res = dao.sumErrorSetFlagByUsrId(usr);
		System.out.println(res);
	}
	@Test
	public void updateFiByIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res = dao.updateFiById(usr,1);
		System.out.println(res);
	}
	
	@Test
	public void updateFdByIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res = dao.updateFiById(usr,1);
		System.out.println(res);
	}
	
	@Test
	public void insertErrorSetTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int flag = 2;
		String lastTestTime="2014-10-01";
		QuestionBank question=new QuestionBank();
		question.setId(12);
		int res = dao.insertErrorSet(usr,flag,lastTestTime,question);
		System.out.println(res);
	}
	
	@Test
	public void deleteByIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res = dao.deleteById(usr,29);
		System.out.println(res);
	}
	@Test
	public void updateLastTestTimeByIdTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res = dao.updateLastTestTimeById(usr,1,"2014-05-14");
		System.out.println(res);
	}
	@Test
	public void findAnswerByQuestionIdTest()
	{
		init();
		String res=dao.findAnswerByQuestionId(1);
		System.out.println(res);
		
	}
	@Test
	public void findQuestionTypeByQuestionIdTest()
	{
		init();
		String res=dao.findQuestionTypeByQuestionId(1);
		System.out.println(res);
		
	}
	@Test
	public void findErrorSetIdByQuestionIdAndUsrIdTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		long res=dao.findErrorSetIdByQuestionIdAndUsrId(usr,1);
		System.out.println(res);
		
	}
	@Test
	public void findFlagByErrorSetIdTest()
	{
		long errorSetId=1;
		init();
		int res=dao.findFlagByErrorSetId(errorSetId);
		System.out.println(res);
	}
	@Test
	public void testService(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		ErrorSetService errorSetService = (ErrorSetService) act.getBean("errorSetServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		String str = errorSetService.getCountByErrorSetFlagUsrId(usr);
		System.out.println(str);
	}
	@Test
	public void testFindByFlagService(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		ErrorSetService errorSetService = (ErrorSetService) act.getBean("errorSetServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		List<String[]> res = errorSetService.findByErrorSetFlagUsrId(usr, 2);
		System.out.println(res.size());
		Iterator iterator = res.iterator();
		while(iterator.hasNext()){
			String[] objs = (String[]) iterator.next();
			for(String ojb:objs){
				if(ojb!=null){
				System.out.println(ojb);
				}
			}
		}
	}
	@Test
	public void testFindByLastTestTimeService(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		ErrorSetService errorSetService = (ErrorSetService) act.getBean("errorSetServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		List<String[]> res = errorSetService.findByLastTestTimeUsrId(usr, "2014-04-30");
		Iterator iterator = res.iterator();
		while(iterator.hasNext()){
			String[] objs = (String[]) iterator.next();
			for(String ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void testFindByTypeService(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		ErrorSetService errorSetService = (ErrorSetService) act.getBean("errorSetServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		List<String[]> res = errorSetService.findByErrorSetTypeUsrId(usr, "单选题");
		Iterator iterator = res.iterator();
		while(iterator.hasNext()){
			String[] objs = (String[]) iterator.next();
			for(String ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void judgeTheAnswerTest()
	{
		ErrorSetAnswerPo errorSetAnswerPo=new ErrorSetAnswerPo();
		errorSetAnswerPo.setErrorSetQuestionId("1");
		errorSetAnswerPo.setErrorSetQuestionAnswer("A");
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		ErrorSetService errorSetService = (ErrorSetService) act.getBean("errorSetServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		String res=errorSetService.judgeTheAnswer(usr, errorSetAnswerPo);
		System.out.println(res);
		
	}
	@Test
	public void findErrorSetSimpilfiedDisplayedByIdTest(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		ErrorSetService errorSetService = (ErrorSetService) act.getBean("errorSetServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		List<String[]> res = errorSetService.findErrorSetSimpilfiedDisplayedById(usr);
		Iterator iterator = res.iterator();
		while(iterator.hasNext()){
			String[] objs = (String[]) iterator.next();
			for(String ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void deleteByQIdTest(){
		init();
		int res = dao.deleteByQuestionId(5);
		System.out.println(res);
	}
}
