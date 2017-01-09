package com.srts.examination.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.examination.dao.CompetitionDao;
import com.srts.examination.domain.Competition;
import com.srts.examination.domain.QuestionBank;
import com.srts.system.domain.Sys_User;
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class CompetitionDaoImpl implements CompetitionDao {
	@Resource
	private SessionFactory sessionFactory;

	
	public List<Competition> findCompetitionGradeByUser(Sys_User usr) {
		long UsrId=usr.getId();
		String SQL="select * from exm_competition "+
		"where usrId=:UsrId";
		return (List<Competition>) sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setLong("UsrId", UsrId).list();
	}

	public List<Competition> findCompetitionRankRightNow(String CurrentTime) {
		String SQL="select top 10 MAX(grade) as maxgrade,usrId "+
		        "from exm_competition "+
				"where exm_competition.comp_date like'%"+CurrentTime+"%'"+
				"group by usrId "+
				"order by maxgrade desc";
		return (List<Competition>) sessionFactory.getCurrentSession()
		.createSQLQuery(SQL).list();
	}

	public List findHistoricalCompetitionRank() {
		// TODO Auto-generated method stub
		String SQL="select top 10 MAX(grade) as maxgrade,usrId "+
		"from exm_competition "+ 
		"group by usrId "+  
		"order by maxgrade desc";
        return (List) sessionFactory.getCurrentSession()
        .createSQLQuery(SQL).list();
	}

	public QuestionBank findQuestionById(long id) {
		// TODO Auto-generated method stub
		String HQL="from QuestionBank where id=:id";
		return (QuestionBank) sessionFactory.getCurrentSession().createQuery(HQL).setLong("id",id).uniqueResult();
	}
   /**/
	public int findCompetitionRankRightNowByUser(Sys_User usr,
			String CurrentTime) {
		// TODO Auto-generated method stub
		long usrId=usr.getId();;
		String SQL="select count(*) from exm_competition" +
		        " where exm_competition.comp_date like'%"+CurrentTime+"%'" +
				" and exm_competition.grade>(" +
				"select max(grade) from exm_competition" +
				" where exm_competition.comp_date like'%"+CurrentTime+"%'" +
				" and exm_competition.usrId=:usrId)";
		int rank=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
				.createSQLQuery(
						SQL).setLong("usrId",usrId).list().get(0)));
		rank+=1;
		return rank;
	}
	/**/
	public int findHistoricalCompetitionRankByUser(Sys_User usr) {
		// TODO Auto-generated method stub
		long usrId=usr.getId();;
		String SQL="select count(*) from exm_competition" +
		        " where exm_competition.grade>(" +
				"select max(grade) from exm_competition" +
				" where exm_competition.usrId=:usrId)";
		int rank=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
				.createSQLQuery(
						SQL).setLong("usrId",usrId).list().get(0)));
		rank+=1;
		return rank;
	}

	public List findRecentFiveCompetitionError(Sys_User usr) {
		// TODO Auto-generated method stub
		long usrId=usr.getId();
		String SQL="select top 5 * from exm_competitionError where exm_competitionError.usrId=:usrId " +
				"order by exm_competitionError.errorDate desc";
		return (List) sessionFactory.getCurrentSession()
        .createSQLQuery(SQL).setLong("usrId",usrId).list();
	}

	public int insertCompetitionError(String errorAnswer, String errorDate,
			Sys_User usr, QuestionBank errorQuestion) {
		// TODO Auto-generated method stub
		long usrId=usr.getId();
		long errorQuestionId=errorQuestion.getId();
		String sql="insert into exm_competitionError(errorAnswer,errorDate,usrId,errorQuestionId) values(?,?,?,?)";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setString(0,errorAnswer);
		query.setString(1, errorDate);
		query.setLong(2, usrId);
		query.setLong(3, errorQuestionId);
		int insertRes=query.executeUpdate();
		return insertRes;
	}

	public int insertCompetition(int grade, String comp_date, int comp_time,
			Sys_User usr) {
		// TODO Auto-generated method stub
			long usrId=usr.getId();
			String sql="insert into exm_competition(grade,comp_date,comp_time,usrId) values(?,?,?,?)";
			SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setInteger(0,grade);
			query.setString(1, comp_date);
			query.setInteger(2, comp_time);
			query.setLong(3, usrId);
			int insertRes=query.executeUpdate();
			return insertRes;
	}

	public int findCompetitionLastGradeByUser(Sys_User usr) {
		// TODO Auto-generated method stub
		int lastGrade=0;
		long UsrId=usr.getId();
		String SQL="select top 1 grade from exm_competition "+
		"where usrId=:UsrId order by comp_date desc,id desc";
		Object res=sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setLong("UsrId", UsrId).uniqueResult();
		if(res!=null)
		{
		    lastGrade=Integer.parseInt(res.toString());
		}
		else
		{
			lastGrade=0;
		}
		return lastGrade;
	}

	public int findCompetitionMaxGradeByUser(Sys_User usr) {
		// TODO Auto-generated method stub
		int userMaxGrade=0;
		long UsrId=usr.getId();
		String SQL="select MAX(grade) from exm_competition "+
		"where usrId=:UsrId ";
		Object res=sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setLong("UsrId", UsrId).uniqueResult();
		if(res!=null)
		{
			userMaxGrade=Integer.parseInt(res.toString());
		}
		else
		{
			userMaxGrade=0;
		}
		return userMaxGrade;
	}

	public int deleteCompetitionErrorByQuestionId(long questionId) {
		// TODO Auto-generated method stub
		String SQL="delete from exm_competitionError where exm_competitionError.errorQuestionId=:questionId";
		return sessionFactory.getCurrentSession().createSQLQuery(SQL).setLong("questionId",questionId).executeUpdate();
	}

}
