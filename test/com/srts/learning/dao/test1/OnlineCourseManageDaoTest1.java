package com.srts.learning.dao.test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.dao.OnlineCourseManageDao;

public class OnlineCourseManageDaoTest1 {
	private ApplicationContext act;
	private OnlineCourseManageDao dao;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (OnlineCourseManageDao) act.getBean("onlineCourseManageDaoImpl");
	}
	
	@Test
	public void test1(){
		init();
		List<Book> book = dao.getOnlineCourseBookInfo(0, 4);
		List<OnlineCourseVideo> video = dao.getOnlineCourseVideoInfo(0, 4);
		List<OnlineCoursePPT> ppt = dao.getOnlineCoursePPTInfo(0, 4);
		
		System.out.println(book.size());
		System.out.println(video.size());
		System.out.println(ppt.size());
	}
	
	@Test
	public void test2(){
		init();
		Long b = dao.getBookCount();
		Long p = dao.getPptCount();
		Long v = dao.getVideoCount();
		System.out.println(b);
		System.out.println(p);
		System.out.println(v);
	}
	
	@Test
	public void test3(){
		init();
		Long p = dao.getPptLoadCount();
		Long b = dao.getVideoLoadCount();
		System.out.println(b);
		System.out.println(p);
	}
	
	@Test
	public void test4(){
		init();
		List<Long>ids = new ArrayList<Long>();
		ids.add(80L);
		ids.add(79L);
		ids.add(78L);
		//System.out.println(dao.deleteBookByIds(ids));
	}
	
	@Test
	public void test5(){
		init();
		Book book = dao.getBookInfoById(1L);
		OnlineCoursePPT ppt = dao.getPptInfoById(1L);
		OnlineCourseVideo video = dao.getVideoInfoById(1L);
		
		System.out.println(book.getBookName());
		System.out.println(ppt.getPptName());
		System.out.println(video.getVideoName());
	}
	
	@Test
	public void test6(){
		init();
		Book book = new Book();
		book.setBookName("更改了");
		book.setBookIntro("这是消息");
		boolean a = dao.updateBookInfoById(77L,book);
		System.out.println(a);
	}
	
	@Test
	public void test7(){
		init();
		Book book = new Book();
		book.setBookName("book");
		book.setBookIcon("");
		book.setBookIntro("");
		book.setDate("");
		book.setUploadUsr("");
		book.setViewCount(0);
		
		BookChapter chapter1 = new BookChapter();
		chapter1.setChapterName("chapter1");
		chapter1.setChapterNum("");
		
		BookChapter chapter2 = new BookChapter();
		chapter1.setChapterName("chapter2");
		chapter1.setChapterNum("");
		
		Set<BookChapter> chapterSet = new HashSet<BookChapter>();
		chapterSet.add(chapter1);
		chapterSet.add(chapter2);
		
		
		BookChapterContent content1 = new BookChapterContent();
		content1.setContentName("content1");
		content1.setContent("");
		
		BookChapterContent content2 = new BookChapterContent();
		content2.setContentName("content2");
		content2.setContent("");
		
		Set<BookChapterContent> contentSet = new HashSet<BookChapterContent>();
		contentSet.add(content1);
		contentSet.add(content2);
		
		chapter1.setContents(contentSet);
		chapter2.setContents(contentSet);
		book.setChapters(chapterSet);
		
		dao.addBookInfo(book);
	}
}
