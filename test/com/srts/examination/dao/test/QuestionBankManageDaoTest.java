package com.srts.examination.dao.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.dao.QuestionBankManageDao;
import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.BookChapter;

public class QuestionBankManageDaoTest {
	private ApplicationContext act;
	private QuestionBankManageDao dao;
	private Workbook workbook;
	private Sheet sheet;
	private Cell[] options;
	
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (QuestionBankManageDao) act.getBean("questionBankManageDaoImpl");
		
	}
	
	public void initExcel(){
		try {
			workbook = Workbook.getWorkbook(new File("C:\\Users\\BXY\\Desktop\\QuestionBankUpload.xls"));
			sheet = workbook.getSheet(0);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void jexcelTest(){
		init();
		initExcel();
		int rowCount = sheet.getRows();
		int columnCount = 0;
		for(int i = 1;i<rowCount;i++){
			options = sheet.getRow(i);
			columnCount = options.length;
			for(int j=0;j<columnCount;j++){
				System.out.print(options[j].getContents()+"|");
			}
			System.out.println();
		}
	}
	
	@Test 
	public void saveQuestionTest(){
		QuestionBank question = new QuestionBank();
		dao.save(question);
		
	}
	
	@Test
	public void test3(){
		init();
		BookChapter a = dao.getBookChapterId("no1","总则");
		System.out.println(a);
	}
	
	 @Test
	 public void getQuestion(){
		init();
		String a="1,3,4,5";
	List<?> questionBanks=dao.getByQuesIds(a, 1);
	if (questionBanks==null) {
		System.out.println("|meichachulai");
	}else{
	Iterator<?> iterator=questionBanks.iterator();
	while (iterator.hasNext()) {
		Object[] objects=(Object[]) iterator.next();
		System.out.println(objects[1]+"***"+objects[2]);
	}
	 }}
}
