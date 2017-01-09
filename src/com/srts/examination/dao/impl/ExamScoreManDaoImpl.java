package com.srts.examination.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.examination.dao.ExamScoreManDao;
import com.srts.examination.domain.UserTestScore;

@Repository
@Transactional
public class ExamScoreManDaoImpl extends BaseDaoImpl<UserTestScore> implements ExamScoreManDao  {

	public List<UserTestScore> getByTestPaperId(long testPaperId) {
		List<UserTestScore> scores=null;
		Criteria criteria=getSession().createCriteria(UserTestScore.class);
		criteria.add(Restrictions.eq("testPaper.id", testPaperId));
		scores=criteria.list();
		return scores;
	}

	public List<UserTestScore> findScoreByCon(String sql) {
		List<UserTestScore> testScores=null;
		Query query=getSession().createQuery(sql);
		testScores=query.list();
		return testScores;
	}

}
