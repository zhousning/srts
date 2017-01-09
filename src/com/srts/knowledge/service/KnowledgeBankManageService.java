package com.srts.knowledge.service;

import java.io.File;
import java.util.List;

import com.srts.knowledge.domain.Experience;
import com.srts.knowledge.domain.RuleLearning;
import com.srts.knowledge.domain.TypicalCase;
import com.srts.knowledge.domain.TypicalViolation;

public interface KnowledgeBankManageService {

	public List<Experience> findTopFiveExperiences();
	public List<TypicalCase> findTopFiveTypicalCases();
	public List<TypicalViolation> findTopFiveTypicalViolations();
	public List<Object[]> findAllByType(String klgType);
	public void deleteKle(String klgType, long klgId);
	public List<Object[]> findContenById(long klgId, String klgType);
	public void updateKlg(long klgId, String klgType, String updateTime, String title, String content, String type);
	public Experience findExpById(long klgId);
	public void upDateExp(Experience experience);
	public void upLoadKlg(String klg,String title, String dates, String content, long userId);
	public String upLoadTpc(String klg, List<File> caseImg,
			List<String> caseImgFileName, long userId);
	public void upLoadTypeCase(String klg, String title, String content,
			String path, String dates);
}
