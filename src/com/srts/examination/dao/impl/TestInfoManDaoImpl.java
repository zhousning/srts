package com.srts.examination.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.examination.dao.TestInfoManDao;
import com.srts.examination.domain.TestInfo;

@Repository
@Transactional
public class TestInfoManDaoImpl extends BaseDaoImpl<TestInfo> implements TestInfoManDao {

	public List<TestInfo> getExamPlan() {

		return null;
	}

	public void addTestInfo(TestInfo testInfo) {
		// TODO Auto-generated method stub
		this.getSession().save(testInfo);
	}

	public List<TestInfo> getTestInfosByState(String state) {
		// TODO Auto-generated method stub
		return this.getSession().createQuery("from TestInfo where state=:state").setString("state", state).list();
	}
	public TestInfo getTestInfoById(long id){
		return (TestInfo) this.getSession().get(TestInfo.class, id);
	}
	public void updateTestInfo(TestInfo testInfo) {
		// TODO Auto-generated method stub
		this.getSession().update(testInfo);
	}

	public List<TestInfo> findAllTestByTime() {
		List<TestInfo> testInfos=null;
		Criteria criteria=getSession().createCriteria(TestInfo.class);
		criteria.addOrder(Order.desc("testDate"));
		testInfos=criteria.list();
		return testInfos;
	}

}
