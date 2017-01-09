package com.srts.examination.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.examination.dao.TestInfoManDao;
import com.srts.examination.dao.TestPeopleDao;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPeople;
import com.srts.system.dao.Sys_UserDao;
import com.srts.system.domain.Sys_User;

@Repository
@Transactional
public class TestPeopleDaoImpl extends BaseDaoImpl<TestPeople> implements
		TestPeopleDao {
	@Resource
	private Sys_UserDao sysUserDao;
	@Resource
	private TestInfoManDao testInfoManDao;

	public List<?> getStatistics(long userId) {
		String sqlString = "SELECT * FROM (SELECT usrId,COUNT(*) AS cou FROM exm_userTestScore WHERE usrId="
				+ userId
				+ " GROUP BY usrId) a,(SELECT usrId,COUNT(*) AS fail FROM exm_userTestScore WHERE usrId="
				+ userId
				+ " AND  grade<90 GROUP BY usrId)b  WHERE a.usrId=b.usrId";
		return this.getSession().createSQLQuery(sqlString).list();
	}

	//插入名单
	public void createNameList(long userId, long testInfoId) {
		Sys_User sysUser=sysUserDao.getById(userId);
		TestInfo testInfo=testInfoManDao.getById(testInfoId);
		TestPeople people=new TestPeople();
		people.setUsr(sysUser);
		people.setTestInfo(testInfo);
		save(people);
	}

	//获取员工被抽到的数据
	public List<TestPeople> getTestPeosByUserId(long userId) {
		List<TestPeople> testPeoples=null;
		Criteria criteria=getSession().createCriteria(TestPeople.class);
		criteria.add(Restrictions.eq("usr.id", userId));
		testPeoples=criteria.list();
		return testPeoples;
	}

	public List<TestPeople> findByTestInfoId(long testInfoId) {
		List<TestPeople> testPeoples=null;
		Criteria criteria=getSession().createCriteria(TestPeople.class);
		criteria.add(Restrictions.eq("testInfo.id",testInfoId));
		testPeoples=criteria.list();
		return testPeoples;
	}
	
	//

}
