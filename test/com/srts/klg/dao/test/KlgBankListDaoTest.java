package com.srts.klg.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.dao.KlgBankListDao;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.dao.ErrorSetDao;
import com.srts.learning.dao.StudyCourseDao;
import com.srts.learning.po.ErrorSetAnswerPo;
import com.srts.learning.service.ErrorSetService;
import com.srts.learning.service.StudyCourseService;
import com.srts.system.domain.Sys_User;

public class KlgBankListDaoTest {
	private ApplicationContext act;
	private KlgBankListDao dao;
	//private StudyCourseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (KlgBankListDao) act.getBean("klgBankListDaoImpl");
		//service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
	}
	@Test
	public void listTopFiveRuleTest(){
		init();
		List list = dao.listTopFiveRule();
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
	public void listTopFiveViolationTest(){
		init();
		List list = dao.listTopFiveViolation();
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
	public void listTopOneCaseTest(){
		init();
		List list = dao.listTopOneCase();
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
	public void listTopOneOperateSheetTest(){
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List list = dao.listTopOneOperateSheet();
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
	public void listTopOneWorkSheetTest(){
		/*chapterId,status,myStudyCourseId,bookId, bookName,startTime,endTime,sumTime,lastStudyTime*/
		init();
		List list = dao.listTopOneWorkSheet();
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
	public void searchKlgBankByTypeAndKeyWordsTest(){
		/*chapterId,status,myStudyCourseId,bookId, bookName,startTime,endTime,sumTime,lastStudyTime*/
		init();
		String type="条文导学";
		String keyWords="违章";
		List list = dao.searchKlgBankByTypeAndKeyWords(type, keyWords);
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
	public void findFavorRuleByUserTest(){
		init();
		Sys_User user =new Sys_User();
		user.setId(1);
		List list = dao.findFavorRuleByUser(user);
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
	public void findPopKlgBankTest(){
		init();
		List list = dao.findPopKlgBank();
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
	public void findSearchnumByMonthTest(){
		init();
		List list = dao.findSearchnumByMonth();
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
	
}
