package com.srts.communication.service;

import java.util.List;

import com.srts.communication.domain.AnswerAsk;
import com.srts.communication.domain.AnswerInfo;
import com.srts.communication.domain.ProblemAnswerAccept;
import com.srts.communication.domain.ProblemInfo;
import com.srts.communication.po.AllAnswerInfo;
import com.srts.communication.po.CommonUser;
import com.srts.communication.po.SelfAnswerInfo;
import com.srts.communication.po.SelfProblemInfo;
import com.srts.system.domain.Sys_User;
import com.srts.utils.pageUtils.PageBean;

public interface ProblemCommService {
//关于类ProblemInfo的操作
	void save(ProblemInfo problemInfo);
	void deleteProblemInfo(long id);
	SelfProblemInfo findAllProblemInfos(int curPageNum);

	ProblemInfo findProblemInfoById(Long problemId);

	SelfProblemInfo findAllMyProblemInfos(Sys_User sysUser, int curPageNum);

	void updateProblemInfoViewCount(int i,Long id);
//关于类AnswerInfo的操作
	void addAnswerInfo(AnswerInfo answerInfo);
	void deleteAnswerInfo(long id);
	AnswerInfo findAnswerInfoById(Long answerId);

	void updateAnswerInfo(AnswerInfo answerInfo);

	SelfAnswerInfo findAllMyAnswerInfo(Sys_User sysUser, int curPageNum);
//关于AnswerAsk的操作
	List<AnswerAsk> findAnswerAskByAnswerInfoId(long id);
	AllAnswerInfo findAllAnswerInfo(int curPageNum);
	void saveAnswerAsk(AnswerAsk answerAsk);
//关于ProblemAnswerAccept的操作
	void saveProblemAnswerAccept(ProblemAnswerAccept accept);

	ProblemAnswerAccept findProblemAnswerAcceptByProblemId(Long problemId);
//3个排行
	List<CommonUser> getProblemCountTop5();

	List<CommonUser> getAnswerCountTop5();

	List<CommonUser> getAcceptCountTop5();
	

	
	
	public PageBean queryForPage(String hql, int pageSize,int currentPage);
	public int getAllRowCount(String hql);

	


}
