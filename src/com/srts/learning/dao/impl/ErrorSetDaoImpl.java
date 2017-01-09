package com.srts.learning.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.examination.domain.QuestionBank;
import com.srts.learning.dao.ErrorSetDao;
import com.srts.learning.domain.ErrorSet;
import com.srts.system.domain.Sys_User;

@Repository
@Transactional
public class ErrorSetDaoImpl extends BaseDaoImpl<ErrorSet> implements ErrorSetDao {

	@SuppressWarnings("unchecked")
	public List<ErrorSet> findAllErrorSetById(Sys_User usr) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return (List<ErrorSet>) getSession()
		.createSQLQuery(
				"select * from lrn_errorSet,exm_questionBank where lrn_errorSet.questionId=exm_questionBank.id and lrn_errorSet.usrId=:UsrId").setLong("UsrId", UsrId).list();
	}

	@SuppressWarnings("unchecked")
	public List<ErrorSet> findByErrorSetFlagUsrId(Sys_User usr, int flag) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		List<ErrorSet> list=new ArrayList<ErrorSet>();
		if(flag==0)
		{
			list = (List<ErrorSet>) getSession()
			.createSQLQuery(
					"select * from lrn_errorSet,exm_questionBank where lrn_errorSet.questionId=exm_questionBank.id and lrn_errorSet.flag=:flag and lrn_errorSet.usrId=:UsrId").setInteger("flag", flag).setLong("UsrId", UsrId).list();
		}
		else if(flag==1)
		{
			list = (List<ErrorSet>) getSession()
			.createSQLQuery(
					"select * from lrn_errorSet,exm_questionBank where lrn_errorSet.questionId=exm_questionBank.id and lrn_errorSet.flag=:flag and lrn_errorSet.usrId=:UsrId").setInteger("flag", flag).setLong("UsrId", UsrId).list();
		}
		else if(flag==2)
		{
			list = (List<ErrorSet>) getSession()
			.createSQLQuery(
					"select * from lrn_errorSet,exm_questionBank where lrn_errorSet.questionId=exm_questionBank.id and lrn_errorSet.flag=:flag and lrn_errorSet.usrId=:UsrId").setInteger("flag", flag).setLong("UsrId", UsrId).list();
		}
		else if(flag==3){
			list = (List<ErrorSet>) getSession()
		.createSQLQuery(
				"select * from lrn_errorSet,exm_questionBank where lrn_errorSet.questionId=exm_questionBank.id and lrn_errorSet.flag>=:flag and lrn_errorSet.usrId=:UsrId").setInteger("flag", flag).setLong("UsrId", UsrId).list();
	    }
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ErrorSet> findByTestTimeUsrId(Sys_User usr, String TestTime) {
		// TODO Auto-generated method stub
		//String queryString = "from StudentInfo s where s.sname like'%"+sname+"%'";  
		long UsrId=usr.getId();
		return (List<ErrorSet>) getSession()
		.createSQLQuery(
				"select * from lrn_errorSet,exm_questionBank where lrn_errorSet.questionId=exm_questionBank.id and lrn_errorSet.usrId=:UsrId and lrn_errorSet.lastTestTime like'%"+TestTime+"%'").setLong("UsrId", UsrId).list();
	}

	@SuppressWarnings("unchecked")
	public List<ErrorSet> findByLastTestTimeUsrId(Sys_User usr,
			String lastTestTime) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return (List<ErrorSet>) getSession()
		.createSQLQuery(
				"select * from lrn_errorSet,exm_questionBank where lrn_errorSet.questionId=exm_questionBank.id and lrn_errorSet.lastTestTime=:lastTestTime and lrn_errorSet.usrId=:UsrId").setString("lastTestTime", lastTestTime).setLong("UsrId", UsrId).list();
	}

	public int countAllErrorSetByUsrId(Sys_User usr) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return Integer.parseInt(String.valueOf(getSession()
		.createSQLQuery(
				"select count(*) from lrn_errorSet where lrn_errorSet.usrId=:UsrId").setLong("UsrId", UsrId).list().get(0)));
	}

	public int countByErrorSetFlagUsrId(int flag, Sys_User usr) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return Integer.parseInt(String.valueOf(getSession()
		.createSQLQuery(
				"select count(*) from lrn_errorSet where lrn_errorSet.flag=:flag and lrn_errorSet.usrId=:UsrId").setInteger("flag",flag).setLong("UsrId", UsrId).list().get(0)));
	}

	public int countByErrorSetTypeUsrId(String type, Sys_User usr) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return Integer.parseInt(String.valueOf(getSession()
		.createSQLQuery(
				"select count(*) from lrn_errorSet,exm_questionBank where lrn_errorSet.questionId=exm_questionBank.id and exm_questionBank.type=:type and lrn_errorSet.usrId=:UsrId").setString("type",type).setLong("UsrId", UsrId).list().get(0)));
	}

	public int countByTestTimeUsrId(Sys_User usr, String TestTime) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return Integer.parseInt(String.valueOf(getSession()
				.createSQLQuery(
						"select count(*) from lrn_errorSet where lrn_errorSet.usrId=:UsrId and lrn_errorSet.lastTestTime like'%"+TestTime+"%'").setLong("UsrId", UsrId).list().get(0)));
		/*return (Integer) getSession().createSQLQuery(
				"select count(*) from lrn_errorSet where lrn_errorSet.usrId=:UsrId and lrn_errorSet.lastTestTime like'%"+TestTime+"%'").setLong("UsrId", UsrId).uniqueResult();*/
	}
	
	public int sumErrorSetFlagByUsrId(Sys_User usr) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return Integer.parseInt(String.valueOf(getSession()
		.createSQLQuery(
				"select sum(flag) from lrn_errorSet where lrn_errorSet.usrId=:UsrId").setLong("UsrId", UsrId).list().get(0)));
	}

	public int updateFdById(Sys_User usr,long id) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return getSession().createSQLQuery(
				"update lrn_errorSet set lrn_errorSet.flag=lrn_errorSet.flag-1 where lrn_errorSet.usrId=:UsrId and lrn_errorSet.id=:id").setLong("id", id).setLong("UsrId", UsrId).executeUpdate();
	}

	public int updateFiById(Sys_User usr,long id) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return getSession().createSQLQuery(
				"update lrn_errorSet set lrn_errorSet.flag=lrn_errorSet.flag+2 where lrn_errorSet.usrId=:UsrId and lrn_errorSet.id=:id").setLong("id", id).setLong("UsrId", UsrId).executeUpdate();
	}

	public int insertErrorSet(Sys_User usr, int flag, String lastTestTime,
			QuestionBank question) {
		// TODO Auto-generated method stub
		int insertRes=1;
		long UsrId=usr.getId();
		long QuestionId=question.getId();
		String search="select * from lrn_errorSet where lrn_errorSet.usrId=:UsrId and lrn_errorSet.questionId=:QuestionId";
		List list = getSession()
		.createSQLQuery(search).setLong("UsrId", UsrId).setLong("QuestionId",QuestionId).list();
		if(list.isEmpty()==false)
		{
			insertRes=getSession().createSQLQuery(
			"update lrn_errorSet set lrn_errorSet.flag=lrn_errorSet.flag+2 where lrn_errorSet.usrId=:UsrId and lrn_errorSet.questionId=:QuestionId").setLong("QuestionId",QuestionId).setLong("UsrId", UsrId).executeUpdate();
		}
		else{
		String sql="insert into lrn_errorSet(flag,lastTestTime,usrId,questionId) values(?,?,?,?)";
		SQLQuery query= getSession().createSQLQuery(sql);
		query.setInteger(0,flag);
		query.setString(1, lastTestTime);
		query.setLong(2, UsrId);
		query.setLong(3, QuestionId);
		insertRes=query.executeUpdate();
		}
		return insertRes;
	}

	public int deleteById(Sys_User usr,long id) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return getSession().createSQLQuery(
				"delete from lrn_errorSet where lrn_errorSet.usrId=:UsrId and lrn_errorSet.id=:id").setLong("id", id).setLong("UsrId", UsrId).executeUpdate();
	}

	public List<ErrorSet> findByErrorSetTypeUsrId(Sys_User usr, String type) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return (List<ErrorSet>) getSession()
		.createSQLQuery("select * from lrn_errorSet,exm_questionBank where lrn_errorSet.questionId=exm_questionBank.id and exm_questionBank.type=:type and lrn_errorSet.usrId=:UsrId").setString("type",type).setLong("UsrId", UsrId).list();
	}

	public int updateLastTestTimeById(Sys_User usr, long id,
			String newLastTestTime) {
		long UsrId=usr.getId();
		return getSession().createSQLQuery(
				"update lrn_errorSet set lrn_errorSet.lastTestTime='"+newLastTestTime+"' where lrn_errorSet.usrId=:UsrId and lrn_errorSet.id=:id").setLong("id", id).setLong("UsrId", UsrId).executeUpdate();
	}

	public String findAnswerByQuestionId(long id) {
		// TODO Auto-generated method stub
		return (String) getSession()
		.createSQLQuery(
				"select answer from exm_questionBank where exm_questionBank.id=:id").setLong("id",id).uniqueResult();
	}

	public String findQuestionTypeByQuestionId(long id) {
		// TODO Auto-generated method stub
		return (String) getSession()
		.createSQLQuery(
				"select type from exm_questionBank where exm_questionBank.id=:id").setLong("id",id).uniqueResult();
	}

	public long findErrorSetIdByQuestionIdAndUsrId(Sys_User usr, long questionId) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		return Integer.parseInt(String.valueOf(getSession()
		.createSQLQuery(
				"select id from lrn_errorSet where lrn_errorSet.questionId=:questionId and lrn_errorSet.usrId=:UsrId").setLong("UsrId", UsrId).setLong("questionId",questionId).uniqueResult()));
	}

	public int findFlagByErrorSetId(long errorSetId) {
		// TODO Auto-generated method stub
		return Integer.parseInt(String.valueOf(getSession()
				.createSQLQuery(
						"select flag from lrn_errorSet where lrn_errorSet.id=:errorSetId").setLong("errorSetId", errorSetId).uniqueResult()));
	}

	public List<ErrorSet> findTopFlagFiveErrorSetById(Sys_User usr) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		String SQL="select top 5 * "+
		"from lrn_errorSet,exm_questionBank "+
		"where lrn_errorSet.questionId=exm_questionBank.id and lrn_errorSet.usrId=:UsrId"+
		" order by flag desc";
		return (List<ErrorSet>) getSession()
		.createSQLQuery(SQL).setLong("UsrId", UsrId).list();
	}

	public int deleteByQuestionId(long QuestionId) {
		// TODO Auto-generated method stub
		String SQL="delete from lrn_errorSet where lrn_errorSet.questionId=:QuestionId";
		return getSession().createSQLQuery(SQL).setLong("QuestionId", QuestionId).executeUpdate();
	}

}
