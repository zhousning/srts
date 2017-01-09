package com.srts.knowledge.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.knowledge.dao.KlgBankDispDao;
@Repository
@Transactional
public class KlgBankDispDaoImpl implements KlgBankDispDao {
	@Resource
	private SessionFactory sessionFactory;

	public int insertCaseSearchRecord(long content_id,
			String searchdate, long usrId) {
		String SQL="insert into klg_caseSearchRecord(content_id,searchdate,usrId) values(?,?,?)";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(SQL);
		query.setLong(0, content_id);
		query.setString(1, searchdate);
		query.setLong(2, usrId);
		int insertRes=query.executeUpdate();
		return insertRes;
	}

	public int insertExperienceSearchRecord(long content_id,
			String searchdate, long usrId) {
		String SQL="insert into klg_experienceSearchRecord(content_id,searchdate,usrId) values(?,?,?)";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(SQL);
		query.setLong(0, content_id);
		query.setString(1, searchdate);
		query.setLong(2, usrId);
		int insertRes=query.executeUpdate();
		return insertRes;
	}

	public int insertRuleLearningSearchRecord(long content_id,
			String searchdate, long usrId) {
		String SQL="insert into klg_ruleLearningSearchRecord(content_id,searchdate,usrId) values(?,?,?)";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(SQL);
		query.setLong(0, content_id);
		query.setString(1, searchdate);
		query.setLong(2, usrId);
		int insertRes=query.executeUpdate();
		return insertRes;
	}

	public int insertViolationSearchRecord(long content_id,
			String searchdate, long usrId) {
		String SQL="insert into klg_violationSearchRecord(content_id,searchdate,usrId) values(?,?,?)";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(SQL);
		query.setLong(0, content_id);
		query.setString(1, searchdate);
		query.setLong(2, usrId);
		int insertRes=query.executeUpdate();
		return insertRes;
	}

	public int updateCaseSearchnum(long id) {
		String SQL="update klg_typicalCase set searchnum=searchnum+1 where klg_typicalCase.id=:id";
		return sessionFactory.getCurrentSession().createSQLQuery(SQL).setLong("id", id).executeUpdate();
	}

	public int updateExperienceSearchnum(long id) {
		String SQL="update klg_experience set searchnum=searchnum+1 where klg_experience.id=:id";
		return sessionFactory.getCurrentSession().createSQLQuery(SQL).setLong("id", id).executeUpdate();
	}

	public int updateRuleLearningSearchnum(long id) {
		String SQL="update klg_ruleLearning set searchnum=searchnum+1 where klg_ruleLearning.id=:id";
		return sessionFactory.getCurrentSession().createSQLQuery(SQL).setLong("id", id).executeUpdate();
	}

	public int updateViolationSearchnum(long id) {
		String SQL="update klg_typicalViolation set searchnum=searchnum+1 where klg_typicalViolation.id=:id";
		return sessionFactory.getCurrentSession().createSQLQuery(SQL).setLong("id", id).executeUpdate();
	}

}
