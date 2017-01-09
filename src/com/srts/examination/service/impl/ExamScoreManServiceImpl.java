package com.srts.examination.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.examination.dao.ExamScoreManDao;
import com.srts.examination.domain.UserTestScore;
import com.srts.examination.service.ExamScoreManService;

@Service
public class ExamScoreManServiceImpl implements ExamScoreManService {
	
	@Resource
	private ExamScoreManDao examScoreManDao;

	public List<UserTestScore> findScoresByTestPaperId(long testPaperId) {
		List<UserTestScore> userTestScores=null;
		userTestScores=(List<UserTestScore>) examScoreManDao.getByTestPaperId(testPaperId);
		return userTestScores;
	}

	public List<UserTestScore> findScoresByCon(String examDate,
			String userName, String depName, String con,long testPaperId) {
		List<UserTestScore> list=null;
		String sql="from UserTestScore u where ";
	if (examDate!=null&&!(examDate.equals(""))) {
		examDate=examDate.trim();
		sql+=" u.testPaper.exam_date= "+"'"+examDate+"'"+" and ";
	}
	if (userName!=null&&!(userName.equals(""))) {
		userName=userName.trim();
		sql+=" u.usr.name= "+"'"+userName+"'"+" and ";
	}
	if (depName!=null&&!(depName.equals(""))) {
		depName=depName.trim();
		sql+="u.usr.department.name="+"'"+depName+"'"+" and ";
	}
	if (con!=null&&!(con.equals(""))) {
		con=con.trim();
		sql+="u.grade"+con+" and ";
	}
	sql+="u.testPaper.id="+testPaperId;
	list=examScoreManDao.findScoreByCon(sql);
		return list;
	}

}
