package com.srts.estimate.dao.test;

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

import com.srts.estimation.dao.WorkerKlgBankEstimateDao;
import com.srts.estimation.dao.WorkerOnlineExerciseEstDao;
import com.srts.estimation.dao.WorkerOnlineStudyEstDao;
import com.srts.examination.dao.QuestionBankManageDao;
import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.BookChapter;
import com.srts.system.domain.Sys_User;

public class workOnlineExerciseEstDaoTest {
	private ApplicationContext act;
	private WorkerKlgBankEstimateDao dao;
		
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (WorkerKlgBankEstimateDao) act.getBean("workerKlgBankEstimateDaoImpl");
		
	}
	
	@Test
	public void findWorkerKlgSearchRecordTest() {
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String startDate="2014-01-01";
		String endDate="2014-12-31";
		String type="条文导学";
		List<String[]> res= dao.findWorkerKlgSearchRecord(usr, startDate, endDate, type);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i)[0]);
			System.out.println(res.get(i)[1]);
			System.out.println(res.get(i)[2]);
			System.out.println(res.get(i)[3]);
			System.out.println(res.get(i)[4]);
		}
	}
	@Test
	public void workerKlgSearchEstTest() {
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String startDate="2014-01-01";
		String endDate="2014-12-31";
		String type="条文导学";
		List<String[]> res= dao.workerKlgSearchEst(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i)[0]);
			System.out.println(res.get(i)[1]);
		}
	}
	@Test
	public void workerKlgSearchEstToMonthTest() {
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String startDate="2014-01-01";
		String endDate="2014-12-31";
		String type="条文导学";
		List<String[]> res= dao.workerKlgSearchEstToMonth(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i)[0]);
			System.out.println(res.get(i)[1]);
		}
	}
	@Test
	public void workerKlgSearchEstToWeekTest() {
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String startDate="2014-01-01";
		String endDate="2014-12-31";
		String type="条文导学";
		List<String[]> res= dao.workerKlgSearchEstToWeek(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i)[0]);
			System.out.println(res.get(i)[1]);
		}
	}
	@Test
	public void workerKlgSearchEstTodayTest() {
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String startDate="2014-01-01";
		String endDate="2014-12-31";
		String type="条文导学";
		List<String[]> res= dao.workerKlgSearchEstToday(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i)[0]);
			System.out.println(res.get(i)[1]);
		}
	}
	@Test
	public void workerOpExpUploadToMonthTest() {
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String startDate="2014-01-01";
		String endDate="2014-12-31";
		String type="条文导学";
		List<String[]> res= dao.workerOpExpUploadToMonth(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i)[0]);
			System.out.println(res.get(i)[1]);
		}
	}
	@Test
	public void workerOpExpUploadToWeekTest() {
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String startDate="2014-01-01";
		String endDate="2014-12-31";
		String type="条文导学";
		List<String[]> res= dao.workerOpExpUploadToWeek(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i)[0]);
			System.out.println(res.get(i)[1]);
		}
	}
	@Test
	public void workerOpExpUploadTodayTest() {
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String startDate="2014-01-01";
		String endDate="2014-12-31";
		String type="条文导学";
		List<String[]> res= dao.workerOpExpUploadToday(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i)[0]);
			System.out.println(res.get(i)[1]);
		}
	}
}
