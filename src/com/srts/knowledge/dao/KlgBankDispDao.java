package com.srts.knowledge.dao;

import com.srts.system.domain.Sys_User;

public interface KlgBankDispDao {
	public int insertRuleLearningSearchRecord(long content_id, String searchdate, long usrId);
	public int insertViolationSearchRecord(long content_id, String searchdate, long usrId);
	public int insertCaseSearchRecord(long content_id, String searchdate, long usrId);
	public int insertExperienceSearchRecord(long content_id, String searchdate, long usrId);
	public int updateRuleLearningSearchnum(long id);
	public int updateViolationSearchnum(long id);
	public int updateCaseSearchnum(long id);
	public int updateExperienceSearchnum(long id);

}
