package com.srts.communication.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.communication.domain.ProblemInfo;
import com.srts.communication.po.CommonUser;
import com.srts.communication.po.SelfProblemInfo;
import com.srts.system.domain.Sys_User;

public interface ProblemCommDao extends BaseDao<ProblemInfo> {

	SelfProblemInfo findAllMyProblemInfos(Sys_User sysUser, int curPageNum);

	SelfProblemInfo findAllProblemInfos(int curPageNum);

	ProblemInfo findProblemInfoById(Long problemId);

	void updateProblemInfoViewCount(int i,Long id);
	
	public List<CommonUser> getProblemCountTop5();

	List<CommonUser> getAnswerCountTop5();

	List<CommonUser> getAcceptCountTop5();
	
	
	
	public List queryForPage(String hql, int offset,int length);
	public int getAllRowCount(String hql);
	
}
