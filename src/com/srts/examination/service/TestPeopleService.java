package com.srts.examination.service;

import java.util.List;

import com.srts.examination.domain.TestPeople;
import com.srts.examination.po.UserPo;
import com.srts.system.domain.Sys_User;

public interface TestPeopleService {


	String getDepAndWorkers(Long[] departmentIds, int counts);

	List<Sys_User> getWorkNums(Long[] depIds);

	List<Sys_User> createNameList(String nameList, long testInfoId);

	List<TestPeople> getTestPeosByUserId(long userId);

	List<Sys_User> getTestPeoples(long testInfoId);

}
