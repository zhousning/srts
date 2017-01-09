package com.srts.examination.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.examination.domain.TestPeople;

public interface TestPeopleDao extends BaseDao<TestPeople> {

	List<?> getStatistics(long userId);

	void createNameList(long userId, long testInfoId);

	List<TestPeople> getTestPeosByUserId(long userId);

	List<TestPeople> findByTestInfoId(long testInfoId);

}
