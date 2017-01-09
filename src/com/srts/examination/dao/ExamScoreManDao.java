package com.srts.examination.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.examination.domain.UserTestScore;

public interface ExamScoreManDao extends BaseDao<UserTestScore> {

	List<UserTestScore> getByTestPaperId(long testPaperId);

	List<UserTestScore> findScoreByCon(String sql);

}
