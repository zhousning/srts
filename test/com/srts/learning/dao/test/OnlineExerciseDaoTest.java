package com.srts.learning.dao.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.dao.OnlineExerciseDao;
import com.srts.learning.service.OnlineExerciseService;


public class OnlineExerciseDaoTest {
	private ApplicationContext act;
	private OnlineExerciseDao dao;
	private OnlineExerciseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (OnlineExerciseDao) act.getBean("onlineExerciseDaoImpl");
		service = (OnlineExerciseService)act.getBean("onlineExerciseServiceImpl");
	}
	@Test
	public void test1(){
		init();
		List<Long> n = new ArrayList<Long>();
		n.add(1L);
		n.add(2L);
		n.add(3L);
		n.add(4L);
		n.add(5L);
		n.add(6L);
		n.add(7L);
		List<QuestionBank> list = dao.getChapterQuestionsByChapterID(11, n);
		for(QuestionBank b :list){
			System.out.println(b.getId()+"===="+b.getContent());
		}
		
		
		String a = "1,2,3,4,5,6";
		String[]aa = a.split("[,]");
		for(String aaa:aa){
			System.out.println(aaa);
			System.out.println("-------");
		}
		
		List<Long> m = new ArrayList<Long>();
		System.out.println(m.size()+"--------------");
		m.addAll(n);
		System.out.println(m.size()+"--------------");
	}
	@Test
	public void test2(){
		init();
		List<QuestionBank> list = service.getQuestionsByChpaterIdAndType(10,"1","1,2,3,4,5,6,7");
		for(QuestionBank ques:list){
			System.out.print(ques.getId()+"--|--");
			System.out.print(ques.getContent()+"--|--");
		}
	}
	@Test
	public void test3(){
		init();
		List<Book> books = service.getAllBooks();
		System.out.println(books.size()+"-------");
		List<BookChapter> chapters = service.getBookChaptersByBookID(books.get(0).getId());
		for(BookChapter book : chapters){
			System.out.println(book.getId());
		}
	}
	
	@Test
	public void test4(){
		int a = 10;
		int b = 3;
		int c = a/b;
		System.out.println(c);
	}
}
