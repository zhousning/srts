package com.srts.examination.service;

import java.util.List;

import com.srts.examination.domain.UserTestScore;

public interface ExamScoreManService {

	List<UserTestScore> findScoresByTestPaperId(long testPaperId);

	List<UserTestScore> findScoresByCon(String examDate, String userName,
			String depName, String con, long testPaperId);

}
