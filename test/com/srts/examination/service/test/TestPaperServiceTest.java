package com.srts.examination.service.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.service.TestPaperService;

public class TestPaperServiceTest {
	private ApplicationContext act;
	private TestPaperService testPaperService;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		testPaperService =(TestPaperService) act.getBean("testPaperServiceImpl");	
	}
	
 @Test
	public void getPaperByTestInfoId(){
		init();
	TestPaper testPaper=null;
	testPaper=testPaperService.geTestPaperByTestInfoID(3l);
	System.out.println(testPaper.getContent());
	}
 
 
 
 /**
	 * 获取考试试卷相关信息
	 */
 @Test
	public void getTestPaperMap() {
		init();
		String questionIds="110,276,213,118,299,272,235,263,134,73,8,346,2,321,300,289,142,202,29,80,196,374,197,155,151,173,158,370,359,191,697,698,700,695,699";
		long testPaperId=128l;
		List<?> list=testPaperService.getQuesByIds(questionIds,testPaperId);
		Map<String, Object[]> map=new LinkedHashMap<String, Object[]>();
		
		Iterator<?> iterator=list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
		 map.put(object[1].toString(), null);	
		}
		
		for(String key:map.keySet()){
			Iterator<?> iterator2=list.iterator();
			int i=0;
			int score=0;
			List<QuestionBank> banks=new ArrayList<QuestionBank>();
			
			while (iterator2.hasNext()) {
				Object[] object = (Object[]) iterator2.next();
				QuestionBank questionBank=new QuestionBank();
				questionBank.setId(Long.parseLong(object[0].toString()));
				questionBank.setContent(object[2].toString());
				questionBank.setAnswer(object[3].toString());
				questionBank.setQuestionPic(object[5].toString());
				if (key.equals(object[1].toString())) {
					i++;
					banks.add(questionBank);
					score=Integer.parseInt(object[11].toString());
				}
			}
			Object[] objects={i,score,i*score,banks};
			
		map.put(key, objects);
		}
		
		Set<Map.Entry<String,Object[]>> set=map.entrySet();
		Iterator<Map.Entry<String, Object[]>> iterator2=set.iterator();
		while (iterator2.hasNext()) {
			Map.Entry<java.lang.String, java.lang.Object[]> entry = (Map.Entry<java.lang.String, java.lang.Object[]>) iterator2
					.next();
			System.out.println(entry.getKey()+"----->>>>"+entry.getValue()[0]+":"+entry.getValue()[1]+":"+entry.getValue()[2]+":");
			List<QuestionBank> questionBanks=(List<QuestionBank>) entry.getValue()[3];
			Iterator<QuestionBank> iterator3=questionBanks.iterator();
			while (iterator3.hasNext()) {
				QuestionBank questionBank = (QuestionBank) iterator3.next();
				System.out.println(questionBank.getType()+":"+questionBank.getContent());
			}
		}
	}
 
 @Test
 public void findFinishedTestPaper(){
	 init();
	 List<TestPaper> testPapers=testPaperService.findFinishedTestPaper();
	 Iterator<TestPaper> iterator=testPapers.iterator();
	 while (iterator.hasNext()) {
		TestPaper testPaper = (TestPaper) iterator.next();
		System.out.println(testPaper.getExam_date()+"*******"+testPaper.getTestPaperName());
	}
 }
 
 @Test
 public void findPaperByCon(){
	 init();
	 String paperName="安规考试";
	 String examName="安规考试";
	 String examDate="";
	 List<TestPaper> papers=testPaperService.findPaperByCon(paperName, examName, examDate);
	 Iterator<TestPaper> iterator=papers.iterator();
	 while (iterator.hasNext()) {
		TestPaper testPaper = (TestPaper) iterator.next();
		System.out.println(testPaper.getTestPaperName()+"*****"+testPaper.getExam_date());
	}
 }
 
}
