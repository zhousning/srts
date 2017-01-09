package com.srts.estimate.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.estimation.po.CompanyEstimateInfoPo;
import com.srts.estimation.po.CompanyTestInfoPo;
import com.srts.estimation.po.InfoPo;
import com.srts.estimation.service.CompanyEstimateService;

public class CompanyEstimateServiceTest {
	private ApplicationContext act;
	private CompanyEstimateService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (CompanyEstimateService) act.getBean("companyEstimateServiceImpl");
	}
	@Test
	public void findAllTestInfoByAllConditionsTest()
	{
		init();
		List<CompanyTestInfoPo> res=service.findAllTestInfoByAllConditions(0, 0, "", "", 0);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getDept());
			System.out.println(res.get(i).getScore());
			System.out.println(res.get(i).getTestDate());
			System.out.println(res.get(i).getTestName());
			System.out.println(res.get(i).getWorkerName());
			System.out.println(res.get(i).getWorkno());
		}
	}
	@Test
	public void categoryTestScoreByTestCompanyAndDeptTest()
	{
		init();
		String res=service.categoryTestScoreByTestCompanyAndDept(0, 0, 1);
		System.out.println(res);
	}
	@Test
	public void selectAveScoreByCompanyAndDeptTest()
	{
		init();
		String res=service.selectAveScoreByCompanyAndDept(1, 2);
		System.out.println(res);
	}
	@Test
	public void selectAveScoreByTestNameTest()
	{
		init();
		String res=service.selectAveScoreByTestName(0, 0);
		System.out.println(res);
	}
	@Test
	public void setEstimateInfoTest()
	{
		init();
		CompanyEstimateInfoPo res=service.setEstimateInfo(1,0,"","",1);
		System.out.println(res.getId());
		System.out.println(res.getType());
		System.out.println(res.getEstString());
	}
	@Test
	public void findChildDeptByCompanyIdTest()
	{
		init();
		List<InfoPo> res=service.findChildDeptByCompanyId(1);
		for(int i=0;i<res.size();i++)
		{
	    System.out.println(res.get(i).getId());
	    System.out.println(res.get(i).getName());
		}
	}
	@Test
	public void findTestInfoByStartDateAndEndDateTest()
	{
		init();
		List<InfoPo> res=service.findTestInfoByStartDateAndEndDate("", "");
		for(int i=0;i<res.size();i++)
		{
	    System.out.println(res.get(i).getId());
	    System.out.println(res.get(i).getName());
		}
	}

}
