package com.srts.examination.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.examination.dao.TestPaperDao;
import com.srts.examination.domain.QuestionScoreList;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.po.QuestionBankPo;
@Repository
@Transactional
public class TestPaperDaoImpl extends BaseDaoImpl<TestPaper> implements TestPaperDao {

	public List<QuestionBankPo> getPaperQuestion(long testInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据考试Id随机获取试卷
	 */
	public TestPaper geTestPaperByTestInfoID(long testInfoId) {
		TestPaper testPaper=null;
		Criteria criteria=getSession().createCriteria(TestPaper.class);
		criteria.add(Restrictions.eq("testInfo.id", testInfoId));
		testPaper=(TestPaper) criteria.uniqueResult();
		return testPaper;
	}

	public List<String> getType(String questionIds) {
		String sql="SELECT type FROM exm_questionBank WHERE id in ("+questionIds+") GROUP BY type";
		return this.getSession().createSQLQuery(sql).list();
	}

	//按考试日期排序查询试卷
	public List<TestPaper> findByExamDate() {
		List<TestPaper> testPapers=null;
		Criteria criteria=getSession().createCriteria(TestPaper.class);
		criteria.addOrder(Order.desc("exam_date"));
		testPapers=criteria.list();
		return testPapers;
	}

	//按条件去查询试卷
	public List<TestPaper> findPaperByCon(String paperName, String examName,
			String examDate) {
		String con="from TestPaper t  where ";
		List<TestPaper> testPapers=null;
		if (paperName!=null&&!(paperName.equals(""))) {
			paperName=paperName.trim();
			con+=" t.testPaperName="+"'"+paperName+"'"+" and ";
		}
		if (examName!=null&&!(examName.equals(""))) {
			examName=examName.trim();
			con+=" t.testInfo.testName="+"'"+examName+"'"+" and ";
		}
		if (examDate!=null&&!(examDate.equals(""))) {
			examDate=examDate.trim();
			con+=" t.exam_date="+"'"+examDate+"'"+" and ";
		}
		con+=" 1=1 ";
		System.out.println(con);
		Query query=getSession().createQuery(con);
		testPapers=query.list();
		return testPapers;
	}
	
	public void saveTestPaper(TestPaper testPaper) {
		// TODO Auto-generated method stub
		this.getSession().save(testPaper);
	}

	public List<TestPaper> findAllTestPapers() {
		// TODO Auto-generated method stub
		return this.getSession().createQuery("from TestPaper order by id desc").list();
	}

	public void deleteTestPaper(TestPaper testPaper) {
		// TODO Auto-generated method stub
		this.getSession().delete(testPaper);
	}

	public TestPaper findTestPaperById(long id) {
		// TODO Auto-generated method stub
		return (TestPaper) this.getSession().get(TestPaper.class, id);
	}

	public void addQuestionScore(QuestionScoreList questionScore) {
		// TODO Auto-generated method stub
		this.getSession().save(questionScore);
	}
}
