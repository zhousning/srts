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


public class OnlineCourseManageServiceTest {
	private ApplicationContext act;
	private OnlineCourseManageService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (OnlineCourseManageService) act.getBean("onlineCourseManageServiceImpl");
	}
	
	@Test
	public void test1(){
		init();
		List<Book> book = (List<Book>) service.getOnlineCourseInfoByPage(1, "BOOK");
		List<OnlineCoursePPT> ppt = (List<OnlineCoursePPT>) service.getOnlineCourseInfoByPage(1,"PPT");
		List<OnlineCourseVideo> video = (List<OnlineCourseVideo>) service.getOnlineCourseInfoByPage(1, "VIDEO");

		System.out.println(book.size());
		System.out.println(video.size());
		System.out.println(ppt.size());
	}
	
	@Test
	public void test2(){
		init();
		Long b = service.getOnlineCourseTotalPages("BOOK");
		Long p = service.getOnlineCourseTotalPages("PPT");
		Long v = service.getOnlineCourseTotalPages("VIDEO");
		System.out.println(b);
		System.out.println(p);
		System.out.println(v);
	}
	
	@Test
	public void test3(){
		init();
		String s = service.getOnlineCourseCountByType();
		System.out.println(s);
	}
	
	@Test
	public void test4(){
		init();
		OnlineCourseInfoPo po = service.getOnlineCourseByTypeAndID("1", "BOOK");
		System.out.println(po.getBookInfo().getBookIcon());
	}
	
	@Test
	public void test5(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(new Date()));
	}
	
	@Test
	public void test6(){
		init();
		service.getAllChapterFromCourseDoc(null,null);
	}
	
	@Test
	public void test7(){
		try {
			WordExtractor we = new WordExtractor(new FileInputStream(new File("C:\\apache-tomcat-6.0.41\\webapps\\srts\\resource\\templete\\learning\\doc\\bookuploadtemplete.doc")));
			String tfp = we.getTextFromPieces();
			String[] pt = we.getParagraphText();
			for(String str:pt){
				if(str!=null){
					if(str.startsWith("@")){
						String[] a = str.split("[$]");
						System.out.println(a[1]);
						System.out.println(a[2]);
					}
					if(str.startsWith("&")){
						String[] a = str.split("&#");
						System.out.println(a[0].split("[&]")[1]);
						if(a[1].contains("#@\r\n")){
							System.out.println(a[1].split("[#@]")[0]);
						}else{
							System.out.println(a[1].substring(1, (a[1].length()-3)));
						}
					}
					if(str.startsWith("#")){
						if(str.contains("#@\r\n")){
							System.out.println(str.split("[#@]")[0]);
						}else{
							System.out.println(str.substring(1, (str.length()-3)));
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test8(){
		init();
		Set<BookChapter> set = service.getAllChapterFromCourseDoc(null, null);
		System.out.println(set.toString());
	}
	
	@Test
	public void test9(){
		
	}
	
}
