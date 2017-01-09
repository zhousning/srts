package com.srts.learning.dao.test;

import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.learning.dao.StudyCourseDao;
import com.srts.learning.po.StudyBookInfoPo;
import com.srts.learning.po.StudyChapterInfoPo;
import com.srts.learning.po.StudyChapterStatusPo;
import com.srts.learning.service.StudyCourseService;

public class StudyCourseDaoTest {
	private ApplicationContext act;
	private StudyCourseDao dao;
	private StudyCourseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (StudyCourseDao) act.getBean("studyCourseDaoImpl");
		service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
	}
	@Test
	public void findAllBooks(){
		init();
		List<Book> books = dao.findAll();
		for(Book book:books){
			System.out.println(book.getBookIcon());
			System.out.println(book.getBookName());
			System.out.println(book.getId());
			for(BookChapter chapter:book.getChapters()){
				System.out.println(chapter.getChapterNum()+chapter.getChapterName());
			}
		}
	}
	@Test
	public void getBookInfo(){
		/*chapterId,status,myStudyCourseId,bookId, bookName,startTime,endTime,sumTime,lastStudyTime*/
//		init();
//		List list= dao.getMyStudyBookInfo(4);
//		Iterator iterator = list.iterator();
//		String currentBookId = "";
//		while(iterator.hasNext()){
//			Object[] objs = (Object[]) iterator.next();
//			currentBookId = objs[0].toString();
//			System.out.println(currentBookId);
//			for(Object obj:objs){
//				
//			}
//		}
	}
	@Test
	public void getChapterCount(){
		init();
		List list = dao.getBookChapterCount();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				System.out.println(ojb.toString());
			}
		}
	}
	@Test
	public void getStudyChapterCount(){
		init();
		List list = dao.getStudyBookChapterCount(4);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				System.out.println(ojb.toString());
			}
		}
	}
	@Test
	public void getStudyTotalTime(){
		init();
		List list = dao.getStudyTotalTime(4);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				System.out.println(ojb.toString());
			}
		}
	}
	
	@Test
	public void getMyStudyCourseScheduleTest(){
		init();
		String str = service.getMyStudyCourseSchedule(4);
		System.out.println(str);
	}
	@Test
	public void getMyStudyCourseSumTimeTest(){
		init();
		String str = service.getMyStudyCourseSumTime(4);
		System.out.println(str);
	}
	
	@Test
	public void getMyStudyTimeCount(){
		init();
		Integer num = dao.getStudyCourseNumCount(4, "2014-07%");
		System.out.println(num);
	}
	
	@Test
	public void getMyStudySumCount(){
		init();
		String string = service.getMyStudyCourseNumCount(4, "2014");
		System.out.println(string);
	}
	
	
	@Test
	public void getMyStudyBookInfo(){
		init();
		List list = dao.getMyStudyCourseBookInfo(4);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[]objects = (Object[]) iterator.next();
			for(Object object:objects){
				System.out.println(object.toString());
			}
		}
	}
	
	@Test
	public void getMyStudyChapterInfo(){
		init();
		List list = dao.getMyStudyCourseChapterInfo(4,1);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[]objects = (Object[]) iterator.next();
			for(Object object:objects){
				System.out.println(object.toString());
			}
		}
	}
	
	@Test
	public void getMyStudyBookTest(){
		init();
		List<StudyBookInfoPo> books = service.getMyStudyBookInfo(4);
		for(StudyBookInfoPo book:books){
			System.out.println(book.getBookIcon());
			System.out.println(book.getBookId());
			System.out.println(book.getBookName());
			System.out.println(book.getSchedule());
			System.out.println("------");
		}
	}
	
	@Test
	public void getMyStudyBookCountById(){
		init();
		int sum = dao.getBookChapterCountById(1);
		int count = dao.getStudyBookChapterCountById(1, 4);
		int schedule = (int)((Float.parseFloat(3+"")/Float.parseFloat(7+""))*100);
		System.out.println(schedule);
		System.out.println(sum+"----"+count);
	}
	
	@Test
	public void getMyStudyBookCountByIdService(){
//		init();
//		int sum = service.getBookScheduleById(1, 4);
//		System.out.println(sum);
	}
	
	@Test
	public void getMyStudyBookInfoTest(){
		//scc.chapterId,bc.chapterNum,bc.chapterName,scc.status,msc.sumTime,msc.startTime,msc.endTime,bk.id bookId,schedule
		init();
		List<StudyChapterInfoPo> chapterInfoPos = service.getMyStudyChapterInfo(4,1);
		for(StudyChapterInfoPo po:chapterInfoPos){
			System.out.println(po.getChapterId());
			System.out.println(po.getChapterNum());
			System.out.println(po.getChapterName());
			System.out.println(po.getStatus());
			System.out.println(po.getSumTime());
			System.out.println(po.getStartTime());
			System.out.println(po.getEndTime());
			System.out.println("book_ID:"+po.getBookId());
			System.out.println("进度"+po.getSchedule());
			System.out.println("--------------");
		}
	}
	
	@Test
	public void getMyStudyCourseInfoTest(){
		init();
		List<StudyChapterInfoPo> infos = service.getMyStudyChapterInfo(4,1);
		for(StudyChapterInfoPo po:infos){
			System.out.println(po.getChapterId());
			System.out.println(po.getChapterNum());
			System.out.println(po.getChapterName());
			System.out.println(po.getStatus());
			System.out.println(po.getStartTime());
			System.out.println(po.getEndTime());
			System.out.println(po.getBookId());

		}
	}
	@Test
	public void getMyStudyBookInSercide(){
		init();
		List<StudyBookInfoPo> pos = service.getMyStudyBookInfo(4);
		for(StudyBookInfoPo po:pos){
			System.out.println(po.getSchedule());
			System.out.println(po.getBookIcon());
			System.out.println(po.getBookName());
		}
	}
	///////////////////////////////////////////////
	@Test
	public void testGetBookChapter(){
		init();
		List<BookChapter> list = dao.getBookChapters(1);
		for(BookChapter chapter:list){
			System.out.println(chapter.getId());
			System.out.println(chapter.getChapterNum());
			System.out.println(chapter.getChapterName());
			System.out.println("bookID"+chapter.getBook().getId());
		}
	}
	@Test
	public void testgetBookByStatusFinishOrUndone(){
		init();
		List list = dao.getBookChapterStatusByFinishOrUndone(4, 1, "完成");
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[]objects = (Object[]) iterator.next();
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println(objects[2]);
		}
	}
	
	@Test
	public void testgetBookChapterContents(){
		init();
		List<BookChapterContent> list = dao.getBookChapterContents(1);
		for(BookChapterContent content:list){
			System.out.println(content.getId());
			System.out.println(content.getContentName());
			System.out.println(content.getContent());
		}
	}
	
	@Test
	public void testgetBookChapterSchedule(){
		init();
		List<StudyChapterStatusPo> pos= service.getBookChapterSchedule(4,1);
		for(StudyChapterStatusPo po:pos){
			System.out.println(po.getChapterID());
			System.out.println(po.getChapterNum());
			System.out.println(po.getChapterName());
			System.out.println(po.getChapterStatus());
		}
	}
	@Test
	public void testgetStudyBookOtherChapter(){
		init();
		List<BookChapterContent> list = service.getStudyBookOtherChapter(1,4);
		System.out.println(list.size());
//		for(BookChapterContent content:list){
//			System.out.println(content.getId());
//			System.out.println(content.getContentName());
//			System.out.println(content.getContent());
//			System.out.println("----------------------");
//		}
	}
	@Test
	public void testgetStudyBookOtherChapterUndo(){
		init();
		List<BookChapterContent> list = dao.getStudyBookOtherChapterUndo(1,4);
		System.out.println(list.size());
		for(BookChapterContent content:list){
			System.out.println(content.getId());
			System.out.println(content.getContentName());
			System.out.println(content.getContent());
			System.out.println("----------------------");
		}
	}
	@Test
	public void testgetStudyBookOtherChapterUndoService(){
		init();
		List<BookChapterContent> list = service.getStudyBookOtherChapter(1,4);
		System.out.println(list.size());
		for(BookChapterContent content:list){
			System.out.println(content.getId());
			System.out.println(content.getContentName());
			System.out.println(content.getContent());
			System.out.println("----------------------");
		}
	}
}
