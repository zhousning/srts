package com.srts.estimate.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.srts.estimation.dao.CompanyEstimateDao;
import com.srts.examination.domain.TestInfo;

public class companyEstiamteDaoTest {
	private ApplicationContext act;
	private CompanyEstimateDao dao;
		
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (CompanyEstimateDao) act.getBean("companyEstimateDaoImpl");
		
	}
	@Test
	public void findAllTestInfoByAllConditionsTest()
	{
		init();
		List<String[]> resList=dao.findAllTestInfoByAllConditions(0, 0, "", "", 1);
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void findAllTestInfoIdTest()
	{
		init();
		List<Long> resList=dao.findAllTestInfoId();
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i));
		}
	}
	@Test
	public void findTestListByStartDateAndEndDate()
	{
		init();
		List<TestInfo> resList=dao.findTestListByStartDateAndEndDate("", "");
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i).getId());
			System.out.println(resList.get(i).getTestName());
		}
	}

}
