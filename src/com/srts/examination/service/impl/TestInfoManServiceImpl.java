package com.srts.examination.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.examination.dao.TestInfoManDao;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPeople;
import com.srts.examination.service.TestInfoManService;
import com.srts.examination.service.TestPeopleService;

@Service
public class TestInfoManServiceImpl implements TestInfoManService {
	@Resource
	private TestInfoManDao testInfoManDao;
	@Resource
	private TestPeopleService testPeopleService;

	public List<TestInfo> getExamPlan() {
		List<TestInfo> testInfos=null, testInfoList=null;

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(date);
		


		testInfos = new ArrayList<TestInfo>();
		testInfoList = testInfoManDao.findAll();

		Iterator<TestInfo> iterator = testInfoList.iterator();
		while (iterator.hasNext()) {
			TestInfo testInfo = (TestInfo) iterator.next();
			Date testDate=null;
			if (testInfo.getTestDate()!=null&&!(testInfo.getTestDate().equals(""))) {
				try {
				
					testDate = sdf.parse(testInfo.getTestDate());
					if (testDate.after(date)||testInfo.getTestDate().equals(currentDate)) {
					
						testInfos.add(testInfo);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		
		}

		return testInfos;
	}

	public TestInfo getUserNowExam(long userId) {
		List<TestPeople> testPeoples = null;
		TestInfo testInfo = null;
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String now = dateFormat.format(date);
		System.out.println(now+"^^^^^^^^^^");

		testPeoples = testPeopleService.getTestPeosByUserId(userId);

		if (testPeoples != null) {
			Iterator<TestPeople> iterator = testPeoples.iterator();
			while (iterator.hasNext()) {
				TestPeople testPeople = (TestPeople) iterator.next();
				System.out.println(testPeople.getUsr().getName()+"***********");
				System.out.println(testPeople.getTestInfo().getTestDate());
				if (testPeople.getTestInfo().getTestDate().equals(now)) {
					testInfo = testPeople.getTestInfo();
					System.out.println(testInfo.getTestDate()+"&&&&&&&&&&&");
				}
			}
		}
		return testInfo;
	}

	public void addTestInfo(TestInfo testInfo) {
		// TODO Auto-generated method stub
		testInfoManDao.addTestInfo(testInfo);
	}

	public TestInfo getTestInfoById(long id) {
		// TODO Auto-generated method stub
		return testInfoManDao.getTestInfoById(id);
	}

	public List<TestInfo> getTestInfosByState(String state) {
		// TODO Auto-generated method stub
		return testInfoManDao.getTestInfosByState(state);
	}

	public void updateTestInfo(TestInfo testInfo) {
		// TODO Auto-generated method stub
		testInfoManDao.updateTestInfo(testInfo);
	}

	public List<TestInfo> findAllTestByTime() {
		List<TestInfo> testInfos=null;
		testInfos=testInfoManDao.findAllTestByTime();
		return testInfos;
	}

}
