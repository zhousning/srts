package com.srts.learning.dao.test1;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.information.domain.TrainNotice;
import com.srts.learning.dao.OnlineCourseTraceManageDao;
import com.srts.learning.po.OnlineCourseTracePo;


public class OnlineCourseTraceDaoTest {
	private ApplicationContext act;
	private OnlineCourseTraceManageDao dao;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (OnlineCourseTraceManageDao) act.getBean("onlineCourseTraceManageDaoImpl");
	}
	
	@Test
	public void test1(){
		init();
		List<Object[]> list = dao.getAllUserStudyTrace(2014, 7);
		OnlineCourseTracePo po = new OnlineCourseTracePo();
		Long t1 = System.currentTimeMillis();
		List<OnlineCourseTracePo> poList = po.getCourseTracePo(list);
		System.out.println(poList.get(0).getUsrName());
		Long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}
	
	@Test
	public void test2(){
		System.out.println(new Date().getYear()+1900);
		System.out.println(new Date().getMonth()+1);
	}
	
	@Test
	public void test3(){
		init();
		List<Object[]> list = dao.getAllUserCourseTrace(2014, 7, 0, 8);
		OnlineCourseTracePo po = new OnlineCourseTracePo();
		List<OnlineCourseTracePo> poList = po.getCourseTracePo(list);
		for(OnlineCourseTracePo pot:poList){
			System.out.println(pot.getUsrId());
			System.out.println(pot.getUsrName());
			System.out.println(pot.getUsrMajor());
			System.out.println(pot.getUsrCompany());
			System.out.println(pot.getStudyCourse());
			System.out.println(pot.getStudyTime());
			System.out.println(pot.getMyStudyCourseId());
			System.out.println(pot.getStudyRecoder());
		}
		int num = dao.getUsrCourseTraceCount(new Date().getYear()+1900,new Date().getMonth()+1);
		System.out.println(num+"num");
	}
	
	@Test
	public void test4(){
		init();
		List<TrainNotice> notices = dao.getOnlineCourseNoticeTitle(2014);
		System.out.println(notices.get(0).getNoticeTitle());
	}
	
	@Test
	public void test5(){
		init();
		List<TrainNotice> notices = dao.getOnlineCourseNoticeTitle(2013);
		System.out.println(notices==null?"y":"n");
	}
	
	@Test
	public void test6(){
		init();
		Map<String,String> options = new HashMap<String,String>();
		options.put("w", "宋晨");
		options.put("n", "检修试验工区");
		options.put("g", "2014年7月份安全规程学习");
		String optionMatch = "w n g ";
		int max = 6;
		int min = 0;
		List<Object[]> list = dao.getUserStudyTraceQueryByOptions(2014, 7, options, optionMatch, max, min);
		System.out.println(list);
	}
	
	@Test
	public void test7(){
		init();
		long userID = 4;
		int noticeYear = 2014;
		int noticeMonth = 7;
		String noticeTitle = "2014年7月份安全规程学习";
		String m = dao.getUserOnlineCourseTraceRecord(userID, noticeYear, noticeMonth, noticeTitle);
		System.out.println(m);
	}
	
	@Test
	public void test8(){
		init();
		BigDecimal a = dao.getMonthStudyTimeCount(2014,3);
		System.out.println(a==null?"0":a.intValue());
	}
	
}
