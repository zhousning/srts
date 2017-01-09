package com.srts.learning.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.dao.OnlineCourseDao;
import com.srts.system.domain.Sys_User;


public class OnlineCourseDaoTest {
	private ApplicationContext act;
	private OnlineCourseDao dao;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (OnlineCourseDao) act.getBean("onlineCourseDaoImpl");
	}
	@Test
	public void getAllCourseTest(){
		init();
		List<OnlineCoursePPT> ppts = dao.getAllOnlineCoursePPT();
		List<OnlineCourseVideo> videos = dao.getAllOnlineCourseVideo();
		for(OnlineCoursePPT ppt:ppts){
			System.out.println(ppt.getPptName());
			System.out.println("------------------------");
		}
		for(OnlineCourseVideo video:videos){
			//System.out.println(video.getUsr().getName());
			System.out.println("------------------------");
		}
	}
	@Test 
	public void test1(){
		init();
		List<BookChapter> list = dao.getBookChapters(1l);
		OnlineCoursePPT ppt = dao.getPptByPptId(1l);
		OnlineCourseVideo vieo = dao.getVideoByID(1l);
		for(BookChapter bc:list){
			System.out.println(bc.getChapterName());
		}
		System.out.println(ppt.getPptName());
		System.out.println(vieo.getVideoName());
	}
	@Test
	public void test3(){
		init();
		List<OnlineCourseVideo> videos = dao.getTop6Video();
		for(OnlineCourseVideo video:videos){
			System.out.println(video.getId());
		}
	}
	@Test
	public void insertIntoMyStudyCourseTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res=dao.insertIntoMyStudyCourse(20, usr, "2014-11-13|20","国家电网公司安全生产反违章工作管理办法", 1, "2014-10-01", "2014-11-30", "2014-11-13", 1);
		System.out.println(res);
	}
	@Test
	public void updateBookViewCountTest()
	{
		init();
		int res=dao.updateBookViewCount(1);
		System.out.println(res);
	}
	@Test
	public void updateVideoViewCountTest()
	{
		init();
		int res=dao.updateVideoViewCount(1);
		System.out.println(res);
	}
	@Test
	public void test9()
	{
		init();
		long id=dao.selectTrainIdByNoticeId(91);
		System.out.println(id);
	}
}
