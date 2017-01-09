package com.srts.knowledge.dao;

import java.util.List;

import com.srts.system.domain.Sys_User;

public interface KlgBankListDao  {
	public List listTopFiveRule();
	public List listTopOneCase();
	public List listTopFiveViolation();
	public List listTopThreeExperience();
	public List listTopOneWorkSheet();
	public List listTopOneOperateSheet();
	public List searchKlgBankByTypeAndKeyWords(String type,String keyWords);
	public int insertIntoExperience(String content,String statement, String explaination, 
			String uploaddate, String updatedate, String checkeddate, Sys_User user);
	public List<Integer[]> findSearchnumByMonth();
	public List findFavorRuleByUser(Sys_User user);
	public List findPopKlgBank();
	public List findAllInfo(String id,String type);
}


