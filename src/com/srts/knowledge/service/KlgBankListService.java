package com.srts.knowledge.service;

import java.util.List;

import com.srts.system.domain.Sys_User;

public interface KlgBankListService {
	public List<String[]> findFavorRuleByUser(Sys_User user);
	public List<String[]> findPopKlgBank();
    public List<String[]> searchKlgBankByTypeAndKeyWords(String type, String keyWords);
    public int insertIntoExperience(String content, String explaination, Sys_User user);
    public String findSearchnumByMonth();
    public List<String[]> listTopFiveRule();
    public List<String[]> listTopFiveViolation();
    public List<String[]> listTopOneCase();
    public List<String[]> listTopOneOperateSheet();
    public List<String[]> listTopOneWorkSheet();
    public List<String[]> listTopThreeExperience();
    public List<String[]> showAllInfo(String id,String type);
}