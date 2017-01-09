package com.srts.learning.service;

import java.util.List;

import com.srts.examination.domain.QuestionBank;
import com.srts.learning.domain.ErrorSet;
import com.srts.learning.domain.ErrorSetFlagSum;
import com.srts.learning.po.ErrorSetAnswerPo;
import com.srts.system.domain.Sys_User;

public interface ErrorSetService {
	public List<String[]> findByErrorSetFlagUsrId(Sys_User usr,int flag);
	public List<String[]> findByLastTestTimeUsrId(Sys_User usr,String lastTestTime);
	public List<String[]> findByErrorSetTypeUsrId(Sys_User usr,String type);
	public String judgeTheAnswer(Sys_User usr,ErrorSetAnswerPo errorSetAnswerPo);
	public String getCountByErrorSetFlagUsrId(Sys_User usr);//计算各类错题个数，返回list
	public String getFindErrorSetFlagSumById(Sys_User usr);
	public String getCountByErrorSetTypeUsrId(Sys_User usr);
	public List<String[]> findErrorSetSimpilfiedDisplayedById(Sys_User usr);
	public String insertIntoErrorSet(Sys_User usr,int flag,String lastTestTime,QuestionBank question);
}
