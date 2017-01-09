package com.srts.learning.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.examination.domain.QuestionBank;
import com.srts.learning.domain.ErrorSet;
import com.srts.system.domain.Sys_User;

public interface ErrorSetDao extends BaseDao<ErrorSet> {
	public List<ErrorSet> findTopFlagFiveErrorSetById(Sys_User usr);
	public List<ErrorSet> findAllErrorSetById(Sys_User usr);
	public List<ErrorSet> findByErrorSetFlagUsrId(Sys_User usr,int flag);
	public List<ErrorSet> findByErrorSetTypeUsrId(Sys_User usr,String type);
	public List<ErrorSet> findByTestTimeUsrId(Sys_User usr,String TestTime);
	public List<ErrorSet> findByLastTestTimeUsrId(Sys_User usr,String lastTestTime);
	public String findAnswerByQuestionId(long id);
	public String findQuestionTypeByQuestionId(long id);
	public long findErrorSetIdByQuestionIdAndUsrId(Sys_User usr,long questionId);
	public int countAllErrorSetByUsrId(Sys_User usr);
	public int countByErrorSetFlagUsrId(int flag,Sys_User usr);
	public int countByErrorSetTypeUsrId(String type,Sys_User usr);
	public int countByTestTimeUsrId(Sys_User usr,String TestTime);
	public int sumErrorSetFlagByUsrId(Sys_User usr);
	public int updateFiById(Sys_User usr,long id);
	public int updateLastTestTimeById(Sys_User usr,long id,String newLastTestTime);
	public int updateFdById(Sys_User usr,long id);
	public int insertErrorSet(Sys_User usr,int flag,String lastTestTime,QuestionBank question);
	public int deleteById(Sys_User usr,long id);
	public int findFlagByErrorSetId(long errorSetId);
	public int deleteByQuestionId(long QuestionId);
}
