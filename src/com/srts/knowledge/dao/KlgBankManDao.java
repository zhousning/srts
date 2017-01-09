package com.srts.knowledge.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.knowledge.domain.Experience;
import com.srts.knowledge.domain.RuleLearning;
import com.srts.knowledge.domain.TypicalCase;
import com.srts.knowledge.domain.TypicalViolation;

public interface KlgBankManDao extends BaseDao<Experience> {

	List<Experience> findTopFiveExperiences();
	List<TypicalCase> findTopFiveTypicalCases();
	List<TypicalViolation> findTopFiveTypicalViolations();
	List<Object[]> findAllByType(String klgType);
	void deleteKlg(String klgType, long klgId);
	List<Object[]> findContentById(long klgId, String klgType);
	void updateKlg(long klgId, String klgType, String updateTime, String title, String content, String type);
	void upLoadKlg(String klg,String title, String dates, String content, long userId);
	void upLoadTypeCase(String klg, String title, String content, String path, String dates);

}
