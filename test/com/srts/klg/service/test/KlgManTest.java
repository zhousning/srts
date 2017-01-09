package com.srts.klg.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.knowledge.domain.TypicalViolation;
import com.srts.knowledge.service.KnowledgeBankManageService;

public class KlgManTest {

	ApplicationContext act=null;
	KnowledgeBankManageService bankManageService=null;
	
	public void init(){
	 act=new ClassPathXmlApplicationContext("applicationContext.xml");
	 bankManageService=(KnowledgeBankManageService) act.getBean("knowledgeBankManageServiceImpl");
	}
	
	@Test
	public void uplodKlg() {
		init();
		bankManageService.upLoadTypeCase("klg_typicalCase", "22", "333333", "3333", "333");
	}


}
