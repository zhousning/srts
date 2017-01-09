package com.srts.examination.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.examination.service.QuestionBankManageService;

public class QuestionBankManageServiceTest {
	private ApplicationContext act;
	private QuestionBankManageService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");	
	}
	@Test
	public void test1(){
		init();
		String excelPath = "D:\\questionbank.xls";
		String result = service.saveQuestionInfo(excelPath);
		System.out.println(result);
	}
	
	
	@Test
	public void findByIds(){
		init();
		String ids="86,271,214,31,18,85,";
		List<QuestionBank> questionBanks=service.findByIds(ids);
		for(QuestionBank q :questionBanks){
			System.out.println(q.getAnswer()+"^^^^^^^^^^");
		}
	}

		
}
