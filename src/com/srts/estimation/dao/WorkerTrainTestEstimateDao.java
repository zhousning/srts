package com.srts.estimation.dao;

import java.util.List;

import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPaper;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;

public interface WorkerTrainTestEstimateDao {
	public TestInfo findTestInfo(long id);
	public int findTestTakenNumByUser(Sys_User usr);
	public TestPaper findTestPaperById(long id);
	public TestPaper findTestPaperByTrainTypeMajor(Train train,String major,String type);
	public List findUserTestScoreByUserAndType(Sys_User usr,String type);
	public List<Integer> categoryUserTestScore(Sys_User usr ,String type);
	public int findUserTestScoreRankByUserAndType(Sys_User usr ,String type,long testPaperId);
	public List<Long> findTestPaperIdByUser(Sys_User usr,String type);
	public String findTestNameByTrainAndType(String type, long testPaperId);

}
